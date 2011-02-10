package com.sgs.portlet.pcccdocumentreceiptprocess.action;

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

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearch;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms;
import com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchTerms;

public class ViewListDocumentReceiptAction extends DocumentReceiptPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {		
	}	
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");
		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
		String nguoiXuLy = ParamUtil.getString(req, "nguoiXuLy","xuLyChung"); //yenlt 09/04/2010
		int leveSendId = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI, 0);
		int loaiCVID = ParamUtil.getInteger(req, PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN, 0);
		
		List<Long> listUser_LDVP_Long =  new ArrayList<Long>();
		listUser_LDVP_Long.add(PortalUtil.getUserId(req));
		req.setAttribute("userIdList", listUser_LDVP_Long);
		
		PcccDocumentReceiptProcessSearchDisplayTerms displayTerms = new PcccDocumentReceiptProcessSearchDisplayTerms(req);
		displayTerms.setCapgui(leveSendId);		
		displayTerms.setLoaisocongvan(loaiCVID);		
		
		req.setAttribute("statusId", statusId);
		req.setAttribute("hienTrang", hienTrang);
		req.setAttribute("isExpired", isExpired);
		req.setAttribute("year", year);
		req.setAttribute("nguoiXuLy", nguoiXuLy);//yenlt 09/04/2010
		
		// yenlt update search form 15/10/2010
		String  tabChung = ParamUtil.getString(req,"tabChung");
		String cachThucXuLy = ParamUtil.getString(req, "cachThucXuLy", "-1");
		
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req,"timkiemtheotieuchi", false);
		String soVBDen = ParamUtil.getString(req, "sovanbanden", "");
		String soHieuGoc = ParamUtil.getString(req, "sohieugoc", "");
		int loaiSoVanBan = ParamUtil.getInteger(req, "loaisocongvan", 0); 
		String issuingplaceId = ParamUtil.getString(req, "issuingplaceId", "");
		String noiPhatHanh = ParamUtil.getString(req, "noiphathanh", "");
		String trichYeu = ParamUtil.getString(req, "trichyeu", "");
		String tuNgay = ParamUtil.getString(req, "tungay");
		String denNgay = ParamUtil.getString(req, "denngay");
		String ngayHetHan = ParamUtil.getString(req, "ngayhethan");
		
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/list");
		portletURL.setParameter("statusId", String.valueOf(statusId));
		portletURL.setParameter("isExpired", String.valueOf(isExpired));
		portletURL.setParameter("hienTrang", hienTrang);
		portletURL.setParameter("nguoiXuLy", nguoiXuLy);
		portletURL.setParameter("year", String.valueOf(year));
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
		portletURL.setParameter("ngayhethan", ngayHetHan);
		// end yenlt update 20101022
		
		long userId = PortalUtil.getUserId(req);
		
		PcccDocumentReceiptProcessSearch searchContainerList = new PcccDocumentReceiptProcessSearch(req, portletURL);
		PcccDocumentReceiptProcessSearchTerms searchTerms = (PcccDocumentReceiptProcessSearchTerms) searchContainerList.getSearchTerms();
		int total1 = 0;
		List<PmlEdmDocumentReceipt> results = null; 
		List<PmlDocumentReceiptLog> resultLogs = null; 
		if (hienTrang.equals("dangXuLy")) { // Dang xu ly
			if (isExpired == false) { // Khong tre han
				if (!timkiemtheotieuchi) {
					total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaisocongvan()), String.valueOf(searchTerms.getCapgui()), cachThucXuLy);
					results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaisocongvan()), String.valueOf(searchTerms.getCapgui()),
							cachThucXuLy ,searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				} else {
					total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
					results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, 
							 searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				}
				
				// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
				resultLogs = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceiptLog_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, soVBDen, 
								soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, 
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				// end phmphuc add 12/11/2010
			} else {
				if (!timkiemtheotieuchi) {
					//Phuong thuc tra ve tong so record tim duoc trong csdl
					total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaisocongvan()), String.valueOf(searchTerms.getCapgui())); 
					
					// Phuong thuc tra ve danh sach doi tuong Customer
					results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaisocongvan()), String.valueOf(searchTerms.getCapgui()),
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				} else {
					total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan); 
					
					results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh,
							trichYeu, tuNgay, denNgay, ngayHetHan, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				}
				
				// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
				resultLogs = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan (listUser_LDVP_Long, statusId, soVBDen, 
						soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				// end phmphuc add 12/11/2010
			}
		}
		else if (hienTrang.equals("daXuLy")) {
			
			if (!isExpired){//khong tre han
				//select-year-letter
				if ("xuLyChung".equals(nguoiXuLy)) {
					// phuong thuc search form 15/10/2010
					if (timkiemtheotieuchi == false) {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
					
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyChung(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()));
					} else {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId, noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan, 
								 searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyChung(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
								noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
					}

				}
				else  if ("tuXuLy".equals(nguoiXuLy)) {
					if (!timkiemtheotieuchi) {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()));
					} else {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan,
									searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyTuXuLy(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
					}
				}
			} else {
				if ("xuLyChung".equals(nguoiXuLy)) {
					if (!timkiemtheotieuchi) {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyChung_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()));
					} else {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyChung_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan,
									searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyChung_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
					}
				}
				else  if ("tuXuLy".equals(nguoiXuLy)) {
					if (!timkiemtheotieuchi) {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()));
					} else {
						results = PmlEdmDocumentReceiptLocalServiceUtil.getListCVDenDaXuLyTuXuLy_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan,
									searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentReceiptLocalServiceUtil.countListCVDenDaXuLyTuXuLy_treHan(userId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
									noiPhatHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
					}
				}
			}
		}
		
		String portletURLString = portletURL.toString();
		req.setAttribute("view.jsp-portletURL", portletURL);
		req.setAttribute("view.jsp-portletURLString", portletURLString);
		req.setAttribute("results", results);
		req.setAttribute("total1", total1);
		req.setAttribute("resultLogs", resultLogs);
		req.setAttribute("searchContainerList", searchContainerList);
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.list");
		
	}
 
