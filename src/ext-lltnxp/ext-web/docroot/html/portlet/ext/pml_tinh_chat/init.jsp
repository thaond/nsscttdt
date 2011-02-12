<%@ page language="java" pageEncoding="utf-8"%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>

<%@ page import="javax.portlet.PortletContext"%>
<%@ page import="javax.portlet.PortletException"%>
<%@ page import="javax.portlet.PortletRequestDispatcher"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>

<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.ext.portal.util.PortletKeysExt" %>
<%@ page import="com.ext.portal.util.WebKeysExt" %>
<%@ page import="com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil"%>

<%@ page import="com.sgs.portlet.pml_tinh_chat.search.PmlTinhChatDisplayTerms" %>
<%@ page import="com.sgs.portlet.pml_tinh_chat.search.PmlTinhChatSearchTerms" %>
<%@ page import="com.sgs.portlet.pml_tinh_chat.search.PmlTinhChatSearch" %>
<%@ page import="com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.sgs.portlet.pml_tinh_chat.PmlTinhChatTenTinhChatException"%>
<%@page import="com.sgs.portlet.pml_tinh_chat.PmlTinhChatCanNotDeleteException"%>

<portlet:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();
%>