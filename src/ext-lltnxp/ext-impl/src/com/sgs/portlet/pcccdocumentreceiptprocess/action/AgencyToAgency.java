/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author WIN7
 *
 */
public class AgencyToAgency extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(TransAction.class);
	
	@Override
	public void processStrutsAction(ActionMapping arg0, ActionForm arg1,
			PortletConfig arg2, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String receiverIds = ParamUtil.getString(req, "receiverIds", "");
		String receiverIdMain = ParamUtil.getString(req, "receiverIdMain", "");
		String processInformation = ParamUtil.getString(req, "processInformation", "");
		
//		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		// vu update 20110112
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
		//end vu update
		
		addWorkflowParameter(req, "receiverIds",  WorkflowParam.TRANSIENT, receiverIds);
		addWorkflowParameter(req, "receiverIdMain",  WorkflowParam.TRANSIENT, receiverIdMain);
		addWorkflowParameter(req, "processInformation",  WorkflowParam.TRANSIENT, processInformation);
	
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
		
	}

	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm arg1,
			PortletConfig arg2, RenderRequest req, RenderResponse res)
			throws Exception {
		List<User> users = getListUser(req);
		req.setAttribute("users", users);

		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.agencytoagency");
	}
	
	/**
	 * Get list users (Director) to trans document
	 * 
	 * @param req
	 * @return List<PmlUser>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> results = new ArrayList<User>();
		PortletPreferences prefs = req.getPreferences();
		String[] listUser = prefs.getValues("listUserLDB", new String[0]);

		User user = null;
		for (int i = 0; i < listUser.length; i++) {
			try {
				user = UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
			}
			catch (Exception e) {
				user = null;
			}
			if (user != null) {
				results.add(user);
			}
		}

		Collections.sort(results, new Comparator<User>() {

			public int compare(User o1, User o2) {

				return o1.getFullName().compareTo(o2.getFullName());
			}
		});

		return results;
	}

}
