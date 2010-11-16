package com.nss.portlet.loai_thu_tuc.action;

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
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil;
import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;
import com.nss.portlet.loai_thu_tuc.model.impl.LoaiThuTucHanhChinhImpl;
import com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/loai_thu_tuc/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addLoaiThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editLoaiThuTucHanhChinh(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLoaiThuTucHanhChinh(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateLoaiThuTucHanhChinh(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveLoaiThuTucHanhChinh(req, res);
			}
		}
	}
	
	public void updateLoaiThuTucHanhChinh(ActionRequest req) {
		long maLoaiThuTucHanhChinh = ParamUtil.getLong(req, "maLoaiThuTucHanhChinh");
		String tenLoaiThuTucHanhChinh = ParamUtil.getString(req, "tenLoaiThuTucHanhChinh");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
		Date date = new Date();
		try {
			loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.getLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
			loaiThuTucHanhChinh.setTenLoaiThuTucHanhChinh(tenLoaiThuTucHanhChinh);
			if (null != user) {
				loaiThuTucHanhChinh.setCompanyid(user.getCompanyId());
				loaiThuTucHanhChinh.setUserid(userId);
			}
			
			if (active) {
				loaiThuTucHanhChinh.setActive(1);
			} else {
				loaiThuTucHanhChinh.setActive(0);
			}
			loaiThuTucHanhChinh.setDescription(description);
			loaiThuTucHanhChinh.setModifieddate(date);
			
			LoaiThuTucHanhChinhLocalServiceUtil.updateLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void deleteLoaiThuTucHanhChinh(ActionRequest req) {
		long maLoaiThuTucHanhChinh = ParamUtil.getLong(req, "maLoaiThuTucHanhChinh");
		List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = new ArrayList<LinhVucThuTucHanhChinh>();
		try {
			linhVucThuTucHanhChinhList = LinhVucThuTucHanhChinhLocalServiceUtil.findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
		} catch (Exception e) {
			linhVucThuTucHanhChinhList = new ArrayList<LinhVucThuTucHanhChinh>();
		}
		
		try {
			if (linhVucThuTucHanhChinhList.size() > 0) {
				req.setAttribute("delete", false);
			}
			else {
				req.setAttribute("delete", true);
					LoaiThuTucHanhChinhLocalServiceUtil.deleteLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
	}

	public void editLoaiThuTucHanhChinh(ActionRequest req, ActionResponse res) {
		long maLoaiThuTucHanhChinh = ParamUtil.getLong(req, "maLoaiThuTucHanhChinh");
		LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
		
		try {
			loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.getLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
			req.setAttribute("loaiThuTucHanhChinh", loaiThuTucHanhChinh);
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void addLoaiThuTucHanhChinh(ActionRequest req) {
		String tenLoaiThuTucHanhChinh = ParamUtil.getString(req, "tenLoaiThuTucHanhChinh");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		
		long maLoaiThuTucHanhChinh = 0;
		LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maLoaiThuTucHanhChinh = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		try {
			loaiThuTucHanhChinh = new LoaiThuTucHanhChinhImpl();
			loaiThuTucHanhChinh.setMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
			loaiThuTucHanhChinh.setTenLoaiThuTucHanhChinh(tenLoaiThuTucHanhChinh);
			loaiThuTucHanhChinh.setCreatedate(date);
			if (null != user) {
				loaiThuTucHanhChinh.setCompanyid(user.getCompanyId());
				loaiThuTucHanhChinh.setUserid(userId);
			}
			
			if (active) {
				loaiThuTucHanhChinh.setActive(1);
			} else {
				loaiThuTucHanhChinh.setActive(0);
			}
			loaiThuTucHanhChinh.setDescription(description);
			
			LoaiThuTucHanhChinhLocalServiceUtil.addLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void updateActiveLoaiThuTucHanhChinh(ActionRequest req,
			ActionResponse res) {
		long maLoaiThuTucHanhChinh = ParamUtil.getLong(req, "maLoaiThuTucHanhChinh");
		LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
		Date date = new Date();
		try {
			loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.getLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
			if (loaiThuTucHanhChinh.getActive() == 1 ) {
				loaiThuTucHanhChinh.setActive(0);
				loaiThuTucHanhChinh.setModifieddate(date);
				loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.updateLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
			} else if (loaiThuTucHanhChinh.getActive() == 0) {
				loaiThuTucHanhChinh.setActive(1);
				loaiThuTucHanhChinh.setModifieddate(date);
				loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.updateLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
			}
			
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
				return mapping.findForward("portlet.nss.loai_thu_tuc.view");
			}
	}

}