//	private List<PmlEdmDocumentReceipt> getListDocumentReceiptByStatusId(RenderRequest req) throws Exception {
//		long userId = PortalUtil.getUserId(req);
//		long statusId = ParamUtil.getLong(req, "statusId", 0);
//		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
//		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");
//		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
//		
//		DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
//		List<PmlEdmDocumentReceipt> documentReceipts = new ArrayList<PmlEdmDocumentReceipt>();
//		
//		PortletPreferences prefs = req.getPreferences();
//		
//		//phan van thu xu ly thay cho lanh dao
//		boolean processTranlate = ParamUtil.getBoolean(req, "vtxulythayldb", false);
//		
////		if (processTranlate) {
////			PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
////			PmlDepartment department = PmlDepartmentLocalServiceUtil.getPmlDepartment(pmlUser.getDepartmentsId());
////			PmlAgencyLeader agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(department.getAgencyId());
////			try {
////				userId = UserLocalServiceUtil.getUser(agencyLeader.getUserId()).getUserId();
////			} catch (Exception e) {
////				
////			}
////		}
//		
//		
//		if (processTranlate) {
//			req.setAttribute("xulythayLd_vpb",true);
//			String[] listUser = prefs.getValues("listUserLDB", new String[0]);
//			long userIdLDB;
//			List<PmlEdmDocumentReceipt> documentReceiptsResuList = new ArrayList<PmlEdmDocumentReceipt>();
//			for (int i = 0; i < listUser.length; i++) {
//				
//				userIdLDB = Long.parseLong(listUser[i]);
//				if ("dangXuLy".equals(hienTrang)) {
//					if (statusId == 0) {
//						documentReceipts = workflowService.getListPmlEdmDocumentReceiptsByUser(userIdLDB);
//					}
//					
//					else {
//						if (isExpired == false) {
////							documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_User_Status_DangXuLy(userIdLDB, statusId, "tatca", "tatca", start, end, obc);
//						}
//						else {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy_TreHan(userIdLDB, new Date(), statusId);
//						}
//					}
//				}
//				
//				/*
//				 * Lay danh sach cong van da xu ly
//				 */
//				else if ("daXuLy".equals(hienTrang)) {
//					
//					if (statusId == 0) {
//						List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
//						for (PmlFileStatus pmlFileStatus : list) {
//							long fileStatusId = pmlFileStatus.getFileStatusId();
//							documentReceipts.addAll(DataReportUtil.getListDocumentReceipt_DaXuLy(userIdLDB, fileStatusId, year));
//						}
//					}
//					
//					else {
//						if (isExpired == false) {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy(userIdLDB, statusId, year);
//						}
//						else {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy_TreHan(userIdLDB, new Date(), statusId);
//						}
//					}
//				}
//				
//				documentReceiptsResuList.addAll(documentReceipts);
//			}
//			
//			return documentReceiptsResuList;
//		}
//		
//		//phan xu ly thay cho lanh dao van phong		
//		boolean processTranlateLDVP = ParamUtil.getBoolean(req, "vtxulythayldvp", false);		
//		if (processTranlateLDVP) {
//			
//			req.setAttribute("xulythayLd_vpb",true);
//			
//			String[] listUser = prefs.getValues("listUser", new String[0]);
//			long userIdLDVP;
//			List<PmlEdmDocumentReceipt> documentReceiptsResuList = new ArrayList<PmlEdmDocumentReceipt>();
//			for (int i = 0; i < listUser.length; i++) {
//				
//				userIdLDVP = Long.parseLong(listUser[i]);
//				if ("dangXuLy".equals(hienTrang)) {
//					if (statusId == 0) {
//						documentReceipts = workflowService.getListPmlEdmDocumentReceiptsByUser(userIdLDVP);
//					}
//					
//					else {
//						if (isExpired == false) {
//							documentReceipts = workflowService.getListDocumentByStatusId(userIdLDVP, statusId);
//						}
//						else {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy_TreHan(userIdLDVP, new Date(), statusId);
//						}
//					}
//					
//				}
//				
//				/*
//				 * Lay danh sach cong van da xu ly
//				 */
//				else if ("daXuLy".equals(hienTrang)) {
//					
//					if (statusId == 0) {
//						List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
//						for (PmlFileStatus pmlFileStatus : list) {
//							long fileStatusId = pmlFileStatus.getFileStatusId();
//							documentReceipts.addAll(DataReportUtil.getListDocumentReceipt_DaXuLy(userIdLDVP, fileStatusId, year));
//						}
//					}
//					
//					else {
//						if (isExpired == false) {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy(userIdLDVP, statusId, year);
//						}
//						else {
//							documentReceipts = DataReportUtil.getListDocumentReceipt_DaXuLy_TreHan(userIdLDVP, new Date(), statusId);
//						}
//					}
//				}
//				
//				documentReceiptsResuList.addAll(documentReceipts);
//			}
//			
//			return documentReceiptsResuList;
//		}
//		
//		/*
//		 * Lay danh sach cong van dang xu ly
//		 */
//		if ("dangXuLy".equals(hienTrang)) {
//			if (statusId == 0) {
//				statusId = PmlFileStatusUtil.findByFileStatusCode("dangxulychung").get(0).getFileStatusId();
//				//documentReceipts = workflowService.getListPmlEdmDocumentReceiptsByUser(userId);
//				documentReceipts = workflowService.getListDocumentByStatusId(userId, statusId);
//			}
//			
//			else {
//				if (isExpired == false) {
//					documentReceipts = workflowService.getListDocumentByStatusId(userId, statusId);
//				}
//				else {
//					//documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.listPmlEdmDocumentReceiptByStatus_DangXuLy_TreHan(userId, statusId);
//					documentReceipts = workflowService.getListDocumentByStatusId(userId, statusId);
//				}
//			}
//			
//		}
//		
//		/*
//		 * Lay danh sach cong van da xu ly
//		 */
//		else if ("daXuLy".equals(hienTrang)) {
//			
//			if (statusId == 0) {
//				/*
//				List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
//				for (PmlFileStatus pmlFileStatus : list) {
//					long fileStatusId = pmlFileStatus.getFileStatusId();
//					documentReceipts.addAll(DataReportUtil.getListDocumentReceipt_DaXuLy(userId, fileStatusId, year));
//				}*/
//				documentReceipts = workflowService.getListDocumentOfUserHadProcessByStatusId(userId, statusId);
//			}
//			
//			else {
//				if (isExpired == false) {
//					documentReceipts = workflowService.getListDocumentOfUserHadProcessByStatusId(userId, statusId);
//				}
//				else {
//					//documentReceipts = PmlEdmDocumentReceiptLocalServiceUtil.listPmlEdmDocumentReceiptByStatus_DaXuLy_TreHan(userId, statusId, year);
//					documentReceipts = workflowService.getListDocumentOfUserHadProcessByStatusId(userId, statusId);
//				}
//			}
//		}
//		
//		return documentReceipts;
//	}


