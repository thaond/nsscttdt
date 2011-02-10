/**
 * Xoa cong van di
 * 
 * Sau khi xoa cong van, he thong chuyen toi trang hienh danh sach (display.jsp)
 */
package com.sgs.portlet.document.sendprocess.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
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
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.util.DocumentSendUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author doanhdv
 *
 */
public class DeleteAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(DeleteAction.class);
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
		_log.info("----------delete process----------");
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		String deleteMessage = "";
		try {
			PmlEdmDocumentSendLocalServiceUtil.deletePmlEdmDocumentSend(documentSendId);
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
		_log.info("size list document send" + documentSends.size());
		
		req.setAttribute("documentSends", documentSends);
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				_log.info("----------delete----------");
				return mapping.findForward("portlet.sgs.document.sendprocess.view");
			}
	}
}
