<%@ include file="/html/portlet/ext/pml_edm_docconfuser/init.jsp" %>

<liferay-ui:tabs names="error" backURL="javascript: history.go(-1);" />

<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />