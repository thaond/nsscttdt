package com.nss.workflowonedoor;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sourceforge.rtf.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.model.PmlFileTypeDelegate;
import com.nss.portlet.delegate.service.PmlDelegateLocalServiceUtil;
import com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegateUtil;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.filetype.service.persistence.PmlFileAttachedFileUtil;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.nss.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.model.PmlStateWorkFlow;
import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.model.PmlWfOnedoorProcess;
import com.nss.portlet.onedoor.model.PmlWorkflow;
import com.nss.portlet.onedoor.model.impl.PmlProcessDisposeImpl;
import com.nss.portlet.onedoor.model.impl.PmlStateProcessImpl;
import com.nss.portlet.onedoor.model.impl.PmlStateWorkFlowImpl;
import com.nss.portlet.onedoor.model.impl.PmlTransitionImpl;
import com.nss.portlet.onedoor.model.impl.PmlWorkflowImpl;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlTransitionLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlWorkflowLocalServiceUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFileUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoUtil;
import com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.nss.portlet.onedoor.service.persistence.PmlProcessDisposeUtil;
import com.nss.portlet.onedoor.service.persistence.PmlStateProcessUtil;
import com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowUtil;
import com.nss.portlet.onedoor.service.persistence.PmlTransitionUtil;
import com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessUtil;
import com.nss.portlet.onedoor.service.persistence.PmlWorkflowUtil;
import com.nss.workflowonedoor.util.DelegateConstants;
import com.nss.workflowonedoor.util.InBienNhanUtil;

import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;

/**
 * @author hieuvh
 * 
 *
 */
