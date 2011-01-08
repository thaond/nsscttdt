<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/js/pcccdocumentsendprocess-js.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%//TSS %>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<%
	String totalDateProcessCalen =""; 
	String dateNow = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay hien tai

	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());

%>


<script language="javascript">

window.onload=function(){
	document.getElementById('processInformation').focus();	
	//TSS
		
}	
	


</script>

<portlet:actionURL var="form">
</portlet:actionURL>


<form name="<portlet:namespace/>fm" action="<%=form%>" method="post" onsubmit="return checkFormDepartment();">
<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>


<div id="div-head-title"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<fieldset>
<table cellpadding="0" cellspacing="0" border="0" width="60%" style="font-size: 13px" class="table-border-pml">
<tr>
	<td>
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="bgtran">
	<tr valign="top">
		<td width="20%" style="text-align: right; padding-right: 3px;" ><liferay-ui:message key="LCCV-yeucauxuly" /> :</td>
		<td width="78%"><textarea name="<portlet:namespace />processInformation" id="processInformation" rows="5" style="width: 99%"></textarea></td>
	</tr>
	<tr><td class="blank-height-10"></td></tr>
	<tr>
		<td></td>
		<td align="left"><liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%= loginName %></b></td>
	</tr>
	<tr class="blank-height-10"></tr>
	<tr valign="top">
		<td style="text-align: right; padding-right: 3px;"><liferay-ui:message key="LCCV-phongbannhan" /><font color="red">(*)</font> :</td>
		<td>
		<table cellpadding="0" cellspacing="0"  width="100%" class="tab-doc-process-list-base">
		<tr class="table-header">
			<td width="4%" style="text-align: center;"><liferay-ui:message key="select"/></td>
			<td style="text-align: center;"><liferay-ui:message key="department"/></td>
		</tr>
		</table>
		<div class="scroll">
		<table cellpadding="0" cellspacing="0" border="0"  class="width98">
		
	 	<logic:iterate  id="department" name="departmentList" type="com.sgs.portlet.department.model.Department" scope="request" indexId="k">
		<tr class="${((k % 2) == 0) ? 'rowOne' : 'rowTwo'}" onclick="getSelectCheckBox(this)" style="height: 28px;">
			<td width="4%" id="<%= k %>" class="td-stt-pml">
				<input class="styled" type="checkbox" onclick="clickCheckBox(event,this)" name="<portlet:namespace/>DepartmentsSendId" id="DepartmentsSendId<%= k%>" value="<%= department.getDepartmentsId() %>" />
			</td>
			<td class="td-stt-pml-left"><%= department.getDepartmentsName() %></td>
		</tr>
		</logic:iterate>
	
		</table>
		</div>
		</td>
	</tr>
	<tr><td class="blank-height-10"></td></tr>
	
			<tr><td class="blank-height-10"></td></tr>
			
			<tr height="10"><td></td><td></td></tr>
			</table>
	</td>
</tr>
</table>
<!-- input type="hidden" id="documentReceiptId" name="<portlet:namespace />documentSendId" value='<--%=//renderRequest.getAttribute("documentSendId") %>'>
<input type="hidden" id="isBookDocumentRecord"  value=""-->
</fieldset>
<table id="table-button">
<tr>
	<td>
		<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/taskAction.jsp"></liferay-util:include>
	      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
	</td>
</tr>
</table>
</form>
