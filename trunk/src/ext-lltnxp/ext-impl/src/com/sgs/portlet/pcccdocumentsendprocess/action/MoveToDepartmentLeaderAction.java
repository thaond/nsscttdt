
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * <ul>
 * <li>renderStruts: prepare data to view</li>
 * <li>processStrutsAction: process move to department leader action.<br/>
 * After that, redirect to ViewAction</li>
 * </ul>
 * 
 * @author doanhdv
 * @author hieuvh
 */
public class MoveToDepartmentLeaderAction extends DocumentSendPortletAction {

	private static Log _log =
		LogFactory.getLog(MoveToDepartmentLeaderAction.class);

	/**
	 * get department leader of an user via given userId
	 * 
	 * @param userId
	 * @return
	 */
	private List<User> getDepartmentLeaders(long userId) {

		PmlUser user = null;

		// get user in SGS Core
		try {
			user = PmlUserUtil.findByPrimaryKey(userId);
		}
		catch (Exception e) {
			_log.info("PML_User Not Found -> Department Leader Not found");
		}

		// user not found return -1
		if (Validator.isNull(user)) {
			return null;
		}

		// get department leader of user.
		String departmentId = user.getDepartmentsId();

		List<User> dLeaders = new ArrayList<User>();
		List<PmlDepartmentsLeader> leaders = null;

		try {
			// minh 20100330
			// leaders =
			// PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(departmentId,
			// true);
			leaders =
				PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentId);
			// end minh 20100330
		}
		catch (Exception e) {
			_log.info("Department Leader Not found");
			leaders = new ArrayList<PmlDepartmentsLeader>();
		}

