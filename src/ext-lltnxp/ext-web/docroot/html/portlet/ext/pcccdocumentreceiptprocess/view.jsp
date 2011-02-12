<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.service.permission.UserPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>

<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>

<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/quanlycongvan.jsp"></liferay-util:include>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/popupinphieuchuyen.jsp"></liferay-util:include>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<%

	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	String soVanBanDen = ParamUtil.getString(renderRequest, "sovanbanden" , "");
	String soHieuGoc = ParamUtil.getString(renderRequest, "sohieugoc", "");
	int loaiSoVB = ParamUtil.getInteger(renderRequest, "loaisocongvan", 0);
	String issuingplaceId = ParamUtil.getString(renderRequest, "issuingplaceId", "");
	String noiphathanh = ParamUtil.getString(renderRequest, "noiphathanh", "");
	String trichyeu = ParamUtil.getString(renderRequest, "trichyeu", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tungay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denngay", "");
	String ngayhethan = ParamUtil.getString(renderRequest, "ngayhethan", "");
	
    String nguoiXuLy = renderRequest.getAttribute("nguoiXuLy") == null ? "xuLyChung" : (String) renderRequest.getAttribute("nguoiXuLy") ; 
	String tabChung = ParamUtil.getString(renderRequest, "tabChung","rad-letter-process");
	
	String status = "";
	String statusTab = "";
	if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
			(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.TIEPNHANCV) == true)) {
		statusTab = "CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly";
		status = "CVDEN_VANTHU_DANGXULY_CHUNG_vuatiepnhan";
	}
	else {
		statusTab = "CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
		status = "CVDEN_TRUONGPHONG_DANGXULY_CHUNG_chophancong";
	}
	long fileStatusIdTab = PmlFileStatusUtil.findByFileStatusCode(statusTab).get(0).getFileStatusId();
	long vuaTiepNhanId = PmlFileStatusUtil.findByFileStatusCode(status).get(0).getFileStatusId();
	long fileStatusIdHome = ParamUtil.getLong(renderRequest, "statusId", 0);
	// minh update 20110119
	long statusIdDangXuLy = ParamUtil.getLong(renderRequest, "statusIdDangXuLy", 0);
	// end minh update 20110119
	boolean isExpiredHome = ParamUtil.getBoolean(renderRequest, "isExpired", false);
	int year = renderRequest.getAttribute("year") == null ? new Date().getYear() + 1900 : (Integer) renderRequest.getAttribute("year");
	
	//end
    String cachThucXuLy = ParamUtil.getString(renderRequest, "cachThucXuLy", "-1");
    String curPage = ParamUtil.getString(renderRequest, "cur", "1");// minh update 20101110
	if (fileStatusIdHome != 0) {
		fileStatusIdTab = fileStatusIdHome;
	}
	// minh update 20110119	
    if (statusIdDangXuLy != 0) {
    	fileStatusIdTab = statusIdDangXuLy;
    }
   // end minh update 20110119
	String hienTrang = ParamUtil.getString(renderRequest,"hienTrang","dangXuLy");
%>
	<portlet:renderURL var="dangXuLyChungTabURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
		<portlet:param name="statusId" value='<%= "" + fileStatusIdTab %>' />
		<portlet:param name="cachThucXuLy" value='<%= cachThucXuLy %>' />
        <portlet:param name="tabChung" value='rad-letter-process' />
        <portlet:param name="hienTrang" value="dangXuLy" />
        <portlet:param name="isExpired" value="<%= String.valueOf(isExpiredHome) %>" />
        <portlet:param name="cur" value="<%= curPage %>" />
		<portlet:param name="loaisocongvan" value="<%= String.valueOf(loaiSoVB) %>" /> 
        <% if (timkiemtheotieuchi) { %>
		<portlet:param name="sovanbanden" value="<%= soVanBanDen %>" /> 
		<portlet:param name="sohieugoc" value="<%= soHieuGoc %>" /> 
		<portlet:param name="issuingplaceId" value="<%= issuingplaceId %>" /> 
		<portlet:param name="noiphathanh" value="<%= noiphathanh %>" /> 
		<portlet:param name="trichyeu" value="<%= trichyeu %>" /> 
		<portlet:param name="tungay" value="<%= tuNgay %>" /> 
		<portlet:param name="denngay" value="<%= denNgay %>" /> 
		<portlet:param name="ngayhethan" value="<%= ngayhethan %>" /> 
		<% } %>
	</portlet:renderURL>
