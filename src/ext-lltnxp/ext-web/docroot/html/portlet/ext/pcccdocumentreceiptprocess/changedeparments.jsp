<%@page import="com.sgs.portlet.receivergroup.util.ReceiverKeys"%>
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

<script type="text/javascript">
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
	<!-- Canh update 20110122 -->
	<tr valign="top">
		<td><label><liferay-ui:message key="noi-nhan" /></label><font color="red">(*)</font> &nbsp;:</td>
		<td style="padding-right: 1%" >
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1"><liferay-ui:message key="phong-ban" /></a></li>
				<li><a href="#tabs-2"><liferay-ui:message key="receiver-group" /></a></li>
			</ul>
			<div id="tabs-1">
				<div class="Scrollbarauto">					
						<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
								<thead>
								<tr class="portlet-section-header results-header" >
									<td align="center" width="40px"><img src="/html/images/grippy.png" />&nbsp;<input type="checkbox" name="checkallboxUser"/></td>
									<td width="30%"><liferay-ui:message key="ten"/></td>
									<!--<td width="30%"><liferay-ui:message key="LCCV-tenphongban"/></td>
									--><td><liferay-ui:message key="LCCV-yeucauxuly"/></td>
								</tr>
								</thead>
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
								>
									<td align="center" id="<%= k%>">
										<img src="/html/images/grippy.png" />&nbsp;<input class="styled" type="checkbox" name="<portlet:namespace/>supportUsers" id="nguoiNhan<%= k%>" value="<%= String.valueOf(userId) %>" data="<%= userName %>"/>
									</td>
									<td ><font style="font-size: 12px; font-weight: bold;color: #444;"><%= userName %></font><br/><font style="font-size: 12px"><liferay-ui:message key="phong"/>:&nbsp;<%= deparmentName %></font></td>
									<!--<td></td>
									--><td >
										<div id="<portlet:namespace />user<%= k%>" style="display: none;">
											<input type="text"  name="<portlet:namespace />processInformationForUser<%= String.valueOf(userId) %>" rows="1" style="width: 95%" />
										</div>	
									</td>
								</tr>
								</logic:iterate>
						</table>
				</div>
			</div>
			<div id="tabs-2">
				<input type="hidden" name="<portlet:namespace/>supportUsers2" id="<portlet:namespace/>supportUsers2" style="width: 100%;"/>
				<liferay-portlet:renderURL portletName="<%=ReceiverKeys.PORTLET_NAME %>" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>" var="luong1">
				<liferay-portlet:param name="struts_action" value="/sgs/receivergroup/view" />
				<liferay-portlet:param name="<%=ReceiverKeys.TYPE %>" value="<%= String.valueOf(ReceiverKeys.PERSONAL) %>" />
				</liferay-portlet:renderURL>
				<div id="boxcontent"></div>				
			</div>
		</div>
				</td>
			</tr>
			<!-- End of Canh -->
			<tr>
						<td><label><liferay-ui:message key="LCCV-phongbanxulychinh" /></label>&nbsp;: </td>
						
						<td>
						<!-- select style="width: 99%" id="selectedOptionsmain" name="<portlet:namespace />mainDepartment"></select-->
						<select style="width: 99%" id="selectedOptionsmain" name="<portlet:namespace />mainUser" ></select>
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
<script type="text/javascript">
/*Canh update 20110122*/
$jq(function(){
	$jq("#<portlet:namespace />checkInfo").change(function(){
		<portlet:namespace/>choiceProcessInformation();
		<portlet:namespace/>choiceProcessInformationTree();
		/*if ($jq("#<portlet:namespace />checkInfo").attr('checked')) {
			$jq('#processInformation').attr('disabled', false);
		} else {
			$jq('#processInformation').attr('disabled', true);
		}*/
	});
	$jq('#processInformation').keyup(function(){
		var ele = $jq(this);
		$jq("input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked").each(function(){
			var e = $jq(this).parent();
			while (!e.is('tr')) {
				e = e.parent();
			}
			e.find("input[type=text]").val(ele.val());
		});
		var tree = $jq("#nss_jstree1");
		var ref = $jq.jstree._reference(tree);
		ref.get_checked().each(function(){
			if ($jq(this).is(".branch")) {
				$jq(this).find("li").each(function(){
					$jq(this).find("input[type=text]").not('.i').show().val(ele.val());
					$jq(this).find("input[type=text]").not('.i').prev('input[type=text]:first').hide();
				});
			} else {
				$jq(this).find("input[type=text]").not('.i').show().val(ele.val());
				$jq(this).find("input[type=text]").not('.i').prev('input[type=text]:first').hide();
			}
		});
	});
	$jq('#processInformation').blur(function(){
		var tree = $jq("#nss_jstree1");
		var ref = $jq.jstree._reference(tree);
		$jq(this).val($jq(this).val().trim());
		if ($jq(this).val().length == 0) {
			ref.get_checked().each(function(){
				if ($jq(this).is(".branch")) {
					$jq(this).find("li").each(function(){
						$jq(this).find("input[type=text]").not('.i').hide().prev('input[type=text]:first').show();
					});
				} else {
					$jq(this).find("input[type=text]").not('.i').hide().prev('input[type=text]:first').show();
				}
			});
		}
	});
	$jq('input[name=checkallboxUser][type=checkbox]').change(function(){
		Liferay.Util.checkAll(document.<portlet:namespace />fm, '<portlet:namespace/>supportUsers', this);
		$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]').each(function(){
			openProcessInfoForEveryUser(this);
		});
	});
	$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]').change(function(event){
		Liferay.Util.checkAllBox(document.<portlet:namespace />fm, '<portlet:namespace/>supportUsers', document.<portlet:namespace />fm.checkallboxUser);
		openProcessInfoForEveryUser(this);
		clickCheckBox(event,this);
	});
	$jq('input[name=checkallboxOrganization][type=checkbox]').live("change", function(){
		Liferay.Util.checkAll(document.<portlet:namespace />fm, '<portlet:namespace/>organizations', this);
	});
	$jq('input[name=<portlet:namespace/>organizations][type=checkbox]').live("change", function(event){
		Liferay.Util.checkAllBox(document.<portlet:namespace />fm, '<portlet:namespace/>organizations', document.<portlet:namespace />fm.checkallboxOrganization);
	});
	
});


