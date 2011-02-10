
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class ChangeagencyAction extends DocumentReceiptPortletAction {

	private static Log _log = LogFactory.getLog(ChangeagencyAction.class);

	/**
	 * Get list users (Director) to trans document
	 * 
	 * @param req
	 * @return List<PmlUser>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> results = new ArrayList<User>();
		// yenlt update 11082010
		long userId = 0;
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			userId = PortalUtil.getUserId(req);
		}
		else {
			userId = userIdXLT;
		}
		// long userLoginId = PortalUtil.getUserId(req);
		// end yenlt
		User userLeader = UserLocalServiceUtil.getUser(userId);
		results.add(userLeader);
		return results;
	}

	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation =
			ParamUtil.getString(req, "processInformation", "");
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");

		PmlEdmDocumentReceipt documentReceipt =
			PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		String dateNumberProcess =
			ParamUtil.getString(req, "dateNumberProcess", "0");
		if ("".equals(dateNumberProcess)) {
			dateNumberProcess = "0";
		}
		int totalDateProcess = ParamUtil.getInteger(req, "totalDateProcess", 0);
		boolean noTimpeProcess =
			ParamUtil.getBoolean(req, "noTimpeProcess", false);
		// documentReceipt.setProcessTime(totalDateProcess);

		// TSS
		String totalDateProcessCalen =
			ParamUtil.getString(req, "totalDateProcessCalen");
		String totalDateProcessCalenRes =
			ParamUtil.getString(req, "totalDateProcessCalenRes");
		SimpleDateFormat partDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCalen = null;
		Date dateCalenRes = null;
		// try{ // yenlt close 03082010
		if (!totalDateProcessCalen.equals("")) {
			dateCalen = partDate.parse(totalDateProcessCalen.trim()); // ngay
																		// chon
																		// tu
																		// calendar
		}
		if (!totalDateProcessCalenRes.equals("")) {
			dateCalenRes = partDate.parse(totalDateProcessCalenRes.trim()); // ngay
																			// chon
																			// tu
																			// calendar
		}
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); // ngay
																				// hien
																				// tai
		Date dateNow = null;
		dateNow = partDate.parse(date);

		// goi ham tinh so ngay nghi trong khoang thoi gian hien tai den ngay
		// chon tu calendar ngay xu ly
		int totalDateOff = 0;
		if (!totalDateProcessCalen.equals("")) {
			totalDateOff =
				PmlEdmDocumentReceiptLocalServiceUtil.totalDateOff(
					date, totalDateProcessCalen);
		}
		// lay tong so ngay - di so ngay nghi;
		// yenlt update 03082010
		// long totalDateProcessCalenDis = dateCalen.getTime() -
		// dateNow.getTime();
		long totalDateProcessCalenDis = 0;
		if (null != dateCalen) {
			totalDateProcessCalenDis = dateCalen.getTime() - dateNow.getTime();
		}
		// end yenlt update 03082010

		int totalDateProcessSave =
			Integer.valueOf(totalDateProcessCalenDis / (1000 * 60 * 60 * 24) +
				"");

		if (totalDateProcessSave == totalDateOff) {
			totalDateProcessSave = 0;
		}
		else if (totalDateProcessSave < totalDateOff) {
			totalDateProcessSave = 0;
		}
		else {
			totalDateProcessSave = totalDateProcessSave - totalDateOff;
		}
		// Save DB
		if (totalDateProcess == 0) {
			totalDateProcess = totalDateProcessSave;
		}

		// minh update 20091022
		if (!noTimpeProcess) {
			documentReceipt.setProcessTime(totalDateProcess);
		}
		else {
			documentReceipt.setProcessTime(0);
		}

		// end update

		// goi ham tinh ngay nghi trong khoang thoi gian hien tai dien ngay chon
		// tu calendar ngay giai quyet
		int totalDateOffRes = 0;
		if (!totalDateProcessCalenRes.equals("")) {
			totalDateOffRes =
				PmlEdmDocumentReceiptLocalServiceUtil.totalDateOff(
					date, totalDateProcessCalenRes);
		}
		// lay tong so ngay - di so ngay nghi;
		// yenlt update 03082010
		// long totalDateProcessCalenResDis = dateCalenRes.getTime() -
		// dateNow.getTime();
		long totalDateProcessCalenResDis = 0;
		if (null != dateCalenRes) {
			totalDateProcessCalenResDis =
				dateCalenRes.getTime() - dateNow.getTime();
		}
		// end yenlt update 03082010

		int totalDateProcessResSave =
			Integer.valueOf(totalDateProcessCalenResDis /
				(1000 * 60 * 60 * 24) + "");
		if (totalDateProcessResSave == totalDateOffRes) {
			totalDateProcessResSave = 0;
		}
		else if (totalDateProcessResSave < totalDateOffRes) {
			totalDateProcessResSave = 0;
		}
		else {
			totalDateProcessResSave = totalDateProcessResSave - totalDateOffRes;
		}

		// Save DB
		if (dateNumberProcess.equals("0")) {
			dateNumberProcess = String.valueOf(totalDateProcessResSave);
		}
		// }catch(Exception e){} // yenlt close 03082010

		// End
		documentReceipt.setDateButPhe(new Date());

		// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
		// Canh update
		User user = PortalUtil.getUser(req);
		PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(
			user.getCompanyId(), documentReceipt);
		// end of Canh
		// lấy lên loại công văn
		String documentType = ParamUtil.getString(req, "documentType");
		// update document Type
		updateDocumentType(req, documentType);

		// yenlt update 11082010
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		else {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(userIdXLT));
			// Canh
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
			// End of Canh
		}
		// end yenlt
		addWorkflowParameter(
			req, "receiverId", WorkflowParam.TRANSIENT, receiverId + "");
		addWorkflowParameter(
			req, "processInformation", WorkflowParam.TRANSIENT,
			processInformation);

		_log.info("in processstrutsAction method of class ChangeagencyAction");
		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		List<User> users = getListUser(req);

		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("users", users);

		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		req.setAttribute(
			"documentReceiptId", ParamUtil.getLong(req, "documentReceiptId"));
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.changeagency");
	}

	private void updateDocumentType(ActionRequest req, String documentType) {

		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		try {
			PmlEdmDocumentReceipt documentReceipt =
				PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
			documentReceipt.setDocumentType(documentType);
			// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
			// Canh update
			User user = PortalUtil.getUser(req);
			PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(
				user.getCompanyId(), documentReceipt);
			// end of Canh
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}
}
