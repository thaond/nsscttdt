package com.sgs.portlet.pml_ho_so_cong_viec.action;

import java.util.List;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecHanXuLyException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecNgayMoHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecReferenceException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecSoHieuHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecTieuDeException;
import com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecUserIdException;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="EditAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class EditAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updatePmlHoSoCongViec(actionRequest); 
			}
			else if (cmd.equals(Constants.DELETE)) {
				deletePmlHoSoCongViecs(actionRequest);
			}
			else if (cmd.equals(Constants.EXPIRE)) {
				expirePmlHoSoCongViecs(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchPmlHoSoCongViecException || 
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_ho_so_cong_viec.error");
			}
			else if (e instanceof PmlHoSoCongViecSoHieuHSCVException ||
					 e instanceof PmlHoSoCongViecTieuDeException ||
					 e instanceof PmlHoSoCongViecNgayMoHSCVException ||
					 e instanceof PmlHoSoCongViecHanXuLyException || 
					 e instanceof PmlHoSoCongViecUserIdException) {

				// Truong hop hieu chinh hoac them moi
				actionRequest.setAttribute("PmlHoSoCongViecAUFlag", "fail");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof PmlHoSoCongViecReferenceException) {
				// Truong hop xoa
				SessionErrors.add(actionRequest, e.getClass().getName());
				setForward(actionRequest, "portlet.sgs.pml_ho_so_cong_viec.view");
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
			String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getPmlHoSoCongViec(renderRequest);
			}
		}
		catch (NoSuchPmlHoSoCongViecException nsex) {
			// Do nothing
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.sgs.pml_ho_so_cong_viec.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(
			getForward(renderRequest, "portlet.sgs.pml_ho_so_cong_viec.edit"));
	}

	protected PmlHoSoCongViec updatePmlHoSoCongViec(ActionRequest actionRequest)
		throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);

		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		// Get parameter
		long userId = ParamUtil.getLong(uploadRequest, "userId", 0);
		long idHoSoCongViec = ParamUtil.getLong(uploadRequest, "idHoSoCongViec", 0);
		long idHSCVCha = ParamUtil.getLong(uploadRequest, "idHSCVCha", 0);
		String soHieuHSCV = ParamUtil.getString(uploadRequest, "soHieuHSCV");
		String tieuDe = ParamUtil.getString(uploadRequest, "tieuDe");
		// Part of date
		int ngayMoHSCVMonth = ParamUtil.getInteger(uploadRequest, "ngayMoHSCVMonth");
		int ngayMoHSCVDay = ParamUtil.getInteger(uploadRequest, "ngayMoHSCVDay");
		int ngayMoHSCVYear = ParamUtil.getInteger(uploadRequest, "ngayMoHSCVYear");
		int hanXuLyMonth = ParamUtil.getInteger(uploadRequest, "hanXuLyMonth");
		int hanXuLyDay = ParamUtil.getInteger(uploadRequest, "hanXuLyDay");
		int hanXuLyYear = ParamUtil.getInteger(uploadRequest, "hanXuLyYear");
		
		String idLinhVuc = ParamUtil.getString(uploadRequest, "idLinhVuc");
		String vanDeLienQuan = ParamUtil.getString(uploadRequest, "vanDeLienQuan");
		long idDoQuanTrong = ParamUtil.getLong(uploadRequest, "idDoQuanTrong", 0);
		long idTinhChat = ParamUtil.getLong(uploadRequest, "idTinhChat", 0);
		long idTrangThaiHSCV = ParamUtil.getLong(uploadRequest, "idTrangThaiHSCV");
		String tomTatNoiDung = ParamUtil.getString(uploadRequest, "tomTatNoiDung");
		String hoatDong = ParamUtil.getString(uploadRequest, "hoatDong");
		
		PmlHoSoCongViec pmlHoSoCongViec = null;

		if (cmd.equals(Constants.ADD)) {
			// Add new item

			pmlHoSoCongViec = PmlHoSoCongViecLocalServiceUtil.addPmlHoSoCongViec(
					userId, idHSCVCha, soHieuHSCV, tieuDe, ngayMoHSCVMonth, ngayMoHSCVDay, 
					ngayMoHSCVYear, hanXuLyMonth, hanXuLyDay, hanXuLyYear, idLinhVuc,
					vanDeLienQuan, idDoQuanTrong, idTinhChat, idTrangThaiHSCV, 
					tomTatNoiDung, hoatDong);
		}
		else {
			// Update existing item

			pmlHoSoCongViec = PmlHoSoCongViecLocalServiceUtil.updatePmlHoSoCongViec (
					idHoSoCongViec, userId, idHSCVCha, soHieuHSCV, tieuDe, ngayMoHSCVMonth,
					ngayMoHSCVDay, ngayMoHSCVYear, hanXuLyMonth, hanXuLyDay,
					hanXuLyYear, idLinhVuc, vanDeLienQuan, idDoQuanTrong, idTinhChat, 
					idTrangThaiHSCV, tomTatNoiDung, hoatDong);
		}
		return pmlHoSoCongViec;
	}
	
	protected void deletePmlHoSoCongViecs(ActionRequest actionRequest) 
	throws Exception {
		
		long deleteHSCVId = ParamUtil.getLong(actionRequest, "deleteHSCVId", 0);
		PmlHoSoCongViecLocalServiceUtil.deletePmlHoSoCongViec(deleteHSCVId);
	}
	
	protected void expirePmlHoSoCongViecs(ActionRequest actionRequest) 
	throws Exception {
		
		long expireHSCVId = ParamUtil.getLong(actionRequest, "expireHSCVId", 0);
		PmlHoSoCongViecLocalServiceUtil.expirePmlHoSoCongViec(expireHSCVId);
	}
}