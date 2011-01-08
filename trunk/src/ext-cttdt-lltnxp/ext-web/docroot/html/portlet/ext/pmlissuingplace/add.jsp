<%@ include file="/html/portlet/ext/pmlissuingplace/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />checkForm(form) {
	if(form.<portlet:namespace />issuingPlaceName.value == "") {
		form.<portlet:namespace />issuingPlaceName.focus();
		return false;
	}
	return true;
}
</script>

<liferay-ui:tabs names="Add Issuing Place" backURL="#" />
<portlet:actionURL var="add_process_issuingplace">
	<portlet:param name="struts_action" value="/sgs/pmlissuingplace/view" />
	<portlet:param name="cmd" value="add_process" />
</portlet:actionURL>
<form action="<%= add_process_issuingplace %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-add">
<tr>
	<td width="10%"><liferay-ui:message key="pmlissuingplace.name" /></td>
	<td><input type="text" name="<portlet:namespace />issuingPlaceName" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.address" /></td>
	<td><input type="text" name="<portlet:namespace />address" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.email" /></td>
	<td><input type="text" name="<portlet:namespace />email" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.telephone" /></td>
	<td><input type="text" name="<portlet:namespace />telephone" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.mobile" /></td>
	<td><input type="text" name="<portlet:namespace />mobile" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td><liferay-ui:message key="pmlissuingplace.description" /></td>
	<td><textarea name="<portlet:namespace />description" class="form-textarea"></textarea></td>
</tr>
<tr>
	<td></td>
	<td>
		<input type="submit" value='<liferay-ui:message key="pmlissuingplace.button-add" />' />
	</td>
</tr>
</table>
</form>