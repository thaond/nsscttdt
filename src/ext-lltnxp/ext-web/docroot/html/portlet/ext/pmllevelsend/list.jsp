<%@ include file="/html/portlet/ext/pmllevelsend/init.jsp" %>

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

<jsp:useBean id="attLevelSendList" class="java.util.ArrayList" scope="request" />
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td align="center">
		<portlet:renderURL var="search_levelsend">
			<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
			<portlet:param name="searchFlag" value="search" />
		</portlet:renderURL>
		<form action="<%= search_levelsend %>" method="post">
		<liferay-ui:message key="pmllevelsend.filter" />
		<select name="<portlet:namespace />filter">
			<option value="0"><liferay-ui:message key="pmllevelsend.all" /></option>
			<option value="1"><liferay-ui:message key="pmllevelsend.name" /></option>
		</select>&nbsp;&nbsp;
		<liferay-ui:message key="pmllevelsend.search-key" />
		<input type="text" name="<portlet:namespace />key" class="form-text-200" value="" />
		<input type="submit" value='<liferay-ui:message key="pmllevelsend.button-search" />' />
		</form>
		<div class="buttonwrapper">
			<portlet:renderURL var="add_levelsend">
				<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
				<portlet:param name="page" value="add" />
			</portlet:renderURL>
   			<a class="ovalbutton" href="<%= add_levelsend %>"><span><liferay-ui:message key="pmllevelsend.add" /></span></a> 
   		</div>
	</td>
</tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="pos">
		<tr align="center" class="table-list-title">
			<th width="7%"><liferay-ui:message key="pmllevelsend.no" /></th>
			<th><a class="link-title" href="#"><liferay-ui:message key="pmllevelsend.name" /></a></th>
			<th width="7%"><liferay-ui:message key="pmllevelsend.edit" /></th>
			<th width="7%"><liferay-ui:message key="pmllevelsend.delete" /></th>
		</tr>
		<logic:iterate id="levelsend" name="attLevelSendList" 
			type="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend" 
			indexId="i">
		
		<% 
		String levelSendId = levelsend.getLevelSendId() + "";
		String levelSendName = levelsend.getLevelSendName();
		%>
		
		<tr align="center" onMouseOut="nofocusColor(this)" onMouseOver="focusColor(this)" class="${((i % 2)==0)? 'rowOne':'rowTwo'}">
			<td><div class="posdiv"><%= (i + 1) %></div></td>
			<td><div align="left" class="posdiv"><%= levelSendName %></div></td>
			<td><div class="posdiv">
				<portlet:renderURL var="edit_levelsend">
					<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
					<portlet:param name="page" value="edit" />
					<portlet:param name="levelSendId" value="<%= levelSendId %>" />
				</portlet:renderURL>
				<a href="<%= edit_levelsend %>"><img src="/html/images/edit.gif" border="0" title="<liferay-ui:message key="pmllevelsend.edit" />" /></a>
			</div></td>
			<td><div class="posdiv">
				<portlet:renderURL var="delete_levelsend">
					<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
					<portlet:param name="page" value="delete" />
					<portlet:param name="levelSendId" value="<%= levelSendId %>" />
				</portlet:renderURL>
				<a href="<%= delete_levelsend %>" onclick="return <portlet:namespace />Sure();"><img src="/html/images/delete.gif" border="0" title="<liferay-ui:message key="pmllevelsend.delete" />" /></a>
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