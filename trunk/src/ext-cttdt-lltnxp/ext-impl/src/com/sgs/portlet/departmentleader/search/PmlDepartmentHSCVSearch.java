/**
 * 
 */
package com.sgs.portlet.departmentleader.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;

/**
 * @author canhminh
 *
 */
public class PmlDepartmentHSCVSearch extends SearchContainer<PmlHoSoCongViec>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("pccc-TN-stt");
		headerNames.add("hscv-phongban");
		headerNames.add("description");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlDepartmentHSCVSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, null, null, DEFAULT_CUR_PARAM,DEFAULT_DELTA, 
					iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
			
		private static Log _log = LogFactoryUtil.getLog(PmlDepartmentHSCVSearch.class);
}

