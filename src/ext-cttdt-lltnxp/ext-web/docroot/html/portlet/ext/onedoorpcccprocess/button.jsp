<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%
	//minh update 20100517
	String dataForSearchB = renderRequest.getAttribute("dataForSearch") != null ? (String)renderRequest.getAttribute("dataForSearch") : "";
	String typeB = renderRequest.getAttribute("type") != null ? (String) renderRequest.getAttribute("type"): "";
	String valueTypeB = renderRequest.getAttribute("valueType") != null ? (String) renderRequest.getAttribute("valueType"): "";
	String beginDateParamB = renderRequest.getAttribute("beginDateParam") != null ? (String) renderRequest.getAttribute("beginDateParam"): "";
	String endDateParamB = renderRequest.getAttribute("endDateParam") != null ? (String) renderRequest.getAttribute("endDateParam"): "";	
	String fileTypeFilterB = renderRequest.getAttribute("fileTypeFilter") != null ? (String)renderRequest.getAttribute("fileTypeFilter") : "";
	
	String sortB = renderRequest.getAttribute("sort") != null ? (String) renderRequest.getAttribute("sort"): "";
	boolean loadDataB = renderRequest.getAttribute("loadData") != null ? (Boolean) renderRequest.getAttribute("loadData") : false;
	String processValueB = renderRequest.getAttribute("processValue") != null ? (String) renderRequest.getAttribute("processValue") :"";
	
	PortletURL redirectURL = renderResponse.createRenderURL();
	redirectURL.setWindowState(WindowState.NORMAL);

	if ("".equals(dataForSearchB)) {
		redirectURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	} else {
		redirectURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/searchresult");
	}
	
	redirectURL.setParameter("dataForSearch", dataForSearchB);
	redirectURL.setParameter("type", typeB);
	redirectURL.setParameter("valueType",valueTypeB);
	redirectURL.setParameter("beginDateParam", beginDateParamB);
	redirectURL.setParameter("endDateParam", endDateParamB);
	redirectURL.setParameter("fileTypeFilter", fileTypeFilterB);
	redirectURL.setParameter("sort", sortB);
	redirectURL.setParameter("loadData", String.valueOf(loadDataB));
	redirectURL.setParameter("processValue", processValueB);
	
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	backURL.setParameter("dataForSearch", dataForSearchB);
	backURL.setParameter("type", typeB);
	backURL.setParameter("valueType",valueTypeB);
	backURL.setParameter("beginDateParam", beginDateParamB);
	backURL.setParameter("endDateParam", endDateParamB);
	backURL.setParameter("fileTypeFilter", fileTypeFilterB);
	backURL.setParameter("sort", sortB);
	backURL.setParameter("loadData", String.valueOf(loadDataB));
	backURL.setParameter("processValue", processValueB);
	
	PortletURL forWardURL = renderResponse.createRenderURL();
	forWardURL.setWindowState(WindowState.NORMAL);
	forWardURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/searchresult");
	forWardURL.setParameter("dataForSearch", dataForSearchB);
	forWardURL.setParameter("type", typeB);
	forWardURL.setParameter("valueType",valueTypeB);
	forWardURL.setParameter("beginDateParam", beginDateParamB);
	forWardURL.setParameter("endDateParam", endDateParamB);
	forWardURL.setParameter("fileTypeFilter", fileTypeFilterB);
	forWardURL.setParameter("sort", sortB);
	forWardURL.setParameter("loadData", String.valueOf(loadDataB));
	forWardURL.setParameter("processValue", processValueB);
	
	//end minh update 20100517
 %> 
	

<portlet:renderURL var="search" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/search"/>
	</portlet:renderURL>
	
	<portlet:actionURL var="report" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view" />
		<portlet:param name="action" value="report" />
	</portlet:actionURL>
	
	<portlet:actionURL var="report_word" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view" />
		<portlet:param name="action" value="report" />
		<portlet:param name="reportType" value="word" />
		<portlet:param name="type" value="<%= ParamUtil.getString(renderRequest, "type") %>" />
		<portlet:param name="valueType" value="<%= ParamUtil.getString(renderRequest, "valueType") %>" />
		<portlet:param name="beginDateParam" value="<%= ParamUtil.getString(renderRequest, "beginDateParam") %>" />
		<portlet:param name="endDateParam" value="<%= ParamUtil.getString(renderRequest, "endDateParam") %>" />
		<portlet:param name="fileTypeFilter" value="<%= ParamUtil.getString(renderRequest, "fileTypeFilter") %>" />
		<portlet:param name="processValue" value="<%= ParamUtil.getString(renderRequest, "processValue") %>" />
	</portlet:actionURL>
	
	<portlet:actionURL var="report_excel" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view" />
		<portlet:param name="action" value="report" />
		<portlet:param name="reportType" value="excel" />
		<portlet:param name="type" value="<%= ParamUtil.getString(renderRequest, "type") %>" />
		<portlet:param name="valueType" value="<%= ParamUtil.getString(renderRequest, "valueType") %>" />
		<portlet:param name="beginDateParam" value="<%= ParamUtil.getString(renderRequest, "beginDateParam") %>" />
		<portlet:param name="endDateParam" value="<%= ParamUtil.getString(renderRequest, "endDateParam") %>" />
		<portlet:param name="fileTypeFilter" value="<%= ParamUtil.getString(renderRequest, "fileTypeFilter") %>" />
		<portlet:param name="processValue" value="<%= ParamUtil.getString(renderRequest, "processValue") %>" />
	</portlet:actionURL>
	
	<portlet:renderURL var="searchFile">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/searchresult"/>
		<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>" value="true"/>
	</portlet:renderURL>
	
	<!-- phmphuc them 19/05/2010 - xuat file cho phan search -->
	
	<portlet:actionURL var="report_word_search" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/searchresult" />
		<portlet:param name="action" value="report" />
		<portlet:param name="reportType" value="word" />
		<portlet:param name="type" value="<%= typeB %>" />
		<portlet:param name="valueType" value="<%= valueTypeB %>" />
		<portlet:param name="beginDateParam" value="<%= beginDateParamB %>" />
		<portlet:param name="endDateParam" value="<%= endDateParamB %>" />
		<portlet:param name="fileTypeFilter" value="<%= fileTypeFilterB %>" />
		<portlet:param name="sort" value="<%= sortB %>" />
		<portlet:param name="loadData" value="<%= String.valueOf(loadDataB) %>" />
		<portlet:param name="processValue" value="<%= processValueB %>" />
		<portlet:param name="dataForSearch" value="<%= dataForSearchB %>" />
	</portlet:actionURL>
	
	<portlet:actionURL var="report_excel_search" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/searchresult" />
		<portlet:param name="action" value="report" />
		<portlet:param name="reportType" value="excel" />
		<portlet:param name="type" value="<%= typeB %>" />
		<portlet:param name="valueType" value="<%= valueTypeB %>" />
		<portlet:param name="beginDateParam" value="<%= beginDateParamB %>" />
		<portlet:param name="endDateParam" value="<%= endDateParamB %>" />
		<portlet:param name="fileTypeFilter" value="<%= fileTypeFilterB %>" />
		<portlet:param name="sort" value="<%= sortB %>" />
		<portlet:param name="loadData" value="<%= String.valueOf(loadDataB) %>" />
		<portlet:param name="processValue" value="<%= processValueB %>" />
		<portlet:param name="dataForSearch" value="<%= dataForSearchB %>" />
	</portlet:actionURL>
	
	<!-- end -->
	
	
	<!--minh update 20100517-->
	<!-- portlet:renderURL var="redirect"-->
		<!-- portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view"/-->
	<!-- /portlet:renderURL-->
	<!--end minh update 20100517-->
	
	
