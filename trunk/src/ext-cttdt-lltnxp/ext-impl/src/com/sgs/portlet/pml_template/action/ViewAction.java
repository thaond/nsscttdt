package com.sgs.portlet.pml_template.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pml_template.model.FileTemplate;
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.search.PmlTemplateSearch;
import com.sgs.portlet.pml_template.service.FileTemplateLocalServiceUtil;
import com.sgs.portlet.pml_template.service.PmlTemplateLocalServiceUtil;
import com.sgs.portlet.pml_template.service.persistence.FileTemplateUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (cmd.equals(Constants.ADD) ) {
			addTemplate(req);
		} else if (cmd.equals(Constants.EDIT)) {
			editTemplate(req);
		} else  if (cmd.equals(Constants.UPDATE)) {
			updateTemplate(req);
		} else if (cmd.equals(Constants.DELETE)) {
			deleteTemplate(req);
		}
	}

	public void deleteTemplate(ActionRequest req) {
		long templateId = ParamUtil.getLong(req, "templateId");
		PmlTemplate pmlTemplate = null;
		List<FileTemplate> fileTemplateList = new ArrayList<FileTemplate>();
		try {
			pmlTemplate = PmlTemplateLocalServiceUtil.getPmlTemplate(templateId);
			PmlTemplateLocalServiceUtil.deletePmlTemplate(templateId);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (null != pmlTemplate) {
			FileTemplate fileTemplate = null;
			try {
				fileTemplateList = FileTemplateUtil.findByTemplateId(templateId);
				if (fileTemplateList.size() > 0) {
					fileTemplate = fileTemplateList.get(0);
					FileTemplateLocalServiceUtil.deleteFileTemplate(fileTemplate);
					String pathFile = getServlet().getServletContext().getRealPath("")+ fileTemplate.getDuongDan();
					deleteFileOnServer(pathFile);
				}
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
	}

	public void editTemplate(ActionRequest req) {
		long templateId = ParamUtil.getLong(req, "templateId");
		PmlTemplate pmlTemplate = null;
		List<FileTemplate> fileTemplateList = new ArrayList<FileTemplate>();
		try {
			pmlTemplate = PmlTemplateLocalServiceUtil.getPmlTemplate(templateId);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (null != pmlTemplate) {
			try {
				fileTemplateList = FileTemplateUtil.findByTemplateId(templateId);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
		req.setAttribute("pmlTemplate", pmlTemplate);
		req.setAttribute("fileTemplateList", fileTemplateList);
	}

	public void updateTemplate(ActionRequest req) {
		long templateId = ParamUtil.getLong(req, "templateId");
		String templateCode = ParamUtil.getString(req, "templateCode");
		String templateName = ParamUtil.getString(req, "templateName");
		Date publishDate = ParamUtil.getDate(req, "ngayBanHanh", new SimpleDateFormat("dd/MM/yyyy"));
		int soVanBan = ParamUtil.getInteger(req, "soVanBan");
		String departmentId = ParamUtil.getString(req, "departmentId");
		PmlTemplate pmlTemplate = null;
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("file");
		// end
		try {
			pmlTemplate = PmlTemplateLocalServiceUtil.getPmlTemplate(templateId);
			pmlTemplate.setTemplateCode(templateCode);
			pmlTemplate.setTemplateName(templateName);
			pmlTemplate.setNumberOfDocument(soVanBan);
			pmlTemplate.setPublishDate(publishDate);
			pmlTemplate.setDepartmentId(departmentId);
			pmlTemplate = PmlTemplateLocalServiceUtil.updatePmlTemplate(pmlTemplate);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (file.exists()) {
			List<FileTemplate> fileTemplateList = new ArrayList<FileTemplate>();
			FileTemplate fileTemplate = null;
			try {
				fileTemplateList = FileTemplateUtil.findByTemplateId(templateId);
				if (fileTemplateList.size() > 0) {
					fileTemplate = fileTemplateList.get(0);
					FileTemplateLocalServiceUtil.deleteFileTemplate(fileTemplate);
					String pathFile = getServlet().getServletContext().getRealPath("")+ fileTemplate.getDuongDan();
					deleteFileOnServer(pathFile);
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
			uploadFile(req, file, pmlTemplate);
		}
	}

	public void addTemplate(ActionRequest req) {
		String templateCode = ParamUtil.getString(req, "templateCode");
		String templateName = ParamUtil.getString(req, "templateName");
		Date publishDate = ParamUtil.getDate(req, "ngayBanHanh", new SimpleDateFormat("dd/MM/yyyy"));
		int soVanBan = ParamUtil.getInteger(req, "soVanBan");
		String departmentId = ParamUtil.getString(req, "departmentId");
		long templateId = 0;
		PmlTemplate pmlTemplate = null;
		// phan cho file upload
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileupload = uploadRequest.getFile("file");
		// end
		try {
			templateId = CounterLocalServiceUtil.increment();
			pmlTemplate = PmlTemplateLocalServiceUtil.createPmlTemplate(templateId);
			pmlTemplate.setTemplateCode(templateCode);
			pmlTemplate.setTemplateName(templateName);
			pmlTemplate.setNumberOfDocument(soVanBan);
			pmlTemplate.setPublishDate(publishDate);
			pmlTemplate.setDepartmentId(departmentId);
			pmlTemplate = PmlTemplateLocalServiceUtil.updatePmlTemplate(pmlTemplate);
			if (fileupload.exists()) {
				uploadFile(req, fileupload, pmlTemplate);
			}
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		
	}
	
	public void deleteFileOnServer(String pathFile) {
		File file = new File(pathFile);
		if (file.exists()) {
			file.delete();
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<Department> departmentList = new ArrayList<Department>();
			departmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
			req.setAttribute("departmentList", departmentList);
			
			String tabs = ParamUtil.getString(req, "tabs", "display");
			if (tabs.equals("display")) {
				String type = ParamUtil.getString(req, "locTheo", "");
				String valueType = ParamUtil.getString(req, "valueType", "");		
				String ngayBanHanhParam = ParamUtil.getString(req,"ngayBanHanhSearch", "");
				String departmentIdFilter = ParamUtil.getString(req,"departmentIdFilter", "");
				// Dieu kien sort 
				PortletURL portletURL = res.createRenderURL();
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("struts_action", "/sgs/pml_template/view");
				portletURL.setParameter("type", type);
				portletURL.setParameter("valueType", valueType);
				portletURL.setParameter("ngayBanHanhParam", ngayBanHanhParam);
				portletURL.setParameter("departmentIdFilter", departmentIdFilter);
				PmlTemplateSearch searchContainer = new PmlTemplateSearch(req, portletURL);
				
				if (!"".equals(valueType)) {
					departmentIdFilter = "";
					ngayBanHanhParam = "";
				}
				
				if (!"".equals(ngayBanHanhParam)) {
					valueType = ngayBanHanhParam ;
					departmentIdFilter = "";
				} 
				
				if (!"".equals(departmentIdFilter)) {
					valueType = departmentIdFilter;
					ngayBanHanhParam = "";
				}
				
				List<PmlTemplate> pmlTemplateList = new ArrayList<PmlTemplate>();
				int total = 0;
				pmlTemplateList = PmlTemplateLocalServiceUtil.search(type, valueType, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
				total = PmlTemplateLocalServiceUtil.searchCount(type, valueType);
				req.setAttribute("pmlTemplateList", pmlTemplateList);
				req.setAttribute("total", total);
				req.setAttribute("valueType", valueType);
				req.setAttribute("departmentIdFilter", departmentIdFilter);
				req.setAttribute("locTheo", type);
				req.setAttribute("ngayBanHanhParam", ngayBanHanhParam);
				req.setAttribute("templateSearchContainer", searchContainer);
				
			}
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pml_template.view");
			}
	}

	public void uploadFile(ActionRequest req, File file,PmlTemplate pmlTemplate) {
		String tenFile = ParamUtil.getString(req, "fileName");
		String fileName = com.sgs.portlet.document.receipt.util.Constants.getDateTime() + tenFile;		
		String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
		File destFile = new File(patthFile + "/" + fileName);
		long fileSize = file.length()/ 1024;
		if (!(new File(patthFile)).exists()) {
			(new File(patthFile)).mkdir();
		}
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			_log.error(e.getMessage());
		}
		
		long maFileDinhKem = 0;
		FileTemplate fileDinhKem = null;
		try {
			maFileDinhKem = CounterLocalServiceUtil.increment();
			fileDinhKem = FileTemplateLocalServiceUtil.createFileTemplate(maFileDinhKem);
			fileDinhKem.setTemplateId(pmlTemplate.getTemplateId());
			fileDinhKem.setTenFile(tenFile); 
			fileDinhKem.setKichThuoc(fileSize);
			fileDinhKem.setDuongDan("/upload/" + fileName);
			fileDinhKem = FileTemplateLocalServiceUtil.addFileTemplate(fileDinhKem);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
	}
}
