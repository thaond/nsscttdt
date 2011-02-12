<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>
<%@page import="com.sgs.portlet.onedoorpcccreport.dto.LoaiHoSoDTO"%>


<%@page import="com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO"%>
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
	String month = request.getAttribute("month").toString();
	String fromDate = request.getAttribute("fromDate").toString();
	String toDate = request.getAttribute("toDate").toString();
	BaoCaoHoSoThangLuyKeDTO totalDTO = (BaoCaoHoSoThangLuyKeDTO) renderRequest.getAttribute("totalDTO");
%>


<portlet:renderURL var="back">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/view" />
</portlet:renderURL>
<div style="width:100%;text-align:center;background-color: #F2F2E6"">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td align="right"><a href="<%= back %>">&laquo;back</a><br /><br /></td></tr>
<tr align="left">
	<td class="report-bg-header-footer">
		<portlet:actionURL var="xuatThongKe">
			<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluyke" />
		</portlet:actionURL>
		<form action="<%= xuatThongKe %>" method="post" onsubmit="return <portlet:namespace/>checkForm(this)">
		<!--<liferay-ui:message key="onedoorpcccreport-baocaotheothang" /> 
		<input type="text" name="<portlet:namespace />month" id="<portlet:namespace />month" value="" />--> 
		<liferay-ui:message key="onedoorpcccreport-tungay" /> 
		<input type="text" name="<portlet:namespace/>fromDate" id="<portlet:namespace/>fromDate" value="<%= fromDate %>" />
		<img id="cal-button-FromDate" src="/html/images/cal.gif" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')"/>
		<liferay-ui:message key="onedoorpcccreport-denngay" /> 
		<input type="text" name="<portlet:namespace/>toDate" id="<portlet:namespace/>toDate" value="<%= toDate %>" />
		<img id="cal-button-ToDate" src="/html/images/cal.gif" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')"/>
		&nbsp;&nbsp;&nbsp;<input type="submit" value='<liferay-ui:message key="onedoorpcccreport-xembaocao" />' />
		</form>
	</td>
