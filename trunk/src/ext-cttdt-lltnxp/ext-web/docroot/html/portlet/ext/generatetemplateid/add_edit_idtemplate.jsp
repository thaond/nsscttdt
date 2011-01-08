<%@ include file="/html/portlet/ext/generatetemplateid/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.generatetemplateid.model.IdTemplate"%>
<%@page import="com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil"%>
<%@page import="com.sgs.portlet.generatetemplateid.util.IdTemplateConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<liferay-util:include page="/html/portlet/ext/generatetemplateid/js/validateIdTemplate.jsp"></liferay-util:include>
<script type="text/javascript">
function checkNumber() {
	var startNumberValue = document.getElementById("startNumber").value;
	if (isNaN(startNumberValue) == true) {
		alert("<liferay-ui:message key='chi-nhap-con-so'/>");
		year.focus();
		return false;
	} else {
		return true;
	}
}

</script>
<%
	String id = (String)renderRequest.getParameter("templateId") == null ? "" : (String)renderRequest.getParameter("templateId");
	IdTemplate idTemplate = null;
	long templateId = 0;
	if(!"".equals(id)){
		templateId = Long.parseLong(id);
		idTemplate = IdTemplateLocalServiceUtil.getIdTemplate(templateId);
	}
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/generatetemplateid/view"/>
	<portlet:param name="templateId" value="<%=String.valueOf(templateId) %>"/>
</portlet:actionURL>
<form method="post" action="<%=update %>" name="<portlet:namespace />frm" onsubmit="return validateFormIdtemplate()" >
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<div class="boxcontent">
	<input type="hidden" name="checkContainText" id="checkContainText" value="">
	<table cellspacing="0" width="100%">
		<%
			if(idTemplate != null){
		%>
		<tr>
			<td width="10%"><liferay-ui:message key="format." /><div id="format" style="color: red; display: none;" >(*)</div>:</td>
			<td>
				<input type="text" name="format" id="textTemplate" style="width: 30%" readonly="readonly" value="<%=idTemplate.getFormat() %>">
				
				<select size="1" name="optTemplate" id="optTemplate" onchange="changeValue(this)">
					<option value="<%=IdTemplateConstants.NUMBER %>"><%= IdTemplateConstants.NUMBER %></option>
					<option value="<%=IdTemplateConstants.YY %>"> <%= IdTemplateConstants.YY %></option>
					<option value="[Text]">Text</option>
				</select>
				<input type="button" value='<liferay-ui:message key="add"/>' name="butName" onclick="butAdd()">
				<input type="button" value="Clear" name="Clear" onclick="butClear()">
				<input type="text" name="textValue" id="textValue" size="20" style="display:none" onkeypress="return checkChar(event)">
			</td>
		</tr>
		<tr >
			<td><liferay-ui:message key="startnumber." />:</td>
			<td><input type="text" style="width: 95%" name="startNumber" id="startNumber" size="20" value="<%=idTemplate.getStartNumber() %>" onblur="checkNumber()"/></td>
		</tr>
		<tr valign="top">
			<td><liferay-ui:message key="description." /><div id="des" style=" display: none;" >(*)</div>:</td>
			<td><textarea style="width: 95%;height: 80px"  name="description" id="description"><%=idTemplate.getDescription()%></textarea></td>
		</tr>
		<tr>
			<td></td>
					<td>
						<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		    			<input style="margin-left: 0;" type="submit" name="button" id="button" value="<liferay-ui:message key="update" />" />
						<input  type="reset" value='<liferay-ui:message key="reset" />'/>
						<input onclick="window.history.back()"  type="button"	value='<liferay-ui:message key="back"/>' />
				 	</td>
				</tr>
		</table>
		<%
			} else {
		%>
			<table cellspacing="0" width="100%">
			<tr>
				<td width="10%"><liferay-ui:message key="format." /><div id="format" style="color: red; display: none;" >(*)</div>:</td>
				<td>
					<input type="text" name="format" id="textTemplate" style="width: 30%"  readonly="readonly">
					
					<select size="1" name="optTemplate" id="optTemplate" onchange="changeValue(this)">
						<option value="<%=IdTemplateConstants.NUMBER %>"><%=IdTemplateConstants.NUMBER %></option>
						<option value="<%=IdTemplateConstants.YY %>"><%=IdTemplateConstants.YY %></option>
						<option value="[Text]">Text</option>
					</select>
					<input type="button" value='<liferay-ui:message key="add"/>' name="butName" onclick="butAdd()">
					<input type="button" value="Clear" name="Clear" onclick="butClear()">
					<input type="text" name="textValue" id="textValue" size="20" style="display:none" onkeypress="return checkChar(event)">
				</td>
			</tr>
			
			<tr >
				<td ><liferay-ui:message key="startnumber." /><div id="startnumber" style="color: red; display: none;" >(*)</div>:</td>
				<td><input type="text" style="width: 95%" name="startNumber" id="startNumber" onblur="checkNumber()" size="20"/></td>
			</tr>
			<tr valign="top">
				<td ><liferay-ui:message key="description." /><div  id="des" style="color: red; display: none;" >(*)</div>:</td>
				<td><textarea style="width: 95%; height: 80px" name="description" id="description"></textarea></td>
			</tr>
			<tr>
				<td></td>
						<td >
							<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
							<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="add_new" />' />
							<input  type="reset" value='<liferay-ui:message key="reset" />'/>
							<input onclick="window.history.back()"  type="button"	value='<liferay-ui:message key="back"/>' />
						 </td>
					</tr>
				</tbody>
			</table>
		<%} %>
	</div> 
	</form>
