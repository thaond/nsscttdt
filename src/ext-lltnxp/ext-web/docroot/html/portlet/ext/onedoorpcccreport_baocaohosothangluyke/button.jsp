<%@ include file="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/init.jsp" %>
	  
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	String fDate = (String) renderRequest.getAttribute("fromDate");
	String tDate = (String) renderRequest.getAttribute("toDate");
	String fTypeId = (String) renderRequest.getAttribute("fileTypeId");
	String dpartmentId = (String) renderRequest.getAttribute("departmentId");
	String ation = (String) renderRequest.getAttribute("action");
	
%>	  
	  
<portlet:renderURL var="search" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/search"/>
</portlet:renderURL>

	<!-- phmphuc them 20/05/2010 - xuat file cho bao cao -->
	<portlet:actionURL var="report" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails" />
		<portlet:param name="actionReport" value="report" />
	</portlet:actionURL>
	
	<portlet:actionURL var="report_word" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails" />
		<portlet:param name="actionReport" value="report" />
		<portlet:param name="reportType" value="word" />
		<portlet:param name="action" value="<%= ParamUtil.getString(renderRequest, "action") %>" />
		<portlet:param name="fromDate" value="<%= ParamUtil.getString(renderRequest, "fromDate") %>" />
		<portlet:param name="toDate" value="<%= ParamUtil.getString(renderRequest, "toDate") %>" />
		<portlet:param name="fileTypeId" value="<%= ParamUtil.getString(renderRequest, "fileTypeId") %>" />
		<portlet:param name="type" value="<%= ParamUtil.getString(renderRequest, "type") %>" />
		<portlet:param name="valueType" value="<%= ParamUtil.getString(renderRequest, "valueType") %>" />
		<portlet:param name="departmentId" value="<%= ParamUtil.getString(renderRequest, "departmentId") %>" />
		<portlet:param name="beginDateParam" value="<%= ParamUtil.getString(renderRequest, "beginDateParam") %>" />
		<portlet:param name="endDateParam" value="<%= ParamUtil.getString(renderRequest, "endDateParam") %>" />
		<portlet:param name="fileStateFilter" value="<%= ParamUtil.getString(renderRequest, "fileStateFilter") %>" />
	</portlet:actionURL>
	
	<portlet:actionURL var="report_excel" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails" />
		<portlet:param name="actionReport" value="report" />
		<portlet:param name="reportType" value="excel" />
		<portlet:param name="action" value="<%= ParamUtil.getString(renderRequest, "action") %>" />
		<portlet:param name="fromDate" value="<%= ParamUtil.getString(renderRequest, "fromDate") %>" />
		<portlet:param name="toDate" value="<%= ParamUtil.getString(renderRequest, "toDate") %>" />
		<portlet:param name="fileTypeId" value="<%= ParamUtil.getString(renderRequest, "fileTypeId") %>" />
		<portlet:param name="type" value="<%= ParamUtil.getString(renderRequest, "type") %>" />
		<portlet:param name="valueType" value="<%= ParamUtil.getString(renderRequest, "valueType") %>" />
		<portlet:param name="departmentId" value="<%= ParamUtil.getString(renderRequest, "departmentId") %>" />
		<portlet:param name="beginDateParam" value="<%= ParamUtil.getString(renderRequest, "beginDateParam") %>" />
		<portlet:param name="endDateParam" value="<%= ParamUtil.getString(renderRequest, "endDateParam") %>" />
		<portlet:param name="fileStateFilter" value="<%= ParamUtil.getString(renderRequest, "fileStateFilter") %>" />
	</portlet:actionURL>
	<!-- end -->
	
<script type="text/javascript">
	function openPopup(form) {
		var width = screen.width / 7;
		var dialogWidth = width * 5;
		var height = screen.height /5;
		var dialogHeight = height * 2;
		var property = 'dialogWidth:735px; dialogHeight:290px;dialogLeft:250px;dialogTop:250px;';
		var result = window.showModalDialog('<%=search %>',	'', property );
		if (result){
			document.getElementById("dataForSearch").value = result;
			form.submit();
		}
	}

	function processReport(typeProcess) {
		var formReport = document.getElementById("reportForm");
		if (typeProcess.id == "wordProcess") {
			formReport.action = '<%= report_word %>';
		} else if (typeProcess.id == "excelProcess") {
			formReport.action = '<%= report_excel %>';
		}
		formReport.submit();
	}
</script>

<portlet:renderURL var="searchFile">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/searchresult"/>
	<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>" value="true"/>
</portlet:renderURL>
	
<portlet:renderURL var="refresh">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails"/>
	<portlet:param name="fromDate"	value="<%= fDate %>" />
	<portlet:param name="toDate"	value="<%= tDate %>" />
	<portlet:param name="fileTypeId"	value="<%= fTypeId %>" />
	<portlet:param name="departmentId"	value="<%= dpartmentId %>" />
	<portlet:param name="action"	value="<%= ation %>" />
	<portlet:param name="redirect"	value="<%= redirect %>" />
</portlet:renderURL>

<portlet:renderURL var="back">
	<portlet:param name="fromDate"	value="<%= fDate %>" />
	<portlet:param name="toDate"	value="<%= tDate %>" />
	<portlet:param name="redirect"	value="<%= redirect %>" />
</portlet:renderURL>
	

		<form action="<%=searchFile %>" method="post">
			<%
				String default_landing_page_path = PropsUtil.get("default.landing.page.path");
			%>
			<a href="#" id="home" 
				onclick='document.getElementById("home").href = "http://" + location.host + "<%= default_landing_page_path %>" + "/trangchu";'>&nbsp;
					<img src="/html/images/nav_home_ico_01.png" title="<liferay-ui:message key="home" />"/>
			</a>		
			<img src="/html/images/nav_back_ico_02.png" onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" title="<liferay-ui:message key="back"/>"/>&nbsp;
			<a href="<%= refresh %>"><img src="/html/images/nav_refresh_ico_01.png" title="<liferay-ui:message key="refresh"/>"/></a>&nbsp;
			<!-- <input type="image" src="/html/images/find_ico_32_01.png" title="<liferay-ui:message key="search" />" onClick="openPopup(this.form)" />-->
			<a href="#" id="wordProcess" onclick="processReport(this);"><img src="/html/images/word.png"/></a>&nbsp;
			<a href="#" id="excelProcess" onclick="processReport(this);"><img src="/html/images/Excel.png"/></a>
			<input type="hidden" name="dataForSearch" id="dataForSearch" value="" />
		</form>
		
		<form id="reportForm" action="<%=report %>" method="post">
		</form>
			
	
