package com.sgs.portlet.onedoorsearch.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			List<PmlFileType> listFileType = PmlFileTypeUtil.findAll();
			List<PmlFileStatus> listFileStatus = PmlFileStatusUtil.findAll();
			
			req.setAttribute("listFileType", listFileType);
			req.setAttribute("listFileStatus", listFileStatus);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.onedoorsearch.view");
			}
	}
	

	public static final PmlProcessDispose getProcessDipose(String fileId) {
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		PmlProcessDispose log = service.getCurrentLogFromFileId(fileId);
		return log;
	}


}
