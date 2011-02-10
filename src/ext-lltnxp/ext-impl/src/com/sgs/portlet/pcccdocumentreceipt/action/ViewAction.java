package com.sgs.portlet.pcccdocumentreceipt.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.Constants;
import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ViewAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String message = "";
		/* get all param in request */
		try {
			
		int documentRecordTypeId = ParamUtil.getInteger(req, "documentRecordTypeId",0);
		System.out.println("documentRecordTypeId "+ documentRecordTypeId);
		boolean privateDocument = ParamUtil.getBoolean(req, "privateDocument");
		String DocumentSendReference = ParamUtil.getString(req, "socongvandiphucdap");
		
		long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
		
		int levelSendId = ParamUtil.getInteger(req, "levelSendId");
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
		String issuingPlaceName = ParamUtil.getString(req, "issuingPlaceName", "");
		issuingPlaceName = StringUtil.encodeHtml(issuingPlaceName);
		String documentReference = ParamUtil.getString(req, "documentReference");
		documentReference = StringUtil.encodeHtml(documentReference);
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");	
		String signer = ParamUtil.getString(req, "signer");
		signer = StringUtil.encodeHtml(signer);
		String numberDocumentReceipt = ParamUtil.getString(req, "numberDocumentReceipt");
		String privilegenLevelId = ParamUtil.getString(req, "privilegenLevelId");
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");
		String briefContent = ParamUtil.getString(req, "briefContent");
		briefContent = StringUtil.encodeHtml(briefContent);
		
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		//xuancong close String nameFiles = ParamUtil.getString(req, "nameFiles");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		String thoigiannhancvden  = ParamUtil.getString(req, "dateArriveTime");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		String isPublic = ParamUtil.getString(req, "isPublic");
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/MM/yyyy"));
		Date dateArrive = ParamUtil.getDate(req, "dateArrive", new SimpleDateFormat("dd/MM/yyyy"));
		// So tong hop
		int generalOrderNo = PmlEdmDocumentReceiptLocalServiceUtil.getGeneralNumberDocumentReceipt(
				ParamUtil.getString(req, "dateArrive")) + 1;
		
		/* phmphuc close 13/01/2011 - khong cho phep edit so va ky hieu vb den
		// phmphuc add 05/01/2011
		boolean editNumber = ParamUtil.getBoolean(req, "editnumber");
		int phanSo = ParamUtil.getInteger(req, "phanSo");
		String phanMoRong = ParamUtil.getString(req, "phanMoRong");
		if (!editNumber) {
			numberDocumentReceipt = phanSo + phanMoRong;
			generalOrderNo = phanSo;
		} 
		*/
		numberDocumentReceipt = StringUtil.encodeHtml(numberDocumentReceipt);
		String donViSaoY = ParamUtil.getString(req, "donvisaoy");
		donViSaoY = StringUtil.encodeHtml(donViSaoY);

		// xuancong close long documentReceiptId = CounterLocalServiceUtil.increment();
		// Phat sinh loi trung id neu du lieu import bang tay ko qua liferay
		// Thay bang lay ma so lon nhat trong bang cong them 1
		long documentReceiptId = PmlEdmDocumentReceiptLocalServiceUtil.getMaxDocumentReceiptId() + 1;
		
		/*
		 * set attribute in documentReceipt object
		 */
		if (Validator.isNotNull(hosocongviecIdValues)) {
			PmlChiTietHSCV pmlChiTietHSCV = null;
			for (int i = 0; i < hosocongviecIdValues.length; i++) {
				pmlChiTietHSCV = new PmlChiTietHSCVImpl();
				pmlChiTietHSCV.setIdChiTietHSCV(CounterLocalServiceUtil.increment());
				pmlChiTietHSCV.setIdHoSoCongViec(hosocongviecIdValues[i]);
				pmlChiTietHSCV.setIdCongVanDen(documentReceiptId);
				PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
			}
		}
		
		PmlEdmDocumentReceipt documentReceipt = new PmlEdmDocumentReceiptImpl();
		documentReceipt.setDocumentReceiptId(documentReceiptId);
		documentReceipt.setLevelSendId(levelSendId);
		documentReceipt.setIssuingPlaceId(issuingPlaceId);
		documentReceipt.setDocumentReference(documentReference);
		documentReceipt.setDocumentTypeId(documentTypeId);
		documentReceipt.setSigner(signer);
		documentReceipt.setNumberDocumentReceipt(numberDocumentReceipt);
		documentReceipt.setPrivilegeLevelId(privilegenLevelId);
		documentReceipt.setConfidentialLevelId(confidentialLevelId);
		documentReceipt.setThoigiannhancvden(thoigiannhancvden);
		documentReceipt.setBriefContent(briefContent);
		documentReceipt.setIsPublic(isPublic);
		documentReceipt.setIssuingDate(issuingDate);
		documentReceipt.setDateArrive(dateArrive);
		documentReceipt.setIssuingPlaceOtherName(issuingPlaceName);
		documentReceipt.setDonViSaoY(donViSaoY); // phmphuc them
		documentReceipt.setDocumentRecordTypeId(documentRecordTypeId); // phmphuc them
		//documentReceipt.setIssuingPlaceOtherName(issuingPlaceName);
		//phan hard code so ngay
		//xuancong close, mac dinh khong dat thoi gian xu ly documentReceipt.setProcessTime(7);
		documentReceipt.setProcessTime(0);
		documentReceipt.setSocongvandiphucdap(DocumentSendReference);
		if (!privateDocument) {
			documentReceipt.setGeneralOrderNo(generalOrderNo);
		}
		if (privateDocument) {
			try {
				long userPrivateDocument = PortalUtil.getUserId(req);
				PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(userPrivateDocument);
				documentReceipt.setMainDepartmentProcessId(pmlUser.getDepartmentsId());
				documentReceipt.setMainUserProcessId(userPrivateDocument);
			} catch (Exception e) {
				_log.error("ERROR GET DEPARMENT ADD DOCUMENT PRIVATE IN "+ ViewAction.class +" "+ e.getMessage());
			}
		}

	/*	if (!"".equals(issuingPlaceName)) {
			PmlEdmIssuingPlace ip = new PmlEdmIssuingPlaceIampl();
			String ipId = IdTemplateServiceUtil.generatedStringId(PmlEdmIssuingPlace.class.getName());
			documentReceipt.setIssuingPlaceId(ipId);
			ip.setIssuingPlaceId(ipId);
			ip.setIssuingPlaceName(issuingPlaceName);
			ip.setActive("1");
			PmlEdmIssuingPlaceLocalServiceUtil.addPmlEdmIssuingPlace(ip);
		}
		*/
		/*
		 * add documentReceipt in to database
		 */
		//PmlEdmDocumentReceiptLocalServiceUtil.addPmlEdmDocumentReceipt(documentReceipt);
		
		//Canh update
		
		User user = PortalUtil.getUser(req);
		PmlEdmDocumentReceiptLocalServiceUtil.addPmlEdmDocumentReceipt(user.getCompanyId(), documentReceipt);
		
		//end of Canh
		
		/*
		 * upload file
		 */
		
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
			//xuancong close _log.info("nameFieldRowArr: " + nameFieldRowArr.length);
			//xuancong close String [] nameFilesArr = nameFiles.split("/");
			//xuancong close _log.info("nameFilesArr: " + nameFilesArr.length);
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFile(req, nameFieldRowArr[i], documentReceipt, titleFilesArr[i]);
				}
			}
		
