package com.nss.portlet.thong_tin_lien_quan.action;

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
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanImpl;
import com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalServiceUtil;

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
				addThongTinLienQuan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editThongTinLienQuan(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteThongTinLienQuan(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateThongTinLienQuan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveThongTinLienQuan(req, res);
			}
		}
	}

	public void deleteThongTinLienQuan(ActionRequest req) {
		long maThongTinLienQuan = ParamUtil.getLong(req, "maThongTinLienQuan");
		Image image = null;
		ThongTinLienQuan thongTinLienQuan = null;
		try {
			thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.getThongTinLienQuan(maThongTinLienQuan);
			image = ImageLocalServiceUtil.getImage(thongTinLienQuan.getImageId_liferay());
		} catch (Exception e) {
			req.setAttribute("delete", false);
			_log.error(e);
		}
		
		if (null != thongTinLienQuan && null != image) {
			try {
				ImageLocalServiceUtil.deleteImage(image);
				ThongTinLienQuanLocalServiceUtil.deleteThongTinLienQuan(maThongTinLienQuan);
				req.setAttribute("delete", true);
			} catch (Exception e) {
				req.setAttribute("delete", false);
				_log.error(e);
			}
		}
		
	}

	public void editThongTinLienQuan(ActionRequest req, ActionResponse res) {
		long maThongTinLienQuan = ParamUtil.getLong(req, "maThongTinLienQuan");
		
		ThongTinLienQuan thongTinLienQuan = null;
		try {
			thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.getThongTinLienQuan(maThongTinLienQuan);
			req.setAttribute("thongTinLienQuan", thongTinLienQuan);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public void updateThongTinLienQuan(ActionRequest req) {
		long maThongTinLienQuan = ParamUtil.getLong(req, "maThongTinLienQuan");
		String tenThongTinLienQuan = ParamUtil.getString(req, "tenThongTinLienQuan");
		String urlThongTinLienQuan = ParamUtil.getString(req, "urlThongTinLienQuan");
		String moTaThongTinLienQuan = ParamUtil.getString(req, "mota");
		int thuTuThongTinLienQuan = ParamUtil.getInteger(req, "thutuThongTinLienQuan");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		ThongTinLienQuan thongTinLienQuan = null;
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
			thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.getThongTinLienQuan(maThongTinLienQuan);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		Image image = null;
		try {
			image = ImageLocalServiceUtil.getImage(thongTinLienQuan.getImageId_liferay());
			if (null != image) {
				ImageLocalServiceUtil.deleteImage(image);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}	
		
		thongTinLienQuan.setMaThongTinLienQuan(maThongTinLienQuan);
		thongTinLienQuan.setTenThongTinLienQuan(tenThongTinLienQuan);
		thongTinLienQuan.setUrlWebsite(urlThongTinLienQuan);
		thongTinLienQuan.setMoTaThongTinLienQuan(moTaThongTinLienQuan);
		thongTinLienQuan.setCompanyid(companyId);
		thongTinLienQuan.setUserid(userId);
		thongTinLienQuan.setModifieddate(date);
		thongTinLienQuan.setThuTuThongTin(thuTuThongTinLienQuan);
		thongTinLienQuan.setTarget(target);
		if (active) {
			thongTinLienQuan.setActive(1);
		} else {
			thongTinLienQuan.setActive(0);
		}
		
		if (file.exists()) {
			long imageUpload = 0;
			try {
				imageUpload = CounterLocalServiceUtil.increment();
			} catch (Exception e1) {
				_log.error(e1.getMessage());
			}
			thongTinLienQuan.setImageId_liferay(imageUpload);
			try {
				ImageLocalServiceUtil.updateImage(imageUpload, file);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		}
			
		try {
			ThongTinLienQuanLocalServiceUtil.updateThongTinLienQuan(thongTinLienQuan);
		} catch (SystemException e2) {
			_log.error(e2);
		}
		
	}

	public void updateActiveThongTinLienQuan(ActionRequest req,
			ActionResponse res) {
		long maThongTinLienQuan = ParamUtil.getLong(req, "maThongTinLienQuan");
		ThongTinLienQuan thongTinLienQuan = null;
		Date date = new Date();
		try {
			thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.getThongTinLienQuan(maThongTinLienQuan);
			if (thongTinLienQuan.getActive() == 1 ) {
				thongTinLienQuan.setActive(0);
				thongTinLienQuan.setModifieddate(date);
				thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.updateThongTinLienQuan(thongTinLienQuan);
			} else if (thongTinLienQuan.getActive() == 0) {
				thongTinLienQuan.setActive(1);
				thongTinLienQuan.setModifieddate(date);
				thongTinLienQuan = ThongTinLienQuanLocalServiceUtil.updateThongTinLienQuan(thongTinLienQuan);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} 
	}

	public void addThongTinLienQuan(ActionRequest req) {
		long maThongTinLienQuan = 0;
		String tenThongTinLienQuan = ParamUtil.getString(req, "tenThongTinLienQuan");
		String urlThongTinLienQuan = ParamUtil.getString(req, "urlThongTinLienQuan");
		String moTaThongTinLienQuan = ParamUtil.getString(req, "mota");
		int thuTuThongTinLienQuan = ParamUtil.getInteger(req, "thutuThongTinLienQuan");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		ThongTinLienQuan thongTinLienQuan = null;
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
			maThongTinLienQuan = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		thongTinLienQuan = new ThongTinLienQuanImpl();
		thongTinLienQuan.setMaThongTinLienQuan(maThongTinLienQuan);
		thongTinLienQuan.setTenThongTinLienQuan(tenThongTinLienQuan);
		thongTinLienQuan.setUrlWebsite(urlThongTinLienQuan);
		thongTinLienQuan.setMoTaThongTinLienQuan(moTaThongTinLienQuan);
		thongTinLienQuan.setCompanyid(companyId);
		thongTinLienQuan.setUserid(userId);
		thongTinLienQuan.setCreatedate(date);
		thongTinLienQuan.setThuTuThongTin(thuTuThongTinLienQuan);
		thongTinLienQuan.setTarget(target);
		if (active) {
			thongTinLienQuan.setActive(1);
		} else {
			thongTinLienQuan.setActive(0);
		}
		try {
			/*
			 * upload file
			 */
			if (file.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				thongTinLienQuan.setImageId_liferay(imageUpload);
				try {
					ImageLocalServiceUtil.updateImage(imageUpload, file);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			ThongTinLienQuanLocalServiceUtil.addThongTinLienQuan(thongTinLienQuan);
			
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
				
				 
				String tabs = ParamUtil.getString(req, "tabs"); 
				String redirect = ParamUtil.getString(req, "redirect");
				
				req.setAttribute("tabs", tabs);
				req.setAttribute("redirect", redirect);
				
				return mapping.findForward("portlet.nss.thong_tin_lien_quan.view");
			}
	}

}

