/**
 * 
 */
package com.nss.portlet.onedoorprocess.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;
import com.nss.portlet.onedoorprocess.util.OneDoorPcccUtil;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;

/**
 * @author triltm
 *
 */
public class DeleteAction extends OneDoorProcessPortletAction {

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "delete",PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		/* Get current user */
		long userId = PortalUtil.getUserId((RenderRequest) req);
		
		/* Get list of fileDTO by user */
		List<PmlFilePcccDTO> fileDTOs = OneDoorPcccUtil.getFilePcccDTOs(userId, null, null);
		req.setAttribute("fileDTOs", fileDTOs);
		return mapping.findForward("portlet.nss.onedoorprocess.delete");
	}

}
