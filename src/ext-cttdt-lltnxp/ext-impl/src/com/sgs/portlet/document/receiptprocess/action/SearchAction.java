/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.text.SimpleDateFormat;
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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.util.DocumentReceiptUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author doanhdv
 *
 */
public class SearchAction extends DocumentReceiptPortletAction {
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		searchDocument(req, res);
		
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.document.receiptprocess.search");
			}
	}
	
	private void searchDocument(ActionRequest req, ActionResponse res) {
		
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 5); // default
		
		//get start position of page
		int start = (page - 1) * limit;

		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentReference = ParamUtil.getString(req, "documentReference");
		String signer = ParamUtil.getString(req, "signer");
		String issuingPlace = ParamUtil.getString(req, "issuingPlace");
		Date dateArrive = ParamUtil.getDate(req, "receiveDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		String status = ParamUtil.getString(req, "status");
		
		//set attributes
		req.setAttribute("briefContent", briefContent);
		req.setAttribute("documentReference", documentReference);
		req.setAttribute("signer", signer);
		req.setAttribute("issuingPlace", issuingPlace);
		req.setAttribute("dateArrive", dateArrive);
		
		long userId = PortalUtil.getUserId(req);
		List<PmlEdmDocumentReceipt> list = ((DocumentReceiptLiferayWorkflowService)getLiferayWorkflowService()).getListPmlEdmDocumentReceiptsByUser(userId);
		
		System.out.println("list size = " + list.size());
		List<PmlEdmDocumentReceipt> documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.filter(list, briefContent, signer, dateArrive, documentReference, issuingPlace, status);
		
		int totalItems = documentReceipts.size();
		int totalPages = totalItems / limit;
		totalPages = totalItems % limit == 0 ? totalPages : totalPages + 1;
		
		//get end position of page
		int end = Math.min(page * limit, totalItems);
		
		List<PmlEdmDocumentReceiptDTO> documentDTOs = new ArrayList<PmlEdmDocumentReceiptDTO>();
			
			for (int i = start; i < end; i++) {
				PmlEdmDocumentReceiptDTO docDTO = new PmlEdmDocumentReceiptDTO();
				docDTO = DocumentReceiptUtil.getDocDTOFromDocRe(documentReceipts.get(i));
				documentDTOs.add(docDTO);
			}
		
		// set attributes
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalItems", totalItems);
		req.setAttribute("documentDTOs", documentDTOs);
		
	}
}
