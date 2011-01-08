package com.sgs.portlet.pcccdocumentreceiptreport.util;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;

/**
 * @author phmphuc
 */
public class ReportUtil {
	
	// lay ten action
	public static String getTenAction(String action) {
		String tenAction = "";
		if (action.equals("tondauky")) {
			tenAction = PortletProps.get("report-tondauky");
		} 
		else if (action.equals("nhantrongky")) {
			tenAction = PortletProps.get("report-nhantrongky");
		} 
		else if (action.equals("chuanhan")) {
			tenAction = PortletProps.get("report-chuanhan");
		} 
		else if (action.equals("dunghan")) {
			tenAction = PortletProps.get("report-dunghan");
		} 
		else if (action.equals("trehan")) {
			tenAction = PortletProps.get("report-trehan");
		} 
		else if (action.equals("tongdagiaiquyet")) {
			tenAction = PortletProps.get("report-tongdagiaiquyet");
		} 
		else if (action.equals("trongquidinh")) {
			tenAction = PortletProps.get("report-trongquydinh");
		} 
		else if (action.equals("quaquydinh")) {
			tenAction = PortletProps.get("report-quaquydinh");
		} 
		else {
			tenAction = PortletProps.get("report-tongdanggiaiquyet");
		}
		tenAction = tenAction.toLowerCase();
		
		return tenAction;
	}


	// lay ten phong ban
	public static String getTenPhongBan(String rowDS, String userIdRow, String departmentId, long userId) {
		String tenPhongBan = "";
		
		Department departmentHienThi = null;
		String departmentNameHienThi = "";
		
		User userHienThi = null;
		String userNameHienThi = "";
		
		// chon toan co quan hay tong cong cua tat ca phong ban
		if (departmentId.equals("toancoquan") || rowDS.equals("tatcaphongban")) {
			tenPhongBan = PortletProps.get("report-toancoquan");
		} 
		// chon 1 vi tri trong tat ca phong ban
		else if (departmentId.equals("tatcaphongban")) {
			try {
				departmentHienThi = DepartmentUtil.findByPrimaryKey(rowDS);
				departmentNameHienThi = departmentHienThi.getDepartmentsName();
			} catch (Exception e) {
				departmentNameHienThi = "";
			}
			tenPhongBan = departmentNameHienThi;
		} 
		else {
			// chon tung phong ban cu the hay tong cong cua tat ca chuyen vien
			try {
				departmentHienThi = DepartmentUtil.findByPrimaryKey(departmentId);
				departmentNameHienThi = departmentHienThi.getDepartmentsName();
			} catch (Exception e) {
				departmentNameHienThi = "";
			}
			
			if (userId == 0 || userIdRow.equals("tatcachuyenvien")) {
				tenPhongBan = departmentNameHienThi;
			} 
			// chon 1 vi tri trong tat ca chuyen vien
			else if (userId == 1) {
				long userSelect = Long.parseLong(userIdRow);
				try {
					userHienThi = UserLocalServiceUtil.getUser(userSelect);
					userNameHienThi = userHienThi.getLastName() + " " + userHienThi.getMiddleName() + " " + userHienThi.getFirstName();
				} catch (Exception e) {
					userNameHienThi = "";
				}
				tenPhongBan = departmentNameHienThi + " - CV: " + userNameHienThi;
			}
			else {
				try {
					userHienThi = UserLocalServiceUtil.getUser(userId);
					userNameHienThi = userHienThi.getLastName() + " " + userHienThi.getMiddleName() + " " + userHienThi.getFirstName();
				} catch (Exception e) {
					userNameHienThi = "";
				}
				tenPhongBan = departmentNameHienThi + " - CV: " + userNameHienThi;
			}
		}
		
		return tenPhongBan;
	}

}
