<%@ include file="/html/common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	}
	
	long imageUpload = GetterUtil.getLong(prefs.getValue("imageUpload", "0"));
	String urlImageHome = GetterUtil.getString(prefs.getValue("urlImageHome", ""));
	String descriptionImageHome = GetterUtil.getString(prefs.getValue("descriptionImageHome", ""));
	
%>