<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.signer.model.Signer"%>
<%@page import="com.sgs.portlet.signer.service.SignerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendSearch"%>
<%@page import="com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendDisplayTerms"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>

<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pmlUserUtilClient.js'></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<%
PmlEdmDocumentSendSearch searchContainerSend = (PmlEdmDocumentSendSearch)request.getAttribute("liferay-ui:search:searchContainer");
PmlEdmDocumentSendDisplayTerms displayTerms = (PmlEdmDocumentSendDisplayTerms)searchContainerSend.getDisplayTerms();
//thoind add 06022010
PortletURL portleturlSearch= renderResponse.createRenderURL();
portleturlSearch.setWindowState(WindowState.NORMAL);
portleturlSearch.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/view");
String search = portleturlSearch.toString();
//end
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	
	// Doc danh sach tat ca nguoi dung co quyen ky van ban
	List<Signer> signers = SignerLocalServiceUtil.getAll();
	List<Long> signerIds = new ArrayList<Long>();
	if (!signers.isEmpty()) {
		for (Signer signer : signers) {
			signerIds.add(signer.getUserId());
		}
	}
%>
<table cellspacing="0" width="100%">
	<tr style="display: none;">
		<td width="13%">
			<label><liferay-ui:message key="pccc-cvdtn-tatca"/>:</label>
	   		<input type="radio" name="<portlet:namespace /><%= displayTerms.NUMOFDIRECTOR %>" value="3" checked="checked" >
		</td>
		<td width="35%">	
			<label><liferay-ui:message key="vb-phat-hanh-cua-giam-doc"/>:</label>
	   		<input type="radio" name="<portlet:namespace /><%= displayTerms.NUMOFDIRECTOR %>" 
	   				value="1" <%= displayTerms.getNumOfDirector() == 1 ? "checked" : "" %>>
		</td>
		<td colspan="2">	
			<label><liferay-ui:message key="vb-phat-hanh-cua-phong-ban"/>:</label>
	   		<input type="radio" name="<portlet:namespace /><%= displayTerms.NUMOFDIRECTOR %>" id="numofdepartment"
					value="2" <%= displayTerms.getNumOfDirector() == 2 ? "checked" : ""%>>
		</td>
	</tr>
	
	<tr>
		<td width="13%"><liferay-ui:message key="so-phat-hanh" />&nbsp;:</td>
		<td width="35%">
			<input style="width: 90%;" type="text" name="<portlet:namespace /><%= displayTerms.SO_PHAT_HANH %>" value="<%= HtmlUtil.escape(displayTerms.getSoPhatHanh()) %>" id="textfield">
		</td>
		<td width="13%"><liferay-ui:message key="loai-cong-van" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.LOAI_CONG_VAN %>" id="select2" style="width: 93%;">
    		<option <%=(displayTerms.getLoaiCongVan() == 0 ? "selected" : "" )%> value="0"><liferay-ui:message key="documentreceipt-search-tatca" /></option>
				<%
				// phmphuc close 11/11/2010
				// List<PmlEdmDocumentType> allDocTypes = PmlEdmDocumentTypeUtil.findAll();
				List<PmlEdmDocumentType> allDocTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
				// end phmphuc update 11/11/2010
				if (!allDocTypes.isEmpty()) { // Co danh sach
					// Duyet danh sach
					for (int idx = 0; idx < allDocTypes.size(); idx ++) {
						PmlEdmDocumentType DTItem = (PmlEdmDocumentType) allDocTypes.get(idx);
						String selDesc = (displayTerms.getLoaiCongVan() == DTItem.getDocumentTypeId() ? "selected" : "" );
						out.println("<option " + selDesc + " value=\"" + String.valueOf(DTItem.getDocumentTypeId()) + "\">" + DTItem.getDocumentTypeName() + "</option>");
					}
				}
				%>
    	</select>
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="phong-soan-thao" />&nbsp;:</td>
		<td>
			<select style="width: 93%;" name="<portlet:namespace /><%= displayTerms.PHONG_SOAN_THAO %>" id="select3" onchange="<portlet:namespace />changeEditorDepartment();">
			<option <%=(displayTerms.getPhongSoanThao().equals("") ? "selected" : "" )%> value=""><liferay-ui:message key="documentreceipt-search-tatca" /></option>
				<%-- xuancong close, cach nay ko dung duoc khi goi trang tu render ko qua action
			<logic:iterate id="pmlDepartment" name="pmlDepartmentList" indexId="i" type="com.sgs.portlet.onedoor.model.PmlDepartment"  >				
     		 	<option <%=(displayTerms.getPhongSoanThao().equals(pmlDepartment.getDepartmentsId()) ? "selected" : "" )%> value="<%= pmlDepartment.getDepartmentsId()%>"><%= pmlDepartment.getDepartmentsName() %></option>
     		 </logic:iterate>	
				--%>
				<%
				// Doc ra List roi xuat ra option thay cho logic:iterate
				List<Department> allDeps = DepartmentUtil.findAll();
				if (!allDeps.isEmpty()) { // Co danh sach
					// Duyet danh sach
					for (int idx = 0; idx < allDeps.size(); idx ++) {
						Department depItem = (Department) allDeps.get(idx);
						String selDesc = (displayTerms.getPhongSoanThao().equals(depItem.getDepartmentsId()) ? "selected" : "");
						out.println("<option " + selDesc + " value=\"" + depItem.getDepartmentsId() + "\">" + depItem.getDepartmentsName() + "</option>");
					}
				}
				%>
    	</select>
		</td>
		<td><liferay-ui:message key="noi-nhan" />&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace /><%= displayTerms.NOI_NHAN %>" value="<%= HtmlUtil.escape(displayTerms.getNoiNhan()) %>" id="textfield2" style="width: 90%;">	</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="receipt.creator" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.NGUOI_SOAN_THAO %>" id="creatorId" style="width: 93%;">
				<option value="0"><liferay-ui:message key="documentreceipt-search-tatca" /></option>
			</select>
		</td>
		<td><liferay-ui:message key="nguoi-ky" />&nbsp;:</td>
		<td>
			<input type="text" name="<portlet:namespace /><%= displayTerms.NGUOI_KY %>" value="<%= HtmlUtil.escape(displayTerms.getNguoiKy()) %>" style="width: 90%;">
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="so-HSCV" />&nbsp;:</td>
		<td>
			<select  name="<portlet:namespace /><%= displayTerms.SO_HSCV %>" id="select" style="width: 93%;">
      	<option <%=(displayTerms.getSoHSCV()== 0 ? "selected" : "" )%> value="0"><liferay-ui:message key="documentreceipt-search-tatca" /></option>
				<%-- xuancong close, cach nay ko dung duoc khi goi trang tu render ko qua action
      	<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >      		
        	<option <%=(displayTerms.getSoHSCV()== pmlHoSoCongViec.getIdHoSoCongViec() ? "selected" : "" )%> value="<%= pmlHoSoCongViec.getIdHoSoCongViec()%>"><%= pmlHoSoCongViec.getTieuDe() %></option>
        </logic:iterate>	
				--%>
				<%
				// Doc ra List roi xuat ra option thay cho logic:iterate
				List<PmlHoSoCongViec> allHSCVs = PmlHoSoCongViecUtil.findAll();
				if (!allHSCVs.isEmpty()) { // Co danh sach
					// Duyet danh sach
					for (int idx = 0; idx < allHSCVs.size(); idx ++) {
						PmlHoSoCongViec HSCVItem = (PmlHoSoCongViec) allHSCVs.get(idx);
						String selDesc = (displayTerms.getSoHSCV()== HSCVItem.getIdHoSoCongViec() ? "selected" : "");
						out.println("<option " + selDesc + " value=\"" + String.valueOf(HSCVItem.getIdHoSoCongViec()) + "\">" + HSCVItem.getTieuDe() + "</option>");
					}
				}
				%>
      </select>
		</td>
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
			<label><liferay-ui:message key="nam" />&nbsp;</label>
			<select name="<portlet:namespace />yearsearch" id="yearsearch" onchange="changeMonthYear()" style="width: 80px;">
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
	</tr>
	<tr>
		<td><liferay-ui:message key="tu-ngay" />&nbsp;:</td>
		<%
		String tuNgay = "01/01/" + year;
		%>
		<td>
			<input style="width: 80%;" type="text" name="<portlet:namespace /><%= displayTerms.TU_NGAY %>" value='<%= (!"".equals(displayTerms.getTuNgay()) ? displayTerms.getTuNgay(): tuNgay) %>' id="HSCV-TU">
			<img align="top" id="cal-button-HSCVTU" src="/html/images/cal.gif" onclick="callCalendar('HSCV-TU','cal-button-HSCVTU')"/>
		</td>
		<td><liferay-ui:message key="den-ngay" />&nbsp;:</td>
		<%
		String denNgay = "31/12/" + year;
		%>
		<td>
			<input style="width: 80%;"  type="text" name="<portlet:namespace /><%= displayTerms.DEN_NGAY %>" value='<%= (!"".equals(displayTerms.getDenNgay()) ? displayTerms.getDenNgay(): denNgay) %>' id="HSCV-DEN">
			<img align="top" id="cal-button-HSCVDEN" src="/html/images/cal.gif" onclick="callCalendar('HSCV-DEN','cal-button-HSCVDEN')"/>
		</td>
	</tr>
	
  <tr>
	    <td style="display: none;"><label><liferay-ui:message key="tra-loi-cong-van-so" /></label></td>
		<td style="display: none;">
			<input type="text" name="<portlet:namespace /><%= displayTerms.TRA_LOI_CONG_VAN_SO %>" value="<%= HtmlUtil.escape(displayTerms.getTraLoiCongVanSo()) %>" id="textfield5" style="width: 163px;">
		</td>
		<td ></td>
		<td ></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="trich-yeu" />&nbsp;:</td>
		<td colspan="3"><textarea style="width: 96%" name="<portlet:namespace /><%= displayTerms.TRICH_YEU %>"  id="textarea" rows="2"><%= HtmlUtil.escape(displayTerms.getTrichYeu()) %></textarea></td>
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

