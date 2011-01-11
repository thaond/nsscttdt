package com.sgs.portlet.report_registry_work.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.ResultProgram;
import com.sgs.portlet.report_registry_work.model.impl.ResultProgramImpl;
import com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil;
import com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/report_registry_work/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String varAction = ParamUtil.getString(req, "varAction");
		
		if (!Validator.isNull(cmd)) {
			if(varAction.equals("department")){
				if(cmd.equals(Constants.ADD)){
					addDepartment(req);
					sendRedirect(req, res, redirect);
				}else if(cmd.equals(Constants.EDIT)){
					editDepartment(req);
				}else if(cmd.equals(Constants.UPDATE)){
					updateDepartment(req, res);
					sendRedirect(req, res, redirect);
				}else if(cmd.equals(Constants.DELETE)){
					deleteDepartment(req, res, redirect);
				}
			}else if(varAction.equals("reportregistry")){
				if(cmd.equals(Constants.ADD)){
					addReportRegistry(req);
					sendRedirect(req, res, redirect);
				}
			}
		}
	}

	public void addDepartment(ActionRequest req) {
		String code = ParamUtil.getString(req, "departmentCode");
		String name = ParamUtil.getString(req, "departmentName");
		String description = ParamUtil.getString(req, "departmentDescription");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				long departmentId = CounterLocalServiceUtil.increment();
				Department department = DepartmentLocalServiceUtil.createDepartment(departmentId);
				department.setDepartmentCode(code);
				department.setDepartmentName(name);
				department.setDepartmentDescription(description);
				department.setUserId(userId);
				department.setCompanyId(companyId);
				DepartmentLocalServiceUtil.addDepartment(department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void editDepartment(ActionRequest req) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0){
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				req.setAttribute("department", department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editDepartment OF " + ViewAction.class + " " + e.getMessage());
		}	
	}
	
	public void updateDepartment(ActionRequest req, ActionResponse res) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		String code = ParamUtil.getString(req, "departmentCode");
		String name = ParamUtil.getString(req, "departmentName");
		String description = ParamUtil.getString(req, "departmentDescription");
		long userId = PortalUtil.getUserId(req);

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				department.setDepartmentCode(code);
				department.setDepartmentName(name);
				department.setDepartmentDescription(description);
				DepartmentLocalServiceUtil.updateDepartment(department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void deleteDepartment(ActionRequest req, ActionResponse res, String redirect) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0){
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				List<ReportRegistry> reportRegistries = DepartmentLocalServiceUtil.getReportRegistries(departmentId);
				if(reportRegistries.size()>0){
					DepartmentLocalServiceUtil.deleteDepartment(department);
				}else{
					req.setAttribute("error_delete_department", "error_delete_department");
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	

	public void addReportRegistry(ActionRequest req) throws SystemException, IOException, PortalException {
		String reportRegistryCode = ParamUtil.getString(req, "reportRegistryCode");
		long departmentId = ParamUtil.getLong(req, "department");
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		long reportRegistryId = CounterLocalServiceUtil.increment();
		ReportRegistry reportRegistry = ReportRegistryLocalServiceUtil.createReportRegistry(reportRegistryId);
		
		Date date = new Date();
		Timestamp timeNow = new Timestamp(date.getTime());
		
		long userId = PortalUtil.getUserId(req);
		if(userId != 0){
			reportRegistry.setReportRegistryCode(reportRegistryCode);
			reportRegistry.setReportDate(timeNow);
			reportRegistry.setUserId(userId);
			reportRegistry.setDepartmentId(departmentId);
			try {
				ReportRegistryLocalServiceUtil.addReportRegistry(reportRegistry);
			} catch (Exception e) {
				_log.error("ERROR IN METHOD addReportRegistry OF " + ViewAction.class + " " + e.getMessage());
			}
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFileResult(req, reportRegistryId, userId, nameFieldRowArr[i], titleFilesArr[i]);
				}
			}
		}
	}


	public void uploadFileResult(ActionRequest req, long reportRegistryId, long userId, String nameFieldUpload, String titleFile) throws SystemException, IOException, PortalException {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			System.out.println("fileNames----"+fileNames);
			String dateValue = com.sgs.portlet.report_registry_work.util.Constants.getDateTime();
			String fileName = dateValue + fileNames;			
			System.out.println("fileName====="+fileName);
			String pathFile = getServlet().getServletContext().getRealPath("/") + "upload";
			System.out.println("pathFile-----"+pathFile);
			File destFile = new File(pathFile + "/" + fileName);
			System.out.println("destFile-----"+destFile);
			if (!(new File(pathFile)).exists()) {
				(new File(pathFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			ResultProgram resultProgram =new ResultProgramImpl();
			long resultProgramId = CounterLocalServiceUtil.increment();
			resultProgram.setResultProgramId(resultProgramId);
			resultProgram.setReportRegistryId(reportRegistryId);
			resultProgram.setResultProgramCheck("resultwork");
			
			User user = UserLocalServiceUtil.getUser(userId);
			String userName = user.getScreenName();
			resultProgram.setResultProgramPath("/upload" + "/" + fileName);
			String fullTitle = titleFile + "_" + userName + "_" + dateValue;
			System.out.println("fullTitle----"+fullTitle);
			resultProgram.setResultProgramTitle(fullTitle);
			
			ResultProgramLocalServiceUtil.addResultProgram(resultProgram);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD uploadFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req));
			} else {
				return mapping.findForward("portlet.sgs.report_registry_work.view");
			}
	}
}
