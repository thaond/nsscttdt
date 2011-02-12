<%@ include file="/html/portlet/ext/home_report/init.jsp" %>

<script type="text/javascript" >

function <portlet:namespace/>enableItemsUser(flagDep) {
	var userIdChoice = "&<%= HomeReportDisplayTerms.USERID%>=0";
	if (flagDep=="false") {
		userIdChoice = "&<%= HomeReportDisplayTerms.USERID%>=" + document.getElementById("<portlet:namespace/>userId").value;
	}
	var departmentId = "&<%= HomeReportDisplayTerms.DEPARTMENTID%>=" + document.getElementById("<portlet:namespace/>departmentId").value;
	var loaiCongVan = "&<%= HomeReportDisplayTerms.LOAITHONGKE%>=" + document.getElementById("<portlet:namespace/>loaiCongVan").value;
	var fromDate = "&<%= HomeReportDisplayTerms.FROMDATE%>=" + document.getElementById("<portlet:namespace/>fromDate").value;
	var toDate = "&<%= HomeReportDisplayTerms.TODATE%>=" + document.getElementById("<portlet:namespace />toDate").value;
	var url = document.getElementById("<portlet:namespace/>url").value;

	url += userIdChoice + departmentId + loaiCongVan + fromDate + toDate;	

	// kiem tra tu ngay - den ngay
	var fromDate = document.getElementById('<portlet:namespace/>fromDate');
	var toDate = document.getElementById('<portlet:namespace/>toDate');

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != fromDate && "" != toDate) {
		strFromDate = fromDate.value.toString();
		objFromDate = sgs.stringToDate(strFromDate, "dmy");
		strToDate = toDate.value.toString();
		objToDate = sgs.stringToDate(strToDate, "dmy");
	}	

	if (objFromDate > objToDate) {
		alert('<liferay-ui:message key="error-date" />');
		toDate.focus();
	}

	else if(fromDate.value == "" || fromDate.value.trim().length == 0) {
		alert('<liferay-ui:message key="error-fromdate" />');
		fromDate.focus();
	}
	
	else if(toDate.value == "" || toDate.value.trim().length == 0) {
		alert('<liferay-ui:message key="error-todate" />');
		toDate.focus();
	}
	
	else if(isDate(fromDate.value) == false || isDate(toDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
	} 

	else {
		submitForm(document.<portlet:namespace />fmReport, url);
	}
}

</script>