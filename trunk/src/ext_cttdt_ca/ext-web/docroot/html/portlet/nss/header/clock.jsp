<%@ include file="/html/portlet/nss/header/init.jsp" %>

<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>

<%
DateFormat df = new SimpleDateFormat("HH : mm : ss", new Locale("vi", "VN"));
%>

<span id="timeField_"><%=df.format(new Date()) %></span>
