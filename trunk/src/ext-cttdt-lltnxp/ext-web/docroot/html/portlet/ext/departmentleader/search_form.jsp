<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentSearch"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentDisplayTerms"%>


<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/departmentleader/view");
%>

<script type="text/javascript">
	function searchPmlDepartment(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	PmlDepartmentSearch fileTypeSearch = (PmlDepartmentSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PmlDepartmentDisplayTerms displayTerms = (PmlDepartmentDisplayTerms) fileTypeSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_pmldepartment" >
	<table class="pmldepartment-table" width="100%">
	
		<tr>
			<td width="11%" align="right"><liferay-ui:message key="department_code" />:&nbsp;</td>
			<td width="20%">
				<input name="<portlet:namespace/><%=PmlDepartmentDisplayTerms.MA_PHONG %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMaPhong()) %>" />
			</td>
			
			<td width="12%" align="right"><liferay-ui:message key="department_name" />:&nbsp;</td>
			<td width="20%">
				<input name="<portlet:namespace/><%=PmlDepartmentDisplayTerms.TEN_PHONG %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenPhong()) %>" />
			</td>
			
			<td width="9%" align="right"><liferay-ui:message key="abbreviate_name" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=PmlDepartmentDisplayTerms.TEN_VIET_TAT %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenVietTat()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" class="button-width" onclick="searchPmlDepartment('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
