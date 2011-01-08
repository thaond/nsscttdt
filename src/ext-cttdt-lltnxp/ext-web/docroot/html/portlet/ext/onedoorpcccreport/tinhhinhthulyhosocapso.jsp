<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>

<portlet:renderURL var="back">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/view" />
</portlet:renderURL>
<jsp:useBean id="tinhHinhThuLyHoSoCapSoList" type="java.util.List" scope="request" />
<div style="width:100%;text-align:center;background-color: #F2F2E6"">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td align="right"><a href="<%= back %>">&laquo;back</a><br /><br /></td></tr>
<tr align="left">
	<td class="report-bg-header-footer">&nbsp;
		
	</td>
</tr>
<tr><td class="blank-height-20"></td></tr>
<tr>
	<td>
		<font class="report-title"><liferay-ui:message key="onedoorpcccreport-tieudetinhhinhthulyhosocapso" /> <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></font><br /><br />
	</td>
</tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="report-table-list">
		<tr>
			<td rowspan="3"><b><liferay-ui:message key="onedoorpcccreport-phongban" /></b></td>
			<td colspan="4"><b><liferay-ui:message key="onedoorpcccreport-hosocanxuly" /></b></td>
			<td rowspan="3" width="5%"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
			<td colspan="3"><b><liferay-ui:message key="onedoorpcccreport-hosotondong" /></b></td>
		</tr>
		<tr>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tontruoc" /></b></td>
			<td colspan="2"><b><liferay-ui:message key="onedoorpcccreport-moichuyenden" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tronghaniso" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-quahaniso" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
		</tr>
		<tr>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-danhan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-chuanhan" /></b></td>
		</tr>
		<tr>
			<td>(1)</td>
			<td>(2)</td>
			<td>(3)</td>
			<td>(4)</td>
			<td>(5)</td>
			<td>(6)</td>
			<td>(7)</td>
			<td>(8)</td>
			<td>(9)</td>
		</tr>
		<logic:iterate id="tinhHinhThuLyHoSoCapSoDTO" name="tinhHinhThuLyHoSoCapSoList"
		type="com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapSoDTO" indexId="i">
		<tr>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_phongBan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="phongban" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_tonTruoc">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="tontruoc" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_daNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="danhan" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_chuaNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="chuanhan" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_tongHoSoCanXuLy">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="tonghosocanxuly" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_hoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="hosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_trongHanISO">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="tronghaniso" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_quaHanISO">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="quahaniso" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapSoDetail_tongHoSoTonDong">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapsodetail" />
				<portlet:param name="id" value="<%=tinhHinhThuLyHoSoCapSoDTO.getId() %>" />
				<portlet:param name="action" value="tonghosotondong" />
			</portlet:renderURL>
			<td align="left">
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.isHasFile() == true) {
			%>	
				<a href="<%=tinhHinhThuLyHoSoCapSoDetail_phongBan %>"><%= tinhHinhThuLyHoSoCapSoDTO.getPhongBan() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getPhongBan() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getTonTruoc() > 0) {
			%>
			<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_tonTruoc %>"><%= tinhHinhThuLyHoSoCapSoDTO.getTonTruoc() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getTonTruoc() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getDaNhan() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_daNhan %>"><%= tinhHinhThuLyHoSoCapSoDTO.getDaNhan() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getDaNhan() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getChuaNhan() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_chuaNhan %>"><%= tinhHinhThuLyHoSoCapSoDTO.getChuaNhan() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getChuaNhan() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_tongHoSoCanXuLy %>"><%= tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_hoSoGiaiQuyet %>"><%= tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_trongHanISO %>"><%= tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_quaHanISO %>"><%= tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapSoDetail_tongHoSoTonDong %>"><%= tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong() %>
			<%
				}
			%>
			</td>
		</tr>
		</logic:iterate>
		</table>
	</td>
</tr>
<tr>
	<td align="left">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" style="border:1px solid #cccccc;border-top:0">
		<tr>
			<td style="padding-left:3px;">
				<br />H&#432;&#7899;ng d&#7851;n<br />
				(1) = T&ecirc;n ph&ograve;ng ban.<br />
				(2) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; &#273;ang &#7903; t&#7841;i chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng x&#7917; l&yacute; v&agrave; ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; t&iacute;nh &#273;&#7871;n ng&agrave;y th&#7889;ng k&ecirc;.<br />
				(3) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do Ph&ograve;ng kh&aacute;c chuy&#7875;n &#273;&#7871;n cho chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng v&agrave; chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng &#273;&atilde; nh&#7853;n.<br />
				(4) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do Ph&ograve;ng kh&aacute;c chuy&#7875;n &#273;&#7871;n cho chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng v&agrave; chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng ch&#432;a nh&#7853;n.<br />
				(5) = (2) + (3) + (4)<br />
				(6) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng chuy&#7875;n qua Ph&ograve;ng kh&aacute;c trong ng&agrave;y th&#7889;ng k&ecirc;.<br />
				(7) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; c&ograve;n trong Ph&ograve;ng, ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; v&agrave; trong th&#7901;i h&#7841;n theo ISO.<br />
				(8) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; c&ograve;n trong Ph&ograve;ng, ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; v&agrave; v&#432;&#7907;t qu&aacute; th&#7901;i h&#7841;n theo ISO.<br />
				(9) = (7) + (8) ho&#7863;c (5) - (6)<br /><br />
				<font style="font-style:italic">T&iacute;nh &#273;&#7871;n tr&#7841;ng th&aacute;i x&#7917; l&yacute; m&#7899;i nh&#7845;t c&#7911;a t&#7915;ng b&#7897; h&#7891; s&#417; t&#7841;i Ph&ograve;ng ban.</font>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr><td class="blank-height-40"></td></tr>
<tr align="right">
	<td class="report-bg-header-footer">
		<portlet:actionURL var="xuatFileTinhHinhThuLyHoSoCapSo">
			<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapso" />
		</portlet:actionURL>
		<form action="<%= xuatFileTinhHinhThuLyHoSoCapSo %>" method="post">
			<input type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' />
		</form>
	</td>
</tr>
</table>
</div>
