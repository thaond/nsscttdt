<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<%@ include file="/html/portlet/ext/processtype/init.jsp" %>

<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.util.DocumentReceiptUtil"%>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%//TSS %>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp">
</liferay-util:include>

<%//End %>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script language="javascript">
window.onload=function(){
	document.getElementById('processInformation').focus();	
	//createListObjects();
	//TSS
	if(document.getElementById('totalDateProcessCalen') != null) {
		callCalendar('totalDateProcessCalen','cal-button-ToDate');
	}
}
	function saveChoiceDateNum(){
		totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
		totalDateProcessCalen.disabled = true;
		dateNumberProcess = document.getElementById("dateNumberProcess");
		dateNumberProcess.disabled = false;
		
		check_1 = document.getElementById("check_1");
		check_1.checked = true;
		check_2 = document.getElementById("check_2");
		check_2.checked = false;
	}
	function saveChoiceDateCalen(){
		totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
		totalDateProcessCalen.disabled = false;
		dateNumberProcess = document.getElementById("dateNumberProcess");
		dateNumberProcess.disabled = true;
		
		check_1 = document.getElementById("check_1");
		check_1.checked = false;
		check_2 = document.getElementById("check_2");
		check_2.checked = true;
	
	//End TSS
}
</script>
<%
	//TSS
	String dateNow = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay hien tai

	//END TSS
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	PmlEdmDocumentReceipt documentReceipt = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	
	String daysProcessDeparmentMain = (String)renderRequest.getAttribute("daysProcessDeparmentMain");
	String numberDateRemain = (String) renderRequest.getAttribute("numberDateRemain");
	int tongthoigian = 0;
	int thoigianconlai = 0;
	//TSS
	String ddXLChinh = (String)renderRequest.getAttribute("ddXLChinh");
	String ddXLDuocGiao = (String)renderRequest.getAttribute("ddXLDuocGiao");

	//END TSS
	if (!"".equals(daysProcessDeparmentMain) || daysProcessDeparmentMain != null) {
		tongthoigian = Integer.parseInt(daysProcessDeparmentMain);
	}
	
	if (!"".equals(numberDateRemain) || numberDateRemain != null) {
		thoigianconlai = Integer.parseInt(numberDateRemain) > 0 ? Integer.parseInt(numberDateRemain) : thoigianconlai;
	}
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	
	// phmphuc update thoi gian phan cong xu ly 18/11/2010
	String expireDateProcess = ""; 
	
	DocumentReceiptUtil documentReceiptUtil = new DocumentReceiptUtil();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	try {
		expireDateProcess = dateFormat.format(documentReceiptUtil.getExpectedReturningDate(numberDateRemain, dateFormat.format(new Date())));
	} catch (Exception e) { }
	// end phmphuc update 18/11/2010
