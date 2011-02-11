package com.sgs.portlet.pml_tinh_chat.search;

//import com.liferay.portal.kernel.dao.DAOParamUtil;
//import com.liferay.portal.kernel.dao.search.DAOParamUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.util.PortalUtil;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.portlet.RenderRequest;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="PmlTinhChatSearchTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAITRIEU
 *
 */
public class PmlTinhChatSearchTerms extends PmlTinhChatDisplayTerms {
	
	public PmlTinhChatSearchTerms(RenderRequest req) {
		super(req);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(
				WebKeys.THEME_DISPLAY);
	}
	
}