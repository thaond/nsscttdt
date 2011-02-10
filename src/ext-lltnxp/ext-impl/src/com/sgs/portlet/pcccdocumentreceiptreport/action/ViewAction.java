package com.sgs.portlet.pcccdocumentreceiptreport.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.dto.TinhHinhThuLyCongVanDTO;
import com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportDisplayTerms;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		
		String reportType = ParamUtil.getString(req, "reportType");
		if(Validator.isNull(reportType) == false && "".equals(reportType) == false) {
			
			String departmentId = ParamUtil.getString(req, DocumentReportDisplayTerms.DEPARTMENTID);
			long userId = ParamUtil.getLong(req, DocumentReportDisplayTerms.USERID);
			String name = "";
			if (departmentId.equals("toancoquan")) {
				name =  "To\u00e0n c\u01a1 quan";
			} else if(departmentId.equals("tatcaphongban") || userId == 0) {
				name = "T\u00ean ph\u00f2ng ban";
			} else {
				name = "T\u00ean chuy\u00ean vi\u00ean";
			}
			
			int nhomCongVan = ParamUtil.getInteger(req, DocumentReportDisplayTerms.NHOMCONGVAN);
			String loaiCongVan = ParamUtil.getString(req, DocumentReportDisplayTerms.LOAICONGVAN);
			String doMat = ParamUtil.getString(req, DocumentReportDisplayTerms.DOMAT);
			
			Date fromDate = new Date();
			Date toDate = new Date();
			SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
			
			if(ParamUtil.getString(req, "fromDate") != "" && ParamUtil.getString(req, "toDate") != "") {
				fromDate = fm.parse(ParamUtil.getString(req, "fromDate"));
				toDate = fm.parse(ParamUtil.getString(req, "toDate"));
			}
			
			if(reportType.equals("word")) { // xuat ra file word
				xuatFileWord(req, res, reportType, loaiCongVan, departmentId, userId, nhomCongVan, doMat, fromDate, toDate, StringUtils.convertToRTF(name));
			}
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				String view = ParamUtil.getString(req, "view");
				String reportType = ParamUtil.getString(req, "reportType");
				String departmentId = ParamUtil.getString(req, DocumentReportDisplayTerms.DEPARTMENTID);
				long userId = ParamUtil.getLong(req, "userId");
				
				String tenPhongBan = getTenPhongBan(reportType, departmentId, userId);
				
				// chua nhan nut Xem bao cao
				if(Validator.isNull(view)) { 
					
					String toDay = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
					
					
					req.setAttribute("fromDate", toDay);
					req.setAttribute("toDate", toDay);
					req.setAttribute("month", getMonth(toDay));
					
					req.setAttribute("attView", "no");
					req.setAttribute("attTenCoQuanPhongBanChuyenVien", tenPhongBan);//yenlt
//					req.setAttribute("tenPhongBan", tenPhongBan);
				} 
				// Nhan nut xem bao cao
				else { 
					
					if (departmentId.equals("toancoquan")) {
						req.setAttribute("attTenCoQuanPhongBanChuyenVien", "toancoquan");
					} else if(departmentId.equals("tatcaphongban") || userId == 0) {
						req.setAttribute("attTenCoQuanPhongBanChuyenVien", "tenphongban");
//						req.setAttribute("attTenCoQuanPhongBanChuyenVien", "tenphongban");
					} else {
						req.setAttribute("attTenCoQuanPhongBanChuyenVien", "tenchuyenvien");
//						req.setAttribute("attTenCoQuanPhongBanChuyenVien", "tenchuyenvien");
					}
					
					int nhomCongVan = ParamUtil.getInteger(req, DocumentReportDisplayTerms.NHOMCONGVAN);
					String loaiCongVan = ParamUtil.getString(req, DocumentReportDisplayTerms.LOAICONGVAN);
					String fromDate = ParamUtil.getString(req, DocumentReportDisplayTerms.FROMDATE);
					String toDate = ParamUtil.getString(req, DocumentReportDisplayTerms.TODATE);
					//yenlt update 28062010
					boolean radioTenPhongBan = ParamUtil.getBoolean(req, DocumentReportDisplayTerms.RADIOTENPHONGBAN);
					boolean radioTenChuyenVien = ParamUtil.getBoolean(req, DocumentReportDisplayTerms.RADIOTENCHUYENVIEN);
					req.setAttribute("radioTenPhongBan", radioTenPhongBan); 
					req.setAttribute("radioTenChuyenVien", radioTenChuyenVien); 
					//end yenlt update 28062010
					
					req.setAttribute("fromDate", fromDate);
					req.setAttribute("toDate", toDate);
					req.setAttribute("month", getMonth(toDate));
					req.setAttribute("attView", view);
					req.setAttribute("departmentId", departmentId);
					req.setAttribute("userId", userId);
					req.setAttribute("nhomCongVan", nhomCongVan);
					req.setAttribute("loaiCongVan", loaiCongVan);
					req.setAttribute("attTenCoQuanPhongBanChuyenVien", tenPhongBan);
					/*	phmphuc close 08/06/2010
					req.setAttribute("tinhHinhThuLyCongVanList", getTinhHinhThuLyCongVan(loaiCongVan, departmentId, userId, nhomCongVan, 
																	new SimpleDateFormat("dd/MM/yyyy").parse(fromDate), new SimpleDateFormat("dd/MM/yyyy").parse(toDate)));
					*/
					
				}	
				return mapping.findForward("portlet.sgs.pcccdocumentreceiptreport.view");
			}
	}
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVan(String reportType, String loaiCongVan, String departmentId, long userId, 
			int documentRecordTypeId, String doMat, Date fromDate, Date toDate) throws Exception {

		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		
		if(departmentId.equals("toancoquan")) { // Toan co quan
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanToanCoQuan(loaiCongVan, documentRecordTypeId, doMat, fromDate, toDate));
		} else if(departmentId.equals("tatcaphongban")) { // Tat ca phong ban
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanTatCaPhongBan(reportType, loaiCongVan, documentRecordTypeId, doMat, fromDate, toDate, -1, -1));
		} else { // Tung phong ban
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanPhongBan(reportType, loaiCongVan, departmentId, userId, documentRecordTypeId, doMat, fromDate, toDate));
		}
		
		return tinhHinhThuLyCongVanList;
	}
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanToanCoQuan(String loaiCongVan, int documentRecordTypeId, 
													String doMat, Date fromDate, Date toDate) throws Exception {
		
		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		
		int stt = 1;
		String ten = "";
		int tonDauKy = 0;
		int nhanTrongKy = 0;
		int dungHan = 0;
		int treHan = 0;
		int tongDaGiaiQuyet = 0;
		int trongQuiDinh = 0;
		int quaQuiDinh = 0;
		int tongDangGiaiQuyet = 0;
		String tyLeGiaiQuyetDungHan = "";
		
		if (loaiCongVan.equals("congvanden")) { // Cong van den
			tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		} else if(loaiCongVan.equals("congvandi")) { // Cong van di
			tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		}
		
		TinhHinhThuLyCongVanDTO tinhHinhThuLyCongVanDTO = new TinhHinhThuLyCongVanDTO();
		tinhHinhThuLyCongVanDTO.setStt(stt + ".");
		tinhHinhThuLyCongVanDTO.setTen(ten);
		tinhHinhThuLyCongVanDTO.setTonDauKy(tonDauKy);
		tinhHinhThuLyCongVanDTO.setNhanTrongKy(nhanTrongKy);
		tinhHinhThuLyCongVanDTO.setDungHan(dungHan);
		tinhHinhThuLyCongVanDTO.setTreHan(treHan);
		tinhHinhThuLyCongVanDTO.setTongDaGiaiQuyet(tongDaGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTrongQuiDinh(trongQuiDinh);
		tinhHinhThuLyCongVanDTO.setQuaQuiDinh(quaQuiDinh);
		tinhHinhThuLyCongVanDTO.setTongDangGiaiQuyet(tongDangGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTyLeGiaiQuyetDungHan(tyLeGiaiQuyetDungHan);
		
		tinhHinhThuLyCongVanList.add(tinhHinhThuLyCongVanDTO);
		
		return tinhHinhThuLyCongVanList;
	}
	
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanTatCaPhongBan(String reportType, String loaiCongVan, int documentRecordTypeId, 
													String doMat, Date fromDate, Date toDate, int start, int end) throws Exception {

		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		
		// Danh sach tat ca cac Phong ban co trong he thong
		List<Department> pmlDepartmentList = new ArrayList<Department>();
		
		if(reportType.equals("word")) {
			pmlDepartmentList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId(-1, -1);
		}
		else {
			pmlDepartmentList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId(start, end);
		}
		int pmlDepartmentSize = pmlDepartmentList.size();
		
		// danh cho bien tong cong
		int tongCong_tonDauKy = 0;
		int tongCong_nhanTrongKy = 0;
		int tongCong_chuaNhan = 0;
		int tongCong_dungHan = 0;
		int tongCong_treHan = 0;
		int tongCong_tongDaGiaiQuyet = 0;
		int tongCong_trongQuiDinh = 0;
		int tongCong_quaQuiDinh = 0;
		int tongCong_tongDangGiaiQuyet = 0;
		int tongCong_sum = 0;
		String tongCong_tyLeGiaiQuyetDungHan = "";
		
		for (int index = 0; index < pmlDepartmentSize; index ++) {
			
			Department pmlDepartment = pmlDepartmentList.get(index);
			String departmentid = pmlDepartment.getDepartmentsId();
			
			int stt = index + 1;
			String ten = pmlDepartment.getDepartmentsName();
			int tonDauKy = 0;
			int nhanTrongKy = 0;
			int chuaNhan = 0;
			int dungHan = 0;
			int treHan = 0;
			int tongDaGiaiQuyet = 0;
			int trongQuiDinh = 0;
			int quaQuiDinh = 0;
			int tongDangGiaiQuyet = 0;
			int sum = 0;
			String tyLeGiaiQuyetDungHan = "";
				
			if (loaiCongVan.equals("congvanden")) { // Cong van den
				tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyPhongBan_CVDen(departmentid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
				tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
			} else if(loaiCongVan.equals("congvandi")) { // Cong van di
				tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi(departmentid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
				tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
			} 
			
			TinhHinhThuLyCongVanDTO tinhHinhThuLyCongVanDTO = new TinhHinhThuLyCongVanDTO();
			tinhHinhThuLyCongVanDTO.setStt(stt + ".");
			tinhHinhThuLyCongVanDTO.setTen(ten);
			tinhHinhThuLyCongVanDTO.setTonDauKy(tonDauKy);
			tinhHinhThuLyCongVanDTO.setNhanTrongKy(nhanTrongKy);
			tinhHinhThuLyCongVanDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyCongVanDTO.setDungHan(dungHan);
			tinhHinhThuLyCongVanDTO.setTreHan(treHan);
			tinhHinhThuLyCongVanDTO.setTongDaGiaiQuyet(tongDaGiaiQuyet);
			tinhHinhThuLyCongVanDTO.setTrongQuiDinh(trongQuiDinh);
			tinhHinhThuLyCongVanDTO.setQuaQuiDinh(quaQuiDinh);
			tinhHinhThuLyCongVanDTO.setTongDangGiaiQuyet(tongDangGiaiQuyet);
			tinhHinhThuLyCongVanDTO.setTyLeGiaiQuyetDungHan(tyLeGiaiQuyetDungHan);
			
			tinhHinhThuLyCongVanList.add(tinhHinhThuLyCongVanDTO);
		}
		
		// set gia tri cho bien tong cong
		if (loaiCongVan.equals("congvanden")) { // Cong van den
			tongCong_tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLySo_CVDen(documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_sum = tongCong_tongDaGiaiQuyet + tongCong_tongDangGiaiQuyet;
			tongCong_tyLeGiaiQuyetDungHan = tongCong_sum == 0 ? "-/-" : Round(((float) (tongCong_dungHan + tongCong_trongQuiDinh) / tongCong_sum) * 100, 2) + "%";
		} else if(loaiCongVan.equals("congvandi")) { // Cong van di
			tongCong_tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLySo_CVDi(documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_sum = tongCong_tongDaGiaiQuyet + tongCong_tongDangGiaiQuyet;
			tongCong_tyLeGiaiQuyetDungHan = tongCong_sum == 0 ? "-/-" : Round(((float) (tongCong_dungHan + tongCong_trongQuiDinh) / tongCong_sum) * 100, 2) + "%";
		}
		
		TinhHinhThuLyCongVanDTO tongCong = new TinhHinhThuLyCongVanDTO();
		tongCong.setStt("");
		tongCong.setTen(PortletProps.get("van-ban-cua-co-quan"));
		tongCong.setTonDauKy(tongCong_tonDauKy);
		tongCong.setNhanTrongKy(tongCong_nhanTrongKy);
		tongCong.setChuaNhan(tongCong_chuaNhan);
		tongCong.setDungHan(tongCong_dungHan);
		tongCong.setTreHan(tongCong_treHan);
		tongCong.setTongDaGiaiQuyet(tongCong_tongDaGiaiQuyet);
		tongCong.setTrongQuiDinh(tongCong_trongQuiDinh);
		tongCong.setQuaQuiDinh(tongCong_quaQuiDinh);
		tongCong.setTongDangGiaiQuyet(tongCong_tongDangGiaiQuyet);
		tongCong.setTyLeGiaiQuyetDungHan(tongCong_tyLeGiaiQuyetDungHan);
		
		tinhHinhThuLyCongVanList.add(tongCong);
		
		return tinhHinhThuLyCongVanList;
	}
	
	
	private static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanPhongBan(String reportType, String loaiCongVan, String departmentId, long userId, 
													int documentRecordTypeId, String doMat, Date fromDate, Date toDate) throws Exception {
	
		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
			
		if (userId == 0) { // Chon chuyen vien
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanTatCaChuyenVienPhongBan(loaiCongVan, departmentId, documentRecordTypeId, doMat, fromDate, toDate));
		} else if (userId == 1) { // Tat ca chuyen vien
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanChuyenVienPhongBan(reportType, loaiCongVan, departmentId, documentRecordTypeId, doMat, fromDate, toDate, -1, -1));
		} else { // Chuyen vien
			tinhHinhThuLyCongVanList.addAll(getTinhHinhThuLyCongVanChuyenVien(loaiCongVan, departmentId, userId, documentRecordTypeId, doMat, fromDate, toDate));
		}
		
		return tinhHinhThuLyCongVanList;
	}
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanTatCaChuyenVienPhongBan(String loaiCongVan, String departmentId, 
				int documentRecordTypeId, String doMat, Date fromDate, Date toDate) throws Exception {
		
		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		
		int stt = 1;
		String ten = DepartmentUtil.findByPrimaryKey(departmentId).getDepartmentsName();
		int tonDauKy = 0;
		int nhanTrongKy = 0;
		int chuaNhan = 0;
		int dungHan = 0;
		int treHan = 0;
		int tongDaGiaiQuyet = 0;
		int trongQuiDinh = 0;
		int quaQuiDinh = 0;
		int tongDangGiaiQuyet = 0;
		String tyLeGiaiQuyetDungHan = "";
		
		if (loaiCongVan.equals("congvanden")) { // Cong van den
			tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		} else if(loaiCongVan.equals("congvandi")) { // Cong van di
			tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		} 
			
		TinhHinhThuLyCongVanDTO tinhHinhThuLyCongVanDTO = new TinhHinhThuLyCongVanDTO();
		tinhHinhThuLyCongVanDTO.setStt(stt + ".");
		tinhHinhThuLyCongVanDTO.setTen(ten);
		tinhHinhThuLyCongVanDTO.setTonDauKy(tonDauKy);
		tinhHinhThuLyCongVanDTO.setNhanTrongKy(nhanTrongKy);
		tinhHinhThuLyCongVanDTO.setChuaNhan(chuaNhan);
		tinhHinhThuLyCongVanDTO.setDungHan(dungHan);
		tinhHinhThuLyCongVanDTO.setTreHan(treHan);
		tinhHinhThuLyCongVanDTO.setTongDaGiaiQuyet(tongDaGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTrongQuiDinh(trongQuiDinh);
		tinhHinhThuLyCongVanDTO.setQuaQuiDinh(quaQuiDinh);
		tinhHinhThuLyCongVanDTO.setTongDangGiaiQuyet(tongDangGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTyLeGiaiQuyetDungHan(tyLeGiaiQuyetDungHan);
		
		tinhHinhThuLyCongVanList.add(tinhHinhThuLyCongVanDTO);
		
		return tinhHinhThuLyCongVanList;
	}
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanChuyenVienPhongBan(String reportType, String loaiCongVan, 
			String departmentId, int documentRecordTypeId, String doMat, Date fromDate, Date toDate, int start, int end) throws Exception {
		
		
		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
		
		if(reportType.equals("word")) {
			pmlUserList = PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentId, -1, -1, null);
		}
		else {
			pmlUserList = PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentId, start, end, null);
		}
		int pmlUserSize = pmlUserList.size();
		
		// danh cho bien tong cong
		int tongCong_tonDauKy = 0;
		int tongCong_nhanTrongKy = 0;
		int tongCong_chuaNhan = 0;
		int tongCong_dungHan = 0;
		int tongCong_treHan = 0;
		int tongCong_tongDaGiaiQuyet = 0;
		int tongCong_trongQuiDinh = 0;
		int tongCong_quaQuiDinh = 0;
		int tongCong_tongDangGiaiQuyet = 0;
		int tongCong_sum = 0;
		String tongCong_tyLeGiaiQuyetDungHan = "";
		
		for (int index = 0; index < pmlUserSize; index ++) {
			
			long userid = pmlUserList.get(index).getUserId();
			
			int stt = index + 1;
			String ten = TinhHinhThuLyCongVanDWRUtil.getFullName(userid);
			int tonDauKy = 0;
			int nhanTrongKy = 0;
			int chuaNhan = 0;
			int dungHan = 0;
			int treHan = 0;
			int tongDaGiaiQuyet = 0;
			int trongQuiDinh = 0;
			int quaQuiDinh = 0;
			int tongDangGiaiQuyet = 0;
			String tyLeGiaiQuyetDungHan = "";
			
			if (loaiCongVan.equals("congvanden")) { // Cong van den
				tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyChuyenVien_CVDen(userid, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
				int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
				tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
			} else if(loaiCongVan.equals("congvandi")) { // Cong van di
				tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi(userid, documentRecordTypeId, 0, doMat, fromDate, toDate);
				int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
				tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
			}
			
			TinhHinhThuLyCongVanDTO tinhHinhThuLyCongVanDTO = new TinhHinhThuLyCongVanDTO();
			tinhHinhThuLyCongVanDTO.setStt(stt + ".");
			tinhHinhThuLyCongVanDTO.setTen(ten);
			tinhHinhThuLyCongVanDTO.setTonDauKy(tonDauKy);
			tinhHinhThuLyCongVanDTO.setNhanTrongKy(nhanTrongKy);
			tinhHinhThuLyCongVanDTO.setChuaNhan(chuaNhan);
			tinhHinhThuLyCongVanDTO.setDungHan(dungHan);
			tinhHinhThuLyCongVanDTO.setTreHan(treHan);
			tinhHinhThuLyCongVanDTO.setTongDaGiaiQuyet(tongDaGiaiQuyet);
			tinhHinhThuLyCongVanDTO.setTrongQuiDinh(trongQuiDinh);
			tinhHinhThuLyCongVanDTO.setQuaQuiDinh(quaQuiDinh);
			tinhHinhThuLyCongVanDTO.setTongDangGiaiQuyet(tongDangGiaiQuyet);
			tinhHinhThuLyCongVanDTO.setTyLeGiaiQuyetDungHan(tyLeGiaiQuyetDungHan);
			
			tinhHinhThuLyCongVanList.add(tinhHinhThuLyCongVanDTO);
		}
		
		// set gia tri cho bien tong cong
		if (loaiCongVan.equals("congvanden")) { // Cong van den
			tongCong_tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyPhongBan_CVDen(departmentId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongCong_sum = tongCong_tongDaGiaiQuyet + tongCong_tongDangGiaiQuyet;
			tongCong_tyLeGiaiQuyetDungHan = tongCong_sum == 0 ? "-/-" : Round(((float) (tongCong_dungHan + tongCong_trongQuiDinh) / tongCong_sum) * 100, 2) + "%";
		} else if(loaiCongVan.equals("congvandi")) { // Cong van di
			tongCong_tonDauKy = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_nhanTrongKy = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_dungHan = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_treHan = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_trongQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_quaQuiDinh = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi(departmentId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongCong_sum = tongCong_tongDaGiaiQuyet + tongCong_tongDangGiaiQuyet;
			tongCong_tyLeGiaiQuyetDungHan = tongCong_sum == 0 ? "-/-" : Round(((float) (tongCong_dungHan + tongCong_trongQuiDinh) / tongCong_sum) * 100, 2) + "%";
		}
		
		TinhHinhThuLyCongVanDTO tongCong = new TinhHinhThuLyCongVanDTO();
		tongCong.setStt("");
		tongCong.setTen(PortletProps.get("van-ban-cua-phong"));
		tongCong.setTonDauKy(tongCong_tonDauKy);
		tongCong.setNhanTrongKy(tongCong_nhanTrongKy);
		tongCong.setChuaNhan(tongCong_chuaNhan);
		tongCong.setDungHan(tongCong_dungHan);
		tongCong.setTreHan(tongCong_treHan);
		tongCong.setTongDaGiaiQuyet(tongCong_tongDaGiaiQuyet);
		tongCong.setTrongQuiDinh(tongCong_trongQuiDinh);
		tongCong.setQuaQuiDinh(tongCong_quaQuiDinh);
		tongCong.setTongDangGiaiQuyet(tongCong_tongDangGiaiQuyet);
		tongCong.setTyLeGiaiQuyetDungHan(tongCong_tyLeGiaiQuyetDungHan);
		
		tinhHinhThuLyCongVanList.add(tongCong);
		
		return tinhHinhThuLyCongVanList;
	}
	
	public static List<TinhHinhThuLyCongVanDTO> getTinhHinhThuLyCongVanChuyenVien(String loaiCongVan, String departmentId, long userId, 
			int documentRecordTypeId, String doMat, Date fromDate, Date toDate) throws Exception {

		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = new ArrayList<TinhHinhThuLyCongVanDTO>();
		
		int stt = 1;
		String ten = TinhHinhThuLyCongVanDWRUtil.getFullName(userId);
		int tonDauKy = 0;
		int nhanTrongKy = 0;
		int chuaNhan = 0;
		int dungHan = 0;
		int treHan = 0;
		int tongDaGiaiQuyet = 0;
		int trongQuiDinh = 0;
		int quaQuiDinh = 0;
		int tongDangGiaiQuyet = 0;
		String tyLeGiaiQuyetDungHan = "";
		
		if (loaiCongVan.equals("congvanden")) { // Cong van den
			tonDauKy = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			nhanTrongKy = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			dungHan = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			treHan = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			trongQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			quaQuiDinh = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyChuyenVien_CVDen(userId, documentRecordTypeId, 0, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		} else if(loaiCongVan.equals("congvandi")) { // Cong van di
			tonDauKy += PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			nhanTrongKy += PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			dungHan += PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			treHan += PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDaGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			trongQuiDinh += PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			quaQuiDinh += PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			tongDangGiaiQuyet = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi(userId, documentRecordTypeId, 0, doMat, fromDate, toDate);
			int sum = tongDaGiaiQuyet + tongDangGiaiQuyet;
			tyLeGiaiQuyetDungHan = sum == 0 ? "-/-" : Round(((float) (dungHan + trongQuiDinh) / sum) * 100, 2) + "%";
		} 
		
		TinhHinhThuLyCongVanDTO tinhHinhThuLyCongVanDTO = new TinhHinhThuLyCongVanDTO();
		tinhHinhThuLyCongVanDTO.setStt(stt + ".");
		tinhHinhThuLyCongVanDTO.setTen(ten);
		tinhHinhThuLyCongVanDTO.setTonDauKy(tonDauKy);
		tinhHinhThuLyCongVanDTO.setNhanTrongKy(nhanTrongKy);
		tinhHinhThuLyCongVanDTO.setChuaNhan(chuaNhan);
		tinhHinhThuLyCongVanDTO.setDungHan(dungHan);
		tinhHinhThuLyCongVanDTO.setTreHan(treHan);
		tinhHinhThuLyCongVanDTO.setTongDaGiaiQuyet(tongDaGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTrongQuiDinh(trongQuiDinh);
		tinhHinhThuLyCongVanDTO.setQuaQuiDinh(quaQuiDinh);
		tinhHinhThuLyCongVanDTO.setTongDangGiaiQuyet(tongDangGiaiQuyet);
		tinhHinhThuLyCongVanDTO.setTyLeGiaiQuyetDungHan(tyLeGiaiQuyetDungHan);
		
		tinhHinhThuLyCongVanList.add(tinhHinhThuLyCongVanDTO);
		
		return tinhHinhThuLyCongVanList;
	}
	
	
	private void xuatFileWord(PortletRequest req, PortletResponse res, 
								String reportType, String loaiCongVan, String departmentId, 
								long userId, int documentRecordTypeId, String doMat,
								Date fromDate, Date toDate, String name) throws Exception {
	
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		// lay ten phong ban va ten chuyen vien duoc chon thong ke bao cao
		String tenPhongBan = getTenPhongBan(reportType, departmentId, userId);
		
		// format ngay theo dinh dang
		String from_Date = new SimpleDateFormat("dd/MM/yyyy").format(fromDate);
		String to_Date = new SimpleDateFormat("dd/MM/yyyy").format(toDate);
		
		List<TinhHinhThuLyCongVanDTO> tinhHinhThuLyCongVanList = getTinhHinhThuLyCongVan(reportType, loaiCongVan, departmentId, userId, 
								documentRecordTypeId, doMat, fromDate, toDate);
		
		int tinhHinhThuLyCongVanSize = tinhHinhThuLyCongVanList.size();
		for(int i = 0; i < tinhHinhThuLyCongVanSize; i ++) {
			String _name = tinhHinhThuLyCongVanList.get(i).getTen();
			tinhHinhThuLyCongVanList.get(i).setTen(StringUtils.convertToRTF(_name));
		}
		
		String path = request.getSession().getServletContext().getRealPath("reports");
		
		TinhHinhThuLyCongVanUtil rtfUtil = new TinhHinhThuLyCongVanUtil(path, tenPhongBan, from_Date, to_Date,
																		tinhHinhThuLyCongVanList, name);
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/ThongKeTinhHinhThuLyCongVan.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}

	// lay ten phong ban va ten chuyen vien duoc chon thong ke bao cao
	private String getTenPhongBan(String reportType, String departmentId, long userId) {
		String tenPhongBan = "";
		
		Department department = null;
		String departmentName = "";
		
		User userHienThi = null;
		String userName = "";
		
		try {
			department = DepartmentUtil.findByPrimaryKey(departmentId);
			departmentName = department.getDepartmentsName();
		} catch (Exception e) {
			departmentName = "";
		}	
		
		try {
			userHienThi = UserLocalServiceUtil.getUser(userId);
			userName = userHienThi.getLastName() + " " + userHienThi.getMiddleName() + " " + userHienThi.getFirstName();
		} catch (Exception e) {
			userName = "";
		}
		
		if (departmentId.equals("toancoquan") || departmentId.equals("tatcaphongban")) {
			if(reportType.equals("word")) { 
				tenPhongBan = StringUtils.convertToRTF(PortletProps.get("report-toancoquan"));
			}
			else {
				tenPhongBan = PortletProps.get("report-toancoquan");
			}
		} 
		else {
			if (userId == 0 || userId == 1) {
				if(reportType.equals("word")) {
					tenPhongBan = StringUtils.convertToRTF(departmentName);
				}
				else {
					tenPhongBan = departmentName;
				}
			}
			else {
				if(reportType.equals("word")) {
					tenPhongBan = StringUtils.convertToRTF(departmentName) + " - CV: " + StringUtils.convertToRTF(userName);
				}
				else {
					tenPhongBan = departmentName + " - CV: " + userName;
				}
			}
		}
		return tenPhongBan;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	private String getMonth(String date) {
		
		String[] arrDate = date.split("/");
		return (arrDate[1] + "/" + arrDate[2]);
	}
	
	/**
	 * 
	 * @param Rval
	 * @param Rpl
	 * @return
	 */
	private static float Round(float Rval, int Rpl) {
		
		float p = (float) Math.pow(10,Rpl);
		Rval = Rval * p;
		float tmp = Math.round(Rval);
		return (float) tmp / p;
	}

}
