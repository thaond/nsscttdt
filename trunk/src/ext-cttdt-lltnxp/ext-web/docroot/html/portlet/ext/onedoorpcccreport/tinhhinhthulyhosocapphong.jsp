<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>

<br />
<portlet:renderURL var="back">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/view" />
</portlet:renderURL>
<jsp:useBean id="tinhHinhThuLyHoSoCapPhongList" type="java.util.List" scope="request" />
<div style="width:100%;text-align:center">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td align="right"><a href="<%= back %>">&laquo;back</a><br /><br /></td></tr>
<tr align="left">
	<td class="report-bg-header-footer">
		&nbsp;
	</td>
</tr>
<tr><td class="blank-height-20"></td></tr>
<tr>
	<td>
		<font class="report-title"><liferay-ui:message key="onedoorpcccreport-tieudetinhhinhthulyhosocapphong" /> <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></font><br /><br />
	</td>
</tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="report-table-list">
		<tr>
			<td rowspan="3"><b><liferay-ui:message key="onedoorpcccreport-chuyenvien" /></b></td>
			<td colspan="4"><b><liferay-ui:message key="onedoorpcccreport-hosocanxuly" /></b></td>
			<td colspan="3"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
			<td colspan="3"><b><liferay-ui:message key="onedoorpcccreport-hosotondong" /></b></td>
		</tr>
		<tr>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tontruoc" /></b></td>
			<td colspan="2"><b><liferay-ui:message key="onedoorpcccreport-moichuyenden" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tugiaiquyet" /></b></td>
			<td rowspan="2" width="6%"><b><liferay-ui:message key="onedoorpcccreport-nguoikhacthulythay" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tronghaniso" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-quahaniso" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
		</tr>
		<tr>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-danhan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-chuanhan" /></b></td>
		</tr>
		
		<%
		int tonTruoc = 0;
		int daNhan = 0;
		int chuaNhan = 0;
		int tongHoSoCanXuLy = 0;
		int tuGiaiQuyet = 0;
		int nguoiKhacThuLyThay = 0;
		int tongHoSoGiaiQuyet = 0;
		int trongHanISO = 0;
		int quaHanISO = 0;
		int tongHoSoTonDong = 0;
		%>
		<logic:iterate id="tinhHinhThuLyHoSoCapPhongDTO" name="tinhHinhThuLyHoSoCapPhongList"
		type="com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapPhongDTO" indexId="i">
		
		<%
		tonTruoc += 0;
		daNhan += 0;
		chuaNhan += 0;
		tongHoSoCanXuLy += 0;
		tuGiaiQuyet += 0;
		nguoiKhacThuLyThay += 0;
		tongHoSoGiaiQuyet += 0;
		trongHanISO += 0;
		quaHanISO += 0;
		tongHoSoTonDong += 0;
		%>
		
		<tr>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_chuyenVien">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="chuyenvien" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_tonTruoc">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tontruoc" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_daNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="danhan" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_chuaNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="chuanhan" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_tongHoSoCanXuLy">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tonghosocanxuly" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_tuGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tugiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_nguoiKhacThuLyThay">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="nguoikhacthulythay" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_tongHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tonghosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_trongHanISO">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tronghaniso" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_quaHanISO">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="quahaniso" />
			</portlet:renderURL>
			<portlet:renderURL var="tinhHinhThuLyHoSoCapPhongDetail_tongHoSoTonDong">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphongdetail" />
				<portlet:param name="id" value='<%=tinhHinhThuLyHoSoCapPhongDTO.getId() + "" %>' />
				<portlet:param name="action" value="tonghosotondong" />
			</portlet:renderURL>
			<td align="left">
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.isHasFile() == true) {
			%>	
				<a href="<%=tinhHinhThuLyHoSoCapPhongDetail_chuyenVien %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getChuyenVien() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getChuyenVien() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_tonTruoc %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getDaNhan() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_daNhan %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getDaNhan() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getDaNhan() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_chuaNhan %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_tongHoSoCanXuLy %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_tuGiaiQuyet %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_nguoiKhacThuLyThay %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_tongHoSoGiaiQuyet %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_trongHanISO %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_quaHanISO %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO() %>
			<%
				}
			%>
			</td>
			<td>
			<%
				if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong() > 0) {
			%>
				<a style="text-decoration: underline;" href="<%=tinhHinhThuLyHoSoCapPhongDetail_tongHoSoTonDong %>"><%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong() %></a>
			<%
				} else {
			%>
				<%= tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong() %>
			<%
				}
			%>
			</td>
		</tr>
		</logic:iterate>
		</table>
	</td>
</tr>

<tr><td class="blank-height-40"></td></tr>
<tr align="right">
	<td class="report-bg-header-footer">
		<portlet:actionURL var="xuatFileTinhHinhThuLyHoSoCapPhong">
			<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphong" />
		</portlet:actionURL>
		<form action="<%= xuatFileTinhHinhThuLyHoSoCapPhong %>" method="post">
			<input type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' />
		</form>
	</td>
</tr>
</table>
</div>