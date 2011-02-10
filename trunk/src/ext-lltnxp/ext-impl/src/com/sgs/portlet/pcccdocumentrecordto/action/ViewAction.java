package com.sgs.portlet.pcccdocumentrecordto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sourceforge.rtf.StringUtils;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.pcccdocumentrecordto.dto.DocumentRecordToDTO;
import com.sgs.portlet.pcccdocumentrecordto.search.DocumentRecordToDisplayTerms;
import com.sgs.portlet.pcccdocumentrecordto.util.DocumentRecordToUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;

public class ViewAction extends PortletAction {
	
	private final static Logger _log = Logger.getLogger(ViewAction.class);
	
	@Override
	public ActionForward strutsExecute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			String reportType = ParamUtil.getString(request, "reportType");
			String cmd = ParamUtil.getString(request, "cmd", "");
			if (Validator.isNull(cmd) == false) {
				
				String phongBan = ParamUtil.getString(request, DocumentRecordToDisplayTerms.PHONGBAN);
				String soNoiBo = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.SONOIBO, true);
				String soHieuGoc = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.SOHIEUGOC, true);
				
				int ngayDenDay = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENDAY, 0);
				int ngayDenMonth = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENMONTH, 0);
				int ngayDenYear = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENYEAR, 0);
				
				int ngayPhatHanhDay = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHDAY, 0);
				int ngayPhatHanhMonth = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHMONTH, 0);
				int ngayPhatHanhYear = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHYEAR, 0);
				
				long capGui = ParamUtil.getLong(request, DocumentRecordToDisplayTerms.CAPGUI);
				long loaiVB = ParamUtil.getLong(request, DocumentRecordToDisplayTerms.LOAIVB);
				String noiPhatHanh = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.NOIPHATHANH, true);
				String thongTinTrichYeu = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.TRICHYEU, true);
				String uuTien = ParamUtil.getString(request, DocumentRecordToDisplayTerms.UUTIEN);
				
				if (cmd.equals("report")) { // Report
					xuatExcel(request, response, reportType, phongBan, soNoiBo, soHieuGoc, ngayDenDay, ngayDenMonth, ngayDenYear,
							ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear, capGui, loaiVB, noiPhatHanh, thongTinTrichYeu, uuTien);
				}
			}
			return null;
		} catch (Exception e) {
			PortalUtil.sendError(e, request, response);

			return null;
		}
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		String cmd = ParamUtil.getString(req, "cmd", "");
		if (Validator.isNull(cmd) == false) {
			if (cmd.equals("report")) { // Report
				String reportType = ParamUtil.getString(req, "reportType");
				
				String phongBan = ParamUtil.getString(request, DocumentRecordToDisplayTerms.PHONGBAN);
				String soNoiBo = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.SONOIBO, true);
				String soHieuGoc = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.SOHIEUGOC, true);
				
				int ngayDenDay = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENDAY, 0);
				int ngayDenMonth = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENMONTH, 0);
				int ngayDenYear = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYDENYEAR, 0);
				
				int ngayPhatHanhDay = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHDAY, 0);
				int ngayPhatHanhMonth = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHMONTH, 0);
				int ngayPhatHanhYear = ParamUtil.getInteger(request, DocumentRecordToDisplayTerms.NGAYPHYEAR, 0);
				
				long capGui = ParamUtil.getLong(request, DocumentRecordToDisplayTerms.CAPGUI);
				long loaiVB = ParamUtil.getLong(request, DocumentRecordToDisplayTerms.LOAIVB);
				String noiPhatHanh = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.NOIPHATHANH, true);
				String thongTinTrichYeu = DAOParamUtil.getLike(request, DocumentRecordToDisplayTerms.TRICHYEU, true);
				String uuTien = ParamUtil.getString(request, DocumentRecordToDisplayTerms.UUTIEN);
				
				if (reportType.equals("word")) { // Xuat file Word
					inBaoCao(request, response, reportType, phongBan, soNoiBo, soHieuGoc, ngayDenDay, ngayDenMonth, ngayDenYear,
							ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear, capGui, loaiVB, noiPhatHanh, thongTinTrichYeu, uuTien);
				} 
				else if (reportType.equals("excel")) { // Xuat file Excel
					req.setAttribute(WebKeys.PORTLET_STRUTS_EXECUTE, true);
					xuatExcel(request, response, reportType, phongBan, soNoiBo, soHieuGoc, ngayDenDay, ngayDenMonth, ngayDenYear,
							ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear, capGui, loaiVB, noiPhatHanh, thongTinTrichYeu, uuTien);
				}
			}
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pcccdocumentrecordto.view");
			}
	}
	
	private List<DocumentRecordToDTO> getDocumentRecordToListReport(String reportType,String phongBan,String soNoiBo,
				String soHieuGoc,int ngayDenDay,int ngayDenMonth,int ngayDenYear,int ngayPhatHanhDay,int ngayPhatHanhMonth,
				int ngayPhatHanhYear,long capGui,long loaiVB,String noiPhatHanh,String thongTinTrichYeu,String uuTien){
		
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = new ArrayList<PmlEdmDocumentReceipt>();
		try {
			pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptLocalServiceUtil.findByN_D_I_L_I_P_D_D_D_B(soNoiBo, soHieuGoc, ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear, capGui, noiPhatHanh, uuTien, ngayDenDay, ngayDenMonth, ngayDenYear, loaiVB, phongBan, thongTinTrichYeu, -1, -1, null);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		int stt = 1;
		String soCVNoiBo = "";
		String soCVDen = "";
		String ngayDen = "";
		String ngayPhatHanh = "";
		String noiBanHanh = "";
		String trichYeu = "";
		String loaiCV = "";
		
		PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
		PmlEdmDocumentType documentType = null;
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
		List<DocumentRecordToDTO> documentRecordToList = new ArrayList<DocumentRecordToDTO>();
		
		for (PmlEdmDocumentReceipt documentReceipt : pmlEdmDocumentReceiptList) {
			try {
				pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceipt.getDocumentReceiptId());
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
			soCVNoiBo = pmlEdmDocumentReceipt.getNumberDocumentReceipt();
			soCVDen = pmlEdmDocumentReceipt.getDocumentReference();
			
			if (null != pmlEdmDocumentReceipt.getDateArrive()) {
				ngayDen = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive());
			}
			
			if (null != pmlEdmDocumentReceipt.getIssuingDate()) {
				ngayPhatHanh = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getIssuingDate());
			}
			
			String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
			if(issuingPlaceId.equals("")) {
				noiBanHanh = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
			} else {
				try {
					pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId());
					noiBanHanh = pmlEdmIssuingPlace.getIssuingPlaceName();
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
			}
			
			trichYeu = pmlEdmDocumentReceipt.getBriefContent();
			try {
				documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId());
				loaiCV = documentType.getDocumentTypeName();
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
			DocumentRecordToDTO documentRecordToDTO = new DocumentRecordToDTO();
			if ("word".equals(reportType)) {
				documentRecordToDTO.setStt(stt);
				documentRecordToDTO.setSoCVNoiBo(StringUtils.convertToRTF(soCVNoiBo));
				documentRecordToDTO.setSoCVDen(StringUtils.convertToRTF(soCVDen));
				documentRecordToDTO.setLoaiCV(StringUtils.convertToRTF(loaiCV));
				documentRecordToDTO.setNgayDen(ngayDen);
				documentRecordToDTO.setNgayPhatHanh(ngayPhatHanh);
				documentRecordToDTO.setNoiBanHanh(StringUtils.convertToRTF(noiBanHanh));
				documentRecordToDTO.setTrichYeu(StringUtils.convertToRTF(trichYeu));
			}
			else if ("excel".equals(reportType)) {
				documentRecordToDTO.setStt(stt);
				documentRecordToDTO.setSoCVNoiBo(soCVNoiBo);
				documentRecordToDTO.setSoCVDen(soCVDen);
				documentRecordToDTO.setLoaiCV(loaiCV);
				documentRecordToDTO.setNgayDen(ngayDen);
				documentRecordToDTO.setNgayPhatHanh(ngayPhatHanh);
				documentRecordToDTO.setNoiBanHanh(noiBanHanh);
				documentRecordToDTO.setTrichYeu(trichYeu);
			}
			stt++;
			documentRecordToList.add(documentRecordToDTO);
		}
		
		return documentRecordToList;
	}

	private void inBaoCao(HttpServletRequest request, HttpServletResponse response, String reportType,String phongBan,String soNoiBo,
			String soHieuGoc,int ngayDenDay,int ngayDenMonth,int ngayDenYear,int ngayPhatHanhDay,int ngayPhatHanhMonth,
			int ngayPhatHanhYear,long capGui,long loaiVB,String noiPhatHanh,String thongTinTrichYeu,String uuTien) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("reports");
		String pathTemplate = request.getSession().getServletContext().getRealPath("reports/SoCongVanDenCuaPhong.rtf");
		
		DocumentRecordToUtil rtfUtil = new DocumentRecordToUtil(path, getDocumentRecordToListReport(reportType, phongBan, 
				soNoiBo, soHieuGoc, ngayDenDay, ngayDenMonth, ngayDenYear, ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear,
				capGui, loaiVB, noiPhatHanh, thongTinTrichYeu, uuTien));
		InputStream in = rtfUtil.run(pathTemplate);
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	private void xuatExcel(HttpServletRequest request, HttpServletResponse response, String reportType,String phongBan,String soNoiBo,
			String soHieuGoc,int ngayDenDay,int ngayDenMonth,int ngayDenYear,int ngayPhatHanhDay,int ngayPhatHanhMonth,
			int ngayPhatHanhYear,long capGui,long loaiVB,String noiPhatHanh,String thongTinTrichYeu,String uuTien) throws Exception {
		
		ServletContext context = request.getSession().getServletContext();
		JRExporter exporter = null;
		
		JasperDesign subDesign1 = JRXmlLoader.load(context.getRealPath("reports/SoCongVanDenCuaPhong_subreport.jrxml"));
		JasperReport subJasperReport1 = JasperCompileManager.compileReport(subDesign1);
		
		Map subMap1 = new HashMap();
		
		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(getDocumentRecordToListReport(reportType, phongBan,
				soNoiBo, soHieuGoc, ngayDenDay, ngayDenMonth, ngayDenYear, ngayPhatHanhDay, ngayPhatHanhMonth, ngayPhatHanhYear, capGui,
				loaiVB, noiPhatHanh, thongTinTrichYeu, uuTien));
		
		JasperCompileManager.compileReportToFile(context.getRealPath("reports/SoCongVanDenCuaPhong.jrxml"), 
				context.getRealPath("reports/SoCongVanDenCuaPhong.jasper"));

		Map map = new HashMap();
		map.put("dataSource1", dataSource1);
		map.put("subReport1", subJasperReport1);
		map.put("subMap1", subMap1);
		
		JREmptyDataSource dataSource = new JREmptyDataSource();
		
		JasperFillManager.fillReportToFile(context.getRealPath("reports/SoCongVanDenCuaPhong.jasper"),
											context.getRealPath("reports/SoCongVanDenCuaPhong.jrprint"), map, dataSource);
		
		File srcFile = new File(context.getRealPath("reports/SoCongVanDenCuaPhong.jrprint"));
		File desFile = null;
		
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
		desFile = File.createTempFile(jasperPrint.getName(), ".xls");
		
		exporter = new JExcelApiExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile.toString());
