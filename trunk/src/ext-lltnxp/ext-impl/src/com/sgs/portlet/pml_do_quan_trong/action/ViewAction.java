package com.sgs.portlet.pml_do_quan_trong.action;

import com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;
import com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongTenDoQuanTrongException;
import com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongCanNotDeleteException;
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.action.ActionUtil;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongServiceUtil;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil;

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
				updatePmlDoQuanTrong(actionRequest);
			}
			
			else if(cmd.equals(Constants.DELETE)){

				deletePmlDoQuanTrong(actionRequest);
			}	
			
			if (Validator.isNotNull(cmd)) {
				String pmlDoQuanTrongURL = ParamUtil.getString(
						actionRequest, "pmlDoQuanTrongURL");
				sendRedirect(actionRequest, actionResponse, pmlDoQuanTrongURL);
			}

		}
		catch (Exception e) {
			if (e instanceof NoSuchPmlDoQuanTrongException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_do_quan_trong.error");
			}
			else if (e instanceof PmlDoQuanTrongTenDoQuanTrongException) {

				actionRequest.setAttribute("PmlDoQuanTrongAUFlag", "fail");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof PmlDoQuanTrongCanNotDeleteException){
				SessionErrors.add(actionRequest,e.getClass().getName());
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
				ActionUtil.getPmlDoQuanTrong(renderRequest);
			}
		}
		catch (NoSuchPmlDoQuanTrongException nsex) {

			// Bo qua loi nay khi bat dau vao trang them moi
		}
		catch (Exception e) {
			throw e;
		}

		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		}
		else {
			return mapping.findForward("portlet.sgs.pml_do_quan_trong.view");
		}
	}

	protected PmlDoQuanTrong updatePmlDoQuanTrong(ActionRequest actionRequest)
	throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
	
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
	
		long idDoQuanTrong = ParamUtil.getLong(uploadRequest, "idDoQuanTrong");
		String tenDoQuanTrong = ParamUtil.getString(uploadRequest, "tenDoQuanTrong");
	
		PmlDoQuanTrong pmlDoQuanTrong = null;
	
		if (cmd.equals(Constants.ADD)) {
			// Add 
			pmlDoQuanTrong = PmlDoQuanTrongServiceUtil.addPmlDoQuanTrong(tenDoQuanTrong);
		}
		else {
			// Update 
			pmlDoQuanTrong = PmlDoQuanTrongServiceUtil.updatePmlDoQuanTrong(idDoQuanTrong, tenDoQuanTrong);
		}
	
		return pmlDoQuanTrong;
	}
	
	protected void deletePmlDoQuanTrong(ActionRequest actionRequest)
	throws Exception {

	String idDoQuanTrongList = actionRequest.getParameter("deletePmlDoQuanTrongIdDoQuanTrongs");
	// trong choi idDoQuanTrongList co chuoi "on," --> cat chuoi bo
	if (idDoQuanTrongList.length() > 3)
		idDoQuanTrongList = idDoQuanTrongList.substring(3);
	// truong hop chuoi rong
	if (idDoQuanTrongList.length()<3)

		idDoQuanTrongList = idDoQuanTrongList.replaceAll("on", "");
	/* 
	long[] idDoQuanTrongs = StringUtil.split(
			ParamUtil.getString(actionRequest, "deletePmlDoQuanTrongIdTinhChats"), 0L);
	*/
	if (!idDoQuanTrongList.equals("")){
		PmlDoQuanTrongLocalServiceUtil.removePmlDoQuanTrong(idDoQuanTrongList);
	}	
	
	// Click xoa bang img delete.png
	String idDoQuanTrong = ""; 
	
	idDoQuanTrong = actionRequest.getParameter("deletePmlDoQuanTrongIdDoQuanTrong");
	
	if (!idDoQuanTrong.equals("")){
		PmlDoQuanTrongLocalServiceUtil.removePmlDoQuanTrong(idDoQuanTrong);
	}
}
}