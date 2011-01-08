/**
 * Lay du lieu tu form update, dung service cap nhat du lieu xuong he thong
 * Khai bao bien updateMessage.
 * Neu cap nhat thanh cong updateMessage = "success"
 * Neu cap nhat that bai updateMessage = "fail"
 * 
 * Sau khi cap nhat tra ve trang hien chi tiet cong van (detail.jsp)
 */
package com.sgs.portlet.document.sendprocess.action;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
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
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.util.DocumentSendUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author doanhdv
 *
 */
public class UpdateAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(UpdateAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		updateDocumentSend(req,res);
		res.sendRedirect(req.getParameter("redirect"));
	}
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		//load cac danh muc dung chung cho cac select box
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				_log.info("----------update----------");
				return mapping.findForward("portlet.sgs.document.sendprocess.detail");
			}
	}
	
	private void updateDocumentSend(ActionRequest req, ActionResponse res) {
		// TODO Auto-generated method stub
		_log.info("=================create return document action=============");
		//so cong van
		//ngay ky
		//long signerId = ParamUtil.getLong(req, "signerId"); //nguoi ky
		long documentSendId = ParamUtil.getLong(req, "documentSendId"); //id
		String privilegeLevelId = ParamUtil.getString(req, "privilegeLevelId"); //do khan
		String receivingPlace = ParamUtil.getString(req, "receivingPlace");//noi goi
		String briefContent = ParamUtil.getString(req, "briefContent");//trich yeu
		boolean isLocalBoolean = ParamUtil.getBoolean(req, "isLocal", false);//cong van noi bo
//		String isLocal = Constants.IS_LOCAL;
//		
//		if(!isLocalBoolean) {
//			isLocal = Constants.IS_NOT_LOCAL;
//		}
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");//loai cong van
		long editorId = ParamUtil.getLong(req, "editorId");//nguoi soan thao
		String documentReference = ParamUtil.getString(req, "documentReference");//so hieu cong van di
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");//do mat
		
		PmlEdmDocumentSend documentSend = new PmlEdmDocumentSendImpl();
		//documentSend.setSignerId(signerId);
		try {
			documentSend.setDocumentSendId(CounterServiceUtil.increment());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		documentSend.setDocumentSendId(documentSendId);
		documentSend.setPrivilegeLevelId(privilegeLevelId);
		documentSend.setReceivingPlace(receivingPlace);
		documentSend.setBriefContent(briefContent);
		documentSend.setIsLocal(isLocalBoolean);
		documentSend.setDocumentTypeId(documentTypeId);
		documentSend.setEditorId(editorId);
		documentSend.setDocumentReference(documentReference);
		documentSend.setConfidentialLevelId(confidentialLevelId);
		
		String addResult = "";
		
		
		// upload file
		
		
		String manyFile = ParamUtil.getString(req, "manyFile", null);
		String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
		String titleManyFile = ParamUtil.getString(req, "titleManyFile", null);
		if (manyFile != null && !manyFile .equals("") ) {
			String[] manyFileArr = manyFile.split("_");
			String[] valueManyFileArr = valueManyFile.split("/");
			String[] titleManyFileArr = titleManyFile.split("#");
			for (int i = 0; i < manyFileArr.length; i++) {
			
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
				File myFile = uploadRequest.getFile(manyFileArr[i]);
				System.out.println(myFile);
				String fileName = com.sgs.portlet.document.receipt.util.Constants.getDateTime()+valueManyFileArr[i];
				System.out.println(manyFileArr[i]);
				System.out.println(fileName+"--------------------------------");
				String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
				File destFile = new File(patthFile + "/" + fileName);
				if (!(new File(patthFile)).exists()) {
					(new File(patthFile)).mkdir();
				}
	
				try {
					FileUtils.copyFile(myFile, destFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
				try {
					attachedFile.setAttachedFileId(CounterServiceUtil.increment());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				attachedFile.setObjectContentId(documentSend.getDocumentSendId());
				attachedFile.setObjectType(documentSend.getClass().getName());
				attachedFile.setAttachedFileName(fileName);
				attachedFile.setPath("/upload" + "/" + fileName);
				attachedFile.setDateCreated(new Date());
				
				//kiem tra file co ten mo rong hay khong
				if (fileName.indexOf(".") != -1) {
					attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
				}
				
				//kiem tra file dinh kem co title hay khong
				String title = "";
				try {
					title = titleManyFileArr[i];
				} catch (ArrayIndexOutOfBoundsException e) {
					title = "";
				}
				
				attachedFile.setTitle(title);
					
				try {
					PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//delete file upload
		try {
			
			String manyDeleteFile = ParamUtil.getString(req, "manyDeleteFile", null);
			if (manyDeleteFile != null && !manyDeleteFile .equals("") ) {
				System.out.println("-------------------------" + manyDeleteFile);
				String[] manyDeleteFileArr = manyDeleteFile.split("#");
				for (int i = 0; i < manyDeleteFileArr.length; i++) {
					String path = getServlet().getServletContext().getRealPath("/");
					File file = new File(path  + manyDeleteFileArr[i].substring(1));
					System.out.println(file.exists());
					if (file.exists()) {
						file.delete();
						PmlEdmAttachedFile pmlEdmAttachedFile = PmlEdmAttachedFileUtil.findByPath(manyDeleteFileArr[i]).get(0);
						PmlEdmAttachedFileUtil.remove(pmlEdmAttachedFile);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			documentSend = PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(documentSend);
			addResult = "success";
		} catch (SystemException e) {
			addResult = "fail";
		}
		
		PmlEdmDocumentSendDTO documentSendDTO = DocumentSendUtil.getDocDTOFormDocSend(documentSend);
		req.setAttribute("documentSendDTO", documentSendDTO);
		req.setAttribute("addResult", addResult);
	}
}
