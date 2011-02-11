package com.sgs.portlet.wardsmanagement.action;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.wardsmanagement.form.WardsForm;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.model.impl.WardsImpl;
import com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsUtil;

public class ViewAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/wardsmanagement/view");
		String cmd = ParamUtil.getString(req, "cmd");
		if ("delete".equals(cmd)) {
			boolean delete = delete(req);
			redirect +="&delete=".concat(String.valueOf(delete));
		}
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				
				String cmd = ParamUtil.getString(req, "cmd");
				String errorMessage = "";

				if(Validator.isNull(cmd) == false) {
					if(cmd.equals("add")) {
						req.setAttribute("listDistrict", getListDistrict("1"));
					}
					else if(cmd.equals("add_process")) {
						addProcess(form, req, res);
					}
					else if(cmd.equals("edit")) {
						edit(form, req, res);
					}
					else if(cmd.equals("edit_process")) {
						editProcess(form, req, res, errorMessage);
					}
					else if(cmd.equals("active")) {
						updateActive(form, req, res);
					}
				}
				
				return mapping.findForward("portlet.sgs.wardsmanagement.view");
			}
	}

	private void updateActive(ActionForm form, RenderRequest req,
			RenderResponse res) {
		String wardsId = ParamUtil.getString(req, "wardsId");

		try {
			Wards wards = WardsLocalServiceUtil.getWards(wardsId);

			if ("1".equals(wards.getActive())) {
				wards.setActive("0");
			}
			else {
				wards.setActive("1");
			}

			wards = WardsLocalServiceUtil.updateWards(wards);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @param active
	 * 
	 * Ham lay danh sach quan/huyen theo tham so active (0, 1)
	 * 
	 * @return ArrayList
	 *
	 */
	
	private List<District> getListDistrict(String active) {
		
		List<District> listDistrict = new ArrayList<District>();
		try {
			listDistrict = DistrictUtil.findByDistrictActive(active);
		} catch (Exception e) {
			listDistrict = new ArrayList<District>();
		}
		return listDistrict;
	}
	
	private void addProcess(ActionForm form, RenderRequest req, RenderResponse res) throws Exception {
		
		try {
			
			// get form available
			WardsForm wardsForm = (WardsForm) form;
			
			Wards wards = new WardsImpl();
			String wardsId = IdTemplateServiceUtil.generatedId(Wards.class);
			wards.setWardsId(wardsId);
			wards.setWardsCode(wardsForm.getWardsCode());
			wards.setWardsName(wardsForm.getWardsName());
			wards.setDistrictId(wardsForm.getDistrictId());
			wards.setDescription(wardsForm.getDescription());
			wards.setActive(wardsForm.getActive() + "");
			
			WardsLocalServiceUtil.addWards(wards);
		} catch(Exception e) {
			
		}
	}
	
	private void edit(ActionForm form, RenderRequest req, RenderResponse res) throws Exception {
		
		try {
			
			String wardsId = ParamUtil.getString(req, "wardsId");
			
			WardsForm wardsForm = (WardsForm) form;
			Wards wards = WardsLocalServiceUtil.getWards(wardsId);
			
			wardsForm.setWardsId(wardsId);
			wardsForm.setWardsCode(wards.getWardsCode());
			wardsForm.setWardsName(wards.getWardsName());
			wardsForm.setDistrictId(wards.getDistrictId());
			wardsForm.setDescription(wards.getDescription());
			wardsForm.setActive(Integer.parseInt(wards.getActive()));
			
			req.setAttribute("listDistrict", getListDistrict("1"));
			req.setAttribute("wardsForm", wardsForm);
		} catch(Exception e) {
			
		}
	}
	
	private void editProcess(ActionForm form, RenderRequest req, RenderResponse res, String errorMessage) throws Exception {
		
		String wardsId = ParamUtil.getString(req,"wardsId");
		String wardsCode = ParamUtil.getString(req,"wardsCode");
		String wardsName = ParamUtil.getString(req,"wardsName");
		String districtId = ParamUtil.getString(req,"districtId");
		String description = ParamUtil.getString(req,"description");
		boolean active = ParamUtil.getBoolean(req,"active");
		
		Wards wards = null;
		try {
			wards = WardsUtil.findByPrimaryKey(wardsId);
		} catch (Exception e) {
			
		}
		
		if (wards != null) {
			wards.setDescription(description);
			wards.setDistrictId(districtId);
			wards.setWardsCode(wardsCode);
			wards.setWardsName(wardsName);
			if (active) {
				wards.setActive("1");
			}
			else {
				wards.setActive("0");
			}
			WardsLocalServiceUtil.updateWards(wards);
		}
	}
	
	@SuppressWarnings("unused")
	private boolean delete( ActionRequest req){
		boolean flag = true;
		
		String wardsId = ParamUtil.getString(req, "wardsId");
		Wards wards = null;
		District district = null;
		
		try {
			wards = WardsLocalServiceUtil.getWards(wardsId);
			district = DistrictUtil.findByPrimaryKey(wards.getDistrictId());
			WardsLocalServiceUtil.deleteWards(wardsId);
			flag = true;
		} catch (PortalException e1) {
			flag =  false;
		} catch (SystemException e1) {
			flag = false;
		}
		
		return flag;
		
	}
	
}
