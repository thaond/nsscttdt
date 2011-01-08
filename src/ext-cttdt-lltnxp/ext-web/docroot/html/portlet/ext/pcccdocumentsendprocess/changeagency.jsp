<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/js/changeselectboxvalue.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%><script language="javascript">

window.onload=function(){
	createListObjects();
}

</script>
<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	//PmlEdmDocumentReceipt documentReceipt = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	
//	String daysProcessDeparmentMain = (String)renderRequest.getAttribute("daysProcessDeparmentMain");
	//String numberDateRemain = (String) renderRequest.getAttribute("numberDateRemain");
	//int tongthoigian = 0;
//	int thoigianconlai = 0;
	//if (!"".equals(daysProcessDeparmentMain) || daysProcessDeparmentMain != null) {
	//	tongthoigian = Integer.parseInt(daysProcessDeparmentMain);
//	}
	
	//if (!"".equals(numberDateRemain) || numberDateRemain != null) {
		//thoigianconlai = Integer.parseInt(numberDateRemain) > 0 ? Integer.parseInt(numberDateRemain) : thoigianconlai;
//	}
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
%>

<portlet:actionURL var="form">
</portlet:actionURL>

<form name="<portlet:namespace />form" action="<%=form %>" method="post" onsubmit="return validateUserAssign();">
<fieldset>
<legend class="legend-noborder"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan" /></legend>
<table cellpadding="0" cellspacing="0" border="0" width="60%" style="font-size: 13px">
<tr>
	<td>
		<fieldset>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr class="td-left"><td class="blank-height-10"></td><td class="blank-height-10"></td></tr>
			<tr valign="top">
				<td width="17%" class="td-left" style="font-weight: bold;"><liferay-ui:message key="LCCV-trinhkydenghi" />:</td>
				<td><textarea name="<portlet:namespace /><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="processInformation" rows="2" style="width: 99%"></textarea></td>
			</tr>
			<tr class="td-left"><td class="blank-height-10"></td></tr>
			<tr class="td-left">
				<td class="td-left" style="font-weight: bold;"></td>
				<td align="left"><liferay-ui:message key="LCCV-ngaygiochuyen" />: <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" />: <b><%=loginName %></b></td>
			</tr>
			<tr class="td-left"><td class="blank-height-10"></td><td class="blank-height-10"></td></tr>
			<tr valign="top">
				<td class="td-left" style="font-weight: bold;"><liferay-ui:message key="LCCV-nguoinhan" /><font color="red">(*)</font>:</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1" width="100%" class="box">
					<tr class="title">
						<td width="55px"><liferay-ui:message key="select"/></td>
						<td><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
					</tr>
					</table>
					<div class="scroll">
						<table cellpadding="0" cellspacing="0" border="1" width="100%" class="table-list">
						
						<logic:iterate id="position" name="positionList" indexId="k" type="com.sgs.portlet.position.model.Position" scope="request" >
						
						<tr onMouseOut="nofocusColor(this)" onMouseover="this.style.backgroundColor='#F5F5DC';" class="${((k % 2) == 0) ? 'cvdrowOne':'cvdrowTwo'}" onclick="checkUserAssign(this)">
							<td width="55px" id="<%= k%>">
								<input  type="radio" onclick="clickCheckBox(event,this)" name="<portlet:namespace/>supportUers" id="nguoiNhan<%= k%>" value="<%=user.getUserId() %>" />
							</td>
							<td align="left"><%=position.getPositionName() %></td>
						</tr>
						</logic:iterate>
						
						</table>
					</div>
				</td>
			</tr>
			<tr class="td-left"><td class="blank-height-10"></td></tr>
			<tr>
				<td class="td-left" style="font-weight: bold;"><liferay-ui:message key="LCCV-thoigian"/>: </td>
				<td rowspan="2">
					<liferay-ui:message key="LCCV-tongthoigian"/>: <b>tongthoigian</b> <liferay-ui:message key="ngay" /> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-thoigianconlai"/>: <b>thoigianconlai</b> <liferay-ui:message key="ngay" /> <br>
					<input type="hidden" id="timeRemain" value="numberDateRemain"/>
				</td>
			</tr>
			<tr  class="td-left"><td ></td><td ></td></tr>
			<tr height="10"><td class="td-left"></td><td class="td-left"></td></tr>
			</table>
		</fieldset>
	</td>
</tr>
<br/>
</table>
<div class="bg-header-footer" align="right">
	<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
	<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
	<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/taskAction.jsp"></liferay-util:include>
      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</fieldset>
</form>
