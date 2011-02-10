package com.sgs.portlet.onedoorfileprocessed.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoorfileprocessed.search.OneDoorFileProcessedSearch;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
				String type = ParamUtil.getString(req, "type", "");
				String valueType = ParamUtil.getString(req, "valueType", "");		
				
				String beginDateParam = ParamUtil.getString(req,"beginDate", "");
				String endDateParam = ParamUtil.getString(req,"endDate","");
				
				// load du lieu tiep theo
				int lastMsgId = ParamUtil.getInteger(req, "last_msg_id", 0);
				boolean loadData = ParamUtil.getBoolean(req, "loadData", false);
				
				String sort = ParamUtil.getString(req,"sort","");
				
				if (!"".equals(valueType)) {
					fileTypeFilter = "";
					beginDateParam = "";
					endDateParam = "";
				}
				
				if (!"".equals(beginDateParam) && !"".equals(endDateParam)   ) {
					valueType = beginDateParam +"_" + endDateParam;
					fileTypeFilter = "";
				} 
				
				if (!"".equals(fileTypeFilter)) {
					valueType = fileTypeFilter;
					beginDateParam = "";
					endDateParam = "";
				}
				
				PortletSession session = req.getPortletSession(true);
				List<String> valueTypeList = (List<String>) session.getAttribute("keyWordList", PortletSession.APPLICATION_SCOPE);
				List<String> typeList = (List<String>) session.getAttribute("typeFilterList", PortletSession.APPLICATION_SCOPE);
				if (!loadData) {
					if ("".equals(type)&& !"sort".equals(sort)) {
						valueTypeList = new ArrayList<String>();
						typeList = new ArrayList<String>();
					}
					
					if (valueTypeList == null) {
						valueTypeList = new ArrayList<String>();
						if (!"".equals(type)) {
							valueTypeList.add(valueType);
						}
					} else {
						if (!"".equals(type)) {
							valueTypeList.add(valueType);
						}
					}
			
					if (typeList == null) {
						typeList = new ArrayList<String>();
						if (!"".equals(type)) {
							typeList.add(type);
						}
					} else {
						if (!"".equals(type)) {
							typeList.add(type);
						}	
					}
					
					session.setAttribute("keyWordList", valueTypeList,PortletSession.APPLICATION_SCOPE);
					session.setAttribute("typeFilterList", typeList,PortletSession.APPLICATION_SCOPE);
				}
				
				// Dieu kien sort cua danh sach can xu ly
				PortletURL portletURL = res.createRenderURL();
				portletURL.setWindowState(WindowState.MAXIMIZED);
				portletURL.setParameter("struts_action", "/sgs/onedoorpcccprocessed/view");
				portletURL.setParameter("type", type);
				portletURL.setParameter("valueType", valueType);
				portletURL.setParameter("beginDateParam", beginDateParam);
				portletURL.setParameter("endDateParam", endDateParam);
				portletURL.setParameter("fileTypeFilter", fileTypeFilter);
				
				OneDoorFileProcessedSearch searchContainer = new OneDoorFileProcessedSearch(req, portletURL);
				
				long userId = PortalUtil.getUserId(req);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				int year = calendar.get(Calendar.YEAR);
				
				List<PmlFilePcccDTO> listFileDTO = new ArrayList<PmlFilePcccDTO>();
				
				listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator()));
				// phan loc theo loai ho so
				List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
				try {
					fileTypeList = PmlFileTypeUtil.findAll();
				} catch (Exception e) {
					fileTypeList = new ArrayList<PmlFileType>();
					//System.out.println("ERROR: Get List FileType: "+ e.getMessage());
				}
				
				req.setAttribute("sort", sort);
				req.setAttribute("loadData", loadData);
				
				req.setAttribute("type", type);
				req.setAttribute("valueType", valueType);
				req.setAttribute("beginDateParam", beginDateParam);
				req.setAttribute("endDateParam", endDateParam);
				
				req.setAttribute("lastMsgId", lastMsgId);
				req.setAttribute("fileTypeList", fileTypeList);
				req.setAttribute("fileTypeFilter", fileTypeFilter);
				
				req.setAttribute("listFileDTO", listFileDTO);
				
				return mapping.findForward("portlet.sgs.onedoorfileprocessed.view");
			}
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccDTO(List<PmlOneDoorReceiveFile> list) throws Exception {

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
			
			filePcccDTO.setExpectedReturingDate(file.getExpectedReturningDate());
			filePcccDTO.setFileId(file.getFileId());
			filePcccDTO.setGender(file.getGender());
			filePcccDTO.setIdNumber(file.getIdNumber());
			
			filePcccDTO.setIssuingDate(file.getIssuingDate());
			filePcccDTO.setIssuingPlace(file.getIssuingPlace());
			filePcccDTO.setNumberReceipt(file.getNumberReceipt());
			filePcccDTO.setOrganization(file.getOrganization());
			filePcccDTO.setOtherContent(file.getOtherContent());
			// phmphuc update 20/04/2010
			filePcccDTO.setGeneralorderno(file.getGeneralorderno());
			// end
			
			filePcccDTO.setPermanentAddress(file.getPermanentAddress());
			filePcccDTO.setReceiver(file.getReceiver());
			filePcccDTO.setSolvingTime(file.getSolvingTime());
			filePcccDTO.setTelephone(file.getTelephone());

			// gan gia tri hien thi voi filePCCC
			PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(file
					.getFileId());
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

			// gan gia tri hien thi voi fileType
			PmlFileType fileType = null;
			try {
				fileType = PmlFileTypeUtil.findByPrimaryKey(file.getFileTypeId());
				filePcccDTO.setFiletype(fileType.getFileTypeName());
			}catch (Exception e) {
				filePcccDTO.setFiletype("");
			}

			PmlProcessDispose log = null;
			try {
				log = getProcessDipose(file.getFileId());
			} catch (Exception e) { }
			
			if (log != null) {
				
				filePcccDTO.setSendDate(log.getSendDate());
				filePcccDTO.setReceiveDate(log.getReceiveDate());
				filePcccDTO.setExpireDate(log.getExpiredDate());
				
				PmlStateProcess status = null;
				if (0 != log.getStateProcessIdAfter()) {
					status = PmlStateProcessUtil.findByPrimaryKey(log.getStateProcessIdAfter());
				} else {
					status = PmlStateProcessUtil.findByPrimaryKey(log.getStateProcessIdBefore());
				}
				
				try {					
					PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(status.getStateProcessId()).get(0);
					filePcccDTO.setStatus(fileStatusStateProcess.getDescription()); // status
				} catch (Exception e) {
					filePcccDTO.setStatus("");
				}
			}
			
			result.add(filePcccDTO);
		}
		return result;
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
