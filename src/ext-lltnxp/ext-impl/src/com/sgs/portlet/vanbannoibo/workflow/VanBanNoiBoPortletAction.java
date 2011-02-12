package com.sgs.portlet.vanbannoibo.workflow;

import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.web.struts.action.WorkflowPortletAction;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;

public abstract class VanBanNoiBoPortletAction extends WorkflowPortletAction{
	public static final String COMMAND_PREFIX = "command.vanbannoibo.tiepnhan";
	
	protected VanBanNoiBoLiferayWorkflowService VanBanNoiBoLWS = new VanBanNoiBoLiferayWorkflowService(); 
	protected VanBanNoiBoProcessTaskNameDispatcher VanBanNoiBoTND = new VanBanNoiBoProcessTaskNameDispatcher();
	
	@Override
	protected LiferayWorkflowService getLiferayWorkflowService() {
		 return VanBanNoiBoLWS;
	}

//	@Override
//	protected long getProcessInstanceId(PortletRequest req) {
//		// get documentReceiptId from request.
//		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", -1);
//		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", -1);	
//		// yenlt update rut lai vb 20101119
//		boolean rutLai = ParamUtil.getBoolean(req, "rutLai", false);
//		long receiverIdBack = ParamUtil.getLong(req, "receiverIdBack", -1);
//		// end yenlt update 20101119
//		if (documentReceiptId == -1) {
//			return -1;
//		}		
//		
//		// find a WF_DocumentReceipt entry with given fileId
//		List<PmlDocumentReceiptWF> wfs = null;
//		
//		try {
//			wfs = PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
//		} catch (SystemException e) {
//			e.printStackTrace();
//		}
//
//		if (Validator.isNull(wfs)) {
//			return -1;
//		}
//		
//		
//		if (wfs.size() == 1) {
//			return wfs.get(0).getProcessId();
//		}
//		
////		end		
//		// get User Id login portal
//		long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(req));
//		if (userId == 0) {
//			return -1;
//		}
//		
//		for (Iterator<PmlDocumentReceiptWF> it = wfs.iterator(); it.hasNext();) {
//			PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) it.next();
//			// yenlt update 20101119
//			boolean hasRight = false;
//			if (rutLai) {
//				hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
//						receiverIdBack, wf.getProcessId());
//			} else { // end yenlt update 20101119
//				hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
//						userId, wf.getProcessId());
//			}
//			if (hasRight) {
//				return wf.getProcessId();
//			}
//		}
//		
//		if (userIdXLT != -1) {
//			for (Iterator<PmlDocumentReceiptWF> it = wfs.iterator(); it.hasNext();) {
//				PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) it.next();
//				// yenlt update 20101119
//				boolean hasRight = false;
//				if (rutLai) {
//					hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
//							receiverIdBack, wf.getProcessId());
//				} else { // end yenlt update 20101119
//					hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
//							userIdXLT, wf.getProcessId());
//				}
//				if (hasRight) {
//					return wf.getProcessId();
//				}
//			}
//		}
//		
//		return -1;
//	}
//
//	@Override
//	protected long getTaskInstanceId(PortletRequest req) {
//		// get "taskId" parameter from request.
//		return ParamUtil.getLong(req, "taskId", -1);
//	}
//
//
//	@Override
//	protected TaskNameDispatcher getTaskNameDispatcher() {
//		return documentReceiptTND;
//	}
}
