package com.sgs.portlet.departmentleader.action;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.PmlDepartmentHSCV;
import com.sgs.portlet.department.model.impl.PmlDepartmentHSCVImpl;
import com.sgs.portlet.department.service.PmlDepartmentHSCVLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;

public class AssignDepartmentHSCV extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		
		if (Validator.isNotNull(cmd)&& cmd.equals(Constants.ADD)) {
			String departmentId = ParamUtil.getString(req, "departmentId");
			List<PmlDepartmentHSCV> pmlDepartmentHSCVList = new ArrayList<PmlDepartmentHSCV>();
			try {
				pmlDepartmentHSCVList = PmlDepartmentHSCVUtil.findByDepartmentsId(departmentId);
				
			} catch (Exception e) {
				
			}
			
			for (PmlDepartmentHSCV pmlDepartmentHSCV : pmlDepartmentHSCVList) {
				try {
					PmlDepartmentHSCVLocalServiceUtil.deletePmlDepartmentHSCV(pmlDepartmentHSCV);
				} catch (Exception e) {
					
				}
			}
			
			long[] idHSCV = ParamUtil.getLongValues(req, "HSCV");
			
			if (Validator.isNotNull(idHSCV)) {
				PmlDepartmentHSCV pmlDepartmentHSCV = null;
				for (int i = 0; i < idHSCV.length; i++) {					
					try {
						pmlDepartmentHSCV = new PmlDepartmentHSCVImpl();
						pmlDepartmentHSCV.setPmlDepartmentHSCVId(CounterLocalServiceUtil.increment());
						pmlDepartmentHSCV.setDepartmentsId(departmentId);
						pmlDepartmentHSCV.setId_ho_so_cong_viec(idHSCV[i]);
						PmlDepartmentHSCVLocalServiceUtil.addPmlDepartmentHSCV(pmlDepartmentHSCV);
					} catch (Exception e) {
						
					}
				}
			}
		}
		sendRedirect(req, res, redirect);
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String departmentId = ParamUtil.getString(req, "departmentId", "");
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(departmentId);
			} catch (Exception e) {
				
			}
			//lay danh sach ho so cong viec
			List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
			
			try {
				pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
			} catch (Exception e) {
				
			}
			
			//lay danh nhung ho so cong viec da thuoc ve phong ban
			List<PmlDepartmentHSCV> pmlDepartmentHSCVList = new ArrayList<PmlDepartmentHSCV>();
			
			if (Validator.isNotNull(departmentId)) {
				try {
					pmlDepartmentHSCVList = PmlDepartmentHSCVUtil.findByDepartmentsId(departmentId) ;
				} catch (Exception e) {
				}			
			}
			
			// loai bo nhung hscv trung
			req.setAttribute("countHSCVExist",pmlDepartmentHSCVList.size());
			long Id_ho_so_cong_viec = 0;
			
			if (pmlDepartmentHSCVList.size() > 0 ) {				
				PmlHoSoCongViec pmlHoSoCongViec = null;
				for (int i = 0; i < pmlHoSoCongViecList.size(); i++) {
					for (int j = 0; j < pmlDepartmentHSCVList.size(); j++) {						
							Id_ho_so_cong_viec = pmlDepartmentHSCVList.get(j).getId_ho_so_cong_viec();
							try {
								pmlHoSoCongViec = PmlHoSoCongViecUtil.findByPrimaryKey(Id_ho_so_cong_viec);
							} catch (Exception e) {
								
							}
							if (pmlHoSoCongViec != null && pmlHoSoCongViecList.contains(pmlHoSoCongViec)) {
								pmlHoSoCongViecList.remove(pmlHoSoCongViec);
								pmlHoSoCongViecList.add(0, pmlHoSoCongViec);
								pmlDepartmentHSCVList.remove(j);
							}
						}
					}
			}
		
			req.setAttribute("hscvList",pmlHoSoCongViecList);
			req.setAttribute("department",department);
			return mapping.findForward("portlet.sgs.departmentleader.viewdepartmenthscv");
	}
	
	


}
