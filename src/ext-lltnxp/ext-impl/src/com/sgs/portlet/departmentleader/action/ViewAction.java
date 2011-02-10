package com.sgs.portlet.departmentleader.action;

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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.DepartmentCanNotDeleteException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
public class ViewAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
			String cmd = ParamUtil.getString(req, Constants.CMD, "");
			/* yenlt close 24082010
			String redirect = ParamUtil.getString(req, "redirect");
			
			if (Constants.DELETE.equals(cmd)) {
				boolean delete = deleteDepartment(req);
				redirect +="&delete=".concat(String.valueOf(delete));
				
			}
			sendRedirect(req, res, redirect);
			*/
			// yenlt update 24082010
			try {
				if (Constants.DELETE.equals(cmd)) {
					deleteDepartment(req);
				}
				if (Validator.isNotNull(cmd)) {
					String departmentURL = ParamUtil.getString(req, "departmentURL");
					sendRedirect(req, res, departmentURL);
				}
			} catch (Exception e) {
				if (e instanceof DepartmentCanNotDeleteException){
					SessionErrors.add(req,e.getClass().getName());
				}
				else {
					throw e;
				}
			}
	}
	
	private void deleteDepartment(ActionRequest req) throws Exception {
		String departmentId = ParamUtil.getString(req, "departmentId","");
		DepartmentLocalServiceUtil.removeDepartment(departmentId);
	}
	// end yenlt update 24082010
	
	/* yenlt close 24082010
	private boolean deleteDepartment(ActionRequest req) throws Exception {
		String departmentId = ParamUtil.getString(req, "departmentId","");
		
		if (!"".equals(departmentId)) {
			
			// get list department leader in department
			
			
			List<PmlDepartmentsLeader> departmentLeaderList = new ArrayList<PmlDepartmentsLeader>();
			try {
				departmentLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				
			}
			
			
			//get list users in this department
			List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				
			}
			
			//get list field in this department
			
			List<PmlField> fieldList = new ArrayList<PmlField>();
			try {
				fieldList = PmlFieldUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				
			}
			
			//get list team in this department
			
			List<PmlTeam> pmlPmlTeamList = new ArrayList<PmlTeam>();
			try {
				pmlPmlTeamList = PmlTeamUtil.findByDepartmentId(departmentId);
			} catch (Exception e) {
				
			}
			
			if (departmentLeaderList.size() > 0  ||	pmlUserList.size() > 0  ||
					fieldList.size() > 0 || pmlPmlTeamList.size() > 0 ) {
				
				return  false;
			} else {
				// delete department
				DepartmentLocalServiceUtil.deleteDepartment(departmentId);
				return  true;
			}
		}
		return false;
	}
	 */
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				List<Department> departmentList = DepartmentUtil.findAll();
				
				req.setAttribute("departmentList", departmentList);
				return mapping.findForward("portlet.sgs.departmentleader.view");
	}
}