<%
	PmlFileStatus fileStatus_DXL = null;
	
	try {
		fileStatus_DXL = PmlFileStatusUtil.findByFileStatusCode("CVDEN_DAXULY_CHUNG_daxuly").get(0);
	} catch (Exception e ) {
		fileStatus_DXL = null;
	}
	
	long fileStatusId_DXL=  0;
	if (fileStatus_DXL != null) {
		fileStatusId_DXL = fileStatus_DXL.getFileStatusId();
	}
%>
<portlet:renderURL var="daXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId_DXL) %>" />
	<!-- minh update 20110119 -->
	<portlet:param name="statusIdDangXuLy" value="<%= String.valueOf(fileStatusIdTab) %>" />
	<!-- end minh update 20110119 -->
	<portlet:param name="tabChung" value="rad-letter-do-finish" />
	<portlet:param name="year" value="<%= String.valueOf(year) %>" /> 
	<portlet:param name="cur" value="<%= curPage %>" />
	<portlet:param name="loaisocongvan" value="<%= String.valueOf(loaiSoVB) %>" /> 
	<% if (timkiemtheotieuchi) { %>
	<portlet:param name="sovanbanden" value="<%= soVanBanDen %>" /> 
	<portlet:param name="sohieugoc" value="<%= soHieuGoc %>" /> 
	<portlet:param name="issuingplaceId" value="<%= issuingplaceId %>" /> 
	<portlet:param name="noiphathanh" value="<%= noiphathanh %>" /> 
	<portlet:param name="trichyeu" value="<%= trichyeu %>" /> 
	<portlet:param name="tungay" value="<%= tuNgay %>" /> 
	<portlet:param name="denngay" value="<%= denNgay %>" /> 
	<portlet:param name="ngayhethan" value="<%= ngayhethan %>" /> 
	<% } %>
</portlet:renderURL>

<portlet:renderURL var="nhanQuaMangURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/listdoctemp" />
	<portlet:param name="tabChung" value="rad-letter-network" />
	<portlet:param name="hienTrang" value="vbquamang" />
	<portlet:param name="cur" value="<%= curPage %>" />
	<% if (timkiemtheotieuchi) { %>
	<portlet:param name="sovanbanden" value="<%= soVanBanDen %>" /> 
	<portlet:param name="sohieugoc" value="<%= soHieuGoc %>" /> 
	<portlet:param name="loaisocongvan" value="<%= String.valueOf(loaiSoVB) %>" /> 
	<portlet:param name="issuingplaceId" value="<%= issuingplaceId %>" /> 
	<portlet:param name="noiphathanh" value="<%= noiphathanh %>" /> 
	<portlet:param name="trichyeu" value="<%= trichyeu %>" /> 
	<portlet:param name="tungay" value="<%= tuNgay %>" /> 
	<portlet:param name="denngay" value="<%= denNgay %>" /> 
	<% } %>
</portlet:renderURL>

<script type="text/javascript">
	window.onload = function () 
	{

		if (document.getElementById('<portlet:namespace/>tuNgay') != null) {
			callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay');
		}
		
		if (document.getElementById('<portlet:namespace/>denNgay') != null) {
			callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay');
		}
		
		if (document.getElementById('<portlet:namespace/>ngayHetHan') != null) {
			callCalendar('<portlet:namespace/>ngayHetHan','cal-button-ngayHetHan');
		}
		<% if ("rad-letter-process".equals(tabChung)) { %>	
			<portlet:namespace />docProcess('<%= dangXuLyChungTabURL %>');
			<portlet:namespace />setHiddenStatus('<%= "" + fileStatusIdTab %>', 'false');
			<%
			if (fileStatusIdTab == vuaTiepNhanId) {
				if (isExpiredHome == true) {
			%>
					document.getElementById("<portlet:namespace />congVanDangXuLyChungTreHan1").checked = true;
			<%
				}
				else {
			%>
					document.getElementById("<portlet:namespace />congVanDangXuLyChung1").checked = true;
			<%
				}
			}
			else {
				if (isExpiredHome == true) {
			%>
					document.getElementById("<portlet:namespace />congVanDangXuLyChungTreHan0").checked = true;
			<%
				}
			}
			%>
		<% } else if ("rad-letter-do-finish".equals(tabChung)) { // yenlt update 20101030
		%>
					<portlet:namespace />docFinish('<%= daXuLyURL %>');
		<% 		
			} else {
		%>
					<portlet:namespace />docNetwork('<%= nhanQuaMangURL %>');
		<%  } // end yenlt update 20101030%>
	}	
	</script>

