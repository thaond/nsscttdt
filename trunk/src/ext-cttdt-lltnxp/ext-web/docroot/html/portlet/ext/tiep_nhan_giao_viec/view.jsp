<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/portlet/ext/tiep_nhan_giao_viec/init.jsp" %>
<!-- Tu update 20101126 -->
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript">
	
	window.onload = function () {
	
		if (document.getElementById('<portlet:namespace />ngaytao') != null) {
			callCalendar('<portlet:namespace/>ngaytao','cal-button-ngaytao');
		}
		
	}
	
</script>
<div class="title_categ"><liferay-ui:message key="nhap-noi-dung-cong-viec" /></div>
<div class="boxcontent">
<table width="100%">
	<tr>
		<td width="15%"><liferay-ui:message key="ma-cong-viec" /></td>
		<td width="32%">00001/HS/CATP</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="ten-cong-viec" /></td>
		<td valign="top" width="32%">
			<input style="width: 92%" type="text" value="ten-cong-viec"/>	
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="nguoi-tao" /></td>
		<td>
		<%User user2 = PortalUtil.getUser(request); 
		%>
		<input style="width: 92%;" type="text" value="<%= user2.getLastName() + user2.getMiddleName() + user2.getFirstName() %>"/>
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="linh-vuc" /></td>
		<td width="32%"><select style="width: 92%;" name='<portlet:namespace/>linh-vuc'> <option><liferay-ui:message key="chon" /></option></select></td>
		<td width="7%"><liferay-ui:message key="ngay-tao" /></td>
		<td width="32%">
		<%
		Date date = new Date();
		
		%>
		<input type="text" name="<portlet:namespace/>ngaytao" id="<portlet:namespace/>ngaytao" value="<%= dateFormat.format(date) %>"/>
		<img align="top" onclick="callCalendar('<portlet:namespace/>ngaytao','cal-button-ngaytao')" id="cal-button-ngaytao" style="cursor: pointer;" src="/html/images/cal.gif">
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="y-kien-chi-dao" /></td>
		<td valign="top" colspan="3">
			<textarea rows="2" style="width: 95.5%"></textarea>		
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="nguoi-chi-dao" /></td>
		<td width="32%" valign="top" >
			<select style="width: 92%;" name='<portlet:namespace/>linh-vuc'> <option><liferay-ui:message key="chon" /></option></select>	
		</td>
		<td width="7%"><liferay-ui:message key="doi-thuc-hien" /></td>
		<td width="32%" valign="top" >
			<select style="width: 92%;" name='<portlet:namespace/>linh-vuc'> <option><liferay-ui:message key="chon" /></option></select>	
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="bao-cao-noi-dung-cong-viec-da-chi-tao" /></td>
		<td valign="top" colspan="3">
			<textarea rows="2" style="width: 95.5%"></textarea>		
		</td>
	</tr>
	<tr>
		<td width="15%"><liferay-ui:message key="chi-dao-them-cua-chi-huy" /></td>
		<td valign="top" colspan="3">
			<textarea rows="2" style="width: 95.5%"></textarea>		
		</td>
	</tr>
</table>
</div>