package com.nss.portlet.linh_vuc_van_ban.action;

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
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanImpl;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil;
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
		String redirect = ParamUtil.getString(req, "redirect", "/nss/linh_vuc_van_ban/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLinhVucVanBan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLinhVucVanBan(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLinhVucVanBan(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLinhVucVanBan(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLinhVucVanBan(req, res);
			}
		}
		
	}

	public void updateActiveLinhVucVanBan(ActionRequest req, ActionResponse res) {
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		LinhVucVanBan linhVucVanBan = null;
		Date date = new Date();
		try {
			linhVucVanBan = LinhVucVanBanLocalServiceUtil.getLinhVucVanBan(maLinhVucVanBan);
			if (linhVucVanBan.getActive() == 1 ) {
				linhVucVanBan.setActive(0);
				linhVucVanBan.setModifieddate(date);
				linhVucVanBan = LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(linhVucVanBan);
			} else if (linhVucVanBan.getActive() == 0) {
				linhVucVanBan.setActive(1);
				linhVucVanBan.setModifieddate(date);
				linhVucVanBan = LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(linhVucVanBan);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void editLinhVucVanBan(ActionRequest req, ActionResponse res) {
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		LinhVucVanBan linhVucVanBan = null;
		
		try {
			linhVucVanBan = LinhVucVanBanLocalServiceUtil.getLinhVucVanBan(maLinhVucVanBan);
			req.setAttribute("linhVucVanBan", linhVucVanBan);
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void deleteLinhVucVanBan(ActionRequest req) {
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		List<LinhVucVanBan> linhVucVanBanList = new ArrayList<LinhVucVanBan>();
		
		try {
			vanBanPhapQuyList = VanBanPhapQuyLocalServiceUtil.getVanbanPhapQuyFromMaLinhVucVanBan(maLinhVucVanBan);
		} catch (Exception e1) {
			vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
			_log.error(e1);
		}
		
		try {
			linhVucVanBanList = LinhVucVanBanLocalServiceUtil.getListLinhVucVanBanByParenId(maLinhVucVanBan);
		} catch (Exception e) {
			linhVucVanBanList = new ArrayList<LinhVucVanBan>();
			_log.error(e);
		}
		
		try {
			if (vanBanPhapQuyList.size() == 0 && linhVucVanBanList.size() == 0) {
				req.setAttribute("delete", true);
				LinhVucVanBanLocalServiceUtil.deleteLinhVucVanBan(maLinhVucVanBan);
			} else {
				req.setAttribute("delete", false);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void updateLinhVucVanBan(ActionRequest req) {
		long maLinhVucVanBan = ParamUtil.getLong(req, "maLinhVucVanBan");
		String tenLinhVucVanBan = ParamUtil.getString(req, "tenLinhVucVanBan");
		long parentId = ParamUtil.getLong(req, "parentId");
		
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		LinhVucVanBan linhVucVanBan = null;
		Date date = new Date();
		try {
			linhVucVanBan = LinhVucVanBanLocalServiceUtil.getLinhVucVanBan(maLinhVucVanBan);
			linhVucVanBan.setTenLinhVucVanBan(tenLinhVucVanBan);
			linhVucVanBan.setParentid(parentId);
			if (null != user) {
				linhVucVanBan.setCompanyid(user.getCompanyId());
				linhVucVanBan.setUserid(userId);
			}
			
			if (active) {
				linhVucVanBan.setActive(1);
			} else {
				linhVucVanBan.setActive(0);
			}
			linhVucVanBan.setDescription(description);
			linhVucVanBan.setModifieddate(date);
			
			LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(linhVucVanBan);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void addLinhVucVanBan(ActionRequest req) {
		String tenLinhVucVanBan = ParamUtil.getString(req, "tenLinhVucVanBan");
		long parentId = ParamUtil.getLong(req, "parentId");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		long maLinhVucVanBan = 0;
		try {
			maLinhVucVanBan = CounterLocalServiceUtil.increment();
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		LinhVucVanBan linhVucVanBan = new LinhVucVanBanImpl();
		linhVucVanBan.setMaLinhVucVanBan(maLinhVucVanBan);
		linhVucVanBan.setTenLinhVucVanBan(tenLinhVucVanBan);
		linhVucVanBan.setParentid(parentId);
		linhVucVanBan.setCreatedate(date);
		if (null != user) {
			linhVucVanBan.setCompanyid(user.getCompanyId());
			linhVucVanBan.setUserid(userId);
		}
		if (active) {
			linhVucVanBan.setActive(1);
		} else {
			linhVucVanBan.setActive(0);
		}
		
		linhVucVanBan.setDescription(description);
		
		try {
			LinhVucVanBanLocalServiceUtil.addLinhVucVanBan(linhVucVanBan);
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
				String redirect = ParamUtil.getString(req, "redirect");
				req.setAttribute("redirect", redirect);
				
				List<LinhVucVanBan> linhVucVanBanListParent = new ArrayList<LinhVucVanBan>();
				linhVucVanBanListParent = LinhVucVanBanLocalServiceUtil.getLinhVucVanBans(-1, -1);
				req.setAttribute("linhVucVanBanListParent", linhVucVanBanListParent);
				
				return mapping.findForward("portlet.nss.linh_vuc_van_ban.view");
			}
	}

}
