package com.sgs.portlet.department.action;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.persistence.RoleUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.persistence.AgencyUtil;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;

public class ViewAction extends PortletAction {

	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

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

			int numberPage = ParamUtil.getInteger(req, "numberPage");
			int numberRecord = ParamUtil.getInteger(req, "numberRecord");
			if (numberRecord == 0) {
				numberRecord = 10;
			}

			String cmd = ParamUtil.getString(req, Constants.CMD);
			if (!Validator.isNull(cmd)) {

				if (cmd.equals(Constants.ADD)) {
					createDepartment(req, res);
				}
				else if (cmd.equals(Constants.EDIT)) {
					editDepartment(req, res);
				}
				else if (cmd.equals(Constants.DELETE)) {
					deleteDepartment(req, res);
				}
				else if (cmd.equals(Constants.UPDATE)) {
					updateDepartment(req, res);
				}
				
			}

			List<Department> listDepartment =
				getListDepartment(req, res, numberPage, numberRecord);
			
			List<Agency> listAgency = AgencyUtil.findAll();
			
			req.setAttribute("listDepartment", listDepartment);
			req.setAttribute("listAgency", listAgency);
			req.setAttribute("numberPage", numberPage);
			return mapping.findForward("portlet.sgs.department.view");
		}
	}

	private List<Department> getListDepartment(
		RenderRequest req, RenderResponse res, int numberPage, int numberRecord) {

		int total = 0;
		int totalPage = 0;
		int start = numberPage * numberRecord;
		int end = start + numberRecord;
		List<Department> list = null;
		String type = ParamUtil.getString(req, "type");
		String keyword = ParamUtil.getString(req, "keyword");
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		String method = request.getMethod().toLowerCase();
		//System.out.println("method: " + method);

		if (keyword != null && "get".equals(method)) {
			try {
				byte[] k = keyword.getBytes("ISO-8859-1");

				keyword = new String(k, "UTF-8");

			}
			catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		req.setAttribute("type", type);
		req.setAttribute("keyword", keyword);
		req.setAttribute("numberRecord", numberRecord);

		if (keyword != null && !keyword.trim().equals("")) {
			keyword = "%" + keyword + "%";
		}

		try {
			if (keyword == null || keyword.trim().equals("")) {
				list = DepartmentUtil.findAll(start, end);
				total = DepartmentUtil.countAll();
			}
			else {
				if (type.equals("all")) {
					list =
						DepartmentUtil.findByC_N_D(
							keyword, keyword, keyword, keyword, start, end);
					total =
						DepartmentUtil.countByC_N_D(keyword, keyword, keyword, keyword);
				}
				else if (type.equals("departmentsCode")) {
					list =
						DepartmentUtil.findByDepartmentsCode(
							keyword, start, end);
					total = DepartmentUtil.countByDepartmentsCode(keyword);
				}
				else if (type.equals("departmentsName")) {
					list =
						DepartmentUtil.findByDepartmentsName(
							keyword, start, end);
					total = DepartmentUtil.countByDepartmentsName(keyword);
				}
				else if (type.equals("description")) {
					list =
						DepartmentUtil.findByDescription(keyword, start, end);
					total = DepartmentUtil.countByDescription(keyword);
				}
			}

			req.setAttribute("total", total);

			if (total == 0) {
				totalPage = 1;
			}
			else {
				totalPage =
					(total % numberRecord == 0)
						? (total / numberRecord) : (total / numberRecord + 1);
			}

			req.setAttribute("totalPage", totalPage);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return list;
	}

	private void updateDepartment(RenderRequest req, RenderResponse res) {

		String departmentsId = ParamUtil.getString(req, "departmentsId");
		String departmentsCode = ParamUtil.getString(req, "departmentsCode");
		String departmentsName = ParamUtil.getString(req, "departmentsName");
		//xuancong close String agencyId = ParamUtil.getString(req, "agency");
		String description = ParamUtil.getString(req, "description");
		Boolean hasTeam = ParamUtil.getBoolean(req, "team");
		
		try {
			Department department =
				DepartmentLocalServiceUtil.getDepartment(departmentsId);

			department.setDepartmentsCode(departmentsCode);
			department.setDepartmentsName(departmentsName);
			department.setDescription(description);
			department.setHasTeam(hasTeam ? "1" : "0");

			// update department
			department =
				DepartmentLocalServiceUtil.updateDepartment(department);
			// update role in liferay
			RoleServiceUtil.updateRole(department.getRoleId(), departmentsName, description);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteDepartment(RenderRequest req, RenderResponse res) {

		String departmentsId = ParamUtil.getString(req, "departmentsId");
		
		try {
			Department department = DepartmentLocalServiceUtil.getDepartment(departmentsId);
			//delete role trong liferay
			Role role = RoleUtil.findByPrimaryKey(department.getRoleId());
			RoleLocalServiceUtil.deleteRole(role);
			//delete department
			DepartmentLocalServiceUtil.deleteDepartment(departmentsId);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private void editDepartment(RenderRequest req, RenderResponse res) {

		String departmentsId = ParamUtil.getString(req, "departmentsId");
		try {
			Department department =
				DepartmentLocalServiceUtil.getDepartment(departmentsId);
			req.setAttribute("department", department);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private void createDepartment(RenderRequest req, RenderResponse res) {

		String departmentsId="";
		try {
			departmentsId = IdTemplateServiceUtil.generatedId(Department.class);
		} catch (NoSuchIdGeneratedException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		String departmentsCode = ParamUtil.getString(req, "departmentsCode");
		String departmentsName = ParamUtil.getString(req, "departmentsName");
		String agencyId = ParamUtil.getString(req, "agency");
		String description = ParamUtil.getString(req, "description");
		Boolean hasTeam = ParamUtil.getBoolean(req, "team");

		Department department = new DepartmentImpl();
		
		department.setDepartmentsId(departmentsId);
		department.setDepartmentsCode(departmentsCode);
		department.setDepartmentsName(departmentsName);
		department.setAgencyId(agencyId);
		department.setDescription(description);
		department.setHasTeam(hasTeam ? "1" : "0");
		
		// tao doi tuong trong bang role cua liferay
		Role role = null;
		try {
			role = RoleServiceUtil.addRole(departmentsName, description, 1);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		if (role != null) {
			department.setRoleId(role.getRoleId());
			try {
				department =
					DepartmentLocalServiceUtil.updateDepartment(department);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			}

	}

}