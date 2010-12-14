<%@ include file="/html/portlet/nss/van_ban_phap_quy/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"%>
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
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String redirect = renderRequest.getParameter("redirect");

	VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy)renderRequest.getAttribute("vanBanPhapQuy");
	List<LinhVucVanBan> linhVucVanBanList = (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVBList") == null ? 
												new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVBList");
	List<LoaiVanBan> loaiVanBanList = (List<LoaiVanBan>) renderRequest.getAttribute("loaiVBList") == null ? 
												new ArrayList<LoaiVanBan>() : (List<LoaiVanBan>) renderRequest.getAttribute("loaiVBList");
	List<FileDinhKem> fileDinhKemList = (List<FileDinhKem>) renderRequest.getAttribute("fileDinhKemList") == null ? 
												new ArrayList<FileDinhKem>() : (List<FileDinhKem>) renderRequest.getAttribute("fileDinhKemList");
	List<CoQuanBanHanh> coQuanBanHanhList = (List<CoQuanBanHanh>) renderRequest.getAttribute("coQuanBanHanhList") == null ? 
			new ArrayList<CoQuanBanHanh>() : (List<CoQuanBanHanh>) renderRequest.getAttribute("coQuanBanHanhList");
																		
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/van_ban_phap_quy/view" );
	portletURL.setParameter("redirect", redirect);

%>


<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="return <portlet:namespace />validateFormVanBanPhapQuy()">
	<input type="hidden" name="<portlet:namespace/>maVanBanPhapQuy" id="maVanBanPhapQuy" value="<%= vanBanPhapQuy.getMaVanBanPhapQuy() %>" />
	<input type="hidden" name="<portlet:namespace/>str_filevanbanphapquytodelete" id="str_filevanbanphapquytodelete" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ky-hieu-van-ban" /></label>:
			</td>
			<td><input style="width: 50%" type="text" name="<portlet:namespace />kyHieuVanBan" id="kyHieuVanBan" value="<%= vanBanPhapQuy.getKyHieuVanBan() %>"/></td>
		</tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="loai-van-ban" /></label></td>
		    <td align="left">
				<select name="<portlet:namespace />maLoaiVanBan" id="maLoaiVanBan" style="width: 52%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						LoaiVanBan loaiVB = null;
						for (int i = 0; i < loaiVanBanList.size(); i ++) {
							loaiVB = (LoaiVanBan) loaiVanBanList.get(i);
							String select = ( vanBanPhapQuy.getMaLoaiVanBan() == loaiVB.getMaLoaiVanBan() ? "selected" : "" );
							out.println("<option " + select + " value=\"" + String.valueOf(loaiVB.getMaLoaiVanBan()) + "\">" + loaiVB.getTenLoaiVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="linh-vuc-van-ban" /></label>:</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maLinhVucVanBan" id="maLinhVucVanBan" style="width: 52%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < linhVucVanBanList.size(); i ++) {
							LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVanBanList.get(i);
							String selDesc = ( vanBanPhapQuy.getMaLinhVucVanBan() == linhVucVB.getMaLinhVucVanBan() ? "selected" : "" );
							out.println("<option " + selDesc + " value=\"" + String.valueOf(linhVucVB.getMaLinhVucVanBan()) + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="co-quan-ban-hanh" /></label>:</td>
		    <td align="left">
		   		 <select name="<portlet:namespace />maCoQuanBanHanh" id="maCoQuanBanHanh" style="width: 52%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < coQuanBanHanhList.size(); i ++) {
							CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) coQuanBanHanhList.get(i);
							String selDesc = ( vanBanPhapQuy.getMaCoQuanBanHanh() == coQuanBanHanh.getMaCoQuanBanHanh() ? "selected" : "" );
							out.println("<option " + selDesc + " value=\"" + String.valueOf(coQuanBanHanh.getMaCoQuanBanHanh()) + "\" >" + coQuanBanHanh.getTenCoQuanBanHanh() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
		<tr>
			<td>
			<label><liferay-ui:message key="tom-tat" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />tomTat" id="tomTat" style="width: 90%" rows="3"><%= vanBanPhapQuy.getTomTat() %></textarea></td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="nguon" /></label>:
			</td>
			<td>
				<input style="width: 90%" type="text" name="<portlet:namespace />nguon" id="nguon" value="<%= vanBanPhapQuy.getNguon() %>"/></td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="noi-dung" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />noiDung" id="noiDung" style="width: 90%" rows="3"><%= vanBanPhapQuy.getNoiDung() %></textarea></td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-ky" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayKy" id="<portlet:namespace/>ngayKy" value="<%= vanBanPhapQuy.getNgayKy() == null ? "" : df.format(vanBanPhapQuy.getNgayKy())%>" style="width: 40%" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayKy" onClick="callCalendar('<portlet:namespace/>ngayKy','cal-button-NgayKy')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-co-hieu-luc" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayCoHieuLuc" id="<portlet:namespace/>ngayCoHieuLuc" value="<%= vanBanPhapQuy.getNgayCoHieuLuc() == null ? "" : df.format(vanBanPhapQuy.getNgayCoHieuLuc())%>" style="width: 40%" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayCoHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayCoHieuLuc','cal-button-NgayCoHieuLuc')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="nguoi-ky" /></label>:
			</td>
			<td><input style="width: 90%" type="text" name="<portlet:namespace />nguoiKy" id="nguoiKy" value="<%= vanBanPhapQuy.getNguoiKy() %>"/></td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="ngay-ban-hanh" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayBanHanh" id="<portlet:namespace/>ngayBanHanh" value="<%= vanBanPhapQuy.getNgayBanHanh() == null ? "" : df.format(vanBanPhapQuy.getNgayBanHanh())%>" style="width: 40%" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayBanHanh" onClick="callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-NgayBanHanh')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-het-hieu-luc" /></label>:
			</td>
			<td align="left">
				<input type="text" name="<portlet:namespace/>ngayHetHieuLuc" id="<portlet:namespace/>ngayHetHieuLuc" value="<%= vanBanPhapQuy.getNgayHetHieuLuc() == null ? "" : df.format(vanBanPhapQuy.getNgayHetHieuLuc())%>" style="width: 40%" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-NgayHetHieuLuc" onClick="callCalendar('<portlet:namespace/>ngayHetHieuLuc','cal-button-NgayHetHieuLuc')" />
			</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%" rows="3"><%= vanBanPhapQuy.getDescription() %></textarea></td>
		</tr>
		<tr >
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" <%= vanBanPhapQuy.getActive() == 1 ? "checked=checked" : ""%> /></td>
		</tr>
</table>
		
	<%
		if (!fileDinhKemList.isEmpty()) {
	%>
	
<br>
<div class="results-grid">
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="tap-tin-dinh-kem"/></label>
	<table id="recentFile" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
			<td width="35px"><div align="center"><liferay-ui:message key="stt"/></div></td>
			<td width="30%"><div><liferay-ui:message key="tieu-de-tap-tin" /></div></td>
			<td width="40%"><div><liferay-ui:message key="ten-tap-tin" /></div></td>
			<td ><div align="center"></div></td>
		</tr>
		<logic:iterate id="fileDinhKem" name="fileDinhKemList" indexId="i" type="com.nss.portlet.van_ban_phap_quy.model.FileDinhKem" scope="request">
			<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>">
				<td align="center"><div><%= ++i %></div></td>
			 	<td><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getTenFile() %></a></div></td>
			  	<td><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getDuongDan().substring(22) %></a></div></td>
			  	<td align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteRowFileUpload(this, '<%= fileDinhKem.getMaFileDinhKem() %>');" ></td>
			</tr>
		</logic:iterate>
		
	</table>
	</fieldset>
	<%
		} 
	%>
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="toan-van"/></label>
	<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
			 <tr class="bgtitlecvddetails" align="center">
			   	<td width="35%"><liferay-ui:message key="tieu-de-tap-tin" /></td>
			    <td width="50%"><liferay-ui:message key="ten-tap-tin" /></td>
				<td align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="upload-file" />' onclick="uploadVanBanPhapQuyFile()"></td>
			</tr>
	</table>
</fieldset>
</div>
<br/>

<div id ="table-button" align="right">
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
</div>
<br><br>
</form>