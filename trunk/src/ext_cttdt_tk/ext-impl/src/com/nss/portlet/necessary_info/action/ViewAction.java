package com.nss.portlet.necessary_info.action;

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
import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.model.impl.ThongTinCanThietImpl;
import com.nss.portlet.necessary_info.service.ThongTinCanThietLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/necessary_info/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addThongTinCanThiet(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editThongTinCanThiet(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteThongTinCanThiet(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateThongTinCanThiet(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveThongTinCanThiet(req, res);
			}
		}
	}

	public void deleteThongTinCanThiet(ActionRequest req) {
		long maThongTinCanThiet = ParamUtil.getLong(req, "maThongTinCanThiet");
		Image image = null;
		ThongTinCanThiet thongTinCanThiet = null;
		try {
			thongTinCanThiet = ThongTinCanThietLocalServiceUtil.getThongTinCanThiet(maThongTinCanThiet);
			image = ImageLocalServiceUtil.getImage(thongTinCanThiet.getImageId_liferay());
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
		
		if (null != thongTinCanThiet) {
			try {
				ThongTinCanThietLocalServiceUtil.deleteThongTinCanThiet(maThongTinCanThiet);
				req.setAttribute("delete", true);
			} catch (Exception e) {
				req.setAttribute("delete", false);
				_log.error(e);
			}
		}
	}

	public void editThongTinCanThiet(ActionRequest req, ActionResponse res) {
		long maThongTinCanThiet = ParamUtil.getLong(req, "maThongTinCanThiet");
		
		ThongTinCanThiet thongTinCanThiet = null;
		try {
			thongTinCanThiet = ThongTinCanThietLocalServiceUtil.getThongTinCanThiet(maThongTinCanThiet);
			req.setAttribute("thongTinCanThiet", thongTinCanThiet);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public void updateThongTinCanThiet(ActionRequest req) {
		long maThongTinCanThiet = ParamUtil.getLong(req, "maThongTinCanThiet");
		String tenThongTinCanThiet = ParamUtil.getString(req, "tenThongTinCanThiet");
		String urlThongTinCanThiet = ParamUtil.getString(req, "urlThongTinCanThiet");
		String moTaThongTinCanThiet = ParamUtil.getString(req, "mota");
		int thuTuThongTinCanThiet = ParamUtil.getInteger(req, "thutuThongTinCanThiet");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		ThongTinCanThiet thongTinCanThiet = null;
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
			thongTinCanThiet = ThongTinCanThietLocalServiceUtil.getThongTinCanThiet(maThongTinCanThiet);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		thongTinCanThiet.setMaThongTinCanThiet(maThongTinCanThiet);
		thongTinCanThiet.setTenThongTinCanThiet(tenThongTinCanThiet);
		thongTinCanThiet.setUrlWebsite(urlThongTinCanThiet);
		thongTinCanThiet.setMoTaThongTinCanThiet(moTaThongTinCanThiet);
		thongTinCanThiet.setCompanyid(companyId);
		thongTinCanThiet.setUserid(userId);
		thongTinCanThiet.setModifieddate(date);
		thongTinCanThiet.setThuTuThongTin(thuTuThongTinCanThiet);
		thongTinCanThiet.setTarget(target);
		if (active) {
			thongTinCanThiet.setActive(1);
		} else {
			thongTinCanThiet.setActive(0);
		}
		
		if (file.exists()) {
			Image image = null;
			try {
				image = ImageLocalServiceUtil.getImage(thongTinCanThiet.getImageId_liferay());
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
			thongTinCanThiet.setImageId_liferay(imageUpload);
			try {
				ImageLocalServiceUtil.updateImage(imageUpload, file);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		}
			
		try {
			ThongTinCanThietLocalServiceUtil.updateThongTinCanThiet(thongTinCanThiet);
		} catch (SystemException e2) {
			_log.error(e2);
		}
		
	}

	public void updateActiveThongTinCanThiet(ActionRequest req,
			ActionResponse res) {
		long maThongTinCanThiet = ParamUtil.getLong(req, "maThongTinCanThiet");
		ThongTinCanThiet thongTinCanThiet = null;
		Date date = new Date();
		try {
			thongTinCanThiet = ThongTinCanThietLocalServiceUtil.getThongTinCanThiet(maThongTinCanThiet);
			if (thongTinCanThiet.getActive() == 1 ) {
				thongTinCanThiet.setActive(0);
				thongTinCanThiet.setModifieddate(date);
				thongTinCanThiet = ThongTinCanThietLocalServiceUtil.updateThongTinCanThiet(thongTinCanThiet);
			} else if (thongTinCanThiet.getActive() == 0) {
				thongTinCanThiet.setActive(1);
				thongTinCanThiet.setModifieddate(date);
				thongTinCanThiet = ThongTinCanThietLocalServiceUtil.updateThongTinCanThiet(thongTinCanThiet);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} 
	}

	public void addThongTinCanThiet(ActionRequest req) {
		long maThongTinCanThiet = 0;
		String tenThongTinCanThiet = ParamUtil.getString(req, "tenThongTinCanThiet");
		String urlThongTinCanThiet = ParamUtil.getString(req, "urlThongTinCanThiet");
		String moTaThongTinCanThiet = ParamUtil.getString(req, "mota");
		int thuTuThongTinCanThiet = ParamUtil.getInteger(req, "thutuThongTinCanThiet");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		ThongTinCanThiet thongTinCanThiet = null;
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
			maThongTinCanThiet = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		thongTinCanThiet = new ThongTinCanThietImpl();
		thongTinCanThiet.setMaThongTinCanThiet(maThongTinCanThiet);
		thongTinCanThiet.setTenThongTinCanThiet(tenThongTinCanThiet);
		thongTinCanThiet.setUrlWebsite(urlThongTinCanThiet);
		thongTinCanThiet.setMoTaThongTinCanThiet(moTaThongTinCanThiet);
		thongTinCanThiet.setCompanyid(companyId);
		thongTinCanThiet.setUserid(userId);
		thongTinCanThiet.setCreatedate(date);
		thongTinCanThiet.setThuTuThongTin(thuTuThongTinCanThiet);
		thongTinCanThiet.setTarget(target);
		if (active) {
			thongTinCanThiet.setActive(1);
		} else {
			thongTinCanThiet.setActive(0);
		}
		try {
			/*
			 * upload file
			 */
			if (file.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				thongTinCanThiet.setImageId_liferay(imageUpload);
				try {
					ImageLocalServiceUtil.updateImage(imageUpload, file);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			ThongTinCanThietLocalServiceUtil.addThongTinCanThiet(thongTinCanThiet);
			
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
				
				return mapping.findForward("portlet.nss.necessary_info.view");
			}
	}

}

