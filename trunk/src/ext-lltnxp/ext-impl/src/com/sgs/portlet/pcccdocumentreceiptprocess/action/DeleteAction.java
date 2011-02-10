/**
 * Xoa cong van co id duoc xac dinh
 * Sau khi xoa tra ve trang hien danh sach (display.jsp)
 */
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

/**
 * Delete a receipt document when it know id of receipt document
 * @author doanhdv
 * @author kienbqc
 */
public class DeleteAction extends DocumentReceiptPortletAction {
	/**
	 * When client want detele a receipt document, this method is called.
	 * To delete a receipt document, we will: <br>
	 * 
	 * - Get id of receipt document in parameter.<br>
	 * - Use PmlEdmDocumentReceiptLocalServiceUtil object to delete that document 
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
	
		long documentReceiptIdTemp = ParamUtil.getLong(req, "documentReceiptIdTemp", 0); // yenlt update 20101101
		if (documentReceiptId <= 0) {
			return;
		} // end if
		
		try {
			// yenlt update 20101101 cap nhat lai idDocTemp khi back lai chua chuyen
			if (0 != documentReceiptIdTemp) {
				List<PmlEdmAttachedFile> attachedFileList = new ArrayList<PmlEdmAttachedFile>();
				attachedFileList = PmlEdmAttachedFileUtil.findByObjectContentId(documentReceiptId);
				if (!attachedFileList.isEmpty()) {
					for (PmlEdmAttachedFile attachedFile : attachedFileList) {
						attachedFile.setObjectContentId(documentReceiptIdTemp);
						attachedFile = PmlEdmAttachedFileLocalServiceUtil.updatePmlEdmAttachedFile(attachedFile);
					}
				}
			} else { // end yenlt update 20101101 
				// Xoa tap tin dinh kem theo van ban pml_edm_attachedfile
				PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFileByOO(documentReceiptId, 
						new PmlEdmDocumentReceiptImpl().getClass().getName());
			}
			
			// Xoa log chi tiet luan chuyen van ban
			PmlDocumentReceiptLogLocalServiceUtil.deletePmlDocumentReceiptLogByRecId(documentReceiptId);
			// Xoa tham chieu van ban va qui trinh jbpm
			//PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWFByRecId(documentReceiptId);// yenlt close 28082010
			// Xoa tham chieu van ban den va van ban di
			try {
				// Tim de xoa, bo qua loi
				PmlEdmAnswerDetailUtil.remove(documentReceiptId);
			} // end try
			catch (Exception ex) {
				// Do nothing
			} // end catch
			// Xoa bang pml_edm_bookdocumentrecordto: chua hieu ro phan nay
			try {
				PmlEdmBookDocumentRecordToLocalServiceUtil.deletePmdEdmBookDocumentRecordToByRecId(documentReceiptId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			// Bang pml_edm_processdocumentreceiptdetail co dung ma so van ban den nhung ko co du lieu nen chua xoa
			// Khi nao dung bang nay thi moi them chuc nang xoa
			// Xoa chi tiet ho so cong viec
			PmlChiTietHSCVLocalServiceUtil.deletePmlChiTietHSCVByCVDenId(documentReceiptId);

			User user = PortalUtil.getUser(req);
			// Xoa thong tin van ban den
			//xuancong close PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(documentReceiptId);
			PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(user.getCompanyId(), documentReceiptId);
			PortletSession session= req.getPortletSession();
			session.setAttribute("transition", "delete",PortletSession.APPLICATION_SCOPE);			
			
			// add parameter for Workflow Service to delete workflow instance
			addWorkflowParameter(req, "documentReceiptId", WorkflowParam.TRANSIENT, "" + documentReceiptId);
		} catch (Exception e) {
		
		}
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		return null;
	}
}
