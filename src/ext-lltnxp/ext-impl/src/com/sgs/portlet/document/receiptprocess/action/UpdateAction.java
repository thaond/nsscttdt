/**
 *
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.io.File;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;

/**
 * @author doanhdv
 *
 */
public class UpdateAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/* call update method to update document */
		updateDocument(req,res);
		
		/* after update system is redirected to view.jsp */
		res.sendRedirect(req.getParameter("redirect"));
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		return null;
	}
	
	/**
	 * Update document. Id of this document is send in request. 
	 * 
	 * @param req ActionRequest
	 * @param res ActionRespose
	 */
	private void updateDocument(ActionRequest req, ActionResponse res) {
		long documentReceiptId = 
			Long.parseLong(ParamUtil.getString(req, "documentReceiptId"));
		PmlEdmDocumentReceipt documentReceipt = null;
		try {
			documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		String documentReference = ParamUtil.getString(req, "arrivingDocumentReference");
		int levelSendId = ParamUtil.getInteger(req, "documentSenderLevelRank");
		String numberLocalDocumentReceipt = ParamUtil.getString(req, "localDocumentReference");
		long documentTypeId = ParamUtil.getInteger(req, "docementType");
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlace");
		String privilegeLevelId = ParamUtil.getString(req, "priviledgeLevel");
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/mm/yyyy"), null);
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevel");
		String signer = ParamUtil.getString(req, "signer");
		String briefContent = ParamUtil.getString(req, "briefContent");
		Date dateArrive = ParamUtil.getDate(req, "arrivingDate", new SimpleDateFormat("dd/mm/yyyy"), null);
		int processTime = ParamUtil.getInteger(req, "totalExecutionDate");
		String isPublic = ParamUtil.getString(req, "localDocuments");
		
		/* set data into document receipt */
		documentReceipt = setDataIntoDocumentReceipt(documentReceipt,
			documentReference, numberLocalDocumentReceipt, issuingPlaceId,
			issuingDate, signer, dateArrive, processTime, isPublic, levelSendId,
			documentTypeId, confidentialLevelId, privilegeLevelId, briefContent);
		
		/* upload attached file */
		try{
			/*
			 * get params in request as: manyFile, valueManyFile, titleManyFile
			 */
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
					
					String fileName = 
						com.sgs.portlet.document.receipt.util.Constants.getDateTime() 
							+ valueManyFileArr[i];
					
					String patthFile = getServlet().getServletContext().getRealPath("/") + "upload";
					File destFile = new File(patthFile + "/" + fileName);
					if (!(new File(patthFile)).exists()) {
						(new File(patthFile)).mkdir();
					}
		
					FileUtils.copyFile(myFile, destFile);
				
					PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
					attachedFile = setDataIntoAttachedFile(attachedFile,
						documentReceipt, fileName, titleManyFileArr[i]);
					PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String manyDeleteFile = ParamUtil.getString(req, "manyDeleteFile", null);
			if (manyDeleteFile != null && !manyDeleteFile .equals("") ) {
				String[] manyDeleteFileArr = manyDeleteFile.split("#");
				for (int i = 0; i < manyDeleteFileArr.length; i++) {
					String path = getServlet().getServletContext().getRealPath("/");
					File file = new File(path  + manyDeleteFileArr[i].substring(1));
					System.out.println(file.exists());
					if (file.exists()) {
						file.delete();
						PmlEdmAttachedFile pmlEdmAttachedFile = 
							PmlEdmAttachedFileUtil.findByPath(
								manyDeleteFileArr[i]).get(0);
						PmlEdmAttachedFileUtil.remove(pmlEdmAttachedFile);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set data into attached file
	 * @param attachedFile
	 * @param documentReceipt
	 * @param fileName
	 * @param titleManyFileArr
	 * @return PmlEdmAttachedFile object
	 * @throws RemoteException
	 * @throws SystemException
	 */
	private PmlEdmAttachedFile setDataIntoAttachedFile(
		PmlEdmAttachedFile attachedFile, PmlEdmDocumentReceipt documentReceipt,
		String fileName, String titleManyFileArr) 
		throws RemoteException, SystemException {
		
		attachedFile.setAttachedFileId(CounterServiceUtil.increment());
		attachedFile.setObjectContentId(documentReceipt.getDocumentReceiptId());
		attachedFile.setObjectType(documentReceipt.getClass().getName());
		attachedFile.setAttachedFileName(fileName);
		attachedFile.setPath("/upload" + "/" + fileName);
		attachedFile.setDateCreated(new Date());
		attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
		attachedFile.setTitle(titleManyFileArr);
		return attachedFile;
	}

	/**
	 * Set data into document receipt
	 * @param documentReceipt
	 * @param documentReference
	 * @param numberLocalDocumentReceipt
	 * @param issuingPlaceId
	 * @param issuingDate
	 * @param signer
	 * @param dateArrive
	 * @param processTime
	 * @param isPublic
	 * @param levelSendId
	 * @param documentTypeId
	 * @param confidentialLevelId
	 * @param privilegeLevelId
	 * @param briefContent
	 * @return PmlEdmDocumentReceipt object
	 */
	private PmlEdmDocumentReceipt setDataIntoDocumentReceipt(
		PmlEdmDocumentReceipt documentReceipt, String documentReference,
		String numberLocalDocumentReceipt, String issuingPlaceId,
		Date issuingDate, String signer, Date dateArrive, int processTime,
		String isPublic, int levelSendId, long documentTypeId,
		String confidentialLevelId, String privilegeLevelId, String briefContent) {

		documentReceipt.setDocumentReference(documentReference); //so hieu cong van den
		documentReceipt.setNumberLocalDocumentReceipt(numberLocalDocumentReceipt); //So cong van noi bo
		documentReceipt.setIssuingPlaceId(issuingPlaceId); //co quan phat hanh
		documentReceipt.setIssuingDate(issuingDate); //ngay phat hanh
		documentReceipt.setSigner(signer); //nguoi ky
		documentReceipt.setDateArrive(dateArrive); //ngay den
		documentReceipt.setProcessTime(processTime); //so ngay xu ly
		documentReceipt.setIsPublic(isPublic); 
		documentReceipt.setLevelSendId(levelSendId); //cap goi
		documentReceipt.setDocumentTypeId(documentTypeId); //loai cong van
		documentReceipt.setConfidentialLevelId(confidentialLevelId); //do mat
		documentReceipt.setPrivilegeLevelId(privilegeLevelId); //do khan
		documentReceipt.setBriefContent(briefContent); //trich yeu
		
		return documentReceipt;
	}
}
