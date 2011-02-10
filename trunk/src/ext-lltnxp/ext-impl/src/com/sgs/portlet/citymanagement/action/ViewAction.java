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

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.citymanagement.CityCanNotDeleteException;
import com.sgs.portlet.citymanagement.CityCodeSameCodeException;
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.CityLocalServiceUtil;
import com.sgs.portlet.citymanagement.service.persistence.CityUtil;

public class ViewAction extends PortletAction {
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
				addCity(req);
			}
			if (cmd.equals(Constants.UPDATE)) {
				updateCity(req);
			}
			if (cmd.equals(Constants.DELETE)) {
				deleteCity(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String cityURL = ParamUtil.getString(req, "cityURL");
				sendRedirect(req, res, cityURL);
			}
		} catch (Exception e) {
			if (e instanceof CityCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof CityCodeSameCodeException) {
				req.setAttribute("cityFlag", "fail");
				req.setAttribute("updateFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	
	private void deleteCity(ActionRequest req, ActionResponse res) throws Exception {
		String cityId = ParamUtil.getString(req, "cityId");
		CityLocalServiceUtil.removeAgency(cityId);
	}
	
	
	private City addCity(ActionRequest req) throws Exception {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String code = ParamUtil.getString(uploadRequest, "code");
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		
		City city = CityLocalServiceUtil.addCity(code, name, description, "1", "DMQG09010000001");
		
		return city;
	}

	
	
	private City updateCity(ActionRequest req) throws Exception {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cityId = ParamUtil.getString(uploadRequest, "cityId");
		String code = ParamUtil.getString(uploadRequest, "districtCode"+cityId);
		String name = ParamUtil.getString(uploadRequest, "districtName"+cityId);
		String description = ParamUtil.getString(uploadRequest, "districtDescription"+cityId);
		
		City city = CityLocalServiceUtil.updateCity(cityId, code, name, description);

		return city;
	}


	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
				List<City> cityList = CityUtil.findAll();
				
				req.setAttribute("cityList", cityList);
				return mapping.findForward("portlet.sgs.citymanagement.view");
	}
	
}
