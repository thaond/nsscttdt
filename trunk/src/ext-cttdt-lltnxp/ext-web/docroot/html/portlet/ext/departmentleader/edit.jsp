<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/departmentleader/js/departmentleader.jsp" ></liferay-util:include>

<%
	Department department = (Department) renderRequest.getAttribute("department");
	//List<Department> departmentParentIdList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId();
	List<Department> departmentParentIdList = DepartmentLocalServiceUtil.findAll();
	String redirect = ParamUtil.getString(renderRequest, "redirect");
%>

<portlet:actionURL var="edit">
	<portlet:param name="struts_action" value="/sgs/departmentleader/edit"/>
	<portlet:param name="departmentId" value="<%=department.getDepartmentsId() %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<form action="<%=edit %>" name="<portlet:namespace />fm" method="post" onsubmit="return validateEditForm();">
<div class="title_categ"><liferay-ui:message key="chinh-sua-phong-ban"/></div>
<div class="boxcontent">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><liferay-ui:message key="department_code"/> <font color="red">(*)</font> :</td>
			<td><input style="width: 95%" type="text" id="departmentCode" name="<portlet:namespace />departmentCode" value="<%=department.getDepartmentsCode() %>" readonly="readonly" /></td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_name"/> <font color="red">(*)</font> :</td>
			<td><input style="width: 95%" type="text" id="departmentName" name="<portlet:namespace />departmentName" value="<%=department.getDepartmentsName() %>" /></td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="abbreviate_name"/> <font color="red">(*)</font> :</td>
			<td><input style="width: 95%" type="text" id="abbreviateName" name="<portlet:namespace />abbreviateName" value="<%=department.getAbbreviateName() %>" /></td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_agency"/> <font color="red">(*)</font> :</td>
			<td>
				<select style="width: 96%" id="departmentAgency" name="<portlet:namespace />departmentAgency">
					<logic:iterate id="agency" name="agencyList" indexId="i" type="com.sgs.portlet.agency.model.Agency" scope="request" >
					<option <%=department.getAgencyId().equals(agency.getAgencyId()) ? "selected" : "" %> value="<%=agency.getAgencyId() %>"><%=agency.getAgencyName() %></option>
					</logic:iterate>
				</select>
			</td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_phutrach"/> :</td>
			<td class="td_input_base">
				<select name="<portlet:namespace />departmentParentId" id="departmentParentId" style="width: 96%">
					<option value=""><liferay-ui:message key="nochoose"/></option>
				<%
					for (int idx = 0; idx < (departmentParentIdList == null ? 0 : departmentParentIdList.size()); idx ++) {
						Department departmentItem = (Department) departmentParentIdList.get(idx);
					%>
						<option value="<%= departmentItem.getPrimaryKey() %>" <%= (department.getDepartmentsParentId().equals(departmentItem.getDepartmentsId()) ? " selected ": " ") %>> <%= departmentItem.getDepartmentsName() %></option>
					<%
					}
				%>
						
				</select>
			</td>
		</tr>
		

		<tr>
			<td valign="top"><liferay-ui:message key="user"/> :</td>
			<td>
			<div style="width: 96%;">
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="2%" align="center">
							<input class="styled" type="checkbox" 
								onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<portlet:namespace/>pmlUserId', this);"
								name="checkallbox" id="checkallbox"/>
						</td>
						<td width="8%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td width="60%"><liferay-ui:message key="name" /></td>
						<td ><liferay-ui:message key="receipt.position" /></td>
					</tr>
					<logic:iterate id="userDTO" name="userList" indexId="i" type="com.sgs.portlet.departmentleader.action.PmlUserDTO" scope="request" >
						<tr  class="${((i % 2)!=0)? 'tr_two results-row':'results-row'}" >
							<td align="center" id="<%=i %>">
								<input type="checkbox" name="<portlet:namespace/>pmlUserId" id="pmlUserId<%=i %>" 
								<%="1".equals(userDTO.getIsDepartmentMember()) ? "checked" : "" %> value="<%=userDTO.getId() %>"
								onclick="Liferay.Util.checkAllBox(<portlet:namespace />fm,'<portlet:namespace/>pmlUserId', checkallbox); checkUserIsDepLeader(this);" />
							</td>
							<td align="center"><%=i + 1 %></td>
							<td ><div align="left"><%=userDTO.getName() %></div></td>
							<td ><div align="left"><%=userDTO.getPosition() %></div></td>
						</tr>
					</logic:iterate>
				</table>
			</div>
			</td>
		</tr>

			<tr>
				<td ><liferay-ui:message key="active"/> :</td>
				<td align="left"><input type="checkbox" id="active" <%= department.getActive().equals("1") ? "checked" : "" %> name="<portlet:namespace />active" /></td>
			</tr>
		<tr v>
			<td><liferay-ui:message key="description"/> :</td>
			<td>
				<textarea style="width: 95%" rows="3" id="description" name="<portlet:namespace />description"><%=department.getDescription() %></textarea>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
					<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="update" />' />
					<input type="reset" value='<liferay-ui:message key="reset" />' />
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"  value='<liferay-ui:message key="back" />' /></span>
			</td>
		</tr>
	</table>
</div>
</form>