package com.sgs.portlet.pcccdocumentreceiptreport.util;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.pcccdocumentreceipt.util.PCCCDocumentUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

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
	public List<PmlEdmDocumentRecordType> getDocumentRecordByDocType(String type) {
		List<PmlEdmDocumentRecordType> results = null;
		List<PmlEdmDocumentType> documentTypes = null;
		PmlEdmDocumentRecordType recordType = null;
		int recordTypeId = 0;
		
		try {
			if (type.equals("congvandi")) {
				documentTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
			} else {
				documentTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
			}
			results = new ArrayList<PmlEdmDocumentRecordType>();
			for (PmlEdmDocumentType documentType : documentTypes) {
				recordTypeId = documentType.getDocumentRecordTypeId();
				try {
					recordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(recordTypeId);
					if (!results.contains(recordType)) {
						results.add(recordType);
					}
				} catch (Exception e1) { }
			}
		} catch (Exception e) {
			System.out.println("ERROR: in method getDocumentRecordByDocType " + TinhHinhThuLyCongVanDWRUtil.class);
			System.out.println(e.getMessage());
		}

		return results;
	}
}
