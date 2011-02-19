<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.service.persistence.PmlTrangThaiHSCVUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptDisplayTerms"%>
<%@page import="com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptSearch"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>


<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%><script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<script type="text/javascript">
	function selPubPlace()
	{ // Chon don vi gui van ban den. Tra ve ten don vi
		var posX = screen.width / 7;
		var posY = screen.height / 5;
		var widthPopup = 3 * posX;
		var heightPopup = 3 * posY;
	  	var host = location.host;
	  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentreceiptprocess/selpublicplacesearch.jsp";
	  	var mywindow = window.open (path, "mywindow", "status=1,scrollbars=1,width=" + widthPopup + "px, height=" + heightPopup + "px");
	   	mywindow.moveTo(posX , posY);
	}
	function retPubPlace (retVal)
	{ // Ham de popup tra ve gia tri duoc chon
		var obj = document.getElementById("noiphathanh");
		if (obj != null) 
		{
			obj.value = retVal;
		} // end if
	}
	function changeMonthYear() {
		// Ham thay doi ngay thang theo combo box thang, nam
		var monthObj = document.getElementById("monthsearch");
		var yearObj = document.getElementById("yearsearch");
		var tuNgayObj = document.getElementById("HSCV-FROM");
		var denNgayObj = document.getElementById("HSCV-TO");
		// Bo qua ham neu 1 trong cac doi tuong tren khong ton tai
		if (monthObj == null || yearObj == null || tuNgayObj == null || denNgayObj == null) {
			return;
		} // end if
		var month = monthObj.value;
		var year = yearObj.value;
		var tuNgay = "";
		var denNgay = "";
		// Bo qua neu year rong
		if (year == 0) {
			return;
		} // end if
		// Neu khong chon thang, lay dau nam va cuoi nam
		if (month == 0) {
			tuNgay = "01/01/" + year;
			denNgay = "31/12/" + year;
		} else { // Co chon thang, lay dau thang den cuoi thang
			var tmpDay = 31;
			var tmpMonth = "0" + month;
			tuNgay = "01/" + tmpMonth.substring(tmpMonth.length - 2, tmpMonth.length) + "/" + year;
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				tmpDay = 30;
			} else if (month == 2) {
				if (year % 4 == 0) {
					tmpDay = 29;
				} else {
					tmpDay = 28;
				} // end else
			} // end if

			denNgay = tmpDay + "/" + tmpMonth.substring(tmpMonth.length - 2, tmpMonth.length) + "/" + year;
		} // end else
		tuNgayObj.value = tuNgay;
		denNgayObj.value = denNgay;
	}
