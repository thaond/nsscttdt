<%@ include file="/html/portlet/ext/pml_template/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pml_template/js/pmltemplate-js.jsp"></liferay-util:include>
<%@page import="java.io.File"%>
<%@page import="com.sgs.portlet.pml_template.model.FileTemplate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.pml_template.model.PmlTemplate"%>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript">
window.onload = function () {
	if (document.getElementById('<portlet:namespace/>ngayBanHanh') != null) {
		callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-ngayBanHanh');
	}
}
</script>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	PmlTemplate pmlTemplate = (PmlTemplate)renderRequest.getAttribute("pmlTemplate");
	List<FileTemplate> fileTemplateList = renderRequest.getAttribute("fileTemplateList") == null ? new ArrayList<FileTemplate>()
				: (List<FileTemplate>)renderRequest.getAttribute("fileTemplateList");
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pml_template/view"/>
	<portlet:param name="redirect" value="<%=redirect %>"/>
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>"/>
</portlet:actionURL>

<form action="<%= update %>" method="post" enctype="multipart/form-data" onsubmit="return validateForm();" >
	<input type="hidden" name="templateId" value="<%= String.valueOf(pmlTemplate.getTemplateId()) %>">
		<div class="title_categ"><liferay-ui:message key="cap-nhat-bieu-mau"/></div>
		<div class="boxcontent">
			<table cellspacing="0" width="100%">
				<tr>
					<td width="18%" ><label><liferay-ui:message key='ma-bieu-mau'/> <font color="#FF0000">(*)</font>&nbsp;:</label></td>
					<td >
						<input type="text" id="code" name="<portlet:namespace/>templateCode" style="width:98%" value="<%= pmlTemplate.getTemplateCode() %>"/>	
					</td>
				</tr>
				<tr>
					<td><label><liferay-ui:message key='ten-bieu-mau'/> <font color="#FF0000">(*)</font> &nbsp;: </label></td>
					<td>
						<input id="name"  name="<portlet:namespace />templateName" type="text" style="width:98%" value="<%= pmlTemplate.getTemplateName() %>">					
					</td>
				</tr>
				<tr>
					<td><label><liferay-ui:message key='so-van-ban'/> <font color="#FF0000">(*)</font> &nbsp;:</label></td>
					<td>
						<input id="number"  name="<portlet:namespace />soVanBan" type="text" style="width:98%" value="<%= pmlTemplate.getNumberOfDocument() %>">					
					</td>
				</tr>
				<tr>
					<td><label><liferay-ui:message key='ngay-ban-hanh'/> <font color="#FF0000">(*)</font> &nbsp;: </label></td>
					<td>
						<input type="text" name="<portlet:namespace/>ngayBanHanh" id="<portlet:namespace/>ngayBanHanh" value="<%= df.format(pmlTemplate.getPublishDate()) %>" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-ngayBanHanh" onClick="callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-ngayBanHanh')" />
						&nbsp; (dd/mm/yyyy)
					</td>
				</tr>
				<tr>
					<td><label><liferay-ui:message key='phong-ban-hanh'/> <font color="#FF0000">(*)</font>&nbsp;:</label></td>
					<td>
						<select style="width: 98.8%" id="department" name="<portlet:namespace />departmentId">
							<option value="">[<liferay-ui:message key='chonphongban'/>]</option>
							<logic:iterate id="department" name="departmentList" indexId="i" type="com.sgs.portlet.department.model.Department" scope="request" >
								<option value="<%=department.getDepartmentsId() %>" <%= pmlTemplate.getDepartmentId().equals(department.getDepartmentsId()) ? "selected" : "" %>><%=department.getDepartmentsName() %></option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				
				<% if (fileTemplateList.size() > 0) { %>
				<tr>
					<td>
						<label><liferay-ui:message key="tap-tin-dinh-kem" />&nbsp;:</label>
					</td>
					<td>
						<%
							FileTemplate fileTemplate = fileTemplateList.get(0);
							
							String download = fileTemplate.getTenFile();
							String fileDinhKemPath = ""; 
							fileDinhKemPath = fileTemplate.getDuongDan();
							String patthFile = getServletContext().getRealPath("")+ fileDinhKemPath;
							File filedownload = new File(patthFile);
							if (filedownload.exists()) {
								download = "<a href='" + fileDinhKemPath+ "'>" + fileTemplate.getTenFile() + "</a>";
							} 
						%>
						<a><label><%= download %></label></a>
					</td>
				</tr>
				<% } %>
				<tr>
					<td>
						<label><liferay-ui:message key="chon-tap-tin-dinh-kem" />&nbsp;:</label>
					</td>
					<td>
						<input type="file" name="<portlet:namespace />file" id="file" onchange="getFileName(this.value)" /></td>
						<input type="hidden" name="<portlet:namespace />fileName" id="fileName"> 
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type='submit'  name='button' value='<liferay-ui:message key="update"/>' />
						<input type="reset" value='<liferay-ui:message key="reset"/>'>
						<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' ></span>
					</td>
				</tr>
			</table>
</div>
</form>