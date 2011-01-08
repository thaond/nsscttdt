/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
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
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlMainSupport;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.service.persistence.PmlMainSupportUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author hieuvh
 *
 */
public class SupportInformationAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(SupportInformationAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		addWorkflowParameter(req, "processInformation", WorkflowParam.TRANSIENT, ParamUtil.getString(req, "processInformation"));
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", 0);
		
		String manyFile = ParamUtil.getString(req, "manyFile", null);
		String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
		String titleManyFile = ParamUtil.getString(req, "titleManyFile", null);
		
		System.out.println("----------------------"+documentReceiptId +" "+manyFile+ " "+ valueManyFile + " "+ titleManyFile +"-----------------------");
		try{
		List<PmlDocumentReceiptWF> listPmlDocumentReceiptWF =  PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
		
		if (listPmlDocumentReceiptWF != null) {
			for (Iterator iterator = listPmlDocumentReceiptWF.iterator(); iterator.hasNext();) {
				PmlDocumentReceiptWF pmlDocumentReceiptWF = (PmlDocumentReceiptWF) iterator	.next();
				
				if(pmlDocumentReceiptWF != null){
					
					long processId = pmlDocumentReceiptWF.getProcessId();
					
					List<PmlMainSupport> listPmlMainSupport =  PmlMainSupportUtil.findByProcessIdMain(processId);
					
					if (listPmlMainSupport != null) {
						for (Iterator iterator2 = listPmlMainSupport.iterator(); iterator2.hasNext();) {
							PmlMainSupport pmlMainSupport = (PmlMainSupport) iterator2.next();
							
							if (pmlMainSupport != null && DocumentReceiptLiferayWorkflowService.TYPE_PB.equalsIgnoreCase(pmlMainSupport.getType_()) ) {
								
								if (manyFile != null && !manyFile .equals("") ) {
									String[] manyFileArr = manyFile.split("_");
									String[] valueManyFileArr = valueManyFile.split("/");
									String[] titleManyFileArr = titleManyFile.split("#");
									for (int i = 0; i < manyFileArr.length; i++) {
									
										UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
										File myFile = uploadRequest.getFile(manyFileArr[i]);
										
										String fileName = com.sgs.portlet.document.receipt.util.Constants.getDateTime()+valueManyFileArr[i];
										
										String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
										File destFile = new File(patthFile + "/" + fileName);
										if (!(new File(patthFile)).exists()) {
											(new File(patthFile)).mkdir();
										}
							
										FileUtils.copyFile(myFile, destFile);
									
										PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
										attachedFile.setAttachedFileId(CounterServiceUtil.increment());
										attachedFile.setObjectContentId(pmlMainSupport.getProcessId());
										attachedFile.setObjectType(pmlMainSupport.getClass().getName());
										attachedFile.setAttachedFileName(fileName);
										attachedFile.setPath("/upload" + "/" + fileName);
										attachedFile.setDateCreated(new Date());
										attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
										attachedFile.setTitle(titleManyFileArr[i]);
										PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
									}
								} 
							}
						}
					}
					
				}
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		_log.info("Go To Give Support Information Form");
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.document.receiptprocess.supportInformation");
		}
	}

}
