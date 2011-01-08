package com.sgs.portlet.pcccdocumentsendprocess.action;

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
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

/**
 * Xoa van ban di khi tim kiem
 * 
 * @author XUANCONG
 */
public class DeleteFromSearchAction extends DocumentSendPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
		throws Exception {

		// Do nothing
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

		long documentSendId = ParamUtil.getLong(req, "documentSendId");

		try {
			// Kiem tra ma so van ban di ton tai
			PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
			// Xoa log luan chuyen van ban di
			PmlDocumentSendLogLocalServiceUtil.deletePmlDocumentSendLogBySendId(documentSendId);
			// Xoa tham chieu van ban di voi jbpm
			try {
				// Khong xoa o day ma dung jbpm xoa PmlDocumentSendWFUtil.remove(documentSendId);
			} // end try
			catch (Exception ex) {
				// Do nothing
			}
			
			// Xoa chi tiet ho so cong viec
			PmlChiTietHSCVLocalServiceUtil.deletePmlChiTietHSCVByCVDiId(documentSendId);
			// Xoa lien quan van ban den va van ban di
			PmlEdmAnswerDetailLocalServiceUtil.deletePmlEdmAnswerDetailBySendId(documentSendId);
			// Xoa file dinh kem van ban di
			PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFileByOO(documentSendId, 
					new PmlEdmDocumentSendImpl().getClass().getName());
			// Xoa pml_edm_writedocumentsend
			PmlEdmWriteDocumentSendLocalServiceUtil.deletePmlEdmWriteDocumentSendBySendId(documentSendId);
			// Xoa thong tin van ban di
			User user = PortalUtil.getUser(req);
			PmlEdmDocumentSendLocalServiceUtil.deletePmlEdmDocumentSend(user.getCompanyId(), documentSendId);
			// Xoa jbpm cua van ban
			addWorkflowParameter(req, "documentSendId", WorkflowParam.TRANSIENT, String.valueOf(documentSendId));
		} // end try
		catch (Exception e) {
			if (e instanceof NoSuchPmlEdmDocumentSendException) {
				SessionErrors.add(req, e.getClass().getName());
			} // end if
			else {
				System.out.println("Co loi khi xoa van ban di khi tim kiem.");
			}
		} // end catch
		
		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.search");
	}
}
