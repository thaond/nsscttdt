<%@ include file="/html/portlet/nss/geneatedocumentcode/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.generatetemplateid.model.IdGenerated"%>
<%@page import="com.nss.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil"%>
<%@page import="com.nss.portlet.generatetemplateid.model.IdTemplate"%>
<%@page import="com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil"%>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%><script type="text/javascript">

function checkYearLength() {
	var idtemplate = document.getElementById("format");
	var year = document.getElementById("year");
	var currentNumber = document.getElementById("currentNumber");
	var yeartrim = year.value.trim() ;
	var currentNumberTrim = currentNumber.value.trim() ;
	
	if (yeartrim == ""){
		alert("<liferay-ui:message key='nhap-nam'/>")
		year.focus();
		return false;		
	}
	
	if (isNaN(year.value) == true || yeartrim.length < 2) {
		alert("<liferay-ui:message key='chi-nhap-2-con-so'/>");
		year.focus();
		return false;
	} 

	if( currentNumberTrim == ""){
		alert("<liferay-ui:message key='nhap-so'/>");
		currentNumber.focus();
		return false;
	}
	
	if (isNaN(currentNumber.value) == true ){
		alert("<liferay-ui:message key='chi-nhap-con-so'/>");
		currentNumber.focus();
		return false;
	}

	if (document.getElementById("addFlag") != null) {
		if (idtemplate.selectedIndex == 0) {
			alert("<liferay-ui:message key='vui-long-chon-mau'/>");
			idtemplate.focus();
			return false;
		}
	}
	else {
		return true;
	}
}

</script>
<%
	long generateId = ParamUtil.getLong(renderRequest, "generateId", 0);

	IdGenerated generated = null;
	IdTemplate template = null;
	if (generateId != 0) {
		generated = IdGeneratedLocalServiceUtil.getIdGenerated(generateId);
		template = IdTemplateLocalServiceUtil.getIdTemplate(generateId);
	}
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/nss/geneatedocumentcode/view"/>
	<portlet:param name="generateId" value="<%= String.valueOf(generateId) %>"/>
</portlet:actionURL>

<form action="<%=update %>" method="post"  name="<portlet:namespace/>fm" onsubmit="return checkYearLength()">
<div class="commom-form">
	<%
		if (null != generated) {
			
	%>
<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"><liferay-ui:message key="dinh-dang" /> <font color="red">(*)</font> :</td>
			<td><input style="width: 98%" type="text" readonly="readonly" name="format" value="<%= template.getFormat()%>"/></td>
		</tr>
		
	
		<tr>
			<td ><liferay-ui:message key="year" /> <font color="red">(*)</font> :</td>
			<td ><input style="width: 98%" type="text" maxlength="2" id="year" name="year" value="<%= generated.getYear() %>"/></td>
		</tr>
		
		
		<tr>
			<td ><liferay-ui:message key="number" /> <font color="red">(*)</font> :</td>
			<td><input style="width: 98%" type="text" id="currentNumber" name="currentNumber" value="<%= String.valueOf(generated.getCurValue()) %>"/></td>
		</tr>
		
		<tr>
			<td></td>
					<td>
						<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" id="updateFlag" value="<%= Constants.UPDATE %>" />
		    			<input style="margin-left: 0" type="submit" name="button" id="button" value="<liferay-ui:message key="update" />"  />
						<input  type="reset" value='<liferay-ui:message key="reset" />'/>
						<input onclick="window.history.back()"  type="button"	value='<liferay-ui:message key="back"/>' />
				 	</td>
				</tr>
		</table>

<% } else { %>

<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
		<table cellspacing="0" width="100%">
			<tr>
				<td width="15%" ><liferay-ui:message key="year" /> <font color="red">(*)</font> :</td>
				<td ><input style="width: 98%"  type="text" id="year" name="year" maxlength="2"/></td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="number" /> <font color="red">(*)</font> :</td>
				<td><input style="width: 98%" type="text" id="currentNumber" name="currentNumber"/></td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="dinh-dang" /> <font color="red">(*)</font> :</td>
				<td>
					<select style="width: 98%" id="format" name="format">
						<option value=""><liferay-ui:message key="chon"/></option>
						<logic:iterate id="idTemplate" name="idTemplateResults" indexId="i" type="com.nss.portlet.generatetemplateid.model.IdTemplate" scope="request" >
							<option value="<%=idTemplate.getTemplateId() %>"><%=idTemplate.getFormat() %></option>
						</logic:iterate>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
						<td>
							<input name="<portlet:namespace /><%= Constants.CMD %>" id="addFlag" type="hidden" value="<%= Constants.ADD %>" />
			    			<input style="margin-left: 0" type="submit" name="button" id="button" value="<liferay-ui:message key="luu" />" />
							<input  type="reset" value='<liferay-ui:message key="reset" />'/>
							<input onclick="window.history.back()"  type="button"	value='<liferay-ui:message key="back"/>' />
					 	</td>
					</tr>
			</table>
			<% } %>
			
	</div>
</form>