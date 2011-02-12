<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.sgs.portlet.documentrecord.search.BookRecordSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.BookRecordDisplayTerms"%>

<%
	BookRecordSearch recordSearch = (BookRecordSearch)request.getAttribute("liferay-ui:search:searchContainer");
	BookRecordDisplayTerms displayTerms = (BookRecordDisplayTerms)recordSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_documentrecord" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="13%">
				<liferay-ui:message key="documentRecordType_name"/>:&nbsp;
			</td>
			<td width="55%">
				<input name="<portlet:namespace/><%=BookRecordDisplayTerms.LOAI_SO_CV %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getLoaiSoCV()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="so"/>:&nbsp;
			</td>
			<td >
				<input name="<portlet:namespace/><%=BookRecordDisplayTerms.SO_PB %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getSoPB()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
