package com.sgs.portlet.onedoorpcccreport.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoSoCongVanDenDTO;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
		long userId = PortalUtil.getUserId(req);
		xuatFileBaoCaoSoCongVanDen(req, res, userId);
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.onedoorpcccreport.view");
			}
	}

	private List<BaoCaoSoCongVanDenDTO> getBaoCaoSoCongVanDen(long userId) throws Exception {
		
		List<BaoCaoSoCongVanDenDTO> baoCaoSoCongVanDenList = new ArrayList<BaoCaoSoCongVanDenDTO>();
		
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = new ArrayList<PmlEdmDocumentReceipt>();
		
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByProcesser(userId);
		int pmlDocumentReceiptLogSize = PmlDocumentReceiptLogUtil.findByProcesser(userId).size();
		for(int index = 0; index < pmlDocumentReceiptLogSize; index ++) {
			pmlEdmDocumentReceiptList.add(PmlEdmDocumentReceiptUtil.findByPrimaryKey(pmlDocumentReceiptLogList.get(index).getDocumentReceiptId()));
		}
		int pmlEdmDocumentReceiptSize = pmlEdmDocumentReceiptList.size();
		
		for(int index = 0; index < pmlEdmDocumentReceiptSize; index ++) {
		
			PmlEdmDocumentReceipt pmlEdmDocumentReceipt = pmlEdmDocumentReceiptList.get(index);
			
			int stt = index + 1;
			String soCongVanNoiBo = getSoCongVanNoiBo(pmlEdmDocumentReceipt);
			String soCongVanDen = getSoCongVanDen(pmlEdmDocumentReceipt);
			String noiBanHanh = getNoiBanHanh(pmlEdmDocumentReceipt);
			String nguoiKy = getNguoiKy(pmlEdmDocumentReceipt);
			String trichYeu = getTrichYeu(pmlEdmDocumentReceipt);
			String loaiCongVan = getLoaiCongVan(pmlEdmDocumentReceipt);
			String doUuTien = getDoUuTien(pmlEdmDocumentReceipt);
			
			BaoCaoSoCongVanDenDTO baoCaoSoCongVanDenDTO = new BaoCaoSoCongVanDenDTO();
			baoCaoSoCongVanDenDTO.setStt(stt);
			baoCaoSoCongVanDenDTO.setSoCongVanNoiBo(StringUtils.convertToRTF(soCongVanNoiBo));
			baoCaoSoCongVanDenDTO.setSoCongVanDen(StringUtils.convertToRTF(soCongVanDen));
			baoCaoSoCongVanDenDTO.setNoiBanHanh(StringUtils.convertToRTF(noiBanHanh));
			baoCaoSoCongVanDenDTO.setNguoiKy(StringUtils.convertToRTF(nguoiKy));
			baoCaoSoCongVanDenDTO.setTrichYeu(StringUtils.convertToRTF(trichYeu));
			baoCaoSoCongVanDenDTO.setLoaiCongVan(StringUtils.convertToRTF(loaiCongVan));
			baoCaoSoCongVanDenDTO.setDoUuTien(StringUtils.convertToRTF(doUuTien));
			
			baoCaoSoCongVanDenList.add(baoCaoSoCongVanDenDTO);
		}
		return baoCaoSoCongVanDenList;
	}
	
	private String getSoCongVanNoiBo(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return pmlEdmDocumentReceipt.getNumberLocalDocumentReceipt();
	}
	
	private String getSoCongVanDen(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return pmlEdmDocumentReceipt.getNumberDocumentReceipt();
	}

	private String getNoiBanHanh(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getIssuingPlaceId()).getIssuingPlaceName();
	}
	
	private String getNguoiKy(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return pmlEdmDocumentReceipt.getSigner();
	}
	
	private String getTrichYeu(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return pmlEdmDocumentReceipt.getBriefContent();
	}
	
	private String getLoaiCongVan(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId()).getDocumentTypeName();
	}
	
	private String getDoUuTien(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws Exception {
		
		return PmlEdmPrivilegeLevelUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getPrivilegeLevelId()).getPrivilegeLevelName();
	}
	
	private void xuatFileBaoCaoSoCongVanDen(PortletRequest req, PortletResponse res, long userId) throws Exception {
		
			
	}
	
	private String getFullName(PortletRequest req, long userId) throws Exception {
		
		String fullname = UserUtil.findByPrimaryKey(userId).getGreeting();
		fullname = fullname.replace("Welcome ", "");
		fullname = fullname.replace("!", "");
		return fullname;
	}
	
}
