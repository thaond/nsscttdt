<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pmluser/js/pmluser.jsp"></liferay-util:include>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
	
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	User currentUser = (User) renderRequest.getAttribute("currentUser");
	PmlUser pmlUser = (PmlUser) renderRequest.getAttribute("pmlUser");
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pmluser/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="pmlUserId" value='<%= String.valueOf(currentUser.getUserId()) %>'/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<form name="<portlet:namespace />fm" action="<%= update %>" method="post" onsubmit="return validateEditPmlUser();">
	<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
	<div class="boxcontent">
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pmluser-thong-tin-dang-nhap"/></legend>
		<table width="100%" cellspacing="0">
			<tr>
				<td width="15%"><liferay-ui:message key="screen-name" /> :</td>
				<td><input style="width: 50%" type="text" id="screenName" name="screenName" value="<%=currentUser.getScreenName() %>" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="email" /> :</td>
				<td ><input style="width: 50%" type="text" id="email" name="email" value="<%=currentUser.getEmailAddress() %>" disabled="disabled" /></td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pmluser-thong-tin-ca-nhan"/></legend>
		<table width="100%" cellspacing="0">
			<tr>
				<td width="15%"><liferay-ui:message key="last-name" /> :</td>
				<td ><input style="width: 50%" type="text" id="lastName" name="<portlet:namespace />lastName" value="<%=currentUser.getLastName() %>" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="middle-name" /> :</td>
				<td><input style="width: 50%" type="text" id="middleName" name="<portlet:namespace />middleName" value="<%=currentUser.getMiddleName() %>" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="first-name" /> :</td>
				<td><input style="width: 50%" type="text" id="firstName" name="<portlet:namespace />firstName" value="<%=currentUser.getFirstName() %>" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="phone" /> :</td>
				<td><input style="width: 50%" type="text" id="phone" name="<portlet:namespace />phone" value="<%=pmlUser.getHandPhone() %>" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="gender" /> :</td>
				<td>
					<select style="width: 96%" id="gender" name="<portlet:namespace />gender" disabled="disabled">
						<option value="">[ <liferay-ui:message key="select" /> ]</option>
						<option <%=currentUser.isMale() ? "selected" : "" %> value="1"><liferay-ui:message key="male" /></option>
						<option <%=currentUser.isFemale() ? "selected" : "" %> value="0"><liferay-ui:message key="female" /></option>
					</select>
				</td>
			</tr>
			<tr>
				<td><liferay-ui:message key="receipt.position" /> <font color="red">(*)</font> :</td>
				<td>
					<select style="width: 96%" id="positionId" name="<portlet:namespace />positionId">
						<option value="0">[ <liferay-ui:message key="select" /> ]</option>
						<logic:iterate id="position" name="positionList" type="com.sgs.portlet.position.model.Position" indexId="i" scope="request">
						<option <%=pmlUser.getPositionId().equals(position.getPositionId()) ? "selected" : "" %> value="<%=position.getPositionId() %>"><%=position.getPositionName() %></option>
						</logic:iterate>
					</select>
				</td>
			</tr>
			<tr>
				<td><liferay-ui:message key="department_name" /> <font color="red">(*)</font> :</td>
				<td>
					<select style="width: 96%" id="departmentId" name="<portlet:namespace />departmentId">
						<option value="0">[ <liferay-ui:message key="select" /> ]</option>
						<logic:iterate id="department" name="departmentList" type="com.sgs.portlet.department.model.Department" indexId="i" scope="request">
						<option <%=pmlUser.getDepartmentsId().equals(department.getDepartmentsId()) ? "selected" : "" %> value="<%=department.getDepartmentsId() %>"><%=department.getDepartmentsName() %></option>
						</logic:iterate>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top"><liferay-ui:message key="description" /> :</td>
				<td ><textarea style="width: 95%" name="<portlet:namespace />note" id="note" rows="3"><%=pmlUser.getNote() %></textarea></td>
			</tr>
		</table>
	</fieldset>
	
	<table width="100%" cellspacing="0">
		<tr>
			<td width="15%"></td>
			<td>
				<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="update" />' />
				<input type="reset" value='<liferay-ui:message key="reset" />' />
				<span onclick="submitFormBack(document.<portlet:namespace />fm, '<%= redirect %>');"><input class="button" type="button" value='<liferay-ui:message key="back" />' /></span>
			</td>
		</tr>
	</table>
</div>
</form>