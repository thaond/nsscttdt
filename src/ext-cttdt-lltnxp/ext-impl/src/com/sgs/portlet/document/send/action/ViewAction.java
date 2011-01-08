package com.sgs.portlet.document.send.action;

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

import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * Prepare data for form add new send document
 * Save data when add a new send document
 * @author kienbqc
 *
 */
public class ViewAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		/* Add a new send document */
		createDocumentReturn(req, res);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		/* Get list of privilege level */
		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelUtil
				.findAll();
		
		/* Get list of document type */
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil
				.findAll();
		
		/* Get list of confidential level */
		List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelUtil
				.findAll();

		/*
		 * Set data into request:
		 * - privilegeLevels
		 * - documentTypes
		 * - confidentialLevels
		 */
		req.setAttribute("privilegeLevels", privilegeLevels);
		req.setAttribute("documentTypes", documentTypes);
		req.setAttribute("confidentialLevels", confidentialLevels);

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		} else {
			return mapping.findForward("portlet.sgs.document.send.view");
		}
	}

	/**
	 * this method use to create return document, mean that answer the document
	 * receipt
	 * 
	 * @param req
	 * @param res
	 */
	private void createDocumentReturn(ActionRequest req, ActionResponse res) {
		String addResult = "";

		try {

			_log.info("=================create return document action=============");
			
			/* get privilegeLevelId from request */
			String privilegeLevelId = ParamUtil.getString(req,
					"privilegeLevelId"); // do khan
			
			/* get receivingPlace from request */
			String receivingPlace = ParamUtil.getString(req, "receivingPlace");// noi goi
			
			/* get briefContent from request*/
			String briefContent = ParamUtil.getString(req, "briefContent");// trich yeu
			
			/* get isLocalBoolean from request */ 
			boolean isLocalBoolean = ParamUtil.getBoolean(req, "isLocal", false);// cong van noi
			
			/*
			 * set number for isLocal
			 * if isLocalBoolean is true, isLocal = "1"
			 * if isLocalBoolean is fail, isLocal = "0"
			 */
//			String isLocal = "";
//			if(isLocalBoolean) {
//				isLocal = "1";
//			} else {
//				isLocal = "0";
//			}
			
			/* Get documentTypeId from request */
			long documentTypeId = ParamUtil.getLong(req, "documentTypeId");// loai cong van
			
			/* Get editorId from request */
			long editorId = ParamUtil.getLong(req, "editorId");// nguoi soan thao
			
			/* Get documentReference from request */
			String documentReference = ParamUtil.getString(req,	"documentReference");// so hieu cong van di
			
			/* Get confidentialLevelId from request */
			String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");// do mat
			
			// Generate documentSendId by CounterServiceUtil.increment() 
			//long documentSendId = CounterServiceUtil.increment();
			
			Date dateCreated = new Timestamp( new Date().getTime());
			
			
/*			//  save documentSend down system 
*			 
*			// declare new documentSend object 
*			PmlEdmDocumentSend documentSend = new PmlEdmDocumentSendImpl();
*			
*			 set data into documentSend object 
*			 documentSend.setSignerId(signerId);
*			documentSend.setDocumentSendId(documentSendId);
*			documentSend.setBriefContent(briefContent);
*			documentSend.setDocumentReference(documentReference);
*			documentSend.setReceivingPlace(receivingPlace);
*			documentSend.setIssuingDate(new Timestamp( new Date().getTime()));
*			documentSend.setEditorId(editorId);
*			documentSend.setDocumentTypeId(documentTypeId);
*			documentSend.setPrivilegeLevelId(privilegeLevelId);
*			documentSend.setConfidentialLevelId(confidentialLevelId);
*			documentSend.setDateCreated(dateCreated);
*			documentSend.setIsLocal(isLocal);
*
*			 use service to create new documentSend in system 
*			documentSend = PmlEdmDocumentSendLocalServiceUtil
*					.addPmlEdmDocumentSend(documentSend);
*/
                        //canh edit
			User user = PortalUtil.getUser(req);
			long companyId = user.getCompanyId();
			PmlEdmDocumentSend documentSend = PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(companyId, briefContent, documentReference, receivingPlace, editorId, documentTypeId, privilegeLevelId, confidentialLevelId, dateCreated, isLocalBoolean);
			long documentSendId = documentSend.getDocumentSendId();
			
			//end of canh
			// vao so cong van cho phong
			String yearInUse = String.valueOf(dateCreated.getYear() + 1900);
			int documentRecordTypeId = PmlEdmBookDocumentSendLocalServiceUtil
				.getDocumentRecordTypeIdByDocumentType(documentTypeId);
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil
				.getDepartmentIdByUserId(PortalUtil.getUserId(req));
			
			PmlEdmBookDocumentSend bookDocumentSend =  
				PmlEdmBookDocumentSendLocalServiceUtil
					.getBookDocumentSend(
						yearInUse, departmentId, documentRecordTypeId);
			
			if (bookDocumentSend != null) {
				if (bookDocumentSend.getDepartmentsId() != null 
								&& bookDocumentSend.getYearInUse() != null) {
					PmlEdmWriteDocumentSend writeDocumentSend = 
						new PmlEdmWriteDocumentSendImpl();
					writeDocumentSend.setDocumentSendId(documentSendId);
					writeDocumentSend.setBookDocumentSendId(
						bookDocumentSend.getBookDocumentSendId());
					writeDocumentSend.setDateCreated(dateCreated);
					
					PmlEdmWriteDocumentSendLocalServiceUtil
						.updatePmlEdmWriteDocumentSend(writeDocumentSend);
				}
			} else {
				try {
					PmlEdmDocumentSendLocalServiceUtil
						.deletePmlEdmDocumentSend(documentSendId);
					return ;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			addWorkflowParameter(req, "documentSendId", WorkflowParam.TRANSIENT, String.valueOf(documentSend.getDocumentSendId()));
			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
			// upload file
			
			
			String manyFile = ParamUtil.getString(req, "manyFile", null);
			String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
			String titleManyFile = ParamUtil.getString(req, "titleManyFile", null);
			if (manyFile != null && !manyFile .equals("") ) {
				String[] manyFileArr = manyFile.split("_");
				String[] valueManyFileArr = valueManyFile.split("/");
				String[] titleManyFileArr = titleManyFile.split("#");
				for (int i = 0; i < manyFileArr.length; i++) {
				
					UploadPortletRequest uploadRequest = 
						PortalUtil.getUploadPortletRequest(req);
					File myFile = uploadRequest.getFile(manyFileArr[i]);
					
					String fileName = 
						com.sgs.portlet.document.receipt.util.Constants.getDateTime()
							+ valueManyFileArr[i];
					String patthFile = 
						getServlet().getServletContext().getRealPath("/") 
							+ "upload";
					File destFile = new File(patthFile + "/" + fileName);
					if (!(new File(patthFile)).exists()) {
						(new File(patthFile)).mkdir();
					}
		
					FileUtils.copyFile(myFile, destFile);
				
					PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
					attachedFile.setAttachedFileId(CounterServiceUtil.increment());
					attachedFile.setObjectContentId(documentSend.getDocumentSendId());
					attachedFile.setObjectType(documentSend.getClass().getName());
					attachedFile.setAttachedFileName(fileName);
					attachedFile.setPath("/upload" + "/" + fileName);
					attachedFile.setDateCreated(new Date());
					
					//neu file dinh kem co ten mo rong thi nhap ten mo rong vao database
					if (fileName.indexOf(".") != -1) {
						attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
					}
					
					//neu file dinh kem khong co title thi luu title la chuoi rong
					String title = "";
					try {
						title = titleManyFileArr[i];
					} catch (ArrayIndexOutOfBoundsException e) {
						title = "";
					}
					
					attachedFile.setTitle(title);
					
					PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
				}
			}
			
			addResult = "success";
			
		} catch (IOException e2) {
			addResult = "fail";
		} catch (SystemException e) {
			addResult = "fail";
                } catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("addResult", addResult);
	}

}
