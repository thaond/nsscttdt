<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%
	String tabAddReportRegistry = (String) request.getAttribute("tabAddReportRegistry");
	String tabAddDepartment = (String) request.getAttribute("tabAddDepartment");

	String tab = ParamUtil.getString(request, "tab");
	if (Validator.isNull(tab)){
		tab = "view_department";
	}
	if(tabAddReportRegistry != null){
		tab = tabAddReportRegistry;
	}
	if(tabAddDepartment != null){
		tab = tabAddDepartment;
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("view_department") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work/display.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_department") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work/add_department.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_department") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work/edit_department.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_report_registry") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work/add_report_registry.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_report_registry") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work/edit_report_registry.jsp"></liferay-util:include>
	</c:when>
</c:choose>