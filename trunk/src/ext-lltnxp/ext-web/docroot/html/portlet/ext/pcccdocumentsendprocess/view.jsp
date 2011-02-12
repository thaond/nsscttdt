<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/quanlycongvandi.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%
	String curPage = ParamUtil.getString(renderRequest, "cur", "1");// minh update 20101110
	// yenlt update 20101023
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	String soKyHieu = ParamUtil.getString(renderRequest, "soKyHieu" , "");
	long loaiVB = ParamUtil.getLong(renderRequest, "loaisocongvan", 0);
	String donViSoanThao = ParamUtil.getString(renderRequest, "donViSoanThao", "");
	String nguoiKy = ParamUtil.getString(renderRequest, "nguoiKy", "");
	String trichYeu = ParamUtil.getString(renderRequest, "trichYeu", "");
	String coQuanNhan = ParamUtil.getString(renderRequest, "coQuanNhan", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tuNgay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denNgay", "");

	// end yenlt update 20101023
	String tabChung = ParamUtil.getString(renderRequest, "tabChung","rad-letter-process");
	String status = "";
	String statusTab = "";
	if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV) == true)) {
		statusTab = "CVDI_VANTHU_DANGXULY_CHUNG_dangxuly";
		status = "CVDI_VANTHU_DANGXULY_CHUNG_vuatiepnhan";
	}
	else {
		statusTab = "CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
		status = "CVDI_TRUONGPHONG_DANGXULY_CHUNG_chophancong";
	}
	long fileStatusIdTab = PmlFileStatusUtil.findByFileStatusCode(statusTab).get(0).getFileStatusId();
	long vuaTiepNhanId = PmlFileStatusUtil.findByFileStatusCode(status).get(0).getFileStatusId();
	long fileStatusIdHome = ParamUtil.getLong(renderRequest, "statusId", 0);
	boolean isExpiredHome = renderRequest.getAttribute("isExpired") == null ? false : (Boolean) renderRequest.getAttribute("isExpired");
	int year = renderRequest.getAttribute("year") == null ? new Date().getYear() + 1900 : (Integer) renderRequest.getAttribute("year");
	if (fileStatusIdHome != 0) {
		fileStatusIdTab = fileStatusIdHome;
	}
%>
<portlet:renderURL var="dangXuLyChungTabURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="statusId" value='<%= "" + fileStatusIdTab %>' />
	<portlet:param name="tabChung" value='rad-letter-process' />
	<portlet:param name="isExpired" value="<%= String.valueOf(isExpiredHome) %>" />
	<portlet:param name="hienTrang" value="dangXuLy" />
	<portlet:param name="cur" value="<%= curPage %>" />
	<portlet:param name="loaisocongvan" value="<%= String.valueOf(loaiVB) %>" /> 
	<% if (timkiemtheotieuchi) { %>
	<portlet:param name="soKyHieu" value="<%= soKyHieu %>" /> 
	<portlet:param name="donViSoanThao" value="<%= donViSoanThao %>" /> 
	<portlet:param name="nguoiKy" value="<%= nguoiKy %>" /> 
	<portlet:param name="trichYeu" value="<%= trichYeu %>" /> 
	<portlet:param name="coQuanNhan" value="<%= coQuanNhan %>" /> 
	<portlet:param name="tuNgay" value="<%= tuNgay %>" /> 
	<portlet:param name="denNgay" value="<%= denNgay %>" /> 
	<% } %>
</portlet:renderURL>
<%
PmlFileStatus fileStatus_DXL = null;

try {
	fileStatus_DXL = PmlFileStatusUtil.findByFileStatusCode("CVDI_DAXULY_CHUNG_daxuly").get(0);
} catch (Exception e ) {
	fileStatus_DXL = null;
}

