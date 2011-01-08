/**
 * 
 */
package com.sgs.portlet.onedoorpcccprocess.action;

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
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlFileAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;
import com.sgs.portlet.onedoorpccc.ajax.OnedoorDwr;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile;
import com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo;
import com.sgs.portlet.onedoorpccc.model.PmlPaintDocument;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCAttachedFileUtil;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFileReturningInfoUtil;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlPaintDocumentUtil;

/**
 * @author hieuvh
 *
 */
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
//		System.out.println("FileId = " + fileId);
		initDataForRender(req, fileId);
		
		/* get current node by fileId */
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		service.updateReceiveDate(fileId, PortalUtil.getUserId(req));
		
		
		return mapping.findForward("portlet.sgs.onedoorpcccprocess.detail");
	}
	
	/**
	 * @param req
	 * @param fileId
	 * @throws Exception
	 */
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
		filePcccDTO.setReceiverTelephone(filePCCC.getReceiverTelephone());
		// minh update 20100524
		filePcccDTO.setApplicantTime(filePCCC.getApplicantTime());
		// end minh update 20100524
		
		
		int timeProcessRemainOfFile = OnedoorDwr.timeProcessRemainOfFile(file.getExpectedReturningDate());
		req.setAttribute("timeProcessRemainOfFile", timeProcessRemainOfFile);
		// gan gia tri hien thi voi district
//		District district = DistrictUtil.findByPrimaryKey(file.getDistrictId());
//		filePcccDTO.setDistrict(district.getDistrictName());
		
		// gan gia tri hien thi voi field
//		PmlField field = PmlFieldUtil.findByPrimaryKey(file.getFieldId());
//		filePcccDTO.setField(field.getFieldName());
		
		// gan gia tri hien thi voi fileType
		PmlFileType fileType = PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId());
		filePcccDTO.setFiletype(fileType.getFileTypeName());
		
//		filePcccDTO.setNote(note);
//		filePcccDTO.setStatus(status);//lay tu jbpm
		
		if (processDisposeList != null && processDisposeList.size() > 1) {
			PmlProcessDispose dispose = processDisposeList.get(processDisposeList.size()-2);
			
			if (dispose != null) {
				filePcccDTO.setLastTestProcessInfo(dispose.getProcessInfomation());
//				_log.info("dispose last value: Ok");	
			}
		}
		else {
			filePcccDTO.setLastTestProcessInfo("HS ch\u01b0a x\u1eed l\u00fd");
//			_log.info("ho so chua xu ly");	
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
//		System.out.println("fileReturningInfoList" + fileReturningInfoList);
		PmlFileReturningInfo fileReturningInfo = null;
		
		if (fileReturningInfoList != null && fileReturningInfoList.size() != 0) {
			fileReturningInfo = fileReturningInfoList.get(0);
		}
		
		req.setAttribute("fileReturningInfo", fileReturningInfo);
		
		// tap tin dinh kem
		List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = PmlFilePCCCAttachedFileUtil.findByFilePcccId(fileId);
		req.setAttribute("filePCCCAttachedFileList", filePCCCAttachedFileList);
		
		// trang thai ho so
		// lay ma tinh trang;
		String stateCode = ((OneDoorProcessLiferayWorkflowService)getLiferayWorkflowService()).getState(fileId);
		// minh update 20100524
		String state = "";
		
		try {
			PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByStateProcessCode(stateCode, OneDoorProcessLiferayWorkflowService.TYPE_MC).get(0);
			PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(pmlStateProcess.getStateProcessId()).get(0);
			state = fileStatusStateProcess.getDescription();
		} catch (Exception e) {
			state = "";
		}
//		List<PmlStateProcess> list = PmlStateProcessUtil.findByStateProcessCode(stateCode);
//		String state = "";
//		if (list != null && list.size() > 0) {
//			PmlStateProcess stateProcess = list.get(0);
//			state = stateProcess.getStateProcessName();
//		} 
		
		req.setAttribute("state", state);
		//end minh update 20100524
		//barcode
	}

}



