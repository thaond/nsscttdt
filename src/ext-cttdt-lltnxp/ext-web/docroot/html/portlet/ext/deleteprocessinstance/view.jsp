<%@ include file="/html/portlet/ext/deleteprocessinstance/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>

<%@page import="com.sgs.portlet.deleteprocessinstance.search.DeleteDocumentSendUnpublishSearch"%>
<%@page import="com.sgs.portlet.deleteprocessinstance.search.DeleteDocumentSendUnpublishSearchTerms"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%
	PortletURL portletURL= renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/sgs/deleteprocessinstance/view");
	
	String portletURLString = portletURL.toString();
%>


<script type="text/javascript">

	function trim(str) {
		if (!str || !str.length) return '';
		var c = str.charCodeAt(0);
		while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
			str = str.substring(1);
			if (str.length > 0) c = str.charCodeAt(0);
		}
		if (str.length>0) {
			c = str.charCodeAt(str.length - 1);
			while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
				str = str.substring(0, str.length - 1);
				if (str.length > 0) c = str.charCodeAt(str.length - 1, 1);
			}
		}
		return str;
	}
	
	function deleteDocumentSend(idDocumentSend,url) {		
		if(trim(idDocumentSend) != null){
			if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>")) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deleteDocumentSendId.value = idDocumentSend;
				submitForm(document.<portlet:namespace />fm,url);
			}		
		}
	}

	function <portlet:namespace />deleteDocumentSends() {
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>")) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />redirect.value = document.<portlet:namespace />fm.<portlet:namespace />documentSendRedirect.value;
			document.<portlet:namespace />fm.<portlet:namespace />deleteDocumentSendIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm,
					 "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/deleteprocessinstance/view" /></portlet:actionURL>");
		}
	}
</script>

<div id="divparent">
<div class="HS-height">

<form action="<%= portletURLString %>" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />deleteDocumentSendIds" />
	<input type="hidden" name="<portlet:namespace />deleteDocumentSendId" />
	<input type="hidden" name="<portlet:namespace />redirect" value="<%= portletURLString  %>"/>
	<%
		DeleteDocumentSendUnpublishSearch searchContainer = new DeleteDocumentSendUnpublishSearch(renderRequest, portletURL);
		List headerNames = searchContainer.getHeaderNames();
	
		// Dat row dang checkbox
		searchContainer.setRowChecker(new RowChecker(renderResponse));
		
	%>
	<liferay-ui:search-form
		page="/html/portlet/ext/deleteprocessinstance/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
		
	<div class="separator"></div>
	<input type="button" value='<liferay-ui:message key="delete" />' onClick="<portlet:namespace />deleteDocumentSends()" />
	<br><br>
	<%
		DeleteDocumentSendUnpublishSearchTerms searchTerms = (DeleteDocumentSendUnpublishSearchTerms)searchContainer.getSearchTerms();
		List<PmlEdmDocumentSend> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlEdmDocumentSendLocalServiceUtil.findByLOAIVB_NGUOIKY(searchTerms.getLoaiVB(), searchTerms.getNguoiKy(), searchTerms.isAndOperator(),
						searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = PmlEdmDocumentSendLocalServiceUtil.countByLOAIVB_NGUOIKY(searchTerms.getLoaiVB(), searchTerms.getNguoiKy(), searchTerms.isAndOperator());
		} else {
			results = PmlEdmDocumentSendLocalServiceUtil.findByKeywords(searchTerms.getKeywords(), searchContainer.getStart(), searchContainer.getEnd(),
						searchContainer.getOrderByComparator());
			total = PmlEdmDocumentSendLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<input type="hidden" name="<portlet:namespace />documentSendRedirect" value="<%= portletURL.toString() %>" />
	<%	
		List resultRow = searchContainer.getResultRows();
		ResultRow row = null;
		PmlEdmDocumentSend documentSend = null;
		String deleteAction = "";
		
		for (int i=0; i < results.size(); i++) {
			documentSend = results.get(i);
			documentSend = documentSend.toEscapedModel();
			row = new ResultRow(documentSend, documentSend.getDocumentSendId(), i);
			
			//stt
			row.addText(String.valueOf(i+1));
			
			// loai cong van
			long pmlDocumentTypeId = documentSend.getDocumentTypeId();
			String nameDocumentType = "";
			try {
				PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlDocumentTypeId);
				nameDocumentType = pmlEdmDocumentType.getDocumentTypeName();
				row.addText(nameDocumentType);
			} catch (Exception ex){
				row.addText("");
			}
			
			// chi tiet
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("struts_action", "/sgs/deleteprocessinstance/detail");
			rowURL.setParameter("documentSendId", String.valueOf(documentSend.getDocumentSendId()));
			rowURL.setParameter("redirect",  searchContainer.getIteratorURL().toString());
			
			row.addText("Chi ti\u1ebft", rowURL);
			
			// nguoi ky
			row.addText(documentSend.getSignerName());
					
			// phong soan thao
			String nameDepartment = "";
			long editorId = documentSend.getEditorId();
			
			try {
				PmlUser userSend = PmlUserUtil.findByPrimaryKey(editorId);
				nameDepartment = DepartmentUtil.findByPrimaryKey(userSend.getDepartmentsId()).getDepartmentsName();
				row.addText(nameDepartment);
			} catch (Exception ex){
				row.addText("");
			}
			
			// trich yeu
			row.addText(documentSend.getBriefContent());
			
			// noi nhan cong van
			row.addText(documentSend.getReceivingPlace());
			
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.MAXIMIZED);
			rowURLDelete.setParameter("struts_action","/sgs/deleteprocessinstance/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("documentSendId", String.valueOf(documentSend.getDocumentSendId()));
			rowURLDelete.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			StringBuilder deleteString = new StringBuilder();
			
			deleteString.append("<img class=\"image-delete\" src=\"/html/images/xoa.gif\"");
			deleteString.append(" value='");
			deleteString.append(LanguageUtil.get(pageContext,"delete" ));
			deleteString.append("' onclick=\"deleteDocumentSend('");
			deleteString.append(String.valueOf(documentSend.getDocumentSendId()));
			deleteString.append("', '");			
			deleteString.append(rowURLDelete.toString());			
			deleteString.append("');\"/>");
			deleteString.append("</div>");
			
			row.addText(deleteString.toString());
			
			resultRow.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</form>
</div>
</div>





