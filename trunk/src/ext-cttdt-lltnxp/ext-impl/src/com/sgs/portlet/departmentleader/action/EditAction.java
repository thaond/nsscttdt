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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.persistence.AgencyUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalServiceUtil;

public class EditAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			String redirect = ParamUtil.get(req, "redirect", "/sgs/departmentleader/view");
			editDepartment(req);
			sendRedirect(req, res, redirect);
	}
	
	
	private void editDepartment(ActionRequest req) throws Exception {
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		
		String departmentParentId = ParamUtil.getString(req, "departmentParentId", "");
		
		String departmentCode = ParamUtil.getString(req, "departmentCode", "");
		
		String departmentName = ParamUtil.getString(req, "departmentName", "");
		
		String abbreviateName = ParamUtil.getString(req, "abbreviateName", "");
		
		String agencyId = ParamUtil.getString(req, "departmentAgency", "");
		
		String[] pmlUserIdArr = req.getParameterValues("pmlUserId");
		
		String active = ParamUtil.getString(req, "active", "");
		String description = ParamUtil.getString(req, "description", "");
		
		if (!"".equals(departmentId)) {
			List<PmlUser> pmlUserList = null;
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			
			for (PmlUser pmlUser : pmlUserList) {
				pmlUser.setDepartmentsId("");
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			}
			
			Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
			department.setDepartmentsParentId(departmentParentId);
			department.setDepartmentsCode(departmentCode);
			department.setDepartmentsName(departmentName);
			department.setAbbreviateName(abbreviateName);
			department.setAgencyId(agencyId);
			if(active.equals("on")){
				department.setActive("1");
			}
			else department.setActive("0");
			
			department.setDescription(description);
			
			DepartmentLocalServiceUtil.updateDepartment(department);
		}

		if (pmlUserIdArr != null) {
			for (int i = 0; i < pmlUserIdArr.length; i++) {
				long pmlUserId = Long.parseLong(pmlUserIdArr[i]);
				PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(pmlUserId);
				pmlUser.setDepartmentsId(departmentId);				
				PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
			}
		}
	}



	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
				String departmentId = ParamUtil.getString(req, "departmentId", "");
				
				List<Agency> agencyList = AgencyUtil.findAll();
				
//				List<PmlUser> pmlUserList = PmlUserUtil.findAll();// yenlt close 24082010
//				List<PmlUserDTO> userList = populateUserToUserDTO(pmlUserList, departmentId); 
				List<PmlUserDTO> userList = populateUserToUserDTO(departmentId); // yenlt update 24082010
				
				Department department = new DepartmentImpl ();
				if (!"".equals(departmentId)) {
					department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				}
				
				req.setAttribute("department", department);
				req.setAttribute("userList", userList);
				req.setAttribute("agencyList", agencyList);

				return mapping.findForward("portlet.sgs.departmentleader.edit");
	}

	// yenlt update chi hien user cua phong va user chua co phong ban = 24/08/2010
	private List<PmlUserDTO> populateUserToUserDTO(String departmentId) throws Exception{
		List<PmlUserDTO> listUserDTO = new ArrayList<PmlUserDTO>();
		List<PmlUser> users = new ArrayList<PmlUser>();
		List<PmlUser> listUserPhongBan = new ArrayList<PmlUser>();
		List<PmlUser> listUserChuaCoPhongBan = new ArrayList<PmlUser>();
		listUserPhongBan = PmlUserUtil.findByDepartmentsId_Active(departmentId, true);
		listUserChuaCoPhongBan = PmlUserUtil.findByDepartmentsId_Active("", true);
		users.addAll(listUserPhongBan);
		users.addAll(listUserChuaCoPhongBan);
		for (int i = 0; i < users.size(); i++) {
			PmlUser pmlUser = users.get(i);
			long pmlUserId = pmlUser.getUserId();
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(pmlUserId);
			} catch (Exception e) {
				
			}
			
			String userName = "";
			if (user != null) {
				userName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			}
			
			String positionId = pmlUser.getPositionId();
			Position position = null;
			try {
				position = PositionLocalServiceUtil.getPosition(positionId);
			} catch (Exception e) {
			}
			
			String positionName = "";
			if (position != null) {
				positionName = position.getPositionName();
			}
			
			String isDepartmentMember = "";
			if (departmentId.equals(pmlUser.getDepartmentsId())) {
				isDepartmentMember = "1";
			}
			else {
				isDepartmentMember = "0";
			}
			
			PmlUserDTO userDTO = new PmlUserDTO();
			userDTO.setId(pmlUserId);
			userDTO.setName(userName);
			userDTO.setPosition(positionName);
			userDTO.setIsDepartmentMember(isDepartmentMember);
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}
	
	private List<PmlUserDTO> populateUserToUserDTO(List<PmlUser> users, String departmentId) throws Exception{
		List<PmlUserDTO> listUserDTO = new ArrayList<PmlUserDTO>();
		
		for (int i = 0; i < users.size(); i++) {
			PmlUser pmlUser = users.get(i);
			long pmlUserId = pmlUser.getUserId();
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(pmlUserId);
			} catch (Exception e) {
				
			}
			
			String userName = "";
			if (user != null) {
				userName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			}
			
			String positionId = pmlUser.getPositionId();
			Position position = null;
			try {
				position = PositionLocalServiceUtil.getPosition(positionId);
			} catch (Exception e) {
			}
			
			String positionName = "";
			if (position != null) {
				positionName = position.getPositionName();
			}
			
			String isDepartmentMember = "";
			if (departmentId.equals(pmlUser.getDepartmentsId())) {
				isDepartmentMember = "1";
			}
			else {
				isDepartmentMember = "0";
			}
			
			PmlUserDTO userDTO = new PmlUserDTO();
			userDTO.setId(pmlUserId);
			userDTO.setName(userName);
			userDTO.setPosition(positionName);
			userDTO.setIsDepartmentMember(isDepartmentMember);
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

}