<script type="text/javascript">
function openPopup(form) {
	var width = screen.width / 7;
	var dialogWidth = width * 5;
	var height = screen.height /5;
	var dialogHeight = height * 2;
	var property = 'dialogWidth:735px; dialogHeight:290px;dialogLeft:250px;dialogTop:250px;';
	var result = window.showModalDialog('<%=search %>',	'', property );
	if (result != "" && result != "_______________" && result != null){			
		document.getElementById("dataForSearch").value = result;
		form.action = "<%= searchFile %>" + '&dataForSearch=' + result;		
	} else {
		form.action="#";
	}
}

function processReport(typeProcess) {
	var formReport = document.getElementById("reportForm");
	if (typeProcess.id == "wordProcess") {
		formReport.action = '<%= report_word %>';
	} else if (typeProcess.id == "excelProcess") {
		formReport.action = '<%= report_excel %>';
	} else if (typeProcess.id == "wordProcessSearch") {
		formReport.action = '<%= report_word_search %>';
	} else if (typeProcess.id == "excelProcessSearch") {
		formReport.action = '<%= report_excel_search %>';
	}
	formReport.submit();
}

function agreeSubmit() {
	var url = document.getElementById('formSumit').action;
	
	if (url.substring(url.length-1,url.length) != "#") {
		document.getElementById('formSumit').action = url;
		return true;
	} else {		
		return false;
	}		
}
</script>
	
<!-- end -->

<form id="formSumit" action="#" method="post"  onsubmit="return agreeSubmit();">
		<%
			String default_landing_page_path = PropsUtil.get("default.landing.page.path");
		%>
		<a href="#" id="home" 
			onclick='document.getElementById("home").href = "http://" + location.host + "<%= default_landing_page_path %>" + "/trangchu";'>
				<img src="/html/images/nav_home_ico_01.png" title="<liferay-ui:message key="home" />"/>
		</a>
		
		<a href="<%= backURL.toString() %>"><img src="/html/images/nav_back_ico_02.png" title="<liferay-ui:message key="back"/>"/></a>
		<a href="<%= forWardURL.toString() %>"><img src="/html/images/nav_forward_ico_01.png" title="<liferay-ui:message key="forward"/>"/></a>
		<a href="<%= redirectURL.toString()  %>"><img src="/html/images/nav_refresh_ico_01.png" title="<liferay-ui:message key="refresh"/>"/></a>
		
		<input type="image" src="/html/images/find_ico_32_01.png" title="<liferay-ui:message key="search" />" onClick="openPopup(this.form)" />
		<input type="hidden" name="dataForSearch" id="dataForSearch" value="" />
		
		<!-- <input id="wordProcess" type="image" src="/html/images/word.png" name="image" onclick="processReport(this);">-->
		<!-- <input id="excelProcess" type="submit" value="Excel" onclick="processReport(this);">-->
		
		<!-- phmphuc them 19/05/2010 -->
		<%
		if ("".equals(dataForSearchB)) {
		%>
			<a href="#" id="wordProcess" onclick="processReport(this);"><img src="/html/images/word.png"/></a>
			<a href="#" id="excelProcess" onclick="processReport(this);"><img src="/html/images/Excel.png"/></a>
		<%
		} else {
		%>
			<a href="#" id="wordProcessSearch" onclick="processReport(this);"><img src="/html/images/word.png"/></a>
			<a href="#" id="excelProcessSearch" onclick="processReport(this);"><img src="/html/images/Excel.png"/></a>
		<%
		}
		%>
		
</form>
<form id="reportForm" action="<%=report %>" method="post"></form>

