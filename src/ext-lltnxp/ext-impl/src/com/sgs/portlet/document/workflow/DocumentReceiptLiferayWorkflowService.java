/**
 * 
 */

package com.sgs.portlet.document.workflow;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.sgs.liferay.jbpm.component.TaskAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalServiceUtil;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.model.PmlMainSupport;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendWFImpl;
import com.sgs.portlet.document.model.impl.PmlMainSupportImpl;
import com.sgs.portlet.document.model.impl.PmlStateProcessImpl;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentSendWFLocalServiceUtil;
import com.sgs.portlet.document.service.PmlMainSupportLocalServiceUtil;
import com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.service.persistence.PmlMainSupportUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowUtil;
import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.model.impl.PmlMessageImpl;
import com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil;
import com.sgs.portlet.message_note.service.persistence.PmlMessageUtil;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.DocumentReceiptUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * @author hieuvh
 * @author minhnv
 */
@SuppressWarnings("unchecked")
public class DocumentReceiptLiferayWorkflowService
	extends AbstractLiferayWorkflowService {

	private final static Logger log =
		Logger.getLogger(DocumentReceiptLiferayWorkflowService.class);

	public final static String TYPE_PB = "PB";
	public final static String TYPE_CV = "CV";
	public final static String TYPE_LD = "LD";
	public final static String TYPE_BC = "BC";

	public final static String PROCESS_NAME_RECEIPT = "congvandenchinh";
	public final static String PROCESS_NAME_DEPARTMENT_SUPPORT =
		"congvanphucapphong";
	public final static String PROCESS_NAME_USER_SUPPORT =
		"congvanphucapchuyenvien";
	public final static String PROCESS_NAME_LDB_SUPPORT =
		"congvanphucaplanhdao";
	public final static String PROCESS_NAME_BC_SUPPORT = "congvanphubaocao";

	public final static String PROCESS_INFOMATION = "tu-dong-hoan-thanh";

	/**
	 * Now for test, initial "CVDENCHINH" process
	 */
	public DocumentReceiptLiferayWorkflowService() {

	}

	/**
	 * @param workflowParams
	 */
	public void addDocumentReturnWorkflow(List<WorkflowParam> params) {

		// get necessary parameters include documentId and fileId
		long documentSendId =
			WorkflowParamUtil.getLong(params, "documentSendId", 0);
		String userId = WorkflowParamUtil.getString(params, "processor", "");

		if ((documentSendId == 0) || "".equals(userId)) {
			log.info("ERROR: Parameter invilidate");
			return;
		}

		try {
			ProcessInstance pi =
				getJbpmService().createProcessInstance(
					DocumentSendLiferayWorkflowService.PROCESSNAME);
			// get processId
			long processInstanceId = pi.getId();
			getJbpmService().setContext(processInstanceId, "actorId", userId);
			getJbpmService().setContext(processInstanceId, "creator", userId);

			// signal to next node & log here
			getJbpmService().signalProcessInstance(processInstanceId);

			// persistence status into documentSend
			try {

				PmlEdmDocumentSend pmlEdmDocumentSend = null;
				pmlEdmDocumentSend =
					PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				pmlEdmDocumentSend.setStatusId(getStateProcessFromCode(
					getStateNode(processInstanceId)).getStateProcessId());
				pmlEdmDocumentSend.setDateCreated(new Date());
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			// up date table pml_documentreceipt_wf
			PmlDocumentSendWF pmlDocumentSendWF = new PmlDocumentSendWFImpl();
			pmlDocumentSendWF.setProcessId(processInstanceId);
			pmlDocumentSendWF.setDocumentSendId(documentSendId);
			PmlDocumentSendWFLocalServiceUtil.addPmlDocumentSendWF(pmlDocumentSendWF);

			// log
			PmlEdmDocumentSend pmlEdmDocumentSend = null;
			try {
				pmlEdmDocumentSend =
					PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
			}
			catch (NoSuchPmlEdmDocumentSendException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			if (pmlEdmDocumentSend != null) {
				// persistence log
				logNewNodeSend(
					documentSendId, userId, processInstanceId,
					pmlEdmDocumentSend.getDateCreated(), 0, 1);
			}
		}
		catch (Exception e) {
			log.error("ERROR: no add workflow instance");
			e.printStackTrace();
		}

		signalTask(params);

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#addWorkflowInstance
	 * (java.util.List)
	 */
	public void addWorkflowInstance(List<WorkflowParam> params) {

		// get necessary parameters include documentId and fileId
		long documentReceiptId =
			WorkflowParamUtil.getLong(params, "documentReceiptId", 0);
		String userId = WorkflowParamUtil.getString(params, "userId", "");

		if ((documentReceiptId == 0) || "".equals(userId)) {
			log.info("Can't create Workflow Instance: Parameter invalid");
			return;
		}
		long processInstanceId = -1;
		List<PmlDocumentReceiptLog> listTemp =
			new ArrayList<PmlDocumentReceiptLog>();

		try {
			listTemp =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(
					documentReceiptId, Long.parseLong(userId));
			if (listTemp.size() == 1) {
				return;
			}
			else {
				try {
					ProcessInstance pi =
						getJbpmService().createProcessInstance(
							PROCESS_NAME_RECEIPT);

					// get processId and set userId to instance.
					processInstanceId = pi.getId();
					getJbpmService().setContext(
						processInstanceId, "actorId", userId);

					// write log here & signal to next node
					getJbpmService().signalProcessInstance(processInstanceId);

					// persistence documentReceipt
					try {
						PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
						pmlEdmDocumentReceipt =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
						pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
							getStateNode(processInstanceId)).getStateProcessId());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
					catch (Exception e) {
					}

					// up date table pml_documentreceipt_wf
					PmlDocumentReceiptWF pmlDocumentReceiptWF =
						new PmlDocumentReceiptWFImpl();
					pmlDocumentReceiptWF.setDocumentReceiptId(documentReceiptId);
					pmlDocumentReceiptWF.setProcessId(processInstanceId);
					pmlDocumentReceiptWF.setIsMain("1");

					PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWF);
				}
				catch (Exception e) {
					log.error("ERROR: no add workflow instance");
					e.printStackTrace();
				}

				// process log for document
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
					e.printStackTrace();
				}

				if (pmlEdmDocumentReceipt != null) {
					// persistence log
					logNewNode(
						documentReceiptId, userId, processInstanceId,
						pmlEdmDocumentReceipt.getDateArrive(), 0, 1);
				}
			}
		}
		catch (NumberFormatException e1) {
			log.error(e1.getMessage());
		}
		catch (SystemException e1) {
			log.error(e1.getMessage());
		}
	}

	public boolean checkProcessInstanceAllEndFromProcessDefinition(
		long processDefinitionId) {

		boolean flag = true;
		List<ProcessInstance> processInstanceList =
			new ArrayList<ProcessInstance>();
		processInstanceList =
			getJbpmService().getListProcessInstanceFromProcessDefinition(
				processDefinitionId);
		if ((null != processInstanceList) && (processInstanceList.size() > 0)) {
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

	/**
	 * @param userId
	 * @param processId
	 * @return
	 */
	public boolean checkUserInDocumentReceiptWorkflow(
		long userId, long processId) {

		boolean rs =
			getJbpmService().checkUserInCurrentTasks(
				processId, String.valueOf(userId));
		if (rs) {
			return rs;
		}

		PmlUser pmlUser = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
				PmlDepartmentsLeaderUtil.findByDepartmentsId_UserId(
					pmlUser.getDepartmentsId(), userId);

			if ((pmlDepartmentsLeaderList != null) &&
				(pmlDepartmentsLeaderList.size() > 0)) {

				// String user = "LDP_"+ pmlUser.getDepartmentsId();//kiem tra
				String user = pmlUser.getDepartmentsId();
				rs =
					getJbpmService().checkUserInCurrentTasks(
						processId, String.valueOf(user));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Delete a Document Receipt after receive it.
	 * 
	 * @param params
	 */
	public void deleteDocumentReceipt(List<WorkflowParam> params) {

		// get necessary parameters include documentReceiptId
		long documentReceiptId =
			WorkflowParamUtil.getLong(params, "documentReceiptId", 0);
		if (documentReceiptId == 0) {
			log.info("ERROR: param invalidate");
			return;
		}

		try {
			List<PmlDocumentReceiptWF> list =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptIdIsMain(
					documentReceiptId, "1");
			if ((list != null) && (list.size() > 0)) {
				long processInstanceId = list.get(0).getProcessId();
				getJbpmService().deleteProcessInstance(processInstanceId);
				PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWFByRecId(documentReceiptId);
			}
		}
		catch (Exception e) {
			log.error("ERROR: no delete document receipt");
			e.printStackTrace();
		}
	}

	/**
	 * Now for test, use deploy support process
	 * 
	 * @param packageProcess
	 * @param nameProcess
	 *            void Mar 14, 2009 com.sgs.portlet.document.workflow
	 */

	public void deloyProcessSupport(
		InputStream is, String nameWorkflow, int type, String description) {

		ProcessDefinition processDefinition = deployWorkflow(is);
		int version = processDefinition.getVersion();
		// minh update ngay 18/11/2009 // yenlt update 06/04/2010
		List<String> nodeNameList =
			getJbpmService().getListNodeName(processDefinition);

		List<PmlStateProcess> pmlStateProcessList = null;
		try {
			pmlStateProcessList =
				PmlStateProcessUtil.findByStateProcessName(TYPE_CV);
		}
		catch (SystemException e1) {
			pmlStateProcessList = new ArrayList<PmlStateProcess>();
		}

		boolean flag = false;
		PmlStateProcess pmlStateProcess = null;
		long id = 0;
		for (String nodeName : nodeNameList) {
			flag = false;
			for (int i = 0; i < pmlStateProcessList.size(); i++) {
				if (nodeName.equals(pmlStateProcessList.get(i).getStateProcessCode())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				try {
					id = CounterLocalServiceUtil.increment();
				}
				catch (SystemException e) {
					id = 0;
				}
				pmlStateProcess = new PmlStateProcessImpl();
				pmlStateProcess.setStateProcessId(id);
				pmlStateProcess.setStateProcessCode(nodeName);
				pmlStateProcess.setStateProcessName(TYPE_CV);
				try {
					PmlStateProcessLocalServiceUtil.addPmlStateProcess(pmlStateProcess);
				}
				catch (SystemException e) {
					log.error("ERROR: no upadate PmlStateProcess in method deloyProcessSupport " +
						DocumentReceiptLiferayWorkflowService.class);
				}
			}

		}
		// end update ngay 18/11/2009
		long workflowID = 0;
		try {
			workflowID = CounterLocalServiceUtil.increment();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		// set value into PmlManageWorkDocumentFlow
		PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow =
			PmlManageWorkDocumentFlowLocalServiceUtil.createPmlManageWorkDocumentFlow(workflowID);
		pmlManageWorkDocumentFlow.setWorkFlowName(nameWorkflow);
		pmlManageWorkDocumentFlow.setVersion(version);
		pmlManageWorkDocumentFlow.setType(type);
		pmlManageWorkDocumentFlow.setDescription(description);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateFormat.format(new Date()));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		pmlManageWorkDocumentFlow.setStartDate(new Timestamp(date.getTime()));
		// persistence
		try {
			PmlManageWorkDocumentFlowLocalServiceUtil.updatePmlManageWorkDocumentFlow(pmlManageWorkDocumentFlow);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		if (processDefinition.getVersion() > 1) {
			List<PmlManageWorkDocumentFlow> pmlManageWorkDocumentFlowList =
				new ArrayList<PmlManageWorkDocumentFlow>();
			try {
				pmlManageWorkDocumentFlowList =
					PmlManageWorkDocumentFlowUtil.findByWorkFlowName(nameWorkflow);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}

			for (PmlManageWorkDocumentFlow item : pmlManageWorkDocumentFlowList) {
				if (item.equals(pmlManageWorkDocumentFlow)) {
					continue;
				}

				if (item.getEndDate() == null) {
					item.setEndDate(new Timestamp(date.getTime()));
					try {
						PmlManageWorkDocumentFlowLocalServiceUtil.updatePmlManageWorkDocumentFlow(item);
						break;
					}
					catch (SystemException e) {
						e.printStackTrace();
					}

				}
			}

		}
	}

	/**
	 * This method gets a row but receipt document at current position in table
	 * Pml_DocumentReceipt_Log
	 * 
	 * @param documentReceiptId
	 *            : is id of receipt document
	 * @param receiverId
	 *            : is id of user receipt document
	 * @return PmlDocumentReceiptLog
	 */
	public PmlDocumentReceiptLog getCurrentDocumentReceiptLog(
		long documentReceiptId, PmlStateProcess pmlStateProcess, long processer) {

		List<PmlDocumentReceiptLog> list = null;
		try {
			list =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_StateProcessIdBefore_Processor(
					documentReceiptId, pmlStateProcess.getStateProcessId(),
					processer);
		}
		catch (SystemException e) {
			log.error("ERROR: in method getCurrentDocumentReceiptLog in class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}

		// check if list null or empty
		if ((list == null) || list.isEmpty()) {
			return null;
		}

		// get log no dateProcess
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : list) {
			if (pmlDocumentReceiptLog.getDateProcess() == null) {
				return pmlDocumentReceiptLog;
			}
		}

		return list.get(0);
	}

	/**
	 * get current state of document receipt
	 * 
	 * @param documentReceiptId
	 * @return
	 */
	public String getCurrentStateOfDocumentReceipt(
		long documentReceiptId, long userId) {

		String currentState = null;
		try {
			List<PmlDocumentReceiptWF> listPmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);

			long processInstanceId = -1;

			for (Iterator iter = listPmlDocumentReceiptWF.iterator(); iter.hasNext();) {
				PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) iter.next();
				processInstanceId = wf.getProcessId();
				if (checkUserInDocumentReceiptWorkflow(
					userId, processInstanceId)) {
					return currentState = getStateNode(processInstanceId);
				}
			}

		}
		catch (Exception e) {
			log.error("ERROR: no get current state of document receipt");
			e.printStackTrace();
		}
		return currentState;
	}

	/**
	 * This method gets id of document receipt approach with a process
	 * definition instance
	 * 
	 * @param processId
	 *            : id of process definition instance
	 * @return long: is id of document receipt approach with a process
	 *         definition instance
	 * @return -1: if id of process definition instance illegal
	 */
	private long getdocumentReceiptIdFromProcessId(long processId) {

		// get fileId from processId
		PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
		long documentReceiptId = -1;

		try {
			pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processId);

			if (pmlDocumentReceiptWF == null) {
				return documentReceiptId;
			}

			documentReceiptId = pmlDocumentReceiptWF.getDocumentReceiptId();

		}
		catch (Exception e) {
			log.error("ERROR: in method getdocumentReceiptIdFromProcessId in class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}

		return documentReceiptId;
	}

	/**
	 * @param processId
	 * @param processStateId
	 * @param receiptDate
	 * @return
	 */
	private Date getExpiredDate(
		long processId, long processStateId, Date receiptDate) {

		Date expireDate = null;
		ProcessInstance pi = getJbpmService().getProcessInstance(processId);
		ProcessDefinition pd = pi.getProcessDefinition();
		int version = pd.getVersion();
		String name = pd.getName();
		try {
			List<PmlStateWorkFlow> stateWfs =
				PmlStateWorkFlowUtil.findByWorkFlow_StateProcessId_Version(
					name, processStateId, version);
			PmlStateWorkFlow stateWorkFlow = stateWfs.get(0);
			int solving = stateWorkFlow.getSolvingTime();
			int dateSolving = 0;
			if (solving % Constants.HOUR_WORK_IN_DAY != 0) {
				dateSolving = (solving / Constants.HOUR_WORK_IN_DAY) + 1;
			}
			dateSolving = (solving / Constants.HOUR_WORK_IN_DAY);
			long time =
				receiptDate.getTime() + (long) dateSolving * 24 * 60 * 60 *
					1000;
			expireDate = new Date(time);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return expireDate;
	}

	public List<PmlEdmDocumentReceipt> getListDocumentByStatusId(
		long userId, long fileStatusId)
		throws Exception {

		List<PmlEdmDocumentReceipt> listDocumentByUser =
			getListPmlEdmDocumentReceiptsByUser(userId);
		List<PmlEdmDocumentReceipt> results =
			new ArrayList<PmlEdmDocumentReceipt>();

		List<PmlStateProcess> stateProcessList =
			PmlStateProcessUtil.findByFileStatusId(fileStatusId);

		for (PmlStateProcess pmlStateProcess : stateProcessList) {
			long stateProcessId = pmlStateProcess.getStateProcessId();

			List<PmlDocumentReceiptLog> logList =
				PmlDocumentReceiptLogUtil.findByStateProcessIdBefore(stateProcessId);
			for (PmlDocumentReceiptLog pmlDocumentReceiptLog : logList) {
				long documentReceiptId =
					pmlDocumentReceiptLog.getDocumentReceiptId();
				PmlEdmDocumentReceipt documentReceipt =
					PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
				if (listDocumentByUser.contains(documentReceipt) &&
					!results.contains(documentReceipt)) {
					// minh update 2009/10/31
					documentReceipt.setStatusId(pmlDocumentReceiptLog.getStateProcessIdAfter());
					// end
					results.add(documentReceipt);
				}
			}
		}

		return results;
	}

	/**
	 * get list PmlEdmDocumentReceipt of user with status concrete
	 * 
	 * @param userId
	 * @param fileStatusId
	 * @return
	 * @throws Exception
	 *             List<PmlEdmDocumentReceipt> Aug 24, 2009
	 *             com.sgs.portlet.document.workflow
	 */
	public List<PmlEdmDocumentReceipt> getListDocumentOfUserHadProcessByStatusId(
		long userId, long fileStatusId) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceiptTemp = null;
		try {
			List<PmlStateProcess> stateProcessList =
				PmlStateProcessUtil.findByFileStatusId(fileStatusId);

			List<String> stateProcessCodeList = new ArrayList<String>();
			if (stateProcessList != null) {
				for (PmlStateProcess pmlStateProcess : stateProcessList) {
					stateProcessCodeList.add(pmlStateProcess.getStateProcessCode());
				}
			}

			List<ProcessInstance> processInstanceList =
				new ArrayList<ProcessInstance>();
			if (!stateProcessCodeList.isEmpty()) {
				processInstanceList =
					getJbpmService().getListProcessInstanceOfActorHadProcessWithState(
						userId, stateProcessCodeList);
			}

			if (processInstanceList != null) {
				for (ProcessInstance processInstance : processInstanceList) {
					long processInstanceId = processInstance.getId();
					// find id of document with process id
					PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
					try {
						pmlDocumentReceiptWF =
							PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
					}
					catch (Exception e) {
					}

					// add to result list if exist document receipt
					if (pmlDocumentReceiptWF != null) {
						long documentReceiptId =
							pmlDocumentReceiptWF.getDocumentReceiptId();

						pmlEdmDocumentReceiptTemp =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);

						if (pmlEdmDocumentReceiptTemp != null) {
							// minh update 2009/10/29
							String stateProcess =
								getStateNode(processInstanceId);
							long stateProcessId = 0;
							try {
								stateProcessId =
									PmlStateProcessUtil.findByStateProcessCode(
										stateProcess).get(0).getStateProcessId();
							}
							catch (Exception e) {
							}

							pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
							// end
							listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
						}
					}
				}
			}

		}
		catch (Exception e) {
		}

		return listPmlEdmDocumentReceipt;
	}

	/**
	 * get all PmlEdmDocumentReceipt of User.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PmlEdmDocumentReceipt> getListPmlEdmDocumentReceiptsByUser(
		long userId) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceiptTemp = null;

		try {
			if (userId != 0) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstanceOfActor(userId);

				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					for (ProcessInstance processInstance : listProcessInstance) {
						long processInstanceId = processInstance.getId();
						// find id of document with process id
						PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
						try {
							pmlDocumentReceiptWF =
								PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
						}
						catch (Exception e) {
						}

						// add to result list if exist document receipt
						if (pmlDocumentReceiptWF != null) {
							long documentReceiptId =
								pmlDocumentReceiptWF.getDocumentReceiptId();

							pmlEdmDocumentReceiptTemp =
								PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);

							if (pmlEdmDocumentReceiptTemp != null) {

								// minh update 2009/10/29
								String stateProcess =
									getStateNode(processInstanceId);
								long stateProcessId = 0;
								try {
									stateProcessId =
										PmlStateProcessUtil.findByStateProcessCode(
											stateProcess).get(0).getStateProcessId();
								}
								catch (Exception e) {

								}
								pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
								// end
								listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt");
			e.printStackTrace();
		}
		return listPmlEdmDocumentReceipt;
	}

	/**
	 * get all PmlEdmDocumentReceipt of User.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PmlEdmDocumentReceipt> getListPmlEdmDocumentReceiptsByUser(
		String userId, String type, String valueType) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();
		try {
			if (!"0".equalsIgnoreCase(userId)) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstanceOfActor(userId);

				log.info("list process instance: " + listProcessInstance);
				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					listPmlEdmDocumentReceipt =
						getListPmlEdmDocumentReceiptsByUserHelp(
							listProcessInstance, type, valueType);
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt");
			e.printStackTrace();
		}
		return listPmlEdmDocumentReceipt;
	}

	/**
	 * get all PmlEdmDocumentReceipt of User had process.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PmlEdmDocumentReceipt> getListPmlEdmDocumentReceiptsByUserHadProcess(
		long userId) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceiptTemp = null;

		try {
			if (userId != 0) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstancesUserHadProcess(
						userId);

				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					for (ProcessInstance processInstance : listProcessInstance) {
						long processInstanceId = processInstance.getId();
						// find id of document with process id
						PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
						try {
							pmlDocumentReceiptWF =
								PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
						}
						catch (Exception e) {
						}

						// add to result list if exist document receipt
						if (pmlDocumentReceiptWF != null) {
							long documentReceiptId =
								pmlDocumentReceiptWF.getDocumentReceiptId();

							pmlEdmDocumentReceiptTemp =
								PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);

							if (pmlEdmDocumentReceiptTemp != null) {
								// minh update 2009/10/29
								String stateProcess =
									getStateNode(processInstanceId);
								long stateProcessId = 0;
								try {
									stateProcessId =
										PmlStateProcessUtil.findByStateProcessCode(
											stateProcess).get(0).getStateProcessId();
								}
								catch (Exception e) {

								}
								pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
								// end
								listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt");
			e.printStackTrace();
		}
		return listPmlEdmDocumentReceipt;
	}

	public List<PmlEdmDocumentReceipt> getListPmlEdmDocumentReceiptsByUserHelp(
		List<ProcessInstance> listProcessInstance, String type, String valueType) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();
		PmlEdmDocumentReceipt pmlEdmDocumentReceiptTemp = null;

		try {
			for (ProcessInstance processInstance : listProcessInstance) {
				long processInstanceId = processInstance.getId();
				// find id of document with process id
				PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
				try {
					pmlDocumentReceiptWF =
						PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
				}
				catch (Exception e) {
				}

				// add to result list if exist document receipt
				if (pmlDocumentReceiptWF != null) {
					long documentReceiptId =
						pmlDocumentReceiptWF.getDocumentReceiptId();

					pmlEdmDocumentReceiptTemp =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					log.info("pmlEdmDocumentReceiptTemp: " +
						pmlEdmDocumentReceiptTemp);

					if ((type != null) && !"".equals(type.trim())) {
						if (pmlEdmDocumentReceiptTemp != null) {
							if (valueType != null) {
								valueType = valueType.trim();
							}

							if ("socongvanden".equals(type)) {
								if (pmlEdmDocumentReceiptTemp.getNumberDocumentReceipt().toUpperCase().contains(
									valueType.toUpperCase())) {
									// minh update 2009/10/29
									String stateProcess =
										getStateNode(processInstanceId);
									long stateProcessId = 0;
									try {
										stateProcessId =
											PmlStateProcessUtil.findByStateProcessCode(
												stateProcess).get(0).getStateProcessId();
									}
									catch (Exception e) {

									}
									pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
									// end
									listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
								}
							}
							else if ("sohieucongvan".equals(type)) {
								if (pmlEdmDocumentReceiptTemp.getDocumentReference().toUpperCase().contains(
									valueType.toUpperCase())) {
									// minh update 2009/10/29
									String stateProcess =
										getStateNode(processInstanceId);
									long stateProcessId = 0;
									try {
										stateProcessId =
											PmlStateProcessUtil.findByStateProcessCode(
												stateProcess).get(0).getStateProcessId();
									}
									catch (Exception e) {

									}
									pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
									// end
									listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
								}
							}
							else if ("trichyeu".equals(type)) {
								if (pmlEdmDocumentReceiptTemp.getBriefContent().toUpperCase().contains(
									valueType.toUpperCase())) {
									// minh update 2009/10/29
									String stateProcess =
										getStateNode(processInstanceId);
									long stateProcessId = 0;
									try {
										stateProcessId =
											PmlStateProcessUtil.findByStateProcessCode(
												stateProcess).get(0).getStateProcessId();
									}
									catch (Exception e) {

									}
									pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
									// end
									listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
								}
							}
						}
					}
					else {
						log.info("khong co tu khoa loc");
						if (pmlEdmDocumentReceiptTemp != null) {
							// minh update 2009/10/29
							String stateProcess =
								getStateNode(processInstanceId);
							long stateProcessId = 0;
							try {
								stateProcessId =
									PmlStateProcessUtil.findByStateProcessCode(
										stateProcess).get(0).getStateProcessId();
							}
							catch (Exception e) {

							}
							pmlEdmDocumentReceiptTemp.setStatusId(stateProcessId);
							// end
							listPmlEdmDocumentReceipt.add(pmlEdmDocumentReceiptTemp);
						}
					}
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listPmlEdmDocumentReceipt;
	}

	/**
	 * Get PmlEdmDocumentReceipt with userId and process state List
	 * 
	 * @param userId
	 * @param type
	 * @param valueType
	 * @param processState
	 * @return List<PmlEdmDocumentReceipt>
	 */
	public List<PmlEdmDocumentReceipt> getListPmlEdmDocumentReceiptsByUserWithState(
		String userId, String type, String valueType, List<String> processState) {

		List<PmlEdmDocumentReceipt> listPmlEdmDocumentReceipt =
			new ArrayList<PmlEdmDocumentReceipt>();

		try {
			if (!"0".equalsIgnoreCase(userId)) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstanceOfActorWithState(
						Long.parseLong(userId), processState);

				log.info("list process instance: " + listProcessInstance);
				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					listPmlEdmDocumentReceipt =
						getListPmlEdmDocumentReceiptsByUserHelp(
							listProcessInstance, type, valueType);
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt with process state list");
			e.printStackTrace();
		}
		return listPmlEdmDocumentReceipt;
	}

	/**
	 * get all document of a department
	 * 
	 * @param userIds
	 * @param fileStatusId
	 * @return List<ProcessInstance>
	 */
	public List<Long> getListProcessInstanceByStatusId(
		List<Long> userIds, long fileStatusId) {

		List<Long> results = new ArrayList<Long>();
		for (int i = 0; i < userIds.size(); i++) {
			results.addAll(getListProcessInstanceByStatusId(
				userIds.get(i), fileStatusId));
		}
		return results;
	}

	/**
	 * get all document with status of a user
	 * 
	 * @param userIds
	 * @param fileStatusId
	 * @return List<Long>
	 */
	public List<Long> getListProcessInstanceByStatusId(
		long userId, long fileStatusId) {

		List<String> smallStatus = new ArrayList<String>();
		List<Long> results = new ArrayList<Long>();
		// lay cac id cua trang thai nho
		List<PmlFileStatusStateProcess> pmlFileStatusStateProcessList =
			new ArrayList<PmlFileStatusStateProcess>();
		try {
			pmlFileStatusStateProcessList =
				PmlFileStatusStateProcessUtil.findByFileStatusId(fileStatusId);
		}
		catch (Exception e) {
			pmlFileStatusStateProcessList =
				new ArrayList<PmlFileStatusStateProcess>();
		}

		// lay cac ten node cua quy trinh
		PmlStateProcess pmlStateProcess = null;
		for (PmlFileStatusStateProcess pmlFileStatusStateProcess : pmlFileStatusStateProcessList) {
			try {
				pmlStateProcess =
					PmlStateProcessUtil.findByPrimaryKey(pmlFileStatusStateProcess.getStateProcessId());
			}
			catch (Exception e) {
				pmlStateProcess = null;
			}

			if (pmlStateProcess != null) {
				smallStatus.add(pmlStateProcess.getStateProcessCode());
			}
		}

		List<ProcessInstance> resultsTemp =
			getJbpmService().getListProcessInstanceOfActorWithState(
				userId, smallStatus);

		for (ProcessInstance processInstance : resultsTemp) {
			results.add(processInstance.getId());
		}

		return results;
	}

	/**
	 * get all log components and sort it by create date.
	 * 
	 * @param documentReceiptId
	 * @return
	 */
	@SuppressWarnings({
		"unused", "null"
	})
	public List<DocumentReceiptLogComponent> getLog(long documentReceiptId) {

		try {
			List<PmlDocumentReceiptWF> listPDRWF =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
			if ((listPDRWF != null) || (listPDRWF.size() != 0)) {
				for (PmlDocumentReceiptWF pDRWF : listPDRWF) {
					long processInstanceId = pDRWF.getPrimaryKey();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// yenlt update rang buoc delete quy trinh == 28082010
	public ProcessDefinition getProcessDefinitionByNameAndVersion(
		String processName, int version) {

		ProcessDefinition pd =
			getJbpmService().findProcessDefinitionWithNameAndVersion(
				processName, version);
		return pd;
	}

	// xac dinh dung the hien khi chuyen toi nhieu phong va nhieu nguoi
	protected long getProcessInstanceId(long documentReceiptId, long userId) {

		// find a WF_DocumentReceipt entry with given fileId
		List<PmlDocumentReceiptWF> wfs = null;

		try {
			wfs =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		// if not exist WF_DocumentReceipt entry return -1
		if (Validator.isNull(wfs)) {
			return -1;
		}

		for (Iterator it = wfs.iterator(); it.hasNext();) {
			PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) it.next();
			boolean hasRight =
				checkUserInDocumentReceiptWorkflow(userId, wf.getProcessId());

			if (hasRight) {
				return wf.getProcessId();
			}
		}

		return -1;
	}

	public List<Long> getProcessInstances(List<Long> userIds) {

		List<Long> results = new ArrayList<Long>();
		for (int i = 0; i < userIds.size(); i++) {
			results.addAll(getProcessInstances(userIds.get(i)));
		}
		return results;
	}

	/**
	 * Lay tat ca cong van ung voi mot user cu the
	 * 
	 * @param userIds
	 * @param fileStatusId
	 * @return List<ProcessInstance>
	 */
	public List<Long> getProcessInstances(long userId) {

		List<ProcessInstance> processInstanceList =
			getJbpmService().getListProcessInstanceOfActor(
				String.valueOf(userId));

		List<Long> results = new ArrayList<Long>();
		for (int i = 0; i < processInstanceList.size(); i++) {
			results.add(processInstanceList.get(i).getId());
		}
		return results;
	}

	/**
	 * get current state of pml_file with given fileId
	 * 
	 * @param fileId
	 * @return
	 */
	public String getState(long documentReceiptId) {

		String state = null;
		String nodeName = null;

		try {
			List<PmlDocumentReceiptWF> pmlDocumentReceiptWfs =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
			PmlDocumentReceiptWF pmlDocumentReceiptWf = null;
			if ((pmlDocumentReceiptWfs != null) &&
				(pmlDocumentReceiptWfs.size() > 0)) {
				pmlDocumentReceiptWf = pmlDocumentReceiptWfs.get(0);
			}
			// get current node name of process instance.
			nodeName =
				getJbpmService().getNodeName(
					pmlDocumentReceiptWf.getProcessId());

			// split it by : separator
			String[] values =
				nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);
			state = values[0];
		}
		catch (Exception e) {
			log.error("ERROR: No Can't Get State Of WF With FileId [" +
				documentReceiptId + "]");
			e.printStackTrace();
		}
		return state;
	}

	/**
	 * This method gets state of process (PmlStateProcess)
	 * 
	 * @param stateProcessCode
	 *            : code of state process
	 * @return PmlStateProcess: is PmlStateProcess object if code of state
	 *         process exist
	 * @return null: if code of state process no exist
	 */
	private PmlStateProcess getStateProcessFromCode(String stateProcessCode) {

		List<PmlStateProcess> list = null;
		PmlStateProcess stateProcess = null;

		// find pml_state_process list from code.
		try {
			list = PmlStateProcessUtil.findByStateProcessCode(stateProcessCode);

			// check exist state process.
			if ((list == null) || (list.size() <= 0)) {
				// no log if state process not found
				return null;
			}

			// get pml_state_process
			for (int i = 0; i < list.size(); i++) {
				if (TYPE_CV.equals(list.get(i).getStateProcessName())) {
					return list.get(i);
				}
			}
			// stateProcess = list.get(0);

		}
		catch (Exception e) {
			log.error("ERROR: in method getStateProcessFromCode in class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}

		return stateProcess;
	}

	/**
	 * get user process node before (thao tac tra cv lai)
	 * 
	 * @param documentSendId
	 * @return User Aug 15, 2009 com.sgs.portlet.document.workflow
	 */
	public User getUserProcess(long documentReceiptId) {

		// minh update 20100419
		// PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
		List<PmlDocumentReceiptWF> pmlDocumentReceiptWFList = null;
		User user = null;
		try {
			// pmlDocumentReceiptWF =
			// PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId).get(0);
			pmlDocumentReceiptWFList =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
		}
		catch (Exception e) {
			pmlDocumentReceiptWFList = new ArrayList<PmlDocumentReceiptWF>();
		}
		// if (pmlDocumentReceiptWF != null) {
		for (PmlDocumentReceiptWF pmlDocumentReceiptWF : pmlDocumentReceiptWFList) {
			List<Long> userIds =
				(List<Long>) (getJbpmService().getContextVariable(
					pmlDocumentReceiptWF.getProcessId(), "listUserNodeBack"));
			// end minh update 20100419

			try {
				if ((userIds != null) && !userIds.isEmpty()) {
					user =
						UserLocalServiceUtil.getUser(userIds.get(userIds.size() - 1));
					return user;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	/**
	 * @param workflowParams
	 */
	public void giveSupportInformation(List<WorkflowParam> workflowParams) {

		signalTask(workflowParams);
	}

	/**
	 * phmphuc 02/12/2010 them moi dong entry giong nhu log
	 */
	private PmlMessage logNewMessage(
		long documentReceiptId, long fromUserId, long toUserId) {

		// add log information
		PmlMessage message = new PmlMessageImpl();
		// id
		long messageId = -1;

		try {
			messageId = CounterLocalServiceUtil.increment();

			message.setMessageId(messageId);
			message.setDocumentId(documentReceiptId);
			message.setFromUserId(fromUserId);
			message.setToUserId(toUserId);
			message.setObjectType(PmlEdmDocumentReceiptImpl.class.getName());
			message.setCreateDate(new Date());
			message.setIsAlert(false);

			PmlMessageLocalServiceUtil.addPmlMessage(message);
		}
		catch (Exception e) {
		}

		return message;
	}

	// end phmphuc them 02/12/2010

	/**
	 * This method add a line data in table Pml_DocumentReceipt_Log
	 * 
	 * @param documentReceiptId
	 *            : id of document receipt
	 * @param userId
	 *            : id of user but receipt document
	 * @param processId
	 *            : id of process definition
	 * @param receiptDate
	 *            : is date but processor receipt document
	 * @param type
	 *            : for know process main or support
	 * @return PmlDocumentReceiptLog
	 */
	private PmlDocumentReceiptLog logNewNode(
		long documentReceiptId, String userId, long processId,
		Date sendDateBefore, int type, int nextStep) {

		// add log information
		PmlDocumentReceiptLog pmlDocumentReceiptLog =
			new PmlDocumentReceiptLogImpl();
		// id of PmlDocumentReceiptLog
		long documentReceiptLogId = -1;
		try {
			documentReceiptLogId = CounterLocalServiceUtil.increment();

			// get state process code from process instance
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// write information to log
			pmlDocumentReceiptLog.setDocumentReceiptLogId(documentReceiptLogId);
			// pmlDocumentReceiptLog.setReceiveDate(receiptDate);

			pmlDocumentReceiptLog.setDocumentReceiptId(documentReceiptId);
			pmlDocumentReceiptLog.setProcesser(Long.parseLong(userId));
			pmlDocumentReceiptLog.setStateProcessIdBefore(stateProcess.getStateProcessId());
			pmlDocumentReceiptLog.setType_(type);
			pmlDocumentReceiptLog.setProcessInstanceId(processId);

			// phmphuc update column phong xu ly 12/04/2010
			PmlUser pmlUserXuLy = null;
			try {
				pmlUserXuLy =
					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(userId));
			}
			catch (Exception e) {
			}
			if (pmlUserXuLy != null) {
				pmlDocumentReceiptLog.setDepartmentProcessId(pmlUserXuLy.getDepartmentsId());
			}
			// end

			// set number of log row for a fileId.
			pmlDocumentReceiptLog.setTransition_(PmlDocumentReceiptLogUtil.countByDocumentReceiptId(documentReceiptId) + 1);
			// pmlDocumentReceiptLog.setExpiredDate(getExpiredDate(processId,
			// processId, receiptDate));
			// yenlt update 12/04/2010
			if (1 != pmlDocumentReceiptLog.getTransition_()) {
				pmlDocumentReceiptLog.setSendDateBefore(sendDateBefore);
			}
			// end

			// Canh
			// List<PmlDocumentReceiptLog> documentReceiptLogs =
			// PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
			// documentReceiptId, Long.parseLong(userId),
			// pmlDocumentReceiptLog.getStateProcessIdBefore(),
			// pmlDocumentReceiptLog.getTransition_());
			// if (documentReceiptLogs.isEmpty()) {
			// pmlDocumentReceiptLog.setStep(1);
			// }
			// else {
			// pmlDocumentReceiptLog.setStep(documentReceiptLogs.get(0).getStep()
			// + 1);
			// }
			if (nextStep < 1) {
				nextStep = 1;
			}
			pmlDocumentReceiptLog.setStep(nextStep);
			// End of Canh

			// persistence log.
			pmlDocumentReceiptLog =
				PmlDocumentReceiptLogLocalServiceUtil.addPmlDocumentReceiptLog(pmlDocumentReceiptLog);

		}
		catch (Exception e) {
			log.error("ERROR: in method logNewNode in class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}

		return pmlDocumentReceiptLog;
	}

	// minh update 18/11/2009

	/**
	 * This method adds a line data in table Pml_DocumentSend_Log
	 * 
	 * @param documentSendId
	 *            : id of document send
	 * @param userId
	 *            : id of user receipt send document
	 * @param processId
	 *            : id of process definition
	 * @param receiptDate
	 *            : is receipt date send document
	 * @return PmlDocumentSendLog
	 */
	@SuppressWarnings("unused")
	private PmlDocumentSendLog logNewNodeSend(
		long documentSendId, String userId, long processId, Date receiptDate,
		int typeProcess, int step) {

		// add log information
		PmlDocumentSendLog pmlDocumentSendLog = new PmlDocumentSendLogImpl();
		// id of PmlDocumentReceiptLog
		long pmlDocumentSendLogId = -1;
		try {
			pmlDocumentSendLogId = CounterLocalServiceUtil.increment();

			// get state process code from process instance
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// write information to log
			pmlDocumentSendLog.setPrimaryKey(pmlDocumentSendLogId);
			// pmlDocumentSendLog.setReceiveDate(receiptDate); //yenlt close
			// 15/04/2010
			pmlDocumentSendLog.setDocumentSendId(documentSendId);
			pmlDocumentSendLog.setProcesser(Long.parseLong(userId));
			pmlDocumentSendLog.setStateProcessIdBefore(stateProcess.getStateProcessId());
			pmlDocumentSendLog.setProcessInstanceId(processId);
			pmlDocumentSendLog.setType_(typeProcess);
			pmlDocumentSendLog.setStep(step);
			// set number of log row for a fileId.
			pmlDocumentSendLog.setTransition_(PmlDocumentSendLogUtil.countByDocumentSendId(documentSendId) + 1);

			/*
			 * phmphuc close 18/06/2010 - yeu cau buoc chuyen dau tien
			 * (transition_ = 1) thi senddatebefore is null if (1 ==
			 * pmlDocumentSendLog.getTransition_() ) {
			 * pmlDocumentSendLog.setSendDateBefore(receiptDate); }
			 */

			// yenlt update 16/04/2010 cap nhat phong ban xu ly
			PmlUser pmlUser = null;
			pmlUser =
				PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(userId));
			pmlDocumentSendLog.setDepartmentProcessId(pmlUser.getDepartmentsId());
			// end
			// persistence log.
			PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);
			// yenlt update 15/04/2010 // cap nhat receivedate trong truong hop
			// soan cong van di tra loi cho cong van den
			PmlDocumentReceiptLog documentReceiptLog = null;
			List<PmlDocumentReceiptLog> documentReceiptLogList =
				new ArrayList<PmlDocumentReceiptLog>();
			PmlEdmDocumentReceipt documentReceipt = null;
			long documentReceiptId = 0;
			PmlEdmAnswerDetail answerDetail = null;
			List<PmlEdmAnswerDetail> answerDetailList =
				new ArrayList<PmlEdmAnswerDetail>();

			answerDetailList =
				PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);

			if (answerDetailList.size() > 0) {
				answerDetail = answerDetailList.get(0);
				documentReceiptId = answerDetail.getDocumentReceiptId();
				documentReceiptLogList =
					PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Type(
						documentReceiptId, 0);

				/*
				 * phmphuc update 15/06/2010 - sap xep theo transition cap nhat
				 * ngay nhan cua receiver trong t/h soan vb di tra loi vb den
				 */
				Collections.sort(
					documentReceiptLogList,
					new Comparator<PmlDocumentReceiptLog>() {

						public int compare(
							PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

							int sort =
								o2.getTransition_() - o1.getTransition_();
							return sort;
						}
					});
				// end

				// phmphuc close 15/06/2010
				// int transition = 1;
				if (documentReceiptLogList.size() != 0) {
					/*
					 * if (documentReceiptLogList.size() > 1) { transition =
					 * documentReceiptLogList.size() -1; } documentReceiptLog =
					 * documentReceiptLogList.get(transition); end
					 */
					documentReceiptLog = documentReceiptLogList.get(0);
					documentReceiptLog.setReceiveDate(receiptDate);
					documentReceiptLog.setReceiveDateTime(receiptDate);
					PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(documentReceiptLog);
				}
			}
			// end
		}
		catch (Exception e) {
			log.error("ERROR: in method logNewNode in class " +
				DocumentSendLiferayWorkflowService.class);
			e.printStackTrace();
		}
		return pmlDocumentSendLog;
	}

	/**
	 * @param workflowParams
	 */
	public void processDocumentReceipt(List<WorkflowParam> workflowParams) {

		// write log here and call signal task
		signalTaskToAgency(workflowParams);
	}

	// end 18/11/2009

	// minh 25/11/2009

	public void signalBackDocumentReceipt(List<WorkflowParam> params) {

		// variables for write log
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", null);
		String receiverId =
			WorkflowParamUtil.getString(params, "receiverId", null);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		Date dateProcess = new Date();
		// yenlt update rut lai vb 20101119
		String rutLai = WorkflowParamUtil.getString(params, "rutLai", "");
		String processor = WorkflowParamUtil.getString(params, "processor", "");
		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh
		// end yenlt update 20101119
		if ((taskId == -1) || (transition == null)) {
			return;
		}

		try {
			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// get documnentReceiptId from processId
			long documentReceiptId =
				getdocumentReceiptIdFromProcessId(processId);

			// load current Log information
			// PmlDocumentReceiptLog pmlDocumentReceiptLog =
			// getCurrentDocumentReceiptLog(documentReceiptId,stateProcess,
			// processor);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);

			// yenlt 07072010 : get processer
			long userProcess = pmlDocumentReceiptLog.getProcesser();
			List<PmlDepartmentsLeader> departmentsLeaderList =
				new ArrayList<PmlDepartmentsLeader>();
			try {
				departmentsLeaderList =
					PmlDepartmentsLeaderUtil.findByUserId(userProcess);
			}
			catch (Exception e) {
			}
			// end yenlt 07072010
			// yenlt update 20101119 == rut lai van ban
			int transitionLogBack = 0;
			Date sendDateBefore = pmlDocumentReceiptLog.getSendDateBefore();

			if (!Boolean.parseBoolean(rutLai)) { // end yenlt 20101119
				if (receiverId != null) {
					pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverId));
				}
				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan =
						PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverId));
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// end

				pmlDocumentReceiptLog.setProcessInfomation(processInformation);
				pmlDocumentReceiptLog.setDateProcess(dateProcess);
				pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
				// set StateProcessIdAfter for current log.
				pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
					getStateNode(processId)).getStateProcessId());

				// Canh
				pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
				// End of Canh

				// persistence log information
				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);
			}
			else { // start yenlt update 20101119
					// xoa dong log cuoi cung = dong cua nguoi duoc phan cong xu
					// ly
					// chinh
				PmlDocumentReceiptLogLocalServiceUtil.deletePmlDocumentReceiptLog(pmlDocumentReceiptLog);

				// xoa nhung dong log sinh ra tu user rut lai vb
				Date dateProcessTime = null;
				List<PmlDocumentReceiptLog> logMainDelete =
					new ArrayList<PmlDocumentReceiptLog>();
				try {
					logMainDelete =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(
							documentReceiptId, Long.parseLong(processor));
				}
				catch (Exception e) {
					e.printStackTrace();
					// logMainDelete = new ArrayList<PmlDocumentReceiptLog>();
				}

				Collections.sort(
					logMainDelete, new Comparator<PmlDocumentReceiptLog>() {

						public int compare(
							PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

							int sort =
								o2.getTransition_() - o1.getTransition_();
							return sort;
						}
					});
				transitionLogBack = logMainDelete.get(0).getTransition_();
				if (logMainDelete.get(0).getDateProcessTime() != null) {
					dateProcessTime = logMainDelete.get(0).getDateProcessTime();
				}
				for (PmlDocumentReceiptLog logReturnTemp : logMainDelete) {
					if ((logReturnTemp.getDateProcessTime() != null) &&
						logReturnTemp.getDateProcessTime().equals(
							dateProcessTime) &&
						"".equals(logReturnTemp.getMainDepartmentProcessId()) &&
						(0 == logReturnTemp.getMainUserProcessId())) {
						// xoa nhung dong tu processor chuyen cho phong hay user
						// phu
						if (transitionLogBack > logReturnTemp.getTransition_()) {
							transitionLogBack = logReturnTemp.getTransition_();
						}
						PmlDocumentReceiptLogLocalServiceUtil.deletePmlDocumentReceiptLog(logReturnTemp);
					}
				}

				// cap nhat dong log dau tien cua nguoi rut VB ve trang thai ban
				// dau
				String stateProcessCodeEnd = getStateNode(processId);
				PmlStateProcess stateProcessEnd =
					getStateProcessFromCode(stateProcessCodeEnd);
				List<PmlDocumentReceiptLog> listemp =
					PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdAfter_DateProcess(
						processId, stateProcessEnd.getStateProcessId(),
						sendDateBefore);
				if ((null != listemp) && !listemp.isEmpty()) {
					PmlDocumentReceiptLog pmlDocumentReceiptLogEnd =
						listemp.get(0);
					pmlDocumentReceiptLogEnd.setDateProcess(null);
					pmlDocumentReceiptLogEnd.setReceiver(0);
					pmlDocumentReceiptLogEnd.setProcessInfomation("");
					pmlDocumentReceiptLogEnd.setStateProcessIdAfter(0);
					pmlDocumentReceiptLogEnd.setExpiredDate(null);
					pmlDocumentReceiptLogEnd.setNumDateProcess(0);
					pmlDocumentReceiptLogEnd.setExpiredDate(null);
					pmlDocumentReceiptLogEnd.setMainDepartmentProcessId("");
					pmlDocumentReceiptLogEnd.setMainUserProcessId(0);
					pmlDocumentReceiptLogEnd.setDepartmentReceiveId("");
					pmlDocumentReceiptLogEnd.setDateProcessTime(null);
					pmlDocumentReceiptLogEnd.setReceiveDateTime(null);
					PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLogEnd);

				}
			}

			List<String> listNodeBack =
				(List<String>) getJbpmService().getContextVariable(
					processId, "listNodeBack");
			List<Long> listUserNodeBack =
				(List<Long>) getJbpmService().getContextVariable(
					processId, "listUserNodeBack");
			// yenlt update 20101119
			if (Boolean.parseBoolean(rutLai)) {
				signalTask(
					taskId, listNodeBack.get(listNodeBack.size() - 1),
					processor);
			}
			else {
				signalTask(
					taskId, listNodeBack.get(listNodeBack.size() - 1),
					receiverId);
			}
			// signalTask(taskId, listNodeBack.get(listNodeBack.size()-1),
			// receiverId); // yenlt close 20101119
			// end yenlt update 20101119

			listNodeBack.remove(listNodeBack.get(listNodeBack.size() - 1));
			// yenlt update 12082010
			// listUserNodeBack.remove(listUserNodeBack.get(listUserNodeBack.size()
			// -1));
			listUserNodeBack.remove(listUserNodeBack.size() - 1);
			// end yenlt update 12082010

			getJbpmService().setContext(processId, "listNodeBack", listNodeBack);
			getJbpmService().setContext(
				processId, "listUserNodeBack", listUserNodeBack);
			// set StateProcessIdAfter for current log.
			// pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(getStateNode(processId)).getStateProcessId());

			// persistence log information
			// PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupport = null;
			try {
				pmlMainSupport = PmlMainSupportUtil.findByPrimaryKey(processId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupport == null) {
				try {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				if (!Boolean.parseBoolean(rutLai)) {// yenlt update 20101119
					logNewNode(
						documentReceiptId, receiverId, processId, dateProcess,
						pmlDocumentReceiptLog.getType_(),
						pmlDocumentReceiptLog.getStep() + 1);
				}
				// logNewNode(documentReceiptId, receiverId, processId,
				// dateProcess, pmlDocumentReceiptLog.getType_());
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}

			// yenlt update 07072010
			String stateProcessName = "";
			PmlStateProcess stateProcessHoanThanh = null;
			List<PmlDocumentReceiptLog> listLog =
				new ArrayList<PmlDocumentReceiptLog>();
			List<PmlDocumentReceiptLog> listLogMain =
				new ArrayList<PmlDocumentReceiptLog>();
			PmlDocumentReceiptLog receiptLog = null;
			try {
				listLog =
					PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			}
			catch (Exception e) {
			}
			if (Boolean.parseBoolean(rutLai)) { // start yenlt 20101119
				List<PmlMainSupport> pmlMainSupportList = null;
				try {
					pmlMainSupportList =
						PmlMainSupportUtil.findByProcessIdMain(processId);
				}
				catch (Exception e) {
					pmlMainSupportList = new ArrayList<PmlMainSupport>();
				}
				List<PmlDocumentReceiptLog> pmlDocumentReceiptLogs =
					new ArrayList<PmlDocumentReceiptLog>();
				for (int i = 0; i < pmlMainSupportList.size(); i++) {
					long processIdHelp =
						pmlMainSupportList.get(i).getProcessId();
					List<PmlMainSupport> mainSupportByProcessId = null;
					mainSupportByProcessId =
						PmlMainSupportUtil.findByProcessIdMain(processIdHelp);
					if (mainSupportByProcessId.size() == 0) {
						stateProcessName = getStateNode(processIdHelp);
						stateProcessHoanThanh =
							getStateProcessFromCode(stateProcessName);
						pmlDocumentReceiptLogs =
							PmlDocumentReceiptLogUtil.findByProcessInstanceId(processIdHelp);
						// xoa dong xu ly phu duoc nhan len khi chuyen
						boolean flagWFSDelete = false;
						for (PmlDocumentReceiptLog pmlDocumentReceiptLogSecondary : pmlDocumentReceiptLogs) {
							if ((pmlDocumentReceiptLogSecondary.getTransition_() > transitionLogBack) &&
								(pmlDocumentReceiptLogSecondary.getDateProcess() == null)) {
								for (;;) {
									if (getJbpmService().getProcessInstance(
										processIdHelp).getEnd() == null) {
										List<TaskInstance> listTaskInstance =
											getJbpmService().getListTasksNode(
												processIdHelp);
										TaskInstance taskInstance = null;
										for (int j = 0; j < listTaskInstance.size(); j++) {
											taskInstance =
												listTaskInstance.get(j);
											if ((taskInstance != null) &&
												(taskInstance.getEnd() == null)) {
												String taskTransition =
													taskInstance.getName().split(
														":")[2];
												getJbpmService().signalTask(
													taskInstance.getId(),
													taskTransition);
												listTaskInstance =
													getJbpmService().getListTasksNode(
														processIdHelp);
											}
										}
									}
									else {
										break;
									}
								}
								PmlDocumentReceiptLogLocalServiceUtil.deletePmlDocumentReceiptLog(pmlDocumentReceiptLogSecondary);
								flagWFSDelete = true;
							}
						}
						// xoa trong bang receipt WF
						if (flagWFSDelete) {
							long processIdWFS = processIdHelp;
							PmlDocumentReceiptWF wfs = null;
							try {
								wfs =
									PmlDocumentReceiptWFUtil.findByPrimaryKey(processIdWFS);
							}
							catch (Exception e) {
								log.error(e.getMessage());
							}
							if (null != wfs) {
								PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWF(wfs);
							}
							// xoa trong bang mainSupport
							try {
								PmlMainSupportLocalServiceUtil.deletePmlMainSupport(processIdHelp);
							}
							catch (Exception e) {
								log.error(e.getMessage());
							}
						}
					}
				}
			}
			else { // end yenlt update 20101119
					// khi nguoi nhan bao cao tra lai
				List<PmlMainSupport> pMSList = new ArrayList<PmlMainSupport>();

				try {
					pMSList =
						PmlMainSupportUtil.findByprocessIdMain_Type(
							processId, TYPE_BC);
				}
				catch (Exception e) {
					log.error("ERROR: get list PmlMainSupport from processInstanceId=[" +
						processId +
						"] and type=[" +
						TYPE_BC +
						"] " +
						e.getMessage());
				}

				if (pMSList == null) {
					pMSList = new ArrayList<PmlMainSupport>();
				}

				Collections.sort(pMSList, new Comparator<PmlMainSupport>() {

					public int compare(PmlMainSupport o1, PmlMainSupport o2) {

						return (int) (o1.getProcessId() - o2.getProcessId());
					}

				});
				int pMSListSize = pMSList.size();
				boolean isProcessInstanceReport = false;
				long processInstanceReportSupprotFinalId = 0;
				for (int i = pMSListSize - 1; i >= 0; i--) {
					if (getJbpmService().getProcessInstance(
						pMSList.get(i).getProcessId()).getEnd() == null) {
						processInstanceReportSupprotFinalId =
							pMSList.get(i).getProcessId();
						isProcessInstanceReport = true;
						break;
					}
				}

				if (isProcessInstanceReport) {
					PmlDocumentReceiptLog documentReceiptLogSupportFinal = null;
					List<PmlDocumentReceiptLog> documentReceiptLogSupportFinals =
						new ArrayList<PmlDocumentReceiptLog>();
					try {
						documentReceiptLogSupportFinals =
							PmlDocumentReceiptLogUtil.findByProcessInstanceId_Type(
								processInstanceReportSupprotFinalId, 4);

						Collections.sort(
							documentReceiptLogSupportFinals,
							new Comparator<PmlDocumentReceiptLog>() {

								public int compare(
									PmlDocumentReceiptLog o1,
									PmlDocumentReceiptLog o2) {

									return (o1.getTransition_() - o2.getTransition_());
								}

							});
						documentReceiptLogSupportFinal =
							documentReceiptLogSupportFinals.get(0);
					}
					catch (Exception e) {
					}

					List<PmlDocumentReceiptLog> documentReceiptLogSuppors =
						new ArrayList<PmlDocumentReceiptLog>();
					try {
						documentReceiptLogSuppors =
							PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Type(
								documentReceiptId, 4);
					}
					catch (Exception e) {
					}

					if (documentReceiptLogSuppors == null) {
						documentReceiptLogSuppors =
							new ArrayList<PmlDocumentReceiptLog>();
					}
					List<TaskInstance> listTaskInstance = null;
					for (PmlDocumentReceiptLog pmlDoLog : documentReceiptLogSuppors) {
						if (documentReceiptLogSupportFinal != null) {
							if ((pmlDoLog.getDateProcessTime() != null) &&
								(documentReceiptLogSupportFinal.getDateProcessTime().getTime() == pmlDoLog.getDateProcessTime().getTime())) {
								listTaskInstance =
									getJbpmService().getListTasksNode(
										pmlDoLog.getProcessInstanceId());
								for (int j = 0; j < listTaskInstance.size(); j++) {
									TaskInstance taskInstance =
										listTaskInstance.get(j);
									if ((taskInstance != null) &&
										(taskInstance.getEnd() == null)) {
										String taskTransition =
											taskInstance.getName().split(":")[2];
										getJbpmService().signalTask(
											taskInstance.getId(),
											taskTransition);
										listTaskInstance =
											getJbpmService().getListTasksNode(
												pmlDoLog.getProcessInstanceId());
									}
								}

								for (PmlDocumentReceiptLog pmlDoLog1 : documentReceiptLogSuppors) {
									if ((pmlDoLog1.getProcessInstanceId() == pmlDoLog.getProcessInstanceId()) &&
										(pmlDoLog1.getDateProcessTime() == null)) {
										stateProcessName =
											getStateNode(pmlDoLog1.getProcessInstanceId());
										stateProcessHoanThanh =
											getStateProcessFromCode(stateProcessName);
										pmlDoLog1.setDateProcess(dateProcess);
										pmlDoLog1.setDateProcessTime(dateProcess);
										pmlDoLog1.setStateProcessIdAfter(stateProcessHoanThanh.getStateProcessId());
										pmlDoLog1.setProcessInfomation(PortletProps.get(PROCESS_INFOMATION));
										PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDoLog1);
									}
								}
							}
						}
					}
				}

				// truong hop TP tra VB
				else if (0 != departmentsLeaderList.size()) {
					receiptLog =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(
							documentReceiptId, 1).get(0);
					listLogMain =
						PmlDocumentReceiptLogUtil.findByProcessInstanceId(receiptLog.getProcessInstanceId());
					listLog.removeAll(listLogMain);
					// add nhung quy trinh phu
					for (int i = 0; i < listLog.size(); i++) {
						PmlDocumentReceiptLog secondaryLog = listLog.get(i);
						if (secondaryLog.getDateProcess() == null) {
							long processInstanceId =
								secondaryLog.getProcessInstanceId();
							// ket thuc trong taskInstance cua user phu
							for (;;) {
								if (getJbpmService().getProcessInstance(
									processInstanceId).getEnd() == null) {
									List<TaskInstance> listTaskInstance =
										getJbpmService().getListTasksNode(
											processInstanceId);
									for (int j = 0; j < listTaskInstance.size(); j++) {
										TaskInstance taskInstance =
											listTaskInstance.get(j);
										if ((taskInstance != null) &&
											(taskInstance.getEnd() == null)) {
											String taskTransition =
												taskInstance.getName().split(
													":")[2];
											getJbpmService().signalTask(
												taskInstance.getId(),
												taskTransition);
											listTaskInstance =
												getJbpmService().getListTasksNode(
													processInstanceId);
										}
									}
								}
								else {
									break;
								}
							}
							stateProcessName = getStateNode(processInstanceId);
							stateProcessHoanThanh =
								getStateProcessFromCode(stateProcessName);
							secondaryLog.setDateProcess(dateProcess);
							secondaryLog.setDateProcessTime(dateProcess);
							secondaryLog.setStateProcessIdAfter(stateProcessHoanThanh.getStateProcessId());
							secondaryLog.setProcessInfomation(PortletProps.get(PROCESS_INFOMATION));
							PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(secondaryLog);
						}
					}
				}
				else {// truong hop CV tra VB
					List<PmlMainSupport> pmlMainSupportList = null;
					try {
						pmlMainSupportList =
							PmlMainSupportUtil.findByprocessIdMain_Type(
								processId, TYPE_CV);
					}
					catch (Exception e) {
						pmlMainSupportList = new ArrayList<PmlMainSupport>();
					}
					List<PmlDocumentReceiptLog> pmlDocumentReceiptLogs =
						new ArrayList<PmlDocumentReceiptLog>();
					for (int i = 0; i < pmlMainSupportList.size(); i++) {
						long processIdHelp =
							pmlMainSupportList.get(i).getProcessId();
						// ket thuc trong taskInstance cua user phu
						for (;;) {
							if (getJbpmService().getProcessInstance(
								processIdHelp).getEnd() == null) {
								List<TaskInstance> listTaskInstance =
									getJbpmService().getListTasksNode(
										processIdHelp);
								TaskInstance taskInstance = null;
								for (int j = 0; j < listTaskInstance.size(); j++) {
									taskInstance = listTaskInstance.get(j);
									if ((taskInstance != null) &&
										(taskInstance.getEnd() == null)) {
										String taskTransition =
											taskInstance.getName().split(":")[2];
										getJbpmService().signalTask(
											taskInstance.getId(),
											taskTransition);
										listTaskInstance =
											getJbpmService().getListTasksNode(
												processIdHelp);
									}
								}
							}
							else {
								break;
							}
						}
						stateProcessName = getStateNode(processIdHelp);
						stateProcessHoanThanh =
							getStateProcessFromCode(stateProcessName);

						try {
							// cap nhat trong bang pml_documentReceipt_log nhung
							// dong nhan len
							pmlDocumentReceiptLogs =
								PmlDocumentReceiptLogUtil.findByProcessInstanceId_Type(
									processIdHelp, 2);
							for (PmlDocumentReceiptLog pmlDocumentReceiptLogSecondary : pmlDocumentReceiptLogs) {
								pmlDocumentReceiptLogSecondary.setDateProcess(dateProcess);
								pmlDocumentReceiptLogSecondary.setDateProcessTime(dateProcess);
								pmlDocumentReceiptLogSecondary.setStateProcessIdAfter(stateProcessHoanThanh.getStateProcessId());
								pmlDocumentReceiptLogSecondary.setProcessInfomation(PortletProps.get(PROCESS_INFOMATION));
								PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLogSecondary);
							}
						}
						catch (Exception e) {
						}
					}

				}
				// end yenlt update 07072010
			}

			/*
			 * yenlt close start 07072010 // minh update 20100419
			 * List<PmlMainSupport> pmlMainSupportList = null; try {
			 * pmlMainSupportList =
			 * PmlMainSupportUtil.findByprocessIdMain_Type(processId, TYPE_CV);
			 * } catch (Exception e) { pmlMainSupportList = new
			 * ArrayList<PmlMainSupport>(); } for (int i = 0; i <
			 * pmlMainSupportList.size(); i++) { long processIdHelp =
			 * pmlMainSupportList.get(i).getProcessId(); try { // xoa trong bang
			 * pml_documentReceipt_wf
			 * PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWF
			 * (processIdHelp); } catch (Exception e) {}
			 * List<PmlDocumentReceiptLog> pmlDocumentReceiptLogDeletes = new
			 * ArrayList<PmlDocumentReceiptLog>(); try { // xoa trong bang
			 * pml_documentReceipt_log nhung dong nhan len
			 * pmlDocumentReceiptLogDeletes =
			 * PmlDocumentReceiptLogUtil.findByProcessInstanceId_Type
			 * (pmlMainSupportList.get(i).getProcessId_Main(), 2); for
			 * (PmlDocumentReceiptLog pmlDocumentReceiptLogDelete :
			 * pmlDocumentReceiptLogDeletes) {
			 * PmlDocumentReceiptLogUtil.remove(pmlDocumentReceiptLogDelete); }
			 * } catch (Exception e) {} try { // xoa trong bang
			 * pml_documentReceipt_log nhung dong sinh ra khi chuyen
			 * pmlDocumentReceiptLogDeletes =
			 * PmlDocumentReceiptLogUtil.findByProcessInstanceId_Type
			 * (processIdHelp, 2); for (PmlDocumentReceiptLog
			 * pmlDocumentReceiptLogDelete : pmlDocumentReceiptLogDeletes) {
			 * PmlDocumentReceiptLogUtil.remove(pmlDocumentReceiptLogDelete); }
			 * } catch (Exception e) {} try { // xoa trong bang pml_main_suppost
			 * PmlMainSupportUtil.remove(pmlMainSupportList.get(i)); } catch
			 * (Exception e) {} try { // xoa trong jbpm
			 * getJbpmService().deleteProcessInstance(processIdHelp); } catch
			 * (Exception e) {} } // end minh update 20100419 yenlt close end
			 * 07072010
			 */

			// phmphuc insert bang entry t/h rut lai - 02/12/2010
			if (Boolean.parseBoolean(rutLai)) {
				List<PmlMessage> listMessageRutLai =
					PmlMessageUtil.findByDocumentId_FromUserId_ObjectType(
						documentReceiptId, Long.parseLong(processor),
						PmlEdmDocumentReceiptImpl.class.getName());
				PmlMessageLocalServiceUtil.deletePmlMessageList(listMessageRutLai);
			}
			// phmphuc insert bang entry t/h tra lai - 02/12/2010
			else {
				logNewMessage(
					documentReceiptId, Long.parseLong(processor),
					Long.parseLong(receiverId));
			}
			// end phmphuc insert

		}
		catch (Exception e) {
			log.error("ERROR: no signal task ");
			e.printStackTrace();
		}
	}

	/**
	 * @param params
	 *            void Mar 17, 2009 com.sgs.portlet.document.workflow
	 */
	@SuppressWarnings("unused")
	public void signalDocumentReceiptFromTeamLeaderToReceiptor(
		List<WorkflowParam> params) {

		// minh update 20101117
		boolean checkInfo =
			Boolean.parseBoolean(WorkflowParamUtil.getString(
				params, "checkInfo", "true"));
		// end minh update 20101117
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", "NotAvailable");
		String mainUser = WorkflowParamUtil.getString(params, "mainUser", "");
		String supportedUsers =
			WorkflowParamUtil.getString(params, "supportedUsers", "");
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		String dateNumberProcess =
			WorkflowParamUtil.getString(params, "dateNumberProcess", "0");

		// phmphuc add 18/10/2010 - lay thoi gian xu ly la ngay tu form
		String expireDate =
			WorkflowParamUtil.getString(params, "expireDate", "");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		DocumentReceiptUtil util = new DocumentReceiptUtil();
		if (!dateNumberProcess.equals("0")) {// chon so ngay
			expireDate =
				dateFormat.format(util.getExpectedReturningDate(
					dateNumberProcess, date));
		}
		else {// chon tu calendar
			dateNumberProcess = util.getNumDateProcess(date, expireDate);
		}
		// end phmphuc update 18/11/2010

		Date dateProcess = new Date();
		long processor = WorkflowParamUtil.getLong(params, "processor", -1);
		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh

		if ((taskId == -1) || "NotAvailable".equalsIgnoreCase(transition) ||
			"".equalsIgnoreCase(mainUser) || (processor == -1)) {

			log.info("ERROR: param invalidate");
			return;
		}

		ProcessInstance processInstanceSupport = null;
		PmlMainSupport pmlMainSupport = null;
		PmlDocumentReceiptWF pmlDocumentReceiptWFSupport = null;

		try {
			long processInstanceId =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();
			String[] supportedUsersArr =
				supportedUsers.split(Constants.USER_SEPERATOR);
			PmlDocumentReceiptWF pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
			long documentReceiptId =
				pmlDocumentReceiptWF.getDocumentReceiptId();
			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);
			// UPDATE
			PmlDocumentReceiptLog pmlDocumentReceiptLogHelp =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			for (int i = 0; i < supportedUsersArr.length; i++) {
				if (Long.parseLong(supportedUsersArr[i]) == Long.parseLong(mainUser)) {
					continue;
				}
				// if (!supportedUsersArr[i].equalsIgnoreCase(mainUser) &&
				// !"".equals(supportedUsersArr[i]) ) {

				long userId = Long.parseLong(supportedUsersArr[i]);// yenlt
																	// update
																	// 12/04/2010

				// create instance of support process, signal process support to
				// next node & log here
				processInstanceSupport =
					getJbpmService().createProcessInstance(
						PROCESS_NAME_USER_SUPPORT);
				long processInstanceSupportId = processInstanceSupport.getId();
				getJbpmService().setContext(
					processInstanceSupportId, "actorId",
					String.valueOf(supportedUsersArr[i]));
				getJbpmService().signalProcessInstance(processInstanceSupportId);

				// save into database with table pml_main_support
				pmlMainSupport = new PmlMainSupportImpl();
				pmlMainSupport.setProcessId(processInstanceSupportId);
				pmlMainSupport.setProcessId_Main(processInstanceId);
				pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_CV);
				PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport);

				// save into database with table pml_documentreceipt_wf
				pmlDocumentReceiptWFSupport = new PmlDocumentReceiptWFImpl();
				pmlDocumentReceiptWFSupport.setProcessId(processInstanceSupportId);
				pmlDocumentReceiptWFSupport.setDocumentReceiptId(documentReceiptId);
				pmlDocumentReceiptWFSupport.setIsMain("0");
				PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWFSupport);

				pmlDocumentReceiptLogHelp.setDocumentReceiptLogId(CounterLocalServiceUtil.increment());
				pmlDocumentReceiptLogHelp.setReceiver(userId);
				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan = PmlUserLocalServiceUtil.getPmlUser(userId);
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentReceiptLogHelp.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// end
				// minh update 20101117
				if (checkInfo) {
					pmlDocumentReceiptLogHelp.setProcessInfomation(processInformation);
				}
				else {
					pmlDocumentReceiptLogHelp.setProcessInfomation(WorkflowParamUtil.getString(
						params, "processInformationForUser" +
							supportedUsersArr[i], ""));
				}
				// end minh update 20101117

				pmlDocumentReceiptLogHelp.setNumDateProcess(Integer.parseInt(dateNumberProcess));

				// phmphuc 18/10/2010 - luu thoi gian xu ly la ngay xuong db
				pmlDocumentReceiptLogHelp.setExpiredDate(expireDate != ""
					? new SimpleDateFormat("dd/MM/yyyy").parse(expireDate)
					: null);
				// end phmphuc

				pmlDocumentReceiptLogHelp.setDateProcess(dateProcess);
				pmlDocumentReceiptLogHelp.setDateProcessTime(dateProcess);
				pmlDocumentReceiptLogHelp.setType_(2);// yenlt update 17/04/2010

				// Canh
				pmlDocumentReceiptLogHelp.setDirectProcesserId(directprocessor);
				// End of Canh

				int transitionHelp = 0;
				try {
					transitionHelp =
						PmlDocumentReceiptLogUtil.countByDocumentReceiptId(documentReceiptId) + 1;
				}
				catch (Exception e) {
				}

				pmlDocumentReceiptLogHelp.setTransition_(transitionHelp);

				pmlDocumentReceiptLogHelp =
					PmlDocumentReceiptLogLocalServiceUtil.addPmlDocumentReceiptLog(pmlDocumentReceiptLogHelp);

				PmlDocumentReceiptLog documentReceiptLog =
					logNewNode(
						documentReceiptId, String.valueOf(userId),
						processInstanceSupportId, new Date(), 2,
						pmlDocumentReceiptLogHelp.getStep() + 1);

				pmlDocumentReceiptLogHelp.setStateProcessIdAfter(documentReceiptLog.getStateProcessIdBefore());
				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLogHelp);

				// //logNewNode(documentReceiptId, supportedUsersArr[i],
				// processInstanceSupportId, new Date(), 2);
				// end
				// }

				// phmphuc insert bang entry t/h quy trinh chuyen vien phu -
				// 02/12/2010
				logNewMessage(documentReceiptId, processor, userId);
			}

			// signal process main to next node and write log
			getJbpmService().setContext(
				processInstanceId, "actorId", String.valueOf(mainUser));

			// log for process main
			PmlDocumentReceiptLog documentReceiptLog =
				new PmlDocumentReceiptLogImpl();

			// load current Log information
			// PmlDocumentReceiptLog pmlDocumentReceiptLog =
			// getCurrentDocumentReceiptLog(documentReceiptId, stateProcess,
			// processor);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			pmlDocumentReceiptLog.setReceiver(Long.parseLong(mainUser));
			// phmphuc update phong ban nhan 12/04/2010
			PmlUser pmlUserNhan = null;
			try {
				pmlUserNhan =
					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(mainUser));
			}
			catch (Exception e) {
			}
			if (pmlUserNhan != null) {
				pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
			}
			// end

			// minh update 20101117
			if (checkInfo) {
				pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			}
			else {
				pmlDocumentReceiptLog.setProcessInfomation(WorkflowParamUtil.getString(
					params, "processInformationForUser" + mainUser, ""));
			}
			// end minh update 20101117

			pmlDocumentReceiptLog.setNumDateProcess(Integer.parseInt(dateNumberProcess));

			// phmphuc 18/10/2010 - luu thoi gian xu ly la ngay xuong db
			pmlDocumentReceiptLog.setExpiredDate(expireDate != ""
				? new SimpleDateFormat("dd/MM/yyyy").parse(expireDate) : null);
			// end phmphuc

			if (dateProcess == null) {
				dateProcess = new Date();
			}

			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);

			// Thoi update 20100319
			if (pmlDocumentReceiptLog.getType_() == 0) {
				pmlDocumentReceiptLog.setMainUserProcessId(Long.parseLong(mainUser));
			}
			// end
			// yenlt update 08062010
			List<PmlDocumentReceiptLog> logProcessIdList =
				new ArrayList<PmlDocumentReceiptLog>();
			try {
				// minh update 20100419
				List<String> listNodeBack =
					(List<String>) getJbpmService().getContextVariable(
						processId, "listNodeBack");
				List<Long> listUserNodeBack =
					(List<Long>) getJbpmService().getContextVariable(
						processId, "listUserNodeBack");

				logProcessIdList =
					PmlDocumentReceiptLogUtil.findByProcessInstanceId_Type(
						processId, 0);
				if (logProcessIdList.size() > 0) {
					if (listNodeBack != null) {
						listNodeBack.add(stateProcessCode);
						getJbpmService().setContext(
							processId, "listNodeBack", listNodeBack);
					}
					else {
						listNodeBack = new ArrayList<String>();
						listNodeBack.add(stateProcessCode);
						getJbpmService().setContext(
							processId, "listNodeBack", listNodeBack);
					}

					if (listUserNodeBack != null) {
						listUserNodeBack.add(processor);
						getJbpmService().setContext(
							processId, "listUserNodeBack", listUserNodeBack);
					}
					else {
						listUserNodeBack = new ArrayList<Long>();
						listUserNodeBack.add(processor);
						getJbpmService().setContext(
							processId, "listUserNodeBack", listUserNodeBack);
					}

				}
			}
			catch (Exception e) {
			}
			// end yenlt 08062010

			// end minh update 20100419
			// yenlt update 26072010
			// getJbpmService().endTaskInstance(taskId);
			getJbpmService().signalTask(taskId, transition);
			// end yenlt update 26072010
			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());
			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupportTemp = null;
			try {
				pmlMainSupportTemp =
					PmlMainSupportUtil.findByPrimaryKey(processId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupportTemp == null) {
				try {

					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {

				// yenlt update 17/04/2010
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				List<PmlDocumentReceiptLog> logList = null;
				PmlDocumentReceiptLog logEnd = null;
				logList =
					PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Type(
						pmlEdmDocumentReceipt.getDocumentReceiptId(), 0);
				Collections.sort(
					logList, new Comparator<PmlDocumentReceiptLog>() {

						public int compare(
							PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

							int sort =
								o1.getTransition_() - o2.getTransition_();
							return sort;
						}
					});

				logEnd = logList.get(logList.size() - 1);
				PmlUser endUser = null;
				endUser =
					PmlUserLocalServiceUtil.getPmlUser(logEnd.getProcesser());

				pmlEdmDocumentReceipt.setMainDepartmentProcessId(endUser.getDepartmentsId());
				if (0 != logEnd.getReceiver()) {
					pmlEdmDocumentReceipt.setMainUserProcessId(logEnd.getReceiver());
				}
				PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);

				logNewNode(
					documentReceiptId, String.valueOf(mainUser), processId,
					dateProcess, pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
				// end
			}
			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					// pmlEdmDocumentReceipt.setMainUserProcessId(Long.parseLong(mainUser));
					// pmlEdmDocumentReceipt =
					// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					// if
					// ((!"".equals(pmlEdmDocumentReceipt.getMainDepartmentProcessId())))
					// {
					// pmlEdmDocumentReceipt.setMainDepartmentProcessId(pmlUserNhan.getDepartmentsId());
					// pmlEdmDocumentReceipt.setMainUserProcessId(pmlUserNhan.getUserId());
					// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					// }
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}

			// phmphuc insert bang entry t/h quy trinh chuyen vien chinh -
			// 02/12/2010
			logNewMessage(
				documentReceiptId, processor, Long.parseLong(mainUser));

		}
		catch (Exception e) {
			log.error("ERROR: no signal DocumentReceipt from Department to User");
			e.printStackTrace();
		}
	}

	// end

	/**
	 * signal a document-receipt to a main Department and some support
	 * departments
	 * 
	 * @param workflowParams
	 */
	@SuppressWarnings("unused")
	public void signalDocumentReceiptToDepartment(List<WorkflowParam> params) {

		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", "NotAvailable");
		String mainDepartment =
			WorkflowParamUtil.getString(params, "mainDepartment", "");
		String supportedDepartment =
			WorkflowParamUtil.getString(params, "supportedDepartment", "");

		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		String dateNumberProcess =
			WorkflowParamUtil.getString(params, "dateNumberProcess", "0");
		Date dateProcess = new Date();

		if ((taskId == -1) || "NotAvailable".equalsIgnoreCase(transition) ||
			"".equalsIgnoreCase(mainDepartment)) {
			log.info("ERROR: param invalidate");
			return;
		}

		ProcessInstance processInstanceSupport = null;
		PmlMainSupport pmlMainSupport = null;
		PmlDocumentReceiptWF pmlDocumentReceiptWFSupport = null;

		try {
			long processInstanceId =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();
			String[] supportedDepartmentArr =
				supportedDepartment.split(Constants.DEPARTMENT_SEPERATOR);
			PmlDocumentReceiptWF pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
			long documentReceiptId =
				pmlDocumentReceiptWF.getDocumentReceiptId();

			for (int i = 0; i < supportedDepartmentArr.length; i++) {
				if (supportedDepartmentArr[i].equalsIgnoreCase(mainDepartment)) {
					continue;
				}

				// List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
				// PmlDepartmentsLeaderUtil.findByDepartmentsId(supportedDepartmentArr[i]);
				List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
					PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(
						supportedDepartmentArr[i], true);
				long userId = pmlDepartmentsLeaderList.get(0).getUserId();

				// create instance of support process, signal process support to
				// next node
				processInstanceSupport =
					getJbpmService().createProcessInstance(
						PROCESS_NAME_DEPARTMENT_SUPPORT);

				long processInstanceSupportId = processInstanceSupport.getId();
				getJbpmService().setContext(
					processInstanceSupportId, "actorId", String.valueOf(userId));
				getJbpmService().signalProcessInstance(processInstanceSupportId);

				// save into database with table pml_main_support
				pmlMainSupport = new PmlMainSupportImpl();
				pmlMainSupport.setProcessId_Main(processInstanceId);
				pmlMainSupport.setProcessId(processInstanceSupportId);
				pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_PB);
				PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport);

				// save into database with table pml_documentreceipt_wf
				pmlDocumentReceiptWFSupport = new PmlDocumentReceiptWFImpl();
				pmlDocumentReceiptWFSupport.setDocumentReceiptId(documentReceiptId);
				pmlDocumentReceiptWFSupport.setProcessId(processInstanceSupportId);
				pmlDocumentReceiptWFSupport.setIsMain("0");
				PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWFSupport);

				logNewNode(
					documentReceiptId, String.valueOf(userId),
					processInstanceSupportId, new Date(), 1, 1);
			}

			// signal process main to next node
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
				PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(
					mainDepartment, true);
			long userId = pmlDepartmentsLeaderList.get(0).getUserId();

			// set actorId and processInformation to process instance. Then, end
			// task
			getJbpmService().setContext(
				processInstanceId, "actorId", String.valueOf(userId));

			// log for process main
			PmlDocumentReceiptLog documentReceiptLog =
				new PmlDocumentReceiptLogImpl();
			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// load current Log information
			// PmlDocumentReceiptLog pmlDocumentReceiptLog =
			// getCurrentDocumentReceiptLog(documentReceiptId,stateProcess,
			// processor);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);

			pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			pmlDocumentReceiptLog.setNumDateProcess(Integer.parseInt(dateNumberProcess));
			pmlDocumentReceiptLog.setReceiver(userId);

			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
			// getJbpmService().endTaskInstance(taskId);
			// getJbpmService().signalTask(taskId, transition);
			signalTask(taskId, transition, String.valueOf(userId));

			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());

			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupportTemp = null;
			try {
				pmlMainSupportTemp =
					PmlMainSupportUtil.findByPrimaryKey(processId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupportTemp == null) {
				try {

					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				logNewNode(
					documentReceiptId, String.valueOf(userId), processId,
					dateProcess, pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}

		}
		catch (Exception e) {
			log.error("ERROR: no signal DocumentReceipt To Department");
			e.printStackTrace();
		}
	}

	public void signalDocumentReceiptToDepartmentUseUsers(
		List<WorkflowParam> params) {

		// minh update 20101117
		boolean checkInfo =
			Boolean.parseBoolean(WorkflowParamUtil.getString(
				params, "checkInfo", "true"));
		// end minh update 20101117

		// minh update 20100315
		String isPTB = WorkflowParamUtil.getString(params, "isPTB", "false");
		String isLDP = WorkflowParamUtil.getString(params, "isLDP", "false");
		String isPTBAndLDP =
			WorkflowParamUtil.getString(params, "isPTBAndLDP", "false");
		String listUserLDBString =
			WorkflowParamUtil.getString(params, "listUserLDB", "");
		// end
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", "NotAvailable");
		String mainUser = WorkflowParamUtil.getString(params, "mainUser", "");
		String supportedUsers =
			WorkflowParamUtil.getString(params, "supportedUsers", "");

		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		String dateNumberProcess =
			WorkflowParamUtil.getString(params, "dateNumberProcess", "0");

		// phmphuc 18/10/2010 - lay thoi gian xu ly la ngay tu form
		String expireDate =
			WorkflowParamUtil.getString(params, "expireDate", "");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		DocumentReceiptUtil util = new DocumentReceiptUtil();
		// chon thoi gian xu ly - ko check vao checkbox
		if (expireDate.equals("")) {// chon so ngay
			expireDate =
				dateFormat.format(util.getExpectedReturningDate(
					dateNumberProcess, date));
		}
		else {// chon tu calendar
			dateNumberProcess = util.getNumDateProcess(date, expireDate);
		}
		// end phmphuc 18/11/2010

		Date dateProcess = new Date();

		// minh update 20100419
		long processor = WorkflowParamUtil.getLong(params, "processor", -1);
		// end minh update 20100419

		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		String issuingPlaces =
			WorkflowParamUtil.getString(params, "issuingPlaces", "");
		// End of Canh

		// yenlt update 20101101 chuyen thanh cong thi xoa trong bang tam
		long documentReceiptIdTemp =
			WorkflowParamUtil.getLong(params, "documentReceiptIdTemp", 0);
		// end yenlt update 20101101
		if ((taskId == -1) || "NotAvailable".equalsIgnoreCase(transition) ||
			"".equalsIgnoreCase(mainUser)) {
			log.info("ERROR: param invalidate");
			return;
		}

		ProcessInstance processInstanceSupport = null;
		PmlMainSupport pmlMainSupport = null;
		PmlDocumentReceiptWF pmlDocumentReceiptWFSupport = null;

		try {
			long processInstanceId =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();
			String[] supportedUsersArr =
				supportedUsers.split(Constants.DEPARTMENT_SEPERATOR);
			PmlDocumentReceiptWF pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
			long documentReceiptId =
				pmlDocumentReceiptWF.getDocumentReceiptId();

			// yenlt update tim xem vb nay co phai vb nhan qua mang 20101119
			if (0 == documentReceiptIdTemp) {
				PmlEdmDocumentReceipt receiptOrgExt = null;
				receiptOrgExt =
					PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
				if (null != receiptOrgExt) {
					documentReceiptIdTemp = receiptOrgExt.getDocReceiptTempId();
				}
			}
			// end yenlt 20101119

			// minh update 20100315
			String[] listUserLDBArr = null;
			List<String> listUserLDB = null;
			// end
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();
			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);
			int step = 1; // Canh

			for (int i = 0; i < supportedUsersArr.length; i++) {
				if (Long.parseLong(supportedUsersArr[i]) == Long.parseLong(mainUser)) {
					continue;
				}
				long userId = Long.parseLong(supportedUsersArr[i]);

				// minh update 20100315
				if (Boolean.parseBoolean(isPTB)) {
					processInstanceSupport =
						getJbpmService().createProcessInstance(
							PROCESS_NAME_LDB_SUPPORT);
				}
				else if (Boolean.parseBoolean(isLDP)) {
					// create instance of support process, signal process
					// support to next node
					processInstanceSupport =
						getJbpmService().createProcessInstance(
							PROCESS_NAME_DEPARTMENT_SUPPORT);
				}
				else if (Boolean.parseBoolean(isPTBAndLDP)) {
					listUserLDBArr =
						listUserLDBString.split(Constants.DEPARTMENT_SEPERATOR);
					listUserLDB = ListUtil.toList(listUserLDBArr);
					if (listUserLDB.contains(supportedUsersArr[i])) {
						processInstanceSupport =
							getJbpmService().createProcessInstance(
								PROCESS_NAME_LDB_SUPPORT);
					}
					else {
						processInstanceSupport =
							getJbpmService().createProcessInstance(
								PROCESS_NAME_DEPARTMENT_SUPPORT);
					}
				}
				// end
				long processInstanceSupportId = processInstanceSupport.getId();
				getJbpmService().setContext(
					processInstanceSupportId, "actorId", String.valueOf(userId));
				getJbpmService().signalProcessInstance(processInstanceSupportId);

				// save into database with table pml_main_support
				pmlMainSupport = new PmlMainSupportImpl();
				pmlMainSupport.setProcessId_Main(processInstanceId);
				pmlMainSupport.setProcessId(processInstanceSupportId);
				// minh update 20100315
				int type = 0;
				if (Boolean.parseBoolean(isPTB)) {
					type = 3;
					pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_LD);
				}
				else if (Boolean.parseBoolean(isLDP)) {
					type = 1;
					pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_PB);
				}
				else if (Boolean.parseBoolean(isPTBAndLDP)) {
					if (listUserLDB.contains(supportedUsersArr[i])) {
						type = 3;
						pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_LD);
					}
					else {
						type = 1;
						pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_PB);
					}
				}
				// end
				PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport);

				// save into database with table pml_documentreceipt_wf
				pmlDocumentReceiptWFSupport = new PmlDocumentReceiptWFImpl();
				pmlDocumentReceiptWFSupport.setDocumentReceiptId(documentReceiptId);
				pmlDocumentReceiptWFSupport.setProcessId(processInstanceSupportId);
				pmlDocumentReceiptWFSupport.setIsMain("0");
				PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWFSupport);
				// update 12/04/2010
				PmlDocumentReceiptLog pmlDocumentReceiptLogHelp =
					PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
						processId, stateProcess.getStateProcessId(), null).get(
						0);

				pmlDocumentReceiptLogHelp.setDocumentReceiptLogId(CounterLocalServiceUtil.increment());
				// minh update 20101117
				if (checkInfo) {
					pmlDocumentReceiptLogHelp.setProcessInfomation(processInformation);
				}
				else {
					pmlDocumentReceiptLogHelp.setProcessInfomation(WorkflowParamUtil.getString(
						params, "processInformationForUser" +
							supportedUsersArr[i], ""));
				}
				// end minh update 20101117
				pmlDocumentReceiptLogHelp.setNumDateProcess(Integer.parseInt(dateNumberProcess));

				// phmphuc 18/10/2010 - luu thoi gian xu ly la ngay xuong db
				pmlDocumentReceiptLogHelp.setExpiredDate(expireDate != ""
					? new SimpleDateFormat("dd/MM/yyyy").parse(expireDate)
					: null);
				// end phmphuc

				pmlDocumentReceiptLogHelp.setReceiver(userId);
				// pmlDocumentReceiptLogHelp.setType_(1);// yenlt update
				// 17/04/2010
				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhanHelp = null;
				try {
					pmlUserNhanHelp =
						PmlUserLocalServiceUtil.getPmlUser(userId);
				}
				catch (Exception e) {
				}
				if (pmlUserNhanHelp != null) {
					pmlDocumentReceiptLogHelp.setDepartmentReceiveId(pmlUserNhanHelp.getDepartmentsId());
				}
				// end
				pmlDocumentReceiptLogHelp.setDateProcess(dateProcess);
				pmlDocumentReceiptLogHelp.setDateProcessTime(dateProcess);

				int transitionHelp = 0;
				try {
					transitionHelp =
						PmlDocumentReceiptLogUtil.countByDocumentReceiptId(documentReceiptId) + 1;
				}
				catch (Exception e) {
				}

				pmlDocumentReceiptLogHelp.setTransition_(transitionHelp);
				pmlDocumentReceiptLogHelp.setType_(1);

				pmlDocumentReceiptLogHelp =
					PmlDocumentReceiptLogLocalServiceUtil.addPmlDocumentReceiptLog(pmlDocumentReceiptLogHelp);

				// end

				// minh update 20100315
				// logNewNode(documentReceiptId, String.valueOf(userId),
				// processInstanceSupportId, new Date(), 1);
				PmlDocumentReceiptLog documentReceiptLog =
					logNewNode(
						documentReceiptId, String.valueOf(userId),
						processInstanceSupportId, new Date(), type,
						pmlDocumentReceiptLogHelp.getStep() + 1);

				PmlDocumentReceiptLog pmlDocumentReceiptLog =
					PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
						processId, stateProcess.getStateProcessId(), null).get(
						0);
				if (1 == pmlDocumentReceiptLog.getTransition_()) {
					// PmlDocumentReceiptLog pmlDocumentReceiptLogHelpHelp =
					// pmlDocumentReceiptLogHelp;
					// pmlDocumentReceiptLogHelpHelp.setSendDateBefore(null);
					// PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLogHelpHelp);
					// Canh edit
					pmlDocumentReceiptLogHelp.setSendDateBefore(null);
					// End of Canh

				}
				// end
				pmlDocumentReceiptLogHelp.setStateProcessIdAfter(documentReceiptLog.getStateProcessIdBefore());

				// Canh
				pmlDocumentReceiptLogHelp.setDirectProcesserId(directprocessor);
				step = pmlDocumentReceiptLogHelp.getStep() + 1;
				// End of Canh

				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLogHelp);

				// phmphuc insert bang entry t/h quy trinh phong ban phu -
				// 02/12/2010
				logNewMessage(documentReceiptId, processor, userId);
			}

			// Canh 20110119
			String[] issuingPlacesArr = issuingPlaces.split(",");
			for (String issuingPlace : issuingPlacesArr) {
				issuingPlace = issuingPlace.trim();
				if (issuingPlace.length() > 0) {
					PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil.addPmlDocumentReceiptIssuingPlaceLog(
						documentReceiptId, dateProcess, processor,
						directprocessor, "", issuingPlace, step);
				}
			}

			// End of Canh

			// get process instance
			// ProcessInstance pi =
			// getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			// long processId = pi.getId();

			// signal process main to next node
			long userId = Long.parseLong(mainUser);

			// set actorId and processInformation to process instance. Then, end
			// task
			getJbpmService().setContext(
				processInstanceId, "actorId", String.valueOf(userId));

			// // get state process
			// String stateProcessCode = getStateNode(processId);
			// PmlStateProcess stateProcess =
			// getStateProcessFromCode(stateProcessCode);

			// Thoi update 20100319
			// get main department
			PmlUser pmlUser = null;
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
			}
			catch (Exception e) {
			}
			// end

			// load current Log information
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);

			// minh update 20101117
			if (checkInfo) {
				pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			}
			else {
				pmlDocumentReceiptLog.setProcessInfomation(WorkflowParamUtil.getString(
					params, "processInformationForUser" + userId, ""));
			}
			// end minh update 20101117

			pmlDocumentReceiptLog.setNumDateProcess(Integer.parseInt(dateNumberProcess));

			// phmphuc 18/10/2010 - luu thoi gian xu ly la ngay xuong db
			pmlDocumentReceiptLog.setExpiredDate(expireDate != ""
				? new SimpleDateFormat("dd/MM/yyyy").parse(expireDate) : null);
			// end phmphuc

			pmlDocumentReceiptLog.setReceiver(userId);
			// phmphuc update phong ban nhan 12/04/2010
			PmlUser pmlUserNhan = null;
			try {
				pmlUserNhan = PmlUserLocalServiceUtil.getPmlUser(userId);
			}
			catch (Exception e) {
			}
			if (pmlUserNhan != null) {
				pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
			}
			// end
			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);

			// Thoi update 20100319
			// save main deparment
			pmlDocumentReceiptLog.setMainDepartmentProcessId(pmlUser.getDepartmentsId());
			// end
			// minh update 20100419
			List<String> listNodeBack =
				(List<String>) getJbpmService().getContextVariable(
					processId, "listNodeBack");
			List<Long> listUserNodeBack =
				(List<Long>) getJbpmService().getContextVariable(
					processId, "listUserNodeBack");

			if (listNodeBack != null) {
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processId, "listNodeBack", listNodeBack);
			}
			else {
				listNodeBack = new ArrayList<String>();
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processId, "listNodeBack", listNodeBack);
			}

			if (listUserNodeBack != null) {
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processId, "listUserNodeBack", listUserNodeBack);
			}
			else {
				listUserNodeBack = new ArrayList<Long>();
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processId, "listUserNodeBack", listUserNodeBack);
			}
			// end minh update 20100419
			// signalTask(taskId, transition, String.valueOf(userId));
			getJbpmService().signalTask(taskId, transition);

			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());
			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupportTemp = null;
			try {
				pmlMainSupportTemp =
					PmlMainSupportUtil.findByPrimaryKey(processId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupportTemp == null) {
				try {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				logNewNode(
					documentReceiptId, String.valueOf(userId), processId,
					dateProcess, pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
				// yenlt update 17/04/2010
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				List<PmlDocumentReceiptLog> logList = null;
				PmlDocumentReceiptLog logEnd = null;
				logList =
					PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Type(
						pmlEdmDocumentReceipt.getDocumentReceiptId(), 0);
				Collections.sort(
					logList, new Comparator<PmlDocumentReceiptLog>() {

						public int compare(
							PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {

							int sort =
								o1.getTransition_() - o2.getTransition_();
							return sort;
						}
					});

				logEnd = logList.get(logList.size() - 1);
				PmlUser endUser = null;
				endUser =
					PmlUserLocalServiceUtil.getPmlUser(logEnd.getProcesser());

				pmlEdmDocumentReceipt.setMainDepartmentProcessId(endUser.getDepartmentsId());
				// pmlEdmDocumentReceipt.setMainUserProcessId(endUser.getUserId());
				PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				// end
				// yenlt update 17/04/2010
				if (0 != documentReceiptIdTemp) {
					PmlEdmDocumentReceiptTemp receiptTemp = null;
					try {
						receiptTemp =
							PmlEdmDocumentReceiptTempLocalServiceUtil.getPmlEdmDocumentReceiptTemp(documentReceiptIdTemp);
						PmlEdmDocumentReceiptTempLocalServiceUtil.deletePmlEdmDocumentReceiptTemp(receiptTemp);
					}
					catch (Exception e) {
						System.out.println("CAN NOT DELETE PmlEdmDocumentReceiptTemp WITH documentReceiptIdTemp " +
							documentReceiptIdTemp);
					}
				}
				// end
			}
			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setMainDepartmentProcessId(pmlUserNhan.getDepartmentsId());
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					// if
					// ((!"".equals(pmlEdmDocumentReceipt.getMainDepartmentProcessId())))
					// {
					// pmlEdmDocumentReceipt.setMainDepartmentProcessId(pmlUserNhan.getDepartmentsId());
					// pmlEdmDocumentReceipt.setMainUserProcessId(pmlUserNhan.getUserId());
					// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					// }
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}

			// phmphuc insert bang entry t/h quy trinh phong ban chinh -
			// 02/12/2010
			logNewMessage(documentReceiptId, processor, userId);

		}
		catch (Exception e) {
			log.error("ERROR: no signal DocumentReceipt To Department");
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#signalTask(java.util
	 * .List)
	 */
	public void signalTask(List<WorkflowParam> params) {

		// variables for write log
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", null);
		String receiverId =
			WorkflowParamUtil.getString(params, "receiverId", null);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		Date dateProcess = new Date();
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		if ((taskId == -1) || (transition == null)) {
			return;
		}

		try {

			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// get documnentReceiptId from processId
			long documentReceiptId =
				getdocumentReceiptIdFromProcessId(processId);

			// load current Log information
			// PmlDocumentReceiptLog pmlDocumentReceiptLog =
			// getCurrentDocumentReceiptLog(documentReceiptId,stateProcess,
			// processor);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			if (receiverId != null) {
				pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverId));

			}

			// phmphuc update phong ban nhan 12/04/2010
			PmlUser pmlUserNhan = null;
			try {
				pmlUserNhan =
					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverId));
			}
			catch (Exception e) {
			}
			if (pmlUserNhan != null) {
				pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
			}
			// end
			pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);

			getJbpmService().signalTask(taskId, transition);

			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());
			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupport = null;
			try {
				pmlMainSupport = PmlMainSupportUtil.findByPrimaryKey(processId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupport == null) {
				try {

					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				logNewNode(
					documentReceiptId, receiverId, processId, dateProcess,
					pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					/*
					 * yenlt close start 07062010 if
					 * ((!"".equals(pmlEdmDocumentReceipt
					 * .getMainDepartmentProcessId()))) { //YENLT 16/04/2010
					 * List<PmlDocumentReceiptLog> logList = null;
					 * PmlDocumentReceiptLog logEnd = null; logList =
					 * PmlDocumentReceiptLogUtil
					 * .findByDocumentReceiptId_Type(pmlEdmDocumentReceipt
					 * .getDocumentReceiptId(), 0); Collections.sort(logList,
					 * new Comparator<PmlDocumentReceiptLog>() { public int
					 * compare(PmlDocumentReceiptLog o1, PmlDocumentReceiptLog
					 * o2) { int sort = o1.getTransition_() -
					 * o2.getTransition_(); return sort; } }); logEnd =
					 * logList.get(logList.size() - 1); PmlUser endUser = null;
					 * endUser =
					 * PmlUserLocalServiceUtil.getPmlUser(logEnd.getProcesser
					 * ());
					 * pmlEdmDocumentReceipt.setMainDepartmentProcessId(endUser
					 * .getDepartmentsId());
					 * pmlEdmDocumentReceipt.setMainUserProcessId
					 * (endUser.getUserId());
					 * PmlEdmDocumentReceiptLocalServiceUtil
					 * .updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt); }
					 * yenlt close end 07062010
					 */
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
						// minh update 20101116
						// getJbpmService().deleteProcessInstance(processId);
						// end minh update 20101116
					}
				}
			}

		}
		catch (Exception e) {
			log.error("ERROR: no signal task ");
			e.printStackTrace();
		}
	}

	public void signalTaskToAgency(List<WorkflowParam> params) {

		// variables for write log
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", null);
		String receiverId =
			WorkflowParamUtil.getString(params, "receiverId", null);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", null);
		Date dateProcess = new Date();
		long processor = WorkflowParamUtil.getLong(params, "processor", -1);
		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh
		long documentReceiptIdTemp =
			WorkflowParamUtil.getLong(params, "documentReceiptIdTemp", 0);

		// yenlt update 20101118
		String changeCVP =
			WorkflowParamUtil.getString(params, "changeCVP", null);
		if (true == Boolean.parseBoolean(changeCVP)) {
			String documentReceiptIdList =
				WorkflowParamUtil.getString(
					params, "documentReceiptIdList", null);
			String[] documentReceipts = documentReceiptIdList.split(",");
			List<PmlDocumentReceiptLog> listLog =
				new ArrayList<PmlDocumentReceiptLog>();
			DocumentReceiptLiferayWorkflowService documentReceiptLWS =
				new DocumentReceiptLiferayWorkflowService();
			PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
			for (int i = 0; i < documentReceipts.length; i++) {
				try {
					if (documentReceipts[i].equals("on")) {
						continue;
					}
					long documentReceiptId =
						Long.parseLong(documentReceipts[i]);
					// yenlt update tim xem vb nay co phai vb nhan qua mang
					// 20101119
					if (0 == documentReceiptIdTemp) {
						PmlEdmDocumentReceipt receiptOrgExt = null;
						receiptOrgExt =
							PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
						if (null != receiptOrgExt) {
							documentReceiptIdTemp =
								receiptOrgExt.getDocReceiptTempId();
						}
					}
					// end yenlt 20101119

					listLog =
						PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
					pmlDocumentReceiptLog = listLog.get(0);
					long processId =
						pmlDocumentReceiptLog.getProcessInstanceId();
					String stateProcessCode = getStateNode(processId);

					List<TaskAction> taskActions = new ArrayList<TaskAction>();
					taskActions = documentReceiptLWS.getTaskActions(processId);
					TaskAction taskAction = null;
					for (int j = 0; j < taskActions.size(); j++) {
						taskAction = taskActions.get(j);
						if (taskAction.getTaskActionName().equals(
							"chuyenchanhvanphong")) {
							taskId = taskAction.getTaskInstanceId();
							break;
						}
					}

					if (receiverId != null) {
						pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverId));
					}

					PmlUser pmlUserNhan = null;
					try {
						pmlUserNhan =
							PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverId));
					}
					catch (Exception e) {
					}
					if (pmlUserNhan != null) {
						pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
					}
					pmlDocumentReceiptLog.setMainDepartmentProcessId(pmlUserNhan.getDepartmentsId());// yenlt
																										// update
																										// 20101122,
																										// set
																										// for
																										// check
																										// rut
																										// lai
					pmlDocumentReceiptLog.setProcessInfomation(processInformation);

					pmlDocumentReceiptLog.setDateProcess(dateProcess);
					pmlDocumentReceiptLog.setDateProcessTime(dateProcess);

					List<String> listNodeBack =
						(List<String>) getJbpmService().getContextVariable(
							processId, "listNodeBack");
					List<Long> listUserNodeBack =
						(List<Long>) getJbpmService().getContextVariable(
							processId, "listUserNodeBack");

					if (listNodeBack != null) {
						listNodeBack.add(stateProcessCode);
						getJbpmService().setContext(
							processId, "listNodeBack", listNodeBack);
					}
					else {
						listNodeBack = new ArrayList<String>();
						listNodeBack.add(stateProcessCode);
						getJbpmService().setContext(
							processId, "listNodeBack", listNodeBack);
					}

					if (listUserNodeBack != null) {
						listUserNodeBack.add(processor);
						getJbpmService().setContext(
							processId, "listUserNodeBack", listUserNodeBack);
					}
					else {
						listUserNodeBack = new ArrayList<Long>();
						listUserNodeBack.add(processor);
						getJbpmService().setContext(
							processId, "listUserNodeBack", listUserNodeBack);
					}

					signalTask(taskId, transition, receiverId);

					// set StateProcessIdAfter for current log.
					pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
						getStateNode(processId)).getStateProcessId());
					pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
					// persistence log information
					PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

					// persistence documentReceipt
					PmlMainSupport pmlMainSupport = null;
					try {
						pmlMainSupport =
							PmlMainSupportUtil.findByPrimaryKey(processId);
					}
					catch (Exception e) {

					}
					if (pmlMainSupport == null) {
						try {
							PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
							pmlEdmDocumentReceipt =
								PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
							pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
								getStateNode(processId)).getStateProcessId());
							PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
						}
						catch (Exception e) {
							log.error(e.getMessage());
						}
					}

					// log new information here
					if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
						logNewNode(
							documentReceiptId, receiverId, processId,
							dateProcess, pmlDocumentReceiptLog.getType_(),
							pmlDocumentReceiptLog.getStep() + 1);
						// yenlt update 20101119
						if (0 != documentReceiptIdTemp) {
							PmlEdmDocumentReceiptTemp receiptTemp = null;
							try {
								receiptTemp =
									PmlEdmDocumentReceiptTempLocalServiceUtil.getPmlEdmDocumentReceiptTemp(documentReceiptIdTemp);
								PmlEdmDocumentReceiptTempLocalServiceUtil.deletePmlEdmDocumentReceiptTemp(receiptTemp);
								documentReceiptIdTemp = 0;
							}
							catch (Exception e) {
								System.out.println("CAN NOT DELETE PmlEdmDocumentReceiptTemp WITH documentReceiptIdTemp " +
									documentReceiptIdTemp);
							}
						}
						// end
					}

					else {
						PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
						try {
							pmlEdmDocumentReceipt =
								PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
						}
						catch (Exception e) {
						}

						if (pmlEdmDocumentReceipt != null) {
							if (!pmlEdmDocumentReceipt.getDocumentType().equals(
								"3")) {
								pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
								PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
							}
						}
					}

					// phmphuc insert bang entry t/h chuyen nhieu vb cho CVP -
					// 02/12/2010
					logNewMessage(
						documentReceiptId, processor,
						Long.parseLong(receiverId));

				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else { // end yenlt 03082010
			if ((taskId == -1) || (transition == null)) {
				return;
			}

			try {

				// get process instance
				ProcessInstance pi =
					getJbpmService().getProcessInstanceFromTaskInstance(taskId);
				long processId = pi.getId();

				// get state process
				String stateProcessCode = getStateNode(processId);
				PmlStateProcess stateProcess =
					getStateProcessFromCode(stateProcessCode);

				// get documnentReceiptId from processId
				long documentReceiptId =
					getdocumentReceiptIdFromProcessId(processId);
				// yenlt update tim xem vb nay co phai vb nhan qua mang 20101119
				if (0 == documentReceiptIdTemp) {
					PmlEdmDocumentReceipt receiptOrgExt = null;
					receiptOrgExt =
						PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
					if (null != receiptOrgExt) {
						documentReceiptIdTemp =
							receiptOrgExt.getDocReceiptTempId();
					}
				}
				// end yenlt 20101119
				// load current Log information
				// PmlDocumentReceiptLog pmlDocumentReceiptLog =
				// getCurrentDocumentReceiptLog(documentReceiptId,stateProcess,
				// processor);
				PmlDocumentReceiptLog pmlDocumentReceiptLog =
					PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
						processId, stateProcess.getStateProcessId(), null).get(
						0);

				if (receiverId != null) {
					pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverId));
				}

				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan =
						PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverId));
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// end
				// save main deparment
				pmlDocumentReceiptLog.setMainDepartmentProcessId(pmlUserNhan.getDepartmentsId());// yenlt
																									// update
																									// 20101122,
																									// set
																									// for
																									// check
																									// rut
																									// lai
				pmlDocumentReceiptLog.setProcessInfomation(processInformation);

				pmlDocumentReceiptLog.setDateProcess(dateProcess);
				pmlDocumentReceiptLog.setDateProcessTime(dateProcess);

				List<String> listNodeBack =
					(List<String>) getJbpmService().getContextVariable(
						processId, "listNodeBack");
				List<Long> listUserNodeBack =
					(List<Long>) getJbpmService().getContextVariable(
						processId, "listUserNodeBack");

				if (listNodeBack != null) {
					listNodeBack.add(stateProcessCode);
					getJbpmService().setContext(
						processId, "listNodeBack", listNodeBack);
				}
				else {
					listNodeBack = new ArrayList<String>();
					listNodeBack.add(stateProcessCode);
					getJbpmService().setContext(
						processId, "listNodeBack", listNodeBack);
				}

				if (listUserNodeBack != null) {
					listUserNodeBack.add(processor);
					getJbpmService().setContext(
						processId, "listUserNodeBack", listUserNodeBack);
				}
				else {
					listUserNodeBack = new ArrayList<Long>();
					listUserNodeBack.add(processor);
					getJbpmService().setContext(
						processId, "listUserNodeBack", listUserNodeBack);
				}

				signalTask(taskId, transition, receiverId);

				// set StateProcessIdAfter for current log.
				pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
					getStateNode(processId)).getStateProcessId());

				// Canh
				pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
				// End of Canh

				// persistence log information
				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

				// persistence documentReceipt
				PmlMainSupport pmlMainSupport = null;
				try {
					pmlMainSupport =
						PmlMainSupportUtil.findByPrimaryKey(processId);
				}
				catch (Exception e) {

				}
				if (pmlMainSupport == null) {
					try {
						PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
						pmlEdmDocumentReceipt =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
						pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
							getStateNode(processId)).getStateProcessId());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
					catch (Exception e) {
					}
				}

				// log new information here
				if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
					logNewNode(
						documentReceiptId, receiverId, processId, dateProcess,
						pmlDocumentReceiptLog.getType_(),
						pmlDocumentReceiptLog.getStep() + 1);
					// yenlt update 17/04/2010
					if (0 != documentReceiptIdTemp) {
						PmlEdmDocumentReceiptTemp receiptTemp = null;
						try {
							receiptTemp =
								PmlEdmDocumentReceiptTempLocalServiceUtil.getPmlEdmDocumentReceiptTemp(documentReceiptIdTemp);
							PmlEdmDocumentReceiptTempLocalServiceUtil.deletePmlEdmDocumentReceiptTemp(receiptTemp);
						}
						catch (Exception e) {
							System.out.println("CAN NOT DELETE PmlEdmDocumentReceiptTemp WITH documentReceiptIdTemp " +
								documentReceiptIdTemp);
						}
					}
					// end
				}

				else {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
					try {
						pmlEdmDocumentReceipt =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					}
					catch (Exception e) {
					}

					if (pmlEdmDocumentReceipt != null) {
						if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
							pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
							PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
							// minh update 20101116
							// getJbpmService().deleteProcessInstance(processId);
							// end minh update 20101116
						}
					}
				}

				// phmphuc insert bang entry t/h VT vao xem chi tiet vb va
				// chuyen cho CVP - 02/12/2010
				logNewMessage(
					documentReceiptId, processor, Long.parseLong(receiverId));

			}
			catch (Exception e) {
				log.error("ERROR: no signal task ");
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param processDispose
	 */
	public void updateReceiveDate(long documentReceiptId, long userId) {

		try {
			// get state process
			// String code = getState(documentReceiptId, userid);
			List<PmlDocumentReceiptLog> documentReceiptLogs =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
					documentReceiptId, userId);
			// PmlStateProcess pmlStateProcess = getStateProcessFromCode(code);
			// PmlDocumentReceiptLog processDispose =
			// getCurrentDocumentReceiptLog(documentReceiptId, pmlStateProcess,
			// userId);
			PmlDocumentReceiptLog processDispose = null;
			for (int i = 0; i < documentReceiptLogs.size(); i++) {
				processDispose = documentReceiptLogs.get(i);
				if ((null == processDispose.getReceiveDate()) &&
					(processDispose.getDateProcess() != null)) {
					// processDispose.setProcesser(userId);
					processDispose.setReceiveDate(new Date());
					processDispose.setReceiveDateTime(new Date());
					PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(processDispose);
				}
			}

		}
		catch (Exception e) {
			// _log.info("Can't update PmlProcessDispose");
			e.getStackTrace();
		}
	}

	public void signalReport(List<WorkflowParam> params) {

		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", "NotAvailable");
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		String dateNumberProcess =
			WorkflowParamUtil.getString(params, "dateNumberProcess", "0");

		String receiverIdReportMain =
			WorkflowParamUtil.getString(params, "receiverIdReportMain", "");
		String receiverIdReports =
			WorkflowParamUtil.getString(params, "receiverIdReports", "");

		long processor = WorkflowParamUtil.getLong(params, "processor", -1);
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		Date dateProcess = new Date();

		if ((taskId == -1) || "NotAvailable".equalsIgnoreCase(transition) ||
			"".equalsIgnoreCase(receiverIdReportMain) ||
			"".equals(receiverIdReports)) {
			log.info("ERROR: param invalidate");
			return;
		}

		ProcessInstance processInstanceSupport = null;
		PmlMainSupport pmlMainSupport = null;
		PmlDocumentReceiptWF pmlDocumentReceiptWFSupport = null;

		try {
			long processInstanceId =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();

			String[] receiverIdReportsArr = receiverIdReports.split(",");

			PmlDocumentReceiptWF pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
			long documentReceiptId =
				pmlDocumentReceiptWF.getDocumentReceiptId();

			// get state process
			String stateProcessCode = getStateNode(processInstanceId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processInstanceId, stateProcess.getStateProcessId(), null).get(
					0);
			PmlDocumentReceiptLog documentReceiptLogSupport = null;

			long processInstanceSupportId = 0;
			int transitionHelp = 0;
			for (int i = 0; i < receiverIdReportsArr.length; i++) {
				if (receiverIdReportsArr[i].equalsIgnoreCase(receiverIdReportMain)) {
					continue;
				}

				// create instance of support process, signal process support to
				// next node
				processInstanceSupport =
					getJbpmService().createProcessInstance(
						PROCESS_NAME_BC_SUPPORT);
				processInstanceSupportId = processInstanceSupport.getId();
				getJbpmService().setContext(
					processInstanceSupportId, "actorId",
					receiverIdReportsArr[i]);
				getJbpmService().signalProcessInstance(processInstanceSupportId);

				// save into database with table pml_main_support
				pmlMainSupport = new PmlMainSupportImpl();
				pmlMainSupport.setProcessId_Main(processInstanceId);
				pmlMainSupport.setProcessId(processInstanceSupportId);
				pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_BC);
				PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport);

				// save into database with table pml_documentreceipt_wf
				pmlDocumentReceiptWFSupport = new PmlDocumentReceiptWFImpl();
				pmlDocumentReceiptWFSupport.setDocumentReceiptId(documentReceiptId);
				pmlDocumentReceiptWFSupport.setProcessId(processInstanceSupportId);
				pmlDocumentReceiptWFSupport.setIsMain("0");
				PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWFSupport);

				// UPDATE
				pmlDocumentReceiptLog.setDocumentReceiptLogId(CounterLocalServiceUtil.increment());
				pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverIdReportsArr[i]));

				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan =
						PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverIdReportsArr[i]));
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// end

				pmlDocumentReceiptLog.setProcessInfomation(processInformation);
				pmlDocumentReceiptLog.setDateProcess(dateProcess);
				pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
				pmlDocumentReceiptLog.setType_(4);
				pmlDocumentReceiptLog.setProcessInstanceId(processInstanceSupportId);
				try {
					transitionHelp =
						PmlDocumentReceiptLogUtil.countByDocumentReceiptId(documentReceiptId) + 1;
				}
				catch (Exception e) {
				}

				pmlDocumentReceiptLog.setTransition_(transitionHelp);

				pmlDocumentReceiptLog =
					PmlDocumentReceiptLogLocalServiceUtil.addPmlDocumentReceiptLog(pmlDocumentReceiptLog);

				documentReceiptLogSupport =
					logNewNode(
						documentReceiptId, receiverIdReportsArr[i],
						processInstanceSupportId, new Date(), 4,
						pmlDocumentReceiptLog.getStep() + 1);
				pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
				pmlDocumentReceiptLog.setStateProcessIdAfter(documentReceiptLogSupport.getStateProcessIdBefore());
				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

				logNewMessage(
					documentReceiptId, processor,
					Long.parseLong(receiverIdReportsArr[i]));
			}

			List<String> listNodeBack =
				(List<String>) getJbpmService().getContextVariable(
					processInstanceId, "listNodeBack");
			List<Long> listUserNodeBack =
				(List<Long>) getJbpmService().getContextVariable(
					processInstanceId, "listUserNodeBack");

			if (listNodeBack != null) {
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processInstanceId, "listNodeBack", listNodeBack);
			}
			else {
				listNodeBack = new ArrayList<String>();
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processInstanceId, "listNodeBack", listNodeBack);
			}

			if (listUserNodeBack != null) {
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processInstanceId, "listUserNodeBack", listUserNodeBack);
			}
			else {
				listUserNodeBack = new ArrayList<Long>();
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processInstanceId, "listUserNodeBack", listUserNodeBack);
			}

			// signal process main to next node, set actorId and
			// processInformation to process instance. Then, end task
			getJbpmService().setContext(
				processInstanceId, "actorId", receiverIdReportMain);

			// load current Log information
			pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processInstanceId, stateProcess.getStateProcessId(), null).get(
					0);
			pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			pmlDocumentReceiptLog.setNumDateProcess(Integer.parseInt(dateNumberProcess));
			pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverIdReportMain));

			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
			signalTask(taskId, transition, String.valueOf(receiverIdReportMain));

			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processInstanceId)).getStateProcessId());
			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupportTemp = null;
			try {
				pmlMainSupportTemp =
					PmlMainSupportUtil.findByPrimaryKey(processInstanceId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupportTemp == null) {
				try {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processInstanceId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
				logNewNode(
					documentReceiptId, receiverIdReportMain, processInstanceId,
					dateProcess, pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}
			logNewMessage(
				documentReceiptId, processor,
				Long.parseLong(receiverIdReportMain));
		}
		catch (Exception e) {
			log.error("ERROR: in method signalReport of class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}
	}

	public void signalCVPToCVPOrAgencyToAgency(List<WorkflowParam> params) {

		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", "NotAvailable");
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		String dateNumberProcess =
			WorkflowParamUtil.getString(params, "dateNumberProcess", "0");
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		String receiverIdMain =
			WorkflowParamUtil.getString(params, "receiverIdMain", "");
		String receiverIds =
			WorkflowParamUtil.getString(params, "receiverIds", "");

		long processor = WorkflowParamUtil.getLong(params, "processor", -1);

		Date dateProcess = new Date();

		if ((taskId == -1) || "NotAvailable".equalsIgnoreCase(transition) ||
			"".equalsIgnoreCase(receiverIdMain) || "".equals(receiverIds)) {
			log.info("ERROR: param invalidate");
			return;
		}

		ProcessInstance processInstanceSupport = null;
		PmlMainSupport pmlMainSupport = null;
		PmlDocumentReceiptWF pmlDocumentReceiptWFSupport = null;

		try {
			long processInstanceId =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();

			String[] receiverIdsArr = receiverIds.split(",");

			PmlDocumentReceiptWF pmlDocumentReceiptWF =
				PmlDocumentReceiptWFUtil.findByPrimaryKey(processInstanceId);
			long documentReceiptId =
				pmlDocumentReceiptWF.getDocumentReceiptId();

			// get state process
			String stateProcessCode = getStateNode(processInstanceId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);
			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processInstanceId, stateProcess.getStateProcessId(), null).get(
					0);
			PmlDocumentReceiptLog documentReceiptLogSupport = null;

			long processInstanceSupportId = 0;
			int transitionHelp = 0;
			for (int i = 0; i < receiverIdsArr.length; i++) {
				if (receiverIdsArr[i].equalsIgnoreCase(receiverIdMain)) {
					continue;
				}

				// create instance of support process, signal process support to
				// next node
				processInstanceSupport =
					getJbpmService().createProcessInstance(
						PROCESS_NAME_LDB_SUPPORT);
				processInstanceSupportId = processInstanceSupport.getId();
				getJbpmService().setContext(
					processInstanceSupportId, "actorId", receiverIdsArr[i]);
				getJbpmService().signalProcessInstance(processInstanceSupportId);

				// save into database with table pml_main_support
				pmlMainSupport = new PmlMainSupportImpl();
				pmlMainSupport.setProcessId_Main(processInstanceId);
				pmlMainSupport.setProcessId(processInstanceSupportId);
				pmlMainSupport.setType_(DocumentReceiptLiferayWorkflowService.TYPE_LD);
				PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport);

				// save into database with table pml_documentreceipt_wf
				pmlDocumentReceiptWFSupport = new PmlDocumentReceiptWFImpl();
				pmlDocumentReceiptWFSupport.setDocumentReceiptId(documentReceiptId);
				pmlDocumentReceiptWFSupport.setProcessId(processInstanceSupportId);
				pmlDocumentReceiptWFSupport.setIsMain("0");
				PmlDocumentReceiptWFLocalServiceUtil.addPmlDocumentReceiptWF(pmlDocumentReceiptWFSupport);

				// UPDATE
				pmlDocumentReceiptLog.setDocumentReceiptLogId(CounterLocalServiceUtil.increment());
				pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverIdsArr[i]));

				// phmphuc update phong ban nhan 12/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan =
						PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(receiverIdsArr[i]));
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentReceiptLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// end

				pmlDocumentReceiptLog.setProcessInfomation(processInformation);
				pmlDocumentReceiptLog.setDateProcess(dateProcess);
				pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
				pmlDocumentReceiptLog.setType_(3);
				pmlDocumentReceiptLog.setProcessInstanceId(processInstanceSupportId);
				try {
					transitionHelp =
						PmlDocumentReceiptLogUtil.countByDocumentReceiptId(documentReceiptId) + 1;
				}
				catch (Exception e) {
				}

				pmlDocumentReceiptLog.setTransition_(transitionHelp);

				pmlDocumentReceiptLog =
					PmlDocumentReceiptLogLocalServiceUtil.addPmlDocumentReceiptLog(pmlDocumentReceiptLog);

				documentReceiptLogSupport =
					logNewNode(
						documentReceiptId, receiverIdsArr[i],
						processInstanceSupportId, new Date(), 3,
						pmlDocumentReceiptLog.getStep() + 1);
				pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
				pmlDocumentReceiptLog.setStateProcessIdAfter(documentReceiptLogSupport.getStateProcessIdBefore());
				PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

				logNewMessage(
					documentReceiptId, processor,
					Long.parseLong(receiverIdsArr[i]));
			}

			List<String> listNodeBack =
				(List<String>) getJbpmService().getContextVariable(
					processInstanceId, "listNodeBack");
			List<Long> listUserNodeBack =
				(List<Long>) getJbpmService().getContextVariable(
					processInstanceId, "listUserNodeBack");

			if (listNodeBack != null) {
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processInstanceId, "listNodeBack", listNodeBack);
			}
			else {
				listNodeBack = new ArrayList<String>();
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(
					processInstanceId, "listNodeBack", listNodeBack);
			}

			if (listUserNodeBack != null) {
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processInstanceId, "listUserNodeBack", listUserNodeBack);
			}
			else {
				listUserNodeBack = new ArrayList<Long>();
				listUserNodeBack.add(processor);
				getJbpmService().setContext(
					processInstanceId, "listUserNodeBack", listUserNodeBack);
			}

			// signal process main to next node, set actorId and
			// processInformation to process instance. Then, end task
			getJbpmService().setContext(
				processInstanceId, "actorId", receiverIdMain);

			// load current Log information
			pmlDocumentReceiptLog =
				PmlDocumentReceiptLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processInstanceId, stateProcess.getStateProcessId(), null).get(
					0);
			pmlDocumentReceiptLog.setProcessInfomation(processInformation);
			pmlDocumentReceiptLog.setNumDateProcess(Integer.parseInt(dateNumberProcess));
			pmlDocumentReceiptLog.setReceiver(Long.parseLong(receiverIdMain));

			pmlDocumentReceiptLog.setDateProcess(dateProcess);
			pmlDocumentReceiptLog.setDateProcessTime(dateProcess);
			signalTask(taskId, transition, String.valueOf(receiverIdMain));

			// set StateProcessIdAfter for current log.
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processInstanceId)).getStateProcessId());
			pmlDocumentReceiptLog.setDirectProcesserId(directprocessor);
			// persistence log information
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// persistence documentReceipt
			PmlMainSupport pmlMainSupportTemp = null;
			try {
				pmlMainSupportTemp =
					PmlMainSupportUtil.findByPrimaryKey(processInstanceId);
			}
			catch (Exception e) {

			}
			if (pmlMainSupportTemp == null) {
				try {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
						getStateNode(processInstanceId)).getStateProcessId());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
				catch (Exception e) {
				}
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processInstanceId).getEnd() == null) {
				logNewNode(
					documentReceiptId, receiverIdMain, processInstanceId,
					dateProcess, pmlDocumentReceiptLog.getType_(),
					pmlDocumentReceiptLog.getStep() + 1);
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				try {
					pmlEdmDocumentReceipt =
						PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					if (!pmlEdmDocumentReceipt.getDocumentType().equals("3")) {
						pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
						PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
					}
				}
			}
			logNewMessage(
				documentReceiptId, processor, Long.parseLong(receiverIdMain));
		}
		catch (Exception e) {
			log.error("ERROR: in method signalReport of class " +
				DocumentReceiptLiferayWorkflowService.class);
			e.printStackTrace();
		}
	}
}
