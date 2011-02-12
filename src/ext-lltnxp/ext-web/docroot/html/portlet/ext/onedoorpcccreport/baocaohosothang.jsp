<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<script type="text/javascript">
window.onload = function (){
	
	
	if (document.getElementById('<portlet:namespace/>fromDate') != null) {
		callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate');
	}
	if (document.getElementById('<portlet:namespace/>toDate') != null) {
		callCalendar('<portlet:namespace/>toDate','cal-button-ToDate');
	}
	
}
</script>
<%
String fromDate = request.getAttribute("fromDate").toString();
String toDate = request.getAttribute("toDate").toString();
%>
<portlet:renderURL var="back">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/view" />
</portlet:renderURL>
<portlet:actionURL var="xuatThongKe">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothang" />
</portlet:actionURL>
<portlet:actionURL var="xuatFileBaoCaoHoSoThang">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothang" />
	<portlet:param name="cmd" value="report" />
</portlet:actionURL>
<script type="text/javascript">
function <portlet:namespace />addActionFrom() {
	var action = "<%= xuatFileBaoCaoHoSoThang %>";
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
}
function <portlet:namespace />setActionFrom() {
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", "");
}
</script>
<form name="<portlet:namespace />frmReport" action="<%= xuatThongKe %>" method="post" onsubmit="return <portlet:namespace/>checkForm(this)">
<div style="width:100%;text-align:center;background-color: #F2F2E6">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td align="right"><a href="<%= back %>">&laquo;back</a><br /><br /></td></tr>
<tr align="left">
	<td class="report-bg-header-footer">
		<liferay-ui:message key="onedoorpcccreport-tungay" /> 
		<input type="text" name="<portlet:namespace/>fromDate" id="<portlet:namespace/>fromDate" value="<%= fromDate %>" />
		<img id="cal-button-FromDate" src="/html/images/cal.gif" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')"/> 
		<liferay-ui:message key="onedoorpcccreport-denngay" /> 
		<input type="text" name="<portlet:namespace/>toDate" id="<portlet:namespace/>toDate" value="<%= toDate %>" />
		<img id="cal-button-ToDate" src="/html/images/cal.gif" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')"/>
		&nbsp;&nbsp;&nbsp;<input type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuatthongke" />' />
	</td>
