<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<portlet:actionURL var="printReport">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/view" />
	<portlet:param name="<%= Constants.CMD %>" value="printReport" />
</portlet:actionURL>

<portlet:renderURL var="docSendProcessURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="statusId" value="<%= ParamUtil.getLong(renderRequest, "statusId", 0) + "" %>" />
	<%
		if (!ParamUtil.getString(renderRequest, "isExpired", "").equals("")) {
	%>
			<portlet:param name="isExpired" value="<%= ParamUtil.getString(renderRequest, "isExpired") %>" />
	<%
		}
	%>
</portlet:renderURL>

<portlet:renderURL var="docSendFinishURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
</portlet:renderURL>

<%
PmlFileStatus fileStatus_XlT = null;
try {
	fileStatus_XlT = PmlFileStatusUtil.findByFileStatusCode("CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly").get(0);
} catch (Exception e ) {
	 fileStatus_XlT = null;
}

long fileStatusId =  0;
if (fileStatus_XlT != null) {
	fileStatusId = fileStatus_XlT.getFileStatusId();
}

%>


<portlet:renderURL var="docSendProcessURL_XuLyThay" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="vtxulythayldb" value="true" />
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId) %>" />
</portlet:renderURL>

<portlet:renderURL var="docSendFinishURL__DaXuLyThay" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="vtxulythayldb" value="true" />
</portlet:renderURL>

<portlet:renderURL var="docSendProcessURL_XuLyThayldvp" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="vtxulythayldvp" value="true" />
	<portlet:param name="hienTrang" value="dangXuLy" />
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId) %>" />
</portlet:renderURL>

<portlet:renderURL var="docSendFinishURL__DaXuLyThayldvp" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="vtxulythayldvp" value="true" />	
</portlet:renderURL>

<script type="text/javascript">

function viewListDocumentSend(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	jQuery('#<portlet:namespace/>listdocumentsend').load(url);
}

function viewListDocumentSendYear(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	// yenlt 20101022
	url = url + "&year=" + window.document.getElementById("<portlet:namespace />select-letter-do-finish").value 
		+ "&timkiemtheotieuchi=" + window.document.getElementById("<portlet:namespace/>timkiemtheotieuchi").value ;
	// end yenlt 20101022
	jQuery('#<portlet:namespace/>listdocumentsend').load(url);
}

function viewListDocumentSendOnChange(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	// yenlt 20101022
	url = url + "&year=" + window.document.getElementById("<portlet:namespace />select-letter-do-finish").value 
		+ "&timkiemtheotieuchi=" + window.document.getElementById("<portlet:namespace/>timkiemtheotieuchi").value ;	
	// end yenlt 20101022
	jQuery('#<portlet:namespace/>listdocumentsend').load(url);
	//window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLy0").checked = true;
	//window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLy0").checked = false;
}

function viewListDocumentSendAction (url) {
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	jQuery('#<portlet:namespace />listdocumentsend').load(url);
}

function <portlet:namespace />uncheckRadio () {
	var radios = window.document.getElementsByName("<portlet:namespace />congVanDiChon");
	for ( var i = 0; i < radios.length; i++) {
		radios[i].checked = false;		
	}
}

