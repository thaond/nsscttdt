package com.sgs.portlet.deleteprocessinstance.search;

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
import com.sgs.portlet.deleteprocessinstance.util.DocumentSendUnpublishUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class DeleteDocumentSendUnpublishSearch extends SearchContainer<PmlEdmDocumentSend>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("no.");
		headerNames.add("loai-cong-van");
		headerNames.add("receipt.detail");
		headerNames.add("nguoi-ky"); 
		headerNames.add("phong-soan-thao");
		headerNames.add("trich-yeu");
		headerNames.add("noi-nhan-cong-van");
		headerNames.add("delete"); 

		orderableHeaders.put("nguoi-ky", "nguoiKy");
		orderableHeaders.put("loai-cong-van", "loaiVB");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentsend-search-khongtontaidulieu";
	
	public DeleteDocumentSendUnpublishSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new DeleteDocumentSendUnpublishDisplayTerms(renderRequest),
				new DeleteDocumentSendUnpublishSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DeleteDocumentSendUnpublishDisplayTerms displayTerms = (DeleteDocumentSendUnpublishDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(DeleteDocumentSendUnpublishDisplayTerms.LOAIVB, String.valueOf(displayTerms.getLoaiVB()));
		iteratorURL.setParameter(DeleteDocumentSendUnpublishDisplayTerms.NGUOIKY, displayTerms.getNguoiKy());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_DELETEPROCESSINSTANCE";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "deleteProcessId-order-by-col", orderByCol);
				preferences.setValue(portletName, "deleteProcessId-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "deleteProcessId-order-by-col", "tenLanhDao");
				orderByType = preferences.getValue(portletName, "deleteProcessId-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = DocumentSendUnpublishUtil.getDocumentSendOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(DeleteDocumentSendUnpublishSearch.class);
	
}
