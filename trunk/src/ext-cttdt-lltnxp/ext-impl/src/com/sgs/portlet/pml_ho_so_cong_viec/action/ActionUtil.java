package com.sgs.portlet.pml_ho_so_cong_viec.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil;
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

	public static void getPmlHoSoCongViec(ActionRequest actionRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getPmlHoSoCongViec(request);
	}

	public static void getPmlHoSoCongViec(RenderRequest renderRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getPmlHoSoCongViec(request);
	}

	public static void getPmlHoSoCongViec(HttpServletRequest request) 
	throws Exception {
		long idHoSoCongViec = ParamUtil.getLong(request, "idHoSoCongViec");
		
		PmlHoSoCongViec pmlHoSoCongViec = null;

		if (Validator.isNotNull(idHoSoCongViec)) {
			pmlHoSoCongViec = PmlHoSoCongViecLocalServiceUtil.getPmlHoSoCongViec(idHoSoCongViec);
		}

		request.setAttribute(WebKeysExt.PMLHOSOCONGVIEC, pmlHoSoCongViec);
		request.setAttribute("idHoSoCongViec", idHoSoCongViec);
	}
}