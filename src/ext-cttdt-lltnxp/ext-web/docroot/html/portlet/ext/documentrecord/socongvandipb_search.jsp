<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.documentrecord.search.BookRecordPBSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.BookRecordPBDisplayTerms"%>

<%
	BookRecordPBSearch recordSearchPB = (BookRecordPBSearch)request.getAttribute("liferay-ui:search:searchContainer");
	BookRecordPBDisplayTerms displayTermsPB = (BookRecordPBDisplayTerms)recordSearchPB.getDisplayTerms();
	
%>

<liferay-ui:search-toggle displayTerms="<%=displayTermsPB%>" id="toogle_id_bookrecordPB" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="13%">
				<liferay-ui:message key="documentRecordType_name"/>:&nbsp;
			</td>
			<td width="55%">
				<input name="<portlet:namespace/><%=BookRecordPBDisplayTerms.LOAI_SO_CV %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsPB.getLoaiSoCV()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="phongban"/>:&nbsp;
			</td>
			<td >
				<input name="<portlet:namespace/><%=BookRecordPBDisplayTerms.SO_PB %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsPB.getSoPB()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