long fileStatusId_DXL=  0;
if (fileStatus_DXL != null) {
	fileStatusId_DXL = fileStatus_DXL.getFileStatusId();
}
%>
<portlet:renderURL var="daXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId_DXL) %>" />
	<portlet:param name="tabChung" value="rad-letter-do-finish" />
	<!--portlet:param name="isExpired" value="</%= String.valueOf(isExpiredHome) %>" /--> <!-- yenlt close 26052010 -->
	<portlet:param name="year" value="<%= String.valueOf(year) %>" /> <!-- yenlt update 22/04/2010 -->
	<portlet:param name="cur" value="<%= curPage %>" />
	<portlet:param name="loaisocongvan" value="<%= String.valueOf(loaiVB) %>" /> 
	<% if (timkiemtheotieuchi) { %>
	<portlet:param name="soKyHieu" value="<%= soKyHieu %>" /> 
	<portlet:param name="donViSoanThao" value="<%= donViSoanThao %>" /> 
	<portlet:param name="nguoiKy" value="<%= nguoiKy %>" /> 
	<portlet:param name="trichYeu" value="<%= trichYeu %>" /> 
	<portlet:param name="coQuanNhan" value="<%= coQuanNhan %>" /> 
	<portlet:param name="tuNgay" value="<%= tuNgay %>" /> 
	<portlet:param name="denNgay" value="<%= denNgay %>" /> 
	<% } %>
</portlet:renderURL>

<script type="text/javascript">
window.onload = function () {
	if (document.getElementById('<portlet:namespace/>tuNgay') != null) {
		callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay');
	}
	
	if (document.getElementById('<portlet:namespace/>denNgay') != null) {
		callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay');
	}
	
	<% if ("rad-letter-process".equals(tabChung)) { %>	
		<portlet:namespace />docSendProcess('<%= dangXuLyChungTabURL %>');
		<portlet:namespace />setHiddenStatus('<%= "" + fileStatusIdTab %>', 'false');
		<%
		if (fileStatusIdTab == vuaTiepNhanId) {
			if (isExpiredHome == true) {
		%>
				if (document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan1") != null) {
				document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan1").checked = true;
				}
		<%
			}
			else {
		%>
				if (document.getElementById("<portlet:namespace />congVanDiDangXuLyChung1") != null) {
				document.getElementById("<portlet:namespace />congVanDiDangXuLyChung1").checked = true;
				}
		<%
			}
		}
		else {
			if (isExpiredHome == true) {
		%>
				if (document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan0") != null) {
				document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan0").checked = true;
				}
		<%
			}
			else {
		%>
				if (document.getElementById("<portlet:namespace />congVanDiDangXuLyChung0") != null) {
				document.getElementById("<portlet:namespace />congVanDiDangXuLyChung0").checked = true;
				}
		<%
			}
		}
		%>
	<% } else { %>	
		<portlet:namespace />docSendFinish('<%= daXuLyURL %>');
	<% } %>
}
 
</script>

<form action="" name="<portlet:namespace />frmQuanLyCongVanDi" method="post">
<div class="title_categ"><liferay-ui:message key="danh-sach-van-ban-di"/></div>
<div class="boxcontent">
<fieldset class="filborder">
		<label class="laborder">
		<span class="act_hv" onclick="showhideformsearch()">			
			<liferay-ui:message key="tieu-thuc-tim-kiem"/>			
		</span>
		</label>
<!-- start form search -->
<%
	List<PmlEdmDocumentType> pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
	try {
		// phmphuc close 11/11/2010
		//pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentTypes(-1, -1);
		pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
		// end phmphuc update 11/11/2010
	} catch (Exception e) {
		pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
	}

	List<Department> departments = new ArrayList<Department>();
	try {
		departments = DepartmentLocalServiceUtil.getDepartments(-1, -1);
	} catch (Exception e) {
		departments = new ArrayList<Department>();
	}

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	searchURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/list");
	String searchURLString = searchURL.toString();
	
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	int yearSearch = calendar.get(Calendar.YEAR);
	
	String fromDate = "01/01/" + yearSearch;
	String toDate = "31/12/" + yearSearch;
	if (!"".equals(tuNgay) && !"".equals(denNgay)) {
		fromDate = tuNgay;
		toDate = denNgay;
	} 
