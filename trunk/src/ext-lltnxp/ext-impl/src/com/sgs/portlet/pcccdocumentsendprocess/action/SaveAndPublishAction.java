/**
 * 
 */

package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;
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
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
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
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalUtil;
import com.sgs.portlet.pcccdocumentreceipt.util.PCCCDocumentUtil;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * @author doanhdv
 * @author XUANCONG
 */
public class SaveAndPublishAction extends DocumentSendPortletAction {

	private static Log _log = LogFactory.getLog(SaveAndPublishAction.class);

	@Override
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		try {
			boolean isPublish = ParamUtil.getBoolean(req, "isPublish", false);
			if (isPublish) {
				sendDocumentSendToGetway(req); // yenlt update 20101105
			}

			updateDocumentSend(req, res);
			PortletSession session = req.getPortletSession();
			session.setAttribute(
				"transition", "return", PortletSession.APPLICATION_SCOPE);

		}
		catch (Exception e) {
			if (e instanceof PmlEdmDocumentSendCanNotPublishException) {
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// phat sinh so cong van

		// String documentReference =
		// IdTemplateServiceUtil.generatedStringId(PmlEdmDocumentSend.class.getName());

		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document =
			PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);

		// department
		PmlUser pmlUser =
			PmlUserLocalServiceUtil.getPmlUser(document.getEditorId());
		Department department =
			DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
		String departmentName = department.getDepartmentsName();
		// xuancong close String abbreviateName =
		// department.getAbbreviateName();
		// xuancong close String departmentCode =
		// department.getDepartmentsCode();
		String departmentsId = department.getDepartmentsId();
		// neu la loai cong van

		// xuancong close int documentTypeId = (int)
		// document.getDocumentTypeId();
		long documentTypeId = document.getDocumentTypeId();
		PmlEdmDocumentType edmDocumentType =
			PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
		int documentRecordtypeId = edmDocumentType.getDocumentRecordTypeId();
		PmlEdmDocumentRecordType documentType =
			PmlEdmDocumentRecordTypeUtil.findByPrimaryKey(documentRecordtypeId);

		String documentRecordTypeCode =
			documentType.getDocumentRecordTypeCode();
		// xuancong close String documentsymbol =
		// edmDocumentType.getDocumentSymbol();
		// xuancong close String typeDocumentSend
		// =edmDocumentType.getDocumentTypeName();
		// xuancong close String loaivanbanCVD =
		// PropsUtil.get("type.document.send");
		// xuancong close String abbreviationAgencyName =
		// PropsUtil.get("abbreviation.agency.name");
		// xuancong close String documentTypeName = ParamUtil.getString(req,
		// "loaicongvancvdtn");

		/*
		 * xuancong close start if
		 * (edmDocumentType.getDocumentSymbol().equals(loaivanbanCVD)) { int
		 * documentTypeIdCount =
		 * PmlEdmDocumentSendLocalServiceUtil.countDocumentType
		 * (documentTypeId,abbreviateName); int documentTypeIdCountIncrement =
		 * documentTypeIdCount+1;
		 * document.setDocumentReference(String.valueOf(documentTypeIdCountIncrement
		 * +"/"+abbreviationAgencyName.replaceFirst("-", "")+abbreviateName));
		 * //DocumentSendDTO documentSendDTO =
		 * populateDocumentSendToDTO(document); } else{ //set so cv di vua phat
		 * sinh vao int documentTypeIdCount =
		 * PmlEdmDocumentSendLocalServiceUtil.
		 * countDocumentType(documentTypeId,abbreviateName); int
		 * documentTypeIdCountIncrement = documentTypeIdCount+1;
		 * document.setDocumentReference
		 * (String.valueOf(documentTypeIdCountIncrement+"/"+ documentsymbol
		 * +abbreviationAgencyName+ abbreviateName)); //DocumentSendDTO
		 * documentSendDTO = populateDocumentSendToDTO(document); } xuancong
		 * close end
		 */
		// xuancong add -- chinh lai cach phat sinh so van ban di
		document.setDocumentReference(PCCCDocumentUtil.getNumberDocumentPublishByTDY(
			documentTypeId, departmentsId, 0));

		DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(document);

		// So cong van
		// List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList =
		// PmlEdmDocumentRecordTypeUtil.findAll();
		/*
		 * phmphuc update 13/01/2011 - nhung loai so vb duoc tao so vb cua co
		 * quan thi moi duoc hien thi
		 */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);

		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList =
			new ArrayList<PmlEdmDocumentRecordType>();
		if (department != null) {
			if (!documentSendDTO.isDocOfDepartment()) {
				pmlEdmDocumentRecordTypeList =
					PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency(
						"vbdi", department.getAgencyId(), currentYear);
			} else {
				pmlEdmDocumentRecordTypeList =
					PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForDeparment(department.getDepartmentsId(), currentYear);
			}
		}
		// lay so van ban cua co quan trong nam
		req.setAttribute(
			"pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);

		// Do mat
		List<PmlEdmConfidentialLevel> pmlEdmConfidentialLevelList =
			PmlEdmConfidentialLevelUtil.findAll();

		// Do khan
		List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList =
			PmlEdmPrivilegeLevelUtil.findAll();

		// Loai cong van
		// phmphuc close and update follow under code 01/12/2010
		// List<PmlEdmDocumentType> pmlEdmDocumentTypeList =
		// PmlEdmDocumentTypeUtil.findAll();
		// get domenttype of documentreceipt
		// List<PmlEdmDocumentType> pmlEdmDocumentTypeList =
		// PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList =
			PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordtypeId);
		// end phmphuc close and update 01/12/2010