</script>
<%
	PmlEdmDocumentReceiptSearch searchContainer = (PmlEdmDocumentReceiptSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PmlEdmDocumentReceiptDisplayTerms displayTerms = (PmlEdmDocumentReceiptDisplayTerms) searchContainer.getDisplayTerms();
	String soCVDen = displayTerms.getSoCVDen();
	String soVaoSo = displayTerms.getSoVaoSo();
	String tuNgay = displayTerms.getTuNgay();
	String denNgay = displayTerms.getDenNgay();
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	tuNgay = tuNgay.equals("") ? "01/01/" + year : tuNgay;
	denNgay = denNgay.equals("") ? "31/12/" + year : denNgay;
	long soHSCV = displayTerms.getSoHSCV();
	long loaiCV = displayTerms.getLoaiCV();
	String noiPhatHanh = displayTerms.getNoiPhatHanh();
	long trangThai = displayTerms.getTrangThai();
	String nguoiKy = displayTerms.getNguoiKy();
	String trichYeu = displayTerms.getTrichYeu();
	//thoind add 06022010
	PortletURL portleturlSearch= renderResponse.createRenderURL();
	portleturlSearch.setWindowState(WindowState.NORMAL);
	portleturlSearch.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	String search = portleturlSearch.toString();
%>

<form name="<portlet:namespace />frmSeaInOD">
<table cellspacing="0" width="100%">
	<tr>
		<td width="13%"><liferay-ui:message key="pccc-cvdtn-sohieu" />&nbsp;:</td>
		<td width="35%"><input type="text" name="<portlet:namespace/>socvden" id="textfield" value="<%= soCVDen %>" style="width: 90%;"></td>
		<td width="13%"><liferay-ui:message	key="pccc-cvdtn-socongvan" />&nbsp;:</td>
		<td>
			<select  name="<portlet:namespace/>loaicv" id="select2" style="width: 93%;">
			<option value="0"><liferay-ui:message key="documentreceipt-search-tatca" /></option>
			<%
			// phmphuc close 11/11/2010
			//List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
			//List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
			// end phmphuc update 11/11/2010
			
			/* phmphuc update 16/02/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
			long userIdLogin = PortalUtil.getUserId(renderRequest);
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userIdLogin);		
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
			} catch (Exception e) { }
			
			List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
			if (department != null) {
				pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbden", department.getAgencyId(), year);
			}
			
			int pmlEdmDocumentRecordTypeListSize = pmlEdmDocumentRecordTypeList.size();
			for (int i = 0; i < pmlEdmDocumentRecordTypeListSize; i ++) {
				PmlEdmDocumentRecordType documentRecordType = pmlEdmDocumentRecordTypeList.get(i);
				String selected = loaiCV == documentRecordType.getDocumentRecordTypeId() ? "selected" : "";
				out.print("<option value=\"" + documentRecordType.getDocumentRecordTypeId() + "\" " + selected + ">" + documentRecordType.getDocumentRecordTypeName() + "</option>");
			}
			%>
			</select>
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="pccc-cvdtn-soCVden" />&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>sovaoso" id="textfield2" value="<%= soVaoSo %>" style="width: 90%;"></td>
		<td><liferay-ui:message key="noi-phat-hanh" />&nbsp;:</td>
		<td>
			<input type="text" name="<portlet:namespace/>noiphathanh" id="noiphathanh" style="width: 78%" value="<%= noiPhatHanh %>">
			<input type="button" value=" ... " style="width: 10%" onclick="javascript: selPubPlace();">
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="so-HSCV" />&nbsp;:</td>
		<td>
			<select  name="<portlet:namespace/>sohscv" id="select" style="width: 93%;">
			<option value="0"><liferay-ui:message key="documentreceipt-search-tatca" /></option>
			<%
			List<PmlHoSoCongViec> pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
			int pmlHoSoCongViecSize = pmlHoSoCongViecList.size();
			for (int i = 0; i < pmlHoSoCongViecSize; i ++) {
				PmlHoSoCongViec pmlHoSoCongViec = pmlHoSoCongViecList.get(i);
				String selected = soHSCV == pmlHoSoCongViec.getIdHoSoCongViec() ? "selected" : "";
				out.print("<option value=\"" + pmlHoSoCongViec.getIdHoSoCongViec() + "\" " + selected + ">" + pmlHoSoCongViec.getTieuDe() + "</option>");
			}
			%>
			</select>
		</td>
		<td><liferay-ui:message	key="nguoi-ky" />&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>nguoiky" style="width: 90%;"id="textfield5" value="<%= nguoiKy %>"></td>

	</tr>
	<tr>
		<td><liferay-ui:message key="phat-hanh-trong" />&nbsp;:</td>
		<td>
			<liferay-ui:message key="thang" />&nbsp;
				<select name="<portlet:namespace />monthsearch" id="monthsearch" onchange="changeMonthYear()" style="width: 50px;">
					<option value="0" selected="selected">&nbsp;</option>
					<%
					for (int idx = 1; idx <= 12; idx++) {
					%>
						<option value="<%= idx %>"><%= idx %></option>
					<%
					}
					%>
				</select>	
			<liferay-ui:message key="nam" />&nbsp;
				<select name="<portlet:namespace />yearsearch" id="yearsearch" onchange="changeMonthYear()" style="width: 100px;">
					<option value="0" selected="selected">&nbsp;</option>
					<%
					for (int idx = year - 10; idx <= year; idx++) {
					%>
						<option value="<%= idx %>"><%= idx %></option>
					<%
					}
					%>
				</select>
		</td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="tu-ngay" />&nbsp;:</td>
		<td>
			<input style="width: 81%" type="text" name="<portlet:namespace/>tungay" id="HSCV-FROM" value="<%= tuNgay %>">
			<img align="top" id="cal-button-HSCVFROM" src="/html/images/cal.gif" onclick="callCalendar('HSCV-FROM','cal-button-HSCVFROM')"/>	
		</td>
		<td><liferay-ui:message key="den-ngay" />&nbsp;:</td>
		<td>
			<input style="width: 82%" type="text" name="<portlet:namespace/>denngay" id="HSCV-TO" value="<%= denNgay %>">
			<img align="top" id="cal-button-HSCVTO" src="/html/images/cal.gif" onclick="callCalendar('HSCV-TO','cal-button-HSCVTO')"/>
		</td>
	</tr>
	
	<tr valign="top">
		<td><liferay-ui:message key="trich-yeu" />&nbsp;:</td>
		<td colspan="3"><textarea style="width: 95.5%;" name="<portlet:namespace/>trichyeu" id="textarea" rows="2"><%= trichYeu %></textarea></td>
		
	</tr>
	<tr>
		<td></td>
		<td colspan="3">
			<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="search"/>'>
			<span onclick="javascript:submitForm(document.hrefFm,'<%= search %>');" >
				<input type="button" value='<liferay-ui:message key="back"/>'>
			</span>
		</td>
	</tr>

</table>
</form>