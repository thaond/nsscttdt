package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.InvalidExtendProcessException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.DocumentReceiptUtil;

public class ViewExtendAction extends PortletAction {

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		
		try {
			if (cmd.equals(Constants.ADD)) { // Them moi gia han
				updatePmlEdmDocumentReceiptExtend(req);
				
				String redirect = ParamUtil.getString(req, "redirect");
				res.sendRedirect(redirect);
			}
		}
		catch (Exception ex) {
			if (ex instanceof InvalidExtendProcessException) {
				req.setAttribute("DocRecExtendAUFlag", "false");
				SessionErrors.add(req, ex.getClass().getName());
			}
			else {
				throw ex;
			}
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
	
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		}
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.viewextend");
		}
	}
	
	protected PmlEdmDocumentReceiptExtend updatePmlEdmDocumentReceiptExtend(
			ActionRequest req) throws Exception {
		
		UploadPortletRequest upReq = PortalUtil.getUploadPortletRequest(req);
		SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		// ***** Lay cac bien tu form truyen xuong thong qua UploadPortletRequest *****
		String cmd = ParamUtil.getString(upReq, Constants.CMD);
		long documentReceiptId = ParamUtil.getLong(upReq, "documentReceiptId");
		long documentReceiptLogId = ParamUtil.getLong(upReq, "documentReceiptLogId");
		Date startProcessDate = ParamUtil.getDate(upReq, "startProcessDate", sDFormat);
		int numDayProcessBef = ParamUtil.getInteger(upReq, "numDayProcessBef");
		Date limitDateBef = ParamUtil.getDate(upReq, "limitDateBef", sDFormat);
		String extendReason = ParamUtil.getString(upReq, "extendReason");
		int numDayProcessAft = ParamUtil.getInteger(upReq, "numDayProcessAft");
		Date limitDateAft = ParamUtil.getDate(upReq, "limitDateAft", sDFormat);
		boolean leanOnLimitDate = ParamUtil.getBoolean(upReq, "leanOnLimitDate");
		long extendUserId = ParamUtil.getLong(upReq, "extendUserId");
		String extendDepartmentId = ParamUtil.getString(upReq, "extendDepartmentId");
		
		// phmphuc cap nhat thoi gian xu ly cho bang ghi de xuat thong tin xu ly
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		// ***** Dua vao gia tri cua leanOnLimitDate de tinh ra mot trong 2 gia tri so ngay xu ly hoac ngay het han *****
		if (leanOnLimitDate == true) { // chon calendar
			// Dua vao limitDateAft de tinh chinh xac ra numDayProcessAft
			if (limitDateAft != null) {
				int totalDateOffRes = PmlHolidayLocalServiceUtil.checkDateHolidayWithTwoDays(date, new SimpleDateFormat("dd/MM/yyyy").format(limitDateAft));
				Date dateNow = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				long timeProcess = limitDateAft.getTime() - dateNow.getTime();
				numDayProcessAft = Integer.valueOf(timeProcess/(1000*60*60*24) +"") - totalDateOffRes;
			}
		} 
		else { // chon ngay
			// Dua vao numDayProcessAft de tinh chinh xac ra limitDateAft
			DocumentReceiptUtil util = new DocumentReceiptUtil();
			limitDateAft = util.getExpectedReturningDate(numDayProcessAft+"", date);
		} 
		// end phmphuc update
		
		PmlEdmDocumentReceiptExtend docRecExt = null;
		if (cmd.equals(Constants.ADD)) {
			// Them vao gia han
			docRecExt = PmlEdmDocumentReceiptExtendLocalServiceUtil.addDocumentReceiptExtend(
					documentReceiptId, documentReceiptLogId, startProcessDate, numDayProcessBef, 
					limitDateBef, extendReason, numDayProcessAft, limitDateAft, leanOnLimitDate, 
					extendUserId, extendDepartmentId);
			// Chinh sua dong log van ban den
			PmlDocumentReceiptLogLocalServiceUtil.updateDocumentReceiptLog(documentReceiptLogId, limitDateAft, numDayProcessAft);
		}
		
		return docRecExt;
	}
}