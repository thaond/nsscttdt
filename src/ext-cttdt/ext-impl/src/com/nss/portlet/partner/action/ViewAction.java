package com.nss.portlet.partner.action;

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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.model.impl.PartnerImpl;
import com.nss.portlet.partner.service.PartnerLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String redirect = ParamUtil.getString(req, "redirect", "/nss/partner/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addPartner(req);
				sendRedirect(req, res, redirect);
			}
			
			else if (cmd.equals(Constants.EDIT)) {
				editPartner(req, res);
			}
			
			else if (cmd.equals(Constants.DELETE)) {
				deletePartner(req);
			}
			
			else if (cmd.equals(Constants.UPDATE)) {
				updatePartner(req);
				sendRedirect(req, res, redirect);
			}
			
			else if (cmd.equals(Constants.LOCK)) {
				updateActivePartner(req, res);
			}
		}
	}

	public void deletePartner(ActionRequest req) {
		long maPartner = ParamUtil.getLong(req, "mapartner");
		
		try {
			long imageId = PartnerLocalServiceUtil.getPartner(maPartner).getImageId_liferay();
			
			PartnerLocalServiceUtil.deletePartner(maPartner);
			ImageLocalServiceUtil.deleteImage(imageId);
			
			req.setAttribute("delete", true);
		} catch (PortalException e) {
			req.setAttribute("delete", false);
			_log.error(e);
		} catch (SystemException e) {
			req.setAttribute("delete", false);
			_log.error(e);
		}
	}

	public void editPartner(ActionRequest req, ActionResponse res) {
		long maPartner = ParamUtil.getLong(req, "mapartner");
		
		Partner partner = null;
		try {
			partner = PartnerLocalServiceUtil.getPartner(maPartner);
			req.setAttribute("partner", partner);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public void updatePartner(ActionRequest req) {
		long maPartner = ParamUtil.getLong(req, "mapartner");
		String tenPartner = ParamUtil.getString(req, "tenpartner");
		String urlPartner = ParamUtil.getString(req, "urlpartner");
		String moTaPartner = ParamUtil.getString(req, "motapartner");
		int thuTuPartner = ParamUtil.getInteger(req, "thutupartner");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		Partner partner = null;
		
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		
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
			partner = PartnerLocalServiceUtil.getPartner(maPartner);
			partner.setMaPartner(maPartner);
			partner.setTenPartner(tenPartner);
			partner.setUrlPartner(urlPartner);
			partner.setMoTaPartner(moTaPartner);
			partner.setCompanyid(companyId);
			partner.setUserid(userId);
			partner.setModifieddate(date);
			partner.setThuTuPartner(thuTuPartner);
			partner.setTarget(target);
			
			if (active) {
				partner.setActive(1);
			} else {
				partner.setActive(0);
			}
			
			// upload file
			if (file.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				partner.setImageId_liferay(imageUpload);
				try {
					ImageLocalServiceUtil.updateImage(imageUpload, file);
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			}
			PartnerLocalServiceUtil.updatePartner(partner);
		} catch (PortalException e2) {
			_log.error(e2);
		} catch (SystemException e2) {
			_log.error(e2);
		}
	}

	public void updateActivePartner(ActionRequest req, ActionResponse res) {
		long maPartner = ParamUtil.getLong(req, "mapartner");
		Partner partner = null;
		Date date = new Date();
		try {
			partner = PartnerLocalServiceUtil.getPartner(maPartner);
			if (partner.getActive() == 1 ) {
				partner.setActive(0);
				partner.setModifieddate(date);
				partner = PartnerLocalServiceUtil.updatePartner(partner);
			} else if (partner.getActive() == 0) {
				partner.setActive(1);
				partner.setModifieddate(date);
				partner = PartnerLocalServiceUtil.updatePartner(partner);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} 
	}

	public void addPartner(ActionRequest req) {
		long maPartner = 0;
		String tenPartner = ParamUtil.getString(req, "tenpartner");
		String urlPartner = ParamUtil.getString(req, "urlpartner");
		String moTaPartner = ParamUtil.getString(req, "motapartner");
		int thuTuPartner = ParamUtil.getInteger(req, "thutupartner");
		String target = ParamUtil.getString(req, "target");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		Partner partner = null;
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
			maPartner = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		partner = new PartnerImpl();
		partner.setMaPartner(maPartner);
		partner.setTenPartner(tenPartner);
		partner.setUrlPartner(urlPartner);
		partner.setMoTaPartner(moTaPartner);
		partner.setCompanyid(companyId);
		partner.setUserid(userId);
		partner.setCreatedate(date);
		partner.setThuTuPartner(thuTuPartner);
		partner.setTarget(target);
		
		if (active) {
			partner.setActive(1);
		} else {
			partner.setActive(0);
		}
		
		// upload file
		try {
			long imageUpload = CounterLocalServiceUtil.increment();
			partner.setImageId_liferay(imageUpload);
			try {
				ImageLocalServiceUtil.updateImage(imageUpload, file);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			PartnerLocalServiceUtil.addPartner(partner);
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
				
				String tabDisplay = ParamUtil.getString(req, "tabDisplay");
				String redirect = ParamUtil.getString(req, "redirect");
				
				req.setAttribute("tabDisplay", tabDisplay);
				req.setAttribute("redirect", redirect);
				
				return mapping.findForward("portlet.nss.partner.view");
			}
	}

}
