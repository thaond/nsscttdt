<%@ include file="/html/common/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="java.util.List"%>
<%@ page import="com.sgs.portlet.department.model.DepartmentModel"%>
<%@ page import="com.sgs.portlet.department.model.Department"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>
