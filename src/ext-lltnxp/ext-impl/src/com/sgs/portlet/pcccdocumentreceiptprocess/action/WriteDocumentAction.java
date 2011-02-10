package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.io.File;
import java.sql.Timestamp;
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

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;

/**
 * Prepare data for form add send document.
 * @author doanhdv
 * @author kienbqc
 */
public class WriteDocumentAction extends DocumentReceiptPortletAction {
	//xuancong close private static final int HSVC_KHONGCHON = -1;
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		String documentReference = IdTemplateServiceUtil.generatedStringId(PmlEdmDocumentSend.class.getName());
		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		//Date sendDate = ParamUtil.getDate(req, "sendDate", df); 
		//Date issuingDate = ParamUtil.getDate(req, "issuingDate", df);
		long editorId = PortalUtil.getUser(req).getUserId(); 
		
		String receivingPlace = ParamUtil.getString(req, "receivingPlace");
		String signerName = ParamUtil.getString(req, "signerName"); 
		String position = ParamUtil.getString(req, "position"); 
		String documentSendCode = ParamUtil.getString(req, "documentSendCode"); 
		String numberPage = ParamUtil.getString(req, "numberPage"); 
		String numberPublish = ParamUtil.getString(req, "numberPublish"); 
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId"); 
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId"); 
		String privilegenLevelId = ParamUtil.getString(req, "privilegenLevelId"); 
		String briefContent = ParamUtil.getString(req, "briefContent"); 
		
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		String titleFiles  = ParamUtil.getString(req, "titleFiles");
		boolean socongvanphucdap = ParamUtil.getBoolean(req, "socongvanphucdap"); 
		
//		long documentSendId = CounterServiceUtil.increment();
		long documentSendId = PmlEdmDocumentSendLocalServiceUtil.getMaxDocumentSendId() + 1;
		
		// Tao mot doi tuong PmlEdmDocumentSend
		PmlEdmDocumentSend pmlEdmDocumentSend = new PmlEdmDocumentSendImpl();
		
		pmlEdmDocumentSend.setDocumentSendId(documentSendId);
		pmlEdmDocumentSend.setDocumentReference(documentReference);
		//pmlEdmDocumentSend.setSendDate(sendDate);
		//pmlEdmDocumentSend.setIssuingDate(issuingDate);		
		pmlEdmDocumentSend.setEditorId(editorId);
		
		pmlEdmDocumentSend.setReceivingPlace(StringUtil.encodeHtml(receivingPlace));
		pmlEdmDocumentSend.setSignerName(StringUtil.encodeHtml(signerName));
		pmlEdmDocumentSend.setPosition(StringUtil.encodeHtml(position));
		pmlEdmDocumentSend.setDocumentSendCode(StringUtil.encodeHtml(documentSendCode));
		pmlEdmDocumentSend.setNumberPage(StringUtil.encodeHtml(numberPage));
		pmlEdmDocumentSend.setNumberPublish(StringUtil.encodeHtml(numberPublish));
		
		pmlEdmDocumentSend.setDocumentTypeId(documentTypeId);
		pmlEdmDocumentSend.setConfidentialLevelId(confidentialLevelId);
		pmlEdmDocumentSend.setPrivilegeLevelId(privilegenLevelId);
		pmlEdmDocumentSend.setBriefContent(StringUtil.encodeHtml(briefContent));
		pmlEdmDocumentSend.setIscongvanphucdap(socongvanphucdap);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String datecreated = formatter.format(date);
		Date datecreated_ = ParamUtil.getDate(req, datecreated, new SimpleDateFormat("dd/MM/yyyy"));
		pmlEdmDocumentSend.setDateCreated(datecreated_);
		
		//PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(pmlEdmDocumentSend);
		//Canh update
		User user = PortalUtil.getUser(req);
		PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(user.getCompanyId(), pmlEdmDocumentSend);
		//end of Canh
		// phan lien quan ho so cong viec
		//xuancong close long hosocongviecId = ParamUtil.getLong(req, "hosocongviecId");
		long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
		PmlChiTietHSCV pmlChiTietHSCV = null;
		for (int i = 0; i < hosocongviecIdValues.length; i++) {				
			pmlChiTietHSCV = new PmlChiTietHSCVImpl();
			pmlChiTietHSCV.setIdChiTietHSCV(CounterServiceUtil.increment());
			pmlChiTietHSCV.setIdCongVanDi(documentSendId);
			pmlChiTietHSCV.setIdHoSoCongViec(hosocongviecIdValues[i]);				
			PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
		}
		//ket thuc
		
		PmlEdmAnswerDetail answerDetail = new PmlEdmAnswerDetailImpl();
		answerDetail.setDocumentReceiptId(documentReceiptId);
		answerDetail.setDocumentSendId(documentSendId);
		PmlEdmAnswerDetailLocalServiceUtil.addPmlEdmAnswerDetail(answerDetail);
		