%>
<portlet:actionURL var="form">
</portlet:actionURL>
<!--  form name="<portlet:namespace />form" action="<//%=form %>" method="post" onsubmit="return validateUserAssign();"-->
<%//TSS %>
<form name="<portlet:namespace />form" action="<%=form %>" method="post" onsubmit="return subUserAss();">
<%//END TSS %>
<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
	<tr valign="top">
		<td width="20%" ><label><liferay-ui:message key="LCCV-yeucauxuly" /></label>&nbsp; :</td>
		<td>
			<textarea name="<portlet:namespace /><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="processInformation" rows="2" style="width: 95%" ></textarea>
			<input value="true" id="<portlet:namespace />checkInfo" name="<portlet:namespace />checkInfo" type="checkbox" checked="checked" onclick="choiceProcessInformation(this);">
		</td>
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
		<td >
			<label><liferay-ui:message key="LCCV-nguoinhan" /></label><font color="red">(*)</font> &nbsp;:</td>
		<td>
		<div style="width: 98%">
		
		<%
			String rowAllNameUser = "checkallboxUser";
			String formNameUser = renderResponse.getNamespace() + "form";
			String rowNameUser = renderResponse.getNamespace() + "supportUsers";
						
			StringBuilder rowAllNameCheckedUser = new StringBuilder();
			rowAllNameCheckedUser.append("<input name=\"");
			rowAllNameCheckedUser.append(rowAllNameUser);
			rowAllNameCheckedUser.append("\" type=\"checkbox\" ");
			rowAllNameCheckedUser.append("onClick=\"Liferay.Util.checkAll(");
			rowAllNameCheckedUser.append(formNameUser);
			rowAllNameCheckedUser.append(", '");
			rowAllNameCheckedUser.append(rowNameUser);
			rowAllNameCheckedUser.append("', this");
			rowAllNameCheckedUser.append(");checkAllOrNoneUserAssignTwo(this);openAllInfo(this);\">");
						
		%>
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
				<td align="center" width="5%"><img src="/html/images/grippy.png" />&nbsp;<%=  rowAllNameCheckedUser.toString()%></td>
				<td width="40%"><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
				<td ></td>
			</tr>
		<logic:iterate id="user" name="userList" indexId="k" type="com.liferay.portal.model.User" scope="request" >
		<%
			String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		%>
		<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'}" 
			<%-- minh update 20101112 onclick="checkUserAssign(this);openProcessInfoForEveryUserTr(this);"--%>
		onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
			<td align="center" id="<%= k%>">
				<img src="/html/images/grippy.png" />&nbsp;<input type="checkbox" onclick="Liferay.Util.checkAllBox(<%= formNameUser%>, '<%=  rowNameUser %>', <%= rowAllNameUser %>);openProcessInfoForEveryUser(this);clickCheckBox(event,this);" name="<portlet:namespace/>supportUsers" id="nguoiNhan<%= k%>" value="<%=user.getUserId() %>" />
			</td>
			<td >
				<%=fullName %>
			</td>
			
			<td >
				<div id="<portlet:namespace />user<%= k%>" style="display: none;">
					<textarea  name="<portlet:namespace />processInformationForUser<%=user.getUserId() %>" rows="1" style="width: 95%" ></textarea>
				</div>	
			</td>
		</tr>
		</logic:iterate>
		</table>
		</div>
		</td>
	</tr>
	<tr >
		<td>
			<label><liferay-ui:message key="document_main_process_employee" /></label><font color="red">(*)</font>&nbsp;:</td>
		<td><select style="width: 98%" id="selectedOptionsmain" name="<portlet:namespace />mainUser"></select></td>
	</tr>
	
	
	<% if (tongthoigian == 0) { %>
		<tr style="display: none;">
		
	<% } else {%>	
		<tr>
	<%}%>		
		
			<td ><liferay-ui:message key="LCCV-thoigian"/>:</td>
			
			<td rowspan="2">
				<liferay-ui:message key="LCCV-tongthoigian"/> : <b><%=tongthoigian > 0 ? daysProcessDeparmentMain : "  " %></b> <liferay-ui:message key="ngay" /> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-thoigianconlai"/>: <b><%=thoigianconlai > 0 ? numberDateRemain : "  " %></b> <liferay-ui:message key="ngay" /> <br>
				<input type="hidden" id="timeRemain" value="<%=numberDateRemain %>"/>
				<liferay-ui:message key="LCCV-thoigiangiaiquyetcuachuyenvien"/>
				
				<input type="hidden" name= "ddXLChinh" id = "ddXLChinh" value = "<%=ddXLChinh %>" />
				<input type="hidden" name= "ddXLDuocGiao" id = "ddXLDuocGiao" value = "<%=ddXLDuocGiao %>" />
				<input type="hidden" name="<porlet:namespace />dateNow" value="<%=dateNow %>" id="<portlet:namespace />dateNow"/>
				<input type="radio" name="saveChoiceDate" id = "check_1" checked="checked" onClick="saveChoiceDateNum()"/>&nbsp;&nbsp; 
				<input size="2" type="text" name="<portlet:namespace />dateNumberProcess" id="dateNumberProcess" value='<%=thoigianconlai > 0 ? numberDateRemain : "" %>'>&nbsp;&nbsp;<liferay-ui:message key="ngay" />
				<input type="radio" name="saveChoiceDate" id = "check_2" onClick="saveChoiceDateCalen()" />&nbsp;&nbsp;
				<input style="width: 128px" type="text" name="totalDateProcessCalen" id="totalDateProcessCalen" value="<%= expireDateProcess %>" disabled="disabled"/>
			</td>
		</tr>
	
	
</table>

<div align="right" id="table-button">
		<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
		<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
		<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
	      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</div>
</form>