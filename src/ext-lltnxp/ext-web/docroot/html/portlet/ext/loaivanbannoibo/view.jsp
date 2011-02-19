<%@ include file="/html/portlet/ext/loaivanbannoibo/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	String errorAddLoaiVanBanNoiBo = (String)request.getAttribute("errorAddLoaiVanBanNoiBo");
	String errorEditLoaiVanBanNoiBo = (String) request.getAttribute("errorEditLoaiVanBanNoiBo");
	if (Validator.isNull(tab)){
		tab = "view_loaivanbannoibo";
	}
	if(errorAddLoaiVanBanNoiBo != null){
		tab = "add_loaivanbannoibo";
	}
	if(errorEditLoaiVanBanNoiBo != null){
		tab = "edit_loaivanbannoibo";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("view_loaivanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/loaivanbannoibo/display.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_loaivanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/loaivanbannoibo/add_loaivanbannoibo.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_loaivanbannoibo") %>'>
		<liferay-util:include page="/html/portlet/ext/loaivanbannoibo/edit_loaivanbannoibo.jsp"></liferay-util:include>
	</c:when>
</c:choose>