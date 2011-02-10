package com.sgs.portlet.onedoorpcccreport_baocaohosothang.action;

/**
 * @author triltm
 */

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;

public class SearchAction extends OneDoorProcessPortletAction {

	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		List<PmlFileType> listFileType = PmlFileTypeUtil.findAll();
		List<PmlFileStatus> listFileStatus = PmlFileStatusUtil.findAll();
		
		req.setAttribute("listFileType", listFileType);
		req.setAttribute("listFileStatus", listFileStatus);
		return mapping.findForward("portlet.sgs.onedoorpcccreport_baocaohosothang.search");
	}
	
}
