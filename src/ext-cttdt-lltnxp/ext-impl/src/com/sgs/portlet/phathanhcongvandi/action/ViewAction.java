package com.sgs.portlet.phathanhcongvandi.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.send.PmlEdmDocumentSendCanNotPublishException;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class ViewAction extends DocumentSendPortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		try {
			boolean isPublish = ParamUtil.getBoolean(req, "isPublish", false);
			if (isPublish) {
				sendDocumentSendToGetway(req);
			}
			
			updateDocumentSend(req, res);
			
		} catch (Exception e) {
			if (e instanceof PmlEdmDocumentSendCanNotPublishException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {


		PmlEdmDocumentSend document = new PmlEdmDocumentSendImpl();
		// nguoi tao
		long userLoginId = PortalUtil.getUserId(req);
		PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(userLoginId);
		document.setEditorId(userLoginId);
		//department
		String departmentName = "";
		String departmentsId = "";
		try {
			Department department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
			departmentName = department.getDepartmentsName();
			departmentsId = department.getDepartmentsId();
		} catch (Exception e) {
			departmentName = "";
			departmentsId = "";
		}
		
		DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(document);
		
		// So cong van
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList  = null;
		try {
			pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch (Exception e) {
			pmlEdmDocumentRecordTypeList  = new ArrayList<PmlEdmDocumentRecordType>();
		}
		// Do mat
		List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList = null;
		try {
			pmlEdmConfidentialLevelList =
				PmlEdmConfidentialLevelUtil.findAll();
			
		} catch (Exception e) {
			pmlEdmConfidentialLevelList = new ArrayList<PmlEdmConfidentialLevel>();
		}
		
		// Do khan
		List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = null;
		try {
			pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();
		} catch (Exception e) {
			pmlEdmPrivilegeLevelList = new ArrayList<PmlEdmPrivilegeLevel>();
		}
		
		// get domenttype of documentreceipt
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = null;
		try {
			pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
			
		} catch (Exception e) {
			pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
		}
		
		
		req.setAttribute("documentDTO", documentSendDTO);
		req.setAttribute("pmlEdmDocumentRecordTypeList",pmlEdmDocumentRecordTypeList);
		req.setAttribute(
				"pmlEdmConfidentialLevelList", pmlEdmConfidentialLevelList);
		req.setAttribute(
				"pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);
		req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
		req.setAttribute("departmentName", departmentName);
		req.setAttribute("departmentsId", departmentsId);
		
		return mapping
				.findForward("portlet.sgs.phathanhcongvandi.view");
	}

	private void updateDocumentSend(ActionRequest req, ActionResponse res) throws Exception{
		String message = "true";
		
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");
		String documentReference = ParamUtil.getString(req, "documentReference");
		String phanMoRong = ParamUtil.getString(req, "phanMoRong");
		Date sendDate = ParamUtil.getDate(req, "sendDate", new SimpleDateFormat("dd/MM/yyyy"));
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/MM/yyyy"));
		String receivingPlace = ParamUtil.getString(req, "receivingPlace", "");
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId");
		long creatorId = ParamUtil.getLong(req, "creatorId");
		String signerName = ParamUtil.getString(req, "signerName");
		String privilegenLevelId = ParamUtil.getString(req, "privilegenLevelId");
		String position = ParamUtil.getString(req, "position");
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentSendCode = ParamUtil.getString(req, "documentSendCode");
		String numberPage = ParamUtil.getString(req, "numberPage");
		String numberPublist = ParamUtil.getString(req, "numberPublist");
		
		long numOfDocRef = 0;
		String[] arrDocRef = documentReference.split("/");
		if (arrDocRef.length > 0) {
			try {
				numOfDocRef = Long.parseLong(arrDocRef[0]);
			} // end try
			catch (Exception ex) {
				// Do nothing
			} // end catch
		} // end if
		
		
		boolean numOfDirector = ParamUtil.getBoolean(req, "numOfDirector");
		

		long documentSendId = CounterLocalServiceUtil.increment();
		PmlEdmDocumentSend document = new PmlEdmDocumentSendImpl();
		document.setDocumentSendId(documentSendId);		
		document.setDocumentReference(documentReference + phanMoRong);
		document.setSendDate(sendDate);
		document.setIssuingDate(issuingDate);
		document.setDocumentTypeId(documentTypeId);
		document.setReceivingPlace(receivingPlace);
		document.setConfidentialLevelId(confidentialLevelId);
		document.setEditorId(creatorId);
		document.setSignerName(signerName);
		document.setPrivilegeLevelId(privilegenLevelId);
		document.setPosition(position);
		document.setBriefContent(briefContent);
		document.setDocumentSendCode(documentSendCode);
		document.setNumberPage(numberPage);
		document.setNumberPublish(numberPublist);
		document.setNumOfDocRef(numOfDocRef);
		document.setNumOfDirector(numOfDirector);
		
		// chi muc
		User user = PortalUtil.getUser(req);
		try {
			PmlEdmDocumentSendLocalServiceUtil.addPmlEdmDocumentSend(user.getCompanyId(), document);
		} catch (Exception e) {
			message = "false";
		}
		// vao so cong van di
		vaosocongvandi(req, documentSendId, documentTypeId);
		
		// upload file
		String nameFieldRow = ParamUtil.getString(req, "nameFieldRow");
		String nameFiles = ParamUtil.getString(req, "nameFiles");
		String titleFiles = ParamUtil.getString(req, "titleFiles");
		if (!"".equals(nameFieldRow)) {
			String[] nameFieldRowArr = nameFieldRow.split("_");
			String[] nameFilesArr = nameFiles.split("/");
			String[] titleFilesArr = titleFiles.split("#");
			if (titleFilesArr.length == 0) {
				titleFilesArr = new String[nameFieldRowArr.length];
				for (int i = 0; i < nameFieldRowArr.length; i++) {
					titleFilesArr[i] = "";
				}
			}
			for (int i = 0; i < nameFieldRowArr.length; i++) {
				uploadFile(
					req, nameFieldRowArr[i], nameFilesArr[i],
					document, titleFilesArr[i]);
			}
		}
		addWorkflowParameter(req, "documentSendId",  WorkflowParam.TRANSIENT, String.valueOf(documentSendId));
		addWorkflowParameter(req, "userId",  WorkflowParam.TRANSIENT, String.valueOf(user.getUserId()));
	}		
		
	public boolean sendDocumentSendToGetway(ActionRequest req){
		String result = "";
		boolean flag = false;
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		Date issuingDate = ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat("dd/MM/yyyy"));
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentReference = ParamUtil.getString(req, "documentReference");
		String nameFiles = ParamUtil.getString(req, "nameFiles");
		
		OrganizationExternal ownOrg = null;
		List<OrganizationExternal> orgList = new ArrayList<OrganizationExternal>();
		String orgSendCode = "";
		String orgSendName = "";
		
		String[] nameFilesArr = nameFiles.split("/");
		
		try {
			orgList = OrganizationExternalUtil.findByIsOwnerOrg(true);
			ownOrg = orgList.get(0);
			orgSendCode = ownOrg.getOrgExternalCode();
			orgSendName = ownOrg.getOrgExternalName();
		} catch (Exception e) {
		}
		
		String[] orgExternalIds = req.getParameterValues("orgExternalId");
		int orgReceiveCodeLength = 0;
		if (orgExternalIds != null && orgExternalIds.length > 0) {
			orgReceiveCodeLength = orgExternalIds.length; 
		}
		
		String[] orgReveiveCodes = new String[orgReceiveCodeLength];
		if (orgExternalIds != null && orgReceiveCodeLength > 0 ) {
			for (int i = 0; i < orgExternalIds.length; i++) {
				long orgExternalId = Long.parseLong(orgExternalIds[i]);
				OrganizationExternal orgReceive = null;
				String orgReceiveCode = "";
				try {
					orgReceive = OrganizationExternalLocalServiceUtil.getOrganizationExternal(orgExternalId);
					orgReceiveCode = orgReceive.getOrgExternalCode();
				} catch (Exception e) {
				}
				orgReveiveCodes[i] = orgReceiveCode;
			}
		}
		String docID = DocumentEdmsGateway.DEG.getEdmsGatewaySubCompany() + documentSendId;
		try {
			result = DocumentEdmsGateway.DEG.SendDocumentSendToGateWay(docID , nameFilesArr,
					orgReveiveCodes, orgSendCode, new SimpleDateFormat("dd/MM/yyyy").format(issuingDate), documentReference, orgSendCode, orgSendName, briefContent);
			if (!"".equals(result)) {
				flag = true;
			}
		} catch (Exception e) {
			return false;
		}
		return flag;
	}
	
	public void uploadFile(
			ActionRequest req, String nameFieldUpload, String nameFile,
			PmlEdmDocumentSend pmlEdmDocumentSend, String titleFile) {

			try {
				// save file upload into folder upload
				UploadPortletRequest uploadRequest =
					PortalUtil.getUploadPortletRequest(req);
				File myFile = uploadRequest.getFile(nameFieldUpload);

				nameFile = nameFile.replace(' ', '_');
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
				long userId = PortalUtil.getUser(req).getUserId();
				User user = UserUtil.findByPrimaryKey(userId);
				String userName = "";
				if (user != null) { 
					userName = user.getScreenName();
				}
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String datevalue = formatter.format(date.getTime());
				
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
	 * @param req
	 * @param documentSendId
	 * @param documentTypeId
	 * @throws SystemException
	 */
	@SuppressWarnings("unused")
	private void vaosocongvandi(ActionRequest req, long documentSendId,
			long documentTypeId) throws SystemException {
	
		Date date = new Timestamp( new Date().getTime());
		String yearInUse = String.valueOf(date.getYear() + 1900);
		
		PmlEdmBookDocumentSend bookDocumentSend = laySoCongVanDi(yearInUse, req, documentTypeId);
		
		if (bookDocumentSend != null) {
			if (bookDocumentSend.getAgencyId() != null && bookDocumentSend.getYearInUse() != null) {
				PmlEdmWriteDocumentSend writeDocumentSend = new PmlEdmWriteDocumentSendImpl();
				
				writeDocumentSend.setDocumentSendId(documentSendId);
				writeDocumentSend.setBookDocumentSendId(bookDocumentSend.getBookDocumentSendId());
				writeDocumentSend.setDateCreated(date);
				
				PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(writeDocumentSend);
			}
		}
	}

	/**
	 * @return
	 */
	private PmlEdmBookDocumentSend laySoCongVanDi(String yearInUse, ActionRequest req, long documentTypeId) {
		
		// vao so cong van cho so
		
		int documentRecordTypeId = PmlEdmBookDocumentSendLocalServiceUtil.getDocumentRecordTypeIdByDocumentType(documentTypeId);
		
		String departmentId = PmlEdmDocumentRecordToLocalServiceUtil.getDepartmentIdByUserId(PortalUtil.getUserId(req));
		Department department = null;
		try {
			department = DepartmentUtil.findByPrimaryKey(departmentId);
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String agencyId = PmlEdmDocumentRecordToLocalServiceUtil.getAgencyIdByDepartment(department);
		PmlEdmBookDocumentSend bookDocumentSend =  
				PmlEdmBookDocumentSendLocalServiceUtil
					.getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(agencyId, yearInUse, documentRecordTypeId);
		return bookDocumentSend;
	}
	
	protected DocumentSendDTO populateDocumentSendToDTO(PmlEdmDocumentSend documentSend) {
		PmlEdmDocumentType documentType = null;
		PmlEdmPrivilegeLevel privilegel = null;
		PmlEdmConfidentialLevel confidentialLevel = null;
		DocumentSendDTO sendDTO = null;
		try {
			
			long editorId = documentSend.getEditorId();
			
			// xuancong add start
			// Ap dung khi nguoi dung import vao ko co
			User user = null;
			String editor = "";
			if (editorId > 0) {
				try {
					user = UserUtil.findByPrimaryKey(editorId);
					editor = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				}
				catch (Exception ex) {
					// Do nothing
				}
			}
			// xuancong add end
		
		
			String signer = documentSend.getSignerName();
			
			sendDTO = new DocumentSendDTO();
			
			sendDTO.setBriefContent(documentSend.getBriefContent());
			sendDTO.setDocumentReference(documentSend.getDocumentReference());
			sendDTO.setReceivingPlace(documentSend.getReceivingPlace());
			
			sendDTO.setIssuingDate(documentSend.getIssuingDate());
			
			sendDTO.setActive(documentSend.getActive());
			
			sendDTO.setDateCreate(documentSend.getDateCreated());
			sendDTO.setDocumentType("");
			sendDTO.setEditor(editor);
			sendDTO.setIsLocal(documentSend.getIsLocal());
			sendDTO.setOpinion(documentSend.getOpinion());
		
			sendDTO.setSigner(signer);
			sendDTO.setIscongvanphucdap(documentSend.getIscongvanphucdap());
			


			
			sendDTO.setSendDate(documentSend.getSendDate());
			sendDTO.setPosition(documentSend.getPosition());
			sendDTO.setDocumentSendCode(documentSend.getDocumentSendCode());
			sendDTO.setNumberPage(documentSend.getNumberPage());
			sendDTO.setNumberPublish(documentSend.getNumberPublish());
//			int documentRecordTypeId = documentType.getDocumentRecordTypeId();
		
			
			// phmphuc them 2 thuoc tinh cho vb di phat hanh - 01/12/2010
			PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(editorId);
//			Department department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
			
//			long soHieuVB = PCCCDocumentUtil.getSoHieuVB(documentTypeId);
//			String phanMoRong = PCCCDocumentUtil.getPhanMoRong(documentTypeId, department.getDepartmentsId());
//			sendDTO.setSoHieuVB(soHieuVB);
//			sendDTO.setPhanMoRong(phanMoRong);
			// end phmphuc them 01/12/2010
			
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return sendDTO;
	}

}
