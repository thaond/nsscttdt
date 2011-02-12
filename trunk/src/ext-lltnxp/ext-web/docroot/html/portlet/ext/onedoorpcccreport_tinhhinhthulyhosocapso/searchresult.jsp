<%@ include file="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil"%>
<%@page import="com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO"%>


<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<liferay-util:include page="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/js/onedoorpcccreport_tinhhinhthulyhosocapso-js.jsp"></liferay-util:include>
<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/css/style.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/css/ex.css" />

<br />

<script type="text/javascript">
function <portlet:namespace/>viewDetail(detailURL) 
{
	jQuery('#dropper').show();
	jQuery('#<portlet:namespace/>buttontask').show();
	jQuery('#<portlet:namespace/>divcontent2').load(detailURL);
	jQuery('#<portlet:namespace/>divcontent2').show();
	jQuery('#div-empty').hide();
}
</script>

<jsp:useBean id="receiveFilesDTO" type="java.util.List" scope="request" />

<style type="text/css">

div#tipDiv 
{
	padding: 4px;
	color: #000;
	font-size: 11px;
	line-height: 1.2;
	background-color: #E1E5F1;
	border: 1px solid #667295;
	width: auto;
}
</style>

<%
	String fromDate = (String) renderRequest.getAttribute("fromDate");
	String toDate = (String) renderRequest.getAttribute("toDate");
	String fileTypeId = (String) renderRequest.getAttribute("fileTypeId");
	String type = (String) renderRequest.getAttribute("type");
	String valueType = (String) renderRequest.getAttribute("valueType");
	
%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action"	value="/sgs/onedoorpcccreport_tinhhinhthulyhosocapso/filedetails" />
	<portlet:param name="fromDate"	value="<%= fromDate %>" />
	<portlet:param name="toDate"	value="<%= toDate %>" />
	<portlet:param name="fileTypeId"	value="<%= fileTypeId %>" />
</portlet:actionURL>

<div class="HS-height">

<div id="listdivpccc">
<div id="listdiv" style="border: 1px solid #7a7a7a; border-bottom: 0px">
<table>
<tr bgcolor="#dbeafc">
	<td width="85%">
		<form id="filter" action="<%=filter %>" method="post">
			<table width="100%" bgcolor="#dbeafc">
			<tr>
				<td width="15%">
					<select	onchange="checkonchangBR33();" name="<portlet:namespace/>type" id="select" style="width: 100%">
						<option value=""><liferay-ui:message key="all" /></option>
						<option <%=("mahoso".equals(type) ? "selected" : "" )%>	value="mahoso"><liferay-ui:message key="pccc-DSHS-mahoso" /></option>
						<option <%=("tenhoso".equals(type) ? "selected" : "" )%> value="tenhoso"><liferay-ui:message key="pccc-TN-tenhoso" /></option>
					</select>
				</td>
				<td>
					<input onkeypress="enableButton();" height="24" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" style="width: 99%" value="<%=valueType %>" />
				</td>
				<td width="7%" align="left">
					<input width="100%" height="24"	type="submit" id="<portlet:namespace/>loc" value='<liferay-ui:message key="pccc-DSHS-loc"/>'/>
				</td>
			</tr>
			</table>
		</form>
	</td>
	<td>
		<div align="left"><liferay-util:include page="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapso/button.jsp"></liferay-util:include></div>
	</td>
</tr>
</table>
</div>
<div class="outer-1">
<div >

<table width="100%" border="1" class="pos">
<tr class="table-header" bgcolor="#dbeafc" align="center" >
    <td class="td-stt-pml">
		<div align="center">TT</div>
	</td>
    <td style="width: 8%" class="td-stt-pml">
		<div align="center"><liferay-ui:message key="pccc-DSHS-mahoso" /></div>
	</td>
    <td class="td-stt-pml">
		<div align="center"><liferay-ui:message key="pccc-TN-tenhoso" /></div>
	</td>
	<td class="td-stt-pml">
		<div align="center"><liferay-ui:message key="pccc-TN-loaihoso" /></div>
	</td>
    <td>
    	<div align="center"><liferay-ui:message key="pccc-TN-trangthaihoso"/></div>
    </td>
    <td>
    	<div align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></div>
    </td>
    <td><div align="center"><liferay-ui:message key="pccc-DSHS-ngayhentra"/></div></td>
</tr>
<logic:iterate id="pmlFilePcccDTO" name="receiveFilesDTO"
type="com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO" indexId="i">
<%
	String style = "";
	if (i%2 == 0) {
		style = "row3";
	} else if (i%2 != 0) {
		style = "row4";
	}
%>
<tr onMouseOut="nofocusColor(this)" onMouseOver="focusColor2(this)"	class="<%= style %>">
	<td style="color: #131313; background-color: #dbeafc" nowrap="nowrap" class="td-stt-pml">
		<div align="center"><%=i+1%>.&nbsp; 
		<%
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	Date date = new Date ();
	    	String cdate = dateFormat.format(date);
	    	Date d1 = dateFormat.parse(cdate);
	    	Date d2 = dateFormat.parse(dateFormat.format(pmlFilePcccDTO.getExpireDate()));
	    	if (d1.equals(d2)){
	    		System.out.println(pmlFilePcccDTO.getExpireDate());
		%> 
		<img src="/html/images/pink.gif"></div>
	</td>
		<%
			}
			if(d1.after(d2)){
		%>
		<img src="/html/images/red.gif"></div>
	</td>
		<%
		   	}
			if(d1.before(d2)){
		%>
		<img src="/html/images/blue.gif"></div>
	</td>
		<%
			}
	    %>
<portlet:renderURL var="detail"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action"	value="/sgs/onedoorpcccreport_tinhhinhthulyhosocapso/filedetails_detail" />
	<portlet:param name="fileId" value="<%=pmlFilePcccDTO.getFileId() %>" />
	<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
</portlet:renderURL>
	<td class="td-stt-pml"><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail%>');"><u><%=pmlFilePcccDTO.getFileId() %></u></a></td>
	<td class="td-stt-pml"><%= pmlFilePcccDTO.getFileName() %></td>
	<td class="td-stt-pml"><%= pmlFilePcccDTO.getFiletype() %></td>
	<td class="td-stt-pml"><%= pmlFilePcccDTO.getStatus() %></td>
	<td class="td-stt-pml"><%= (pmlFilePcccDTO.getApplicationDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getApplicationDate())) : "" %></td>
	<td class="td-stt-pml"><%= (pmlFilePcccDTO.getExpectedReturingDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getExpectedReturingDate())) : ""%></td>
</tr>
</logic:iterate>
</table>
</div>
</div></div>
<div id="dropper" style="display: none;">
<table width="100%" bgcolor="#dbeafc" align="center">
	<tr>
		<td colspan="7" align="center" style="height: 4px">
		<div>
				<img onClick="displayAndHiddenReport()" style="cursor: pointer;"	src="/html/images/showfull.gif">
		</div>
		</td>
	</tr>
</table>
</div>
<div id="div-empty">
<table  border="1" >
<tr>
	<td id="empty-border"  class="empty-table"></td>
</tr>
</table>
<table class="bgdocsend-table-footer" style="width: 100%">
<tr>
	<td>
		<a onclick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
	</td>
</tr>
</table>
</div>
<!-- detail information document -->
<div id="<portlet:namespace/>divcontent2" class="outer-2"
	style="display: none;"></div>
<div id="<portlet:namespace/>buttontask" style="display: none"></div>
<script type="text/javascript">
window.onload = function () {
	checkonchangBR33();
}
</script>