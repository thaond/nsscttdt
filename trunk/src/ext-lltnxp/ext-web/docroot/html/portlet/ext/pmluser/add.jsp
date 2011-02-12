<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pmluser/js/pmluser.jsp"></liferay-util:include>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
%>
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/pmluser/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>
<div class="title_categ"><liferay-ui:message key="pmluser-them-moi-nguoi-dung"/></div>
	<div class="boxcontent">
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pmluser-thong-tin-dang-nhap"/></label>
		<table width="100%" cellspacing="0">
		
			<tr>
				<td width="15%"><liferay-ui:message key="screen-name" /> <font color="red">(*)</font> :</td>
				<td ><input style="width: 50%" type="text" id="screenName" name="screenName" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="email" /> <font color="red">(*)</font> :</td>
				<td><input style="width: 50%" type="text" id="email" name="email" onblur="validateEmail(this)"/></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="password" /> <font color="red">(*)</font> :</td>
				<td><input style="width: 50%" type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="re-password" /> <font color="red">(*)</font> :</td>
				<td><input style="width: 50%" type="password" id="retypePassword" name="retypePassword" /></td>
			</tr>
			
		</table>
	</fieldset>
	
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pmluser-thong-tin-ca-nhan"/></label>
		
		<table width="100%" cellspacing="0">
		
			<tr>
				<td width="15%"><liferay-ui:message key="last-name" /> <font color="red">(*)</font> :</td>
				<td ><input style="width: 50%" type="text" id="lastName" name="<portlet:namespace />lastName"/></td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="middle-name" /> :</td>
				<td><input style="width: 50%" type="text" id="middleName" name="<portlet:namespace />middleName"/></td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="first-name" /> <font color="red">(*)</font> :</td>
				<td><input style="width: 50%" type="text" id="firstName" name="<portlet:namespace />firstName"/></td>
			</tr>

			<tr>
				<td><liferay-ui:message key="phone" /></td>
				<td><input style="width: 50%" type="text" id="phone" name="<portlet:namespace />phone" /></td>
			</tr>

			<tr>
				<td><liferay-ui:message key="gender" /> <font color="red">(*)</font> :</td>
				<td>
					<select style="width: 10%" id="gender" name="<portlet:namespace />gender">
						<option value="">[ <liferay-ui:message key="select" /> ]</option>
						<option value="1"><liferay-ui:message key="male" /></option>
						<option value="0"><liferay-ui:message key="female" /></option>
					</select>
				</td>
			</tr>

			<tr>
				<td><liferay-ui:message key="receipt.position" /> <font color="red">(*)</font> :</td>
				<td>
					<select style="width: 95%" id="positionId" name="<portlet:namespace />positionId">
						<option value="0">[ <liferay-ui:message key="select" /> ]</option>
						<logic:iterate id="position" name="positionList" type="com.sgs.portlet.position.model.Position" indexId="i" scope="request">
						<option value="<%=position.getPositionId() %>"><%=position.getPositionName() %></option>
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
						<option value="<%=department.getDepartmentsId() %>"><%=department.getDepartmentsName() %></option>
						</logic:iterate>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top"><liferay-ui:message key="description" /> :</td>
				<td><textarea style="width: 95%" name="<portlet:namespace />note" id="note" rows="3"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td>
						<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="save" />' />
						<input  type="reset" value='<liferay-ui:message key="reset" />' />
						<a href="<%= redirect %>"><input  type="button" value='<liferay-ui:message key="back" />' /></a>
				</td>
			</tr>
</table>
		
	</fieldset>
	</div>
</form>