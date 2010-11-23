package com.nss.portlet.loai_van_ban.action;

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
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.model.impl.LoaiVanBanImpl;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil;
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
		String redirect = ParamUtil.getString(req, "redirect", "/nss/loai_van_ban/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLoaiVanBan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLoaiVanBan(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLoaiVanBan(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLoaiVanBan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLoaiVanBan(req, res);
			}
		}
	}
	
	private void updateActiveLoaiVanBan(ActionRequest req, ActionResponse res) {
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		LoaiVanBan loaiVanBan = null;
		Date date = new Date();
		try {
			loaiVanBan = LoaiVanBanLocalServiceUtil.getLoaiVanBan(maLoaiVanBan);
			if (loaiVanBan.getActive() == 1 ) {
				loaiVanBan.setActive(0);
				loaiVanBan.setModifieddate(date);
				loaiVanBan = LoaiVanBanLocalServiceUtil.updateLoaiVanBan(loaiVanBan);
			} else if (loaiVanBan.getActive() == 0) {
				loaiVanBan.setActive(1);
				loaiVanBan.setModifieddate(date);
				loaiVanBan = LoaiVanBanLocalServiceUtil.updateLoaiVanBan(loaiVanBan);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	private void updateLoaiVanBan(ActionRequest req) {
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		String tenLoaiVanBan = ParamUtil.getString(req, "tenLoaiVanBan");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		LoaiVanBan loaiVanBan = null;
		Date date = new Date();
		try {
			loaiVanBan = LoaiVanBanLocalServiceUtil.getLoaiVanBan(maLoaiVanBan);
			loaiVanBan.setTenLoaiVanBan(tenLoaiVanBan);
			if (null != user) {
				loaiVanBan.setCompanyid(user.getCompanyId());
				loaiVanBan.setUserid(userId);
			}
			
			if (active) {
				loaiVanBan.setActive(1);
			} else {
				loaiVanBan.setActive(0);
			}
			loaiVanBan.setDescription(description);
			loaiVanBan.setModifieddate(date);
			
			LoaiVanBanLocalServiceUtil.updateLoaiVanBan(loaiVanBan);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void deleteLoaiVanBan(ActionRequest req) {
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		try {
			vanBanPhapQuyList = VanBanPhapQuyLocalServiceUtil.getVanbanPhapQuyFromMaLoaiVanBan(maLoaiVanBan);
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
				LoaiVanBanLocalServiceUtil.deleteLoaiVanBan(maLoaiVanBan);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void editLoaiVanBan(ActionRequest req, ActionResponse res) {
		long maLoaiVanBan = ParamUtil.getLong(req, "maLoaiVanBan");
		LoaiVanBan loaiVanBan = null;
		
		try {
			loaiVanBan = LoaiVanBanLocalServiceUtil.getLoaiVanBan(maLoaiVanBan);
			req.setAttribute("loaiVanBan", loaiVanBan);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void addLoaiVanBan(ActionRequest req) {
		String tenLoaiVanBan = ParamUtil.getString(req, "tenLoaiVanBan");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long maLoaiVanBan = 0;
		LoaiVanBan loaiVanBan = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maLoaiVanBan = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		try {
			loaiVanBan = new LoaiVanBanImpl();
			loaiVanBan.setMaLoaiVanBan(maLoaiVanBan);
			loaiVanBan.setTenLoaiVanBan(tenLoaiVanBan);
			loaiVanBan.setCreatedate(date);
			if (null != user) {
				loaiVanBan.setCompanyid(user.getCompanyId());
				loaiVanBan.setUserid(userId);
			}
			
			if (active) {
				loaiVanBan.setActive(1);
			} else {
				loaiVanBan.setActive(0);
			}
			loaiVanBan.setDescription(description);
			
			LoaiVanBanLocalServiceUtil.addLoaiVanBan(loaiVanBan);
			
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
				String redirect = ParamUtil.getString(req, "redirect");
				req.setAttribute("redirect", redirect);
				
				return mapping.findForward("portlet.nss.loai_van_ban.view");
			}
	}

}
