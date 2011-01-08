package com.sgs.portlet.pmluser.action;

/**
 * @author triltm
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portal.util.ConstantsExt;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlTeam;
import com.sgs.portlet.onedoor.service.PmlTeamLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.model.impl.PmlUserImpl;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
				String cmd = ParamUtil.getString(req, Constants.CMD, "");
				String redirect = ParamUtil.getString(req, "redirect");
				
		if (Constants.ADD.equals(cmd)) { // Them nguoi dung moi
					addPmlUser(req);
				}
		else if (Constants.UPDATE.equals(cmd)) { // Cap nhat thong tin nguoi dung
					updatePmlUser(req);
				}
		else if (Constants.DELETE.equals(cmd)) { // Xoa nguoi dung
					boolean delete = deletePmlUser(req);
					redirect += "&delete=".concat(String.valueOf(delete));
				}
		else if (ConstantsExt.SYNCHRONIZE.equals(cmd)) { // Dong bo nguoi dung
			synchronizeUser(req);
		}
		
				sendRedirect(req, res, redirect);
	}

	private void addPmlUser(ActionRequest req) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
				WebKeys.THEME_DISPLAY);
		// Login information
		String screenName = ParamUtil.getString(req, "screenName", "");
		String email = ParamUtil.getString(req, "email", "");
		String password = ParamUtil.getString(req, "password", "");
		String retypePassword = ParamUtil.getString(req, "retypePassword", "");
		
		// Private information
		String lastName = ParamUtil.getString(req, "lastName", "");
		String middleName = ParamUtil.getString(req, "middleName", "");
		String firstName = ParamUtil.getString(req, "firstName", "");
		
		Date birthday = ParamUtil.getDate(req, "birthday", new SimpleDateFormat("dd/MM/yyyy"), null);
		
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1990;
		if (birthday != null) {
			/* xuancong close
			birthdayMonth = birthday.getMonth();
			birthdayDay = birthday.getDate();
			birthdayYear = birthday.getYear() + 1900;
			xuancong close */
			Calendar cal = Calendar.getInstance();
			cal.setTime(birthday);
			birthdayMonth = cal.get(Calendar.MONTH);
			birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
			birthdayYear = cal.get(Calendar.YEAR);
		}
		
		String phone = ParamUtil.getString(req, "phone", "");
		boolean gender = ParamUtil.getBoolean(req, "gender", true);
		String positionId = ParamUtil.getString(req, "positionId", "");
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		long teamId = ParamUtil.getLong(req, "teamId", 0);
		String note = ParamUtil.getString(req, "note", "");
		long[] organizationsId = {32902};
		
		PmlUser pmlUser = new PmlUserImpl();
		User user = null;
		
		//set system user
		
		user = UserServiceUtil.addUser(themeDisplay.getCompanyId(), false,
				password, retypePassword, false, screenName, email, 
				new Locale("vi_VN"), firstName, middleName, lastName, 
				0, 0, gender, birthdayMonth, birthdayDay, birthdayYear,
				"", organizationsId, true);
		
		//set PmlUser
		if (user != null) {
			pmlUser.setUserId(user.getUserId());
			pmlUser.setPositionId(positionId);
			pmlUser.setDepartmentsId(departmentId);
			pmlUser.setHandPhone(phone);
			pmlUser.setNote(note);
			pmlUser.setTeamId(teamId);
			
			PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
		}
	}
	
	private void updatePmlUser(ActionRequest req) throws Exception {
		long pmlUserId = ParamUtil.getLong(req, "pmlUserId", 0);
		
		//ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
		//		WebKeys.THEME_DISPLAY);
		// Login information
		//String screenName = ParamUtil.getString(req, "screenName", "");
		//String email = ParamUtil.getString(req, "email", "");
		
		// Private information
		//String lastName = ParamUtil.getString(req, "lastName", "");
		//String middleName = ParamUtil.getString(req, "middleName", "");
		//String firstName = ParamUtil.getString(req, "firstName", "");
		
		Date birthday = ParamUtil.getDate(req, "birthday", new SimpleDateFormat("dd/MM/yyyy"), null);
		
		//int birthdayMonth = 1;
		//int birthdayDay = 1;
		//int birthdayYear = 1990;
		if (birthday != null) {
			/* xuancong close
			birthdayMonth = birthday.getMonth();
			birthdayDay = birthday.getDate();
			birthdayYear = birthday.getYear() + 1900;
			xuancong close */
			Calendar cal = Calendar.getInstance();
			cal.setTime(birthday);
			//birthdayMonth = cal.get(Calendar.MONTH);
			//birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
			//birthdayYear = cal.get(Calendar.YEAR);
		}
		
		String phone = ParamUtil.getString(req, "phone", "");
		//boolean gender = ParamUtil.getBoolean(req, "gender", true);
		String positionId = ParamUtil.getString(req, "positionId", "");
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		long teamId = ParamUtil.getLong(req, "teamId", 0);
		String note = ParamUtil.getString(req, "note", "");
		//long[] organizationsId = {32902};
		
		if (pmlUserId != 0) {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(pmlUserId);
			
			//User user = UserUtil.findByPrimaryKey(pmlUserId);
			
			//String oldPassword = AdminUtil.getUpdateUserPassword(req, pmlUserId);
			//String greeting = "Welcome " + user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			
			// Khong update portalUser tu pmlUser
			// xuancong close UserServiceUtil.updateUser(pmlUserId, oldPassword, false, screenName, email, "vi_VN", "GMT+07:00", greeting, "", firstName, middleName, lastName, 0, 0, gender, birthdayMonth, birthdayDay, birthdayYear, "", "", "", "", "", "", "", "", "", "", "", organizationsId);
			
			pmlUser.setDepartmentsId(departmentId);
			pmlUser.setHandPhone(phone);
			pmlUser.setNote(note);
			pmlUser.setPositionId(positionId);
			pmlUser.setTeamId(teamId);
			
			PmlUserLocalServiceUtil.updatePmlUser(pmlUser);
		}
	}
	
	
	private boolean deletePmlUser(ActionRequest req) {
		long pmlUserId = ParamUtil.getLong(req, "pmlUserId", 0);
		
		//List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
		//List<PmlAgencyLeader> pmlAgencyLeaderList = new ArrayList<PmlAgencyLeader>();
		if (pmlUserId != 0) {
			
			/* xuancong close Khong xoa portalUser
			try {
				pmlDepartmentsLeaderList = PmlDepartmentsLeaderUtil.findByUserId(pmlUserId);
			} catch (Exception e) {
				_log.error("NO GET LIST DEPARTMENT");
			}
			
			try {
				pmlAgencyLeaderList = PmlAgencyLeaderUtil.findByUserId(pmlUserId);
			} catch (Exception e) {
				_log.error("NO GET LIST PMLAGENCYLEADER");
			}
			 
			
			if (pmlDepartmentsLeaderList.size() == 0 && pmlAgencyLeaderList.size() == 0) {
			
				try {
					PmlUserLocalServiceUtil.deletePmlUser(pmlUserId);
					UserLocalServiceUtil.deleteUser(pmlUserId);
					return true;
				} catch (Exception e) {
					_log.error("NO DELETE PMLUSER");
					return false;
				}
			}
			*/
			try {
				return PmlUserLocalServiceUtil.removePmlUser(pmlUserId);
			}
			catch (Exception ex) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
				String cmd = ParamUtil.getString(req, Constants.CMD, "");
				
				if (Constants.ADD.equals(cmd) || Constants.EDIT.equals(cmd)) {
					
					List<Position> positionList = new ArrayList<Position>();
					List<Department> departmentList =  new ArrayList<Department>();
					List<PmlTeam> teamList = new ArrayList<PmlTeam>();
					try {
						positionList = PositionLocalServiceUtil.getPositions(-1, -1);
						
					} catch (Exception e) {
						_log.error("NO GET LIST POSITION");
					}
					
					try {
						departmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
						
					} catch (Exception e) {
						_log.error("NO GET LIST DEPARTMENT");
					}
					
					try {
						teamList = PmlTeamLocalServiceUtil.getPmlTeams(-1, -1);
					} catch (Exception e) {
					}
					
					if (Constants.EDIT.equals(cmd)) {
						getEditUser(req);
					}
					
					req.setAttribute("teamList", teamList);
					req.setAttribute("departmentList", departmentList);
					req.setAttribute("positionList", positionList);
				}
				
				return mapping.findForward("portlet.sgs.pmluser.view");
	}

	private void getEditUser(RenderRequest req) throws Exception {
		long pmlUserId = ParamUtil.getLong(req, "pmlUserId", 0);
		
		if (pmlUserId != 0) {
			PmlUser pmlUser = null;
			User user = null;
			try {
				pmlUser = PmlUserUtil.findByPrimaryKey(pmlUserId);
				user = UserUtil.findByPrimaryKey(pmlUserId);
			} catch (Exception e) {
				_log.error("NO GET PMLUSER WITH ID " +  pmlUserId);
				pmlUser = new PmlUserImpl();
				user = new UserImpl();
			}
			
			req.setAttribute("pmlUser", pmlUser);
			req.setAttribute("currentUser", user);
		}
	}

	/* xuancong close ham khong su dung
	private List<PmlUserDTO> populateToDTO(List<PmlUser> pmlUserList) throws Exception {
		List<PmlUserDTO> results = new ArrayList<PmlUserDTO>();
		for (PmlUser pmlUser : pmlUserList) {
			long pmlUserId = pmlUser.getUserId();
			
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(pmlUserId);
			} catch (Exception e) {}
			
			String pmlUserFullName = "";
			String screenName = "";
			String email = "";
			if (user != null) {
				pmlUserFullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				screenName = user.getScreenName();
				email = user.getEmailAddress();
			}
			
			String positionId = pmlUser.getPositionId();
			String positionName = "";

			if (!"".equals(positionId)) {
				Position position = PositionUtil.findByPrimaryKey(positionId);
				positionName = position.getPositionName();
			}
			
			String departmentId = pmlUser.getDepartmentsId();
			String departmentName = "";

			if (!"".equals(departmentId)) {
				Department department = DepartmentUtil.findByPrimaryKey(departmentId);
				departmentName = department.getDepartmentsName();
			}
			
			String pmlRoleId = pmlUser.getRoleId();
			String roleName = "";
			
			if (!"".equals(pmlRoleId)) {
				PmlRole role = PmlRoleUtil.findByPrimaryKey(pmlRoleId);
				roleName = role.getRoleName();
			}
			
			String handPhone = pmlUser.getHandPhone();
			String note = pmlUser.getNote();
			
			long teamId = pmlUser.getTeamId();
			String teamName = "";
			
			if (teamId != 0) {
				try {
					PmlTeam pmlTeam = PmlTeamUtil.findByPrimaryKey(teamId);
					teamName = pmlTeam.getTeamName();
				} catch (Exception e) {					
				}
			}
			
			PmlUserDTO userDTO = new PmlUserDTO();
			
			userDTO.setPmlUserId(pmlUserId);
			userDTO.setFullName(pmlUserFullName);
			userDTO.setScreenName(screenName);
			userDTO.setEmail(email);
			userDTO.setPositionName(positionName);
			userDTO.setDepartmentName(departmentName);
			userDTO.setHandPhone(handPhone);
			userDTO.setNote(note);
			userDTO.setTeamName(teamName);
			userDTO.setRoleName(roleName);
			
			results.add(userDTO);
		}
		return results;
	}
	*/
	
	private void synchronizeUser(ActionRequest req) throws Exception {
		
		// Goi ham xu ly dong bo du lieu
		PmlUserLocalServiceUtil.synchronizePmlUserWithPortalUser();
	}
}
