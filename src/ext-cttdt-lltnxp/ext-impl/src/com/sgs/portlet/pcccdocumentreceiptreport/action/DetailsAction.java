package com.sgs.portlet.pcccdocumentreceiptreport.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil;
import com.ext.portlet.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class DetailsAction extends DocumentReceiptPortletAction {
	
	
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
		
		PmlEdmDocumentReceiptDTO documentReceiptDTO = new PmlEdmDocumentReceiptDTO();
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		PmlEdmDocumentReceipt document = PmlEdmDocumentReceiptLocalServiceUtil
								.getPmlEdmDocumentReceipt(documentReceiptId);

		documentReceiptDTO = populateDocumentReceiptToDTO(req, document);
		
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
		req.setAttribute("attachedFiles", formatAttachedFiles);
		
		//lay so cong van den cua phong
		long userId = PortalUtil.getUserId(req);
		PmlUser pmlUser =null;
		String departmentId = "";
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
		} catch (Exception e) {
			pmlUser = null;
		}
		if (null != pmlUser) {
			departmentId = pmlUser.getDepartmentsId();
		}
		
		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = null;
		try {
			pmlEdmBookDocumentRecordToList = PmlEdmBookDocumentRecordToUtil.findByDocumentReceiptId(documentReceiptId);
		} catch (Exception e) {
			pmlEdmBookDocumentRecordToList = new ArrayList<PmlEdmBookDocumentRecordTo>();
		}
		
		long documentRecordToId = 0;
		PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = null;  
		String soCongVanDenHientai = "";
		for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : pmlEdmBookDocumentRecordToList) {
			documentRecordToId = pmlEdmBookDocumentRecordTo.getDocumentRecordToId();
			try {
				pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToUtil.findByPrimaryKey(documentRecordToId);
			} catch (Exception e) {
				pmlEdmDocumentRecordTo = null;
			}
			
			if (null != pmlEdmDocumentRecordTo && departmentId.equals(pmlEdmDocumentRecordTo.getDepartmentsId()) ) {
				soCongVanDenHientai = String.valueOf(pmlEdmBookDocumentRecordTo.getSoCongVanDenPhongHienTai());
				break;
			}
		}
		
		req.setAttribute("soCongVanDenHientai", soCongVanDenHientai);
		
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
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);

		// Sap xep thu tu luan chuyen van ban tang dan theo thoi gian
		if (!pmlDocumentReceiptLogList.isEmpty()) {
			Collections.sort(pmlDocumentReceiptLogList, new Comparator<PmlDocumentReceiptLog>(){
				public int compare(PmlDocumentReceiptLog obj1, PmlDocumentReceiptLog obj2) {   
					if (obj1.getTransition_() < obj2.getTransition_()) return -1;
					if (obj1.getTransition_() == obj2.getTransition_()) return 0;
					return 1;
				}                                        
			});
		} // end if
		
		req.setAttribute("pmlDocumentReceiptLogList", pmlDocumentReceiptLogList);
		
		getTimeProcessOnDeparment(req);
		
		
		//truyen cach thuc xu ly tuong ung cong van len trang detail.jsp
		long documentId = ParamUtil.getLong(req, "documentReceiptId");
		ProcessType pt_tmp = null;
		if (documentId != 0){
			List<SaveProcessType> lstSavePT= SaveProcessTypeLocalServiceUtil.getProcessTypeByDocId(documentId);
			
			//lay ra danh sach cach thuc xu ly tuong ung cong van
			List<ProcessType> lstPT = new ArrayList<ProcessType>();
			if (lstSavePT != null) {
				Iterator<SaveProcessType> itrSavePT = lstSavePT.iterator();
				while (itrSavePT.hasNext()) {
					SaveProcessType saveProcessType = (SaveProcessType) itrSavePT.next();
					pt_tmp = ProcessTypeLocalServiceUtil.getProcessTypeById(saveProcessType.getFlagProcessType());
					if(pt_tmp != null) lstPT.add(pt_tmp);
				}
			}
			req.setAttribute("listprocesstype_doc",lstPT);
		}
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptreport.details");
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
//				List<PmlDocumentReceiptLog> resultList  = new ArrayList<PmlDocumentReceiptLog>();
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {
					String inf = pmlDocumentReceiptLogList.get(i).getProcessInfomation();
					if (!"".equals(inf)) {
						processInformation = inf;
						break;
					}
				}
				
				for (int i = 0; i < pmlDocumentReceiptLogList.size(); i++) {			
					if (pmlDocumentReceiptLogList.get(i).getExpiredDate() != null) {
						
						result = pmlDocumentReceiptLogList.get(i).getNumDateProcess();						
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						expireDateProcess = dateFormat.format(pmlDocumentReceiptLogList.get(i).getExpiredDate());
						break; 
					}
				}
				
				
				/* phmphuc close 10/06/2010
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
				}*/
				
				// lay phong ban xu ly chinh va chuyen vien xu ly chinh
				try {
					PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					// phong ban xu ly chinh
					String departmentId = documentReceipt.getMainDepartmentProcessId();
					Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
					mainDepartmentName = department.getDepartmentsName();
					
					// chuyen vien xu ly chinh
					long mainProcessId = documentReceipt.getMainUserProcessId();
					User mainUser = UserLocalServiceUtil.getUser(mainProcessId);
					mainProcessName = mainUser.getLastName() + " " + mainUser.getMiddleName() + " " + mainUser.getFirstName();
					
				} catch (Exception e) {
					mainDepartmentName = "";
					mainProcessName = "";
				}
				// end
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
