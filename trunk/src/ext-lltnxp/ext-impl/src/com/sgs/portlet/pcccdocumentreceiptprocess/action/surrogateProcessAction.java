package com.sgs.portlet.pcccdocumentreceiptprocess.action;

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
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearch;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchTerms;



public class surrogateProcessAction extends DocumentReceiptPortletAction {
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

		// yenlt update 20101022
		
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req,"timkiemtheotieuchi", false);
		String soVBDen = ParamUtil.getString(req, "sovanbanden", "");
		String soHieuGoc = ParamUtil.getString(req, "sohieugoc", "");
		int loaiSoVanBan = ParamUtil.getInteger(req, "loaisocongvan", 0); 
		String issuingplaceId = ParamUtil.getString(req, "issuingplaceId", "");
		String noiPhatHanh = ParamUtil.getString(req, "noiphathanh", "");
		String trichYeu = ParamUtil.getString(req, "trichyeu", "");
		String tuNgay = ParamUtil.getString(req, "tungay");
		String denNgay = ParamUtil.getString(req, "denngay");
		
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/xulythayld");
		portletURL.setParameter("statusId", String.valueOf(statusId));
		portletURL.setParameter("userIdXLT", String.valueOf(userIdXLT));
		if (vtxulythayldb) {
			portletURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
		}
		
		if (vtxulythayldvp) {
			portletURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
		}
		
		PcccDocumentReceiptProcessSearch searchContainerList = new PcccDocumentReceiptProcessSearch(req, portletURL);
		PcccDocumentReceiptProcessSearchTerms searchTerms = (PcccDocumentReceiptProcessSearchTerms) searchContainerList.getSearchTerms();
		List<Long> listXLT = new ArrayList<Long>();
		listXLT.add(userIdXLT);
		int total1 = 0;
		List<PmlEdmDocumentReceipt> results = null;
		List<PmlDocumentReceiptLog> resultLogs = null;
		
		if (timkiemtheotieuchi == false) {
			// Lay tong so cong van
			total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users(listXLT,  String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan())); 
			
			// Lay danh sach doi tuong PmlEdmDocumentReceipt
			results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users(listXLT, String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
					searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		} else {
			total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users(listXLT, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay);
			
			results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users(listXLT, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay,
					searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		}
		
		// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
		resultLogs = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceiptLog_Users(listXLT, soVBDen, soHieuGoc, 
						loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		
		// end phmphuc add 12/11/2010
		
		searchContainerList.setResults(results);
		searchContainerList.setTotal(total1);
		portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
		
		String portletURLString = portletURL.toString();
		
		req.setAttribute("view.jsp-portletURL", portletURL);
		req.setAttribute("view.jsp-portletURLString", portletURLString);
		req.setAttribute("results", results);
		req.setAttribute("total1", total1);
		req.setAttribute("resultLogs", resultLogs);
		req.setAttribute("searchContainerList", searchContainerList);
		// end yenlt update 20101022
		
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.xulythayld");
		
	}
}