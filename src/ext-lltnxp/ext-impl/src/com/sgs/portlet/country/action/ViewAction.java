package com.sgs.portlet.country.action;

import java.rmi.RemoteException;
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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.persistence.CityUtil;
import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.model.impl.CountryImpl;
import com.sgs.portlet.country.service.CountryLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.service.persistence.NationUtil;

public class ViewAction extends PortletAction {

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/country/view");
		if (cmd.equals(Constants.DELETE)) {
			boolean delete = deleteCountry(req);
			redirect +="&delete=".concat(String.valueOf(delete));
		}
	}

	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		}
		else {
			String cmd = ParamUtil.getString(req, Constants.CMD);

			if (!Validator.isNull(cmd)) {
				if (cmd.equals(Constants.ADD)) {
					createCountry(req, res);
				}
				else if (cmd.equals(Constants.EDIT)) {
					editCountry(req, res);
				}
				else if (cmd.equals(Constants.UPDATE)) {
					updateCountry(req, res);
				}
				else if (cmd.equals(Constants.LOCK)) {
					updateActiveCountry(req, res);
				}
				else if (cmd.equals(Constants.CANCEL)) {
				}
			}
			
			return mapping.findForward("portlet.sgs.country.view");
		}
	}

	private void updateCountry(RenderRequest req, RenderResponse res) {

		String countryId = ParamUtil.getString(req, "countryId");
		String countryCode = ParamUtil.getString(req, "countryCode");
		String countryName = ParamUtil.getString(req, "countryName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");

		try {
			Country country = CountryLocalServiceUtil.getCountry(countryId);

			country.setCountryCode(countryCode);
			country.setCountryName(countryName);
			country.setDescription(description);
			if (active) {
				country.setActive("1");
			}
			else {
				country.setActive("0");
			}
			country = CountryLocalServiceUtil.updateCountry(country);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private boolean deleteCountry(ActionRequest req) {
		String countryId = ParamUtil.getString(req, "countryId");
		List<Nation> nationList = null;
		List<City> cityList = null;
		Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountry(countryId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			nationList = NationUtil.findByCountryId(countryId);
		}catch (Exception e) {}
		
		try {
			cityList = CityUtil.findByCountryId(countryId);
		} catch (Exception e) {}
		
		if ((nationList != null && !nationList.isEmpty()) || (cityList != null && !cityList.isEmpty()) ) {
			return false;
		}
		else {
			try {
				CountryLocalServiceUtil.deleteCountry(country);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	private void editCountry(RenderRequest req, RenderResponse res) {

		String countryId = ParamUtil.getString(req, "countryId");
		try {
			Country country = CountryLocalServiceUtil.getCountry(countryId);
			req.setAttribute("country", country);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private void createCountry(RenderRequest req, RenderResponse res) {

		String countryId = "";

		try {
			countryId = IdTemplateServiceUtil.generatedId(Country.class);
		}
		catch (NoSuchIdGeneratedException e1) {
			e1.printStackTrace();
		}
		catch (SystemException e1) {
			e1.printStackTrace();
		}
		catch (RemoteException e1) {
			e1.printStackTrace();
		}

		String countryCode = ParamUtil.getString(req, "countryCode");
		String countryName = ParamUtil.getString(req, "countryName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");

		Country country = new CountryImpl();
		country.setCountryId(countryId);
		country.setCountryCode(countryCode);
		country.setCountryName(countryName);
		country.setDescription(description);
		if (active) {
			country.setActive("1");
		}
		else {
			country.setActive("0");
		}

		try {
			country = CountryLocalServiceUtil.updateCountry(country);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private void updateActiveCountry(RenderRequest req, RenderResponse res) {

		String countryId = ParamUtil.getString(req, "countryId");
		if (Validator.isNotNull(countryId)) {

			try {
				Country country = CountryLocalServiceUtil.getCountry(countryId);
				if ("1".equals(country.getActive())) {
					country.setActive("0");
				}
				else {
					country.setActive("1");
				}

				country = CountryLocalServiceUtil.updateCountry(country);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

}
