<%@ include file="/html/portlet/ext/field/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<portlet:actionURL var="total_item_of_page_field">
	<portlet:param name="struts_action" value="/sgs/field/view" />
	<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
</portlet:actionURL>

<script type="text/javascript">
function <portlet:namespace />Sure() {
	i = confirm('<bean:message key="sgs_field_deleteMessage"/>');
	if(i == 0) return false;
}
function <portlet:namespace />addValue() {

	var value = document.getElementById("total_item_of_page_field").value;
	var url = "<%=total_item_of_page_field %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=" + value;
	document.getElementsByName("<portlet:namespace />form2")[0].setAttribute("action", url);
}


</script>
<portlet:renderURL var="add_field">
	<portlet:param name="struts_action" value="/sgs/field/view" />
	<portlet:param name="tab" value="add" />
</portlet:renderURL>
<jsp:useBean id="listField" class="java.util.ArrayList" scope="request" />
<div>

<table cellspacing="0" width="100%" >
<tr><td><%=request.getAttribute("errorMessage") %></td></tr>
<tr>
	<td align="center">
		<portlet:actionURL var="search_field"><portlet:param name="struts_action" value="/sgs/field/view" />
			<portlet:param name="cmd" value="search" />
			</portlet:actionURL>
		<form action="<%=search_field %>" method="post">
		<bean:message key="sgs_field_filter"/>:
		<select name="filter">
		<% 
		String arrayFilter[] = {"all", "sgs_field_fieldCode", "sgs_field_fieldName"};
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
		<bean:message key="sgs_field_key"/>:
		<input type="text" name="key" class="form-text-200" value='<% if(request.getAttribute("filter") != null) %><%=request.getAttribute("keySearch") %>' />
		<input type="submit" value='<bean:message key="sgs_field_go"/>' />
		<td>
			<div class="buttonwrapper">
	   			<span onclick="javascript:submitForm(document.hrefFm,'<%= add_field %>');"><INPUT type="button" value='<liferay-ui:message key="add_new" />' /></span 
	   		</div>
   		</td>
   		</form>
	</td>
</tr>
</table>
<br/>

<table>
<tr>
	<td align="right">
		<form name="<portlet:namespace />form2" action="<%=total_item_of_page_field %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>" method="post">
		<bean:message key="sgs_field_numberDisplay"/>:
		<select id="total_item_of_page_field" name="total_item_of_page_field" onchange="<portlet:namespace />addValue();<portlet:namespace />form2.submit();">
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
</table>
<br/>
<table width="100%" cellpadding="0" cellspacing="0" border="0" class="table-pml">
	
		<portlet:renderURL var="sort_field">
			<portlet:param name="struts_action" value="/sgs/field/view" />
			<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
		</portlet:renderURL>
		
		<tr valign="middle" class="title-table-pml">
			<td width="4%" class="td-stt-pml"><bean:message key="sgs_field_no"/></td>
			<td class="td-stt-pml"><a href=<%=sort_field %>&sort=1&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<bean:message key="sgs_field_fieldCode"/></a></td>
			<td class="td-stt-pml"><a href="<%=sort_field %>&sort=2&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<bean:message key="sgs_field_fieldName"/></a></td>
			<td class="td-stt-pml"><bean:message key="sgs_field_description"/></td>
			<td class="td-stt-pml"><a href="<%=sort_field %>&sort=3&flag=<%=request.getAttribute("flag") %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit")%>">
					<bean:message key="sgs_field_active"/></a></td>
			<td class="td-stt-pml"><bean:message key="department_name"/></td>
			<td width="5%" class="td-stt-pml"><bean:message key="sgs_field_edit"/></td>
			<td width="5%" class="td-stt-pml"><bean:message key="sgs_field_delete"/></td>
		</tr>
		<% 
			int n = (Integer.parseInt(request.getAttribute("currentPage").toString()) - 1) * Integer.parseInt(request.getAttribute("currentLimit").toString());
		%>
		<logic:iterate id="field" name="listField" 
			type="com.sgs.portlet.field.model.PmlField" 
			indexId="i">
			
		<tr height="28" class="${((i % 2)==0)? 'rowOneT1':'rowTwoT2'}">
			<td align="center"  style="text-align:center; color: #FF0000;background-color: #DBEAFC" class="td-stt-pml"><%=((i + 1) + n ) %>.</td>
			<td align="center" class="td-stt-pml"><%=field.getFieldCode() %></td>
			<td align="left" class="td-stt-pml"><%=field.getFieldName() %></td>
			<td width="40%" align="left" class="td-stt-pml"><%=field.getDescription() %></td>
			<td align="center" class="td-stt-pml">
			<% if(Integer.parseInt(field.getActive()) == 1) { %>
				<img src="/html/images/checked.gif" border="0" title="Hoat dong" /></td>
			<% } else { %>
				<img src="/html/images/unchecked.gif" border="0" title="khong hoat dong" /></td>
			<% } %>
			<td align="left" class="td-stt-pml"><%=field.getDepartmentsId() %></td>
			<td align="center" class="td-stt-pml">
				<portlet:renderURL var="edit_field">
					<portlet:param name="struts_action" value="/sgs/field/view" />
					<portlet:param name="tab" value="edit" />
					<portlet:param name="cmd" value="edit" />
					<portlet:param name="fieldID" value="<%=field.getFieldId() %>" />
				</portlet:renderURL>
				<a href="<%=edit_field %>"><img src="/html/images/edit.gif" border="0" title="edit" /></a>
			</td>
			<td class="td-stt-pml">
				<portlet:renderURL var="delete_field">
					<portlet:param name="struts_action" value="/sgs/field/view" />
					<portlet:param name="cmd" value="delete" />
					<portlet:param name="fieldID" value="<%=field.getFieldId() %>" />
				</portlet:renderURL>
				<a href="<%=delete_field %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=<%=request.getAttribute("currentPage") %>&limit=<%=request.getAttribute("currentLimit") %>" onclick="return <portlet:namespace />Sure();"><img src="/html/images/xoa.gif" border="0" title="delete" /></a>
			</td>
		</tr>
		<tr>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  </tr>	
		</logic:iterate>
</table>
<br/>
<table cellpadding="0" cellspacing="0" border="0" width="100%" >
<tr>
	<td><bean:message key="sgs_field_totalMessage"/>: <font color="red"><%=request.getAttribute("totalOfItems")%></font></td>
	<td align="right" colspan="5"><bean:message key="sgs_field_page"/>:&nbsp;
		<script type="text/javascript">
			for (var i = 1; i <= <%=request.getAttribute("totalPages")%>; i ++) {
				if (i == <%=request.getAttribute("currentPage")%>) {
			    	document.write('&nbsp;<font color="red">' + i + '</font>&nbsp;');
			  	}else { 		
			  		document.write('<portlet:renderURL var="list_field">
									<portlet:param name="struts_action" value="/sgs/field/view" />
									<% if(request.getAttribute("filter") != null) %><portlet:param name="cmd" value="search" />
									</portlet:renderURL>');
			  		document.write('&nbsp;<a href="<%=list_field %><% if(request.getAttribute("filter") != null) { %>&<portlet:namespace />key=<%=request.getAttribute("keySearch") %><% } %><% if(request.getAttribute("keySearch") != null) { %>&<portlet:namespace />filter=<%=request.getAttribute("filter") %><% } %>&page=' + i + '&limit=' + <%=request.getAttribute("currentLimit")%> + '">' + i + '</a>&nbsp;');	  
			  	}
			}
		</script>
	</td>
</tr>
</table></div>