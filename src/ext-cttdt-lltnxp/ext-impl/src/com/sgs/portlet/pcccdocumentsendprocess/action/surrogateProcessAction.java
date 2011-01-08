package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearch;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchTerms;

public class surrogateProcessAction extends DocumentSendPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {		
	}	
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean vtxulythayldb = ParamUtil.getBoolean(req, "vtxulythayldb", false);
		boolean vtxulythayldvp = ParamUtil.getBoolean(req, "vtxulythayldvp", false);
		
		int leveSendId = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI, 0);
		int loaiCVID = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN, 0);
		PcccDocumentReceiptProcessSearchDisplayTerms displayTerms = new PcccDocumentReceiptProcessSearchDisplayTerms(req);
		displayTerms.setCapgui(leveSendId);		
		displayTerms.setLoaisocongvan(loaiCVID);		
		
		req.setAttribute("userIdXLT", userIdXLT);
		req.setAttribute("statusId", statusId);
		req.setAttribute("vtxulythayldb", vtxulythayldb);
		req.setAttribute("vtxulythayldvp",vtxulythayldvp);
		// yenlt update 20101028
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req, "timkiemtheotieuchi", false);
		long loaiVB = ParamUtil.getLong(req, "loaiVB", 0);
		String donViSoanThao = ParamUtil.getString(req, "donViSoanThao", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String coQuanNhan = ParamUtil.getString(req, "coQuanNhan", "");
		
		String tuNgay = ParamUtil.getString(req, "tuNgay", "");
		String denNgay = ParamUtil.getString(req, "denNgay", "");
		
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/xulythayld");
		portletURL.setParameter("statusId", String.valueOf(statusId));
		portletURL.setParameter("userIdXLT", String.valueOf(userIdXLT));
		if (vtxulythayldb) {
			portletURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
		}
		
		if (vtxulythayldvp) {
			portletURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
		}
		
		PcccDocumentSendProcessSearch searchContainer = new PcccDocumentSendProcessSearch(req, portletURL);
		PcccDocumentSendProcessSearchTerms searchTerms = (PcccDocumentSendProcessSearchTerms) searchContainer.getSearchTerms();
		List<Long> listXLT = new ArrayList<Long>();
		listXLT.add(userIdXLT);
		
		int total1 = 0;
		List<PmlEdmDocumentSend> results = null;
		List<PmlDocumentSendLog> resultLogs = null;
		if (timkiemtheotieuchi == false) {
			results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users(listXLT, String.valueOf(searchTerms.getLoaiSoCongVan()),
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users(listXLT,  String.valueOf(searchTerms.getLoaiSoCongVan())); 
		} else {
			results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users(listXLT, loaiVB, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users(listXLT, loaiVB, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay); 
		}
		
		// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
		resultLogs = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSendLog_Users(listXLT, loaiVB, donViSoanThao, 
					nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, 
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		
		// end phmphuc add 12/11/2010
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total1);
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		
		String portletURLString = portletURL.toString();
		
		req.setAttribute("view.jsp-portletURL", portletURL);
		req.setAttribute("view.jsp-portletURLString", portletURLString);
		req.setAttribute("results", results);
		req.setAttribute("total1", total1);
		req.setAttribute("resultLogs", resultLogs);
		req.setAttribute("searchContainerList", searchContainer);
		// end yenlt update 20101028
		
		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.xulythayld");
		
	}
}