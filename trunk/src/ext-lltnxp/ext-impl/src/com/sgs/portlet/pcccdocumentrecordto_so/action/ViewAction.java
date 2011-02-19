package com.sgs.portlet.pcccdocumentrecordto_so.action;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import net.sourceforge.rtf.StringUtils;
import com.sgs.portlet.pcccdocumentrecordto.dto.DocumentRecordToDTO;
import com.sgs.portlet.pcccdocumentrecordto.util.DocumentRecordToUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		String cmd = ParamUtil.getString(req, "cmd", "");
		if (Validator.isNull(cmd) == false) {
			if (cmd.equals("report")) { // Report
				String reportType = ParamUtil.getString(req, "reportType");
				if (reportType.equals("word")) { // Xuat file Word
					inBaoCao(req, res);
				} else if (reportType.equals("excel")) { // Xuat file Excel
					xuatExcel(req, res);
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
				
				req.setAttribute("documentRecordToList", getDocumentRecordToList(req));
				
				return mapping.findForward("portlet.sgs.pcccdocumentrecordto_so.view");
			}
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
	
	private List<DocumentRecordToDTO> getDocumentRecordToList(RenderRequest req) throws Exception {
		
		List<DocumentRecordToDTO> documentRecordToList = new ArrayList<DocumentRecordToDTO>();
		
		// Default -1 (Danh sach nhung cong van da tiep nhan)
		String pmlDepartmentId = "-1";
		// Danh sach so cong van
		List<PmlEdmDocumentRecordTo> pmlEdmDocumentRecordToList = PmlEdmDocumentRecordToUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = new ArrayList<PmlEdmBookDocumentRecordTo>();
		
		for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : pmlEdmDocumentRecordToList) {
			pmlEdmBookDocumentRecordToList.addAll(PmlEdmBookDocumentRecordToUtil.findByDocumentRecordToId(pmlEdmDocumentRecordTo.getDocumentRecordToId()));
		}
			
		// Lay cac bien form
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDen = ParamUtil.getString(req, "soCVDen", "");
		String ngayDen = ParamUtil.getString(req, "ngayDen", "");
		String ngayHetHan = ParamUtil.getString(req, "ngayHetHan", "");
		String noiBanHanh = ParamUtil.getString(req, "noiBanHanh", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		req.setAttribute("attSTT", stt);
		req.setAttribute("attSoCVNoiBo", soCVNoiBo);
		req.setAttribute("attSoCVDen", soCVDen);
		req.setAttribute("attNgayDen", ngayDen);
		req.setAttribute("attNgayHetHan", ngayHetHan);
		req.setAttribute("attNoiBanHanh", noiBanHanh);
		req.setAttribute("attTrichYeu", trichYeu);
		req.setAttribute("attLoaiCV", loaiCV);
		req.setAttribute("attDoUuTien", doUuTien);
		
		pmlEdmBookDocumentRecordToList = filter(pmlEdmBookDocumentRecordToList, stt, soCVNoiBo, soCVDen, 
										ngayDen, ngayHetHan, noiBanHanh, trichYeu, loaiCV, doUuTien);
		
		// Danh sach cong van thuoc pmlDepartmentId
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
			documentRecordToDTO.setStt(String.valueOf(index ++));
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
	
	private List<DocumentRecordToDTO> getDocumentRecordToListReport(ActionRequest req) throws Exception {
		
		List<DocumentRecordToDTO> documentRecordToList = new ArrayList<DocumentRecordToDTO>();
		
		// Default -1 (Danh sach nhung cong van da tiep nhan)
		String pmlDepartmentId = "-1";
		// Danh sach so cong van
		List<PmlEdmDocumentRecordTo> pmlEdmDocumentRecordToList = PmlEdmDocumentRecordToUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = new ArrayList<PmlEdmBookDocumentRecordTo>();
		
		for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : pmlEdmDocumentRecordToList) {
			pmlEdmBookDocumentRecordToList.addAll(PmlEdmBookDocumentRecordToUtil.findByDocumentRecordToId(pmlEdmDocumentRecordTo.getDocumentRecordToId()));
		}
			
		// Lay cac bien form
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDen = ParamUtil.getString(req, "soCVDen", "");
		String ngayDen = ParamUtil.getString(req, "ngayDen", "");
		String ngayHetHan = ParamUtil.getString(req, "ngayHetHan", "");
		String noiBanHanh = ParamUtil.getString(req, "noiBanHanh", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		pmlEdmBookDocumentRecordToList = filter(pmlEdmBookDocumentRecordToList, stt, soCVNoiBo, soCVDen, 
										ngayDen, ngayHetHan, noiBanHanh, trichYeu, loaiCV, doUuTien);
		
		// Danh sach cong van thuoc pmlDepartmentId
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
			documentRecordToDTO.setStt(String.valueOf(index ++));
			documentRecordToDTO.setSoCVNoiBo(StringUtils.convertToRTF(soCVNoiBo));
			documentRecordToDTO.setSoCVDen(StringUtils.convertToRTF(soCVDen));
			documentRecordToDTO.setNgayDen(ngayDen);
			documentRecordToDTO.setNgayHetHan(ngayHetHan);
			documentRecordToDTO.setNoiBanHanh(StringUtils.convertToRTF(noiBanHanh));
			documentRecordToDTO.setTrichYeu(StringUtils.convertToRTF(trichYeu));
			documentRecordToDTO.setLoaiCV(StringUtils.convertToRTF(loaiCV));
			documentRecordToDTO.setDoUuTien(StringUtils.convertToRTF(doUuTien));
			documentRecordToDTO.setTrinhTuXuLy(StringUtils.convertToRTF(trinhTuXuLy));
			
			documentRecordToList.add(documentRecordToDTO);
		}
		
		return documentRecordToList;
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
	
	private void inBaoCao(ActionRequest req, ActionResponse res) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		DocumentRecordToUtil rtfUtil = new DocumentRecordToUtil(request.getSession().getServletContext().getRealPath("reports"),
				getDocumentRecordToListReport(req));
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/SoCongVanDenVanPhongSo.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	private void xuatExcel(PortletRequest req, PortletResponse res) throws Exception {
		
		
	}
	
}
