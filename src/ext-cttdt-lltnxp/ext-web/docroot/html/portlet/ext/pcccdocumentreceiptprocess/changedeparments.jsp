<%@ include file="/html/portlet/ext/processtype/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>

<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.util.DocumentReceiptUtil"%>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%//TSS %>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp"></liferay-util:include>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%//End TSS %>

<script language="javascript">
window.onload=function() {
	document.getElementById('processInformation').focus();	
	//TSS
	if(document.getElementById('totalDateProcessCalen') != null) {
		callCalendar('totalDateProcessCalen','cal-button-ToDate');
	}
	if(document.getElementById('totalDateProcessCalenRes') != null) {
		callCalendar('totalDateProcessCalenRes','cal-button-ToDateRes');
	}	
}	
	//End
	function printPhieuChuyen() {
		var userProcess = "";
		var url = "";
		// phmphuc close 18/06/2010
		// var mainDepartmentId =  DWRUtil.getValue('selectedOptionsmain')		
		// url = document.getElementById('print').value + "&mainDepartment=" + mainDepartmentId; 
		// end
		
		var mainUserId = DWRUtil.getValue('selectedOptionsmain')
		var processInformation = DWRUtil.getValue('processInformation');
		var dateNumberProcess = DWRUtil.getValue('dateNumberProcess');
		var totalDateProcessCalenRes = DWRUtil.getValue('totalDateProcessCalenRes');
		var nochoosetime = document.getElementById("nochoosetime");
		if (nochoosetime.checked) {
			url = document.getElementById('print').value + "&mainUser=" + mainUserId + "&processInformation=" + processInformation;		 
		}
		else {
			url = document.getElementById('print').value + "&mainUser=" + mainUserId + "&processInformation=" + processInformation
					+ "&dateNumberProcess=" + dateNumberProcess + "&totalDateProcessCalenRes=" + totalDateProcessCalenRes;		 
		}
		return url
	}

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
	
	// minh update 20100316
	long documentReceiptId = ParamUtil.getLong(renderRequest, "documentReceiptId");
	PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
	String documentReceiptType = "" ;
	try {
		pmlEdmDocumentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		documentReceiptType = pmlEdmDocumentReceipt.getDocumentType();
	} catch (Exception e) {
		documentReceiptType = "";
	}
	//emd
	
	// phmphuc update thoi gian phan cong xu ly 18/11/2010
	String expireDateProcess = ""; 
	
	DocumentReceiptUtil documentReceiptUtil = new DocumentReceiptUtil();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	try {
		expireDateProcess = dateFormat.format(documentReceiptUtil.getExpectedReturningDate(""+15, dateFormat.format(new Date())));
	} catch (Exception e) { }
	// end phmphuc update 18/11/2010

%>

<portlet:actionURL var="inphieuchuyen">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/inphieuchuyen" />	
	<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "documentReceiptId" %>' value="<%= ParamUtil.getString(renderRequest, "documentReceiptId") %>"/>
</portlet:actionURL> 
<portlet:actionURL var="form"></portlet:actionURL>

<form name="<portlet:namespace/>fm" action="<%=form%>" method="post" onsubmit="return subDepart();">
<input type="hidden" id="countLDB" name="countLDB" />
<input type="hidden" id="print" value="<%= inphieuchuyen %>"/> 

