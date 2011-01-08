
package com.sgs.portlet.pcccdocumentsend.action;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.model.impl.PositionImpl;
import com.sgs.portlet.position.service.persistence.PositionUtil;


public class ViewAction extends DocumentSendPortletAction {
	// vu update 31122010  
	private static Log _log = LogFactory.getLog(ViewAction.class); 
	// end update
	
	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		String message = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String datecreated = formatter.format(date);
			Date datecreated_ = ParamUtil.getDate(req, datecreated, new SimpleDateFormat("dd/MM/yyyy"));
//			String documentReference =
//				IdTemplateServiceUtil.generatedStringId(PmlEdmDocumentSend.class.getName());
			// van
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
			//String nameFiles = ParamUtil.getString(req, "nameFiles");
			String titleFiles = ParamUtil.getString(req, "titleFiles");
			Boolean ishasdoc = ParamUtil.getBoolean(req, "ishasdoc");

		// xuancong close long documentSendId = CounterServiceUtil.increment();
			// Gay loi trung id khi import du lieu bang tay, ko qua liferay
			// Thay bang ham lay id lon nhat trong bang pml_edm_documentsend cong 1
			long documentSendId = PmlEdmDocumentSendLocalServiceUtil.getMaxDocumentSendId() + 1;
			
			PmlEdmDocumentSend pmlEdmDocumentSend =	new PmlEdmDocumentSendImpl();
			
			pmlEdmDocumentSend.setDocumentSendId(documentSendId);
//			pmlEdmDocumentSend.setDocumentReference(StringUtil.encodeHtml(documentReference));
//			pmlEdmDocumentSend.setSendDate(sendDate);
//			pmlEdmDocumentSend.setIssuingDate(issuingDate);
			pmlEdmDocumentSend.setEditorId(editorId);
			
			pmlEdmDocumentSend.setIscongvanphucdap(ishasdoc);
			
			pmlEdmDocumentSend.setReceivingPlace(StringUtil.encodeHtml(receivingPlace));
			pmlEdmDocumentSend.setSignerName(StringUtil.encodeHtml(signerName));
			pmlEdmDocumentSend.setPosition(StringUtil.encodeHtml(position));
			pmlEdmDocumentSend.setDocumentSendCode(StringUtil.encodeHtml(documentSendCode));
			pmlEdmDocumentSend.setNumberPage(StringUtil.encodeHtml(numberPage));
			pmlEdmDocumentSend.setNumberPublish(StringUtil.encodeHtml(numberPublish));
	
			pmlEdmDocumentSend.setDocumentTypeId(documentTypeId);
			pmlEdmDocumentSend.setConfidentialLevelId(confidentialLevelId);
			pmlEdmDocumentSend.setDateCreated(datecreated_);
			pmlEdmDocumentSend.setPrivilegeLevelId(privilegenLevelId);
			pmlEdmDocumentSend.setBriefContent(StringUtil.encodeHtml(briefContent));

                        //PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(pmlEdmDocumentSend);
			
			//canh update
			//xuancong close pmlEdmDocumentSend.setSignerId(signerId);
			User user = PortalUtil.getUser(req);
			PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(user.getCompanyId(), pmlEdmDocumentSend);
			//
			// phan lien quan ho so cong viec
			long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
			PmlChiTietHSCV pmlChiTietHSCV = null;
			for (int i = 0; i < hosocongviecIdValues.length; i++) {				
				pmlChiTietHSCV = new PmlChiTietHSCVImpl();
				pmlChiTietHSCV.setIdChiTietHSCV(CounterServiceUtil.increment());
				pmlChiTietHSCV.setIdCongVanDi(documentSendId);
				pmlChiTietHSCV.setIdHoSoCongViec(hosocongviecIdValues[i]);				
				PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
			}
			//phan vao so
			bookDocumentRecordTo(
				documentSendId, editorId, new Date(), documentTypeId);
			addWorkflowParameter(
				req, "documentSendId", WorkflowParam.TRANSIENT,
				String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
			addWorkflowParameter(
				req, "userId", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));

