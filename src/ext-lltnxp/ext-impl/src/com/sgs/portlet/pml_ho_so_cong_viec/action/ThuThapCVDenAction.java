package com.sgs.portlet.pml_ho_so_cong_viec.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

public class ThuThapCVDenAction extends PortletAction {
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect");

		long idHoSoCongViec = ParamUtil.getLong(req, "idHoSoCongViec");

		String documentReceiptIds = ParamUtil.getString(req,
				"documentReceiptIds");

		String[] documentReceiptIdStrs = StringUtil.split(documentReceiptIds);
		PmlChiTietHSCV chiTietHSCV = null;
		for (String documentReceiptIdStr : documentReceiptIdStrs) {
			long documentReceiptId = Long.valueOf(documentReceiptIdStr);

			chiTietHSCV = PmlChiTietHSCVLocalServiceUtil.findBy_IdHSCV_CVDen(
					idHoSoCongViec, documentReceiptId);

			if (Validator.isNull(chiTietHSCV)) {
				long chiTietHSCVId = CounterLocalServiceUtil
						.increment(PmlChiTietHSCV.class.getName());

				chiTietHSCV = PmlChiTietHSCVLocalServiceUtil
						.createPmlChiTietHSCV(chiTietHSCVId);

				chiTietHSCV.setIdHoSoCongViec(idHoSoCongViec);
				chiTietHSCV.setIdCongVanDen(documentReceiptId);

				PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(chiTietHSCV);
			}
		}

		res.sendRedirect(redirect);
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if ((getForward(req) != null) && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		} else {
			return mapping
					.findForward("portlet.sgs.pml_ho_so_cong_viec.thu_thap_cvden");
		}
	}
}
