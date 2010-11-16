<%@ include file="/html/portlet/nss/van_ban_phap_quy_display/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.nss.portlet.van_ban_phap_quy_display.search.VanBanPhapQuySearch"%>
<%@page import="com.nss.portlet.van_ban_phap_quy_display.search.VanBanPhapQuyDisplayTerms"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<script type="text/javascript">
	
	window.onload = function () {
	
		if (document.getElementById('<portlet:namespace />fromDate') != null) {
			callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate');
		}
		
		if (document.getElementById('<portlet:namespace />toDate') != null) {
			callCalendar('<portlet:namespace/>toDate','cal-button-ToDate');
		}
		
	}
</script>

<%
	VanBanPhapQuySearch vanBanPhapQuySearchDisplay = (VanBanPhapQuySearch) request.getAttribute("liferay-ui:search:searchContainer");
	VanBanPhapQuyDisplayTerms displayTermsDisplay = (VanBanPhapQuyDisplayTerms) vanBanPhapQuySearchDisplay.getDisplayTerms();
	
	List<CoQuanBanHanh> coQuanBanHanhList = (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList") == null ? new ArrayList<CoQuanBanHanh>() : (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList");
	List<LoaiVanBan> loaiVBList = (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList") == null ? new ArrayList<LoaiVanBan>() : (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList");
	List<LinhVucVanBan> linhVucVBList = (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList") == null ? new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList");
	
%>

<liferay-ui:search-toggle displayTerms="<%= displayTermsDisplay %>" id="toogle_id_vanbanphapquydisplay" >
	<table class="common-table">
	
		<tr>
			<td align="right"><liferay-ui:message key="ky-hieu-van-ban" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTermsDisplay.KY_HIEU_VAN_BAN %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTermsDisplay.getKyHieuVanBan()) %>" />
			</td>
			<td rowspan="7" width="20px"></td>
			<td align="right"><liferay-ui:message key="tom-tat" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTermsDisplay.TOM_TAT %>" size="15" type="text" value="<%= HtmlUtil.escape(displayTermsDisplay.getTomTat()) %>" />
			</td>		
			
		</tr>
		
		<tr>
			<td align="right"><liferay-ui:message key="nguoi-ky" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTermsDisplay.NGUOI_KY %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTermsDisplay.getNguoiKy()) %>" />
			</td>
					
			<td align="right"><liferay-ui:message key="co-quan-ban-hanh" />:&nbsp;</td>
			<td align="left">
				<select name="<portlet:namespace /><%= displayTermsDisplay.MA_CO_QUAN_BAN_HANH%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTermsDisplay.getMaCoQuanBanHanh() == 0  ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!coQuanBanHanhList.isEmpty()) { 
							for (int i = 0; i < coQuanBanHanhList.size(); i ++) {
								CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) coQuanBanHanhList.get(i);
								String selDesc = (displayTermsDisplay.getMaCoQuanBanHanh() == coQuanBanHanh.getMaCoQuanBanHanh() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + coQuanBanHanh.getMaCoQuanBanHanh() + "\">" + coQuanBanHanh.getTenCoQuanBanHanh() + "</option>");
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		
		<tr>
		 	<td align="right"><liferay-ui:message key="loai-van-ban" />:</td>
		    <td align="left">
				<select name="<portlet:namespace /><%= displayTermsDisplay.MA_LOAI_VAN_BAN%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTermsDisplay.getMaLoaiVanBan() == 0 ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!loaiVBList.isEmpty()) { 
							for (int i = 0; i < loaiVBList.size(); i ++) {
								LoaiVanBan loaiVB = (LoaiVanBan) loaiVBList.get(i);
								String selDesc = (displayTermsDisplay.getMaLoaiVanBan() == loaiVB.getMaLoaiVanBan() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + loaiVB.getMaLoaiVanBan() + "\">" + loaiVB.getTenLoaiVanBan() + "</option>");
							}
						}
					%>
		    	</select>
		    </td>
					
			<td align="right" class="minlabel"><liferay-ui:message key="linh-vuc-van-ban" />:</td>
			<td align="left">
				<select name="<portlet:namespace /><%= displayTermsDisplay.MA_LINH_VUC_VAN_BAN%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTermsDisplay.getMaLinhVucVanBan() == 0 ? "selected" : "" )%> value=""><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!linhVucVBList.isEmpty()) { 
							for (int i = 0; i < linhVucVBList.size(); i ++) {
								LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVBList.get(i);
								String selDesc = (displayTermsDisplay.getMaLinhVucVanBan() == linhVucVB.getMaLinhVucVanBan() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + linhVucVB.getMaLinhVucVanBan() + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		
		<tr>
			<%
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				int year = calendar.get(Calendar.YEAR);
				
				String tuNgay = "01/01/" + year;
				String denNgay = "31/12/" + year;
			%>
			<td align="right"><liferay-ui:message key="ngay-ban-hanh" /><liferay-ui:message key="tu-ngay" />:</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/><%= displayTermsDisplay.TU_NGAY %>" id="<portlet:namespace />fromDate" value="<%= (!"".equals(displayTermsDisplay.getTuNgay()) ? displayTermsDisplay.getTuNgay(): tuNgay)  %>" style="width: 100px" />
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')" />
			</td>
			
			<td align="right"><liferay-ui:message key="den-ngay" />:</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/><%= displayTermsDisplay.DEN_NGAY %>" id="<portlet:namespace />toDate" value="<%= (!"".equals(displayTermsDisplay.getDenNgay()) ? displayTermsDisplay.getDenNgay(): denNgay)  %>" style="width: 100px" />
				<img src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
			</td>		
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<div style="padding-top: 5px;padding-bottom: 10px; text-align: center;">
	<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
</div>
