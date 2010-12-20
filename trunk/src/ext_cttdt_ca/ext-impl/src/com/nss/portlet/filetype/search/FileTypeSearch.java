package com.nss.portlet.filetype.search;

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
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.util.FileTypeSearchUtil;

public class FileTypeSearch extends SearchContainer<PmlFileType>{
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("sgs_filetype_filetypeCode");
		headernames.add("sgs_filetype_filetypeName");
		headernames.add("sgs_filetype_fieldid");
		headernames.add("sgs_filetype_templateid");		
		headernames.add("sgs_filetype_processTime");		
		headernames.add("description");		
		headernames.add("active.");		
		headernames.add("sgs_filetype_current_receipt_number");	
		headernames.add("sgs_filetype_receipt_template");	
		headernames.add("pccc-TN-hosodinhkem");			
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("sgs_filetype_filetypeCode", "sgs_filetype_filetypeCode");
		orderableHeaders.put("sgs_filetype_filetypeName", "sgs_filetype_filetypeName");		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public FileTypeSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new FileTypeDisplayTerms(renderRequest), 
				new FileTypeSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		FileTypeDisplayTerms displayTerms = (FileTypeDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(FileTypeDisplayTerms.FILETYPE_CODE, displayTerms.getFileTypeCode());
		iteratorURL.setParameter(FileTypeDisplayTerms.FILETYPE_NAME, displayTerms.getFileTypeName());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_FILETYPE", "filetype-order-by-column",orderByCol);
				 preferences.setValue("SGS_FILETYPE", "filetype-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_FILETYPE", "filetype-order-by-column", "sgs_filetype_filetypeCode");
				 preferences.setValue("SGS_FILETYPE", "filetype-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = FileTypeSearchUtil.getFileTypeOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(FileTypeSearch.class);

}
