/**
 * 
 */
package com.nss.portlet.onedoorprocess.action;

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
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.onedoor.ajax.OnedoorDwr;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlPaintDocumentLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;
import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;

public class DetailAction extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(DetailAction.class);
	
	@Override
	public void processStrutsAction(ActionMapping arg0, ActionForm arg1,
			PortletConfig arg2, ActionRequest arg3, ActionResponse arg4)
			throws Exception {
	}

	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig conf, RenderRequest req, RenderResponse res)
			throws Exception {
		
		// get fileId from request.
		String fileId = ParamUtil.getString(req, "fileId");
		initDataForRender(req, fileId);
		
		/* get current node by fileId */
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		service.updateReceiveDate(fileId, PortalUtil.getUserId(req));
		
		
		return mapping.findForward("portlet.nss.onedoorprocess.detail");
	}
	
	/**
	 * @param req
	 * @param fileId
	 * @throws Exception
	 */
	private void initDataForRender(PortletRequest req, String fileId) throws Exception {
		
		List<PmlProcessDispose> processDisposeList = PmlProcessDisposeLocalServiceUtil.findByFileId(fileId);
		req.setAttribute("processDisposeList", processDisposeList);
		
		PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
		
		// gan gia tri hien thi voi file
		PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
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
		PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
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
		filePcccDTO.setReceiverTelephone(filePCCC.getReceiverTelephone());
		// minh update 20100524
		filePcccDTO.setApplicantTime(filePCCC.getApplicantTime());
		// end minh update 20100524
		
		
		int timeProcessRemainOfFile = OnedoorDwr.timeProcessRemainOfFile(file.getExpectedReturningDate());
		req.setAttribute("timeProcessRemainOfFile", timeProcessRemainOfFile);
		
		// gan gia tri hien thi voi fileType
		PmlFileType fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(file.getFileTypeId());
		filePcccDTO.setFiletype(fileType.getFileTypeName());
		
		
		if (processDisposeList != null && processDisposeList.size() > 1) {
			PmlProcessDispose dispose = processDisposeList.get(processDisposeList.size()-2);
			
			if (dispose != null) {
				filePcccDTO.setLastTestProcessInfo(dispose.getProcessInfomation());
			}
		}
		else {
			filePcccDTO.setLastTestProcessInfo("HS ch\u01b0a x\u1eed l\u00fd");
		}
		
		
		req.setAttribute("filePcccDTO", filePcccDTO);
		
		//lay fileAttachedFile tu fileId cho truoc
		List<PmlFileAttachedFile> fileAttachedFileList = PmlFileAttachedFileLocalServiceUtil.findByFileId(fileId);
		req.setAttribute("fileAttachedFileList", fileAttachedFileList);
		
		List<PmlPaintDocument> paintDocumentList = PmlPaintDocumentLocalServiceUtil.findByFileId(fileId);
		req.setAttribute("paintDocumentList", paintDocumentList);
		
		
		
		req.setAttribute("fileId", file.getFileId());
		
		// thong tin tra ho so
		List<PmlFileReturningInfo> fileReturningInfoList = PmlFileReturningInfoLocalServiceUtil.findByFileId(fileId);
		PmlFileReturningInfo fileReturningInfo = null;
		
		if (fileReturningInfoList != null && fileReturningInfoList.size() != 0) {
			fileReturningInfo = fileReturningInfoList.get(0);
		}
		
		req.setAttribute("fileReturningInfo", fileReturningInfo);
		
		// tap tin dinh kem
		List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = PmlFilePCCCAttachedFileLocalServiceUtil.findByFilePcccId(fileId);
		req.setAttribute("filePCCCAttachedFileList", filePCCCAttachedFileList);
		
		// trang thai ho so
		// lay ma tinh trang;
		String stateCode = ((OneDoorProcessLiferayWorkflowService)getLiferayWorkflowService()).getState(fileId);
		// minh update 20100524
		String state = "";
		
		try {
			PmlStateProcess pmlStateProcess = PmlStateProcessLocalServiceUtil.findByStateProcessCode_Name(stateCode, OneDoorProcessLiferayWorkflowService.TYPE_MC).get(0);
			PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(pmlStateProcess.getStateProcessId()).get(0);
			state = fileStatusStateProcess.getDescription();
		} catch (Exception e) {
			state = "";
		}
		req.setAttribute("state", state);
		//end minh update 20100524
		//barcode
	}

}



