<%@ include file="/html/portlet/nss/adv/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.adv.search.QuangCaoSearch"%>
<%@page import="com.nss.portlet.adv.search.QuangCaoSearchTerms"%>
<%@page import="com.nss.portlet.adv.model.QuangCao"%>
<%@page import="com.nss.portlet.adv.service.QuangCaoLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/adv/js/quangcao-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/adv/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		QuangCaoSearch searchContainer = new QuangCaoSearch(renderRequest, portletURL);
		QuangCaoSearchTerms searchTerms = (QuangCaoSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_ADV" /></div>
		
		<liferay-ui:search-form
			page="/html/portlet/nss/adv/search_form.jsp"
			searchContainer="<%= searchContainer %>" />
		<div id="separator"></div>
		
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/nss/adv/view");
				addURL.setParameter("tabs", "add");
				addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			%>
		<br/>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
		<br/>
		<%
			List<QuangCao> results = null;
			int total = 0;
			
			if (searchTerms.isAdvancedSearch()) {
				results = QuangCaoLocalServiceUtil.search(searchTerms.getTenQuangCao(), searchTerms.getMoTa(), searchTerms.isAndOperator(),
							searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
				total = QuangCaoLocalServiceUtil.searchCount(searchTerms.getTenQuangCao(), searchTerms.getMoTa(), searchTerms.isAndOperator());
			} else {
				results = QuangCaoLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(),
							searchContainer.getOrderByComparator());
				total = QuangCaoLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			}
			
			searchContainer.setResults(results);
			searchContainer.setTotal(total);
			
			portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		%>
		<%
		
			List resultRows = searchContainer.getResultRows();
			ResultRow row = null;
			QuangCao quangCao = null;
			long maQuangCao = 0;
			String update = "";
			String deleteAction = "";
			String active = "";
			
			for ( int i=0; i < results.size(); i++) {
				quangCao = results.get(i);
				maQuangCao = quangCao.getMaQuangCao();
				
				quangCao = quangCao.toEscapedModel();
				row = new ResultRow(quangCao, maQuangCao, i);
				
				//STT
				row.addText(String.valueOf(i + 1));
				
				//ten linh vuc van ban
				row.addText(quangCao.getTenQuangCao());
				
				// hinh anh
				if (0 == quangCao.getImageId_liferay()) {
					row.addText("");
				} else {
					row.addText("<img width='120px' height='90px' src='"+  themeDisplay.getPathImage()+ "/adv?img_id="+ quangCao.getImageId_liferay() +"' />");
				}
				
				// mo ta
				row.addText(quangCao.getMoTaQuangCao());
				
				// thu tu
				row.addText(String.valueOf(quangCao.getThuTuQuangCao()));
				
				// target
				row.addText(quangCao.getTarget());
				
				//active 
				//URL active
				PortletURL rowURLActive= renderResponse.createActionURL();
				rowURLActive.setWindowState(WindowState.NORMAL);
				rowURLActive.setParameter("struts_action","/nss/adv/view");
				rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
				rowURLActive.setParameter("maQuangCao", String.valueOf(maQuangCao));
				rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
				
				if (1 == quangCao.getActive()) {
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
				} else if (0 == quangCao.getActive()){
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
				}
				row.addText(active);
				
				// edit
				//URL update
				PortletURL rowURLEdit = renderResponse.createActionURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
				rowURLEdit.setParameter("struts_action","/nss/adv/view");
				rowURLEdit.setParameter("maQuangCao", String.valueOf(maQuangCao));
				rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURLEdit.setParameter("tabs", "edit");
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				
				row.addText(update);
				
				// delete
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action","/nss/adv/view");
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("maQuangCao", String.valueOf(maQuangCao));
				
				deleteAction = "<a  href='javascript: ;'  onclick=deleteQuangCao('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(deleteAction);
				
				resultRows.add(row);
			}
			
		%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</div>
</form>
<% 
boolean delete = (Boolean)renderRequest.getAttribute("delete") == null ? true : (Boolean)renderRequest.getAttribute("delete");
if (!delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-rang-buoc'/>");
	</script>
<%	
}
%>