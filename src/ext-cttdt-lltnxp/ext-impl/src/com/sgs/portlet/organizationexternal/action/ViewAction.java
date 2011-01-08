package com.sgs.portlet.organizationexternal.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.organizationexternal.OrganizationExternalCodeSameCodeException;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
							PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		try {
			if (Validator.isNotNull(cmd)) {
				if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
					updateOrganizationExternal(req, res);
				}
				else if (cmd.equals(Constants.DELETE)) {
					boolean delete = deleteOrganizationExternal(req);
					redirect += "&delete=".concat(String.valueOf(delete));
				}
			}
		} catch (Exception e) {
			if (e instanceof OrganizationExternalCodeSameCodeException) {
				req.setAttribute("orgExternalFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.organizationexternal.add");
			}
			else {
				throw e;
			}
		}
	}

	private boolean deleteOrganizationExternal(ActionRequest req) {
		long orgExternalId = ParamUtil.getLong(req, "orgExternalId");
		OrganizationExternal orgExternal = null;
		try {
			orgExternal = OrganizationExternalLocalServiceUtil.getOrganizationExternal(orgExternalId);
			OrganizationExternalLocalServiceUtil.deleteOrganizationExternal(orgExternal);
			return true;
		} catch (Exception e) {
			_log.warn(e);
			return false;
		}
	}

	private OrganizationExternal updateOrganizationExternal(ActionRequest req, ActionResponse res) throws SystemException, PortalException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		
		long orgExternalId = ParamUtil.getLong(uploadRequest, "orgExternalId");
		String orgExternalCode = ParamUtil.getString(uploadRequest, "orgExternalCode");
		String orgExternalName = ParamUtil.getString(uploadRequest, "orgExternalName");
		boolean isOwnerOrg = ParamUtil.getBoolean(uploadRequest, "isOwnerOrg");
		
		OrganizationExternal orgExternal = null;
		
		if (cmd.equals(Constants.ADD)) {
			if (isOwnerOrg) {
				orgExternal = OrganizationExternalLocalServiceUtil.addOrganizationExternal(orgExternalCode, orgExternalName, true);
			}
			else {
				orgExternal = OrganizationExternalLocalServiceUtil.addOrganizationExternal(orgExternalCode, orgExternalName, false);
			}
		}
		else if (cmd.equals(Constants.UPDATE)) {
			orgExternal = OrganizationExternalLocalServiceUtil.updateOrganizationExternal(orgExternalId, orgExternalCode, orgExternalName, isOwnerOrg);
		}
		
		return orgExternal;
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.organizationexternal.view");
			}
	}

}