var _personalCallback = function() {
	$jq("#<portlet:namespace/>supportUsers2").val("");
	$jq("input[name=checkallboxUser][type=checkbox], input[name=<portlet:namespace/>supportUsers]").change(function(){
		<portlet:namespace/>selectUserEvent();
	});
	$jq("#nss_jstree1").unbind("check_node.jstree uncheck_node.jstree").bind("check_node.jstree uncheck_node.jstree", function(){
		setTimeout('<portlet:namespace/>selectUserTreeEvent()', 150);
		setTimeout('<portlet:namespace/>choiceProcessInformationTree()', 150);
	});
};
var _receivingPlaceCallback = function() {
	$jq("#<portlet:namespace/>receivers").val("");
	$jq("#nss_jstree3").unbind("select_node.jstree").bind("select_node.jstree", function(){
		setTimeout('<portlet:namespace/>selectOrgTreeEvent()', 150);
	});
};

function <portlet:namespace/>choiceProcessInformation() {
	var ctrlEle = $jq("#<portlet:namespace />checkInfo");
		if (ctrlEle.attr("checked")) {
			$jq("input[name=<portlet:namespace/>supportUsers][type=checkbox]").parents('tr').find("input[type=text]").parent().hide();
		} else {
			$jq("input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked").each(function(){
				var e = $jq(this).parent();
				while (!e.is('tr')) {
					e = e.parent();
				}
				e.find("input[type=text]").parent().show();
			});
		}
}

function <portlet:namespace/>choiceProcessInformationTree() {
	var ctrlEle = $jq("#<portlet:namespace />checkInfo");
	var tree = $jq("#nss_jstree1");
	var ref = $jq.jstree._reference(tree);
	ref.get_checked().each(function(){
		if ($jq(this).is(".branch")) {
			$jq(this).find("li").each(function(){
				if (ctrlEle.attr("checked")) {
					$jq(this).find("span").hide();
				} else {
					$jq(this).find("span").show();
				}
			});
		} else {
			if (ctrlEle.attr("checked")) {
				$jq(this).find("span").hide();
			} else {
				$jq(this).find("span").show();
			}
		}
	});
	ref.get_unchecked().each(function(){
		if ($jq(this).is(".branch")) {
			$jq(this).find("li").each(function(){
				$jq(this).find("span").hide();
			});
		} else {
			$jq(this).find("span").hide();
		}
	});
}
	
function <portlet:namespace/>selectUserEvent() {
	var tree = $jq("#nss_jstree1");
	var ref = $jq.jstree._reference(tree);
	ref.uncheck_all();
	<portlet:namespace/>choiceProcessInformationTree();
	$jq("#<portlet:namespace/>supportUsers2").val('');
	
	var data = new Object();
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked').each(function(){
		data[$jq(this).val()] = $jq(this).attr("data");
	});
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}
}
function <portlet:namespace/>selectOrgEvent() {
	var tree = $jq("#nss_jstree3");
	var ref = $jq.jstree._reference(tree);
	ref.uncheck_all();
	<portlet:namespace/>choiceProcessInformationTree();
	$jq("#<portlet:namespace/>receivers").val('');
	
	/*var data = new Object();
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked').each(function(){
		data[$jq(this).val()] = $jq(this).attr("data");
	});
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}*/
}

