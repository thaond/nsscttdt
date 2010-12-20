package com.nss.portlet.onedoorfileprocessed.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.persistence.PmlFileAttachedFileUtil;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFileUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoUtil;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessUtil;
import com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentUtil;
import com.nss.portlet.onedoor.service.persistence.PmlProcessDisposeUtil;
import com.nss.portlet.onedoor.service.persistence.PmlStateProcessUtil;
import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;

public class DetailAction extends OneDoorProcessPortletAction  {
	private static Log _log = LogFactory.getLog(DetailAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// get fileId from request.
		String fileId = ParamUtil.getString(renderRequest, "fileId");
		initDataForRender(renderRequest, fileId);
		
		return mapping.findForward("portlet.nss.onedoorfileprocessed.detail");
	}

	private void initDataForRender(PortletRequest req, String fileId) throws Exception {
		List<PmlProcessDispose> processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
		req.setAttribute("processDisposeList", processDisposeList);
		
		PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
		
		// gan gia tri hien thi voi file
		PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
		filePcccDTO.setApplicantName(file.getApplicantName());
		filePcccDTO.setApplicationDate(file.getApplicationDate());
		filePcccDTO.setAuthourisedLetter(file.getAuthorisedLetter());
		filePcccDTO.setBriefContent(file.getBriefContent());
		filePcccDTO.setContactInformation(file.getContactInfomation());
		filePcccDTO.setDateCreate(file.getDateCreated());
		filePcccDTO.setExpectedReturingDate(file.getExpectedReturningDate());
		filePcccDTO.setFileId(file.getFileId());
		filePcccDTO.setGender(file.getGender());
		filePcccDTO.setIdNumber(file.getIdNumber());
		filePcccDTO.setIssuingDate(file.getIssuingDate());
		filePcccDTO.setIssuingPlace(file.getIssuingPlace());
		filePcccDTO.setNumberReceipt(file.getNumberReceipt());
		filePcccDTO.setOrganization(file.getOrganization());
		filePcccDTO.setOtherContent(file.getOtherContent());
		filePcccDTO.setPermanentAddress(file.getPermanentAddress());
		filePcccDTO.setReceiver(file.getReceiver());
		filePcccDTO.setSolvingTime(file.getSolvingTime());
		filePcccDTO.setTelephone(file.getTelephone());
		
		// gan gia tri hien thi voi filePCCC
		PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(fileId);
		filePcccDTO.setAddressBuilder(filePCCC.getAddressBuilder());
		filePcccDTO.setApplicantCategory(filePCCC.getApplicantCategory());
		filePcccDTO.setApplicantRepresentation(filePCCC.getApplicantRepresentation());
		filePcccDTO.setApplicantTelephone(filePCCC.getApplicantTelephone());
		filePcccDTO.setConclusion(filePCCC.getConclusion());
		filePcccDTO.setDesignCop(filePCCC.getDesignCop());
		filePcccDTO.setFileName(filePCCC.getFileName());
		filePcccDTO.setFileNumber(filePCCC.getFileNumber());
		filePcccDTO.setInputDataDate(filePCCC.getInputDataDate());
		filePcccDTO.setInvestor(filePCCC.getInvestor());
		filePcccDTO.setNoteInformationManagement(filePCCC.getNoteInformationManagement());
		filePcccDTO.setProjectname(filePCCC.getProjectName());
		filePcccDTO.setReceiverRepresentation(filePCCC.getReceiverRepresentation());
		filePcccDTO.setApplicantTime(filePCCC.getApplicantTime());
		filePcccDTO.setReceiverTelephone(filePCCC.getReceiverTelephone());
		
		// gan gia tri hien thi voi fileType
		PmlFileType fileType = PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId());
		filePcccDTO.setFiletype(fileType.getFileTypeName());
		
		
		if (processDisposeList != null && processDisposeList.size() > 1) {
			PmlProcessDispose dispose = processDisposeList.get(processDisposeList.size()-2);
			
			if (dispose != null) {
				filePcccDTO.setLastTestProcessInfo(dispose.getProcessInfomation());
				_log.info("dispose last value: Ok");	
			}
		}
		else {
			filePcccDTO.setLastTestProcessInfo("HS ch\u01b0a x\u1eed l\u00fd");
			_log.info("ho so chua xu ly");	
		}
		
		
		req.setAttribute("filePcccDTO", filePcccDTO);
		
		//lay fileAttachedFile tu fileId cho truoc
		List<PmlFileAttachedFile> fileAttachedFileList = PmlFileAttachedFileUtil.findByFileId(fileId);
		req.setAttribute("fileAttachedFileList", fileAttachedFileList);
		
		List<PmlPaintDocument> paintDocumentList = PmlPaintDocumentUtil.findByFileId(fileId);
		req.setAttribute("paintDocumentList", paintDocumentList);
		
		req.setAttribute("fileId", file.getFileId());
		
		// thong tin tra ho so
		List<PmlFileReturningInfo> fileReturningInfoList = PmlFileReturningInfoUtil.findByFileId(fileId);
		PmlFileReturningInfo fileReturningInfo = null;
		
		if (fileReturningInfoList != null && fileReturningInfoList.size() != 0) {
			fileReturningInfo = fileReturningInfoList.get(0);
		}
		
		req.setAttribute("fileReturningInfo", fileReturningInfo);
		
		// tap tin dinh kem
		List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = PmlFilePCCCAttachedFileUtil.findByFilePcccId(fileId);
		req.setAttribute("filePCCCAttachedFileList", filePCCCAttachedFileList);
		
		// trang thai ho so 
		String stateCode = ((OneDoorProcessLiferayWorkflowService)getLiferayWorkflowService()).getState(fileId);
		List<PmlStateProcess> list = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(stateCode, OneDoorProcessLiferayWorkflowService.TYPE_MC);
		String state = "";
		if (list != null && list.size() > 0) {
			PmlStateProcess stateProcess = list.get(0);
			try {
				PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(stateProcess.getStateProcessId()).get(0);
				state = fileStatusStateProcess.getDescription();
			} catch (Exception e) {
			}
		} 
		
		req.setAttribute("state", state);
		
		//barcode
		
		// hien thi thong tin de download file 
		// tam thoi chua sua o so 0
		/* format name of attached file */
		/* yenlt close 16/10/2010 pmlnew ko co bang nay
		List<PmlFileAttachReturnInfo> attachedFiles = PmlFileAttachReturnInfoLocalServiceUtil.getListFileAttachReturnInfo(fileId, 0);
		List<PmlFileAttachReturnInfo> formatAttachedFiles = new ArrayList<PmlFileAttachReturnInfo>();
		if (attachedFiles != null) {
		for (int i = 0; i < attachedFiles.size(); i++) {  
			PmlFileAttachReturnInfo attachedFile = attachedFiles.get(i);
			String name = attachedFile.getFileName();
			String subName = name.substring(Constants.NUMBER_REFIX_ATTACHEDFILE);
			attachedFile.setFileName(subName);
			
			formatAttachedFiles.add(attachedFile);
			}
		}
		// set attribute 
		req.setAttribute("attachedFiles", formatAttachedFiles);
		
		*/
	}
}