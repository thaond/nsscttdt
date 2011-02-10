package com.sgs.portlet.nation.action;

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
import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.service.persistence.CountryUtil;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.model.impl.NationImpl;
import com.sgs.portlet.nation.service.NationLocalServiceUtil;

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
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/nation/view");
		if (cmd.equals(Constants.DELETE)) {
			boolean delete = deleteNation(req);
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
			List<Country> listCountry = CountryUtil.findAll();
			req.setAttribute("listCountry", listCountry);
			
			String cmd = ParamUtil.getString(req, Constants.CMD);

			if (!Validator.isNull(cmd)) {

				if (cmd.equals(Constants.ADD)) {
					createNation(req, res);
				}
				else if (cmd.equals(Constants.EDIT)) {					
					editNation(req, res);
				}
				else if (cmd.equals(Constants.UPDATE)) {
					updateNation(req, res);
				}
				else if (cmd.equals(Constants.LOCK)) {
					updateActiveNation(req, res);
				}
			}

			
			return mapping.findForward("portlet.sgs.nation.view");
		}
	}


	private void updateNation(RenderRequest req, RenderResponse res) {

		String nationId = ParamUtil.getString(req, "nationId");
		String nationCode = ParamUtil.getString(req, "nationCode");
		String nationName = ParamUtil.getString(req, "nationName");
		String countryId = ParamUtil.getString(req, "countryId");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");


		try {
			Nation nation = NationLocalServiceUtil.getNation(nationId);

			nation.setNationCode(nationCode);
			nation.setNationName(nationName);
			nation.setCountryId(countryId);
			nation.setDescription(description);
			
			if (active) {
				nation.setActive("1");
			}
			else {
				nation.setActive("0");
			}

			nation = NationLocalServiceUtil.updateNation(nation);

		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private boolean deleteNation(ActionRequest req) {

		String nationId = ParamUtil.getString(req, "nationId");
		try {
			Nation nation = NationLocalServiceUtil.getNation(nationId);
			NationLocalServiceUtil.deleteNation(nation);
			return true;
		}
		catch (PortalException e) {
			return false;
		}
		catch (SystemException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * cap nhat lai mot dan toc cu the
	 * @param req
	 * @param res
	 * Aug 18, 2009
	 * com.sgs.portlet.nation.action
	 *
	 */

	@SuppressWarnings("unchecked")
	private void editNation(RenderRequest req, RenderResponse res) {

		String nationId = ParamUtil.getString(req, "nationId");
		
		try {
			Nation nation = NationLocalServiceUtil.getNation(nationId);
			
			List<Country> countryList = (List<Country>) req.getAttribute("listCountry");
			
			Country country =  null;
			try {
				country =  CountryUtil.findByPrimaryKey(nation.getCountryId());
			} catch (Exception e) {}
			
			if (country != null) {
				countryList.remove(country);
				countryList.add(0, country);
				req.setAttribute("listCountry", countryList);
			}			
			
			req.setAttribute("nation", nation);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private void createNation(RenderRequest req, RenderResponse res) {

		try {
			String nationId="";
			try {
				nationId = IdTemplateServiceUtil.generatedId(Nation.class);
			}
			catch (NoSuchIdGeneratedException e) {
				e.printStackTrace();
			}
			catch (RemoteException e) {
				e.printStackTrace();
			}
			
			String nationCode = ParamUtil.getString(req, "nationCode");
			String nationName = ParamUtil.getString(req, "nationName");
			String countryId = ParamUtil.getString(req, "countryId");
			String description = ParamUtil.getString(req, "description");
			Boolean active = ParamUtil.getBoolean(req, "active");

			Nation nation = new NationImpl();
			nation.setNationId(nationId);
			nation.setNationCode(nationCode);
			nation.setNationName(nationName);
			nation.setCountryId(countryId);
			nation.setDescription(description);
			
			if (active) {
				nation.setActive("1");
			}
			else {
				nation.setActive("0");
			}

			nation = NationLocalServiceUtil.updateNation(nation);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private void updateActiveNation(RenderRequest req, RenderResponse res) {

		String nationId = ParamUtil.getString(req, "nationId");

		try {
			Nation nation = NationLocalServiceUtil.getNation(nationId);

			if ("1".equals(nation.getActive())) {
				nation.setActive("0");
			}
			else {
				nation.setActive("1");
			}

			nation = NationLocalServiceUtil.updateNation(nation);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

}
