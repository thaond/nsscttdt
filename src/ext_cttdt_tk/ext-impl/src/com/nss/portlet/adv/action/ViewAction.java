package com.nss.portlet.adv.action;

import java.io.File;
import java.util.Date;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.model.impl.QuangCaoImpl;
import com.nss.portlet.adv.service.QuangCaoLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/adv/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addQuangCao(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editQuangCao(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteQuangCao(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateQuangCao(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveQuangCao(req, res);
			}
		}
	}

	public void updateActiveQuangCao(ActionRequest req, ActionResponse res) {
		long maQuangCao = ParamUtil.getLong(req, "maQuangCao");
		QuangCao quangCao = null;
		Date date = new Date();
		try {
			quangCao = QuangCaoLocalServiceUtil.getQuangCao(maQuangCao);
			if (quangCao.getActive() == 1 ) {
				quangCao.setActive(0);
				quangCao.setModifieddate(date);
				quangCao = QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
			} else if (quangCao.getActive() == 0) {
				quangCao.setActive(1);
				quangCao.setModifieddate(date);
				quangCao = QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} 
	}
	public void updateQuangCao(ActionRequest req) {
		long maQuangCao = ParamUtil.getLong(req, "maQuangCao");
		String tenQuangCao = ParamUtil.getString(req, "tenQuangCao");
		String urlQuangCao = ParamUtil.getString(req, "urlQuangCao");
		String moTaQuangCao = ParamUtil.getString(req, "mota");
		int thuTuQuangCao = ParamUtil.getInteger(req, "thutuQuangCao");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		QuangCao quangCao = null;
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		// end
		
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		long companyId = 0;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
	
		try {
			quangCao = QuangCaoLocalServiceUtil.getQuangCao(maQuangCao);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		Image image = null;
		try {
			image = ImageLocalServiceUtil.getImage(quangCao.getImageId_liferay());
			if (null != image) {
				ImageLocalServiceUtil.deleteImage(image);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}	
		
		quangCao.setMaQuangCao(maQuangCao);
		quangCao.setTenQuangCao(tenQuangCao);
		quangCao.setUrlWebsite(urlQuangCao);
		quangCao.setMoTaQuangCao(moTaQuangCao);
		quangCao.setCompanyid(companyId);
		quangCao.setUserid(userId);
		quangCao.setModifieddate(date);
		quangCao.setThuTuQuangCao(thuTuQuangCao);
		quangCao.setTarget(target);
		if (active) {
			quangCao.setActive(1);
		} else {
			quangCao.setActive(0);
		}
		
		if (file.exists()) {
			long imageUpload = 0;
			try {
				imageUpload = CounterLocalServiceUtil.increment();
			} catch (Exception e1) {
				_log.error(e1.getMessage());
			}
			quangCao.setImageId_liferay(imageUpload);
			try {
				ImageLocalServiceUtil.updateImage(imageUpload, file);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		}
			
		try {
			QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
		} catch (SystemException e2) {
			_log.error(e2);
		}
		
	}
	public void addQuangCao(ActionRequest req) {
		long maQuangCao = 0;
		String tenQuangCao = ParamUtil.getString(req, "tenQuangCao");
		String urlQuangCao = ParamUtil.getString(req, "urlQuangCao");
		String moTaQuangCao = ParamUtil.getString(req, "mota");
		int thuTuQuangCao = ParamUtil.getInteger(req, "thutuQuangCao");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		QuangCao quangCao = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		long companyId = 0;
		
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		// end
		
		try {
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maQuangCao = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		quangCao = new QuangCaoImpl();
		quangCao.setMaQuangCao(maQuangCao);
		quangCao.setTenQuangCao(tenQuangCao);
		quangCao.setUrlWebsite(urlQuangCao);
		quangCao.setMoTaQuangCao(moTaQuangCao);
		quangCao.setCompanyid(companyId);
		quangCao.setUserid(userId);
		quangCao.setCreatedate(date);
		quangCao.setThuTuQuangCao(thuTuQuangCao);
		quangCao.setTarget(target);
		if (active) {
			quangCao.setActive(1);
		} else {
			quangCao.setActive(0);
		}
		try {
			/*
			 * upload file
			 */
			if (file.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				quangCao.setImageId_liferay(imageUpload);
				try {
					ImageLocalServiceUtil.updateImage(imageUpload, file);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			QuangCaoLocalServiceUtil.addQuangCao(quangCao);
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	public void editQuangCao(ActionRequest req, ActionResponse res) {
		long maQuangCao = ParamUtil.getLong(req, "maQuangCao");
		
		QuangCao quangCao = null;
		try {
			quangCao = QuangCaoLocalServiceUtil.getQuangCao(maQuangCao);
			req.setAttribute("quangCao", quangCao);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	public void deleteQuangCao(ActionRequest req) {
		long maQuangCao = ParamUtil.getLong(req, "maQuangCao");
		Image image = null;
		QuangCao quangCao = null;
		try {
			quangCao = QuangCaoLocalServiceUtil.getQuangCao(maQuangCao);
			image = ImageLocalServiceUtil.getImage(quangCao.getImageId_liferay());
		} catch (Exception e) {
			req.setAttribute("delete", false);
			_log.error(e);
		}
		
		if (null != image) {
			try {
				ImageLocalServiceUtil.deleteImage(image);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		
		if (null != quangCao) {
			try {
				QuangCaoLocalServiceUtil.deleteQuangCao(maQuangCao);
				req.setAttribute("delete", true);
			} catch (Exception e) {
				req.setAttribute("delete", false);
				_log.error(e);
			}
		}
		
	}
	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				String tabs = ParamUtil.getString(req, "tabs"); 
				String redirect = ParamUtil.getString(req, "redirect");
				
				req.setAttribute("tabs", tabs);
				req.setAttribute("redirect", redirect);
				return mapping.findForward("portlet.nss.adv.view");
			}
	}

}
