package com.sgs.portlet.document.receipt.searchdocumentsend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class PmlEdmDocumentSendSearch extends SearchContainer<PmlEdmDocumentSend> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("no.");
		//xuancong close, chuyen code edit ra ben phai headerNames.add("edit");
		headerNames.add("so-phat-hanh");
		headerNames.add("ngay-phat-hanh");
		headerNames.add("trich-yeu");
		headerNames.add("loai-cong-van");
		headerNames.add("nguoi-ky"); // Dua tu jsp vao java
		headerNames.add("phong-soan-thao");
		headerNames.add("noi-nhan-cong-van");
		headerNames.add("toan-van");
		headerNames.add("edit");
		headerNames.add("delete"); // Them cot xoa
		
		orderableHeaders.put("so-phat-hanh", "so-phat-hanh");
		orderableHeaders.put("ngay-phat-hanh", "ngay-phat-hanh");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public PmlEdmDocumentSendSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(	renderRequest, new PmlEdmDocumentSendDisplayTerms(renderRequest),
				new PmlEdmDocumentSendSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		PmlEdmDocumentSendDisplayTerms displayTerms = (PmlEdmDocumentSendDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH, displayTerms.getSoPhatHanh());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.LOAI_CONG_VAN, String.valueOf(displayTerms.getLoaiCongVan()));
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.TRA_LOI_CONG_VAN_SO, displayTerms.getTraLoiCongVanSo());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.PHONG_SOAN_THAO, displayTerms.getPhongSoanThao());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.NOI_NHAN, displayTerms.getNoiNhan());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.NGUOI_KY, displayTerms.getNguoiKy());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.TU_NGAY, displayTerms.getTuNgay());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.DEN_NGAY, displayTerms.getDenNgay());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.SO_HSCV, String.valueOf(displayTerms.getSoHSCV()));
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.TRICH_YEU, displayTerms.getTrichYeu());
		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.NGUOI_SOAN_THAO, String.valueOf(displayTerms.getNguoiSoanThao()));

		iteratorURL.setParameter(PmlEdmDocumentSendDisplayTerms.NUMOFDIRECTOR, String.valueOf(displayTerms.getNumOfDirector()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PCCCDOCUMENTSENDPROCESS";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "documentworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentworks-order-by-col", "so-phat-hanh");
				orderByType = preferences.getValue(portletName, "documentworks-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PmlEdmDocumentSendUtil.getPmlEdmDocumentSendOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlEdmDocumentSendSearch.class);
}
