package com.nss.portlet.nss_don_vi_thu_tuc.action;

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
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucImpl;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil;
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
		String redirect = ParamUtil.getString(req, "redirect", "/nss/nss_don_vi_thu_tuc/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {

			if (cmd.equals(Constants.ADD)) {
				addDonViThuTuc(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.EDIT)) {
				editDonViThuTuc(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteDonViThuTuc(req);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateDonViThuTuc(req);
				sendRedirect(req, res, redirect);
			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveDonViThuTuc(req, res);
			}
		}
	}
	
	private void updateActiveDonViThuTuc(ActionRequest req, ActionResponse res) {
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		DonViThuTuc donViThuTuc = null;
		Date date = new Date();
		try {
			donViThuTuc = DonViThuTucLocalServiceUtil.getDonViThuTuc(maDonViThuTuc);
			if (donViThuTuc.getActive() == 1 ) {
				donViThuTuc.setActive(0);
				donViThuTuc.setModifieddate(date);
				donViThuTuc = DonViThuTucLocalServiceUtil.updateDonViThuTuc(donViThuTuc);
			} else if (donViThuTuc.getActive() == 0) {
				donViThuTuc.setActive(1);
				donViThuTuc.setModifieddate(date);
				donViThuTuc = DonViThuTucLocalServiceUtil.updateDonViThuTuc(donViThuTuc);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	private void updateDonViThuTuc(ActionRequest req) {
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		String tenDonViThuTuc = ParamUtil.getString(req, "tenDonViThuTuc");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		int capDonVi = ParamUtil.getInteger(req, "capDonVi");
		
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		DonViThuTuc donViThuTuc = null;
		Date date = new Date();
		try {
			donViThuTuc = DonViThuTucLocalServiceUtil.getDonViThuTuc(maDonViThuTuc);
			donViThuTuc.setTenDonViThuTuc(tenDonViThuTuc);
			donViThuTuc.setCapDonVi(capDonVi);
			if (null != user) {
				donViThuTuc.setCompanyid(user.getCompanyId());
				donViThuTuc.setUserid(userId);
			}
			
			if (active) {
				donViThuTuc.setActive(1);
			} else {
				donViThuTuc.setActive(0);
			}
			donViThuTuc.setDescription(description);
			donViThuTuc.setModifieddate(date);
			
			DonViThuTucLocalServiceUtil.updateDonViThuTuc(donViThuTuc);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void deleteDonViThuTuc(ActionRequest req) {
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		
		List<ThuTucHanhChinh> thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		try {
			thuTucHanhChinhList = ThuTucHanhChinhLocalServiceUtil.findByMaDonViThuTuc(maDonViThuTuc);
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
				DonViThuTucLocalServiceUtil.deleteDonViThuTuc(maDonViThuTuc);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void editDonViThuTuc(ActionRequest req, ActionResponse res) {
		long maDonViThuTuc = ParamUtil.getLong(req, "maDonViThuTuc");
		DonViThuTuc donViThuTuc = null;
		
		try {
			donViThuTuc = DonViThuTucLocalServiceUtil.getDonViThuTuc(maDonViThuTuc);
			req.setAttribute("donViThuTuc", donViThuTuc);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void addDonViThuTuc(ActionRequest req) {
		String tenDonViThuTuc = ParamUtil.getString(req, "tenDonViThuTuc");
		boolean active = ParamUtil.getBoolean(req, "active");
		String description = ParamUtil.getString(req, "description");
		int capDonVi = ParamUtil.getInteger(req, "capDonVi");
		
		long maDonViThuTuc = 0;
		DonViThuTuc donViThuTuc = null;
		Date date = new Date();
		long userId = PortalUtil.getUserId(req);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e1) {
			_log.error(e1);
		}
		
		try {
			maDonViThuTuc = CounterLocalServiceUtil.increment();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		try {
			donViThuTuc = new DonViThuTucImpl();
			donViThuTuc.setMaDonViThuTuc(maDonViThuTuc);
			donViThuTuc.setTenDonViThuTuc(tenDonViThuTuc);
			donViThuTuc.setCapDonVi(capDonVi);
			donViThuTuc.setCreatedate(date);
			if (null != user) {
				donViThuTuc.setCompanyid(user.getCompanyId());
				donViThuTuc.setUserid(userId);
			}
			
			if (active) {
				donViThuTuc.setActive(1);
			} else {
				donViThuTuc.setActive(0);
			}
			donViThuTuc.setDescription(description);
			
			DonViThuTucLocalServiceUtil.addDonViThuTuc(donViThuTuc);
			
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
				
				return mapping.findForward("portlet.nss.nss_don_vi_thu_tuc.view");
			}
	}

}
