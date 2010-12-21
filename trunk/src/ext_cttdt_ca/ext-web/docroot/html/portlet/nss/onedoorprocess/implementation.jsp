<%@ include file="/html/portlet/nss/onedoorprocess/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

<script type="text/javascript">
function startTime()
{
	var today=new Date();
	var h=today.getHours();
	var m=today.getMinutes();
	var s=today.getSeconds();
	// add a zero in front of numbers<10
	m=checkTime(m);
	s=checkTime(s);
	document.getElementById('applicantTime').value=h+":"+m+":"+s;
	t=setTimeout('startTime()',500);

}

function checkTime(i)
	{
	if (i<10)
	  {
	  i="0" + i;
	  }
	return i;
}

function <portlet:namespace/>checkForm(form) {
	if(form.<portlet:namespace/>ngayYeuCau.value == "") {
		form.<portlet:namespace/>ngayYeuCau.focus();
		return false;
	}
	if(<portlet:namespace/>checkReceiveLicenseDate(form.<portlet:namespace/>ngayYeuCau.value) == false) {
		alert('<liferay-ui:message key="pccc-error-date"/>');
		form.<portlet:namespace/>ngayYeuCau.focus();
		return false;
	}
	if(form.<portlet:namespace/>thoiGianYeuCau.value == "") {
		form.<portlet:namespace/>thoiGianYeuCau.focus();
		return false;
	}
	if(<portlet:namespace/>checkThoiGianYeuCau(form.<portlet:namespace/>thoiGianYeuCau.value) == false) {
		alert('Time is not correct format (ex: 12:34:23 AM)');
		form.<portlet:namespace/>thoiGianYeuCau.focus();
		return false;
	}
	if(form.<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId.value == "0") {
		alert("<liferay-ui:message key='chonnguoitiepnhanxuly'/>");
		form.<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId.focus();
		return false;
	}
	if(form.<portlet:namespace/>veViec.value == "") {
		alert("<liferay-ui:message key='nhapthongtinveviec'/>");
		form.<portlet:namespace/>veViec.focus();
		return false;
	}
	return true;
}

function <portlet:namespace/>checkReceiveLicenseDate(strDate) {

	if(strDate.length > 10 || strDate.length < 10) return false;
	var arrDate = strDate.split("/");
	if(isNaN(arrDate[0]) || isNaN(arrDate[1]) || isNaN(arrDate[2]))
		return false;
	if(arrDate[0] < 0 || arrDate[0] > 31)
		return false;
	if(arrDate[1] < 0 || arrDate[1] > 12)
		return false;
	if(arrDate[2] < 2000 || arrDate[2] > 2100)
		return false;
	return true;
}
function <portlet:namespace/>checkThoiGianYeuCau(strTime) {

	if(strTime.length > 8 || strTime.length < 7) return false;
	var arrTime = strTime.split(":");
	if(isNaN(arrTime[0]) || isNaN(arrTime[1]) || isNaN(arrTime[2]))
		return false;
	if(arrTime[0] < 0 || arrTime[0] > 23)
		return false;
	if(arrTime[1] < 0 || arrTime[1] > 59)
		return false;
	if(arrTime[2] < 0 || arrTime[2] > 59)
		return false;
	return true;
}
</script>

<%
	Calendar cal = Calendar.getInstance();
	//cal.setTimeZone(TimeZone.getTimeZone("GMT+07"));
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginUserName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName() ;
	// yenlt 24052010
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	// end yenlt 24052010
%>

<portlet:actionURL var="form" >
	<portlet:param name="struts_action" value="/nss/onedoorprocess/implementation"/>
</portlet:actionURL>
<form name="form"  method="post" action="<%= form %>" onsubmit="return <portlet:namespace/>checkForm(this)">
<input type="hidden" name="isDelegate" value="<%= isDelegate %>" > <!-- yenlt 24052010 -->
<div class="title_categ"><liferay-ui:message key="pccc-XL-yeucaubosunghoso"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
<tr>
	<td width="15%" >
		<div><label><liferay-ui:message key="pccc-BS-nguoiyeucau" /><font color="red">(*)</font> :</label></div>
	</td>
    <td>
    	<input type="text"  readonly="readonly" name="<portlet:namespace/>nguoiYeuCau" style="width:99%;" value="<%= loginUserName %>" >
    	<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>senderId" value="<%= loginUser.getUserId() %>">
   	</td>
</tr>
<tr>
	<td>
		<div><label><liferay-ui:message key="pccc-BS-ngayyeucau" /><font color="red">(*)</font> :</label></div>
	</td>
	<td>
    	<input type="text" name="<portlet:namespace/>ngayYeuCau" id="ngayyeucau" style="width:99%;" value='<%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>' >
    	<input type="hidden" readonly="readonly" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>dateProcess" id="ngayGui" style="width:100%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'>
	</td>
</tr>
<tr>
	<td>
		<div><label><liferay-ui:message key="pccc-BS-thoigianyeucau" /> :</label></div>
	</td>
	<td>
		<input type="text" name="<portlet:namespace/>thoiGianYeuCau" id="applicantTime" style="width:99%;" value='<%= new SimpleDateFormat("hh:mm:ss").format(cal.getTime()) %>' >
	</td>
</tr>
<tr>
	<td>
		<div><label><liferay-ui:message key="pccc-BS-nguoisexuly" /><font color="red" size="1">(*)</font> :</label></div>
	</td>
	<td>
		<select name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId" id="nguoisexuly" style="width:99.6%;">
	    	<option value="0"><liferay-ui:message key="select"/></option>
	    	<logic:iterate id="user" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
	    	<%
	    		String receiverName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName() ;
	    	%>
	    		<option value="<%=user.getUserId() %>"><%= receiverName %></option>
			</logic:iterate>
	    </select>
	</td>
</tr>

<tr>
	<td colspan="2">
		<div><label><liferay-ui:message key="pccc-BS-veviec"/><font color="red" size="1">(*)</font> :</label></div><br />
		<textarea name="<portlet:namespace/>veViec" rows="2"  style="width: 99%;height: 80px"></textarea>
	</td>    
</tr>

<tr>
	<td colspan="2">
		<div><label><liferay-ui:message key="pccc-BS-ghichu"/>:</label></div><br />
		<textarea name="<portlet:namespace/>ghiChu"  style="width: 99%;height: 80px"></textarea>
	</td>    
</tr>
</table>

<div id="table-button" align="right">
		<liferay-util:include page="/html/portlet/nss/onedoorprocess/common/taskAction.jsp"></liferay-util:include>
      	<input class="button-width" type="reset" value='<liferay-ui:message key="reset"/>'>    	
      	<portlet:renderURL var="back">
			<portlet:param name="struts_action"	value="/nss/onedoorprocess/view" />
			<portlet:param name="transitionBack" value="transitionBack" />
			<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId" %>' value='<%= ParamUtil.getString(renderRequest, "fileId") %>' />
			<portlet:param name="isDelegate" value="<%= isDelegate %>" />
			<portlet:param name="processValue" value="<%= processValue %>" />
		</portlet:renderURL>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></span>      
</div>
</div>
</form>
<script type="text/javascript">
window.onload = function () {
	document.getElementById('ngayyeucau').focus();	
	startTime();
}
</script>