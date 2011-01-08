package com.sgs.portlet.pcccdocumentrecordto.search;

import com.ext.portal.util.PortletKeysExt;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.pcccdocumentrecordto.util.DocumentRecordToUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author XUANCONG
 *
 */
public class DocumentRecordToSearch extends SearchContainer<PmlEdmDocumentReceipt> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("pcccdocumentrecordto-stt");
		headerNames.add("pccc-cvdtn-soCVden");
		headerNames.add("pccc-cvdtn-sohieu");
		headerNames.add("pcccdocumentrecordto-loaicv");
		headerNames.add("pcccdocumentrecordto-ngayden");
		headerNames.add("documentreceipt-search-ngayphathanh");
		headerNames.add("pcccdocumentrecordto-noibanhanh");
		headerNames.add("pcccdocumentrecordto-trichyeu");

		// Order by
		orderableHeaders.put("pcccdocumentrecordto-socvnoibo", "sovanbannoibo");
		orderableHeaders.put("pcccdocumentrecordto-ngayden", "ngayden");
		orderableHeaders.put("documentreceipt-search-ngayphathanh", "ngayphathanh");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"documentreceipt-search-khongtontaidulieu";

	public DocumentRecordToSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(
			renderRequest, new DocumentRecordToDisplayTerms(renderRequest),
			new DocumentRecordToSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		DocumentRecordToDisplayTerms displayTerms =
			(DocumentRecordToDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.SONOIBO, displayTerms.getSoNoiBo());
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.SOHIEUGOC, displayTerms.getSoHieuGoc());
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYPHDAY, String.valueOf(displayTerms.getNgayPHDay()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYPHMONTH, String.valueOf(displayTerms.getNgayPHMonth()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYPHYEAR, String.valueOf(displayTerms.getNgayPHYear()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.CAPGUI, String.valueOf(displayTerms.getCapGui()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NOIPHATHANH, displayTerms.getNoiPhatHanh());
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.UUTIEN, displayTerms.getUuTien());
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYDENDAY, String.valueOf(displayTerms.getNgayDenDay()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYDENMONTH, String.valueOf(displayTerms.getNgayDenMonth()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.NGAYDENYEAR, String.valueOf(displayTerms.getNgayDenYear()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.LOAIVB, String.valueOf(displayTerms.getLoaiVB()));
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.PHONGBAN, displayTerms.getPhongBan());
		iteratorURL.setParameter(
				DocumentRecordToDisplayTerms.TRICHYEU, displayTerms.getTrichYeu());

		try {
			PortalPreferences prefs =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				prefs.setValue(
					PortletKeysExt.DOCUMENTRECORDTO, "documentrecordto-order-by-col", orderByCol);
				prefs.setValue(
					PortletKeysExt.DOCUMENTRECORDTO, "documentrecordto-order-by-type", orderByType);
			}
			else {
				orderByCol = prefs.getValue(
						PortletKeysExt.DOCUMENTRECORDTO, "documentrecordto-order-by-col", "sovanbannoibo");
				orderByType = prefs.getValue(
						PortletKeysExt.DOCUMENTRECORDTO, "documentrecordto-order-by-type", "desc");
			}

			OrderByComparator orderByComparator =
				DocumentRecordToUtil.getDocumentRecordToOrderByComparator(
						orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(DocumentRecordToSearch.class);
}