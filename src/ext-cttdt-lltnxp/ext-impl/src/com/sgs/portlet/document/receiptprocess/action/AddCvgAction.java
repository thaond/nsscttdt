/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

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

import com.ext.portlet.util.Constants;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * This class is used to create a new sendDocument for a receiveDocument.
 * 
 * @version 1.7 10 Apr 2009
 * @author doanhdv
 * @author kienbqc
 *
 */
public class AddCvgAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(AddCvgAction.class);
	
	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		createDocumentReturn(req, res);
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		return null;
	}
	
	/**
	 * <p>
	 * This method use to create return document, mean that answer the document
	 * receipt.
	 * </p>
	 * 
	 * <p>
	 *  - Get parameter.
	 *  - Generate documentSendId.
	 *  - Set data into documentSend object.
	 *  - Use addPmlEdmDocumentSend method of 
	 * PmlEdmDocumentSendLocalServiceUtil to create a new send document
	 * in system.
	 * <p>
	 * @param req ActionRequest
	 * @param res ActionRespose
	 */
	private void createDocumentReturn(ActionRequest req, ActionResponse res) {
		String addResult = "";

		try {
			_log.info("=================create return document action=============");
			
			/* do khan */
			String privilegeLevelId = ParamUtil.getString(req, "privilegeLevelId");
			
			/* noi goi */
			String receivingPlace = ParamUtil.getString(req, "receivingPlace");
			
			/* trich yeu */
			String briefContent = ParamUtil.getString(req, "briefContent");
			
			/* la cong van noi bo hay khong */
			boolean isLocal = ParamUtil.getBoolean(req, "isLocal", false);
			//boolean isLocal = setNumberForIsLocal(isLocalBoolean);
			
			/* loai cong van */
			long documentTypeId = ParamUtil.getLong(req, "documentTypeId");
			
			/* nguoi soan thao */
			long editorId = ParamUtil.getLong(req, "editorId");
			
			/* so hieu cong van di */
			String documentReference = ParamUtil.getString(req,	"documentReference");
			
			/* do mat */
			String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");
			
			/* luu cong van */ 
			PmlEdmDocumentSend documentSend = new PmlEdmDocumentSendImpl();
			
			/* 
			 * get auto increment id from service of liray that is 
			 * CounterServiceUtil
			 */
			long documentSendId = CounterServiceUtil.increment();
			
			/* set data into documentSend object */
			documentSend = setDataIntoDocumentSend(documentSend, documentSendId, 
				privilegeLevelId, receivingPlace, briefContent, isLocal,
				documentTypeId, editorId, documentReference, confidentialLevelId);
			
			/*
			 * It use addPmlEdmDocumentSend method of 
			 * PmlEdmDocumentSendLocalServiceUtil to create a new send document
			 * in system.
			 */
			PmlEdmDocumentSendLocalServiceUtil
					.addPmlEdmDocumentSend(documentSend);
			
			/* add parameter for workflow service */
			addWorkflowParameter(req, "documentSendId", WorkflowParam.TRANSIENT, String.valueOf(documentSend.getDocumentSendId()));
			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));

			/* upload file */
			uploadFile(req, res, documentSend);
						
			/* luu quan he cong van den - cong van tra loi */
			long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
			
			PmlEdmAnswerDetail pmlEdmAnswerDetail = new PmlEdmAnswerDetailImpl();
			pmlEdmAnswerDetail.setDocumentReceiptId(documentReceiptId);
			pmlEdmAnswerDetail.setDocumentSendId(documentSendId);
			
			/*
			 * Use addPmlEdmAnswerDetail method of
			 * PmlEdmAnswerDetailLocalServiceUtil class to add 
			 * a pmdEdmAnswerDetail that is concern between receive document
			 * and send document
			 */
			PmlEdmAnswerDetailLocalServiceUtil.addPmlEdmAnswerDetail(pmlEdmAnswerDetail);
			
			addResult = "success";
			
		} catch (IOException e2) {
			addResult = "fail";
		} catch (SystemException e) {
			addResult = "fail";
		}

		req.setAttribute("addResult", addResult);
	}

	/**
	 * This method is used to upload file from client.
	 * File upload is saved in [hostname]/upload directory
	 * @param req action request
	 * @param res action respose
	 * @param documentSend PmlEmlDocumentSend object
	 * @throws IOException
	 * @throws SystemException
	 */
	private void uploadFile(ActionRequest req, ActionResponse res, 
		PmlEdmDocumentSend documentSend) throws IOException, SystemException {
		
		String manyFile = ParamUtil.getString(req, "manyFile", null);
		String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
		
		if (manyFile != null && !manyFile .equals("") ) {
			String[] manyFileArr = manyFile.split("_");
			String[] valueManyFileArr = valueManyFile.split("/");
			
			if (manyFileArr.length != 0) {
				if (valueManyFileArr.length != 0) {
					
					for (int i = 0; i < manyFileArr.length; i++) {
					
						UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
						File myFile = uploadRequest.getFile(manyFileArr[i]);
						
						String fileName = valueManyFileArr[i];

						File destFile = new File(getServlet().getServletContext()
								.getRealPath("/")
								+ "upload" + "/" + fileName);
						
						/*
						 * If upload directory don't exists,
						 * create upload directory
						 */
						if (!(new File(getServlet().getServletContext().getRealPath("/")
								+ "upload")).exists()) {
							(new File(getServlet().getServletContext().getRealPath("/")
									+ "upload")).mkdir();
						}

						/* copy file to server from client */
						FileUtils.copyFile(myFile, destFile);

						PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();

						/* set data for attachedFile object */
						attachedFile = setDataForAttachedFile(attachedFile, documentSend,
							fileName);

						/* 
						 * Use addPmdEdmAttachedFile method of 
						 * PmlEdmAttachedFileLocalServiceUtil class to 
						 * add attached file into system  
						 */
						PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
						
					}
				}
			}
		}

	}

	/**
	 * This method is used to set number for isLocal.
	 * @param isLocalBoolean
	 * @return Return "1" if isLocalBoolean is true. <br> 
	 * 		   Return "0" if isLocalBoolean is fail
	 */
	private boolean setNumberForIsLocal(boolean isLocalBoolean) {
		boolean isLocal = false;
		if (isLocalBoolean) {
			isLocal = true;
		} else {
			isLocal = false;
		}
		
		return isLocal;
	}

	/**
	 * This method is used to set data for attached file object
	 * @param attachedFile
	 * @param documentSend
	 * @param fileName
	 * @return PmlEdmAttachedFile object
	 * @throws MalformedURLException
	 */
	private PmlEdmAttachedFile setDataForAttachedFile(
		PmlEdmAttachedFile attachedFile, PmlEdmDocumentSend documentSend,
		String fileName) throws MalformedURLException {

		attachedFile.setObjectContentId(documentSend.getDocumentSendId());
		attachedFile.setObjectType(Constants.OBJECT_TYPE_DOCUMENT_SEND);
		attachedFile.setAttachedFileName(fileName);
		attachedFile.setPath(getServlet().getServletContext().getResource("/").toString() + "upload" + "/" + fileName);
		attachedFile.setDateCreated(new Date());
		attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
		
		return attachedFile;
	}

	/**
	 * This method is used to set data into documentSend object
	 * @param documentSend
	 * @param documentSendId
	 * @param privilegeLevelId
	 * @param receivingPlace
	 * @param briefContent
	 * @param isLocal
	 * @param documentTypeId
	 * @param editorId
	 * @param documentReference
	 * @param confidentialLevelId
	 * @return PmlEdmDocumentSend object
	 */
	private PmlEdmDocumentSend setDataIntoDocumentSend(
		PmlEdmDocumentSend documentSend, long documentSendId,
		String privilegeLevelId, String receivingPlace, String briefContent,
		boolean isLocal, long documentTypeId, long editorId,
		String documentReference, String confidentialLevelId) {

		documentSend.setDocumentSendId(documentSendId);
		documentSend.setPrivilegeLevelId(privilegeLevelId);
		documentSend.setReceivingPlace(receivingPlace);
		documentSend.setBriefContent(briefContent);
		documentSend.setIsLocal(isLocal);
		documentSend.setDocumentTypeId(documentTypeId);
		documentSend.setEditorId(editorId);
		documentSend.setDocumentReference(documentReference);
		documentSend.setConfidentialLevelId(confidentialLevelId);
		documentSend.setActive(Constants.ACTIVE);
		
		return documentSend;
	}
}