		addWorkflowParameter(
			req, "documentSendId", WorkflowParam.TRANSIENT,
			String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
		
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
		
		addWorkflowParameter(req, "receiverId",  WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		
		// upload file
		try {
			if (!"".equals(nameFieldRow)) {
				String [] nameFieldRowArr = nameFieldRow.split("_");
				String [] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String [nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFile(req, nameFieldRowArr[i], pmlEdmDocumentSend, titleFilesArr[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			e.printStackTrace();
		}
		
		//update date document receipt go away department 
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		int documentRecordTypeId = 0; 
		try {
			documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
		} catch (Exception e) {
			documentRecordTypeId = 0; 
		}
		
		long userId = PortalUtil.getUserId(req);
		updateBookDocumentReceipt(userId, yearInUse, documentRecordTypeId, documentReceiptId);
	}
	
	/**
	 * set date complete of department process document receipt
	 * @param userId
	 * @param yearInUse
	 * @param documentRecordTypeId
	 * @param documentReceiptId
	 * void
	 *
	 */
	private void updateBookDocumentReceipt (long userId, String yearInUse, int documentRecordTypeId, long documentReceiptId) {
		PmlUser pmlUser = null;
		String departmentIdMain = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			
		} catch (Exception e) {	} 
		
		if (pmlUser != null) {
			try {
				departmentIdMain = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId()).getDepartmentsId();
				if (departmentIdMain != null) {
					PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(yearInUse, departmentIdMain, documentRecordTypeId);
					if (pmlEdmDocumentRecordTo != null) {
						
						PmlEdmBookDocumentRecordTo bookDocumentRecordTo = PmlEdmBookDocumentRecordToUtil.findByDocumentReceiptId_DocumentRecordToId(documentReceiptId, pmlEdmDocumentRecordTo.getDocumentRecordToId()).get(0);
						Date date = new Timestamp( new Date().getTime());
						bookDocumentRecordTo.setDateComplete(date);
						
						PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
					}
				}
			} catch (Exception e) {}
				
		}
		
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		// so ho so cong viec
		
		List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
		try {
			pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
		} catch (Exception e) {
		
		}
		
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		
		try {
			// lay ra user hien hanh
			long userId = PortalUtil.getUser(req).getUserId();
			User user = UserUtil.findByPrimaryKey(userId);
			req.setAttribute("user", user);
			
			// lay ra phong ban cua user hien hanh
			Department department = DepartmentUtil.findByPrimaryKey(PmlUserUtil.findByPrimaryKey(userId).getDepartmentsId());
			req.setAttribute("department", department);
			
			/* phmphuc close and update 12/11/2010
			// So cong van
			List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
			
			if (pmlEdmDocumentRecordTypeList == null) {
				req.setAttribute("pmlEdmDocumentRecordTypeList", new ArrayList<PmlEdmDocumentRecordType>());
			}
			*/
			// lay so van ban theo loai VB
			List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
			List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
			int documentRecordTypeId = 0;
			PmlEdmDocumentRecordType recordType = null;
			for (PmlEdmDocumentType documentType : documentTypes) {
				documentRecordTypeId = documentType.getDocumentRecordTypeId();
				try {
					recordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(documentRecordTypeId);
					if (!pmlEdmDocumentRecordTypeList.contains(recordType)) {
						pmlEdmDocumentRecordTypeList.add(recordType);
					}
				} catch (Exception e) { }
			}
			// end phmphuc update 12/11/2010
			
			
			req.setAttribute("pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
			
			// Loai cong van
			List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
			
			if (pmlEdmDocumentTypeList == null) {
				req.setAttribute("pmlEdmDocumentTypeList", new ArrayList<PmlEdmDocumentType>());
			}
			
			req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
			
			// Do mat
			List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList = PmlEdmConfidentialLevelUtil.findAll();
			
			if (pmlEdmConfidentialLevelList == null) {
				req.setAttribute("pmlEdmConfidentialLevelList", new ArrayList<PmlEdmConfidentialLevel>());
			}
			
			req.setAttribute("pmlEdmConfidentialLevelList", pmlEdmConfidentialLevelList);
			
			// Do khan
			List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();
			
			if (pmlEdmPrivilegeLevelList == null) {
				req.setAttribute("pmlEdmPrivilegeLevelList", new ArrayList<PmlEdmPrivilegeLevel>());
			}
			
			req.setAttribute("pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);
			
			// thong tin cong van den
			Integer documentReceiptId = ParamUtil.getInteger(req, "documentReceiptId");
			req.setAttribute("documentReceiptId", documentReceiptId);
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
			req.setAttribute("pmlEdmDocumentReceipt", pmlEdmDocumentReceipt);
			
			List<PmlEdmAttachedFile> pmlEdmAttachedFileList = PmlEdmAttachedFileUtil.findByObjectContentId(documentReceiptId);
			req.setAttribute("pmlEdmAttachedFileList", pmlEdmAttachedFileList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.writeDocument");
		}
	}
	
	public void uploadFile(ActionRequest req, String nameFieldUpload, PmlEdmDocumentSend pmlEdmDocumentSend, String titleFile) {
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
			attachedFile.setObjectContentId(pmlEdmDocumentSend.getDocumentSendId());
			attachedFile.setObjectType(pmlEdmDocumentSend.getClass().getName());
			attachedFile.setAttachedFileName(fileName);
			attachedFile.setPath("/upload" + "/" + fileName);
			attachedFile.setDateCreated(new Date());
			if (fileName.lastIndexOf(".") != -1) {
				attachedFile.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
			}
			// lay ra screenname user hien hanh
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
			// lay ngay hien tai
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String datevalue = formatter.format(date.getTime());
			
			//attachedFile.setTitle(StringUtil.encodeHtml(titleFile));
			//set title dang title_screenname_ngay
			attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + datevalue));
			attachedFile.setDisplayOrHidden(true);
			//persistence attachedFile into database
			PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
