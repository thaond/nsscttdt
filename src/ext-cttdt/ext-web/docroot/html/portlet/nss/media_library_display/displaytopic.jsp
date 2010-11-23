<%@ include file="/html/portlet/nss/media_library_display/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.media_library.model.MediaLibrary"%>

<%
	MediaLibrary mediaLibrary = (MediaLibrary)renderRequest.getAttribute("mediaLibrary");
	List<MediaLibrary> mediaLibraryList = (List<MediaLibrary>)renderRequest.getAttribute("mediaLibraryChuDeList") == null ? new ArrayList<MediaLibrary>()
			: (List<MediaLibrary>)renderRequest.getAttribute("mediaLibraryChuDeList");
	long maMediaChuDe = 0;
	String mainVideo = "";
	if (null != mediaLibrary) {
		mainVideo = getServletContext().getRealPath("")+ mediaLibrary.getDuongDan();
		maMediaChuDe = mediaLibrary.getMaMediaChuDe();
	}
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/media_library_display/view");
	portletURL.setParameter("maMediaChuDe", String.valueOf(maMediaChuDe));
	portletURL.setParameter("tabs", "topic");
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
<div>
	<table>
		<tr>
			<td><embed src="<%= mediaLibrary.getDuongDan() %>"> </td>
		</tr>
		<tr height="10"></tr>
		<tr>
			<td><%= mediaLibrary.getTenMediaLibrary() %></td>
		</tr>
	</table>
</div>

<div>
	<table>
	<%
		for (int i = 0 ; i < mediaLibraryList.size(); i++) {
			MediaLibrary library = mediaLibraryList.get(i);
			String pathFile = getServletContext().getRealPath("")+ library.getDuongDan();
	%>
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<embed src="<%= library.getDuongDan() %>"></td>
						</td>
					</tr>
				</table>  
			</td>
			<td width="10"></td>
			<td>
				<table>
					<tr>
						<td><label><%= library.getTieuDeMediaLibrary() %></label></td>
					</tr>
					<tr height="10"></tr>
					<tr>
						<td><label><%= library.getLuotXem() %></label></td>
					</tr>
				</table>  
			</td>
		</tr>
		<tr height="10"></tr>
	<%
		}
	%>
	</table>
</div>
</form>