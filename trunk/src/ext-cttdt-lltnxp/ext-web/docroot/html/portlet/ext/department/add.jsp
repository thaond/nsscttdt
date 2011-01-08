<%@ include file="/html/portlet/ext/department/init.jsp" %>


<%@page import="com.sgs.portlet.agency.model.Agency"%><html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body>
<table width="100%" border="0" >
<tr><td align="left"  style="cursor:pointer">
                    <a onClick="window.history.back()"> 
						<img alt="Back" src="/sgs-portal-skin/images/custom/back.png" border="0">                       
						<bean:message key="TaggsContent.DisplayFullContent.Back" />
						</a>
					</td> </tr>
                  </table>
<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.MAXIMIZED);
%>

<form action="<%= portletURL.toString() %>" method="post" onSubmit="return checkformDep(this);"
	name="<portlet:namespace />fm">
<%
	Department department = (Department)renderRequest.getAttribute("department");
	List<Agency> listAgency = (List<Agency>) renderRequest.getAttribute("listAgency");
%>
<%
if (department == null || department.getDepartmentsId().equals("")) {
%>
<table width="100%" border="0" >
  <tr>
    <td><div align="left"></div></td>
    <td><liferay-ui:message key="department_title" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><div align="left"></div></td>
    <td>****************</td>
    <td>&nbsp;</td>
    </tr><tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_code" />
    	</div>
    </td>
    <td>
    	<input type="text" name="<portlet:namespace />departmentsCode" id="departmentsCode" />
    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_name" />
    	</div>
    </td>
    <td>
         <input type="text" name="<portlet:namespace />departmentsName" id="departmentsName" />
    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
  	<td>
  		<div align="right">
    		<liferay-ui:message key="department_agency" />
    	</div>
  	</td>
  	<td>
  		<select name="<portlet:namespace />agency" id="agency">
  		<%
  			for (int i = 0; i < listAgency.size(); i++) {
  		%>
  			<option value="<%=listAgency.get(i).getAgencyId() %>"><%=listAgency.get(i).getAgencyName() %></option>
  		<%
  			}
  		%>
  		</select>
  	</td>
  </tr><tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_description" />
    	</div>
    </td>
    <td>
    	<textarea name="<portlet:namespace />description" id="description" cols="45" rows="5"></textarea>    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
    <td><div align="right"><liferay-ui:message key="department_has_team" /></div></td>
    <td>
           <input name="<portlet:namespace />team" type="checkbox" id="team" />   </td>
    <td>               </td>
  </tr><tr height="10"></tr>
  <tr>
    <td><div align="right"></div></td>
    <td > 
    		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
    		<input type="submit" name="button" id="button" value='<liferay-ui:message key="save" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
    </td>
    <td > </td>
    </tr>
  </table>
<%
} else {
%>

<table width="100%" border="0" >
  <tr>
    <td><div align="left"></div></td>
    <td><liferay-ui:message key="department_title" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><div align="left"></div></td>
    <td>****************</td>
    <td>&nbsp;</td>
    </tr>
  <tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_code" />
    	</div>
    </td>
    <td>
    	<input type="text" 
    		   name="<portlet:namespace />departmentsCode" 
    		   id="departmentsCode" 
    		   value="<%=department.getDepartmentsCode() %>"/>
    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_name" />
    	</div>
    </td>
    <td>
         <input type="text" 
         		name="<portlet:namespace />departmentsName" 
         		id="departmentsName" 
         		value="<%=department.getDepartmentsName() %>"/>
    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
  	<td>
  		<div align="right">
    		<liferay-ui:message key="department_agency" />
    	</div>
  	</td>
  	<td>
  		<select name="<portlet:namespace />agency" id="agency">
  		<%
  			for (int i = 0; i < listAgency.size(); i++) {
  		%>
  			<option <%=department.getAgencyId().equals(listAgency.get(i).getAgencyId()) ? "selected=selected" : "" %> value="<%=(listAgency.get(i)).getAgencyId() %>"><%=(listAgency.get(i)).getAgencyName() %></option>
  		<%
  			}
  		%>
  		</select>
  	</td>
  </tr><tr height="10"></tr>
  <tr>
    <td>
    	<div align="right">
    		<liferay-ui:message key="department_description" />
    	</div>
    </td>
    <td>
    	<textarea name="<portlet:namespace />description" 
    			  id="description" 
    			  cols="45" 
    			  rows="5"><%=department.getDescription() %></textarea>    
    </td>
    <td>&nbsp;</td>
  </tr><tr height="10"></tr>
  <tr>
    <td><div align="right"><liferay-ui:message key="department_has_team" /></div></td>
    <td>
           <input name="<portlet:namespace />team" 
           		  type="checkbox" 
           		  id="team" 
           		  <%=department.getHasTeam().equals("1") ? "checked=checked":""%>/>   
    </td>
    <td></td>
  </tr><tr height="10"></tr>
  <tr>
    <td><div align="right"></div></td>
    <td > 
    		<input name="<portlet:namespace />departmentsId" type="hidden" value="<%=department.getDepartmentsId()%>" />
    		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    		<input type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
    </td>
    <td > </td>
    </tr>
  </table>
<%} %>
</form>
</body>
</html>