%>
<div id="searchform">
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"><liferay-ui:message key="loai-van-ban"/>&nbsp;:</td>
			<td width="35%">
				<select name="<portlet:namespace/>loaisocongvan" id="<portlet:namespace/>loaiVB" style="width: 92%">
      				<option value="<%= 0 %>" ></option>
		        	<% if (!pmlEdmDocumentTypeList.isEmpty()) { 
		        		for (PmlEdmDocumentType pmlEdmDocumentType : pmlEdmDocumentTypeList) { %>
	      				<option value="<%= pmlEdmDocumentType.getDocumentTypeId() %>" <%=  pmlEdmDocumentType.getDocumentTypeId() == loaiVB ? "selected" : "" %>> <%= pmlEdmDocumentType.getDocumentTypeName() %> </option>
	     			<% 	} 
	     				}%>
		      	</select>
			</td>
			<td width="15%"><liferay-ui:message key="so-ky-hieu"/>&nbsp;:</td>
			<td ><input id="<portlet:namespace/>soKyHieu" name="<portlet:namespace/>soKyHieu" style="width: 90%" type="text" value="<%= soKyHieu %>" /></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="don-vi-soan-thao" />&nbsp;:</td>
			<td>
				<select name="<portlet:namespace />donViSoanThao" id="<portlet:namespace/>donViSoanThao" style="width: 92%">
					<option value=""></option>
					<%
					if (!departments.isEmpty()) {
						for (int idx = 0; idx < departments.size(); idx ++) {
							Department depItem = (Department) departments.get(idx);
					%>
							<option value="<%= depItem.getDepartmentsId() %>" <%= depItem.getDepartmentsId().equals(donViSoanThao) ? "selected" : ""%>><%= depItem.getDepartmentsName() %></option>
					<%
						}
					}
					%>
				</select>
			</td>
			<td><liferay-ui:message key="nguoi-ky"/>&nbsp;:</td>
			<td ><input id="<portlet:namespace/>nguoiKy" name="<portlet:namespace/>nguoiKy" style="width: 90%" type="text" value="<%= nguoiKy %>" /></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="tu-ngay"/>&nbsp;:</td>
			<td>
				<input type="text" name="<portlet:namespace/>tuNgay" id="<portlet:namespace/>tuNgay" value="<%= fromDate %>" style="width: 80%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-tuNgay" onClick="callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay')" />
			</td>
			<td><liferay-ui:message key="den-ngay"/>&nbsp;:</td>
			<td >
				<input type="text" name="<portlet:namespace/>denNgay" id="<portlet:namespace/>denNgay" value="<%= toDate %>" style="width: 80%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-denNgay" onClick="callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay')" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="co-quan-nhan"/>&nbsp;:</td>
			<td><input name="<portlet:namespace/>coQuanNhan" id="<portlet:namespace/>coQuanNhan"style="width: 90%" type="text" value="<%= coQuanNhan %>" /></td>
			<td>&nbsp;</td>
			<td ></td>
		</tr>

		<tr>					
			<td >
				<liferay-ui:message key="trich-yeu"/>:&nbsp;
			</td>			
			<td colspan="3">
				<textarea id="<portlet:namespace/>trichYeu" name="<portlet:namespace/>trichYeu" style="width: 96%" rows="2" /><%= trichYeu %></textarea>
			</td>
		</tr>
	</table>	
	<!-- end form search -->