//		into record document book
//		 ben thu thiem khong can so cong van den 	
		 long userId = PortalUtil.getUserId(req);
		 bookDocumentRecordTo(numberDocumentReceipt, documentRecordTypeId, documentReceiptId, userId, dateArrive);
		
		addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
		addWorkflowParameter(req, "documentReceiptId", WorkflowParam.TRANSIENT, "" + documentReceipt.getDocumentReceiptId());
		
		message = Constants.SUCCESS;
		
		} catch (Exception e) {
				message = Constants.FAIL;
				e.printStackTrace();
			}
		
		req.setAttribute("message", message);
	}

	/**
	 * This method allows upload many files from client to server 
	 * @param nameRowUpload 
	 * void 
	 *
	 */
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
			// lay ra screenname user hien hanh
			long userId = PortalUtil.getUser(req).getUserId();
			User user = UserUtil.findByPrimaryKey(userId);
			String userName = "";
			if (user != null) { // Nguoi dung xac dinh
				userName = user.getScreenName();
			}
			// lay ngay hien tai
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String datevalue = formatter.format(date.getTime());
			//attachedFile.setTitle(titleFile);
			attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + datevalue));
			//persistence attachedFile into database
			PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * into record document book of agency 
	 * @param documentReceiptId
	 * @param userId
	 * @param dateArrive
	 * May 19, 2009
	 * com.sgs.portlet.pcccdocumentreceipt.action
	 *
	 */
	
	
	@SuppressWarnings("static-access")
	private  void bookDocumentRecordTo(String numberDocumentReceipt, int documentRecordTypeId, long documentReceiptId, long userId, Date dateArrive) {
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		Department department = null;
		try {
			//int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(userId);
			department = DepartmentUtil.findByPrimaryKey(departmentId);
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = 
				PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearInUse, agencyId, documentRecordTypeId);
			
				if (pmlEdmDocumentRecordTo.getAgencyId() != null && pmlEdmDocumentRecordTo.getYearInUse() != null){
					PmlEdmBookDocumentRecordTo bookDocumentRecordTo = new PmlEdmBookDocumentRecordToImpl();
					
					bookDocumentRecordTo = setDataIntoBookDocumentRecordTo(bookDocumentRecordTo,
						documentReceiptId, pmlEdmDocumentRecordTo, dateArrive);
						
					PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
					
					//pmlEdmDocumentRecordTo.setCurrentRecord(pmlEdmDocumentRecordTo.getCurrentRecord() + 1);					
					pmlEdmDocumentRecordTo.setCurrentRecord(Long.parseLong(numberDocumentReceipt.split("/")[0]));					
					PmlEdmDocumentRecordToLocalServiceUtil.updatePmlEdmDocumentRecordTo(pmlEdmDocumentRecordTo);
				}
					
		}
		catch (Exception e1) {
			e1.printStackTrace();
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
	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			try {
				
				//get all PmlEdmLevelSend
				List<PmlEdmLevelSend> pmlEdmLevelSendList = PmlEdmLevelSendUtil.findAll();
				if (pmlEdmLevelSendList == null) {
					req.setAttribute("pmlEdmLevelSendList",new ArrayList<PmlEdmLevelSend>() );
				} else {
					req.setAttribute("pmlEdmLevelSendList",pmlEdmLevelSendList);
				}
				
				//get all PmlEdmDocumentRecordType
				/* phmphuc update 13/01/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				int currentYear = calendar.get(Calendar.YEAR);

				long userId = PortalUtil.getUserId(req);
				PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);		
				Department department = null;
				try {
					department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
				} catch (Exception e) { }
				
				List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
				if (department != null) {
					pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbden", department.getAgencyId(), currentYear);
				}
				//lay so van ban cua co quan trong nam
				req.setAttribute("pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
		
				// get all PmlEdmConfidentialLevel
				List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList = PmlEdmConfidentialLevelUtil.findAll();
				
				if (pmlEdmConfidentialLevelList == null) {
					req.setAttribute("pmlEdmConfidentialLevelList",new ArrayList<PmlEdmConfidentialLevel>());
				} else {
					req.setAttribute("pmlEdmConfidentialLevelList",pmlEdmConfidentialLevelList);
				}
				//get all PmlEdmPrivilegeLevel 
				List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();
				
				if (pmlEdmPrivilegeLevelList == null) {
					req.setAttribute("pmlEdmPrivilegeLevelList",new ArrayList<PmlEdmPrivilegeLevel>());
				} else {
					req.setAttribute("pmlEdmPrivilegeLevelList",pmlEdmPrivilegeLevelList);
				}
				
				req.setAttribute("userId",userId);
				
				// phmphuc them 11/11/2010 - get documenttype of documentreceipt
				List<PmlEdmDocumentType> pmlEdmDocumentTypeListReceipt = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
				if (pmlEdmDocumentTypeListReceipt == null) {
					req.setAttribute("pmlEdmDocumentTypeListReceipt", new ArrayList<PmlEdmDocumentType>());
				} else {
					req.setAttribute("pmlEdmDocumentTypeListReceipt", pmlEdmDocumentTypeListReceipt);
				}
				
			} catch (Exception e) {
				System.out.println("ERROR: "+ e.getMessage());
				e.printStackTrace();
			}
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pcccdocumentreceipt.view");
			}
	}
}
