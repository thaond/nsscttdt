package com.sgs.portlet.document_manager.action;

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
import com.sgs.portlet.document_manager.model.AttactFileDocument;
import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.model.impl.AttactFileDocumentImpl;
import com.sgs.portlet.document_manager.service.AttactFileDocumentLocalServiceUtil;
import com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/document_manager/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String varAction = ParamUtil.getString(req, "varAction");
		
		if (!Validator.isNull(cmd)) {
			if(varAction.equals("documentManagerSend")){
				if(cmd.equals(Constants.ADD)){
					addDocumentManager(req, res, redirect);
				}else if(cmd.equals(Constants.EDIT)){
					editDocumentManager(req);
				}else if(cmd.equals(Constants.UPDATE)){
					updateDocumentManager(req, res);
					sendRedirect(req, res, redirect);
				}else if(cmd.equals(Constants.DELETE)){
					deleteDocumentManager(req, res, redirect);
				}
			}else if(varAction.equals("attactFileDocument")){
				if(cmd.equals(Constants.DELETE)){
					deleteAttactFileDocument(req);
				}
			}
		}
	}

	public void addDocumentManager(ActionRequest req, ActionResponse res, String redirect) throws SystemException, IOException, PortalException {
		try {
			String documentManagerCode = ParamUtil.getString(req, "documentManagerCode");
			String documentManagerCategory = ParamUtil.getString(req, "documentManagerCategory");
			String documentManagerDescription = ParamUtil.getString(req, "documentManagerDescription");
			String documentManagerStyle = ParamUtil.getString(req, "documentManagerStyle");
			
			Date date = new Date();
			Timestamp timeNow = new Timestamp(date.getTime());
			
			String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
			nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
			String titleFiles  = ParamUtil.getString(req, "titleFiles");
			titleFiles = StringUtil.encodeHtml(titleFiles);
			
			List<DocumentManager> documentManagers = DocumentManagerLocalServiceUtil.getDocumentManagers(-1, -1);
			boolean checkDocumentManagerCode = false;
			for(DocumentManager dm : documentManagers){
				if(dm.getDocumentManagerCode().equals(documentManagerCode)){
					checkDocumentManagerCode = true;
				}
			}
			
			if(!checkDocumentManagerCode){
				long userId = PortalUtil.getUserId(req);
				if(userId != 0){
					long documentManagerId = CounterLocalServiceUtil.increment();
					DocumentManager documentManager = DocumentManagerLocalServiceUtil.createDocumentManager(documentManagerId);
					documentManager.setDocumentManagerCode(documentManagerCode);
					documentManager.setDocumentManagerCategory(documentManagerCategory);
					documentManager.setDocumentManagerDateCreate(timeNow);
					documentManager.setDocumentManagerDescription(documentManagerDescription);
					documentManager.setUserId(userId);
					if(documentManagerStyle.equals("send")){
						documentManager.setDocumentManagerStyle("send");
					}else{
						documentManager.setDocumentManagerStyle("received");
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
						String documentManagerTitles = "";
						for (int i = 0; i < nameFieldRowArr.length; i++) {
							documentManagerTitles += titleFilesArr[i];
							uploadFile(req, documentManagerId, userId, nameFieldRowArr[i], titleFilesArr[i]);
						}
					documentManager.setDocumentManagerTitle(documentManagerTitles);
					}
					DocumentManagerLocalServiceUtil.addDocumentManager(documentManager);
					sendRedirect(req, res, redirect);
				}
			}else{
				req.setAttribute("duplicate_document_manager_code", "duplicate_document_manager_code");
				req.setAttribute("tabAddDocumentManager", "add_document_manager");
				req.setAttribute("documentManagerCode", documentManagerCode);
				req.setAttribute("documentManagerCategory", documentManagerCategory);
				req.setAttribute("documentManagerDescription", documentManagerDescription);
				req.setAttribute("documentManagerStyle", documentManagerStyle);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addDocumentManager OF " + ViewAction.class + " " + e.getMessage());
		}
	}


	public void uploadFile(ActionRequest req, long documentManagerId, long userId, String nameFieldUpload, String titleFile) throws SystemException, IOException, PortalException {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String dateValue = com.sgs.portlet.document_manager.util.Constants.getDateTime();
			String fileName = dateValue + fileNames;		
			fileName= fileName.replace(" ", "");
			String pathFile = getServlet().getServletContext().getRealPath("/") + "upload";
			File destFile = new File(pathFile + "/" + fileName);
			if (!(new File(pathFile)).exists()) {
				(new File(pathFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			AttactFileDocument attactFileDocument = new AttactFileDocumentImpl();
			long attactFileDocumentId = CounterLocalServiceUtil.increment();
			attactFileDocument.setAttactFileDocumentId(attactFileDocumentId);
			attactFileDocument.setDocumentManagerId(documentManagerId);
			
			User user = UserLocalServiceUtil.getUser(userId);
			String userName = user.getScreenName();
			attactFileDocument.setAttactFileDocumentPath("/upload" + "/" + fileName);
			String fullTitle = titleFile + "_" + userName + "_" + dateValue;
			attactFileDocument.setAttactFileDocumentTitle(fullTitle);
			
			AttactFileDocumentLocalServiceUtil.addAttactFileDocument(attactFileDocument);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD uploadFile OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void editDocumentManager(ActionRequest req) {
		long documentManagerId = ParamUtil.getLong(req, "documentManagerId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0){
				DocumentManager documentManager = DocumentManagerLocalServiceUtil.getDocumentManager(documentManagerId);
				req.setAttribute("documentManager", documentManager);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editDocumentManager OF " + ViewAction.class + " " + e.getMessage());
		}	
	}
	
	public void updateDocumentManager(ActionRequest req, ActionResponse res) throws SystemException, PortalException, IOException {
		try {
			long documentManagerId = ParamUtil.getLong(req, "documentManagerId");
			String documentManagerCode = ParamUtil.getString(req, "documentManagerCode");
			String documentManagerCategory = ParamUtil.getString(req, "documentManagerCategory");
			String documentManagerDescription = ParamUtil.getString(req, "documentManagerDescription");
			String documentManagerStyle = ParamUtil.getString(req, "documentManagerStyle");
			
			String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
			nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
			String titleFiles  = ParamUtil.getString(req, "titleFiles");
			titleFiles = StringUtil.encodeHtml(titleFiles);
			
			long userId = PortalUtil.getUserId(req);
			if(userId != 0){
				DocumentManager documentManager = DocumentManagerLocalServiceUtil.getDocumentManager(documentManagerId);
				documentManager.setDocumentManagerCode(documentManagerCode);
				documentManager.setDocumentManagerCategory(documentManagerCategory);
				documentManager.setDocumentManagerDescription(documentManagerDescription);
				documentManager.setUserId(userId);
				if(documentManagerStyle.equals("send")){
					documentManager.setDocumentManagerStyle("send");
				}else{
					documentManager.setDocumentManagerStyle("received");
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
					String documentManagerTitles = "";
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						documentManagerTitles += titleFilesArr[i];
						uploadFile(req, documentManagerId, userId, nameFieldRowArr[i], titleFilesArr[i]);
					}
					documentManager.setDocumentManagerTitle(documentManagerTitles);
				}
				DocumentManagerLocalServiceUtil.updateDocumentManager(documentManager);
			}	
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateDocumentManager OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void deleteDocumentManager(ActionRequest req, ActionResponse res, String redirect) {
		long documentManagerId = ParamUtil.getLong(req, "documentManagerId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0 && documentManagerId > 0){
				List<AttactFileDocument> attactFileDocuments = DocumentManagerLocalServiceUtil.getAttactFileDocuments(documentManagerId);
				String pathFile = getServlet().getServletContext().getRealPath("/");
				if(attactFileDocuments.size() > 0){
					for(AttactFileDocument attactFileDocument : attactFileDocuments){
						AttactFileDocumentLocalServiceUtil.deleteAttactFileDocument(attactFileDocument);
						String fileName = attactFileDocument.getAttactFileDocumentPath();
						String pathServer = pathFile + fileName;
						File file = new File(pathServer);
						file.delete();
					}
				}
				DocumentManagerLocalServiceUtil.deleteDocumentManager(documentManagerId);
			}
		} catch (Exception e) {
			//_log.error("ERROR IN METHOD deleteDocumentManager OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void deleteAttactFileDocument(ActionRequest req) {
		try {
			long attactFileDocumentId = ParamUtil.getLong(req,"attactFileDocumentId");
			AttactFileDocumentLocalServiceUtil.deleteAttactFileDocument(attactFileDocumentId);
			editDocumentManager(req);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteAttactFileDocument OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.document_manager.view");
		}	
	}
}
