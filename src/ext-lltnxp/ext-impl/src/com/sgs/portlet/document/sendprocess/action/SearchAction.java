/**
 * 
 */
package com.sgs.portlet.document.sendprocess.action;

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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.send.util.DocumentSendUtil;

/**
 * @author doanhdv
 *
 */
public class SearchAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		searchDocumentSend(req, res);
	}


	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req));
			} else {
				return mapping.findForward("portlet.sgs.document.sendprocess.search");
			}
	}
	private void searchDocumentSend(ActionRequest req, ActionResponse res) {
		
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 5); // default
		
		//get start position of page
		int start = (page - 1) * limit;
		
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentReference = ParamUtil.getString(req, "documentReference");
		//String signer = ParamUtil.getString(req, "signer");
		String issuingPlace = ParamUtil.getString(req, "issuingPlace");
		Date dateArrive = ParamUtil.getDate(req, "receiveDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		String status = ParamUtil.getString(req, "status");
		
		req.setAttribute("briefContent", briefContent);
		req.setAttribute("documentReference", documentReference);
		//req.setAttribute("signer", signer);
		req.setAttribute("issuingPlace", issuingPlace);
		req.setAttribute("dateArrive", dateArrive);
		req.setAttribute("status", status);
		
		List<PmlEdmDocumentSend> documentSends = null;
		try {
			documentSends = PmlEdmDocumentSendUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		documentSends = PmlEdmDocumentSendLocalServiceUtil.filter(documentSends, briefContent, dateArrive, documentReference, issuingPlace);
		List<PmlEdmDocumentSendDTO> documentSendDTOs = new ArrayList<PmlEdmDocumentSendDTO>();
		for(PmlEdmDocumentSend documentSend : documentSends) {
			PmlEdmDocumentSendDTO documentSendDTO = DocumentSendUtil.getDocDTOFormDocSend(documentSend);
			documentSendDTOs.add(documentSendDTO);
		}
		
		int totalItems = documentSendDTOs.size();
		int totalPages = totalItems / limit;
		totalPages = totalItems % limit == 0 ? totalPages : totalPages + 1;
		
		//get end position of page
		int end = Math.min(page * limit, totalItems);
		List<PmlEdmDocumentSendDTO> results = new ArrayList<PmlEdmDocumentSendDTO>();
		
		for (int i = start; i < end; i++) {
			PmlEdmDocumentSendDTO doc = documentSendDTOs.get(i);
			results.add(doc);
		}
		
		//set attributes
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalItems", totalItems);
		req.setAttribute("documentSends", results);
	}
}
