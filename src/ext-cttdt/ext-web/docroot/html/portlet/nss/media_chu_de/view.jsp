<%@ include file="/html/portlet/nss/media_chu_de/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.media_chu_de.search.MediaChuDeSearch"%>
<%@page import="com.nss.portlet.media_chu_de.search.MediaChuDeSearchTerms"%>
<%@page import="com.nss.portlet.media_chu_de.model.MediaChuDe"%>
<%@page import="com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil"%>
<%@page import="com.nss.portlet.media_chu_de.MediaChuDeTenChuDeException"%>
<%@page import="com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException"%>
<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/media_chu_de/view");
	
	MediaChuDe mediaChuDe = (MediaChuDe)request.getAttribute("mediaChuDe");
	long maMediaChuDe = 0; 
	boolean isAddNew = true; // add new item
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String mediaChuDeAUFlag = "";
	String tenMediaChuDe = "";
	
	if (mediaChuDe != null) {
		maMediaChuDe = mediaChuDe.getMaMediaChuDe();
		isAddNew = false;
		tenMediaChuDe = mediaChuDe.getTenMediaChuDe();
	}
	else {
		mediaChuDeAUFlag = request.getAttribute("mediaChuDeAUFlag") == null ? "" : String.valueOf(request.getAttribute("mediaChuDeAUFlag"));
		if (mediaChuDeAUFlag.equals("fail")) {
			maMediaChuDe = ParamUtil.getLong(request, "maMediaChuDe");
			isAddNew = false;
		}
		tenMediaChuDe = ParamUtil.getString(request, "tenMediaChuDe");
	}
	
%>

<script type="text/javascript">
	function deleteMediaChuDe(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function <portlet:namespace />saveMediaChuDe(cmd) {
		if (cmd == null) {
			cmd = "<%= mediaChuDe != null || (mediaChuDe == null && maMediaChuDe > 0 && mediaChuDeAUFlag.equals("fail")) ? Constants.UPDATE : Constants.ADD %>";
		}
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		submitForm(document.<portlet:namespace />fm);
	}
</script>	

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm"  enctype="multipart/form-data" onSubmit="<portlet:namespace />saveMediaChuDe(); return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />maMediaChuDe" value="<%= maMediaChuDe %>" />
	<input name="<portlet:namespace />mediaChuDeURL" type="hidden" value='<%= portletURL.toString() %>' />

	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-media-chu-de" /></div>
		<liferay-ui:error exception="<%= MediaChuDeTenChuDeException.class %>" message="ten-media-chu-de-khong-hop-le" />
		<liferay-ui:error exception="<%= MediaChuDeCanNotDeleteException.class %>" message="khong-the-xoa-media-chu-de" />
		
		<%
			MediaChuDeSearch mediaChuDeSearch = new MediaChuDeSearch(renderRequest, portletURL);
			MediaChuDeSearchTerms searchTerms = (MediaChuDeSearchTerms)mediaChuDeSearch.getSearchTerms();
			
			List<MediaChuDe> results = MediaChuDeLocalServiceUtil.findMediaChuDe(searchTerms.getTenMediaChuDe(), searchTerms.isAndOperator(), 
						mediaChuDeSearch.getStart(), mediaChuDeSearch.getEnd(), mediaChuDeSearch.getOrderByComparator());
			int total = MediaChuDeLocalServiceUtil.countMediaChuDe(searchTerms.getTenMediaChuDe(), searchTerms.isAndOperator());
			mediaChuDeSearch.setResults(results);
			mediaChuDeSearch.setTotal(total);
			
			portletURL.setParameter(mediaChuDeSearch.getCurParam(), String.valueOf(mediaChuDeSearch.getCurValue()));
		%>
		<div class="od-div-outer-box">
			<table class="common-table" width="100%">
				<tr>
					<td width="50%">
						<liferay-ui:message key="ten-media-chu-de" />&nbsp;<span style="color:red;">(*)</span><br>
						<input type="text" name="<portlet:namespace />tenMediaChuDe" value="<%= tenMediaChuDe %>" style="width:100%;" />
					</td>
					<td width="50%">
						<liferay-ui:message key="is-add-new" /><br />
						<input type="checkbox" name="<portlet:namespace />isAddNew" <%= isAddNew == true ? "checked" : "" %> disabled="disabled" />
					</td>
				</tr>
			</table>
			<div class="separator"></div>
			<div>
				<input type="submit" value='<liferay-ui:message key="save" />' />
			</div>
		</div>
		<%	
			List resultRows = mediaChuDeSearch.getResultRows();
			ResultRow row = null;
			MediaChuDe mediaChuDeRow = null;
			String update = "";
			String deleteAction = "";
			String active = "";
			for (int i = 0; i < results.size(); i++) {
				mediaChuDeRow = results.get(i);
				long maMediaChuDeRow = mediaChuDeRow.getMaMediaChuDe();
				mediaChuDeRow = mediaChuDeRow.toEscapedModel();
				row = new ResultRow(mediaChuDeRow, maMediaChuDeRow, i);	
				
				// stt
				row.addText(String.valueOf(i + 1));
				
				// ten chu de		
				row.addText(mediaChuDeRow.getTenMediaChuDe());

				// Active image
				PortletURL rowURLActive = renderResponse.createActionURL();
				rowURLActive.setWindowState(WindowState.NORMAL);
				rowURLActive.setParameter("struts_action", "/nss/media_chu_de/view");
				rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
				rowURLActive.setParameter("redirect", mediaChuDeSearch.getIteratorURL().toString());
				rowURLActive.setParameter("maMediaChuDe", String.valueOf(maMediaChuDeRow));
			
				if (mediaChuDeRow.getActive()) {
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
				} else if (!mediaChuDeRow.getActive()){
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
				}
				row.addText(active);
				
				// edit
				//URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
				rowURLEdit.setParameter("struts_action","/nss/media_chu_de/view");
				rowURLEdit.setParameter("redirect", mediaChuDeSearch.getIteratorURL().toString());
				rowURLEdit.setParameter("maMediaChuDe", String.valueOf(maMediaChuDeRow));
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				
				row.addText(update);

				// delete
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("struts_action","/nss/media_chu_de/view");
				rowURLDelete.setParameter("redirect", mediaChuDeSearch.getIteratorURL().toString());
				rowURLDelete.setParameter("maMediaChuDe", String.valueOf(maMediaChuDeRow));
				
				deleteAction = "<a  href='javascript: ;'  onclick=deleteMediaChuDe('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(deleteAction);
							
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%= mediaChuDeSearch %>" />
	</div>
</form>
