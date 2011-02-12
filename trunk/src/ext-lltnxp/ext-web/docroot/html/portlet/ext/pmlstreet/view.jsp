<%@ include file="/html/portlet/ext/pmlstreet/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.sgs.portlet.pmlstreet.search.StreetSearch"%>
<%@page import="com.sgs.portlet.pmlstreet.search.StreetSearchTerms"%>
<%@page import="com.sgs.portlet.pmlstreet.service.PmlStreetLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlstreet.model.PmlStreet"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.pmlstreet.NoGenerateStreetIdException"%>

<%@page import="com.sgs.portlet.pmlstreet.search.StreetDisplayTerms"%><liferay-util:include page="/html/portlet/ext/pmlstreet/js/street.jsp">
</liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/pmlstreet/view");
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="title_categ"><liferay-ui:message key="street"/></div>
<input name="<portlet:namespace />streetURL" type="hidden" value="<%= portletURL.toString() %>" />
 <div class="boxcontent">
 <liferay-ui:error exception="<%= NoGenerateStreetIdException.class %>" message="khong-co-mau-phat-sinh-ma-duong" />	
	<%
		StreetSearch streetSearch = new StreetSearch(renderRequest,portletURL);
		StreetDisplayTerms displayTerms = (StreetDisplayTerms)streetSearch.getDisplayTerms();
		StreetSearchTerms searchTerms = (StreetSearchTerms)streetSearch.getSearchTerms();
	%>
	<table cellspacing="0" width="100%">
		<tr>
			<td width="9%" align="right"><label><liferay-ui:message key="ten_duong"/>&nbsp;:</label></td>
			<td width="80%"><input name="<%= StreetDisplayTerms.TEN %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" /></td>
			<td align="right"><input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/></td>
		</tr>
	</table>
		<br /> 
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="them-moi" /></label>
			<table cellspacing="0" width="100%">
				<tr>
					<td width="9%" align="right"><liferay-ui:message key="ma_duong"/>&nbsp;:</td>
					<td width="15%"><input name="<portlet:namespace/>streetCode" id="streetCode"  style="width: 90%" type="text" value="" disabled="disabled"/></td>
					<td width="2%"><input name="<portlet:namespace/>checkCode" id="checkCode" type="checkbox" checked="checked" onclick="changeTextStreetCode()"/></td>
					<td width="13%" align="right"><liferay-ui:message key="ten_duong"/>&nbsp;:<font color="red">(*)</font>:</td>
					<td width="53%"><input name="<portlet:namespace/>ten" id="streetName"  style="width: 98%" type="text" value="" /></td>
					<td align="right">
						<portlet:actionURL var="add">
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"/>
						<portlet:param name="struts_action" value="/sgs/pmlstreet/view" />
						<portlet:param name="redirect" value="<%= streetSearch.getIteratorURL().toString() %>" />
						</portlet:actionURL>
						<input onclick="addStreet('<%= add %>')" id="addButton"  type="button" value='<liferay-ui:message key="add_new"/>' />	
					</td>
				</tr>
			</table>
			
		</fieldset>
		
		
	<%
		int total = 0;
		total = PmlStreetLocalServiceUtil.searchCount(searchTerms.getTen());
		
		List<PmlStreet> results = null;
		results = PmlStreetLocalServiceUtil.search(searchTerms.getTen(),streetSearch.getStart(), streetSearch.getEnd(), streetSearch.getOrderByComparator()); 
		
		streetSearch.setTotal(total);
		streetSearch.setResults(results);
		
		portletURL.setParameter(streetSearch.getCurParam(), String.valueOf(streetSearch.getCurValue()));
	%>
	<%
	
		List resultRows = streetSearch.getResultRows();
		ResultRow row = null;
		PmlStreet street = null;
		String update = "";
		String deleteAction = "";
		
		for ( int i=0; i< results.size(); i++) {
			street = results.get(i);
			String streetId = street.getStreetId();
			
			row = new ResultRow(street, streetId, i);
			
			// STT
			row.addText(String.valueOf(i+1));
			
			// ma duong
			row.addText(streetId);
			
			// ten duong
			StringBuilder streetName = new StringBuilder();
			
			streetName.append("<div id=\"");
			streetName.append("name".concat(streetId));
			streetName.append("\">");
			streetName.append(street.getStreetName());
			streetName.append("</div>");		
			streetName.append("<div id=\"");
			streetName.append("editName".concat(streetId));
			streetName.append("\" style=\"display: none;\" >");
			streetName.append("<input name=\"");
			streetName.append("streetName_".concat(streetId));
			streetName.append("\" style=\"width: 96%\"");
			streetName.append(" id=\"");
			streetName.append("hidden".concat(streetId));
			streetName.append("\" type=\"text\"");
			streetName.append(" value=\"");
			streetName.append(street.getStreetName());
			streetName.append("\" /> </div>");
			
			row.addText(streetName.toString());
			
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
			rowURLEdit.setParameter("struts_action","/sgs/pmlstreet/view");
			rowURLEdit.setParameter("streetId",streetId);
			rowURLEdit.setParameter("redirect", streetSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/pmlstreet/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("streetId",streetId);
			rowURLDelete.setParameter("redirect", streetSearch.getIteratorURL().toString());
			
			//sua hoac xoa
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(streetId));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editStreet('");
			editOrDelete.append(streetId);
			editOrDelete.append("'); \"/>&nbsp;&nbsp;");
			
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"deleteStreet('");
			editOrDelete.append(streetId);
			editOrDelete.append("', '");
			editOrDelete.append(rowURLDelete.toString());			
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(streetId));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updateStreet('");
			editOrDelete.append(streetId);
			editOrDelete.append("', '");
			editOrDelete.append(rowURLEdit.toString());	
			editOrDelete.append("');\"/>&nbsp;&nbsp;");
			
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(streetId);
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			  
			row.addText(editOrDelete.toString());	
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=streetSearch %>" />
</div>
</form>
<% 
Boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
if (delete != null && !delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>
