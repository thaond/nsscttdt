package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ext.portlet.util.StringUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp.PcccDocumentReceiptTempSearch;

public class ViewListDocumentReceiptTempAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewListDocumentReceiptTempAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm arg1,
			PortletConfig arg2, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, "DOC_CMD", "");
		if (!"".equals(cmd)) {
			if (cmd.equals("ADD_TO_DOCTEMP")) {
				addDocReceipt(req);
			}
		}
		
	}

	public void addDocReceipt(ActionRequest req) {
		long documentReceiptIdTemp = ParamUtil.getLong(req, "documentReceiptIdTemp", 0);
		PmlEdmDocumentReceiptTemp receiptTemp = null;
		try {
			receiptTemp = PmlEdmDocumentReceiptTempLocalServiceUtil.getPmlEdmDocumentReceiptTemp(documentReceiptIdTemp);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (null != receiptTemp) {
			try {
				String documentSendReference = receiptTemp.getSocongvandiphucdap();
				
				//long[] hosocongviecIdValues = ParamUtil.getLongValues(req, "HSCV");
				
				int levelSendId = receiptTemp.getLevelSendId();
				String issuingPlaceId = receiptTemp.getIssuingPlaceId();
				String issuingPlaceName = receiptTemp.getIssuingPlaceOtherName();
				issuingPlaceName = StringUtil.encodeHtml(issuingPlaceName);
				String documentReference = receiptTemp.getDocumentReference();
				documentReference = StringUtil.encodeHtml(documentReference);
				long documentTypeId = receiptTemp.getDocumentTypeId();	
				String signer = receiptTemp.getSigner();
				signer = StringUtil.encodeHtml(signer);
				String numberDocumentReceipt = receiptTemp.getNumberDocumentReceipt();
				numberDocumentReceipt = StringUtil.encodeHtml(numberDocumentReceipt);
				String privilegenLevelId = receiptTemp.getPrivilegeLevelId();
				String confidentialLevelId = receiptTemp.getConfidentialLevelId();
				String briefContent = receiptTemp.getBriefContent();
				briefContent = StringUtil.encodeHtml(briefContent);
				String thoigiannhancvden  = receiptTemp.getThoigiannhancvden();
				long orgExternalId = receiptTemp.getOrgExternalId();
				
				String isPublic = receiptTemp.getIsPublic();
				Date issuingDate = receiptTemp.getIssuingDate();
				Date dateArrive = receiptTemp.getDateArrive();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				// So tong hop
				int generalOrderNo = PmlEdmDocumentReceiptLocalServiceUtil.getGeneralNumberDocumentReceipt(sdf.format(receiptTemp.getDateArrive())) + 1;

				long documentReceiptId = 0;
//				long documentReceiptId = PmlEdmDocumentReceiptLocalServiceUtil.getMaxDocumentReceiptId() + 1;
				
				/*
				 * set attribute in documentReceipt object
				 */
//				if (Validator.isNotNull(hosocongviecIdValues)) {
//					PmlChiTietHSCV pmlChiTietHSCV = null;
//					for (int i = 0; i < hosocongviecIdValues.length; i++) {
//						pmlChiTietHSCV = new PmlChiTietHSCVImpl();
//						pmlChiTietHSCV.setIdChiTietHSCV(CounterLocalServiceUtil.increment());
//						pmlChiTietHSCV.setIdHoSoCongViec(hosocongviecIdValues[i]);
//						pmlChiTietHSCV.setIdCongVanDen(documentReceiptId);
//						PmlChiTietHSCVLocalServiceUtil.addPmlChiTietHSCV(pmlChiTietHSCV);
//					}
//				}
				
				List<PmlEdmDocumentReceipt> documentReceiptList = new ArrayList<PmlEdmDocumentReceipt>();
				PmlEdmDocumentReceipt documentReceipt = null;
//				new PmlEdmDocumentReceiptImpl();
				try {
					documentReceiptList = PmlEdmDocumentReceiptUtil.findByDocReceiptTempId_OrgExternalId(documentReceiptIdTemp, orgExternalId);
					documentReceiptId = documentReceiptList.get(0).getDocumentReceiptId();
				} catch (Exception e) {
					documentReceiptList = new ArrayList<PmlEdmDocumentReceipt>();
				}
				if (documentReceiptList.isEmpty()) {
					documentReceipt = new PmlEdmDocumentReceiptImpl();
					documentReceiptId = CounterLocalServiceUtil.increment();
					documentReceipt.setDocumentReceiptId(documentReceiptId);
					documentReceipt.setLevelSendId(levelSendId);
					documentReceipt.setIssuingPlaceId(issuingPlaceId);
					documentReceipt.setDocumentReference(documentReference);
					documentReceipt.setDocumentTypeId(documentTypeId);
					documentReceipt.setSigner(signer);
					documentReceipt.setNumberDocumentReceipt(numberDocumentReceipt);
					documentReceipt.setPrivilegeLevelId(privilegenLevelId);
					documentReceipt.setConfidentialLevelId(confidentialLevelId);
					documentReceipt.setThoigiannhancvden(thoigiannhancvden);
					documentReceipt.setBriefContent(briefContent);
					documentReceipt.setIsPublic(isPublic);
					documentReceipt.setIssuingDate(issuingDate);
					documentReceipt.setDateArrive(dateArrive);
					documentReceipt.setIssuingPlaceOtherName(issuingPlaceName);
					documentReceipt.setProcessTime(0);
					documentReceipt.setSocongvandiphucdap(documentSendReference);
					documentReceipt.setGeneralOrderNo((long)generalOrderNo);
					documentReceipt.setOrgExternalId(orgExternalId);
					documentReceipt.setDocReceiptTempId(documentReceiptIdTemp);
					
					User user = PortalUtil.getUser(req);
					PmlEdmDocumentReceiptLocalServiceUtil.addPmlEdmDocumentReceipt(user.getCompanyId(), documentReceipt);
					// thay id temp thanh id chinh
					List<PmlEdmAttachedFile> attachedFileList = new ArrayList<PmlEdmAttachedFile>();
					attachedFileList = PmlEdmAttachedFileUtil.findByObjectContentId(documentReceiptIdTemp);
					if (!attachedFileList.isEmpty()) {
						for (PmlEdmAttachedFile attachedFile : attachedFileList) {
							attachedFile.setObjectContentId(documentReceiptId);
							attachedFile = PmlEdmAttachedFileLocalServiceUtil.updatePmlEdmAttachedFile(attachedFile);
						}
					}
					
				}
				addWorkflowParameter(req, "userId", WorkflowParam.TRANSIENT, "" + PortalUtil.getUserId(req));
				addWorkflowParameter(req, "documentReceiptId", WorkflowParam.TRANSIENT, String.valueOf(documentReceiptId));
				addWorkflowParameter(req, com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, WorkflowParam.TRANSIENT, "true");
				addWorkflowParameter(req, "documentReceiptIdTemp", WorkflowParam.TRANSIENT, String.valueOf(documentReceiptIdTemp));

				req.setAttribute("documentReceiptId", documentReceiptId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm arg1,
			PortletConfig arg2, RenderRequest req, RenderResponse res)
			throws Exception {
		String hienTrang = ParamUtil.getString(req, "hienTrang", "vbquamang");
		req.setAttribute("hienTrang", hienTrang);
		
		String tabChung = ParamUtil.getString(req, "tabChung", "rad-letter-network");
		List<Long> listUser_LDVP_Long =  new ArrayList<Long>();
		listUser_LDVP_Long.add(PortalUtil.getUserId(req));
		req.setAttribute("userIdList", listUser_LDVP_Long);
		
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req,"timkiemtheotieuchi", false);
		String soVBDen = ParamUtil.getString(req, "sovanbanden", "");
		String soHieuGoc = ParamUtil.getString(req, "sohieugoc", "");
		int loaiSoVanBan = ParamUtil.getInteger(req, "loaisocongvan", 0); 
		String issuingplaceId = ParamUtil.getString(req, "issuingplaceId", "");
		String noiPhatHanh = ParamUtil.getString(req, "noiphathanh", "");
		String trichYeu = ParamUtil.getString(req, "trichyeu", "");
		String tuNgay = ParamUtil.getString(req, "tungay");
		String denNgay = ParamUtil.getString(req, "denngay");
//		String ngayHetHan = ParamUtil.getString(req, "ngayhethan");
		
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/list");
		portletURL.setParameter("hienTrang", hienTrang);
		portletURL.setParameter("tabChung", tabChung);
		for(int i = 0; i < listUser_LDVP_Long.size() ; i++) {			
			portletURL.setParameter(String.valueOf(listUser_LDVP_Long.get(i)),  String.valueOf(listUser_LDVP_Long.get(i)));
		}
		
		// yenlt update 20101022
		portletURL.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
		portletURL.setParameter("sovanbanden", soVBDen);
		portletURL.setParameter("sohieugoc", soHieuGoc);
		portletURL.setParameter("loaisocongvan", String.valueOf(loaiSoVanBan));
		portletURL.setParameter("issuingplaceId", issuingplaceId);
		portletURL.setParameter("noiphathanh", noiPhatHanh);
		portletURL.setParameter("trichyeu", trichYeu);
		portletURL.setParameter("tungay", tuNgay);
		portletURL.setParameter("denngay", denNgay);
//		portletURL.setParameter("ngayhethan", ngayHetHan);
		// end yenlt update 20101022
		
		PcccDocumentReceiptTempSearch searchContainerList = new PcccDocumentReceiptTempSearch(req, portletURL);
		int total1 = 0;
		List<PmlEdmDocumentReceiptTemp> results = null; 
		
		if (!timkiemtheotieuchi) {
			total1 = PmlEdmDocumentReceiptTempLocalServiceUtil.countAllList();
			results = PmlEdmDocumentReceiptTempLocalServiceUtil.getAllList(searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		} else {
			total1 = PmlEdmDocumentReceiptTempLocalServiceUtil.countPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc, loaiSoVanBan, 
					issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay);
			results = PmlEdmDocumentReceiptTempLocalServiceUtil.listPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc, loaiSoVanBan,
					issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		}
		
		String portletURLString = portletURL.toString();
		req.setAttribute("view.jsp-portletURL", portletURL);
		req.setAttribute("view.jsp-portletURLString", portletURLString);
		req.setAttribute("results", results);
		req.setAttribute("total1", total1);
		req.setAttribute("searchContainerList", searchContainerList);
		
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.listdoctemp");
	}

}
