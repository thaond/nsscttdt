package com.sgs.portlet.departmentleader.action;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.AgencyLocalServiceUtil;
import com.sgs.portlet.department.DepartmentCodeSameCodeException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalServiceUtil;

public class AddAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(AddAction.class);
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			
		try {
			String redirect = ParamUtil.getString(req, "redirect");
			addDepartment(req);	
			sendRedirect(req, res, redirect);
		} catch (Exception e) {
			if (e instanceof DepartmentCodeSameCodeException) {
				req.setAttribute("departmentFlag", "fail");
				
				List<Agency> agencyList = AgencyLocalServiceUtil.getAgencies(-1, -1);
				req.setAttribute("agencyList", agencyList);
				
				setForward(req, "portlet.sgs.departmentleader.add");
				
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	private void addDepartment(ActionRequest req) throws Exception {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String departmentParentId = ParamUtil.getString(uploadRequest, "departmentParentId");
		String departmentCode = ParamUtil.getString(uploadRequest, "departmentCode");
		String departmentName = ParamUtil.getString(uploadRequest, "departmentName");
		String abbreviateName = ParamUtil.getString(uploadRequest, "abbreviateName");
		String agencyId = ParamUtil.getString(uploadRequest, "departmentAgency");
		String[] pmlUserIdArr = req.getParameterValues("pmlUserId");
		boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		String description = ParamUtil.getString(uploadRequest, "description");
		
		Department department = null;
		
		if(active) {
			department = DepartmentLocalServiceUtil.addDepartment(departmentCode, departmentName, description, "1", agencyId, abbreviateName, departmentParentId);
		}
		else {
			department = DepartmentLocalServiceUtil.addDepartment(departmentCode, departmentName, description, "1", agencyId, abbreviateName, departmentParentId);
		}
		
		if (pmlUserIdArr != null) {
			for (int i = 0; i < pmlUserIdArr.length; i++) {
				long pmlUserId = Long.parseLong(pmlUserIdArr[i]);
				PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(pmlUserId);
				pmlUser.setDepartmentsId(department.getDepartmentsId());
				
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			}
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			List<Agency> agencyList = new ArrayList<Agency>();
			List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
			
			try {
				agencyList = AgencyLocalServiceUtil.getAgencies(-1, -1);
				
			} catch (Exception e) {
				_log.error("NO GET LIST AGENCY");
			}
			
			try {
				pmlUserList = PmlUserLocalServiceUtil.getPmlUsers(-1, -1);
				
			} catch (Exception e) {
				_log.error("NO GET LIST PMLUSER");
			}
			// yenlt update 24082010
//			List<PmlUserDTO> userList = populateUserToUserDTO(pmlUserList);
			List<PmlUserDTO> userList = populateUserToUserDTO();
				
			req.setAttribute("userList", userList);
			req.setAttribute("agencyList", agencyList);
			return mapping.findForward("portlet.sgs.departmentleader.add");
	}
	
	private List<PmlUserDTO> populateUserToUserDTO() {
		List<PmlUserDTO> listUserDTO = new ArrayList<PmlUserDTO>();
		List<PmlUser> users = new ArrayList<PmlUser>();
		try {
			users = PmlUserUtil.findByDepartmentsId_Active("", true);
		} catch (Exception e1) {
			users = new ArrayList<PmlUser>();
			_log.error(e1.getMessage());
		}
		for (int i = 0; i < users.size(); i++) {
			PmlUser pmlUser = users.get(i);
			long pmlUserId = pmlUser.getUserId();
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(pmlUserId);
			} catch (Exception e) {
			}
			
			if (user != null) {
				String userName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				String positionId = pmlUser.getPositionId();
				Position position = null;
				String positionName = "";
				try {
					position = PositionLocalServiceUtil.getPosition(positionId);
					positionName = position.getPositionName();			
				} catch (Exception e) {
					 positionName = "";
				}
			
				PmlUserDTO userDTO = new PmlUserDTO();
				userDTO.setId(pmlUserId);
				userDTO.setName(userName);
				userDTO.setPosition(positionName);
				listUserDTO.add(userDTO);
			}
		}
		return listUserDTO;
	}
	
	/*
	private List<PmlUserDTO> populateUserToUserDTO(List<PmlUser> users) {
		List<PmlUserDTO> listUserDTO = new ArrayList<PmlUserDTO>();
		for (int i = 0; i < users.size(); i++) {
			PmlUser pmlUser = users.get(i);
			long pmlUserId = pmlUser.getUserId();
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(pmlUserId);
			} catch (Exception e) {
			}
			
			if (user != null) {
				String userName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				String positionId = pmlUser.getPositionId();
				Position position = null;
				String positionName = "";
				try {
					position = PositionLocalServiceUtil.getPosition(positionId);
					positionName = position.getPositionName();			
				} catch (Exception e) {
					positionName = "";
				}
				
				PmlUserDTO userDTO = new PmlUserDTO();
				userDTO.setId(pmlUserId);
				userDTO.setName(userName);
				userDTO.setPosition(positionName);
				listUserDTO.add(userDTO);
			}
		}
		return listUserDTO;
	}*/
}
