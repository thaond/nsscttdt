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
<%@ page import="com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil"%>

<%@ page import="com.sgs.portlet.pml_do_quan_trong.search.PmlDoQuanTrongDisplayTerms" %>
<%@ page import="com.sgs.portlet.pml_do_quan_trong.search.PmlDoQuanTrongSearchTerms" %>
<%@ page import="com.sgs.portlet.pml_do_quan_trong.search.PmlDoQuanTrongSearch" %>
<%@ page import="com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongTenDoQuanTrongException"%>
<%@ page import="com.sgs.portlet.pml_do_quan_trong.PmlDoQuanTrongCanNotDeleteException"%>


<portlet:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();
%>