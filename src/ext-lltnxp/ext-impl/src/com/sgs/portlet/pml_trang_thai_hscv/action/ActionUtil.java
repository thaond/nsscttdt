package com.sgs.portlet.pml_trang_thai_hscv.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil;
import com.ext.portal.util.WebKeysExt;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * <a href="ActionUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class ActionUtil {

	public static void getPmlTrangThaiHSCV(ActionRequest actionRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getPmlTrangThaiHSCV(request);
	}

	public static void getPmlTrangThaiHSCV(RenderRequest renderRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getPmlTrangThaiHSCV(request);
	}

	public static void getPmlTrangThaiHSCV(HttpServletRequest request) 
	throws Exception {
		long idTrangThaiHSCV = ParamUtil.getLong(request, "idTrangThaiHSCV");
		

		PmlTrangThaiHSCV pmlTrangThaiHSCV = null;

		if (Validator.isNotNull(idTrangThaiHSCV)) {
			pmlTrangThaiHSCV = PmlTrangThaiHSCVLocalServiceUtil.getPmlTrangThaiHSCV(idTrangThaiHSCV);
		}

		request.setAttribute(WebKeysExt.PMLTRANGTHAIHSCV, pmlTrangThaiHSCV);
	}
}