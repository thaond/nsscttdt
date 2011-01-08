package com.sgs.portlet.pml_do_quan_trong.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil;
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

	public static void getPmlDoQuanTrong(ActionRequest actionRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getPmlDoQuanTrong(request);
	}

	public static void getPmlDoQuanTrong(RenderRequest renderRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getPmlDoQuanTrong(request);
	}

	public static void getPmlDoQuanTrong(HttpServletRequest request) 
	throws Exception {
		long idDoQuanTrong = ParamUtil.getLong(request, "idDoQuanTrong");
		

		PmlDoQuanTrong pmlDoQuanTrong = null;

		if (Validator.isNotNull(idDoQuanTrong)) {
			pmlDoQuanTrong = PmlDoQuanTrongLocalServiceUtil.getPmlDoQuanTrong(idDoQuanTrong);
		}

		request.setAttribute(WebKeysExt.PMLDOQUANTRONG, pmlDoQuanTrong);
	}
}