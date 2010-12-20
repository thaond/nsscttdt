package com.nss.portlet.link.action;

import java.util.ArrayList;
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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.model.impl.LoaiWebsiteImpl;
import com.nss.portlet.link.service.LienKetWebsiteLocalServiceUtil;
import com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil;

public class ViewLoaiWebsiteAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewLoaiWebsiteAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/link/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLoaiWebsite(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLoaiWebsite(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLoaiWebsite(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLoaiWebsite(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLoaiWebsite(req, res);
			}
		}
	}

	public void updateActiveLoaiWebsite(ActionRequest req, ActionResponse res) {
		long maLoaiWebsite = ParamUtil.getLong(req, "maLoaiWebsite");
		LoaiWebsite loaiWebsite = null;
		Date date = new Date();
		
		try {
			loaiWebsite = LoaiWebsiteLocalServiceUtil.getLoaiWebsite(maLoaiWebsite);
			if (loaiWebsite.getActive() == 1 ) {
				loaiWebsite.setActive(0);
				loaiWebsite.setModifieddate(date);
				loaiWebsite = LoaiWebsiteLocalServiceUtil.updateLoaiWebsite(loaiWebsite);
			} else if (loaiWebsite.getActive() == 0) {
				loaiWebsite.setActive(1);
				loaiWebsite.setModifieddate(date);
				loaiWebsite = LoaiWebsiteLocalServiceUtil.updateLoaiWebsite(loaiWebsite);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteLoaiWebsite(ActionRequest req) {
		long maLoaiWebsite = ParamUtil.getLong(req, "maLoaiWebsite");
		List<LienKetWebsite> lienKetWebsiteList = new ArrayList<LienKetWebsite>();
		
		try {
			lienKetWebsiteList = LienKetWebsiteLocalServiceUtil.getListLienKetWebsiteByLoaiWebsiteId(maLoaiWebsite);
		} catch (Exception e) {
			lienKetWebsiteList = new ArrayList<LienKetWebsite>();
			_log.error(e);
		}
		
		if (lienKetWebsiteList.size() > 0) {
			req.setAttribute("delete", false);
		} else {
			try {
				LoaiWebsiteLocalServiceUtil.deleteLoaiWebsite(maLoaiWebsite);
				req.setAttribute("delete", true);
			} catch (Exception e) {
				req.setAttribute("delete", true);
				_log.error(e);
			}
		}
	}

	public void editLoaiWebsite(ActionRequest req, ActionResponse res) {
		long maLoaiWebsite = ParamUtil.getLong(req, "maLoaiWebsite");
		LoaiWebsite loaiWebsite = null;
		
		try {
			loaiWebsite = LoaiWebsiteLocalServiceUtil.getLoaiWebsite(maLoaiWebsite);
			req.setAttribute("loaiWebsite", loaiWebsite);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void updateLoaiWebsite(ActionRequest req) {
		long maLoaiWebsite = ParamUtil.getLong(req, "maLoaiWebsite");
		String tenLoaiWebsite = ParamUtil.getString(req, "tenLoaiWebsite");
		String moTaLoaiWebsite = ParamUtil.getString(req, "mota");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		LoaiWebsite loaiWebsite = null;
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
			loaiWebsite = LoaiWebsiteLocalServiceUtil.getLoaiWebsite(maLoaiWebsite);
			
			loaiWebsite.setTenLoaiWebsite(tenLoaiWebsite);
			loaiWebsite.setMoTaLoaiWebsite(moTaLoaiWebsite);
			loaiWebsite.setCompanyid(companyId);
			loaiWebsite.setUserid(userId);
			loaiWebsite.setModifieddate(date);
			if (active) {
				loaiWebsite.setActive(1);
			} else {
				loaiWebsite.setActive(0);
			}
			
			LoaiWebsiteLocalServiceUtil.updateLoaiWebsite(loaiWebsite);
		} catch (PortalException e1) {
			_log.error(e1);
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
	}

	public void addLoaiWebsite(ActionRequest req) {
		long maLoaiWebsite = 0;
		String tenLoaiWebsite = ParamUtil.getString(req, "tenLoaiWebsite");
		String moTaLoaiWebsite = ParamUtil.getString(req, "mota");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		LoaiWebsite loaiWebsite = null;
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
			maLoaiWebsite = CounterLocalServiceUtil.increment();
		} catch (Exception e) {
			_log.error(e);
		}
		
		loaiWebsite = new LoaiWebsiteImpl();
		loaiWebsite.setMaLoaiWebsite(maLoaiWebsite);
		loaiWebsite.setTenLoaiWebsite(tenLoaiWebsite);
		loaiWebsite.setMoTaLoaiWebsite(moTaLoaiWebsite);
		loaiWebsite.setCompanyid(companyId);
		loaiWebsite.setUserid(userId);
		loaiWebsite.setCreatedate(date);
		if (active) {
			loaiWebsite.setActive(1);
		} else {
			loaiWebsite.setActive(0);
		}
		
		try {
			LoaiWebsiteLocalServiceUtil.addLoaiWebsite(loaiWebsite);
		} catch (Exception e) {
			_log.error(e);
		}
	}

		public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {
			
			String tabLoai = ParamUtil.getString(req, "tabLoai"); 
			String tabs = ParamUtil.getString(req, "tabs"); 
			String redirect = ParamUtil.getString(req, "redirect");
			
			req.setAttribute("tabLoai", tabLoai);
			req.setAttribute("tabs", tabs);
			req.setAttribute("redirect", redirect);
			
			return mapping.findForward("portlet.nss.link.view");
		}
}
