package com.nss.portlet.linh_vuc_thu_tuc.action;

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
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhImpl;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/linh_vuc_thu_tuc/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLinhVucThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLinhVucThuTucHanhChinh(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLinhVucThuTucHanhChinh(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLinhVucThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLinhVucThuTucHanhChinh(req, res);
			}
		}
	}
	
	private void updateActiveLinhVucThuTucHanhChinh(ActionRequest req, ActionResponse res) {
		long maLinhVucThuTucHanhChinh = ParamUtil.getLong(req, "maLinhVucThuTucHanhChinh");
		LinhVucThuTucHanhChinh linhVucThuTuc = null;
		Date date = new Date();
		try {
			linhVucThuTuc = LinhVucThuTucHanhChinhLocalServiceUtil.getLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
			if (linhVucThuTuc.getActive() == 1 ) {
				linhVucThuTuc.setActive(0);
				linhVucThuTuc.setModifieddate(date);
				linhVucThuTuc = LinhVucThuTucHanhChinhLocalServiceUtil.updateLinhVucThuTucHanhChinh(linhVucThuTuc);
			} else if (linhVucThuTuc.getActive() == 0) {
				linhVucThuTuc.setActive(1);
				linhVucThuTuc.setModifieddate(date);
				linhVucThuTuc = LinhVucThuTucHanhChinhLocalServiceUtil.updateLinhVucThuTucHanhChinh(linhVucThuTuc);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	private void updateLinhVucThuTucHanhChinh(ActionRequest req) {
		long maLinhVucThuTucHanhChinh = ParamUtil.getLong(req, "maLinhVucThuTucHanhChinh");
		String tenLinhVucThuTucHanhChinh = ParamUtil.getString(req, "tenLinhVucThuTucHanhChinh");
		long loaiLinhVucId = ParamUtil.getLong(req, "loaiLinhVucId");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		LinhVucThuTucHanhChinh linhVucThuTuc = null;
		Date date = new Date();
		try {
			linhVucThuTuc = LinhVucThuTucHanhChinhLocalServiceUtil.getLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
			linhVucThuTuc.setTenLinhVucThuTucHanhChinh(tenLinhVucThuTucHanhChinh);
			linhVucThuTuc.setMaLoaiThuTucHanhChinh(loaiLinhVucId);
			if (null != user) {
				linhVucThuTuc.setCompanyid(user.getCompanyId());
				linhVucThuTuc.setUserid(userId);
			}
			
			if (active) {
				linhVucThuTuc.setActive(1);
			} else {
				linhVucThuTuc.setActive(0);
			}
			linhVucThuTuc.setDescription(description);
			linhVucThuTuc.setModifieddate(date);
			
			LinhVucThuTucHanhChinhLocalServiceUtil.updateLinhVucThuTucHanhChinh(linhVucThuTuc);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void deleteLinhVucThuTucHanhChinh(ActionRequest req) {
		long maLinhVucThuTucHanhChinh = ParamUtil.getLong(req, "maLinhVucThuTucHanhChinh");
		
		List<ThuTucHanhChinh> thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		try {
			thuTucHanhChinhList = ThuTucHanhChinhLocalServiceUtil.findByMaLinhVucThuTuc(maLinhVucThuTucHanhChinh);
		} catch (Exception e1) {
			thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
			_log.error(e1);
		}
		try {
			if (thuTucHanhChinhList.size() > 0) {
				req.setAttribute("delete", false);
			}
			else {
				req.setAttribute("delete", true);
				LinhVucThuTucHanhChinhLocalServiceUtil.deleteLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void editLinhVucThuTucHanhChinh(ActionRequest req, ActionResponse res) {
		long maLinhVucThuTucHanhChinh = ParamUtil.getLong(req, "maLinhVucThuTucHanhChinh");
		LinhVucThuTucHanhChinh linhVucThuTuc = null;
		
		try {
			linhVucThuTuc = LinhVucThuTucHanhChinhLocalServiceUtil.getLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
			req.setAttribute("linhVucThuTuc", linhVucThuTuc);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void addLinhVucThuTucHanhChinh(ActionRequest req) {
		String tenLinhVucThuTucHanhChinh = ParamUtil.getString(req, "tenLinhVucThuTucHanhChinh");
		long loaiLinhVucId = ParamUtil.getLong(req, "loaiLinhVucId");
		String description = ParamUtil.getString(req, "description");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		long maLinhVucThuTucHanhChinh = 0;
		LinhVucThuTucHanhChinh linhVucThuTuc = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maLinhVucThuTucHanhChinh = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		try {
			linhVucThuTuc = new LinhVucThuTucHanhChinhImpl();
			linhVucThuTuc.setMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
			linhVucThuTuc.setTenLinhVucThuTucHanhChinh(tenLinhVucThuTucHanhChinh);
			linhVucThuTuc.setMaLoaiThuTucHanhChinh(loaiLinhVucId);
			linhVucThuTuc.setCreatedate(date);
			if (null != user) {
				linhVucThuTuc.setCompanyid(user.getCompanyId());
				linhVucThuTuc.setUserid(userId);
			}
			
			if (active) {
				linhVucThuTuc.setActive(1);
			} else {
				linhVucThuTuc.setActive(0);
			}
			linhVucThuTuc.setDescription(description);
			
			LinhVucThuTucHanhChinhLocalServiceUtil.addLinhVucThuTucHanhChinh(linhVucThuTuc);
			
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
				
				return mapping.findForward("portlet.nss.linh_vuc_thu_tuc.view");
			}
	}

}
