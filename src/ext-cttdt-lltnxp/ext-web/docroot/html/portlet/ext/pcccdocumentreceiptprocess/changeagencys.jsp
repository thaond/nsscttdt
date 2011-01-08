<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<%@page import="java.util.Date"%><link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%//TSS %>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<%//End TSS %>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script language="javascript">
window.onload=function(){
	document.getElementById('processInformation').focus();	
	//createListObjects();
	//TSS
	if(document.getElementById('totalDateProcessCalen') != null) {
		callCalendar('totalDateProcessCalen','cal-button-ToDate');
	}
	if(document.getElementById('totalDateProcessCalenRes') != null) {
		callCalendar('totalDateProcessCalenRes','cal-button-ToDateRes');
	}		
	//END
}
//TSS
function saveChoiceDateNum(){
	totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
	totalDateProcessCalen.disabled = true;
	totalDateProcessCalenRes = document.getElementById("totalDateProcessCalenRes");
	totalDateProcessCalenRes.disabled = true;
	totalDateProcessDis = document.getElementById("totalDateProcess");
	totalDateProcessDis.disabled = false;		
	dateNumberProcess = document.getElementById("dateNumberProcess");
	dateNumberProcess.disabled = false;
	check_1 = document.getElementById("check_1");
	check_1.checked = true;
	check_2 = document.getElementById("check_2");
	check_2.checked = false;
	check_3 = document.getElementById("check_3");
	check_3.checked = true;
	check_4 = document.getElementById("check_4");
	check_4.checked = false;
}

function saveChoiceDateCalen(){
	totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
	totalDateProcessCalen.disabled = false;
	totalDateProcessCalenRes = document.getElementById("totalDateProcessCalenRes");
	totalDateProcessCalenRes.disabled = false;
	totalDateProcessDis = document.getElementById("totalDateProcess");
	totalDateProcessDis.disabled = true;
	dateNumberProcess = document.getElementById("dateNumberProcess");
	dateNumberProcess.disabled = true;
	check_1 = document.getElementById("check_1");
	check_1.checked = false;
	check_2 = document.getElementById("check_2");
	check_2.checked = true;
	check_3 = document.getElementById("check_3");
	check_3.checked = false;
	check_4 = document.getElementById("check_4");
	check_4.checked = true;
}
//End
</script>
<%
	//TSS
	String totalDateProcessCalen =""; 
	String dateNow = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay hien tai
	//End
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());

%>
<portlet:actionURL var="form"></portlet:actionURL>
<form name="<portlet:namespace/>fm" action="<%= form %>" method="post" onsubmit="return validateAgencyProcess();">
<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan" /></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
	<tr valign="top">
		<td width="18%"><label><liferay-ui:message key="LCCV-yeucauxuly" /> </label>&nbsp;:</td>
		<td ><textarea name="<portlet:namespace />processInformation" id="processInformation" rows="2" style="width: 98%"> </textarea></td>
	</tr>
	<tr>
		<td></td>
		<td align="left">
		<span style="background: #ccf1f7;padding: 2px 5px;">
		<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;-&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
		</span>
		</td>
	</tr>
	
	<tr valign="top">
		<td ><liferay-ui:message key="LCCV-phongbannhan" /><font color="red">(*)</font> &nbsp;:</td>
		<td>
		<div style="width: 99%">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td align="center" width="40px"><liferay-ui:message key="select"/></td>
					<td ><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
				</tr>
				<logic:iterate id="user" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
			<%
		    	String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		    %>
			<tr class="${((i % 2) == 0) ? 'results-row' : 'tr_two results-row'}" onclick="getSelectRadio(this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
				<td align="center" id="<%= i %>">
					<div align="center"><input <%= ((i == 0) ? "checked='checked'" : "")  %> class="styled" type="radio" name="<portlet:namespace/>receiverId" id="nguoiNhan<%= i %>"  value="<%=user.getUserId() %>" onclick="clickRadio(event)" /></div>
				</td>
				<td><%=fullName %></td>
			</tr>
			</logic:iterate>
		</table>
		</div>
		</td>
	</tr>

	<tr >
		<td><liferay-ui:message key="LCCV-cach-thuc-xu-ly" /><font color="red">(*)</font> &nbsp;: </td>
		<td style="padding-left: 3px">
			<input type="radio" name="<portlet:namespace />documentType" value="1"></input> <liferay-ui:message key="LCCV-cong-van-luu" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="<portlet:namespace />documentType" value="2"></input> <liferay-ui:message key="LCCV-cong-bao-cao" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="<portlet:namespace />documentType" value="3"></input> <liferay-ui:message key="LCCV-soan-cong-van-tra-loi" />
		</td>
	</tr>
	<tr >
		<td valign="top"><liferay-ui:message key="LCCV-thoigian"/>&nbsp; : </td>
		<td align="left">
			<table width="100%" cellspacing="0">
				<tr>
					<td width="30%"><liferay-ui:message key="LCCV-tongthoigian"/>&nbsp;:</td>
					<td>
					<input type="radio" name="saveChoiceDate" id = "check_1" checked="checked" onClick="saveChoiceDateNum()"/>&nbsp;&nbsp;
					<input size="2" type="text" name="<portlet:namespace />totalDateProcess" id="totalDateProcess" value="7" />  
					<liferay-ui:message key="ngay" />&nbsp;&nbsp;
					<input type="radio" name="saveChoiceDate" id = "check_2" onClick="saveChoiceDateCalen()" />&nbsp;&nbsp;
					<input style="width: 128px" type="text" name="<portlet:namespace />totalDateProcessCalen" id="totalDateProcessCalen" value="<%= dateNow %>" disabled="true" />					
					<input type="hidden" name="<porlet:namespace />dateNow" value="<%=dateNow %>" id="<portlet:namespace />dateNow"/>
					<input type="hidden" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-TotalDate" onclick="callCalendar('totalDateProcessCalen','cal-button-TotalDate');" />
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="LCCV-thoigiangiaiquyetcuaphong"/>&nbsp;:</td>
					<td>
						
					<input type="radio" name="saveChoiceDateRes" id = "check_3" checked="checked" onClick="saveChoiceDateNum()"/>&nbsp;&nbsp;
					<input size="2" type="text" name="<portlet:namespace />dateNumberProcess" id="dateNumberProcess" > 					
					<liferay-ui:message key="ngay" />&nbsp;&nbsp;
					
					<input type="radio" name="saveChoiceDateRes" id = "check_4" onClick="saveChoiceDateCalen()" />&nbsp;&nbsp;
					<input style="width: 128px" type="text" name="<portlet:namespace />totalDateProcessCalenRes" id="totalDateProcessCalenRes" value="<%= dateNow %>" disabled="true" />					
					<input type="hidden" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-TotalDateRes" onclick="callCalendar('totalDateProcessCalenRes','cal-button-TotalDateRes');" />
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="LCCV-khongcanchonthoigian" />&nbsp;:</td>
					<td><input type="checkbox" name="<portlet:namespace />noTimpeProcess"/>		</td>
				</tr>			
	</table>
</td>
</tr>
</table>

<input type="hidden" id="documentReceiptId" name="<portlet:namespace />documentReceiptId" value='<%=renderRequest.getAttribute("documentReceiptId") %>'>
<input type="hidden" id="isBookDocumentRecord"  value="">

<div align="right" id="table-button">
		<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
		<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
		<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
	      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</div>
</form>