			// upload file

			if (!"".equals(nameFieldRow)) {
				String[] nameFieldRowArr = nameFieldRow.split("_");
				String[] titleFilesArr = titleFiles.split("#");
				if (titleFilesArr.length == 0) {
					titleFilesArr = new String[nameFieldRowArr.length];
					for (int i = 0; i < nameFieldRowArr.length; i++) {
						titleFilesArr[i] = "";
					}
				}
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					uploadFile(
						//req, nameFieldRowArr[i], nameFilesArr[i],
						req, nameFieldRowArr[i],
						pmlEdmDocumentSend, titleFilesArr[i]);
				}
			}
			
			message = com.ext.portlet.util.Constants.SUCCESS;;
		}
		catch (Exception e) {
			message = com.ext.portlet.util.Constants.FAIL;
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		// phmphuc close 21/09/2010
//		PortletSession session= req.getPortletSession();
//		session.setAttribute("message", message,PortletSession.APPLICATION_SCOPE);
		req.setAttribute("message", message);
		// end phmphuc update
		
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// so ho so cong viec
		
		List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
		try {
			pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
		} catch (Exception e) {
		}
		
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		
		long userId = PortalUtil.getUser(req).getUserId();
		
		try {
			// lay ra user hien hanh
			User user = null;
			try {
				user = UserUtil.findByPrimaryKey(userId);
			} catch (Exception e) {
				_log.error("ERROR NO GET USER LOGIN "+ViewAction.class + "" +e.getMessage());
				user = new UserImpl();
			}
			
			req.setAttribute("user", user);

			// lay ra phong ban cua user hien hanh
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(PmlUserUtil.findByPrimaryKey(userId).getDepartmentsId());
			} catch (Exception e) {
				_log.error("ERROR NO GET department FROM USER LOGIN "+ViewAction.class + "" +e.getMessage());
				department = new DepartmentImpl();
			}
			
			req.setAttribute("department",department);
			
			// So cong van
			List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = null;			
			try {
				 pmlEdmDocumentRecordTypeList =PmlEdmDocumentRecordTypeUtil.findAll();
				
			} catch (Exception e) {
				_log.error("ERROR NO GET LIST PmlEdmDocumentRecordType "+ViewAction.class + "" +e.getMessage());
				pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
			}

			req.setAttribute(
				"pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);

			// Loai cong van
			/* phmphuc clsoe and change by under code
			List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
			if (pmlEdmDocumentTypeList == null) {
				req.setAttribute("pmlEdmDocumentTypeList", new ArrayList<PmlEdmDocumentType>());
			}
			req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
			*/
			// phmphuc them 11/11/2010 - get documenttype of documentreceipt
			List<PmlEdmDocumentType> pmlEdmDocumentTypeListSend = null;
			try {
				pmlEdmDocumentTypeListSend = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2,3);
				
			} catch (Exception e) {
				_log.error("ERROR NO GET LIST PmlEdmDocumentType "+ViewAction.class + "" +e.getMessage());
				pmlEdmDocumentTypeListSend = new ArrayList<PmlEdmDocumentType>();
			}

			req.setAttribute("pmlEdmDocumentTypeListSend", pmlEdmDocumentTypeListSend);


			// Do mat
			List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList = null;
			try {
				pmlEdmConfidentialLevelList = PmlEdmConfidentialLevelUtil.findAll();
			} catch (Exception e) {
				_log.error("ERROR NO GET LIST PmlEdmConfidentialLevel "+ViewAction.class + "" +e.getMessage());
				pmlEdmConfidentialLevelList = new ArrayList<PmlEdmConfidentialLevel>();
			}

			req.setAttribute("pmlEdmConfidentialLevelList", pmlEdmConfidentialLevelList);

			// Do khan
			List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = null;
			try {
				pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();
				
			} catch (Exception e) {
				_log.error("ERROR NO GET LIST PmlEdmPrivilegeLeve "+ViewAction.class + "" +e.getMessage());
				 pmlEdmPrivilegeLevelList = new ArrayList<PmlEdmPrivilegeLevel>();
			}


			req.setAttribute("pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);

			Position position = null;
			try {
				PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
				position = PositionUtil.findByPrimaryKey(pmlUser.getPositionId());
			} catch (Exception e) {
				_log.error("ERROR NO GET POSITION FROM USER LOGIN "+ViewAction.class + "" +e.getMessage());
				position = new PositionImpl();
			}

			req.setAttribute("position", position.getPositionCode());
		
		}
		catch (Exception e) {
			// vu update 31122010
			_log.error(ViewAction.class + "" +e.getMessage());
			// end update
		}

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		}
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentsend.view");
		}
	}

	public void uploadFile(
		ActionRequest req, String nameFieldUpload,
		PmlEdmDocumentSend pmlEdmDocumentSend, String titleFile) {

		try {
			// save file upload into folder upload
			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile(nameFieldUpload);
			String nameFile = uploadRequest.getFileName(nameFieldUpload).replace(' ', '_');	
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

	/**
	 * into record document book of agency
	 * 
	 * @param documentReceiptId
	 * @param userId
	 * @param dateArrive
	 *            May 19, 2009 com.sgs.portlet.pcccdocumentreceipt.action
	 * @throws SystemException
	 * @throws NoSuchPmlEdmDocumentTypeException
	 * @throws NoSuchPmlDepartmentException
	 * @throws NoSuchPmlUserException
	 */

	private void bookDocumentRecordTo(
		long documentSendId, long userId, Date dateArrive, long documentTypeId)
		throws SystemException, NoSuchPmlEdmDocumentTypeException,
		NoSuchDepartmentException, NoSuchPmlUserException, ArrayIndexOutOfBoundsException {

		// get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));

		Department department = null;

		PmlEdmDocumentType documentType =
			PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);

		int documentRecordTypeId = documentType.getDocumentRecordTypeId();

		PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);

		String departmentId = pmlUser.getDepartmentsId();
		department = DepartmentUtil.findByPrimaryKey(departmentId);
		String agencyId = department.getAgencyId();
		List<PmlEdmBookDocumentSend> pmlEdmBookDocumentSends =
			PmlEdmBookDocumentSendUtil.findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId, yearInUse, documentRecordTypeId);
		
		PmlEdmBookDocumentSend pmlEdmBookDocumentSend = pmlEdmBookDocumentSends.get(0);
		if (pmlEdmBookDocumentSend.getAgencyId() != null &&
			pmlEdmBookDocumentSend.getYearInUse() != null) {
			PmlEdmWriteDocumentSend writeDocumentSend =
				new PmlEdmWriteDocumentSendImpl();

			writeDocumentSend =
				setDataIntoWriteDocumentSend(
					writeDocumentSend, documentSendId,
					pmlEdmBookDocumentSend, dateArrive);

			PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(writeDocumentSend);

			pmlEdmBookDocumentSend.setCurrentRecord(pmlEdmBookDocumentSend.getCurrentRecord() + 1);
			PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(writeDocumentSend);
		}

	}

	/**
	 * set data into bookDocumentRecordTo object
	 * 
	 * @param writeDocumentSend
	 * @param documentSendId
	 * @param pmlEdmBookDocumentSend
	 * @param dateArrive
	 */
	private PmlEdmWriteDocumentSend setDataIntoWriteDocumentSend(
		PmlEdmWriteDocumentSend writeDocumentSend, long documentSendId,
		PmlEdmBookDocumentSend pmlEdmBookDocumentSend, Date dateArrive) {

		writeDocumentSend.setDocumentSendId(documentSendId);
		writeDocumentSend.setBookDocumentSendId(pmlEdmBookDocumentSend.getBookDocumentSendId());
		writeDocumentSend.setDateCreated(dateArrive);

		return writeDocumentSend;
	}

}
