<%@ include file="/html/portlet/nss/department/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.department.model.Department"%>
<%@page import="com.nss.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.nss.portlet.department.DepartmentCodeSameCodeException"%>

<%
	List<Department> departmentParentIdList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId();
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	String departmentFlag = request.getAttribute("departmentFlag") == null ? "" : String.valueOf(request.getAttribute("departmentFlag"));
	String departmentParentId = "";
	String departmentCode = "";
	String departmentName = "";
	String abbreviateName = "";
	String agencyId = "";
	String[] pmlUserIdArr = null;
	long userIdChoose = 0;
	Boolean active = true;
	String description = "";
	if (departmentFlag.equals("fail")) { // Them that bai
		departmentParentId = ParamUtil.getString(request, "departmentParentId", "");
		departmentCode = ParamUtil.getString(request, "departmentCode", "");
		departmentName = ParamUtil.getString(request, "departmentName", "");
		abbreviateName = ParamUtil.getString(request, "abbreviateName", "");
		agencyId = ParamUtil.getString(request, "departmentAgency", "");
		pmlUserIdArr = request.getParameterValues("pmlUserId");
		active = ParamUtil.getBoolean(request, "active");
		description = ParamUtil.getString(request, "description", "");
	}
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/nss/department/add"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<form action="<%=add %>" method="post" name="<portlet:namespace />fm" onsubmit="return validateAddForm();"  enctype="multipart/form-data">
<liferay-ui:error exception="<%= DepartmentCodeSameCodeException.class %>" message="ma-phong-ban-khong-duoc-trung" />
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="them-moi-phong-ban"/></div>
	<table align="center" width="100%">
		<tr >
			<td width="20%"><liferay-ui:message key="department_code"/> <font color="red">(*)</font> :</td>
			<td >
				<input style="width: 95%" type="text" id="departmentCode" name="<portlet:namespace />departmentCode" value="<%= departmentCode %>"/>
			</td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_name"/> <font color="red">(*)</font> :</td>
			<td><input style="width: 95%" type="text" id="departmentName" name="<portlet:namespace />departmentName" value="<%= departmentName %>"/></td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="abbreviate_name"/> <font color="red">(*)</font> :</td>
			<td><input style="width: 95%" type="text" id="abbreviateName" name="<portlet:namespace />abbreviateName" value="<%= abbreviateName %>"/></td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_agency"/> <font color="red">(*)</font> :</td>
			<td>
				<select style="width: 96%" id="departmentAgency" name="<portlet:namespace />departmentAgency">
					<logic:iterate id="agency" name="agencyList" indexId="i" type="com.nss.portlet.agency.model.Agency" scope="request" >
						<option value="<%= agency.getAgencyId() %>" 
										<% if(agency.getAgencyId().equals(agencyId)) { %>selected="selected"<% } %>>
										<%= agency.getAgencyName() %>
						</option>
					</logic:iterate>
				</select>
			</td>
		</tr>
		
		<tr>
			<td><liferay-ui:message key="department_phutrach"/> :</td>
			<td class="td_input_base">
				<select name="<portlet:namespace />departmentParentId" id="departmentParentId" style="width: 96%">
					<option value=""><liferay-ui:message key="chon"/></option>
				<%
					for (int idx = 0; idx < (departmentParentIdList == null ? 0 : departmentParentIdList.size()); idx ++) {
						Department departmentItem = (Department) departmentParentIdList.get(idx);
					%>
						<option value="<%= departmentItem.getPrimaryKey() %>"
										<% if(departmentItem.getDepartmentsId().equals(departmentParentId)) { %>selected="selected"<% } %>> 
										<%= departmentItem.getDepartmentsName() %></option>
					<%
					}
				%>
						
				</select>
			</td>
		</tr>
		
		<tr valign="top">
			<td><liferay-ui:message key="user"/> :</td>
			<td>
				<div style="width: 96%;">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
							<td width="2%" align="center">
								<input class="styled" type="checkbox"
									<% 
										if (ParamUtil.getBoolean(request, "checkallbox")) {
									%> 
									checked="checked"<% } %>
									onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<portlet:namespace/>pmlUserId', this);"
									name="checkallbox" id="checkallbox"/>
							</td>
							<td width="8%" align="center"><liferay-ui:message key="STT"/></td>
							<td width="60%"><liferay-ui:message key="name" /></td>
							<td ><liferay-ui:message key="position_" /></td>
						</tr>
						
						<logic:iterate id="userDTO" name="userList" indexId="i" type="com.nss.portlet.department.util.PmlUserDTO" scope="request" >					
							<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}" >
								<td id="<%=i %>" align="center">
									<input type="checkbox" name="<portlet:namespace/>pmlUserId" id="pmlUserId<%=i %>" 
											value="<%= userDTO.getId() %>" 
											<% 
												if (pmlUserIdArr != null) {
													for (int k = 0; k < pmlUserIdArr.length; k ++) {
														userIdChoose = Long.parseLong(pmlUserIdArr[k]);
														if(userDTO.getId() == userIdChoose) { 
											%> 
											checked="checked"<% }}} %>
											onclick="Liferay.Util.checkAllBox(<portlet:namespace />fm,'<portlet:namespace/>pmlUserId', checkallbox);" />
								</td>
								<td align="center"><%=i + 1 %></td>
								<td ><%=userDTO.getName() %></td>
								<td ><%=userDTO.getPosition() %></td>
							</tr>
							
						</logic:iterate>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td ><liferay-ui:message key="active"/> :</td>
			<td><input type="checkbox" name="active" id="active" checked="checked" value="<%= active %>"/></td>
		</tr>
		<tr valign="top">
			<td><liferay-ui:message key="description"/> :</td>
			<td>
				<textarea style="width: 95%" rows="3" id="description" name="<portlet:namespace />description"><%= description %></textarea>
			</td>
		</tr>
	
		<tr>
			<td></td>
			<td>
				<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="luu" />' />
				<input type="reset" value='<liferay-ui:message key="reset" />' />
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button" value='<liferay-ui:message key="back" />' /></span>
			</td>
		</tr>
	</table>
</div>
</form>
<script type="text/javascript">
function validateAddForm() {
	var departmentCode = document.getElementById("departmentCode");
	var departmentName = document.getElementById("departmentName");
	var abbreviateName = document.getElementById("abbreviateName");
	if (departmentCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-phong-ban' />");
		departmentCode.focus()
		return false;
	}
	if (departmentName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-phong-ban' />");
		departmentName.focus()
		return false;
	}
	if (abbreviateName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-viet-tat' />");
		abbreviateName.focus()
		return false;
	}
	else {
		return true;
	}
}
</script>