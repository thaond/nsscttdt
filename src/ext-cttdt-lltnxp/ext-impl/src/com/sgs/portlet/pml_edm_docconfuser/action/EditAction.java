package com.sgs.portlet.pml_edm_docconfuser.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;
import com.sgs.portlet.pml_edm_docconfuser.PmlEdmDocConfUserUserIdException;
import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil;

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
				updatePmlEdmDocConfUser(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deletePmlEdmDocConfUser(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchDocConfUserException || 
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_edm_docconfuser.error");
			}
			else if (e instanceof PmlEdmDocConfUserUserIdException) {

				// Truong hop hieu chinh hoac them moi
				actionRequest.setAttribute("PmlEdmDocConfUserAUFlag", "fail");
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

			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getPmlEdmDocConfUser(renderRequest);
			}
		}
		catch (NoSuchDocConfUserException nsex) {
			// Do nothing
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.sgs.pml_edm_docconfuser.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(
			getForward(renderRequest, "portlet.sgs.pml_edm_docconfuser.edit"));
	}

	/**
	 * Add or edit item information
	 * @param actionRequest
	 * @return Document configuration for user
	 * @throws Exception
	 */
	protected PmlEdmDocConfUser updatePmlEdmDocConfUser(
			ActionRequest actionRequest)
		throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);

		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		// Get parameter
		long dcuId = ParamUtil.getLong(uploadRequest, "dcuId", 0);
		long userId = ParamUtil.getLong(uploadRequest, "userId", 0);
		boolean viewAllDoc = ParamUtil.getBoolean(uploadRequest, "viewAllDoc");
		String viewDepDoc = ParamUtil.getString(uploadRequest, "viewDepDoc");
		
		PmlEdmDocConfUser pmlEdmDocConfUser = null;

		if (cmd.equals(Constants.ADD)) {
			// Add new item
			pmlEdmDocConfUser = PmlEdmDocConfUserLocalServiceUtil.addPmlEdmDocConfUser(
					userId, viewAllDoc, viewDepDoc); 
		}
		else {
			// Update existing item
			pmlEdmDocConfUser = PmlEdmDocConfUserLocalServiceUtil.updatePmlEdmDocConfUser(
					dcuId, userId, viewAllDoc, viewDepDoc);
		}
		return pmlEdmDocConfUser;
	}
	
	/**
	 * Delete document configuration for user
	 * @param actionRequest
	 * @throws Exception
	 */
	protected void deletePmlEdmDocConfUser(
			ActionRequest actionRequest) 
	throws Exception {
		
		long delDCUId = ParamUtil.getLong(actionRequest, "delDCUId", 0);
		PmlEdmDocConfUserLocalServiceUtil.deletePmlEdmDocConfUser(delDCUId);
	}
}