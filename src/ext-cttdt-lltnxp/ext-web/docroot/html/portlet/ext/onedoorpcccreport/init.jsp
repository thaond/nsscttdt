<%@ include file="/html/common/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccreport/style.css" />
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

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<script type="text/javascript">
function <portlet:namespace/>compare2Date(fromDate, toDate) {
	
	var strFromDate = fromDate.value.toString();
	var objFromDate = sgs.stringToDate(strFromDate,"dmy");
	var strToDate = toDate.value.toString();
	var objToDate = sgs.stringToDate(strToDate,"dmy");

	if(objFromDate > objToDate) {
		return false;
	}
	return true;
}
function <portlet:namespace/>checkForm(form) {
	var fromDate = document.getElementById('<portlet:namespace/>fromDate');
	var toDate = document.getElementById('<portlet:namespace/>toDate');
	if(fromDate.value == "") {
		fromDate.focus();
		return false;
	}
	if(isDate(fromDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		fromDate.focus();
		return false;
	} 
	if(toDate.value == "") {
		toDate.focus();
		return false;
	}
	if(isDate(toDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		toDate.focus();
		return false;
	}
	if(<portlet:namespace/>compare2Date(fromDate, toDate) == false) {
		alert("Ch\u1ecdn ng\u00e0y th\u1ed1ng k\u00ea kh\u00f4ng ch\u00ednh x\u00e1c.\n('T\u1eeb ng\u00e0y' ph\u1ea3i nh\u1ecf h\u01a1n ho\u1eb7c b\u1eb1ng '\u0110\u1ebfn ng\u00e0y').");
		fromDate.focus();
		return false;
	}
	return true;
}
</script>