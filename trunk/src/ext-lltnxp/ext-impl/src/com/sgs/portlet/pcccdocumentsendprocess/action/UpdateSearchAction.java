/**
 * Lay du lieu tu form update, dung service cap nhat du lieu xuong he thong
 * Khai bao bien updateMessage.
 * Neu cap nhat thanh cong updateMessage = "success"
 * Neu cap nhat that bai updateMessage = "fail"
 * 
 * Sau khi cap nhat tra ve trang hien chi tiet cong van (detail.jsp)
 */
package com.sgs.portlet.pcccdocumentsendprocess.action;

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
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * @author triltm
 * 
 */
public class UpdateSearchAction extends DocumentSendPortletAction {	
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "update",PortletSession.APPLICATION_SCOPE);
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/pcccdocumentsendprocess/view");
		updateDocumentSend(req, res);
		res.sendRedirect(redirect);
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document = PmlEdmDocumentSendLocalServiceUtil
				.getPmlEdmDocumentSend(documentSendId);
		DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(document);
		
		//department
		PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(document.getEditorId());
		Department department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
		String departmentName = department.getDepartmentsName();
		String departmentsId = department.getDepartmentsId();
		// lay phong ban cha
		Department departmentParent = null;
		if (department.getDepartmentsParentId() != null && !department.getDepartmentsParentId().equals("")) {
			String departmentParentId = department.getDepartmentsParentId();
			departmentParent = DepartmentLocalServiceUtil.getDepartment(departmentParentId);
			departmentName = departmentParent.getDepartmentsName();
			departmentsId = departmentParent.getDepartmentsId();
		}
		
		// So cong van
		/* phmphuc update 13/01/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);

		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		if (department != null) {
			if (!document.isIsDocOfDepartment()) {
				pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbdi", department.getAgencyId(), currentYear);
		
			} else {
				pmlEdmDocumentRecordTypeList =
					PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForDeparment(department.getDepartmentsId(), currentYear);
			}
		}
		
		// Do mat
		List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList =
			PmlEdmConfidentialLevelUtil.findAll();
		
		// Do khan
		List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList =
			PmlEdmPrivilegeLevelUtil.findAll();
		
		// Loai cong van
//		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
		int documentRecordTypeId = document.getDocumentRecordTypeId();
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
		
		// attach file
		List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil
		.findByObjectContentId_ObjectType(documentSendId, 
			new PmlEdmDocumentSendImpl().getClass().getName());
		
		// danh sach phong ban
		List<Department> departmentList = null;
		try {
			departmentList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId();
		} catch (Exception e) {
			departmentList = new ArrayList<Department>();
		}
		
		// danh sach chuyen vien phong ban
		List<PmlUser> userList = null;
		try {
			userList = PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentsId, -1, -1, null);
		} catch (Exception e) {
			userList = new ArrayList<PmlUser>();
		}

		req.setAttribute("documentDTO", documentSendDTO);
		req.setAttribute("pmlEdmDocumentRecordTypeList",
				pmlEdmDocumentRecordTypeList);
		req.setAttribute(
				"pmlEdmConfidentialLevelList", pmlEdmConfidentialLevelList);
		req.setAttribute(
				"pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);
		req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
		req.setAttribute("departmentName", departmentName);
		req.setAttribute("departmentsId", departmentsId);
		req.setAttribute("attachedFiles", attachedFiles);
		req.setAttribute("departmentList", departmentList);
		req.setAttribute("userList", userList);
		
		// ho so cong viec cua moi phong tuong ung
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
				} catch (Exception e) {}
				
				PmlHoSoCongViec pmlHoSoCongViec = null;
				for (int i = 0; i < pmlDepartmentHSCVList.size(); i++) {
						
					try {
						pmlHoSoCongViec = PmlHoSoCongViecUtil.fetchByPrimaryKey(
								pmlDepartmentHSCVList.get(i).getId_ho_so_cong_viec());
					} catch (Exception e) {}
					if (pmlHoSoCongViec != null) {
						pmlHoSoCongViecList.add(pmlHoSoCongViec);
					}
				}
			}
			
			// minh update 20100210 phan ho so cong viec lay theo user login
			
			List<PmlHoSoCongViec> pmlHoSoCongViecForUserList = null;
	      	try {
		      	pmlHoSoCongViecForUserList = PmlHoSoCongViecUtil.findByUserId_HoatDong(pmlUserLogin.getUserId(),"1");
	      	} catch (Exception e) {
	      		pmlHoSoCongViecForUserList = new ArrayList<PmlHoSoCongViec>();
	      	}
	      	for (int i = 0; i < pmlHoSoCongViecForUserList.size(); i++) {
				if (!pmlHoSoCongViecList.contains(pmlHoSoCongViecForUserList.get(i))) {
					pmlHoSoCongViecList.add(pmlHoSoCongViecForUserList.get(i));
				}
			}
	     // end minh update 20100210
		}
		//req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		
		List<PmlChiTietHSCV> pmlChiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		
		try {
			pmlChiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDi(documentSendId);
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
	
		return mapping
				.findForward("portlet.sgs.pcccdocumentsendprocess.updatesearch");
	}

	private void updateDocumentSend(ActionRequest req, ActionResponse res) throws Exception {
		// minh upate 20110215
		// soan van ban di cua phong	
		boolean soVanBanCuaPhong = ParamUtil.getBoolean(req, "soVanBanCuaPhong", false);
		// end minh upate 20110215	
		String documentReference = ParamUtil.getString(req, "documentReference", "");
		String phanMoRong = ParamUtil.getString(req, "phanMoRong", "");
		documentReference += phanMoRong;
		long numOfDocRef = 0;
		if (documentReference.split("/").length == 2) { // So hieu van ban di hop le
			try {
				String numPart = documentReference.split("/")[0];
				numOfDocRef = Long.parseLong(numPart);
				if (numOfDocRef < 0) { // So hieu ko hop le
					numOfDocRef = 0;
				} // end if
			} catch (Exception ex) { // So hieu khong hop le
				numOfDocRef = 0;
			}
		} // end if
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/MM/yyyy"), null); // Ngay ban hanh
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");
		String receivingPlace = ParamUtil.getString(req, "receivingPlace", "");
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");
		String signerName = ParamUtil.getString(req, "signerName");
		String privilegenLevelId = ParamUtil.getString(req, "privilegenLevelId");
		String position = ParamUtil.getString(req, "position");
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentSendCode = ParamUtil.getString(req, "documentSendCode");
		String numberPage = ParamUtil.getString(req, "numberPage");
		boolean ishasdoc = ParamUtil.getBoolean(req, "ishasdoc");
		 
		// phmphuc update nguoi soan thao va phong ban soan thao
//		long creatorId = ParamUtil.getLong(req, "creatorId");
		long creatorName = ParamUtil.getLong(req, "creatorName");
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document = PmlEdmDocumentSendLocalServiceUtil
				.getPmlEdmDocumentSend(documentSendId);
		
		if (numOfDocRef > 0) { // So hieu van ban di hop le
			document.setDocumentReference(documentReference);
			document.setNumOfDocRef(numOfDocRef);
		}
		if (issuingDate != null) { // Cap nhat ngay phat hanh
			document.setIssuingDate(issuingDate);
		}
		
		if (creatorName != 0) {
			document.setEditorId(creatorName);
		}
		
		document.setIscongvanphucdap(ishasdoc);
		document.setDocumentTypeId(documentTypeId);
		document.setReceivingPlace(StringUtil.encodeHtml(receivingPlace));
		document.setConfidentialLevelId(confidentialLevelId);
		document.setSignerName(StringUtil.encodeHtml(signerName));
		document.setPrivilegeLevelId(privilegenLevelId);
		document.setPosition(StringUtil.encodeHtml(position));
		document.setBriefContent(StringUtil.encodeHtml(briefContent));
		document.setDocumentSendCode(StringUtil.encodeHtml(documentSendCode));
		document.setNumberPage(StringUtil.encodeHtml(numberPage));
		document.setIsDocOfDepartment(soVanBanCuaPhong);
		//Canh update
		User user = PortalUtil.getUser(req);
		document = PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(user.getCompanyId(), document);
		//end of Canh
		/*
		 *  lay tat ca nhung hscv tuong ung voi cong van nay
		 *  Sau do remove tat ca  nhung hscv trong bang chi tiet ho so cong va them ho so cong viec moi vao
		 */	
		long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
		List<PmlChiTietHSCV> pmlChiTietHSCVList = new ArrayList<PmlChiTietHSCV>(); 
		try {
			pmlChiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDi(documentSendId);
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
			pmlChiTietHSCV.setIdCongVanDi(documentSendId);
			PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
		}
		
		// display attachedFile
		List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil
		.findByObjectContentId_ObjectType(documentSendId, 
			new PmlEdmDocumentSendImpl().getClass().getName());
		
		long[] attachedFileIdValues = ParamUtil.getLongValues(req, "document_attached_file_view_active");
		
		PmlEdmAttachedFile attachedFile = null;
		for (int i = 0; i < attachedFileIdValues.length; i++) {
			try {
				attachedFile =  PmlEdmAttachedFileUtil.findByPrimaryKey(attachedFileIdValues[i]);
			} catch (Exception e) {
				attachedFile = null;
			}
			
			if (null != attachedFile && attachedFiles.contains(attachedFile)) {
				attachedFiles.remove(attachedFile);
				if (!attachedFile.getDisplayOrHidden()) {
					try {
						attachedFile.setDisplayOrHidden(true);
						PmlEdmAttachedFileLocalServiceUtil.updatePmlEdmAttachedFile(attachedFile);
					} catch (Exception e) {
						
					}
				}
			}
		}
		
		PmlEdmAttachedFile attachedFileUpdate = null;
		for (int i = 0; i < attachedFiles.size(); i++) {
			try {
				attachedFileUpdate = attachedFiles.get(i);
				attachedFileUpdate.setDisplayOrHidden(false);
				PmlEdmAttachedFileLocalServiceUtil.updatePmlEdmAttachedFile(attachedFileUpdate);
			} catch (Exception e) {
				
			}
		}
		
		// upload file	
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		//String nameFiles = ParamUtil.getString(req, "nameFiles");
		String titleFiles = ParamUtil.getString(req, "titleFiles");
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
				uploadFile(
//					req, nameFieldRowArr[i], nameFilesArr[i],
					req, nameFieldRowArr[i],
					document, titleFilesArr[i]);
			}
		}
	}
	
	public void uploadFile(
//			ActionRequest req, String nameFieldUpload, String nameFile,
			ActionRequest req, String nameFieldUpload,
			PmlEdmDocumentSend pmlEdmDocumentSend, String titleFile) {

			try {
				// save file upload into folder upload
				UploadPortletRequest uploadRequest =
					PortalUtil.getUploadPortletRequest(req);
				File myFile = uploadRequest.getFile(nameFieldUpload);
				
				String nameFile = uploadRequest.getFileName(nameFieldUpload).replace(' ', '_');				
//				nameFile = nameFile.replace(' ', '_');
				String fileName = Constants.getDateTime() + nameFile;
				String patthFile =
					getServlet().getServletContext().getRealPath("/") + "upload";
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
					attachedFile.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
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
				
				//attachedFile.setTitle(StringUtil.encodeHtml(titleFile));
				//set title dang title_screenname_ngay
				attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" + userName + "_" + datevalue));
				attachedFile.setDisplayOrHidden(true);
				// persistence attachedFile into database
				PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
