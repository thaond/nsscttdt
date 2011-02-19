<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.PhongBanDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.PhongBanSearch"%>

<%
	PhongBanSearch phongbanSearch = (PhongBanSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PhongBanDisplayTerms displayTerms = (PhongBanDisplayTerms) phongbanSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_loaivanbannoibo">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><liferay-ui:message key="ma-phong-ban-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=PhongBanDisplayTerms.DEPARTMENTSCODE%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentsCode())%>" />
			</td>
	
			<td><liferay-ui:message key="ten-phong-ban-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=PhongBanDisplayTerms.DEPARTMENTNAMES%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentsName())%>" />
			</td>
			<td><liferay-ui:message key="ten-viet-tat-phong-ban-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=PhongBanDisplayTerms.ABBREVIATENAME%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getAbbreviateName())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br>
<input type="submit" style="margin-left: 20%" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />
	
