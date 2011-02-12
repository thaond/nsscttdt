<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>

<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pcccdocumentreceiptprocess-js.jsp"/>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<portlet:actionURL var="inphieuchuyen">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/inphieuchuyen" />	
	<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "documentReceiptId" %>' value="<%= ParamUtil.getString(renderRequest, "documentReceiptId") %>"/>
</portlet:actionURL> 

<portlet:actionURL var="form" >
</portlet:actionURL>

<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	List<User> userList = (List<User>) request.getAttribute("users"); 
	boolean userLDVP = false;
	for (User u : userList) {
		for(int i=0; i < listUser.length; i++){
			if (u.getUserId() == Integer.parseInt(listUser[i])){
				userLDVP = true;
				break;
			}
		}
	}
	
	boolean isDsVB = ParamUtil.getBoolean(renderRequest, "dsVBDen", false);
	String documentReceiptIdList  = ParamUtil.getString(renderRequest, "documentReceiptIdList");
%>

<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" onsubmit="return validateTransForm();">
<input type="hidden" id="print" value="<%= inphieuchuyen %>"/> 
<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
	<%
		if (userLDVP) {
			
	%>
	
		<tr valign="top" >				
		</tr>
		
	<%}	else { %>
		<tr valign="top"  >	
				<td width="14%" ><label><liferay-ui:message key="LCCV-trinhkydenghi" /></label> &nbsp;:</td>
				<td align="right"><textarea name="<portlet:namespace/>processInformation" id="processInformation" rows="2" style="width: 98%"></textarea></td>
		</tr>
	<%}  %>	
		<tr>
			<td></td>
			<td style="padding-left: 1.1%;">
				<span style="background: #ccf1f7;padding: 2px 5px;">
				<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
				</span>
				</td>
		</tr>

		<tr valign="top" >
			<td ><label><liferay-ui:message key="LCCV-nguoinhan" /></label> &nbsp;:</td>
			<td align="right">
			<div style="width: 99%">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
						<tr class="portlet-section-header results-header" >
							<td width="40px" align="center"><label><liferay-ui:message key="select"/></label></td>
							<td align="left"><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
						</tr>
						<logic:iterate id="user" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
						<%
					    	String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
					    %>
						<tr id="bgtran-tr" class="${((i % 2) == 0) ? 'results-row' : 'tr_two results-row'}" onclick="getSelectRadio(this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
							<td align="center" id="<%= i %>">
								<input <%= ((i == 0) ? "checked='checked'" : "")  %> class="styled" type="radio" name="<portlet:namespace/>receiverId" id="nguoiNhan<%= i %>"  value="<%=user.getUserId() %>" onclick="clickRadio(event)" />
							</td>
							<td align="left"><%=fullName %></td>
						</tr>
						</logic:iterate>
					</table>
			</div>
			</td>
		</tr>
</table>

<div align="right" id="table-button">
			<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
			<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
			<% if (isDsVB) { 
				PortletURL inPhieuChuyenURL = renderResponse.createRenderURL();
				inPhieuChuyenURL.setWindowState(LiferayWindowState.POP_UP);
				inPhieuChuyenURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/indsphieuchuyen");
				inPhieuChuyenURL.setParameter("documentReceiptIdList", documentReceiptIdList);
				
			%>
			<span onclick="<portlet:namespace />inDSPhieuChuyenTrans('<%= inPhieuChuyenURL.toString() %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="in-phieu-chuyen"/>' ></span>
			<% } else { %>
			<span onclick="javascript:submitForm(document.hrefFm,printPhieuChuyen());" ><input class="button-width" type="button" value='<liferay-ui:message key="in-phieu-chuyen"/>' ></span>
			<% } %>
			<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
			<a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</div>
</form>
<script type="text/javascript">
window.onload = function () {
	if(document.getElementById('processInformation') != null ){		
		document.getElementById('processInformation').focus();
	}
	
}

function printPhieuChuyen() {
	var userProcess = "";
	var url = "";
	var users = document.getElementsByName("<portlet:namespace/>receiverId");	 
	 

	 for ( var i = 0; i < users.length; i++) {
		if (users[i].checked) {
			userProcess = users[i].value;
			break;
		}		
	}
		url = document.getElementById('print').value + "&receiverId=" + userProcess;		 
	return url
}

function <portlet:namespace />inDSPhieuChuyenTrans(url) {
	// cho phan popup chon receiver
	var extWin = window.open(url, 'extendwin', 'directories=no, height=400, location=no, menubar=no, resizable=yes, scrollbars=yes, status=no, toolbar=no, width=1000');
	extWin.focus();
}

</script>
