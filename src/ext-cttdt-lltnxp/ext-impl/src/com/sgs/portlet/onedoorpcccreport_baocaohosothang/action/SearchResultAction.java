package com.sgs.portlet.onedoorpcccreport_baocaohosothang.action;

/**
 * @author triltm
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalServiceUtil;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;

public class SearchResultAction extends OneDoorProcessPortletAction {

	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		long userId = PortalUtil.getUserId(req);
		List<PmlOneDoorReceiveFile> list = ((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService())
				.getListPmlFilesByUser(userId);
		List<PmlOneDoorReceiveFile> receiveFiles = filterPmlOneDoorReceiveFiles(
				req, list);
		List<PmlFilePcccDTO> receiveFilesDTO = getPmlFilePcccDTO(receiveFiles);

		req.setAttribute("receiveFilesDTO", receiveFilesDTO);
		return mapping.findForward("portlet.sgs.onedoorpcccreport_baocaohosothang.searchresult");
	}

//	private List<PmlOneDoorReceiveFile> filterPmlOneDoorReceiveFiles(
//			RenderRequest req, List<PmlOneDoorReceiveFile> list) {
//		//get data
//		String fileId = ParamUtil.getString(req, "fileId", "");
//		String fileName = ParamUtil.getString(req, "fileName", "");
//		String applicantName = ParamUtil.getString(req, "applicantName", "");
//		String address = ParamUtil.getString(req, "address", "");
//		String telephone = ParamUtil.getString(req, "telephone", "");
//		long fileStatus = ParamUtil.getLong(req, "fileStatus", 0);
//		String fileType = ParamUtil.getString(req, "fileType", "");
//		Date receiveFromDate = ParamUtil.getDate(req, "receiveFromDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date receiveToDate = ParamUtil.getDate(req, "receiveToDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date expectedReturningFromDate = ParamUtil.getDate(req, "expectReturningFromDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date expextedReturningToDate = ParamUtil.getDate(req, "expectReturningToDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date inputDataFromDate = ParamUtil.getDate(req, "completeFromDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date inputDataToDate = ParamUtil.getDate(req, "completeToDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date exactReturningFromDate = ParamUtil.getDate(req, "exactReturningFromDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		Date exactReturningToDate = ParamUtil.getDate(req, "exactReturningToDate", new SimpleDateFormat("dd/MM/yyyy"), null);
//		String email = ParamUtil.getString(req, "email", "");
//
//		List<PmlOneDoorReceiveFile> results = new ArrayList<PmlOneDoorReceiveFile>();
//		results = PmlFilePCCCLocalServiceUtil.filter(list, fileId, fileName,
//				applicantName, address, telephone, email, fileStatus, fileType,
//				receiveFromDate, receiveToDate, expectedReturningFromDate,
//				expextedReturningToDate, inputDataFromDate, inputDataToDate,
//				exactReturningFromDate, exactReturningToDate);
//		return results;
//	}

	private List<PmlFilePcccDTO> getPmlFilePcccDTO(
			List<PmlOneDoorReceiveFile> list) throws Exception {
		List<PmlFilePcccDTO> result = new ArrayList<PmlFilePcccDTO>();

		if (list == null) {
			return result;
		}
		for (PmlOneDoorReceiveFile file : list) {
			PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();

			// gan gia tri hien thi voi file
			filePcccDTO.setApplicantName(file.getApplicantName());
			filePcccDTO.setApplicationDate(file.getApplicationDate());
			filePcccDTO.setAuthourisedLetter(file.getAuthorisedLetter());
			filePcccDTO.setBriefContent(file.getBriefContent());
			filePcccDTO.setContactInformation(file.getContactInfomation());
			filePcccDTO.setDateCreate(file.getDateCreated());
			filePcccDTO
					.setExpectedReturingDate(file.getExpectedReturningDate());
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
			PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(file
					.getFileId());
			filePcccDTO.setAddressBuilder(filePCCC.getAddressBuilder());
			filePcccDTO.setApplicantCategory(filePCCC.getApplicantCategory());
			filePcccDTO.setApplicantRepresentation(filePCCC
					.getApplicantRepresentation());
			filePcccDTO.setApplicantTelephone(filePCCC.getApplicantTelephone());
			filePcccDTO.setConclusion(filePCCC.getConclusion());
			filePcccDTO.setDesignCop(filePCCC.getDesignCop());
			filePcccDTO.setFileName(filePCCC.getFileName());
			filePcccDTO.setFileNumber(filePCCC.getFileNumber());
			filePcccDTO.setInputDataDate(filePCCC.getInputDataDate());
			filePcccDTO.setInvestor(filePCCC.getInvestor());
			filePcccDTO.setNoteInformationManagement(filePCCC
					.getNoteInformationManagement());
			filePcccDTO.setProjectname(filePCCC.getProjectName());
			filePcccDTO.setReceiverRepresentation(filePCCC
					.getReceiverRepresentation());
			filePcccDTO.setReceiverTelephone(filePCCC.getReceiverTelephone());

			// gan gia tri hien thi voi fileType
			PmlFileType fileType = PmlFileTypeUtil.findByPrimaryKey(file
					.getFileTypeId());
			filePcccDTO.setFiletype(fileType.getFileTypeName());
			
			PmlProcessDispose log = null;
			try {
				log = getProcessDipose(file.getFileId());
			} catch (Exception e) {
			}
			if (log != null) {
				filePcccDTO.setSendDate(log.getSendDate());
				filePcccDTO.setReceiveDate(log.getReceiveDate());
				filePcccDTO.setExpireDate(log.getExpiredDate());
				PmlStateProcess status = PmlStateProcessUtil
						.findByPrimaryKey(log.getStateProcessIdBefore());
				filePcccDTO.setStatus(status.getStateProcessName());
			}

			result.add(filePcccDTO);
		}
		return result;
	}



	// TODO: bBbbb
	private List<PmlOneDoorReceiveFile> filterPmlOneDoorReceiveFiles(
			RenderRequest req, List<PmlOneDoorReceiveFile> list) throws Exception {
		
		List<PmlOneDoorReceiveFile> results = new ArrayList<PmlOneDoorReceiveFile>();
		
		//get data
		String dataForSearch = ParamUtil.getString(req, "dataForSearch", "");
		System.out.println("============dataforsearch================ " + dataForSearch);
		if ("".equals(dataForSearch)) {
			results = list;
		}
		else {
			
			String[] dataForSearchArray = dataForSearch.split("_", -1);
			
			System.out.println("Length = " + dataForSearchArray.length);
			String fileId = dataForSearchArray[0];
			String fileName = dataForSearchArray[1];
			System.out.println("********* file Name ======= " + fileName);
			String applicantName = dataForSearchArray[2];
			String address = dataForSearchArray[3];
			String telephone = dataForSearchArray[4];
			String email = dataForSearchArray[5];
			
			long fileStatus = 0;
			if (!"".equals(dataForSearchArray[6])) {
				fileStatus = Long.parseLong(dataForSearchArray[6]);
			}
			String fileType = dataForSearchArray[7];
			
			
			Date receiveFromDate = null;
			if (!"".equals(dataForSearchArray[8])) {
				receiveFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[8]);
				System.out.println("=====receiveFromDate======== " + receiveFromDate.toString());
			}
			
		
			Date receiveToDate = null;
			if (!"".equals(dataForSearchArray[9])) {
				receiveToDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[9]);
			}
			
			Date expectedReturningFromDate = null;
			if (!"".equals(dataForSearchArray[10])) {
				expectedReturningFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[10]);
			}
			
			Date expextedReturningToDate = null;
			if (!"".equals(dataForSearchArray[11])) {
				expextedReturningToDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[11]);
			}
			
			Date inputDataFromDate = null;
			if (!"".equals(dataForSearchArray[12])) {
				inputDataFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[12]);
			}
			
			Date inputDataToDate = null;
			if (!"".equals(dataForSearchArray[13])) {
				 inputDataToDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[13]);
			}
			
			Date exactReturningFromDate = null;
			if (!"".equals(dataForSearchArray[14])) {
				exactReturningFromDate =  new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[14]);
			}
			
			Date exactReturningToDate = null;
			if (!"".equals(dataForSearchArray[15])) {
				exactReturningToDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataForSearchArray[15]);
			}
			
			results = PmlFilePCCCLocalServiceUtil.filter(list, fileId, fileName,
					applicantName, address, telephone, email, fileStatus, fileType,
					receiveFromDate, receiveToDate, expectedReturningFromDate,
					expextedReturningToDate, inputDataFromDate, inputDataToDate,
					exactReturningFromDate, exactReturningToDate);
		}
		System.out.println("********results = " + results.size());
		for (int i = 0; i < results.size(); i++) {
			String issuingPlace = results.get(i).getIssuingPlace();
			System.out.println("**********issuing place************ " + issuingPlace);
		}
		return results;
	}
	
	/**
	 * lay log moi nhat cua ho so
	 * 
	 * @param fileId
	 * @return
	 */
	private PmlProcessDispose getProcessDipose(String fileId) {
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		PmlProcessDispose log = service.getCurrentLogFromFileId(fileId);
		return log;
	}

}
