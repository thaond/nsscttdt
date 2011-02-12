package com.sgs.portlet.vanbannoibo.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.portal.SystemException;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;

public class VanBanNoiBoLiferayWorkflowService extends AbstractLiferayWorkflowService{
	
	private final static Logger log = Logger.getLogger(VanBanNoiBoLiferayWorkflowService.class);
	
	public VanBanNoiBoLiferayWorkflowService(){
		
	}
	
	@Override
	public void addWorkflowInstance(List<WorkflowParam> params) {
//
//		// get necessary parameters include documentId and fileId
//		long documentReceiptId = WorkflowParamUtil.getLong(params, "documentReceiptId", 0);
//		String userId = WorkflowParamUtil.getString(params, "userId", "");
//
//		if ((documentReceiptId == 0) || "".equals(userId)) {
//			log.info("Can't create Workflow Instance: Parameter invalid");
//			return;
//		}
//		long processInstanceId = -1;
//		List<PmlDocumentReceiptLog> listTemp =
//			new ArrayList<PmlDocumentReceiptLog>();
//
//		try {
//			listTemp =
//				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(
//					documentReceiptId, Long.parseLong(userId));
//			if (listTemp.size() == 1) {
//				return;
//			}
//			else {
//				try {
//					ProcessInstance pi =
//						getJbpmService().createProcessInstance(
//							PROCESS_NAME_RECEIPT);
//
//					// get processId and set userId to instance.
//					processInstanceId = pi.getId();
//					getJbpmService().setContext(
//						processInstanceId, "actorId", userId);
//
//					// write log here & signal to next node
//					getJbpmService().signalProcessInstance(processInstanceId);
//
//					// persistence documentReceipt
//					try {
//						PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
//						pmlEdmDocumentReceipt =
//							PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
//						pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
//							getStateNode(processInstanceId)).getStateProcessId());
//						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
//					}
//					catch (Exception e) {
//					}
//
//					// up date table pml_documentreceipt_wf
//					PmlDocumentReceiptWF pmlDocumentReceiptWF =
//						new PmlDocumentReceiptWFImpl();
//					pmlDocumentReceiptWF.setDocumentReceiptId(documentReceiptId);
//					pmlDocumentReceiptWF.setProcessId(processInstanceId);
//					pmlDocumentReceiptWF.setIsMain("1");
//
//					PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWF);
//				}
//				catch (Exception e) {
//					log.error("ERROR: no add workflow instance");
//					e.printStackTrace();
//				}
//
//				// process log for document
//				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
//				try {
//					pmlEdmDocumentReceipt =
//						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//
//				if (pmlEdmDocumentReceipt != null) {
//					// persistence log
//					logNewNode(
//						documentReceiptId, userId, processInstanceId,
//						pmlEdmDocumentReceipt.getDateArrive(), 0, 1);
//				}
//			}
//		}
//		catch (NumberFormatException e1) {
//			log.error(e1.getMessage());
//		}
//		catch (SystemException e1) {
//			log.error(e1.getMessage());
//		}
	}


