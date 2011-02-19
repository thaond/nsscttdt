package com.sgs.portlet.vanbannoibo.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;
import com.sgs.portlet.vanbannoibo.workflow.VanBanNoiBoLiferayWorkflowService;

public class AddVanBanNoiBoCommand extends LiferayWorkflowCommand{

	public Object execute() {
		((VanBanNoiBoLiferayWorkflowService)getLiferayWorkflowService()).addWorkflowInstance(getWorkflowParams());
		return "";
	}
}
