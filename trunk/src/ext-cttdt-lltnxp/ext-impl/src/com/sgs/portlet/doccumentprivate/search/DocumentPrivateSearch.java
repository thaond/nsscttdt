package com.sgs.portlet.doccumentprivate.search;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;


import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.doccumentprivate.util.DocumentPrivateUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class DocumentPrivateSearch extends SearchContainer<PmlEdmDocumentReceipt>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String,String>(); 
	
	static {
		headerNames.add("documentreceipt-search-stt");
		headerNames.add("documentreceipt-search-socvden");
		headerNames.add("documentreceipt-search-sovaoso");
		headerNames.add("documentreceipt-search-loaicv");
		headerNames.add("documentreceipt-search-noiphathanh");
		headerNames.add("documentreceipt-search-ngayphathanh");
		headerNames.add("documentreceipt-search-trichyeu");
		headerNames.add("documentreceipt-search-nguoiky");
		headerNames.add("documentreceipt-search-toanvan");
		headerNames.add("edit"); 
		headerNames.add("delete"); 
		orderableHeaders.put("documentreceipt-search-socvden", "documentReference");
		orderableHeaders.put("documentreceipt-search-sovaoso", "numberDocumentReceipt");
		orderableHeaders.put("documentreceipt-search-nguoiky", "signer");
		
	}
	// Hien message thong bao khi khong co data
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";
	
	public DocumentPrivateSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
				req,
				new DocumentPrivateDisplayTearms(req),
				new DocumentPrivateSearchTearms(req),
				DEFAULT_CUR_PARAM,
				DEFAULT_DELTA,
				iteratorURL,
				headerNames,
				EMPTY_RESULTS_MESSAGE
		);
		DocumentPrivateDisplayTearms displayTearms = (DocumentPrivateDisplayTearms) getDisplayTerms();
		iteratorURL.setParameter(DocumentPrivateDisplayTearms.TU_NGAY, displayTearms.getTuNgay());
		iteratorURL.setParameter(DocumentPrivateDisplayTearms.DEN_NGAY, displayTearms.getDenNgay());
		iteratorURL.setParameter(DocumentPrivateDisplayTearms.LIST_USERID, displayTearms.getListUserId());
		
		try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(req);
				String orderByCol = ParamUtil.getString(req,"orderByCol");
				String orderByType = ParamUtil.getString(req,"orderByType");
				
				if (Validator.isNull(orderByCol) && Validator.isNull(orderByType)) {
					preferences.setValue("NSS_DOCUMENTPRIVATE", "documentprivate-order-by-col", orderByCol);
					preferences.setValue("NSS_DOCUMENTPRIVATE", "documentprivate-order-by-type", orderByType);
				} else {
					preferences.setValue("NSS_DOCUMENTPRIVATE", "document-order-by-col", "documentReference");
					preferences.setValue("NSS_DOCUMENTPRIVATE", "document-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = DocumentPrivateUtil.getDocumentPrivateComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

			
		} catch (Exception e) {
		}
	}
	

}								
