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
		
<table width="100%" cellspacing="0">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ky-hieu-van-ban" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input style="width: 50%" type="text" name="<portlet:namespace />kyHieuVanBan" id="kyHieuVanBan" value=""/></td>
		</tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="loai-van-ban" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>:
	    	</td>
		    <td align="left">
				<select name="<portlet:namespace />maLoaiVanBan" id="maLoaiVanBan" style="width: 52%">
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
	    	<span style="color: rgb(255, 0, 0);"> *</span>:
	    	</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maLinhVucVanBan" id="maLinhVucVanBan" style="width: 52%">
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
	    	<span style="color: rgb(255, 0, 0);"> *</span>:
	    	</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maCoQuanBanHanh" id="maCoQuanBanHanh" style="width: 52%">
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
				<label><liferay-ui:message key="tom-tat" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />tomTat" id="tomTat" style="width: 90%" rows="3" ></textarea></td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="nguon" /></label>:
			</td>
			<td>
				<input style="width: 90%" type="text" name="<portlet:namespace />nguon" id="nguon" value=""/></td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="noi-dung" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />noiDung" id="noiDung" style="width: 90%" rows="3"></textarea></td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-ky" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayKy" id="<portlet:namespace/>ngayKy" value="<%= df.format(date) %>" style="width: 40%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayKy" onClick="callCalendar('<portlet:namespace/>ngayKy','cal-button-NgayKy')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-co-hieu-luc" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayCoHieuLuc" id="<portlet:namespace/>ngayCoHieuLuc" value="<%= df.format(date) %>" style="width: 40%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayCoHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayCoHieuLuc','cal-button-NgayCoHieuLuc')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="nguoi-ky" /></label>:
			</td>
			<td><input type="text" name="<portlet:namespace />nguoiKy" id="nguoiKy" value="" style="width: 90%"/></td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="ngay-ban-hanh" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayBanHanh" id="<portlet:namespace/>ngayBanHanh" value="<%= df.format(date) %>" style="width: 40%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayBanHanh" onClick="callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-NgayBanHanh')" />
			</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-het-hieu-luc" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayHetHieuLuc" id="<portlet:namespace/>ngayHetHieuLuc" value="<%= df.format(date) %>" style="width: 40%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayHetHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayHetHieuLuc','cal-button-NgayHetHieuLuc')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%" rows="3"></textarea></td>
		</tr>
		<tr >
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
		</tr>
</table>
<br>
<div class="results-grid">
<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="toan-van"/></label>
			<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
				   	<td width="35%"><liferay-ui:message key="tieu-de-tap-tin" /></td>
				    <td width="50%"><liferay-ui:message key="ten-tap-tin" /></td>
					<td align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="upload-file" />' onclick="uploadVanBanPhapQuyFile()"></td>
				</tr>
			 </table>
</fieldset>
</div>
<br>
<div id ="table-button" align="right">
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
</div>
<br>
<br>
</div>
</form>