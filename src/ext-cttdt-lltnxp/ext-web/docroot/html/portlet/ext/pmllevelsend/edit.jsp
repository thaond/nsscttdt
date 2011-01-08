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

<jsp:useBean id="attLevelSend" class="com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl" scope="request" />
<%
String levelSendId = levelSend.getLevelSendId() + "";
String levelSendName = levelSend.getLevelSendName();
%>

<liferay-ui:tabs names="Eidt Level Send" backURL="#" />
<portlet:actionURL var="edit_process_levelsend">
	<portlet:param name="struts_action" value="/sgs/pmllevelsend/view" />
	<portlet:param name="cmd" value="edit_process" />
</portlet:actionURL>
<form action="<%= edit_process_levelsend %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-add">
<tr><td class="blank-height-10"></td></tr>
<tr>
	<td width="10%"><liferay-ui:message key="pmllevelsend.id" /></td>
	<td><input type="text" name="<portlet:namespace />levelSendId" value="<%= levelSendId %>" class="form-text-200" readonly /></td>
</tr>

<tr>
	<td width="15%"><liferay-ui:message key="pmllevelsend.name" /></td>
	<td><input type="text" name="<portlet:namespace />levelSendName" value="<%= levelSendName %>" class="form-text-200" /></td>
</tr>
<tr>
	<td></td>
	<td>
		<input type="submit" value='<liferay-ui:message key="pmllevelsend.button-update" />' />
	</td>
</tr>
</table>
</form>