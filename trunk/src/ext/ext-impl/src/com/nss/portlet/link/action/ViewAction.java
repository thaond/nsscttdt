package com.nss.portlet.link.action;

import java.io.File;
import java.util.Date;
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
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.model.impl.LienKetWebsiteImpl;
import com.nss.portlet.link.service.LienKetWebsiteLocalServiceUtil;
import com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/link/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLienKetWebsite(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLienKetWebsite(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLienKetWebsite(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLienKetWebsite(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLienKetWebsite(req, res);
			}
		}
	}

	public void deleteLienKetWebsite(ActionRequest req) {
		long maWebsite = ParamUtil.getLong(req, "maWebsite");
		Image image = null;
		LienKetWebsite lienKetWebsite = null;
		try {
			lienKetWebsite = LienKetWebsiteLocalServiceUtil.getLienKetWebsite(maWebsite);
			image = ImageLocalServiceUtil.getImage(lienKetWebsite.getImageId_liferay());
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
		
		if (null != lienKetWebsite) {
			try {
				LienKetWebsiteLocalServiceUtil.deleteLienKetWebsite(maWebsite);
				req.setAttribute("delete", true);
			} catch (Exception e) {
				req.setAttribute("delete", false);
				_log.error(e);
			}
		}
		
	}

	public void editLienKetWebsite(ActionRequest req, ActionResponse res) {
		long maWebsite = ParamUtil.getLong(req, "maWebsite");
		
		LienKetWebsite lienKetWebsite = null;
		try {
			lienKetWebsite = LienKetWebsiteLocalServiceUtil.getLienKetWebsite(maWebsite);
			req.setAttribute("lienKetWebsite", lienKetWebsite);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public void updateLienKetWebsite(ActionRequest req) {
		long maWebsite = ParamUtil.getLong(req, "maWebsite");
		String tenWebsite = ParamUtil.getString(req, "tenwebsite");
		String urlWebsite = ParamUtil.getString(req, "urlwebsite");
		String moTaWebsite = ParamUtil.getString(req, "mota");
		long loaiWebsite = ParamUtil.getLong(req, "loaiwebsite");
		int thuTuWebsite = ParamUtil.getInteger(req, "thutuwebsite");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		LienKetWebsite lienKetWebsite = null;
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
			lienKetWebsite = LienKetWebsiteLocalServiceUtil.getLienKetWebsite(maWebsite);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		lienKetWebsite.setMaWebsite(maWebsite);
		lienKetWebsite.setTenWebsite(tenWebsite);
		lienKetWebsite.setUrlWebsite(urlWebsite);
		lienKetWebsite.setMoTaWebsite(moTaWebsite);
		lienKetWebsite.setLoaiWebsite(loaiWebsite);
		lienKetWebsite.setCompanyid(companyId);
		lienKetWebsite.setUserid(userId);
		lienKetWebsite.setModifieddate(date);
		lienKetWebsite.setThuTuWebsite(thuTuWebsite);
		lienKetWebsite.setTarget(target);
		if (active) {
			lienKetWebsite.setActive(1);
		} else {
			lienKetWebsite.setActive(0);
		}
		
		if (file.exists()) {
			Image image = null;
			try {
				image = ImageLocalServiceUtil.getImage(lienKetWebsite.getImageId_liferay());
				if (null != image) {
					ImageLocalServiceUtil.deleteImage(image);
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}	
			long imageUpload = 0;
			try {
				imageUpload = CounterLocalServiceUtil.increment();
			} catch (Exception e1) {
				_log.error(e1.getMessage());
			}
			lienKetWebsite.setImageId_liferay(imageUpload);
			try {
				ImageLocalServiceUtil.updateImage(imageUpload, file);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		}
			
		try {
			LienKetWebsiteLocalServiceUtil.updateLienKetWebsite(lienKetWebsite);
		} catch (SystemException e2) {
			_log.error(e2);
		}
		
	}

	public void updateActiveLienKetWebsite(ActionRequest req,
			ActionResponse res) {
		long maWebsite = ParamUtil.getLong(req, "maWebsite");
		LienKetWebsite lienKetWebsite = null;
		Date date = new Date();
		try {
			lienKetWebsite = LienKetWebsiteLocalServiceUtil.getLienKetWebsite(maWebsite);
			if (lienKetWebsite.getActive() == 1 ) {
				lienKetWebsite.setActive(0);
				lienKetWebsite.setModifieddate(date);
				lienKetWebsite = LienKetWebsiteLocalServiceUtil.updateLienKetWebsite(lienKetWebsite);
			} else if (lienKetWebsite.getActive() == 0) {
				lienKetWebsite.setActive(1);
				lienKetWebsite.setModifieddate(date);
				lienKetWebsite = LienKetWebsiteLocalServiceUtil.updateLienKetWebsite(lienKetWebsite);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} 
	}

	public void addLienKetWebsite(ActionRequest req) {
		long maWebsite = 0;
		String tenWebsite = ParamUtil.getString(req, "tenwebsite");
		String urlWebsite = ParamUtil.getString(req, "urlwebsite");
		String moTaWebsite = ParamUtil.getString(req, "mota");
		long loaiWebsite = ParamUtil.getLong(req, "loaiwebsite");
		int thuTuWebsite = ParamUtil.getInteger(req, "thutuwebsite");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		LienKetWebsite lienKetWebsite = null;
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
			maWebsite = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		lienKetWebsite = new LienKetWebsiteImpl();
		lienKetWebsite.setMaWebsite(maWebsite);
		lienKetWebsite.setTenWebsite(tenWebsite);
		lienKetWebsite.setUrlWebsite(urlWebsite);
		lienKetWebsite.setMoTaWebsite(moTaWebsite);
		lienKetWebsite.setLoaiWebsite(loaiWebsite);
		lienKetWebsite.setCompanyid(companyId);
		lienKetWebsite.setUserid(userId);
		lienKetWebsite.setCreatedate(date);
		lienKetWebsite.setThuTuWebsite(thuTuWebsite);
		lienKetWebsite.setTarget(target);
		if (active) {
			lienKetWebsite.setActive(1);
		} else {
			lienKetWebsite.setActive(0);
		}
		try {
			/*
			 * upload file
			 */
			if (file.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				lienKetWebsite.setImageId_liferay(imageUpload);
				try {
					ImageLocalServiceUtil.updateImage(imageUpload, file);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			LienKetWebsiteLocalServiceUtil.addLienKetWebsite(lienKetWebsite);
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				List<LoaiWebsite> loaiWebsiteList = LoaiWebsiteLocalServiceUtil.getLoaiWebsites(-1, -1);
				 
				String tabDisplay = ParamUtil.getString(req, "tabDisplay"); 
				String tabs = ParamUtil.getString(req, "tabs"); 
				String redirect = ParamUtil.getString(req, "redirect");
				
				req.setAttribute("tabDisplay", tabDisplay);
				req.setAttribute("tabs", tabs);
				req.setAttribute("redirect", redirect);
				req.setAttribute("loaiWebsiteList", loaiWebsiteList);
				
				return mapping.findForward("portlet.nss.link.view");
			}
	}

}
