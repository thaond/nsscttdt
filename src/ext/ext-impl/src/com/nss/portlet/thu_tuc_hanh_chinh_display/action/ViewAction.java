package com.nss.portlet.thu_tuc_hanh_chinh_display.action;

import java.util.ArrayList;
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

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
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
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if (cmd.equals("DETAIL")) {
				detailThuTucHanhChinh(req);
			}
		}
	}

	public void detailThuTucHanhChinh(ActionRequest req) {
		long maThuTucHanhChinh = ParamUtil.getLong(req, "maThuTucHanhChinh");
		ThuTucHanhChinh thuTucHanhChinh = null;
		try {
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(maThuTucHanhChinh);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		req.setAttribute("thuTucHanhChinh", thuTucHanhChinh);
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = new ArrayList<LinhVucThuTucHanhChinh>();
				linhVucThuTucHanhChinhList = LinhVucThuTucHanhChinhLocalServiceUtil.findByActive(1);

				List<DonViThuTuc> capThanhPhoList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(1, 1);
				List<DonViThuTuc> capQuanHuyenList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(2, 1);
				List<DonViThuTuc> capPhuongXaList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(3, 1);
				
				req.setAttribute("linhVucThuTucHanhChinhList", linhVucThuTucHanhChinhList);
				req.setAttribute("capThanhPhoList", capThanhPhoList);
				req.setAttribute("capQuanHuyenList", capQuanHuyenList);
				req.setAttribute("capPhuongXaList", capPhuongXaList);
				return mapping.findForward("portlet.nss.thu_tuc_hanh_chinh_display.view");
			}
	}

}
