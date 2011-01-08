<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordPBSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordPBDisplayTerms"%>

<%
	DocumentRecordPBSearch recordSearchPB = (DocumentRecordPBSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentRecordPBDisplayTerms displayTermsPB = (DocumentRecordPBDisplayTerms)recordSearchPB.getDisplayTerms();
	
%>

<liferay-ui:search-toggle displayTerms="<%=displayTermsPB%>" id="toogle_id_documentrecordPB" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="13%">
				<liferay-ui:message key="documentRecordType_name"/>:&nbsp;
			</td>
			<td width="55%">
				<input name="<portlet:namespace/><%=DocumentRecordPBDisplayTerms.LOAI_SO_CV %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsPB.getLoaiSoCV()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="phongban"/>:&nbsp;
			</td>
			<td >
				<input name="<portlet:namespace/><%=DocumentRecordPBDisplayTerms.SO_PB %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsPB.getSoPB()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