//	private List<PmlEdmDocumentReceipt> filter(RenderRequest req, List<PmlEdmDocumentReceipt> documentReceipt) throws Exception {
//		
//		List<PmlEdmDocumentReceipt> results = new ArrayList<PmlEdmDocumentReceipt>();
//		
//		String capGoi = ParamUtil.getString(req, "capGoi", "tatca");
//		String soCongVan = ParamUtil.getString(req, "soCongVan", "tatca");
//		
//		if ("tatca".equals(capGoi) && "tatca".equals(soCongVan)) {
//			if (documentReceipt != null) {
//				results.addAll(documentReceipt);
//			}
//		}
//		else {
//			results = new ArrayList<PmlEdmDocumentReceipt>();
//			for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : documentReceipt) {
//				String levelSendId = String.valueOf(pmlEdmDocumentReceipt.getLevelSendId());
//				long documentTypeId = pmlEdmDocumentReceipt.getDocumentTypeId();
//				PmlEdmDocumentType documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
//				String documentRecordTypeId = String.valueOf(documentType.getDocumentRecordTypeId());
//				
//				results.add(pmlEdmDocumentReceipt);
//				
//				int index = results.size() - 1;
//				
//				if (!capGoi.equals("tatca")) {
//					if (!capGoi.equals(levelSendId)) {
//						results.remove(index);
//						continue;
//					}
//				}
//				
//				if (!soCongVan.equals("tatca")) {
//					if (!soCongVan.equals(documentRecordTypeId)) {
//						results.remove(index);
//						continue;
//					}
//				}
//			}
//		}
//		
//		req.setAttribute("capGoi", capGoi);
//		req.setAttribute("soCongVan", soCongVan);
//		
//		return results;
//	}
	
