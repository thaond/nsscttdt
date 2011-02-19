package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.document.util.DataReportUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearch;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchDisplayTerms;
import com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchTerms;

public class ViewListDocumentSendAction extends DocumentSendPortletAction {
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
		
		int loaiCVID = ParamUtil.getInteger(req, PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN, 0);
		
		List<Long> listUser_LDVP_Long =  new ArrayList<Long>();
		listUser_LDVP_Long.add(PortalUtil.getUserId(req));
		req.setAttribute("listUser_LDVP_Long", listUser_LDVP_Long);
			
		PcccDocumentSendProcessSearchDisplayTerms displayTerms = new PcccDocumentSendProcessSearchDisplayTerms(req);
		displayTerms.setLoaiSoCongVan(loaiCVID);	
		
//	end 	
		req.setAttribute("statusId", statusId);
		req.setAttribute("hienTrang", hienTrang);
		req.setAttribute("isExpired", isExpired);
		//yenlt 09/04/2010
		req.setAttribute("year", year);
		req.setAttribute("nguoiXuLy", nguoiXuLy);
		//end
		
		//yenlt update 20101023
		String  tabChung = ParamUtil.getString(req,"tabChung");
		boolean timkiemtheotieuchi = ParamUtil.getBoolean(req, "timkiemtheotieuchi", false);
		String soKyHieu = ParamUtil.getString(req, "soKyHieu" , "");
		long loaiVB = ParamUtil.getLong(req, "loaisocongvan", 0);
		String donViSoanThao = ParamUtil.getString(req, "donViSoanThao", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String coQuanNhan = ParamUtil.getString(req, "coQuanNhan", "");
		
		String tuNgay = ParamUtil.getString(req, "tuNgay", "");
		String denNgay = ParamUtil.getString(req, "denNgay", "");
		
		List<PmlEdmDocumentSend> results = null;
		int total1 = 0;
		
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/list");
		
		for(int i = 0; i < listUser_LDVP_Long.size() ; i++) {			
			portletURL.setParameter(String.valueOf(listUser_LDVP_Long.get(i)),  String.valueOf(listUser_LDVP_Long.get(i)));
		}	
		
		portletURL.setParameter("statusId", String.valueOf(statusId));
		portletURL.setParameter("hienTrang", hienTrang);
		portletURL.setParameter("isExpired", String.valueOf(isExpired));
		portletURL.setParameter("nguoiXuLy", nguoiXuLy);
		portletURL.setParameter("year", String.valueOf(year));
		portletURL.setParameter("tabChung", tabChung);
		
		// yenlt update 20101023
		portletURL.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
		portletURL.setParameter("soKyHieu", soKyHieu);
		portletURL.setParameter("loaisocongvan", String.valueOf(loaiVB));
		portletURL.setParameter("donViSoanThao", donViSoanThao);
		portletURL.setParameter("nguoiKy", nguoiKy);
		portletURL.setParameter("trichYeu", trichYeu);
		portletURL.setParameter("coQuanNhan", coQuanNhan);
		portletURL.setParameter("tuNgay", tuNgay);
		portletURL.setParameter("denNgay", denNgay);
		// end yenlt update 20101023
		
		String portletURLString = portletURL.toString();

		PcccDocumentSendProcessSearch searchContainerList = new PcccDocumentSendProcessSearch(req, portletURL);
		PcccDocumentSendProcessSearchTerms searchTerms = (PcccDocumentSendProcessSearchTerms) searchContainerList.getSearchTerms();
		long userId = PortalUtil.getUserId(req);
		List<PmlDocumentSendLog> resultLogs = null;
		if (hienTrang.equals("dangXuLy")) { // Dang xu ly
			if (!isExpired) { // Khong tre han
				if (timkiemtheotieuchi == false) {
					total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca"); 
					
					results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()),"tatca",
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				} else {
					total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy1(listUser_LDVP_Long, statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, 
								tuNgay, denNgay); 
					
					results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy1(listUser_LDVP_Long, statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, 
								tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				}
				// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi documentsend
				resultLogs = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSendLog_Users_Status_DangXuLy(listUser_LDVP_Long, statusId, loaiVB, 
								soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, 
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				// end phmphuc add 12/11/2010
			} else {
				if (timkiemtheotieuchi == false) {
					total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca"); 
					
					results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca",
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				} else {
					total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy_TreHan1(listUser_LDVP_Long, statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, 
								tuNgay, denNgay); 
					
					results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy_TreHan1(listUser_LDVP_Long, statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, 
								tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				}
				// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi documentsend
				resultLogs = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSendLog_Users_Status_DangXuLy_TreHan(listUser_LDVP_Long, statusId, 
								loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, 
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				// end phmphuc add 12/11/2010
			}
		
		}
		else if (hienTrang.equals("daXuLy")) {
			
			if (!isExpired){//khong tre han
				//select-year-letter
				if ("xuLyChung".equals(nguoiXuLy)) {
					if (timkiemtheotieuchi == false) {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung(userId, String.valueOf(year),  String.valueOf(searchTerms.getLoaiSoCongVan()));
					} else {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay);
					}
				} 
				else  if ("tuXuLy".equals(nguoiXuLy)) {
					if (timkiemtheotieuchi == false) {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()));
					} else {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
								   tuNgay, denNgay,searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
								   tuNgay, denNgay);
					}
				}
			} else {
				if ("xuLyChung".equals(nguoiXuLy)) {
					if (timkiemtheotieuchi == false) {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung_treHan(userId, String.valueOf(year),  String.valueOf(searchTerms.getLoaiSoCongVan()));
					} else {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung_treHan1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung_treHan1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay);
					}
				}
				else  if ("tuXuLy".equals(nguoiXuLy)) {
					if (timkiemtheotieuchi == false) {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
								searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()));
					} else {
						results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy_treHan1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay, searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
						
						total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy_treHan1(userId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
									tuNgay, denNgay);
					}
				}
			}
		}
		searchContainerList.setTotal(total1);
		searchContainerList.setResults(results);
				
		portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
		
		req.setAttribute("view.jsp-portletURL", portletURL);
		req.setAttribute("view.jsp-portletURLString", portletURLString);
		req.setAttribute("results", results);
		req.setAttribute("total1", total1);
		req.setAttribute("resultLogs", resultLogs);
		req.setAttribute("searchContainerList", searchContainerList);
		// end yenlt update 20101023
		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.list");
	}
	
	private List<PmlEdmDocumentSend> filter(RenderRequest req,
			List<PmlEdmDocumentSend> documentSendList) throws Exception {
		List<PmlEdmDocumentSend> results = new ArrayList<PmlEdmDocumentSend>();
		String documentRecordTypeId = ParamUtil.getString(req, "documentRecordTypeId", "all");
		if ("all".equals(documentRecordTypeId)) {
			results.addAll(documentSendList);
		}
		
		else {
			for (int i = 0; i < documentSendList.size(); i++) {
				PmlEdmDocumentSend documentSend = documentSendList.get(i);
				long documentTypeId = documentSend.getDocumentTypeId();
				PmlEdmDocumentType documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
				String docRecordTypeId = String.valueOf(documentType.getDocumentRecordTypeId());
				if (documentRecordTypeId.equals(docRecordTypeId)) {
					results.add(documentSend);
				}
			}
		}
		req.setAttribute("documentRecordTypeId", documentRecordTypeId);
		return results;
	}

	private List<PmlEdmDocumentSend> getListDocumentSendDTOByStatusId(RenderRequest req) throws Exception {

		long userId = PortalUtil.getUserId(req);
		long statusId = ParamUtil.getLong(req, "statusId", 0);
		boolean isExpired = ParamUtil.getBoolean(req, "isExpired", false);
		String hienTrang = ParamUtil.getString(req, "hienTrang", "dangXuLy");
		int year = ParamUtil.getInteger(req, "year", new Date().getYear() + 1900);
		
		PortletPreferences prefs = req.getPreferences();
		boolean processTranlate = ParamUtil.getBoolean(req, "vtxulythay", false);
		List<PmlEdmDocumentSend> documentSends = new ArrayList<PmlEdmDocumentSend>();
		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		
//		if (processTranlate) {
//			PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
//			PmlDepartment department = PmlDepartmentLocalServiceUtil.getPmlDepartment(pmlUser.getDepartmentsId());
//			PmlAgencyLeader agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(department.getAgencyId());
//			try {
//				userId = UserLocalServiceUtil.getUser(agencyLeader.getUserId()).getUserId();
//			} catch (Exception e) {
//				
//			}
//		}
		
		if (processTranlate) {
			req.setAttribute("xulythayLd_vpb",true);
			String[] listUser = prefs.getValues("listUserLDB", new String[0]);
			long userIdLDB;
		
			List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
			for (int i = 0; i < listUser.length; i++) {
				
				userIdLDB = Long.parseLong(listUser[i]);
				if ("dangXuLy".equals(hienTrang)) {
					if (statusId != 0) {
						if (isExpired == false) {
							documentSends = workflowService.getListDocumentByStatusId(userIdLDB, statusId);	
						}
						else {
							documentSends = DataReportUtil.getListDocumentSendForTreHan(userIdLDB, new Date(), statusId);
						}
					}
					else {
						documentSends = workflowService.getListPmlEdmDocumentSendsByUser(userIdLDB);
					}
				}
				
				else {
					if (statusId != 0) {
						if (isExpired == false) {
							documentSends = DataReportUtil.getListDocumentSend_DaXuLy(userIdLDB, statusId, year);	
						}
						else {
							documentSends = DataReportUtil.getListDocumentSend_DaXuLy_TreHan(userIdLDB, new Date(), statusId);
						}
					}
					else {
						List<PmlFileStatus> fileStatuses = PmlFileStatusUtil.findAll();
						for (PmlFileStatus pmlFileStatus : fileStatuses) {
							statusId = pmlFileStatus.getFileStatusId();
							documentSends.addAll(DataReportUtil.getListDocumentSend_DaXuLy(userIdLDB, statusId, year));
						}
					}
				}
				
				pmlEdmDocumentSendList.addAll(documentSends);
			}
			
			return pmlEdmDocumentSendList;
		}

		//phan xu ly thay cho lanh dao van phong		
		boolean processTranlateLDVP = ParamUtil.getBoolean(req, "vtxulythayldvp", false);		
		if (processTranlateLDVP) {
			req.setAttribute("xulythayLd_vpb",true);
			String[] listUser = prefs.getValues("listUser", new String[0]);
			long userIdLDVP;
		
			List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
			for (int i = 0; i < listUser.length; i++) {
				
				userIdLDVP = Long.parseLong(listUser[i]);
				if ("dangXuLy".equals(hienTrang)) {
					if (statusId != 0) {
						if (isExpired == false) {
							documentSends = workflowService.getListDocumentByStatusId(userIdLDVP, statusId);	
						}
						else {
							documentSends = DataReportUtil.getListDocumentSendForTreHan(userIdLDVP, new Date(), statusId);
						}
					}
					else {
						documentSends = workflowService.getListPmlEdmDocumentSendsByUser(userIdLDVP);
					}
				}
				
				else {
					if (statusId != 0) {
						if (isExpired == false) {
							documentSends = DataReportUtil.getListDocumentSend_DaXuLy(userIdLDVP, statusId, year);	
						}
						else {
							documentSends = DataReportUtil.getListDocumentSend_DaXuLy_TreHan(userIdLDVP, new Date(), statusId);
						}
					}
					else {
						List<PmlFileStatus> fileStatuses = PmlFileStatusUtil.findAll();
						for (PmlFileStatus pmlFileStatus : fileStatuses) {
							statusId = pmlFileStatus.getFileStatusId();
							documentSends.addAll(DataReportUtil.getListDocumentSend_DaXuLy(userIdLDVP, statusId, year));
						}
					}
				}
				
				pmlEdmDocumentSendList.addAll(documentSends);
			}
			
			return pmlEdmDocumentSendList;
		}
		
		if ("dangXuLy".equals(hienTrang)) {
			if (statusId != 0) {
				if (isExpired == false) {
					documentSends = workflowService.getListDocumentByStatusId(userId, statusId);	
				}
				else {
					documentSends = DataReportUtil.getListDocumentSendForTreHan(userId, new Date(), statusId);
				}
			}
			else {
				documentSends = workflowService.getListPmlEdmDocumentSendsByUser(userId);
			}
		}
		
		else {
			if (statusId != 0) {
				if (isExpired == false) {
					documentSends = DataReportUtil.getListDocumentSend_DaXuLy(userId, statusId, year);	
				}
				else {
					documentSends = DataReportUtil.getListDocumentSend_DaXuLy_TreHan(userId, new Date(), statusId);
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
		
		return documentSends;
	}
	
	private List<DocumentSendDTO> phanTrang(List<DocumentSendDTO> documentDTOs, int start, int end) throws Exception {
		
		List<DocumentSendDTO> results = new ArrayList<DocumentSendDTO>();
		
		if (end > documentDTOs.size()) {
			end = documentDTOs.size();
		}
		
		for (int i  = start; i < end; i ++) {
			results.add(documentDTOs.get(i));
		}
		
		return results;
	}
	
	private List<DocumentSendDTO> sortListDocumentDTOs(
			List<DocumentSendDTO> documentDTOs, String sortBy, int flag) {

		Collator viCollator = Collator.getInstance(new Locale("vi"));
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < documentDTOs.size(); i++) {
			for (int j = i + 1; j < documentDTOs.size(); j++) {
				if ("loaiCongVan".equals(sortBy)) {
					str1 = documentDTOs.get(i).getDocumentType();
					str2 = documentDTOs.get(j).getDocumentType();
				}
				
				if ("soVaKyHieu".equals(sortBy)) {
					str1 = documentDTOs.get(i).getDocumentReference();
					str2 = documentDTOs.get(j).getDocumentReference();
				}
				
				if ("nguoiTao".equals(sortBy)) {
					str1 = documentDTOs.get(i).getEditor();
					str2 = documentDTOs.get(j).getEditor();
				}
				
				if ("nguoiKy".equals(sortBy)) {
					str1 = documentDTOs.get(i).getSigner();
					str2 = documentDTOs.get(j).getSigner();
				}
				
				if ("noiNhan".equals(sortBy)) {
					str1 = documentDTOs.get(i).getReceivingPlace();
					str2 = documentDTOs.get(j).getReceivingPlace();
				}
				
				if ("trichYeu".equals(sortBy)) {
					str1 = documentDTOs.get(i).getBriefContent();
					str2 = documentDTOs.get(j).getBriefContent();
				}
				if ("trangThai".equals(sortBy)) {
					str1 = documentDTOs.get(i).getState();
					str2 = documentDTOs.get(j).getState();
				}
				
				if (flag == 0) {
					if (viCollator.compare(str1, str2) < 0) {
						Collections.swap(documentDTOs, i, j);
					}
				}
				else {
					if (viCollator.compare(str1, str2) > 0) {
						Collections.swap(documentDTOs, i, j);
					}
				}
			}
		}
		
		return documentDTOs;
	}
}