</tr>
<tr><td class="blank-height-20"></td></tr>
<%
if(Validator.isNull(fromDate) == false && Validator.isNull(toDate) == false) {
%>
<jsp:useBean id="baoCaoHoSoThangList" type="java.util.List" scope="request" />
<tr>
	<td>
		<font class="report-title"><liferay-ui:message key="onedoorpcccreport-tieudebaocaohosothang" /></font><br />
		(<liferay-ui:message key="onedoorpcccreport-tinhtungay" /> <%= fromDate %> <liferay-ui:message key="onedoorpcccreport-denngay" /> <%= toDate %>)<br /><br />
	</td>
</tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="report-table-list">
		<tr>
			<td rowspan="3" width="3%"><b><liferay-ui:message key="onedoorpcccreport-stt" /></b></td>
			<td rowspan="3"><b><liferay-ui:message key="onedoorpcccreport-tensanpham" /></b></td>
			<td colspan="8"><b><liferay-ui:message key="onedoorpcccreport-noidungthongke" /></b></td>
			<td rowspan="3" width="7%"><b><liferay-ui:message key="onedoorpcccreport-tylehosodunghan" /></b></td>
		</tr>
		<tr>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tondauky" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-hosonhantrongthang" /></b></td>
			<td rowspan="2" width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td colspan="2"><b><liferay-ui:message key="onedoorpcccreport-soluonghosohoanthanh" /></b></td>
			<td colspan="3"><b><liferay-ui:message key="onedoorpcccreport-soluonghosodangthuly" /></b></td>
		</tr>
		<tr>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-sodunghan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-sotrehan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-tronghan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-datrehan" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-chinhsuabosung" /></b></td>
		</tr>
		<%
		int tonDauKy = 0;
		int hoSoNhanTrongThang = 0;
		int tongCong = 0;
		int soDungHan = 0;
		int soTreHan = 0;
		int trongHan = 0;
		int daTreHan = 0;
		int chinhSuaBoSung = 0;
		int tyLeHoSoDungHan = 0;
		%>
		<logic:iterate id="baoCaoHoSoThangDTO" name="baoCaoHoSoThangList"
		type="com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangDTO" indexId="i">
		
		<%
		tonDauKy += baoCaoHoSoThangDTO.getTonDauKy();
		hoSoNhanTrongThang += baoCaoHoSoThangDTO.getHoSoNhanTrongThang();
		tongCong += baoCaoHoSoThangDTO.getTongCong();
		soDungHan += baoCaoHoSoThangDTO.getSoDungHan();
		soTreHan += baoCaoHoSoThangDTO.getSoTreHan();
		trongHan += baoCaoHoSoThangDTO.getTrongHan();
		daTreHan += baoCaoHoSoThangDTO.getDaTreHan();
		chinhSuaBoSung += baoCaoHoSoThangDTO.getChinhSuaBoSung();
		//tyLeHoSoDungHan += baoCaoHoSoThangDTO.getTyLeHoSoDungHan();
		%>
		
		<tr>
			<td><%= baoCaoHoSoThangDTO.getStt() %></td>
			<td align="left">
				<portlet:renderURL var="chitiethoso_baocaothang_tensanpham">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="tensanpham"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% 
					if(baoCaoHoSoThangDTO.isHasFile() == true) { 
				%>
				<a href="<%= chitiethoso_baocaothang_tensanpham %>"><%= baoCaoHoSoThangDTO.getTenSanPham() %></a>
				<% 
					} else { 
				%>
					<%= baoCaoHoSoThangDTO.getTenSanPham() %>
				<%
					}
				%>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_tondauky">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="tondauky"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getTonDauKy() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_tondauky %>"><%= baoCaoHoSoThangDTO.getTonDauKy() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getTonDauKy() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_nhantrongthang">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="nhantrongthang"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getHoSoNhanTrongThang() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_nhantrongthang %>"><%= baoCaoHoSoThangDTO.getHoSoNhanTrongThang() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getHoSoNhanTrongThang() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_tongcong">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="tongcong"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getTongCong() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_tongcong %>"><%= baoCaoHoSoThangDTO.getTongCong() %></a></td>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getTongCong() %>
				<% } %>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_sodunghan">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="sodunghan"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getSoDungHan() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_sodunghan %>"><%= baoCaoHoSoThangDTO.getSoDungHan() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getSoDungHan() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_sotrehan">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="sotrehan"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getSoTreHan() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_sotrehan %>"><%= baoCaoHoSoThangDTO.getSoTreHan() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getSoTreHan() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_tronghan">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="tronghan"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getTrongHan() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_tronghan %>"><%= baoCaoHoSoThangDTO.getTrongHan() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getTrongHan() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_datrehan">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="datrehan"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>
				<% if(baoCaoHoSoThangDTO.getDaTreHan() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_datrehan %>"><%= baoCaoHoSoThangDTO.getDaTreHan() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getDaTreHan() %>
				<% } %>
			</td>
			<td>
				<portlet:renderURL var="chitiethoso_baocaothang_chinhsuabosung">
					<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
					<portlet:param name="columeName" value="chinhsuabosung"/>
					<portlet:param name="fileTypeId" value="<%= baoCaoHoSoThangDTO.getFileTypeId() %>" />
					<portlet:param name="fromDate" value="<%= fromDate %>" />
					<portlet:param name="toDate" value="<%= toDate %>" />
				</portlet:renderURL>				
				<% if(baoCaoHoSoThangDTO.getChinhSuaBoSung() > 0) { %>
					<a style="text-decoration: underline;" href="<%= chitiethoso_baocaothang_chinhsuabosung %>"><%= baoCaoHoSoThangDTO.getChinhSuaBoSung() %></a>
				<% } else { %>
					<%= baoCaoHoSoThangDTO.getChinhSuaBoSung() %>
				<% } %>
			</td>
			<td><%= baoCaoHoSoThangDTO.getTyLeHoSoDungHan() %></td>
		</tr>
		</logic:iterate>
		<tr>
			<td></td>
			<td><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td><b><%= tonDauKy %></b></td>
			<td><b><%= hoSoNhanTrongThang %></b></td>
			<td><b><%= tongCong %></b></td>
			<td><b><%= soDungHan %></b></td>
			<td><b><%= soTreHan %></b></td>
			<td><b><%= trongHan %></b></td>
			<td><b><%= daTreHan %></b></td>
			<td><b><%= chinhSuaBoSung %></b></td>
			<td><b><%= tyLeHoSoDungHan %>%</b></td>
		</tr>
		</table>
	</td>
</tr>
<tr><td class="blank-height-40"></td></tr>
<tr align="right">
	<td class="report-bg-header-footer">
		<input type="button" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' onclick="<portlet:namespace />addActionFrom();<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" />
	</td>
</tr>
<%
}
%>
</table>
</div>
</form>