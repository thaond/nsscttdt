/**
 * Xoa cong van di
 * 
 * Sau khi xoa cong van, he thong chuyen toi trang hienh danh sach (display.jsp)
 */
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.util.DocumentSendUtil;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

/**
 * @author doanhdv
 * @author XuanCong
 */
public class DeleteAction extends DocumentSendPortletAction {
	//xuancong close private static Log _log = LogFactory.getLog(DeleteAction.class);
	/**
	 * Dung service xoa cong van trong he thong
	 * 
	 * Khai bao bien deleteMessage
	 * Neu xoa thanh cong deteleMessage = "success"
	 * Neu xoa khong thanh cong deleteMessage = "fail"
	 *
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
		throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		//xuancong close _log.info("----------delete process----------");
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "delete",PortletSession.APPLICATION_SCOPE);
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		if (documentSendId <= 0) { // Ma so khong hop le
			return;
		}
		
		String deleteMessage = "";
		try {
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
			addWorkflowParameter(req, "documentSendId", WorkflowParam.TRANSIENT, String.valueOf(documentSendId));
			deleteMessage = "success";
		} catch (PortalException e) {
			deleteMessage = "fail";
		} catch (SystemException e) {
			deleteMessage = "fail";
		}
		
		req.setAttribute("deleteMessage", deleteMessage);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		long userId = PortalUtil.getUserId(req);
		List<PmlEdmDocumentSendDTO> documentSends = DocumentSendUtil.getDocumentSendsByUser(userId);
		//xuancong close _log.info("size list document send" + documentSends.size());
		
		req.setAttribute("documentSends", documentSends);
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
			//xuancong close _log.info("----------delete----------");
				return mapping.findForward("portlet.sgs.document.sendprocess.view");
			}
	}
}
