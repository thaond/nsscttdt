package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.Collections;
import java.util.Comparator;
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
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class DetailDocTempAction extends DocumentReceiptPortletAction {

	@Override
	public void processStrutsAction(ActionMapping arg0, ActionForm arg1,
			PortletConfig arg2, ActionRequest arg3, ActionResponse arg4)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm arg1,
			PortletConfig arg2, RenderRequest req, RenderResponse res)
			throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		PmlEdmDocumentReceiptDTO documentReceiptDTO = new PmlEdmDocumentReceiptDTO();
		PmlEdmDocumentReceipt document = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		documentReceiptDTO = populateDocumentReceiptToDTO(req, document);
		
		req.setAttribute("documentDTO", documentReceiptDTO);
		
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
		if (!pmlDocumentReceiptLogList.isEmpty()) {
			Collections.sort(pmlDocumentReceiptLogList, new Comparator<PmlDocumentReceiptLog>(){
				public int compare(PmlDocumentReceiptLog obj1, PmlDocumentReceiptLog obj2) {   
					if (obj1.getTransition_() < obj2.getTransition_()) return -1;
					if (obj1.getTransition_() == obj2.getTransition_()) return 0;
					return 1;
				}                                        
			});
		} // end if
		
		req.setAttribute("pmlDocumentReceiptLogList", pmlDocumentReceiptLogList);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.detaildoctemp");
		}
	}

}
