package com.sgs.portlet.pcccdocumentsendreport_so.action;

import java.io.InputStream;
import java.util.ArrayList;
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
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendUtil;
import net.sourceforge.rtf.StringUtils;
import com.sgs.portlet.pcccdocumentsendreport.dto.DocumentSendDTO;
import com.sgs.portlet.pcccdocumentsendreport.util.DocumentSendUtil;

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
				
				req.setAttribute("documentSendList", getDocumentSendList(req));
				
				return mapping.findForward("portlet.sgs.pcccdocumentsendreport_so.view");
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
	
	private List<DocumentSendDTO> getDocumentSendList(RenderRequest req) throws Exception {
		
		List<DocumentSendDTO> documentSendList = new ArrayList<DocumentSendDTO>();
		
		// Default -1 (Danh sach nhung cong van da tiep nhan)
		String pmlDepartmentId = "-1";
		// Danh sach so cong van
		List<PmlEdmBookDocumentSend> pmlEdmBookDocumentSendList = PmlEdmBookDocumentSendUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList = new ArrayList<PmlEdmWriteDocumentSend>();
		
		for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : pmlEdmBookDocumentSendList) {
			pmlEdmWriteDocumentSendList.addAll(PmlEdmWriteDocumentSendUtil.findByBookDocumentSendId(pmlEdmBookDocumentSend.getBookDocumentSendId()));
		}
		
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDi = ParamUtil.getString(req, "soCVDi", "");
		String noiNhan = ParamUtil.getString(req, "noiNhan", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		req.setAttribute("attSTT", stt);
		req.setAttribute("attSoCVNoiBo", soCVNoiBo);
		req.setAttribute("attSoCVDi", soCVDi);
		req.setAttribute("attNoiNhan", noiNhan);
		req.setAttribute("attNguoiKy", nguoiKy);
		req.setAttribute("attTrichYeu", trichYeu);
		req.setAttribute("attLoaiCV", loaiCV);
		req.setAttribute("attDoUuTien", doUuTien);
		
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
	
	private List<DocumentSendDTO> getDocumentSendListReport(ActionRequest req) throws Exception {
		
		List<DocumentSendDTO> documentSendList = new ArrayList<DocumentSendDTO>();
		
		// Default -1 (Danh sach nhung cong van da tiep nhan)
		String pmlDepartmentId = "-1";
		// Danh sach so cong van
		List<PmlEdmBookDocumentSend> pmlEdmBookDocumentSendList = PmlEdmBookDocumentSendUtil.findByDepartmentsId(pmlDepartmentId);
		// Danh sach vao so cong van
		List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList = new ArrayList<PmlEdmWriteDocumentSend>();
		
		for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : pmlEdmBookDocumentSendList) {
			pmlEdmWriteDocumentSendList.addAll(PmlEdmWriteDocumentSendUtil.findByBookDocumentSendId(pmlEdmBookDocumentSend.getBookDocumentSendId()));
		}
		
		String stt = ParamUtil.getString(req, "stt", "");
		String soCVNoiBo = ParamUtil.getString(req, "soCVNoiBo", "");
		String soCVDi = ParamUtil.getString(req, "soCVDi", "");
		String noiNhan = ParamUtil.getString(req, "noiNhan", "");
		String nguoiKy = ParamUtil.getString(req, "nguoiKy", "");
		String trichYeu = ParamUtil.getString(req, "trichYeu", "");
		String loaiCV = ParamUtil.getString(req, "loaiCV", "tatca");
		String doUuTien = ParamUtil.getString(req, "doUuTien", "tatca");
		
		req.setAttribute("attSTT", stt);
		req.setAttribute("attSoCVNoiBo", soCVNoiBo);
		req.setAttribute("attSoCVDi", soCVDi);
		req.setAttribute("attNoiNhan", noiNhan);
		req.setAttribute("attNguoiKy", nguoiKy);
		req.setAttribute("attTrichYeu", trichYeu);
		req.setAttribute("attLoaiCV", loaiCV);
		req.setAttribute("attDoUuTien", doUuTien);
		
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
			documentSendDTO.setStt(StringUtils.convertToRTF(stt));
			documentSendDTO.setSoCVNoiBo(StringUtils.convertToRTF(soCVNoiBo));
			documentSendDTO.setSoCVDi(StringUtils.convertToRTF(soCVDi));
			documentSendDTO.setNoiNhan(StringUtils.convertToRTF(noiNhan));
			documentSendDTO.setNguoiKy(StringUtils.convertToRTF(nguoiKy));
			documentSendDTO.setTrichYeu(StringUtils.convertToRTF(trichYeu));
			documentSendDTO.setLoaiCV(StringUtils.convertToRTF(loaiCV));
			documentSendDTO.setDoUuTien(StringUtils.convertToRTF(doUuTien));
			documentSendDTO.setTrinhTuXuLy(StringUtils.convertToRTF(trinhTuXuLy));
			
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
	
	private void inBaoCao(ActionRequest req, ActionResponse res) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		DocumentSendUtil rtfUtil = new DocumentSendUtil(request.getSession().getServletContext().getRealPath("reports"),
				getDocumentSendListReport(req));
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/SoCongVanDiVanPhongSo.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	private void xuatExcel(PortletRequest req, PortletResponse res) throws Exception {
		
		
	}
	
}
