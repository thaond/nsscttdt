package com.sgs.portlet.pcccdocumentreceiptreport.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class TinhHinhThuLyCongVanDWRUtil {
	/* xuancong close khong su dung PmlUserDTO ma su dung PmlUser
	public static List<PmlUserDTO> getUserOfDepartment(String departmentId) throws Exception{
		//minh update 20100608		
//		List<User> _userList = new ArrayList<User>();
		List<PmlUserDTO> _userList = new ArrayList<PmlUserDTO>();
		List<PmlUser> pmlUserList = PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentId, -1, -1);
		int pmlUserSize = pmlUserList.size();
		PmlUserDTO pmlUserDTO = null;
		for(int i = 0; i < pmlUserSize; i ++) {
			//minh update 20100608		
//			User _user = UserUtil.findByPrimaryKey(pmlUserList.get(i).getUserId());
//			_user.setGreeting(getFullName(_user.getUserId()));
//			_userList.add(_user);
			pmlUserDTO = new PmlUserDTO();
			pmlUserDTO.setUserId(pmlUserList.get(i).getUserId());
			pmlUserDTO.setUserName(getFullName(pmlUserList.get(i).getUserId()));
			_userList.add(pmlUserDTO);
		}
		return _userList;
	}
	xuancong close end */
	
	/**
	 * Ham lay ve danh sach nguoi dung theo ma so phong ban
	 * 
	 * @param departmentId Ma so phong ban
	 */
	public static List<PmlUser> getUserOfDepartment(String departmentId) throws Exception {
		
		return PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentId, -1, -1, null);
	}
	
	public static String getFullName(long userId) {
		
		User user = null;
		String fullname = "";
		try {
			user = UserUtil.findByPrimaryKey(userId);
			fullname= user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		} catch (Exception e) {
			fullname = "";
		}
		return fullname;
	}
	
	/**
	 * lay so cong van theo loai cong van duoc chon 11/11/2010
	 */
	public List<PmlEdmDocumentRecordType> getDocumentRecordByDocType(long userId, String type) {
		List<PmlEdmDocumentRecordType> results = new ArrayList<PmlEdmDocumentRecordType>();
		
		/* phmphuc update 10/02/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);

		PmlUser pmlUser = null;
		Department department = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
		} catch (Exception e) { }
		
		if (department != null) {
			try {
				if (type.equals("congvandi")) {
					results = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbdi", department.getAgencyId(), currentYear);
				} else {
					results = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbden", department.getAgencyId(), currentYear);
				}
			} catch (Exception e) {
				System.out.println("ERROR: in method getDocumentRecordByDocType " + TinhHinhThuLyCongVanDWRUtil.class);
			}
		}

		return results;
	}
}
