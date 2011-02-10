package com.sgs.portlet.citymanagement.action;

import java.util.ArrayList;
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
import com.sgs.portlet.districtmanagement.DistrictCanNotDeleteException;
import com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictUtil;

public class DistrictManagementAction extends PortletAction {
	// Yenlt update 05/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if (cmd.equals(Constants.ADD)) {
				addDistrict(req);
			}
			if (cmd.equals(Constants.UPDATE)) {
				updateDistrict(req);
			}
			if (cmd.equals(Constants.DELETE)) {
				 deleteDistrict(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String districtURL = ParamUtil.getString(req, "districtURL");
				sendRedirect(req, res, districtURL);
			}
		} catch (Exception e) {
			if (e instanceof DistrictCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof DistrictCodeSameCodeException) {
				req.setAttribute("districtFlag", "fail");
				req.setAttribute("updateFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	
	private void deleteDistrict(ActionRequest req, ActionResponse res) throws Exception {
		String districtId = ParamUtil.getString(req, "districtId");
		DistrictLocalServiceUtil.removeDistrict(districtId);
	}
	
	
	private District addDistrict(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String code = ParamUtil.getString(uploadRequest, "code");
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		String cityId = ParamUtil.getString(uploadRequest, "cityId");
		
		District district = DistrictLocalServiceUtil.addDistrict(code, name, cityId, description, "1");
		
		return district;
	}

	
	private District updateDistrict(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String districtId = ParamUtil.getString(uploadRequest, "districtId");
		String cityId = ParamUtil.getString(uploadRequest, "cityId");
		String code = ParamUtil.getString(uploadRequest, "districtCode"+districtId);
		String name = ParamUtil.getString(uploadRequest, "districtName"+districtId);
		String description = ParamUtil.getString(uploadRequest, "districtDescription"+districtId);
		
		District district = DistrictLocalServiceUtil.updateDistrict(districtId, code, name, cityId, description, "1");

		return district;
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		String cityId = ParamUtil.getString(req, "cityId");
		req.setAttribute("cityId", cityId);
//		City city = null;
//		try {
//			city = CityLocalServiceUtil.getCity(cityId);
//			req.setAttribute("city", city );
//		} catch (Exception e) {	}
		
		getDistrictList(req);
		
		return mapping.findForward("portlet.sgs.citymanagement.districtmanagement");
	}


	private void getDistrictList(RenderRequest req) throws Exception {
		List<District> results = new ArrayList<District>();
		String cityId = ParamUtil.getString(req, "cityId", "");
		if (!"".equals(cityId)) {
			results = DistrictUtil.findByCityID(cityId);
			City city = CityLocalServiceUtil.getCity(cityId);
			req.setAttribute("city", city);
		}
		req.setAttribute("districtList", results);
	}
}
