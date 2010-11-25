<%@ include file="/html/portlet/nss/van_ban_phap_quy/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>

<liferay-util:include page="/html/portlet/nss/van_ban_phap_quy/js/vanbanphapquy-js.jsp"></liferay-util:include>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<script type="text/javascript">
	
	window.onload = function () {
	
		if (document.getElementById('<portlet:namespace/>ngayKy') != null) {
			callCalendar('<portlet:namespace/>ngayKy','cal-button-NgayKy');
		}
		
		if (document.getElementById('<portlet:namespace/>ngayCoHieuLuc') != null) {
			callCalendar('<portlet:namespace/>ngayCoHieuLuc','cal-button-NgayCoHieuLuc');
		}
		
		if (document.getElementById('<portlet:namespace/>ngayHetHieuLuc') != null) {
			callCalendar('<portlet:namespace/>ngayHetHieuLuc','cal-button-NgayHetHieuLuc');
		}
		
		if (document.getElementById('<portlet:namespace/>ngayBanHanh') != null) {
			callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-NgayBanHanh');
		}
		
	}
</script>

<%
	String redirect = renderRequest.getParameter("redirect");

	List<LinhVucVanBan> linhVucVanBanList = (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVBList") == null ? 
												new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVBList");
	List<LoaiVanBan> loaiVanBanList = (List<LoaiVanBan>) renderRequest.getAttribute("loaiVBList") == null ? 
												new ArrayList<LoaiVanBan>() : (List<LoaiVanBan>) renderRequest.getAttribute("loaiVBList");
	List<CoQuanBanHanh> coQuanBanHanhList = (List<CoQuanBanHanh>) renderRequest.getAttribute("coQuanBanHanhList") == null ? 
												new ArrayList<CoQuanBanHanh>() : (List<CoQuanBanHanh>) renderRequest.getAttribute("coQuanBanHanhList");
												
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/van_ban_phap_quy/view" );
	portletURL.setParameter("redirect", redirect);

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
%>


<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="return <portlet:namespace />validateFormVanBanPhapQuy()">
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
		
	<table width="100%" border="0" class="common-table">
		<tr>
			<td>
			<label><liferay-ui:message key="ky-hieu-van-ban" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />kyHieuVanBan" class="form-input-box" id="kyHieuVanBan" value=""/></td>
			<td>&nbsp;</td>
		</tr>
		
		
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="loai-van-ban" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
				<select name="<portlet:namespace />maLoaiVanBan" id="maLoaiVanBan" class="form-input-box">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < loaiVanBanList.size(); i ++) {
							LoaiVanBan loaiVB = (LoaiVanBan) loaiVanBanList.get(i);
							out.println("<option value=\"" + String.valueOf(loaiVB.getMaLoaiVanBan()) + "\">" + loaiVB.getTenLoaiVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    
	    
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="linh-vuc-van-ban" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maLinhVucVanBan" id="maLinhVucVanBan" class="form-input-box">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < linhVucVanBanList.size(); i ++) {
							LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVanBanList.get(i);
							out.println("<option value=\"" + String.valueOf(linhVucVB.getMaLinhVucVanBan()) + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    
	    
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="co-quan-ban-hanh" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maCoQuanBanHanh" id="maCoQuanBanHanh" class="form-input-box">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < coQuanBanHanhList.size(); i ++) {
							CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) coQuanBanHanhList.get(i);
							out.println("<option value=\"" + String.valueOf(coQuanBanHanh.getMaCoQuanBanHanh()) + "\">" + coQuanBanHanh.getTenCoQuanBanHanh() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	     
	    
		<tr>
			<td>
				<label><liferay-ui:message key="tom-tat" /></label>
			</td>
			<td><textarea name="<portlet:namespace />tomTat" class="form-input-box" id="tomTat" cols="45" rows="5" ></textarea></td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
				<label><liferay-ui:message key="nguon" /></label>
			</td>
			<td>
				<input type="text" name="<portlet:namespace />nguon" class="form-input-box" id="nguon" value=""/></td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="noi-dung" /></label>
			</td>
			<td><textarea name="<portlet:namespace />noiDung" class="form-input-box" id="noiDung" cols="45" rows="5"></textarea></td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-ky" /></label>
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayKy" id="<portlet:namespace/>ngayKy" value="<%= df.format(date) %>" class="form-input-box" />
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayKy" onClick="callCalendar('<portlet:namespace/>ngayKy','cal-button-NgayKy')" />
			</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-co-hieu-luc" /></label>
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayCoHieuLuc" id="<portlet:namespace/>ngayCoHieuLuc" value="<%= df.format(date) %>" class="form-input-box" />
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayCoHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayCoHieuLuc','cal-button-NgayCoHieuLuc')" />
			</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="nguoi-ky" /></label>
			</td>
			<td><input type="text" name="<portlet:namespace />nguoiKy" class="form-input-box" id="nguoiKy" value=""/></td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
				<label><liferay-ui:message key="ngay-ban-hanh" /></label>
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayBanHanh" id="<portlet:namespace/>ngayBanHanh" value="<%= df.format(date) %>" class="form-input-box" />
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayBanHanh" onClick="callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-NgayBanHanh')" />
			</td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-het-hieu-luc" /></label>
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayHetHieuLuc" id="<portlet:namespace/>ngayHetHieuLuc" value="<%= df.format(date) %>" class="form-input-box"/>
				<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayHetHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayHetHieuLuc','cal-button-NgayHetHieuLuc')" />
			</td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" class="form-input-box" id="description" cols="45" rows="5"></textarea></td>
			<td>&nbsp;</td>
		</tr>
		
	    
		<tr >
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
			<td></td>
		</tr>
	     
		<tr>
			<td>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<table>
	  <tr>
	    <td valign="top"><div align="right"></div></td>
	    <td colspan="3" align="center">
	    <fieldset>
			<legend class="legend-noborder"><liferay-ui:message key="toan-van"/></legend>
			<table id="addfileupload" class="table-pml"  style="width: 98%" align="center" cellpadding="0" cellspacing="0">
			  <tr class="bgtitlecvddetails" align="center">
			   <td width="30%" class="td-stt-pml"><liferay-ui:message key="tieu-de-tap-tin" /></td>
			    <td width="50%" class="td-stt-pml"><liferay-ui:message key="ten-tap-tin" /></td>
					<td width="20%" class="td-stt-pml"><input type="button" value='<liferay-ui:message key="upload-file" />' onclick="uploadVanBanPhapQuyFile()"></td>
				</tr>
			 </table>
			
		</fieldset>
	    </td>
	  </tr>
	</table>
	<br/>
	<table id="table-button">
		<tbody>
			<tr>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
		</tbody>
	</table>
	</div>
</form>