<form action="" name="<portlet:namespace />fm" method="post">
	<input type="hidden" name="<portlet:namespace />statusId" id="<portlet:namespace/>hiddenStatus" value="<%= String.valueOf(fileStatusIdHome) %>"/>
	<input type="hidden" name="<portlet:namespace />hienTrang" id="<portlet:namespace/>hiddenHienTrang" />
	<input type="hidden" name="<portlet:namespace />isExpired" id="<portlet:namespace/>hiddenIsExpired" />
	<input type="hidden" name="<portlet:namespace />nguoiXuLy" id="<portlet:namespace/>hiddenNguoiXuLy" /> <!-- ltyen 24/04/2010 -->
	<input type="hidden" name="<portlet:namespace />timkiemtheotieuchi" id="<portlet:namespace/>timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>" /> <!-- yenlt 20101021 -->
	<input type="hidden" name="<portlet:namespace />tabChung" id="<portlet:namespace/>tabChung" value="<%= tabChung %>"/> <!-- yenlt 20101021 -->
<%
	List<PmlEdmIssuingPlace> issuingPlaceList = new ArrayList<PmlEdmIssuingPlace>();
	try {
		issuingPlaceList = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlaces(-1,-1);
	} catch (Exception e) {
		issuingPlaceList = new ArrayList<PmlEdmIssuingPlace>();
	}
	
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
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	searchURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/list");
	
	PortletURL searchTempURL = renderResponse.createRenderURL();
	searchTempURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	searchTempURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/listdoctemp");
	
	String searchURLString = searchURL.toString();
	String searchTempURLString = searchTempURL.toString();
	%>

<div class="title_categ"><liferay-ui:message key="danh-sach-van-ban-den"/></div>
<div class="boxcontent">

<!-- start form search -->
<fieldset class="filborder">
		<label class="laborder">
		<span class="act_hv" onclick="showhideformsearch()">			
			<liferay-ui:message key="tieu-thuc-tim-kiem"/>			
		</span>
		</label>
<div id="searchform">
		<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"><liferay-ui:message key="so-den-theo-so"/>&nbsp;:</td>
			<td width="35%"><input id="<portlet:namespace/>sovanbanden" name="<portlet:namespace/>sovanbanden" style="width: 90%" type="text" value="<%= soVanBanDen %>" /></td>
			<td width="15%"><liferay-ui:message key="so-ky-hieu-goc"/>&nbsp;:</td>
			<td ><input id="<portlet:namespace/>sohieugoc" name="<portlet:namespace/>sohieugoc" style="width: 90%" type="text" value="<%= soHieuGoc %>" /></td>
		</tr>
		<tr>
			<td ><liferay-ui:message key="nhom-van-ban"/>&nbsp;:</td>
			<td >
				<select name="<portlet:namespace/>loaisocongvan" id="socongvancvdtn" style="width:92%" onchange="changeDocumentRecordType()">
      				<option value="<%=0%>" onclick="setLoaiVanBanToBlank()"></option>
		        	<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
	      				<option value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>" <%=  pmlEdmDocumentRecordType.getDocumentRecordTypeId() == loaiSoVB ? "selected" : "" %>> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
	     			 </logic:iterate>
		      	</select>
			</td>
			<td ><liferay-ui:message key="loai-van-ban"/>&nbsp;:</td>
			<td >
				<select name="<portlet:namespace/>loaivanban" id="loaicongvancvdtn" style="width:92%">
				<% if (0 != loaiSoVB) { 
					List<PmlEdmDocumentType> documentTypeList = new ArrayList<PmlEdmDocumentType>();
					try {
						documentTypeList = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(loaiSoVB);
					} catch (Exception e) {
						documentTypeList = new ArrayList<PmlEdmDocumentType>();
					}
					
					if (!documentTypeList.isEmpty()) {
						PmlEdmDocumentType documentType = documentTypeList.get(0);
				%>
					<option value="<%= String.valueOf(documentType.getDocumentTypeId()) %>" selected="selected">
						<%= documentType.getDocumentTypeName() %></option>
				<%	}
				}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td ><liferay-ui:message key="co-quan"/>&nbsp;:</td>
			<td >
				<div id="divissuingplace" style="width: 87%;float: left;">
					<select name="<portlet:namespace/>issuingplaceId" id="<portlet:namespace/>issuingplaceId" style="width:98%" >
	      				<option value="" <%= "".equals(issuingplaceId) ? "selected" : "" %>></option>
	      				<%
	      					for (int i = 0 ; i < issuingPlaceList.size(); i++) {
	      						PmlEdmIssuingPlace issuing = issuingPlaceList.get(i);
	      				%>
		      				<option value="<%= issuing.getIssuingPlaceId() %>" <%= issuing.getIssuingPlaceId().equals(issuingplaceId) ? "selected" : "" %>> <%= issuing.getIssuingPlaceName() %> </option>
	      				<%
	      					}
	      				%>
			      	</select>
				</div>
				<div id="divnoiphathanh" style="display: none;width: 87%;float: left;">
					<input name="<portlet:namespace/>noiphathanh" id="<portlet:namespace/>noiphathanh" type="text" value="<%= noiphathanh %>" style="width: 95%;"/>
				</div>
				<input style="margin-top: 2px;" type="checkbox" name="<portlet:namespace/>isissuing" id="<portlet:namespace/>ischeck" checked="checked" onclick="changeIssuingplace()">
			</td>
			<td ><liferay-ui:message key="ngay-het-han-xu-ly"/>&nbsp;:</td>
			<td >
				<input style="width: 80%" type="text" name="<portlet:namespace/>ngayhethan" id="<portlet:namespace/>ngayHetHan" value="<%= ngayhethan %>" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-ngayHetHan" onClick="callCalendar('<portlet:namespace/>ngayHetHan','cal-button-ngayHetHan')" />
			</td>
		</tr>
		<tr>
			<td ><liferay-ui:message key="tu-ngay"/>&nbsp;:</td>
			<td >
				<input style="width: 80%" type="text" name="<portlet:namespace/>tungay" id="<portlet:namespace/>tuNgay" value="<%= fromDate %>" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-tuNgay" onClick="callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay')" />
			</td>
			<td ><liferay-ui:message key="den-ngay"/>&nbsp;:</td>
			<td >
				<input style="width: 80%" type="text" name="<portlet:namespace/>denngay" id="<portlet:namespace/>denNgay" value="<%= toDate %>" />
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-denNgay" onClick="callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay')" />
			</td>
		</tr>
		<tr>
			<td ><liferay-ui:message key="trich-yeu"/>&nbsp;:</td>
			<td colspan="3">
				<textarea id="<portlet:namespace/>trichyeu" name="<portlet:namespace/>trichyeu" style="width: 96%;" rows="2" /><%= trichyeu %></textarea>
			</td>
			
		</tr>
		
		</table>
