package com.sgs.portlet.department.service.impl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.department.DepartmentCanNotDeleteException;
import com.sgs.portlet.department.DepartmentCodeSameCodeException;
import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.base.DepartmentLocalServiceBaseImpl;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.NoSuchPmlFileTypeException;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;


public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	
	/**
	 * Get all department
	 * @return The list of all department
	 * @throws SystemException
	 */
	public List<Department> findAll() 
	throws SystemException {
	
		try {
			return departmentPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
//	minh 20100204
	
	public int searchCount(String keywords) throws SystemException{
		return departmentFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String pmlDepartmentCode, String pmlDepartmentName, String pmlDepartmentAbbreviateName, boolean andOperator) throws SystemException{
		return departmentFinder.countByPmlDepartment(pmlDepartmentCode, pmlDepartmentName, pmlDepartmentAbbreviateName, andOperator);
	}
	
	public List<Department> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Department> search(String pmlDepartmentCode, String pmlDepartmentName, String pmlDepartmentAbbreviateName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findByPmlDepartment(pmlDepartmentCode, pmlDepartmentName, pmlDepartmentAbbreviateName, andOperator, start, end, obc);
	}
	
//  end	
	//yenlt 05/04/2010
	
	public List<Department> findDepartments(String departmentsId, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findDepartments(departmentsId, start, end, obc);
	}
	
	public int countDepartments(String departmentsId) throws SystemException{
		return departmentFinder.countDepartments(departmentsId);
	}
	//end
	
	// lay danh sach phong ban
	public List<Department> findDepartmentsByDepartmentParentId() throws SystemException{
		return departmentFinder.findDepartmentsByDepartmentParentId();
	}
	
	/**
	 * get PmlDepartment object by departmentCode
	 * @param departmentCode
	 * @return PmlDepartment object
	 * 
	 */
	public Department getDepartmentByCode(String departmentCode){
		Department pmlDepartment = null;
		try {
			if (departmentCode == null) {
				return pmlDepartment;
			}
			pmlDepartment = DepartmentUtil.findByDepartmentsCode(departmentCode).get(0);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return pmlDepartment;
	}
	
	/**
	 * Lay ds loai ho so da xu ly boi phong nao
	 * - Tao List<PmlFileType> retValue = new ArrayList<PmlFileType>()
	 * - Lay ds PmlProcessDispose : listProcessDispose = PmlProcessDisposeUtil.findAll()
	 * - Duyet listProcessDispose, lay ds processer : listProcesser
	 * - Lay ds PmlDepartment theo listProcesser : listDepartment
	 * - Duyet listDepartment, lay departmentIdFromList
	 * - Neu departmentIdFromList == departmentId thi lay ds user theo departmentId : listUser
	 * - Tao List<PmlProcessDispose> listProcessDispose1 = new ArrayList<PmlProcessDispose>()
	 * - Duyet listUser, lay ds PmlProcessDispose theo processer
	 * 	 listProcessDispose1 = PmlProcessDisposeUtil.findByProcesser(list[i])
	 * - Duyet listProcessDispose1, lay ds fileId : listFileId
	 * - Lay ds PmlFile theo listFileId : listFile
	 * - Tu listFile lay ds fileTypeId : listFileTypeId
	 * - Lay PmlFileType theo listFileTypeId sau do add vao retValue
	 * 
	 * 
	 * @param departmentId
	 * @return
	 */
	public List<PmlFileType> getListFileTypeByDepartment(String departmentId, Date date) {
		
		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		
		if (departmentId == null) {
			return retValue;
		}
		
		retValue = getListFileTypeByListFile(departmentId, date);
		
		return retValue;
	}

	/**
	 * @param departmentId
	 * @return
	 */
	private List<PmlFileType> getListFileTypeByListFile(String departmentId, Date date) {
		
		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		
		if (departmentId == null) {
			return retValue;
		}
		
		List<PmlOneDoorReceiveFile> listFile = getListFileByListProcessDispose(departmentId, date);

		for (PmlOneDoorReceiveFile item : listFile) {
			String fileTypeId = item.getFileTypeId();
			if (fileTypeId != null) {
				PmlFileType pmlFileType = null;
				try {
					pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
				}
				catch (NoSuchPmlFileTypeException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
				
				if (retValue.contains(pmlFileType)) {
					continue;
				}
				retValue.add(pmlFileType);
			}
		}
		
		return retValue;
	}

	/**
	 * @param departmentId
	 * @return
	 */
	private List<PmlOneDoorReceiveFile> getListFileByListProcessDispose(String departmentId, Date date) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (departmentId == null || date == null) {
			return retValue;
		}

		List<PmlProcessDispose> listProcessDispose = new ArrayList<PmlProcessDispose>();
		try {
			listProcessDispose = getListProcessDisposeByListUser(departmentId);
		} catch (Exception e) {
		}
			
		
		if (listProcessDispose != null && listProcessDispose.size() > 0) {
			for (PmlProcessDispose item : listProcessDispose) {
				String fileId = item.getFileId();
				if (fileId != null) {
					PmlOneDoorReceiveFile oneDoorReceiveFile = null;
					try {
						oneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
						
						Date applicationDate = oneDoorReceiveFile.getApplicationDate();
						Date applicationDateCompare = null;
						Date dateCompare = null;
						
						if (applicationDate != null) {
							applicationDateCompare = df.parse(sdf.format(applicationDate));
							dateCompare = df.parse(sdf.format(date));
							if (applicationDateCompare.before(dateCompare) || applicationDateCompare.equals(dateCompare)) {
								if (retValue.contains(oneDoorReceiveFile)) {
									continue;
								}
								retValue.add(oneDoorReceiveFile);
							}
						}
					}catch (NoSuchPmlOneDoorReceiveFileException e) {
						e.printStackTrace();
					}catch (SystemException e) {
						e.printStackTrace();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return retValue;
		
		//end
		
		/* yenlt close start 25/03/2010
		 * 
		List<PmlFileType> listFileType = getListFileTypeByDepartment(departmentId, date);
		if (listFileType != null && listFileType.size() > 0) {
			for (PmlFileType pmlFileType : listFileType) {
				String fileTypeIdFromList = pmlFileType.getFileTypeId();
				
				if (fileTypeIdFromList != null) {
					if (fileTypeIdFromList.equalsIgnoreCase(fileTypeId)) {
						try {
							retValue = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeIdFromList);
						}
						catch (SystemException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return retValue;
		yenlt close end */
	}

	/**
	 * @param departmentId
	 * @return
	 */
	private List<PmlProcessDispose> getListProcessDisposeByListUser(String departmentId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		if (departmentId == null) {
			return retValue;
		}
		// yenlt update 25/03/2010
		// Lay ds user theo departmentId
		List<PmlUser> listUser = new ArrayList<PmlUser>();
		try {
			listUser = PmlUserUtil.findByDepartmentsId(departmentId);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlProcessDispose> list = null;		
		for (PmlUser item : listUser) {
			long userId = item.getUserId();
			if (userId != 0) {
				try {
					list = PmlProcessDisposeUtil.findByProcesser(userId);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
				retValue.addAll(list);
			}
		}
		
		return retValue;
		//end
		
		/* yenlt close start 25/03/2010
		List<PmlDepartment> listDepartment = new ArrayList<PmlDepartment>();
		try {
			listDepartment = getListDepartmentByListProcesser();
		} catch (Exception e) {
		}
		
		if (listDepartment != null && listDepartment.size() > 0) {
			for (PmlDepartment pmlDepartment : listDepartment) {
				String departmentIdFromList = pmlDepartment.getDepartmentsId();
				
				if (departmentIdFromList != null) {
					if (departmentIdFromList.equalsIgnoreCase(departmentId)) {
						// Lay ds user theo departmentId
						List<PmlUser> listUser = new ArrayList<PmlUser>();
						try {
							listUser = PmlUserUtil.findByDepartmentsId(departmentId);
						}
						catch (SystemException e) {
							e.printStackTrace();
						}
						
						List<PmlProcessDispose> list = null;
						for (PmlUser item : listUser) {
							long userId = item.getUserId();
							if (userId != 0) {
								try {
									list = PmlProcessDisposeUtil.findByProcesser(userId);
								}
								catch (SystemException e) {
									e.printStackTrace();
								}
								retValue.addAll(list);
							}
						}
					}
				}
			}
		}
		yenlt close end */
	}

	/**
	 * @return
	 */
	private List<Department> getListDepartmentByListProcesser() {
		
		List<Department> retValue = new ArrayList<Department>();

		List<PmlProcessDispose> listProcessDispose = new ArrayList<PmlProcessDispose>();
		try {
			listProcessDispose = PmlProcessDisposeUtil.findAll();
		}
		catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		// get list PmlUser by listProcessDispose
		List<PmlUser> listProcesser = getListProcesser(listProcessDispose);
		
		for (PmlUser pmlUser : listProcesser) {
			if (pmlUser.getDepartmentsId() != null) {
				try {
					Department pmlDepartment = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
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
	 * @param listProcessDispose
	 * @return
	 */
	private List<PmlUser> getListProcesser(List<PmlProcessDispose> listProcessDispose) {
		
		List<PmlUser> retValue = new ArrayList<PmlUser>();
		
		if (listProcessDispose == null) {
			return retValue;
		}

		for (PmlProcessDispose pmlProcessDispose : listProcessDispose) {
			long processer = pmlProcessDispose.getProcesser();
			
			if (processer != 0) {
				// Lay ds processer
				try {
					PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(processer);
					if (retValue.contains(pmlUser)) {
						continue;
					}
					retValue.add(pmlUser);
				}
				catch (NoSuchPmlUserException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	public List<PmlOneDoorReceiveFile> getListFileByDepartment_FileType(String departmentId, String fileTypeId, Date date) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (departmentId == null || fileTypeId == null) {
			return retValue;
		}
		
//yenlt update 25/03/2010
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		List<PmlProcessDispose> listProcessDispose = new ArrayList<PmlProcessDispose>();
		try {
			listProcessDispose = getListProcessDisposeByListUser(departmentId);
			
		} catch (Exception e) {
		}
			
		if (listProcessDispose != null && listProcessDispose.size() > 0) {			
			for (PmlProcessDispose item : listProcessDispose) {				
				String fileId = item.getFileId();
				List<PmlProcessDispose> pmlProcessDisposeListTemp = new ArrayList<PmlProcessDispose>();
				try {
					pmlProcessDisposeListTemp = PmlProcessDisposeUtil.findByFileId(fileId);
					PmlProcessDispose pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, pmlProcessDisposeListTemp.size()).get(0);
					PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(pmlProcessDispose.getProcesser());
					if (!departmentId.equals(pmlUser.getDepartmentsId() )) {
						continue;
					}
				} catch (Exception e) {}			
				
				
				if (fileId != null) {
					PmlOneDoorReceiveFile oneDoorReceiveFile = null;
					try {
						oneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
						
						String fileTypeReceiveFile = oneDoorReceiveFile.getFileTypeId();
						
						if (fileTypeReceiveFile.equalsIgnoreCase(fileTypeId) ) {
							Date applicationDate = oneDoorReceiveFile.getApplicationDate();
							Date applicationDateCompare = null;
							Date dateCompare = null;
							
							if (applicationDate != null) {
								applicationDateCompare = df.parse(sdf.format(applicationDate));
								dateCompare = df.parse(sdf.format(date));
								if (applicationDateCompare.before(dateCompare) || applicationDateCompare.equals(dateCompare)) {
									if (retValue.contains(oneDoorReceiveFile)) {
										continue;
									}
									retValue.add(oneDoorReceiveFile);
								}
							}
							
						}
					}catch (NoSuchPmlOneDoorReceiveFileException e) {
						e.printStackTrace();
					}catch (SystemException e) {
						e.printStackTrace();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return retValue;
		
		//end
		
		/* yenlt close start 26/03/2010
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (departmentId == null || fileTypeId == null) {
			return retValue;
		}
		
		List<PmlFileType> listFileType = getListFileTypeByDepartment(departmentId, date);
		
		if (listFileType != null && listFileType.size() > 0) {
			for (PmlFileType pmlFileType : listFileType) {
				String fileTypeIdFromList = pmlFileType.getFileTypeId();
				
				if (fileTypeIdFromList != null) {
					if (fileTypeIdFromList.equalsIgnoreCase(fileTypeId)) {
						try {
							retValue = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeIdFromList);
						}
						catch (SystemException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return retValue;
		yenlt close end */
	}

	/**
	 * @author phmphuc
	 * lay danh sach hien thi theo departmentId
	 */
	public List<Department> findDepartmentsByDepartmentParentId(int start, int end) throws SystemException{
		return departmentFinder.findDepartmentsByDepartmentParentId(start, end);
	}
	
	public int countTinhHinhThuLyCongVanPhongBan() throws Exception {
		return departmentFinder.countTinhHinhThuLyCongVanPhongBan();
	}
	// yenlt update 24082010
	protected void validateDepartment(int departmentLeaderSize, int fieldSize, int pmlUserSize)
	throws PortalException, SystemException {
	
		if (departmentLeaderSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
		if (fieldSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
		if (pmlUserSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
	}
	
	public void removeDepartment(String departmentId) throws SystemException, PortalException {
		List<PmlDepartmentsLeader> departmentLeaderList = new ArrayList<PmlDepartmentsLeader>();
		List<PmlField> fieldList = new ArrayList<PmlField>();
		List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
		try {
			departmentLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentId);
			fieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
			pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
		} catch (Exception e) {
			
		}
		validateDepartment(departmentLeaderList.size(), fieldList.size(), pmlUserList.size());
		departmentPersistence.remove(departmentId);
	}
	// end yenlt 
	
	/*
	// phmphuc update 27/08/2010 - rang buoc dieu kien trung code
	public int countDepartmentByCode(String departmentsCode) throws SystemException {
		int result = 0;
		
		try {
			result = DepartmentUtil.countByDepartmentsCode(departmentsCode);
		} catch (Exception ex) {
			_log.error(ex.getMessage());
		}
		return result;
	}
	
	private static Log _log = LogFactoryUtil.getLog(DepartmentLocalServiceUtil.class);
	// phmphuc end
	*/
	
	
	/*
	 * phmphuc create 09/09/2010
	 * kiem tra ma phong ban khi them moi
	 */
	public Department addDepartment(String departmentsCode, String departmentsName, String description, 
									String active, String agencyId, String abbreviateName,
									String departmentsParentId) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(departmentsCode);
		
		String departmentId = "";
		try {
			departmentId = IdTemplateServiceUtil.generatedId(Department.class);
		} catch (RemoteException e) { }
		
		Department department = departmentPersistence.create(departmentId);
		
		// Set properties value
		department.setDepartmentsCode(departmentsCode);
		department.setDepartmentsName(departmentsName);
		department.setDescription(description);
		department.setActive(active);
		department.setActive(active);
		department.setAgencyId(agencyId);
		department.setAbbreviateName(abbreviateName);
		department.setDepartmentsParentId(departmentsParentId);
		
		departmentPersistence.update(department, false);

		return department;
	}
	
	protected void validateForAdd(String departmentsCode) throws PortalException, SystemException {
		
		if (Validator.isNull(departmentsCode)) {
			throw new DepartmentCodeSameCodeException();
		}
		
		List<Department> list = departmentFinder.findDepartmentsByCodeForValidate(departmentsCode);
		if (!list.isEmpty()) {
			departmentsCode = departmentsCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (departmentsCode.equalsIgnoreCase(list.get(idx).getDepartmentsCode().trim())) {
					throw new DepartmentCodeSameCodeException();
				}
			}
		}
	}
}
