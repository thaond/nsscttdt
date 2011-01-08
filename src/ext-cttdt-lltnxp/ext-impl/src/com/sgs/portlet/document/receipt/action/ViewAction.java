/**
 * 
 */
package com.sgs.portlet.document.receipt.action;

import java.io.File;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
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

import com.ext.portlet.util.Constants;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;

/**
 * This class is used to prepare data for add receipt document form and to
 * create new receipt document.
 * @version 1.20 10 Apr 2009
 * @author kienbqc
 *
 */
public class ViewAction extends DocumentReceiptPortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	/**
	 * create new receipt document
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		createDocument(req,res);
	}
	
	/**
	 * prepare data for add receipt document form
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
			// get list records for selected boxes
				List<PmlEdmLevelSend> levelSends = PmlEdmLevelSendUtil.findAll();
				List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil.findAll();
				List<PmlEdmPrivilegeLevel> documentPrivilegeLevels = PmlEdmPrivilegeLevelUtil.findAll();
				List<PmlEdmConfidentialLevel> documentConfidentialLevels = PmlEdmConfidentialLevelUtil.findAll();
				List<PmlEdmIssuingPlace> issuingPlaces = PmlEdmIssuingPlaceUtil.findAll();
				
			//set list records for render request
				req.setAttribute("levelSends", levelSends);
				req.setAttribute("documentTypes", documentTypes);
				req.setAttribute("privilegeLevels", documentPrivilegeLevels);
				req.setAttribute("confidentialLevels", documentConfidentialLevels);
				req.setAttribute("issuingPlaces", issuingPlaces);
				
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.document.receipt.view");
			}
	}
	
	/**
	 * this method use to create a new document and persist.
	 * @param req
	 * @param res
	 */
	private void createDocument(ActionRequest req, ActionResponse res) {
		String documentReference = ParamUtil.getString(req, "arrivingDocumentReference");
		int levelSendId = ParamUtil.getInteger(req, "documentSenderLevelRank");
		String numberLocalDocumentReceipt = ParamUtil.getString(req, "localDocumentReference");
		long documentTypeId = ParamUtil.getInteger(req, "docementType");
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlace");
		String privilegeLevelId = ParamUtil.getString(req, "priviledgeLevel");
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevel");
		String signer = ParamUtil.getString(req, "signer");
		String briefContent = ParamUtil.getString(req, "briefContent");
		Date dateArrive = ParamUtil.getDate(req, "arrivingDate", new SimpleDateFormat("dd/MM/yyyy"), null);
		int processTime = ParamUtil.getInteger(req, "totalExecutionDate");
		boolean isPublic = ParamUtil.getBoolean(req, "localDocuments", false);

		PmlEdmDocumentReceipt documentReceipt = new PmlEdmDocumentReceiptImpl();
		long documentReceiptId = 0;

		try {
//			documentReceiptId = CounterLocalServiceUtil.increment();
//			documentReceipt = setDataIntoDocumentReceipt(documentReceipt, documentReceiptId, documentReceiptId, 
//				documentReference, numberLocalDocumentReceipt, issuingPlaceId,
//				issuingDate, signer, dateArrive, processTime, isPublic, levelSendId,
//				documentTypeId, confidentialLevelId, privilegeLevelId, briefContent);
		
			//canh update
			User user = PortalUtil.getUser(req);
			documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.addPmlEdmDocumentReceipt(
					user.getCompanyId(), documentReference, numberLocalDocumentReceipt, issuingPlaceId, 
					issuingDate, signer, dateArrive, processTime, isPublic, levelSendId, documentTypeId, 
					confidentialLevelId, privilegeLevelId, briefContent);
			documentReceiptId = documentReceipt.getDocumentReceiptId();
			//end of canh
	
			// upload file
			String manyFile = ParamUtil.getString(req, "manyFile", null);
			String valueManyFile = ParamUtil.getString(req, "valueManyFile", null);
			String titleManyFile = ParamUtil.getString(req, "titleManyFile", null);
			
			_log.info(manyFile +"----------------------------------------------------------------");
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
					attachedFile = setDataIntoAttachedFile(attachedFile, documentReceipt,
						fileName, titleManyFileArr[i]);
					
					PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
				}
			} 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
			
			//vao so cong van cho so
			
			int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(PortalUtil.getUserId(req));
			String yearInUse = String.valueOf(dateArrive.getYear() + 1900);
			
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(departmentId);
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
			
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = 
				PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearInUse, agencyId, documentRecordTypeId);
			
			if (pmlEdmDocumentRecordTo != null) {
				if (pmlEdmDocumentRecordTo.getAgencyId() != null && pmlEdmDocumentRecordTo.getYearInUse() != null){
					PmlEdmBookDocumentRecordTo bookDocumentRecordTo = new PmlEdmBookDocumentRecordToImpl();
					
					bookDocumentRecordTo = setDataIntoBookDocumentRecordTo(bookDocumentRecordTo,
						documentReceiptId, pmlEdmDocumentRecordTo, dateArrive);
						
					PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
				}
					
			} else {
				try {
					PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(documentReceiptId);
					return ;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
			addWorkflowParameter(req, "documentReceiptId", WorkflowParam.TRANSIENT, "" + documentReceipt.getDocumentReceiptId());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set data into bookDocumentRecordTo object
	 * @param bookDocumentRecordTo
	 * @param documentReceiptId
	 * @param pmlEdmDocumentRecordTo
	 * @param dateArrive
	 */
	private PmlEdmBookDocumentRecordTo setDataIntoBookDocumentRecordTo(
		PmlEdmBookDocumentRecordTo bookDocumentRecordTo,
		long documentReceiptId, PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
		Date dateArrive) {

		bookDocumentRecordTo.setDocumentReceiptId(documentReceiptId);
		bookDocumentRecordTo.setDocumentRecordToId(pmlEdmDocumentRecordTo.getDocumentRecordToId());
		bookDocumentRecordTo.setDateCreate(dateArrive);
		
		return bookDocumentRecordTo;
	}

	/**
	 * set data into attachedFile object
	 * @param attachedFile
	 * @param documentReceipt
	 * @param fileName
	 * @param titleManyFileArr
	 * @throws RemoteException
	 * @throws SystemException
	 */
	private PmlEdmAttachedFile setDataIntoAttachedFile(
		PmlEdmAttachedFile attachedFile, PmlEdmDocumentReceipt documentReceipt,
		String fileName, String titleManyFileArr) throws RemoteException, SystemException {

		attachedFile.setAttachedFileId(CounterServiceUtil.increment());
		attachedFile.setObjectContentId(documentReceipt.getDocumentReceiptId());
		attachedFile.setObjectType(documentReceipt.getClass().getName());
		attachedFile.setAttachedFileName(fileName);
		attachedFile.setPath("/upload" + "/" + fileName);
		attachedFile.setDateCreated(new Date());
		if (fileName.indexOf(".") != -1) {
			attachedFile.setFileType(fileName.substring(fileName.indexOf(".")+1));
		}
		
		String title = "";
		try {
			title = titleManyFileArr;
		} catch (ArrayIndexOutOfBoundsException e) {
			title = "";
		}
		attachedFile.setTitle(title);
		
		return attachedFile;
	}

	/**
	 * set data into documentReceipt object
	 * @param documentReceipt
	 * @param documentReceiptId
	 * @param documentReceiptId2
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
	 */
	private PmlEdmDocumentReceipt setDataIntoDocumentReceipt(
		PmlEdmDocumentReceipt documentReceipt, long documentReceiptId,
		long documentReceiptId2, String documentReference,
		String numberLocalDocumentReceipt, String issuingPlaceId,
		Date issuingDate, String signer, Date dateArrive, int processTime,
		boolean isPublic, int levelSendId, long documentTypeId,
		String confidentialLevelId, String privilegeLevelId, String briefContent) {

		documentReceipt.setDocumentReceiptId(documentReceiptId);
		documentReceipt.setDocumentReference(documentReference); //so hieu cong van den
		documentReceipt.setNumberLocalDocumentReceipt(numberLocalDocumentReceipt); //So cong van noi bo
		documentReceipt.setIssuingPlaceId(issuingPlaceId); //co quan phat hanh
		documentReceipt.setIssuingDate(issuingDate); //ngay phat hanh
		documentReceipt.setSigner(signer); //nguoi ky
		documentReceipt.setDateArrive(dateArrive); //ngay den
		documentReceipt.setProcessTime(processTime); //so ngay xu ly
		documentReceipt.setIsPublic(isPublic ? "1" : "0");
		documentReceipt.setLevelSendId(levelSendId); //cap goi
		documentReceipt.setDocumentTypeId(documentTypeId); //loai cong van
		documentReceipt.setConfidentialLevelId(confidentialLevelId); //do mat
		documentReceipt.setPrivilegeLevelId(privilegeLevelId); //do khan
		documentReceipt.setBriefContent(briefContent); //trich yeu
		documentReceipt.setActive(Constants.ACTIVE);
		
		return documentReceipt;
	}

}
