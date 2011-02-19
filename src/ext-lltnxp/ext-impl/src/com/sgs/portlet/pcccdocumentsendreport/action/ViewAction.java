package com.sgs.portlet.pcccdocumentsendreport.action;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.pcccdocumentsendreport.dto.DocumentSendDTO;
import com.sgs.portlet.pcccdocumentsendreport.search.DocSendReportDisplayTerms;
import com.sgs.portlet.pcccdocumentsendreport.util.DocumentSendUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

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
				
				String soPH = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.SOPH, true);
				int ngayPHMonth = ParamUtil.getInteger(request, DocSendReportDisplayTerms.NGAYPHMONTH, 0);
				int ngayPHYear = ParamUtil.getInteger(request, DocSendReportDisplayTerms.NGAYPHYEAR, 0);
				String phongST = ParamUtil.getString(request, DocSendReportDisplayTerms.PHONGST);
				String noiNhan = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.NOINHAN, true);
				long loaiVB = ParamUtil.getLong(request, DocSendReportDisplayTerms.LOAIVB, 0);
				String tenNguoiKy = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.NGUOIKY, true);
				long nguoiST = ParamUtil.getLong(request, DocSendReportDisplayTerms.NGUOIST, 0);
				String thongTinTrichYeu = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.TRICHYEU, true);
				String vanBanPH = ParamUtil.getString(request, DocSendReportDisplayTerms.VANBANPH);
				
				String orderByCol = ParamUtil.getString(request, "orderByCol", "");
				String orderByType = ParamUtil.getString(request, "orderByType", "");
				OrderByComparator obc = DocumentSendUtil.getDocSendReportOrderByComparator(orderByCol, orderByType);
				
				if (cmd.equals("report")) { // Report
					xuatExcel(request, response, reportType, soPH, ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB,
							tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, obc);
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
				
				String soPH = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.SOPH, true);
				int ngayPHMonth = ParamUtil.getInteger(request, DocSendReportDisplayTerms.NGAYPHMONTH, 0);
				int ngayPHYear = ParamUtil.getInteger(request, DocSendReportDisplayTerms.NGAYPHYEAR, 0);
				String phongST = ParamUtil.getString(request, DocSendReportDisplayTerms.PHONGST);
				String noiNhan = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.NOINHAN, true);
				long loaiVB = ParamUtil.getLong(request, DocSendReportDisplayTerms.LOAIVB, 0);
				String tenNguoiKy = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.NGUOIKY, true);
				long nguoiST = ParamUtil.getLong(request, DocSendReportDisplayTerms.NGUOIST, 0);
				String thongTinTrichYeu = DAOParamUtil.getLike(request, DocSendReportDisplayTerms.TRICHYEU, true);
				String vanBanPH = ParamUtil.getString(request, DocSendReportDisplayTerms.VANBANPH);

				String orderByCol = ParamUtil.getString(request, "orderByCol", "");
				String orderByType = ParamUtil.getString(request, "orderByType", "");
				OrderByComparator obc = DocumentSendUtil.getDocSendReportOrderByComparator(orderByCol, orderByType);
				
				if (reportType.equals("word")) { // Xuat file Word
					inBaoCao(request, response, reportType, soPH, ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB,
							tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, obc);
				} 
				else if (reportType.equals("excel")) { // Xuat file Excel
					req.setAttribute(WebKeys.PORTLET_STRUTS_EXECUTE, true);
					xuatExcel(request, response, reportType, soPH, ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB,
							tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, obc);
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
				return mapping.findForward("portlet.sgs.pcccdocumentsendreport.view");
			}
	}
	
	private List<DocumentSendDTO> getDocumentSendListReport(String reportType, String soPH, int ngayPHMonth, int ngayPHYear, 
					String phongST, String noiNhan, long loaiVB, String tenNguoiKy, long nguoiST, String thongTinTrichYeu, 
					String vanBanPH, OrderByComparator obc) {
		
		List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
		List<DocumentSendDTO> documentSendList = new ArrayList<DocumentSendDTO>();
		
		try {
			pmlEdmDocumentSendList = PmlEdmDocumentSendLocalServiceUtil.findByVBDi_SoVBDiCuaPhong(soPH, ngayPHMonth, ngayPHYear, phongST, 
													noiNhan, loaiVB, tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, -1, -1, obc);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		int index = 1;
		String stt = "";
		String soKyHieu = "";
		String ngayPhatHanh = "";
		String trichYeu = "";
		String nguoiKy = "";
		String noiNhanVB = "";
		String nguoiNhanBanLuu = "";
		String soBan = "";
		
		PmlEdmDocumentSend pmlEdmDocumentSend = null;
		PmlUser editor = null;
		Department department = null;
		
		if (pmlEdmDocumentSendList.size() > 0) {
			for (PmlEdmDocumentSend documentSend : pmlEdmDocumentSendList) {
				
				try {
					pmlEdmDocumentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSend.getDocumentSendId());
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
				
				stt = (index ++) + ".";
				soKyHieu = pmlEdmDocumentSend.getDocumentReference();

				if (pmlEdmDocumentSend.getIssuingDate() != null) {
					ngayPhatHanh = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentSend.getIssuingDate());
				}
				
				trichYeu = pmlEdmDocumentSend.getBriefContent();
				
				nguoiKy = pmlEdmDocumentSend.getSignerName();
				
				noiNhanVB = pmlEdmDocumentSend.getReceivingPlace();
				
				// nguoi nhan ban luu (nguoi soan vb di)
				long editorId = pmlEdmDocumentSend.getEditorId();
				try {
					nguoiNhanBanLuu = PmlUserLocalServiceUtil.getFullName(editorId);
				} catch (Exception e) { }
				try {
					editor = PmlUserLocalServiceUtil.getPmlUser(editorId);
					department = DepartmentLocalServiceUtil.getDepartment(editor.getDepartmentsId());
					nguoiNhanBanLuu += " (" + department.getDepartmentsName() + ")";
				}  catch (Exception e) { }
				
				soBan = pmlEdmDocumentSend.getNumberPublish();
				
				DocumentSendDTO documentSendDTO = new DocumentSendDTO();
				
				documentSendDTO.setStt(stt);
				documentSendDTO.setNgayPhatHanh(ngayPhatHanh);
				if ("word".equals(reportType)) {
					documentSendDTO.setSoKyHieu(StringUtils.convertToRTF(soKyHieu));
					documentSendDTO.setTrichYeu(StringUtils.convertToRTF(trichYeu));
					documentSendDTO.setNguoiKy(StringUtils.convertToRTF(nguoiKy));
					documentSendDTO.setNoiNhan(StringUtils.convertToRTF(noiNhanVB));
					documentSendDTO.setNguoiNhanBanLuu(StringUtils.convertToRTF(nguoiNhanBanLuu));
					documentSendDTO.setSoBan(StringUtils.convertToRTF(soBan));
				}
				else if ("excel".equals(reportType)) {
					documentSendDTO.setSoKyHieu(soKyHieu);
					documentSendDTO.setTrichYeu(trichYeu);
					documentSendDTO.setNguoiKy(nguoiKy);
					documentSendDTO.setNoiNhan(noiNhanVB);
					documentSendDTO.setNguoiNhanBanLuu(nguoiNhanBanLuu);
					documentSendDTO.setSoBan(soBan);
				}
				documentSendList.add(documentSendDTO);
			}
		}
		else  {
			DocumentSendDTO documentSendDTO = new DocumentSendDTO();
			documentSendDTO.setSoKyHieu(soKyHieu);
			documentSendDTO.setTrichYeu(trichYeu);
			documentSendDTO.setNguoiKy(nguoiKy);
			documentSendDTO.setNoiNhan(noiNhanVB);
			documentSendDTO.setNguoiNhanBanLuu(nguoiNhanBanLuu);
			documentSendDTO.setSoBan(soBan);
			
			documentSendList.add(documentSendDTO);
		}
		
		return documentSendList;
	}
	
	
	private int countDocumentSendListReport(String reportType, String soPH, int ngayPHMonth, int ngayPHYear, 
			String phongST, String noiNhan, long loaiVB, String tenNguoiKy, long nguoiST, String thongTinTrichYeu, String vanBanPH) {

		int results = 0;
		
		try {
			results = PmlEdmDocumentSendLocalServiceUtil.countByVBDi_SoVBDiCuaPhong(soPH, ngayPHMonth, ngayPHYear, phongST, 
													noiNhan, loaiVB, tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		return results;
	}
	
	
	private void inBaoCao( HttpServletRequest request, HttpServletResponse response, String reportType, String soPH, int ngayPHMonth,
							int ngayPHYear,String phongST, String noiNhan, long loaiVB, String tenNguoiKy, long nguoiST, 
							String thongTinTrichYeu, String vanBanPH, OrderByComparator obc) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("reports");
		
		List<DocumentSendDTO> list = getDocumentSendListReport(reportType, soPH, ngayPHMonth, ngayPHYear,
										phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, obc);
		int total = countDocumentSendListReport(reportType, soPH, ngayPHMonth, ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH);
		
		DocumentSendUtil rtfUtil = new DocumentSendUtil(path, list, total);
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/SoCongVanDiCuaPhong.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	@SuppressWarnings("unchecked")
	private void xuatExcel(HttpServletRequest request, HttpServletResponse response, String reportType, String soPH, int ngayPHMonth,
								int ngayPHYear, String phongST, String noiNhan, long loaiVB, String tenNguoiKy, long nguoiST,
								String thongTinTrichYeu, String vanBanPH, OrderByComparator obc) throws Exception {
		
		ServletContext context = request.getSession().getServletContext();
		JRExporter exporter = null;
		
		JasperDesign subDesign1 = JRXmlLoader.load(context.getRealPath("reports/SoCongVanDiCuaPhong_subreport.jrxml"));
		JasperReport subJasperReport1 = JasperCompileManager.compileReport(subDesign1);
		
		Map subMap1 = new HashMap();
		
		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(getDocumentSendListReport(reportType, soPH, ngayPHMonth,
					ngayPHYear, phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, thongTinTrichYeu, vanBanPH, obc));
		
		JasperCompileManager.compileReportToFile(context.getRealPath("reports/SoCongVanDiCuaPhong.jrxml"), 
				context.getRealPath("reports/SoCongVanDiCuaPhong.jasper"));

		Map map = new HashMap();
		map.put("dataSource1", dataSource1);
		map.put("subReport1", subJasperReport1);
		map.put("subMap1", subMap1);
		
		JREmptyDataSource dataSource = new JREmptyDataSource();
		
		JasperFillManager.fillReportToFile(context.getRealPath("reports/SoCongVanDiCuaPhong.jasper"),
											context.getRealPath("reports/SoCongVanDiCuaPhong.jrprint"), map, dataSource);
		
		File srcFile = new File(context.getRealPath("reports/SoCongVanDiCuaPhong.jrprint"));
		File desFile = null;
		
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
		desFile = File.createTempFile(jasperPrint.getName(), ".xls");
		
		exporter = new JExcelApiExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile.toString());
		exporter.exportReport();
		
		InputStream in = new FileInputStream(desFile);
		ServletResponseUtil.sendFile(response, "SoCongVanDiCuaPhong.xls", in, "application/vnd.ms-excel");
	}
	
	/* yenlt close start 04062010
	 * private boolean findString(String strFind, String strSrc) throws Exception {
		
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
	
	private List<DocumentSendDTO> getDocumentSendList(RenderRequest req) throws Exception {
		
		List<DocumentSendDTO> documentSendList = new ArrayList<DocumentSendDTO>();
		
		// Default -1 (Danh sach nhung cong van da tiep nhan)
		String pmlDepartmentId = ParamUtil.getString(req, "departmentId", "-1");
		// Danh sach so cong van
		List<PmlEdmBookDocumentSend> pmlEdmBookDocumentSendList = PmlEdmBookDocumentSendUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList = new ArrayList<PmlEdmWriteDocumentSend>();
		
		for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : pmlEdmBookDocumentSendList) {
			pmlEdmWriteDocumentSendList.addAll(PmlEdmWriteDocumentSendUtil.findByBookDocumentSendId(pmlEdmBookDocumentSend.getBookDocumentSendId()));
		}
		
		// lay filter
		String tinhTrangCongVan = ParamUtil.getString(req, "tinhTrangCongVan", "tatca");
		String phatHanh = ParamUtil.getString(req, "phatHanh", "tatca");
		String xuLy = ParamUtil.getString(req, "xuLy", "tatca");
		String confidentialLevelId = ParamUtil.getString(req, "confidentialLevelId", "tatca");
		String documentRecordTypeId = ParamUtil.getString(req, "documentRecordTypeId", "tatca");
		
		// set attribute
		req.setAttribute("attTinhTrangCongVan", tinhTrangCongVan);
		req.setAttribute("attPhatHanh", phatHanh);
		req.setAttribute("attXuLy", xuLy);
		req.setAttribute("attConfidentialLevelId", confidentialLevelId);
		req.setAttribute("attDocumentRecordTypeId", documentRecordTypeId);
		req.setAttribute("attDepartmentId", pmlDepartmentId);
		
		// filter
		pmlEdmWriteDocumentSendList = filter(pmlEdmWriteDocumentSendList, 
												tinhTrangCongVan, phatHanh, xuLy, confidentialLevelId, documentRecordTypeId, pmlDepartmentId);
		
		// lay filter
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDi = ParamUtil.getString(req, "soCVDi", "");
		String noiNhan = ParamUtil.getString(req, "noiNhan", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		// set attribute
		req.setAttribute("attSTT", stt);
		req.setAttribute("attSoCVNoiBo", soCVNoiBo);
		req.setAttribute("attSoCVDi", soCVDi);
		req.setAttribute("attNoiNhan", noiNhan);
		req.setAttribute("attNguoiKy", nguoiKy);
		req.setAttribute("attTrichYeu", trichYeu);
		req.setAttribute("attLoaiCV", loaiCV);
		req.setAttribute("attDoUuTien", doUuTien);
		
		// filter
		pmlEdmWriteDocumentSendList = filter(pmlEdmWriteDocumentSendList, stt, soCVNoiBo, soCVDi, 
													noiNhan, nguoiKy, trichYeu, loaiCV, doUuTien);
		
		int index = 1;
		for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : pmlEdmWriteDocumentSendList) {
			
			PmlEdmDocumentSend pmlEdmDocumentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(pmlEdmWriteDocumentSend.getDocumentSendId());
			
			stt = (index ++) + "";
			soCVNoiBo = "";
			soCVDi = "";
			noiNhan = pmlEdmDocumentSend.getReceivingPlace();
			nguoiKy = pmlEdmDocumentSend.getSignerName();
			trichYeu = pmlEdmDocumentSend.getBriefContent();
			loaiCV = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentSend.getDocumentTypeId()).getDocumentTypeName();
			doUuTien = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(pmlEdmDocumentSend.getPrivilegeLevelId()).getPrivilegeLevelName();
			String trinhTuXuLy = "";
			
			DocumentSendDTO documentSendDTO = new DocumentSendDTO();
			documentSendDTO.setStt(stt);
			documentSendDTO.setSoCVNoiBo(soCVNoiBo);
			documentSendDTO.setSoCVDi(soCVDi);
			documentSendDTO.setNoiNhan(noiNhan);
			documentSendDTO.setNguoiKy(nguoiKy);
			documentSendDTO.setTrichYeu(trichYeu);
			documentSendDTO.setLoaiCV(loaiCV);
			documentSendDTO.setDoUuTien(doUuTien);
			documentSendDTO.setTrinhTuXuLy(trinhTuXuLy);
			
			documentSendList.add(documentSendDTO);
		}
		
		return documentSendList;
	}
	private List<PmlEdmWriteDocumentSend> filter(List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList, 
														String stt, String soCVNoiBo, String soCVDi, 
														String noiNhan, String nguoiKy,
														String trichYeu, String loaiCV, String doUuTien) throws Exception {

		List<PmlEdmWriteDocumentSend> res = new ArrayList<PmlEdmWriteDocumentSend>();
		
		for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : pmlEdmWriteDocumentSendList) {
		
			PmlEdmDocumentSend pmlEdmDocumentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(pmlEdmWriteDocumentSend.getDocumentSendId());
		
			res.add(pmlEdmWriteDocumentSend);
			
			int index = res.size() - 1;
			
			if (!soCVNoiBo.equals("")) {
				if (findString(soCVNoiBo, "") == false) {
					res.remove(index);
					continue;
				}
			}
			if (!soCVDi.equals("")) {
				if (findString(soCVDi, "") == false) {
					res.remove(index);
					continue;
				}
			}
			if (!noiNhan.equals("")) {
				if (findString(noiNhan, pmlEdmDocumentSend.getReceivingPlace()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!nguoiKy.equals("")) {
				if (findString(nguoiKy, pmlEdmDocumentSend.getSignerName()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!trichYeu.equals("")) {
				if (findString(trichYeu, pmlEdmDocumentSend.getBriefContent()) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!loaiCV.equals("tatca")) {
				String temp = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentSend.getDocumentTypeId()).getDocumentTypeId() + "";
				if (findString(loaiCV, temp) == false) {
					res.remove(index);
					continue;
				}
			}
			if (!doUuTien.equals("tatca")) {
				String temp = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(pmlEdmDocumentSend.getPrivilegeLevelId()).getPrivilegeLevelId();
					if (findString(doUuTien, temp) == false) {
					res.remove(index);
					continue;
				}
			}
		}
		return res;
	}
	
	private List<PmlEdmWriteDocumentSend> filter(List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList, 
													String tinhTrangCongVan, String phatHanh, String xuLy, 
													String confidentialLevelId, String documentRecordTypeId, String pmlDepartmentId) throws Exception {
		List<PmlEdmWriteDocumentSend> res = new ArrayList<PmlEdmWriteDocumentSend>();
		
		for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : pmlEdmWriteDocumentSendList) {
			PmlEdmDocumentSend pmlEdmDocumentSend = null;
			try {
			pmlEdmDocumentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(pmlEdmWriteDocumentSend.getDocumentSendId());
		} catch (Exception e) {
		}
			
		
			res.add(pmlEdmWriteDocumentSend);
			
			int index = res.size() - 1;
			
			if (!tinhTrangCongVan.equals("tatca")) {
				
			}
			if (!phatHanh.equals("tatca")) {
				
			}
			if (!xuLy.equals("tatca")) {
				
			}
			if (!confidentialLevelId.equals("tatca")) {
				if (!confidentialLevelId.equals(pmlEdmDocumentSend.getConfidentialLevelId())) {
					res.remove(index);
					continue;
				}
			}
			if (!documentRecordTypeId.equals("tatca")) {
				String temp = PmlEdmDocumentRecordToUtil.findByPrimaryKey(pmlEdmWriteDocumentSend.getBookDocumentSendId()).getDocumentRecordTypeId() + "";
				if (documentRecordTypeId.equals(temp)) {
					res.remove(index);
					continue;
				}
			}
		}
		return res;
	}
	
	yenlt close end 04062010 */

}