		// attach file
		List<PmlEdmAttachedFile> attachedFiles =
			PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType_D_OR_H(
				documentSendId,
				new PmlEdmDocumentSendImpl().getClass().getName(), true);

		req.setAttribute("documentRecordTypeCode", documentRecordTypeCode);
		req.setAttribute("documentDTO", documentSendDTO);
		req.setAttribute(
			"pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
		req.setAttribute(
			"pmlEdmConfidentialLevelList", pmlEdmConfidentialLevelList);
		req.setAttribute("pmlEdmPrivilegeLevelList", pmlEdmPrivilegeLevelList);
		req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
		req.setAttribute("departmentName", departmentName);
		req.setAttribute("attachedFiles", attachedFiles);
		req.setAttribute("departmentsId", departmentsId);

		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.saveAndPublish");
	}

	private void updateDocumentSend(ActionRequest req, ActionResponse res)
		throws Exception {

		int documentRecordTypeId =
			ParamUtil.getInteger(req, "documentRecordTypeId");
		long documentTypeId = ParamUtil.getLong(req, "documentTypeId");
		String documentReference =
			ParamUtil.getString(req, "documentReference");
		// String phanMoRong = ParamUtil.getString(req, "phanMoRong"); //
		// phmphuc 01/12/2010 - gan phan mo rong phong ban
		Date sendDate =
			ParamUtil.getDate(req, "sendDate", new SimpleDateFormat(
				"dd/MM/yyyy"));
		Date issuingDate =
			ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat(
				"dd/MM/yyyy"));
		String receivingPlace = ParamUtil.getString(req, "receivingPlace", "");
		String confidentialLevelId =
			ParamUtil.getString(req, "confidentialLevelId");
		long creatorId = ParamUtil.getLong(req, "creatorId");
		String signerName = ParamUtil.getString(req, "signerName");
		String privilegenLevelId =
			ParamUtil.getString(req, "privilegenLevelId");
		String position = ParamUtil.getString(req, "position");
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentSendCode = ParamUtil.getString(req, "documentSendCode");
		String numberPage = ParamUtil.getString(req, "numberPage");
		String numberPublist = ParamUtil.getString(req, "numberPublist");
		// xuancong add -- Them phan cap nhat numofdocref
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

		// la van ban di phat hanh cua giam doc hay phong ban
		boolean numOfDirector = ParamUtil.getBoolean(req, "numOfDirector");

		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document =
			PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		// document.setDocumentReference(documentReference + phanMoRong);
		document.setDocumentReference(documentReference);
		document.setSendDate(sendDate);
		document.setIssuingDate(issuingDate);
		document.setDocumentTypeId(documentTypeId);

