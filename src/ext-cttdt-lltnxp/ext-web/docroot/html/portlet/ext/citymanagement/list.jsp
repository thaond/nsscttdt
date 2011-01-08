<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>
<%@page import="java.net.URLDecoder"%>
<portlet:actionURL var="total_item_of_page_city">
	<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
	<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
</portlet:actionURL>

<script type="text/javascript">
function <portlet:namespace />Sure() {
	i = confirm("Are you sure you want to delete?");
	if(i == 0) return false;
}
function <portlet:namespace />addValue() {

	var value = document.getElementById("total_item_of_page_city").value;
	var url = "<%=total_item_of_page_city %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=" + value;
	document.getElementsByName("<portlet:namespace />form2")[0].setAttribute("action", url);
}
</script>

<portlet:renderURL var="add_city">
	<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
	<portlet:param name="tab" value="add" />
</portlet:renderURL>

<jsp:useBean id="listCity" class="java.util.ArrayList" scope="request" />
<table cellspacing="0" width="100%">
<% 
if(request.getAttribute("errorMessage") != null) {
	String message = request.getAttribute("errorMessage").toString();
	if(message.equals("") == false) { 
%>
<tr><td>
	<div><img src="/html/images/hd-success.png" border="0" /><%=request.getAttribute("errorMessage") %></div>
</td></tr>
<% 
	}
}
%>
<tr>
	<td align="center">
		<portlet:renderURL var="search_city">
			<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
			<portlet:param name="cmd" value="search" />
		</portlet:renderURL>
		<form action="<%=search_city %>" method="post">
		<liferay-ui:message key="citymanagement.filter" />:
		<select name="filter">
		<% 
		String arrayFilter[] = {"citymanagement.all", "citymanagement.code", "citymanagement.name", "citymanagement.description"};
		int len = arrayFilter.length;
		for(int i = 0; i < len; i ++) {
		%>
			<option value="<%=i %>" 
				<% 
					if(request.getAttribute("filter") != null) 
						if(i == Integer.parseInt(request.getAttribute("filter").toString())) { 
				%>
							selected="selected"
						<% } %>
				><liferay-ui:message key="<%=arrayFilter[i] %>" /></option>
		<% } %>
		</select>
		<liferay-ui:message key="citymanagement.key-search" />:
		<input type="text" name="key" value='<% if(request.getAttribute("filter") != null) %><%=request.getAttribute("keySearch") %>' />
		<input type="submit" value='<liferay-ui:message key="citymanagement.button-search" />' />
        <div align="left">
   		<a href="<%= add_city %>"><input type="button" value='<liferay-ui:message key="add_new" />' /></a> 
   		</div>
		</form>
	</td>
     <td></td>
</tr>
<tr>
	<td align="right">
		<form name="<portlet:namespace />form2" action="<%=total_item_of_page_city %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>" method="post">
		<liferay-ui:message key="citymanagement.total-item-of-page" />:
		<select id="total_item_of_page_city" name="total_item_of_page_city" onchange="<portlet:namespace />addValue();<portlet:namespace />form2.submit();">
		<% for(int i = 10; i <= 70; i += 10) { %>
			<option value="<%=i %>" 
				<% if(i == Integer.parseInt(request.getAttribute("currentLimit").toString())) { %>selected="selected">
				<% } else { %>>
				<% } %><%=i %>
			</option>
		<% } %>
		</select>
		</form>
	</td>
</tr>
<tr>
	<td>
		<portlet:renderURL var="sort_city">
			<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
			<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
		</portlet:renderURL>
		<table width="100%" cellspacing="0" >
		<tr valign="middle" align="center">
			<td width="3%"><liferay-ui:message key="citymanagement.no" /></td>
			<td><a class="link-title" 
					href="<%=sort_city %>&sort=1&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<liferay-ui:message key="citymanagement.code" /></a></td>
			<td><a class="link-title" 
					href="<%=sort_city %>&sort=2&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<liferay-ui:message key="citymanagement.name" /></a></td>
			<td><liferay-ui:message key="citymanagement.description" /></td>
			<td><a class="link-title" 
					href="<%=sort_city %>&sort=3&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<liferay-ui:message key="citymanagement.active" /></a></td>
			<td><liferay-ui:message key="citymanagement.edit" /></td>
			<td><liferay-ui:message key="citymanagement.delete" /></td>
		</tr>
		<% 
			int n = (Integer.parseInt(request.getAttribute("currentPage").toString()) - 1) * Integer.parseInt(request.getAttribute("currentLimit").toString());
		%>
		<logic:iterate id="city" name="listCity" 
			type="com.sgs.portlet.citymanagement.model.City" 
			indexId="i">
			
		<tr align="center" height="28" class="${((i % 2)==0)? 'rowOneT1':'rowTwoT2'}">
			<td ><div class="posdiv"><%=((i + 1) + n ) %>.</div></td>
			<td><div class="posdiv"><bean:write name="city" property="cityCode" /></div></td>
			<td align="left"><bean:write name="city" property="cityName" /></td>
			<td align="left"><bean:write name="city" property="description" /></td>
			<td><div class="posdiv">
			<% if(Integer.parseInt(city.getActive()) == 1) { %>
				<img src="/html/images/checked.gif" border="0" title="<liferay-ui:message key="citymanagement.check" />" /></td>
			<% } else { %>
				<img src="/html/images/unchecked.gif" border="0" title="<liferay-ui:message key="citymanagement.uncheck" />" /></div></td>
			<% } %>
			<td><div class="posdiv">
				<portlet:renderURL var="edit_city">
					<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
					<portlet:param name="tab" value="edit" />
					<portlet:param name="cmd" value="edit" />
					<portlet:param name="cityID" value="<%=city.getCityID() %>" />
				</portlet:renderURL>
				<a href="<%=edit_city %>"><img src="/html/images/edit.gif" border="0" title="<liferay-ui:message key="citymanagement.edit-title" />" /></a>
			</div></td>
			<td><div class="posdiv">
				<portlet:renderURL var="delete_city">
					<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
					<portlet:param name="cmd" value="delete" />
					<portlet:param name="cityID" value="<%=city.getCityID() %>" />
				</portlet:renderURL>
				<a href="<%=delete_city %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit") %>" onclick="return <portlet:namespace />Sure();"><img src="/html/images/xoa.gif" border="0" title="<liferay-ui:message key="citymanagement.delete-title" />" /></a>
			</div></td>
		</tr>
		</logic:iterate>
	</table>
</td>
</tr>
</table>
	
<table cellspacing="0" width="100%">
<tr>
	<td><liferay-ui:message key="citymanagement.total-of-items" />: <font color="red"><%=request.getAttribute("totalOfItems")%></font></td>
	<td align="right" colspan="5"><liferay-ui:message key="citymanagement.page" />:&nbsp;
		<script type="text/javascript">
			for (var i = 1; i <= <%=request.getAttribute("totalPages")%>; i ++) {
				if (i == <%=request.getAttribute("currentPage")%>) {
			    	document.write('&nbsp;<font color="red">' + i + '</font>&nbsp;');
			  	}else { 		
			  		document.write('<portlet:renderURL var="list_city">
									<portlet:param name="struts_action" value="/sgs/citymanagement/view" />
									<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
									</portlet:renderURL>');
			  		document.write('&nbsp;<a href="<%=list_city %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=' + i + '&limit=' + <%=request.getAttribute("currentLimit")%> + '">' + i + '</a>&nbsp;');	  
			  	}
			}
		</script>
	</td>
</tr>
</table>
