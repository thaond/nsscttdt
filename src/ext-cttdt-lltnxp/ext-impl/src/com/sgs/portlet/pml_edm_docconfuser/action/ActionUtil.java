package com.sgs.portlet.pml_edm_docconfuser.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil;
import com.ext.portal.util.WebKeysExt;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * <a href="ActionUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class ActionUtil {

	public static void getPmlEdmDocConfUser(ActionRequest actionRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getPmlEdmDocConfUser(request);
	}

	public static void getPmlEdmDocConfUser(RenderRequest renderRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getPmlEdmDocConfUser(request);
	}

	public static void getPmlEdmDocConfUser(
			HttpServletRequest request) 
	throws Exception {
		long dcuId = ParamUtil.getLong(request, "dcuId");
		
		PmlEdmDocConfUser pmlEdmDocConfUser = null;

		if (Validator.isNotNull(dcuId)) {
			pmlEdmDocConfUser = PmlEdmDocConfUserLocalServiceUtil.getPmlEdmDocConfUser(dcuId);
		}

		request.setAttribute(WebKeysExt.PMLEDMDOCCONFUSER, pmlEdmDocConfUser);
	}
}