<%@ include file="/html/portlet/ext/attachedfile/init.jsp" %>
<%@page import="com.sgs.portlet.attachedfile.search.AttachedfileSearch"%>
<%@page import="com.sgs.portlet.attachedfile.search.AttachedfileDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	AttachedfileSearch attachedfileSearch = (AttachedfileSearch)request.getAttribute("liferay-ui:search:searchContainer");
	AttachedfileDisplayTerms displayTerms = (AttachedfileDisplayTerms)attachedfileSearch.getDisplayTerms();
%>
<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_attachedfile" >
	<table class="attachedfile-table" cellspacing="0" width="100%">
		<tr>
			<td width="3%" align="right">
				<liferay-ui:message key="code."/>:&nbsp;
			</td>
			<td width="15%">
				<input name="<portlet:namespace/><%=AttachedfileDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="15%" align="right">
				<liferay-ui:message key="pccc-TN-tenhosodinhkem"/>:&nbsp;
			</td>
			<td>
				<input name="<portlet:namespace/><%=AttachedfileDisplayTerms.TEN %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