</div>
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"></td>
			<td colspan="3">
			<input style="margin-left: 0;" onclick="checkHienTrang();" type="button" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
			<%
								PmlFileStatus fileStatus_XlT = null;
								
								try {
									fileStatus_XlT = PmlFileStatusUtil.findByFileStatusCode("CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly").get(0);
								} catch (Exception e ) {
									 fileStatus_XlT = null;
								}
								
								long fileStatusIdXLT =  0;
								if (fileStatus_XlT != null) {
									fileStatusIdXLT = fileStatus_XlT.getFileStatusId();
								}
			%>
							
								<portlet:renderURL var="surrogateprocessLDB"	windowState="<%= LiferayWindowState.NORMAL.toString() %>">
									<portlet:param name="struts_action"	value="/sgs/pcccdocumentreceiptprocess/viewxlt" />								
									<portlet:param name="vtxulythayldb" value="true"/>
									<portlet:param name="vtxulythayldvp" value="false"/>
									<portlet:param name="statusId" value="<%= String.valueOf(fileStatusIdXLT) %>" />
								</portlet:renderURL>
								<span onclick="javascript:submitForm(document.hrefFm,'<%= surrogateprocessLDB %>');">
								<input type="button" value="<liferay-ui:message key="nhap-but-phe"/>" />
								</span>
							
							<!-- input type="hidden" name="<portlet:namespace />xulythayldvp" id="xulythayldvp" value="false" /-->							
								<portlet:renderURL var="surrogateprocessLDVP"	windowState="<%= LiferayWindowState.NORMAL.toString() %>">
									<portlet:param name="struts_action"	value="/sgs/pcccdocumentreceiptprocess/viewxlt" />								
									<portlet:param name="vtxulythayldb" value="false"/>
									<portlet:param name="vtxulythayldvp" value="true"/>
									<portlet:param name="statusId" value="<%= String.valueOf(fileStatusIdXLT) %>" />
								</portlet:renderURL>
								<!-- <span onclick="javascript:submitForm(document.hrefFm,'<!%= surrogateprocessLDVP %>');">
								<input type="button" value="<liferay-ui:message key="quanlycongvan-xulythayldvp"/>" />
								</span>-->
			
			</td>
		</tr>
