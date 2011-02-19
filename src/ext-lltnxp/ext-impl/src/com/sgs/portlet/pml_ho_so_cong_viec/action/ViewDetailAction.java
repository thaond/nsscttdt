package com.sgs.portlet.pml_ho_so_cong_viec.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

/**
 * <a href="ViewAction.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Hai Trieu
 * 
 */
public class ViewDetailAction extends PortletAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		try {

			sendRedirect(actionRequest, actionResponse);
			if (cmd.equals(Constants.DELETE)) {

				deletePmlChiTietHSCVDEN(actionRequest);
			}
		} catch (Exception e) {
			if ((e instanceof NoSuchPmlHoSoCongViecException)
					|| (e instanceof NoSuchPmlChiTietHSCVException)
					|| (e instanceof PrincipalException)) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest,
						"portlet.sgs.pml_ho_so_cong_viec.error");
			} else {
				throw e;
			}
		}
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {

		try {
			ActionUtil.getPmlHoSoCongViec(renderRequest);

		} catch (NoSuchPmlChiTietHSCVException nsex) {

			// Bo qua loi nay khi bat dau vao trang them moi
		} catch (Exception e) {
			throw e;
		}

		if ((getForward(renderRequest) != null)
				&& !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		} else {
			return mapping
					.findForward("portlet.sgs.pml_ho_so_cong_viec.viewdetail");
		}
	}

	protected void deletePmlChiTietHSCVDEN(ActionRequest actionRequest)
			throws Exception {

		long idHoSoCongViec = ParamUtil
				.getLong(actionRequest, "idHoSoCongViec");
		String deleteDocumentReceiptIds = ParamUtil.getString(actionRequest,
				"deleteDocumentReceiptIds");

		String[] documentReceiptIdStrs = StringUtil
				.split(deleteDocumentReceiptIds);

		for (String documentReceiptIdStr : documentReceiptIdStrs) {
			long documentReceiptId = Long.valueOf(documentReceiptIdStr);

			if ((idHoSoCongViec > 0) && (documentReceiptId > 0)) {
				PmlChiTietHSCVLocalServiceUtil.removeChiTietHSCVCVDen(
						idHoSoCongViec, documentReceiptId);
			}

		}

		String deleteDocumentSendIds = ParamUtil.getString(actionRequest,
				"deleteDocumentSendIds");

		String[] documentSendIdStrs = StringUtil.split(deleteDocumentSendIds);

		for (String documentSendIdStr : documentSendIdStrs) {
			long documentSendId = Long.valueOf(documentSendIdStr);

			if ((idHoSoCongViec > 0) && (documentSendId > 0)) {
				PmlChiTietHSCVLocalServiceUtil.removeChiTietHSCVCVDi(
						idHoSoCongViec, documentSendId);
			}
		}

	}
}