function <portlet:namespace />docSendProcess(url) {
	var showProcessAction = window.document.getElementById("<portlet:namespace />letter-doc-process");
	var showFinishAction = window.document.getElementById("<portlet:namespace />letter-doc-finish");
	var tdLetterProcess = window.document.getElementById("<portlet:namespace />td-letter-process");
	var tdLetterDoFinish = window.document.getElementById("<portlet:namespace />td-letter-do-finish");
	var radLetterProcess = window.document.getElementById("<portlet:namespace />rad-letter-process");
	var radLetterDoFinish = window.document.getElementById("<portlet:namespace />rad-letter-do-finish");
	var tdLetterDoFinishYear = window.document.getElementById("<portlet:namespace />td-letter-do-finish-year");
	var year = window.document.getElementById("do-finish-year");

	window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value = "dangXuLy";
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = "xuLyChung";
	// minh update 20100304
	//var coXuLyThayKhong =  document.getElementById("xulythay").value;
	//var coXuLyThayKhongldvp =  document.getElementById("xulythayldvp").value;	
	//if (coXuLyThayKhong == "true" ) {
		
	//	viewListDocumentSend('<!%=docSendProcessURL_XuLyThay%>');
	//}

	//else if (coXuLyThayKhongldvp == "true") {
	//	viewListDocumentSend('<!%=docSendProcessURL_XuLyThayldvp%>');
	//}
	
	//else {	
	// end 	
		//viewListDocumentSend('<1%=docSendProcessURL %>');
	window.document.getElementById("<portlet:namespace/>tabChung").value = "rad-letter-process";
	var timkiemtheotieuchi = document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value;
	if (timkiemtheotieuchi == "true") {
		getParamForListDocumentAction(url);
	} else { // yenlt update 20101022
		viewListDocumentSend(url);
	}

	// minh update 20100304	
	//}
	// end
	
	year.style.display = "none";
	radLetterProcess.checked = true;
	radLetterDoFinish.checked = false;
	if (showProcessAction && showFinishAction) {
		showProcessAction.style.display = "";
		showFinishAction.style.display = "none";
	}
	if (showProcessAction && showProcessAction.style.display == ""){
		tdLetterProcess.style.background = "#60BFFC";
		tdLetterProcess.style.color = "#075372";
		//tdLetterProcess.style.text-shadow = "(0,1px,0,#9ad8ff)";
		tdLetterDoFinish.style.background = "#B5EDFB";
		tdLetterDoFinish.style.color = "#3facf1";
		//tdLetterDoFinish.style.text-shadow = "#c6f4ff";			
		radLetterProcess.style.background = "#60BFFC";
		radLetterDoFinish.style.background = "#b5edfb";	
		tdLetterDoFinishYear.style.background = "#B5EDFB";	
	}
	if (window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChung0") != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChung0").checked = true;
	} 
} 
function <portlet:namespace />docSendFinish(url)
{
	var showProcessAction = window.document.getElementById("<portlet:namespace />letter-doc-process");
	var showFinishAction = window.document.getElementById("<portlet:namespace />letter-doc-finish");
	var tdLetterProcess = window.document.getElementById("<portlet:namespace />td-letter-process");
	var tdLetterDoFinish = window.document.getElementById("<portlet:namespace />td-letter-do-finish");
	var radLetterProcess = window.document.getElementById("<portlet:namespace />rad-letter-process");
	var radLetterDoFinish = window.document.getElementById("<portlet:namespace />rad-letter-do-finish");
	var tdLetterDoFinishYear = window.document.getElementById("<portlet:namespace />td-letter-do-finish-year");
	var year = window.document.getElementById("do-finish-year");

	window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value = "daXuLy";
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = "xuLyChung";
	window.document.getElementById("<portlet:namespace/>tabChung").value = "rad-letter-do-finish";
	// minh update 20100304
	//var coXuLyThayKhong =  document.getElementById("xulythay").value;	
	//if (coXuLyThayKhong == "true" ) {
	//	viewListDocumentSend('<!%=docSendFinishURL__DaXuLyThay%>');
	//}
	//else {	
	// end	
		//viewListDocumentSend('</%=docSendFinishURL %>');
	var timkiemtheotieuchi = document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value;
	if (timkiemtheotieuchi == "true") {
		getParamForListDocumentAction(url);
	} else { // yenlt update 20101022
		viewListDocumentSend(url);
	}
	// minh update 20100304	
	//}
	// end
	year.style.display = "";
	
	radLetterProcess.checked = false;
	radLetterDoFinish.checked = true;
	if (showFinishAction && showProcessAction){
		showProcessAction.style.display = "none";
		showFinishAction.style.display = "";

		if (showFinishAction && showFinishAction.style.display == ""){
			tdLetterDoFinish.style.background = "#60BFFC";	
			tdLetterProcess.style.background = "#b5edfb";	
			tdLetterProcess.style.color = "#3facf1";
			radLetterDoFinish.style.background = "#60BFFC";	
			tdLetterDoFinish.style.color = "#075372";
			tdLetterDoFinishYear.style.background = "#60BFFC";	
			tdLetterDoFinishYear.style.color = "#075372";
			radLetterProcess.style.background = "#b5edfb";	
		}
	}
	if (window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChung0") != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChung0").checked = true;
	}
}

