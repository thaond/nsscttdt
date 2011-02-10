package com.sgs.portlet.filetype.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;

public class FileTypeAttFileSearch extends SearchContainer<PmlFileTypeAttachedFile> {
	static List<String> headernames = new ArrayList<String>();
	
	static{
		headernames.add("no.");
		headernames.add("sgs_onedoor_attached_file_name");
		headernames.add("sgs_onedoor_original");
		headernames.add("sgs_onedoor_copy");
		headernames.add("sgs_onedoor_note");		
		headernames.add("edit");		
		headernames.add("delete");		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public FileTypeAttFileSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, null, null,
				DEFAULT_CUR_PARAM, DEFAULT_DELTA,
				iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
	}
	
	private final Log _log = LogFactoryUtil.getLog(FileTypeAttFileSearch.class);
}
