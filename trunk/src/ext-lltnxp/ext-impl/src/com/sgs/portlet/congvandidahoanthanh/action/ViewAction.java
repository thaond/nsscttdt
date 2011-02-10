package com.sgs.portlet.congvandidahoanthanh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.congvandidahoanthanh.dto.CVDiDaHoanThanhDTO;
import com.sgs.portlet.congvandidahoanthanh.search.CVDiDaHoanThanhDisplayTerms;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil;

public class ViewAction extends PortletAction {
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		boolean report = ParamUtil.getBoolean(req, "report", false);
		
		int[] loaiSoCongVanChecked = ParamUtil.getIntegerValues(req, "pmlEdmDocumentRecordTypes", new int[]{});
		
		String fromDate = ParamUtil.getString(req, CVDiDaHoanThanhDisplayTerms.FROMDATE, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		String toDate = ParamUtil.getString(req, CVDiDaHoanThanhDisplayTerms.TODATE, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		if (report == true) {
			printReport(req, res, loaiSoCongVanChecked, fromDate, toDate);
		}
	}

	private void printReport(ActionRequest req, ActionResponse res, int[] loaiSoCongVanChecked, String fromDate, String toDate) {
		
		List<CVDiDaHoanThanhDTO> results = new ArrayList<CVDiDaHoanThanhDTO>();
		// tao moi mot workbook
		HSSFWorkbook wb = new HSSFWorkbook();
		File file = new File("congvandidahoanthanh.xls") ;
	    FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
		}
	
		// tao sheet theo loai so cong van duoc chon
		for (int i = 0; i < loaiSoCongVanChecked.length; i ++) {
			
			try {
				results = getResults(loaiSoCongVanChecked[i], fromDate, toDate, true);
			} catch (SystemException e1) {
			} catch (PortalException e1) {
			}
			
			PmlEdmDocumentRecordType documentRecordType = null;
			try {
				documentRecordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(loaiSoCongVanChecked[i]);
			} catch (PortalException e) {
			} catch (SystemException e) {
			}
			if (documentRecordType != null) {
				String nameSheet = documentRecordType.getDocumentRecordTypeName();
				HSSFSheet sheet = wb.createSheet(nameSheet + " " + i);
				Region region = null;
				
				sheet.autoSizeColumn((short)1);
				sheet.autoSizeColumn((short)2);
				sheet.autoSizeColumn((short)3);
				sheet.autoSizeColumn((short)4);
				sheet.autoSizeColumn((short)5);
				sheet.autoSizeColumn((short)6);
				sheet.autoSizeColumn((short)7);
				sheet.autoSizeColumn((short)8);
				sheet.autoSizeColumn((short)9);
				
				// tao header cho phan bao cao -- bo dong dau tien, begin tu dong thu 2
				HSSFRow row = sheet.createRow((short)1);
				row.setHeight((short)1200);
				try {
					createCellBOLD(wb, row, ( short)1, PortletProps.get("thong-ke-cong-van-trai"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					region = new Region(1, (short)1, 1, (short)2);
					sheet.addMergedRegion(region);
				} catch (Exception e2) {
				}
				
				try {
					createCellBOLD(wb, row, (short)8, PortletProps.get("thong-ke-cong-van-phai"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					region = new Region(1, (short)8, 1, (short)9);
					sheet.addMergedRegion(region);
				} catch (Exception e2) {
				}
				
				// tieu de bao cao
				row = sheet.createRow((short)2);
				row.setHeight((short)1000);
				try {
					createCellBOLD(wb, row, (short)4,
							PortletProps.get("baocaotonghopcongvandahoanthanh")+ " \n "+ PortletProps.get("congvandi"), 
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					region = new Region(2, (short)4, 2, (short)5);
					sheet.addMergedRegion(region);
				} catch (Exception e2) {
				}
				
				row = sheet.createRow((short)3);
				try {
					createCellBOLD(wb, row, (short)4,
							PortletProps.get("tungay")+ " " + fromDate + " - " + PortletProps.get("denngay")+ " " + toDate, 
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					region = new Region(3, (short)4, 3, (short)5);
					sheet.addMergedRegion(region);
				} catch (Exception e2) {
				}
				
				// hien thi loai so cong van duoc chon
				row = sheet.createRow((short)5);
				try {
					createCellBOLD(wb, row, (short)4, nameSheet, 
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					region = new Region(5, (short)4, 5, (short)5);
					sheet.addMergedRegion(region);
				} catch (Exception e2) {
				}
				
				// tieu de cho bang hien thi noi dung bao cao
				row = sheet.createRow((short)7);
				row.setHeight((short)400);
				try {
					createCellBOLD_COLOR(wb, row, (short) 1, "STT", HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 2, PortletProps.get("ngayphathanh"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 3, PortletProps.get("noidung"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 4, PortletProps.get("loaicongvan"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 5, PortletProps.get("nguoikyvanban"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 6, PortletProps.get("nguoisoanvanban"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 7, PortletProps.get("noinhan"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 8, PortletProps.get("nguoitheodoi"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
					createCellBOLD_COLOR(wb, row, (short) 9, PortletProps.get("ghichu"),
							HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
				} catch (Exception e2) {
				}
				
				// input data into cells
				if (results.size() != 0) {
					for (int j = 8; j < results.size() + 8 ; j ++) {
						row = sheet.createRow((short)j);
						row.setHeight((short)350);
//						createCell(wb, row, (short)1, results.get(j - 8).getStt(),
//								HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
						createCell(wb, row, (short)2, results.get(j - 8).getNgayPhatHanh(),
								HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)3, results.get(j - 8).getNoiDung(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)4, results.get(j - 8).getLoaiCongvan(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)5, results.get(j - 8).getNguoiKyVB(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)6, results.get(j - 8).getNguoiSoanVB(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)7, results.get(j - 8).getNoiNhan(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)8, results.get(j - 8).getNguoiTheoDoi(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
						createCell(wb, row, (short)9, results.get(j - 8).getGhiChu(),
								HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.ALIGN_LEFT);
					}
				} else {
					row = sheet.createRow((short)8);
					row.setHeight((short)400);
					try {
						createCellBOLD(wb, row, (short) 4, PortletProps.get("messageview"),
								HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
						region = new Region(8, (short)4, 8, (short)5);
						sheet.addMergedRegion(region);
					} catch (Exception e2) {
					}
				}
			}
		}
		try {
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e1) {
		}
		
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
		}
		
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);		
		try {
			ServletResponseUtil.sendFile(response, "congvandidahoanthanh.xls", in, "application/vnd.ms-excel");
		} catch (Exception e) {
			
		}
	}
	
	private static void createCell(HSSFWorkbook wb, HSSFRow row, short column, String text,  short halign, short valign) {
		HSSFCell cell = row.createCell(column);
        cell.setCellValue(text);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
	}
	
	private static void createCellBOLD_COLOR(HSSFWorkbook wb, HSSFRow row, short column, String text,  short halign, short valign) {
		HSSFCell cell = row.createCell(column);
		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setWrapText( true );        
		cellStyle.setAlignment(halign);
		cellStyle.setVerticalAlignment(valign);
		
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.RED.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);

		HSSFRichTextString string = new HSSFRichTextString(text);
		string.applyFont(font);
		cell.setCellValue(string);
		
		cell.setCellStyle(cellStyle);     
	}
	
	private static void createCellBOLD(HSSFWorkbook wb, HSSFRow row, short column, String text,  short halign, short valign) {
		HSSFCell cell = row.createCell(column);
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFRichTextString string = new HSSFRichTextString(text);
		string.applyFont(font);
		cell.setCellValue(string);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setWrapText( true );        
		cellStyle.setAlignment(halign);
		cellStyle.setVerticalAlignment(valign);
		cell.setCellStyle(cellStyle);     
	}

	public static List<CVDiDaHoanThanhDTO> getResults(int loaiSoCongVanChecked, String fromDate, String toDate, boolean b) throws SystemException, PortalException {
		
		List<CVDiDaHoanThanhDTO> results = new ArrayList<CVDiDaHoanThanhDTO>();
		List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
		PmlEdmDocumentSend cvdi = null;
		
		// lay nhung cv di da hoan thanh theo loai so cong van duoc chon
		try {
			pmlEdmDocumentSendList = PmlEdmDocumentSendLocalServiceUtil.getListPmlEdmDocumentSend(loaiSoCongVanChecked, fromDate, toDate, -1, -1, null);
		} catch (Exception e) {
		}
		
		if (pmlEdmDocumentSendList.size() != 0) {
			for (int j = 0; j < pmlEdmDocumentSendList.size(); j ++) {
				cvdi = pmlEdmDocumentSendList.get(j);
				
				CVDiDaHoanThanhDTO dto = new CVDiDaHoanThanhDTO();
				
				// stt
				dto.setStt((j + 1) + ".");
				// ngay phat hanh
				dto.setNgayPhatHanh(new SimpleDateFormat("dd-MM-yyyy").format(cvdi.getIssuingDate()));
				// noi dung
				dto.setNoiDung(cvdi.getBriefContent());
				// loai cong van
				PmlEdmDocumentType pmlEdmDocumentType = null;
				try {
					pmlEdmDocumentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(cvdi.getDocumentTypeId());
				} catch (Exception e) {
				}
				if (pmlEdmDocumentType != null) {
					dto.setLoaiCongvan(pmlEdmDocumentType.getDocumentTypeName());
				} else {
					dto.setLoaiCongvan("");
				}
				// nguoi ky van ban
				dto.setNguoiKyVB(cvdi.getSignerName());
				// nguoi soan van ban
				String tenNguoiSoanVB = "";
				try {
					tenNguoiSoanVB = TinhHinhThuLyCongVanDWRUtil.getFullName(cvdi.getEditorId());
				} catch (Exception e) {
				}
				if (tenNguoiSoanVB != null) {
					dto.setNguoiSoanVB(tenNguoiSoanVB);
				} else {
					dto.setNguoiSoanVB("");
				}
				// noi nhan
				dto.setNoiNhan(cvdi.getReceivingPlace());
				// nguoi theo doi
				dto.setNguoiTheoDoi("");
				// ghi chu
				dto.setGhiChu("");
				
				results.add(dto);
			}
		}
		return results;
	}


	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				int[] loaiSoCongVanChecked = ParamUtil.getIntegerValues(req, "pmlEdmDocumentRecordTypes", new int[]{});
				req.setAttribute("loaiSoCongVanChecked", loaiSoCongVanChecked);
				
				// lay tat ca loai so cong van co trong csdl
				List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
				Collections.sort(pmlEdmDocumentRecordTypeList, new Comparator<PmlEdmDocumentRecordType>() {
					public int compare(PmlEdmDocumentRecordType o1, PmlEdmDocumentRecordType o2) {
						return o1.getDocumentRecordTypeName().compareTo (o2.getDocumentRecordTypeName());
					}
				});
				req.setAttribute("pmlEdmDocumentRecordTypeList", pmlEdmDocumentRecordTypeList);
				
				return mapping.findForward("portlet.sgs.congvandidahoanthanh.view");
			}
	}
	
}