	@Override
	public void signalTask(List<WorkflowParam> params) {

//		// variables for write log
//		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
//		String transition =
//			WorkflowParamUtil.getString(params, "transition", null);
//		String receiverId =
//			WorkflowParamUtil.getString(params, "receiverId", null);
//		String processInformation =
//			WorkflowParamUtil.getString(params, "processInformation", "");
//		Date dateProcess = new Date();
//		long directprocessor =
//			WorkflowParamUtil.getLong(params, "directprocessor", 0);
//		if ((taskId == -1) || (transition == null)) {
//			return;
//		}
//
//		try {
//
//			// get process instance
//			ProcessInstance pi =
//				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
//			long processId = pi.getId();
//
//			// get state process
//			String stateProcessCode = getStateNode(processId);
//			PmlStateProcess stateProcess =
//				getStateProcessFromCode(stateProcessCode);
//
//			// get documnentReceiptId from processId
//			long documentReceiptId =
//				getdocumentReceiptIdFromProcessId(processId);
//
//			// load current Log information
//			// PmlDocumentReceiptLog pmlDocumentReceiptLog =
//			// getCurrentDocumentReceiptLog(documentReceiptId,stateProcess,
//			// processor);
//			PmlDocumentReceiptLog pmlDocumentReceiptLog =
//				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
//					processId, stateProcess.getStateProcessId(), null).get(0);
//			if (receiverId != null) {
//				pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverId));
//
//			}
//
//			// phmphuc update phong ban nhan 12/04/2010
//			PmlUser pmlUserNhan = null;
//			try {
//				pmlUserNhan =
//					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverId));
//			}
//			catch (Exception e) {
//			}
//			if (pmlUserNhan != null) {
//				pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
//			}
//			// end
//			pmlDocumentReceiptLog.setProcessInfomation(processInformation);
//			pmlDocumentReceiptLog.setDateProcess(dateProcess);
//			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
//
//			getJbpmService().signalTask(taskId, transition);
//
//			// set StateProcessIdAfter for current log.
//			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
//				getStateNode(processId)).getStateProcessId());
//			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
//			// persistence log information
//			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);
//
//			// persistence documentReceipt
//			PmlMainSupport pmlMainSupport = null;
//			try {
//				pmlMainSupport = PmlMainSupportUtil.findByPrimaryKey(processId);
//			}
//			catch (Exception e) {
//
//			}
//			if (pmlMainSupport == null) {
//				try {
//
//					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
//					pmlEdmDocumentReceipt =
//						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
//					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
//						getStateNode(processId)).getStateProcessId());
//					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
//				}
//				catch (Exception e) {
//				}
//			}
//
//			// log new information here
//			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
//				logNewNode(
//					documentReceiptId, receiverId, processId, dateProcess,
//					pmlDocumentReceiptLog.getType_(),
//					pmlDocumentReceiptLog.getStep() + 1);
//			}
//
//			else {
//				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
//				try {
//					pmlEdmDocumentReceipt =
//						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
//				}
//				catch (Exception e) {
//				}
//
//				if (pmlEdmDocumentReceipt != null) {
//					/*
//					 * yenlt close start 07062010 if
//					 * ((!"".equals(pmlEdmDocumentReceipt
//					 * .getMainDepartmentProcessId()))) { //YENLT 16/04/2010
//					 * List<PmlDocumentReceiptLog> logList = null;
//					 * PmlDocumentReceiptLog logEnd = null; logList =
//					 * PmlDocumentReceiptLogUtil
//					 * .findByDocumentReceiptId_Type(pmlEdmDocumentReceipt
//					 * .getDocumentReceiptId(), 0); Collections.sort(logList,
//					 * new Comparator<PmlDocumentReceiptLog>() { public int
//					 * compare(PmlDocumentReceiptLog o1, PmlDocumentReceiptLog
//					 * o2) { int sort = o1.getTransition_() -
//					 * o2.getTransition_(); return sort; } }); logEnd =
//					 * logList.get(logList.size() - 1); PmlUser endUser = null;
//					 * endUser =
//					 * PmlUserLocalServiceUtil.getPmlUser(logEnd.getProcesser
//					 * ());
//					 * pmlEdmDocumentReceipt.setMainDepartmentProcessId(endUser
//					 * .getDepartmentsId());
//					 * pmlEdmDocumentReceipt.setMainUserProcessId
//					 * (endUser.getUserId());
//					 * PmlEdmDocumentReceiptLocalServiceUtil
//					 * .updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt); }
//					 * yenlt close end 07062010
//					 */
//					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
//						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
//						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
//						// minh update 20101116
//						// getJbpmService().deleteProcessInstance(processId);
//						// end minh update 20101116
//					}
//				}
//			}
//
//		}
//		catch (Exception e) {
//			log.error("ERROR: no signal task ");
//			e.printStackTrace();
//		}
	}
}
