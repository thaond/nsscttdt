<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	String errorAddSoVanBanNoiBo = (String) request.getAttribute("errorAddSoVanBanNoiBo");
	String errorEditSoVanBanNoiBo = (String) request.getAttribute("errorEditSoVanBanNoiBo");
	if (Validator.isNull(tab)){
		tab = "view_sovanbannoibo";
	}
	if(errorAddSoVanBanNoiBo != null){
		tab = "add_sovanbannoibo";
	}
	if(errorEditSoVanBanNoiBo != null){
		tab = "edit_sovanbannoibo";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("view_sovanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/sovanbannoibo/display.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_sovanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/sovanbannoibo/add_sovanbannoibo.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_sovanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/sovanbannoibo/edit_sovanbannoibo.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("config_loaivanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/sovanbannoibo/config_loaivanbannoibo.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("config_phongban") %>'>
		<liferay-util:include page="/html/portlet/ext/sovanbannoibo/config_phongban.jsp"></liferay-util:include>
	</c:when>
</c:choose>