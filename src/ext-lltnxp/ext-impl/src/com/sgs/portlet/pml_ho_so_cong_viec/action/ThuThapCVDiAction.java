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

public class ThuThapCVDiAction extends PortletAction {
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect");

		long idHoSoCongViec = ParamUtil.getLong(req, "idHoSoCongViec");

		String documentSendIds = ParamUtil.getString(req, "documentSendIds");

		String[] documentSendIdStrs = StringUtil.split(documentSendIds);
		PmlChiTietHSCV chiTietHSCV = null;
		for (String documentSendIdStr : documentSendIdStrs) {
			long documentSendId = Long.valueOf(documentSendIdStr);

			chiTietHSCV = PmlChiTietHSCVLocalServiceUtil.findBy_IdHSCV_CVDi(
					idHoSoCongViec, documentSendId);

			if (Validator.isNull(chiTietHSCV)) {
				long chiTietHSCVId = CounterLocalServiceUtil
						.increment(PmlChiTietHSCV.class.getName());

				chiTietHSCV = PmlChiTietHSCVLocalServiceUtil
						.createPmlChiTietHSCV(chiTietHSCVId);

				chiTietHSCV.setIdHoSoCongViec(idHoSoCongViec);
				chiTietHSCV.setIdCongVanDi(documentSendId);

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
					.findForward("portlet.sgs.pml_ho_so_cong_viec.thu_thap_cvdi");
		}
	}
}
