package com.nss.portlet.onedoorprocess.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.onedoor.ajax.OnedoorDwr;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class ImplementInformation extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(TransferAction.class);
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req,
			ActionResponse res) throws Exception {

		String isDelegate = ParamUtil.getString(req, "isDelegate");
		addWorkflowParameter(req, "isDelegate", WorkflowParam.TRANSIENT, isDelegate);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req,
			RenderResponse res) throws Exception {
		List<User> users = getListUsers(req, res);
		req.setAttribute("users", users);
		
		String  fileId  = ParamUtil.getString(req, "fileId");	
		
		if (fileId != null) {
			PmlFilePCCC pmlFilePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
			if (pmlFilePCCC != null) {
				String totalTimeProcess = pmlFilePCCC.getTotalHour()+"";
				req.setAttribute("totalTimeProcess", totalTimeProcess);
				
				int totalDate = pmlFilePCCC.getTotalDate();
				Date now = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String nowDate = dateFormat.format(now);
				String returnDate = new OnedoorDwr().getExpectedReturningDate(totalDate+"",nowDate);
				
				req.setAttribute("returnDate", returnDate);
			}
		}
		
		
		
		return mapping.findForward("portlet.nss.onedoorprocess.implementinformation");
	}
	
	private List<User> getListUsers(RenderRequest req, RenderResponse res) throws Exception {
		long taskId = ParamUtil.getLong(req, "taskId");
		List<User> users = getLiferayWorkflowService().getPooledUser(taskId);
		Collections.sort(users, new Comparator<User>(){
			public int compare(User o1, User o2) {						
				return o1.getFullName().compareTo(o2.getFullName());
			}					
		});	
		return users;
	}
	
}
