package com.nss.portlet.co_quan_ban_hanh.action;

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
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhImpl;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/co_quan_ban_hanh/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addCoQuanBanHanh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editCoQuanBanHanh(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteCoQuanBanHanh(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateCoQuanBanHanh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveCoQuanBanHanh(req, res);
			}
		}
	}

	public void updateActiveCoQuanBanHanh(ActionRequest req, ActionResponse res) {
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		CoQuanBanHanh coQuanBanHanh  = null;
		Date date = new Date();
		try {
			coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.getCoQuanBanHanh(maCoQuanBanHanh);
			if (coQuanBanHanh.getActive() == 1 ) {
				coQuanBanHanh.setActive(0);
				coQuanBanHanh.setModifieddate(date);
				coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.updateCoQuanBanHanh(coQuanBanHanh);
			} else if (coQuanBanHanh.getActive() == 0) {
				coQuanBanHanh.setActive(1);
				coQuanBanHanh.setModifieddate(date);
				coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.updateCoQuanBanHanh(coQuanBanHanh);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void updateCoQuanBanHanh(ActionRequest req) {
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		String tenCoQuanBanHanh = ParamUtil.getString(req, "tenCoQuanBanHanh");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		CoQuanBanHanh coQuanBanHanh  = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.getCoQuanBanHanh(maCoQuanBanHanh);
			coQuanBanHanh.setMaCoQuanBanHanh(maCoQuanBanHanh);
			coQuanBanHanh.setTenCoQuanBanHanh(tenCoQuanBanHanh);
			coQuanBanHanh.setCreatedate(date);
			if (null != user) {
				coQuanBanHanh.setCompanyid(user.getCompanyId());
				coQuanBanHanh.setUserid(userId);
			}
			
			if (active) {
				coQuanBanHanh.setActive(1);
			} else {
				coQuanBanHanh.setActive(0);
			}
			coQuanBanHanh.setDescription(description);
			
			CoQuanBanHanhLocalServiceUtil.updateCoQuanBanHanh(coQuanBanHanh);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteCoQuanBanHanh(ActionRequest req) {
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		try {
			vanBanPhapQuyList = VanBanPhapQuyLocalServiceUtil.getVanbanPhapQuyFromMaCoQuanBanHanh(maCoQuanBanHanh);
		} catch (Exception e1) {
			vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
			_log.error(e1);
		}
		
		try {
			if (vanBanPhapQuyList.size() > 0) {
				req.setAttribute("delete", false);
			}
			else {
				req.setAttribute("delete", true);
				CoQuanBanHanhLocalServiceUtil.deleteCoQuanBanHanh(maCoQuanBanHanh);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void editCoQuanBanHanh(ActionRequest req, ActionResponse res) {
		long maCoQuanBanHanh = ParamUtil.getLong(req, "maCoQuanBanHanh");
		CoQuanBanHanh coQuanBanHanh = null;
		
		try {
			coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.getCoQuanBanHanh(maCoQuanBanHanh);
			req.setAttribute("coQuanBanHanh", coQuanBanHanh);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void addCoQuanBanHanh(ActionRequest req) {
		String tenCoQuanBanHanh = ParamUtil.getString(req, "tenCoQuanBanHanh");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long maCoQuanBanHanh = 0;
		CoQuanBanHanh coQuanBanHanh  = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maCoQuanBanHanh = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		try {
			coQuanBanHanh = new CoQuanBanHanhImpl();
			coQuanBanHanh.setMaCoQuanBanHanh(maCoQuanBanHanh);
			coQuanBanHanh.setTenCoQuanBanHanh(tenCoQuanBanHanh);
			coQuanBanHanh.setCreatedate(date);
			if (null != user) {
				coQuanBanHanh.setCompanyid(user.getCompanyId());
				coQuanBanHanh.setUserid(userId);
			}
			
			if (active) {
				coQuanBanHanh.setActive(1);
			} else {
				coQuanBanHanh.setActive(0);
			}
			coQuanBanHanh.setDescription(description);
			
			CoQuanBanHanhLocalServiceUtil.addCoQuanBanHanh(coQuanBanHanh);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.co_quan_ban_hanh.view");
			}
	}

}
