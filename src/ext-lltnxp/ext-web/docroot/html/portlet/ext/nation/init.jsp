<%@ include file="/html/common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.util.List"%>
<%@page import="com.sgs.portlet.nation.model.Nation"%>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>