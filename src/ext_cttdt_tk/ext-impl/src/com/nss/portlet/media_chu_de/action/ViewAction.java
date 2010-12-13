package com.nss.portlet.media_chu_de.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException;
import com.nss.portlet.media_chu_de.MediaChuDeTenChuDeException;
import com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if (cmd.equals(Constants.ADD)) {
				addMediaChuDe(req);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteMediaChuDe(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateMediaChuDe(req);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveMediaChuDe(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String mediaChuDeURL = ParamUtil.getString(req, "mediaChuDeURL");
				sendRedirect(req, res, mediaChuDeURL);
			}
		} catch (Exception e) {
			if (e instanceof MediaChuDeCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof NoSuchMediaChuDeException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
			}
			else if (e instanceof MediaChuDeTenChuDeException) {
				String tenMediaChuDe = ParamUtil.getString(req, "tenMediaChuDe");
				req.setAttribute("tenMediaChuDe", tenMediaChuDe);
				req.setAttribute("mediaChuDeAUFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	public void deleteMediaChuDe(ActionRequest req) throws MediaChuDeCanNotDeleteException, NoSuchMediaChuDeException, PortalException, SystemException {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		MediaChuDeLocalServiceUtil.deleteMediaChuDe(maMediaChuDe);
	}
	
	public MediaChuDe addMediaChuDe(ActionRequest req) throws PortalException, SystemException {
		String tenMediaChuDe = ParamUtil.getString(req, "tenMediaChuDe");
		MediaChuDe mediaChuDe = MediaChuDeLocalServiceUtil.addMediaChuDe(tenMediaChuDe);
		return mediaChuDe;
	}
	
	public MediaChuDe updateMediaChuDe(ActionRequest req) throws PortalException, SystemException {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		String tenMediaChuDe = ParamUtil.getString(req, "tenMediaChuDe");
		MediaChuDe mediaChuDe = MediaChuDeLocalServiceUtil.updateMediaChuDe(maMediaChuDe, tenMediaChuDe);
		return mediaChuDe;	
	}
	
	public void updateActiveMediaChuDe(ActionRequest req, ActionResponse res) {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		MediaChuDe mediaChuDe = null;
		try {
			mediaChuDe = MediaChuDeLocalServiceUtil.getMediaChuDe(maMediaChuDe);
			if(!mediaChuDe.getActive()) {
				mediaChuDe.setActive(true);
				MediaChuDeLocalServiceUtil.updateMediaChuDe(mediaChuDe, true);
			} else {
				mediaChuDe.setActive(false);
				MediaChuDeLocalServiceUtil.updateMediaChuDe(mediaChuDe, true);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			
			if (cmd.equals(Constants.EDIT)) {
				getMediaChuDe(req);
			}
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.media_chu_de.view");
			}
	}
	
	public void getMediaChuDe(RenderRequest req) {
		long maMediaChuDe = ParamUtil.getLong(req, "maMediaChuDe");
		MediaChuDe mediaChuDe = null;
		try {
			mediaChuDe = MediaChuDeLocalServiceUtil.getMediaChuDe(maMediaChuDe);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("mediaChuDe", mediaChuDe);
		
	}

}
