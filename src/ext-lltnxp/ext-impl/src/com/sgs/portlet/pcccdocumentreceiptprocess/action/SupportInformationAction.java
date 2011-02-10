/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author hieuvh
 *
 */
public class SupportInformationAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(SupportInformationAction.class);
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		addWorkflowParameter(req, "processInformation", WorkflowParam.TRANSIENT, ParamUtil.getString(req, "processInformation"));
		
//		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		
		// vu update 20110112
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		else {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(userIdXLT));
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		
		// end vu update
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", 0);
		
		String manyFile = ParamUtil.getString(req, "manyFile", null);
		//String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
		String titleManyFile = ParamUtil.getString(req, "titleManyFile", null);
		
		try{
//		List<PmlDocumentReceiptWF> listPmlDocumentReceiptWF =  PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		
//		if (listPmlDocumentReceiptWF != null) {
//			for (Iterator iterator = listPmlDocumentReceiptWF.iterator(); iterator.hasNext();) {
//				PmlDocumentReceiptWF pmlDocumentReceiptWF = (PmlDocumentReceiptWF) iterator	.next();
//				
//				if(pmlDocumentReceiptWF != null){
//					
//					long processId = pmlDocumentReceiptWF.getProcessId();
//					
//					List<PmlMainSupport> listPmlMainSupport =  PmlMainSupportUtil.findByProcessIdMain(processId);
//					
//					if (listPmlMainSupport != null) {
//						for (Iterator iterator2 = listPmlMainSupport.iterator(); iterator2.hasNext();) {
//							PmlMainSupport pmlMainSupport = (PmlMainSupport) iterator2.next();
//							
//							if (pmlMainSupport != null && DocumentReceiptLiferayWorkflowService.TYPE_PB.equalsIgnoreCase(pmlMainSupport.getType_()) ) {
//								
//								if (manyFile != null && !manyFile .equals("") ) {
//										String[] nameFieldRowArr = manyFile.split("_");
//										
//										String[] titleFilesArr = titleManyFile.split("#");
//										if (titleFilesArr.length == 0) {
//											titleFilesArr = new String[nameFieldRowArr.length];
//											for (int i = 0; i < nameFieldRowArr.length; i++) {
//												titleFilesArr[i] = "";
//											}
//										}
//										for (int i = 0; i < nameFieldRowArr.length; i++) {
//											uploadFile(req, nameFieldRowArr[i],
//													documentReceipt, titleFilesArr[i]);
//										}
//									}
//									
//									
//									PortletSession session= req.getPortletSession();
//									session.setAttribute("transition", "save",PortletSession.APPLICATION_SCOPE);
//								} 
//							}
//						}
//					}
//					
//				}
//			}
		
			if (manyFile != null && !manyFile .equals("") ) {
				String[] nameFieldRowArr = manyFile.split("_");
				
				String[] titleFilesArr = titleManyFile.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String[nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFile(req, nameFieldRowArr[i],
							documentReceipt, titleFilesArr[i]);
				}
			}
			
			
			PortletSession session= req.getPortletSession();
			session.setAttribute("transition", "save",PortletSession.APPLICATION_SCOPE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void uploadFile(ActionRequest req, String nameFieldUpload, PmlEdmDocumentReceipt documentReceipt, String titleFile) {
		try {
			//save file upload into folder upload
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String fileName = com.sgs.portlet.document.receipt.util.Constants.getDateTime()+ fileNames;	
			String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
			File destFile = new File(patthFile + "/" + fileName);
			if (!(new File(patthFile)).exists()) {
				(new File(patthFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);
			
			// set value into attachedFile
			PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
			attachedFile.setAttachedFileId(CounterServiceUtil.increment());
			attachedFile.setObjectContentId(documentReceipt.getDocumentReceiptId());
			attachedFile.setObjectType(documentReceipt.getClass().getName());
			attachedFile.setAttachedFileName(fileName);
			attachedFile.setPath("/upload" + "/" + fileName);
			attachedFile.setDateCreated(new Date());
			if (fileName.lastIndexOf(".") != -1) {
				attachedFile.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
			}
			long userId = PortalUtil.getUser(req).getUserId();
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(userId);
			} catch (Exception e) {
				user = null;
			}
			
			String userName = "";
			if (user != null) { // Nguoi dung xac dinh
				userName = user.getScreenName();
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String datevalue = formatter.format(date.getTime());
			
			//attachedFile.setTitle(StringUtil.encodeHtml(titleFile));
			//set title dang title_screenname_ngay
			attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + datevalue));
			attachedFile.setDisplayOrHidden(true);
			//attachedFile.setTitle(titleFile);
			//persistence attachedFile into database
			PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		_log.info("Go To Give Support Information Form");
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.supportInformation");
		}
	}

}