</table>			
</fieldset>

<!-- end form search -->

<div class="table-doc-doc-auto-content-base" >
	<ul class="ultitle">
		<li class="onli1" style="width: 30%;" title="<liferay-ui:message key ="quanlycongvan-congvandangxuly"/>" id="<portlet:namespace />td-letter-process" 
			onClick="<portlet:namespace/>setAllValueToDefault();<portlet:namespace />docProcess('<%= dangXuLyChungTabURL %>&timkiemtheotieuchi=false');
			<portlet:namespace/>congVanDangXuLyChung(0); <portlet:namespace />setHiddenStatus('<%=  String.valueOf(fileStatusIdTab) %>', 'false');">
				<input id="<portlet:namespace />rad-letter-process" type="radio" checked="checked" name="rad_letter" value="">
						<span class="rad-span-letter-base">	<liferay-ui:message key ="quanlycongvan-congvandangxuly"/></span>
		</li>
		<li class="onli01" style="width: 25%;" title="<liferay-ui:message key ='quanlycongvan-congvandaxuly'/>" id="<portlet:namespace />td-letter-do-finish" 
			onClick="<portlet:namespace/>setAllValueToDefault();<portlet:namespace />docFinish('<%= daXuLyURL%>&timkiemtheotieuchi=false');">
				<input id="<portlet:namespace />rad-letter-do-finish" type="radio" name="rad_letter" value="">
					<span class="rad-span-letter-base">	<liferay-ui:message key ='quanlycongvan-congvandaxuly'/></span>
		</li>
		<li class="onli2" style="width: 15%" title="<liferay-ui:message key ='year'/>" id="<portlet:namespace />td-letter-do-finish-year">
			<div id="do-finish-year" style="display: none;">
										<%
											PmlFileStatus fileStatus_DXL_Year = null;
											
											try {
												fileStatus_DXL_Year = PmlFileStatusUtil.findByFileStatusCode("CVDEN_DAXULY_CHUNG_daxuly").get(0);
											} catch (Exception e ) {
												fileStatus_DXL_Year = null;
											}
											
											long fileStatusId_DXL_Year=  0;
											if (fileStatus_DXL_Year != null) {
												fileStatusId_DXL_Year = fileStatus_DXL_Year.getFileStatusId();
											}
										
										%>	
										<portlet:renderURL var="selectedYear" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
											<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
											<portlet:param name="hienTrang" value="daXuLy" />
											<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId_DXL_Year) %>" />
										</portlet:renderURL>
											<span >
												<liferay-ui:message key ='year'/>
											</span>
											<select id="<portlet:namespace />select-letter-do-finish"  name="select-year-letter" size="1"
												onchange="<portlet:namespace/>setAllValueToDefault();viewListDocumentOnChange('<%=selectedYear %>&isExpired=' + document.getElementById('<portlet:namespace/>hiddenIsExpired').value
												+ '&nguoiXuLy=' + document.getElementById('<portlet:namespace/>hiddenNguoiXuLy').value
												);"> <!-- ltyen update 24/04/2010 -->
												<%
													Date currentDate = new Date();
													int currentYear = currentDate.getYear() + 1900;
													for (int i = currentYear - 9; i <= currentYear; i++) {
												%>
												<option value="<%= i %>" <%= year == i ? "selected" : "" %>><%=i %></option>
												<%
													}
												%>
											</select>
			</div>
		</li>
		<li class="onli01" style="width: 26%;" title="<liferay-ui:message key ='quanlycongvan-vanbannhanquamang'/>" id="<portlet:namespace />td-letter-network" 
			onClick="<portlet:namespace/>setAllValueToDefault();<portlet:namespace />docNetwork('<%= nhanQuaMangURL %>&timkiemtheotieuchi=false');">
			<input id="<portlet:namespace />rad-letter-network" type="radio" name="rad_letter_network" value="">
				<span class="rad-span-letter-base">	<liferay-ui:message key ='quanlycongvan-vanbannhanquamang'/></span>
		</li>
	</ul>
