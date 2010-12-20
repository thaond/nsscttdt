package com.nss.portlet.van_ban_phap_quy_display.action;

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
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
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
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if (!Validator.isNull(cmd)) {
			if (cmd.equals("DETAIL")) {
				detailVanBanPhapQuy(req, res);
			}
		}
	}

	public void detailVanBanPhapQuy(ActionRequest req, ActionResponse res) {
		long maVanBanPhapQuy = ParamUtil.getLong(req, "maVanBanPhapQuy");
		VanBanPhapQuy vanBanPhapQuy = null;

		try {
			vanBanPhapQuy = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
		} catch (Exception e) {
			_log.error(e);
		}
		
		req.setAttribute("vanBanPhapQuy", vanBanPhapQuy);
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				List<LinhVucVanBan> linhVucVBList = new ArrayList<LinhVucVanBan>();
				List<LoaiVanBan> loaiVBList = new ArrayList<LoaiVanBan>();
				List<CoQuanBanHanh> coQuanBanHanhList = new ArrayList<CoQuanBanHanh>();
				
				coQuanBanHanhList = CoQuanBanHanhLocalServiceUtil.findByActive(1);
				loaiVBList = LoaiVanBanLocalServiceUtil.findByActive(1);
				linhVucVBList = LinhVucVanBanLocalServiceUtil.findByActive(1);
				
				req.setAttribute("coQuanBanHanhList", coQuanBanHanhList);
				req.setAttribute("loaiVBList", loaiVBList);
				req.setAttribute("linhVucVBList", linhVucVBList);
				return mapping.findForward("portlet.nss.van_ban_phap_quy_display.view");
			}
	}

}
