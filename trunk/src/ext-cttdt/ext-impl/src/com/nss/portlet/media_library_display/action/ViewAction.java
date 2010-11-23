package com.nss.portlet.media_library_display.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, "cmd");
		if (Validator.isNotNull(cmd)) {
			if ("detailtopic".equals(cmd)) {
				long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
				long maMediaLibrary = ParamUtil.getLong(req, "maMediaLibrary");
				List<MediaLibrary> mediaLibraryChuDeList = new ArrayList<MediaLibrary>();
				MediaLibrary mediaLibrary = null;
				mediaLibrary = MediaLibraryLocalServiceUtil.getMediaLibrary(maMediaLibrary);
				mediaLibraryChuDeList = MediaLibraryLocalServiceUtil.findByMaMediaChuDe_Active(maMediaChuDe, true);
				req.setAttribute("mediaLibraryChuDeList", mediaLibraryChuDeList);
				req.setAttribute("mediaLibrary", mediaLibrary);
			}
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<MediaLibrary> mediaLibraryList = new ArrayList<MediaLibrary>();
			List<MediaChuDe> mediaChuDeList = new ArrayList<MediaChuDe>();
			mediaChuDeList = MediaChuDeLocalServiceUtil.findByActive(true);
			mediaLibraryList = MediaLibraryLocalServiceUtil.findByActive(true);
			req.setAttribute("mediaChuDeList", mediaChuDeList);
			req.setAttribute("mediaLibraryList", mediaLibraryList);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.media_library_display.view");
			}
	}

}
