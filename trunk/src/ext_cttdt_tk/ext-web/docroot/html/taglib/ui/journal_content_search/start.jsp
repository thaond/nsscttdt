<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/taglib/ui/journal_content_search/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%
String defaultKeywords = LanguageUtil.get(pageContext, "search") + "...";
String unicodeDefaultKeywords = UnicodeFormatter.toString(defaultKeywords);

String keywords = ParamUtil.getString(request, namespace + "keywords", defaultKeywords);

// minh update 20100723
String pageSearch = "SEARCH";
List<com.liferay.portal.model.PortletPreferences> portletPreferences =  com.liferay.portal.service.PortletPreferencesLocalServiceUtil.getPortletPreferences();
Collections.sort(portletPreferences, new Comparator<com.liferay.portal.model.PortletPreferences>(){
	public int compare(com.liferay.portal.model.PortletPreferences p1, com.liferay.portal.model.PortletPreferences p2) {
		return (int) (p2.getPrimaryKey() - p1.getPrimaryKey());
	}
});

com.liferay.portal.model.PortletPreferences pRes = null;
Layout layoutSearch = null;
long pageLId = 0;
for (com.liferay.portal.model.PortletPreferences p: portletPreferences) {
	if (p.getPortletId().equals(PortletKeys.JOURNAL_CONTENT_SEARCH)) {
		pRes = p;
		pageLId = pRes.getPlid();
		layoutSearch = LayoutLocalServiceUtil.getLayout(pageLId);
		if (layoutSearch.getFriendlyURL().toUpperCase().contains(pageSearch)){
			break;
		}
	}
}

// end minh update 20100723

PortletURL portletURL = new PortletURLImpl(request, PortletKeys.JOURNAL_CONTENT_SEARCH, pageLId, PortletRequest.RENDER_PHASE);

portletURL.setWindowState(WindowState.NORMAL);
portletURL.setPortletMode(PortletMode.VIEW);

portletURL.setParameter("struts_action", "/journal_content_search/search");
%>


<form action="<%= portletURL.toString() %>" method="post" name="<%= namespace %>fm" onSubmit="submitForm(this); return false;">
<input name="<%= namespace %>keywords" class="txtsearch" type="text" value="<%= HtmlUtil.escape(keywords) %>" onBlur="if (this.value == '') { this.value = '<%= unicodeDefaultKeywords %>'; }" onFocus="if (this.value == '<%= unicodeDefaultKeywords %>') { this.value = ''; }" />
<input align="absmiddle" border="0" src="<%= themeDisplay.getPathThemeImages() %>/hcs/bttsearch.png" title="<liferay-ui:message key="search" />" type="image" />