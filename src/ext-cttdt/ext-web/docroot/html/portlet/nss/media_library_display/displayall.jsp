<%@ include file="/html/portlet/nss/media_library_display/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil"%>
<%@page import="com.nss.portlet.media_chu_de.model.MediaChuDe"%>
<%@page import="com.nss.portlet.media_library.model.MediaLibrary"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-util:include page="/html/portlet/nss/media_library_display/js/mediadisplay_js.jsp"></liferay-util:include>
<%
	List<MediaChuDe> mediaChuDeList = (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList") == null ? new ArrayList<MediaChuDe>()
				: (List<MediaChuDe>)renderRequest.getAttribute("mediaChuDeList");
	List<MediaLibrary> mediaLibraryList = (List<MediaLibrary>)renderRequest.getAttribute("mediaLibraryList") == null ? new ArrayList<MediaLibrary>()
				: (List<MediaLibrary>)renderRequest.getAttribute("mediaLibraryList");
	List<MediaLibrary> mediaLibraryChuDeList = new ArrayList<MediaLibrary>(); 
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/media_library_display/view");
%>


<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
	<fieldset>
		<div class="parent-title"><liferay-ui:message key="media-library" /></div>
		 
			<table>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" width="100%" border="0">
							<tr>
								<div> hien thi video clip</div>
							</tr>
						</table>
					</td>
					<td height="10"></td>
					<td>
						<table cellpadding="0" cellspacing="0" width="100%" border="0">
							<tr>
								<div> hien thi video clip</div>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
			<%
				for (int i = 0; i < mediaChuDeList.size(); i++) {
					MediaChuDe mediaChuDe = mediaChuDeList.get(i);
					mediaLibraryChuDeList = MediaLibraryLocalServiceUtil.findByMaMediaChuDe_Active(mediaChuDe.getMaMediaChuDe(), true);
					if (!mediaLibraryChuDeList.isEmpty()) {
						
						PortletURL detailURL = renderResponse.createActionURL();
						detailURL.setWindowState(WindowState.NORMAL);
						detailURL.setParameter("cmd","detailtopic");
						detailURL.setParameter("struts_action","/nss/media_library_display/view");
						detailURL.setParameter("maMediaChuDe",String.valueOf(mediaChuDe.getMaMediaChuDe()));	
						detailURL.setParameter("tabs", "topic");	

			%>
			<table>
			
					<tr>
						<td><div class="parent-title"><%= mediaChuDe.getTenMediaChuDe() %></div></td>
					</tr>
					<%
						for (int j = 0; j < mediaLibraryChuDeList.size(); j++) {
							MediaLibrary mediaLibrary = mediaLibraryChuDeList.get(j);
							detailURL.setParameter("maMediaLibrary", String.valueOf(mediaLibrary.getMaMediaLibrary()));	
					%>
					<tr>
							<td>
								<table>
									<tr><td>hien thi doan video o day</td></tr>
									<tr><td><a href="<%= detailURL.toString() %>"><%= mediaLibrary.getTenMediaLibrary() %></a></td></tr>
								</table>
							</td>
							<td height="10"></td>
					</tr>
					<tr height="10"></tr>
					<%
						}
					%>
			
			</table>
			<%
					}
				}
			%>
	</fieldset>
</form>
