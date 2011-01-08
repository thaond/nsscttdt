<%@ include file="/html/portlet/ext/geneatedocumentcode/init.jsp" %>


<%@page import="com.sgs.portlet.generatetemplateid.model.IdTemplate"%>
<%@page import="com.sgs.portlet.generatetemplateid.service.persistence.IdTemplateUtil"%>

<%@page import="com.sgs.portlet.geneatedocumentcode.search.GenerateDocumentCodeSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.generatetemplateid.model.IdGenerated"%>
<%@page import="com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/geneatedocumentcode/js/idGenerated.jsp"></liferay-util:include>

<script type="text/javascript">

	function deleteGeneratedCode(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />frm.method = "post";
			submitForm(document.<portlet:namespace />frm, url);
		}
	}

	function checkListIdTemplate(url){
		var list = document.getElementById("listIdTemplate");
		var listTrim = list.value.trim();
		if ( listTrim == "") {
			alert("<liferay-ui:message key='khong-the-them-moi-vi-khong-con-mau-phat-sinh-ma'/>");
			return false;
		} else {
			submitForm(document.<portlet:namespace />frm, url);
		}
	}

</script>
<portlet:renderURL var="add">
	<portlet:param name="struts_action" value="/sgs/geneatedocumentcode/view"/>
	<portlet:param name="tab" value="add_new"/>
</portlet:renderURL>

<%
	String listIdTemplate = (String) renderRequest.getAttribute("listIdTemplate") == null ? "" : (String)renderRequest.getAttribute("listIdTemplate");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/geneatedocumentcode/view");
%>

	
<form action="<%=portletURL.toString() %>" method="post" name="<portlet:namespace/>frm">
<div class="title_categ"><liferay-ui:message key="generate-document-code"/></div>
<div class="boxcontent">
	<input type="hidden" name="listIdTemplate" id="listIdTemplate" value="<%= listIdTemplate %>">
		<input class="button-width" type="button" id="add" onclick="checkListIdTemplate('<%=add %>')" value='<liferay-ui:message key="add_new"/>'/>
	<%
	
		GenerateDocumentCodeSearch codeSearch = new GenerateDocumentCodeSearch(renderRequest,portletURL);
	
		List<IdGenerated> results = IdGeneratedLocalServiceUtil.search(codeSearch.getStart(), codeSearch.getEnd());
		int total = IdGeneratedLocalServiceUtil.searchCount();
		
		codeSearch.setResults(results);
		codeSearch.setTotal(total);
		
		portletURL.setParameter(codeSearch.getCurParam(), String.valueOf(codeSearch.getCurValue()));
		
		List resultRows = codeSearch.getResultRows();
		ResultRow row = null;
		IdGenerated idGenerated = null;
		IdTemplate idTemplate = null;
		String update = "";
		String deleteAction = "";
		
		for ( int i=0; i<results.size(); i++){
			idGenerated = results.get(i);
			row = new ResultRow(idGenerated, idGenerated.getId(), i);
			
			try {
				idTemplate = IdTemplateLocalServiceUtil.getIdTemplate(idGenerated.getId());
			} catch (Exception e) {
				
			}
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/geneatedocumentcode/view");
			rowURLEdit.setParameter("generateId",String.valueOf(idGenerated.getId()));
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/geneatedocumentcode/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("generateId",String.valueOf(idGenerated.getId()));
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteGeneratedCode('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			//STT
			row.addText(String.valueOf(i+1));
			//year
			row.addText(idGenerated.getYear());
			//number
			row.addText(String.valueOf(idGenerated.getCurValue()));
			//temple
			if ( null!= idTemplate) {
				row.addText(idTemplate.getFormat());
			} else {
				row.addText("");
			}
			//edit
			row.addText(update);
			//delete
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	
		<liferay-ui:search-iterator searchContainer="<%=codeSearch %>" />
	
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