<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
	<tr valign="top">
		<td width="18%"><label><liferay-ui:message key="LCCV-yeucauxuly" /> </label>&nbsp;:</td>
		<td ><textarea name="<portlet:namespace />processInformation" id="processInformation" rows="2" style="width: 96%"></textarea>
		<input value="true" id="<portlet:namespace />checkInfo" name="<portlet:namespace />checkInfo" type="checkbox" checked="checked" onclick="choiceProcessInformation(this);">
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
		<span style="background: #ccf1f7;padding: 2px 5px;">
			<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%= new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> 
			&nbsp;-&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%= loginName %></b>
		</span>
		</td>
	</tr>
	<tr valign="top">
		<td><label><liferay-ui:message key="LCCV-phongbannhan" /></label><font color="red">(*)</font> &nbsp;:</td>
		<td>
		<div style="width: 99%" class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		
		<%
			String rowAllNameUser = "checkallboxUser";
			String formNameUser = renderResponse.getNamespace() + "fm";
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
			rowAllNameCheckedUser.append(");checkAllOrNoneUserAssign(this);openAllInfo(this);\">");
						
		%>
				<tr class="portlet-section-header results-header" >
					<td align="center" width="40px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameCheckedUser.toString() %></td>
					<td width="30%"><liferay-ui:message key="ten"/></td>
					<td width="30%"><liferay-ui:message key="LCCV-tenphongban"/></td>
					<td><liferay-ui:message key="LCCV-yeucauxuly"/></td>
				</tr>
				
				<logic:iterate  id="departmentLeader" name="pmlDepartmentsLeaderList" type="com.sgs.portlet.onedoor.model.PmlDepartmentsLeader" scope="request" indexId="k">
				<%
					long userId = departmentLeader.getUserId();
					String departmentId = departmentLeader.getDepartmentsId();
					String userName = "";
					String deparmentName = "";
					try {
						User userLeader = UserUtil.findByPrimaryKey(userId);
						userName = userLeader.getLastName().concat(" ") +  userLeader.getMiddleName().concat(" ") + userLeader.getFirstName();
						deparmentName = DepartmentUtil.findByPrimaryKey(departmentId).getDepartmentsName();
					} catch (Exception e){
						System.out.println("ERROR: no user or deparment in file changedeparment.jsp");
					}
				%>
				<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'}" 
				
				<%--onclick="checkUserAssign(this)"--%>
				
				onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
					<td align="center" id="<%= k%>">
						<img src="/html/images/grippy.png" />&nbsp;<input class="styled" type="checkbox" onclick="Liferay.Util.checkAllBox(<%= formNameUser%>, '<%=  rowNameUser %>', <%= rowAllNameUser %>);openProcessInfoForEveryUser(this);clickCheckBox(event,this);" name="<portlet:namespace/>supportUsers" id="nguoiNhan<%= k%>" value="<%= String.valueOf(userId) %>" />
					</td>
					<td ><%= userName %></td>
					<td><%= deparmentName %></td>
					<td >
						<div id="<portlet:namespace />user<%= k%>" style="display: none;">
							<textarea  name="<portlet:namespace />processInformationForUser<%= String.valueOf(userId) %>" rows="1" style="width: 95%" ></textarea>
						</div>	
					</td>
				</tr>
				</logic:iterate>
				</table>
				</div>
				</td>
			</tr>
			<!-- minh update 20100316 -->
			<% 
			 if (null != documentReceiptType && !"".equals(documentReceiptType)) {
			%>
			<tr  style="display:none;"></tr>
			<%} else {
			%>
			<tr>
			<%} %>
			<!--  end  -->
				<td valign="top">
						<label>	<liferay-ui:message key="LCCV-cach-thuc-xu-ly" /><font color="red">(*)</font>&nbsp;:</label>
				</td>
				<td >
					<div style="width: 99%;" class="Scrollbarauto">
					
						<%
							String rowAllName = "checkallbox";
							String formName = renderResponse.getNamespace() + "fm";
							String rowName = renderResponse.getNamespace() + "processType";
						
							StringBuilder rowAllNameChecked = new StringBuilder();
							rowAllNameChecked.append("<input name=\"");
							rowAllNameChecked.append(rowAllName);
							rowAllNameChecked.append("\" type=\"text\" ");
							rowAllNameChecked.append("\">");
							
						%>
						<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
							<tr class="portlet-section-header results-header" >
								<td width="40px" align="center">##</td>
								<td ><liferay-ui:message key="ten-cach-thuc-xu-ly"/></td>
							</tr>
						<logic:iterate id="listprocesstype" name="listprocesstype" type="com.ext.portlet.processtype.model.ProcessType" scope="request" indexId="l">
							<tr class="${((l % 2) == 0) ? 'results-row' : 'tr_two results-row'}" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
								<td align="center" id="<%= l%>">
									<img src="/html/images/grippy.png" />&nbsp;<input class="styled"  type="radio" name="<portlet:namespace/>processType" id="cachThucXL<%= l%>" value="<%= listprocesstype.getProcessTypeId()%>" />
								</td>
								<td><%= listprocesstype.getName() %></td>
							</tr>
						</logic:iterate>
						</table>
					</div>
				</td>
			</tr>
			<!-- khong dung nua - khong hien thi-->
			<tr  style="display:none;">
				<td ><liferay-ui:message key="LCCV-cach-thuc-xu-ly" /><font color="red">(*)</font> &nbsp;: </td>
				<td style="padding-left: 3px">
					<input type="radio" name="<portlet:namespace />documentType" value="1"></input> <liferay-ui:message key="LCCV-cong-van-luu" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="<portlet:namespace />documentType" value="2"></input> <liferay-ui:message key="LCCV-cong-bao-cao" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="<portlet:namespace />documentType" value="3"></input> <liferay-ui:message key="LCCV-soan-cong-van-tra-loi" />
				</td>
			</tr>
			<!-- khong dung nua - khong hien thi-->
			<tr>
						<td><label><liferay-ui:message key="LCCV-phongbanxulychinh" /></label>&nbsp;: </td>
						
						<td>
						<!-- select style="width: 99%" id="selectedOptionsmain" name="<portlet:namespace />mainDepartment"></select-->
						<select style="width: 99%" id="selectedOptionsmain" name="<portlet:namespace />mainUser" ></select>
						</td>
			</tr>
					
					<!-- minh update 20100316 -->
					<%-- 
					 if (null != documentReceiptType && !"".equals(documentReceiptType)) {
					--%>
					<%--tr  style="display:none;"--%>
					<%--} else {--%>
					<tr>
					<%--} --%>
					<!--  end  -->
						
						<td><liferay-ui:message key="LCCV-thoigian"/>&nbsp;:</td>
						<td>
							<table width="100%" cellspacing="0">
								<tr>
									<td width="30%"><liferay-ui:message key="LCCV-tongthoigian"/>&nbsp;:</td>
									<td>									
										<input type="radio" name="saveChoiceDate" id = "check_1" checked="checked" onClick="saveChoiceDateNum()"/>&nbsp;&nbsp;					
										<input size="2" type="text" name="<portlet:namespace />totalDateProcess" id="totalDateProcess" value="15" />  
										<liferay-ui:message key="ngay" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
										<input type="radio" name="saveChoiceDate" id = "check_2" onClick="saveChoiceDateCalen()" />&nbsp;&nbsp;
									<!-- phmphuc close and update 18/11/2010 -->
										<input style="width: 128px" type="text" name="<portlet:namespace />totalDateProcessCalen" id="totalDateProcessCalen" 
												value="<%= expireDateProcess %>" disabled="disabled" />								
									<!-- end phmphuc update 18/11/2010 -->
										<input type="hidden" name="<porlet:namespace />dateNow" value="<%=dateNow %>" id="<portlet:namespace />dateNow"/>
										<input type="hidden" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-TotalDate" onclick="callCalendar('totalDateProcessCalen','cal-button-TotalDate');" />
									</td>			
								</tr>
								<tr>
									<td ><liferay-ui:message key="LCCV-thoigiangiaiquyetcuaphong"/>&nbsp;:</td>
									<td>
										<input type="radio" name="saveChoiceDateRes" id = "check_3" checked="checked" onClick="saveChoiceDateNum()"/>&nbsp;&nbsp;
										<input size="2" type="text" name="<portlet:namespace />dateNumberProcess" id="dateNumberProcess" value="15"> 					
										<liferay-ui:message key="ngay" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
										<input type="radio" name="saveChoiceDateRes" id ="check_4" onClick="saveChoiceDateCalen()" />&nbsp;&nbsp;
									<!-- phmphuc close and update 18/11/2010 -->
										<input style="width: 128px" type="text" name="<portlet:namespace />totalDateProcessCalenRes" id="totalDateProcessCalenRes" 
												value="<%= expireDateProcess %>" disabled="disabled" />					
									<!-- end phmphuc update 18/11/2010 -->
										<input type="hidden" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-TotalDateRes" onclick="callCalendar('totalDateProcessCalenRes','cal-button-TotalDateRes');" />
									</td>
								</tr>
								<tr>
									<td ><liferay-ui:message key="LCCV-khongcanchonthoigian" />&nbsp;:</td>
									<td><input type="checkbox" id="nochoosetime" onclick="noChooseTime()"></td>
								</tr>
							</table>
						</td>
					</tr>
</table>

<input type="hidden" id="documentReceiptId" name="<portlet:namespace />documentReceiptId" value='<%=renderRequest.getAttribute("documentReceiptId") %>'>
<input type="hidden" id="isBookDocumentRecord"  value="">
<input type="hidden" id="documentReceiptType"  value="<%= documentReceiptType %>">

<div align="right" id="table-button">
		<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
		<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
		<span onclick="javascript:submitForm(document.hrefFm, printPhieuChuyen());" >
		<input type="button" value='<liferay-ui:message key="in-phieu-chuyen"/>' ></span>
		<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
	      <a onClick="window.history.back()"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</div>
</form>