
package com.sgs.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.agency.NoSuchAgencyException;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.persistence.AgencyUtil;
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.service.persistence.AttachedFileUtil;
import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.field.NoSuchPmlFieldException;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.NoSuchPmlFileTypeException;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.base.PmlOneDoorReceiveFileLocalServiceBaseImpl;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;

/**
 * @author lethanhtung
 *
 */
public class PmlOneDoorReceiveFileLocalServiceImpl	extends PmlOneDoorReceiveFileLocalServiceBaseImpl {

	
//	end minh update 20100525		
	public List<PmlOneDoorReceiveFile> search(String numberreceipt, String filename, String applicantname,
			String permanentaddress, String telephone, String filetypeid, String tuNgayTiepNhan,
			String denNgayTiepNhan, String tuNgayHenTra, String denNgayHenTra, 
			String tuNgayHSHoanThanh, String denNgayHSHoanThanh, String tuNgayHSTraThuc, String denNgayHSTraThuc,
			List<String> typeList, List<String> valueTypeList, int start, int end,  OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.search(numberreceipt, filename, applicantname,
					permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
					denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, 
					tuNgayHSHoanThanh, denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc,
					typeList, valueTypeList, start, end, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
//	end minh update 20100525
	
	/**
	 * AttachedFile : ho so kem theo 
	 * this method return a list of AttachedFile
	 * 
	 * @param fileTypeId
	 * @return
	 */
	public List<AttachedFile> getAttachedByFileType(String fileTypeId) {

		List<AttachedFile> retValue = new ArrayList<AttachedFile>();
		AttachedFile attachedFile = null;
		List<PmlFileTypeAttachedFile> list =	new ArrayList<PmlFileTypeAttachedFile>();
		try {
			list = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
			for (int i = 0; i < list.size(); i++) {
				String attachedFileId = list.get(i).getAttachedFileId();
				attachedFile =	AttachedFileUtil.findByPrimaryKey(attachedFileId);
				retValue.add(attachedFile);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return retValue;
	}

	/**
	 * FileType_AttachedFile : LoaiHoSo_HoSoKemTheo 
	 * this method get a list of FileType_AttachedFile
	 * @param fileTypeId
	 * @return
	 */
	public List<PmlFileTypeAttachedFile> getFileTypeAttachedFileByFileTypeId(String fileTypeId) {

		List<PmlFileTypeAttachedFile> retValue = new ArrayList<PmlFileTypeAttachedFile>();
		try {
			retValue = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return retValue;
	}

	/**
	 * this method filter a list by input params and a list of PmlOneDoorReceiveFile object
	 * @param list
	 * @param fileTypeName : tÃªn lá»�ai há»“ sÆ¡
	 * @param startDate
	 * @param endDate
	 * @param applicantName : tÃªn ngá»«Æ¡i ná»™p
	 * @param organization : tÃªn Ä‘Æ¡n vá»‹
	 * @param address
	 * @param district
	 * @param numberReceipt
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filter(List<PmlOneDoorReceiveFile> list, String fileTypeName, Date startDate,
													Date endDate, String applicantName, String organization,
													String address, String district, String numberReceipt) {

		List<PmlOneDoorReceiveFile> retValue =	filterByFileTypeName(list, fileTypeName);
		retValue =	filterByApplicantName(retValue, applicantName);
		retValue =	filterByNumberReceipt(retValue, numberReceipt);
		retValue =	filterByStartDate(retValue, startDate);
		retValue =	filterByEndDate(retValue, endDate);
		retValue =	filterByDistrict(retValue, district);
		retValue =	filterByOrganization(retValue, organization);
		retValue =	filterByAddress(retValue, address);
		return retValue;
	}
	
	/**
	 * this method filter a list by number receipt and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param numberReceipt
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByNumberReceipt(List<PmlOneDoorReceiveFile> list, String numberReceipt) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || numberReceipt == null || numberReceipt.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getNumberReceipt() != null) {
				if (item.getNumberReceipt().toUpperCase().indexOf(numberReceipt.toUpperCase()) != -1) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			
			}
		}	
		return retValue;
	}
	
	/**
	 * this method filter a list by district and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param district
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByDistrict(List<PmlOneDoorReceiveFile> list, String district) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || district == null || district.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getDistrictId() != null) {
				if (item.getDistrictId().equalsIgnoreCase(district)) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		
		return retValue;
	}
	
	/**
	 * this method filter a list by address and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param address
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByAddress(List<PmlOneDoorReceiveFile> list, String address) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || address == null || address.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getPermanentAddress() != null) {
				if (item.getPermanentAddress().toUpperCase().indexOf(address.toUpperCase()) != -1) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		
		return retValue;
	}

	/**
	 * this method filter a list by fileTypeName and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param fileTypeName
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByFileTypeName(List<PmlOneDoorReceiveFile> list, String fileTypeName) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || fileTypeName == null || fileTypeName.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getFileTypeId() != null) {
				if (item.getFileTypeId().toUpperCase().indexOf(fileTypeName.toUpperCase()) != -1) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		
		return retValue;
	}

	/**
	 * this method filter a list by applicantName and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param applicantName
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByApplicantName(List<PmlOneDoorReceiveFile> list, String applicantName) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || applicantName == null || applicantName.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getApplicantName() != null) {
				if (item.getApplicantName().toUpperCase().indexOf(applicantName.toUpperCase()) != -1) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		
		return retValue;
	}
	
	/**
	 * this method filter a list by organization and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param organization
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByOrganization(List<PmlOneDoorReceiveFile> list, String organization) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		if (list == null || organization == null || organization.equalsIgnoreCase("")) {
			return list;
		}
		
		for (PmlOneDoorReceiveFile item : list) {
			if (item.getOrganization() != null) {
				if (item.getOrganization().toUpperCase().indexOf(organization.toUpperCase()) != -1) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		
		return retValue;
	}

	/**
	 * this method filter a list by startDate and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param startDate
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByStartDate(List<PmlOneDoorReceiveFile> list, Date startDate) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		if (list == null || startDate == null || startDate.toString().equals("")) {
			return list;
		}
		for (PmlOneDoorReceiveFile item : list) {
			Date applicationDate = item.getApplicationDate();
			
			if (applicationDate != null) {
				if (applicationDate.after(startDate) || startDate.equals(applicationDate)) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}
		return retValue;
	}

	/**
	 * this method filter a list by endDate and a list of PmlOneDoorReceiveFile
	 * @param list
	 * @param endDate
	 * List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> filterByEndDate(List<PmlOneDoorReceiveFile> list, Date endDate) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		if (list == null || endDate == null || endDate.toString().equals("")) {
			return list;
		}
		for (PmlOneDoorReceiveFile item : list) {
			Date applicationDate = item.getApplicationDate();
			
			if (applicationDate != null) {
				if (applicationDate.before(endDate) || endDate.equals(applicationDate)) {
					pmlOneDoorReceiveFile = item;
					retValue.add(pmlOneDoorReceiveFile);
				}
			}
		}	
		return retValue;
	}
	
	/**
	 * há»“ sÆ¡ tráº£
	 * count applicationFile by startDate, endDate and fileTypeId
	 * @param startDate
	 * @param endDate
	 * @param fileTypeId
	 * @return integer
	 */
	public int counterApplicationFile (Date startDate, Date endDate, String fileTypeId) {
		
		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			
			if (list == null || startDate == null || endDate == null) {
				return 0;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date applicationDate = item.getApplicationDate();
				
				if (applicationDate != null) {
					if ((applicationDate.after(startDate) || startDate.equals(applicationDate))
									&& (applicationDate.before(endDate) || endDate.equals(applicationDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue.size();
	}
	
	/**
	 * há»“ sÆ¡ nháº­n (giáº¥y phÃ©p ra)
	 * count exactReturningFile by startDate, endDate and fileTypeId
	 * @param startDate
	 * @param endDate
	 * @param fileTypeId
	 * @return integer
	 */
	public int counterExactReturningFile (Date startDate, Date endDate, String fileTypeId) {
		
		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			
			if (list == null || startDate == null || endDate == null) {
				return 0;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date exactReturningDate = item.getExactReturningDate();
				
				if (exactReturningDate != null) {
					if ((exactReturningDate.after(startDate) || startDate.equals(exactReturningDate))
									&& (exactReturningDate.before(endDate) || endDate.equals(exactReturningDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue.size();
	}
	
	/**
	 * giáº¥y phÃ©p chÆ°a Ä‘áº¿n háº¹n
	 * count expectedReturningFile by startDate, endDate and fileTypeId. Get by expectedRetrningDate
	 * @param startDate
	 * @param endDate
	 * @param fileTypeId
	 * @return integer
	 */
	public int counterExpectedReturningFile (Date startDate, Date endDate, String fileTypeId) {
		
		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findAll();
			
			if (list == null || startDate == null || endDate == null) {
				return 0;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date expectedReturningDate = item.getExpectedReturningDate();
				
				if (expectedReturningDate != null) {
					if ((expectedReturningDate.after(startDate) || startDate.equals(expectedReturningDate))
									&& (expectedReturningDate.before(endDate) || endDate.equals(expectedReturningDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue.size();
	}
	
	/**
	 * get List<PmlFileType> by List<PmlOneDoorReceiveFile>
	 * @param list
	 * @return List<PmlFileType>
	 * 
	 */
	public List<PmlFileType> getListFileTypeByListFile (List<PmlOneDoorReceiveFile> list) {
		
		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		PmlFileType pmlFileType = null;
		
		try {
			if (list == null) {
				return retValue;
			}
			for (PmlOneDoorReceiveFile item : list) {
				if (item.getFileTypeId() != null) {
					String fileTypeId = item.getFileTypeId();
					try {
						pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
						if (retValue.contains(pmlFileType)) {
							continue;
						}
						retValue.add(pmlFileType);
					}
					catch (NoSuchPmlFileTypeException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlField> by List<PmlOneDoorReceiveFile>
	 * @param listFile
	 * @return List<PmlField>
	 */
	public List<PmlField> getListFieldByListFile (List<PmlOneDoorReceiveFile> listFile) {
		
		List<PmlField> retValue = new ArrayList<PmlField>();
		PmlField pmlField = null;
		List<PmlFileType> list = this.getListFileTypeByListFile(listFile);
		
		if (list == null) {
			return retValue;
		}
		for (PmlFileType item : list) {
			if (item.getFieldId() != null) {
				String fieldId = item.getFieldId();
				try {
					pmlField = PmlFieldUtil.findByPrimaryKey(fieldId);
					if (retValue.contains(pmlField)) {
						continue;
					}
					retValue.add(pmlField);
				}
				catch (NoSuchPmlFieldException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return retValue;
	}
	
	/**
	 * get List<PmlDepartment> by List<PmlOneDoorReceiveFile>
	 * @param listFile
	 * @return List<PmlDepartment>
	 */
	public List<Department> getListDepartmentsByListFile(List<PmlOneDoorReceiveFile> listFile) {
		
		List<Department> retValue = new ArrayList<Department>();
		Department pmlDepartment = null;
		List<PmlField> list = this.getListFieldByListFile(listFile);
		
		if (list == null) {
			return retValue;
		}
		for (PmlField item : list) {
			if (item.getDepartmentsId() != null) {
				String departmentsId = item.getDepartmentsId();
				try {
					pmlDepartment = DepartmentUtil.findByPrimaryKey(departmentsId);
					if (retValue.contains(pmlDepartment)) {
						continue;
					}
					retValue.add(pmlDepartment);
				}
				catch (NoSuchDepartmentException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return retValue;
	}
	
	/**
	 * get List<PmlAgency> by List<PmlOneDoorReceiveFile>
	 * @param listFile
	 * @return listFile
	 */
	public List<Agency> getListAgencyByListFile (List<PmlOneDoorReceiveFile> listFile) {
		
		List<Agency> retValue = new ArrayList<Agency>();
		Agency pmlAgency = null;
		List<Department> list = this.getListDepartmentsByListFile(listFile);
		
		if (list == null) {
			return retValue;
		}
		for (Department item : list) {
			if (item.getAgencyId() != null) {
				String agencyId = item.getAgencyId();
				try {
					pmlAgency = AgencyUtil.findByPrimaryKey(agencyId);
					if (retValue.contains(pmlAgency)) {
						continue;
					}
					retValue.add(pmlAgency);
				}
				catch (NoSuchAgencyException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by field
	 * @param pmlField
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByField (PmlField pmlField) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlFileType> listFileType = null; 
		
		if (pmlField == null) {
			return retValue;
		}
		
		String fieldId = pmlField.getFieldId();
		try {
			listFileType = PmlFileTypeUtil.findByFieldId(fieldId);
			
			if (listFileType == null) {
				return retValue;
			}
			for (PmlFileType item : listFileType) {
				String fileTypeId = item.getFileTypeId();
				retValue = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by FileType
	 * @param pmlFileType
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByFileType (PmlFileType pmlFileType) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (pmlFileType == null || pmlFileType.getFileTypeId() == null || pmlFileType.getFileTypeId().equals("")) {
			return retValue;
		}
		
		String fileTypeId = pmlFileType.getFileTypeId();
		try {
			retValue = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * bÃ¡o cÃ¡o tuáº§n, láº¥y danh sÃ¡ch PmlOneDoorReceiveFile theo ngÃ y thá»±c tráº£ vÃ  ngÃ y nháº­n
	 * get List<PmlOneDoorReceiveFile> by startDate, endDate and field. Get by exactReturningDate and applicationDate
	 * @param startDate
	 * @param endDate
	 * @param pmlField
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public  List<PmlOneDoorReceiveFile> getListFile (Date startDate, Date endDate, PmlField pmlField) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list1 = this.getListFileByField(pmlField);
		List<PmlOneDoorReceiveFile> list2 = this.getFileByTwoDate(startDate, endDate);
		list1.retainAll(list2);
		
		for (PmlOneDoorReceiveFile item : list1) {
			retValue.add(item);
		}
		
		return retValue;
	}
	
	public  List<PmlOneDoorReceiveFile> getListFile (Date startDate, Date endDate) {
		
		return this.getFileByTwoDate(startDate, endDate);
	}
	
	/**
	 * bÃ¡o cÃ¡o thÃ¡ng, láº¥y danh sÃ¡ch PmlOneDoorReceiveFile theo ngÃ y thá»±c tráº£
	 * get List<PmlOneDoorReceiveFile> by startDate, endDate and FileType object. Compare with exactReturningDate
	 * @param startDate
	 * @param endDate
	 * @param pmlFileType
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByExactReturningDate (Date startDate, Date endDate, PmlFileType pmlFileType) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list1 = this.getListFileByExactReturningFile(startDate, endDate);
		List<PmlOneDoorReceiveFile> list2 = this.getListFileByFileType(pmlFileType);
		list1.retainAll(list2);
		
		for (PmlOneDoorReceiveFile item : list1) {
			retValue.add(item);
		}
		
		return retValue;
	}
	
	/**
	 * loc theo ngay thuc tra
	 * get List<PmlOneDoorReceiveFile> by startDate and endDate. Compare with exactReturningDate
	 * @param startDate
	 * @param endDate
	 * @since 30-03-2009
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByExactReturningFile(Date startDate, Date endDate) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findAll();
			
			if (list == null || startDate == null || endDate == null) {
				return retValue;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date exactReturningDate =  item.getExactReturningDate();
				
				if (exactReturningDate != null) {
					if ((exactReturningDate.after(startDate) || startDate.equals(exactReturningDate))
									&& (exactReturningDate.before(endDate) || endDate.equals(exactReturningDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * bÃ¡o cÃ¡o thÃ¡ng, láº¥y danh sÃ¡ch PmlOneDoorReceiveFile theo ngÃ y háº¹n tráº£
	 * get List<PmlOneDoorReceiveFile> by FileType object, startDate and endDate. Compare by expectedReturningDate
	 * @param pmlFileType
	 * @param startDate
	 * @param endDate
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByExpectedReturningDate (PmlFileType pmlFileType, Date startDate, Date endDate) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list1 = this.getListExpectedReturningFile(startDate, endDate);
		List<PmlOneDoorReceiveFile> list2 = this.getListFileByFileType(pmlFileType);
		list1.retainAll(list2);
		
		for (PmlOneDoorReceiveFile item : list1) {
			retValue.add(item);
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by startDate and endDate. Compare by expextedReturningDate.
	 * @param startDate
	 * @param endDate
	 * @return List<PmlOneDoorReceiveFile>
	 */
	private List<PmlOneDoorReceiveFile> getListExpectedReturningFile(Date startDate, Date endDate) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findAll();
			
			if (list == null || startDate == null || endDate == null) {
				return retValue;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date expectedReturningDate = item.getExpectedReturningDate();
				
				if (expectedReturningDate != null) {
					if ((expectedReturningDate.after(startDate) || startDate.equals(expectedReturningDate))
									&& (expectedReturningDate.before(endDate) || endDate.equals(expectedReturningDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * bÃ¡o cÃ¡o thÃ¡ng, láº¥y danh sÃ¡ch PmlOneDoorReceiveFile theo ngÃ y nháº­n
	 * get List<PmlOneDoorReceiveFile> by FileType object, startDate and endDate. Compare by applicationDate
	 * @param pmlFileType
	 * @param startDate
	 * @param endDate
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileByApplicationDate (PmlFileType pmlFileType, Date startDate, Date endDate) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list1 = this.getListApplicationFile(startDate, endDate);
		List<PmlOneDoorReceiveFile> list2 = this.getListFileByFileType(pmlFileType);
		list1.retainAll(list2);
		
		for (PmlOneDoorReceiveFile item : list1) {
			retValue.add(item);
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by startDate and endDate. Compare by applicationDate.
	 * @param startDate
	 * @param endDate
	 * @return List<PmlOneDoorReceiveFile>
	 */
	private List<PmlOneDoorReceiveFile> getListApplicationFile(Date startDate, Date endDate) {

		List<PmlOneDoorReceiveFile> retValue =	new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		List<PmlOneDoorReceiveFile> list ;
		
		try {
			list = PmlOneDoorReceiveFileUtil.findAll();
			
			if (list == null || startDate == null || endDate == null) {
				return retValue;
			}
			
			for (PmlOneDoorReceiveFile item : list) {
				Date applicationDate = item.getApplicationDate();
				
				if (applicationDate != null) {
					if ((applicationDate.after(startDate) || startDate.equals(applicationDate))
									&& (applicationDate.before(endDate) || endDate.equals(applicationDate))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * láº¥y danh sÃ¡ch PmlOneDoorReceiveFile theo ngÃ y thá»±c tráº£ vÃ  ngÃ y nháº­n
	 * get List<PmlOneDoorReceiveFile> by startDate and endDate. Compare by exactReturningDate and applicationDate
	 * @param startDate
	 * @param endDate
	 * @return List<PmlOneDoorReceiveFile>
	 */
	private List<PmlOneDoorReceiveFile> getFileByTwoDate(Date startDate, Date endDate) {

		 List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		 List<PmlOneDoorReceiveFile> list;
		 PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		 try {
			list = PmlOneDoorReceiveFileUtil.findAll();
			if (list == null || startDate == null || endDate == null) {
				return retValue;
			}
			for (PmlOneDoorReceiveFile item : list) {
				Date applicationDate = item.getApplicationDate();
				Date exactReturningDate = item.getExactReturningDate();
				
				if (exactReturningDate != null && applicationDate != null) {
					if (((exactReturningDate.after(startDate) || startDate.equals(exactReturningDate))
									&& (exactReturningDate.before(endDate) || endDate.equals(exactReturningDate)))
									|| ((applicationDate.after(startDate) || startDate.equals(applicationDate))
									    && (applicationDate.before(endDate) || endDate.equals(applicationDate)))) {
						pmlOneDoorReceiveFile = item;
						retValue.add(pmlOneDoorReceiveFile);
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		 return retValue;
	}
	
	/**
	 * lay ra danh sach fieldID va PmlOneDoorReceiveFile theo fieldId dua theo danh sach PmlOneDoorReceiveFile co san.
	 * get Map<String, List<PmlOneDoorReceiveFile>> by List<PmlOneDoorReceiveFile>
	 * @param listFile
	 * @return Map<String, List<PmlOneDoorReceiveFile>>
	 */
	public Map<String, List<PmlOneDoorReceiveFile>> getListFieldIDAndListFile (List<PmlOneDoorReceiveFile> listFile) {
		
		Map<String, List<PmlOneDoorReceiveFile>> retValue = new HashMap<String, List<PmlOneDoorReceiveFile>>();
		List<PmlOneDoorReceiveFile> list = null;
		
		if (listFile == null) {
			return retValue;
		}
		
		for (Iterator<PmlOneDoorReceiveFile> iterator = listFile.iterator(); iterator.hasNext();) {
			
			PmlOneDoorReceiveFile receiveFile =	iterator.next();
			String fieldId = getFieldIdByFile(receiveFile);
			
			if (retValue.keySet().contains(fieldId)) {
				list = retValue.get(fieldId);
			} else {
				list = new ArrayList<PmlOneDoorReceiveFile>();
			}
			
			list.add(receiveFile);
			retValue.put(fieldId, list);
		}
		
		return retValue;
	}

	/**
	 * get fieldId by File object
	 * @param receiveFile
	 * @return String
	 */
	private String getFieldIdByFile(PmlOneDoorReceiveFile receiveFile) {

		PmlFileType pmlFileType = null;
		
		try {
			pmlFileType = PmlFileTypeUtil.findByPrimaryKey(receiveFile.getFileTypeId());
		} catch (Exception e) {
		}
		
		if (pmlFileType == null) {
			return null;
		}
		
		return pmlFileType.getFieldId();
	}
	
	/**
	 * get Map<String, List<PmlOneDoorReceiveFile>> by List<PmlOneDoorReceiveFile>, startDate and endDate.
	 * Compare by exactReturningDate
	 * @param listFile
	 * @param startDate
	 * @param endDate
	 * @return Map<String, List<PmlOneDoorReceiveFile>>
	 */
	public Map<String, List<PmlOneDoorReceiveFile>> getListFieldIDAndListFile (List<PmlOneDoorReceiveFile> listFile, 
																					Date startDate, Date endDate) {
		
		Map<String, List<PmlOneDoorReceiveFile>> retValue = new HashMap<String, List<PmlOneDoorReceiveFile>>();
		List<PmlOneDoorReceiveFile> list = null;
		
		if (listFile == null || startDate == null || endDate == null) {
			return retValue;
		}
		
		for (Iterator<PmlOneDoorReceiveFile> iterator = listFile.iterator(); iterator.hasNext();) {
			
			PmlOneDoorReceiveFile receiveFile =	iterator.next();
			String fieldId = getFieldIdByFile(receiveFile);
			Date exactReturningDate = receiveFile.getExactReturningDate();
			
			if (receiveFile.getExactReturningDate() != null) {
				if ((exactReturningDate.after(startDate) || startDate.equals(exactReturningDate))
								&& (exactReturningDate.before(endDate) || endDate.equals(exactReturningDate))) {
					if (retValue.keySet().contains(fieldId)) {
						list = retValue.get(fieldId);
					} else {
						list = new ArrayList<PmlOneDoorReceiveFile>();
					}
					
					list.add(receiveFile);
					retValue.put(fieldId, list);
				}
			}
		}
		
		return retValue;
	}
	
	/**
	 * loc theo ngay nhan
	 * get List<PmlOneDoorReceiveFile> by fileTypeId, startDate and endDate.
	 * Compare by exactReturningDate
	 * @param fileTypeId
	 * @param startDate
	 * @param endDate
	 * @since 30-03-2009
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileBy_fileTypeId_startDate_endDate (String fileTypeId, Date startDate, Date endDate) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list = null;
		
		if (fileTypeId == null) {
			return retValue;
		}
		
		try {
			list = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			if (startDate == null || endDate == null) {
				return new ArrayList<PmlOneDoorReceiveFile>();
			}
			for (PmlOneDoorReceiveFile item : list) {
				Date exactReturningDate = item.getExactReturningDate();
				if (exactReturningDate != null) {
					if (exactReturningDate.after(startDate) && exactReturningDate.before(endDate) ) {
						retValue.add(item);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by departmentId
	 * @param departmentId
	 * @param startDate
	 * @param endDate
	 * @since 30-03-2009
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileBy_DepartmentId (String departmentId) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list = null;
		List<PmlFileType> listFileType = getListFileTypeByDepartmentId(departmentId);
		
		if (departmentId == null) {
			return retValue;
		}
		
		for (PmlFileType fileTypeItem : listFileType) {
			String fileTypeId = fileTypeItem.getFileTypeId();
			try {
				list = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
				retValue.addAll(list);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}

	/**
	 * get List<PmlFileType> by departmentId
	 * @param departmentId
	 * @return List<PmlFileType>
	 */
	public List<PmlFileType> getListFileTypeByDepartmentId(String departmentId) {

		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		List<PmlFileType> list = null;
		List<PmlField> listField = null;
		
		if (departmentId == null) {
			return retValue;
		}
		try {
			listField = PmlFieldUtil.findByDepartmentsId(departmentId);
			
			for (PmlField fieldItem : listField) {
				String fieldId = fieldItem.getFieldId();
				list = PmlFileTypeUtil.findByFieldId(fieldId);
				retValue.addAll(list);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by departmentId and fileTypeId
	 * @param departmentId
	 * @param fileTypeId
	 * @return List<PmlOneDoorReceiveFile>
	 */
	public List<PmlOneDoorReceiveFile> getListFileBy_DepartmentId_FileTypeId (String departmentId, String fileTypeId) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> list = null;
		
		if (departmentId == null || fileTypeId == null) {
			return retValue;
		}
		
		List<PmlFileType> listFileType = getListFileTypeByDepartmentId(departmentId);
		if (listFileType != null && listFileType.size() > 0) {
			for (PmlFileType pmlFileType : listFileType) {
				String filetypeID = pmlFileType.getFileTypeId();
				if (filetypeID.equals(fileTypeId)) {
					try {
						list = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
						retValue.addAll(list);
					}
					catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return retValue;
	}
	
//	public static void main(String[] args) {
//
//		List<String> ret =  new ArrayList<String>();
//		List<String> l1 = new ArrayList<String>();
//		List<String> l2 = new ArrayList<String>();
//		String a = "a";	String b = "b";	String c = "c";	String d = "d";	String e = "e";
//		String f = "f";	String g = "g";	String h = "h";	String i = "i";	String k = "k";
//		String l = "l";	String m = "m";
//		l1.add(a); l1.add(b); l1.add(c); l1.add(d); l1.add(e); l1.add(f);
//		l2.add(a); l2.add(b); l2.add(c); l2.add(h); l2.add(i); l2.add(k); l2.add(l); l2.add(m); l2.add(g);
//		l2.retainAll(l1);
//		for (String it : l2) {
//			ret.add(it);
//		}
//		System.out.println(ret);
//	}
	/**
	 * Yenlt 26/02/2010
	 * getListFileChuaNhanChuaHoanThanh
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, start, end, obc);
	}
	
	/**
	 * Yenlt 26/02/2010
	 * getListFileDaNhanChuaHoanThanh
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileDaNhanChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileDaNhanChuaHoanThanh(userId, typeList, valueTypeList, start, end, obc);
	}
	
	/**
	 * Yenlt 26/02/2010
	 * getListFileQuaHanISOChuaHoanThanh
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, start, end, obc);
	}
	
	/**
	 * Yenlt 26/02/2010
	 * getListFileChoBoSungChuaHoanThanh
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, start, end, obc);
	}
	
	/**
	 * Yenlt 26/02/2010
	 * getListFileCanXuLy
	 */
	//yenlt update 02/04/2010
	public List<PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc)throws Exception {
		return pmlOneDoorReceiveFileFinder.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, start, end, obc);
	}
	// YENLT 24052010 FILE UY QUYEN
	public List<PmlOneDoorReceiveFile> getListFileNeedProcess(long userId, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileNeedProcess(userId,  typeList, valueTypeList, start, end, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	
	}
	public List<PmlOneDoorReceiveFile> getListFileDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileDelegated(userId,  typeList, valueTypeList, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
		
	}
	
	public List<PmlOneDoorReceiveFile> getListFileIsDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) {
		try {
			return pmlOneDoorReceiveFileFinder.getListFileIsDelegated(userId,  typeList, valueTypeList, obc);
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
		
	}
	/**
	 * BAO CAO HO SO THANG LUY KE -- 11/05/2010 -- YEN
	 */
	public List<PmlOneDoorReceiveFile> getListTonDauKyThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListTonDauKyThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListHSNhanTrongThangThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListHSNhanTrongThangThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	public List<PmlOneDoorReceiveFile> getListTongHSNhanThangLuyKe(String departmentId, List<Long> userIds,String fileTypeId, String fromDate, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListTongHSNhanThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	public List<PmlOneDoorReceiveFile> getListHSNhanTrongNamThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListHSNhanTrongNamThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListHSGiaiQuyetTrongThangLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongNamLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String fromDate, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListHSGiaiQuyetTrongNamLuyKe(departmentId, userIds, fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListHSTonDenNgayBCThangLuyKe(String departmentId, List<Long> userIds, String fileTypeId, String toDate,List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getListHSTonDenNgayBCThangLuyKe(departmentId, userIds, fileTypeId, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	
	/**
	 * THU LY HO SO CAP PHONG - THU LY HO SO CAP SO - YEN - 11-05-2010
	 */
	// TON TRUOC
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoTonTruoc(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoTonTruoc(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// DA NHAN
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoDaNhan(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoDaNhan(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}	
	}
	// CHUA NHAN 
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoChuaNhan(List<Long> userIds, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoChuaNhan(userIds, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}	
	}
	// TU GIAI QUYET
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoTuGiaiQuyet(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoTuGiaiQuyet(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// NGUOI KHAC THU LY THAY
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoNguoiKhacThuLyThay(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoNguoiKhacThuLyThay(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// TRONG HAN ISO
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoTonTrongHanISO(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoTonTrongHanISO(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// QUA HAN ISO
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoTonQuaHanISO(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoTonQuaHanISO(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// SO LUONG HO SO GIAI QUYET 
	public List<PmlOneDoorReceiveFile> getSoLuongHoSoGiaiQuyet(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHoSoGiaiQuyet(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// TONG HO SO TON DONG
	public List<PmlOneDoorReceiveFile> getSoLuongTongHoSoTonISO(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongTongHoSoTonISO(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// TONG HS CAN XU LY
	public List<PmlOneDoorReceiveFile> getSoLuongTongHoSoCanXuLy(List<Long> userIds, String toDay, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongTongHoSoCanXuLy(userIds, toDay, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	/**
	 *  BAO CAO HO SO THANG -- YEN --- 13/05/2010
	 */
	// TON DAU KY - BC THANG
	public List<PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(List<PmlFileType> fileTypeList, String fromDate, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHSTonBCThang(fileTypeList, fromDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	//HS NHAN TRONG THANG - BC THANG 
	public List<PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongHSNhanTrongThang(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// TONG = TON DAU KY + HS NHAN TRONG THANG
	public List<PmlOneDoorReceiveFile> getSoLuongTongHS(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoLuongTongHS(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// SO DUNG HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoHSHoanThanhDungHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// SO HS HOAN THANH TRE HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoHSHoanThanhTreHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// SO HS DANG THU LY TRONG HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoHSDangThuLyDungHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	// SO HS DANG THU LY TRE HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoHSDangThuLyTreHan(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
		
	}
	// SO HS CHO BO SUNG -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSChoBoSung(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		try {
			return pmlOneDoorReceiveFileFinder.getSoHSChoBoSung(fileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc);
		} catch (Exception e) {
			return new ArrayList<PmlOneDoorReceiveFile>();
		}
	}
	/**
	 * yenlt 16/10/2010
	 * danh sach ho so da xu ly 
	 */
	public List<PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(long userId, int year, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList, start, end, obc);
	}
	
	public int getGeneralNumberReceipt(
			String ddmmyyyyReceiveDate) 
	throws SystemException {
		
		try {
			return pmlOneDoorReceiveFileFinder.getGeneralNumberReceipt(
					ddmmyyyyReceiveDate);
		}
		catch (Exception ex) {
			return -1;
		}
	}
	/**
	 *  YENLT 16/10/2010 ONEDOOR RETURN
	 */
	public List<PmlOneDoorReceiveFile> findByPMLFILERETURN (List<String> fileTypeIds, int year, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.findByPMLFILERETURN(fileTypeIds, year, typeList, valueTypeList, start, end, obc);
	}
	
	public List<PmlOneDoorReceiveFile> onedoorSearch(String numberreceipt, String filename, String applicantname,
			String permanentaddress, String telephone, String filetypeid, String tuNgayTiepNhan,
			String denNgayTiepNhan, String tuNgayHenTra, String denNgayHenTra, 
			String tuNgayHSHoanThanh, String denNgayHSHoanThanh, String tuNgayHSTraThuc, String denNgayHSTraThuc, 
			int start, int end, OrderByComparator obc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.onedoorSearch(numberreceipt, filename, applicantname, permanentaddress, telephone, filetypeid, tuNgayTiepNhan, denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh, denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, start, end, obc);
	}
	
	public int onedoorSearchCount(String numberreceipt, String filename, String applicantname,
			String permanentaddress, String telephone, String filetypeid, String tuNgayTiepNhan,
			String denNgayTiepNhan, String tuNgayHenTra, String denNgayHenTra, 
			String tuNgayHSHoanThanh, String denNgayHSHoanThanh, String tuNgayHSTraThuc, String denNgayHSTraThuc) throws SystemException {
		return pmlOneDoorReceiveFileFinder.onedoorSearchCount(numberreceipt, filename, applicantname, permanentaddress, telephone, filetypeid, tuNgayTiepNhan, denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh, denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc);
	}
	
	/**
	 * HOME_REPORT_ONEDOOR
	 * phmphuc them 18/10/2010
	 */
	// TON THANG TRUOC
	public int countSoLuongHoSoTonTruoc(List<Long> userIds, String fromDate, String toDate) throws SystemException {
		return pmlOneDoorReceiveFileFinder.countSoLuongHoSoTonTruoc(userIds, fromDate, toDate);
	}
	
	// NHAN TRONG THANG
	public int countSoLuongHoSoNhanTrongThang(List<Long> userIds, String fromDate, String toDate) throws SystemException {
		return pmlOneDoorReceiveFileFinder.countSoLuongHoSoNhanTrongThang(userIds, fromDate, toDate);
	}
	
	// DA XU LY
	public int countSoLuongHoSoDaXuLy(List<Long> userIds, String fromDate, String toDate) throws SystemException {
		return pmlOneDoorReceiveFileFinder.countSoLuongHoSoDaXuLy(userIds, fromDate, toDate);
	}
	
	// CON TON
	public int countSoLuongHoSoConTon(List<Long> userIds, String fromDate, String toDate) throws SystemException {
		return pmlOneDoorReceiveFileFinder.countSoLuongHoSoConTon(userIds, fromDate, toDate);
	}
	
}
