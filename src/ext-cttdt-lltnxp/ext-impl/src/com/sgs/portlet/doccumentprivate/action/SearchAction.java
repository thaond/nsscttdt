package com.sgs.portlet.doccumentprivate.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;

public class SearchAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String delete = ParamUtil.getString(req, "delete");
			req.setAttribute("flag", ParamUtil.getString(req, "flag"));
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else if (delete.equalsIgnoreCase("delete")){
				long companyId = ParamUtil.getLong(req, "companyId", 0);
				long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
				List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentReceiptId,
								new PmlEdmDocumentReceiptImpl().getClass().getName());

				try {
					for (PmlEdmAttachedFile p : attachedFiles) {
						PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFile(p);
					}
					PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(companyId, documentReceiptId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return mapping.findForward("portlet.sgs.doccumentprivate.view");
	}

}
