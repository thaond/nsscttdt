<%@ include file="/html/portlet/nss/van_ban_phap_quy/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuySearch"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuyDisplayTerms"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil"%>

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
	VanBanPhapQuySearch vanBanPhapQuySearch = (VanBanPhapQuySearch) request.getAttribute("liferay-ui:search:searchContainer");
	VanBanPhapQuyDisplayTerms displayTerms = (VanBanPhapQuyDisplayTerms) vanBanPhapQuySearch.getDisplayTerms();
	
	List<CoQuanBanHanh> coQuanBanHanhList = (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList") == null ? new ArrayList<CoQuanBanHanh>() : (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList");
	List<LoaiVanBan> loaiVBList = (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList") == null ? new ArrayList<LoaiVanBan>() : (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList");
	List<LinhVucVanBan> linhVucVBList = (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList") == null ? new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList");
	
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_vanbanphapquy" >
	<table class="vanbanphapquy-table">
	
		<tr>
			<td align="right"><liferay-ui:message key="ky-hieu-van-ban" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.KY_HIEU_VAN_BAN %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getKyHieuVanBan()) %>" />
			</td>
					
			<td align="right"><liferay-ui:message key="tom-tat" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.TOM_TAT %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTomTat()) %>" />
			</td>		
			
		</tr>
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="nguoi-ky" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.NGUOI_KY %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getNguoiKy()) %>" />
			</td>
					
			<td align="right"><liferay-ui:message key="co-quan-ban-hanh" />:&nbsp;</td>
			<td align="left">
				<select name="<portlet:namespace /><%= displayTerms.MA_CO_QUAN_BAN_HANH%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTerms.getMaCoQuanBanHanh() == 0  ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!coQuanBanHanhList.isEmpty()) { 
							for (int i = 0; i < coQuanBanHanhList.size(); i ++) {
								CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) coQuanBanHanhList.get(i);
								String selDesc = (displayTerms.getMaCoQuanBanHanh() == coQuanBanHanh.getMaCoQuanBanHanh() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + coQuanBanHanh.getMaCoQuanBanHanh() + "\">" + coQuanBanHanh.getTenCoQuanBanHanh() + "</option>");
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		<tr height="10"></tr>
		<tr>
		 	<td align="right" class="minlabel"><liferay-ui:message key="loai-van-ban" /></td>
		    <td align="left" >
				<select name="<portlet:namespace /><%= displayTerms.MA_LOAI_VAN_BAN%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTerms.getMaLoaiVanBan() == 0 ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!loaiVBList.isEmpty()) { 
							for (int i = 0; i < loaiVBList.size(); i ++) {
								LoaiVanBan loaiVB = (LoaiVanBan) loaiVBList.get(i);
								String selDesc = (displayTerms.getMaLoaiVanBan() == loaiVB.getMaLoaiVanBan() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + loaiVB.getMaLoaiVanBan() + "\">" + loaiVB.getTenLoaiVanBan() + "</option>");
							}
						}
					%>
		    	</select>
		    </td>
					
			<td class="minlabel"><liferay-ui:message key="linh-vuc-van-ban" />:&nbsp;</td>
			<td align="left">
				<select name="<portlet:namespace /><%= displayTerms.MA_LINH_VUC_VAN_BAN%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTerms.getMaLinhVucVanBan() == 0 ? "selected" : "" )%> value=""><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!linhVucVBList.isEmpty()) { 
							for (int i = 0; i < linhVucVBList.size(); i ++) {
								LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVBList.get(i);
								String selDesc = (displayTerms.getMaLinhVucVanBan() == linhVucVB.getMaLinhVucVanBan() ? "selected" : "" );
								out.println("<option " + selDesc + " value=\"" + linhVucVB.getMaLinhVucVanBan() + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		<tr height="10"></tr>
		<tr>
			<%
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				int year = calendar.get(Calendar.YEAR);
				
				String tuNgay = "01/01/" + year;
				String denNgay = "31/12/" + year;
			%>
			<td align="right"><liferay-ui:message key="ngay-ban-hanh" /><liferay-ui:message key="tu-ngay" />:&nbsp;</td>
			<td align="left">
				<input type="text"  name="<portlet:namespace/><%= displayTerms.TU_NGAY %>" id="<portlet:namespace />fromDate" value="<%= (!"".equals(displayTerms.getTuNgay()) ? displayTerms.getTuNgay(): tuNgay)  %>" style="width: 125px" />
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')" />
			</td>
			
			<td align="right"><liferay-ui:message key="den-ngay" />:&nbsp;</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/><%= displayTerms.DEN_NGAY %>" id="<portlet:namespace />toDate" value="<%= (!"".equals(displayTerms.getDenNgay()) ? displayTerms.getDenNgay(): denNgay)  %>" style="width: 125px" />
				<img src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
			</td>		
		</tr>
		<tr height="10"></tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>