//		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);

		exporter.exportReport();
	
		ServletResponseUtil.sendFile(response, "SoCongVanDenCuaPhong.xls", new FileInputStream(desFile), "application/vnd.ms-excel");
		
	}
	
	/* yenlt close 04062010
	 * 
	private Date convertDateFormat(Date date, String DATE_FORMAT) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		Date retValue = null;
		try {
			retValue = df.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	private List<DocumentRecordToDTO> getDocumentRecordToList(RenderRequest req) throws Exception {
		
		List<DocumentRecordToDTO> documentRecordToList = new ArrayList<DocumentRecordToDTO>();
		
		String pmlDepartmentId = ParamUtil.getString(req, "departmentId", "-1"); // Default -1 (Danh sach nhung cong van da tiep nhan)
		
		// Danh sach so cong van
		List<PmlEdmDocumentRecordTo> pmlEdmDocumentRecordToList = PmlEdmDocumentRecordToUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = new ArrayList<PmlEdmBookDocumentRecordTo>();
		
		for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : pmlEdmDocumentRecordToList) {
			pmlEdmBookDocumentRecordToList.addAll(PmlEdmBookDocumentRecordToUtil.findByDocumentRecordToId(pmlEdmDocumentRecordTo.getDocumentRecordToId()));
		}
		
		// Lay filter
		String daTaoChuaTao = ParamUtil.getString(req, "daTaoChuaTao", "tatca");
		String tinhTrangCongVan = ParamUtil.getString(req, "tinhTrangCongVan", "tatca");
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId", "tatca");
		String documentRecordTypeId = ParamUtil.getString(req, "documentRecordTypeId", "tatca");
		
		// Set attribute
		req.setAttribute("attDaTaoChuaTao", daTaoChuaTao);
		req.setAttribute("attTinhTrangCongVan", tinhTrangCongVan);
		req.setAttribute("attConfidentialLevelId", confidentialLevelId);
		req.setAttribute("attDocumentRecordTypeId", documentRecordTypeId);
		req.setAttribute("attDepartmentId", pmlDepartmentId);
		
		// filter
		pmlEdmBookDocumentRecordToList = filter(pmlEdmBookDocumentRecordToList, 
												daTaoChuaTao, tinhTrangCongVan, confidentialLevelId, documentRecordTypeId);
		
		// Lay filter
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDen = ParamUtil.getString(req, "soCVDen", "");
		String ngayDen = ParamUtil.getString(req, "ngayDen", "");
		String ngayHetHan = ParamUtil.getString(req, "ngayHetHan", "");
		String noiBanHanh = ParamUtil.getString(req, "noiBanHanh", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		// Set attribute
		req.setAttribute("attSTT", stt);
		req.setAttribute("attSoCVNoiBo", soCVNoiBo);
		req.setAttribute("attSoCVDen", soCVDen);
		req.setAttribute("attNgayDen", ngayDen);
		req.setAttribute("attNgayHetHan", ngayHetHan);
		req.setAttribute("attNoiBanHanh", noiBanHanh);
		req.setAttribute("attTrichYeu", trichYeu);
		req.setAttribute("attLoaiCV", loaiCV);
		req.setAttribute("attDoUuTien", doUuTien);
		
		// filter
		pmlEdmBookDocumentRecordToList = filter(pmlEdmBookDocumentRecordToList, stt, soCVNoiBo, soCVDen, 
										ngayDen, ngayHetHan, noiBanHanh, trichYeu, loaiCV, doUuTien);
		
		int index = 1;
		for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : pmlEdmBookDocumentRecordToList) {
			
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlEdmBookDocumentRecordTo.getDocumentReceiptId());
			
			soCVNoiBo = pmlEdmDocumentReceipt.getNumberLocalDocumentReceipt();
			soCVDen = pmlEdmDocumentReceipt.getNumberDocumentReceipt();
			ngayDen = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive());
			ngayHetHan = new SimpleDateFormat("dd/MM/yyyy").format(getExpirationDate(pmlEdmDocumentReceipt.getDateArrive(), pmlEdmDocumentReceipt.getProcessTime()));
			noiBanHanh = "";
			String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
			if(issuingPlaceId.equals("")) {
				noiBanHanh = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
			} else {
				noiBanHanh = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId()).getIssuingPlaceName();
			}
			trichYeu = pmlEdmDocumentReceipt.getBriefContent();
			loaiCV = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId()).getDocumentTypeName();
			doUuTien = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getPrivilegeLevelId()).getPrivilegeLevelName();
			String trinhTuXuLy = "";
			
			DocumentRecordToDTO documentRecordToDTO = new DocumentRecordToDTO();
			documentRecordToDTO.setStt(index ++);
			documentRecordToDTO.setSoCVNoiBo(soCVNoiBo);
			documentRecordToDTO.setSoCVDen(soCVDen);
			documentRecordToDTO.setNgayDen(ngayDen);
			documentRecordToDTO.setNgayHetHan(ngayHetHan);
			documentRecordToDTO.setNoiBanHanh(noiBanHanh);
			documentRecordToDTO.setTrichYeu(trichYeu);
			documentRecordToDTO.setLoaiCV(loaiCV);
			documentRecordToDTO.setDoUuTien(doUuTien);
			documentRecordToDTO.setTrinhTuXuLy(trinhTuXuLy);
			
			documentRecordToList.add(documentRecordToDTO);
		}
		
		return documentRecordToList;
	}
	
	private List<PmlEdmBookDocumentRecordTo> filter(List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList, 
													String daTaoChuaTao, String tinhTrangCongVan, 
													String confidentialLevelId, String documentRecordTypeId) throws Exception {
		List<PmlEdmBookDocumentRecordTo> res = new ArrayList<PmlEdmBookDocumentRecordTo>();
		
		for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : pmlEdmBookDocumentRecordToList) {
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
			try {
				 pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlEdmBookDocumentRecordTo.getDocumentReceiptId());	
			} catch (Exception e) {
			}
			
			
			res.add(pmlEdmBookDocumentRecordTo);
			
			int index = res.size() - 1;
			
			if (!daTaoChuaTao.equals("tatca")) {
				
			}
			if (!tinhTrangCongVan.equals("tatca")) {
							
			}
			if (!confidentialLevelId.equals("tatca")) {
				if (!confidentialLevelId.equals(pmlEdmDocumentReceipt.getConfidentialLevelId())) {
					res.remove(index);
					continue;
				}
			}
			if (!documentRecordTypeId.equals("tatca")) {
				String temp = PmlEdmDocumentRecordToUtil.findByPrimaryKey(pmlEdmBookDocumentRecordTo.getDocumentRecordToId()).getDocumentRecordTypeId() + "";
				if (!documentRecordTypeId.equals(temp)) {
					res.remove(index);
					continue;
				}
			}
		}
		return res;
	}
	
	private List<PmlEdmBookDocumentRecordTo> filter(List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList, 
														String stt, String soCVNoiBo, String soCVDen, 
														String ngayDen, String ngayHetHan, String noiBanHanh,
														String trichYeu, String loaiCV, String doUuTien) throws Exception {

		List<PmlEdmBookDocumentRecordTo> res = new ArrayList<PmlEdmBookDocumentRecordTo>();
	
		for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : pmlEdmBookDocumentRecordToList) {
			
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlEdmBookDocumentRecordTo.getDocumentReceiptId());
			
			res.add(pmlEdmBookDocumentRecordTo);
			
			int index = res.size() - 1;
			
			if (!soCVNoiBo.equals("")) {
				if (findString(soCVNoiBo, pmlEdmDocumentReceipt.getNumberLocalDocumentReceipt()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!soCVDen.equals("")) {
				if (findString(soCVDen, pmlEdmDocumentReceipt.getNumberDocumentReceipt()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!ngayDen.equals("")) {
				if (findString(ngayDen, new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive())) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!ngayHetHan.equals("")) {
				if (findString(ngayHetHan, new SimpleDateFormat("dd/MM/yyyy").format(getExpirationDate(pmlEdmDocumentReceipt.getDateArrive(), pmlEdmDocumentReceipt.getProcessTime()))) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!noiBanHanh.equals("")) {
				String temp = "";
				String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
				if(issuingPlaceId.equals("")) {
					temp = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
				} else {
					temp = PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId()).getIssuingPlaceName();
				}
				if (findString(noiBanHanh, temp) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!trichYeu.equals("")) {
				if (findString(trichYeu, pmlEdmDocumentReceipt.getBriefContent()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!loaiCV.equals("tatca")) {
				String temp = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId()).getDocumentTypeId() + "";
				if (findString(loaiCV, temp) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!doUuTien.equals("tatca")) {
				String temp = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getPrivilegeLevelId()).getPrivilegeLevelId();
				if (findString(doUuTien, temp) == false) {
					res.remove(index);
					continue;
				}
			}
		}
		return res;
	}
	
	private boolean findString(String strFind, String strSrc) throws Exception {
		
		int lenSrc = strSrc.length();
		int lenFind = strFind.length();
		if (lenSrc < lenFind) { // chuoi can tim co do dai lon hon chuoi nguon
			return false;
		}
		int i;
		for (i = 0; i < lenSrc; i ++) {
			int posFind = 0;
			if(strSrc.charAt(i) == strFind.charAt(posFind)) {
				int len = i + lenFind;
				if(len <= lenSrc) {
					for (int j = i; j < len; j ++) {
						if(strSrc.charAt(j) != strFind.charAt(posFind ++)) {
							return false;
						}
					}
					return true;
				} else {
					return false;
				}
			}
		}
		return false; 
	}
	
	private Date getExpirationDate(Date dateProcess, int numDateProcess) {
		
		Date retValue = dateProcess;
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		if (numDateProcess == 0) {
			return retValue;
		}
		
		Date dateProcessCompare = convertDateFormat(dateProcess, DATE_FORMAT);
		String strDate = sdf.format(dateProcessCompare);
		int numDate = PmlHolidayLocalServiceUtil.checkDateHoliday(strDate, numDateProcess);
		int totalDate = numDate + numDateProcess;
		Calendar cal = Calendar.getInstance();
		cal.setTime(retValue);
		cal.add(Calendar.DAY_OF_YEAR, totalDate);
		retValue = cal.getTime();

		return retValue;
	}
	
	yenlt close end 04062010 */
}
