<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/pcccdocumentsendprocess-js.jsp"/>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/changeselectboxvalue.jsp"/>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />

<portlet:actionURL var="form" >
</portlet:actionURL>
<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
%>

<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" onsubmit="return validateTransForm();">
	<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>senderId" value="<%= loginUser.getUserId() %>"></td>
	<input type="hidden" readonly="readonly" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>dateProcess" id="ngayGui" style="width:100%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>' >

<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
	<div class="boxcontent">
		<table cellspacing="0" width="100%">
			<tr valign="top">
				<td width="14%"><label><liferay-ui:message key="LCCV-trinhkydenghi" /></label><font size="1" color="red">(*)</font> &nbsp;:</td>
				<td align="right"><textarea name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="thongTinXuLy" rows="2" style="width: 98%"></textarea></td>
			</tr>
			
			<tr>
				<td></td>
				<td style="padding-left: 1.1%;">
					<span style="background: #ccf1f7;padding: 2px 5px;">
						<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
					</span>
				</td>
			</tr>
			<tr valign="top">
				<td ><label><liferay-ui:message key="LCCV-nguoinhan" /></label> <font size="1" color="red">(*)</font>&nbsp;:</td>
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
							<tr id="bgtran-tr" class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onclick="getSelectRadio(this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
								<td align="center" id="<%= i %>">
									<input <%= ((i == 0) ? "checked='checked'" : "")  %> class="styled" type="radio" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId" id="nguoiNhan<%= i %>"  value="<%=user.getUserId() %>" onclick="clickRadio(event)" />
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
			<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/taskAction.jsp"></liferay-util:include>
			<a onClick="window.history.back()"><input class="button" type="button" value='<liferay-ui:message key="back"/>'></a>
		</div>
	</div>
</form>

<script type="text/javascript">
window.onload = function () {
	document.getElementById('thongTinXuLy').focus();	
	
}
</script>