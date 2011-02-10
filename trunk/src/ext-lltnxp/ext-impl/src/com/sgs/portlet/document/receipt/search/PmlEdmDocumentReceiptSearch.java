/**
 * 
 */
package com.sgs.portlet.document.receipt.search;

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
import com.liferay.portal.model.User;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptUtil;

/**
 * @author DienNH
 *
 */
public class PmlEdmDocumentReceiptSearch extends SearchContainer<User> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("documentreceipt-search-stt");
		//xuancong close, dua ve ben phai headerNames.add("edit");//thoi add
		headerNames.add("pccc-cvdtn-sohieu");
		headerNames.add("pccc-cvdtn-soCVden");
		headerNames.add("documentreceipt-search-loaicv");
		headerNames.add("documentreceipt-search-noiphathanh");
		//xuancong close headerNames.add("documentreceipt-search-ngayden")
		headerNames.add("documentreceipt-search-ngayphathanh");
		headerNames.add("documentreceipt-search-trichyeu");
		headerNames.add("documentreceipt-search-nguoiky");
		headerNames.add("documentreceipt-search-toanvan");
		headerNames.add("edit"); // Dua cot sua ve ben phai
		headerNames.add("delete"); // Them cot xoa
		
		orderableHeaders.put("pccc-cvdtn-sohieu", "socvden");
		orderableHeaders.put("pccc-cvdtn-soCVden", "sovaoso");
		//xuancong close orderableHeaders.put("documentreceipt-search-ngayden", "ngayden");
		orderableHeaders.put("documentreceipt-search-trichyeu", "trichyeu");
		orderableHeaders.put("documentreceipt-search-nguoiky", "nguoiky");
	}
	
	// Hien message thong bao khi khong co Customer nao
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";
	
	/**
	 * 
	 * @param req
	 * @param iteratorURL
	 */
	public PmlEdmDocumentReceiptSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
				req,
				new PmlEdmDocumentReceiptDisplayTerms(req),
				new PmlEdmDocumentReceiptSearchTerms(req),
				DEFAULT_CUR_PARAM,
				DEFAULT_DELTA,
				iteratorURL,
				headerNames,
				EMPTY_RESULTS_MESSAGE
		);
		
		PmlEdmDocumentReceiptDisplayTerms displayTerms = (PmlEdmDocumentReceiptDisplayTerms) getDisplayTerms();
		//PmlEdmDocumentReceiptSearchTerms searchTerms = (PmlEdmDocumentReceiptSearchTerms) getSearchTerms();
		
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN, displayTerms.getSoCVDen());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO, displayTerms.getSoVaoSo());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.TU_NGAY, displayTerms.getTuNgay());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.DEN_NGAY, displayTerms.getDenNgay());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.SO_HSCV, String.valueOf(displayTerms.getSoHSCV()));
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.LOAI_CV, String.valueOf(displayTerms.getLoaiCV()));
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.NOI_PHAT_HANH, displayTerms.getNoiPhatHanh());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.TRANG_THAI, String.valueOf(displayTerms.getTrangThai()));
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY, displayTerms.getNguoiKy());
		iteratorURL.setParameter(PmlEdmDocumentReceiptDisplayTerms.TRICH_YEU, displayTerms.getTrichYeu());
		
		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(req);
			
			String orderByCol = ParamUtil.getString(req, "orderByCol");
			String orderByType = ParamUtil.getString(req, "orderByType");
			
			String portletName = "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj";
			
			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
				preferences.setValue(portletName, "customer-order-by-col", orderByCol);
				preferences.setValue(portletName, "customer-order-by-type", orderByType);
			}
			else {
				/* xuancong close start
				preferences.setValue(portletName, "customer-order-by-col", "socvden");
				preferences.setValue(portletName, "customer-order-by-type", "asc");
				xuancong close end */
				orderByCol = preferences.getValue(portletName, "customer-order-by-col", "sovaoso");
				orderByType = preferences.getValue(portletName, "customer-order-by-type", "desc");
			}
			
			OrderByComparator orderByComparator = PmlEdmDocumentReceiptUtil.getDocumentReceiptOrderByComparator(orderByCol, orderByType);
			
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlEdmDocumentReceipt.class);
	
}
