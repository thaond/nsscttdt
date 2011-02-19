<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.document.receipt.InvalidExtendProcessException"%>
<head>
	<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
	<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
	<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
</head>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>

<%
	// Lay ra ma so cua van ban den va ma so dong log can gia han
	long documentReceiptId = ParamUtil.getLong(request, "documentReceiptId");
	long docRecLogId = ParamUtil.getLong(request, "docRecLogId");
	long userId = PortalUtil.getUserId(renderRequest);
	SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy");

	if (documentReceiptId <= 0 || docRecLogId <= 0) return;
	// Lay doi tuong van ban den
	PmlEdmDocumentReceipt docRec = null;
	try {
		docRec = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
	}
	catch (Exception ex) {
		System.out.println("Khong xac dinh duoc van ban den trong trang viewextend.jsp");
		return;
	}
	// Lay doi tuong log can hieu chinh cua van ban den
	PmlDocumentReceiptLog docRecLog = null;
	try {
		docRecLog = PmlDocumentReceiptLogUtil.findByPrimaryKey(docRecLogId);
	}
	catch (Exception ex) {
		System.out.println("Khong xac dinh duoc log cua van ban den trong trang viewextend.jsp");
		return;
	}
	String cmd = ParamUtil.getString(request, Constants.CMD, "");
	// ********** Phan khai bao cac bien luu cac gia tri nhap tren form trong truong hop luu database that bai **********
	String extendReason = ""; // Li do gia han
	int numDayProcessAft = 0; // So ngay gia han sau
	String limitDateAft = ""; // Ngay het han sau gia han (trong database luu Date)
	boolean leanOnLimitDate = false; // Luu tru dua vao ngay het han xu ly
	
	// ********** Lay lai gia tri nhap tren form neu them database that bai **********
	String docRecExtendAUFlag = ""; // Flag them, sua thanh cong hay that bai
	
	docRecExtendAUFlag = request.getAttribute("DocRecExtendAUFlag") == null ? "" : 
			String.valueOf(request.getAttribute("DocRecExtendAUFlag"));
	if (docRecExtendAUFlag.equals("fail")) { // Them, sua that bai
		extendReason = ParamUtil.getString(request, "extendReason");
		numDayProcessAft = ParamUtil.getInteger(request, "numDayProcessAft");
		limitDateAft = ParamUtil.getString(request, "limitDateAft");
		leanOnLimitDate = ParamUtil.getBoolean(request, "leanOnLimitDate");
	}

%>