</div>
<fieldset class="filborder_divie">
<div class="boxhiden_show">
	<ul id="<portlet:namespace />letter-doc-process">
		<li style="width: 49.5%; margin-right: 0.8%;">
					<fieldset class="filborder">
					<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvanxulychung"/></label>		
						<table width="100%" cellspacing="0" class="bgtablil">										
									<%
									if (dangXuLyChung != null ) {
										List<String> fileStatusCode = new ArrayList<String>();
			
										if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.TIEPNHANCV) == true)) {
											fileStatusCode.add("CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly");
											fileStatusCode.add("CVDEN_VANTHU_DANGXULY_CHUNG_vuatiepnhan");
										} else if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.GIAMDOCREPORT) == true)||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.GIAMDOCREPORT) == true)) {
											fileStatusCode.add("CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly");
											fileStatusCode.add("CVDEN_TRUONGPHONG_DANGXULY_CHUNG_chophancong");
										} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.CHUYENVIENREPORT) == true ||
												PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.CHUYENVIENREPORT) == true) {
											fileStatusCode.add("CVDEN_CHUYENVIEN_DANGXULY_TUXULY_dangxuly");
										}
										
										int fileStatusCodeSize = fileStatusCode.size();
										for (int i = 0; i < fileStatusCodeSize; i ++) {
											PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(i)).get(0);
											long fileStatusId = fileStatus.getFileStatusId();
											String fileStatusName = fileStatus.getFileStatusName();
									%>
											<portlet:renderURL var="dangXuLyChungURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="hienTrang" value="dangXuLy" /> <!-- yenlt update 09/04/2010 -->
												<portlet:param name="isExpired" value="false" />
												<portlet:param name="nguoiXuLy" value="xuLyChung" /><!-- yenlt update 20101026 -->
												<!-- minh update 20100417 -->
												<portlet:param name="tabChung" value='rad-letter-process' />
												<portlet:param name="cachThucXuLy" value='<%= cachThucXuLy %>' />
												<!-- end minh update 20100417 -->
											</portlet:renderURL>
											<portlet:renderURL var="dangXuLyChungTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="true" />
												<portlet:param name="hienTrang" value="dangXuLy" /> <!-- yenlt update 09/04/2010 -->
												<portlet:param name="nguoiXuLy" value="xuLyChung" /><!-- yenlt update 20101026 -->
												<!-- minh update 20100417 -->
												<portlet:param name="tabChung" value='rad-letter-process' />
												<portlet:param name="cachThucXuLy" value='<%= cachThucXuLy %>' />
												<!-- end minh update 20100417 -->
											</portlet:renderURL>
											<tr class="<%= (i % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
												<td onclick="<portlet:namespace/>congVanDangXuLyChung(<%= i %>);<portlet:namespace/>setAllValueToDefault();viewListDocument('<%= dangXuLyChungURL %>');<portlet:namespace />setHiddenStatus('<%= "" + fileStatus.getFileStatusId() %>', 'false');">
													<input checked="checked" type="radio" id="<portlet:namespace />congVanDangXuLyChung<%= i %>" name="<portlet:namespace />congVanChon" value="<%= String.valueOf(fileStatus.getFileStatusId()) %>">
													<span>
														<%= fileStatusName  %>
													</span>
												</td>
												<td onClick="<portlet:namespace/>congVanDangXuLyChungTreHan('<%= i %>');<portlet:namespace/>setAllValueToDefault();<portlet:namespace />setHiddenStatus('<%= "" + fileStatus.getFileStatusId() %>', 'true'); viewListDocument('<%= dangXuLyChungTreHanURL %>');">
													<input type="radio" id="<portlet:namespace />congVanDangXuLyChungTreHan<%= i %>" name="<portlet:namespace />congVanChon">
													<span>
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
					<fieldset class="filborder">
					<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvantuxuly"/></label>	
						<table class="bgtablil" width="100%" cellspacing="0">
									<%
									if (dangXuLyTuXuLy != null) {
										
										List<String> fileStatusCode = new ArrayList<String>();
			
										if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.TIEPNHANCV) == true)) {
											fileStatusCode.add("CVDEN_VANTHU_DANGXULY_TUXULY_dangxuly");
										} else if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.GIAMDOCREPORT) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.TRUONGPHONGREPORT) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.GIAMDOCREPORT) == true)) {
											fileStatusCode.add("CVDEN_TRUONGPHONG_DANGXULY_TUXULY_dangxuly");
										} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.CHUYENVIENREPORT) == true ||
												PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_wul3", ActionKeysExt.CHUYENVIENREPORT) == true) {
											fileStatusCode.add("CVDEN_CHUYENVIEN_DANGXULY_TUXULY_dangxuly");
										}
										
										int fileStatusCodeSize = fileStatusCode.size();
										for (int j = 0; j < fileStatusCodeSize; j ++) {
											PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(j)).get(0);
											long fileStatusId = fileStatus.getFileStatusId();
											String fileStatusName = fileStatus.getFileStatusName();
									%>
											<portlet:renderURL var="dangXuLyTuXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="hienTrang" value="dangXuLy" /> <!-- yenlt update 09/04/2010 -->
												<portlet:param name="isExpired" value="false" />
												<portlet:param name="nguoiXuLy" value="tuXuLy" /><!-- yenlt update 20101026 -->
												<!-- minh update 20100417 -->
												<portlet:param name="tabChung" value='rad-letter-process' />
												<portlet:param name="cachThucXuLy" value='<%= cachThucXuLy %>' />
												<!-- end minh update 20100417 -->
											</portlet:renderURL>
											<portlet:renderURL var="dangXuLyTuXuLyTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="true" />
												<portlet:param name="hienTrang" value="dangXuLy" /> <!-- yenlt update 09/04/2010 -->
												<portlet:param name="nguoiXuLy" value="tuXuLy" /><!-- yenlt update 20101026 -->
												<!-- minh update 20100417 -->
												<portlet:param name="tabChung" value='rad-letter-process' />
												<portlet:param name="cachThucXuLy" value='<%= cachThucXuLy %>' />
												<!-- end minh update 20100417 -->
											</portlet:renderURL>
											<tr class="<%= (j % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
												<td onclick="<portlet:namespace/>congVanDangXuLyTuXuLy(<%=j %>); <portlet:namespace/>setAllValueToDefault();viewListDocument('<%= dangXuLyTuXuLyURL %>');<portlet:namespace />setHiddenStatus('<%= "" + fileStatus.getFileStatusId() %>', 'false');">
													<input type="radio" id="<portlet:namespace />congVanDangXuLyTuXuLy<%= j %>" name="<portlet:namespace />congVanChon">
													<span>
														<%= fileStatusName  %>																		  
													</span>																		
												</td>
												<td onclick="<portlet:namespace />congVanDangXuLyTuXuLyTreHan('<%= j %>');<portlet:namespace/>setAllValueToDefault();<portlet:namespace />setHiddenStatus('<%= "" + fileStatus.getFileStatusId() %>', 'true'); viewListDocument('<%= dangXuLyTuXuLyTreHanURL %>');">
													<input type="radio" id="<portlet:namespace />congVanDangXuLyTuXuLyTreHan<%= j %>" name="<portlet:namespace />congVanChon">
													<span>
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
	<ul  style="display:none;" id="<portlet:namespace />letter-doc-finish">
		<li style="width: 49.5%; margin-right: 0.8%;">
		<fieldset class="filborder">
					<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvanxulychung"/></label>
					<table width="100%" cellspacing="0" class="bgtablil">
									
									<%
									if (daXuLyChung != null) {
										List<String> fileStatusCode = new ArrayList<String>();
										fileStatusCode.add("CVDEN_DAXULY_CHUNG_daxuly");
										int fileStatusCodeSize = fileStatusCode.size();
										for (int k = 0; k < fileStatusCodeSize; k ++) {
											PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(k)).get(0);
											long fileStatusId = fileStatus.getFileStatusId();
											String fileStatusName = fileStatus.getFileStatusName();
									%>
											<portlet:renderURL var="daXuLyChungURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="false" />
												<portlet:param name="hienTrang" value="daXuLy" />
												<portlet:param name="nguoiXuLy" value="xuLyChung" /> <!-- yenlt 09/04/2010 -->
												<portlet:param name="tabChung" value="rad-letter-do-finish" />
												<portlet:param name="timkiemtheotieuchi" value="false" />
											</portlet:renderURL>
											<portlet:renderURL var="daXuLyChungTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%= "" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="true" />
												<portlet:param name="hienTrang" value="daXuLy" />
												<portlet:param name="nguoiXuLy" value="xuLyChung" /> <!-- yenlt 09/04/2010 -->
												<portlet:param name="tabChung" value="rad-letter-do-finish" />
												<portlet:param name="timkiemtheotieuchi" value="false" />
											</portlet:renderURL>
											<tr class="<%= (k % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
												<td onclick="<portlet:namespace/>congDaVanXuLyChung(<%= k %>);<portlet:namespace/>setAllValueToDefault(); viewListDocumentYear('<%=daXuLyChungURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%= "" + fileStatus.getFileStatusId() %>', 'false','xuLyChung');">
													<input type="radio" id="<portlet:namespace />congDaVanXuLyChung<%= k %>" name="<portlet:namespace />congVanChon">
													<span>
														<%= fileStatusName %>
													</span>
												</td>
												<td onclick="<portlet:namespace />congVanDaXuLyChungTreHan('<%= k %>'); <portlet:namespace/>setAllValueToDefault();viewListDocumentYear('<%= daXuLyChungTreHanURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%="" + fileStatus.getFileStatusId() %>', 'true','xuLyChung');">
													<input type="radio" id="<portlet:namespace />congVanDaXuLyChungTreHan<%= k %>" name="<portlet:namespace />congVanChon">
													<span>
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
		<li style="width: 49.6%;">
			<fieldset class="filborder">
					<label class="laborder"><liferay-ui:message key ="quanlycongvan-congvantuxuly"/></label>
					<table width="100%" cellspacing="0" class="bgtablil">
								
									<%
									if (daXuLyTuXuLy != null) {
										
										List<String> fileStatusCode = new ArrayList<String>();
										fileStatusCode.add("CVDEN_DAXULY_TUXULY_daxuly");
										//end
										int fileStatusCodeSize = fileStatusCode.size();
										for (int n = 0; n < fileStatusCodeSize; n ++) {
											PmlFileStatus fileStatus = PmlFileStatusUtil.findByFileStatusCode(fileStatusCode.get(n)).get(0);
											long fileStatusId = fileStatus.getFileStatusId();
											String fileStatusName = fileStatus.getFileStatusName();
									%>
											<portlet:renderURL var="daXuLyTuXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%="" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="false" />
												<portlet:param name="hienTrang" value="daXuLy" />
												<portlet:param name="nguoiXuLy" value="tuXuLy" /> <!-- yenlt 09/04/2010 -->
												<portlet:param name="tabChung" value="rad-letter-do-finish" />
												<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
											</portlet:renderURL>
											<portlet:renderURL var="daXuLyTuXuLyTreHanURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
												<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
												<portlet:param name="statusId" value='<%="" + fileStatus.getFileStatusId() %>' />
												<portlet:param name="isExpired" value="true" />
												<portlet:param name="hienTrang" value="daXuLy" />
												<portlet:param name="nguoiXuLy" value="tuXuLy" /> <!-- yenlt 09/04/2010 -->
												<portlet:param name="tabChung" value="rad-letter-do-finish" />
												<portlet:param name="timkiemtheotieuchi" value="false" /> <!-- yenlt update 20101023 -->
											</portlet:renderURL>
											<tr class="<%=(n % 2) == 0 ? "tr_tab1" : "tr_tab2" %>">
												<td onclick="<portlet:namespace/>congVanDaXuLyTuXuLy(<%=n %>);<portlet:namespace/>setAllValueToDefault(); viewListDocumentYear('<%=daXuLyTuXuLyURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%="" + fileStatus.getFileStatusId() %>', 'false','tuXuLy');">
													<input type="radio" id="<portlet:namespace />congVanDaXuLyTuXuLy<%=n %>" name="<portlet:namespace />congVanChon">
													<span>
														<%=fileStatusName %>
													</span>																		
												</td>
												<td onclick="<portlet:namespace />congVanDaXuLyTuXuLyTreHan('<%=n %>');<portlet:namespace/>setAllValueToDefault(); viewListDocumentYear('<%=daXuLyTuXuLyTreHanURL %>');<portlet:namespace />setHiddenStatusDaXuLy('<%="" + fileStatus.getFileStatusId() %>', 'true','tuXuLy');">
													<input type="radio" id="<portlet:namespace />congVanDaXuLyTuXuLyTreHan<%=n %>" name="<portlet:namespace />congVanChon">
													<span>
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
<div id="<portlet:namespace/>listdocument" class="listdoctempRe"></div>
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
<%	} if ("delete".equalsIgnoreCase(transition) && !"vbquamang".equals(hienTrang)) { %>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-xoa-thanh-cong'/>");
		</script>
<%	} if ("save".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-luu-thanh-cong'/>");
		</script>
<%	} 

	renderRequest.getPortletSession().setAttribute("transition",null,PortletSession.APPLICATION_SCOPE);
%>
<script type="text/javascript">
	function checkHienTrang() {
	 hienTrangOnlick = window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value;
		if ("vbquamang" == hienTrangOnlick) {
			getParamForListDocumentAction('<%= searchTempURLString %>');
		} else {
			getParamForListDocumentAction('<%= searchURLString %>');
		}
	}
</script>