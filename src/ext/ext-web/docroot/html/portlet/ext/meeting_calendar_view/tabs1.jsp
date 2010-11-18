<%@ include file="/html/portlet/ext/meeting_calendar_view/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
if(Validator.isNotNull(ParamUtil.getString(request, "tabs1"))){
	tabs1 = ParamUtil.getString(request, "tabs1");
}
//xuancong close tabs1Names = "lich-ngay,lich-tuan";
tabs1Names = "lich-ngay";
//xuancong close start
//if(PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(),"ADD_VIEW")){
//	tabs1Names = "lich-ngay,lich-tuan,setting";
//}
//xuancong close end
PortletURL tabs1URL = renderResponse.createRenderURL();

tabs1URL.setWindowState(WindowState.NORMAL);

tabs1URL.setParameter("struts_action", "/ext/meeting_calendar_view/view");
tabs1URL.setParameter("month", String.valueOf(selMonth));
tabs1URL.setParameter("day", String.valueOf(selDay));
tabs1URL.setParameter("year", String.valueOf(selYear));
%>

<liferay-ui:tabs
	names="<%= tabs1Names %>"
	url="<%= tabs1URL.toString() %>"
	value="<%= tabs1 %>"
/>
<%---
<liferay-ui:tabs
	names="<%= tabs1Names %>"
	url="<%= tabs1URL.toString() %>"
	value="<%= tabs1 %>"
	backURL="home"
/>
---%>
