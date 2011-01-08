package com.sgs.portlet.agency.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.agency.AgencyCanNotDeleteException;
import com.sgs.portlet.agency.AgencyCodeSameCodeException;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.AgencyLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlAgencyLeader;
import com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderImpl;
import com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil;
import com.sgs.portlet.pmluser.DTO.PmlUserDTO;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.persistence.PositionUtil;

public class ViewAction extends PortletAction {
	// Yenlt update 26/01/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		//if (!Validator.isNull(cmd)) {
		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateAgency(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteAgency(req, res);
			}
//			else if (cmd.equals(Constants.UPDATE)) {
//				updateAgency(req, res);
//			}
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
				setForward(req, "portlet.sgs.agency.add");
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {
		
		List<PmlUser> pmlUserList = PmlUserUtil.findAll();
		List<PmlUserDTO> pmlUserDTOList = populateToDTO(pmlUserList);
		
		req.setAttribute("pmlUserDTOList", pmlUserDTOList);
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if (cmd.equals(Constants.EDIT)) {
				editAgency(req, res);
			}
		}
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		}
		else {
			
			return mapping.findForward("portlet.sgs.agency.view");
		}
	}

	private List<PmlUserDTO> populateToDTO(List<PmlUser> pmlUserList) throws Exception {
		List<PmlUserDTO> results = new ArrayList<PmlUserDTO>();
		for (PmlUser pmlUser : pmlUserList) {
			long pmlUserId = pmlUser.getUserId();
			
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(pmlUserId);
			} catch (Exception e) {}
			
			String pmlUserFullName = "";
			if (user != null) {
				pmlUserFullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			}
			
			String positionId = pmlUser.getPositionId();
			String positionName = "";

			if (!"".equals(positionId)) {
				Position position = PositionUtil.findByPrimaryKey(positionId);
				positionName = position.getPositionName();
			}
			
			PmlUserDTO userDTO = new PmlUserDTO();
			
			userDTO.setPmlUserId(pmlUserId);
			userDTO.setFullName(pmlUserFullName);
			userDTO.setPositionName(positionName);
			results.add(userDTO);
		}
		return results;
	}
	
	/*
	private void updateAgency(ActionRequest req, ActionResponse res) {

		String agencyId = ParamUtil.getString(req, "agencyId");
		String agencyCode = ParamUtil.getString(req, "agencyCode");
		String agencyName = ParamUtil.getString(req, "agencyName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");
		long userID = ParamUtil.getLong(req, "userID");

		try {
			Agency agency = AgencyLocalServiceUtil.getAgency(agencyId);
			PmlAgencyLeader agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(agencyId);
			agencyLeader.setUserId(userID);
			agency.setAgencyCode(agencyCode);
			agency.setAgencyName(agencyName);
			agency.setDescription(description);
			if (active) {
				agency.setActive("1");
			}
			else {
				agency.setActive("0");
			}
			PmlAgencyLeaderLocalServiceUtil.updatePmlAgencyLeader(agencyLeader);
			agency = AgencyLocalServiceUtil.updateAgency(agency);

		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}*/

	private void deleteAgency(ActionRequest req, ActionResponse res) throws Exception {

		String agencyId = ParamUtil.getString(req, "agencyId");
		AgencyLocalServiceUtil.removeAgency(agencyId);
		/* yenlt close 24082010
		List<Department> pmlDepartmentList = new ArrayList<Department>();
		try {
			pmlDepartmentList = DepartmentUtil.findByAgencyId(agencyId);
		} catch (Exception e) {
			
		}
		
		try {
			if (pmlDepartmentList.size() > 0 ) {
				req.setAttribute("delete", false);
			}
			else {
				Agency agency = AgencyLocalServiceUtil.getAgency(agencyId);
				AgencyLocalServiceUtil.deleteAgency(agency);
				PmlAgencyLeaderLocalServiceUtil.deletePmlAgencyLeader(agencyId);
				req.setAttribute("delete", true);
			}
			
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		*/
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
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

}
