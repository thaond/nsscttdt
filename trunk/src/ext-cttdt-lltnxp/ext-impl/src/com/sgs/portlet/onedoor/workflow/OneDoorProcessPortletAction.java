package com.sgs.portlet.onedoor.workflow;

import javax.portlet.PortletRequest;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.web.struts.action.WorkflowPortletAction;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;
import com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess;
import com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalServiceUtil;

public abstract class OneDoorProcessPortletAction extends WorkflowPortletAction {
	public static final String COMMAND_PREFIX = "command.onedoor";
	
	private OneDoorProcessLiferayWorkflowService oDPLWS = new OneDoorProcessLiferayWorkflowService(); 
	private OneDoorProcessTaskNameDispatcher oDPTND = new OneDoorProcessTaskNameDispatcher();
	
	@Override
	protected LiferayWorkflowService getLiferayWorkflowService() {
		return oDPLWS;
	}

	@Override
	protected long getProcessInstanceId(PortletRequest arg0) {
		
		// get fileId from request.
		String fileId = ParamUtil.getString(arg0, "fileId", null);
		if (Validator.isNull(fileId)) {
			return -1;
		}
		
		// find a WF_File entry with given fileId
		PmlWfOnedoorProcess wf = null;
		try {
			wf = PmlWfOnedoorProcessLocalServiceUtil.getPmlWfOnedoorProcess(fileId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		
		
		// if not exist WF_File entry return -1
		if (Validator.isNull(wf)) {
			return -1;
		}
		
		// RETURN processId
		return wf.getProcessId();
	}

	@Override
	protected long getTaskInstanceId(PortletRequest arg0) {
		// get "taskId" parameter from request.
		return ParamUtil.getLong(arg0, "taskId", -1);
	}

	@Override
	protected TaskNameDispatcher getTaskNameDispatcher() {
		return oDPTND;
	}
}
