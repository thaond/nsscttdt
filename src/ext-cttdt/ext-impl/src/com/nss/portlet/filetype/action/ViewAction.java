package com.nss.portlet.filetype.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.attachedfile.model.AttachedFile;
import com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil;
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil;
import com.nss.portlet.filetype.FileTypeCanNotDeleteException;
import com.nss.portlet.filetype.FileTypeCodeSameCodeException;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.model.impl.PmlFileTypeAttachedFileImpl;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		try {
			if (Constants.DELETE.equals(cmd)) {
				delete(req, res);
			} else if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
				updateFileType(req, res); 
			} else if (cmd.equals("ADD_ATTACH_FILE")) {
				addAttachFileSWithFileType(req);
			} else if (cmd.equals("EDIT_ATTACH_FILE")) {
				editAttachFileSWithFileType(req);
			} else if (cmd.equals("DELETE_ATTACH_FILE")) {
				deleteFileTypeAttachFile(req);
			} else if (cmd.equals(Constants.LOCK)) {
				updateActive(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String fileTypeURL = ParamUtil.getString(req, "fileTypeURL");
				sendRedirect(req, res, fileTypeURL);
			}
		} catch (Exception e) {
			if (e instanceof FileTypeCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof FileTypeCodeSameCodeException) {
				req.setAttribute("fileTypeFlag", "fail");
				
				List<PmlField> listField = PmlFieldLocalServiceUtil.getPmlFields(-1, -1);
				List<IdTemplate> listTemplate = IdTemplateLocalServiceUtil.getIdTemplates(-1, -1);
		
				req.setAttribute("listTemplate", listTemplate);
				req.setAttribute("listField", listField);

				if (cmd.equals(Constants.ADD)) {
					setForward(req, "portlet.nss.filetype.add");
				}
				else if (cmd.equals(Constants.UPDATE)) {
					setForward(req, "portlet.nss.filetype.edit");
				}
				
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				String cmd = ParamUtil.getString(req, Constants.CMD);
				String action = ParamUtil.getString(req, "action");
				
				if (cmd.equals(Constants.EDIT) || cmd.equals(Constants.ADD)) {
					List<PmlField> listField = new ArrayList<PmlField>();
					try {
						listField =  PmlFieldLocalServiceUtil.getPmlFields(-1, -1);
					} catch (Exception e) {
						_log.debug("NO GET LIST FIELD");
					}
					
					List<IdTemplate> listTemplate = new ArrayList<IdTemplate>();
					
					try {
						listTemplate = IdTemplateLocalServiceUtil.getIdTemplates(-1, -1);
					} catch (Exception e) {
						_log.debug("NO GET LIST IDTEMPLATE");
					}				
			
					req.setAttribute("listTemplate", listTemplate);
					req.setAttribute("listField", listField);
					
				}
				else if (action.equals("VIEW_ATTACH_FILE") || cmd.equals("VIEW_ATTACH_FILE") ) {
					viewAttachFileSWithFileType(req);
				} 
				else if (cmd.equals("ADD_ATTACHFILE")) {
					
					List<AttachedFile> attachedFileList = new ArrayList<AttachedFile>();
					try {
						attachedFileList = AttachedFileLocalServiceUtil.getAttachedFiles(-1, -1);
					} catch (Exception e) {
						_log.debug("NO GET LIST ATTACHEDFILE");
					}
					
					req.setAttribute("attachedFileList", attachedFileList);
					req.setAttribute("fileTypeId", ParamUtil.getString(req, "fileTypeId"));
					
				} else if (cmd.equals("EDIT_ATTACHFILE")) {
					
					String fileTypeAttachFileId = ParamUtil.getString(req, "fileTypeAttachFileId");
					String fileTypeId = ParamUtil.getString(req, "fileTypeId");
					PmlFileTypeAttachedFile attachedFile = null;
					
					try {
						attachedFile = PmlFileTypeAttachedFileLocalServiceUtil
							.getPmlFileTypeAttachedFile(fileTypeAttachFileId);
					} catch (Exception e) {
						_log.debug("NO GET PMLFILETYPEATTACHEDFILE");
					}

					req.setAttribute("fileTypeAttachFile", attachedFile);
					req.setAttribute("fileTypeId", fileTypeId);
				}
				
				return mapping.findForward("portlet.nss.filetype.view");
			}
	}
	
	private void viewAttachFileSWithFileType(RenderRequest req) {
		
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");

		List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = null;

		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileLocalServiceUtil.findByFileTypeId(fileTypeId);
		} catch (SystemException e) {
			_log.debug("NO GET LIST PmlFileTypeAttachedFile");
		}
		
		req.setAttribute("fileTypeId", fileTypeId);
		req.setAttribute("pmlFileTypeAttachedFileList",pmlFileTypeAttachedFileList);
	}

	private void delete(ActionRequest req, ActionResponse res) throws Exception {
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");
		PmlFileTypeLocalServiceUtil.removePmlFileType(fileTypeId);
	}
	
	private PmlFileType updateFileType(ActionRequest req,
			ActionResponse res) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
						
		String fileTypeId = ParamUtil.getString(uploadRequest, "fileTypeId");
		String fileTypeCode = ParamUtil.getString(uploadRequest, "_fileTypeCode");
		String fileTypeName = ParamUtil.getString(uploadRequest, "_fileTypeName");
		String fieldId = ParamUtil.getString(uploadRequest, "_fieldId");
		String processTime = ParamUtil.getString(uploadRequest, "_processTime");
		String description = ParamUtil.getString(uploadRequest, "_description");
		Boolean active = ParamUtil.getBoolean(req, "_active");
		String currentReceiptNumber = ParamUtil.getString(uploadRequest, "_currentReceiptNumber");
		String receiptTemplate = ParamUtil.getString(uploadRequest, "_receiptTemplate");
		String templateId = ParamUtil.getString(uploadRequest, "_templateId");
		
		PmlFileType fileType = null;
		
		if (cmd.equals(Constants.ADD)) {
			if (active) {
				fileType = PmlFileTypeLocalServiceUtil.addFileType(fileTypeCode, fileTypeName, fieldId, processTime, description, 
																	"1", currentReceiptNumber, receiptTemplate, templateId);
			}
			else {
				fileType = PmlFileTypeLocalServiceUtil.addFileType(fileTypeCode, fileTypeName, fieldId, processTime, description, 
																	"0", currentReceiptNumber, receiptTemplate, templateId);
			}
		}
		else if (cmd.equals(Constants.UPDATE)) {
			if (active) {
				fileType = PmlFileTypeLocalServiceUtil.updateFileType(fileTypeId, fileTypeCode, fileTypeName, fieldId, processTime, 
														description, "1", currentReceiptNumber, receiptTemplate, templateId);
			}
			else {
				fileType =PmlFileTypeLocalServiceUtil.updateFileType(fileTypeId, fileTypeCode, fileTypeName, fieldId, processTime, 
														description, "0", currentReceiptNumber, receiptTemplate, templateId);
			}
		}
		return fileType;
	}

	private void addAttachFileSWithFileType(ActionRequest req) {
		try {
			String fileTypeId = ParamUtil.getString(req, "fileTypeId");
			
			String attachedFileId = ParamUtil.getString(req, "selectedAttachedFile");
			Integer original = ParamUtil.getInteger(req, "original");
			Integer copy = ParamUtil.getInteger(req, "copy");
			String note = ParamUtil.getString(req, "note");
			
			PmlFileTypeAttachedFile pmlFileTypeAttachedFile = new PmlFileTypeAttachedFileImpl();
			
			pmlFileTypeAttachedFile.setCopy_(copy);
			pmlFileTypeAttachedFile.setNote(note);
			pmlFileTypeAttachedFile.setOriginal(original);
			pmlFileTypeAttachedFile.setAttachedFileId(attachedFileId);
			pmlFileTypeAttachedFile.setAttachedFileName(AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId).getAttachedFileName());
			pmlFileTypeAttachedFile.setFileTypeId(fileTypeId);
			pmlFileTypeAttachedFile.setFiletypeAttachedFileId(String.valueOf(CounterUtil.increment()));
	
			pmlFileTypeAttachedFile.setNew(true);
			PmlFileTypeAttachedFileLocalServiceUtil.addPmlFileTypeAttachedFile(pmlFileTypeAttachedFile);
			
			req.setAttribute("fileTypeId", fileTypeId);
		} catch (Exception e) {
			_log.debug("NO ADD pmlFileTypeAttachedFile");
		}
	}
	
	private void editAttachFileSWithFileType(ActionRequest req) {
		try {
			String pmlFileTypeAttachedFileId = ParamUtil.getString(req, "pmlFileTypeAttachedFileId");
			PmlFileTypeAttachedFile pmlFileTypeAttachedFile = PmlFileTypeAttachedFileLocalServiceUtil.getPmlFileTypeAttachedFile(pmlFileTypeAttachedFileId);
			
			Integer original = ParamUtil.getInteger(req, "original");
			Integer copy = ParamUtil.getInteger(req, "copy");
			String note = ParamUtil.getString(req, "note");
			
			pmlFileTypeAttachedFile.setCopy_(copy);
			pmlFileTypeAttachedFile.setOriginal(original);
			pmlFileTypeAttachedFile.setNote(note);
			
			PmlFileTypeAttachedFileLocalServiceUtil.updatePmlFileTypeAttachedFile(pmlFileTypeAttachedFile, true);
			
			req.setAttribute("fileTypeId", ParamUtil.getString(req, "fileTypeId"));
		} catch (Exception e) {
			_log.debug("NO EDIT pmlFileTypeAttachedFile");
		}
	}
	
	private void deleteFileTypeAttachFile(ActionRequest req) throws Exception {

		req.setAttribute("fileTypeId", ParamUtil.getString(req, "fileTypeId"));
		String fileTypeAttachFileId = ParamUtil.getString(req, 	"fileTypeAttachFileId");
		try {
			PmlFileTypeAttachedFileLocalServiceUtil
					.deletePmlFileTypeAttachedFile(fileTypeAttachFileId);
			
		} catch (Exception e) {
			_log.debug("NO DELETE pmlFileTypeAttachedFile");
		}
	}
	
	public void updateActive(ActionRequest req, ActionResponse res) {
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");
		PmlFileType pmlFileType = null;
		try {
			pmlFileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
		} catch (PortalException e) { 
			_log.error(e);
			_log.error("NOT FOUND PmlFileType");
		} catch (SystemException e) {
			_log.error(e);
			_log.error("NOT FOUND PmlFileType");
		}
		
		if ( null != pmlFileType) {
			if ("1".equals(pmlFileType.getActive())) {
				pmlFileType.setActive("0");
			} else if ("0".equals(pmlFileType.getActive())) {
				pmlFileType.setActive("1");
			}
			
			try {
				pmlFileType = PmlFileTypeLocalServiceUtil.updatePmlFileType(pmlFileType);
			} catch (SystemException e) {
				_log.error(e);
				_log.error("CAN NOT UPDATE PmlFileType");
			}
		}
	}
}
