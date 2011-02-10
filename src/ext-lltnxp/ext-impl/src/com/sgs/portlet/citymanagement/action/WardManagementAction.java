package com.sgs.portlet.citymanagement.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.CityLocalServiceUtil;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil;
import com.sgs.portlet.wardsmanagement.WardCodeSameCodeException;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsUtil;

public class WardManagementAction extends PortletAction {
	// Yenlt update 05/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/* yenlt close start 05/04/2010
				addDistrict(req);
				yenlt close end */
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		
		try {
			if (cmd.equals(Constants.ADD)) {
				addDistrict(req);
			}
			if (cmd.equals(Constants.UPDATE)) {
				updateDistrict(req);
			}
			if (cmd.equals(Constants.DELETE)) {
				boolean delete = deleteWard(req, res);
				redirect +="&delete=".concat(String.valueOf(delete));
			}
			if (Validator.isNotNull(cmd)) {
				String wardURL = ParamUtil.getString(req, "wardURL");
				sendRedirect(req, res, wardURL);
			}
		} catch (Exception e) {
			if (e instanceof WardCodeSameCodeException) {
				String cityId = ParamUtil.getString(req, "cityId");
				req.setAttribute("cityId", cityId);
				
				req.setAttribute("wardFlag", "fail");
				req.setAttribute("updateFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	
	private boolean deleteWard(ActionRequest req, ActionResponse res) {
		String wardsId = ParamUtil.getString(req, "wardsId");
		Wards wards = null;
		try {
			wards = WardsLocalServiceUtil.getWards(wardsId);
			WardsLocalServiceUtil.deleteWards(wards);
			return true;
		} catch (PortalException e) {
			return false;
		} catch (SystemException e) {
			return false;
		}
		
	}
	
	
	private Wards addDistrict(ActionRequest req) throws PortalException, SystemException  {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String code = ParamUtil.getString(uploadRequest, "code");
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		String districtId = ParamUtil.getString(uploadRequest, "districtId");
		
		Wards ward = WardsLocalServiceUtil.addWard(code, name, districtId, description, "1");
		
		return ward;
		
	}
	
	
	private Wards updateDistrict(ActionRequest req) throws PortalException, SystemException {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String districtId = ParamUtil.getString(uploadRequest, "districtId");
		String wardId = ParamUtil.getString(uploadRequest, "wardsId");
		String code = ParamUtil.getString(uploadRequest, "districtCode"+wardId);
		String name = ParamUtil.getString(uploadRequest, "districtName"+wardId);
		String description = ParamUtil.getString(uploadRequest, "districtDescription"+wardId);
		
		Wards ward = WardsLocalServiceUtil.updateWard(wardId, code, name, districtId, description, "1");

		return ward;
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

		String cityId = ParamUtil.getString(req, "cityId");
		String districtId = ParamUtil.getString(req, "districtId");
		req.setAttribute("cityId", cityId);
		req.setAttribute("districtId", districtId);
//		City city = null;
//		District district = null;
//		try {
//			city = CityLocalServiceUtil.getCity(cityId);
//			district = DistrictLocalServiceUtil.getDistrict(districtId);
//			req.setAttribute("city", city);
//			req.setAttribute("district", district);
//		} catch (Exception e) {
//		}
		
		getDistrictList(req);
		return mapping.findForward("portlet.sgs.citymanagement.wardmanagement");
	}
	

	private void getDistrictList(RenderRequest req) throws Exception {
		String districtId = ParamUtil.getString(req, "districtId", "");
		District district = DistrictLocalServiceUtil.getDistrict(districtId);
		
		String cityId = district.getCityID();
		City city = CityLocalServiceUtil.getCity(cityId);
		
		List<Wards> wardsList = WardsUtil.findByDistrictId(districtId);
		
		req.setAttribute("wardsList", wardsList);
		req.setAttribute("district", district);
		req.setAttribute("city", city);
	}
}
