
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.processtype.service.persistence.ProcessTypeUtil;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeImpl;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;

/**
 * ChangeAssignDepartmentAction class is used to prepare data for assign
 * department form and add information assign department into workflow.
 * 
 * @version 1.5 10 Apr 2009
 * @author doanhdv
 * @author kienbqc
 */
@SuppressWarnings("unused")
public class ChangeAssignDepartmentAction extends DocumentReceiptPortletAction {

	private static Log _log =
		LogFactory.getLog(ChangeAssignDepartmentAction.class);

	/**
	 * Add document for department
	 * 
	 * @param req
	 *            ActionRequest
	 * @param res
	 *            ActionRespose
	 * @param mainDepartment
	 */
	private void bookDocumentRecordTo(
		ActionRequest req, ActionResponse res, String mainDepartment) {

		Date date = new Timestamp(new Date().getTime());
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");

		if ((mainDepartment == null) || "".equals(mainDepartment)) {
			_log.info("ERROR: no have deppartment process main");
			return;
		}

		// get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));

		int documentRecordTypeId =
			PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);

		PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo =
			PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(
				yearInUse, mainDepartment, documentRecordTypeId);

		if ((pmlEdmDocumentRecordTo.getYearInUse() != null) &&
			(pmlEdmDocumentRecordTo.getDepartmentsId() != null)) {
			PmlEdmBookDocumentRecordTo bookDocumentRecordTo =
				new PmlEdmBookDocumentRecordToImpl();
			int currentRecordIncr =
				(int) (pmlEdmDocumentRecordTo.getCurrentRecord() + 1);
			/* set data into bookDocumentRecordTo object */
			bookDocumentRecordTo =
				setDataIntoBookDocumentRecordTo(
					bookDocumentRecordTo, documentReceiptId,
					pmlEdmDocumentRecordTo, date, currentRecordIncr);

			try {
				/* Add PmlEdmBookDocumentRecordTo into system */

				PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);

				pmlEdmDocumentRecordTo.setCurrentRecord(currentRecordIncr);
				PmlEdmDocumentRecordToLocalServiceUtil.updatePmlEdmDocumentRecordTo(pmlEdmDocumentRecordTo);
			}
			catch (SystemException e) {
				System.out.println("ERROR: in method bookDocumentRecordTo " +
					e.getMessage());
				e.printStackTrace();
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		// get params in request

		// minh update 20100127

		// String[] supportDepartments =
		// req.getParameterValues("supportDepartments");
		// String supportedDepartment = "";
		//
		//
		// if (supportDepartments != null && supportDepartments.length > 0 ) {
		// for (int i = 0; i < supportDepartments.length; i++) {
		// supportedDepartment += supportDepartments[i];
		// if (i + 1 < supportDepartments.length) {
		// supportedDepartment += Constants.DEPARTMENT_SEPERATOR;
		// }
		// }
		// }
		// String[] supportUsers = req.getParameterValues("supportUsers");
		// String supportedUsers = "";
		//
		// if ((supportUsers != null) && (supportUsers.length > 0)) {
		// for (int i = 0; i < supportUsers.length; i++) {
		// supportedUsers += supportUsers[i];
		// if (i + 1 < supportUsers.length) {
		// supportedUsers += Constants.DEPARTMENT_SEPERATOR;
		// }
		// }
		// }
		// end

		// Canh Update 20110122
		String supportUsers2 = ParamUtil.getString(req, "supportUsers2", "");
		String receivers = ParamUtil.getString(req, "receivers", "");
		JSONObject supportUsers2JsonObject = new JSONObject();
		JSONObject receiversJsonObject = new JSONObject();
		try {
			supportUsers2JsonObject = new JSONObject(supportUsers2);
		}
		catch (Exception e) {
		}
		try {
			receiversJsonObject = new JSONObject(receivers);
		}
		catch (Exception e) {
		}

		String[] supportUsers = req.getParameterValues("supportUsers");
		StringBuilder supportedUsers = new StringBuilder();
		StringBuilder issuingPlaces = new StringBuilder();

		if ((supportUsers != null) && (supportUsers.length > 0)) {
			for (String supportUser : supportUsers) {
				supportUsers2JsonObject.put(supportUser, "");
			}
		}

		Iterator<String> iterator = supportUsers2JsonObject.keys();
		while (iterator.hasNext()) {
			supportedUsers.append(iterator.next());
			if (iterator.hasNext()) {
				supportedUsers.append(Constants.DEPARTMENT_SEPERATOR);
			}
		}
		iterator = receiversJsonObject.keys();
		while (iterator.hasNext()) {
			issuingPlaces.append(iterator.next());
			if (iterator.hasNext()) {
				issuingPlaces.append(",");
			}
		}
		addWorkflowParameter(
			req, "issuingPlaces", WorkflowParam.TRANSIENT,
			issuingPlaces.toString());
		// End of Canh Update 20110122 issuingPlaces

		// minh update 20100315
		PortletPreferences prefs = req.getPreferences();
		String[] listUserLDB = prefs.getValues("listUserLDB", new String[0]);

		int countLDB = ParamUtil.getInteger(req, "countLDB");

		if (countLDB == supportUsers.length) {
			addWorkflowParameter(req, "isPTB", WorkflowParam.TRANSIENT, "true");
		}
		else if (countLDB == 0) {
			addWorkflowParameter(req, "isLDP", WorkflowParam.TRANSIENT, "true");
		}
		else {
			addWorkflowParameter(
				req, "isPTBAndLDP", WorkflowParam.TRANSIENT, "true");
			String listUserLDBString = "";
			for (int i = 0; i < listUserLDB.length; i++) {
				listUserLDBString += listUserLDB[i];
				if (i + 1 < listUserLDB.length) {
					listUserLDBString += Constants.DEPARTMENT_SEPERATOR;
				}
			}
			addWorkflowParameter(
				req, "listUserLDB", WorkflowParam.TRANSIENT, listUserLDBString);
		}
		// end

		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt =
			PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);