//	private List<PmlEdmDocumentReceiptDTO> phanTrang(List<PmlEdmDocumentReceiptDTO> documentDTOs, int start, int end) throws Exception {
//		
//		List<PmlEdmDocumentReceiptDTO> results = new ArrayList<PmlEdmDocumentReceiptDTO>();
//		
//		if (end > documentDTOs.size()) {
//			end = documentDTOs.size();
//		}
//		
//		for (int i  = start; i < end; i ++) {
//			results.add(documentDTOs.get(i));
//		}
//		
//		return results;
//	}
	
//	private List<PmlEdmDocumentReceiptDTO> sortListDocumentDTOs(
//			List<PmlEdmDocumentReceiptDTO> documentDTOs, String sortBy, int flag) {
//
//		Collator viCollator = Collator.getInstance(new Locale("vi"));
//		String str1 = "";
//		String str2 = "";
//		Date date1 = null;
//		Date date2 = null;
//		
//		for (int i = 0; i < documentDTOs.size(); i++) {
//			for (int j = i + 1; j < documentDTOs.size(); j++) {
//				if ("capGoi".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getLevelSendName();
//					str2 = documentDTOs.get(j).getLevelSendName();
//				}
//				
//				if ("loaiCongVan".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getDocumentTypeName();
//					str2 = documentDTOs.get(j).getDocumentTypeName();
//				}
//				
//				if ("soCVDen".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getNumberDocumentReceipt();
//					str2 = documentDTOs.get(j).getNumberDocumentReceipt();
//				}
//				
//				if ("soHieu".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getDocumentReference();
//					str2 = documentDTOs.get(j).getDocumentReference();
//				}
//				
//				if ("ngayNhan".equals(sortBy)) {
//					date1 = documentDTOs.get(i).getDateArrive();
//					date2 = documentDTOs.get(j).getDateArrive();
//					
//					str1 = getStringFromDate(date1);
//					str2 = getStringFromDate(date2);
//				}
//				
//				if ("noiPhatHanh".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getIssuingPlaceName();
//					str2 = documentDTOs.get(j).getIssuingPlaceName();
//				}
//				
//				if ("trichYeu".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getBriefContent();
//					str2 = documentDTOs.get(j).getBriefContent();
//				}
//				if ("trangThai".equals(sortBy)) {
//					str1 = documentDTOs.get(i).getState();
//					str2 = documentDTOs.get(j).getState();
//				}
//				
//				if (flag == 0) {
//					if (viCollator.compare(str1, str2) < 0) {
//						Collections.swap(documentDTOs, i, j);
//					}
//				}
//				else {
//					if (viCollator.compare(str1, str2) > 0) {
//						Collections.swap(documentDTOs, i, j);
//					}
//				}
//			}
//		}
//		
//		return documentDTOs;
//	}
	

//	private String getStringFromDate (Date d) {
//		String result = "";
//		String year = "";
//		String month = "";
//		String date = "";
//		
//		int yearInt = d.getYear() + 1900;
//		int monthInt = d.getMonth() + 1;
//		int dateInt = d.getDate();
//		
//		year = String.valueOf(yearInt);
//		
//		if (monthInt < 10) {
//			month = "0" + monthInt;
//		}
//		else {
//			month = String.valueOf(monthInt);
//		}
//		
//		if (dateInt < 10) {
//			date = "0" + dateInt;
//		}
//		else {
//			date = String.valueOf(dateInt);
//		}
//		
//		result = year + "/" + month + "/" + date;
//		return result;
//	}
	
}