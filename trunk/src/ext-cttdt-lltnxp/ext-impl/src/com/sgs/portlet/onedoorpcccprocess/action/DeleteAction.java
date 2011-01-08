/**
 * 
 */
package com.sgs.portlet.onedoorpcccprocess.action;

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
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlWfOnedoorProcessUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.util.OneDoorPcccUtil;

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
		return mapping.findForward("portlet.sgs.onedoorpcccprocess.delete");
	}

}
