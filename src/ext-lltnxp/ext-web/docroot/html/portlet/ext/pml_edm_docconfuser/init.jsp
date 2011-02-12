<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Arrays"%>
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

<%@page import="com.liferay.portal.kernel.xml.Document" %>
<%@page import="com.liferay.portal.kernel.xml.Element" %>
<%@page import="com.liferay.portal.kernel.xml.Node" %>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@page import="com.liferay.portal.kernel.xml.XPath" %>
<%@page import="com.liferay.portal.util.LayoutLister" %>
<%@page import="com.liferay.portal.util.LayoutView" %>
<%@page import="com.liferay.portal.webdav.WebDAVUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>
<%
PortletPreferences preferences = renderRequest.getPreferences();
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

%>