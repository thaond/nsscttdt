<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<liferay-ui:tabs names="error" backURL="javascript: history.go(-1);" />

<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />