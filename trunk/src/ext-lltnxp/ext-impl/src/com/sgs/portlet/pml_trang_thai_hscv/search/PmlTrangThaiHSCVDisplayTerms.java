package com.sgs.portlet.pml_trang_thai_hscv.search;

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
 * <a href="PmlTinhChatDisplayTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class PmlTrangThaiHSCVDisplayTerms extends DisplayTerms {
	
	public PmlTrangThaiHSCVDisplayTerms(RenderRequest req) {
		super(req);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
				WebKeys.THEME_DISPLAY);
		
	}
	
	
}