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

<liferay-ui:tabs names="Add Level Send" backURL="#" />
<portlet:actionURL var="add_process_levelsend">
	<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
	<portlet:param name="cmd" value="add_process" />
</portlet:actionURL>
<form action="<%= add_process_levelsend %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-add">
<tr><td class="blank-height-10"></td></tr>
<tr>
	<td width="10%"><liferay-ui:message key="pmllevelsend.name" /></td>
	<td><input type="text" name="<portlet:namespace />levelSendName" value="" class="form-text-200" /></td>
</tr>
<tr>
	<td></td>
	<td>
		<input type="submit" value='<liferay-ui:message key="pmllevelsend.button-add" />' />
	</td>
</tr>
</table>
</form>