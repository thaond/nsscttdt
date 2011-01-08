package com.sgs.portlet.pml_do_quan_trong.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.StringPool;
//import com.liferay.portal.util.PortalUtil;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.portlet.RenderRequest;

/**
 * <a href="PmlDoQuanTrongDisplayTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class PmlDoQuanTrongDisplayTerms extends DisplayTerms {
	
	public PmlDoQuanTrongDisplayTerms(RenderRequest req) {
		super(req);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
				WebKeys.THEME_DISPLAY);
		
	}
	
	
}