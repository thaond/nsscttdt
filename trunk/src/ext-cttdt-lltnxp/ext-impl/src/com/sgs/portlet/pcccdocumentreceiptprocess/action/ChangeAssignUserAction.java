/**
 * 
 */

package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.compass.core.util.backport.java.util.Collections;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.DocumentReceiptUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * ChangeAssignAction class can forward to assign.jsp (renderStruts method)
 * 
 * @author doanhdv
 * @author hieuvh - interact workflow
 */
public class ChangeAssignUserAction extends DocumentReceiptPortletAction {

	// xuancong close private static Log _log =
	// LogFactory.getLog(ChangeAssignUserAction.class);

	/**
	 * get days process on main deparmetn
	 * 
	 * @param req
	 * @return List<Integer>
	 */
	private void getTimeProcessOnDeparment(RenderRequest req) {

		int result = 0;
		long numberDateRemain = 0;
		// TSS
		String ddXLChinh = "";
		String ddXLDuocGiao = "";

		// End
		try {
			long documentReceiptId =
				ParamUtil.getLong(req, "documentReceiptId");
			// phmphuc close and change 18/11/2010 - lay danh sach theo user
			// login
			long userLogin = PortalUtil.getUserId(req);
			// List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList =
			// PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = null;
			try {
				pmlDocumentReceiptLogList =
					PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(
						documentReceiptId, userLogin);
			}
			catch (Exception e) {
			}
			// end phmphuc update 18/11/2010
			if ((pmlDocumentReceiptLogList != null) &&
				(pmlDocumentReceiptLogList.size() > 0)) {

				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {
					if (pmlDocumentReceiptLogList.get(i).getNumDateProcess() > 0) {
						result =
							pmlDocumentReceiptLogList.get(i).getNumDateProcess();
						DateFormat dateFormat =
							new SimpleDateFormat("dd/MM/yyyy");
						numberDateRemain =
							result -
								(dateFormat.parse(dateFormat.format(new Date())).getTime() - dateFormat.parse(
									dateFormat.format(pmlDocumentReceiptLogList.get(
										i).getDateProcess())).getTime()) /
								(24 * 60 * 60 * 1000);
						break;
					}
				}
			}

			// phmphuc close and update 13/10/2010
			// TSS
			// Hai Trieu
			// chuyen sang ngay theo dinh dang dd/MM/yyyy
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateFormat.format(new Date()); // ngay hien tai
			int totalDateProMain = result;// tong so ngay xu ly chinh
			DocumentReceiptUtil util = new DocumentReceiptUtil();
			if (totalDateProMain > 0) {
				// ddXLChinh =
				// PmlEdmDocumentReceiptLocalServiceUtil.addDateNum(date,
				// totalDateProMain);
				ddXLChinh =
					dateFormat.format(util.getExpectedReturningDate(
						totalDateProMain + "", date));
			}
			// tong so ngay xu ly duoc giao cho phong ban do dua tren so ngay xu
			// ly chinh
			int totalDateRemain = Integer.valueOf(numberDateRemain + "");
			if (totalDateRemain > 0) {
				// ddXLDuocGiao =
				// PmlEdmDocumentReceiptLocalServiceUtil.addDateNum(date,
				// totalDateRemain);
				ddXLDuocGiao =
					dateFormat.format(util.getExpectedReturningDate(
						totalDateProMain + "", date));
				// End
				// end phmphuc close
			}

		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		// TSS
		req.setAttribute("ddXLChinh", ddXLChinh);
		req.setAttribute("ddXLDuocGiao", ddXLDuocGiao);
		// End
		req.setAttribute("daysProcessDeparmentMain", "" + result);
		req.setAttribute("numberDateRemain", "" + numberDateRemain);
	}

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long[] supportUers =
			ParamUtil.getLongValues(req, "supportUsers", new long[] {});
		long mainUser = ParamUtil.getLong(req, "mainUser");
		int dateNumberProcess =
			ParamUtil.getInteger(req, "dateNumberProcess", 0);
		// xuancong close String processInformation = ParamUtil.getString(req,
		// "processInformation");

		// TSS
		// trieu add date chon tu calender

		String totalDateProcessCalen =
			ParamUtil.getString(req, "totalDateProcessCalen");
		SimpleDateFormat partDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCalen = null;
		// try{ // yenlt close 03082010
		if (!totalDateProcessCalen.equals("")) {
			dateCalen = partDate.parse(totalDateProcessCalen.trim()); // ngay
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
		// yenlt update 03082010
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
		if (dateNumberProcess == 0) {
			dateNumberProcess = totalDateProcessSave;
		}
		// }catch(Exception e){} // yenlt close 03082010
		// End

		String supportedUsers = "";

		/*
		 * yenlt close start 14/04/2010 for (int i = 0; i < supportUers.length;
		 * i++) { if (supportUers[i] == mainUser) { continue; } supportedUsers
		 * += supportUers[i]; if (i + 1 < supportUers.length) { supportedUsers
		 * += Constants.USER_SEPERATOR; } }
		 */
		// yenlt update 14/04/2010
		if ((supportUers != null) && (supportUers.length > 0)) {
			for (int i = 0; i < supportUers.length; i++) {
				supportedUsers += supportUers[i];
				if (i + 1 < supportUers.length) {
					supportedUsers += Constants.USER_SEPERATOR;
				}
			}
		}
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
			for (int i = 0; i < supportUers.length; i++) {
				addWorkflowParameter(
					req,
					"processInformationForUser" + supportUers[i],
					WorkflowParam.TRANSIENT,
					ParamUtil.getString(req, "processInformationForUser" +
						supportUers[i], ""));
			}
		}
		// end minh update 20101117

		/* set information into workflow */
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
		addWorkflowParameter(req, "mainUser", WorkflowParam.TRANSIENT, "" +
			mainUser);
		addWorkflowParameter(
			req, "supportedUsers", WorkflowParam.TRANSIENT, supportedUsers);
		addWorkflowParameter(
			req, "dateNumberProcess", WorkflowParam.TRANSIENT, "" +
				dateNumberProcess);
		addWorkflowParameter(
			req, "expireDate", WorkflowParam.TRANSIENT, totalDateProcessCalen);
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		addWorkflowParameter(
			req, "documentReceiptId", WorkflowParam.TRANSIENT,
			String.valueOf(documentReceiptId));
		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * <p>
	 * Prepare data for assign form: list of user in together deparment with
	 * user login.
	 * </p>
	 * <p>
	 * Step: <br>
	 * - Get id of login user <br>
	 * - Get user from userId <br>
	 * - Get department id of login user <br>
	 * - Get list of user in together department <br>
	 * - Set list into attribute of request <br>
	 * </p>
	 */
	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		/* Get id of login user */
		// yenlt update 11082010
		// long userId = PortalUtil.getUserId(req);
		long userId = 0;
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			userId = PortalUtil.getUserId(req);
		}
		else {
			userId = userIdXLT;
		}
		// end yenlt