function <portlet:namespace/>selectUserTreeEvent() {
	$jq('input[name=checkallboxUser][type=checkbox]').attr("checked", false);
	$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked').each(function(){
		$jq(this).attr("checked", false);
		openProcessInfoForEveryUser(this);
	});
	
	var data = new Object();
	var tree = $jq("#nss_jstree1");
	var ref = $jq.jstree._reference(tree);
	$jq(":checked[name=<portlet:namespace/>supportUsers]").attr('checked', false);
	ref.get_checked().each(function(){
		if ($jq(this).is(".branch")) {
			$jq(this).find("li").each(function(){
				data[$jq(this).attr("id")] = $jq(this).find("a").text().trim();
			});
		} else {
			data[$jq(this).attr("id")] = $jq(this).find("a").text().trim();
		}
		return data;
	});
	$jq("#<portlet:namespace/>supportUsers2").val(JSON.stringify(data));
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}
	/*$jq("#countLDB").val(data.length);
	$jq("input[name=<portlet:namespace/>supportUsers][checked=true]").each(function(){
		if ($jq(this).attr("checked")) {
			data[$jq(this).val()] = $jq(this).attr("data");
			return data;
		}
	});
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}*/
}
function <portlet:namespace/>selectOrgTreeEvent() {
	$jq('input[name=checkallboxUser][type=checkbox]').attr("checked", false);
	$jq('input[name=<portlet:namespace/>supportUsers][type=checkbox]:checked').each(function(){
		$jq(this).attr("checked", false);
		openProcessInfoForEveryUser(this);
	});
	
	var data = new Object();
	var tree = $jq("#nss_jstree1");
	var ref = $jq.jstree._reference(tree);
	$jq(":checked[name=<portlet:namespace/>supportUsers]").attr('checked', false);
	ref.get_checked().each(function(){
		if ($jq(this).is(".branch")) {
			$jq(this).find("li").each(function(){
				data[$jq(this).attr("id")] = $jq(this).find("a").text().trim();
			});
		} else {
			data[$jq(this).attr("id")] = $jq(this).find("a").text().trim();
		}
		return data;
	});
	$jq("#<portlet:namespace/>supportUsers2").val(JSON.stringify(data));
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}
	/*$jq("#countLDB").val(data.length);
	$jq("input[name=<portlet:namespace/>supportUsers][checked=true]").each(function(){
		if ($jq(this).attr("checked")) {
			data[$jq(this).val()] = $jq(this).attr("data");
			return data;
		}
	});
	var ele = $jq("#selectedOptionsmain");
	ele.empty();
	for (var a in data) {
		var e = $jq("<option/>");
		e.val(a);
		e.text(data[a]);
		ele.append(e);
	}*/
}

function <portlet:namespace/>selectReceivingPlaceEvent() {
	var data = new Object();
	var tree = $jq("#nss_jstree3");
	var ref = $jq.jstree._reference(tree);
	ref.get_checked().each(function(){
		if ($jq(this).is(".branch")) {
			$jq(this).find("li").each(function(){
				data[$jq(this).attr("id")] = $jq(this).text().trim();
			});
		} else {
			data[$jq(this).attr("id")] = $jq(this).text().trim();
		}
		return data;
	});
	$jq("#<portlet:namespace/>receivers").val(JSON.stringify(data));
}

function initOrganizationList() {
	documentSendUtilClient.getIssuingPlace(function(data){
		if (!data || data.length == 0) {
			return;
		} else {
			var container = $jq("#organizationList");
			container.empty();
			for ( var i= 0; i < data.length; i++) {
				var pmlIssuingPlace = data[i];
				
				var tr = $jq('<tr/>');
				tr.addClass("results-row");
				if (i % 2 != 0) {
					tr.addClass("tr_two");
				}
				
				var td0 = $jq("<td align='center'/>");
				var checkbox = $jq('<input type="checkbox" name="<portlet:namespace/>organizations"/>');
				checkbox.val(pmlIssuingPlace.issuingPlaceId);
				td0.append('<img src="/html/images/grippy.png" />&nbsp;');
				td0.append(checkbox);
				
				var td1 = $jq("<td/>");
				td1.text(pmlIssuingPlace.issuingPlaceId);
				var td2 = $jq("<td/>");
				td2.text(pmlIssuingPlace.issuingPlaceName);
				var td3 = $jq("<td/>");
				td3.text(pmlIssuingPlace.note);
				
				tr.append(td0);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				
				container.append(tr);
			}
		}
	});
}

function <portlet:namespace/>isSelectingUser() {
	
	var tree = $jq("#nss_jstree1");
	var ref = $jq.jstree._reference(tree);
	if ($jq(":checked[name=<portlet:namespace/>supportUsers]").length > 0) {
		return true;
	} else if (ref.get_checked().length > 0) {
		return true;
	} else {
		return false;
	}
}

function <portlet:namespace/>isSelectingOrg() {
	var tree = $jq("#nss_jstree3");
	var ref = $jq.jstree._reference(tree);
	if ($jq(":checked[name=<portlet:namespace/>organizations]").length > 0) {
		return true;
	} else if (ref.get_checked().length > 0) {
		return true;
	} else {
		return false;
	}
}

$jq(function(){
	$jq("#boxcontent").load('<%= luong1%>', {"_callback": _personalCallback.toString(), "edit_text_name": "<%= renderResponse.getNamespace()%>processInformationForUser"});
	initOrganizationList();
	$jq("#tabs").tabs();
});
/*End of Canh*/
</script>
<style type="text/css">
.results-row:HOVER td {
	background: #bbedfc;
}
</style>