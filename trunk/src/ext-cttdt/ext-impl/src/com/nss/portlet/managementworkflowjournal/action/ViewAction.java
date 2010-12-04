package com.nss.portlet.managementworkflowjournal.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalServiceUtil;
import com.nss.workflow.JournalLiferayPortletAction;
import com.nss.workflow.JournalLiferayWorkflowService;

public class ViewAction extends JournalLiferayPortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		try {
			if (cmd.equals(Constants.ADD)) {
				addProcessDefinitionJournal(req);
			} else if (cmd.equals(Constants.DELETE)) {
				boolean flag = deleteProcess(req);
				if (flag) {
					sendRedirect(req, res, redirect);
				}else {
					req.setAttribute("error_delete_workflowjounal", "error_delete_workflowjounal");
				}
			}
		} catch (Exception e) {
			_log.error("ERROR: in method processStrutsAction in class "	+ ViewAction.class + e.getMessage());
		}
	}

	private void addProcessDefinitionJournal(ActionRequest req) {
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		File fileWorkflow = uploadRequest.getFile("fileWorkflow");
		String dateFrom = ParamUtil.getString(req, "dateFrom", "");
		String dateTo = ParamUtil.getString(req, "dateTo", "");
		String description = ParamUtil.getString(req, "description", "");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long managementWorkflowJournalId = ParamUtil.getLong(req, "managementWorkflowJournalId", 0);
		String dateSaveUpdate = ParamUtil.getString(req, "dateSaveUpdate");
		Timestamp timesFrom = null;
		Timestamp timesTo = null;
		long userId = 0;
		long companyId = 0;
		long groupId = 0 ;
		try {
			userId = PortalUtil.getUserId(req);
			if(userId != 0){
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				groupId = user.getGroup().getGroupId();
			}
		} catch (Exception e1) {
			_log.error("ERROR: in method addProcessDefinitionJournal in class "	+ ViewAction.class + e1.getMessage());
		} 
		try {
			if (!"".equals(dateFrom)) {
				Date dFrom = dateFormat.parse(dateFrom);
				timesFrom = new Timestamp(dFrom.getTime());
			}
			if (!"".equals(dateTo)) {
				Date dTo = dateFormat.parse(dateTo);
				timesTo = new Timestamp(dTo.getTime());
			}
		} catch (ParseException e) {
			timesTo = new Timestamp(0);
		}
		try {
			if (fileWorkflow != null) {
				InputStream is = new FileInputStream(fileWorkflow);
				JournalLiferayWorkflowService documentReceiptLiferayWorkflowService = (JournalLiferayWorkflowService) getLiferayWorkflowService();
				documentReceiptLiferayWorkflowService.deloyProcessSupport(is,description, timesFrom, timesTo, userId, companyId, groupId, managementWorkflowJournalId, dateSaveUpdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean deleteProcess(ActionRequest req) {
		boolean flag = false;
		long manageDocumentWorkflowId = ParamUtil.getLong(req, "manageDocumentWorkflowId");
		long processdefinitionId = ParamUtil.getLong(req, "processdefinitionId");
		try {
			ManagementWorkflowJournal managementWorkflowJournal = ManagementWorkflowJournalLocalServiceUtil
					.getManagementWorkflowJournal(manageDocumentWorkflowId);
			String workflowName = managementWorkflowJournal.getWorkflowname();
			int version = managementWorkflowJournal.getVersion_();
			JournalLiferayWorkflowService deleteProcessDefinitionLiferayWorkflowService = (JournalLiferayWorkflowService) getLiferayWorkflowService();
			boolean check = deleteProcessDefinitionLiferayWorkflowService.deleteProcessDefinition(workflowName, version, manageDocumentWorkflowId, processdefinitionId);
			if(check){
				flag = true;	
			}
		} catch (Exception e) {
			_log.error("ERROR: in method deleteProcess in class "	+ ViewAction.class + e.getMessage());
		}
		return flag;
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		} else {
			return mapping
					.findForward("portlet.nss.managementworkflowjournal.view");
		}
	}
}
