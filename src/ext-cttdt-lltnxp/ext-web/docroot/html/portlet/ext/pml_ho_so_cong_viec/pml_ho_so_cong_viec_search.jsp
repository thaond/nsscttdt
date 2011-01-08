<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>
<%@page import="com.sgs.portlet.field.model.PmlField"%>
<%@page import="com.sgs.portlet.field.service.persistence.PmlFieldUtil"%>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<style>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>
<script type="text/javascript" >

	window.onload = function () {
		if (document.getElementById('ngaymohscv') != null) {
			callCalendar('ngaymohscv','cal-button-ngaymohscv');
		}
	}

</script>

<%
	PmlHoSoCongViecSearch searchContainer = (PmlHoSoCongViecSearch)request.getAttribute("liferay-ui:search:searchContainer");
	
	PmlHoSoCongViecDisplayTerms displayTerms = (PmlHoSoCongViecDisplayTerms)searchContainer.getDisplayTerms();

	//List<PmlL>
	List<PmlDoQuanTrong> pmlDoQuanTrongs = PmlDoQuanTrongLocalServiceUtil.getAll();
	List<PmlTrangThaiHSCV> pmlTrangThaies = PmlTrangThaiHSCVLocalServiceUtil.getAll();
	List<PmlField> fields = PmlFieldUtil.findAll();
	
	SimpleDateFormat formatSearch = new SimpleDateFormat("dd/MM/yyyy"); 
%>

<liferay-ui:search-toggle id="toggle_id_pml_hscv_search" displayTerms="<%= displayTerms %>">
<table cellspacing="0" width="100%">
	<tr>
		
		<td width="15%">
			<liferay-ui:message key="pml_sohieuhscv" />&nbsp;:
		</td>
		<td width="35%">
			<input style="width: 90%" name="<portlet:namespace /><%= displayTerms.SOHIEUHSCV %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSoHieuHSCV()) %>" />
		</td>
		<td width="15%">
			<liferay-ui:message key="pml_tieude" />&nbsp;:
		</td>
		<td >
			<input style="width: 90%" name="<portlet:namespace /><%= displayTerms.TIEUDE %>"  type="text" value="<%= HtmlUtil.escape(displayTerms.getTieuDe()) %>" />
		</td>
	</tr>
	<tr >
		<td ><liferay-ui:message key="pml_linhvuc" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.IDLINHVUC %>" style="width: 93%">
				<option value=""></option>
				<%
				for (int idx = 0; idx < fields.size(); idx++) {
					PmlField fieldItem = (PmlField) fields.get(idx); 
				%>
					<option <%= displayTerms.getIdLinhVuc().equals(fieldItem.getFieldId()) ? "selected" : "" %> value="<%= fieldItem.getFieldId() %>"><%= fieldItem.getFieldName() %></option>
				<%
				}
				%>
			</select>
		</td>
		<td>
			<liferay-ui:message key="pml_ngaymo" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.NGAYMOHSCV %>" style="width:35%;" type="text" value='<%= displayTerms.getNgayMoHSCV() != null ? formatSearch.format(displayTerms.getNgayMoHSCV()) : "" %>' id="ngaymohscv" />
		    <span style="cursor: pointer"><img align="top" id="cal-button-ngaymohscv" src="/html/images/cal.gif" onclick="callCalendar('ngaymohscv','cal-button-ngaymohscv')"/></span>
		</td>
	</tr>
	<tr >
		<td>
			<liferay-ui:message key="pml_vandelienquan" />&nbsp;:
		</td>
		<td>
			<input style="width: 90%" name="<portlet:namespace /><%= displayTerms.VANDELIENQUAN %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getVanDeLienQuan()) %>" />
		</td>
		<td>
			<liferay-ui:message key="pml_mucdoquantrong" />&nbsp;:
		</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.IDDOQUANTRONG %>" style="width: 93%">
				<option value="0"></option>
				<%
				for (int idx = 0; idx < pmlDoQuanTrongs.size(); idx++) {
					PmlDoQuanTrong doQuanTrongItem = (PmlDoQuanTrong) pmlDoQuanTrongs.get(idx); 
				%>
					<option <%= displayTerms.getIdDoQuanTrong() == doQuanTrongItem.getIdDoQuanTrong() ? "selected" : "" %> value="<%= doQuanTrongItem.getIdDoQuanTrong() %>"><%= doQuanTrongItem.getTenDoQuanTrong() %></option>
				<%
				}
				%>
			</select>
		</td>
	</tr>

	<tr >		
		<td>
			<liferay-ui:message key="pml_trangthai" />&nbsp;:
		</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.IDTRANGTHAIHSCV %>" style="width: 93%">
				<option value="0"></option>
				<%
				for (int idx = 0; idx < pmlTrangThaies.size(); idx++) {
					PmlTrangThaiHSCV trangThaiHSCVItem = (PmlTrangThaiHSCV) pmlTrangThaies.get(idx); 
				%>
					<option <%= displayTerms.getIdTrangThaiHSCV() == trangThaiHSCVItem.getIdTrangThaiHSCV() ? "selected" : "" %> value="<%= trangThaiHSCVItem.getIdTrangThaiHSCV() %>"><%= trangThaiHSCVItem.getTenTrangThaiHSCV() %></option>
				<%
				}
				%>
			</select>
		</td>
		<td>
			<liferay-ui:message key="pml_hoatdong" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.HOATDONG %>" type="checkbox" <%= displayTerms.getHoatDong().equals("1") ? "checked" : "" %> />
		</td>
	</tr>
	<tr >
		<td>
			<liferay-ui:message key="pml_tomtatnoidung" />&nbsp;:
		</td>
		<td colspan="3">
			<textarea style="width: 96%" rows="2" name="<portlet:namespace /><%= displayTerms.TOMTATNOIDUNG %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTomTatNoiDung()) %>" /></textarea>
		</td>
	</tr>		
</table>
</liferay-ui:search-toggle>
<br />
<div>
	<input type="button" value='<liferay-ui:message key="search-hosocongviec" />' onClick="<portlet:namespace />searchData();" />
	<input type="button" value='<liferay-ui:message key="add-hosocongviec" />' onClick="<portlet:namespace />addHoSoCongViec();" />
</div>

<script type="text/javascript">
	function <portlet:namespace />addHoSoCongViec() {
		var url = '<liferay-portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" portletName="<%= PortletKeysExt.PMLHOSOCONGVIEC %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></liferay-portlet:renderURL>';

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm, url);
	}

	function <portlet:namespace />searchData() {
		if (trim(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYMOHSCV %>.value) != "" && 
		!isDate(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYMOHSCV %>.value)) {
			alert('<liferay-ui:message key="pml_nhap_ngay_dung_dinhdang" />');
			return;
		}

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.SOHIEUHSCV %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</c:if>
</script>