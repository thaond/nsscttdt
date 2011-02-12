<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>
<%
String redirect = ParamUtil.getString(request, "redirect");
%>
<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_company_logo" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="title_categ"><liferay-ui:message key="Thay-doi-logo"/></div>
<div class="boxcontent">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<liferay-util:include page="/html/portlet/enterprise_admin/tabs1.jsp"><liferay-util:param name="tabs1" value="settings" /></liferay-util:include>
<div class="boxcontent_Tab">
<liferay-ui:tabs names="enterprise-logo" />
<div class="boxcontent_Tab">
<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />

<input name="<portlet:namespace />fileName" size="50" type="file" />
<input type="submit" value="<liferay-ui:message key="save" />" />
<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
</div>
</div>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />fileName);
	</script>
</c:if>