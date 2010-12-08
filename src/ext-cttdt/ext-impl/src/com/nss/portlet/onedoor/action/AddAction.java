package com.nss.portlet.onedoor.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.CounterServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.attachedfile.model.AttachedFile;
import com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.impl.PmlFileAttachedFileImpl;
import com.nss.portlet.filetype.service.PmlFileAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCImpl;
import com.nss.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl;
import com.nss.portlet.onedoor.model.impl.PmlPaintDocumentImpl;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlPaintDocumentLocalServiceUtil;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class AddAction extends OneDoorProcessPortletAction {
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String message = "";
		try {
			// tao moi mot pmlFile
			String fileId = IdTemplateServiceUtil.generatedId(PmlOneDoorReceiveFile.class);
			String numberReceipt = fileId;
			String applicantName = ParamUtil.getString(req, "applicantName");
			Date applicationDate = ParamUtil.getDate(req, "applicationDate", new SimpleDateFormat("dd/MM/yyyy"));
			String fileTypeId = ParamUtil.getString(req, "fileTypeId");
			Date expectedReturningDate = ParamUtil.getDate(req, "expectedReturningDate", new SimpleDateFormat("dd/MM/yyyy"));
			String permanentAddress = ParamUtil.getString(req, "permanentAddress");
			String receiver = ParamUtil.getString(req, "receiver");
			long generalorderno = PmlOneDoorReceiveFileLocalServiceUtil.getGeneralNumberReceipt(ParamUtil.getString(req, "inputDataDate")) + 1;
			PmlOneDoorReceiveFile pmlFile = new PmlOneDoorReceiveFileImpl();
			
			pmlFile.setFileId(fileId);
			pmlFile.setNumberReceipt(numberReceipt);
			pmlFile.setApplicantName(applicantName);
			pmlFile.setApplicationDate(applicationDate);
			pmlFile.setFileTypeId(fileTypeId);
			pmlFile.setExpectedReturningDate(expectedReturningDate);
			pmlFile.setReceiverId(PortalUtil.getUserId(req));
			pmlFile.setPermanentAddress(permanentAddress);
			pmlFile.setReceiver(receiver);
			pmlFile.setGeneralorderno(generalorderno);
			
			addWorkflowParameter(req, "fileId", WorkflowParam.TRANSIENT, fileId);
			addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
			
			pmlFile = PmlOneDoorReceiveFileLocalServiceUtil.addPmlOneDoorReceiveFile(pmlFile);
			
			// tao pmlFilepccc
			String fileName = ParamUtil.getString(req, "fileName");
			String applicantRepresentation = ParamUtil.getString(req, "applicantRepresentation");
			String applicantTelephone = ParamUtil.getString(req, "applicantTelephone");
			String receiverRepresentation = ParamUtil.getString(req, "receiverRepresentation");
			String receiverTelephone = ParamUtil.getString(req, "receiverTelephone");
			String projectName = ParamUtil.getString(req, "projectName");
			String applicantCategory = ParamUtil.getString(req, "applicantCategory");
			String addressBuilder = ParamUtil.getString(req, "addressBuilder");
			String investor = ParamUtil.getString(req, "investor");
			String designCop = ParamUtil.getString(req, "designCop");
			int fileNumber = ParamUtil.getInteger(req, "fileNumber");
			String applicantTime = ParamUtil.getString(req, "applicantTime");
			String noteinformationManagement = ParamUtil.getString(req, "noteinformationManagement");
			int totalHour = ParamUtil.getInteger(req, "totalHour");
			int totalDate = ParamUtil.getInteger(req, "totalDate");
			String conclusion = ParamUtil.getString(req, "conclusion");
			Date inputDataDate = ParamUtil.getDate(req, "inputDataDate", new SimpleDateFormat("dd/MM/yyyy"));
			String receiveOfUnit = ParamUtil.getString(req, "receiverUnit");
			
			PmlFilePCCC pmlFilePCCC = new PmlFilePCCCImpl();
			
			pmlFilePCCC.setFileId(fileId);
			pmlFilePCCC.setFileName(fileName);
			pmlFilePCCC.setApplicantRepresentation(applicantRepresentation);
			pmlFilePCCC.setApplicantTelephone(applicantTelephone);
			pmlFilePCCC.setReceiverRepresentation(receiverRepresentation);
			pmlFilePCCC.setReceiverTelephone(receiverTelephone);
			pmlFilePCCC.setProjectName(projectName);
			pmlFilePCCC.setApplicantCategory(applicantCategory);
			pmlFilePCCC.setAddressBuilder(addressBuilder);
			pmlFilePCCC.setInvestor(investor);
			pmlFilePCCC.setDesignCop(designCop);
			pmlFilePCCC.setFileNumber(fileNumber);
			pmlFilePCCC.setInputDataDate(inputDataDate);
			pmlFilePCCC.setReceiveOfUnit(receiveOfUnit);
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(inputDataDate.getYear() + 1900, inputDataDate.getMonth(), inputDataDate.getDate());
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			Date date = df.parse(applicantTime);
			
			calendar.set(Calendar.HOUR_OF_DAY, date.getHours());
			calendar.set(Calendar.MINUTE, date.getMinutes());
			calendar.set(Calendar.SECOND, date.getSeconds());
			//yenlt update 16/04/2010
			pmlFilePCCC.setApplicantTime(applicantTime);
			//end
	//		pmlFilePCCC.setInputDataDate(inputDataDate);
			pmlFilePCCC.setNoteInformationManagement(noteinformationManagement);
			pmlFilePCCC.setTotalHour(totalHour);
			pmlFilePCCC.setTotalDate(totalDate);
			pmlFilePCCC.setConclusion(conclusion);
			
			pmlFilePCCC = PmlFilePCCCLocalServiceUtil.addPmlFilePCCC(pmlFilePCCC);
	
			String listnamepaint = ParamUtil.getString(req, "listnamepaint","");
			if (listnamepaint.trim().length() != 0) {
				String[] ar = listnamepaint.split("#");
				for (int i = 0; i < ar.length; i++) {
					PmlPaintDocument pmlPaintDocument = new PmlPaintDocumentImpl();
					String[] ars = ar[i].split("_");
					long paintDocumentId = CounterServiceUtil.increment();
					pmlPaintDocument.setPaintDocumentId(paintDocumentId);
					pmlPaintDocument.setFileId(fileId);
					pmlPaintDocument.setPaintDocumentName((ars[1]));
					pmlPaintDocument.setQuantity(Integer.parseInt(ars[2]));
					String note = "";
					try {
						note = ars[3];
					} catch (ArrayIndexOutOfBoundsException e) {
						note = "";
					}
					pmlPaintDocument.setNote(note);
					pmlPaintDocument = PmlPaintDocumentLocalServiceUtil.updatePmlPaintDocument(pmlPaintDocument);
					
				}
			}
	
			
			String listAttachFileId = ParamUtil.getString(req, "listAttachFileId", "");
					
			if ( listAttachFileId.trim().length() != 0) {
				String[] s = listAttachFileId.split("#");
				
				for (int i = 0; i < s.length; i++) {
					PmlFileAttachedFile pmlFileAttachedFile = new PmlFileAttachedFileImpl();
					String[] s1 = s[i].split("_");					
					long id = CounterLocalServiceUtil.increment();
					pmlFileAttachedFile.setFileAttachedFileId(String
							.valueOf(id));
					
					pmlFileAttachedFile.setFileId(fileId);
					pmlFileAttachedFile.setOriginal(Integer.parseInt(s1[1]));
					pmlFileAttachedFile.setCopy_(Integer.parseInt(s1[2]));
					if (s1.length > 3)  {
						pmlFileAttachedFile.setNote(s1[3]);
					}
					
					String attachedFileId = PmlFileTypeAttachedFileLocalServiceUtil.findByPrimaryKey(s1[0]).getAttachedFileId();
					pmlFileAttachedFile.setAttachedFileId(attachedFileId);
					
				    AttachedFile attachedFile = AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId);
				    pmlFileAttachedFile.setAttachedFileName(attachedFile.getAttachedFileName());
				    
					pmlFileAttachedFile = PmlFileAttachedFileLocalServiceUtil.updatePmlFileAttachedFile(pmlFileAttachedFile);
					
				}
			}
			
			message = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			message = FAIL;
		}
		req.setAttribute("message", message);
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		initDataForRender(req);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.nss.onedoor.add");
		}
	}
	
	private void initDataForRender(PortletRequest req) throws Exception{
		long userId = PortalUtil.getUserId((RenderRequest) req);
		String userName = PortalUtil.getUserName(userId, "");
		req.setAttribute("numberReceipt", "numberReceipt");
		req.setAttribute("userId", userId);
		req.setAttribute("userName", userName);
		
		List<PmlFileType> listFileType = PmlFileTypeLocalServiceUtil.findAll();
		req.setAttribute("listFileType", listFileType);
	}
}
