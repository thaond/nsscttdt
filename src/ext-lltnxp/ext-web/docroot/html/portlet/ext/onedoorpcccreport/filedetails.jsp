<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>

<%@page import="java.text.SimpleDateFormat"%><link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<br />
<jsp:useBean id="pmlFilePcccList" type="java.util.List" scope="request" />
<div style="text-align: center; font-weight: bold;"><liferay-ui:message key="onedoorpcccreport-chitiethoso"/></div><br />
<table cellpadding="0" cellspacing="0" border="1" width="100%" class="pos">
<tr class="table-header" bgcolor="#dbeafc" style="height: 30px;">
    <td style="width:4%"><div align="center"><liferay-ui:message key="pccc-TN-stt"/></div></td>
    <td style="width:8%"><div align="center"><liferay-ui:message key="pccc-DSHS-mahoso"/></div></td>
    <td><div align="center"><liferay-ui:message key="pccc-TN-tenhoso"/></div></td>
    <td><div align="center"><liferay-ui:message key="pccc-TN-loaihoso"/></div></td>
    <td><div align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></div></td>
    <td><div align="center"><liferay-ui:message key="pccc-DSHS-ngayhentra"/></div></td>
</tr>
<logic:iterate id="pmlFilePcccDTO" name="pmlFilePcccList"
type="com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO" indexId="i">
<tr>
	<td style="text-align: center;"><%= (i + 1) %></td>
	<td><%= pmlFilePcccDTO.getFileId() %></td>
	<td><%= pmlFilePcccDTO.getFileName() %></td>
	<td><%= pmlFilePcccDTO.getFiletype() %></td>
	<td style="text-align: center;"><%= (pmlFilePcccDTO.getApplicationDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getApplicationDate())) : "" %></td>
	<td style="text-align: center;"><%= (pmlFilePcccDTO.getExpectedReturingDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getExpectedReturingDate())) : ""%></td>
</tr>
</logic:iterate>
</table>