<form action="<portlet:actionURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/viewextend" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm">
<div class="boxcontent">
	<input type="hidden" name="<portlet:namespace />documentReceiptId" value="<%= documentReceiptId %>" />
	<input type="hidden" name="<portlet:namespace />documentReceiptLogId" value="<%= docRecLogId %>" />
	<input type="hidden" name="<portlet:namespace /><%= Constants.CMD %>" />
	<input type="hidden" name="<portlet:namespace />redirect" value='<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/viewextend" /><portlet:param name="documentReceiptId" value="<%= String.valueOf(documentReceiptId) %>" /><portlet:param name="docRecLogId" value="<%= String.valueOf(docRecLogId) %>" /></portlet:renderURL>'/>
	<liferay-ui:error exception="<%= InvalidExtendProcessException.class %>" message="values-relate-not-valid-to-extend" />
	<fieldset class="filborder">
	<legend class="laborder"><liferay-ui:message key="information-summary-document-receipt-need-extend"/></legend>
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td class="td-left" width="20%"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
				<td class="td-right" width="30%"><%= docRec.getDocumentReference() %></td>
				<td class="td-left" width="17%"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>: </label></td>
				<td class="td-right" width="33%"><%= docRec.getNumberDocumentReceipt() %></td>
			</tr>
			<tr>
				<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>: </label></td>
				<td class="td-right">
					<%
					// Lay ten noi phat hanh
					String issPlaName = "";
					if (docRec.getIssuingPlaceId().length() > 0) { 
						try {
							issPlaName = PmlEdmIssuingPlaceUtil.findByPrimaryKey(docRec.getIssuingPlaceId()).getIssuingPlaceName();
						}
						catch (Exception ex) {
							System.out.println("Khong lay duoc don vi:" + docRec.getIssuingPlaceId());
						}
					}
					else {
						issPlaName = docRec.getIssuingPlaceOtherName();
					}
					out.println(issPlaName);
					%>
				</td>
				<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>: </label></td>
				<td class="td-right">
					<%= docRec.getIssuingDate() != null ? sDFormat.format(docRec.getIssuingDate()) : "" %>
				</td>
			</tr>
			<tr>
				<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>: </label></td>
				<td class="td-right" ><%= docRec.getBriefContent() %></td>
				<td class="td-left">&nbsp;</td>
				<td class="td-right" >&nbsp;</td>
			</tr>
			<tr>
				<td class="td-left"><label><liferay-ui:message key="pccc-TN-phongbanthulychinh"/>: </label></td>
				<td class="td-right">
					<%
					// Lay ten phong xu ly chinh
					String mainProcDepName = "";
					if (docRec.getMainDepartmentProcessId().length() > 0) {
						try {
							mainProcDepName = DepartmentUtil.findByPrimaryKey(docRec.getMainDepartmentProcessId()).getDepartmentsName();
						}
						catch (Exception ex) {
							System.out.println("Khong doc duoc phong ban:" + docRec.getMainDepartmentProcessId());
						}
					}
					out.println(mainProcDepName);
					%>
				</td>
				<td class="td-left" ><label><liferay-ui:message key="pccc-TN-nguoithulychinh"/>: </label></td>
				<td class="td-right">
					<%
					// Lay ten nguoi xu ly chinh
					String mainProcUserName = "";
					if (docRec.getMainUserProcessId() > 0) {
						try {
							PmlUser tmpUser = PmlUserUtil.findByPrimaryKey(docRec.getMainUserProcessId());
							mainProcUserName = tmpUser.getLastName() + " " + tmpUser.getMiddleName() + " " + tmpUser.getFirstName();
						}
						catch (Exception ex) {
							System.out.println("Khong xac dinh duoc nguoi dung:" + String.valueOf(docRec.getMainUserProcessId()));
						}
					}
					out.println(mainProcUserName);
					%>
				</td>
			</tr>
			
			<tr>
				<td class="td-left"><label><liferay-ui:message key="date-start-process"/>: </label></td>
				<td class="td-right">
					<%= docRecLog.getSendDateBefore() != null ? sDFormat.format(docRecLog.getSendDateBefore()) : sDFormat.format(docRecLog.getDateProcess()) %>
					<input type="hidden" name="<portlet:namespace />startProcessDate" 
								value="<%= docRecLog.getSendDateBefore() != null ? sDFormat.format(docRecLog.getSendDateBefore()) : sDFormat.format(docRecLog.getDateProcess()) %>" />
				</td>
				<td class="td-left"><label><liferay-ui:message key="limit-date"/>: </label></td>
				<td class="td-right"><span style="color: #FF5A00;font-weight: bold;">
					<%= docRecLog.getExpiredDate() != null ? sDFormat.format(docRecLog.getExpiredDate()) : "" %>
					&nbsp;
					<%
					if (docRecLog.getNumDateProcess() > 0) {
					%>
						(<%= docRecLog.getNumDateProcess() %>&nbsp;<liferay-ui:message key="ngay" />)
					<%
					}
					%></span>
					<input type="hidden" name="<portlet:namespace />numDayProcessBef" value="<%= docRecLog.getNumDateProcess() %>" />
					<input type="hidden" name="<portlet:namespace />limitDateBef" value="<%= docRecLog.getExpiredDate() != null ? sDFormat.format(docRecLog.getExpiredDate()) : "" %>" />
				</td>
			</tr>
			<tr>
				<td class="td-left"><label><liferay-ui:message key="before-extend"/></label></td>
				<td class="td-right">&nbsp;</td>
				<td class="td-left">&nbsp;</td>
				<td class="td-right" >&nbsp;</td>
			</tr>
		</table>
	</fieldset>
	<fieldset class="filborder">
	<legend class="laborder"><liferay-ui:message key="extend-process"/></legend>
			<table cellspacing="0" width="100%">
				<%
				// Lay ma so phong, ten phong, ten nguoi dung
				String depId = ""; // Ma so phong ban
				String depName = ""; // Ten phong ban
				String userName = ""; // Ten nguoi dung
				try {
					PmlUser curUser = PmlUserUtil.findByPrimaryKey(userId);
					userName = curUser.getLastName() + " " + curUser.getMiddleName() + " " + curUser.getFirstName();
					depId = curUser.getDepartmentsId();
					depName = DepartmentUtil.findByPrimaryKey(depId).getDepartmentsName();
				}
				catch (Exception ex) {
					depId = "";
					depName = "";
					userName = "";
				}
				
				%>
				<tr>
					<td width="20%" class="td-left"><label><liferay-ui:message key="person-extend"/>:</label></td>
					<td colspan="3" class="td-right">
						<%= userName %>
						<input type="hidden" name="<portlet:namespace />extendUserId" value="<%= userId %>" />
					</td>
					
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="department-extend"/>:</label></td>
					<td colspan="3" class="td-right">
						<%= depName %>
						<input type="hidden" name="<portlet:namespace />extendDepartmentId" value="<%= depId %>" />
					</td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="date-start-process"/>:</label></td>
					<td class="td-right" colspan="3">
						<%= docRecLog.getSendDateBefore() != null ? sDFormat.format(docRecLog.getSendDateBefore()) : "" %>
					</td>
				</tr>
				<tr>
					<td class="td-left">
						<label><liferay-ui:message key="reason-extend"/></label>
						<font color="red">(*)</font>:
					</td>
					<td class="td-right" colspan="3">
						<textarea name="<portlet:namespace />extendReason" rows="3" style="width: 98%;"><%= extendReason %></textarea>
					</td>
				</tr>
				<tr>
					<td class="td-left">
						<label><liferay-ui:message key="extend-process"/></label>
						<font color="red">(*)</font>:
					</td>
					<td class="td-right" colspan="3">
						<input type="checkbox" name="<portlet:namespace />leanOnLimitDate" <%= leanOnLimitDate == true ? "checked" : "" %> onclick="<portlet:namespace />changeByLeanOnLimitDate();" />
						&nbsp;
						<liferay-ui:message key="account-by-date-expire-process" />
					</td>
				</tr>
				<tr>
					<td class="td-left">&nbsp;</td>
					<td class="td-right" >
						<input type="text" name="<portlet:namespace />numDayProcessAft" style="width: 80px;" maxlength="2" value="<%= numDayProcessAft %>" />
						&nbsp;
						<liferay-ui:message key="ngay" />
					</td>
					<td class="td-right" colspan="2">
						<input type="text" id="limitDate" name="<portlet:namespace />limitDateAft" style="width: 100px;" maxlength="10" value="<%= limitDateAft %>" />
						&nbsp;(dd/mm/yyyy)
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-img-limitdate" onclick="callCalendar('limitDate', 'cal-img-limitdate');" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td >
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="extend-process" />" onclick="<portlet:namespace />saveNewExtend();" />
						<input type="button" value="<liferay-ui:message key="close" />" onclick="window.close(); opener.location.reload();" />
					</td>
			</tr>
			</table>
		</fieldset>
