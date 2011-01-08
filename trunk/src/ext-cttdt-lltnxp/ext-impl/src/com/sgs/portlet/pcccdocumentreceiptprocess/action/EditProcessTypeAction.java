package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeImpl;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil;
import com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypeUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypeUtil;

public class EditProcessTypeAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (Validator.isNotNull(cmd) && cmd.equals(Constants.UPDATE)) {
			updateProcessType(req);
		}
	}
	
	public void updateProcessType(ActionRequest req) {
		long processTypeId = ParamUtil.getLong(req, "processType");
		long documentId = ParamUtil.getLong(req, "documentReceiptId", 0); 
		long documentReceiptLogId = ParamUtil.getLong(req, "documentReceiptLogId", 0);
		long processTypeUserId = ParamUtil.getLong(req, "processTypeUserId", 0); 
		String processTypeDepId = ParamUtil.getString(req, "processTypeDepId");
		String processTypeReason = ParamUtil.getString(req, "processTypeReason");
		
		List<SaveProcessType> saveProcessTypeList = new ArrayList<SaveProcessType>();
		PmlEdmDocumentReceipt documentReceipt = null;
		SaveProcessType saveProcessType = null;
		ProcessType processType = null;
		String processTypeIdBefore = "";
		String processTypeIdAfter = "";
		
		// xoa nhung dong cu va luu dong moi luu vao bang SaveProcessType
		try {
			saveProcessTypeList = SaveProcessTypeUtil.findByDocId(documentId);
			for (int i = 0; i < saveProcessTypeList.size(); i++) {
				processTypeIdBefore += saveProcessTypeList.get(i).getFlagProcessType();
				if (i < saveProcessTypeList.size()-1) {
					processTypeIdBefore += ",";
				}
				SaveProcessTypeLocalServiceUtil.deleteSaveProcessType(saveProcessTypeList.get(i));
			}
		} catch (SystemException e1) {
		}
		
		try {
			processType = ProcessTypeLocalServiceUtil.getProcessTypeById(processTypeId);
		} catch (Exception e) {
		}
		if(processType != null){
			processTypeIdAfter += processTypeId;
			
			saveProcessType = new SaveProcessTypeImpl(); 
			try {
				saveProcessType.setSptId(CounterServiceUtil.increment());
				saveProcessType.setDocId(documentId);								
				saveProcessType.setFlagProcessType(processTypeId);
				SaveProcessTypeLocalServiceUtil.addSaveProcessType(saveProcessType);
			} catch (Exception e) {
			}    		
		}
		
		// thay doi gia tri type trong bang documentreceipt
		try {
			documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentId);
			documentReceipt.setDocumentType(String.valueOf(processType.getFlagProcessType()));
			User user = PortalUtil.getUser(req);
			PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(user.getCompanyId(), documentReceipt); // update trong ham danh chi muc
		} catch (Exception e2) {
		}
		
	
		// luu ly do thay doi
		List<PmlEdmDocumentReceiptProcessType> docProcessTypeList = new ArrayList<PmlEdmDocumentReceiptProcessType>();
		PmlEdmDocumentReceiptProcessType docProcessType = null;
		int processTypeOrderNo = 1;
		long docProcessTypeId = 0;
		try {
			docProcessTypeList = PmlEdmDocumentReceiptProcessTypeUtil.findByDocumentReceiptId(documentId);
			processTypeOrderNo = docProcessTypeList.size();
		} catch (SystemException e) {
			processTypeOrderNo = 1;
		}
		try {
			docProcessTypeId = CounterLocalServiceUtil.increment();
			docProcessType = PmlEdmDocumentReceiptProcessTypeLocalServiceUtil.createPmlEdmDocumentReceiptProcessType(docProcessTypeId);
			docProcessType.setDocumentReceiptId(documentId);
			docProcessType.setDocumentReceiptLogId(documentReceiptLogId);
			docProcessType.setProcessTypeOrderNo(processTypeOrderNo);
			docProcessType.setProcessTypeIdBefore(processTypeIdBefore);
			docProcessType.setProcessTypeIdAfter(processTypeIdAfter);
			docProcessType.setProcessTypeReason(processTypeReason);
			docProcessType.setProcesserId(processTypeUserId);
			docProcessType.setDepartmentId(processTypeDepId);
			docProcessType.setDateEdit(new Date());
			PmlEdmDocumentReceiptProcessTypeLocalServiceUtil.updatePmlEdmDocumentReceiptProcessType(docProcessType);
		} catch (SystemException e) {
		}
		
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		}
		else {
			long documentId = ParamUtil.getLong(req, "documentReceiptId", 0); 
			
			List<SaveProcessType> saveProcessTypeList = new ArrayList<SaveProcessType>();
			List<Long> processTypeIdList = new ArrayList<Long>();
			SaveProcessType saveProcessType = null;
			try {
				saveProcessTypeList = SaveProcessTypeUtil.findByDocId(documentId);
				for (int i = 0; i < saveProcessTypeList.size(); i++) {
					saveProcessType = saveProcessTypeList.get(i);
					processTypeIdList.add(saveProcessType.getFlagProcessType());
				}
			} catch (SystemException e1) {
			}
			
			
			List<ProcessType> processTypeList = new ArrayList<ProcessType>();
			try {
				processTypeList = ProcessTypeLocalServiceUtil.getProcessTypes(-1, -1);
			} catch (Exception e) {
				processTypeList = new ArrayList<ProcessType>();
			}
			req.setAttribute("processTypeIdList", processTypeIdList);
			req.setAttribute("processTypeList", processTypeList);
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.editprocesstype");
		}
	}
}
