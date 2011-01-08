package com.sgs.portlet.districtmanagement.action;

import java.util.ArrayList;

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
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.citymanagement.service.persistence.CityUtil;
import com.sgs.portlet.districtmanagement.DistrictCanNotDeleteException;
import com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException;
import com.sgs.portlet.districtmanagement.NoSuchDistrictException;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, "cmd");
		try {
			if(cmd.equals("add_process") || cmd.equals("edit_process")) {
				updateDistrict(req);
			}
			if(cmd.equals("delete")){
				delete(req);
			} else if(cmd.equals("active")) {
				updateActive( req);
			/*} else if(cmd.equals("add_process")) {
				addProcess(req, res);
			} else if(cmd.equals("edit_process")) {
				editProcess(req, res);*/
			}
			if (Validator.isNotNull(cmd)) {
				String districtURL = ParamUtil.getString(req, "districtURL");
				sendRedirect(req, res, districtURL);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchDistrictException ||
					e instanceof PrincipalException) {

				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.districtmanagement.error");
			}
			else if (e instanceof DistrictCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof DistrictCodeSameCodeException) {
				req.setAttribute("districtFlag", "fail");
				req.setAttribute("listCity", getListCity("1"));
				
				if (cmd.equals("add_process")) {
					setForward(req, "portlet.sgs.districtmanagement.add");
				}
				else if (cmd.equals("edit_process")) {
					setForward(req, "portlet.sgs.districtmanagement.edit");
				}
				
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		
	}
	
	private District updateDistrict(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		
		String districtId = ParamUtil.getString(uploadRequest, "districtId");
		String districtCode = ParamUtil.getString(req, "districtCode");
		String districtName = ParamUtil.getString(req, "districtName");
		String description = ParamUtil.getString(req, "description");
		String cityID = ParamUtil.getString(req, "cityID");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		District district = null;
		
		if (cmd.equals("add_process")) {
			if (active) {
				district = DistrictLocalServiceUtil.addDistrict(districtCode, districtName, cityID, description, "1");
			}
			else {
				district = DistrictLocalServiceUtil.addDistrict(districtCode, districtName, cityID, description, "0");
			}
		}
		else if (cmd.equals("edit_process")) {
			if (active) {
				district = DistrictLocalServiceUtil.updateDistrict(districtId, districtCode, districtName, cityID, description, "1");
			}
			else {
				district = DistrictLocalServiceUtil.updateDistrict(districtId, districtCode, districtName, cityID, description, "0");
			}
		}
		return district;
	}
	
	
	private ArrayList getListCity(String active) throws Exception {
		
		ArrayList listCity = (ArrayList) CityUtil.findByCityActive(active);
		return listCity;
	}
	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {				
			
			String cmd = ParamUtil.getString(req, "cmd");
			if(Validator.isNull(cmd) == false) {
				if(cmd.equals("edit")) {
					edit(req, res);
				}
			}
			req.setAttribute("listCity", getListCity("1"));
			
			return mapping.findForward("portlet.sgs.districtmanagement.view");
		}
	}

	
	// them quan vao csdl
	/*
	private void addProcess(ActionRequest req, ActionResponse res) throws Exception {
		try {
			// get form available
			String districtCode = ParamUtil.getString(req, "districtCode");
			String districtName = ParamUtil.getString(req, "districtName");
			String description = ParamUtil.getString(req, "description");
			String cityID = ParamUtil.getString(req, "cityID");
			boolean active = ParamUtil.getBoolean(req, "active");
			
			District district = new DistrictImpl();
			String districtId = IdTemplateServiceUtil.generatedId(District.class);
			district.setDistrictId(districtId);
			district.setDistrictCode(districtCode);
			district.setDistrictName(districtName);
			district.setCityID(cityID);
			district.setDescription(description);
			if (active) {
				district.setActive("1");
			} else {
				district.setActive("0");
			}
			
			DistrictLocalServiceUtil.addDistrict(district);
			
		} catch(Exception e) {
			
		}
	}*/
	
	
	//lay du lieu quan de bat dau cap nhat
	private void edit(RenderRequest req, RenderResponse res) throws Exception {
		String districtId = ParamUtil.getString(req, "districtId");
//		District district = null;
//		district = DistrictLocalServiceUtil.getDistrict(districtId);
//		req.setAttribute("listCity", getListCity("1"));
//		req.setAttribute("district", district);
		req.setAttribute("districtId", districtId);
	}
	
	
	//cap nhat lai quan trong csdl
	/*
	private void editProcess(ActionRequest req, ActionResponse res) throws Exception {
		String districtId = ParamUtil.getString(req, "districtId");
		String districtCode = ParamUtil.getString(req, "districtCode");
		String districtName = ParamUtil.getString(req, "districtName");
		String cityID = ParamUtil.getString(req, "cityID");
		String description = ParamUtil.getString(req, "description");
		boolean active = ParamUtil.getBoolean(req, "active");
		
		District district = null;
		try {
			district = DistrictUtil.findByPrimaryKey(districtId);
			
		} catch (Exception e) {
			
		}
		
		if (district != null  ) {
			district.setCityID(cityID);
			district.setDistrictCode(districtCode);
			district.setDistrictName(districtName);
			district.setDescription(description);
			if (active) {
				district.setActive("1");
			}
			else{
				district.setActive("0");
			}
			
			DistrictLocalServiceUtil.updateDistrict(district);
		}
	}*/
	
	
	//xoa quan ra khoi csdl neu khong co re buoc
	//yenlt 05/04/2010
	private void delete(ActionRequest req) throws Exception{
		String districtId = ParamUtil.getString(req, "districtId");
		DistrictLocalServiceUtil.removeDistrict(districtId);
	}
	
	private void updateActive(ActionRequest req) {
		String districtId = ParamUtil.getString(req, "districtId");

		try {
			District district = DistrictLocalServiceUtil.getDistrict(districtId);

			if ("1".equals(district.getActive())) {
				district.setActive("0");
			}
			else {
				district.setActive("1");
			}

			district = DistrictLocalServiceUtil.updateDistrict(district);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}
		
}
