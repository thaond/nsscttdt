<%@ include file="/html/portlet/ext/issuingplace/init.jsp" %>

<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.issuingplace.search.IssuingPlaceSearch"%>
<%@page import="com.sgs.portlet.issuingplace.search.IssuingPlaceSearchTerms"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/ext/issuingplace/js/issuingplace.jsp"></liferay-util:include>
<script type="text/javascript">
	function addPmlEdmIssuingPlace(url) {	
		var valueName =  document.getElementById("<portlet:namespace/>issuingName").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>issuingName").focus();
		} else {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/issuingplace/view");
	
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace />pmlIssuingPlaceURL" type="hidden" value="<%= portletURL.toString() %>" />
	<div class="title_categ"><liferay-ui:message key="issuingplace"/></div>
	<div class="boxcontent issuingplace">
	<liferay-ui:error exception="<%= PmlEdmIssuingPlaceCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />	
	<%
		IssuingPlaceSearch issuingPlaceSearch = new IssuingPlaceSearch(renderRequest, portletURL);
		IssuingPlaceSearchTerms searchTerms = (IssuingPlaceSearchTerms) issuingPlaceSearch.getSearchTerms();
	%>
	<liferay-ui:search-form
		page="/html/portlet/ext/issuingplace/issuingplace_search.jsp"
		searchContainer="<%= issuingPlaceSearch %>" />
	<div id="separator"></div>

	<%
		//URL add issuing place
		PortletURL addIssuingPlace = renderResponse.createActionURL();
		addIssuingPlace.setWindowState(WindowState.NORMAL);
		addIssuingPlace.setParameter(Constants.CMD,Constants.ADD);
		addIssuingPlace.setParameter("struts_action","/sgs/issuingplace/view");
		addIssuingPlace.setParameter("redirect", issuingPlaceSearch.getIteratorURL().toString());
	%>
	
	<fieldset class="filborder">
		<legend class="laborder" ><liferay-ui:message key="add-issuingplace" /></legend>
		<table cellspacing="0" width="100%">
			<tr>
				<td width="18%"><label><liferay-ui:message key="issuing-place-ten-don-vi-lien-quan" /><font color="#FF0000" size="1">(*)</font>:&nbsp;</label></td>
				<td  width="35%">
					<input id="<portlet:namespace/>issuingName" name="<portlet:namespace/>issuingName" style="width: 90%" type="text" value="" />
				</td>
					
				<td  width="8%"><label><liferay-ui:message key="pccc-TN-ghichu" />:&nbsp;</label></td>
				<td  width="20%">
					<input id="<portlet:namespace/>issuingNote" name="<portlet:namespace/>issuingNote" style="width: 90%" type="text" value="" />
				</td>
				<td>
					<input onclick="addPmlEdmIssuingPlace('<%= addIssuingPlace.toString()  %>')" id="addButton" type="button" value='<liferay-ui:message key="save"/>' />		
				</td>
			</tr>
		</table>	
	</fieldset>
	
	<%
		List<PmlEdmIssuingPlace> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlEdmIssuingPlaceLocalServiceUtil.searchIssuingPlace(searchTerms.getCode(), searchTerms.getName(),
					searchTerms.isAndOperator(),issuingPlaceSearch.getStart(), issuingPlaceSearch.getEnd(), issuingPlaceSearch.getOrderByComparator());
		} else {
			results = PmlEdmIssuingPlaceLocalServiceUtil.searchIssuingPlace(searchTerms.getKeywords(),issuingPlaceSearch.getStart(), issuingPlaceSearch.getEnd(), issuingPlaceSearch.getOrderByComparator());
		}
		
		issuingPlaceSearch.setResults(results);
		
		
		if (searchTerms.isAdvancedSearch()) {
			total = PmlEdmIssuingPlaceLocalServiceUtil.searchCountIssuingPlace(searchTerms.getCode(), searchTerms.getName(), searchTerms.isAndOperator());
		} else {
			total = PmlEdmIssuingPlaceLocalServiceUtil.searchCountIssuingPlace(searchTerms.getKeywords());
			
		}
		
		issuingPlaceSearch.setTotal(total);
		
		portletURL.setParameter(issuingPlaceSearch.getCurParam(), String.valueOf(issuingPlaceSearch.getCurValue()));
	%>
	<%

		List resultRows = issuingPlaceSearch.getResultRows();
		ResultRow row = null;
		PmlEdmIssuingPlace issuingPlace = null;
		String addCapGui = "";
		
		for ( int i=0; i < results.size(); i++) {
			issuingPlace = results.get(i);
			String issuingPlaceId = issuingPlace.getIssuingPlaceId();
			issuingPlace = issuingPlace.toEscapedModel();
			row = new ResultRow(issuingPlace, issuingPlaceId, i);
			
			//STT
			row.addText(String.valueOf(i +1));
			
			//ma
			row.addText(issuingPlace.getIssuingPlaceCode().equals("") ? "&nbsp;" : issuingPlace.getIssuingPlaceCode());

			//ten co quan
			StringBuilder issuingPlaceName = new StringBuilder();
			
			issuingPlaceName.append("<div id=\"");
			issuingPlaceName.append("name".concat(issuingPlaceId));
			issuingPlaceName.append("\">");
			issuingPlaceName.append(issuingPlace.getIssuingPlaceName());
			issuingPlaceName.append("</div>");		
			issuingPlaceName.append("<div id=\"");
			issuingPlaceName.append("editName".concat(issuingPlaceId));
			issuingPlaceName.append("\" style=\"display: none;\" >");
			issuingPlaceName.append("<input name=\"");
			issuingPlaceName.append("issuingName_".concat(issuingPlaceId));
			issuingPlaceName.append("\" style=\"width: 90%\"");
			issuingPlaceName.append(" id=\"");
			issuingPlaceName.append("hiddenName".concat(issuingPlaceId));
			issuingPlaceName.append("\" type=\"text\"");
			issuingPlaceName.append(" value=\"");
			issuingPlaceName.append(issuingPlace.getIssuingPlaceName());
			issuingPlaceName.append("\" </div>");
			
			row.addText(issuingPlaceName.toString());
			
			//ghi chu
			StringBuilder issuingPlaceNote = new StringBuilder();
			issuingPlaceNote.append("<div id=\"");
			issuingPlaceNote.append("note".concat(issuingPlaceId));
			issuingPlaceNote.append("\">");
			issuingPlaceNote.append(issuingPlace.getNote().equals("") ? "&nbsp;" : issuingPlace.getNote());
			issuingPlaceNote.append("</div>");		
			issuingPlaceNote.append("<div id=\"");
			issuingPlaceNote.append("editNote".concat(issuingPlaceId));
			issuingPlaceNote.append("\" style=\"display: none;\" >");
			issuingPlaceNote.append("<input name=\"");
			issuingPlaceNote.append("issuingNote_".concat(issuingPlaceId));
			issuingPlaceNote.append("\" style=\"width: 95%\"");
			issuingPlaceNote.append(" id=\"");
			issuingPlaceNote.append("hiddenNote".concat(issuingPlaceId));
			issuingPlaceNote.append("\" type=\"text\"");
			issuingPlaceNote.append(" value=\"");
			issuingPlaceNote.append(issuingPlace.getNote());
			issuingPlaceNote.append("\" </div>");
			
			row.addText(issuingPlaceNote.toString());
			
			//URL add
			PortletURL rowURLAdd = renderResponse.createRenderURL();
			rowURLAdd.setWindowState(WindowState.NORMAL);
			rowURLAdd.setParameter("struts_action","/sgs/issuingplace/addlevelsend");
			rowURLAdd.setParameter("issuingPlaceId",issuingPlaceId);
// minh update 20101113		
			//rowURLAdd.setParameter("redirect", issuingPlaceSearch.getIteratorURL().toString());
			rowURLAdd.setParameter("redirect_view", issuingPlaceSearch.getIteratorURL().toString());
// end minh update 20101113				
			addCapGui = "<a href='"+ rowURLAdd.toString()+ "'><img src='/html/images/addEvent.gif' />&nbsp;</a>";
			row.addText(addCapGui);
			//sua hoac xoa
			
			
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
			rowURLEdit.setParameter("struts_action","/sgs/issuingplace/view");
			rowURLEdit.setParameter("issuingPlaceId",issuingPlaceId);
			rowURLEdit.setParameter("redirect", issuingPlaceSearch.getIteratorURL().toString());
			
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/issuingplace/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("issuingPlaceId",issuingPlaceId);
			rowURLDelete.setParameter("redirect", issuingPlaceSearch.getIteratorURL().toString());
			
			//script click sua
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(issuingPlaceId));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editIssuingPlace('");
			editOrDelete.append(issuingPlaceId);
			editOrDelete.append("'); \"/>");

			//script click xoa
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"deleteIssuingPlace('");
			editOrDelete.append(issuingPlaceId);
			editOrDelete.append("', '");			
			editOrDelete.append(rowURLDelete.toString());			
			editOrDelete.append("');\"/>");
			editOrDelete.append("</div>");
			
			// luu sau khi sua
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(issuingPlaceId));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updateIssuingPlace('");
			editOrDelete.append(issuingPlaceId);
			editOrDelete.append("', '");
			editOrDelete.append(rowURLEdit.toString());	
			editOrDelete.append("');\"/>");
			
			// click huy
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(issuingPlaceId);
			editOrDelete.append("');\"/>");
			editOrDelete.append("</div>");
			
			row.addText(editOrDelete.toString());
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=issuingPlaceSearch %>" />
</div>
</form>
