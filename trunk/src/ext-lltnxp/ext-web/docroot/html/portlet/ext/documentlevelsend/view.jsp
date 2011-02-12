<%@ include file="/html/portlet/ext/documentlevelsend/init.jsp" %>
<%@ include file="/html/portlet/ext/documentlevelsend/js/doc_levelsend.jsp" %>


<%@page import="com.sgs.portlet.documentlevelsend.search.PmlEdmLevelSendSearch"%>
<%@page import="com.sgs.portlet.documentlevelsend.search.PmlEdmLevelSendSearchTerms"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.PmlEdmLevelSendCanNotDeleteException"%>

<script type="text/javascript">
	function addPmlEDMConfidentialLevel(url) {
		var tenCapGui = document.getElementById('<portlet:namespace/>tenCapGui');
		if (tenCapGui.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ten'/>")
			tenCapGui.focus();
			return false;
		}	
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentlevelsend/view");
	
	
%>
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<input name="<portlet:namespace />pmlLevelSendURL" type="hidden" value="<%= portletURL.toString() %>" />
	<div class="title_categ"><liferay-ui:message key="document-level-send"/></div>
	<div class="boxcontent documentlevelsend">
	<liferay-ui:error exception="<%= PmlEdmLevelSendCanNotDeleteException.class %>" message="can-not-delete-pml-tinh-chat" />
	<%
		PmlEdmLevelSendSearch  pmlEdmLevelSendSearch   = new PmlEdmLevelSendSearch(renderRequest, portletURL);
		PmlEdmLevelSendSearchTerms searchTerms = (PmlEdmLevelSendSearchTerms) pmlEdmLevelSendSearch.getSearchTerms();

	%>
	
	<label><liferay-ui:message key="document.level"/>:&nbsp;</label>
	<input name="<%= renderResponse.getNamespace() %><%= PmlEdmLevelSendSearchTerms.PMLEDMLEVELSEND_NAME %>" id="<portlet:namespace/>tenCapGui" style="width:60%;" type="text" value="<%= HtmlUtil.escape(searchTerms.getPmlEdmLevelSendName()) %>" />
	<input type="submit" class="button-width"  name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
	<portlet:actionURL var="add">
		<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
		<portlet:param name="struts_action" value="/sgs/documentlevelsend/view" />
		<portlet:param name="redirect" value="<%= pmlEdmLevelSendSearch.getIteratorURL().toString() %>" />
	</portlet:actionURL>
	<input onclick="addPmlEDMConfidentialLevel('<%= add %>')" id="addButton" type="button" value='<liferay-ui:message key="add_new"/>' />	
	<div id="separator"></div>
	
	<%
	
		int total = PmlEdmLevelSendLocalServiceUtil.searchCount(searchTerms.getPmlEdmLevelSendName());
		List<PmlEdmLevelSend> pmlEdmLevelSendList = PmlEdmLevelSendLocalServiceUtil.
			search(searchTerms.getPmlEdmLevelSendName(), pmlEdmLevelSendSearch.getStart(), 
					pmlEdmLevelSendSearch.getEnd(), pmlEdmLevelSendSearch.getOrderByComparator() );
	
	
		List<PmlEdmLevelSend> results = pmlEdmLevelSendList;
		
		pmlEdmLevelSendSearch.setTotal(total);
		
		pmlEdmLevelSendSearch.setResults(results);
		
		portletURL.setParameter(pmlEdmLevelSendSearch.getCurParam(), String.valueOf(pmlEdmLevelSendSearch.getCurValue()));
	
		List resultRows = pmlEdmLevelSendSearch.getResultRows();
	
		PmlEdmLevelSend pmlEdmLevelSend  = null;
		
		ResultRow row = null;	
		
		int pmlEdmLevelSendId  = 0;
		
		
		for (int i = 0; i < results.size(); i ++) {
			pmlEdmLevelSend = results.get(i);
			pmlEdmLevelSendId = pmlEdmLevelSend.getLevelSendId();
			
			row = new ResultRow(pmlEdmLevelSend, pmlEdmLevelSendId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma do mat 
			
			//row.addText(pmlEdmLevelSend.getLevelSendCode());
			
			// ten do mat
			StringBuilder pmlEdmLevelSendName = new StringBuilder();
			
			pmlEdmLevelSendName.append("<div id=\"");
			pmlEdmLevelSendName.append("name".concat(String.valueOf(pmlEdmLevelSendId)));
			pmlEdmLevelSendName.append("\">");
			pmlEdmLevelSendName.append(pmlEdmLevelSend.getLevelSendName());
			pmlEdmLevelSendName.append("</div>");		
			pmlEdmLevelSendName.append("<div id=\"");
			pmlEdmLevelSendName.append("editName".concat(String.valueOf(pmlEdmLevelSendId)));
			pmlEdmLevelSendName.append("\" style=\"display: none;\" >");
			pmlEdmLevelSendName.append("<input name=\"");
			pmlEdmLevelSendName.append("levelSendName_".concat(String.valueOf(pmlEdmLevelSendId)));
			pmlEdmLevelSendName.append("\" style=\"width: 95%\"");
			pmlEdmLevelSendName.append(" id=\"");
			pmlEdmLevelSendName.append("hidden".concat(String.valueOf(pmlEdmLevelSendId)));
			pmlEdmLevelSendName.append("\" type=\"text\"");
			pmlEdmLevelSendName.append(" value=\"");
			pmlEdmLevelSendName.append(pmlEdmLevelSend.getLevelSendName());
			pmlEdmLevelSendName.append("\" /> </div>");
						
			row.addText(pmlEdmLevelSendName.toString());
			
			
			// sua  hoac xoa
			PortletURL deleteURL = renderResponse.createActionURL();
			deleteURL.setParameter(Constants.ACTION, Constants.DELETE);
			deleteURL.setParameter("documentLevelSendId", String.valueOf(pmlEdmLevelSendId));
			deleteURL.setParameter("struts_action", "/sgs/documentlevelsend/view");
			deleteURL.setParameter("redirect",  pmlEdmLevelSendSearch.getIteratorURL().toString());
			
			PortletURL updateURL = renderResponse.createActionURL();
			updateURL.setParameter(Constants.ACTION, Constants.UPDATE);
			updateURL.setParameter("documentLevelSendId", String.valueOf(pmlEdmLevelSendId));
			updateURL.setParameter("struts_action", "/sgs/documentlevelsend/view");
			updateURL.setParameter("redirect",  pmlEdmLevelSendSearch.getIteratorURL().toString());
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(String.valueOf(pmlEdmLevelSendId)));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editPmlEdmLevelSend('");
			editOrDelete.append(String.valueOf(pmlEdmLevelSendId));
			editOrDelete.append("'); \"/>");
			
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"delettePmlEdmLevelSend('");
			editOrDelete.append(String.valueOf(pmlEdmLevelSendId));
			editOrDelete.append("', '");
			editOrDelete.append(deleteURL.toString());			
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(String.valueOf(pmlEdmLevelSendId)));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updatePmlEdmLevelSend('");
			editOrDelete.append(String.valueOf(pmlEdmLevelSendId));
			editOrDelete.append("', '");
			editOrDelete.append(updateURL.toString());	
			editOrDelete.append("');\"/>");
			
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(String.valueOf(pmlEdmLevelSendId));
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			  
			row.addText(editOrDelete.toString());			
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pmlEdmLevelSendSearch %>" />
		</fieldset>
</div>
</form>



