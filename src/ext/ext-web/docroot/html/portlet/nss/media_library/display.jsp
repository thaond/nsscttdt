<%@ include file="/html/portlet/nss/media_library/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.media_library.model.MediaLibrary"%>
<%@page import="com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil"%>
<%@page import="com.nss.portlet.media_chu_de.model.MediaChuDe"%>
<%@page import="com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil"%>
<%@page import="com.nss.portlet.media_library.search.MediaLibrarySearch"%>
<%@page import="com.nss.portlet.media_library.search.MediaLibrarySearchTerms"%>


<liferay-util:include page="/html/portlet/nss/media_library/js/medialibrary-js.jsp"></liferay-util:include>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/media_library/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-media-library" /></div>
		
		<%
			MediaLibrarySearch searchContainer = new MediaLibrarySearch(renderRequest, portletURL);
			MediaLibrarySearchTerms searchTerms = (MediaLibrarySearchTerms)searchContainer.getSearchTerms();
		%>
		
		<liferay-ui:search-form
			page="/html/portlet/nss/media_library/search_form.jsp"
			searchContainer="<%= searchContainer %>" />
		<div id="separator"></div>
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/media_library/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
		<a href="<%= addURL.toString() %>">
			<input type="button" value="<liferay-ui:message key="them-moi" />" >
		</a>
		<br/><br/>
		<%	
			List<MediaLibrary> results = null;
			int total = 0;
			if (!searchTerms.isAdvancedSearch()) {
				results = MediaLibraryLocalServiceUtil.search(searchTerms.getKeywords(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
				total = MediaLibraryLocalServiceUtil.searchCount(searchTerms.getKeywords());
			} else {
				results = MediaLibraryLocalServiceUtil.findMediaLibrary(searchTerms.getTieuDeMediaLibrary(), searchTerms.getTenMediaLibrary(), searchTerms.getMaMediaChuDe(),
						searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
				total = MediaLibraryLocalServiceUtil.countMediaLibrary(searchTerms.getTieuDeMediaLibrary(), searchTerms.getTenMediaLibrary(), searchTerms.getMaMediaChuDe(), searchTerms.isAndOperator());
			}
		
			searchContainer.setResults(results);
			searchContainer.setTotal(total);
			portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
			
			List resultRows = searchContainer.getResultRows();
			ResultRow row = null;
			MediaLibrary mediaLibrary = null;
			MediaChuDe mediaChuDeRow = null;
			String update = "";
			String deleteAction = "";
			String active = "";
			
			for (int i = 0; i < results.size(); i++) {
				mediaLibrary = results.get(i);
				long maMediaLibrary = mediaLibrary.getMaMediaLibrary();
				mediaLibrary = mediaLibrary.toEscapedModel();
				row = new ResultRow(mediaLibrary, maMediaLibrary, i);	
				
				// stt
				row.addText(String.valueOf(i + 1));
				
				// tieu de media library		
				row.addText(mediaLibrary.getTieuDeMediaLibrary());
				
				// ten media library	
				String download = "";
				String pathFile = getServletContext().getRealPath("")+ mediaLibrary.getDuongDan();
				File file = new File(pathFile);
				if (file.exists()) {
					download = "<a href='" + mediaLibrary.getDuongDan()+ "'>" + mediaLibrary.getTenMediaLibrary() + "</a>";
				} else {
					download = mediaLibrary.getTenMediaLibrary();
				}
				row.addText(download);	

				// ten chu de
				String tenMediaChuDe = "";
				try {
					mediaChuDeRow = MediaChuDeLocalServiceUtil.getMediaChuDe(mediaLibrary.getMaMediaChuDe());
					tenMediaChuDe = mediaChuDeRow.getTenMediaChuDe();
				} catch (Exception e) {
					tenMediaChuDe = "";
				}
				row.addText(tenMediaChuDe);
				
				// Active image
				PortletURL rowURLActive = renderResponse.createActionURL();
				rowURLActive.setWindowState(WindowState.NORMAL);
				rowURLActive.setParameter("struts_action", "/nss/media_library/view");
				rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
				rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURLActive.setParameter("maMediaLibrary", String.valueOf(maMediaLibrary));
			
				if (mediaLibrary.getActive()) {
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
				} else if (!mediaLibrary.getActive()){
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
				}
				row.addText(active);
				
				// edit
				//URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
				rowURLEdit.setParameter("struts_action","/nss/media_library/view");
				rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURLEdit.setParameter("tabs", "edit");
				rowURLEdit.setParameter("maMediaLibrary", String.valueOf(maMediaLibrary));
				rowURLEdit.setParameter("maMediaChuDe", String.valueOf(mediaChuDeRow.getMaMediaChuDe()));
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				
				row.addText(update);

				// delete
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("struts_action","/nss/media_library/view");
				rowURLDelete.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURLDelete.setParameter("maMediaLibrary", String.valueOf(maMediaLibrary));
				
				deleteAction = "<a  href='javascript: ;'  onclick=deleteMediaLibrary('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(deleteAction);
							
				resultRows.add(row);
			}
			
		%>
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</div>
</form>