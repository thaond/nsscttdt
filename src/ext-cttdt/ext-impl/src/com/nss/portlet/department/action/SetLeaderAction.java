package com.nss.portlet.department.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.impl.PmlDepartmentsLeaderImpl;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil;

public class SetLeaderAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		updateLeader(req);
	}

	private void updateLeader(ActionRequest req) throws Exception {
		long[] addDepartmentLeaderArr = StringUtil.split(ParamUtil.getString(req, "addDepartmentLeader"), 0L);
		addDepartmentLeader(req, addDepartmentLeaderArr);

		long[] removeDepartmentLeaderArr = StringUtil.split(ParamUtil.getString(req, "removeDepartmentLeader"), 0L);
		removeDepartmentLeader(req, removeDepartmentLeaderArr);
	}
	
	private void addDepartmentLeader(ActionRequest req, long[] addDepartmentLeaderArr) throws SystemException {
		long main = ParamUtil.getLong(req, "isLeaderMain");
		String departmentsId = ParamUtil.getString(req, "departmentId", "");
		
		for (int i = 0; i < addDepartmentLeaderArr.length; i++) {
			long userId = addDepartmentLeaderArr[i];

			PmlDepartmentsLeader pmlDepartmentsLeader = new PmlDepartmentsLeaderImpl();
			
			pmlDepartmentsLeader.setUserId(userId);
			pmlDepartmentsLeader.setDepartmentsId(departmentsId);
			if (userId == main) {
				pmlDepartmentsLeader.setMain(true);
			}
			else {
				pmlDepartmentsLeader.setMain(false);
			}
			PmlDepartmentsLeaderLocalServiceUtil.updatePmlDepartmentsLeader(pmlDepartmentsLeader);
		}
	}
	
	private void removeDepartmentLeader(ActionRequest req, long[] removeDepartmentLeaderArr) {
		String departmentsId = ParamUtil.getString(req, "departmentId", "");
		
		for (int i = 0; i < removeDepartmentLeaderArr.length; i++) {
			long userId = removeDepartmentLeaderArr[i];
			PmlDepartmentsLeader pmlDepartmentsLeader = null;

			try {
				pmlDepartmentsLeader = PmlDepartmentsLeaderLocalServiceUtil.findByDepartmentsId_UserId(departmentsId, userId).get(0);
				
				PmlDepartmentsLeaderLocalServiceUtil.deletePmlDepartmentsLeader(pmlDepartmentsLeader);
			} catch (Exception e) {
			}
			
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		String departmentId = ParamUtil.getString(req, "departmentId", "");
		
		Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
		String departmentName = department.getDepartmentsName();

		req.setAttribute("departmentName", departmentName);
		req.setAttribute("departmentId", departmentId);
		
		return mapping.findForward("portlet.nss.department.setleader");
	}

}
