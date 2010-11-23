<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<%
	String tabs = ParamUtil.getString(request, "tabs");
	PortletURL portletURL = renderResponse.createRenderURL();
	if (Validator.isNull(tabs)) {
		tabs = "display";
	}
	portletURL.setParameter("tabs", tabs);
%>

<c:choose>
	<c:when test='<%=tabs.equals("display")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_tra_loi/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("answer")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_tra_loi/answer.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("detail")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_tra_loi/detail.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("edit_question")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_tra_loi/edit_question.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("edit_answer")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_tra_loi/edit_answer.jsp" /></div>
	</c:when>
	
</c:choose>