/*
 * Script cho cong van dang xu ly 
 */
function <portlet:namespace/>congVanDiDangXuLyChung(id)
{
	if (window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChung" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChung" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDangXuLyTuXuLy(id)
{
	if (window.document.getElementById("<portlet:namespace />congVanDiDangXuLyTuXuLy" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDangXuLyTuXuLy" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDaXuLyChung(id)
{
	if (window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChung" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChung" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDaXuLyTuXuLy(id)
{
	if (window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLy" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLy" + id).checked = true;
	}
}

/*
 * Cong van dang xu ly tre han
 */

function <portlet:namespace />congVanDiDangXuLyChungTreHan (id) {
	if (window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDangXuLyChungTreHan" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDangXuLyTuXuLyTreHan (id) {
	if (window.document.getElementById("<portlet:namespace />congVanDiDangXuLyTuXuLyTreHan" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDangXuLyTuXuLyTreHan" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDaXuLyChungTreHan (id) {
	if (window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChungTreHan" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDaXuLyChungTreHan" + id).checked = true;
	}
}

function <portlet:namespace />congVanDiDaXuLyTuXuLyTreHan (id) {
	if (window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLyTreHan" + id) != null) {
		window.document.getElementById("<portlet:namespace />congVanDiDaXuLyTuXuLyTreHan" + id).checked = true;
	}
}

/*
 * huy even khi click vao radio hay checkbox
 */
 
 function getSelectRadioSelf(self){		
		
		if (!self.checked) {
			self.checked = true;			
		}  else {
			self.checked = false;			
		}
}

function clickRadio(event)
{

	if (event) // firefox
	{
		if (event.stopPropagation)
		{
			event.stopPropagation();
		}
		else event.cancelBubble = true;
				
	}
	else // windows
	{
		window.event.cancelBubble = true;
	}
	return true; // co the false, bo
}

/*
 * Script cho trang configuration.jsp
 */
function checkedDangXuLyChung(id) 
{
	var checkBox = window.document.getElementById("dangXuLyChung" + id);
	if (!checkBox.checked) {
		checkBox.checked = true;
	}
	else if (checkBox.checked) {
		checkBox.checked = false;
	}
}

function checkedDangXuLyTuXuLy (id) 
{
	var checkBox = window.document.getElementById("dangXuLyTuXuLy" + id);
	if (!checkBox.checked) {
		checkBox.checked = true;
	}
	else if (checkBox.checked) {
		checkBox.checked = false;
	}
}

function checkedDaXuLyChung (id) {
	var checkBox = window.document.getElementById("daXuLyChung" + id);
	if (!checkBox.checked) {
		checkBox.checked = true;
	}
	else if (checkBox.checked) {
		checkBox.checked = false;
	}
}

function checkedDaXuLyTuXuLy (id) {
	var checkBox = window.document.getElementById("daXuLyTuXuLy" + id);
	if (!checkBox.checked) {
		checkBox.checked = true;
	}
	else if (checkBox.checked) {
		checkBox.checked = false;
	}
}

function <portlet:namespace />addReportActionFrom(reportType) {
	var action = "<%= printReport %>&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />frmQuanLyCongVanDi")[0].setAttribute("action", action);
	document.<portlet:namespace />frmQuanLyCongVanDi.submit();
	document.getElementsByName("<portlet:namespace />frmQuanLyCongVanDi")[0].setAttribute("action", "");
}

function <portlet:namespace />setHiddenStatus(status, isExpired) {
	window.document.getElementById("<portlet:namespace/>hiddenStatus").value = status;
	window.document.getElementById("<portlet:namespace />hiddenIsExpired").value = isExpired;
}

//minh update

//ltyen 24/04/2010
function <portlet:namespace />setHiddenStatusDaXuLy(status, isExpired, nguoiXuLy) {
	window.document.getElementById("<portlet:namespace/>hiddenStatus").value = status;
	window.document.getElementById("<portlet:namespace />hiddenIsExpired").value = isExpired;
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = nguoiXuLy;
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;// yenlt
}
//end
function goToPageDocumentSend(form, url) {
	form.action = url;
	form.submit();
}

// yenlt update 20101023


function <portlet:namespace/>setAllValueToDefault() {
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;
	window.document.getElementById('<portlet:namespace/>soKyHieu').value = "";
	window.document.getElementById('<portlet:namespace/>loaiVB').value = 0;
	window.document.getElementById('<portlet:namespace/>donViSoanThao').value = "";
	window.document.getElementById('<portlet:namespace/>nguoiKy').value = "";
	window.document.getElementById('<portlet:namespace/>trichYeu').value = "";
	window.document.getElementById('<portlet:namespace/>coQuanNhan').value = "";
}

function getParamForListDocumentAction(url) {
	var tuNgay = document.getElementById('<portlet:namespace/>tuNgay').value;
	var denNgay = document.getElementById('<portlet:namespace/>denNgay').value;

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != tuNgay && "" != denNgay) {
		strFromDate = tuNgay.toString();
		objFromDate = sgs.stringToDate(strFromDate, "dmy");
		strToDate = denNgay.toString();
		objToDate = sgs.stringToDate(strToDate, "dmy");
	}	

	if(isDate(tuNgay) == false || isDate(denNgay) == false) {
		alert('<liferay-ui:message key="pccc-error-date"/>');
		return false;
	}

	if (objFromDate > objToDate) {
		alert('<liferay-ui:message key="tu-ngay-phai-nho-hon-hoac-bang-den-ngay"/>');
		return false;
	}

	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}

	jQuery('#<portlet:namespace/>timkiemtheotieuchi').val('true');
	var params = {
			'soKyHieu': jQuery('#<portlet:namespace/>soKyHieu').val(),
			'loaisocongvan': jQuery('#<portlet:namespace/>loaiVB').val(),
			'donViSoanThao': jQuery('#<portlet:namespace/>donViSoanThao').val(),
			'nguoiKy': jQuery('#<portlet:namespace/>nguoiKy').val(),
			'trichYeu': jQuery('#<portlet:namespace/>trichYeu').val(),
			'coQuanNhan': jQuery('#<portlet:namespace/>coQuanNhan').val(),
			'tuNgay': jQuery('#<portlet:namespace/>tuNgay').val(),
			'denNgay': jQuery('#<portlet:namespace/>denNgay').val(),
			'timkiemtheotieuchi': jQuery('#<portlet:namespace/>timkiemtheotieuchi').val(),
			'statusId': jQuery('#<portlet:namespace/>hiddenStatus').val(),
			'hienTrang': jQuery('#<portlet:namespace/>hiddenHienTrang').val(),
			'isExpired': jQuery('#<portlet:namespace />hiddenIsExpired').val(),
			'nguoiXuLy': jQuery('#<portlet:namespace/>hiddenNguoiXuLy').val(),
			'tabChung': jQuery('#<portlet:namespace/>tabChung').val()
			};
	jQuery('#<portlet:namespace/>listdocumentsend').load(url, params);
	
}

// phan cho xu ly thay
function viewListDocumentSendXLT(url) {
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	jQuery('#<portlet:namespace/>listdocumentxlt').load(url);
}

function <portlet:namespace/>setAllValueXLTToDefault() {
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;
	window.document.getElementById('<portlet:namespace/>loaiVB').value = 0;
	window.document.getElementById('<portlet:namespace/>donViSoanThao').value = "";
	window.document.getElementById('<portlet:namespace/>nguoiKy').value = "";
	window.document.getElementById('<portlet:namespace/>trichYeu').value = "";
	window.document.getElementById('<portlet:namespace/>coQuanNhan').value = "";
}

function getParamForListXLT(url) {
	var rodios = document.getElementsByName("nguoiXuLyThay");
	var idRedirect = document.getElementById("idRedirect");
	for (var i = 0; i < rodios.length; i++) {
		if (rodios[i].checked) {
			url +=  "&userIdXLT=" + rodios[i].value;				
			document.getElementById("<portlet:namespace/>userIdXLT").value = rodios[i].value;	// yenlt update 20101022
		}
	}	
	var userIdXLT = document.getElementById("<portlet:namespace/>userIdXLT").value;
	if (userIdXLT == 0) {
		alert("<liferay-ui:message key='vui-long-chon-lanh-dao-de-nhap-lieu-thay'/>");
		return false;
	}	
	
	var tuNgay = document.getElementById('<portlet:namespace/>tuNgay').value;
	var denNgay = document.getElementById('<portlet:namespace/>denNgay').value;

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != tuNgay && "" != denNgay) {
		strFromDate = tuNgay.toString();
		objFromDate = sgs.stringToDate(strFromDate, "dmy");
		strToDate = denNgay.toString();
		objToDate = sgs.stringToDate(strToDate, "dmy");
	}	

	if (objFromDate > objToDate) {
		alert('<liferay-ui:message key="tu-ngay-phai-nho-hon-hoac-bang-den-ngay"/>');
		return false;
	}

	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}

	jQuery('#<portlet:namespace/>timkiemtheotieuchi').val('true');
	var params = {
			'loaisocongvan': jQuery('#<portlet:namespace/>loaiVB').val(),
			'donViSoanThao': jQuery('#<portlet:namespace/>donViSoanThao').val(),
			'nguoiKy': jQuery('#<portlet:namespace/>nguoiKy').val(),
			'trichYeu': jQuery('#<portlet:namespace/>trichYeu').val(),
			'coQuanNhan': jQuery('#<portlet:namespace/>coQuanNhan').val(),
			'tuNgay': jQuery('#<portlet:namespace/>tuNgay').val(),
			'denNgay': jQuery('#<portlet:namespace/>denNgay').val(),
			'timkiemtheotieuchi': jQuery('#<portlet:namespace/>timkiemtheotieuchi').val(),
			'statusId': jQuery('#<portlet:namespace/>statusId').val(),
			'userIdXLT': jQuery('#<portlet:namespace/>userIdXLT').val(),
			'vtxulythayldb': jQuery('#<portlet:namespace/>vtxulythayldb').val(),
			'vtxulythayldvp': jQuery('#<portlet:namespace/>vtxulythayldvp').val()
			};
	jQuery('#<portlet:namespace/>listdocumentxlt').load(url, params);

}
// end yenlt update 20101023


function showhideformsearch(){
	jQuery('#searchform').toggle();
	jQuery('#up').toggle();
	jQuery('#down').toggle();
}

//minh update 20100304
//function changProcess(){	
//	document.getElementById("xulythay").value = "true";
//	document.getElementById("xulythayldvp").value = "false";
//	<portlet:namespace />docSendProcess();
	
//}

//function changProcessCVP(){	
//	document.getElementById("xulythayldvp").value = "true";
//	document.getElementById("xulythay").value = "false";
//	<portlet:namespace />docSendProcess();
	
//}
// end
</script>