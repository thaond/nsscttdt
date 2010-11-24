<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>

<% 

String userId = (String) request.getAttribute("userId");
PortletURL portletURL = renderResponse.createActionURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("struts_action", "/nss/image_signer/view");
portletURL.setParameter("userId", userId);

%>
 userId <%=userId%>



<form action="<%=portletURL.toString() %>" enctype="multipart/form-data" method="post">
ImageSign <input type="file" name="<portlet:namespace/>imageSign"><br>
ImageUnSign <input type="file" name="<portlet:namespace/>imageUnSign"><br>
<input type="submit" value="upload">
</form>



