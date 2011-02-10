package com.sgs.portlet.pcccdocumentreceiptreport.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO;
import com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailDisplayTerms;
import com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.ReportUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanUtil;

public class PCCCDocumentSendDetailsAction extends DocumentSendPortletAction {

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		
		// lay du lieu de xuat report
		String action = ParamUtil.getString(req, "action");
		String rowDS = ParamUtil.getString(req, "row");
		String userIdRow = ParamUtil.getString(req, "userIdRow");
		
		String departmentId = ParamUtil.getString(req, "departmentId");
		long userId = ParamUtil.getLong(req, "userId", 0);
		int nhomCongVan = ParamUtil.getInteger(req, "nhomCongVan", 0);
		String doMat = ParamUtil.getString(req, "doMat");
		
		Date fromDate = new Date();
		Date toDate = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
		
		if(ParamUtil.getString(req, "fromDate") != "" && ParamUtil.getString(req, "toDate") != "") {
			fromDate = fm.parse(ParamUtil.getString(req, "fromDate"));
			toDate = fm.parse(ParamUtil.getString(req, "toDate"));
		}
		
		int loaiSoCongVan = ParamUtil.getInteger(req, DocumentDetailDisplayTerms.LOAISOCONGVAN, 0);
		
		String orderByCol = ParamUtil.getString(req, "orderByCol");
		String orderByType = ParamUtil.getString(req, "orderByType");
		OrderByComparator obc = DocumentDetailUtil.getDocumentDetailOrderByComparator(orderByCol, orderByType);
		
