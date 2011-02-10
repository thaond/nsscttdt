package com.sgs.portlet.filetype.action;

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
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.service.AttachedFileLocalServiceUtil;
import com.sgs.portlet.attachedfile.service.persistence.AttachedFileUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.PmlFieldLocalServiceUtil;
import com.sgs.portlet.filetype.FileTypeCanNotDeleteException;
import com.sgs.portlet.filetype.FileTypeCodeSameCodeException;
import com.sgs.portlet.filetype.form.FileTypeForm;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.impl.PmlFileTypeAttachedFileImpl;
import com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	// Yenlt update 05/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	//end
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

		String cmd = ParamUtil.getString(req, Constants.CMD);
//		String tab = ParamUtil.getString(req, "tab");
		//String redirect = ParamUtil.getString(req, "redirect")+"&tab=" + tab;
		//String redirectAttFile = ParamUtil.getString(req, "redirectAttFile")+"&tab=" + tab;
		// loai ho so
		try {
			if (Constants.DELETE.equals(cmd)) {
				/* yenlt close 25082010
				 boolean delete = delete(form, req, res);
				 redirect += "&delete=" + String.valueOf(delete);
				 */
				delete(req, res);// yenlt update 25082010
//			} else if (Constants.ADD.equals(cmd)) {
//				addFileType(form, req, res);
//				
//			} else if (Constants.EDIT.equals(cmd)) {
//				editFileType(form, req, res); 
//				
			} else if (Constants.ADD.equals(cmd) || Constants.UPDATE.equals(cmd)) {
				updateFileType(req, res); 
			
			} else if (cmd.equals("ADD_ATTACH_FILE")) {
				addAttachFileSWithFileType(req);
				//redirect = redirectAttFile;
				
			} else if (cmd.equals("EDIT_ATTACH_FILE")) {
				editAttachFileSWithFileType(req);
				//redirect = redirectAttFile;
				
			} else if (cmd.equals("DELETE_ATTACH_FILE")) {
				deleteFileTypeAttachFile(req);// yenlt update 25082010
				/* yenlt close 25082010
				boolean delete = deleteFileTypeAttachFile(req);
				redirect = redirectAttFile + "&delete=" + String.valueOf(delete);
				*/
			} else if (cmd.equals(Constants.LOCK)) {
				//Yenlt update 10/03/2010
				updateActive(req, res);
				//end
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
					setForward(req, "portlet.sgs.filetype.add");
				}
				else if (cmd.equals(Constants.UPDATE)) {
					setForward(req, "portlet.sgs.filetype.edit");
				}
				
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		//sendRedirect( req, res, redirect); // yenlt close 25082010
		
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
	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		} else {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			String action = ParamUtil.getString(req, "action");
			
			// di vao form edit hoac add  loai ho so
			
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
				
				if (cmd.equals(Constants.EDIT)) {
					initEditFileType(form, req, res);
				}
				
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
			
			
			return mapping.findForward("portlet.sgs.filetype.view");
		}
	}

	/*
	 *  khoi tao du lieu cho viec edit loai ho so
	 */
	private void initEditFileType(ActionForm form, RenderRequest req, RenderResponse res)
			throws Exception {

		// get Field ID
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");
		req.setAttribute("fileTypeId", fileTypeId);

		FileTypeForm filetypeForm = (FileTypeForm) form;

		PmlFileType filetype = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
		filetypeForm.set_active(filetype.getActive());
		filetypeForm.set_currentReceiptNumber(filetype
				.getCurrentReceiptNumber());
		filetypeForm.set_description(filetype.getDescription());
		filetypeForm.set_fieldId(filetype.getFieldId());
		filetypeForm.set_fileTypeCode(filetype.getFileTypeCode());
		filetypeForm.set_fileTypeId(filetype.getFileTypeId());
		filetypeForm.set_fileTypeName(filetype.getFileTypeName());
		filetypeForm.set_processTime(filetype.getProcessTime());
		filetypeForm.set_receiptTemplate(filetype.getReceiptTemplate());
		filetypeForm.set_templateId(filetype.getTemplateId());

		req.setAttribute("filetype", filetypeForm);
	}
	
	private void viewAttachFileSWithFileType(RenderRequest req) {
		
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");

		List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = null;

		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
		} catch (SystemException e) {
			_log.debug("NO GET LIST PmlFileTypeAttachedFile");
		}
		
		req.setAttribute("fileTypeId", fileTypeId);
		req.setAttribute("pmlFileTypeAttachedFileList",pmlFileTypeAttachedFileList);
	}


