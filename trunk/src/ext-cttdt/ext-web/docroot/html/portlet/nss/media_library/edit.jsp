<%@ include file="/html/portlet/nss/media_library/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.media_chu_de.model.MediaChuDe"%>
<%@page import="com.nss.portlet.media_library.model.MediaLibrary"%>

<liferay-util:include page="/html/portlet/nss/media_library/js/medialibrary-js.jsp"></liferay-util:include>
<%
	String redirect = renderRequest.getParameter("redirect");
	MediaLibrary mediaLibrary = (MediaLibrary)renderRequest.getAttribute("mediaLibrary");
	
	List<MediaChuDe> mediaChuDeList = (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList") == null ? new ArrayList<MediaChuDe>() 
			: (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/media_library/view");
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("maMediaLibrary", String.valueOf(mediaLibrary.getMaMediaLibrary()));
	
%>

 <form action="<%= portletURL.toString() %>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onsubmit="return checkFormEditMediaLibrary();">
		<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="cap-nhat" /></div>
		<table width="100%" border="0" class="common-table">
		    
		    <tr>
		    	<td ><label><liferay-ui:message key="media-chu-de" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>
		    	</td>
			    <td align="left">
			   		 <select name="<portlet:namespace />maMediaChuDe" id="maMediaChuDe" style="width: 24%;">
			    		<option value="0"><liferay-ui:message key="chon-chu-de" /></option>
						<%
							for (int i = 0; i < mediaChuDeList.size(); i ++) {
								MediaChuDe mediaChuDe = (MediaChuDe) mediaChuDeList.get(i);
						%>
						<option value="<%= mediaChuDe.getMaMediaChuDe() %>" "<%= mediaChuDe.getMaMediaChuDe() == mediaLibrary.getMaMediaChuDe() ? "selected" : "" %>" ><%= mediaChuDe.getTenMediaChuDe() %></option>
						<%
							}
						%>
			    	</select>
			    </td>
		    </tr>
		    
		    <tr>
				<td>
					<label><liferay-ui:message key="tieu-de" /></label>
				</td>
				<td>
					<input type="text" name="<portlet:namespace />tieuDe" class="form-input-box" value="<%= mediaLibrary.getTieuDeMediaLibrary() %>" /></td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>
					<label><liferay-ui:message key="ten-media-library" /></label>
					<span style="color: rgb(255, 0, 0);"> *</span>
				</td>
				<td><label><%= mediaLibrary.getTenMediaLibrary() %></label>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>
					<label><liferay-ui:message key="tap-tin-dinh-kem" /></label>
				</td>
				<td>
					<input type="file" name="<portlet:namespace />file" class="form-input-box" id="file" onchange="getFileName(this.value)" /></td>
					<input type="hidden" name="<portlet:namespace />fileName" id="fileName"> 
				<td>&nbsp;</td>
			</tr>
			
		    <tr>
				<td>
					<label><liferay-ui:message key="active" /></label>
					<span style="color: rgb(255, 0, 0);"> *</span>
				</td>
				<td><input type="checkbox" name="<portlet:namespace />active" <%= mediaLibrary.getActive() == true ? "checked" : "" %> ></td>
				<td>&nbsp;</td>
			</tr>
		    
			<tr>
				<td>
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<br/>
		<table id="table-button">
			<tbody>
				<tr>
					<td>
						<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
						<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
						<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
		    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
				 	</td>
				</tr>
			</tbody>
		</table>
		</div>
	</form>