		if (Validator.isNull(cmd) == false) {
			if (cmd.equals("printReport")) { // Report
				String reportType = ParamUtil.getString(req, "reportType");
				
				if (reportType.equals("word")) { // Xuat file Word
					printReportWord(req, res, reportType, nhomCongVan, loaiSoCongVan, departmentId, userId, doMat, 
							fromDate, toDate, action, rowDS, userIdRow, -1, -1, obc);
				} 
				else if (reportType.equals("excel")) { // Xuat file Excel
					printReportExcel(req, res, reportType, nhomCongVan, loaiSoCongVan, departmentId, userId, doMat, 
							fromDate, toDate, action, rowDS, userIdRow, -1, -1, obc);
				}
			}
		}
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); 
		}
		else {
			String action = ParamUtil.getString(req, "action");
			String rowDS = ParamUtil.getString(req, "row");
			String userIdRow = ParamUtil.getString(req, "userIdRow");
			String departmentId = ParamUtil.getString(req, "departmentId");
			long userId = ParamUtil.getLong(req, "userId", 0);
			
			String tenPhongBan = ReportUtil.getTenPhongBan(rowDS, userIdRow, departmentId, userId);
			String tenAction = ReportUtil.getTenAction(action);
			
			req.setAttribute("tenPhongBan", tenPhongBan);
			req.setAttribute("tenAction", tenAction);
			
			return mapping.findForward("portlet.sgs.pcccdocumentreceiptreport.pcccdocumentsenddetails");
		}
	}

	private void printReportWord(PortletRequest req, PortletResponse res, String reportType, int nhomCongVan, int loaiSoCongVan, 
						String departmentId, long userId, String doMat, Date fromDate, Date toDate, String action, 
						String rowDS, String userIdRow, int start, int end, OrderByComparator obc) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);

		// format ngay theo dinh dang
		String from_Date = new SimpleDateFormat("dd/MM/yyyy").format(fromDate);
		String to_Date = new SimpleDateFormat("dd/MM/yyyy").format(toDate);
		// end

		// get ten phong ban
		String tenPhongBan = ReportUtil.getTenPhongBan(rowDS, userIdRow, departmentId, userId);
		// end

		// get ten action
		String tenAction = ReportUtil.getTenAction(action);
		// end

		// get danh sach tuong ung
		List<PCCCDocumentListDTO> documentList = getDocumentListDTOReport(reportType, nhomCongVan, loaiSoCongVan, 
							departmentId, userId, doMat, fromDate, toDate, action, rowDS, userIdRow, start, end, obc);
		// end

		String path = request.getSession().getServletContext().getRealPath("reports");

		TinhHinhThuLyCongVanUtil rtfUtil = new TinhHinhThuLyCongVanUtil(path, StringUtils.convertToRTF(tenPhongBan), 
												StringUtils.convertToRTF(tenAction), from_Date, to_Date, documentList);
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext()
				.getRealPath("reports/DSThongKeCongVanDi.rtf"));
		ServletResponseUtil.sendFile(response, "DSThongKeCongVanDi.rtf", in, "application/rtf");
	}
	
	
	private void printReportExcel(PortletRequest req, PortletResponse res, String reportType, int nhomCongVan, int loaiSoCongVan, 
									String departmentId, long userId, String doMat, Date fromDate, Date toDate, String action, 
									String rowDS, String userIdRow, int start, int end, OrderByComparator obc) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		List<PCCCDocumentListDTO> results = getDocumentListDTOReport(reportType, nhomCongVan, loaiSoCongVan, 
								departmentId, userId, doMat, fromDate, toDate, action, rowDS, userIdRow, start, end, obc);
		
		// tao moi mot workbook
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("thongkevanban"); // tao moi mot sheet
	    
		CellStyle cellStyleOne  = wb.createCellStyle();
		CellStyle cellStyleTwo = wb.createCellStyle();
		CellStyle cellStyleThree = wb.createCellStyle();
		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		CellRangeAddress region = null;	
		Font font = wb.createFont();
		Row row = null;
	    
		File file = new File("thongkevanban.xls") ;
		FileOutputStream fileOut = null;
		
		// set do rong cho cell
		for (int i = 1; i < 9; i ++) {
			if (i == 1) {
				sheet.setColumnWidth(i, 10*256);
			}
			else if (i == 5 || i == 6 || i == 8) {
				sheet.setColumnWidth(i, 30*256);
			}
			else {
				sheet.setColumnWidth(i, 20*256);
			}
		}
	    
		// tao header cho phan bao cao -- bo dong dau tien, begin tu dong thu 2
		row = sheet.createRow(1);
		row.setHeight((short)800);
		
		// tieu de ben trai
		try {
			createCellBOLD(font, cellStyleOne, row, (short)1, PortletProps.get("thong-ke-cong-van-trai"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(1, 1, 1, 3);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// tieu de ben phai
		try {
			createCellBOLD(font, cellStyleOne, row, (short)7, PortletProps.get("thong-ke-cong-van-phai"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(1, 1, 7, 8);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// tieu de bao cao
		row = sheet.createRow(3);
		row.setHeight((short)400);
		try {
			createCellBOLD(font, cellStyleOne, row, (short)4, PortletProps.get("thong-ke-tinh-hinh-thu-ly-van-ban"), 
					CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(3, 3, 4, 6);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// ten phong ban
		row = sheet.createRow(4);
		row.setHeight((short)400);
		try {
			createCellBOLD(font, cellStyleOne, row, (short)4, ReportUtil.getTenPhongBan(rowDS, userIdRow, departmentId, userId), 
					CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(4, 4, 4, 6);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// ten action
		row = sheet.createRow(5);
		row.setHeight((short)400);
		try {
			createCellBOLD(font, cellStyleOne, row, (short)4, 
					PortletProps.get("report-danhsachvanbanden") + " " + ReportUtil.getTenAction(action) + " " + PortletProps.get("report-phanmemloi"), 
					CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(5, 5, 4, 6);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// tu ngay den ngay bao cao
		row = sheet.createRow(6);
		row.setHeight((short)400);
		try {
			createCellBOLD(font, cellStyleOne, row, (short)4,
					PortletProps.get("tungay")+ " " + format.format(fromDate) + " - " + PortletProps.get("denngay")+ " " + format.format(toDate), 
					CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			region = new CellRangeAddress(6, 6, 4, 6);
			sheet.addMergedRegion(region);
		} catch (Exception e2) { }
		
		// tieu de cot bao cao
		row = sheet.createRow(8);
		try {
			createCellBOLD_COLOR(font, cellStyleTwo, row, 1, "STT", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 2, PortletProps.get("loai-van-ban"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 3, PortletProps.get("receipt.creator"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 4, PortletProps.get("receipt.signer"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 5, PortletProps.get("receipt.receiveplace"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 6, PortletProps.get("document_brief_content"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 7, PortletProps.get("pccc-cvdtn-domat"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
			createCellBOLD_COLOR(font, cellStyleTwo, row, 8, PortletProps.get("report-chuyenviendangxuly"), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
		} catch (Exception e) { }
		
		// input data into cells
		int curRow = 9;
		for (int i = 0; i < results.size(); i ++) {
			row = sheet.createRow(curRow ++);
			try {
				createCell(createHelper, cellStyleThree, row, 1, results.get(i).getStt(), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
				createCell(createHelper, cellStyleThree, row, 2, results.get(i).getLoaiVB(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyleThree, row, 3, results.get(i).getNguoiTao(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyleThree, row, 4, results.get(i).getNguoiKyVB(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyle, row, 5, results.get(i).getNoiNhan(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyle, row, 6, results.get(i).getTrichYeu(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyleThree, row, 7, results.get(i).getDoMat(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
				createCell(createHelper, cellStyle, row, 8, results.get(i).getNguoiXuLy(), CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT);
			} catch (Exception e1) { }
		}
		
		try {
			fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e1) { }
	    
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
		}
	
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);		
		try {
			ServletResponseUtil.sendFile(response, "thongkevanban.xls", in, "application/vnd.ms-excel");
		} catch (Exception e) { }
	}
	
	
	private static void createCell(CreationHelper createHelper, CellStyle cellStyle, Row row, int column, String text, short halign, short valign) {
		cellStyle.setWrapText(true); 
		cellStyle.setAlignment(halign);
	    cellStyle.setVerticalAlignment(valign);
	    
	    Cell cell = row.createCell(column);
	    cell.setCellValue(createHelper.createRichTextString(text));
		cell.setCellStyle(cellStyle);     
	}
	
	
	private static void createCellBOLD(Font font, CellStyle cellStyle, Row row, int column, String text, short halign, short valign) {
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		cellStyle.setWrapText( true );        
		cellStyle.setAlignment(halign);
		cellStyle.setVerticalAlignment(valign);
		cellStyle.setFont(font);
		
		HSSFRichTextString richText = new HSSFRichTextString(text);
		richText.applyFont(font);
		
		Cell cell = row.createCell(column);
		cell.setCellValue(richText);	
		cell.setCellStyle(cellStyle);  
	}
	
	
	private static void createCellBOLD_COLOR(Font font, CellStyle cellStyle, Row row,  int column, String text, short halign, short valign) {
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle.setWrapText(true);        
		cellStyle.setAlignment(halign);
		cellStyle.setVerticalAlignment(valign);		
		cellStyle.setFont(font);
		
		HSSFRichTextString richText = new HSSFRichTextString(text);
		richText.applyFont(font);		
		
		Cell cell = row.createCell(column);
		cell.setCellValue(richText);
		cell.setCellStyle(cellStyle);   
	}
	
	
	public static List<PCCCDocumentListDTO> getDocumentListDTOReport(String reportType, int nhomCongVan, int loaiSoCongVan, 
				String departmentId, long userId, String doMat, Date fromDate, Date toDate, String action, String rowDS, 
				String userIdRow, int start, int end, OrderByComparator obc) throws Exception {

		List<PCCCDocumentListDTO> pCCCDocumentListDTO = new ArrayList<PCCCDocumentListDTO>();
		
		List<PmlEdmDocumentSend> list = null;
		
		/**
		 * toan co quan
		 */
		if (departmentId.equals("toancoquan")) {
			list = new ArrayList<PmlEdmDocumentSend>();
			
			if (action.equals("tondauky")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			} 
			else if (action.equals("nhantrongky")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			}
			else if (action.equals("dunghan")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			} 
			else if (action.equals("trehan")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			} 
			else if (action.equals("tongdagiaiquyet")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			}
			else if (action.equals("trongquidinh")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			}
			else if (action.equals("quaquydinh")) {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			}
			else {
				list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
								start, end, obc));
			}
		}
		
		/**
		 * tat ca phong ban
		 */
		else if (departmentId.equals("tatcaphongban")) {
			list = new ArrayList<PmlEdmDocumentSend>();

			if (!rowDS.equals("tatcaphongban")) {
				String departmentid = rowDS;
					
				if (action.equals("tondauky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("nhantrongky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("chuanhan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listChuaNhanTrongKyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("dunghan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("trehan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("tongdagiaiquyet")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("trongquidinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else if (action.equals("quaquydinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
			}
			
			// chon xem danh sach van ban tu dong TONG CONG	
			else if (rowDS.equals("tatcaphongban")) {
				if (action.equals("tondauky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("nhantrongky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("dunghan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("trehan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("tongdagiaiquyet")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("trongquidinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("quaquydinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
			}
		}
		
		/**
		 * chon tung phong ban cu the
		 * trong truong hop nay phan ra thanh 3 truong hop nho
		 * 1.	Chon chuyen vien (ko chon chuyen vien nao - chi hien thi ten phong ban) userId = 0
		 * 2.	Chon tat ca chuyen vien cua phong ban (luc nay se hien thi danh sach chuyen vien cua tung phong ban) userId = 1
		 * 3.	Chon chuyen vien cu the (chi hien thi chuyen vien duoc chon)
		 */
		else {
			list = new ArrayList<PmlEdmDocumentSend>();
			
			if (userId == 0) {
				if (action.equals("tondauky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("nhantrongky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("chuanhan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listChuaNhanTrongKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else if (action.equals("dunghan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else if (action.equals("trehan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else if (action.equals("tongdagiaiquyet")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else if (action.equals("trongquidinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
				else if (action.equals("quaquydinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} 
				else {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
			} 
			
			else if (userId == 1) {
				if (!userIdRow.equals("tatcachuyenvien")) {
					long userid = Long.parseLong(userIdRow);
		
					if (action.equals("tondauky")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("nhantrongky")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("chuanhan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listChuaNhanChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("dunghan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("trehan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("tongdagiaiquyet")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("trongquidinh")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else if (action.equals("quaquydinh")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} else {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
				}
				// chon xem danh sach van ban tu dong TONG CONG
				else if (userIdRow.equals("tatcachuyenvien")) {
					if (action.equals("tondauky")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} 
					else if (action.equals("nhantrongky")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} 
					else if (action.equals("chuanhan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listChuaNhanTrongKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} 
					else if (action.equals("dunghan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
					else if (action.equals("trehan")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
					else if (action.equals("tongdagiaiquyet")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
					else if (action.equals("trongquidinh")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
					else if (action.equals("quaquydinh")) {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					} 
					else {
						list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
										start, end, obc));
					}
				}
			}
			
			else {
				if (action.equals("tondauky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTonDauKyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("nhantrongky")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listNhanTrongKyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("chuanhan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listChuaNhanChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("dunghan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("trehan")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("tongdagiaiquyet")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("trongquidinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listDungHanDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else if (action.equals("quaquydinh")) {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTreHanDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				} else {
					list.addAll(PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate, 
									start, end, obc));
				}
			}
		}
		
		PmlEdmDocumentSend documentSend = null;
		PmlEdmConfidentialLevel confidentialLevel = null;
		List<PmlDocumentSendLog> listLog = new ArrayList<PmlDocumentSendLog>();
		long documentSendId = 0;
		long editorId = 0;
		PmlEdmDocumentType documentType = null;
		
		for (int i = 0; i < list.size(); i++) {
			documentSend = (PmlEdmDocumentSend)list.get(i);
			documentSendId = documentSend.getDocumentSendId();
			
			// bien dto
			String loaiVBDTO = "";
			String nguoiTaoDTO = "";
			String nguoiKyVBDTO = "";
			String noiNhanDTO = "";
			String trichYeuDTO = "";
			String doMatDTO = "";
			String nguoiXuLyDTO = "";
			
			// loai van ban
			try {
				documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentSend.getDocumentTypeId());
				loaiVBDTO = documentType.getDocumentTypeName();
			} catch (Exception e) {
				loaiVBDTO = "";
			}
		
			// nguoi tao
			editorId = documentSend.getEditorId();
			try {
				nguoiTaoDTO = TinhHinhThuLyCongVanDWRUtil.getFullName(editorId);
			} catch (Exception e) {
				nguoiTaoDTO = "";
			}
			
			// nguoi ky van ban
			nguoiKyVBDTO = documentSend.getSignerName();
			
			// noi nhan
			noiNhanDTO = documentSend.getReceivingPlace();
			
			// trich yeu
			trichYeuDTO = documentSend.getBriefContent();
			
			// do mat
			try {
				if (!doMat.equals("")) {
					confidentialLevel = PmlEdmConfidentialLevelUtil.findByPrimaryKey(doMat);
				} else {
					confidentialLevel = PmlEdmConfidentialLevelUtil.findByPrimaryKey(documentSend.getConfidentialLevelId());
				}
				doMatDTO = confidentialLevel.getConfidentialLevelName();
			} catch (Exception e) { }
			
			// nguoi xu ly
			PmlDocumentSendLog log = null;
			PmlDocumentSendLog processorRoot = null;
			String proceesorRootName = "";
			String receiverName = "";
			int step = 1;
			
			// van thu
			try {
				processorRoot = PmlDocumentSendLogUtil.findByDocumentSendId_Step(documentSendId, step).get(0);
				proceesorRootName = TinhHinhThuLyCongVanDWRUtil.getFullName(processorRoot.getProcesser());
				nguoiXuLyDTO += proceesorRootName;
			} catch (Exception e) { }
			
			// luan chuyen
			try {
				listLog = PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Step(documentSendId, processorRoot.getProcesser(), step);
				if (listLog.get(0).getReceiver() == 0) {
					listLog = new ArrayList<PmlDocumentSendLog>();
				}
				
				while (listLog.size() > 0) {
					step ++;
					int size = listLog.size();
					nguoiXuLyDTO += " -> ";
					for (int j = 0; j < size; j ++) {
						log = listLog.get(j);
						receiverName = TinhHinhThuLyCongVanDWRUtil.getFullName(log.getReceiver());
						
						nguoiXuLyDTO += receiverName;
						listLog = PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Step
																					(documentSendId, log.getReceiver(), step);
						if (listLog.get(0).getReceiver() == 0) {
							listLog = new ArrayList<PmlDocumentSendLog>();
						}
					}
				}
			} catch (Exception e) { }
				
			PCCCDocumentListDTO dto =  new PCCCDocumentListDTO();
			dto.setDocumentId(documentSend.getDocumentSendId());
			dto.setStt((i+1) + ".");
			if (reportType.equals("word")) {
				dto.setLoaiVB(StringUtils.convertToRTF(loaiVBDTO));
				dto.setNguoiTao(StringUtils.convertToRTF(nguoiTaoDTO));
				dto.setNguoiKyVB(StringUtils.convertToRTF(nguoiKyVBDTO));
				dto.setNoiNhan(StringUtils.convertToRTF(noiNhanDTO));
				dto.setTrichYeu(StringUtils.convertToRTF(trichYeuDTO));
				dto.setDoMat(StringUtils.convertToRTF(doMatDTO));
				dto.setNguoiXuLy(StringUtils.convertToRTF(nguoiXuLyDTO));
			} else {
				dto.setLoaiVB(loaiVBDTO);
				dto.setNguoiTao(nguoiTaoDTO);
				dto.setNguoiKyVB(nguoiKyVBDTO);
				dto.setNoiNhan(noiNhanDTO);
				dto.setTrichYeu(trichYeuDTO);
				dto.setDoMat(doMatDTO);
				dto.setNguoiXuLy(nguoiXuLyDTO);
			}
			pCCCDocumentListDTO.add(dto);
		}
		
		return pCCCDocumentListDTO;
	}

	
	// dung cho ham count danh sach thong ke tu con so cu the
	public static int countDocumentListDTOReport(int nhomCongVan, int loaiSoCongVan, String departmentId, long userId,
			String doMat, Date fromDate, Date toDate, String action, String rowDS, String userIdRow) throws Exception {
		
		int total = 0;

		/**
		 * toan co quan
		 */
		if (departmentId.equals("toancoquan")) {
			if (action.equals("tondauky")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("nhantrongky")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("dunghan")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("trehan")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("tongdagiaiquyet")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("trongquidinh")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else if (action.equals("quaquydinh")) {
				total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			} 
			else {
				total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLySo_CVDi
								(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
			}
		}
		
		/**
		 * tat ca phong ban
		 */
		else if (departmentId.equals("tatcaphongban")) {
			if (!rowDS.equals("tatcaphongban")) {
				String departmentid = rowDS;
						
				if (action.equals("tondauky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("nhantrongky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("chuanhan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi
							(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("dunghan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trehan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate );
				} 
				else if (action.equals("tongdagiaiquyet")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trongquidinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("quaquydinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi
									(departmentid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				}
			}
			// chon xem danh sach van ban tu dong TONG CONG		
			else if (rowDS.equals("tatcaphongban")) {
				if (action.equals("tondauky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("nhantrongky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("dunghan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("trehan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("tongdagiaiquyet")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("trongquidinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else if (action.equals("quaquydinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} else {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLySo_CVDi
									(nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				}
			}
		} 
		
		/**
		 * chon tung phong ban cu the
		 * trong truong hop nay phan ra thanh 3 truong hop nho
		 * 1.	Chon chuyen vien (ko chon chuyen vien nao - chi hien thi ten phong ban) userId = 0
		 * 2.	Chon tat ca chuyen vien cua phong ban (luc nay se hien thi danh sach chuyen vien cua tung phong ban) userId = 1
		 * 3.	Chon chuyen vien cu the (chi hien thi chuyen vien duoc chon)
		 */
		else {
			if (userId == 0) {
				if (action.equals("tondauky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("nhantrongky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("chuanhan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("dunghan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trehan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("tongdagiaiquyet")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trongquidinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("quaquydinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi
									(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				}
			}
			
			else if (userId == 1) {
				if (!userIdRow.equals("tatcachuyenvien")) {
					long userid = Long.parseLong(userIdRow);
		
					if (action.equals("tondauky")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate 
										);
					} 
					else if (action.equals("nhantrongky")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("chuanhan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("dunghan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("trehan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					}
					else if (action.equals("tongdagiaiquyet")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("trongquidinh")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("quaquydinh")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					}
					else {
						total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi
										(userid, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
						
					}
				}
				// chon xem danh sach van ban tu dong TONG CONG
				else if (userIdRow.equals("tatcachuyenvien")) {
					if (action.equals("tondauky")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("nhantrongky")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("chuanhan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanTrongKyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("dunghan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("trehan")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("tongdagiaiquyet")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("trongquidinh")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else if (action.equals("quaquydinh")) {
						total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					} 
					else {
						total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyPhongBan_CVDi
										(departmentId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
					}
				}
			} 
			
			else {
				if (action.equals("tondauky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("nhantrongky")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("chuanhan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("dunghan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trehan")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("tongdagiaiquyet")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("trongquidinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countDungHanDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else if (action.equals("quaquydinh")) {
					total = PmlEdmDocumentSendLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				} 
				else {
					total = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi
									(userId, nhomCongVan, loaiSoCongVan, doMat, fromDate, toDate);
				}
			}
		}
		
		return total;
	}
}