//end

	/*
	 * Yenlt  05/04/2010
	 * update active
	 */
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
	// yenlt update 25082010
	private void delete(ActionRequest req, ActionResponse res) throws Exception {
		String fileTypeId = ParamUtil.getString(req, "fileTypeId");
		PmlFileTypeLocalServiceUtil.removePmlFileType(fileTypeId);
	}
	/*
	 * 
	 */
	/* yenlt close 25082010
	private boolean delete(ActionForm form, ActionRequest req, ActionResponse res)
			throws Exception {

		try {

			String fileTypeId = ParamUtil.getString(req, "fileTypeId");
			
			List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
			try {
				pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
			} catch (Exception e) {
				
			}
			
			List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = new ArrayList<PmlFileTypeAttachedFile>();
			try {
				pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
			} catch (Exception e) {
				
			}
			//con bang pml_transition chua quan ly va cung khong can thiet nen khong bat ren buoc
			
			if (pmlOneDoorReceiveFileList.size() > 0 || pmlFileTypeAttachedFileList.size() > 0) {
				return  false;
			} else {
				PmlFileTypeLocalServiceUtil.deletePmlFileType(fileTypeId);
				return  true;
			}
		} catch (Exception e) {
			_log.debug("NO DELETE FILETYPE");
			return false;	
		}
	}
	*/
	/*
	 * them loai ho so
	 */
	/*
	private void addFileType(ActionForm form, ActionRequest req,
			ActionResponse res) {
		try {
			 // get form available
			FileTypeForm fileTypeForm = (FileTypeForm) form;
			String fileTypeId = IdTemplateServiceUtil
					.generatedId(PmlFileType.class);

			PmlFileType fileType = PmlFileTypeLocalServiceUtil.createPmlFileType(fileTypeId);
			Boolean active = ParamUtil.getBoolean(req, "_active");
			fileType.setCurrentReceiptNumber(fileTypeForm
					.get_currentReceiptNumber());
			fileType.setDescription(fileTypeForm.get_description());
			fileType.setFieldId(fileTypeForm.get_fieldId());
			fileType.setFileTypeCode(fileTypeForm.get_fileTypeCode());
			fileType.setFileTypeName(fileTypeForm.get_fileTypeName());
			fileType.setProcessTime(fileTypeForm.get_processTime());
			fileType.setReceiptTemplate(fileTypeForm.get_receiptTemplate());
			fileType.setTemplateId(fileTypeForm.get_templateId());
			if (active) {
				fileType.setActive("1");
			} else {
				fileType.setActive("0");
			}

			PmlFileTypeLocalServiceUtil.updatePmlFileType(fileType);

		} catch (Exception e) {
		}
	}*/
	
	/*
	 * cap nhat loai ho so
	 */
	/*
	private void editFileType(ActionForm form, ActionRequest req,
			ActionResponse res) throws Exception {

		try {
			// get form available
			FileTypeForm fileTypeForm = (FileTypeForm) form;

			PmlFileType fileType = new PmlFileTypeImpl();
			Boolean active = ParamUtil.getBoolean(req, "_active");
			if (active) {
				fileType.setActive("1");
			} else {
				fileType.setActive("0");
			}
			fileType.setFileTypeId(fileTypeForm.get_fileTypeId());

			fileType.setCurrentReceiptNumber(fileTypeForm
					.get_currentReceiptNumber());
			fileType.setDescription(fileTypeForm.get_description());
			fileType.setFieldId(fileTypeForm.get_fieldId());
			fileType.setFileTypeCode(fileTypeForm.get_fileTypeCode());
			fileType.setFileTypeName(fileTypeForm.get_fileTypeName());
			fileType.setProcessTime(fileTypeForm.get_processTime());
			fileType.setReceiptTemplate(fileTypeForm.get_receiptTemplate());
			fileType.setTemplateId(fileTypeForm.get_templateId());

			PmlFileTypeLocalServiceUtil.updatePmlFileType(fileType);

		} catch (Exception e) {
		}
	}*/
	
	
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
			pmlFileTypeAttachedFile.setAttachedFileName(AttachedFileUtil.findByPrimaryKey(attachedFileId).getAttachedFileName());
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
			PmlFileTypeAttachedFile pmlFileTypeAttachedFile = PmlFileTypeAttachedFileUtil.findByPrimaryKey(pmlFileTypeAttachedFileId);
			
			Integer original = ParamUtil.getInteger(req, "original");
			Integer copy = ParamUtil.getInteger(req, "copy");
			String note = ParamUtil.getString(req, "note");
			
			pmlFileTypeAttachedFile.setCopy_(copy);
			pmlFileTypeAttachedFile.setOriginal(original);
			pmlFileTypeAttachedFile.setNote(note);
			
			PmlFileTypeAttachedFileUtil.update(pmlFileTypeAttachedFile, true);
			
			req.setAttribute("fileTypeId", ParamUtil.getString(req, "fileTypeId"));
		} catch (Exception e) {
			_log.debug("NO EDIT pmlFileTypeAttachedFile");
		}
	}
	// yenlt update 25082010
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

	/* yenlt close 25082010
	private boolean deleteFileTypeAttachFile(ActionRequest req) throws Exception {

		req.setAttribute("fileTypeId", ParamUtil.getString(req, "fileTypeId"));
		String fileTypeAttachFileId = ParamUtil.getString(req, 	"fileTypeAttachFileId");
		try {
			PmlFileTypeAttachedFileLocalServiceUtil
					.deletePmlFileTypeAttachedFile(fileTypeAttachFileId);
			
			return true;
		} catch (Exception e) {
			_log.debug("NO DELETE pmlFileTypeAttachedFile");
			return false;
		}
	}
	*/

}
