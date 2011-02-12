<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
String redirect = ParamUtil.getString(request, "redirect");

String eventType = ParamUtil.getString(request, "eventType");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("struts_action", "/ext/meeting_calendar/view");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("month", String.valueOf(selMonth));
portletURL.setParameter("day", String.valueOf(selDay));
portletURL.setParameter("year", String.valueOf(selYear));
%>
<form method="get" name="<portlet:namespace />fm">
	<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />
<c:choose>
	<c:when test='<%= tabs1.equals("approved-calendar") || tabs1.equals("calendar-release")  %>'>
		<%@ include file="/html/portlet/ext/meeting_calendar/week_view.jspf" %>
	</c:when>
<c:when test='<%= tabs1.equals("focus-week")  %>'>
		<%@ include file="/html/portlet/ext/meeting_calendar/focus_week.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("register-calendar")  %>'>
		<%@ include file="/html/portlet/ext/meeting_calendar/register-calendar.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("manage-resources")  %>'>
		<liferay-util:include page="/html/portlet/ext/meeting_calendar/manage_resources.jsp"/>
	</c:when>
</c:choose>

</form>