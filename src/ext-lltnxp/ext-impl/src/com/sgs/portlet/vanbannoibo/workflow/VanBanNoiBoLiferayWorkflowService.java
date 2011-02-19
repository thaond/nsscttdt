package com.sgs.portlet.vanbannoibo.workflow;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.impl.AbstractLiferayWorkflowService;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoImpl;
import com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalServiceUtil;

public class VanBanNoiBoLiferayWorkflowService extends AbstractLiferayWorkflowService{
	
	private final static Logger log = Logger.getLogger(VanBanNoiBoLiferayWorkflowService.class);
	public final static String VAN_BAN_NOI_BO_CHINH = "vanbannoibo";
	public final static String TYPE_CV = "CV";
	
	public VanBanNoiBoLiferayWorkflowService(){
		
	}
	
	public void addWorkflowInstance(List<WorkflowParam> params) {

		long vanBanNoiBoId = WorkflowParamUtil.getLong(params, "vanBanNoiBoId", 0);
		String userId = WorkflowParamUtil.getString(params, "userId", "");

		if ((vanBanNoiBoId == 0) || "".equals(userId)) {
			log.info("Can't create Workflow Instance: Parameter invalid");
			return;
		}
		long processInstanceId = -1;
		//List<LogVanBanNoiBo> listTemp = new ArrayList<LogVanBanNoiBo>();

		try {
			ProcessInstance pi = getJbpmService().createProcessInstance(VAN_BAN_NOI_BO_CHINH);
			// get processId and set userId to instance.
			processInstanceId = pi.getId();
			getJbpmService().setContext(processInstanceId, "actorId", userId);

			// write log here & signal to next node
			Date ngayGui = new Date();
			PmlUser user = PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(userId));
			String phongXuLy = user.getDepartmentsId();
			getJbpmService().signalProcessInstance(processInstanceId);
			logNewNodeSend(vanBanNoiBoId, Long.parseLong(userId), ngayGui, 0, processInstanceId, 1, phongXuLy);
		}
		catch (Exception e) {
			log.error("ERROR: no add workflow instance");
			e.printStackTrace();
		}	
	}


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
	
	private LogVanBanNoiBo logNewNodeSend(
			long vanBanNoiBoId, long nguoiXuLyId, Date ngayGui, 
			int loaiQuyTrinh, long processInstanceId, int step, String phongXuLy) {

			// add log information
			LogVanBanNoiBo logVanBanNoiBo = new LogVanBanNoiBoImpl();
			// id of PmlDocumentReceiptLog
//			long pmlDocumentSendLogId = -1;
			long logVanBanNoiBoId = -1;
			try {
//				pmlDocumentSendLogId = CounterLocalServiceUtil.increment();
				logVanBanNoiBoId = CounterLocalServiceUtil.increment();

				// get state process code from process instance
				String stateProcessCode = getStateNode(processInstanceId);
				PmlStateProcess stateProcess = getStateProcessFromCode(stateProcessCode);
				

				// write information to log
				logVanBanNoiBo.setLogVanBanNoiBoId(logVanBanNoiBoId);
				// pmlDocumentSendLog.setReceiveDate(receiptDate); //yenlt close
				// 15/04/2010\
				logVanBanNoiBo.setVanBanNoiBoId(vanBanNoiBoId);
				logVanBanNoiBo.setNguoiXuLy(nguoiXuLyId);
				logVanBanNoiBo.setNgayGui(ngayGui);
				logVanBanNoiBo.setLoaiQuyTrinh(0);
				logVanBanNoiBo.setProcessInstanceId(processInstanceId);
				logVanBanNoiBo.setStep(1);
				LogVanBanNoiBoLocalServiceUtil.addLogVanBanNoiBo(logVanBanNoiBo);
				logVanBanNoiBo.setPhongXuLy(phongXuLy);
				// set number of log row for a fileId.
//				pmlDocumentSendLog.setTransition_(PmlDocumentSendLogUtil.countByDocumentSendId(documentSendId) + 1);
//				logVanBanNoiBo.setBuocLuanChuyen(buocLuanChuyen)

				/*
				 * phmphuc close 18/06/2010 - yeu cau buoc chuyen dau tien
				 * (transition_ = 1) thi senddatebefore is null if (1 ==
				 * pmlDocumentSendLog.getTransition_() ) {
				 * pmlDocumentSendLog.setSendDateBefore(receiptDate); }
				 */

				// yenlt update 16/04/2010 cap nhat phong ban xu ly
//				PmlUser pmlUser = null;
//				pmlUser =
//					PmlUserLocalServiceUtil.getPmlUser(Long.parseLong(userId));
//				pmlDocumentSendLog.setDepartmentProcessId(pmlUser.getDepartmentsId());
//				// end
//				// persistence log.
//				PmlDocumentSendLogLocalServiceUtil.updatePmlDocumentSendLog(pmlDocumentSendLog);
//				// yenlt update 15/04/2010 // cap nhat receivedate trong truong hop
//				// soan cong van di tra loi cho cong van den
//				PmlDocumentReceiptLog documentReceiptLog = null;
//				List<PmlDocumentReceiptLog> documentReceiptLogList =
//					new ArrayList<PmlDocumentReceiptLog>();
//				PmlEdmDocumentReceipt documentReceipt = null;
//				long documentReceiptId = 0;
//				PmlEdmAnswerDetail answerDetail = null;
//				List<PmlEdmAnswerDetail> answerDetailList =
//					new ArrayList<PmlEdmAnswerDetail>();
//
//				answerDetailList =
//					PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);
//
//				if (answerDetailList.size() > 0) {
//					answerDetail = answerDetailList.get(0);
//					documentReceiptId = answerDetail.getDocumentReceiptId();
//					documentReceiptLogList =
//						PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Type(
//							documentReceiptId, 0);
//
//					/*
//					 * phmphuc update 15/06/2010 - sap xep theo transition cap nhat
//					 * ngay nhan cua receiver trong t/h soan vb di tra loi vb den
//					 */
//					Collections.sort(
//						documentReceiptLogList,
//						new Comparator<PmlDocumentReceiptLog>() {
//
//							public int compare(
//								PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {
//
//								int sort =
//									o2.getTransition_() - o1.getTransition_();
//								return sort;
//							}
//						});
//					// end
//
//					// phmphuc close 15/06/2010
//					// int transition = 1;
//					if (documentReceiptLogList.size() != 0) {
//						/*
//						 * if (documentReceiptLogList.size() > 1) { transition =
//						 * documentReceiptLogList.size() -1; } documentReceiptLog =
//						 * documentReceiptLogList.get(transition); end
//						 */
//						documentReceiptLog = documentReceiptLogList.get(0);
//						documentReceiptLog.setReceiveDate(receiptDate);
//						documentReceiptLog.setReceiveDateTime(receiptDate);
//						PmlDocumentReceiptLogLocalServiceUtil.updatePmlDocumentReceiptLog(documentReceiptLog);
//					}
//				}
				// end
			}
			catch (Exception e) {
				log.error("ERROR: in method logNewNode in class " + VanBanNoiBoLiferayWorkflowService.class); 
			}
			return logVanBanNoiBo;
		}
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
			log.error("ERROR: in method getStateProcessFromCode in class " + VanBanNoiBoLiferayWorkflowService.class);
		}

		return stateProcess;
	}
}