		/* Get user from userId */
		PmlUser nowUser = PmlUserLocalServiceUtil.getPmlUser(userId);

		/* Get department id of login user */
		String departmentId = nowUser.getDepartmentsId();

		// minh update
		Department department = null;
		try {
			department = DepartmentUtil.findByPrimaryKey(departmentId);
		}
		catch (Exception e) {
			department = new DepartmentImpl();
		}

		List<Department> departmentList = null;
		try {
			departmentList =
				DepartmentUtil.findByAbbreviateName(department.getAbbreviateName());
		}
		catch (Exception e) {
			departmentList = new ArrayList<Department>();
		}

		List<PmlUser> userSportals = new ArrayList<PmlUser>();
		for (int i = 0; i < departmentList.size(); i++) {
			userSportals.addAll(PmlUserUtil.findByDepartmentsId(departmentList.get(
				i).getDepartmentsId()));
		}

		List<User> users = new ArrayList<User>();

		for (int i = 0; i < userSportals.size(); i++) {
			PmlUser pmlUser = userSportals.get(i);
			// minh update 20100316
			if (pmlUser.getUserId() == userId) {
				continue;
			}
			// end
			User user = UserLocalServiceUtil.getUser(pmlUser.getUserId());
			users.add(user);
		}

		Collections.sort(users, new Comparator<User>() {

			public int compare(User o1, User o2) {

				return o1.getFullName().compareTo(o2.getFullName());
			}
		});

		// //sort with name
		// for (int j = 0; j < users.size(); j++) {
		// int temp = j;
		// for (int i = temp; i < users.size(); i++) {
		// if (users.get(j).getFullName().compareTo(users.get(i).getFullName())>
		// 0) {
		// java.util.Collections.swap(users, j, i);
		// }
		// }
		// }

		// end

		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt =
			PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);

		req.setAttribute("documentReceipt", documentReceipt);
		req.setAttribute("userList", users);
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);

		getTimeProcessOnDeparment(req);

		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			/* Foward to assign.jsp */
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.changeusers");
		}
	}
}
