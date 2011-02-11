package com.sgs.portlet.pml_ho_so_cong_viec.action;

import com.sgs.portlet.pml_ho_so_cong_viec.action.ActionUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="ViewAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class ViewDetailAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		try {
			
			sendRedirect(actionRequest, actionResponse);
			if(cmd.equals(Constants.DELETE)){

				deletePmlChiTietHSCVDEN(actionRequest);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchPmlHoSoCongViecException || 
				e instanceof NoSuchPmlChiTietHSCVException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_ho_so_cong_viec.error");
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
		
		try {
				ActionUtil.getPmlHoSoCongViec(renderRequest);
	
		}
		catch (NoSuchPmlChiTietHSCVException nsex) {

			// Bo qua loi nay khi bat dau vao trang them moi
		}
		catch (Exception e) {
			throw e;
		}

		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		}
		else {
			return mapping.findForward("portlet.sgs.pml_ho_so_cong_viec.viewdetail");
		}
	}
	protected void deletePmlChiTietHSCVDEN(ActionRequest actionRequest)
	throws Exception {

		long idHoSoCongViec = ParamUtil.getLong(actionRequest, "idHoSoCongViec");
		String idCongVanDenStr = ParamUtil.getString(actionRequest, "hidCVDen");
		if (idCongVanDenStr != null && !idCongVanDenStr.equals("")){
			long idCongVanDen = Long.valueOf(idCongVanDenStr);
			if (idHoSoCongViec > 0 && idCongVanDen > 0){
				PmlChiTietHSCVLocalServiceUtil.removeChiTietHSCVCVDen(idHoSoCongViec, idCongVanDen);
			}
		}
		String idCongVanDiStr = ParamUtil.getString(actionRequest, "hidCVDi");
		if (idCongVanDiStr != null && !idCongVanDiStr.equals("")) {
			long idCongVanDi = Long.valueOf(idCongVanDiStr);
			if (idHoSoCongViec > 0 && idCongVanDi > 0){
				PmlChiTietHSCVLocalServiceUtil.removeChiTietHSCVCVDi(idHoSoCongViec, idCongVanDi);
			}
		}
	}
}