		if (leaders.size() > 0) {
			User _leader = null;
			for (PmlDepartmentsLeader leader : leaders) {
				try {
					_leader = UserLocalServiceUtil.getUser(leader.getUserId());
					dLeaders.add(_leader);
				}
				catch (Exception e) {
				}
			}

			return dLeaders;
		}
		else {
			Department department = null;
			List<Department> departmentList = new ArrayList<Department>();
			PmlDepartmentsLeader pmlDepartmentsLeader = null;
			List<PmlDepartmentsLeader> pmlDepartmentsLeaderList =
				new ArrayList<PmlDepartmentsLeader>();
			try {
				department = DepartmentUtil.findByPrimaryKey(departmentId);
				departmentList =
					DepartmentUtil.findByAbbreviateName(department.getAbbreviateName());
			}
			catch (Exception e) {
			}

			for (int i = 0; i < departmentList.size(); i++) {
				try {
					// minh 20100330
					// pmlDepartmentsLeaderList =
					// PmlDepartmentsLeaderUtil.findByDepartmentsId_Main(departmentList.get(i).getDepartmentsId(),
					// true);
					pmlDepartmentsLeaderList =
						PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentList.get(
							i).getDepartmentsId());
					// end minh 20100330
				}
				catch (SystemException e) {
				}

				if (pmlDepartmentsLeaderList.size() > 0) {
					try {
						// minh 20100330
						for (int j = 0; j < pmlDepartmentsLeaderList.size(); j++) {
							// pmlDepartmentsLeader =
							// pmlDepartmentsLeaderList.get(0);
							pmlDepartmentsLeader =
								pmlDepartmentsLeaderList.get(j);
							dLeaders.add(UserLocalServiceUtil.getUser(pmlDepartmentsLeader.getUserId()));
						}
						// end minh 20100330
					}
					catch (Exception e) {
					}
				}
			}
			return dLeaders;
		}
	}

	/**
	 * Get department leader in list
	 * 
	 * @param req
	 * @return List<User>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> results = new ArrayList<User>();
		// xuancong close long documentSendId = ParamUtil.getLong(req,
		// "documentSendId", 0);

		long userId = PortalUtil.getUserId(req);
		List<User> dLeaders = getDepartmentLeaders(userId);

		results.addAll(dLeaders);
		return results;
	}

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation =
			ParamUtil.getString(req, "processInformation", "");

		addWorkflowParameter(
			req, "receiverId", WorkflowParam.TRANSIENT, receiverId + "");
		addWorkflowParameter(
			req, "processInformation", WorkflowParam.TRANSIENT,
			processInformation);
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
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}

		// addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT,
		// String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt update 11082010

		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);

		// phan vao so cong van
		writeDocumentSend(req, res);
	}

	@Override
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

		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.trans");
	}

	/**
	 * Set data into PmlEdmWriteDocumentSend
	 * 
	 * @param bookDocumentRecordTo
	 * @param documentReceiptId
	 * @param pmlEdmDocumentRecordTo
	 * @param date
	 * @return PmlEdmBookDocumentRecordTo object
	 */
	private PmlEdmWriteDocumentSend setDataIntoPmlEdmWriteDocumentSend(
		PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, long documentSendId,
		PmlEdmBookDocumentSend pmlEdmBookDocumentSend, Date date,
		int currentRecordIncr) {

		pmlEdmWriteDocumentSend.setDocumentSendId(documentSendId);
		pmlEdmWriteDocumentSend.setBookDocumentSendId(pmlEdmBookDocumentSend.getBookDocumentSendId());
		pmlEdmWriteDocumentSend.setDateCreated(date);
		pmlEdmWriteDocumentSend.setSoCongVanDiPhongHienTai(currentRecordIncr);
		return pmlEdmWriteDocumentSend;
	}

	/**
	 * Add document for department
	 * 
	 * @param req
	 *            ActionRequest
	 * @param res
	 *            ActionRespose
	 * @param mainDepartment
	 */
	private void writeDocumentSend(ActionRequest req, ActionResponse res) {

		Date date = new Timestamp(new Date().getTime());
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		// get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String yearInUse = String.valueOf(calendar.get(Calendar.YEAR));

		// lay phong cua truong phong
		long userIdTP = PortalUtil.getUserId(req);
		PmlUser pmlUserTP = null;
		try {
			pmlUserTP = PmlUserLocalServiceUtil.getPmlUser(userIdTP);
		}
		catch (Exception e) {
		}
		String tPDepartment = "";
		if (pmlUserTP != null) {
			tPDepartment = pmlUserTP.getDepartmentsId();
		}

		// lay cong van di
		PmlEdmDocumentSend pmlEdmDocumentSend = null;
		try {
			pmlEdmDocumentSend =
				PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		}
		catch (Exception e) {
			pmlEdmDocumentSend = null;
		}

		// lay phong cua nguoi soan
		long userEditor = 0;
		PmlUser pmlUser = null;
		String editorDepartment = null;
		if (pmlEdmDocumentSend != null) {
			userEditor = pmlEdmDocumentSend.getEditorId();
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userEditor);
			}
			catch (Exception e) {
				pmlUser = null;
			}
			if (pmlUser != null) {
				editorDepartment = pmlUser.getDepartmentsId();
			}

			int documentRecordTypeId =
				PmlEdmBookDocumentSendLocalServiceUtil.getDocumentRecordTypeIdByDocumentType(pmlEdmDocumentSend.getDocumentTypeId());

			PmlEdmBookDocumentSend pmlEdmBookDocumentSend =
				new PmlEdmBookDocumentSendImpl();

			if (editorDepartment.equals(tPDepartment)) {
				pmlEdmBookDocumentSend =
					PmlEdmBookDocumentSendLocalServiceUtil.getBookDocumentSend(
						yearInUse, editorDepartment, documentRecordTypeId);
			}

			if ((pmlEdmBookDocumentSend.getYearInUse() != null) &&
				(pmlEdmBookDocumentSend.getDepartmentsId() != null)) {
				PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend =
					new PmlEdmWriteDocumentSendImpl();
				int currentRecordIncr =
					(int) (pmlEdmBookDocumentSend.getCurrentRecord() + 1);
				/* set data into bookDocumentRecordTo object */
				pmlEdmWriteDocumentSend =
					setDataIntoPmlEdmWriteDocumentSend(
						pmlEdmWriteDocumentSend, documentSendId,
						pmlEdmBookDocumentSend, date, currentRecordIncr);

				try {
					/* Add PmlEdmBookDocumentRecordTo into system */

					PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(pmlEdmWriteDocumentSend);

					pmlEdmBookDocumentSend.setCurrentRecord(currentRecordIncr);
					PmlEdmBookDocumentSendLocalServiceUtil.updatePmlEdmBookDocumentSend(pmlEdmBookDocumentSend);
				}
				catch (SystemException e) {
					System.out.println("ERROR: in method writeDocumentSend " +
						e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
