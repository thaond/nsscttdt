<%@ include file="/html/portlet/nss/onedoorprocess/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<portlet:actionURL var="form" >
</portlet:actionURL>

<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String userName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName() ;
	String senderId = String.valueOf(loginUser.getUserId());
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
%>
<form name="form"  method="post" action="<%=form%>" onsubmit="return <portlet:namespace/>checkReceiverId(this)">
<input type="hidden" name="isDelegate" value="<%= isDelegate %>" > <!-- yenlt 24052010 -->
<div class="title_categ"><liferay-ui:message key="pccc-XL-xulyhoso"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0" >
<tr>
    <td width="15%" >
   		<label>
   			<liferay-ui:message key="pccc-XL-nguoigui"/><font color="red" size="1">(*)</font> :
   		</label>
    </td>
    
    <td>
		<input type="text" readonly="readonly" name="<portlet:namespace/>nguoiGui" id="nguoiGui" style="width:99%;" value="<%=userName %>" />
		<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>senderId" value="<%= senderId %>">
	</td>
</tr>

<tr>
    <td>
    	<label>
      		<liferay-ui:message key="pccc-XL-ngaygui"/>
      		<font color="red" size="1">(*)</font> :
      	</label>
	</td>
	
    <td>
    	<input type="text" readonly="readonly" name="<portlet:namespace/>dateProcess" id="ngayGui" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>' />
    	<input type="hidden" readonly="readonly" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>dateProcess" id="ngayGui" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'>
    </td>   
</tr>

<tr>
	<td >
		<label>
			<liferay-ui:message key="pccc-XL-thoigiangui"/> :
		</label>
    </td>
    
    <td>
    	<input type="text" readonly="readonly" name="<portlet:namespace/>thoiGianGui" id="applicantTime" style="width:99%;" value='<%=new java.text.SimpleDateFormat("hh:mm:ss").format(new Date())%>' />
    </td>   
</tr>
<tr>
    <td >
    	<label>
      		<liferay-ui:message key="pccc-XL-nguoiNhan"/><font color="red">(*)</font> :
      	</label>
	</td>
	
    <td>	
		<select name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId" id="receiverIdfocus" style="width:99.6%;">
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
	<td >
		<label>
			<liferay-ui:message key="pccc-TN-tongthoigianxuly"/> :
		</label>
    </td>
    
    <td>
    	<input type="text" readonly="readonly" name="<portlet:namespace/>tongThoiGianGui" id="tongThoiGianGui" style="width:99%;" value='<%= renderRequest.getAttribute("totalTimeProcess") %>' />
    </td>   
</tr>
<tr>
	<td >
		<label>
			<liferay-ui:message key="pccc-TN-ngayhentrakhach"/> :
		</label>
    </td>
    
    <td>
    	<input type="text" readonly="readonly" name="<portlet:namespace/>ngayHenTraKhach" id="ngayHenTraKhach" style="width:99%;" value='<%= renderRequest.getAttribute("returnDate")%>' />
    </td>   
</tr>
<tr>
    <td >
    	<label>
      		<liferay-ui:message key="pccc-XL-thongtinxuly"/> :
      	</label>
	</td>
	
    <td rowspan="3">
    	<textarea name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="thongTinXuLy" cols="90" rows="2" style="width: 99%;"></textarea>
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
function <portlet:namespace/>checkReceiverId(form) {
	
	if(form.<portlet:namespace/><%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX %>receiverId.value == "0") {
		alert("<liferay-ui:message key='chonnguoitiepnhanxuly'/>");
		form.<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId.focus();
		return false;
	}
	
	return true;
}

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
window.onload = function () {
	document.getElementById('receiverIdfocus').focus();
	startTime();
}
</script>