<%@ include file="/html/portlet/ext/pmlissuingplace/init.jsp" %>
<script type="text/javascript">
function <portlet:namespace />Sure() {
	i = confirm("Are you sure you want to delete?");
	if(i == 0) return false;
}
</script>

<% 	
	if(request.getAttribute("messageFlag") != null) {
		if(Boolean.parseBoolean(request.getAttribute("messageFlag").toString()) == true) {
%>			<div class="box-message-success">Your request processed successfully.</div>
<% 		} else { %><div class="box-message-error">Error ...</div><% }} %>

<br/>

<jsp:useBean id="attIssuingPlaceList" class="java.util.ArrayList" scope="request" />
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td class="blank-height-10"></td></tr>
<tr>
	<td align="center">
		<portlet:renderURL var="search_issuingplace">
			<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
			<portlet:param name="searchFlag" value="search" />
		</portlet:renderURL>
		<form action="<%= search_issuingplace %>" method="post">
		<liferay-ui:message key="pmlissuingplace.filter" />
		<select name="<portlet:namespace />filter">
			<option value="0"><liferay-ui:message key="pmlissuingplace.all" /></option>
			<option value="1"><liferay-ui:message key="pmlissuingplace.name" /></option>
		</select>&nbsp;&nbsp;
		<liferay-ui:message key="pmlissuingplace.search-key" />
		<input type="text" name="<portlet:namespace />key" class="form-text-200" value="" />
		<input type="submit" value='<liferay-ui:message key="pmlissuingplace.button-search" />' />
		</form>
		<div class="buttonwrapper">
			<portlet:renderURL var="add_issuingplace">
				<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
				<portlet:param name="page" value="add" />
			</portlet:renderURL>
   			<a class="ovalbutton" href="<%= add_issuingplace %>"><span><liferay-ui:message key="pmlissuingplace.add" /></span></a> 
   		</div>
	</td>
</tr>
<tr><td class="blank-height-20"></td></tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="pos">
		<tr align="center" class="table-list-title">
			<th width="7%"><liferay-ui:message key="pmlissuingplace.no" /></th>
			<th><a class="link-title" href="#"><liferay-ui:message key="pmlissuingplace.name" /></a></th>
			<th width="7%"><liferay-ui:message key="pmlissuingplace.active" /></th>
			<th width="7%"><liferay-ui:message key="pmlissuingplace.edit" /></th>
			<th width="7%"><liferay-ui:message key="pmlissuingplace.delete" /></th>
		</tr>
		<logic:iterate id="issuingPlace" name="attIssuingPlaceList" 
			type="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace" 
			indexId="i">
		
		<% 
		String issuingPlaceId = issuingPlace.getIssuingPlaceId() + "";
		String issuingPlaceName = issuingPlace.getIssuingPlaceName();
		%>
		
		<tr align="center" onMouseOut="nofocusColor(this)" onMouseOver="focusColor(this)" class="${((i % 2)==0)? 'rowOne':'rowTwo'}">
			<td><div class="posdiv"><%= (i + 1) %></div></td>
			<td><div align="left" class="posdiv"><%= issuingPlaceName %></div></td>
			<td ><div class="posdiv">
			<% if(Integer.parseInt(issuingPlace.getActive()) == 1) { %>
				<img src="/html/images/checked.gif" border="0" title="<liferay-ui:message key="citymanagement.check" />" /></td>
			<% } else { %>
				<img src="/html/images/unchecked.gif" border="0" title="<liferay-ui:message key="citymanagement.uncheck" />" /></div></td>
			<% } %>
			<td><div class="posdiv">
				<portlet:renderURL var="edit_issuingplace">
					<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
					<portlet:param name="page" value="edit" />
					<portlet:param name="issuingPlaceId" value="<%= issuingPlaceId %>" />
				</portlet:renderURL>
				<a href="<%= edit_issuingplace %>"><img src="/html/images/edit.gif" border="0" title="<liferay-ui:message key="pmlissuingplace.edit" />" /></a>
			</div></td>
			<td><div class="posdiv">
				<portlet:renderURL var="delete_issuingplace">
					<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
					<portlet:param name="page" value="delete" />
					<portlet:param name="issuingPlaceId" value="<%= issuingPlaceId %>" />
				</portlet:renderURL>
				<a href="<%= delete_issuingplace %>" onclick="return <portlet:namespace />Sure();"><img src="/html/images/delete.gif" border="0" title="<liferay-ui:message key="pmlissuingplace.delete" />" /></a>
			</div></td>
		</tr>
		</logic:iterate>
		</table>		
	</td>
</tr>
</table>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td><liferay-ui:message key="citymanagement.total-of-items" />: <font color="red"><%=request.getAttribute("totalOfItems")%></font></td>
	<td align="right"><liferay-ui:message key="citymanagement.page" />:&nbsp;
		<script type="text/javascript">
			for (var i = 1; i <= <%=request.getAttribute("totalPages")%>; i ++) {
				if (i == <%=request.getAttribute("currentPage")%>) {
			    	document.write('&nbsp;<font color="red">' + i + '</font>&nbsp;');
			  	}else { 		
			  		document.write('<portlet:renderURL var="list_levelsend">
									<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
									<% if(request.getAttribute("filter") != null) %><portlet:param name="searchFlag" value="search" />
									</portlet:renderURL>');
			  		document.write('&nbsp;<a href="<%= list_levelsend %>&_page=' + i + '">' + i + '</a>&nbsp;');	  
			  	}
			}
		</script>
	</td>
</tr>
</table>