<script type="text/javascript">
	function changeMonthYear() {
		// Ham thay doi ngay thang theo combo box thang, nam
		var monthObj = document.getElementById("monthsearch");
		var yearObj = document.getElementById("yearsearch");
		var tuNgayObj = document.getElementById("HSCV-TU");
		var denNgayObj = document.getElementById("HSCV-DEN");
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

	// Thay doi danh sach nguoi soan thao theo phong ban
	function <portlet:namespace />changeEditorDepartment() {
		var depObj = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.PHONG_SOAN_THAO %>;
		var editorObj = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGUOI_SOAN_THAO %>;
		
		// Bo tat ca phan tu cua nguoi soan thao, chi giu lai phan tu dau tien
		editorObj.length = 1;
		pmlUserUtilClient.getPmlUserByDepartmentId(depObj.value, function(data) {
			if (data != null) {
				idxSelected = 0;
				for (idx = 0; idx < data.length; idx ++) {
					// Bo qua nguoi dung da bi xoa
					if (data[idx].screenName == "") {
						continue;
					}
					// Them option
					objNew = document.createElement("option");
					objNew.value = data[idx].userId;
					objNew.text = data[idx].lastName + " " + data[idx].middleName + " " + data[idx].firstName;
					editorObj.options[editorObj.options.length] = objNew;
					if ("<%= displayTerms.getNguoiSoanThao() %>" == data[idx].userId) {
						// Chon nguoi dung dang tim kiem
						idxSelected = editorObj.options.length - 1;
					}
				}
				// Chon muc
				editorObj.selectedIndex = idxSelected;
			}
		});
	}

	// ***** Mac dinh doi changeEditorDepartment sau khi nap form *****
	window.onload = function() {
		<portlet:namespace />changeEditorDepartment();
	}
</script>