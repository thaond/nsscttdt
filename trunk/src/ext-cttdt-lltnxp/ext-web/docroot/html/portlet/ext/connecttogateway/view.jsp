<%@page import="com.sgs.portlet.connecttogateway.action.ConnectionToGatewayContant"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/ext/connecttogateway/init.jsp" %>


<%
	
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	}
	
	boolean flagRunThread = GetterUtil.getBoolean(prefs.getValue("flagRunThread", String.valueOf(true)));
	boolean flagStopThread = GetterUtil.getBoolean(prefs.getValue("flagStopThread", String.valueOf(false)));
	boolean flagRunTimer = GetterUtil.getBoolean(prefs.getValue("flagRunTimer", String.valueOf(true)));
	boolean flagStopTimer = GetterUtil.getBoolean(prefs.getValue("flagStopTimer", String.valueOf(false)));
	
	boolean flagRunThreadEOrg = GetterUtil.getBoolean(prefs.getValue("flagRunThreadEOrg", String.valueOf(true)));
	boolean flagStopThreadEOrg = GetterUtil.getBoolean(prefs.getValue("flagStopThreadEOrg", String.valueOf(false)));
	boolean flagRunTimerEOrg  = GetterUtil.getBoolean(prefs.getValue("flagRunTimerEOrg", String.valueOf(true)));
	boolean flagStopTimerEOrg = GetterUtil.getBoolean(prefs.getValue("flagStopTimerEOrg", String.valueOf(false)));
	
	
	String action = ParamUtil.getString(renderRequest, "action", "");
	
	String tabs = ParamUtil.getString(renderRequest, "tabs", "van-ban");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/connecttogateway/view");
	portletURL.setParameter("tabs", tabs);
	portletURL.setParameter("flagRunThread", String.valueOf(flagRunThread));
	portletURL.setParameter("flagStopThread", String.valueOf(flagStopThread));
	portletURL.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
	portletURL.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
	
	portletURL.setParameter("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
	portletURL.setParameter("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
	portletURL.setParameter("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
	portletURL.setParameter("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
	portletURL.setParameter("action", action);
	
%>
<script type="text/javascript">
	function callAction(url) {
		document.<portlet:namespace/>fm.action = url;
		document.<portlet:namespace/>fm.submit();
	}
</script>

<form action=""  method="post" name='<portlet:namespace/>fm'>
<div class="title_categ"><liferay-ui:message key="connet-to-gateway"/></div>
<div class="boxcontent" >
	<liferay-ui:tabs names="van-ban,to-chuc,goi-mail" param="tabs"  url="<%= portletURL.toString()%>" value="<%= tabs %>"/>
	<div class="boxcontent_Tab">
	<c:choose>
		<c:when test='<%= tabs.equals("van-ban") %>'>
			<%
			// document create thread
			PortletURL createThread = renderResponse.createActionURL();
			createThread.setWindowState(WindowState.NORMAL);
			createThread.setParameter("struts_action", "/sgs/connecttogateway/view");
			createThread.setParameter("tabs", tabs);
			createThread.setParameter("action", ConnectionToGatewayContant.CREATETHREADDOC);
			createThread.setParameter("flagRunThread", String.valueOf(false));
			createThread.setParameter("flagStopThread", String.valueOf(true));
			createThread.setParameter("flagRunTimer", String.valueOf(false));
			createThread.setParameter("flagStopTimer", String.valueOf(false));
			
			createThread.setParameter("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
			createThread.setParameter("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
			createThread.setParameter("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
			createThread.setParameter("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
			
			// document stop thread
			PortletURL stopThread = renderResponse.createActionURL();
			stopThread.setWindowState(WindowState.NORMAL);
			stopThread.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopThread.setParameter("tabs", tabs);
			stopThread.setParameter("action", ConnectionToGatewayContant.STOPTHREADDOC);
			stopThread.setParameter("flagRunThread", String.valueOf(true));
			stopThread.setParameter("flagStopThread", String.valueOf(false));
			stopThread.setParameter("flagRunTimer", String.valueOf(true));
			stopThread.setParameter("flagStopTimer", String.valueOf(false));
			
			stopThread.setParameter("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
			stopThread.setParameter("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
			stopThread.setParameter("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
			stopThread.setParameter("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
			
			// document create timer
			PortletURL createTimer = renderResponse.createActionURL();
			createTimer.setWindowState(WindowState.NORMAL);
			createTimer.setParameter("struts_action", "/sgs/connecttogateway/view");
			createTimer.setParameter("tabs", tabs);
			createTimer.setParameter("action", ConnectionToGatewayContant.CREATETIMERDOC);
			createTimer.setParameter("flagRunThread", String.valueOf(false));
			createTimer.setParameter("flagStopThread", String.valueOf(false));
			createTimer.setParameter("flagRunTimer", String.valueOf(false));
			createTimer.setParameter("flagStopTimer", String.valueOf(true));
			
			createTimer.setParameter("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
			createTimer.setParameter("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
			createTimer.setParameter("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
			createTimer.setParameter("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
			
			// document stop timer
			PortletURL stopTimer = renderResponse.createActionURL();
			stopTimer.setWindowState(WindowState.NORMAL);
			stopTimer.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopTimer.setParameter("tabs", tabs);
			stopTimer.setParameter("action", ConnectionToGatewayContant.STOPTIMERDOC);
			stopTimer.setParameter("flagRunThread", String.valueOf(true));
			stopTimer.setParameter("flagStopThread", String.valueOf(false));
			stopTimer.setParameter("flagRunTimer", String.valueOf(true));
			stopTimer.setParameter("flagStopTimer", String.valueOf(false));
			
			stopTimer.setParameter("flagRunThreadEOrg", String.valueOf(flagRunThreadEOrg));
			stopTimer.setParameter("flagStopThreadEOrg", String.valueOf(flagStopThreadEOrg));
			stopTimer.setParameter("flagRunTimerEOrg", String.valueOf(flagRunTimerEOrg));
			stopTimer.setParameter("flagStopTimerEOrg", String.valueOf(flagStopTimerEOrg));
			
			%>

			<span style='display:<%= (flagRunThread? "inline" :"none") %>' onclick="callAction('<%= createThread.toString() %>');">
				<input id="create_thread" type="button" value='<liferay-ui:message key="create-connection-by-thread"/>' />
			</span>
				
			<span style='display:<%= (flagStopThread? "inline" :"none") %>' onclick="callAction('<%= stopThread.toString() %>');">
				<input id="stop_thread" type="button" value='<liferay-ui:message key="stop-thread"/>' />
			</span>
				
			<span style='display:<%= (flagRunTimer? "inline" :"none") %>' onclick="callAction('<%= createTimer.toString() %>');">
				<input id="create_timer" type="button" value='<liferay-ui:message key="create-connection-by-timer"/>' />
			</span>
				
			<span style='display:<%= (flagStopTimer? "inline" :"none") %>' onclick="callAction('<%= stopTimer.toString() %>');">
				<input id="stop_timer" type="button" value='<liferay-ui:message key="stop-timer"/>' />
			</span>
		
		</c:when>
		
		<c:when test='<%= tabs.equals("to-chuc")%>'>
			<!-- ket noi van ban -->
			<%
			// external organization create thread
			PortletURL createThreadEOrg = renderResponse.createActionURL();
			createThreadEOrg.setWindowState(WindowState.NORMAL);
			createThreadEOrg.setParameter("struts_action", "/sgs/connecttogateway/view");
			createThreadEOrg.setParameter("tabs", tabs);
			createThreadEOrg.setParameter("action", ConnectionToGatewayContant.CREATETHREADEORG);
			createThreadEOrg.setParameter("flagRunThreadEOrg", String.valueOf(false));
			createThreadEOrg.setParameter("flagStopThreadEOrg", String.valueOf(true));
			createThreadEOrg.setParameter("flagRunTimerEOrg", String.valueOf(false));
			createThreadEOrg.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			createThreadEOrg.setParameter("flagRunThread", String.valueOf(flagRunThread));
			createThreadEOrg.setParameter("flagStopThread", String.valueOf(flagStopThread));
			createThreadEOrg.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			createThreadEOrg.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization stop thread
			PortletURL stopThreadEOrg = renderResponse.createActionURL();
			stopThreadEOrg.setWindowState(WindowState.NORMAL);
			stopThreadEOrg.setParameter("tabs", tabs);
			stopThreadEOrg.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopThreadEOrg.setParameter("action", ConnectionToGatewayContant.STOPTHREADEORG);
			stopThreadEOrg.setParameter("flagRunThreadEOrg", String.valueOf(true));
			stopThreadEOrg.setParameter("flagStopThreadEOrg", String.valueOf(false));
			stopThreadEOrg.setParameter("flagRunTimerEOrg", String.valueOf(true));
			stopThreadEOrg.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			stopThreadEOrg.setParameter("flagRunThread", String.valueOf(flagRunThread));
			stopThreadEOrg.setParameter("flagStopThread", String.valueOf(flagStopThread));
			stopThreadEOrg.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			stopThreadEOrg.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization create timer
			PortletURL createTimerEOrg = renderResponse.createActionURL();
			createTimerEOrg.setWindowState(WindowState.NORMAL);
			createTimerEOrg.setParameter("struts_action", "/sgs/connecttogateway/view");
			createTimerEOrg.setParameter("tabs", tabs);
			createTimerEOrg.setParameter("action", ConnectionToGatewayContant.CREATETIMEREORG);
			createTimerEOrg.setParameter("flagRunThreadEOrg", String.valueOf(false));
			createTimerEOrg.setParameter("flagStopThreadEOrg", String.valueOf(false));
			createTimerEOrg.setParameter("flagRunTimerEOrg", String.valueOf(false));
			createTimerEOrg.setParameter("flagStopTimerEOrg", String.valueOf(true));
			
			createTimerEOrg.setParameter("flagRunThread", String.valueOf(flagRunThread));
			createTimerEOrg.setParameter("flagStopThread", String.valueOf(flagStopThread));
			createTimerEOrg.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			createTimerEOrg.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization stop timer
			PortletURL stopTimerEOrg = renderResponse.createActionURL();
			stopTimerEOrg.setWindowState(WindowState.NORMAL);
			stopTimerEOrg.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopTimerEOrg.setParameter("tabs", tabs);
			stopTimerEOrg.setParameter("action", ConnectionToGatewayContant.STOPTIMEREORG);
			stopTimerEOrg.setParameter("flagRunThreadEOrg", String.valueOf(true));
			stopTimerEOrg.setParameter("flagStopThreadEOrg", String.valueOf(false));
			stopTimerEOrg.setParameter("flagRunTimerEOrg", String.valueOf(true));
			stopTimerEOrg.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			stopTimerEOrg.setParameter("flagRunThread", String.valueOf(flagRunThread));
			stopTimerEOrg.setParameter("flagStopThread", String.valueOf(flagStopThread));
			stopTimerEOrg.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			stopTimerEOrg.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			%>
		
			<span style='display:<%= (flagRunThreadEOrg? "inline" :"none") %>' onclick="callAction('<%= createThreadEOrg.toString() %>');">
				<input id="create_thread" type="button" value='<liferay-ui:message key="create-connection-by-thread-eorg"/>' />
			</span>
			
			<span  style='display:<%= (flagStopThreadEOrg? "inline" :"none") %>' onclick="callAction('<%= stopThreadEOrg.toString() %>');">
				<input id="stop_thread" type="button" value='<liferay-ui:message key="stop-thread-eorg"/>' />
			</span>
			
			<span style='display:<%= (flagRunTimerEOrg? "inline" :"none") %>' onclick="callAction('<%= createTimerEOrg.toString() %>');">
				<input id="create_timer" type="button" value='<liferay-ui:message key="create-connection-by-timer-eorg"/>' />
			</span>
			
			<span style='display:<%= (flagStopTimerEOrg? "inline" :"none") %>' onclick="callAction('<%= stopTimerEOrg.toString() %>');">
				<input id="stop_timer" type="button" value='<liferay-ui:message key="stop-timer-eorg"/>' />
			</span>
		</c:when>
		<c:when test='<%= tabs.equals("goi-mail")%>'>
			<%
			// external organization create thread
			PortletURL createThreadSendMail = renderResponse.createActionURL();
			createThreadSendMail.setWindowState(WindowState.NORMAL);
			createThreadSendMail.setParameter("struts_action", "/sgs/connecttogateway/view");
			createThreadSendMail.setParameter("tabs", tabs);
			createThreadSendMail.setParameter("action", ConnectionToGatewayContant.CREATETHREADSENDMAIL);
			createThreadSendMail.setParameter("flagRunThreadEOrg", String.valueOf(false));
			createThreadSendMail.setParameter("flagStopThreadEOrg", String.valueOf(true));
			createThreadSendMail.setParameter("flagRunTimerEOrg", String.valueOf(false));
			createThreadSendMail.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			createThreadSendMail.setParameter("flagRunThread", String.valueOf(flagRunThread));
			createThreadSendMail.setParameter("flagStopThread", String.valueOf(flagStopThread));
			createThreadSendMail.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			createThreadSendMail.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization stop thread
			PortletURL stopThreadSendMail = renderResponse.createActionURL();
			stopThreadSendMail.setWindowState(WindowState.NORMAL);
			stopThreadSendMail.setParameter("tabs", tabs);
			stopThreadSendMail.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopThreadSendMail.setParameter("action", ConnectionToGatewayContant.STOPTHREADSENDMAIL);
			stopThreadSendMail.setParameter("flagRunThreadEOrg", String.valueOf(true));
			stopThreadSendMail.setParameter("flagStopThreadEOrg", String.valueOf(false));
			stopThreadSendMail.setParameter("flagRunTimerEOrg", String.valueOf(true));
			stopThreadSendMail.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			stopThreadSendMail.setParameter("flagRunThread", String.valueOf(flagRunThread));
			stopThreadSendMail.setParameter("flagStopThread", String.valueOf(flagStopThread));
			stopThreadSendMail.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			stopThreadSendMail.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization create timer
			PortletURL createTimerSendMail = renderResponse.createActionURL();
			createTimerSendMail.setWindowState(WindowState.NORMAL);
			createTimerSendMail.setParameter("struts_action", "/sgs/connecttogateway/view");
			createTimerSendMail.setParameter("tabs", tabs);
			createTimerSendMail.setParameter("action", ConnectionToGatewayContant.CREATETIMERSENDMAIL);
			createTimerSendMail.setParameter("flagRunThreadEOrg", String.valueOf(false));
			createTimerSendMail.setParameter("flagStopThreadEOrg", String.valueOf(false));
			createTimerSendMail.setParameter("flagRunTimerEOrg", String.valueOf(false));
			createTimerSendMail.setParameter("flagStopTimerEOrg", String.valueOf(true));
			
			createTimerSendMail.setParameter("flagRunThread", String.valueOf(flagRunThread));
			createTimerSendMail.setParameter("flagStopThread", String.valueOf(flagStopThread));
			createTimerSendMail.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			createTimerSendMail.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			
			// external organization stop timer
			PortletURL stopTimerSendMail = renderResponse.createActionURL();
			stopTimerSendMail.setWindowState(WindowState.NORMAL);
			stopTimerSendMail.setParameter("struts_action", "/sgs/connecttogateway/view");
			stopTimerSendMail.setParameter("tabs", tabs);
			stopTimerSendMail.setParameter("action", ConnectionToGatewayContant.STOPTIMERSENDMAIL);
			stopTimerSendMail.setParameter("flagRunThreadEOrg", String.valueOf(true));
			stopTimerSendMail.setParameter("flagStopThreadEOrg", String.valueOf(false));
			stopTimerSendMail.setParameter("flagRunTimerEOrg", String.valueOf(true));
			stopTimerSendMail.setParameter("flagStopTimerEOrg", String.valueOf(false));
			
			stopTimerSendMail.setParameter("flagRunThread", String.valueOf(flagRunThread));
			stopTimerSendMail.setParameter("flagStopThread", String.valueOf(flagStopThread));
			stopTimerSendMail.setParameter("flagRunTimer", String.valueOf(flagRunTimer));
			stopTimerSendMail.setParameter("flagStopTimer", String.valueOf(flagStopTimer));
			%>
		
			<span style='display:<%= (flagRunThreadEOrg? "inline" :"none") %>' onclick="callAction('<%= createThreadSendMail.toString() %>');">
				<input id="create_thread" type="button" value='<liferay-ui:message key="create-connection-by-thread-eorg"/>' />
			</span>
			
			<span  style='display:<%= (flagStopThreadEOrg? "inline" :"none") %>' onclick="callAction('<%= stopThreadSendMail.toString() %>');">
				<input id="stop_thread" type="button" value='<liferay-ui:message key="stop-thread-eorg"/>' />
			</span>
			
			<span style='display:<%= (flagRunTimerEOrg? "inline" :"none") %>' onclick="callAction('<%= createTimerSendMail.toString() %>');">
				<input id="create_timer" type="button" value='<liferay-ui:message key="create-connection-by-timer-eorg"/>' />
			</span>
			
			<span style='display:<%= (flagStopTimerEOrg? "inline" :"none") %>' onclick="callAction('<%= stopTimerSendMail.toString() %>');">
				<input id="stop_timer" type="button" value='<liferay-ui:message key="stop-timer-eorg"/>' />
			</span>
		</c:when>
	</c:choose>
	</div>
</div>
</form>