<%@ include file="/html/portlet/nss/journalworkflow/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);
	
	if (originalRedirect.equals(StringPool.BLANK)) {
		originalRedirect = redirect;
	}
	else {
		redirect = originalRedirect;
	}
	String definition = "";
%>

<portlet:actionURL var="addBusinessProcessURL">
	<portlet:param name="struts_action" value="/nss/journalworkflow/view"/>
	<portlet:param name="<%=Constants.CMD %>" value="addBusinessProcess"/>
</portlet:actionURL>

<form method="post" action="<%=addBusinessProcessURL %>">
<div class="parent-title"><liferay-ui:message key="Them-quy-trinh"/></div>
		<input name="<portlet:namespace />originalRedirect"	type="hidden" value="<%=HtmlUtil.escape(originalRedirect)%>" />
		<liferay-ui:tabs names="process-definition" formName="fm1" backURL="<%= redirect %>" />
		<div class="borderendTab">
		<liferay-ui:input-textarea param="bpdText"></liferay-ui:input-textarea><br><br>
		<input type="submit" value="<liferay-ui:message key="add"/>" />
		<input type="button" value="<liferay-ui:message key="cancel"/>" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';"/>
		</div>
</form>
