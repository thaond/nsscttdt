package com.sgs.portlet.pml_ho_so_cong_viec.action;

import java.text.DateFormat;
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

import com.ext.portlet.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.onedoorpccc.ajax.OnedoorDwr;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;

public class DetailAction extends DocumentReceiptPortletAction {
//public class DetailAction extends PortletAction {
	
	
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	
	}
			
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
																		
		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);
		
		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default
		
		
		
		PmlEdmDocumentReceiptDTO documentReceiptDTO = new PmlEdmDocumentReceiptDTO();
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		PmlEdmDocumentReceipt document = PmlEdmDocumentReceiptLocalServiceUtil
								.getPmlEdmDocumentReceipt(documentReceiptId);
		
		documentReceiptDTO = populateDocumentReceiptToDTO2(req, document);
		
		List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil
						.findByObjectContentId_ObjectType(documentReceiptId, 
							new PmlEdmDocumentReceiptImpl().getClass().getName());
		
		List<PmlEdmAttachedFile> formatAttachedFiles = new ArrayList<PmlEdmAttachedFile>();
		/* format name of attached file */
		
		if (attachedFiles != null) {
			for (int i = 0; i < attachedFiles.size(); i++) {
				PmlEdmAttachedFile attachedFile = attachedFiles.get(i);
				String name = attachedFile.getAttachedFileName();
				String subName = name.substring(Constants.NUMBER_REFIX_ATTACHEDFILE);
				attachedFile.setAttachedFileName(subName);
				
				formatAttachedFiles.add(attachedFile);
			}
		}
		
		String documentRecordTypeName = getDocumentRecordTypeName(req);
		
		
		req.setAttribute("documentRecordTypeId", documentRecordTypeName);
		req.setAttribute("documentDTO", documentReceiptDTO);
		//req.setAttribute("documentReceiptId", documentReceiptId);
		req.setAttribute("attachedFiles", formatAttachedFiles);
		
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);
		
		
		//lay hscv
		List<PmlChiTietHSCV> chiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		try {
			chiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDen(documentReceiptId);
		} catch (Exception e) {
			
		}
		
		List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
		if (chiTietHSCVList.size() > 0) {
		
			PmlHoSoCongViec pmlHoSoCongViec = null;
			for (PmlChiTietHSCV pmlChiTietHSCV : chiTietHSCVList) {
				try {
					pmlHoSoCongViec = PmlHoSoCongViecUtil.findByPrimaryKey(pmlChiTietHSCV.getIdHoSoCongViec());
				} catch (Exception e) {	}
					
				if (pmlHoSoCongViec != null) {
					pmlHoSoCongViecList.add(pmlHoSoCongViec);
				}
					
			}
			
		}
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		//watch series process
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogListTemp = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);		
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = new ArrayList<PmlDocumentReceiptLog>();
		
		for (int i = pmlDocumentReceiptLogListTemp.size() -1; i >= 0; i--) {
			if(0 == pmlDocumentReceiptLogListTemp.get(i).getType_()) {
			pmlDocumentReceiptLogList.add(pmlDocumentReceiptLogListTemp.get(i));
			}
		}
		
		req.setAttribute("pmlDocumentReceiptLogList", pmlDocumentReceiptLogList);
		
		getTimeProcessOnDeparment(req);
		
		/* get current node by fileId */
		
		//DocumentReceiptLiferayWorkflowService service = new DocumentReceiptLiferayWorkflowService();
		//service.updateReceiveDate(documentReceiptId, PortalUtil.getUserId(req));
		
	
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pml_ho_so_cong_viec.detail");
			}
	}
	
	private String getDocumentRecordTypeName(RenderRequest req) throws Exception {
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);
		long documentTypeId = documentReceipt.getDocumentTypeId();
		PmlEdmDocumentType documentType = PmlEdmDocumentTypeLocalServiceUtil
				.getPmlEdmDocumentType(documentTypeId);

		int documentRecordTypeId = documentType.getDocumentRecordTypeId();
		PmlEdmDocumentRecordType documentRecordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(documentRecordTypeId);
		return documentRecordType.getDocumentRecordTypeName();
	}
	
	
	/**
	 * get days process on main deparmetn 
	 * @param req
	 * @return List<Integer>
	 *
	 */
	
	private void getTimeProcessOnDeparment(RenderRequest req) throws Exception {
		int result = 0; 
		String expireDateProcess = "";
		String mainProcessName = "";
		String mainDepartmentName = "";
		String processInformation = "";
		try {
			long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
			List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList  = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			if (pmlDocumentReceiptLogList != null && pmlDocumentReceiptLogList.size() > 0) {
				List<PmlDocumentReceiptLog> resultList  = new ArrayList<PmlDocumentReceiptLog>();
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {
					String inf = pmlDocumentReceiptLogList.get(i).getProcessInfomation();
					if (!"".equals(inf)) {
						processInformation = inf;
						break;
					}
				}
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {			
					/* phmphuc close and change 10/12/2010
					if (pmlDocumentReceiptLogList.get(i).getNumDateProcess() > 0) {
						result =  pmlDocumentReceiptLogList.get(i).getNumDateProcess();						
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date dateProcess = pmlDocumentReceiptLogList.get(i).getDateProcess();
						long numberDateRemain = result - (dateFormat.parse(dateFormat.format(new Date())).getTime() - dateFormat.parse(dateFormat.format(pmlDocumentReceiptLogList.get(i).getDateProcess())).getTime( ))/ (24 * 60 * 60 * 1000);
						
						OnedoorDwr onedoorDwr = new OnedoorDwr();
						expireDateProcess = onedoorDwr.getExpectedReturningDate(""+numberDateRemain, dateFormat.format(dateProcess));
						resultList.add(pmlDocumentReceiptLogList.get(i));
					}
					*/
					if (pmlDocumentReceiptLogList.get(i).getExpiredDate() != null) {
						
						result = pmlDocumentReceiptLogList.get(i).getNumDateProcess();						
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						expireDateProcess = dateFormat.format(pmlDocumentReceiptLogList.get(i).getExpiredDate());
						break; 
					}
				}
				
				if (resultList.size() > 1) {
					long mainProcessId = resultList.get(0).getReceiver();
					PmlUser mainProcess = PmlUserLocalServiceUtil.getPmlUser(mainProcessId);
					
					String departmentId = mainProcess.getDepartmentsId();
					Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
					mainDepartmentName = department.getDepartmentsName();
					
					User mainUser = UserLocalServiceUtil.getUser(mainProcessId);
					mainProcessName = mainUser.getLastName() + " " + mainUser.getMiddleName() + " " + mainUser.getFirstName();
				}
				else if (resultList.size() > 0) {
					long mainProcessId = resultList.get(0).getReceiver();
					PmlUser mainProcess = PmlUserLocalServiceUtil.getPmlUser(mainProcessId);
					String departmentId = mainProcess.getDepartmentsId();
					
					Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
					mainDepartmentName = department.getDepartmentsName();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("daysProcessDeparmentMain", "" + result);
		req.setAttribute("expireDateProcess", "" + expireDateProcess);
		req.setAttribute("mainProcessName", mainProcessName);
		req.setAttribute("mainDepartmentName", mainDepartmentName);
		req.setAttribute("processInformation", processInformation);
	}
	
}