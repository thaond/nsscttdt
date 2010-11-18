<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil"%>
<%
	// Hai Trieu
	// Add: 20091019
 %>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%@page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalComponent"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.calendar.model.impl.CalEventImpl"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@ page import="com.ext.portal.util.WebKeysExt"%>
<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>

<style>
	<%@ include file="/html/portlet/ext/meeting_calendar/style.css" %>
</style>
<%
	String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
	String redirect = ParamUtil.getString(request, "redirect");
	String tabs1_ = ParamUtil.getString(request, "tabs1", tabs2Default);
	MeetingDetailWeek meetingDetailWeek = (MeetingDetailWeek) request.getAttribute(WebKeysExt.MEETINGDETAILWEEK);
	String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);
	
	if (originalRedirect.equals(StringPool.BLANK)) {
		originalRedirect = redirect;
	}
	else {
		redirect = originalRedirect;
	}
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	
	long mdweekId = BeanParamUtil.getLong(meetingDetailWeek, request, "mdweekId");
	long userId = themeDisplay.getUserId();
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/ext/meeting_calendar/view_focus_week");
	portletURL.setParameter("tabs1", "focus-week");
	portletURL.setParameter("redirect", redirect);
	String MeetingDetailWeekAUFlag = ""; // chi cho phep them moi update khong cho xoa.
	String cmd = ParamUtil.getString(request, Constants.CMD);
	// Object properties
	String focus = "";
	String note = "";
	String receive = "- Như trên; \n";
	receive = receive + "- Phòng - ban, đơn vị; \n";
	receive = receive + "- Lưu: VP - A.17b; \n";
	int week = 0;
	int year = 0;
	
	Calendar cal = (Calendar)selCal.clone();
	week = ParamUtil.getInteger(request,"week", 0);
	year = ParamUtil.getInteger(request,"year", 0);
	//MeetingDetailWeek meetingDetailWeek = null;
	if (mdweekId > 0)
	{
		 meetingDetailWeek = MeetingDetailWeekLocalServiceUtil.FindPrimaryKey(mdweekId);
		if (meetingDetailWeek != null) {
			mdweekId = meetingDetailWeek.getMdweekId();
			userId = meetingDetailWeek.getUserId();
			focus = meetingDetailWeek.getFocus();
			note = meetingDetailWeek.getNote();
			if (!note.equals("") & note != ""){
				note = note.replaceAll("<br/>", "\n");
			}
			receive = meetingDetailWeek.getReceive();
			if (!receive.equals("") & receive !="") {
				receive = receive.replaceAll("<br/>", "\n");
			}		
			week = meetingDetailWeek.getWeek();
			year = meetingDetailWeek.getYear();
		}
	}
	String editorParam = "focus"; // ten truong luu du lieu
	String editorContent = focus;
%>

<div id="divparent">
<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/ext/meeting_calendar/edit_focus_week" /></portlet:actionURL>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveFocus(); return false;" class="meeting_calendar_bg">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />originalRedirect" type="hidden" value="<%= HtmlUtil.escape(originalRedirect) %>" />
<input name="<portlet:namespace />referringPortletResource" type="hidden" value="<%= HtmlUtil.escape(referringPortletResource) %>" />
<input name="<portlet:namespace />mdweekId" type="hidden" value="<%= mdweekId %>" />
<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1_ %>" />
<input name="<portlet:namespace />userId" type="hidden" value="<%= userId %>" />
<input name="<portlet:namespace />timeZoneSensitive" type="hidden" value="true" />
<input name="<portlet:namespace />week" type="hidden" value="<%= week %>" />
<input name="<portlet:namespace />year" type="hidden" value="<%= year %>" />

<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />

<script type="text/javascript">
	function <portlet:namespace />initEditor(){
		return "<%= UnicodeFormatter.toString(editorContent)%>";
	}
	function <portlet:namespace />changeFormat() {
		if (window.<portlet:namespace />editor) {
			document.<portlet:namespace />fm.<portlet:namespace /><%=editorParam%>.value = window.<portlet:namespace />editor.getHTML();	
		}
	}
	
	function <portlet:namespace />saveFocus(cmd) {
		if (cmd == null) {
			cmd = "<%= meetingDetailWeek != null || meetingDetailWeek == null && MeetingDetailWeekAUFlag.equals("fail") && mdweekId > 0 ? Constants.UPDATE : Constants.ADD %>";
		}
		
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		<portlet:namespace />changeFormat();
		submitForm(document.<portlet:namespace />fm);
	}

</script>

<table class="lfr-table" width="100%">
<tr>
	<td colspan="2">
		<img border="0" src="/html/portlet/ext/meeting_calendar/Text_DangKyLichLamViec.gif" />
	</td>
</tr>
<tr>
<liferay-ui:error exception="<%= DuplicateFocusException.class %>" message="trong-tam-tuan-da-co" />
	<td valign="top">
		<table class="lfr-table" width="100%">
			<tr>
				<td class="focusWeek" valign="top" width="15%">
					<liferay-ui:error exception="<%= FocusException.class %>" message="trong-tam-de-trong" />
					<liferay-ui:message key ="trong-tam"/> (*) :
				</td>
				<td>					
					<liferay-ui:input-editor/>
					<input name="<portlet:namespace /><%=editorParam %>" type="hidden"/>				
				</td>
			</tr>
			<tr>
				<td class="focusWeek" valign="top" style="padding-top: 10px;"><liferay-ui:message key ="luu-y"/> :</td>
				<td style="padding-top: 10px;">
					<textarea name="<portlet:namespace />note" rows="7" cols="120"><%= note %></textarea>
				</td>
			</tr>
			<tr>
				<td class="focusWeek" valign="top" style="padding-top: 10px;"><liferay-ui:message key ="noi-nhan"/> :</td>
				<td style="padding-top: 10px;">
					<textarea name="<portlet:namespace />receive" rows="7" cols="120"><%= receive %></textarea>
				</td>
			</tr>	
		</table>
		<div class="separator"><!-- --></div>
		<div>
			<input type="button" value='<liferay-ui:message key="save" />'  onClick="<portlet:namespace />saveFocus()" />
			<input type="button" value='<liferay-ui:message key="cancel" />' onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
		</div>
		</td>
	</tr>
	</table>
</form>
</div>
<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
<script type="text/javascript">
		if (window.<portlet:namespace />editor) {
			Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= editorParam %>);
		}
	</script>

</c:if>		
