<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pcccdocumentreceiptprocess-js.jsp"/>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<portlet:actionURL var="form" >
</portlet:actionURL>

<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
%>
<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" onsubmit="return validateTransForm();">
<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan" /></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
		<tr valign="top">
			<td width="18%"><label><liferay-ui:message key="LCCV-trinhkydenghi" /> </label>&nbsp;:</td>
			<td ><textarea name="<portlet:namespace/>processInformation" id="processInformation" rows="2" style="width: 98%"> </textarea></td>
		</tr>
		<tr>
			<td></td>
			<td align="left">
			<span style="background: #ccf1f7;padding: 2px 5px;">
			<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;-&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
			</span>
			</td>
		</tr>
		
		<tr valign="top" >
			<td ><label><liferay-ui:message key="LCCV-nguoinhan" /></label> &nbsp;:</td>
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
			<tr id="bgtran-tr" class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onclick="getSelectRadio(this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
				<td id="<%= i %>">
					<div align="center"><input <%= ((i == 0) ? "checked='checked'" : "")  %> class="styled" type="radio" name="<portlet:namespace/>receiverId" id="nguoiNhan<%= i %>"  value="<%=user.getUserId() %>" onclick="clickRadio(event)" /></div>
				</td>
				<td><div align="left"><%=fullName %></div></td>
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
			<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
			<a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</div>
</form>
<script type="text/javascript">
window.onload = function () {
	document.getElementById('processInformation').focus();	
}
</script>