</div>
</form>

<script language="javascript">
	/**
	 * Thay doi gia tri cac control phu hop voi checkbox leanOnLimitDate
	 */
	function <portlet:namespace />changeByLeanOnLimitDate() {
		var objChk = document.<portlet:namespace />fm.<portlet:namespace />leanOnLimitDate;
		if (objChk.checked == true) {
			// Disabled control de nhap so ngay
			document.<portlet:namespace />fm.<portlet:namespace />numDayProcessAft.disabled = true;
			// Enabled cac control de chon ngay
			document.<portlet:namespace />fm.<portlet:namespace />limitDateAft.disabled = false;
			document.getElementById("cal-img-limitdate").style.display = "inherit";
		}
		else {
			// Disabled cac control de chon ngay
			document.<portlet:namespace />fm.<portlet:namespace />limitDateAft.disabled = true;
			document.getElementById("cal-img-limitdate").style.display = "none";
			// Enabled control de nhap so ngay
			document.<portlet:namespace />fm.<portlet:namespace />numDayProcessAft.disabled = false;
		}
	}
	/**
	 * Xu ly su kien khi nap man hinh
	 */
	window.onload = function () {
		// Goi ham thay doi gia tri cac control phu hop voi checkbox leanOnLimitDate
		<portlet:namespace />changeByLeanOnLimitDate();
		// Goi ham de co the su dung calendar
		if (document.getElementById('limitDate') != null) {
			callCalendar('limitDate', 'cal-img-limitdate');
		}
	};
	/**
	 * Kiem tra gia tri nhap vao tren form de luu gia han
	 */
	function <portlet:namespace />doCheckInput() {
		// ***** Kiem tra ma so van ban, ma so log, ngay bat dau, so ngay xu ly va han xu ly, nguoi dung, phong ban truoc gia han *****
		var showAlertInvalid = false; // Hien thi alert hay khong
		var objExam = null;
		// Kiem tra ma so van ban den
		objExam = document.<portlet:namespace />fm.<portlet:namespace />documentReceiptId;
		if (!isIntegerPositiveNumeric(objExam.value)) showAlertInvalid = true;
		// Kiem tra ma so log van ban den
		objExam = document.<portlet:namespace />fm.<portlet:namespace />documentReceiptLogId;
		if (!isIntegerPositiveNumeric(objExam.value)) showAlertInvalid = true;
		// Kiem tra ngay bat dau
		objExam = document.<portlet:namespace />fm.<portlet:namespace />startProcessDate;
		if (!isDate(objExam.value)) showAlertInvalid = true;
		// Kiem tra so ngay xu ly truoc khi gia han
		objExam = document.<portlet:namespace />fm.<portlet:namespace />numDayProcessBef;
		if (!isIntegerPositiveNumeric(objExam.value)) showAlertInvalid = true;
		// Kiem tra han xu ly truoc khi gia han
		objExam = document.<portlet:namespace />fm.<portlet:namespace />limitDateBef;
		if (!isDate(objExam.value)) showAlertInvalid = true;
		// Kiem tra ma so nguoi dung
		objExam = document.<portlet:namespace />fm.<portlet:namespace />extendUserId;
		if (!isIntegerPositiveNumeric(objExam.value)) showAlertInvalid = true;
		// Kiem tra ma so phong ban
		objExam = document.<portlet:namespace />fm.<portlet:namespace />extendDepartmentId;
		if (trim(objExam.value) == "") showAlertInvalid = true;
		// Xuat thong bao khong hop le
		if (showAlertInvalid == true) {
			alert("<liferay-ui:message key='values-relate-not-valid-to-extend' />");
			return false;
		}
		// Kiem tra li do gia han
		objExam = document.<portlet:namespace />fm.<portlet:namespace />extendReason;
		if (trim(objExam.value) == "") {
			alert("<liferay-ui:message key='please-input-reason-extend' />");
			if (objExam.readOnly == false && objExam.disabled == false) {
				objExam.focus();
			}
			return false;
		}
		// Kiem tra so ngay xu ly gia han hoac ngay het han xu ly
		if (document.<portlet:namespace />fm.<portlet:namespace />leanOnLimitDate.checked == true) { // Tinh theo ngay het han
			// Kiem tra ngay het han xu ly
			objExam = document.<portlet:namespace />fm.<portlet:namespace />limitDateAft;
			if (!isDate(objExam.value)) {
				alert("<liferay-ui:message key='please-input-limit-date-by-format-ddmmyyyy' />");
				objExam.select();
				if (objExam.readOnly == false && objExam.disabled == false) {
					objExam.focus();
				}
				return false;
			}
			// Kiem tra ngay het han sau so voi ngay het han truoc
			var limitDateBefVal = document.<portlet:namespace />fm.<portlet:namespace />limitDateBef.value;
			if (isDate(limitDateBefVal)) {
				if (compare2Date(limitDateBefVal, objExam.value) >= 0) {
					alert("<liferay-ui:message key='limit-date-extend-must-greater-than-limit-date-current' />");
					objExam.select();
					if (objExam.readOnly == false && objExam.disabled == false) {
						objExam.focus();
					}
					return false;
				}
			}
		} // end if
		else { // Neu tinh theo so ngay xu ly
			// Kiem tra so ngay xu ly gia han
			objExam = document.<portlet:namespace />fm.<portlet:namespace />numDayProcessAft;
			if (!isIntegerPositiveNumeric(objExam.value)) {
				alert("<liferay-ui:message key='number-day-process-extend-must-be-integer-positive' />");
				objExam.select();
				if (objExam.readOnly == false && objExam.disabled == false) {
					objExam.focus();
				}
				return false;
			}
			// Kiem tra so ngay xu ly sau va truoc gia han
			var numDayProcessBefVal = document.<portlet:namespace />fm.<portlet:namespace />numDayProcessBef.value;
			if (isIntegerNumeric(numDayProcessBefVal)) {
				if (parseInt(numDayProcessBefVal) >= parseInt(objExam.value)) {
					alert("<liferay-ui:message key='number-day-process-extend-must-greater-than-number-day-process-current' />");
					objExam.select();
					if (objExam.readOnly == false && objExam.disabled == false) {
						objExam.focus();
					}
					return false;
				}
			}
		} // end else
		return true;
	}
	/**
	 * Luu gia han vao database
	 */
	function <portlet:namespace />saveNewExtend() {
		// Kiem tra gia tri nhap vao
		if (<portlet:namespace />doCheckInput() == false) return;
		// Dat gia tri cmd la ADD (them moi) va submit form
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.ADD %>";
		submitForm(document.<portlet:namespace />fm);
		alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
		opener.location.reload();
		window.close();
	}
</script>