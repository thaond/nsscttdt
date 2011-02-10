package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.document.util.DataReportUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.dto.QuanLyCongVanDTO;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.QuanLyCongVanUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;

public class ViewAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactoryUtil.getLog(ViewAction.class);
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		if (Validator.isNull(cmd) == false) {
			if (cmd.equals("printReport")) { // Report
				String reportType = ParamUtil.getString(req, "reportType");
				if (reportType.equals("word")) { // Xuat file Word
					printReport(req, res);
				} else if (reportType.equals("excel")) { // Xuat file Excel
					
				}
			}
		}
	}
	
	
	private void printReport(ActionRequest req, ActionResponse res) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		QuanLyCongVanUtil rtfUtil = new QuanLyCongVanUtil(request.getSession().getServletContext().getRealPath("reports"),
				getListDocumentReceiptDTOByStatusId(req));
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/BaoCaoSoCongVanDen_New.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	
	private List<QuanLyCongVanDTO> getListDocumentReceiptDTOByStatusId(ActionRequest req) throws Exception {
		List<QuanLyCongVanDTO> results = new ArrayList<QuanLyCongVanDTO>();
					
		long userId = PortalUtil.getUserId(req);
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");//yenlt 14/04/2010
		String nguoiXuLy = ParamUtil.getString(req, "nguoiXuLy", "xuLyChung");
		int leveSendId = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI, 0);
		int loaiCVID = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN, 0);
		//end
		
		// phmphuc them 21/04/2010
		String cachThucXuLy = ParamUtil.getString(req, "cachThucXuLy", "-1");
		
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(userId);
		// end
		
		// yenlt update 20101021
		
		String soVBDen = ParamUtil.getString(req, "sovanbanden", "");
		String soHieuGoc = ParamUtil.getString(req, "sohieugoc", "");
		int loaiSoVanBan = ParamUtil.getInteger(req, "loaisocongvan", 0); 
		String issuingplaceId = ParamUtil.getString(req, "issuingplaceId", "");
		String noiPhatHanh = ParamUtil.getString(req, "noiphathanh", "");
		String trichYeu = ParamUtil.getString(req, "trichyeu", "");
		String tuNgay = ParamUtil.getString(req, "tungay");
		String denNgay = ParamUtil.getString(req, "denngay");
		String ngayHetHan = ParamUtil.getString(req, "ngayhethan");
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req,"timkiemtheotieuchi", false);
		// end yenlt update 20101021
		List<PmlEdmDocumentReceipt> documentReceipts = new ArrayList<PmlEdmDocumentReceipt>();
		List<PmlEdmDocumentReceiptTemp> documentReceiptsTemp = new ArrayList<PmlEdmDocumentReceiptTemp>(); 
		DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
		
		/*
		 * Lay danh sach cong van dang xu ly
		 */
		if ("dangXuLy".equals(hienTrang)) {
			if (statusId == 0) {
				documentReceipts = workflowService.getListPmlEdmDocumentReceiptsByUser(userId);
			}
//			
			else {
				if (isExpired == false) {
					// phmphuc update 21/04/2010
//					documentReceipts = workflowService.getListDocumentByStatusId(userId, statusId);
					if (!timkiemtheotieuchi) {
						documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(userIdList, statusId, 
								String.valueOf(loaiCVID), String.valueOf(leveSendId), cachThucXuLy, -1, -1, null);
						//  end
					} else { // yenlt 20101021
						documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(userIdList, statusId, soVBDen, soHieuGoc,
									loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
					}
				}
				else {
					// phmphuc update 21/04/2010
//					documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy_TreHan(userId, new Date(), statusId);
					if (!timkiemtheotieuchi) {
						documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIdList, statusId, 
								String.valueOf(loaiCVID), String.valueOf(leveSendId), -1, -1, null);
						// end
					} else {
						documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIdList, statusId, soVBDen, 
								soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
					}
				}
			}
		}
		
		/*
		 * Lay danh sach cong van da xu ly
		 */
		else if ("daXuLy".equals(hienTrang)) {
			if (statusId == 0) {
				List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
				for (PmlFileStatus pmlFileStatus : list) {
					long fileStatusId = pmlFileStatus.getFileStatusId();
					documentReceipts.addAll(DataReportUtil.getListDocumentReceipt_DaXuLy(userId, fileStatusId, year));
				}
			}
			
			else {
				if (isExpired == false) {
					if ("xuLyChung".equals(nguoiXuLy)) {
						if (!timkiemtheotieuchi) {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung(userId, String.valueOf(year), String.valueOf(leveSendId), String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
						}
					} else if ("tuXuLy".equals(nguoiXuLy)) {
						if (!timkiemtheotieuchi) {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy(userId, String.valueOf(year), 
									String.valueOf(leveSendId), String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
						}
					}
				}
				else {
					if ("xuLyChung".equals(nguoiXuLy)) {
						if (!timkiemtheotieuchi) {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung_treHan(userId, String.valueOf(year), 
									String.valueOf(leveSendId), String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
							
						}
					} else if ("tuXuLy".equals(nguoiXuLy)) {
						if (!timkiemtheotieuchi) {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy_treHan(userId, String.valueOf(year), 
									String.valueOf(leveSendId), String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, -1, -1, null);
						}
					}
				}
			}
		} else if ("vbquamang".equals(hienTrang)) { // yenlt update 20101101
			if (!timkiemtheotieuchi) {
				documentReceiptsTemp = PmlEdmDocumentReceiptTempLocalServiceUtil.getAllList(-1, -1, null);
			} else {
				documentReceiptsTemp = PmlEdmDocumentReceiptTempLocalServiceUtil.listPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc, loaiSoVanBan,
						issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, -1, -1, null);
			}
		} // end yenlt update 20101101
		
		QuanLyCongVanDTO quanLyCongVanDTO = null;
		PmlEdmDocumentReceiptDTO documentReceiptDTO = null;

		int stt = 1;
		if ( documentReceipts.size() != 0){
			for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : documentReceipts) {
//				pmlEdmDocumentReceipt.setStatusId(statusId);
				documentReceiptDTO = populateDocumentReceiptToDTO(req, pmlEdmDocumentReceipt);
				
				quanLyCongVanDTO = new QuanLyCongVanDTO();
				quanLyCongVanDTO.setStt(stt + ".");
				quanLyCongVanDTO.setSoCVDen(StringUtils.convertToRTF(documentReceiptDTO.getNumberDocumentReceipt()));
				quanLyCongVanDTO.setSoHieu(StringUtils.convertToRTF(documentReceiptDTO.getDocumentReference()));
				quanLyCongVanDTO.setNgayDen(new SimpleDateFormat("dd/MM/yyyy").format(documentReceiptDTO.getDateArrive()) );
				quanLyCongVanDTO.setNoiPhatHanh(StringUtils.convertToRTF(documentReceiptDTO.getIssuingPlaceName()));
				quanLyCongVanDTO.setTrichYeu(StringUtils.convertToRTF(documentReceiptDTO.getBriefContent()));
				// phmphuc update 21/04/2010
//				String stateProcessCode = documentReceiptDTO.getState();
//				PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcessCode).get(0);
				
				// lay trang thai hien thi giong trang list.jsp
				PmlDocumentReceiptLog documentReceiptLog = null;
				try {
					documentReceiptLog =  PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
							pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdList.get(0) , null , 0).get(0);
				} catch (Exception e) {	
					if (!userIdList.isEmpty()) {
						List<PmlDocumentReceiptLog> tmpDocRecLogs = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_StateProcessIdAfter(
								pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdList.get(0) , 0);
						if (!tmpDocRecLogs.isEmpty()) {
							documentReceiptLog = tmpDocRecLogs.get(0);
						}
					}
				}
				
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				if (documentReceiptLog != null) {
					try {
						fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, documentReceiptLog.getStateProcessIdBefore()).get(0);
					} catch (Exception e) {
						fileStatusStateProcess = null;
					}
				}
				
				String procTypeDesc = ""; 
				if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("1")) { // VB luu tham khao
					procTypeDesc = " (VB l\u01B0u tham kh\u1EA3o)";
				} 
				else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("2")) { // VB bao cao
					procTypeDesc = " (VB b\u00E1o c\u00E1o)";
				} 
				else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("3")) { // VB can soan vb tra loi
					procTypeDesc = " (VB ph\u1EA3i so\u1EA1n VB tr\u1EA3 l\u1EDDi)";
				}
				
				if (fileStatusStateProcess != null) {
					if (fileStatusStateProcess.getDescription().trim().length() > 0) {
						if (procTypeDesc.length() > 0) {
							quanLyCongVanDTO.setTrangThai(StringUtils.convertToRTF(fileStatusStateProcess.getDescription().trim() + "\n" + procTypeDesc));
						} 
						else {
							quanLyCongVanDTO.setTrangThai(StringUtils.convertToRTF(fileStatusStateProcess.getDescription().trim()));
						} 
					} 
					else {
						quanLyCongVanDTO.setTrangThai("");
					} 
				} else {
					quanLyCongVanDTO.setTrangThai(StringUtils.convertToRTF(procTypeDesc));
				}
				// end
				
				results.add(quanLyCongVanDTO);
				stt ++;
			}
		} else if (!documentReceiptsTemp.isEmpty()) { // yenlt update 20101101
			for (PmlEdmDocumentReceiptTemp documentReceiptTemp : documentReceiptsTemp) {
				String issuingPlaceName = "";
				String issuingPlaceId = documentReceiptTemp.getIssuingPlaceId();
				
				try {
					PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil
							.getPmlEdmIssuingPlace(issuingPlaceId);
					issuingPlaceName = issuingPlace.getIssuingPlaceName();
				} catch (Exception e) {
					issuingPlaceName = documentReceiptTemp.getIssuingPlaceOtherName();
				}
								
				quanLyCongVanDTO = new QuanLyCongVanDTO();
				quanLyCongVanDTO.setStt(stt + ".");
				quanLyCongVanDTO.setSoCVDen(StringUtils.convertToRTF(documentReceiptTemp.getNumberDocumentReceipt()));
				quanLyCongVanDTO.setSoHieu(StringUtils.convertToRTF(documentReceiptTemp.getDocumentReference()));
				quanLyCongVanDTO.setNgayDen(new SimpleDateFormat("dd/MM/yyyy").format(documentReceiptTemp.getDateArrive()) );
				quanLyCongVanDTO.setNoiPhatHanh(StringUtils.convertToRTF(issuingPlaceName));
				quanLyCongVanDTO.setTrichYeu(StringUtils.convertToRTF(documentReceiptTemp.getBriefContent()));
				
				results.add(quanLyCongVanDTO);
				stt ++;
			}
		} else {
			quanLyCongVanDTO = new QuanLyCongVanDTO();
			results.add(quanLyCongVanDTO);
		}
		
		return results;
	}
	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		//yenlt update 21/04/2010
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");
		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
		String nguoiXuLy = ParamUtil.getString(req, "nguoiXuLy", "xuLyChung");
		String cachThucXuLy = ParamUtil.getString(req, "cachThucXuLy", "-1");
		String tabChung = ParamUtil.getString(req,"tabChung","rad-letter-process");
		 
		// phmphuc close and change by under code 11/11/2010
//		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordTypes(-1, -1);
		// lay so van ban theo loai VB
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
		int documentRecordTypeId = 0;
		PmlEdmDocumentRecordType recordType = null;
		for (PmlEdmDocumentType documentType : documentTypes) {
			documentRecordTypeId = documentType.getDocumentRecordTypeId();
			try {
				recordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(documentRecordTypeId);
				if (!pmlEdmDocumentRecordTypeList.contains(recordType)) {
					pmlEdmDocumentRecordTypeList.add(recordType);
				}
			} catch (Exception e) { }
		}
		// end phmphuc update 11/11/2010
		
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentTypes(-1, -1);
		req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
		req.setAttribute("pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
		
		req.setAttribute("statusId", statusId);
		req.setAttribute("hienTrang", hienTrang);
		req.setAttribute("isExpired", isExpired);
		req.setAttribute("year", year);
		req.setAttribute("nguoiXuLy", nguoiXuLy);
		req.setAttribute("cachThucXuLy", cachThucXuLy);
		req.setAttribute("tabChung", tabChung);
		//end
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.view");
	}
	
}