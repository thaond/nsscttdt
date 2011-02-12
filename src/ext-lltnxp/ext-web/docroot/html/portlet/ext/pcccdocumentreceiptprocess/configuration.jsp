<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/quanlycongvan.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />


<%
boolean documentRecordTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentRecordTypeCode",false);
boolean documentTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentTypeCode",false);
String textAdd = PrefsParamUtil.getString(prefs, request, "textAdd","");
textAdd = textAdd.trim();

boolean departmentCode = PrefsParamUtil.getBoolean(prefs, request, "departmentCode",false);
boolean useYear = PrefsParamUtil.getBoolean(prefs, request, "useYear",false);
%>

<liferay-portlet:actionURL var="form" portletConfiguration="true">
</liferay-portlet:actionURL>
<form action="<%=form %>" method="post">


<table style="width: 100%; margin-top: 10px; margin-bottom: 5px">
    <tr>
	<td nowrap="nowrap" width="20%">
		<div style="padding-left: 3px;"><liferay-ui:message key="phan-mo-rong" />: <div>
	</td>
	<td align="left">
	        <input name="<portlet:namespace/>textAdd" type="text" value="<%=  HtmlUtil.escape(textAdd)%>"  />
	</td>
    </tr>
		
    <tr>
	<td nowrap="nowrap" width="20%">
		<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-so-van-ban" />: <div>
	</td>
	<td align="left">
		<input name="<portlet:namespace/>documentRecordTypeCode" type="checkbox"  <%=  documentRecordTypeCode == true ? "checked": ""  %>  />
	</td>
    </tr>
		
    <tr>
	<td nowrap="nowrap" width="20%">
		<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-loai-van-ban" />: <div>
	</td>
	<td align="left">
		<input name="<portlet:namespace/>documentTypeCode" type="checkbox"   <%=  documentTypeCode == true ? "checked": ""  %>  />
	</td>
   </tr>
		
	<tr>
		<td nowrap="nowrap" width="20%">
			 <div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-phong-ban" />: <div>
		</td>
		<td align="left">
			 <input name="<portlet:namespace/>departmentCode" type="checkbox"   <%=  departmentCode == true ? "checked": ""  %>  />
		</td>
	</tr>
		
	<tr>
		<td nowrap="nowrap" width="20%">
			 <div style="padding-left: 3px;"><liferay-ui:message key="su-dung-nam-hien-tai" />: <div>
		</td>
		<td align="left">
			 <input name="<portlet:namespace/>useYear" type="checkbox"   <%=  useYear == true ? "checked": ""  %>  />
		</td>
	</tr>	
</table>

<table cellspacing="0" width="100%">
<tr>
	<td width="20%">
	 	<liferay-ui:message key="document_days_process" />:
	</td>
			
	<td >
	 	<input name="processDateNumber" type="text" size="5" value="<%=processDateNumberNew %>" onKeyup="isInteger(this.value)" />
	</td>
</tr>
<tr>
	<td><liferay-ui:message key="cauhinhchuyen-ldvp"/>:</td>
	<td>
	<div class="Scrollbarauto" style="border-bottom: 1px solid #8AD1FE">
		<table cellspacing="0" width="100%" class="taglib-search-iterator table-pml">
			<tr class="portlet-section-header results-header">
					<td width="35px" align="center">##</td>
					<td width="45px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
					<td width="60%"><liferay-ui:message key="name" /></td>
					<td ><liferay-ui:message key="receipt.position" /></td>
				</tr>
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
	
	
	
				<tr class="${((i % 2)!=0)? 'results-row':'tr_two results-row'}" >
					<td align="center" id="<%=i %>">
			<input type="checkbox" <%=flag == true ? "checked" : "" %> name="listUser" id="listUser<%=i %>" value="<%=pmlUser.getUserId() %>" onclick="clickRadio(event)" />
		</td>
					<td align="center"><%=i + 1 %></td>
					<td ><%= userName %></td>
					<td ><%= positionName %></td>
	</tr>
	</logic:iterate>
				</table>
			</div>
	</td>
</tr>
<tr><td colspan="2"></td></tr>
<tr>
	<td><liferay-ui:message key="cauhinhchuyen-ldb"/>:</td>
	<td>
		<div class="Scrollbarauto"  style="border-bottom: 1px solid #8AD1FE">
		<table cellspacing="0" width="100%" class="taglib-search-iterator table-pml">
			<tr class="portlet-section-header results-header">
					<td width="35px" align="center">##</td>
					<td width="45px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
					<td width="60%"><liferay-ui:message key="name" /></td>
					<td ><liferay-ui:message key="receipt.position" /></td>
				</tr>
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
	
	
	
				<tr class="${((i % 2)!=0)? 'results-row':'tr_two results-row'}" >
					<td align="center" id="<%=i %>">
			<input type="checkbox" <%=flag == true ? "checked" : "" %> name="listUserLDB" id="listUserLDB<%=i %>" value="<%=pmlUser.getUserId() %>" onclick="clickRadio(event)" />
		</td>
					<td align="center"><%=i + 1 %></td>
					<td ><%= userName %></td>
					<td ><%= positionName %></td>
	</tr>
	</logic:iterate>
				</table>
		</div>
	</td>
</tr>
<tr>
	<td></td>
	<td>
			<input type="submit" value='<liferay-ui:message key="save" />'/>
			<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'/>
	</td>
</tr>
</table>

</form>
