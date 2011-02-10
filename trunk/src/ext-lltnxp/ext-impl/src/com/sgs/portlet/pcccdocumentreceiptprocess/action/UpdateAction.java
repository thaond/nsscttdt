package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.PmlDepartmentHSCV;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVUtil;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
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
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class UpdateAction extends DocumentReceiptPortletAction {
	//xuancong close private static final int HSVC_KHONGCHON = -1;
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		updateDocumentReceipt(req);
		
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "update",PortletSession.APPLICATION_SCOPE);
		
		String redirect = ParamUtil.getString(req, "redirect","/sgs/pcccdocumentreceiptprocess/view");
		res.sendRedirect(redirect);
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default
		
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		
		// get all PmlEdmLevelSend
		List<PmlEdmLevelSend> pmlEdmLevelSendList = PmlEdmLevelSendUtil.findAll();

		/* phmphuc update 13/01/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
		// get all PmlEdmDocumentRecordType
//		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		long userId = PortalUtil.getUserId(req);
		PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);		
		Department department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = 
					PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbden", department.getAgencyId(), currentYear);
		// end phmphuc update

		// get all PmlEdmConfidentialLevel
		List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList = PmlEdmConfidentialLevelUtil.findAll();

		// get all PmlEdmPrivilegeLevel
		List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();

		// get all issuing place
		List<PmlEdmIssuingPlace> pmlEdmIssuingPlaceList = PmlEdmIssuingPlaceUtil.findAll();

		// populate PmlEdmDocumentReceipt to PmlEdmDocumentReceiptDTO
		PmlEdmDocumentReceiptDTO documentReceiptDTO = getDocumentReceiptDTO(req);

		// get Attach files
		List<PmlEdmAttachedFile> attachFiles = getAttachFiles(req);

		// get list issuing place
		List<PmlEdmIssuingPlace> issuingPlaces = getIssuingPlaces(req);

		// get list document record type
		int documentRecordTypeId = documentReceiptDTO.getDocumentRecordTypeId();//getDocumentRecordTypeId(req);

		// get list document types
		List<PmlEdmDocumentType> documentTypes = getDocumentTypes(req);

		// set attribute
		req.setAttribute("userId", userId);
		req.setAttribute("pmlEdmLevelSendList", pmlEdmLevelSendList);
		req.setAttribute("pmlEdmDocumentRecordTypeList",
				pmlEdmDocumentRecordTypeList);
		req.setAttribute("pmlEdmConfidentialLevelList",
				pmlEdmConfidentialLevelList);
		req.setAttribute("pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);
		req.setAttribute("documentReceiptDTO", documentReceiptDTO);
		req.setAttribute("pmlEdmIssuingPlaceList", pmlEdmIssuingPlaceList);
		req.setAttribute("attachFiles", attachFiles);
		req.setAttribute("issuingPlaces", issuingPlaces);
		req.setAttribute("documentRecordTypeId", "" + documentRecordTypeId);
		req.setAttribute("documentTypes", documentTypes);
		
		// ho so cong viec
		
		List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
		
		PmlUser pmlUserLogin  = null;
		try {
			pmlUserLogin = PmlUserUtil.findByPrimaryKey(PortalUtil.getUserId(req));
		} catch (Exception e) {
		}
		
		if (pmlUserLogin != null) {
			Department pmlDepartment = null;
			try {
				pmlDepartment = DepartmentUtil.findByPrimaryKey(pmlUserLogin.getDepartmentsId());
				
			} catch (Exception e) {
				
			}
			
			if (pmlDepartment != null) {
				List<PmlDepartmentHSCV> pmlDepartmentHSCVList = new ArrayList<PmlDepartmentHSCV>(); 
				try {
					pmlDepartmentHSCVList = PmlDepartmentHSCVUtil.findByDepartmentsId(pmlDepartment.getDepartmentsId());
				} catch (Exception e) {
					
				}
				PmlHoSoCongViec pmlHoSoCongViec = null;
				for (int i = 0; i < pmlDepartmentHSCVList.size(); i++) {
					
					try {
						pmlHoSoCongViec = PmlHoSoCongViecUtil.fetchByPrimaryKey(pmlDepartmentHSCVList.get(i).getId_ho_so_cong_viec());
					} catch (Exception e) {
						
					}
					if (pmlHoSoCongViec != null) {
						pmlHoSoCongViecList.add(pmlHoSoCongViec);
					}
				}
			}
		}	
		//req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		List<PmlChiTietHSCV> pmlChiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		
		try {
			pmlChiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDen(documentReceiptId);
		} catch (Exception e) {}
		
		req.setAttribute("countHSCVChoice", pmlChiTietHSCVList.size());
		
		PmlHoSoCongViec pmlHoSoCongViecTemp = null;
		if (pmlChiTietHSCVList.size() > 0) {
			
			for (int i = 0; i < pmlHoSoCongViecList.size(); i++) {
				for (int j = 0; j < pmlChiTietHSCVList.size(); j++) {
						try {
							pmlHoSoCongViecTemp = PmlHoSoCongViecUtil.findByPrimaryKey(pmlChiTietHSCVList.get(j).getIdHoSoCongViec());
						} catch (Exception e) {}				
						
						if (pmlHoSoCongViecTemp != null && pmlHoSoCongViecList.get(i).equals(pmlHoSoCongViecTemp)) {
							pmlHoSoCongViecList.remove(pmlHoSoCongViecList.get(i));
							pmlHoSoCongViecList.add(0,pmlHoSoCongViecTemp);
							pmlChiTietHSCVList.remove(pmlHoSoCongViecTemp);
						}
					}
				}
		}
		
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);		
			
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.update");
	}

	private int getDocumentRecordTypeId(RenderRequest req) throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);
		long documentTypeId = documentReceipt.getDocumentTypeId();
		PmlEdmDocumentType documentType = PmlEdmDocumentTypeLocalServiceUtil
				.getPmlEdmDocumentType(documentTypeId);

		int documentRecordTypeId = documentType.getDocumentRecordTypeId();
		return documentRecordTypeId;
	}

	private List<PmlEdmDocumentType> getDocumentTypes(RenderRequest req)
			throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);
		long documentTypeId = documentReceipt.getDocumentTypeId();

		req.setAttribute("documentTypeId", documentTypeId);
		PmlEdmDocumentType documentType = PmlEdmDocumentTypeLocalServiceUtil
				.getPmlEdmDocumentType(documentTypeId);

		int documentRecordTypeId = documentType.getDocumentRecordTypeId();
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil
				.findByDocumentRecordTypeId(documentRecordTypeId);
		return documentTypes;
	}

	private List<PmlEdmIssuingPlace> getIssuingPlaces(RenderRequest req)
			throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);

		int levelSendId = documentReceipt.getLevelSendId();

		List<PmlEdmIssuingPlace> issuingPlaces = new ArrayList<PmlEdmIssuingPlace>();
		
		// phmphuc update 12/07/2010 - hien thi danh sach da sap xep san
		try {
			issuingPlaces = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
		} catch (Exception e) { }
		
		/*
		List<PmlEdmLevelSendDetail> levelSendDetails = PmlEdmLevelSendDetailUtil.findByLevelSendId(levelSendId);

		for (PmlEdmLevelSendDetail levelSendDetail : levelSendDetails) {
			String issuingPlaceId = levelSendDetail.getIssuingPlaceId();

			PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(issuingPlaceId);
			issuingPlaces.add(issuingPlace);
		}*/
		// end
		
		return issuingPlaces;
	}

	private PmlEdmDocumentReceiptDTO getDocumentReceiptDTO(RenderRequest req)
			throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);

		PmlEdmDocumentReceiptDTO documentReceiptDTO = populateDocumentReceiptToDTO(
				req, documentReceipt);

		return documentReceiptDTO;
	}

	private List<PmlEdmAttachedFile> getAttachFiles(RenderRequest req)
			throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		List<PmlEdmAttachedFile> attachFiles = PmlEdmAttachedFileUtil
				.findByObjectContentId(documentReceiptId);
		return attachFiles;
	}

	/**
	 * update selected document
	 * 
	 * @param req
	 */
	private void updateDocumentReceipt(ActionRequest req) throws Exception {
		/* get all param in request */
		int documentRecordTypeId = ParamUtil.getInteger(req, "documentRecordTypeId");
		int documentRecordTypeIdHidden = ParamUtil.getInteger(req, "documentRecordTypeIdHidden");
		
		int levelSendId = ParamUtil.getInteger(req, "levelSendId");
		String issuingPlaceId = ParamUtil.getString(req, "issuingPlaceId");
		String issuingPlaceName = ParamUtil.getString(req, "issuingPlaceName");
		issuingPlaceName = StringUtil.encodeHtml(issuingPlaceName);
		String documentReference = ParamUtil
				.getString(req, "documentReference");
		documentReference = StringUtil.encodeHtml(documentReference);
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");
		String signer = ParamUtil.getString(req, "signer");
		signer = StringUtil.encodeHtml(signer);
		String numberDocumentReceipt = ParamUtil.getString(req,
				"numberDocumentReceipt");
		String privilegenLevelId = ParamUtil
				.getString(req, "privilegenLevelId");
		String confidentialLevelId = ParamUtil.getString(req,
				"confidentialLevelId");
		String briefContent = ParamUtil.getString(req, "briefContent");
		briefContent = StringUtil.encodeHtml(briefContent);
		
		String thoigiannhancvden = ParamUtil.getString(req, "dateArriveTime");
		
		//upload file
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		nameFieldRow = StringUtil.encodeHtml(nameFieldRow);
	//	String nameFiles = ParamUtil.getString(req, "nameFiles");
	//	nameFiles = StringUtil.encodeHtml(nameFiles);
		String titleFiles = ParamUtil.getString(req, "titleFiles");
		titleFiles = StringUtil.encodeHtml(titleFiles);
		
		//delete recent upload file
		String str_fileattachedfiletodelete = ParamUtil.getString(req, "str_fileattachedfiletodelete", "");
		if (!"".equals(str_fileattachedfiletodelete) || str_fileattachedfiletodelete != null) {
			deleteFileUpload(str_fileattachedfiletodelete);
		}
		
		String isPublic = ParamUtil.getString(req, "isPublic");
		Date issuingDate = ParamUtil.getDate(req, "issuingDate",
				new SimpleDateFormat("dd/MM/yyyy"));
		Date dateArrive = ParamUtil.getDate(req, "dateArrive",
				new SimpleDateFormat("dd/MM/yyyy"));
		/*
		// phmphuc add 05/01/2011
		boolean editNumber = ParamUtil.getBoolean(req, "editnumber");
		int phanSo = ParamUtil.getInteger(req, "phanSo");
		String phanMoRong = ParamUtil.getString(req, "phanMoRong");
		int generalOrderNo = 0;
		if (!editNumber) {
			numberDocumentReceipt = phanSo + phanMoRong;
			generalOrderNo = phanSo;
		} 
		*/
		numberDocumentReceipt = StringUtil.encodeHtml(numberDocumentReceipt);
		String donViSaoY = ParamUtil.getString(req, "donvisaoy");
		donViSaoY = StringUtil.encodeHtml(donViSaoY);

		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		Date dateArriveOld = documentReceipt.getDateArrive();
		
		documentReceipt.setLevelSendId(levelSendId);
		documentReceipt.setIssuingPlaceId(issuingPlaceId);
		documentReceipt.setDocumentReference(documentReference);
		documentReceipt.setDocumentTypeId(documentTypeId);
		documentReceipt.setSigner(signer);
		documentReceipt.setNumberDocumentReceipt(numberDocumentReceipt);
		documentReceipt.setPrivilegeLevelId(privilegenLevelId);
		documentReceipt.setConfidentialLevelId(confidentialLevelId);
		documentReceipt.setBriefContent(briefContent);
		documentReceipt.setThoigiannhancvden(thoigiannhancvden);
		documentReceipt.setIsPublic(isPublic);
		documentReceipt.setIssuingDate(issuingDate);
		documentReceipt.setDateArrive(dateArrive);
		documentReceipt.setIssuingPlaceOtherName(issuingPlaceName);
		documentReceipt.setDocumentRecordTypeId(documentRecordTypeId);
		/*
		// phmphuc them
		if (!editNumber) {
			documentReceipt.setGeneralOrderNo(generalOrderNo);
		}
		*/
		documentReceipt.setDonViSaoY(donViSaoY); 
		
		//PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(documentReceipt);
		
		//canh update
		User user = PortalUtil.getUser(req);
		documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.updatePmlEdmDocumentReceipt(user.getCompanyId(), documentReceipt);
		//end of canh
		/*
		 *  lay tat ca nhung hscv tuong ung voi cong van nay
		 *  Sau do remove tat ca  nhung hscv trong bang chi tiet ho so cong va them ho so cong viec moi vao
		 */	
		long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
		List<PmlChiTietHSCV> pmlChiTietHSCVList = new ArrayList<PmlChiTietHSCV>(); 
		try {
			pmlChiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDen(documentReceiptId);
		} catch (Exception e) {}

		if (pmlChiTietHSCVList.size() > 0){				
			for (PmlChiTietHSCV pmlChiTietHSCV : pmlChiTietHSCVList) {
				PmlChiTietHSCVLocalServiceUtil.deletePmlChiTietHSCV(pmlChiTietHSCV);
			}				
		}
			
		PmlChiTietHSCV pmlChiTietHSCV = null;
		for (int i = 0; i < hosocongviecIdValues.length; i++) {
			pmlChiTietHSCV = new PmlChiTietHSCVImpl();
			pmlChiTietHSCV.setIdChiTietHSCV(CounterLocalServiceUtil.increment());
			pmlChiTietHSCV.setIdHoSoCongViec(hosocongviecIdValues[i]);
			pmlChiTietHSCV.setIdCongVanDen(documentReceiptId);
			PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
		}
		
		/*
		 * upload file
		 */

			if (!"".equals(nameFieldRow)) {
				String[] nameFieldRowArr = nameFieldRow.split("_");
				//String[] nameFilesArr = nameFiles.split("/");
				String[] titleFilesArr = titleFiles.split("#");
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
			if (documentRecordTypeId != documentRecordTypeIdHidden) {
				long userId = PortalUtil.getUserId(req);
				removeBookDocumentRecordTo(userId, dateArriveOld, documentRecordTypeId, documentReceiptId);
				bookDocumentRecordTo(numberDocumentReceipt, documentRecordTypeId, documentReceiptId, userId, dateArrive);
			}
	}
	
	private void deleteFileUpload(String str_fileattachedfiletodelete) throws Exception {
		String[] fileUploadId = str_fileattachedfiletodelete.split("/");
		for (int i = 0; i < fileUploadId.length; i++) {
			if (!"".equals(fileUploadId[i])) {
			long fileAttachedId = Long.parseLong(fileUploadId[i]);
			PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFile(fileAttachedId);
			}
		}
	}

	/**
	 * This method allows upload many files from client to server
	 * 
	 * @param nameRowUpload
	 *            void
	 * 
	 */
	public void uploadFile(ActionRequest req, String nameFieldUpload,
			PmlEdmDocumentReceipt documentReceipt,
			String titleFile) {
		try {
			// save file upload into folder upload
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String fileNames = uploadRequest.getFileName(nameFieldUpload);
			String fileName = Constants.getDateTime()+ fileNames;	
			String patthFile = getServlet().getServletContext()
					.getRealPath("/")
					+ "upload";
			File destFile = new File(patthFile + "/" + fileName);
			if (!(new File(patthFile)).exists()) {
				(new File(patthFile)).mkdir();
			}
			FileUtils.copyFile(myFile, destFile);

			// set value into attachedFile
			PmlEdmAttachedFile attachedFile = new PmlEdmAttachedFileImpl();
			attachedFile.setAttachedFileId(CounterServiceUtil.increment());
			attachedFile.setObjectContentId(documentReceipt
					.getDocumentReceiptId());
			attachedFile.setObjectType(documentReceipt.getClass().getName());
			attachedFile.setAttachedFileName(fileName);
			attachedFile.setPath("/upload" + "/" + fileName);
			attachedFile.setDateCreated(new Date());
			if (fileName.lastIndexOf(".") != -1) {
				attachedFile.setFileType(fileName.substring(fileName
						.lastIndexOf(".") + 1));
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
			
			// persistence attachedFile into database
			PmlEdmAttachedFileLocalServiceUtil
					.addPmlEdmAttachedFile(attachedFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void removeBookDocumentRecordTo(long userId, Date dateArriveOld, int documentRecordTypeId, long documentReceiptId) {
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateArriveOld);		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		Department department = null;
		try {
			String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(userId);
			department = DepartmentUtil.findByPrimaryKey(departmentId);
			String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
			PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = 
				PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearInUse, agencyId, documentRecordTypeId);
			
			if (pmlEdmDocumentRecordTo.getAgencyId() != null && pmlEdmDocumentRecordTo.getYearInUse() != null){
				PmlEdmBookDocumentRecordToLocalServiceUtil.deletePmdEdmBookDocumentRecordToByRecId(documentReceiptId);
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
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
}
