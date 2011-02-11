package com.sgs.portlet.pml_trang_thai_hscv.action;

import com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil;
import com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;
import com.sgs.portlet.pml_trang_thai_hscv.PmlTrangThaiHSCVTenTrangThaiHSCVException;
import com.sgs.portlet.pml_trang_thai_hscv.PmlTrangThaiHSCVCanNotDeleteException;
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.action.ActionUtil;
import com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

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
public class ViewAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updatePmlTrangThaiHSCV(actionRequest);
			}

			else if(cmd.equals(Constants.DELETE)){

				deletepmlTrangThaiHSCV(actionRequest);
			}			
			
			if (Validator.isNotNull(cmd)) {
				String pmlTrangThaiURL = ParamUtil.getString(
						actionRequest, "pmlTrangThaiURL");
				sendRedirect(actionRequest, actionResponse, pmlTrangThaiURL);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchPmlTrangThaiHSCVException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_trang_thai_hscv.error");
			}
			
			else if (e instanceof PmlTrangThaiHSCVTenTrangThaiHSCVException) {

				actionRequest.setAttribute("PmlTrangThaiHSCVAUFlag", "fail");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			
			else if (e instanceof PmlTrangThaiHSCVCanNotDeleteException){
				SessionErrors.add(actionRequest, e.getClass().getName());
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

			// Case edit element
			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getPmlTrangThaiHSCV(renderRequest);
			}
		}
		catch (NoSuchPmlTrangThaiHSCVException nsex) {

			// Bo qua loi nay khi bat dau vao trang them moi
		}
		catch (Exception e) {
			throw e;
		}

		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		}
		else {
			return mapping.findForward("portlet.sgs.pml_trang_thai_hscv.view");
		}
	}

	protected PmlTrangThaiHSCV updatePmlTrangThaiHSCV(ActionRequest actionRequest)
	throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
	
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
	
		long idTrangThaiHSCV = ParamUtil.getLong(uploadRequest, "idTrangThaiHSCV");
		String tenTrangThaiHSCV = ParamUtil.getString(uploadRequest, "tenTrangThaiHSCV");
	
		PmlTrangThaiHSCV pmlTrangThaiHSCV = null;
	
		if (cmd.equals(Constants.ADD)) {
			// Add 
			pmlTrangThaiHSCV = PmlTrangThaiHSCVServiceUtil.addPmlTrangThaiHSCV(tenTrangThaiHSCV);
		}
		else {
			// Update
			pmlTrangThaiHSCV = PmlTrangThaiHSCVServiceUtil.updatePmlTrangThaiHSCV(idTrangThaiHSCV, tenTrangThaiHSCV);
		}
	
		return pmlTrangThaiHSCV;
	}
	
	protected void deletepmlTrangThaiHSCV(ActionRequest actionRequest)
	throws Exception {

	String idTrangThaiHSCVList = actionRequest.getParameter("deletePmlTrangThaiHSCVIdTrangThaiHSCVs");
	// trong choi idTrangThaiHSCVList co chuoi "on," --> cat chuoi bo
	if (idTrangThaiHSCVList.length() > 3)
		idTrangThaiHSCVList = idTrangThaiHSCVList.substring(3);
	// truong hop chuoi rong
	if (idTrangThaiHSCVList.length()<3)

		idTrangThaiHSCVList = idTrangThaiHSCVList.replaceAll("on", "");
	/* 
	long[] idTrangThaiHSCVs = StringUtil.split(
			ParamUtil.getString(actionRequest, "deletepmlTrangThaiHSCVIdTrangThaiHSCVs"), 0L);
	*/
	if (!idTrangThaiHSCVList.equals("")){
		PmlTrangThaiHSCVLocalServiceUtil.removePmlTrangThaiHSCV(idTrangThaiHSCVList);
	}	
	
	// Click xoa bang img delete.png
	String idTrangThaiHSCV = ""; 
	
	idTrangThaiHSCV = actionRequest.getParameter("deletePmlTrangThaiHSCVIdTrangThaiHSCV");
	
	if (!idTrangThaiHSCV.equals("")){
		PmlTrangThaiHSCVLocalServiceUtil.removePmlTrangThaiHSCV(idTrangThaiHSCV);
	}
}
}