</tr>
<tr><td class="blank-height-20"></td></tr>
<%
if(Validator.isNull(fromDate) == false && Validator.isNull(toDate) == false) {
%>
<tr>
	<td>
		<font class="report-title"><liferay-ui:message key="onedoorpcccreport-tieudebaocaohosothangluyke" /> 02/2009</font>
	</td>
</tr>
<tr><td><liferay-ui:message key="onedoorpcccreport-mota" /> 02/2009 (<liferay-ui:message key="onedoorpcccreport-tungay" /> <%= fromDate %> <liferay-ui:message key="onedoorpcccreport-denngay" /> <%= toDate %>)<br /><br /></td></tr>
<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" class="report-table-list">
		<tr>
			<td rowspan="2"><b><liferay-ui:message key="onedoorpcccreport-diengiai" /></b></td>
			<td colspan="3"><b><liferay-ui:message key="onedoorpcccreport-hosonhan" /></b></td>
			<td rowspan="2" width="6%"><b><liferay-ui:message key="onedoorpcccreport-hosotiepnhantrongnam" /></b></td>
			<td colspan="2"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
			<td rowspan="2" width="6%"><b><liferay-ui:message key="onedoorpcccreport-hosoton" /></b></td>
			<td rowspan="2" width="15%"><b><liferay-ui:message key="onedoorpcccreport-ghichu" /></b></td>
		</tr>
		<tr>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-tondauky" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-trongthang" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-trongthang" /></b></td>
			<td width="5%"><b><liferay-ui:message key="onedoorpcccreport-trongnam" /></b></td>
		</tr>
		
		<tr>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_tonDauKy">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="tondauky" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_trongThangHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="trongthanghosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_tongCong">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="tongcong" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_trongNamHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="trongnamhosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_trongThangHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="trongthanghosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_trongNamHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="trongnamhosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_total_hoSoTon">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="action" value="hosoton" />
			</portlet:renderURL>
			<td align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
			<td><b>
			<%
				if (totalDTO.getTonDauKy() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_tonDauKy %>"><%=totalDTO.getTonDauKy() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTonDauKy() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getTrongThangHoSoNhan() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_trongThangHoSoNhan %>"><%=totalDTO.getTrongThangHoSoNhan() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTrongThangHoSoNhan() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getTongCong() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_tongCong %>"><%=totalDTO.getTongCong() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTongCong() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getTrongNamHoSoNhan() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_trongNamHoSoNhan %>"><%=totalDTO.getTrongNamHoSoNhan() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTrongNamHoSoNhan() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getTrongThangHoSoGiaiQuyet() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_trongThangHoSoGiaiQuyet %>"><%=totalDTO.getTrongThangHoSoGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTrongThangHoSoGiaiQuyet() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getTrongNamHoSoGiaiQuyet() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_trongNamHoSoGiaiQuyet %>"><%=totalDTO.getTrongNamHoSoGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getTrongNamHoSoGiaiQuyet() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (totalDTO.getHoSoTon() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_total_hoSoTon %>"><%=totalDTO.getHoSoTon() %></a>
			<%
				} else {
			%>
				<%= totalDTO.getHoSoTon() %>
			<%
				}
			%>
			</b></td>
			<td></td>
		</tr>
		<logic:iterate id="baoCaoHoSoThangLuyKeDTO" name="baoCaoHoSoThangLuyKeList"
			type="com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO" indexId="i" scope="request">
		<tr style="background-color: #E1E1E1">
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_tenLoaiHoSo">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tenloaihoso" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_tonDauKy">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tondauky" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_trongThangHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongthanghosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_tongCong">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tongcong" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_trongNamHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongnamhosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_trongThangHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongthanghosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_trongNamHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongnamhosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_department_hoSoTon">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="hosoton" />
			</portlet:renderURL>
			<td align="left">
			<%
				if (baoCaoHoSoThangLuyKeDTO.isHasFile() == true) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_tenLoaiHoSo %>"><b>- <%= baoCaoHoSoThangLuyKeDTO.getTenPhongBan() %></b></a>
			<%
				} else {
			%>
				<b>- <%= baoCaoHoSoThangLuyKeDTO.getTenPhongBan() %></b>
			<%
				}
			%>
			</td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTonDauKy() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_tonDauKy %>"><%=baoCaoHoSoThangLuyKeDTO.getTonDauKy() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTonDauKy() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_trongThangHoSoNhan %>"><%=baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTongCong() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_tongCong %>"><%=baoCaoHoSoThangLuyKeDTO.getTongCong() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTongCong() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_trongNamHoSoNhan %>"><%=baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_trongThangHoSoGiaiQuyet %>"><%=baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_trongNamHoSoGiaiQuyet %>"><%=baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet() %></div></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet() %>
			<%
				}
			%>
			</b></td>
			<td><b>
			<%
				if (baoCaoHoSoThangLuyKeDTO.getHoSoTon() > 0) {
			%>
				<a href="<%=baoCaoHoSoThangLuyKe_department_hoSoTon %>"><%=baoCaoHoSoThangLuyKeDTO.getHoSoTon() %></a>
			<%
				} else {
			%>
				<%= baoCaoHoSoThangLuyKeDTO.getHoSoTon() %>
			<%
				}
			%>
			</b></td>
			<td align="left"><%= baoCaoHoSoThangLuyKeDTO.getGhiChu() %></td>
		</tr>
		<%
		int loaiHoSoSize = baoCaoHoSoThangLuyKeDTO.getLoaiHoSoList().size();
		for(int index = 0; index < loaiHoSoSize; index ++) {
			LoaiHoSoDTO loaiHoSoDTO = baoCaoHoSoThangLuyKeDTO.getLoaiHoSoList().get(index);
		%>
			<tr>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_tenLoaiHoSo">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tenloaihoso" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_tonDauKy">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tondauky" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_trongThangHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongthanghosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_tongCong">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="tongcong" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_trongNamHoSoNhan">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongnamhosonhan" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_trongThangHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongthanghosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_trongNamHoSoGiaiQuyet">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="trongnamhosogiaiquyet" />
			</portlet:renderURL>
			<portlet:renderURL var="baoCaoHoSoThangLuyKe_fileType_hoSoTon">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluykedetail" />
				<portlet:param name="departmentId" value="<%=baoCaoHoSoThangLuyKeDTO.getDepartmentId() %>" />
				<portlet:param name="action" value="hosoton" />
			</portlet:renderURL>
				<td align="left">
				<%
					if (loaiHoSoDTO.isHasFile() == true) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_tenLoaiHoSo %>"><%= index + 1 %>/&nbsp;<%= loaiHoSoDTO.getTenLoaiHoSo() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTenLoaiHoSo() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTonDauKy() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_tonDauKy %>"><%= loaiHoSoDTO.getTonDauKy() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTonDauKy() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTrongThangHoSoNhan() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_trongThangHoSoNhan %>"><%= loaiHoSoDTO.getTrongThangHoSoNhan() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTrongThangHoSoNhan() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTongCong() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_tongCong %>"><%= loaiHoSoDTO.getTongCong() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTongCong() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTrongNamHoSoNhan() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_trongNamHoSoNhan %>"><%= loaiHoSoDTO.getTrongNamHoSoNhan() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTrongNamHoSoNhan()%>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTrongThangHoSoGiaiQuyet() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_trongThangHoSoGiaiQuyet %>"><%= loaiHoSoDTO.getTrongThangHoSoGiaiQuyet() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTrongThangHoSoGiaiQuyet() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getTrongNamHoSoGiaiQuyet() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_trongNamHoSoGiaiQuyet %>"><%= loaiHoSoDTO.getTrongNamHoSoGiaiQuyet() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getTrongNamHoSoGiaiQuyet() %>
				<%
					}
				%>
				</td>
				<td>
				<%
					if (loaiHoSoDTO.getHoSoTon() > 0) {
				%>
					<a href="<%=baoCaoHoSoThangLuyKe_fileType_hoSoTon %>"><%= loaiHoSoDTO.getHoSoTon() %></a>
				<%
					} else {
				%>
					<%= loaiHoSoDTO.getHoSoTon() %>
				<%
					}
				%>
				</td>
				<td align="left"><%= loaiHoSoDTO.getGhiChu() %></td>
			</tr>
			<%
				} 
			%>
		</logic:iterate>
		</table>
	</td>
</tr>
<tr><td class="blank-height-40"></td></tr>
<tr align="right">
	<td class="report-bg-header-footer">
		<portlet:actionURL var="xuatFileBaoCaoHoSoThangLuyKe">
			<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluyke" />
			<portlet:param name="cmd" value="report" />
		</portlet:actionURL>
		<form action="<%= xuatFileBaoCaoHoSoThangLuyKe %>" method="post">
			<input type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' />
		</form>
	</td>
</tr>
<%
	}
%>
</table>
</div>