public class OneDoorProcessLiferayWorkflowService extends
		AbstractLiferayWorkflowService {
	private static Log log = LogFactory.getLog(OneDoorProcessLiferayWorkflowService.class);
	private final static String transitionSeperator = "%";
	private final static String nodeSeperator = ":";
	public final static String TYPE_MC = "MC"; //yenlt 06/04/2010
	
	public static final int HOUR_WORK_IN_DAY = 8;
	/**
	 * Now for test, initial "ingiacong" process
	 */
	public OneDoorProcessLiferayWorkflowService() {
	}
	
	public void saveDataIntiPmlTransition(String fileTypeId, String nameProcess, int version, int traceTransitionProcessMain) {
		String nameTransitionTemp = null;
		PmlTransition pmlTransition = null;
		
		String stateNodeCurrentCode = null;
		String stateNodeNextCode = null;
		long stateProcessCurrent = 0;
		long stateProcessNext = 0;
		List<String[]> nameTransitionList =  getJbpmService().getNameTransitionMainNode(nameProcess, version, traceTransitionProcessMain);
		
		try {
			for (String[] nameString : nameTransitionList) {			
					
						pmlTransition = new PmlTransitionImpl();						
						nameTransitionTemp = nameString[0].split(transitionSeperator)[0];		
						
						//state current
						stateNodeCurrentCode = nameString[1].split(nodeSeperator)[0];						
						List<PmlStateProcess> pmlStateProcessCurrentList = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(stateNodeCurrentCode, TYPE_MC); 
						if (pmlStateProcessCurrentList != null && pmlStateProcessCurrentList.size() > 0 ) {
							stateProcessCurrent = pmlStateProcessCurrentList.get(0).getStateProcessId();
						}
						
						//state next
						stateNodeNextCode = nameString[2].split(nodeSeperator)[0];						
						List<PmlStateProcess> pmlStateProcessNextList = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(stateNodeNextCode, TYPE_MC); 
						if (pmlStateProcessNextList != null && pmlStateProcessNextList.size() > 0 ) {
							stateProcessNext = pmlStateProcessNextList.get(0).getStateProcessId();
						}
						//persistent
						pmlTransition.setPrimaryKey(CounterUtil.increment());
						if ("".equals(PortletProps.get(nameTransitionTemp)) || PortletProps.get(nameTransitionTemp)== null) {
							pmlTransition.setTransitionName(nameTransitionTemp);
						} else {
							pmlTransition.setTransitionName(PortletProps.get(nameTransitionTemp));
						}
						pmlTransition.setFileTypeId(fileTypeId);
						pmlTransition.setVersion_(version + "");
						pmlTransition.setNoTransition(PmlTransitionLocalServiceUtil.countByFileTypeId(fileTypeId) + 1);
						pmlTransition.setStateProcessCurrent(stateProcessCurrent);
						pmlTransition.setStateProcessNext(stateProcessNext);
						
						PmlTransitionLocalServiceUtil.addPmlTransition(pmlTransition);
					}
		
		}catch (Exception e) {
			log.error("ERROR: in method saveDataIntiPmlTransition "+ OneDoorProcessLiferayWorkflowService.class);
			e.printStackTrace();
		}
	}
	
	public int totalTime(InputStream is) {
		int total = 0;	
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlInputStream(is);
		List<String> nodeList = getJbpmService().getListNodeName(processDefinition);
		for (String nodeName : nodeList) {
			if (nodeName.contains(AbstractLiferayWorkflowService.STATE_SEPARATOR)) {
				total += Integer.parseInt(nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR)[1]);
			}
		}
		return total;
	}
	
	/**
	 * get version of process definition lastest
	 * @param fileTypeId
	 * @return int
	 *
	 */
	public int getVersion(String fileTypeId) {
		
		try {
			PmlWorkflow pmlWorkflow= PmlWorkflowUtil.findByFileTypeId(fileTypeId).get(0);
			return getJbpmService().findLatestProcessDefinition(pmlWorkflow.getWorkflow()).getVersion();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/**
	 * deploy a process definition into in database
	 * @param fileTypeId
	 * @param is
	 * @param nameProcess
	 * @param traceTransitionProcessMain
	 * void
	 *
	 */
	//yenlt update 06/04/2010
	public void deloyProcessSupport(String fileTypeId,InputStream is, String nameProcess,int traceTransitionProcessMain) {
		deployOneDoorWorkflow(fileTypeId,  is);					
		ProcessDefinition processDefinition = getJbpmService().findLatestProcessDefinition(nameProcess);
		
		List<String> nodeList =  getJbpmService().getListNodeName(processDefinition);		
		
	
		List<String>  nodeNameList = getJbpmService().getListNodeName(processDefinition);
		List<PmlStateProcess> pmlStateProcessList = null;
		
		try {
			pmlStateProcessList = PmlStateProcessLocalServiceUtil.findByStateProcessName(TYPE_MC);
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		
		boolean flag = false;
		PmlStateProcess pmlStateProcess = null;
		long id = 0;
		String name = "";
		
		for (String nodeName : nodeNameList) {
			if(nodeName.contains(":")){
				name = nodeName.substring(0,nodeName.lastIndexOf(":"));
			}else{
				name = nodeName;
			}
			
			flag = false;
			for (int i = 0; i < pmlStateProcessList.size(); i++) {
				if (name.equals(pmlStateProcessList.get(i).getStateProcessCode())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				try {
					id = CounterLocalServiceUtil.increment();
				} catch (SystemException e) {
					id = 0;
				}
				pmlStateProcess = new PmlStateProcessImpl();
				pmlStateProcess.setStateProcessId(id);
				pmlStateProcess.setStateProcessCode(name);
				pmlStateProcess.setStateProcessName(TYPE_MC);
				try {
					PmlStateProcessLocalServiceUtil.addPmlStateProcess(pmlStateProcess);
				} catch (SystemException e) {
					log.error("ERROR: no upadate PmlStateProcess in method deloyProcessSupport " + OneDoorProcessLiferayWorkflowService.class);
				}
			}
			
		}
		
		List<PmlWorkflow> pmlWorkflowList = null;
		int version = processDefinition.getVersion();
		saveDataIntiPmlTransition(fileTypeId, nameProcess, version, traceTransitionProcessMain);
		if (nodeList != null ) {

			try {
				pmlWorkflowList = PmlWorkflowLocalServiceUtil.findByWorkFlow_Version(nameProcess, version);
			
				for (String nodeName : nodeList) {	
					if (!nodeName.contains(AbstractLiferayWorkflowService.STATE_SEPARATOR)) {
						nodeName +=":0";
					}
					
					String [] arr = nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);
					
					if(pmlWorkflowList != null && pmlWorkflowList.size() > 0){
						String idWF = pmlWorkflowList.get(0).getWorkflow();
						PmlStateWorkFlow pmlStateWorkFlow = new PmlStateWorkFlowImpl();

						 pmlStateProcessList = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(arr[0], TYPE_MC);
						if (pmlStateProcessList != null && pmlStateProcessList.size() > 0) {
							pmlStateProcess = pmlStateProcessList.get(0);
							pmlStateWorkFlow.setStateProcessId(pmlStateProcess.getStateProcessId());
							pmlStateWorkFlow.setSolvingTime(Integer.parseInt(arr[1]));
							pmlStateWorkFlow.setWorkflow(idWF);
							pmlStateWorkFlow.setVersion_(version);
							pmlStateWorkFlow.setPrimaryKey(	CounterUtil.increment());
							PmlStateWorkFlowLocalServiceUtil.addPmlStateWorkFlow(pmlStateWorkFlow);
						}
					}
				}	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#addWorkflowInstance(java.util.List)
	 */
	public void addWorkflowInstance(List<WorkflowParam> params) {
		
		// get necessary parameters include userId and fileId
		String fileId = WorkflowParamUtil.getString(params, "fileId", null);
		String userId = WorkflowParamUtil.getString(params, "userId", null);
		
		if (fileId == null || userId == null) {
			log.info("Can't create Workflow Instance: Parameter invilidate");
			return;
		}
		
		// create process instance
		ProcessDefinition pd = getProcessDefinition(fileId);
		ProcessInstance pi = getJbpmService().createProcessInstanceHasVersion(pd.getName(), pd.getVersion());

		// signal first node
		long processId = pi.getId();
		getJbpmService().setContext(processId, "actorId", userId);
		getJbpmService().signalProcessInstance(processId);

		// create relationship of PML and JBPM
		PmlWfOnedoorProcess wfOnedoorProcess = PmlWfOnedoorProcessLocalServiceUtil
				.createPmlWfOnedoorProcess(fileId);
		wfOnedoorProcess.setProcessId(processId);
		
//		org.jbpm.graph.def.Node node = getJbpmService().getNodeCurrent(processId);
//		wfOnedoorProcess.setNodeId(node.getId());

		try {
			PmlWfOnedoorProcessLocalServiceUtil
					.updatePmlWfOnedoorProcess(wfOnedoorProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		PmlOneDoorReceiveFile file = null;
		try {
			file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
		} catch (Exception e) {}
		
		String stateProcessCode = getStateNode(processId);
		PmlStateProcess stateProcess = getStateProcessFromCode(stateProcessCode);
		logNewNode(fileId, userId, processId, file.getApplicationDate(), stateProcess.getStateProcessId(), true);
	}

	/**
	 * log after create new file.
	 * @param fileId
	 * @param userId
	 * @param processId
	 */
	private PmlProcessDispose logNewNode(String fileId, String userId, long processId,
			Date receiptDate, long processStateId, boolean isStart) {
		// add log information
		PmlProcessDispose log = new PmlProcessDisposeImpl();
		
		long logId = -1;
		try {
			logId = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		// get pml_file from fileId
//		PmlOneDoorReceiveFile file = null;
//		try {
//			file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
//		} catch (Exception e) {}
		
		// get state process code from process instance
		String stateProcessCode = getStateNode(processId);
		PmlStateProcess stateProcess = getStateProcessFromCode(stateProcessCode);
		
		// write information to log
		log.setPrimaryKey(logId);
		
		if (isStart) {
			log.setReceiveDate(receiptDate);
		}
		
		log.setFileId(fileId);
		log.setProcesser(Long.parseLong(userId));
		log.setStateProcessIdBefore(stateProcess.getStateProcessId());
		log.setSendDate(new Date());
		
		log.setExpiredDate(getExpiredDate(processId, processStateId, receiptDate));		
		// set number of log row for a fileId. 
		try {
			log.setTransition_(PmlProcessDisposeUtil.countByFileId(fileId) + 1);
		} catch (SystemException e) {
			log.setTransition_(1);
		}
		
		// persistence log.
		try {
			PmlProcessDisposeLocalServiceUtil.updatePmlProcessDispose(log);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return log;
	}

	/**
	 * @param processId
	 * @param processStateId
	 * @param receiptDate
	 * @return Date
	 */
	private Date getExpiredDate(
		long processId, long processStateId, Date receiptDate) {

		Date expireDate = null;
		ProcessInstance pi = getJbpmService().getProcessInstance(processId);
		ProcessDefinition pd = pi.getProcessDefinition();
		int version = pd.getVersion();
		String name = pd.getName();
		try {
			List<PmlStateWorkFlow> stateWfs = PmlStateWorkFlowUtil.findByWorkFlow_StateProcessId_Version(name, processStateId, version);
			PmlStateWorkFlow stateWorkFlow = stateWfs.get(0);
			int solving = stateWorkFlow.getSolvingTime();
			int dateSolving = 0;
			if (solving % HOUR_WORK_IN_DAY != 0) {
				dateSolving = (solving / HOUR_WORK_IN_DAY) + 1; 
			}
			dateSolving = (solving / HOUR_WORK_IN_DAY);
			long time = receiptDate.getTime() + (long)dateSolving*24*60*60*1000;
			expireDate = new Date(time);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return expireDate;
	}

	/**
	 * @param stateProcessCode
	 * @return PmlStateProcess
	 */
	private PmlStateProcess getStateProcessFromCode(String stateProcessCode) {
		List<PmlStateProcess> list = null;
		
		// find state process list from code.
		try {
			list = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(stateProcessCode, TYPE_MC);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// check exist state process.
		if (list == null || list.size() <= 0) {
			// no log if state process not found
			return null;
		}
		
		// get pml state process
		for (int i = 0; i < list.size(); i++) {
			if (TYPE_MC.equals(list.get(i).getStateProcessName())) {
				return list.get(i);
			}
		}
//		PmlStateProcess stateProcess = list.get(0);
//		return stateProcess;
		return null;
	}

	/**
	 * 
	 * @param fileTypeId
	 * @param xmlResourcePath
	 * @param startDate
	 * @return ProcessDefinition
	 */
	protected ProcessDefinition createProcessDefinition(
			String fileTypeId, String xmlResourcePath, Date startDate) {
		ProcessDefinition processDefinition = getJbpmService()
				.parseXMLResource(xmlResourcePath);

		if (processDefinition != null) {
			getJbpmService().deployProcessDefinition(processDefinition);

			PmlWorkflow pmlWorkflow = new PmlWorkflowImpl();
			pmlWorkflow.setFileTypeId(fileTypeId);
			pmlWorkflow.setStartDate(startDate);
			pmlWorkflow.setWorkflow(processDefinition.getName());
			pmlWorkflow.setVersion_(processDefinition.getVersion());
			
			try {
				PmlWorkflowLocalServiceUtil.addPmlWorkflow(pmlWorkflow);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		return processDefinition;
	}

	/**
	 * 
	 * @param fileTypeId
	 * @param date
	 * @return ProcessDefinition
	 */
	protected ProcessDefinition getProcessDefinition(String fileTypeId, Date date) {

		PmlWorkflow pmlWorkflow = null;
		try {
			// yenlt update 16082010
			List<PmlWorkflow> list = PmlWorkflowLocalServiceUtil.findByFileTypeId(fileTypeId);
			
			if (list == null || list.isEmpty()) {
				return null;
			}
			
			Collections.sort(list, new Comparator<PmlWorkflow>() {
				public int compare(PmlWorkflow o1, PmlWorkflow o2) {
					int sort = o1.getVersion_() - o2.getVersion_();
					return sort;
				}
			});
			
			PmlWorkflow wf = list.get(list.size()-1);
			pmlWorkflow = PmlWorkflowLocalServiceUtil.findByFileTypeId_Version(fileTypeId, wf.getVersion_()).get(0);
			// end yenlt update 16082010
			/* yenlt close end 13082010 
			List<PmlWorkflow> list = PmlWorkflowUtil.findByFileTypeId_StartDate(fileTypeId,	date);
			// in real time, if have multi object return, CHECK END_DATE
			for (PmlWorkflow workflow : list) {
				if (workflow.getEndDate() != null &&
						date.before(workflow.getEndDate())) {
					pmlWorkflow = workflow;
					break;
				} else if (workflow.getEndDate() == null) {
					pmlWorkflow = workflow;
				}
			}
			*/
		} catch (SystemException e) {
			e.printStackTrace();
			log.error("Error: Could not find instance of ProcessDefinition");
		}

		return getJbpmService().findProcessDefinitionWithNameAndVersion(
				pmlWorkflow.getWorkflow(), pmlWorkflow.getVersion_());
	}

	/**
	 * get Process Definition base on fileId
	 * @param fileId
	 * @return ProcessDefinition
	 */
	public ProcessDefinition getProcessDefinition(String fileId) {
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;
		
		try {
			pmlOneDoorReceiveFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		} catch (NoSuchPmlOneDoorReceiveFileException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		String fileTypeId = "";
		Date createDate = null;
		
		if (pmlOneDoorReceiveFile != null) {
			fileTypeId = pmlOneDoorReceiveFile.getFileTypeId();
			createDate = pmlOneDoorReceiveFile.getApplicationDate();
		}


		if (!"".equals(fileTypeId) && createDate != null) {
			return getProcessDefinition(fileTypeId, createDate);
		}
		return null;
	}

	/**
	 * 
	 * @param userId
	 * @return List<PmlOneDoorReceiveFile> 
	 * 
	 */
	public List<PmlOneDoorReceiveFile> getListPmlFilesByUser(long userId) {
		return getListPmlFilesByUser(userId, null, null);
	}
	
	/**
	 * gets all pml_file of a user with concrete filter condition
	 * @param userId
	 * @param type
	 * @param valueType
	 * @return List<PmlOneDoorReceiveFile>
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListPmlFilesByUser(long userId, String type, String valueType) {
		List<ProcessInstance> processInstanceList = this.getJbpmService().getListProcessInstanceOfActor(userId);
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = null;
		
		try {
			pmlOneDoorReceiveFileList = getListPmlFilesByUserhelp(processInstanceList, type, valueType);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR: No Can't Find List PmlFiles From A Concrete User [ "
					+ userId + " ]");
		}
		
		return pmlOneDoorReceiveFileList;
	}
	
	
	private List<PmlOneDoorReceiveFile> getListPmlFilesByUserhelp (List<ProcessInstance> processInstanceList, String type, String valueType) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlWfOnedoorProcess> pmlWfOnedoorProcessList = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date beginDate = null;
		Date endDate = null;
		try {
			for (Iterator<ProcessInstance> iterator = processInstanceList
					.iterator(); iterator.hasNext();) {
				
				ProcessInstance processInstance = iterator.next();
				if (processInstance != null) {
					try {
						pmlWfOnedoorProcessList = PmlWfOnedoorProcessUtil
								.findByProcessId(processInstance.getId());
					} catch (Exception e) {	}
					
					
					if (pmlWfOnedoorProcessList == null || pmlWfOnedoorProcessList.size() == 0) {
						continue;
					}
					
					for (Iterator<PmlWfOnedoorProcess> ite = pmlWfOnedoorProcessList
							.iterator(); ite.hasNext();) {
					
						PmlWfOnedoorProcess pmlWfOnedoorProcess = ite.next();
						PmlOneDoorReceiveFile pmlDoorReceiveFile = null;
						
						try {
							pmlDoorReceiveFile = PmlOneDoorReceiveFileUtil
								.findByPrimaryKey(pmlWfOnedoorProcess.getFileId());
						} catch (Exception e) {}
							
						if ("mahoso".equals(type)) {
							if (pmlDoorReceiveFile.getFileId().toUpperCase().contains(valueType.toUpperCase())) {
								pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
							}
						}
						
						else if ("tenhoso".equals(type)) {
							String fileId = pmlDoorReceiveFile.getFileId();
							PmlFilePCCC filePCCC = null;
							
							try {
								filePCCC = PmlFilePCCCUtil.findByPrimaryKey(fileId);
							} catch (Exception e) {}
							
							if (filePCCC != null) {
								if (filePCCC.getFileName().toUpperCase().contains(valueType.toUpperCase())) {
								pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
								}
							}
						}
						
						// ADD UPDATE
						else if ("loaihoso".equals(type)) {
							String fileTypeId = pmlDoorReceiveFile.getFileTypeId();
							PmlFileType pmlFileType = null;
							try{
								pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
							}catch (Exception e) {}
							
							if (pmlFileType != null) {
								if (pmlFileType.getFileTypeName().toUpperCase().contains(valueType.toUpperCase())) {
									pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
								}
							}
						}
						else if ("trangthaihoso".equals(type)) {
								String fileId = pmlDoorReceiveFile.getFileId();
								String fileState = getState(fileId);
									
								if (fileState .equalsIgnoreCase(valueType)){
									pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
								}
						}
						
						else if ("ngaygui".equals(type)) {
							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDoorReceiveFile.getFileId());
							
							if (pmlProcessDispose.getSendDate() == null){
								pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
							}
							
							else {
								if (!"".equals(valueType)) {
									beginDate =	dateFormat.parse(valueType.split("_")[0]);
									endDate =	dateFormat.parse(valueType.split("_")[1]);
								
									Date sendDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getSendDate()));
									
									if ((beginDate.before(sendDate) || beginDate.equals(sendDate))
										&& (sendDate.before(endDate) || sendDate.equals(endDate))){ 
										
										pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
									}
							}
							}
						}
						
						else if ("ngaynhan".equals(type)) {
							
							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDoorReceiveFile.getFileId());
							
							if (pmlProcessDispose.getReceiveDate() == null){
								pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
							}
							
							else {
								
								if (!"".equals(valueType)) {
									beginDate =	dateFormat.parse(valueType.split("_")[0]);
									endDate =	dateFormat.parse(valueType.split("_")[1]);
								
								Date receiveDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getReceiveDate()));
								
								if ((beginDate.before(receiveDate) || beginDate.equals(receiveDate))
									&& (receiveDate.before(endDate) || receiveDate.equals(endDate))){ 
									
									pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
								}
							}
						}
						}
						
						else if ("ngayhethan".equals(type)) {
							
							
							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDoorReceiveFile.getFileId());
							
							if (pmlProcessDispose.getExpiredDate() == null){
								pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
							}
							
							else {
								
								if (!"".equals(valueType)) {
									beginDate =	dateFormat.parse(valueType.split("_")[0]);
									endDate =	dateFormat.parse(valueType.split("_")[1]);
								
								Date expiredDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getExpiredDate()));
								
								if ((beginDate.before(expiredDate) || beginDate.equals(expiredDate))
									&& (expiredDate.before(endDate) || expiredDate.equals(endDate))){ 
									
									pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
								}
							}
							}
						}
						
						else if ("ngayhentrakhach".equals(type)) {
							if (!"".equals(valueType)) {
								beginDate =	dateFormat.parse(valueType.split("_")[0]);
								endDate =	dateFormat.parse(valueType.split("_")[1]);
							
								Date expectedReturningDate = dateFormat.parse(dateFormat.format(pmlDoorReceiveFile.getExpectedReturningDate()));
								
								if ((beginDate.before(expectedReturningDate) || beginDate.equals(expectedReturningDate))
										&& (expectedReturningDate.before(endDate) || expectedReturningDate.equals(endDate))){ 
										
										pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
									}
								}
						}
						
						
						
						//END EDD UPDATE
						else {
							pmlOneDoorReceiveFileList.add(pmlDoorReceiveFile);
						}
						
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return pmlOneDoorReceiveFileList;
	}
	
	/**
	 * lay log moi nhat cua ho so
	 * 
	 * @param fileId
	 * @return
	 */
	private PmlProcessDispose getProcessDipose(String fileId) {
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		PmlProcessDispose log = service.getCurrentLogFromFileId(fileId);
		return log;
	}
	
	/**
	 * Get PML_File with user and process state list   
	 * @param userId
	 * @param stateProcess
	 * @return List<PmlOneDoorReceiveFile>
	 *
	 */
	public List<PmlOneDoorReceiveFile> getListPmlFilesByUserWithSate(long userId,  String type, String valueType, List<String> processState ){
		List<ProcessInstance> processInstanceList = this.getJbpmService().getListProcessInstanceOfActorWithState(userId, processState);
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = null;
		
		try {
			pmlOneDoorReceiveFileList = getListPmlFilesByUserhelp(processInstanceList, type, valueType);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR: No Can't Find List PmlFiles From A Concrete User [ "
					+ userId + " ] And Process State List");
		}
		
		return pmlOneDoorReceiveFileList;
	}
	
	/**
	 * get current state of pml_file with given fileId
	 * @param fileId
	 * @return
	 */
	public String getState(String fileId) {

		String state = null;
		String nodeName = null;
		PmlWfOnedoorProcess pmlWfOnedoorProcess = null;
		
		
		try {
			pmlWfOnedoorProcess = PmlWfOnedoorProcessUtil
					.findByPrimaryKey(fileId);
		} catch (Exception e1) {}
			
		try {	
			if (pmlWfOnedoorProcess != null){
			
				// get current node name of process instance.
				nodeName = this.getJbpmService().getNodeName(pmlWfOnedoorProcess
						.getProcessId());
				
				// split it by : separator
				String[] values = nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);
				state = values[0];
			}
		} catch (Exception e) {
			log.error("ERROR: No Can't Get State Of WF With FileId [" + fileId + "]");			
		}
		return state;
	}

	/**
	 * Parameter list is:
	 *    <li>taskId: </li>
	 *    <li>transition: </li>
	 * signal task in file
	 * @see com.sgs.liferay.jbpm.service.LiferayWorkflowService#signalTask(java.util.List)
	 */
	public void signalTask(List<WorkflowParam> params) {
		long taskId = -1;
		String transition = null;
		String receiverId = null;
//		String senderId = null;
		String processor = null; // yenlt 24052010
		String isDelegate = null; // yenlt 24052010
		String processInformation = null;
		Date dateProcess = null;
		
		// get process instance
		taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		ProcessInstance pi = getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		long processId = pi.getId();
		
		// get fileId from processId
		String fileId = getFileIdFromProcessId(processId);
		
		// get parameters
		transition = WorkflowParamUtil.getString(params, "transition", null);
		String temp = WorkflowParamUtil.getString(params, "dateProcess", "");
		try {
			dateProcess = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(temp);
		} catch (Exception e) {}
		
		// get parameters
		receiverId = WorkflowParamUtil.getString(params, "receiverId", null);
//		senderId = WorkflowParamUtil.getString(params, "senderId", null);
		processor = WorkflowParamUtil.getString(params, "processor", null);//yenlt 24052010
		isDelegate = WorkflowParamUtil.getString(params, "isDelegate", null);//yenlt 24052010
		processInformation = WorkflowParamUtil.getString(params, "processInformation", null);

		
		// load current Log information
		PmlProcessDispose log = getCurrentLogFromFileId(fileId);
		log.setProcessInfomation(processInformation);
		
		try {
			log.setReceiver(Long.parseLong(receiverId));	
		} catch (Exception e) {
		}
		
		if (dateProcess == null) {
			dateProcess = new Date();
		}

		log.setDateProcess(dateProcess);
		//yenlt update 24052010
		// update truong hop nguoi duoc uy quyen xu ly ho so
		long userLoginId = Long.parseLong(processor);
		if (isDelegate.equals("true")) {
			log.setDelegateUser(userLoginId);
		}
		// end yenlt 24052010
		
		// minh update 20100428
		List<Long> listUserNodeBack = (List<Long>) getJbpmService().getContextVariable(processId, "listUserNodeBack");
		
		if (listUserNodeBack !=null  ){
			listUserNodeBack.add(log.getProcesser());
			getJbpmService().setContext(processId, "listUserNodeBack", listUserNodeBack);
		} else {
			 listUserNodeBack = new ArrayList<Long>();
			 listUserNodeBack.add(log.getProcesser());
			 getJbpmService().setContext(processId, "listUserNodeBack", listUserNodeBack);
		}	
		// end minh update 20100428
		// signal to next node
		signalTask(taskId, transition, receiverId);
	
		// set StateProcessIdAfter for current log.
		long processStateAfterId = getStateProcessFromCode(getState(fileId)).getStateProcessId();
		log.setStateProcessIdAfter(processStateAfterId);
		// persistence log information
		try {
			PmlProcessDisposeLocalServiceUtil.updatePmlProcessDispose(log);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// log new information here
		if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
			logNewNode(fileId, receiverId, processId, dateProcess, processStateAfterId, false);
		}
	}

	/**
	 * @param fileId
	 * @param processId
	 * @return PmlProcessDispose
	 */
	public PmlProcessDispose getCurrentLogFromFileId(String fileId) {
		//get state process
		String code = getState(fileId);
		PmlStateProcess state = getStateProcessFromCode(code);
		
		List<PmlProcessDispose> list = new ArrayList<PmlProcessDispose>();
		
		try {
			list = PmlProcessDisposeUtil.findByFileId_StateProcessIdBefore(fileId,state.getStateProcessId());
			if (0 == list.size()) {
				list = PmlProcessDisposeUtil.findByFileId_StateProcessIdAfter(fileId,state.getStateProcessId());
			}
		} catch (SystemException e) {
			list = new ArrayList<PmlProcessDispose>();
		}
		
		// check if list null or empty
		if (list == null || list.isEmpty()) {
			return null;
		}
		
		// get log no dateProcess
		for (PmlProcessDispose log : list) {
			if (log.getDateProcess() == null) {
				return log;
			}
		}
		
		return list.get(0);
	}

	/**
	 * @param processId
	 * @return
	 */
	private String getFileIdFromProcessId(long processId) {
		// get fileId from processId
		List<PmlWfOnedoorProcess> wfList = null;
		try {
			wfList = PmlWfOnedoorProcessUtil.findByProcessId(processId);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (wfList == null || wfList.size() <= 0) {
			return null;
		}
		
		String fileId = wfList.get(0).getFileId();
		return fileId;
	}

	/**
	 * @param fileType
	 * @param is
	 */
	public void deployOneDoorWorkflow(String fileType, InputStream is) {
		try {
			long workflowID = CounterLocalServiceUtil.increment();
			PmlWorkflow workflow = PmlWorkflowLocalServiceUtil.createPmlWorkflow(workflowID);
	
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date d = new Date();
			Date date = df.parse(df.format(d));
	
			workflow.setStartDate(new Timestamp(date.getTime()));
			workflow.setFileTypeId(fileType);
			
			
			ProcessDefinition pd = deployWorkflow(is);
			if (pd == null) {
				return;
			}
			
			workflow.setWorkflow(pd.getName());
			workflow.setVersion_(pd.getVersion());
			workflow = PmlWorkflowLocalServiceUtil.updatePmlWorkflow(workflow);
			
			// change previous version end date.
			if (pd.getVersion() > 1) {
				int previousVersion = pd.getVersion() - 1;
				
				List<PmlWorkflow> previousWorkflows = PmlWorkflowUtil.findByFileTypeId(fileType);
				
				if (previousWorkflows == null) {
					return;
				}
			
				for (Iterator iterator = previousWorkflows.iterator();
						iterator.hasNext();) {

					PmlWorkflow pmlWorkflow = (PmlWorkflow) iterator.next();
					
					if (pmlWorkflow.equals(workflow)) {
						continue;
					}
					
					if (pmlWorkflow.getEndDate() == null) {
						pmlWorkflow.setEndDate(new Timestamp(date.getTime()));
						PmlWorkflowLocalServiceUtil.updatePmlWorkflow(pmlWorkflow);
						break;
					}
				}
				
			}
		} catch (Exception e) {}
	}

	/**
	 * @param workflowParams
	 */
	public InputStream inBienNhan(List<WorkflowParam> workflowParams) {

		String fileId = WorkflowParamUtil.getString(workflowParams, "fileId","");
		String path = WorkflowParamUtil.getString(workflowParams, "path", "");
		log.info("fileId: " + fileId);
		if (fileId.equals("")) {
			return null;
		}

		InputStream stream = reportInBienNhan(path, fileId);
		return stream;
	}
	
	private InputStream reportInBienNhan(String path, String fileId) {
		//yenlt update 15/04/2010
		String templateReport = "";
		String day = "";
		String month = "";
		String yearHS = "";
		String receiptNumber = "";
		String appRepresent = "";
		String hour = "";
		String minutes = "";
		String address = "";
		String represent = "";
		String receive = "";
		int processTime = 0 ;
		String ngayNhan = "";
		String  fileTypeId = "";
		String receiptTemplate = "";
		String applicantTime = "";
		PmlOneDoorReceiveFile file = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PmlFileType fileType = null;
		PmlFilePCCC filePCCC = null;
		try {
			file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		} catch (Exception e) {
			log.error("CAN NOT GET PMLONEDOORRECEIVEFILE");
		}
		
		if ( null != file) {
			try {
				filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
			} catch (PortalException e1) {
				log.error(e1);
			} catch (SystemException e1) {
				log.error(e1);
			}
			
			processTime = filePCCC.getTotalDate();
			appRepresent = filePCCC.getApplicantRepresentation();
			fileTypeId = file.getFileTypeId();
			 try {
				fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
			} catch (PortalException e) {
				log.error(e);
			} catch (SystemException e) {
				log.error(e);
				log.error("CAN NOT GET FILE TYPE");
			}
			
			 //loai ho so
			if ( null != fileType ) {
				receiptTemplate = fileType.getReceiptTemplate();
//				templateReport = "/" + receiptTemplate +".rtf";//yenlt close 20/04/2010
				templateReport = "/bienNhanHoSo.rtf";
			}
			//dai dien ben giao
			represent =  file.getApplicantName();
			receiptNumber = file.getNumberReceipt();
			address = file.getPermanentAddress();
			//dai dien ben nhan
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(file.getReceiverId());
			} catch (PortalException e) {
				log.error(e);
			} catch (SystemException e) {
				log.error(e);
			}
			if (null != user) {
				receive = user.getLastName()+ " " + user.getMiddleName() + " " + user.getFirstName();
			}
			
			if ( null != file.getApplicationDate() ) {
				ngayNhan = sdf.format(file.getApplicationDate());
				String[] dateSplit = ngayNhan.split("/");
				day = dateSplit[0];
				month = dateSplit[1];
				yearHS = dateSplit[2];
			}
			//hour
			applicantTime = filePCCC.getApplicantTime();
			if (!"".equals(applicantTime)){
				String[] time = applicantTime.split(":");
				hour = time[0];
				minutes = time[1];
			}
		}
		
//		if ("bienNhanHoSo".equals(receiptTemplate)) {
			InBienNhanUtil rTFUtil = null;
			InputStream inputStream = null;
			rTFUtil = new InBienNhanUtil(path,  day, month, yearHS, StringUtils.convertToRTF(receiptNumber), StringUtils.convertToRTF(appRepresent), hour,
					minutes, StringUtils.convertToRTF(address), StringUtils.convertToRTF(represent), StringUtils.convertToRTF(receive),processTime);
			
			try {
				inputStream = rTFUtil.run(path + templateReport);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return inputStream;
//		}
		
		//end yenlt
		/* yenlt close 15/04/2010
		else {
			OpenOfficeConnection connection = new SocketOpenOfficeConnection();
			
			File templateFile = new File(path + "/report-template.odt");
			File outputFile = null;
			try {
				outputFile = File.createTempFile("report", ".doc");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				
				DocumentTemplate template = null;
				if (templateFile.isDirectory()) {
					template = new UnzippedDocumentTemplate(templateFile);
				} else {
					template = new ZippedDocumentTemplate(templateFile);
				}
				
				// data for report
				PmlOneDoorReceiveFile pmlFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
				
				PmlFileType pmlFileType = PmlFileTypeUtil.findByPrimaryKey(pmlFile.getFileTypeId());
				
				PmlField pmlField = PmlFieldUtil.findByPrimaryKey(pmlFileType.getFieldId());
				
				PmlDepartment pmlDepartment = PmlDepartmentUtil.findByPrimaryKey(pmlField.getDepartmentsId());
				
				PmlFilePCCC pmlFilePCCC = PmlFilePCCCUtil.findByPrimaryKey(fileId);
				
				Map model = new HashMap();
				model.put("departmentName", pmlDepartment.getDepartmentsName().toUpperCase());
				model.put("fileName", pmlFilePCCC.getFileName().toUpperCase());
				
				Date applicationDate = pmlFile.getApplicationDate();
//			Date applicationDate =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(pmlFile.getApplicationDate().toString());
				String hours = (applicationDate.getHours() < 10) ? ("0" + applicationDate.getHours()) : (applicationDate.getHours() + ""); 
				String minutes = (applicationDate.getMinutes() < 10) ? ("0" + applicationDate.getMinutes()) : (applicationDate.getMinutes() + "");
				String dates = (applicationDate.getDate() < 10) ? ("0" + applicationDate.getDate()) : (applicationDate.getDate() + "");
				String months = (applicationDate.getMonth() < 10) ? ("0" + applicationDate.getMonth()) : (applicationDate.getMonth() + "");
				long year = applicationDate.getYear() + 1900;
				model.put("applicationDateTime", "\ufeffV\u00e0o h\u1ed3i: " + hours + " gi\u1edd " + minutes + " ph\u00fat, ng\u00e0y " + dates + " th\u00e1ng " + months + " n\u0103m " + year);
				
				model.put("applicantName", pmlFile.getApplicantName());
				model.put("applicantRepresentation", pmlFilePCCC.getApplicantRepresentation());
				model.put("applicantTelephone", pmlFilePCCC.getApplicantTelephone());
				model.put("receiverOfUnit", pmlFilePCCC.getReceiveOfUnit());
				model.put("receiverRepresentation", pmlFilePCCC.getReceiverRepresentation());
				model.put("receiverTelephone", pmlFilePCCC.getReceiverTelephone());
				model.put("projectName", pmlFilePCCC.getProjectName());
				model.put("applicantCategory", pmlFilePCCC.getApplicantCategory());
				model.put("addressBuilder", pmlFilePCCC.getAddressBuilder());
				model.put("investor", pmlFilePCCC.getInvestor());
				model.put("designCop", pmlFilePCCC.getDesignCop());
				
				List<PmlFileAttachedFile> attachedFileList = PmlFileAttachedFileUtil.findByFileId(fileId);
				model.put("numberAttachedFile", (attachedFileList.size() < 10) ? ("0" + attachedFileList.size()) : (attachedFileList.size() + ""));//so bo ho so
				
				List<PmlPaintDocument> paintDocumentList = PmlPaintDocumentUtil.findByFileId(fileId);
				model.put("numberPaintDocument", (paintDocumentList.size() < 10) ? ("0" + paintDocumentList.size()) : (paintDocumentList.size() + ""));
				
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
//			Date date = df.parse(pmlFile.getExpectedReturningDate().toString());
				Date date = pmlFile.getExpectedReturningDate();
				String expectedReturningDate = (new SimpleDateFormat("dd/MM/yyyy")).format(date);
				model.put("expectedReturningDate", expectedReturningDate);
				
				model.put("paintDocumentList", paintDocumentList);
				model.put("attachedFileList", attachedFileList);
				model.put("size", attachedFileList.size());
				
				if ("odt".equals(FilenameUtils.getExtension(outputFile.getName()))) {
					template.createDocument(model, new FileOutputStream(outputFile));
				} else {
					connection.connect();
					File temporaryFile = File.createTempFile("document", ".odt");
					temporaryFile.deleteOnExit();
					template.createDocument(model, new FileOutputStream(
							temporaryFile));
					
					DocumentConverter converter = new OpenOfficeDocumentConverter(
							connection);
					converter.convert(temporaryFile, outputFile);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection.disconnect();
			}
			
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(outputFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			return inputStream;
		}
		yenlt close end */
	}
	
	/**
	 * To deactive a selected document by set active field to "0"
	 * @author triltm
	 * @param workflowParams
	 */
	public void deleteWorkflowInstance(List<WorkflowParam> workflowParams) {
		
		// get taskId from parameters list
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		 
		// check exist taskId
		if (taskId == -1) {
			return;
		}
		
		// get process instance via task instance from Jbpm service
		ProcessInstance pi = getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		
		String fileId =  getFileIdFromProcessId(pi.getId());
		
		// minh update 20100524
		//PmlOneDoorReceiveFile pmlFile = null;
		try {
			//pmlFile = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
			//pmlFile.setActive("0");
			//PmlOneDoorReceiveFileLocalServiceUtil.updatePmlOneDoorReceiveFile(pmlFile);
			PmlOneDoorReceiveFileLocalServiceUtil.deletePmlOneDoorReceiveFile(fileId);
		// end minh update 20100524
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// minh update 20100524
		try {
			PmlFileAttachedFileUtil.removeByFileId(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			PmlFilePCCCLocalServiceUtil.deletePmlFilePCCC(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			PmlFilePCCCAttachedFileUtil.removeByFilePcccId(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			PmlFileReturningInfoUtil.removeByFileId(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
//		try {// chua co ban nay
//			PmlFileAttachReturnInfoUtil.removeByFilePcccId(fileId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		
		// end minh update 20100524
		try {
			PmlProcessDisposeUtil.removeByFileId(fileId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		try {
			PmlWfOnedoorProcessUtil.remove(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// delete process instance.
		getJbpmService().deleteProcessInstance(pi.getId());
	}

	/**
	 * 
	 * @param processDispose
	 */
	public void updateReceiveDate(String fileId, long userId) {
		try {
			PmlProcessDispose processDispose = getCurrentLogFromFileId(fileId);
			if (processDispose.getReceiveDate() == null) {
//				processDispose.setProcesser(userId); // yenlt close 24052010
				processDispose.setReceiveDate(new Date());
				
				PmlProcessDisposeLocalServiceUtil.updatePmlProcessDispose(processDispose);
			}
		} catch (Exception e) {		
			e.getStackTrace();
		}
	}
	
	private Date returnExpiredDate(String fileId, Date processDate) {
		Date expireDate = null;
		try {
			PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileLocalServiceUtil
												.getPmlOneDoorReceiveFile(fileId);
			String fileTypeId = file.getFileTypeId();
			List<PmlWorkflow> workflowObjs =  PmlWorkflowUtil.findByFileTypeId(fileTypeId);
			if (workflowObjs != null ) {
				PmlWorkflow workflowObj = workflowObjs.get(0);
			
				String workflow = workflowObj.getWorkflow();
				int version_ = workflowObj.getVersion_();
				
				PmlProcessDispose dispose = getCurrentLogFromFileId(fileId);
				//lay ProcessDisposeid, tu do se lay stateProcess, tu stateProcessId, va workflowId lay State_Wf
				// tu doi tuong state_wf lay duoc solvingTime
				//lay sovlingTime + ngay xu ly =  ngay het han
				long stateProcessId = dispose.getStateProcessIdBefore();
				
				List<PmlStateWorkFlow> stateWfs = PmlStateWorkFlowUtil
					.findByWorkFlow_StateProcessId_Version(workflow, stateProcessId, version_);
				
				PmlStateWorkFlow stateWorkFlow = stateWfs.get(0);
				int solving = stateWorkFlow.getSolvingTime();
				
				long time = processDate.getTime() + (long)solving*60*60*1000;
				expireDate = new Date(time);
			}
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return expireDate;
	}
	
	/**
	 * This method get all PmlOneDoorReceiptFile objects of a user with specific
	 * userId in current time.<br>
	 * The results is populated to a map in 3 cases:<br>
	 * 1. Key: DelegateConstants.OWNER ('owner')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user is response to process.<br>
	 * 2. Key: DelegateConstants.IS_DELEGATED ('is_delegated')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user is delegated to process.<br>
	 * 3. Key: DelegateConstants.DELEGATED ('delegated')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user delegated to process.<br>
	 * -----------------
	 * @param userId specific userId given by client.
	 * @return a map with 3 keys just description.
	 */
	public Map<String, List<PmlOneDoorReceiveFile>> getPmlFileMapByUserId(long userId) {
		return getPmlFileMapByUserId(userId, null, null);
	}
	
	/**
	 * This method get all PmlOneDoorReceiptFile objects of a user with specific
	 * userId in current time.<br>
	 * The results is populated to a map in 3 cases:<br>
	 * 1. Key: DelegateConstants.OWNER ('owner')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user is response to process.<br>
	 * 2. Key: DelegateConstants.IS_DELEGATED ('is_delegated')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user is delegated to process.<br>
	 * 3. Key: DelegateConstants.DELEGATED ('delegated')<br>
	 * Value: list of PmlOneDoorReceiptFile objects that user delegated to process.<br>
	 * -----------------
	 * @param userId specific userId given by client.
	 * @param type 
	 * @param valueType
	 * @return a map with 3 keys just description.
	 */
	public Map<String, List<PmlOneDoorReceiveFile>> getPmlFileMapByUserId(long userId, String type, String valueType) {
		// create 3 ArrayList
		List<PmlOneDoorReceiveFile> ownerList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> isDelegatedList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> delegatedList = new ArrayList<PmlOneDoorReceiveFile>();
		
		// create currentDate : Date
		Date currentDate = Calendar.getInstance().getTime();
		
		// create fileTypeMap
		Map fileTypeMap = new HashMap();
		
		// get list of files of User at current time in process definition.
		List<PmlOneDoorReceiveFile> filesOfUser = getListPmlFilesByUser(userId, type, valueType);
		
		// Check NULL and size of filesOfUser
		if (filesOfUser != null && filesOfUser.size() > 0) {
		
			// For Each file in filesOfUser
			for (PmlOneDoorReceiveFile file : filesOfUser) {
				// get fileType form file
				String fileTypeId = file.getFileTypeId();
				
				// fileTypeId has to not null, and get delegateType from fileTypeMap.
				String delegateType = (String) fileTypeMap.get(fileTypeId);
				
				// check NULL of delegateType
				if (delegateType != null) {
					// check delegateType is OWNER
					if (delegateType.equals(DelegateConstants.OWNER)) {
						ownerList.add(file);
					} else { // delegateType is DELEGATED
						delegatedList.add(file);
					}
					
					// call continue to go to next file.
					continue;
				}
				
				// call checkDelegatedByTime(userId, fileType, currentDate) method to check delegated time.
				boolean delegatedAtCurrentTime = checkDelegatedByTime(userId, fileTypeId, currentDate);
				
				// if delegated, add to delegatedList, put value to fileTypeMap.
				if (delegatedAtCurrentTime) {
					delegatedList.add(file);
					fileTypeMap.put(fileTypeId, DelegateConstants.DELEGATED);
				} else { // is owner, add to ownerList.
					ownerList.add(file);
					fileTypeMap.put(fileTypeId, DelegateConstants.OWNER);
				}
			}
		}
		
		// calculate isDelegatedList at currentDate.
		isDelegatedList = getIsDelegatedFileList(userId, currentDate, type, valueType);
		
		// create resultMap
		Map resultMap = new HashMap();
		
		// put value to resultMap
		resultMap.put(DelegateConstants.OWNER, ownerList);
		resultMap.put(DelegateConstants.DELEGATED, delegatedList);
		resultMap.put(DelegateConstants.IS_DELEGATED, isDelegatedList);
		
		// return
		return resultMap;
	}

	/**
	 * check user has delegated a fileType at given date.
	 * call Delegate Service
	 * @param userId
	 * @param fileTypeId
	 * @param date
	 * @return true if user has delegated a fileType at given date, otherwise return false
	 */
	private boolean checkDelegatedByTime(long userId, String fileTypeId,
			Date date) {
		
		try {
			return PmlDelegateLocalServiceUtil.checkDelegatedByTime(userId, fileTypeId, date);
		} catch (Exception e) {
			System.out.println("Exception, FALSE TO RETURN.");
			e.printStackTrace();
		}

		return false;	
	}
	
	/**
	 * get IS_DELEGATED files of a user in given date.
	 * call Delegate Service
	 * * Y tuong giai quyet van de:
	 * - Lay danh sach cac delegate ma userId la receiver voi thoi gian cung cap
	 * nam giua startDate va endDate (hoac cancelDate) neu da cancel.
	 * - Neu ko co delegate return null
	 * - Khoi dong danh sach ket qua.
	 * - Voi moi delegate:
	 *   + Lay assignerId
	 *   + Lay danh sach cac loai ho so cua delegate.
	 *   + Tim cac ho so thuoc ve assigner.
	 *   + Voi moi ho so neu ho so co loai ho so nam trong danh sach loai ho so cua delegate thi add vao danh sach ket qua. 
	 * - Tra ve danh sach ket qua.
	 * @param userId id of user need to calculate list of IS_DELEGATED files.
	 * @param date given by client
	 * @return list of IS_DELEGATED files that assign to users.
	 */
	public List<PmlOneDoorReceiveFile> getIsDelegatedFileList(long userId,
			Date date, String type, String valueType) {
		// init resutl List
		List<PmlOneDoorReceiveFile> resultList = null;
		
		// get list of pml_delegate with userId as receiver
		List<PmlDelegate> delegateList = new ArrayList();
		try {
			// list with cancel
			List<PmlDelegate> delegateList1 =  PmlDelegateLocalServiceUtil
					.getByReceive_StartDate_CancelDate(userId, date, date);
			
			// list without cancel
			List<PmlDelegate> delegateList2 = PmlDelegateLocalServiceUtil
					.getByReceive_StartDate_EndDate(userId, date, date);
			
			if (delegateList1 != null) {
				delegateList.addAll(delegateList1);
			}
			
			if (delegateList2 != null) {
				delegateList.addAll(delegateList2);
			}
			
			// return null if delegateList is empty. 
			if (delegateList.isEmpty()) {
				return null;
			}
			
			resultList = new ArrayList<PmlOneDoorReceiveFile>();
			// for each pml_delegate in delegateList.
			for (PmlDelegate pmlDelegate : delegateList) {
				// get assignerId.
				long assignerId = pmlDelegate.getAssigner();
				
				List<PmlFileTypeDelegate> fileTypeDelegateList = PmlFileTypeDelegateUtil.findByDelegateId(pmlDelegate.getDelegateId());
				
				// get fileTypeIdList.
				List<String> fileTypeIdList = getFileTypeIdListFromFileTypeDelegateList(fileTypeDelegateList);
				
				// get list file of assigner.
			    List<PmlOneDoorReceiveFile> assignerList = getListPmlFilesByUser(assignerId, type, valueType);
			    
			    // filter by fileType is delegated.
			    for (PmlOneDoorReceiveFile file : assignerList) {
			    	if (fileTypeIdList.contains(file.getFileTypeId())) {
			    		resultList.add(file);
			    	}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	/**
	 * get file type list from 
	 * @param fileTypeDelegateList
	 * @return
	 */
	private List<String> getFileTypeIdListFromFileTypeDelegateList(
			List<PmlFileTypeDelegate> fileTypeDelegateList) {
		
		List<String> list = new ArrayList<String>();
		
		for (PmlFileTypeDelegate pmlFileTypeDelegate : fileTypeDelegateList) {
			list.add(pmlFileTypeDelegate.getFileTypeId());
		}
		
		return list;
	}
	
	/**
	 * get state of file with a user concreate 
	 */
	
	public List<PmlStateProcess> getStateOfFileWithUser(long userId) {
		List<PmlStateProcess> listRes =	new ArrayList<PmlStateProcess>();
		
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList =	getListPmlFilesByUser(userId);
		List<PmlStateProcess> listTemp = null;
		
		for (PmlOneDoorReceiveFile pf : pmlOneDoorReceiveFileList) {
			String fileId = pf.getFileId();
			String nodeName = getState(fileId);
			
			
			try {
				listTemp = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(nodeName, TYPE_MC);
			} catch (SystemException e) {}
			
			if (listTemp != null && listTemp.size() > 0){
				if (!listRes.contains(listTemp.get(0))) {
					listRes.add(listTemp.get(0));
				
				}
			}
		}
		return listRes;
		
	}
//	Yenlt 05/04/2010
	
	/**
	 * Lay tat ca cong van ung voi mot user cu the  
	 * @param userIds
	 * @param fileStatusId
	 * @return List<ProcessInstance>
	 */
	public List<Long> getProcessInstances (long userId){
		List<ProcessInstance> processInstanceList = getJbpmService().getListProcessInstanceOfActor(String.valueOf(userId));
		
		List<Long> results = new ArrayList<Long>();		
		for (int i = 0; i < processInstanceList.size(); i++) {			
			results.add(processInstanceList.get(i).getId());
		}
		return results;
	}
	
	
	public List<Long> getProcessInstances (List<Long> userIds){
		List<Long> results = new ArrayList<Long>();		
		for (int i = 0; i < userIds.size(); i++) {			
			results.addAll(getProcessInstances (userIds.get(i)));
		}
		return results;
	}
//	end
	public void signalBackTask(List<WorkflowParam> params) {
		
		long taskId = -1;
		String transition = null;
		String receiverId = null;
//		String senderId = null;
		String processor = null; // yenlt 24052010
		String isDelegate = null; // yenlt 24052010
		String processInformation = null;
		Date dateProcess = null;
		
		// get process instance
		taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		ProcessInstance pi = getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		long processId = pi.getId();
		
		// get fileId from processId
		String fileId = getFileIdFromProcessId(processId);
		
		// get parameters
		transition = WorkflowParamUtil.getString(params, "transition", null);
		String temp = WorkflowParamUtil.getString(params, "dateProcess", "");
		try {
			dateProcess = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(temp);
		} catch (Exception e) {}
		
		// get parameters
		receiverId = WorkflowParamUtil.getString(params, "receiverId", null);
//		senderId = WorkflowParamUtil.getString(params, "senderId", null);
		processor = WorkflowParamUtil.getString(params, "processor", null);//yenlt 24052010
		isDelegate = WorkflowParamUtil.getString(params, "isDelegate", null);//yenlt 24052010
		processInformation = WorkflowParamUtil.getString(params, "processInformation", null);

		// load current Log information
		PmlProcessDispose log = getCurrentLogFromFileId(fileId);
		log.setProcessInfomation(processInformation);
		
		try {
			log.setReceiver(Long.parseLong(receiverId));	
		} catch (Exception e) {
		}
		
		if (dateProcess == null) {
			dateProcess = new Date();
		}

		log.setDateProcess(dateProcess);
		//yenlt update 24052010
		// update truong hop nguoi duoc uy quyen xu ly ho so
		long userLoginId = Long.parseLong(processor);
		if (isDelegate.equals("true")) {
			log.setDelegateUser(userLoginId);
		}
		// end yenlt 24052010
		
		// minh update 20100428
		List<Long> listUserNodeBack = (List<Long>) getJbpmService().getContextVariable(processId, "listUserNodeBack");
		// end minh update 20100428
		
		// signal to next node
		signalTask(taskId,  transition, receiverId);			
		
		// minh update 20100428
		listUserNodeBack.remove(listUserNodeBack.get(listUserNodeBack.size() -1));
		getJbpmService().setContext(processId, "listUserNodeBack",listUserNodeBack);
		// end minh update 20100428
		
		// set StateProcessIdAfter for current log.
		long processStateAfterId = getStateProcessFromCode(getState(fileId)).getStateProcessId();
		log.setStateProcessIdAfter(processStateAfterId);
		// persistence log information
		try {
			PmlProcessDisposeLocalServiceUtil.updatePmlProcessDispose(log);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// log new information here
		if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
			logNewNode(fileId, receiverId, processId, dateProcess, processStateAfterId, false);
		}
		
	}
	
	public User getUserBackProcess(String fileId) {
		PmlWfOnedoorProcess pmlWfOnedoorProcess = null;
		User user = null;
		try {
			pmlWfOnedoorProcess = PmlWfOnedoorProcessLocalServiceUtil.getPmlWfOnedoorProcess(fileId);
			
		} catch (Exception e) {
		}
		
		if (pmlWfOnedoorProcess != null) {
			List<Long> userIds  =(List<Long>) (getJbpmService().getContextVariable(pmlWfOnedoorProcess.getProcessId(), "listUserNodeBack"));
			try {
				if (userIds != null && !userIds.isEmpty()) {
					user = UserLocalServiceUtil.getUser(userIds.get(userIds.size() - 1));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return user;
	}
	//yenlt update 24052010
	public List<ProcessInstance> getListProcessInstanceOfActor(long userId) {
		return this.getJbpmService().getListProcessInstanceOfActor(userId);
	}
	// end yenlt 24052010
	// yenlt update rang buoc delete quy trinh == 28082010
	public ProcessDefinition getProcessDefinitionByNameAndVersion(String processName, int version) {
		ProcessDefinition pd = getJbpmService().findProcessDefinitionWithNameAndVersion(processName, version);
		return pd;
	}
	
	public boolean checkProcessInstanceAllEndFromProcessDefinition(long processDefinitionId) {
		boolean flag = true;
		List<ProcessInstance> processInstanceList = new ArrayList<ProcessInstance>();
		processInstanceList = getJbpmService().getListProcessInstanceFromProcessDefinition(processDefinitionId);
		if (null != processInstanceList && processInstanceList.size() > 0) {
			for (int i = 0; i < processInstanceList.size(); i++) {
				ProcessInstance processInstance = processInstanceList.get(i);
				if (getJbpmService().getProcessInstance(processInstance.getId()).getEnd() == null) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	// end yenlt 28082010
}
