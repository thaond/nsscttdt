<%@ include file="/html/portlet/nss/attachedfile/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.attachedfile.search.AttachedfileSearch"%>
<%@page import="com.nss.portlet.attachedfile.search.AttachedfileDisplayTerms"%>

<%
	AttachedfileSearch attachedfileSearch = (AttachedfileSearch)request.getAttribute("liferay-ui:search:searchContainer");
	AttachedfileDisplayTerms displayTerms = (AttachedfileDisplayTerms)attachedfileSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_attachedfile" >
	<table class="attachedfile-table" cellspacing="0" width="100%">
		<tr>
			<td align="right">
				<liferay-ui:message key="code."/>:&nbsp;
			</td>
			<td >
				<input name="<portlet:namespace/><%=AttachedfileDisplayTerms.MA %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="pccc-TN-tenhosodinhkem"/>:&nbsp;
			</td>
			<td>
				<input name="<portlet:namespace/><%=AttachedfileDisplayTerms.TEN %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
