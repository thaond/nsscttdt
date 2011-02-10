package com.sgs.portlet.documentrecord.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.documentrecord.util.DocumentRecordToUtil;

public class DocumentRecordSearch extends SearchContainer<PmlEdmDocumentRecordTo>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("documentRecordType_name");
		headerNames.add("so");
		headerNames.add("ngay-tao");
		headerNames.add("nam");
		headerNames.add("so-hien-tai");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("documentRecordType_name", "loaiSoCV");
		orderableHeaders.put("so", "agency");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public DocumentRecordSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new DocumentRecordDisplayTerms(renderRequest), new DocumentRecordSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			DocumentRecordDisplayTerms displayTerms = (DocumentRecordDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(DocumentRecordDisplayTerms.LOAI_SO_CV, displayTerms.getLoaiSoCV());
			iteratorURL.setParameter(DocumentRecordDisplayTerms.SO_PB, displayTerms.getSoPB());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENTRECORD";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "documentrecord-order-by-col", orderByCol);
					preferences.setValue(portletName, "documentrecord-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "documentrecord-order-by-col", "pml_agency.agencyname");
					orderByType = preferences.getValue(portletName, "documentrecord-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = DocumentRecordToUtil.getDocumentRecordToOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(DocumentRecordSearch.class);
}