package com.sgs.portlet.pcccdocumentsendreport.search;

import com.ext.portal.util.PortletKeysExt;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.pcccdocumentsendreport.util.DocumentSendUtil;

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
public class DocSendReportSearch extends SearchContainer<PmlEdmDocumentSend> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("no.");
		headerNames.add("so-phat-hanh");
		headerNames.add("loai-van-ban");
		headerNames.add("ngay-phat-hanh");
		headerNames.add("trich-yeu");
		headerNames.add("don-vi-soan-thao");

		// Order by
		orderableHeaders.put("so-phat-hanh", "sophathanh");
		orderableHeaders.put("ngay-phat-hanh", "ngayphathanh");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "documentsend-search-khongtontaidulieu";

	public DocSendReportSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(
			renderRequest, new DocSendReportDisplayTerms(renderRequest),
			new DocSendReportSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		DocSendReportDisplayTerms displayTerms = (DocSendReportDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
				DocSendReportDisplayTerms.SOPH, displayTerms.getSoPH());
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.NGAYPHMONTH, String.valueOf(displayTerms.getNgayPHMonth()));
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.NGAYPHYEAR, String.valueOf(displayTerms.getNgayPHYear()));
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.PHONGST, displayTerms.getPhongST());
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.NOINHAN, displayTerms.getNoiNhan());
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.LOAIVB, String.valueOf(displayTerms.getLoaiVB()));
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.NGUOIKY, displayTerms.getNguoiKy());
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.NGUOIST, String.valueOf(displayTerms.getNguoiST()));
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.TRICHYEU, displayTerms.getTrichYeu());
		iteratorURL.setParameter(
				DocSendReportDisplayTerms.VANBANPH, displayTerms.getVanBanPH());

		try {
			PortalPreferences prefs =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "sophathanh");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				prefs.setValue(
					PortletKeysExt.DOCSENDREPORT, "docsendreport-order-by-col", orderByCol);
				prefs.setValue(
					PortletKeysExt.DOCSENDREPORT, "docsendreport-order-by-type", orderByType);
			}
			else {
				orderByCol = prefs.getValue(
						PortletKeysExt.DOCSENDREPORT, "docsendreport-order-by-col", "sophathanh");
				orderByType = prefs.getValue(
						PortletKeysExt.DOCSENDREPORT, "docsendreport-order-by-type", "desc");
			}

			OrderByComparator orderByComparator =
				DocumentSendUtil.getDocSendReportOrderByComparator(
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

	private static Log _log = LogFactory.getLog(DocSendReportSearch.class);
}