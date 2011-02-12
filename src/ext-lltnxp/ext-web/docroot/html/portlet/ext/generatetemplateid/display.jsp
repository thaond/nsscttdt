<%@ include file="/html/portlet/ext/generatetemplateid/init.jsp" %>

<%@page import="com.sgs.portlet.generatetemplateid.model.IdTemplate"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.generatetemplateid.model.impl.IdTemplateImpl"%>
<%@page import="com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.sgs.portlet.generatetemplateid.search.GenerateTemplateIdSearch"%>
<%@page import="com.sgs.portlet.generatetemplateid.search.GenerateTemplateIdSearchTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<script type="text/javascript">

	function deleteGeneratedTemplate(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />frm.method = "post";
			submitForm(document.<portlet:namespace />frm, url);
		}
	}

</script>

<portlet:renderURL var="add">
	<portlet:param name="tab" value="add_edit"/>
	<portlet:param name="struts_action" value="/sgs/generatetemplateid/view"/>
</portlet:renderURL>

<%

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/generatetemplateid/view");
    
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />frm" >
<div class="title_categ"><liferay-ui:message key="generate-template-id"/></div>
<div class="boxcontent">	
	<%
		GenerateTemplateIdSearch generateTemplateIdSearch = new GenerateTemplateIdSearch(renderRequest, portletURL);
		GenerateTemplateIdSearchTerms searchTerms = (GenerateTemplateIdSearchTerms)generateTemplateIdSearch.getSearchTerms();
	%>
	
		<liferay-ui:search-form
		page="/html/portlet/ext/generatetemplateid/search_form.jsp"
		searchContainer="<%= generateTemplateIdSearch %>" />
		<span onclick="javascript:submitForm(document.hrefFm,'<%= add %>');">
			<input class="button-width" type="button" value='<liferay-ui:message key="add_new" />'/>
		</span>
	<%
			List<IdTemplate> results = null;
			int total = 0;
				
			if (searchTerms.isAdvancedSearch()) {
				results = IdTemplateLocalServiceUtil.search(searchTerms.getDinhDang(),searchTerms.getMoTa(),searchTerms.isAndOperator(),
															generateTemplateIdSearch.getStart(), generateTemplateIdSearch.getEnd(),generateTemplateIdSearch.getOrderByComparator());
			} else {
				results = IdTemplateLocalServiceUtil.search(searchTerms.getKeywords(),generateTemplateIdSearch.getStart(),
															generateTemplateIdSearch.getEnd(),generateTemplateIdSearch.getOrderByComparator());
			}
			generateTemplateIdSearch.setResults(results);
			if (searchTerms.isAdvancedSearch()) {
				total = IdTemplateLocalServiceUtil.searchCount(searchTerms.getDinhDang(),searchTerms.getMoTa(),searchTerms.isAndOperator());
			} else {
				total = IdTemplateLocalServiceUtil.searchCount(searchTerms.getKeywords());
			}
			generateTemplateIdSearch.setTotal(total);
			portletURL.setParameter(generateTemplateIdSearch.getCurParam(), String.valueOf(generateTemplateIdSearch.getCurValue()));
		%>
		
		<%
		 	List resultRows = generateTemplateIdSearch.getResultRows();
			ResultRow row = null;
			IdTemplate idTemplate = null;
			String deleteAction = "";
			String update = "";
			
			for (int i= 0; i<results.size(); i++) {
				idTemplate = results.get(i);
				row = new ResultRow(idTemplate, idTemplate.getTemplateId(), i);
				
				//URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter("struts_action","/sgs/generatetemplateid/view");
				rowURLEdit.setParameter("templateId",String.valueOf(idTemplate.getTemplateId()));
				rowURLEdit.setParameter("tab","add_edit");
		
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action","/sgs/generatetemplateid/view");
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("templateId",String.valueOf(idTemplate.getTemplateId()));
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				deleteAction = "<a  href='javascript: ;'  onclick=deleteGeneratedTemplate('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				//STT
				row.addText(String.valueOf(i+1));
				//Ma
				row.addText(idTemplate.getFormat());
				//row.addText("");
				//Mo ta
				row.addText(idTemplate.getDescription());
				//sua
				row.addText(update);
				//xoa
				row.addText(deleteAction);
				
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%=generateTemplateIdSearch %>" />
</div>
</form>
<% 
Boolean delete = (Boolean) renderRequest.getAttribute("delete");
if (delete != null && !delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-rang-buoc'/>");
	</script>
<%	
}
%>
