package com.sgs.portlet.onedoor.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.onedoor.model.PmlTeam;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.onedoor.service.base.PmlTeamLocalServiceBaseImpl;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlTeamUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.onedoorpccc.model.PmlTeamLeader;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTeamLeaderUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlTeamLocalServiceImpl extends PmlTeamLocalServiceBaseImpl {
	
	/**
	 * @param departmentId
	 * @param teamCode
	 * @return PmlTeam
	 */
	public PmlTeam getTeamByDepartmentId_TeamCode(String departmentId, String teamCode) {
		
		PmlTeam retValue = null;
		List<PmlTeam> listTeam = null;
		
		if (departmentId == null || teamCode == null) {
			return retValue;
		}
		
		try {
			listTeam = PmlTeamUtil.findByDepartmentId_TeamCode(departmentId, teamCode);
			
			if (listTeam != null && listTeam.size() > 0) {
				retValue = listTeam.get(0);
			}
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get team leader by departmentCode and teamCode
	 * @param departmentCode
	 * @param teamCode
	 * @return PmlUser
	 */
	public PmlUser getTeamLeaderByDepartmentCode_TeamCode(String departmentCode, String teamCode) {
		
		if (departmentCode == null || teamCode == null) {
			return null;
		}
		
		// get department from department code.
		List<Department> listDeparment = null;
		try {
			listDeparment = DepartmentUtil.findByDepartmentsCode(departmentCode);
			
			String departmentId = null;
			
			if (listDeparment == null || listDeparment.size() <= 0) {
				return null;
			}
			
			departmentId = listDeparment.get(0).getDepartmentsId();
			
			// get team from departmentId and teamCode
			PmlTeam team = getTeamByDepartmentId_TeamCode(departmentId, teamCode);
			if (team == null) {
				return null;
			}
			
			// get team leader.
			PmlTeamLeader teamLeader = PmlTeamLeaderUtil.findByPrimaryKey(team.getTeamId());
			return PmlUserUtil.findByPrimaryKey(teamLeader.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * get all user of a team by departmentCode and teamCode
	 * @param departmentCode
	 * @param teamCode
	 * @return List<PmlUser>
	 */
	public List<PmlUser> getTeamMembersByDepartmentCode_TeamCode(String departmentCode, String teamCode) {
		
		if (departmentCode == null || teamCode == null) {
			return null;
		}
		
		// get department from department code.
		List<Department> listDeparment = null;
		try {
			listDeparment = DepartmentUtil.findByDepartmentsCode(departmentCode);
			
			String departmentId = null;
			
			if (listDeparment == null || listDeparment.size() <= 0) {
				return null;
			}
			
			departmentId = listDeparment.get(0).getDepartmentsId();
			
			// get team from departmentId and teamCode
			PmlTeam team = getTeamByDepartmentId_TeamCode(departmentId, teamCode);
			if (team == null) {
				return null;
			}
			
			// get all members in team
			return PmlUserUtil.findByTeamId(team.getTeamId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
