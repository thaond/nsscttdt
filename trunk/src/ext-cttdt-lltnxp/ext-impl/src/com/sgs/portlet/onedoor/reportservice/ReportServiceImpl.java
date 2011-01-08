package com.sgs.portlet.onedoor.reportservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlFileAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class ReportServiceImpl {
	private final static Logger log = Logger.getLogger(ReportServiceImpl.class);  
	
	/**
	 * get all Pml_Field: (lay tat ca linh vuc)
	 * @return List<PmlField>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	public List<PmlField> getAllPmlField() {
		List<PmlField> pmlFieldList = null;
		try {
			pmlFieldList = PmlFieldUtil.findAll();
			
			if (pmlFieldList == null) {
				return new ArrayList<PmlField>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getAllPmlField(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlFieldList;
	}
	
	/**
	 * get all Pml_FileType with a Pml_Field: (lay tat ca loai ho so tuong ung voi mot linh vuc cu the)
	 * @param fieldId
	 * @return List<PmlFileType>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	
	public List<PmlFileType> getListPmlFileType_With_PmlField(String fieldId) {
		List<PmlFileType> pmlFileTypeList = null;
		
		try{
			pmlFileTypeList = PmlFileTypeUtil.findByFieldId(fieldId);
			
			if (pmlFileTypeList == null) {
				pmlFileTypeList = new ArrayList<PmlFileType>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlFileType_With_PmlField(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		
		return pmlFileTypeList;
		
	}
	
	/**
	 * get all Pml_File with a Pml_Field
	 * @param fileId
	 * @return List<PmlWfOnedoorProcess>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListPmlOneDoorReceiveFile_With_PmlFileType(String fileTypeId) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		try {
			pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId); 
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlOneDoorReceiveFile_With_PmlFileType in class ReportServiceImpl");
			e.printStackTrace();
		}
		
		
		return pmlOneDoorReceiveFileList;
	}
	
	/**
	 * get all Pml_File (lay tat ca ho so)
	 * @return
	 * List<PmlOneDoorReceiveFile>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListPmlOneDoorReceiveFile() {
		List<PmlOneDoorReceiveFile> pmlWfOnedoorProcessList = new ArrayList<PmlOneDoorReceiveFile>();
		try {
			pmlWfOnedoorProcessList = PmlOneDoorReceiveFileUtil.findAll();
			if (pmlWfOnedoorProcessList == null) {
				pmlWfOnedoorProcessList = new ArrayList<PmlOneDoorReceiveFile>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlWfOnedoorProcess(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlWfOnedoorProcessList;
	}
	
	/**
	 * get all Pml_OneDoorReceiveFile (File) with concrete department (lay tat ca ho so voi phong cu the)
	 * @param departmentId
	 * @return
	 * List<PmlOneDoorReceiveFile>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	
	public List<PmlOneDoorReceiveFile> getListPmlOneDoorReceiveFile_with_DepartmentId(String departmentId) {
		List<PmlOneDoorReceiveFile> pmlWfOnedoorProcessList = new ArrayList<PmlOneDoorReceiveFile>();
		try {
			pmlWfOnedoorProcessList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_DepartmentId(departmentId);
			if (pmlWfOnedoorProcessList == null) {
				pmlWfOnedoorProcessList = new ArrayList<PmlOneDoorReceiveFile>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlOneDoorReceiveFile_with_DepartmentId(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlWfOnedoorProcessList;
	}
	
	
	/**
	 * get all PmlOneDoorReceiveFile with fileTypeId , fromDate, toDate (lay tat ca ho so voi loai file, ngay bat dau va ngay ket thuc cu the)
	 * @param fileTypeId
	 * @param fromDate
	 * @param toDate
	 * @return
	 * List<PmlOneDoorReceiveFile>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListPmlOneDoorReceiveFile_With_PmlFileType(String fileTypeId, Date fromDate, Date toDate) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = null;
		try {
			pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileBy_fileTypeId_startDate_endDate(fileTypeId, fromDate, toDate);
			if (pmlOneDoorReceiveFileList == null) {
				pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
			} 
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlOneDoorReceiveFile_With_PmlFileType(...) in class ReportServiceImpl");
		}
		return pmlOneDoorReceiveFileList;
	}
	
	
	/**
	 * get all Pml_User with  concrete Pml_Field (lay tat ca Pml_User voi fieldId cu the )
	 * @param fieldId
	 * @return
	 * List<PmlUser>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlUser> getAllPmlUser_With_FieldId(String fieldId) {
		List<PmlUser> pmlUserList = null;
		try {
			pmlUserList = PmlUserLocalServiceUtil.getListUserByFieldId(fieldId);
			if(pmlUserList == null) {
				pmlUserList = new ArrayList<PmlUser>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getAllPmlUser_With_FieldId(...) in class ReportServiceImpl");
		}
		return pmlUserList;
	}
	
	
	/**
	 * get all Pml_FileType with concrete user (lay tat ca loai ho so voi user cu the)  
	 * @param userId
	 * @return
	 * List<PmlFileType>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlFileType> getListFileType_With_PmlUserId(long userId) {
		List<PmlFileType> pmlfileTypeList = null;
		try {
			pmlfileTypeList = PmlFileTypeLocalServiceUtil.getListFileTypeByUserId(userId);
		} catch (Exception e) {
			log.error("ERROR: in method getListFileType_With_PmlUserId(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlfileTypeList; 
	}
	
	/**
	 * get all PmlOneDoorReceiveFile [fromDate <= ExactReturnDate <= toDate] (lay tat ca cac ho so co ngay tra thuc tu fromDate va toDate)
	 * @param fromDate
	 * @param toDate
	 * @return
	 * List<PmlOneDoorReceiveFile>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListFileBy_ExactReturning(Date fromDate, Date toDate) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = null;
		try {
			pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileByExactReturningFile(fromDate, toDate);
			if (pmlOneDoorReceiveFileList == null ) {
				pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListPmlOneDoorReceiveFile(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		
	}
	
	/**
	 * get all Pml_ProcessDispose with PmlFileType
	 * @param fieldId
	 * @param fileId
	 * @return List<PmlProcessDispose>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	
	public List<PmlProcessDispose> getPmlProcessDispose(String fileTypeId) {
		List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
		
		try {
			pmlProcessDisposeList =  PmlStateProcessLocalServiceUtil.getListStateProcessByFileType(fileTypeId);
			
		} catch (Exception e) {
			log.error("ERROR: in method getPmlProcessDispose() in class ReportServiceImpl");
			e.printStackTrace();
		}
		
		return pmlProcessDisposeList;
		
	}
	
	/**
	 * get PmlProcessDispose in table Pml_ProcessDispose
	 * @param fileTypeId
	 * @param fromDate
	 * @param toDate
	 * @param sateId
	 * @return List<PmlProcessDispose>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.workflow
	 *
	 */
	
	public List<PmlProcessDispose> getPmlProcessDispose(String fileTypeId, Date fromDate, Date toDate, long stateId) {
		List<PmlProcessDispose> pmlProcessDisposeListResult = new ArrayList<PmlProcessDispose>();
		try {
			List<PmlProcessDispose> pmlProcessDisposeList = PmlProcessDisposeUtil.findAll();
			if (pmlProcessDisposeList == null) {
				return pmlProcessDisposeListResult;
			}
			
			
			else if (toDate == null ||  fromDate == null) {
					for (Iterator<PmlProcessDispose> iterator = pmlProcessDisposeList.iterator(); iterator.hasNext();) {
						PmlProcessDispose pmlProcessDispose = iterator.next();
						if (pmlProcessDispose.getStateProcessIdBefore() == stateId) {	
							PmlOneDoorReceiveFile pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
							if (pmlOneDoorReceiveFile.getFileTypeId().equalsIgnoreCase(fileTypeId)) {
								pmlProcessDisposeListResult.add(pmlProcessDispose);
							}
						}
					}
			}
			
			else {
				for (Iterator<PmlProcessDispose> iterator = pmlProcessDisposeList.iterator(); iterator.hasNext();) {
					PmlProcessDispose pmlProcessDispose = iterator.next();
					
					 if (pmlProcessDispose.getReceiveDate().after(fromDate) && pmlProcessDispose.getReceiveDate().before(toDate) 
							&& pmlProcessDispose.getStateProcessIdBefore() == stateId) {
						PmlOneDoorReceiveFile pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
						if (pmlOneDoorReceiveFile.getFileTypeId().equalsIgnoreCase(fileTypeId)) {
							pmlProcessDisposeListResult.add(pmlProcessDispose);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR: in method getPmlProcessDispose(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlProcessDisposeListResult;
		
	}

////////////////////3
	/**
	 * get PmlOnedoorProcess no return
	 * @param fileTypeId
	 * @param fromDate
	 * @param toDate
	 * @param sateId
	 * @return
	 * List<PmlProcessDispose>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<PmlOneDoorReceiveFile> getPmlOneDoorReceiveFileNoReturn(String fileTypeId, Date fromDate, Date toDate, long stateId) {
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		
			
		return pmlOneDoorReceiveFileList;
		
	}
	
////////////////////////////////4	
	/**
	 * check PmlWfOnedoorProcess has over time?
	 * @param fileId
	 * @return boolean
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public boolean getPmlWfOnedoorProcessOverTime(String fileId) {
		boolean result = false; 
		try {
			
			PmlOneDoorReceiveFile pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
			result = PmlStateProcessLocalServiceUtil.getPmlOneDoorReceiveFileOverTime(pmlOneDoorReceiveFile);
			
		} catch (Exception e) {
			log.error("ERROR in method getPmlWfOnedoorProcessOverTime in class ");
			e.printStackTrace();
		}		
		return result;
		
	}
	
	/**
	 * check PmlWfOnedoorProcess has over time?
	 * @param pmlWfOnedoorProcess
	 * @return boolean
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public boolean getPmlOneDoorReceiveFileOverTime(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) {
		boolean result = false;
		try {	
			result = PmlStateProcessLocalServiceUtil.getPmlOneDoorReceiveFileOverTime(pmlOneDoorReceiveFile);
		} catch (Exception e) {
			log.error("ERROR: in method getPmlOneDoorReceiveFileOverTime() in class ");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return PmlProcessDispose
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public PmlProcessDispose getPmlProcessDisposeOverTime(String fileTypeId, String fileId, Date fromDate, Date toDate) {
		PmlProcessDispose  pmlProcessDispose = null;
		try {
			  pmlProcessDispose =	PmlStateProcessLocalServiceUtil.getFileOverTime(fileId, fileTypeId, fromDate, toDate);
		} catch (Exception e) {
			log.error("ERROR: in method getPmlProcessDisposeOverTime in class reportserviceImpl");
			e.printStackTrace();
		}
		
		return pmlProcessDispose;
		
	} 
	
	///////////////////////////////5
	
	
	public List<PmlStateProcess> getAllPmlStateProcess(String fileTypeId) {
		List<PmlStateProcess> pmlStateProcessList = new ArrayList<PmlStateProcess>();
		try {
			pmlStateProcessList = PmlStateProcessLocalServiceUtil.getListStateProcess(fileTypeId);
		} catch (Exception e) {
			log.error("");
			e.printStackTrace();
		}
		return pmlStateProcessList;
		
	}
	
	/**
	 * get all PmlDepartment with  concrete Pml_fileType (lay tat ca phong ban ung voi mot loai ho so)
	 * @param fileTypeId
	 * @return 
	 * List<PmlDepartment>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.reportservice
	 *
	 */
	public List<Department> getListDepartment(String fileTypeId) {
		List<Department> pmlDepartmentList = null;
		try {
			pmlDepartmentList = PmlStateProcessLocalServiceUtil.getListDepartmentByFileTypeId(fileTypeId);
			if (pmlDepartmentList == null) {
				pmlDepartmentList = new ArrayList<Department>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListDepartment(...) in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlDepartmentList;
		
	}
	
	/**
	 * count all pml_file has a concrete state (dem so luong ho so voi tung tinh trang cu the) 
	 * @param fileTypeId
	 * @param stateId
	 * @return
	 * int
	 * Apr 3, 2009
	 * com.sgs.portlet.onedoor.reportservice
	 *
	 */
	
	public int getFileWithStateSolveOfDepartment( String fileTypeId, long stateId){
		int count = 0;
		
		try {
			count = PmlStateProcessLocalServiceUtil.counterFileByState(fileTypeId, stateId);
		} catch (Exception e) {
			log.error("ERROR in method getFileWithStateSolveOfDepartment(..) in class ReportServiceImp");
			e.printStackTrace();
		}
		
		return count;
	}
	/**
	 * count all pml_file with concrete status (dem so luong ho so ung voi tung trang thai cu the cua mot phong )
	 * @param departmentId
	 * @param statusId
	 * @return
	 * int
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.reportservice
	 *
	 */
	public int getFileWithStatusSolveOfDepartment( String departmentId, long statusId, Date startDate, Date endDate) {
		int count = 0;
		try {
			count = PmlStateProcessLocalServiceUtil.countFileByState(departmentId, statusId, startDate, endDate);
		} catch (Exception e) {
			log.error("ERROR in method getFileWithStatusSolveOfDepartment(..) in class ReportServiceImp");
			e.printStackTrace();
		}
		return count;
	}
	
	
	/**
	 * get all Department
	 * @return
	 * List<PmlDepartment>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.report
	 *
	 */
	public List<Department> getListDepartment() {
		List<Department> pmlDepartmentList = null;
		try {
			pmlDepartmentList = DepartmentUtil.findAll();
			if (pmlDepartmentList == null) {
				pmlDepartmentList = new ArrayList<Department>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getListDepartment() in class ReportServiceImpl");
			e.printStackTrace();
		}
		
		return pmlDepartmentList;
	}
	
	////////////////////////////6 su dung lai nhung phuong thuc o tren
	
	/**
	 * get all Pml_StateProcess (lay tat ca tinh trang xu ly)
	 * @param fileTypeId
	 * @return 
	 * List<PmlDepartment>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.reportservice
	 *
	 */
	public List<PmlStateProcess> getAllPmlStateProcess() {
		List<PmlStateProcess> pmlStateProcessList = null;
		try{
			pmlStateProcessList = PmlStateProcessUtil.findAll();
			if (pmlStateProcessList == null) {
				pmlStateProcessList = new ArrayList<PmlStateProcess>();
			}
		}catch (Exception e) {
			log.error("ERROR: in method getAllPmlStateProcess in class ReportServiceImpl");
			e.printStackTrace();
		}
		return pmlStateProcessList;
	}
	//////////////////////////////////////////////////
	
	
	/**
	 * get all PmlFileAttachedFile with  concrete Pml_file (lay tat ca file dinh kem ung voi mot ho so cu the)
	 * @param fileTypeId
	 * @return 
	 * List<PmlDepartment>
	 * Apr 2, 2009
	 * com.sgs.portlet.onedoor.reportservice
	 *
	 */
	
	public List<PmlFileAttachedFile> getPmlFileAttachedFile_With_FileId (String fileId) {
		List<PmlFileAttachedFile> pmlFileAttachedFileList = null;
		try {
			pmlFileAttachedFileList = PmlFileAttachedFileUtil.findByFileId(fileId);
			if (pmlFileAttachedFileList == null) {
				pmlFileAttachedFileList = new ArrayList<PmlFileAttachedFile>();
			}
		} catch (Exception e) {
			log.error("ERROR: in method getPmlFileAttachedFile_With_FileId(...) in class ReportServiceImpl");
		}
		
		return pmlFileAttachedFileList;
	}
	
	/**
	 * 
	 */
}