		// Canh
		String receivingPlace2 =
			ParamUtil.getString(req, "receivingPlace2", "");
		receivingPlace2 = receivingPlace2.replaceAll("&nbsp;", " ");
		Map<String, String> map = new HashMap<String, String>();
		String[] receivingPlaces = receivingPlace.split(";");
		for (String rp : receivingPlaces) {
			rp = rp.trim();
			if (rp.length() > 0) {
				map.put(rp, null);
			}
		}
		String[] receivingPlaces2 = receivingPlace2.split(";");
		for (String rp : receivingPlaces2) {
			rp = rp.trim();
			if (rp.length() > 0) {
				map.put(rp, null);
			}
		}
		Iterator<String> iterator = map.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			sb.append(iterator.next());
			if (iterator.hasNext()) {
				sb.append("; ");
			}
		}
		document.setReceivingPlace(sb.toString());
		// End of Canh

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
		document.setDocumentRecordTypeId(documentRecordTypeId);

		// PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(document);

		// Canh update
		User user = PortalUtil.getUser(req);
		PmlEdmDocumentSendLocalServiceUtil.updatePmlEdmDocumentSend(
			user.getCompanyId(), document);
		// end of Canh

		// vao so cong van di
		// minh upate 20100113
		// vaosocongvandi(req, documentSendId, documentTypeId);
		Date dateArrive = new Timestamp(new Date().getTime());
		bookDocumentRecordTo(
			Long.parseLong(arrDocRef[0]), documentRecordTypeId, documentSendId,
			user.getUserId(), dateArrive, documentTypeId);
		// end minh upate 20100113

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
					req, nameFieldRowArr[i], nameFilesArr[i], document,
					titleFilesArr[i]);
			}
		}
	}

	public boolean sendDocumentSendToGetway(ActionRequest req) {

		String result = "";
		boolean flag = false;
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		Date issuingDate =
			ParamUtil.getDate(req, "issuingDate", new SimpleDateFormat(
				"dd/MM/yyyy"));
		String briefContent = ParamUtil.getString(req, "briefContent");
		String documentReference =
			ParamUtil.getString(req, "documentReference");
		String nameFiles = ParamUtil.getString(req, "nameFiles");

		OrganizationExternal ownOrg = null;
		List<OrganizationExternal> orgList =
			new ArrayList<OrganizationExternal>();
		String orgSendCode = "";
		String orgSendName = "";

		String[] nameFilesArr = nameFiles.split("/");

		try {
			orgList = OrganizationExternalUtil.findByIsOwnerOrg(true);
			ownOrg = orgList.get(0);
			orgSendCode = ownOrg.getOrgExternalCode();
			orgSendName = ownOrg.getOrgExternalName();
		}
		catch (Exception e) {
		}

		String[] orgExternalIds = req.getParameterValues("orgExternalId");
		int orgReceiveCodeLength = 0;
		if ((orgExternalIds != null) && (orgExternalIds.length > 0)) {
			orgReceiveCodeLength = orgExternalIds.length;
		}

		String[] orgReveiveCodes = new String[orgReceiveCodeLength];
		if ((orgExternalIds != null) && (orgReceiveCodeLength > 0)) {
			for (int i = 0; i < orgExternalIds.length; i++) {
				long orgExternalId = Long.parseLong(orgExternalIds[i]);
				OrganizationExternal orgReceive = null;
				String orgReceiveCode = "";
				try {
					orgReceive =
						OrganizationExternalLocalServiceUtil.getOrganizationExternal(orgExternalId);
					orgReceiveCode = orgReceive.getOrgExternalCode();
				}
				catch (Exception e) {
				}
				orgReveiveCodes[i] = orgReceiveCode;
			}
		}
		String docID =
			DocumentEdmsGateway.DEG.getEdmsGatewaySubCompany() + documentSendId;
		try {
			result =
				DocumentEdmsGateway.DEG.SendDocumentSendToGateWay(
					docID, nameFilesArr, orgReveiveCodes, orgSendCode,
					new SimpleDateFormat("dd/MM/yyyy").format(issuingDate),
					documentReference, orgSendCode, orgSendName, briefContent);
			if (!"".equals(result)) {
				flag = true;
			}
		}
		catch (Exception e) {
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

			attachedFile.setTitle(StringUtil.encodeHtml(titleFile + "_" +
				userName + "_" + datevalue));
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
	/*
	 * minh update 20100114
	 * @SuppressWarnings("unused") private void vaosocongvandi(ActionRequest
	 * req, long documentSendId, long documentTypeId) throws SystemException {
	 * Date date = new Timestamp( new Date().getTime()); String yearInUse =
	 * String.valueOf(date.getYear() + 1900); PmlEdmBookDocumentSend
	 * bookDocumentSend = laySoCongVanDi(yearInUse, req, documentTypeId); if
	 * (bookDocumentSend != null) { if (bookDocumentSend.getAgencyId() != null
	 * && bookDocumentSend.getYearInUse() != null) { PmlEdmWriteDocumentSend
	 * writeDocumentSend = new PmlEdmWriteDocumentSendImpl();
	 * writeDocumentSend.setDocumentSendId(documentSendId);
	 * writeDocumentSend.setBookDocumentSendId
	 * (bookDocumentSend.getBookDocumentSendId());
	 * writeDocumentSend.setDateCreated(date);
	 * PmlEdmWriteDocumentSendLocalServiceUtil
	 * .updatePmlEdmWriteDocumentSend(writeDocumentSend); } } }
	 */
	/**
	 * @return
	 */
	/*
	 * private PmlEdmBookDocumentSend laySoCongVanDi(String yearInUse,
	 * ActionRequest req, long documentTypeId) { // vao so cong van cho so int
	 * documentRecordTypeId =
	 * PmlEdmBookDocumentSendLocalServiceUtil.getDocumentRecordTypeIdByDocumentType
	 * (documentTypeId); String departmentId =
	 * PmlEdmDocumentRecordToLocalServiceUtil
	 * .getDepartmentIdByUserId(PortalUtil.getUserId(req)); Department
	 * department = null; try { department =
	 * DepartmentUtil.findByPrimaryKey(departmentId); } catch (Exception e1) {
	 * e1.printStackTrace(); } String agencyId =
	 * PmlEdmDocumentRecordToLocalServiceUtil
	 * .getAgencyIdByDepartment(department); PmlEdmBookDocumentSend
	 * bookDocumentSend = PmlEdmBookDocumentSendLocalServiceUtil
	 * .getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(agencyId,
	 * yearInUse, documentRecordTypeId); return bookDocumentSend; } end minh
	 * update 20100114
	 */

	private void bookDocumentRecordTo(
		long numberDocumentReference, int documentRecordTypeId,
		long documentSendId, long userId, Date dateArrive, long documentTypeId)
		throws SystemException, NoSuchPmlEdmDocumentTypeException,
		NoSuchDepartmentException, NoSuchPmlUserException,
		ArrayIndexOutOfBoundsException {

		// get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));

		Department department = null;

		PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);

		String departmentId = pmlUser.getDepartmentsId();
		department = DepartmentUtil.findByPrimaryKey(departmentId);
		String agencyId = department.getAgencyId();

		List<PmlEdmBookDocumentSend> pmlEdmBookDocumentSends =
			PmlEdmBookDocumentSendUtil.findByAgencyId_YearInUse_DocumentRecordTypeId(
				agencyId, yearInUse, documentRecordTypeId);
		if ((pmlEdmBookDocumentSends != null) &&
			!pmlEdmBookDocumentSends.isEmpty()) {
			PmlEdmBookDocumentSend pmlEdmBookDocumentSend =
				pmlEdmBookDocumentSends.get(0);
			if ((pmlEdmBookDocumentSend.getAgencyId() != null) &&
				(pmlEdmBookDocumentSend.getYearInUse() != null)) {
				PmlEdmWriteDocumentSend writeDocumentSend =
					new PmlEdmWriteDocumentSendImpl();

				writeDocumentSend =
					setDataIntoWriteDocumentSend(
						writeDocumentSend, documentSendId,
						pmlEdmBookDocumentSend, dateArrive);

				PmlEdmWriteDocumentSendLocalServiceUtil.updatePmlEdmWriteDocumentSend(writeDocumentSend);

				// pmlEdmBookDocumentSend.setCurrentRecord(pmlEdmBookDocumentSend.getCurrentRecord()
				// + 1);
				pmlEdmBookDocumentSend.setCurrentRecord(numberDocumentReference);
				PmlEdmBookDocumentSendLocalServiceUtil.updatePmlEdmBookDocumentSend(pmlEdmBookDocumentSend);
			}
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
