package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.io.InputStream;
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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.document.util.DataReportUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import net.sourceforge.rtf.StringUtils;

import com.sgs.portlet.pcccdocumentsendprocess.dto.QuanLyCongVanDiDTO;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchTerms;
import com.sgs.portlet.pcccdocumentsendprocess.util.QuanLyCongVanDiUtil;

public class ViewAction extends DocumentSendPortletAction {
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

	
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
				String transitionBack = ParamUtil.getString(req,"transitionBack","");
				req.setAttribute("transitionBack", transitionBack);
				
				//yenlt update 22/04/2010
				long statusId = ParamUtil.getLong(req, "statusId", 0);
				boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
				String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");
				int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
				String nguoiXuLy = ParamUtil.getString(req, "nguoiXuLy", "xuLyChung");
				
				req.setAttribute("statusId", statusId);
				req.setAttribute("hienTrang", hienTrang);
				req.setAttribute("isExpired", isExpired);
				req.setAttribute("year", year);
				req.setAttribute("nguoiXuLy", nguoiXuLy);
				//end

				return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.view");
	}
	
	private List<QuanLyCongVanDiDTO> getListDocumentSendDTOByStatusId(ActionRequest req) throws Exception {
		List<QuanLyCongVanDiDTO> results = new ArrayList<QuanLyCongVanDiDTO>();
		
		long userId = PortalUtil.getUserId(req);
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");// yenlt 14/04/2010
		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
		
		// phmphuc them 21/04/2010
		int loaiCVID = ParamUtil.getInteger(req, PcccDocumentSendProcessSearchTerms.LOAISOCONGVAN, 0);
		
		String nguoiXuLy = ParamUtil.getString(req, "nguoiXuLy", "xuLyChung");
		
		List<Long> userIdList = new ArrayList<Long>();
		userIdList.add(userId);
		// end
		
		List<PmlEdmDocumentSend> documentSends = new ArrayList<PmlEdmDocumentSend>();
		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		
		//yenlt update 20101023
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req, "timkiemtheotieuchi", false);
		String soKyHieu = ParamUtil.getString(req, "soKyHieu" , "");
		long loaiVB = ParamUtil.getLong(req, "loaisocongvan", 0);
		String donViSoanThao = ParamUtil.getString(req, "donViSoanThao", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String coQuanNhan = ParamUtil.getString(req, "coQuanNhan", "");
		
		String tuNgay = ParamUtil.getString(req, "tuNgay", "");
		String denNgay = ParamUtil.getString(req, "denNgay", "");
		
		if ("dangXuLy".equals(hienTrang)) {
			if (statusId != 0) {
				if (isExpired == false) {
					// phmphuc update 22/04/2010
//					documentSends = workflowService.getListDocumentByStatusId(userId, statusId);
					if (timkiemtheotieuchi == false) {
						documentSends = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy(userIdList, statusId, 
								String.valueOf(loaiCVID), "tatca", -1, -1, null);
						// end
					} else {
						documentSends = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy1(userIdList, statusId, loaiVB,
								soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
					}
				}
				else {
					// phmphuc update 22/04/2010
//					documentSends = DataReportUtil.getListDocumentSendForTreHan(userId, new Date(), statusId);
					if (timkiemtheotieuchi == false) {
						documentSends = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy_TreHan(userIdList, statusId, 
								String.valueOf(loaiCVID), "tatca", -1, -1, null);
						// end
					} else {
						documentSends = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy_TreHan1(userIdList, statusId, loaiVB,
								soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
					}
				}
			}
			else {
				documentSends = workflowService.getListPmlEdmDocumentSendsByUser(userId);
			}
		}
		
		else if ("daXuLy".equals(hienTrang)) {
			if (statusId != 0) {
				if (isExpired == false) {
					// phmphuc update 22/04/2010
//					documentSends = DataReportUtil.getListDocumentSend_DaXuLy(userId, statusId, year);	
					
					if ("xuLyChung".equals(nguoiXuLy)) {
						if (timkiemtheotieuchi == false) {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung(userId, String.valueOf(year), 
									String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung1(userId,  loaiVB,
									soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
						}
					}
					else  if ("tuXuLy".equals(nguoiXuLy)) {
						if (timkiemtheotieuchi == false) {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy(userId, String.valueOf(year), 
									String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy1(userId, loaiVB,
									soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
						}
					}
				}
				else {
//					documentSends = DataReportUtil.getListDocumentSend_DaXuLy_TreHan(userId, new Date(), statusId);
					if ("xuLyChung".equals(nguoiXuLy)) {
						if (timkiemtheotieuchi == false) {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung_treHan(userId, String.valueOf(year),
									String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung_treHan1(userId, loaiVB,
									soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
						}
					}
					else  if ("tuXuLy".equals(nguoiXuLy)) {
						if (timkiemtheotieuchi == false) {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy_treHan(userId, String.valueOf(year), 
									String.valueOf(loaiCVID), -1, -1, null);
						} else {
							documentSends = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy_treHan1(userId, loaiVB,
									soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, -1, -1, null);
						}
					}
					// end
				}
				
			}
			else {
				List<PmlFileStatus> fileStatuses = PmlFileStatusUtil.findAll();
				for (PmlFileStatus pmlFileStatus : fileStatuses) {
					statusId = pmlFileStatus.getFileStatusId();
					documentSends.addAll(DataReportUtil.getListDocumentSend_DaXuLy(userId, statusId, year));
				}
			}
		}

		if (!documentSends.isEmpty()) {
			int stt = 1;
			for (PmlEdmDocumentSend pmlEdmDocumentSend : documentSends) {
				DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(pmlEdmDocumentSend);
				
				QuanLyCongVanDiDTO quanLyCongVanDiDTO = new QuanLyCongVanDiDTO();
				quanLyCongVanDiDTO.setStt(stt + ".");
				quanLyCongVanDiDTO.setSoKyHieuVanBan(documentSendDTO.getDocumentReference());
				quanLyCongVanDiDTO.setNguoiTao(StringUtils.convertToRTF(documentSendDTO.getEditor()));
				quanLyCongVanDiDTO.setNguoiKyVanBan(StringUtils.convertToRTF(documentSendDTO.getSigner()));
				quanLyCongVanDiDTO.setNoiNhan(StringUtils.convertToRTF(documentSendDTO.getReceivingPlace()));
				quanLyCongVanDiDTO.setTrichYeu(StringUtils.convertToRTF(documentSendDTO.getBriefContent()));
				// phmphuc update 22/04/2010
//			quanLyCongVanDiDTO.setTrangThai(StringUtils.convertToRTF(documentSendDTO.getState()));
				
				// lay trang thai hien thi giong trang list.jsp
				PmlDocumentSendLog pmlDocumentSendLog = null;
				try {
					pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
							pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0) , null , 0).get(0);
				} catch (Exception e) {
					try {
						pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_StateProcessIdAfter(
								pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0) , 0).get(0);
					} catch (Exception ex) {
						try {					
							pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor(
									pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0))
									.get(PmlDocumentSendLogUtil.findByDocumentSendId_Processor(
											pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0)).size() - 1);	
						} catch (Exception e2) {
							pmlDocumentSendLog = new PmlDocumentSendLogImpl();
						}
					}
				}
				
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				if (pmlDocumentSendLog != null) {
					try {
						fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, pmlDocumentSendLog.getStateProcessIdBefore()).get(0);
					} catch (Exception e) {
						fileStatusStateProcess = null;
					}
				}
				
				if (fileStatusStateProcess != null) {
					quanLyCongVanDiDTO.setTrangThai(StringUtils.convertToRTF(fileStatusStateProcess.getDescription()));
				}
				
				else {
					quanLyCongVanDiDTO.setTrangThai("");
				}
				// end
				
				results.add(quanLyCongVanDiDTO);
				stt ++;
			}
		} else {
			QuanLyCongVanDiDTO quanLyCongVanDiDTO = new QuanLyCongVanDiDTO();
			quanLyCongVanDiDTO.setStt("");
			quanLyCongVanDiDTO.setSoKyHieuVanBan("");
			quanLyCongVanDiDTO.setNguoiTao("");
			quanLyCongVanDiDTO.setNguoiKyVanBan("");
			quanLyCongVanDiDTO.setNoiNhan("");
			quanLyCongVanDiDTO.setTrichYeu("");
			quanLyCongVanDiDTO.setTrangThai("");
		}
		
		return results;
	}
	
	private void printReport(ActionRequest req, ActionResponse res) throws Exception {
			
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
			
			QuanLyCongVanDiUtil rtfUtil = new QuanLyCongVanDiUtil(request.getSession().getServletContext().getRealPath("reports"),
					getListDocumentSendDTOByStatusId(req));
			
			InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/BaoCaoSoCongVanDi_New.rtf"));
			ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
		}
	
}