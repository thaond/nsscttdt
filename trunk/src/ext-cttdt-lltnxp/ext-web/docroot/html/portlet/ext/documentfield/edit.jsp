<%@ include file="/html/portlet/ext/documentfield/init.jsp" %>
<%@page import="com.sgs.portlet.field.model.PmlField"%>
<%@page import="com.sgs.portlet.field.model.impl.PmlFieldImpl"%>
<%@ include file="/html/portlet/ext/documentfield/js/doc_field.jsp" %>
<%
	//FieldImpl fieldObj = (FieldImpl) renderRequest.getAttribute("fieldObj");
	PmlField fieldObj = (PmlField) renderRequest.getAttribute("fieldObj");
%>
<portlet:renderURL var="redirect">
	<portlet:param name="struts_action"	value="/sgs/documentfield/view" />
</portlet:renderURL>				
<portlet:actionURL var="edit">
	<portlet:param name="struts_action" value="/sgs/documentfield/editfield"/>
	<portlet:param name="fieldId" value="<%=fieldObj.getFieldId() %>"/>
	<portlet:param name="redirect" value="<%=redirect %>"/>
</portlet:actionURL>
<form action="<%=edit %>" method="post" onsubmit="return validateEditForm();" >
<div class="title_categ"><liferay-ui:message key="field-sua-linh-vuc-ho-so"/></div>
 <div class="boxcontent">
				<table cellspacing="0" width="100%">
					
				<tr>
					<td width="15%" ><label><liferay-ui:message key='field.code'/>&nbsp;: <font color="red">(*)</font>:</label></td>
					<td >
						<input  type="text" id="code" readonly="readonly" name="<portlet:namespace/>code"  style="width:50%" value="<%=fieldObj.getFieldCode() %>">
					</td>
				</tr>
				
				<tr>
					<td><label><liferay-ui:message key='field.name'/> &nbsp;:<font color="red">(*)</font> : </label></td>
					<td>
						<input  type="text" id="name" name="<portlet:namespace/>name"  style="width:50%" value="<%=fieldObj.getFieldName() %>">
					</td>
				</tr>
				
				<tr>
					<td width="10%" ><label><liferay-ui:message key='field.department'/>&nbsp;: <font color="#FF0000">(*)</font>:</label></td>
					<td>
					<select style="width: 96%" id="department" name="<portlet:namespace />departmentId">
						<option value="">[<liferay-ui:message key="chonphongban"/>]</option>
						<logic:iterate id="department" name="listDepartment" indexId="i" type="com.sgs.portlet.department.model.Department" scope="request" >
						<option <%=fieldObj.getDepartmentsId().equals(department.getDepartmentsId()) ? "selected" : "" %> value="<%=department.getDepartmentsId() %>">
							<%=department.getDepartmentsName() %>
						</option>
						</logic:iterate>
					</select>
					</td>
				</tr>
				
				<tr>
					<td valign="top"><label><liferay-ui:message key='description'/>:</label></td>
					<td><textarea name="<portlet:namespace />description" style="width:95%" rows="5" ><%=fieldObj.getDescription() %></textarea></td>
				</tr>
				
				<tr>
					<td></td>
					<td >
				    	<input style="margin-left: 0;" type='submit' value='<liferay-ui:message key="update"/>' />							
				 		<input type="reset" value='<liferay-ui:message key="reset"/>'>
				 		<span onclick="javascript:submitForm(document.hrefFm,'<%=redirect%>');"><input type="button" value='<liferay-ui:message key="back"/>' ></span> 	     
				    </td>
				</tr>
</table>
</div>
</form>