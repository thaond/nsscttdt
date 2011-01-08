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

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.sgs.portlet.home_report_onedoor.search.HomeReportOnedoorSearch"%>
<%@page import="com.sgs.portlet.home_report_onedoor.search.HomeReportOnedoorDisplayTerms"%>
<%@page import="com.sgs.portlet.home_report_onedoor.search.HomeReportOnedoorSearchTerms"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>