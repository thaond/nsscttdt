package com.nss.portlet.onedoorreport_tinhhinhthulyhosocapso.action;


import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlFileStatus;
import com.nss.portlet.onedoor.service.PmlFileStatusLocalServiceUtil;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;

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
		
		List<PmlFileType> listFileType = PmlFileTypeLocalServiceUtil.findAll();
		List<PmlFileStatus> listFileStatus = PmlFileStatusLocalServiceUtil.getPmlFileStatuses(-1, -1);
		
		req.setAttribute("listFileType", listFileType);
		req.setAttribute("listFileStatus", listFileStatus);
		return mapping.findForward("portlet.nss.onedoorreport_tinhhinhthulyhosocapso.search");
	}
	
}
