

<%
searchContainer = (HoSoCapSoSearch)request.getAttribute("liferay-ui:search:searchContainer");
String type = (String)request.getAttribute("liferay-ui:search:type");
PortletURL iteratorURL = searchContainer.getIteratorURL();
String url = StringPool.BLANK;

if (iteratorURL != null) {
	url = HttpUtil.removeParameter(iteratorURL.toString(), namespace + searchContainer.getCurParam());
}


%>
<div style="display: none;">
	<liferay-ui:page-iterator
		curParam="<%= searchContainer.getCurParam() %>"
		curValue="<%= searchContainer.getCurValue() %>"
		delta="<%= searchContainer.getDelta() %>"
		maxPages="<%= 25 %>"
		total="<%= searchContainer.getTotal() %>"
		type="<%= type %>"
		url="<%= url %>"
	/>
</div>

<%@ include file="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/search_paginator/start.jsp" %>