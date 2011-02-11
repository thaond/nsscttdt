package com.sgs.portlet.pml_do_quan_trong.search;

import javax.portlet.RenderRequest;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="PmlDoQuanTrongSearchTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAITRIEU
 *
 */
public class PmlDoQuanTrongSearchTerms extends PmlDoQuanTrongDisplayTerms {
	
	public PmlDoQuanTrongSearchTerms(RenderRequest req) {
		super(req);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
				WebKeys.THEME_DISPLAY);
	}
	
}