<%@ include file="/html/portlet/ext/documenttype/init.jsp" %>

<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl"%>
<%@page import="com.sgs.portlet.document.receipt.PmlEdmDocumentTypeCanNotDeleteException"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.documenttype.search.PmlEdmDocumentTypeSearch"%>
<%@page import="com.sgs.portlet.documenttype.search.PmlEdmDocumentTypeSearchTerms"%>

<liferay-util:include page="/html/portlet/ext/documenttype/js/doc_type.jsp"></liferay-util:include>
<script type="text/javascript">

	function addPmlEdmDocumentType(url) {	
		var valueName =  document.getElementById("<portlet:namespace/>documentTypeNameAdd").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>documentTypeNameAdd").focus();
		} else {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}


</script>

<%
	List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = (List<PmlEdmDocumentRecordType>) renderRequest.getAttribute("pmlEdmDocumentRecordTypeList");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documenttype/view");
%>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<input name="<portlet:namespace />documentTypeURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= PmlEdmDocumentTypeCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<div class="title_categ"><liferay-ui:message key="document-type"/></div>
	<div class="boxcontent documenttypeCSS">
	<%
		PmlEdmDocumentTypeSearch pmlEdmDocumentTypeSearch   = new PmlEdmDocumentTypeSearch(renderRequest, portletURL);
		PmlEdmDocumentTypeSearchTerms searchTerms = (PmlEdmDocumentTypeSearchTerms) pmlEdmDocumentTypeSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/documenttype/search_form.jsp"
		searchContainer="<%= pmlEdmDocumentTypeSearch %>" />
		
	<div id="separator"></div>
	
	
	<portlet:actionURL var="add">
		<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
		<portlet:param name="struts_action" value="/sgs/documenttype/view" />
		<portlet:param name="redirect" value="<%= pmlEdmDocumentTypeSearch.getIteratorURL().toString() %>" />
	</portlet:actionURL>
	
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="add-documenttype" /></legend>
		
		<table cellspacing="0" width="100%">
			<tr>
				<td width="10%"><label><liferay-ui:message key="recordtype.code" />:&nbsp;</label></td>
				<td width="10%">
					<input id="<portlet:namespace/>symbol" name="<portlet:namespace/>symbol" style="width: 85%" type="text" value="" />
				</td>
				
				<td width="19%" align="right"><label><liferay-ui:message key="ten-loai-cong-van" /><font size="1"  color="#ff0000">(*)</font>:&nbsp;</label></td>
				<td  width="20%">
					<input id="<portlet:namespace/>documentTypeNameAdd" name="<portlet:namespace/>documentTypeNameAdd" style="width: 90%" type="text" value="" />
				</td>
					
				<td width="19%" align="right"><label><liferay-ui:message key="ten-loai-so-cong-van" />:&nbsp;</label></td>
				<td  width="20%">
					<select style="width: 93%" id="documentRecordTypeNameAdd" name="<portlet:namespace/>documentRecordTypeNameAdd">						
						<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
							<option  value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId()%>" id="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId()%>">
								<%=pmlEdmDocumentRecordType.getDocumentRecordTypeName() %>
							</option>											
						</logic:iterate>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><label><liferay-ui:message key="su-dung-cho" />:&nbsp;</label></td>
				<td>
					<select id="sendReceiptDistinctionAdd" name="<portlet:namespace/>sendReceiptDistinctionAdd">	
						<option value="3"><liferay-ui:message key="cong-van-den-va-di"/></option>
						<option value="1"><liferay-ui:message key="cong-van-den"/></option>
						<option value="2"><liferay-ui:message key="cong-van-di"/></option>
					</select>
				</td>
				
				<td align="right"><label><liferay-ui:message key="co-gan-phan-mo-rong" />:&nbsp;</label></td>
				<td >
					 <input name="<portlet:namespace />haveDepartExtendsAdd" type="checkbox" checked="checked" id="haveDepartExtendsAdd" />
				</td>
			</tr>
			
			<tr>
				<td>
					<input onclick="addPmlEdmDocumentType('<%= add %>')" id="addButton" type="button" value='<liferay-ui:message key="save"/>' />		
				</td>
			</tr>
		</table>	
	</fieldset>
	
	<%
		List<PmlEdmDocumentType> results = new ArrayList<PmlEdmDocumentType>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlEdmDocumentTypeLocalServiceUtil.search(
					searchTerms.getPmlEdmDocumentTypeName(), 
					searchTerms.getPmlEdmDocumentRecordTypeName(),
					searchTerms.isAndOperator(), 
					pmlEdmDocumentTypeSearch.getStart(), 
					pmlEdmDocumentTypeSearch.getEnd(),
					pmlEdmDocumentTypeSearch.getOrderByComparator());
			
			total = PmlEdmDocumentTypeLocalServiceUtil.searchCount(
					searchTerms.getPmlEdmDocumentTypeName(),
					searchTerms.getPmlEdmDocumentRecordTypeName(),
					searchTerms.isAndOperator());
		}
		else {
			results = PmlEdmDocumentTypeLocalServiceUtil.search(searchTerms.getKeywords(),
					pmlEdmDocumentTypeSearch.getStart(),
					pmlEdmDocumentTypeSearch.getEnd(), 
					pmlEdmDocumentTypeSearch.getOrderByComparator());
			
			total = PmlEdmDocumentTypeLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		pmlEdmDocumentTypeSearch.setTotal(total);
		
		pmlEdmDocumentTypeSearch.setResults(results);
		
		portletURL.setParameter(pmlEdmDocumentTypeSearch.getCurParam(),
					String.valueOf(pmlEdmDocumentTypeSearch.getCurValue()));
	%>
	
	<div id="separator"></div>
	
	<%
		List resultRows = pmlEdmDocumentTypeSearch.getResultRows();
	
		PmlEdmDocumentType pmlEdmDocumentType  = null;
		
		ResultRow row = null;	
		
		long pmlEdmDocumentTypeId  = 0;
		
		
		for (int i = 0; i < results.size(); i ++) {
			pmlEdmDocumentType = results.get(i);
			pmlEdmDocumentTypeId = pmlEdmDocumentType.getDocumentTypeId();			
			row = new ResultRow(pmlEdmDocumentType, pmlEdmDocumentTypeId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma so
			//row.addText(pmlEdmDocumentType.getDocumentSymbol());
			StringBuilder pmlEdmDocumentTypeSymbol = new StringBuilder();
			
			pmlEdmDocumentTypeSymbol.append("<div id=\"");
			pmlEdmDocumentTypeSymbol.append("documentTypeSymbol".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeSymbol.append("\">");
			pmlEdmDocumentTypeSymbol.append(pmlEdmDocumentType.getDocumentSymbol());
			pmlEdmDocumentTypeSymbol.append("</div>");		
			pmlEdmDocumentTypeSymbol.append("<div id=\"");
			pmlEdmDocumentTypeSymbol.append("editDocumentTypeSymbol".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeSymbol.append("\" style=\"display: none;\" >");
			pmlEdmDocumentTypeSymbol.append("<input name=\"");
			pmlEdmDocumentTypeSymbol.append("documentTypeSymbol_".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeSymbol.append("\" style=\"width: 90%\"");
			pmlEdmDocumentTypeSymbol.append(" id=\"");
			pmlEdmDocumentTypeSymbol.append("hiddenDocumentTypeSymbol".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeSymbol.append("\" type=\"text\"");
			pmlEdmDocumentTypeSymbol.append(" value=\"");
			pmlEdmDocumentTypeSymbol.append(pmlEdmDocumentType.getDocumentSymbol());
			pmlEdmDocumentTypeSymbol.append("\"/> </div>");
						
			row.addText(pmlEdmDocumentTypeSymbol.toString());
			
			// ten loai cong van
			
			StringBuilder pmlEdmDocumentTypeName = new StringBuilder();
			
			pmlEdmDocumentTypeName.append("<div id=\"");
			pmlEdmDocumentTypeName.append("documentTypeName".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeName.append("\">");
			pmlEdmDocumentTypeName.append(pmlEdmDocumentType.getDocumentTypeName());
			pmlEdmDocumentTypeName.append("</div>");		
			pmlEdmDocumentTypeName.append("<div id=\"");
			pmlEdmDocumentTypeName.append("editDocumentTypeName".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeName.append("\" style=\"display: none;\" >");
			pmlEdmDocumentTypeName.append("<input name=\"");
			pmlEdmDocumentTypeName.append("documentTypeCode_".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeName.append("\" style=\"width: 90%\"");
			pmlEdmDocumentTypeName.append(" id=\"");
			pmlEdmDocumentTypeName.append("hiddenDocumentName".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentTypeName.append("\" type=\"text\"");
			pmlEdmDocumentTypeName.append(" value=\"");
			pmlEdmDocumentTypeName.append(pmlEdmDocumentType.getDocumentTypeName());
			pmlEdmDocumentTypeName.append("\"/> </div>");
						
			row.addText(pmlEdmDocumentTypeName.toString());
			
			// ten loai so cong van
			String  documentRecordTypeName = "";
			PmlEdmDocumentRecordType documentRecordType = null;
			try {
				documentRecordType = 
					PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(pmlEdmDocumentType.getDocumentRecordTypeId());
				documentRecordTypeName = documentRecordType.getDocumentRecordTypeName();
			} catch (Exception e) {
				documentRecordType = new PmlEdmDocumentRecordTypeImpl();
			}
			
			StringBuilder pmlEdmDocumentRecordTypeName = new StringBuilder();
			
			pmlEdmDocumentRecordTypeName.append("<div id=\"");
			pmlEdmDocumentRecordTypeName.append("documentRecordTypeName".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentRecordTypeName.append("\">");
			pmlEdmDocumentRecordTypeName.append(documentRecordTypeName);
			pmlEdmDocumentRecordTypeName.append("</div>");	
			
			pmlEdmDocumentRecordTypeName.append("<div id=\"");
			pmlEdmDocumentRecordTypeName.append("editDocumentRecordTypeName".concat(String.valueOf(pmlEdmDocumentTypeId)));
			pmlEdmDocumentRecordTypeName.append("\" style=\"display: none;\" >");
			pmlEdmDocumentRecordTypeName.append("<select id=\"hiddenDocumentRecordName"); 
			pmlEdmDocumentRecordTypeName.append(String.valueOf(pmlEdmDocumentTypeId));
			pmlEdmDocumentRecordTypeName.append("\" name=\"hiddenDocumentRecordName_");
			pmlEdmDocumentRecordTypeName.append(String.valueOf(pmlEdmDocumentTypeId));
			pmlEdmDocumentRecordTypeName.append("\" style=\"width: 90%\"");
			pmlEdmDocumentRecordTypeName.append("\" >");
			for (PmlEdmDocumentRecordType pmlEdmDocumentRecordType : pmlEdmDocumentRecordTypeList) {
				pmlEdmDocumentRecordTypeName.append("<option");
				
				pmlEdmDocumentRecordTypeName.append(pmlEdmDocumentRecordType.getDocumentRecordTypeId() == documentRecordType.getDocumentRecordTypeId() ? " selected " : " ");
				pmlEdmDocumentRecordTypeName.append(" value=\"" + pmlEdmDocumentRecordType.getDocumentRecordTypeId() + "\">");
				pmlEdmDocumentRecordTypeName.append(pmlEdmDocumentRecordType.getDocumentRecordTypeName());
				pmlEdmDocumentRecordTypeName.append("</option>");
			}
			pmlEdmDocumentRecordTypeName.append("</select >");	
			pmlEdmDocumentRecordTypeName.append(" </div>");
						
			row.addText(pmlEdmDocumentRecordTypeName.toString());
			
			// phmphuc them 11/11/2010 - doi tuong su dung loai van ban
			//su dung cho
			String pmlSendReceiptDistincion = String.valueOf(pmlEdmDocumentType.getSendReceiptDistinction());
			StringBuilder sendReceiptDistinction = new StringBuilder();
			sendReceiptDistinction.append("<div id=\"");
			sendReceiptDistinction.append("sendReceiptDistinction".concat(String.valueOf(pmlEdmDocumentTypeId)));
			sendReceiptDistinction.append("\">");
			if(pmlSendReceiptDistincion.equals("1")) {
				sendReceiptDistinction.append("V\u0103n b\u1ea3n \u0111\u1ebfn");
			}
			else if(pmlSendReceiptDistincion.equals("2")) {
				sendReceiptDistinction.append("V\u0103n b\u1ea3n \u0111i");
			}
			else if(pmlSendReceiptDistincion.equals("3")) {
				sendReceiptDistinction.append("V\u0103n b\u1ea3n \u0111\u1ebfn v\u00e0 \u0111i");
			}
			sendReceiptDistinction.append("</div>");
			
			sendReceiptDistinction.append("<div id=\"");
			sendReceiptDistinction.append("editSendReceiptDistinction".concat(String.valueOf(pmlEdmDocumentTypeId)));
			sendReceiptDistinction.append("\" style=\"display: none;\" >");
			sendReceiptDistinction.append("<select id=\"hiddenSendReceiptDistinction"); 
			sendReceiptDistinction.append(String.valueOf(pmlEdmDocumentTypeId));
			sendReceiptDistinction.append("\" name=\"hiddenSendReceiptDistinction_".concat(String.valueOf(pmlEdmDocumentTypeId)));
			sendReceiptDistinction.append("\" style=\"width: 90%\"");
			sendReceiptDistinction.append("\" >");
			
			sendReceiptDistinction.append("<option ");
			sendReceiptDistinction.append(pmlEdmDocumentType.getSendReceiptDistinction() == 1 ? " selected " : " ");
			sendReceiptDistinction.append("value=\"1\">V\u0103n b\u1ea3n \u0111\u1ebfn</option>");
			sendReceiptDistinction.append("<option ");
			sendReceiptDistinction.append(pmlEdmDocumentType.getSendReceiptDistinction() == 2 ? " selected " : " ");
			sendReceiptDistinction.append("value=\"2\">V\u0103n b\u1ea3n \u0111i</option>");
			sendReceiptDistinction.append("<option ");
			sendReceiptDistinction.append(pmlEdmDocumentType.getSendReceiptDistinction() == 3 ? " selected " : " ");
			sendReceiptDistinction.append("value=\"3\">V\u0103n b\u1ea3n \u0111\u1ebfn v\u00e0 \u0111i</option>");
			sendReceiptDistinction.append("</select >");	
			sendReceiptDistinction.append(" </div>");
			row.addText(sendReceiptDistinction.toString());
			// end phmphuc them 11/11/2010
			
			// phmphuc them 30/11/2010 - gan phan mo rong cua phong ban
			StringBuilder haveDepartExtends = new StringBuilder();
			haveDepartExtends.append("<div id=\"");
			haveDepartExtends.append("haveDepartExtends".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\">");
			haveDepartExtends.append("<input name=\"");
			haveDepartExtends.append("haveDepartExtends".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\" id=\"");
			haveDepartExtends.append("haveDepartExtends".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\" type=\"checkbox\"");
			haveDepartExtends.append(pmlEdmDocumentType.getHaveDepartExtends() == true ? "checked=checked" : "");
			haveDepartExtends.append("\" disabled=\"true\"/> </div>");

			haveDepartExtends.append("<div id=\"");
			haveDepartExtends.append("editHaveDepartExtends".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\" style=\"display: none;\" >");
			haveDepartExtends.append("<input name=\"");
			haveDepartExtends.append("hiddenHaveDepartExtends_".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\" id=\"");
			haveDepartExtends.append("hiddenHaveDepartExtends".concat(String.valueOf(pmlEdmDocumentTypeId)));
			haveDepartExtends.append("\" type=\"checkbox\"");
			haveDepartExtends.append(pmlEdmDocumentType.getHaveDepartExtends() == true ? "checked=checked" : "");
			haveDepartExtends.append("/> </div>");
			row.addText("center", "", haveDepartExtends.toString());
			// end phmphuc them 30/11/2010
			
			// sua hoac xoa
			PortletURL deleteURL = renderResponse.createActionURL();
			deleteURL.setParameter(Constants.ACTION, Constants.DELETE);
			deleteURL.setParameter("pmlEdmDocumentTypeId", String.valueOf(pmlEdmDocumentTypeId));
			deleteURL.setParameter("struts_action", "/sgs/documenttype/view");
			deleteURL.setParameter("redirect",  pmlEdmDocumentTypeSearch.getIteratorURL().toString());
			
			PortletURL updateURL = renderResponse.createActionURL();
			updateURL.setParameter(Constants.ACTION, Constants.UPDATE);
			updateURL.setParameter("pmlEdmDocumentTypeId", String.valueOf(pmlEdmDocumentTypeId));
			updateURL.setParameter("struts_action", "/sgs/documenttype/view");
			updateURL.setParameter("redirect",  pmlEdmDocumentTypeSearch.getIteratorURL().toString());
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(String.valueOf(pmlEdmDocumentTypeId)));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editDocumentType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentTypeId));
			editOrDelete.append("'); \"/>");
			editOrDelete.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"deletteDocumentType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentTypeId));
			editOrDelete.append("', '");
			editOrDelete.append(deleteURL.toString());			
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(String.valueOf(pmlEdmDocumentTypeId)));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updateDocumentType('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentTypeId));
			editOrDelete.append("', '");
			editOrDelete.append(updateURL.toString());	
			editOrDelete.append("');\"/>");
			editOrDelete.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(String.valueOf(pmlEdmDocumentTypeId));
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			  
			row.addText(editOrDelete.toString());			
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pmlEdmDocumentTypeSearch %>" />
</div>
</form>
