<%@ include file="/html/portlet/nss/media_library/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.media_chu_de.model.MediaChuDe"%>
<%@page import="com.nss.portlet.media_library.search.MediaLibrarySearch"%>
<%@page import="com.nss.portlet.media_library.search.MediaLibraryDisplayTerms"%>

<%
	List<MediaChuDe> mediaChuDeList = (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList") == null ? new ArrayList<MediaChuDe>() 
												: (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList");
	MediaLibrarySearch searchContainer = (MediaLibrarySearch)renderRequest.getAttribute("liferay-ui:search:searchContainer");
	MediaLibraryDisplayTerms displayTerms = (MediaLibraryDisplayTerms)searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_medialibrary" >
<table class="vanbanphapquy-table">
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="tieu-de" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%= MediaLibraryDisplayTerms.TIEU_DE_MEDIA_LIBRARY %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTieuDeMediaLibrary()) %>" />
			</td>
		</tr>
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="ten-media-library" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%= MediaLibraryDisplayTerms.TEN_MEDIA_LIBRARY %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenMediaLibrary()) %>" />
			</td>
		</tr>
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="media-chu-de" />:&nbsp;</td>
			<td align="left">
				<select name="<portlet:namespace /><%= MediaLibraryDisplayTerms.MA_MEDIA_CHU_DE%>"  style="width: 89%;">
		    		<option  value="<%= 0 %>"><liferay-ui:message key="chon-chu-de" /></option>
					<%
						if (!mediaChuDeList.isEmpty()) { 
							for (int i = 0; i < mediaChuDeList.size(); i ++) {
								MediaChuDe mediaChuDe = (MediaChuDe) mediaChuDeList.get(i);
					%>
								<option <%= displayTerms.getMaMediaChuDe() == mediaChuDe.getMaMediaChuDe() ? "selected=selected" : "" %>  value="<%= mediaChuDe.getMaMediaChuDe() %>" > <%= mediaChuDe.getTenMediaChuDe() %> </option>
					<%
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
	</table>
</liferay-ui:search-toggle>	
<br/>

<div style="padding-top: 5px;padding-bottom: 10px;">
	<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
</div>