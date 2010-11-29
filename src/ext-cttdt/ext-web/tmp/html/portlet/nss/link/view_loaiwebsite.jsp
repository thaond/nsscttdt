<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String tabs = ParamUtil.getString(renderRequest,"tabs","view_loaiWebsite");
	String tabLoai = ParamUtil.getString(request, "tabLoai");
	PortletURL portletURLLoai = renderResponse.createRenderURL();
	portletURLLoai.setWindowState(WindowState.NORMAL);
	portletURLLoai.setParameter("struts_action", "/nss/link/view");
	if (Validator.isNull(tabLoai)) {
		tabLoai = "display_loai";
	}
	portletURLLoai.setParameter("tabLoai", tabLoai);
	portletURLLoai.setParameter("tabs", tabs);
%>
<c:choose>
	<c:when test='<%=tabLoai.equals("display_loai")%>'>
		<liferay-util:include
			page="/html/portlet/nss/link/display_loaiwebsite.jsp" />
	</c:when>

	<c:when test='<%=tabLoai.equals("add_loai")%>'>
		<liferay-util:include
			page="/html/portlet/nss/link/add_loaiwebsite.jsp" />
	</c:when>
</c:choose>