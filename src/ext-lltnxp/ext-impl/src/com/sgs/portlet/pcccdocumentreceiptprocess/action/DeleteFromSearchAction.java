package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

/**
 * Xoa van ban den tu trang tim kiem
 * 
 * @author XUANCONG
 */
public class DeleteFromSearchAction extends DocumentReceiptPortletAction {

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		// Do nothing
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", 0);
		long companyId = ParamUtil.getLong(req, "companyId", 0);
		
		try {
			// Kiem tra ma so van ban co ton tai hay ko. 
			// Neu ko ton tai se vang loi NoSuchPmlEdmDocumentReceiptException
			PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
			
			// Xoa tap tin dinh kem theo van ban pml_edm_attachedfile
			PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFileByOO(documentReceiptId, 
					new PmlEdmDocumentReceiptImpl().getClass().getName());
			// Xoa log chi tiet luan chuyen van ban
			PmlDocumentReceiptLogLocalServiceUtil.deletePmlDocumentReceiptLogByRecId(documentReceiptId);
			// Xoa tham chieu van ban va qui trinh jbpm
			PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWFByRecId(documentReceiptId);
			// Xoa tham chieu van ban den va van ban di
			try {
				// Tim de xoa, bo qua loi
				PmlEdmAnswerDetailUtil.remove(documentReceiptId);
			} // end try
			catch (Exception ex) {
				// Do nothing
			} // end catch
			// Xoa bang pml_edm_bookdocumentrecordto: chua hieu ro phan nay
			PmlEdmBookDocumentRecordToLocalServiceUtil.deletePmdEdmBookDocumentRecordToByRecId(documentReceiptId);
			// Bang pml_edm_processdocumentreceiptdetail co dung ma so van ban den nhung ko co du lieu nen chua xoa
			// Khi nao dung bang nay thi moi them chuc nang xoa
			// Xoa chi tiet ho so cong viec
			PmlChiTietHSCVLocalServiceUtil.deletePmlChiTietHSCVByCVDenId(documentReceiptId);
			// Xoa thong tin van ban den
			PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(companyId, documentReceiptId);
			
			// add parameter for Workflow Service to delete workflow instance
			addWorkflowParameter(req, "documentReceiptId",
					WorkflowParam.TRANSIENT, "" + documentReceiptId);
		} 
		catch (Exception e) {
			if (e instanceof NoSuchPmlEdmDocumentReceiptException) { // Khong tim thay van ban de xoa
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				System.out.println("Co loi khi xoa van ban khi tim kiem.");
			}
		} // end catch
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.search");
	}
}