		// minh update 20100127
		// String mainDepartment = ParamUtil.getString(req, "mainDepartment",
		// "");
		String mainUser = ParamUtil.getString(req, "mainUser", "");
		// end

		// minh update 20101117
		Boolean checkInfo = ParamUtil.getBoolean(req, "checkInfo");
		addWorkflowParameter(
			req, "checkInfo", WorkflowParam.TRANSIENT,
			String.valueOf(checkInfo));
		if (checkInfo) {
			String processInformation =
				ParamUtil.getString(req, "processInformation", "");
			addWorkflowParameter(
				req, "processInformation", WorkflowParam.TRANSIENT,
				processInformation);
		}
		else {
			for (int i = 0; i < supportUsers.length; i++) {
				addWorkflowParameter(
					req,
					"processInformationForUser" + supportUsers[i],
					WorkflowParam.TRANSIENT,
					ParamUtil.getString(req, "processInformationForUser" +
						supportUsers[i], ""));
			}
		}
		// end minh update 20101117

		String dateNumberProcess =
			ParamUtil.getString(req, "dateNumberProcess", "0");
		boolean noTimpeProcess =
			ParamUtil.getBoolean(req, "noTimpeProcess", false);

		// phmphuc update 18/10/2010 - lay ngay xu ly theo calendar
		String expireDate =
			ParamUtil.getString(req, "totalDateProcessCalenRes");
		// end phmphuc update 18/11/2010

