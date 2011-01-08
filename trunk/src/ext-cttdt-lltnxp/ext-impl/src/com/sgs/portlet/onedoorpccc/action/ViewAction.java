package com.sgs.portlet.onedoorpccc.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;

public class ViewAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		initDataForRender(req);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.onedoorpccc.view");
			}
	}

	private void initDataForRender(PortletRequest req) throws Exception{
		long userId = PortalUtil.getUserId((RenderRequest) req);
		String userName = PortalUtil.getUserName(userId, "");
		
		req.setAttribute("numberReceipt", "numberReceipt");
		req.setAttribute("userId", userId);
		req.setAttribute("userName", userName);
		
		List<PmlFileType> listFileType = PmlFileTypeUtil.findAll();
		req.setAttribute("listFileType", listFileType);
	}
}
