<%@ include file="/html/portlet/ext/documentfield/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.documentfield.search.PmlFieldSearch"%>
<%@page import="com.sgs.portlet.documentfield.search.PmlFieldDisplayTerms"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentfield/view");
%>

<script type="text/javascript">
	function searchPmlField(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
</script>

<%
	PmlFieldSearch pmlFieldSearch = (PmlFieldSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PmlFieldDisplayTerms displayTerms = (PmlFieldDisplayTerms) pmlFieldSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_pmlfield" >
	<table cellspacing="0" width="100%">
	
		<tr>
			<td width="10%" align="right"><liferay-ui:message key="field.code" />:</td>
			<td width="20%">
				<input name="<portlet:namespace/><%=PmlFieldDisplayTerms.MA_PHAN_LOAI %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMaPhanLoai()) %>" />
			</td>
			<td width="10%" align="right"><liferay-ui:message key="field.name" />:</td>
			<td >
				<input name="<portlet:namespace/><%=PmlFieldDisplayTerms.TEN_PHAN_LOAI %>" style="width: 98%"  type="text" value="<%= HtmlUtil.escape(displayTerms.getTenPhanLoai()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" class="button-width" onclick="searchPmlField('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