</div>
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"></td>
			<td colspan="3">
				<span onclick="getParamForListDocumentAction('<%= searchURLString %>');">
				<input style="margin-left: 0;" type="button" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
			</span>
				<%
						// minh update 20100304
						PmlFileStatus fileStatus_XlT = null;
								
						try {
							fileStatus_XlT = PmlFileStatusUtil.findByFileStatusCode("CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly").get(0);
						} catch (Exception e ) {
							 fileStatus_XlT = null;
						}
								
						long fileStatusIdXLT =  0;
						if (fileStatus_XlT != null) {
							fileStatusIdXLT = fileStatus_XlT.getFileStatusId();
						}
						// end
					%>
					
							<portlet:renderURL var="surrogateprocessLDB"	windowState="<%= LiferayWindowState.NORMAL.toString() %>">
								<portlet:param name="struts_action"	value="/sgs/pcccdocumentsendprocess/viewxlt" />								
								<portlet:param name="vtxulythayldb" value="true"/>
								<portlet:param name="vtxulythayldvp" value="false"/>
								<portlet:param name="statusId" value="<%= String.valueOf(fileStatusIdXLT) %>" />
							</portlet:renderURL>
								
							<span onclick="javascript:submitForm(document.hrefFm,'<%= surrogateprocessLDB %>');">
									<input type="button"  value='<liferay-ui:message key="nhap-but-phe"/>' >
							</span>

								<portlet:renderURL var="surrogateprocessLDVP"	windowState="<%= LiferayWindowState.NORMAL.toString() %>">
									<portlet:param name="struts_action"	value="/sgs/pcccdocumentsendprocess/viewxlt" />								
									<portlet:param name="vtxulythayldb" value="false"/>
									<portlet:param name="vtxulythayldvp" value="true"/>
									<portlet:param name="statusId" value="<%= String.valueOf(fileStatusIdXLT) %>" />
								</portlet:renderURL>
								<!-- <span onclick="javascript:submitForm(document.hrefFm,'<%= surrogateprocessLDVP %>');">
									<input type="button"  value='<liferay-ui:message key="quanlycongvan-xulythayldvp"/>' >
								</span>-->
			</td>
		</tr>
</table>
</fieldset>
<div class="table-doc-doc-auto-content-base">
					<ul class="ultitle">
						<li class="onli1" style="width: 35%;" title="<liferay-ui:message key ="quanlycongvan-congvandangxuly"/>" id="<portlet:namespace />td-letter-process" 
							onclick="<portlet:namespace/>setAllValueToDefault();<portlet:namespace />docSendProcess('<%= dangXuLyChungTabURL %>&timkiemtheotieuchi=false');">
							<input id="<portlet:namespace />rad-letter-process" type="radio" checked="checked" name="rad_letter" value="">
							<span class="rad-span-letter-base">
								<liferay-ui:message key ="quanlycongvan-congvandangxuly"/>
							</span>
						</li>
						<li class="onli01" style="width: 35%;" title="<liferay-ui:message key ='quanlycongvan-congvandaxuly'/>"  id="<portlet:namespace />td-letter-do-finish" 
							onclick="<portlet:namespace/>setAllValueToDefault();<portlet:namespace />docSendFinish('<%= daXuLyURL%>&timkiemtheotieuchi=false');">						
							<input id="<portlet:namespace />rad-letter-do-finish" type="radio" name="rad_letter" value="">
							<span class="rad-span-letter-base">
								<liferay-ui:message key ='quanlycongvan-congvandaxuly'/>
							</span>
						</li>
						<li class="onli2" style="width: 27%;" title="<liferay-ui:message key ='year'/>" id="<portlet:namespace />td-letter-do-finish-year">
							<div id="do-finish-year" style="display: none;">	
								<%
									PmlFileStatus fileStatus_DXL_Year = null;
									
									try {
										fileStatus_DXL_Year = PmlFileStatusUtil.findByFileStatusCode("CVDI_DAXULY_CHUNG_daxuly").get(0);
									} catch (Exception e ) {
										fileStatus_DXL_Year = null;
									}
									
									long fileStatusId_DXL_Year=  0;
									if (fileStatus_DXL_Year != null) {
										fileStatusId_DXL_Year = fileStatus_DXL_Year.getFileStatusId();
									}
							
								%>	
								<portlet:renderURL var="selectedYear" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
									<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
									<portlet:param name="hienTrang" value="daXuLy" />
									<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId_DXL_Year) %>" />
								</portlet:renderURL>
								<span class="rad-span-letter-base">
									<liferay-ui:message key ='year'/>
								</span>
								<select id="<portlet:namespace />select-letter-do-finish"  name="select-year-letter" size="1"
									onchange="<portlet:namespace/>setAllValueToDefault();viewListDocumentSendOnChange('<%=selectedYear.toString() %>&isExpired=' + document.getElementById('<portlet:namespace/>hiddenIsExpired').value
									+ '&nguoiXuLy=' + document.getElementById('<portlet:namespace/>hiddenNguoiXuLy').value
									);"> <!-- ltyen update 24/04/2010 -->
									<%
										Date currentDate = new Date();
										int currentYear = currentDate.getYear() + 1900;
										for (int i = currentYear - 9; i <= currentYear; i++) {
									%>
									<option value="<%= i %>" <%= year == i ? "selected" : "" %>><%=i %></option>
									<!-- option value="<\%=i %>"><\%=i %></option> --> <!-- yenlt close 22/04/2010 -->
									<%
										}
									%>
									<!--option selected="selected" value="<\%=currentYear %>"><\%=currentYear %></option> <!-- yenlt close 22/04/2010 -->
								</select>
							</div>
		</li>
	</ul>
