<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/quanlycongvan.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<liferay-portlet:actionURL var="form" portletConfiguration="true">
</liferay-portlet:actionURL>
<form action="<%=form %>" method="post">
<table style="width: 100%; margin-top: 10px; margin-bottom: 5px">
<tr>
	<td nowrap="nowrap" width="20%">
	 	<div style="padding-left: 3px;"><liferay-ui:message key="document_days_process" />: <div>
	</td>
			
	<td align="left">
	 	<input name="processDateNumber" type="text" size="5" value="<%=processDateNumberNew %>" onKeyup="isInteger(this.value)" />
	</td>
</tr>
</table>

<fieldset style="width: 99%">
<legend style="color: gray;" class="legend-noborder"><liferay-ui:message key="cauhinhchuyen-ldvp"/></legend>

<table>
<tr style="height: 28px;"  class="one-gate-no-border-title">
		<td width="2%" class="td-stt-pml">##</td>
		<td width="4%" class="td-stt-pml"><liferay-ui:message key="pccc-TN-stt"/></td>
		<td width="60%" class="td-stt-pml"><liferay-ui:message key="name" /></td>
		<td width="34%" class="td-stt-pml"><liferay-ui:message key="receipt.position" /></td>
	</tr>
<tbody class="ma-phat-sinh-code">
	<logic:iterate id="pmlUser" name="userList" indexId="i" type="com.sgs.portlet.pmluser.model.PmlUser" scope="request" >
	<%
		boolean flag = false;
		if (listUser != null) {
			for (int j = 0; j < listUser.length; j++) {
				if (pmlUser.getUserId() == Long.parseLong(listUser[j])) {
					flag = true;
				}
			}
		}
		
		String userName = "";
		User userLiferay = null;
		try {
			userLiferay = UserUtil.findByPrimaryKey(pmlUser.getUserId());
		} catch (Exception e) {
			userLiferay = null;	
		}
		
		if (userLiferay != null) {
			userName = userLiferay.getLastName() + " " + userLiferay.getMiddleName() + " " + userLiferay.getFirstName();
		}
		
		String positionName = "";
		Position position = null;
		try {
			position = PositionUtil.findByPrimaryKey(pmlUser.getPositionId());
		} catch (Exception e) {
			position = null;	
		}
		if (position != null) {
			positionName = position.getPositionName();
		}
		
	%>
	
	
	
	<tr style="height: 25px" class="${((i % 2)!=0)? 'rowTwoT2':'rowOneT1'}" >
		<td class="td-stt-pml" style="background-color: #DBEAFC;" id="<%=i %>">
			<input type="checkbox" <%=flag == true ? "checked" : "" %> name="listUser" id="listUser<%=i %>" value="<%=pmlUser.getUserId() %>" onclick="clickRadio(event)" />
		</td>
		<td class="td-stt-pml" style="background-color: #DBEAFC;"><%=i + 1 %></td>
		<td class="td-stt-pml" ><div align="left"><%= userName %></div></td>
		<td class="td-stt-pml" ><div align="left"><%= positionName %></div></td>
	</tr>
	</logic:iterate>
	</tbody>
	</table>
	
</fieldset>
	
<fieldset style="width: 99%">
<legend style="color: gray;" class="legend-noborder"><liferay-ui:message key="cauhinhchuyen-ldb"/></legend>
	
<table>
<tr style="height: 28px;"  class="one-gate-no-border-title">
		<td width="2%" class="td-stt-pml">##</td>
		<td width="4%" class="td-stt-pml"><liferay-ui:message key="pccc-TN-stt"/></td>
		<td width="60%" class="td-stt-pml"><liferay-ui:message key="name" /></td>
		<td width="34%" class="td-stt-pml"><liferay-ui:message key="receipt.position" /></td>
	</tr>
<tbody class="ma-phat-sinh-code">
	<logic:iterate id="pmlUser" name="userList" indexId="i" type="com.sgs.portlet.pmluser.model.PmlUser" scope="request" >
	<%
		boolean flag = false;
		if (listUserLDB != null) {
			for (int j = 0; j < listUserLDB.length; j++) {
				if (pmlUser.getUserId() == Long.parseLong(listUserLDB[j])) {
					flag = true;
				}
			}
		}
		
		String userName = "";
		User userLiferay = null;
		try {
			userLiferay = UserUtil.findByPrimaryKey(pmlUser.getUserId());
		} catch (Exception e) {
			userLiferay = null;	
		}
		
		if (userLiferay != null) {
			userName = userLiferay.getLastName() + " " + userLiferay.getMiddleName() + " " + userLiferay.getFirstName();
		}
		
		String positionName = "";
		Position position = null;
		try {
			position = PositionUtil.findByPrimaryKey(pmlUser.getPositionId());
		} catch (Exception e) {
			position = null;	
		}
		if (position != null) {
			positionName = position.getPositionName();
		}
		
	%>
	
	
	
	<tr style="height: 25px" class="${((i % 2)!=0)? 'rowTwoT2':'rowOneT1'}" >
		<td class="td-stt-pml" style="background-color: #DBEAFC;" id="<%=i %>">
			<input type="checkbox" <%=flag == true ? "checked" : "" %> name="listUserLDB" id="listUserLDB<%=i %>" value="<%=pmlUser.getUserId() %>" onclick="clickRadio(event)" />
		</td>
		<td class="td-stt-pml" style="background-color: #DBEAFC;"><%=i + 1 %></td>
		<td class="td-stt-pml" ><div align="left"><%= userName %></div></td>
		<td class="td-stt-pml" ><div align="left"><%= positionName %></div></td>
	</tr>
	</logic:iterate>
	</tbody>
	</table>	
</fieldset>	
<table>
<tr>
	<td>
		<div style="padding-left: 5px">
			<input type="submit" value='<liferay-ui:message key="save" />'/>
			<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'/>
		</div>
	</td>
</tr>
</table>

</form>
