<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>

<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/js/pcccdocumentsendprocess-js.jsp" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<script language="javascript">
window.onload=function(){
	document.getElementById('processInformation').focus();	
	//createListObjects();
	//TSS
	if(document.getElementById('totalDateProcessCalen') != null) {
		callCalendar('totalDateProcessCalen','cal-button-ToDate');
	}
}
	
</script>
<%
	String dateNow = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay hien tai

	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	//PmlEdmDocumentReceipt documentReceipt = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	
	
%>
<portlet:actionURL var="form">
</portlet:actionURL>

<!--  form name="<portlet:namespace />form" action="<//%=form %>" method="post" onsubmit="return validateUserAssign();"-->
<%//TSS %>
<form name="<portlet:namespace />form" action="<%=form %>" method="post" onsubmit="return subUserAss();">
<%//END TSS %>
<div id="div-head-title"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<fieldset>
<table cellpadding="0" cellspacing="0" border="0" width="60%" style="font-size: 13px" class="table-border-pml">
<tr>
	<td>
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="bgtran">
	<tr valign="top">
		<td width="20%" style="text-align: right; padding-right: 3px;"><liferay-ui:message key="LCCV-yeucauxuly" /> :</td>
		<td width="78%"><textarea name="<portlet:namespace /><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="processInformation" rows="5" style="width: 99%"></textarea></td>
	</tr>
	<tr class="blank-height-10"></tr>
	<tr>
		<td></td>
		<td align="left"><liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b></td>
	</tr>
	<tr class="blank-height-10"></tr>
	<tr valign="top">
		<td style="text-align: right; padding-right: 3px;"><liferay-ui:message key="LCCV-nguoinhan" /><font color="red">(*)</font> :</td>
		<td>
		<div class="scroll">
		<table cellpadding="0" cellspacing="0" width="100%" class="tab-doc-process-list-base">
		<tr style="height: 28px;" class="table-header">
			<td width="4%" align="center" class="td-stt-pml"><liferay-ui:message key="select"/></td>
			<td align="center" class="td-stt-pml"><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
		</tr>
		<logic:iterate id="user" name="userList" indexId="k" type="com.liferay.portal.model.User" scope="request" >
		<%
			String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		%>
		<tr style="height: 25px;" class="${((k % 2) == 0) ? 'rowOne' : 'rowTwo'}" onclick="checkUserAssign(this)">
			<td class="td-stt-pml-left" width="55px" id="<%= k%>">
				<input type="checkbox" onclick="clickCheckBox(event,this)" name="<portlet:namespace/>supportUers" id="nguoiNhan<%= k%>" value="<%=user.getUserId() %>" />
			</td>
			<td class="td-stt-pml-left" align="left" style="padding-left: 3px;"><%=fullName %></td>
		</tr>
		</logic:iterate>
		</table>
		</div>
		</td>
	</tr>
	<tr >
		<td style="text-align: right; padding-right: 3px;" nowrap="nowrap"><liferay-ui:message key="document_main_process_employee" /><font color="red">(*)</font> :</td>
		<td><select style="width: 99%" id="selectedOptionsmain" name="<portlet:namespace />mainUser"></select></td>
	</tr>
	<tr class="blank-height-10"></tr>
	
	
		
	
	
	<tr ><td ></td><td ></td></tr>
	<tr height="10"><td></td><td></td></tr>
	</table>
	</td>
</tr>
</table>
</fieldset>
<table id="table-button">
<tr>
	<td>
		
		
	      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
	</td>
</tr>
</table>
</form>