</div>
					
<!-- Phan cho nhung trang thai -->
					<fieldset class="filborder_divie">
					<div class="boxhiden_show">
					<ul id="<portlet:namespace />letter-doc-process">
					<li style="width: 49.5%; margin-right: 0.8%;">
						<!-- Cong van dang xu ly && xu ly chung -->
						<!-- ltyen 24/04/2010 -->
						<input type="hidden" name="<portlet:namespace />statusId" id="<portlet:namespace />hiddenStatus" />
						<input type="hidden" name="<portlet:namespace />hienTrang" id="<portlet:namespace />hiddenHienTrang" />
						<input type="hidden" name="<portlet:namespace />isExpired" id="<portlet:namespace />hiddenIsExpired" />
						<input type="hidden" name="<portlet:namespace />nguoiXuLy" id="<portlet:namespace/>hiddenNguoiXuLy" /> <!-- ltyen end 24/04/2010 -->
						<input type="hidden" name="<portlet:namespace />timkiemtheotieuchi" id="<portlet:namespace/>timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>"/><!-- yenlt 20101021 -->
						<input type="hidden" name="<portlet:namespace />tabChung" id="<portlet:namespace/>tabChung" value="<%= tabChung %>"/> <!-- yenlt 20101021 -->
						<fieldset class="filborder">
						<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvanxulychung"/></label>		
						<table width="100%" cellspacing="0" class="bgtablil">	
						
						<%
						if (congVanDiDangXuLyChung != null) {
							List<String> fileStatusCode = new ArrayList<String>();

							if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV) == true) {		
								fileStatusCode.add("CVDI_VANTHU_DANGXULY_CHUNG_dangxuly");
								fileStatusCode.add("CVDI_VANTHU_DANGXULY_CHUNG_vuatiepnhan");			
							} else if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
									(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.GIAMDOCREPORT) == true)) {
								fileStatusCode.add("CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly");
								fileStatusCode.add("CVDI_TRUONGPHONG_DANGXULY_CHUNG_chophancong");
							} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.CHUYENVIENREPORT) == true) {
								fileStatusCode.add("CVDI_CHUYENVIEN_DANGXULY_TUXULY_dangxuly");
							}
							
							int fileStatusCodeSize = fileStatusCode.size();
							for (int i = 0; i < fileStatusCodeSize; i ++) {
								PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(i)).get(0);
								long fileStatusId = fileStatus.getFileStatusId();
								String fileStatusName = fileStatus.getFileStatusName();
								
						%>
						<portlet:renderURL var="congVanDiDangXuLyChungURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%=String.valueOf(fileStatusId ) %>' />
							<portlet:param name="isExpired" value="false" />
							<portlet:param name="tabChung" value='rad-letter-process' />
							<portlet:param name="nguoiXuLy" value="xuLyChung" /><!-- yenlt update 20101026 -->
						</portlet:renderURL>
						<portlet:renderURL var="congVanDiDangXuLyChungTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%=String.valueOf(fileStatusId ) %>' />
							<portlet:param name="isExpired" value="true" />
							<portlet:param name="tabChung" value='rad-letter-process' />
							<portlet:param name="nguoiXuLy" value="xuLyChung" /><!-- yenlt update 20101026 -->
						</portlet:renderURL>
						<tr class="<%=(i % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
							<td onclick="<portlet:namespace/>congVanDiDangXuLyChung('<%=i %>'); <portlet:namespace/>setAllValueToDefault();viewListDocumentSend('<%=congVanDiDangXuLyChungURL %>');<portlet:namespace />setHiddenStatus('<%=String.valueOf(fileStatusId ) %>', 'false');">
								<input type="radio" id="<portlet:namespace />congVanDiDangXuLyChung<%=i %>" name="<portlet:namespace />congVanDiChon">
								<span class="span-list-letter">
									<%=fileStatusName %>
								</span>
							</td>
							<td onclick="<portlet:namespace />congVanDiDangXuLyChungTreHan('<%=i %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSend('<%=congVanDiDangXuLyChungTreHanURL %>');<portlet:namespace />setHiddenStatus('<%=String.valueOf(fileStatusId ) %>', 'true');">
								<input type="radio" id="<portlet:namespace />congVanDiDangXuLyChungTreHan<%=i %>" name="<portlet:namespace />congVanDiChon" value="">
								<span class="span-list-letter">
									<liferay-ui:message key ="quanlycongvan-congvantrehan"/>
								</span>
							</td>
						</tr>
						<%
								}
							}
						%>
						</table>
						</fieldset>
			
						</li>
						
						<li style="width:49.6%;">
						
						<!-- Cong van dang xu ly && Tu xu ly -->
						<fieldset class="filborder">
						<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvantuxuly"/></label>	
						<table class="bgtablil" width="100%" cellspacing="0">
						
						<%	
						if (congVanDiDangXuLyTuXuLy != null) {
							List<String> fileStatusCode = new ArrayList<String>();

							if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV) == true)) {
								fileStatusCode.add("CVDI_VANTHU_DANGXULY_TUXULY_dangxuly");
							} else if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
									(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.GIAMDOCREPORT) == true)) {
								fileStatusCode.add("CVDI_TRUONGPHONG_DANGXULY_TUXULY_dangxuly");
							} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.CHUYENVIENREPORT) == true) {
								fileStatusCode.add("CVDI_CHUYENVIEN_DANGXULY_TUXULY_dangxuly");
							}
							
							int fileStatusCodeSize = fileStatusCode.size();
							for (int j = 0; j < fileStatusCodeSize; j ++) {
								PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(j)).get(0);
								long fileStatusId = fileStatus.getFileStatusId();
								String fileStatusName = fileStatus.getFileStatusName();
						%>
						<portlet:renderURL var="congVanDiDangXuLyTuXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="false" />
							<portlet:param name="tabChung" value='rad-letter-process' />
							<portlet:param name="nguoiXuLy" value="tuXuLy" /><!-- yenlt update 20101026 -->
						</portlet:renderURL>
						<portlet:renderURL var="congVanDiDangXuLyTuXuLyTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="true" />
							<portlet:param name="tabChung" value='rad-letter-process' />
							<portlet:param name="nguoiXuLy" value="tuXuLy" /><!-- yenlt update 20101026 -->
						</portlet:renderURL>
						<tr class="<%=(j % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
							<td onclick="<portlet:namespace />congVanDiDangXuLyTuXuLy('<%=j %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSend('<%=congVanDiDangXuLyTuXuLyURL %>');<portlet:namespace />setHiddenStatus('<%= String.valueOf(fileStatusId) %>', 'false');">
								<input type="radio" id="<portlet:namespace />congVanDiDangXuLyTuXuLy<%=j %>" name="<portlet:namespace />congVanDiChon" value="<%= String.valueOf(fileStatusId) %>">
								<span class="span-list-letter">
									<%=fileStatusName %>																		  
								</span>																		
							</td>
							<td onclick="<portlet:namespace />congVanDiDangXuLyTuXuLyTreHan('<%=j %>'); <portlet:namespace/>setAllValueToDefault();viewListDocumentSend('<%=congVanDiDangXuLyTuXuLyTreHanURL %>');<portlet:namespace />setHiddenStatus('<%= String.valueOf(fileStatusId) %>', 'true');">
								<input type="radio" id="<portlet:namespace />congVanDiDangXuLyTuXuLyTreHan<%=j %>" name="<portlet:namespace />congVanDiChon" value="">
								<span class="span-list-letter">
									<liferay-ui:message key ="quanlycongvan-congvantrehan"/>
								</span>
							</td>
						</tr>
						
						<%
								}
							}
						%>
						
						</table>
						</fieldset>
					</li>
					</ul>
					
					<ul style="display:none;" id="<portlet:namespace />letter-doc-finish" >
					<li style="width: 49.5%; margin-right: 0.8%;">
						
						<!-- Cong van da xu ly && xu ly chung -->
						<fieldset class="filborder">
						<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvanxulychung"/></label>
						<table width="100%" cellspacing="0" class="bgtablil">
						
						<%
						if (congVanDiDaXuLyChung != null) {
							List<String> fileStatusCode = new ArrayList<String>();
							int fileStatusCodeSize = fileStatusCode.size();
							for (int k = 0; k < fileStatusCodeSize; k ++) {
								PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(k)).get(0);
								long fileStatusId = fileStatus.getFileStatusId();
								String fileStatusName = fileStatus.getFileStatusName();
						%>
						<portlet:renderURL var="congVanDiDaXuLyChungURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="false" />
							<portlet:param name="hienTrang" value="daXuLy" />
							<portlet:param name="nguoiXuLy" value="xuLyChung" /> <!-- yenlt 09/04/2010 -->
							<portlet:param name="tabChung" value="rad-letter-do-finish" />
							<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
						</portlet:renderURL>
						<portlet:renderURL var="congVanDiDaXuLyChungTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="true" />
							<portlet:param name="hienTrang" value="daXuLy" />
							<portlet:param name="nguoiXuLy" value="xuLyChung" /> <!-- yenlt 09/04/2010 -->
							<portlet:param name="tabChung" value="rad-letter-do-finish" />
							<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
						</portlet:renderURL>
						<tr class="<%=(k % 2) == 0 ? "tr_tab1" : "t_tab2" %>">
							<td onclick="<portlet:namespace />congVanDiDaXuLyChung('<%=k %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSendYear('<%=congVanDiDaXuLyChungURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%= String.valueOf(fileStatusId) %>', 'false','xuLyChung');">
								<input checked="checked" type="radio" id="<portlet:namespace />congVanDiDaXuLyChung<%=k %>" name="<portlet:namespace />congVanDiChon" value="<%= String.valueOf(fileStatusId) %>">
								<span class="span-list-letter">
									<%=fileStatusName %>
								</span>
							</td>
							<td onclick="<portlet:namespace />congVanDiDaXuLyChungTreHan('<%=k %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSendYear('<%=congVanDiDaXuLyChungTreHanURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%= String.valueOf(fileStatusId) %>', 'true','xuLyChung');">
								<input type="radio" id="<portlet:namespace />congVanDiDaXuLyChungTreHan<%=k %>" name="<portlet:namespace />congVanDiChon" value="">
								<span class="span-list-letter">
									<liferay-ui:message key ="quanlycongvan-congvantrehan"/>
								</span>
							</td>
						</tr>
						
						<%
								}
							}
						%>
						
						</table>
						</fieldset>
						</li>
						
						<li style="width: 49.6%">
						
						<!-- Cong van da xu ly && tu xu ly -->
						<fieldset class="filborder">
						<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvantuxuly"/></label>
						<table width="100%" cellspacing="0" class="bgtablil">
						
						<%
						if (congVanDiDaXuLyTuXuLy != null) {
							List<String> fileStatusCode = new ArrayList<String>();
							fileStatusCode.add("CVDI_DAXULY_TUXULY_daxuly"); //yenlt update 09/04/2010
							
							int fileStatusCodeSize = fileStatusCode.size();
							for (int n = 0; n < fileStatusCodeSize; n ++) {
								PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(n)).get(0);
								long fileStatusId = fileStatus.getFileStatusId();
								String fileStatusName = fileStatus.getFileStatusName();
						%>
						<portlet:renderURL var="congVanDiDaXuLyTuXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="false" />
							<portlet:param name="hienTrang" value="daXuLy" />
							<portlet:param name="nguoiXuLy" value="tuXuLy" /> <!-- yenlt 09/04/2010 -->
							<portlet:param name="tabChung" value="rad-letter-do-finish" />
							<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
						</portlet:renderURL>
						<portlet:renderURL var="congVanDiDaXuLyTuXuLyTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
							<portlet:param name="statusId" value='<%= String.valueOf(fileStatusId) %>' />
							<portlet:param name="isExpired" value="true" />
							<portlet:param name="hienTrang" value="daXuLy" />
							<portlet:param name="nguoiXuLy" value="tuXuLy" /> <!-- yenlt 09/04/2010 -->
							<portlet:param name="tabChung" value="rad-letter-do-finish" />
							<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
						</portlet:renderURL>
						<tr class="<%=(n % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
							<td onclick="<portlet:namespace />congVanDiDaXuLyTuXuLy('<%=n %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSendYear('<%=congVanDiDaXuLyTuXuLyURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%= String.valueOf(fileStatusId) %>', 'false','tuXuLy');">
								<input type="radio" id="<portlet:namespace />congVanDiDaXuLyTuXuLy<%=n %>" name="<portlet:namespace />congVanDiChon" value="<%= String.valueOf(fileStatusId) %>">
								<span class="span-list-letter">
									<%=fileStatusName %>
								</span>																		
							</td>
							<td onclick="<portlet:namespace />congVanDiDaXuLyTuXuLyTreHan('<%=n %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentSendYear('<%=congVanDiDaXuLyTuXuLyTreHanURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%= String.valueOf(fileStatusId) %>', 'true','tuXuLy');">
								<input type="radio" id="<portlet:namespace />congVanDiDaXuLyTuXuLyTreHan<%=n %>" name="<portlet:namespace />congVanDiChon" value="">
								<span class="span-list-letter">
									<liferay-ui:message key ="quanlycongvan-congvantrehan"/>
								</span>
							</td>
						</tr>
						
						<%
								}
							}
						%>
						</table>
						</fieldset>
				</li>
			</ul>
			</div>
		</fieldset>
<div id="<portlet:namespace/>listdocumentsend"></div>
</div>
</form>

<%
	String transitionBack = (String) renderRequest.getAttribute("transitionBack");
	String transition = (String) renderRequest.getPortletSession().getAttribute("transition",PortletSession.APPLICATION_SCOPE);
	if (transitionBack != null && transitionBack.trim().length() > 0 ) {
		transition = null;
	}
	if ("transition".equalsIgnoreCase(transition)) {
%>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-chuyen-thanh-cong'/>");
		</script>
<%	} if ("update".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-sua-thanh-cong'/>");
		</script>	
<%	} if ("delete".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-xoa-thanh-cong'/>");
		</script>
<%	} if ("return".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript" >	
		alert("<liferay-ui:message key='pcccdocumentreceipt-tra-thanh-cong'/>");
		</script>
<%	}
	renderRequest.getPortletSession().setAttribute("transition",null,PortletSession.APPLICATION_SCOPE);
%>
