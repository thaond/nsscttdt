<%@ include file="/html/portlet/ext/department/init.jsp" %>
<%@page import="com.sgs.portlet.agency.service.persistence.AgencyUtil"%><body>
<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
%>

<%
	int total = ((Integer)renderRequest.getAttribute("total")).intValue();
	int totalPage = ((Integer)renderRequest.getAttribute("totalPage")).intValue();
	String type = (String) renderRequest.getAttribute("type");
	String keyword = (String) renderRequest.getAttribute("keyword");
	int numberRecord = ((Integer)renderRequest.getAttribute("numberRecord")).intValue();
	int numberPage = ((Integer)renderRequest.getAttribute("numberPage")).intValue();
%>

<portlet:renderURL var="add">
	<portlet:param name="struts_action" value="/sgs/department/view" />
	<portlet:param name="tabs1" value="add" />
</portlet:renderURL>

<form action="<%= portletURL.toString() %>" method="post"
	name="<portlet:namespace />fm">

<table width="100%">
<tr height="20"></tr>
  <tr>
    <td class="tdcolor"><liferay-ui:message key="department.display.filter" /></td>
    <td>:</td>
    <td><select name="<portlet:namespace />type">
      <option <%=type.equals("all") ? "selected": ""%> 
      	value="all"><liferay-ui:message key="all" /></option>
      <option <%=type.equals("departmentsCode") ? "selected": ""%> 
      	value="departmentsCode"><liferay-ui:message key="department_code" /></option>
      <option <%=type.equals("departmentsName") ? "selected": ""%> 
      	value="departmentsName"><liferay-ui:message key="department_name" /></option>
      <option <%=type.equals("description") ? "selected": ""%> 
      	value="description"><liferay-ui:message key="department_description" /></option>    
  	  </select></td>
    <td class="tdcolor"><liferay-ui:message key="department.display.keyword" /></td>
   <td> 
   		<input type="text" name="<portlet:namespace />keyword" id="text" value="<%= keyword %>"/>
   		<input type="submit" name="button" id="button" value='<liferay-ui:message key="department.display.go" />' /> 
   	</td>
     <td><div class="buttonwrapper">
   		<a class="ovalbutton" href="<%= add %>"><span><liferay-ui:message key="add_new" /></span></a> 
   		</div></td>
  </tr>
</table>
<br/>
<table>
  <tr>
    <td width="60">&nbsp;</td>
    <td width="240">&nbsp;</td>
    <td width="240">&nbsp;</td>
    <td width="143">&nbsp;</td>
    <td width="213">&nbsp;</td>
    <td width="106"><liferay-ui:message key="department.display.number_display" /></td>
    <td width="70" >
     
        <select name="<portlet:namespace />numberRecord" id="select" onchange="<portlet:namespace />fm.submit()">
        <option <%=(numberRecord == 5) ? "selected": ""%> value="5">5</option>
        <option <%=(numberRecord == 10) ? "selected": ""%> value="10">10</option>
        <option <%=(numberRecord == 15) ? "selected": ""%> value="15">15</option>
        <option <%=(numberRecord == 20) ? "selected": ""%> value="20">20</option>
        <option <%=(numberRecord == 25) ? "selected": ""%> value="25">25</option>
        <option <%=(numberRecord == 30) ? "selected": ""%> value="30">30</option>
        
        </select>    </td>
  </tr>
  </table>
  <br/>
  <table class="pos">
  <tr >
    <th><liferay-ui:message key="department_no" /></th>
    <th><liferay-ui:message key="department_code" /></th>
    <th><liferay-ui:message key="department_name" /></th>
    <th><liferay-ui:message key="department_agency" /></th>
    <th><liferay-ui:message key="department_description" /></th>
    <th><liferay-ui:message key="department_has_team" /></th>
    <th><liferay-ui:message key="department.display.edit" /></th>
    <th><liferay-ui:message key="department.display.delete" /></th>
  </tr>
  <p></p>
   
 	<logic:iterate id="department" name="listDepartment" indexId="i" type="com.sgs.portlet.department.model.DepartmentModel" scope="request" >
 	
 		<portlet:renderURL var="edit">
			<portlet:param name="struts_action" value="/sgs/department/view" />
			<portlet:param name="tabs1" value="add" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.EDIT %>"/>
			<portlet:param name="departmentsId" value="<%=department.getDepartmentsId() %>"/>
			<portlet:param name="type" value="<%=type %>"/>
			<portlet:param name="keyword" value="<%=keyword %>"/>
			<portlet:param name="numberRecord" value="<%=String.valueOf(numberRecord) %>"/>
		</portlet:renderURL>

		<portlet:renderURL var="delete">
			<portlet:param name="struts_action" value="/sgs/department/view" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.DELETE %>"/>
			<portlet:param name="departmentsId" value="<%=department.getDepartmentsId() %>"/>
			<portlet:param name="type" value="<%=type %>"/>
			<portlet:param name="keyword" value="<%=keyword %>"/>
			<portlet:param name="numberRecord" value="<%=String.valueOf(numberRecord) %>"/>
		</portlet:renderURL> 
		
		<%
			String url = "";
			if ("1".equals(department.getHasTeam())) {
				url = "/html/images/checked.gif";
			} else {
				url = "/html/images/unchecked.gif";
			}
		%>
		
		<tr onMouseOut="nofocusColor(this)" onMouseOver="focusColor(this)" class="${((i % 2)==0)? 'rowOne':'rowTwo'}">
		    <td><div class="posdiv"><%=i + numberPage * numberRecord + 1%></div></td>
		    <td><div class="posdiv"><bean:write name="department" property="departmentsCode"/></div></td>
		    <td><div align="left"><bean:write name="department" property="departmentsName"/></div></td>
		    <td><div align="left"><%=AgencyUtil.findByPrimaryKey(department.getAgencyId()).getAgencyName() %></div></td>
		    <td><div align="left"><bean:write name="department" property="description"/></div></td>
		    <td><div class="posdiv"><img src="<%=url %>" /></div></td>
		    <td><div class="posdiv"><a href="<%=edit %>"><img src="/html/images/edit.gif"/> </a></div></td>
		    <td><div class="posdiv"><a href="<%=delete %>" onclick="return confirm('<liferay-ui:message key="confirmDelete" />');"><img src="/html/images/delete.gif"/></a></div></td>
	    </tr>
    </logic:iterate>
    <tr height="20"></tr>
    </table>
    <table>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><liferay-ui:message key="department_total" /> <%=total %></td>
    <td>&nbsp;</td>
    <td><liferay-ui:message key="department_page" /></td>
    <td>
    <%
    	for(int j = 0; j < totalPage; j++) {
    %>
    	<portlet:renderURL var="displayPage">
			<portlet:param name="struts_action" value="/sgs/department/view" />
			<portlet:param name="tabs1" value="display" />
			<portlet:param name="numberPage" value="<%=String.valueOf(j) %>"/>
			<portlet:param name="type" value="<%=type %>"/>
			<portlet:param name="keyword" value="<%=keyword %>"/>
			<portlet:param name="numberRecord" value="<%=String.valueOf(numberRecord) %>"/>
		</portlet:renderURL>
    <%
    	if (numberPage == j) {
	%>
			[<%=j+1%>]	
	<%
    	} else {
    %>
    	<a href="<%=displayPage %>"><%=j + 1 %></a>
    <%
		}
	   } %>
  </td>
    <td>&nbsp;</td>
  </tr>
  
</table>
 </form>

</body>
