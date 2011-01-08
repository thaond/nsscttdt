package com.sgs.portlet.document.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.service.base.PmlStateProcessLocalServiceBaseImpl;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlStateProcessLocalServiceImpl  extends PmlStateProcessLocalServiceBaseImpl {
	
	/**
	 * this method get a list of PmlStateProcess object by fileTypeId
	 * @param fileTypeId : ID cá»§a lá»�ai há»“ sÆ¡
	 * @return list of PmlStateProcess object
	 * 
	 */
	public List<PmlStateProcess> getListStateProcess (String fileTypeId) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		PmlStateProcess pmlStateProcess = null;
		List<PmlStateWorkFlow> listStateWorkflow = getListStateWorkflowByFileTypeId(fileTypeId);
		
		if (fileTypeId == null || listStateWorkflow == null) {
			return retValue;
		}
		
		for (PmlStateWorkFlow pmlStateWorkFlow : listStateWorkflow) {
			long stateProcessId = pmlStateWorkFlow.getStateProcessId();
			
			try {
				pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessId);
				retValue.add(pmlStateProcess);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return retValue;
	}
	
	/**
	 * get List<PmlStateWorkFlow> by fileTypeId
	 * @param fileTypeId
	 * @return List<PmlStateWorkFlow>
	 */
	private List<PmlStateWorkFlow> getListStateWorkflowByFileTypeId (String fileTypeId) {
		
		List<PmlStateWorkFlow> retValue = new ArrayList<PmlStateWorkFlow>();
		
		if (fileTypeId == null) {
			return retValue;
		} else {
			List<PmlWorkflow> listWorkflow = null;
			try {
				listWorkflow = PmlWorkflowUtil.findByFileTypeId(fileTypeId);
				if (listWorkflow != null && listWorkflow.size() > 0) {
					PmlWorkflow pmlWorkflow =  listWorkflow.get(0);
					String workflow = pmlWorkflow.getWorkflow();
					
					retValue = PmlStateWorkFlowUtil.findByWorkflow(workflow);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return retValue;
	}
	
	/**
	 * this method count File state by fileTypeId and stateProcessId
	 * @param fileTypeId : ID cá»§a lá»�ai há»“ sÆ¡
	 * @param stateProcessId : ID cá»§a tĂ¬nh tráº¡ng xá»­ lĂ½
	 * @return integer
	 * 
	 */
	public int counterFileByState (String fileTypeId, long stateProcessId) {
		
		int retValue = 0;
		List<PmlOneDoorReceiveFile> list = getListFileByStateProcessId_FileTypeId(stateProcessId, fileTypeId);
		
		if (fileTypeId == null || list == null || list.size() == 0) {
			return retValue;
		} else {
			retValue = getListFileByStateProcessId_FileTypeId(stateProcessId, fileTypeId).size();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by stateProcessId
	 * @param stateProcessId
	 * @return List<PmlOneDoorReceiveFile>
	 */
	private List<PmlOneDoorReceiveFile> getListFileByStateProcessId (long stateProcessId) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		PmlOneDoorReceiveFile oneDoorReceiveFile = null;
		
		List<PmlProcessDispose> listProcessDispose = getListProcessDisposeByStateProcessId(stateProcessId);
		
		if (listProcessDispose == null) {
			return retValue;
		}
		
		for (PmlProcessDispose pmlProcessDispose : listProcessDispose) {
			if (pmlProcessDispose.getFileId() != null) {
				try {
					oneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
					retValue.add(oneDoorReceiveFile);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlProcessDispose> by stateProcessId
	 * @param stateProcessId
	 * @return List<PmlProcessDispose>
	 */
	private List<PmlProcessDispose> getListProcessDisposeByStateProcessId(long stateProcessId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		try {
			retValue = PmlProcessDisposeUtil.findByStateProcessIdBefore(stateProcessId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
	/**
	 * get List<PmlOneDoorReceiveFile> by stateProcessId and fileTypeId
	 * @param stateProcessId
	 * @param fileTypeId
	 * @return List<PmlOneDoorReceiveFile>
	 */
	private List<PmlOneDoorReceiveFile> getListFileByStateProcessId_FileTypeId (long stateProcessId, String fileTypeId) {
		
		List<PmlOneDoorReceiveFile> retValue = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (fileTypeId == null) {
			return retValue;
		} else {
			try {
				List<PmlOneDoorReceiveFile> listByStateProcessId = getListFileByStateProcessId(stateProcessId);
				retValue = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
				retValue.retainAll(listByStateProcessId);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}

	/**
	 * this method count file state by departmentId, fileStatusId, startDate and endDate
	 * @param departmentId : ID cá»§a phĂ²ng ban
	 * @param fileStatusId : ID cá»§a tráº¡ng thĂ¡i há»“ sÆ¡
	 * @param startDate
	 * @param endDate
	 * @return integer
	 * 
	 */
	public int countFileByState (String departmentId, long fileStatusId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (departmentId == null || startDate == null || endDate == null) {
			return retValue;
		} else {
			retValue = getListProcessDispose(departmentId, fileStatusId, startDate, endDate).size();
		}
		
		return retValue;
	}

	/**
	 * get List<PmlStateProcess> by fileStatusId
	 * @param fileStatusId : tráº¡ng thĂ¡i há»“ sÆ¡
	 * @return List<PmlStateProcess>
	 */
	private List<PmlStateProcess> getListStateProcess(long fileStatusId) {

		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		List<PmlStateProcess> list = null;
		
		try {
			list = PmlStateProcessUtil.findByFileStatusId(fileStatusId);
			
			if (list != null) {
				retValue = list;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * get List<PmlStateProcess> by departmentId
	 * @param departmentId
	 * @return List<PmlStateProcess>
	 */
	private List<PmlStateProcess> getListStateProcessByDepartment(String departmentId) {

		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		
		if (departmentId == null) {
			return retValue;
		}
		
		List<PmlStateWorkFlow> listStateWorkflow = getListStateWorkflowByDepartmentId(departmentId);
		PmlStateProcess pmlStateProcess = null;
		
		if (listStateWorkflow != null && listStateWorkflow.size() > 0) {
			for (PmlStateWorkFlow item : listStateWorkflow) {
				try {
					pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(item.getStateProcessId());
					retValue.add(pmlStateProcess);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlStateWorkFlow> by departmentId
	 * @param departmentId
	 * @return List<PmlStateWorkFlow>
	 */
	private List<PmlStateWorkFlow> getListStateWorkflowByDepartmentId(String departmentId) {
		
		List<PmlStateWorkFlow> retValue = new ArrayList<PmlStateWorkFlow>();
		List<PmlStateWorkFlow> list = null;
		
		if (departmentId == null) {
			return retValue;
		}
		
		List<PmlWorkflow> listWorkflow = getListWorkflowByDepartmentId(departmentId);
		
		if (listWorkflow != null && listWorkflow.size() > 0) {
			for (PmlWorkflow item : listWorkflow) {
				try {
					list = PmlStateWorkFlowUtil.findByWorkflow(item.getWorkflow());
					retValue.addAll(list);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * get List<PmlWorkflow> by departmentId
	 * @param departmentId
	 * @return List<PmlWorkflow>
	 */
	private List<PmlWorkflow> getListWorkflowByDepartmentId (String departmentId) {
		
		List<PmlWorkflow> retValue = new ArrayList<PmlWorkflow>();
		
		if (departmentId == null) {
			return retValue;
		}
		
		List<PmlFileType> listFileType = getListFileTypeByDepartmentId(departmentId);
		PmlWorkflow pmlWorkflow = null;
		
		if (listFileType != null && listFileType.size() > 0) {
			for (PmlFileType item : listFileType) {
				String fileTypeId = item.getFileTypeId();
				try {
					pmlWorkflow = PmlWorkflowUtil.findByFileTypeId(fileTypeId).get(0);
					retValue.add(pmlWorkflow);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	/**
	 * get List<PmlFileType> by departmentId
	 * @param departmentId
	 * @return List<PmlFileType>
	 */
	private List<PmlFileType> getListFileTypeByDepartmentId(String departmentId) {
		
		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		List<PmlFileType> list = null;
		
		if (departmentId == null) {
			return retValue;
		}
		
		List<PmlField> listField = getListFieldByDepartmentId(departmentId);
		
		if (listField != null && listField.size() > 0) {
			for (PmlField item : listField) {
				try {
					list = PmlFileTypeUtil.findByFieldId(item.getFieldId());
					retValue.addAll(list);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}

	/**
	 * get List<PmlField> by departmentId
	 * @param departmentId
	 * @return List<PmlField>
	 */
	private List<PmlField> getListFieldByDepartmentId(String departmentId) {
		
		List<PmlField> retValue = new ArrayList<PmlField>();
		
		if (departmentId == null) {
			return retValue;
		}
		
		try {
			retValue = PmlFieldUtil.findByDepartmentsId(departmentId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return retValue;
	}

	/**
	 * get List<PmlStateProcess> by departmentId and fileStatusId
	 * @param departmentId
	 * @param fileStatusId
	 * @return List<PmlStateProcess>
	 */
	private List<PmlStateProcess> getListStateProcess(String departmentId, long fileStatusId) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		List<PmlStateProcess> list1 = getListStateProcess(fileStatusId);
		List<PmlStateProcess> list2 = getListStateProcessByDepartment(departmentId);
		
		list1.retainAll(list2);
		retValue = list1;

		return retValue;
	}
	
	/**
	 * this method get list of PmlProcessDispose object by departmentId, fileStatusId, startDate and endDate
	 * @param departmentId : ID cá»§a phĂ²ng ban
	 * @param fileStatusId : Id cá»§a tráº¡ng thĂ¡i há»“ sÆ¡
	 * @param startDate
	 * @param endDate
	 * @return list of PmlProcessDispose object
	 * 
	 */
	public List<PmlProcessDispose> getListProcessDispose (String departmentId, long fileStatusId, Date startDate, Date endDate) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> list = null;
		PmlProcessDispose pmlProcessDispose = null;
		long stateProcessId = 0;
		List<PmlStateProcess> listStateProcess = getListStateProcess(departmentId, fileStatusId);
		
		for (PmlStateProcess item : listStateProcess) {
			stateProcessId = item.getStateProcessId();
			try {
				list = PmlProcessDisposeUtil.findByStateProcessIdBefore(stateProcessId);
				for (PmlProcessDispose processDisposeItem : list) {
					Date dateProcess = processDisposeItem.getDateProcess();
					
					if (dateProcess != null) {
						if ((dateProcess.after(startDate) || startDate.equals(dateProcess)) 
										&& (dateProcess.before(endDate) || endDate.equals(dateProcess))) {
							pmlProcessDispose = processDisposeItem;
							list.add(pmlProcessDispose);
							retValue.addAll(list);
						}
					}
				}
				retValue.addAll(list);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * this method get list of PmlProcessDispose object by stateProcessId, startDate and endDate
	 * @param stateProcessId : Id cá»§a tĂ¬nh tráº¡ng xá»­ lĂ½
	 * @param startDate
	 * @param endDate
	 * @return list of PmlProcessDispose object
	 * 
	 */
	public List<PmlProcessDispose> getListProcessDisposeByStateProcess(long stateProcessId, Date startDate, Date endDate) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> list = null;
		PmlProcessDispose pmlProcessDispose = null;
		
		if (startDate == null || endDate == null) {
			try {
				return PmlProcessDisposeUtil.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			list = PmlProcessDisposeUtil.findByStateProcessIdBefore(stateProcessId);
			if (list != null) {
				for (PmlProcessDispose item : list) {
					Date dateProcess = item.getDateProcess();
					
					if (dateProcess != null) {
						if ((dateProcess.after(startDate) || startDate.equals(dateProcess)) 
										&& (dateProcess.before(endDate) || endDate.equals(dateProcess))) {
							pmlProcessDispose = item;
							retValue.add(pmlProcessDispose);
						}
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
	 * this method get list of Department object by fileTypeId
	 * @param fileTypeId : ID cá»§a lá»�ai há»“ sÆ¡
	 * @return list of Department object
	 * 
	 */
	public List<Department> getListDepartmentByFileTypeId (String fileTypeId) {
		
		List<Department> retValue = new ArrayList<Department>();
		Department department = null;
		
		if (fileTypeId == null) {
			return retValue;
		}
		
		PmlField field = null;
		PmlFileType pmlFileType = null;
		String fieldId = "";
		String departmentId = "";
		
		try {
			pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
			
			if (pmlFileType != null) {
				fieldId = pmlFileType.getFieldId();
				
				if (fieldId != null) {
					field = PmlFieldUtil.findByPrimaryKey(fieldId);
					departmentId = field.getDepartmentsId();
					
					if (departmentId != null) {
						department = DepartmentUtil.findByPrimaryKey(departmentId);
						retValue.add(department);
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
	 * this method get list of PmlProcessDispose object by fileTypeId, stateProcessId, startDate and endDate
	 * @param fileTypeId : ID cá»§a lá»�aai há»“ sÆ¡
	 * @param stateProcessId : Id cá»§a tĂ¬nh tráº¡ng xá»­ lĂ½
	 * @param startDate
	 * @param endDate
	 * @return list of PmlProcessDispose object
	 * 
	 */
	public List<PmlProcessDispose> getListProcessDisposeBy_FileTypeId_StateProcessId (String fileTypeId, long stateProcessId, 
																							Date startDate, Date endDate) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> list1 = getListStateProcessByFileType(fileTypeId);
		List<PmlProcessDispose> list2 = getListProcessDisposeByStateProcess(stateProcessId, startDate, endDate);
		
		if (fileTypeId == null ) {
			return retValue;
		}
			
		list1.retainAll(list2);
		retValue = list1;
		
		return retValue;
	}
	
	/**
	 * this method get list of PmlProcessDispose object by fileTypeId
	 * @param fileTypeId : ID cá»§a lá»�ai há»“ sÆ¡
	 * @return list of PmlProcessDispose object
	 * 
	 */
	@SuppressWarnings("null")
	public List<PmlProcessDispose> getListStateProcessByFileType (String fileTypeId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> list = null;
		List<PmlStateProcess> listStateProcess = null;
		PmlStateProcess pmlStateProcess = null;
		
		if (fileTypeId == null) {
			return retValue;
		}
		
		PmlWorkflow pmlWorkflow = null;
		List<PmlWorkflow> listWorkflow = null;
		List<PmlStateWorkFlow> listStateWorkflow = null;
		String workflow = "";
		long stateProcessId = 0;
		
		try {
			listWorkflow = PmlWorkflowUtil.findByFileTypeId(fileTypeId);
			
			if (listWorkflow != null) {
				pmlWorkflow = listWorkflow.get(0);
				workflow = pmlWorkflow.getWorkflow();
				
				listStateWorkflow = PmlStateWorkFlowUtil.findByWorkflow(workflow);
				if (listStateWorkflow != null) {
					for (PmlStateWorkFlow item : listStateWorkflow) {
						stateProcessId = item.getStateProcessId();
						pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessId);
						listStateProcess.add(pmlStateProcess);
						
						if (listStateProcess != null) {
							for (PmlStateProcess stateProcessItem : listStateProcess) {
								stateProcessId = stateProcessItem.getStateProcessId();
								list = PmlProcessDisposeUtil.findByStateProcessIdBefore(stateProcessId);
								retValue.addAll(list);
							}
						}
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
	 * this method get list of PmlProcessDispose object by fileTypeId, fromDate and toDate
	 * @param fileTypeId : ID cá»§a lá»�ai há»“ sÆ¡
	 * @param fromDate
	 * @param toDate
	 * @return
	 * List<PmlProcessDispose>
	 * Apr 3, 2009
	 * com.sgs.portlet.document.service.impl
	 *
	 */
	public List<PmlProcessDispose> getListFileFromDate_ToDate(String fileTypeId, Date fromDate, Date toDate ) {
		List<PmlProcessDispose> result = new ArrayList<PmlProcessDispose>();
		
		List<PmlProcessDispose> listPmlProcessDispose_File = getListStateProcessByFileType(fileTypeId);
		
		if (listPmlProcessDispose_File != null) {
			
			for(PmlProcessDispose pmlProcessDispose : listPmlProcessDispose_File) {
				PmlOneDoorReceiveFile pmlOneDoorReceiveFile;
				try {
					
					pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
					if (fromDate.before(pmlOneDoorReceiveFile.getDateCreated()) && pmlOneDoorReceiveFile.getDateCreated().before(toDate))  {
						result.add(pmlProcessDispose);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param fileTypeId
	 * @param fromDate
	 * @param toDate
	 * @return
	 * PmlProcessDispose
	 * Apr 3, 2009
	 * com.sgs.portlet.document.service.impl
	 *
	 */
	public PmlProcessDispose getFileOverTime(String fileId, String fileTypeId, Date fromDate, Date toDate ) {
		
		List<PmlProcessDispose> pmlProcessDisposeList = getListFileFromDate_ToDate(fileTypeId, fromDate, toDate);
		
		List<PmlProcessDispose> pmlProcessDisposeList_Tepm1 = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> pmlProcessDisposeList_Tepm2 = new ArrayList<PmlProcessDispose>();
		PmlProcessDispose pmlProcessDisposeResult = null;
		
		if (pmlProcessDisposeList != null && pmlProcessDisposeList.size() > 0) {
			for(PmlProcessDispose pmlProcessDispose : pmlProcessDisposeList) {
				PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
				
				try {
					pmlOneDoorReceiveFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(pmlProcessDispose.getFileId());
					
					if (pmlOneDoorReceiveFile.getExactReturningDate() == null || pmlOneDoorReceiveFile.getExactReturningDate().after(pmlOneDoorReceiveFile.getExpectedReturningDate())) {
						pmlProcessDisposeList_Tepm1.add(pmlProcessDispose);
					}
					
					if(pmlProcessDisposeList_Tepm1 != null && pmlProcessDisposeList_Tepm1.size() > 0 ){
						for (PmlProcessDispose pmlProcessDispose1 : pmlProcessDisposeList_Tepm1) {
							if (fileId.equalsIgnoreCase(pmlProcessDispose1.getFileId())) {
								pmlProcessDisposeList_Tepm2.add(pmlProcessDispose1);
							}
						}
					}
					
					if(pmlProcessDisposeList_Tepm2 != null &&  pmlProcessDisposeList_Tepm2.size() > 0){
						pmlProcessDisposeResult = pmlProcessDisposeList_Tepm2.get(0);
						
						for (int i = 1; i < pmlProcessDisposeList_Tepm2.size() ;i++) {
							
							if (pmlProcessDisposeResult.getDateProcess().before(pmlProcessDisposeList_Tepm2.get(i).getDateProcess())) {
								pmlProcessDisposeResult = pmlProcessDisposeList_Tepm2.get(i);
							}
							
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return pmlProcessDisposeResult;
		
	}
	
	/**
	 * check file has over time ??
	 * @param pmlOneDoorReceiveFile
	 * @return
	 * boolean
	 * Apr 3, 2009
	 * com.sgs.portlet.document.service.impl
	 *
	 */
	
	public boolean getPmlOneDoorReceiveFileOverTime(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) {
		boolean result = false;
		Date dateExactReturn = pmlOneDoorReceiveFile.getExactReturningDate();
		if (dateExactReturn == null || dateExactReturn.after(pmlOneDoorReceiveFile.getExpectedReturningDate())) {
			result = true;
		}
		return result;
	}
	
	public List<PmlStateProcess> findByStateProcessIds(
			List<Long> stateProcessIds) throws Exception {
		return pmlStateProcessFinder.findByStateProcessIds(stateProcessIds);
	}
}
