<%@ include file="/html/common/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

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

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.sgs.portlet.home_report.search.HomeReportDisplayTerms"%>
<%@page import="com.sgs.portlet.home_report.search.HomeReportSearch"%>
<%@page import="com.sgs.portlet.home_report.search.HomeReportSearchTerms"%>

<%@page import="com.sgs.portlet.home_report.search.DocumentReceiptViewListDisplayTerms"%>
<%@page import="com.sgs.portlet.home_report.search.DocumentReceiptViewListSearch"%>
<%@page import="com.sgs.portlet.home_report.search.DocumentReceiptViewListSearchTerms"%>

<%@page import="com.sgs.portlet.home_report.search.DocumentSendViewListDisplayTerms"%>
<%@page import="com.sgs.portlet.home_report.search.DocumentSendViewListSearch"%>
<%@page import="com.sgs.portlet.home_report.search.DocumentSendViewListSearchTerms"%>

<%@page import="com.sgs.portlet.home_report.util.HomeReportDWRUtil"%>

<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

