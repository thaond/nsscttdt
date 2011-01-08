
package com.sgs.portlet.document.workflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.liferay.jbpm.component.TaskAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendWFImpl;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentSendWFLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.model.impl.PmlMessageImpl;
import com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil;
import com.sgs.portlet.message_note.service.persistence.PmlMessageUtil;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * @author hieuvh
 * @author minhnv
 */
@SuppressWarnings("unchecked")
public class DocumentSendLiferayWorkflowService
	extends AbstractLiferayWorkflowService {

	private final static Logger log =
		Logger.getLogger(DocumentSendLiferayWorkflowService.class);
	public final static String PROCESSNAME = "congvandi";
	public final static String TYPE_PB = "PB";
	public final static String TYPE_CV = "CV";

	public final static String PROCESS_NAME_DEPARTMENT_SUPPORT =
		"congvanphucapphong";
	public final static String PROCESS_NAME_USER_SUPPORT =
		"congvanphucapchuyenvien";
	
	public final static String PROCESSNAME_SUPPORT = "congvandiphuphathanh";

	public DocumentSendLiferayWorkflowService() {

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#addWorkflowInstance
	 * (java.util.List)
	 */
	public void addWorkflowInstance(List<WorkflowParam> params) {

		// get necessary parameters include documentId and fileId
		long documentSendId =
			WorkflowParamUtil.getLong(params, "documentSendId", 0);
		String userId = WorkflowParamUtil.getString(params, "userId", "");

		if ((documentSendId == 0) || "".equals(userId)) {
			log.info("ERROR: Parameter invilidate");
			return;
		}
		long processInstanceId = -1;

		try {

			ProcessInstance pi =
				getJbpmService().createProcessInstance(PROCESSNAME);
			// get processId
			processInstanceId = pi.getId();
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
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			// up date table pml_documentreceipt_wf
			PmlDocumentSendWF pmlDocumentSendWF = new PmlDocumentSendWFImpl();
			pmlDocumentSendWF.setProcessId(processInstanceId);
			pmlDocumentSendWF.setDocumentSendId(documentSendId);
			pmlDocumentSendWF.setIsMain("1");
			PmlDocumentSendWFLocalServiceUtil.addPmlDocumentSendWF(pmlDocumentSendWF);

		}
		catch (Exception e) {
			log.error("ERROR: no add workflow instance");
			e.printStackTrace();
		}

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
			logNewNode(
				documentSendId, userId, processInstanceId,
				pmlEdmDocumentSend.getDateCreated(), 0, 1);
		}
	}
	
	public long addWorkflowInstanceSupport(List<WorkflowParam> params) {

		// get necessary parameters include documentId and fileId
		long documentSendId =
			WorkflowParamUtil.getLong(params, "documentSendId", 0);
		String userId = WorkflowParamUtil.getString(params, "userId", "");

		if ((documentSendId == 0) || "".equals(userId)) {
			log.info("ERROR: Parameter invilidate");
			return -1;
		}
		long processInstanceId = -1;

		try {

			ProcessInstance pi =
				getJbpmService().createProcessInstance(PROCESSNAME_SUPPORT);
			// get processId
			processInstanceId = pi.getId();
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
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			// up date table pml_documentreceipt_wf
			PmlDocumentSendWF pmlDocumentSendWF = new PmlDocumentSendWFImpl();
			pmlDocumentSendWF.setProcessId(processInstanceId);
			pmlDocumentSendWF.setDocumentSendId(documentSendId);
			pmlDocumentSendWF.setIsMain("1");
			PmlDocumentSendWFLocalServiceUtil.addPmlDocumentSendWF(pmlDocumentSendWF);

		}
		catch (Exception e) {
			log.error("ERROR: no add workflow instance");
			e.printStackTrace();
		}

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
			logNewNode(
				documentSendId, userId, processInstanceId,
				pmlEdmDocumentSend.getDateCreated(), 0, 1);
		}
		
		return processInstanceId;
	}

	// end
	// yenlt 11082010 cho xu ly thay
	/**
	 * @param userId
	 * @param processId
	 * @return
	 */
	public boolean checkUserInDocumentSendWorkflow(long userId, long processId) {

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
				String user = pmlUser.getDepartmentsId();
				rs =
					getJbpmService().checkUserInCurrentTasks(
						processId, String.valueOf(user));
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		return rs;
	}

	// end yenlt 11082010

	/**
	 * delete a document from database
	 * 
	 * @param params
	 *            void
	 */
	public void deleteDocumentSend(List<WorkflowParam> params) {

		long documentSendId =
			WorkflowParamUtil.getLong(params, "documentSendId", 0);

		if (documentSendId == 0) {
			log.info("ERROR: param invalidate");
			return;
		}

		try {

			PmlDocumentSendWF pmlDocumentSendWF =
				PmlDocumentSendWFUtil.remove(documentSendId);
			if (pmlDocumentSendWF != null) {
				long processInstanceId = pmlDocumentSendWF.getProcessId();
				getJbpmService().deleteProcessInstance(processInstanceId);
			}

		}
		catch (Exception e) {
			log.error("ERROR: no delete document send");
			e.printStackTrace();
		}
	}

	/**
	 * get Creator of document send with given documentSendId
	 * 
	 * @param documentSendId
	 * @return
	 */
	public long getCreatorDocumentSend(long documentSendId) {

		try {
			PmlDocumentSendWF pmlDocumentSendWF =
				PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
			long processInstanceId = pmlDocumentSendWF.getProcessId();

			return Long.parseLong(getJbpmService().getContextVariable(
				processInstanceId, "creator").toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method gets state but send document at position current in table
	 * Pml_DocumentSend_Log
	 * 
	 * @param documentSendId
	 *            : is id of send document
	 * @return PmlDocumentSendLog
	 * @return null: if documentSendId doesn't find in table
	 *         Pml_DocumentSend_Log
	 */

	private PmlDocumentSendLog getCurrentDocumentSendLog(
		long documentSendId, PmlStateProcess stateProcess) {

		List<PmlDocumentSendLog> list = null;

		try {
			list =
				PmlDocumentSendLogUtil.findByDocumentSendId_StateProcessIdBefore(
					documentSendId, stateProcess.getStateProcessId());
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		// check if list null or empty
		if ((list == null) || list.isEmpty()) {
			return null;
		}

		// get log no dateProcess
		for (PmlDocumentSendLog log : list) {
			if (log.getDateProcess() == null) {
				return log;
			}
		}

		return list.get(0);
	}

	/**
	 * get current state of document send
	 * 
	 * @param documentReceiptId
	 * @return
	 */
	public String getCurrentStateOfDocumentSend(long documentSendId) {

		String currentState = null;

		try {
			PmlDocumentSendWF listPmlDocumentSendWF =
				PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
			if (listPmlDocumentSendWF != null) {
				long processInstanceId = listPmlDocumentSendWF.getProcessId();
				currentState = getStateNode(processInstanceId);
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get current state of document send");
			e.printStackTrace();
		}
		return currentState;
	}

	/**
	 * This method gets id of send document approach with a process definition
	 * instance
	 * 
	 * @param processId
	 *            : id of process definition instance
	 * @return long: is id of send document approach with a process definition
	 *         instance
	 * @return -1: if id of process definition instance illegal
	 */
	private long getdocumentSendIdFromProcessId(long processId) {

		// get fileId from processId
		List<PmlDocumentSendWF> pmlDocumentSendWFList =
			new ArrayList<PmlDocumentSendWF>();
		long documentSendId = -1;
		try {
			pmlDocumentSendWFList =
				PmlDocumentSendWFUtil.findByProcessId(processId);

			if ((pmlDocumentSendWFList == null) ||
				(pmlDocumentSendWFList.size() == 0)) {
				return documentSendId;
			}

			documentSendId = pmlDocumentSendWFList.get(0).getDocumentSendId();

		}
		catch (Exception e) {
			log.error("ERROR: in method getdocumentsendIdFromProcessId in class " +
				DocumentSendLiferayWorkflowService.class);
			e.printStackTrace();
		}

		return documentSendId;
	}

	public List<PmlEdmDocumentSend> getListDocumentByStatusId(
		long userId, long statusId)
		throws Exception {

		List<PmlEdmDocumentSend> listDocumentSentByUser =
			getListPmlEdmDocumentSendsByUser(userId);
		List<PmlEdmDocumentSend> results = new ArrayList<PmlEdmDocumentSend>();
		List<PmlStateProcess> stateProcessList =
			PmlStateProcessUtil.findByFileStatusId(statusId);

		for (PmlStateProcess pmlStateProcess : stateProcessList) {
			long stateProcessId = pmlStateProcess.getStateProcessId();

			List<PmlDocumentSendLog> logList =
				PmlDocumentSendLogUtil.findByStateProcessIdBefore(stateProcessId);
			for (PmlDocumentSendLog pmlDocumentSendLog : logList) {
				long documentSendId = pmlDocumentSendLog.getDocumentSendId();
				PmlEdmDocumentSend documentSend =
					PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
				if (listDocumentSentByUser.contains(documentSend) &&
					!results.contains(documentSend)) {
					results.add(documentSend);
				}
			}
		}

		return results;
	}

	/**
	 * get list PmlEdmDocumentSend of user with status concrete
	 * 
	 * @param userId
	 * @param fileStatusId
	 * @return
	 * @throws Exception
	 *             List<PmlEdmDocumentReceipt> Aug 24, 2009
	 *             com.sgs.portlet.document.workflow
	 */
	public List<PmlEdmDocumentSend> getListDocumentOfUserHadProcessByStatusId(
		long userId, long fileStatusId) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSendTemp = null;
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
					PmlDocumentSendWF pmlDocumentSendWF = null;
					try {
						pmlDocumentSendWF =
							PmlDocumentSendWFUtil.findByPrimaryKey(processInstanceId);
					}
					catch (Exception e) {
					}

					// add to result list if exist document receipt
					if (pmlDocumentSendWF != null) {
						long documentSendId =
							pmlDocumentSendWF.getDocumentSendId();

						pmlEdmDocumentSendTemp =
							PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);

						if (pmlEdmDocumentSendTemp != null) {
							listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
						}
					}
				}
			}

		}
		catch (Exception e) {

		}

		return listPmlEdmDocumentSend;
	}

	/**
	 * get all PmlEdmDocumentSend of User.
	 * 
	 * @param userId
	 * @return
	 */

	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendsByUser(long userId) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSend = null;
		PmlDocumentSendWF pmlDocumentSendWF = null;

		try {
			List<ProcessInstance> listProcessInstance =
				getJbpmService().getListProcessInstanceOfActor(userId);

			if ((listProcessInstance != null) &&
				(listProcessInstance.size() != 0)) {

				for (ProcessInstance processInstance : listProcessInstance) {

					long processInstanceId = processInstance.getId();
					List<PmlDocumentSendWF> pmlDocumentSendWFs = null;
					try {
						pmlDocumentSendWFs =
							PmlDocumentSendWFUtil.findByProcessId(processInstanceId);
					}
					catch (Exception e) {
					}

					// add to result list if exist document receipt
					if ((pmlDocumentSendWFs != null) &&
						(pmlDocumentSendWFs.size() != 0)) {
						pmlDocumentSendWF = pmlDocumentSendWFs.get(0);

						long documentSendId =
							pmlDocumentSendWF.getDocumentSendId();
						pmlEdmDocumentSend =
							PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);

						if (pmlEdmDocumentSend != null) {
							listPmlEdmDocumentSend.add(pmlEdmDocumentSend);
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentSend");
			e.printStackTrace();
		}
		return listPmlEdmDocumentSend;
	}

	/**
	 * get all PmlEdmDocumentReceipt of User.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendsByUser(
		String userId, String type, String valueType) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();

		try {
			if (!"0".equalsIgnoreCase(userId)) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstanceOfActor(userId);

				log.info("list process instance: " + listProcessInstance.size());
				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					listPmlEdmDocumentSend =
						getListPmlEdmDocumentSendsByUserHelp(
							listProcessInstance, type, valueType);
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt");
			e.printStackTrace();
		}
		return listPmlEdmDocumentSend;
	}

	/**
	 * Get PmlEdmDocumentSend list with userId and process state list
	 * 
	 * @param userId
	 * @param type
	 * @param valueType
	 * @param processState
	 * @return List<PmlEdmDocumentSend>
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendsByUser(
		String userId, String type, String valueType, List<String> processState) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();

		try {
			if (!"0".equalsIgnoreCase(userId)) {
				List<ProcessInstance> listProcessInstance =
					getJbpmService().getListProcessInstanceOfActorWithState(
						Long.parseLong(userId), processState);

				log.info("list process instance: " + listProcessInstance.size());
				if ((listProcessInstance != null) &&
					(listProcessInstance.size() != 0)) {

					listPmlEdmDocumentSend =
						getListPmlEdmDocumentSendsByUserHelp(
							listProcessInstance, type, valueType);
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt with process state list");
			e.printStackTrace();
		}
		return listPmlEdmDocumentSend;
	}

	/**
	 * get all PmlEdmDocumentSend of User had process for report.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendsByUserHadProcess(
		long userId) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSendTemp = null;

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
						PmlDocumentSendWF pmlDocumentSendWF = null;
						try {
							pmlDocumentSendWF =
								PmlDocumentSendWFUtil.findByPrimaryKey(processInstanceId);
						}
						catch (Exception e) {
						}

						// add to result list if exist document receipt
						if (pmlDocumentSendWF != null) {
							long documentSendId =
								pmlDocumentSendWF.getDocumentSendId();

							pmlEdmDocumentSendTemp =
								PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);

							if (pmlEdmDocumentSendTemp != null) {
								listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentSend");
			e.printStackTrace();
		}
		return listPmlEdmDocumentSend;
	}

	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendsByUserHelp(
		List<ProcessInstance> listProcessInstance, String type, String valueType) {

		List<PmlEdmDocumentSend> listPmlEdmDocumentSend =
			new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend pmlEdmDocumentSendTemp = null;

		try {
			for (ProcessInstance processInstance : listProcessInstance) {
				long processInstanceId = processInstance.getId();
				// find id of document with process id
				PmlDocumentSendWF pmlDocumentSendWF = null;
				List<PmlDocumentSendWF> pmlDocumentSendWFs = null;
				try {
					pmlDocumentSendWFs =
						PmlDocumentSendWFUtil.findByProcessId(processInstanceId);
				}
				catch (Exception e) {
				}

				if ((pmlDocumentSendWFs != null) &&
					(pmlDocumentSendWFs.size() > 0)) {
					pmlDocumentSendWF = pmlDocumentSendWFs.get(0);
				}

				// add to result list if exist document receipt
				if (pmlDocumentSendWF != null) {
					long documentSendId = pmlDocumentSendWF.getDocumentSendId();

					pmlEdmDocumentSendTemp =
						PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
					if ((type != null) && !"".equals(type.trim())) {
						if (pmlEdmDocumentSendTemp != null) {
							log.info("value type: " + valueType);
							if (valueType != null) {
								valueType = valueType.trim();
							}

							if ("socongvandi".equals(type)) {
								log.info("so cong van di");
								if (pmlEdmDocumentSendTemp.getDocumentReference().toUpperCase().contains(
									valueType.toUpperCase())) {
									listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
								}

							}
							else if ("sohieucongvan".equals(type)) {
								log.info("so hieu cong van di");
								if (pmlEdmDocumentSendTemp.getDocumentReference().toUpperCase().contains(
									valueType.toUpperCase())) {
									listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
								}
							}
							else if ("trichyeu".equals(type)) {
								log.info("trich yeu");
								if (pmlEdmDocumentSendTemp.getBriefContent().toUpperCase().contains(
									valueType.toUpperCase())) {
									listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
								}
							}
						}
					}
					else {
						log.info("khong co tu khoa loc");
						if (pmlEdmDocumentSendTemp != null) {
							log.info("khac null");
							listPmlEdmDocumentSend.add(pmlEdmDocumentSendTemp);
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error("ERROR: no get list PmlEdmDocumentReceipt");
			e.printStackTrace();
		}
		return listPmlEdmDocumentSend;
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
	 * implement by get Pooled Actor of taskinstance via given taskId
	 * 
	 * @param taskId
	 * @return
	 */
	public List<User> getPublisherList(long taskId) {

		return getPooledUser(taskId);
	}

	/**
	 * get current state of pml_file with given fileId
	 * 
	 * @param documentSendId
	 * @return
	 */
	public String getState(long documentSendId) {

		String state = null;
		String nodeName = null;

		try {
			PmlDocumentSendWF pmlDocumentSendWf =
				PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);

			// get current node name of process instance.
			nodeName =
				getJbpmService().getNodeName(pmlDocumentSendWf.getProcessId());

			// split it by : separator
			String[] values =
				nodeName.split(AbstractLiferayWorkflowService.STATE_SEPARATOR);
			state = values[0];
		}
		catch (Exception e) {
			log.error("ERROR: No Can't Get State Of WF With FileId [" +
				documentSendId + "]");
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
				DocumentSendLiferayWorkflowService.class);
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
	public User getUserProcess(long documentSendId) {

		PmlDocumentSendWF pmlDocumentSendWF = null;

		User user = null;
		try {
			pmlDocumentSendWF =
				PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
		}
		catch (Exception e) {
		}

		if (pmlDocumentSendWF != null) {
			List<Long> userIds =
				(List<Long>) (getJbpmService().getContextVariable(
					pmlDocumentSendWF.getProcessId(), "listUserNodeBack"));
			try {
				if ((userIds != null) && !userIds.isEmpty()) {
					user =
						UserLocalServiceUtil.getUser(userIds.get(userIds.size() - 1));
					return user;
				}
			}
			catch (Exception e) {
			}
		}
		return user;
	}

	/**
	 * phmphuc 02/12/2010 them moi dong entry giong nhu log van ban di
	 */
	private PmlMessage logNewMessage(
		long documentSendId, long fromUserId, long toUserId) {

		// add log information
		PmlMessage message = new PmlMessageImpl();
		// id
		long messageId = -1;

		try {
			messageId = CounterLocalServiceUtil.increment();

			message.setMessageId(messageId);
			message.setDocumentId(documentSendId);
			message.setFromUserId(fromUserId);
			message.setToUserId(toUserId);
			message.setObjectType(PmlEdmDocumentSendImpl.class.getName());
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
	private PmlDocumentSendLog logNewNode(
		long documentSendId, String userId, long processId,
		Date sendDateBefore, int typeProcess, int step) {

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
			// 14/04/2010
			pmlDocumentSendLog.setDocumentSendId(documentSendId);
			pmlDocumentSendLog.setProcesser(Long.parseLong(userId));
			pmlDocumentSendLog.setStateProcessIdBefore(stateProcess.getStateProcessId());
			pmlDocumentSendLog.setProcessInstanceId(processId);
			pmlDocumentSendLog.setType_(typeProcess);
			// set number of log row for a fileId.
			pmlDocumentSendLog.setTransition_(PmlDocumentSendLogUtil.countByDocumentSendId(documentSendId) + 1);

			// Canh
			pmlDocumentSendLog.setStep(step);
			// End of Canh

			// yenlt update column phong xu ly 14/04/2010
			PmlUser pmlUserXuLy = null;
			try {
				pmlUserXuLy =
					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(userId));
			}
			catch (Exception e) {
			}
			if (pmlUserXuLy != null) {
				pmlDocumentSendLog.setDepartmentProcessId(pmlUserXuLy.getDepartmentsId());
			}
			// end
			// yenlt update 14/04/2010
			if (1 != pmlDocumentSendLog.getTransition_()) {
				pmlDocumentSendLog.setSendDateBefore(sendDateBefore);
			}
			// end
			// persistence log.
			PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);
		}
		catch (Exception e) {
			log.error("ERROR: in method logNewNode in class " +
				DocumentSendLiferayWorkflowService.class);
			e.printStackTrace();
		}
		return pmlDocumentSendLog;
	}

	/**
	 * Move document to agency leader.<br>
	 * Input parameters is:<br>
	 * <ul>
	 * <li>processInformation : String</li>
	 * <li>taskId : long</li>
	 * <li>transition : String</li>
	 * <li>senderId : long</li>
	 * <li>receiverId : long</li>
	 * </ul>
	 * This method log processInformation and signal workflow to agency leader
	 * (identified by receiverId). In general, Implementation of this method
	 * same with moveToDepartmentLeader. In future, this maybe changed
	 * 
	 * @param workflowParams
	 */
	public void moveToAgencyLeader(List<WorkflowParam> workflowParams) {

		// get parameters
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		long receiverId =
			WorkflowParamUtil.getLong(workflowParams, "receiverId", -1);
		// log here and signal
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiverId + "");

		signalTask(workflowParams);
	}

	/**
	 * Move document to department leader.<br>
	 * Input parameters is:<br>
	 * <ul>
	 * <li>processInformation : String</li>
	 * <li>taskId : long</li>
	 * <li>transition : String</li>
	 * <li>senderId : long</li>
	 * <li>receiverId : long</li>
	 * </ul>
	 * This method log processInformation and signal workflow to department
	 * leader (identified by receiverId)
	 * 
	 * @param workflowParams
	 */
	public void moveToDepartmentLeader(List<WorkflowParam> workflowParams) {

		// get parameters
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		long receiverId =
			WorkflowParamUtil.getLong(workflowParams, "receiverId", -1);
		// log here and signal
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiverId + "");

		signalTask(workflowParams);
	}

	/**
	 * Move Document Send to Publish.<br>
	 * Input parameters is:<br>
	 * <ul>
	 * <li>processInformation : String</li>
	 * <li>taskId : long</li>
	 * <li>transition : String</li>
	 * <li>senderId : long</li>
	 * <li>receiverId : long</li>
	 * </ul>
	 * This method log processInformation and signal workflow to Publisher of
	 * DocumentSend. In general, Implementation of this method same with
	 * moveToDepartmentLeader. In future, this maybe changed
	 * 
	 * @param workflowParams
	 */
	public void moveToPublish(List<WorkflowParam> workflowParams) {

		// get parameters
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		long receiverId =
			WorkflowParamUtil.getLong(workflowParams, "receiverId", -1);
		// log here and signal
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiverId + "");

		signalTask(workflowParams);
	}

	/**
	 * This method signal document send to team leader.
	 * 
	 * @param workflowParams
	 */
	public void moveToTeamLeader(List<WorkflowParam> workflowParams) {

		// get parameters
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		long receiverId =
			WorkflowParamUtil.getLong(workflowParams, "receiverId", -1);
		// log here and signal
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiverId + "");

		signalTask(workflowParams);
	}

	/**
	 * Publish Document Send.<br>
	 * Input parameters is:<br>
	 * <ul>
	 * <li>taskId : long</li>
	 * <li>transition : String</li>
	 * </ul>
	 * This method log processInformation and signal workflow to Publisher of
	 * DocumentSend. In general, Implementation of this simply call signalTask()
	 * method. After that, if document send have a associated document receipt,
	 * signal process instance of document receipt.
	 * 
	 * @param workflowParams
	 */
	public void publishDocumentSend(List<WorkflowParam> workflowParams) {

		// signal document send process
		signalTask(workflowParams);

		// get process instance from task instance Id
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		long processId = pi.getId();
		// minh update 20101116
		long processIdSend = processId;
		// end minh update 20101116
		// if process has not yet end, return
		if (pi.getEnd() == null) {
			return;
		}

		/*
		 * if process end and document send has associated document receipt,
		 * signal (end) process of that document receipt.
		 */
		try {
			List<PmlDocumentSendWF> pmlWfs =
				PmlDocumentSendWFUtil.findByProcessId(processId);

			// if wf not exist, do nothing and return now
			if ((pmlWfs == null) || (pmlWfs.size() == 0)) {
				return;
			}

			// get documentSendId
			PmlDocumentSendWF wf = pmlWfs.get(0);
			long documentSendId = wf.getDocumentSendId();

			// get document send - document receipt relationship
			List<PmlEdmAnswerDetail> list =
				PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);

			// list not exist, do nothing and return
			if ((list == null) || (list.size() == 0)) {
				return;
			}

			// get relationship.
			PmlEdmAnswerDetail edmAnswerDetail = list.get(0);

			// get documentReceiptId.
			long documentReceiptId = edmAnswerDetail.getDocumentReceiptId();

			// get Workflow of Document Receipt.
			List<PmlDocumentReceiptWF> documentReceiptWFList =
				PmlDocumentReceiptWFUtil.findByDocumentReceiptIdIsMain(
					documentReceiptId, "1");

			if ((documentReceiptWFList == null) &&
				(documentReceiptWFList.size() == 0)) {
				return;
			}

			// get document Send processId
			PmlDocumentReceiptWF documentReceiptWF =
				documentReceiptWFList.get(0);
			processId = documentReceiptWF.getProcessId();

			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			PmlDocumentReceiptLog pmlDocumentReceiptLog =
				new DocumentReceiptLiferayWorkflowService().getCurrentDocumentReceiptLog(
					documentReceiptId, stateProcess,
					getCreatorDocumentSend(documentSendId));
			pmlDocumentReceiptLog.setDateProcess(new Date());
			pmlDocumentReceiptLog.setDateProcessTime(new Date());

			Collection<TaskInstance> collection =
				getJbpmService().findTaskInstances(processId);
			for (TaskInstance taskInstance : collection) {
				if (!taskInstance.hasEnded()) {
					getJbpmService().endTaskInstance(taskInstance.getId());
					break;
				}
			}
			pmlDocumentReceiptLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());
			PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);

			// minh update 20101116
			// delete processintance documnet send
			// getJbpmService().deleteProcessInstance(processIdSend);
			// delete processintance documnet receipt
			// getJbpmService().deleteProcessInstance(processId);
			// end minh update 20101116

		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	// minh update 18/11/2009

	/**
	 * Request Additional Information about Document Send.<br>
	 * Input parameters is:<br>
	 * <ul>
	 * <li>processInformation : String</li>
	 * <li>taskId : long</li>
	 * <li>transition : String</li>
	 * <li>senderId : long</li>
	 * <li>receiverId : long</li>
	 * </ul>
	 * This method log processInformation and signal workflow to Creator of
	 * DocumentSend. In general, Implementation of this method same with
	 * moveToDepartmentLeader. In future, this maybe changed
	 * 
	 * @param workflowParams
	 */
	public void requestAdditional(List<WorkflowParam> workflowParams) {

		// get parameters
		long taskId = WorkflowParamUtil.getLong(workflowParams, "taskId", -1);
		long receiverId =
			WorkflowParamUtil.getLong(workflowParams, "receiverId", -1);
		// log here and signal
		ProcessInstance pi =
			getJbpmService().getProcessInstanceFromTaskInstance(taskId);
		getJbpmService().setContext(pi.getId(), "actorId", receiverId + "");
		signalTask(workflowParams);
	}

	/**
	 * signal a document-receipt to a main Department and some support
	 * departments
	 * 
	 * @param workflowParams
	 */

	public void signalDocumentSendToDepartment(List<WorkflowParam> params) {

		/*
		 * long taskId = WorkflowParamUtil.getLong(params, "taskId", -1); String
		 * transition = WorkflowParamUtil.getString(params, "transition",
		 * "NotAvailable"); // String mainDepartment =
		 * WorkflowParamUtil.getString(params, // "mainDepartment", ""); String
		 * supportedDepartment = WorkflowParamUtil.getString(params,
		 * "supportedDepartment", ""); // String processInformation =
		 * WorkflowParamUtil.getString(params, // "processInformation", ""); //
		 * String dateNumberProcess = WorkflowParamUtil.getString(params, //
		 * "dateNumberProcess", "0"); // Date dateProcess = new Date(); long
		 * processor = WorkflowParamUtil.getLong(params, "processor", -1); //
		 * Canh long directprocessor = WorkflowParamUtil.getLong(params,
		 * "directprocessor", 0); // End of Canh String editorDepartment = null;
		 * PmlUser pmlUser = null; try { pmlUser =
		 * PmlUserLocalServiceUtil.getPmlUser(processor); } catch (Exception e)
		 * { pmlUser = null; } if (pmlUser != null) { editorDepartment =
		 * pmlUser.getDepartmentsId(); } if ((taskId == -1) ||
		 * "NotAvailable".equalsIgnoreCase(transition)) {
		 * log.info("ERROR: param invalidate"); return; } ProcessInstance
		 * processInstanceSupport = null; PmlMainSupport pmlMainSupport = null;
		 * PmlDocumentSendWF pmlDocumentSendSupport = null; try { long
		 * processInstanceId =
		 * getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();
		 * String[] supportedDepartmentArr =
		 * supportedDepartment.split(Constants.DEPARTMENT_SEPERATOR);
		 * PmlDocumentSendWF pmlDocumentSendWF =
		 * PmlDocumentSendWFUtil.findByPrimaryKey(processInstanceId); long
		 * documentSendId = pmlDocumentSendWF.getDocumentSendId(); for (int i =
		 * 0; i < supportedDepartmentArr.length; i++) { if
		 * (supportedDepartmentArr[i].equalsIgnoreCase(editorDepartment)) {
		 * continue; } List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
		 * PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(
		 * supportedDepartmentArr[i], true); long userId =
		 * pmlDepartmentsLeaderList.get(0).getUserId(); // create instance of
		 * support process, signal process support to // next node
		 * processInstanceSupport = getJbpmService().createProcessInstance(
		 * PROCESS_NAME_DEPARTMENT_SUPPORT); long processInstanceSupportId =
		 * processInstanceSupport.getId(); getJbpmService().setContext(
		 * processInstanceSupportId, "actorId", String.valueOf(userId));
		 * getJbpmService().signalProcessInstance(processInstanceSupportId); //
		 * save into database with table pml_main_support pmlMainSupport = new
		 * PmlMainSupportImpl();
		 * pmlMainSupport.setProcessId_Main(processInstanceId);
		 * pmlMainSupport.setProcessId(processInstanceSupportId);
		 * pmlMainSupport.
		 * setType_(DocumentReceiptLiferayWorkflowService.TYPE_PB);
		 * PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport); //
		 * save into database with table pml_documentreceipt_wf
		 * pmlDocumentSendSupport = new PmlDocumentSendWFImpl();
		 * pmlDocumentSendSupport.setDocumentSendId(documentSendId);
		 * pmlDocumentSendSupport.setProcessId(processInstanceSupportId);
		 * pmlDocumentSendSupport.setIsMain("0");
		 * PmlDocumentSendWFLocalServiceUtil
		 * .addPmlDocumentSendWF(pmlDocumentSendSupport); logNewNode(
		 * documentSendId, String.valueOf(userId), processInstanceSupportId, new
		 * Date(), 1); } // // signal process main to next node //
		 * List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = //
		 * PmlDepartmentsLeaderUtil
		 * .findByDepartmentsId_Main(editorDepartment,true); // long userId =
		 * pmlDepartmentsLeaderList.get(0).getUserId(); // // // set actorId and
		 * processInformation to process instance. Then, // end task //
		 * getJbpmService().setContext(processInstanceId, "actorId", //
		 * String.valueOf(userId)); // // // log for process main //
		 * PmlDocumentReceiptLog documentReceiptLog = new //
		 * PmlDocumentReceiptLogImpl(); // // get process instance //
		 * ProcessInstance pi = //
		 * getJbpmService().getProcessInstanceFromTaskInstance(taskId); // long
		 * processId = pi.getId(); // // // get state process // String
		 * stateProcessCode = getStateNode(processId); // PmlStateProcess
		 * stateProcess = // getStateProcessFromCode(stateProcessCode); // // //
		 * load current Log information // // PmlDocumentReceiptLog
		 * pmlDocumentReceiptLog = //
		 * getCurrentDocumentReceiptLog(documentReceiptId,stateProcess, //
		 * processor); // PmlDocumentReceiptLog pmlDocumentReceiptLog = //
		 * PmlDocumentReceiptLogUtil
		 * .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processId,
		 * // stateProcess.getStateProcessId(), null).get(0); // //
		 * pmlDocumentReceiptLog.setProcessInfomation(processInformation); //
		 * pmlDocumentReceiptLog
		 * .setNumDateProcess(Integer.parseInt(dateNumberProcess)); //
		 * pmlDocumentReceiptLog.setReceiver(userId); // //
		 * pmlDocumentReceiptLog.setDateProcess(dateProcess); // //
		 * getJbpmService().endTaskInstance(taskId); // //
		 * getJbpmService().signalTask(taskId, transition); //
		 * signalTask(taskId, transition, String.valueOf(userId)); // // // set
		 * StateProcessIdAfter for current log. //
		 * pmlDocumentReceiptLog.setStateProcessIdAfter
		 * (getStateProcessFromCode(getStateNode
		 * (processId)).getStateProcessId()); // // // persistence log
		 * information //
		 * PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog
		 * (pmlDocumentReceiptLog); // // // persistence documentReceipt //
		 * PmlMainSupport pmlMainSupportTemp = null; // try { //
		 * pmlMainSupportTemp = //
		 * PmlMainSupportUtil.findByPrimaryKey(processId); // } catch (Exception
		 * e) { // // } // if (pmlMainSupportTemp == null) { // try { // //
		 * PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null; //
		 * pmlEdmDocumentReceipt = //
		 * PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId); //
		 * pmlEdmDocumentReceipt
		 * .setStatusId(getStateProcessFromCode(getStateNode
		 * (processId)).getStateProcessId()); //
		 * PmlEdmDocumentReceiptLocalServiceUtil
		 * .updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt); // } catch
		 * (Exception e) { // } // } // // // // log new information here // if
		 * (getJbpmService().getProcessInstance(processId).getEnd() == // null)
		 * { // logNewNode(documentReceiptId, String.valueOf(userId), processId,
		 * // dateProcess, pmlDocumentReceiptLog.getType_()); // } // // else {
		 * // PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null; // try { //
		 * pmlEdmDocumentReceipt = //
		 * PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId); //
		 * }catch (Exception e) { // } // // if (pmlEdmDocumentReceipt != null )
		 * { // if(! pmlEdmDocumentReceipt.getDocumentType().equals("3")){ //
		 * pmlEdmDocumentReceipt.setDateHoanThanh(new Date()); //
		 * PmlEdmDocumentReceiptLocalServiceUtil
		 * .updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt); // } // } // } }
		 * catch (Exception e) {
		 * log.error("ERROR: no signal DocumentSend To Department");
		 * e.printStackTrace(); }
		 */
		throw new UnsupportedOperationException("Method not support yet");
	}

	// end 18/11/2009

	// minh 25/11/2009

	/**
	 * @param params
	 *            void Mar 17, 2009 com.sgs.portlet.document.workflow
	 */
	public void signalDocumentSendToReceiptor(List<WorkflowParam> params) {

		/*
		 * long taskId = WorkflowParamUtil.getLong(params, "taskId", -1); String
		 * transition = WorkflowParamUtil.getString(params, "transition",
		 * "NotAvailable"); String mainUser =
		 * WorkflowParamUtil.getString(params, "mainUser", ""); String
		 * supportedUsers = WorkflowParamUtil.getString(params,
		 * "supportedUsers", ""); String processInformation =
		 * WorkflowParamUtil.getString(params, "processInformation", ""); String
		 * dateNumberProcess = WorkflowParamUtil.getString(params,
		 * "dateNumberProcess", "0"); Date dateProcess = new Date(); long
		 * processor = WorkflowParamUtil.getLong(params, "processor", -1); //
		 * Canh long directprocessor = WorkflowParamUtil.getLong(params,
		 * "directprocessor", 0); // End of Canh if ((taskId == -1) ||
		 * "NotAvailable".equalsIgnoreCase(transition) ||
		 * "".equalsIgnoreCase(mainUser) || (processor == -1)) {
		 * log.info("ERROR: param invalidate"); return; } ProcessInstance
		 * processInstanceSupport = null; PmlMainSupport pmlMainSupport = null;
		 * PmlDocumentSendWF pmlDocumentSendWFSupport = null; try { long
		 * processInstanceId =
		 * getJbpmService().getProcessInstanceFromTaskInstance(taskId).getId();
		 * String[] supportedUsersArr =
		 * supportedUsers.split(Constants.USER_SEPERATOR); PmlDocumentSendWF
		 * pmlDocumentSendWF =
		 * PmlDocumentSendWFUtil.findByPrimaryKey(processInstanceId); long
		 * documentSendId = pmlDocumentSendWF.getDocumentSendId(); for (int i =
		 * 0; i < supportedUsersArr.length; i++) { if
		 * (!supportedUsersArr[i].equalsIgnoreCase(mainUser) &&
		 * !"".equals(supportedUsersArr[i])) { // create instance of support
		 * process, signal process // support to next node & log here
		 * processInstanceSupport = getJbpmService().createProcessInstance(
		 * PROCESS_NAME_USER_SUPPORT); long processInstanceSupportId =
		 * processInstanceSupport.getId(); getJbpmService().setContext(
		 * processInstanceSupportId, "actorId",
		 * String.valueOf(supportedUsersArr[i]));
		 * getJbpmService().signalProcessInstance( processInstanceSupportId); //
		 * save into database with table pml_main_support pmlMainSupport = new
		 * PmlMainSupportImpl();
		 * pmlMainSupport.setProcessId(processInstanceSupportId);
		 * pmlMainSupport.setProcessId_Main(processInstanceId);
		 * pmlMainSupport.setType_
		 * (DocumentReceiptLiferayWorkflowService.TYPE_CV);
		 * PmlMainSupportLocalServiceUtil.addPmlMainSupport(pmlMainSupport); //
		 * save into database with table pml_documentreceipt_wf
		 * pmlDocumentSendWFSupport = new PmlDocumentSendWFImpl();
		 * pmlDocumentSendWFSupport.setProcessId(processInstanceSupportId);
		 * pmlDocumentSendWFSupport.setDocumentSendId(documentSendId);
		 * pmlDocumentSendWFSupport.setIsMain("0");
		 * PmlDocumentSendWFLocalServiceUtil
		 * .addPmlDocumentSendWF(pmlDocumentSendWFSupport); logNewNode(
		 * documentSendId, supportedUsersArr[i], processInstanceSupportId, new
		 * Date(), 2); } } // signal process main to next node and write log
		 * getJbpmService().setContext( processInstanceId, "actorId",
		 * String.valueOf(mainUser)); // log for process main PmlDocumentSendLog
		 * documentSendLog = new PmlDocumentSendLogImpl(); // get process
		 * instance ProcessInstance pi =
		 * getJbpmService().getProcessInstanceFromTaskInstance(taskId); long
		 * processId = pi.getId(); // get state process String stateProcessCode
		 * = getStateNode(processId); PmlStateProcess stateProcess =
		 * getStateProcessFromCode(stateProcessCode); // load current Log
		 * information PmlDocumentSendLog pmlDocumentSendLog =
		 * PmlDocumentSendLogUtil
		 * .findByProcessInstanceId_StateProcessIdBefore_DateProcess( processId,
		 * stateProcess.getStateProcessId(), null).get(0);
		 * pmlDocumentSendLog.setReceiver(Long.parseLong(mainUser));
		 * pmlDocumentSendLog.setProcessInfomation(processInformation);
		 * pmlDocumentSendLog
		 * .setNumDateProcess(Integer.parseInt(dateNumberProcess)); // yenlt
		 * update phong ban nhan 14/04/2010 PmlUser pmlUserNhan = null; try {
		 * pmlUserNhan =
		 * PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(mainUser)); } catch
		 * (Exception e) { } if (pmlUserNhan != null) {
		 * pmlDocumentSendLog.setDepartmentReceiveId
		 * (pmlUserNhan.getDepartmentsId()); } // end if (dateProcess == null) {
		 * dateProcess = new Date(); }
		 * pmlDocumentSendLog.setDateProcess(dateProcess);
		 * pmlDocumentSendLog.setDateProcessTime(dateProcess);
		 * getJbpmService().endTaskInstance(taskId); // set StateProcessIdAfter
		 * for current log.
		 * pmlDocumentSendLog.setStateProcessIdAfter(getStateProcessFromCode(
		 * getStateNode(processId)).getStateProcessId()); // persistence log
		 * information
		 * PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog
		 * (pmlDocumentSendLog); // persistence documentReceipt PmlMainSupport
		 * pmlMainSupportTemp = null; try { pmlMainSupportTemp =
		 * PmlMainSupportUtil.findByPrimaryKey(processId); } catch (Exception e)
		 * { } if (pmlMainSupportTemp == null) { try { PmlEdmDocumentReceipt
		 * pmlEdmDocumentReceipt = null; pmlEdmDocumentReceipt =
		 * PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentSendId);
		 * pmlEdmDocumentReceipt.setStatusId(getStateProcessFromCode(
		 * getStateNode(processId)).getStateProcessId());
		 * PmlEdmDocumentReceiptLocalServiceUtil
		 * .updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt); } catch
		 * (Exception e) { } } // log new information here if
		 * (getJbpmService().getProcessInstance(processId).getEnd() == null) {
		 * logNewNode( documentSendId, String.valueOf(mainUser), processId,
		 * dateProcess, pmlDocumentSendLog.getType_()); } else {
		 * PmlEdmDocumentSend pmlEdmDocumentSend = null; try {
		 * pmlEdmDocumentSend =
		 * PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId); } catch
		 * (Exception e) { } if (pmlEdmDocumentSend != null) {
		 * PmlEdmDocumentSendLocalServiceUtil
		 * .updatePmlEdmDocumentSend(pmlEdmDocumentSend); } } } catch (Exception
		 * e) {
		 * log.error("ERROR: no signal DocumentReceipt from Department to User"
		 * ); e.printStackTrace(); }
		 */
		throw new UnsupportedOperationException("Method not support yet");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.jbpm.service.LiferayWorkflowService#signalTask(java.util
	 * .List)
	 */
	public void signalTask(List<WorkflowParam> params) {

		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String transition =
			WorkflowParamUtil.getString(params, "transition", null);
		long receiverId = WorkflowParamUtil.getLong(params, "receiverId", -1);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		long processorId = WorkflowParamUtil.getLong(params, "processor", -1);
		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh

		try {

			if ((taskId == -1) || (transition == null)) {
				return;
			}

			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();
			getJbpmService().setContext(processId, "actorId", receiverId + "");

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// yenlt update phong ban nhan 14/04/2010
			PmlDocumentSendLog pmlDocumentSendLog =
				PmlDocumentSendLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			PmlUser pmlUserNhan = null;
			try {
				pmlUserNhan = PmlUserLocalServiceUtil.getPmlUser(receiverId);
			}
			catch (Exception e) {
			}
			if (pmlUserNhan != null) {
				pmlDocumentSendLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
			}
			// end
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
				listUserNodeBack.add(processorId);
				getJbpmService().setContext(
					processId, "listUserNodeBack", listUserNodeBack);
			}
			else {
				listUserNodeBack = new ArrayList<Long>();
				listUserNodeBack.add(processorId);
				getJbpmService().setContext(
					processId, "listUserNodeBack", listUserNodeBack);
			}

			// get documnentReceiptId from processId
			long documentSendId = getdocumentSendIdFromProcessId(processId);

			// load current Log information
			// PmlDocumentSendLog pmlDocumentSendLog =
			// getCurrentDocumentSendLog(documentSendId, stateProcess);
			// yenlt close 14/04/2010
			// pmlDocumentSendLog =
			// PmlDocumentSendLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(processId,
			// stateProcess.getStateProcessId(), null).get(0);
			// end
			pmlDocumentSendLog.setReceiver(receiverId);
			pmlDocumentSendLog.setProcessInfomation(processInformation);
			pmlDocumentSendLog.setDateProcess(new Date());
			pmlDocumentSendLog.setDateProcessTime(new Date());

			getJbpmService().signalTask(taskId, transition);
			// signalTask(taskId, transition, receiverId +"");

			// set StateProcessIdAfter for current log.
			pmlDocumentSendLog.setStateProcessIdAfter(getStateProcessFromCode(
				getStateNode(processId)).getStateProcessId());

			// Canh
			pmlDocumentSendLog.setDirectProcesserId(directprocessor);
			// End of Canh

			// persistence log information
			PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);

			// persistence status into documentSend
			try {

				PmlEdmDocumentSend pmlEdmDocumentSend = null;
				pmlEdmDocumentSend =
					PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				pmlEdmDocumentSend.setStatusId(getStateProcessFromCode(
					getStateNode(processId)).getStateProcessId());
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				logNewNode(
					documentSendId, receiverId + "", processId, new Date(),
					pmlDocumentSendLog.getType_(),
					pmlDocumentSendLog.getStep() + 1);
			}

			else {

				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				PmlEdmAnswerDetail pmlEdmAnswerDetail = null;
				try {
					pmlEdmAnswerDetail =
						PmlEdmAnswerDetailUtil.findByDocumentSendId(
							documentSendId).get(0);
				}
				catch (Exception e) {
				}

				try {
					if (pmlEdmAnswerDetail != null) {
						pmlEdmDocumentReceipt =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlEdmAnswerDetail.getDocumentReceiptId());
					}
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {

					pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
			}

			// phmphuc insert bang entry t/h luan chuyen vb - 02/12/2010
			logNewMessage(documentSendId, processorId, receiverId);

		}
		catch (Exception e) {
			log.error("ERROR: no signal task ");
			e.printStackTrace();
		}

	}

	public void signalTaskBack(List<WorkflowParam> params) {

		String transition =
			WorkflowParamUtil.getString(params, "transition", null);
		long taskId = WorkflowParamUtil.getLong(params, "taskId", -1);
		String processInformation =
			WorkflowParamUtil.getString(params, "processInformation", "");
		long receiverId = WorkflowParamUtil.getLong(params, "receiverId", -1);
		// yenlt update 20101119
		String rutLai = WorkflowParamUtil.getString(params, "rutLai", "");
		String processor = WorkflowParamUtil.getString(params, "processor", "");
		// end yenlt update 20101119

		// Canh
		long directprocessor =
			WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh

		try {

			if ((taskId == -1) || (transition == null)) {
				return;
			}

			// get process instance
			ProcessInstance pi =
				getJbpmService().getProcessInstanceFromTaskInstance(taskId);
			long processId = pi.getId();
			getJbpmService().setContext(processId, "actorId", receiverId + "");

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess =
				getStateProcessFromCode(stateProcessCode);

			// get documnentReceiptId from processId
			long documentSendId = getdocumentSendIdFromProcessId(processId);

			// load current Log information
			// PmlDocumentSendLog pmlDocumentSendLog =
			// getCurrentDocumentSendLog(documentSendId, stateProcess);
			PmlDocumentSendLog pmlDocumentSendLog =
				PmlDocumentSendLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			// yenlt update 20101119 == rut lai van ban
			Date sendDateBefore = pmlDocumentSendLog.getSendDateBefore();
			if (!Boolean.parseBoolean(rutLai)) { // end yenlt 20101119
				pmlDocumentSendLog.setReceiver(receiverId);
				pmlDocumentSendLog.setProcessInfomation(processInformation);
				pmlDocumentSendLog.setDateProcess(new Date());
				pmlDocumentSendLog.setDateProcessTime(new Date());
				// yenlt update phong ban nhan 14/04/2010
				PmlUser pmlUserNhan = null;
				try {
					pmlUserNhan =
						PmlUserLocalServiceUtil.getPmlUser(receiverId);
				}
				catch (Exception e) {
				}
				if (pmlUserNhan != null) {
					pmlDocumentSendLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
				}
				// set StateProcessIdAfter for current log.
				pmlDocumentSendLog.setStateProcessIdAfter(getStateProcessFromCode(
					getStateNode(processId)).getStateProcessId());

				// Canh
				pmlDocumentSendLog.setDirectProcesserId(directprocessor);
				// End of Canh

				// persistence log information
				PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);
			}
			else {// start yenlt update 20101119
					// xoa dong log cuoi cung = dong cua nguoi duoc phan cong xu
					// ly
					// chinh
				PmlDocumentSendLogLocalServiceUtil.deletePmlDocumentSendLog(pmlDocumentSendLog);
				// cap nhat dong log cua nguoi rut lai vb ve trang thai ban dau
				String stateProcessCodeEnd = getStateNode(processId);
				PmlStateProcess stateProcessEnd =
					getStateProcessFromCode(stateProcessCodeEnd);

				PmlDocumentSendLog pmlDocumentSendLogEnd =
					PmlDocumentSendLogUtil.findByProcessInstanceId_StateProcessIdAfter_DateProcess(
						processId, stateProcessEnd.getStateProcessId(),
						sendDateBefore).get(0);
				pmlDocumentSendLogEnd.setDateProcess(null);
				pmlDocumentSendLogEnd.setReceiver(0);
				pmlDocumentSendLogEnd.setReceiveDate(null);
				pmlDocumentSendLogEnd.setProcessInfomation("");
				pmlDocumentSendLogEnd.setStateProcessIdAfter(0);
				pmlDocumentSendLogEnd.setExpiredDate(null);
				pmlDocumentSendLogEnd.setNumDateProcess(0);
				pmlDocumentSendLogEnd.setDepartmentReceiveId("");
				pmlDocumentSendLogEnd.setDateProcessTime(null);
				pmlDocumentSendLogEnd.setReceiveDateTime(null);

				// Canh
				pmlDocumentSendLogEnd.setDirectProcesserId(directprocessor);
				// End of Canh

				pmlDocumentSendLogEnd =
					PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLogEnd);
			}
			// end
			// signal Task

			List<String> listNodeBack =
				(List<String>) getJbpmService().getContextVariable(
					processId, "listNodeBack");
			List<Long> listUserNodeBack =
				(List<Long>) getJbpmService().getContextVariable(
					processId, "listUserNodeBack");

			// yenlt update 07102010
			if (Boolean.parseBoolean(rutLai)) {
				signalTask(
					taskId, listNodeBack.get(listNodeBack.size() - 1),
					processor);
			}
			else {
				getJbpmService().signalTask(
					taskId, listNodeBack.get(listNodeBack.size() - 1));
			}
			// signalTask(taskId, transition, receiverId +"");
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
			// pmlDocumentSendLog.setStateProcessIdAfter(getStateProcessFromCode(getStateNode(processId)).getStateProcessId());

			// persistence log information
			// PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);

			// persistence status into documentSend
			try {
				PmlEdmDocumentSend pmlEdmDocumentSend = null;
				pmlEdmDocumentSend =
					PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				pmlEdmDocumentSend.setStatusId(getStateProcessFromCode(
					getStateNode(processId)).getStateProcessId());
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			// log new information here
			if (getJbpmService().getProcessInstance(processId).getEnd() == null) {
				if (!Boolean.parseBoolean(rutLai)) {// yenlt update 20101119
					logNewNode(
						documentSendId, receiverId + "", processId, new Date(),
						pmlDocumentSendLog.getType_(),
						pmlDocumentSendLog.getStep() + 1);
				}
			}

			else {
				PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
				PmlEdmAnswerDetail pmlEdmAnswerDetail = null;
				try {
					pmlEdmAnswerDetail =
						PmlEdmAnswerDetailUtil.findByDocumentSendId(
							documentSendId).get(0);
				}
				catch (Exception e) {
				}

				try {
					if (pmlEdmAnswerDetail != null) {
						pmlEdmDocumentReceipt =
							PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlEdmAnswerDetail.getDocumentReceiptId());
					}
				}
				catch (Exception e) {
				}

				if (pmlEdmDocumentReceipt != null) {
					pmlEdmDocumentReceipt.setDateHoanThanh(new Date());
					PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
				}
			}

			// phmphuc insert bang entry t/h rut lai - 02/12/2010
			if (Boolean.parseBoolean(rutLai)) {
				List<PmlMessage> listMessageRutLai =
					PmlMessageUtil.findByDocumentId_FromUserId_ObjectType(
						documentSendId, Long.parseLong(processor),
						PmlEdmDocumentReceiptImpl.class.getName());
				PmlMessageLocalServiceUtil.deletePmlMessageList(listMessageRutLai);
			}
			// phmphuc insert bang entry t/h tra lai - 02/12/2010
			else {
				logNewMessage(
					documentSendId, Long.parseLong(processor), receiverId);
			}
			// end phmphuc insert

		}
		catch (Exception e) {
			log.error("ERROR: no signal task ");
			e.printStackTrace();
		}

	}

	/**
	 * @param
	 */
	public void updateReceiveDate(long documentSendId, long userId) {

		try {
			// get state process
			/*
			 * yenlt close start 14/04/2010 String code =
			 * getState(documentSendId); PmlStateProcess state =
			 * getStateProcessFromCode(code); PmlDocumentSendLog documentSendLog
			 * = getCurrentDocumentSendLog(documentSendId, state); yenlt close
			 * end
			 */

			// yenlt update 14/04/2010
			List<PmlDocumentSendLog> listSendLog =
				PmlDocumentSendLogUtil.findByDocumentSendId_Receiver(
					documentSendId, userId);
			PmlDocumentSendLog documentSendLog = null;
			for (int i = 0; i < listSendLog.size(); i++) {
				documentSendLog = listSendLog.get(i);
				if ((null == documentSendLog.getReceiveDate()) &&
					(documentSendLog.getDateProcess() != null)) {
					// documentSendLog.setProcesser(userId);//yenlt close
					// 15/04/2010
					documentSendLog.setReceiveDate(new Date());
					documentSendLog.setReceiveDateTime(new Date());
					PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(documentSendLog);
				}

			}
			// end
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
	public String publishDocumentSendSupport (List<WorkflowParam> params) {
		
		long processId = addWorkflowInstanceSupport(params);
		if (-1 == processId) {
			log.error("ERROR: NO CREATE PROCESSINSTANCE");
			return "false";
		}
		List<TaskAction> taskActions = null;
		
		
		try {
			taskActions = this.getTaskActions(processId);
		} catch (Exception e) {
			log.error("ERROR: NO HAS LIST TaskAction");
			return "false";
		}
		
		if (taskActions != null && !taskActions.isEmpty()) {
		TaskAction tA = taskActions.get(0);
		
		long taskId = tA.getTaskInstanceId();
		String transition = tA.getTransition();
		
		String userId = WorkflowParamUtil.getString(params, "userId", "0");
		long receiverId = Long.parseLong(userId);
		
		String processInformation = WorkflowParamUtil.getString(params, "processInformation", "");
		
		long processorId = WorkflowParamUtil.getLong(params, "processor", -1);
		
		// Canh
		long directprocessor = WorkflowParamUtil.getLong(params, "directprocessor", 0);
		// End of Canh

		try {

			if ((taskId == -1) || (transition == null)) {
				return "false";
			}
			
			getJbpmService().setContext(processId, "actorId", String.valueOf(receiverId));

			// get state process
			String stateProcessCode = getStateNode(processId);
			PmlStateProcess stateProcess = getStateProcessFromCode(stateProcessCode);

			
			PmlDocumentSendLog pmlDocumentSendLog = PmlDocumentSendLogUtil.findByProcessInstanceId_StateProcessIdBefore_DateProcess(
					processId, stateProcess.getStateProcessId(), null).get(0);
			
			PmlUser pmlUserNhan = null;
			try {
				pmlUserNhan = PmlUserLocalServiceUtil.getPmlUser(receiverId);
			}
			catch (Exception e) {
			}
			if (pmlUserNhan != null) {
				pmlDocumentSendLog.setDepartmentReceiveId(pmlUserNhan.getDepartmentsId());
			}
			// end
			
			List<String> listNodeBack = (List<String>) getJbpmService().getContextVariable(processId, "listNodeBack");
			List<Long> listUserNodeBack = (List<Long>) getJbpmService().getContextVariable(processId, "listUserNodeBack");

			if (listNodeBack != null) {
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(processId, "listNodeBack", listNodeBack);
			}
			else {
				listNodeBack = new ArrayList<String>();
				listNodeBack.add(stateProcessCode);
				getJbpmService().setContext(processId, "listNodeBack", listNodeBack);
			}

			if (listUserNodeBack != null) {
				listUserNodeBack.add(processorId);
				getJbpmService().setContext(processId, "listUserNodeBack", listUserNodeBack);
			}
			else {
				listUserNodeBack = new ArrayList<Long>();
				listUserNodeBack.add(processorId);
				getJbpmService().setContext(
					processId, "listUserNodeBack", listUserNodeBack);
			}

			// get documnentReceiptId from processId
			long documentSendId = WorkflowParamUtil.getLong(params, "documentSendId", 0);

			pmlDocumentSendLog.setReceiver(receiverId);
			pmlDocumentSendLog.setProcessInfomation(processInformation);
			pmlDocumentSendLog.setDateProcess(new Date());
			pmlDocumentSendLog.setDateProcessTime(new Date());

			getJbpmService().signalTask(taskId, transition);

			// set StateProcessIdAfter for current log.
			pmlDocumentSendLog.setStateProcessIdAfter(getStateProcessFromCode(getStateNode(processId)).getStateProcessId());

			// Canh
			pmlDocumentSendLog.setDirectProcesserId(directprocessor);
			// End of Canh

			// persistence log information
			PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);

			// persistence status into documentSend
			try {

				PmlEdmDocumentSend pmlEdmDocumentSend = null;
				pmlEdmDocumentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				pmlEdmDocumentSend.setStatusId(getStateProcessFromCode(getStateNode(processId)).getStateProcessId());
				PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(pmlEdmDocumentSend);
			}
			catch (Exception e) {
			}

			
		}
		catch (Exception e) {
			log.error("ERROR: no signal task ");
			return "false";
		}
		}
		return "true";
	}
}
