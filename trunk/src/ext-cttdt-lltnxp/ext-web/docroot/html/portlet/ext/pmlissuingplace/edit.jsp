<%@ include file="/html/portlet/ext/pmllevelsend/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />checkForm(form) {
	if(form.<portlet:namespace />levelSendName.value == "") {
		form.<portlet:namespace />levelSendName.focus();
		return false;
	}
	return true;
}
</script>

<jsp:useBean id="attIssuingPlace" class="com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl" scope="request" />
<liferay-ui:tabs names="Edit Issuing Place" backURL="#" />
<portlet:actionURL var="edit_process_issuingplace">
	<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
	<portlet:param name="cmd" value="edit_process" />
</portlet:actionURL>
<form action="<%= edit_process_issuingplace %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-add">
<tr>
	<td width="10%"><liferay-ui:message key="pmlissuingplace.id" /></td>
	<td><input type="text" name="<portlet:namespace />issuingPlaceId" value="<%= attIssuingPlace.getIssuingPlaceId() %>" class="form-text-200" readonly /></td>
</tr>
<tr>
	<td width="10%"><liferay-ui:message key="pmlissuingplace.name" /></td>
	<td><input type="text" name="<portlet:namespace />issuingPlaceName" value="<%= attIssuingPlace.getIssuingPlaceName() %>" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.address" /></td>
	<td><input type="text" name="<portlet:namespace />address" value="<%= attIssuingPlace.getAddress() %>" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.email" /></td>
	<td><input type="text" name="<portlet:namespace />email" value="<%= attIssuingPlace.getEmail() %>" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.telephone" /></td>
	<td><input type="text" name="<portlet:namespace />telephone" value="<%= attIssuingPlace.getTablephone() %>" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.mobile" /></td>
	<td><input type="text" name="<portlet:namespace />mobile" value="<%= attIssuingPlace.getHandphone() %>" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.description" /></td>
	<td><textarea name="<portlet:namespace />description" class="form-textarea"><%= attIssuingPlace.getNote() %></textarea></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.active" /></td>
	<td><input type="checkbox" name="<portlet:namespace />active" id="<portlet:namespace />active" value="1" <% if(attIssuingPlace.getActive().equals("1")) { %>checked<% } %> /></td>
</tr>
<tr>
	<td></td>
	<td>
		<input type="submit" value='<liferay-ui:message key="pmlissuingplace.button-update" />' />
	</td>
</tr>
</table>
</form>