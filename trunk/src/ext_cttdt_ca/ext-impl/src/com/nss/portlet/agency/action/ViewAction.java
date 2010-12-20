package com.nss.portlet.agency.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.agency.AgencyCanNotDeleteException;
import com.nss.portlet.agency.AgencyCodeSameCodeException;
import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.model.PmlAgencyLeader;
import com.nss.portlet.agency.model.impl.PmlAgencyLeaderImpl;
import com.nss.portlet.agency.service.AgencyLocalServiceUtil;
import com.nss.portlet.agency.service.PmlAgencyLeaderLocalServiceUtil;
import com.nss.portlet.agency.util.UserDTO;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.service.PositionLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateAgency(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteAgency(req, res);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveAgency(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(req, "redirect");
				sendRedirect(req, res, redirect);
			}
		} catch (Exception e) {
			if (e instanceof AgencyCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof AgencyCodeSameCodeException) {
				req.setAttribute("agencyFlag", "fail");
				SessionErrors.add(req,e.getClass().getName());
				setForward(req, "portlet.nss.agency.add");
			}
			else {
				throw e;
			}
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);
			List<UserDTO> userDTOList = populateToDTO(userList);
			
			req.setAttribute("userDTOList", userDTOList);
			String cmd = ParamUtil.getString(req, Constants.CMD);
			
			if (!Validator.isNull(cmd)) {
				if (cmd.equals(Constants.EDIT)) {
					editAgency(req, res);
				}
			}
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.agency.view");
			}
	}

	private List<UserDTO> populateToDTO(List<User> userList) throws Exception {
		List<UserDTO> results = new ArrayList<UserDTO>();
		PmlUser pmlUser = null;
		String positionId = "";
		String positionName = "";
		for (User user : userList) {
			String userFullName = "";
			if (user != null) {
				userFullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			}
			
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(user.getUserId());
				positionId = pmlUser.getPositionId();
				if (!"".equals(positionId)) {
					Position position = PositionLocalServiceUtil.getPosition(positionId);
					positionName = position.getPositionName();
				}
			} catch (Exception e) {
				pmlUser = null;
			}
			
			UserDTO userDTO = new UserDTO();
			
			userDTO.setPmlUserId(user.getUserId());
			userDTO.setFullName(userFullName);
			userDTO.setPositionName(positionName);
			results.add(userDTO);
		}
		return results;
	}
	
	private void deleteAgency(ActionRequest req, ActionResponse res) throws Exception {

		String agencyId = ParamUtil.getString(req, "agencyId");
		AgencyLocalServiceUtil.removeAgency(agencyId);
	}
	
	private void editAgency(RenderRequest req, RenderResponse res) {

		String agencyId = ParamUtil.getString(req, "agencyId");
		long userAgencyId = ParamUtil.getLong(req, "userAgencyId");
		String userFullName = "";
		
		if (userAgencyId != 0) {
			User userAgency;
			try {
				userAgency = UserLocalServiceUtil.getUser(userAgencyId);
				userFullName = userAgency.getLastName().concat(" ").concat(userAgency.getMiddleName()).concat(" ").concat(userAgency.getFirstName());
			} catch (Exception e) {}
		}
		
		try {
			Agency agency = AgencyLocalServiceUtil.getAgency(agencyId);
			PmlAgencyLeader agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(agencyId);	   
			req.setAttribute("agency", agency);
			req.setAttribute("agencyLeader", agencyLeader);
			req.setAttribute("userFullName", userFullName);
			
		}
		catch (PortalException e) {
			_log.error(e.getMessage());
		}
		catch (SystemException e) {
			_log.error(e.getMessage());
		}
	}

	private Agency updateAgency(ActionRequest req, ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		
		String agencyId = ParamUtil.getString(uploadRequest, "agencyId");
		String agencyCode = ParamUtil.getString(uploadRequest, "agencyCode");
		String agencyName = ParamUtil.getString(uploadRequest, "agencyName");
		String description = ParamUtil.getString(uploadRequest, "description");
		boolean active = ParamUtil.getBoolean(uploadRequest, "active");		
		long userID = ParamUtil.getLong(uploadRequest, "userID");
		
		Agency agency = null;
		
		if (cmd.equals(Constants.ADD)) {
			if (active) {
				agency = AgencyLocalServiceUtil.addAgency(agencyCode, agencyName, description, "1");
			}
			else {
				agency = AgencyLocalServiceUtil.addAgency(agencyCode, agencyName, description, "0");
			}
			
			// luu vao bang agencyLeader
			PmlAgencyLeader pmlAgencyLeader = new PmlAgencyLeaderImpl();
			pmlAgencyLeader.setAgencyId(agency.getAgencyId());
			pmlAgencyLeader.setUserId(userID);
			
			try {
				PmlAgencyLeaderLocalServiceUtil.updatePmlAgencyLeader(pmlAgencyLeader);
			} catch (Exception e) { }
		}
		else if (cmd.equals(Constants.UPDATE)) {
			if (active) {
				agency = AgencyLocalServiceUtil.updateAgency(agencyId, agencyCode, agencyName, description, "1");
			}
			else {
				agency = AgencyLocalServiceUtil.updateAgency(agencyId, agencyCode, agencyName, description, "0");
			}
			
			// luu vao bang agencyLeader
			try {
				PmlAgencyLeader agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(agencyId);
				agencyLeader.setUserId(userID);
				PmlAgencyLeaderLocalServiceUtil.updatePmlAgencyLeader(agencyLeader);
			} catch (Exception e) { }
		}
	
		return agency;
				
	}

	private void updateActiveAgency(ActionRequest req, ActionResponse res) {

		String agencyId = ParamUtil.getString(req, "agencyId");
		
		try {
			Agency agency = AgencyLocalServiceUtil.getAgency(agencyId);
			
			if ("1".equals(agency.getActive())) {
				agency.setActive("0");
			}
			else {
				agency.setActive("1");
			}

			agency = AgencyLocalServiceUtil.updateAgency(agency);
		}
		catch (PortalException e) {
			_log.error(e.getMessage());
		}
		catch (SystemException e) {
			_log.error(e.getMessage());
		}

	}
}