		if ("".equals(dateNumberProcess)) {
			dateNumberProcess = "0";
		}
		int totalDateProcess = ParamUtil.getInteger(req, "totalDateProcess", 0);
		// TSS
		String totalDateProcessCalen =
			ParamUtil.getString(req, "totalDateProcessCalen");
		String totalDateProcessCalenRes =
			ParamUtil.getString(req, "totalDateProcessCalenRes");
		SimpleDateFormat partDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCalen = null;
		Date dateCalenRes = null;
		// try{ // yenlt close 26072010
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
			// phmphuc update 18/11/2010
			// totalDateOff =
			// PmlEdmDocumentReceiptLocalServiceUtil.totalDateOff(date,
			// totalDateProcessCalen);
			totalDateOff =
				PmlHolidayLocalServiceUtil.checkDateHolidayWithTwoDays(
					date, totalDateProcessCalen);
			// end phmphuc update 18/11/2010
		}
		// lay tong so ngay - di so ngay nghi;
		// yenlt update 26072010
		// long totalDateProcessCalenDis = dateCalen.getTime() -
		// dateNow.getTime();
		long totalDateProcessCalenDis = 0;
		if (null != dateCalen) {
			totalDateProcessCalenDis = dateCalen.getTime() - dateNow.getTime();
		}
		// end yenlt update 26072010

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

		// minh update 20100316
		if ((documentReceipt.getDocumentType() == null) ||
			"".equals(documentReceipt.getDocumentType())) {
			// minh update 20091022
			if (!noTimpeProcess) {
				documentReceipt.setProcessTime(totalDateProcess);
			}
			else {
				documentReceipt.setProcessTime(0);
			}
			// end update
		}
		// end

		// goi ham tinh ngay nghi trong khoang thoi gian hien tai dien ngay chon
		// tu calendar ngay giai quyet
		int totalDateOffRes = 0;
		if (!totalDateProcessCalenRes.equals("")) {
			// phmphuc update 18/11/2010
			// totalDateOffRes =
			// PmlEdmDocumentReceiptLocalServiceUtil.totalDateOff(date,
			// totalDateProcessCalenRes);
			totalDateOffRes =
				PmlHolidayLocalServiceUtil.checkDateHolidayWithTwoDays(
					date, totalDateProcessCalenRes);
			// end phmphuc update 18/11/2010
		}
		// lay tong so ngay - di so ngay nghi;
		// yenlt update 26072010
		// long totalDateProcessCalenResDis = dateCalenRes.getTime() -
		// dateNow.getTime();
		long totalDateProcessCalenResDis = 0;
		if (null != dateCalenRes) {
			totalDateProcessCalenResDis =
				dateCalenRes.getTime() - dateNow.getTime();
		}
		// end yenlt update 26072010

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
		// }catch(Exception e){} // end yenlt close 26072010

		// End
		documentReceipt.setDateButPhe(new Date());
		// PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
		// Canh update
		User user = PortalUtil.getUser(req);
		PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(
			user.getCompanyId(), documentReceipt);
		// end of Canh

		// minh update 20100316
		if ((documentReceipt.getDocumentType() == null) ||
			"".equals(documentReceipt.getDocumentType())) {
			// String documentType = ParamUtil.getString(req,"documentType");
			// Quan add start: lay cac cach thuc xu ly da duoc check
			String[] lstProcessType = req.getParameterValues("processType");
			int documentTypeMax = 1;

			long documentId = ParamUtil.getLong(req, "documentReceiptId"); // lay
																			// macongvan
																			// de
																			// luu
																			// vao
																			// bang
																			// saveprocesstype

			if ((lstProcessType != null) && (lstProcessType.length > 0)) {
				for (int i = 0; i < lstProcessType.length; i++) {
					ProcessType processType =
						ProcessTypeLocalServiceUtil.getProcessTypeById(Long.valueOf(lstProcessType[i]));
					if (processType != null) {
						if (processType.getFlagProcessType() > documentTypeMax) {
							documentTypeMax = processType.getFlagProcessType();
						}

						// luu vao bang saveprocesstype
						SaveProcessType saveProcessType =
							new SaveProcessTypeImpl();
						saveProcessType.setSptId(CounterServiceUtil.increment()); // set
																					// id
						saveProcessType.setDocId(documentId); // set macongvan
						saveProcessType.setFlagProcessType(Long.valueOf(lstProcessType[i]));// set
																							// processtypeid
						SaveProcessTypeLocalServiceUtil.addSaveProcessType(saveProcessType);
					}
				}
			}
			String documentType = String.valueOf(documentTypeMax);
			// Quan add end

			// update document Type
			updateDocumentType(req, documentType);
		}
		// end

		// insert into book document record
		// ben thu thiem khong can vao so cua phong
		// bookDocumentRecordTo(req, res, mainDepartment);

		// minh update 20100127
		// addWorkflowParameter(req, "mainDepartment", WorkflowParam.TRANSIENT,
		// mainDepartment);
		// addWorkflowParameter(req, "supportedDepartment",
		// WorkflowParam.TRANSIENT, supportedDepartment);
		addWorkflowParameter(req, "mainUser", WorkflowParam.TRANSIENT, mainUser);
		addWorkflowParameter(
			req, "supportedUsers", WorkflowParam.TRANSIENT,
			supportedUsers.toString());
		// end
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

		// addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT,
		// String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt update 11082010
		// yenlt update 20101101 chuyen thanh cong thi xoa trong bang tam
		long documentReceiptIdTemp =
			ParamUtil.getLong(req, "documentReceiptIdTemp", 0);
		addWorkflowParameter(
			req, "documentReceiptIdTemp", WorkflowParam.TRANSIENT,
			String.valueOf(documentReceiptIdTemp));
		// end yenlt update 20101101

		addWorkflowParameter(
			req, "dateNumberProcess", WorkflowParam.TRANSIENT,
			dateNumberProcess);
		addWorkflowParameter(
			req, "expireDate", WorkflowParam.TRANSIENT, expireDate); // phmphuc
																		// them
																		// 18/11/2010
		addWorkflowParameter(
			req, "documentReceiptId", WorkflowParam.TRANSIENT,
			String.valueOf(documentReceiptId));
		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(
	 * org.apache.struts.action.ActionMapping,
	 * org.apache.struts.action.ActionForm, javax.portlet.PortletConfig,
	 * javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// load cac danh muc dung chung cho cac select box
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);

		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
				PmlDepartmentsLeaderUtil.findAll();

			// minh update 20100315
			long userIdXLT = ParamUtil.getLong(req, "userIdXLT");

			PortletPreferences prefs = req.getPreferences();
			String[] listUserLDB =
				prefs.getValues("listUserLDB", new String[0]);
			List<String> listUserLDBString = ListUtil.toList(listUserLDB);
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderListUserLDB =
				new ArrayList<PmlDepartmentsLeader>();
			// van thu khong co trong tuong hop nay
			try {
				List<PmlDepartmentsLeader> pmlDepartmentsLeaderUserIdXLT =
					PmlDepartmentsLeaderUtil.findByUserId(userIdXLT);
				List<PmlDepartmentsLeader> pmlDepartmentsLeaderUserSign =
					PmlDepartmentsLeaderUtil.findByUserId(PortalUtil.getUserId(req));

				if (userIdXLT > 0) {
					if (pmlDepartmentsLeaderUserIdXLT.get(0).getMain() &&
						listUserLDBString.contains(String.valueOf(userIdXLT))) {
						for (int i = 0; i < pmlDepartmentsLeaderList.size(); i++) {
							if (pmlDepartmentsLeaderList.get(i).getUserId() == userIdXLT) {
								pmlDepartmentsLeaderList.remove(i);
								break;
							}
						}
					}
					else {
						for (int i = 0; i < pmlDepartmentsLeaderList.size(); i++) {
							if (pmlDepartmentsLeaderList.get(i).getUserId() == userIdXLT) {
								pmlDepartmentsLeaderList.remove(i);
								break;
							}
						}
						for (int i = 0; i < listUserLDB.length; i++) {
							pmlDepartmentsLeaderListUserLDB.add(PmlDepartmentsLeaderUtil.findByUserId(
								Long.parseLong(listUserLDB[i])).get(0));
						}
					}
				}
				else {
					if (pmlDepartmentsLeaderUserSign.get(0).getMain() &&
						listUserLDBString.contains(String.valueOf(PortalUtil.getUserId(req)))) {
						for (int i = 0; i < pmlDepartmentsLeaderList.size(); i++) {
							if (pmlDepartmentsLeaderList.get(i).getUserId() == PortalUtil.getUserId(req)) {
								pmlDepartmentsLeaderList.remove(i);
								break;
							}
						}
					}
					else {
						for (int i = 0; i < pmlDepartmentsLeaderList.size(); i++) {
							if (pmlDepartmentsLeaderList.get(i).getUserId() == PortalUtil.getUserId(req)) {
								pmlDepartmentsLeaderList.remove(i);
								break;
							}
						}
						for (int i = 0; i < listUserLDB.length; i++) {
							pmlDepartmentsLeaderListUserLDB.add(PmlDepartmentsLeaderUtil.findByUserId(
								Long.parseLong(listUserLDB[i])).get(0));
						}
					}
				}
				pmlDepartmentsLeaderList.removeAll(pmlDepartmentsLeaderListUserLDB);
			}
			catch (Exception e) {
				_log.error(e.getMessage());
			}
			// end

			if (!pmlDepartmentsLeaderList.isEmpty()) {
				Collections.sort(
					pmlDepartmentsLeaderList,
					new Comparator<PmlDepartmentsLeader>() {

						public int compare(
							PmlDepartmentsLeader pDL1, PmlDepartmentsLeader pDL2) {

							String departmentName1 = "";
							String departmentName2 = "";
							try {
								departmentName1 =
									DepartmentUtil.findByPrimaryKey(
										pDL1.getDepartmentsId()).getDepartmentsName();
							}
							catch (Exception e) {
							}

							try {
								departmentName2 =
									DepartmentUtil.findByPrimaryKey(
										pDL2.getDepartmentsId()).getDepartmentsName();
							}
							catch (Exception e) {
							}

							return departmentName1.compareTo(departmentName2);
						}
					});
			}

			req.setAttribute(
				"pmlDepartmentsLeaderList", pmlDepartmentsLeaderList);

			// truyen danh sach processtype
			List<ProcessType> listprocesstype = ProcessTypeUtil.findAll();
			req.setAttribute("listprocesstype", listprocesstype);
			// date begin transition
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			req.setAttribute("beginDate", sdf.format(date));

			req.setAttribute(
				"documentReceiptId",
				ParamUtil.getLong(req, "documentReceiptId"));
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.changedeparments");
		}
	}

	/**
	 * Set data into BookDocumentRecordTo
	 * 
	 * @param bookDocumentRecordTo
	 * @param documentReceiptId
	 * @param pmlEdmDocumentRecordTo
	 * @param date
	 * @return PmlEdmBookDocumentRecordTo object
	 */
	private PmlEdmBookDocumentRecordTo setDataIntoBookDocumentRecordTo(
		PmlEdmBookDocumentRecordTo bookDocumentRecordTo,
		long documentReceiptId, PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
		Date date, int currentRecordIncr) {

		bookDocumentRecordTo.setDocumentReceiptId(documentReceiptId);
		bookDocumentRecordTo.setDocumentRecordToId(pmlEdmDocumentRecordTo.getDocumentRecordToId());
		bookDocumentRecordTo.setDateCreate(date);
		bookDocumentRecordTo.setSoCongVanDenPhongHienTai(currentRecordIncr);
		return bookDocumentRecordTo;
	}

	/**
	 * get all number date process in limit
	 * 
	 * @param req
	 * @return List<Integer>
	 */

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
