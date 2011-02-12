<%@ include file="/html/portlet/ext/documentrecordtype/init.jsp" %>

<%@page import="com.sgs.portlet.documentrecordtype.search.PmlEdmDocumentRecordTypeSearch"%>
<%@page import="com.sgs.portlet.documentrecordtype.search.PmlEdmDocumentRecordTypeSearchTerms"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.PmlEdmDocumentRecordTypeCanNotDeleteException"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-util:include page="/html/portlet/ext/documentrecordtype/js/pccc-docreceipt.jsp"></liferay-util:include>

<script type="text/javascript">

	function addPmlEdmDocumentRecordType(url) {	
		var valueName =  document.getElementById("<portlet:namespace/>recordname").value;
		var valueCode =  document.getElementById("<portlet:namespace/>recordcode").value;
		if (valueCode.trim () == "") {
			alert('<liferay-ui:message key="vui-long-nhap-documenttype-code"/>');
			document.getElementById("<portlet:namespace/>recordcode").focus();
		} else if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>recordname").focus();
		}
		// vu update 20111801
		// ky hieu loai van ban co the trung
		/*
		else if (checkDRTCode(valueCode)) {
			 alert('<liferay-ui:message key="ky-hieu-loai-van-ban-bi-trung"/>');
			 document.getElementById("<portlet:namespace/>recordcode").focus();
		}
		*/
		// end vu update
		else {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	
</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentrecordtype/view");
%>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<div class="title_categ"><liferay-ui:message key="document-record-type"/></div>
	<div class="boxcontent documentrecord">
	<input name="<portlet:namespace />documentRecordTypeURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= PmlEdmDocumentRecordTypeCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<%
		PmlEdmDocumentRecordTypeSearch pmlEdmDocumentRecordTypeSearch   = new PmlEdmDocumentRecordTypeSearch(renderRequest, portletURL);
		PmlEdmDocumentRecordTypeSearchTerms searchTerms = (PmlEdmDocumentRecordTypeSearchTerms) pmlEdmDocumentRecordTypeSearch.getSearchTerms();

	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/documentrecordtype/search_form.jsp"
		searchContainer="<%= pmlEdmDocumentRecordTypeSearch %>" />
	<div id="separator"></div>
	<portlet:actionURL var="add">
		<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
		<portlet:param name="struts_action" value="/sgs/documentrecordtype/view" />
		<portlet:param name="redirect" value="<%= pmlEdmDocumentRecordTypeSearch.getIteratorURL().toString() %>" />
	</portlet:actionURL>
	
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="add-documentrecord" /></label>
		<table cellspacing="0" width="100%">
			<tr>
				<td width="8%"><label><liferay-ui:message key="recordtype.code" /><font color="#FF0000" size="1">(*)</font>:&nbsp;</label></td>
				<td width="20%">
					<input id="<portlet:namespace/>recordcode" name="<portlet:namespace/>recordcode" style="width: 90%" type="text" value="" />
				</td>
					
				<td width="18%"><label><liferay-ui:message key="ten-loai-so-cong-van" /><font color="#FF0000" size="1">(*)</font>:&nbsp;</label></td>
				<td width="40%">
					<input id="<portlet:namespace/>recordname" name="<portlet:namespace/>recordname" style="width: 95%" type="text" value="" />
				</td>
				<td>
					<input onclick="addPmlEdmDocumentRecordType('<%= add %>')" id="addButton" type="button" value='<liferay-ui:message key="save"/>' />		
				</td>
			</tr>
		</table>	
	</fieldset>
	<%
		List<PmlEdmDocumentRecordType> results = new ArrayList<PmlEdmDocumentRecordType>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlEdmDocumentRecordTypeLocalServiceUtil.search(
					searchTerms.getPmlEdmDocumentRecordTypeCode(), 
					searchTerms.getPmlEdmDocumentRecordTypeName(),
					searchTerms.isAndOperator(), 
					pmlEdmDocumentRecordTypeSearch.getStart(), 
					pmlEdmDocumentRecordTypeSearch.getEnd(),
					pmlEdmDocumentRecordTypeSearch.getOrderByComparator());
			
			total = PmlEdmDocumentRecordTypeLocalServiceUtil.searchCount(
					searchTerms.getPmlEdmDocumentRecordTypeCode(),
					searchTerms.getPmlEdmDocumentRecordTypeName(),
					searchTerms.isAndOperator());
		}
		else {
			results = PmlEdmDocumentRecordTypeLocalServiceUtil.search(searchTerms.getKeywords(),
					pmlEdmDocumentRecordTypeSearch.getStart(),
					pmlEdmDocumentRecordTypeSearch.getEnd(), 
					pmlEdmDocumentRecordTypeSearch.getOrderByComparator());
			
			total = PmlEdmDocumentRecordTypeLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		pmlEdmDocumentRecordTypeSearch.setTotal(total);
		
		pmlEdmDocumentRecordTypeSearch.setResults(results);
		
		portletURL.setParameter(pmlEdmDocumentRecordTypeSearch.getCurParam(),
					String.valueOf(pmlEdmDocumentRecordTypeSearch.getCurValue()));
	%>
	
	<div id="separator"></div>
	
	<%
	
		
	
		List resultRows = pmlEdmDocumentRecordTypeSearch.getResultRows();
	
		PmlEdmDocumentRecordType pmlEdmDocumentRecordType  = null;
		
		ResultRow row = null;	
		
		int pmlEdmDocumentRecordTypeId  = 0;
		
		
		for (int i = 0; i < results.size(); i ++) {
			pmlEdmDocumentRecordType = results.get(i);
			pmlEdmDocumentRecordTypeId = pmlEdmDocumentRecordType.getDocumentRecordTypeId();			
			row = new ResultRow(pmlEdmDocumentRecordType, pmlEdmDocumentRecordTypeId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma so
			
			StringBuilder pmlEdmDocumentRecordTypeCode = new StringBuilder();
			
			pmlEdmDocumentRecordTypeCode.append("<div id=\"");
			pmlEdmDocumentRecordTypeCode.append("code".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeCode.append("\">");
			pmlEdmDocumentRecordTypeCode.append(pmlEdmDocumentRecordType.getDocumentRecordTypeCode());
			pmlEdmDocumentRecordTypeCode.append("</div>");		
			pmlEdmDocumentRecordTypeCode.append("<div id=\"");
			pmlEdmDocumentRecordTypeCode.append("editCode".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeCode.append("\" style=\"display: none;\" >");
			pmlEdmDocumentRecordTypeCode.append("<input name=\"");
			pmlEdmDocumentRecordTypeCode.append("documentRecordTypeCode_".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeCode.append("\" style=\"width: 90%\"");
			pmlEdmDocumentRecordTypeCode.append(" id=\"");
			pmlEdmDocumentRecordTypeCode.append("hiddenCode".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeCode.append("\" type=\"text\"");
			pmlEdmDocumentRecordTypeCode.append(" value=\"");
			pmlEdmDocumentRecordTypeCode.append(pmlEdmDocumentRecordType.getDocumentRecordTypeCode());
			pmlEdmDocumentRecordTypeCode.append("\" /> </div>");
						
			row.addText(pmlEdmDocumentRecordTypeCode.toString());
			
			// ten loai so cong van
			StringBuilder pmlEdmDocumentRecordTypeName = new StringBuilder();
			
			pmlEdmDocumentRecordTypeName.append("<div id=\"");
			pmlEdmDocumentRecordTypeName.append("name".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeName.append("\">");
			pmlEdmDocumentRecordTypeName.append(pmlEdmDocumentRecordType.getDocumentRecordTypeName());
			pmlEdmDocumentRecordTypeName.append("</div>");		
			pmlEdmDocumentRecordTypeName.append("<div id=\"");
			pmlEdmDocumentRecordTypeName.append("editName".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeName.append("\" style=\"display: none;\" >");
			pmlEdmDocumentRecordTypeName.append("<input name=\"");
			pmlEdmDocumentRecordTypeName.append("documentRecordTypeName_".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeName.append("\" style=\"width: 90%\"");
			pmlEdmDocumentRecordTypeName.append(" id=\"");
			pmlEdmDocumentRecordTypeName.append("hidden".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			pmlEdmDocumentRecordTypeName.append("\" type=\"text\"");
			pmlEdmDocumentRecordTypeName.append(" value=\"");
			pmlEdmDocumentRecordTypeName.append(pmlEdmDocumentRecordType.getDocumentRecordTypeName());
			pmlEdmDocumentRecordTypeName.append("\" </div>");
						
			row.addText(pmlEdmDocumentRecordTypeName.toString());
			
			
			// sua  hoac xoa
			PortletURL deleteURL = renderResponse.createActionURL();
			deleteURL.setParameter(Constants.ACTION, Constants.DELETE);
			deleteURL.setParameter("pmlEdmDocumentRecordTypeId", String.valueOf(pmlEdmDocumentRecordTypeId));
			deleteURL.setParameter("struts_action", "/sgs/documentrecordtype/view");
			deleteURL.setParameter("redirect",  pmlEdmDocumentRecordTypeSearch.getIteratorURL().toString());
			
			PortletURL updateURL = renderResponse.createActionURL();
			updateURL.setParameter(Constants.ACTION, Constants.UPDATE);
			updateURL.setParameter("pmlEdmDocumentRecordTypeId", String.valueOf(pmlEdmDocumentRecordTypeId));
			updateURL.setParameter("struts_action", "/sgs/documentrecordtype/view");
			updateURL.setParameter("redirect",  pmlEdmDocumentRecordTypeSearch.getIteratorURL().toString());
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editDocumentRecordType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentRecordTypeId));
			editOrDelete.append("'); \"/>");
			
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"deletteDocumentRecordType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentRecordTypeId));
			editOrDelete.append("', '");
			editOrDelete.append(deleteURL.toString());			
			editOrDelete.append("');\"/>");
			editOrDelete.append("</div>");
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(String.valueOf(pmlEdmDocumentRecordTypeId)));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updateDocumentRecordType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentRecordTypeId));
			editOrDelete.append("', '");
			editOrDelete.append(updateURL.toString());	
			editOrDelete.append("');\"/>");
			
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentRecordTypeId));
			editOrDelete.append("');\"/>");
			editOrDelete.append("</div>");
			row.addText(editOrDelete.toString());			
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pmlEdmDocumentRecordTypeSearch %>" />
		</fieldset>
</div>
</form>

