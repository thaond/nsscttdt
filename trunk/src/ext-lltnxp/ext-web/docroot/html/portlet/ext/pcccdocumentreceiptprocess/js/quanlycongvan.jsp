<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>

<portlet:actionURL var="printReport">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/view" />
	<portlet:param name="<%= Constants.CMD %>" value="printReport" />
</portlet:actionURL>

<portlet:renderURL var="dangXuLyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	
	<portlet:param name="statusId" value='<%= ParamUtil.getLong(renderRequest, "statusId", 0) + "" %>' />
	
	<portlet:param name="tabChung" value="rad-letter-process" />
	<%
		if (!ParamUtil.getString(renderRequest, "isExpired", "").equals("")) {
	%>
			<portlet:param name="isExpired" value="<%= ParamUtil.getString(renderRequest, "isExpired") %>" />
	<%
		}
	%>
</portlet:renderURL>

<%
PmlFileStatus fileStatus_XlT = null;

try {
	fileStatus_XlT = PmlFileStatusUtil.findByFileStatusCode("CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly").get(0);
} catch (Exception e ) {
	 fileStatus_XlT = null;
}

long fileStatusId =  0;
if (fileStatus_XlT != null) {
	fileStatusId = fileStatus_XlT.getFileStatusId();
}


%>

<portlet:renderURL var="dangXuLyURL_XuLyThay" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	<portlet:param name="vtxulythayldb" value="true" />
	<portlet:param name="hienTrang" value="dangXuLy" />
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId) %>" />
	
</portlet:renderURL>

<portlet:renderURL var="daXuLyURL__DaXuLyThay" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="vtxulythayldb" value="true" />
</portlet:renderURL>

<portlet:renderURL var="dangXuLyURL_XuLyThayldvp" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	<portlet:param name="vtxulythayldvp" value="true" />
	<portlet:param name="hienTrang" value="dangXuLy" />	
	<portlet:param name="statusId" value="<%= String.valueOf(fileStatusId) %>" />
</portlet:renderURL>

<portlet:renderURL var="daXuLyURL__DaXuLyThayldvp" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/list" />
	<portlet:param name="hienTrang" value="daXuLy" />
	<portlet:param name="vtxulythayldvp" value="true" />	
</portlet:renderURL>

<script type="text/javascript">

function viewListDocument(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	jQuery('#<portlet:namespace/>listdocument').load(url);
}

function viewListDocumentYear(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	// yenlt 20101022
	url = url + "&year=" + window.document.getElementById("<portlet:namespace />select-letter-do-finish").value 
		+ "&timkiemtheotieuchi=" + document.getElementById("<portlet:namespace/>timkiemtheotieuchi").value ;
	// end yenlt 20101022
	jQuery('#<portlet:namespace/>listdocument').load(url);
}

function viewListDocumentOnChange(url) 
{
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	// yenlt 20101022
	url = url + "&year=" + window.document.getElementById("<portlet:namespace />select-letter-do-finish").value 
		+ "&timkiemtheotieuchi=" + document.getElementById("<portlet:namespace/>timkiemtheotieuchi").value ;
	// end yenlt update 20101022
	jQuery('#<portlet:namespace/>listdocument').load(url);
	//window.document.getElementById("<portlet:namespace />congDaVanXuLyChung0").checked = true;
	//window.document.getElementById("<portlet:namespace />congVanDaXuLyTuXuLy0").checked = false;
}

function viewListDocumentAction (url) {
	if (navigator.userAgent.indexOf("MSIE") > -1) {
		url += '<%= "&?random=" + Math.random()*99999 %>';
	}
	jQuery('#<portlet:namespace />listDocument').load(url);
}

function <portlet:namespace />uncheckRadio () {
	var radios = window.document.getElementsByName("<portlet:namespace />congVanChon");
	for ( var i = 0; i < radios.length; i++) {
		radios[i].checked = false;		
	}
}

function <portlet:namespace />docProcess(url)
{
	var showProcessAction = window.document.getElementById("<portlet:namespace />letter-doc-process");
	var showFinishAction = window.document.getElementById("<portlet:namespace />letter-doc-finish");
	
	var tdLetterProcess = window.document.getElementById("<portlet:namespace />td-letter-process");
	var tdLetterDoFinish = window.document.getElementById("<portlet:namespace />td-letter-do-finish");
	var tdLetterNetWork = window.document.getElementById("<portlet:namespace />td-letter-network");
	
	var radLetterProcess = window.document.getElementById("<portlet:namespace />rad-letter-process");
	var radLetterDoFinish = window.document.getElementById("<portlet:namespace />rad-letter-do-finish");
	var radLetterNetwork = window.document.getElementById("<portlet:namespace />rad-letter-network");
	
	var tdLetterDoFinishYear = window.document.getElementById("<portlet:namespace />td-letter-do-finish-year");
	
	var year = window.document.getElementById("do-finish-year");
	window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value = "dangXuLy";
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = "xuLyChung";
	window.document.getElementById("<portlet:namespace/>tabChung").value = "rad-letter-process";
	var timkiemtheotieuchi = document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value;
	if (timkiemtheotieuchi == "true") {
		getParamForListDocumentAction(url);
	} else { // yenlt update 20101022
		viewListDocument(url);
	}
	year.style.display = "none";
	radLetterProcess.checked = true;
	radLetterDoFinish.checked = false;
	radLetterNetwork.checked = false;
	if (showProcessAction && showFinishAction) {
		showProcessAction.style.display = "";
		showFinishAction.style.display = "none";
	}
	if (showProcessAction && showProcessAction.style.display == ""){
		tdLetterProcess.style.background = "#60BFFC";
		tdLetterProcess.style.color = "#075372";
		//tdLetterProcess.style.text-shadow = "(0,1px,0,#9ad8ff)";
		tdLetterNetWork.style.background = "#B5EDFB";
		tdLetterNetWork.style.color = "#3facf1";
		
		tdLetterDoFinish.style.background = "#B5EDFB";
		tdLetterDoFinish.style.color = "#3facf1";
		//tdLetterDoFinish.style.text-shadow = "#c6f4ff";			
		radLetterProcess.style.background = "#60BFFC";
		radLetterDoFinish.style.background = "#b5edfb";	
		radLetterNetwork.style.background = "#b5edfb";	
		
		tdLetterDoFinishYear.style.background = "#B5EDFB";	
	}

	window.document.getElementById("<portlet:namespace />congVanDangXuLyChung0").checked = true;
} 
// yenlt update 20101030
function <portlet:namespace />docNetwork(url)
{
	var showProcessAction = window.document.getElementById("<portlet:namespace />letter-doc-process");
	var showFinishAction = window.document.getElementById("<portlet:namespace />letter-doc-finish");

	var tdLetterProcess = window.document.getElementById("<portlet:namespace />td-letter-process");
	var tdLetterDoFinish = window.document.getElementById("<portlet:namespace />td-letter-do-finish");
	var tdLetterNetWork = window.document.getElementById("<portlet:namespace />td-letter-network");
	
	var radLetterProcess = window.document.getElementById("<portlet:namespace />rad-letter-process");
	var radLetterDoFinish = window.document.getElementById("<portlet:namespace />rad-letter-do-finish");
	var radLetterNetwork = window.document.getElementById("<portlet:namespace />rad-letter-network");
	
	var tdLetterDoFinishYear = window.document.getElementById("<portlet:namespace />td-letter-do-finish-year");
	
	var year = window.document.getElementById("do-finish-year");
	
	window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value = "vbquamang";
	//window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = "xuLyChung";
	window.document.getElementById("<portlet:namespace/>tabChung").value = "rad-letter-network";
	var timkiemtheotieuchi = document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value;
	if (timkiemtheotieuchi == "true") {
		getParamForListDocumentAction(url);
	} else { 
		viewListDocument(url);
	}

	year.style.display = "none";
	radLetterNetwork.checked = true;
	radLetterProcess.checked = false;
	radLetterDoFinish.checked = false;
	
	if (showProcessAction && showFinishAction) {
		showProcessAction.style.display = "none";
		showFinishAction.style.display = "none";
	}
	if (showProcessAction.style.display == "none" && showProcessAction.style.display == "none"){
		
		tdLetterNetWork.style.background = "#60BFFC";
		tdLetterNetWork.style.color = "#075372";
		
		tdLetterProcess.style.background = "#B5EDFB";
		tdLetterProcess.style.color = "#3facf1";
		
		tdLetterDoFinish.style.background = "#B5EDFB";
		tdLetterDoFinish.style.color = "#3facf1";
		
		radLetterNetwork.style.background = "#60BFFC";
		radLetterProcess.style.background = "#b5edfb";
		radLetterDoFinish.style.background = "#b5edfb";	
		
		tdLetterDoFinishYear.style.background = "#B5EDFB";	
	}

	window.document.getElementById("<portlet:namespace />congVanDangXuLyChung0").checked = true;
} 
// end yenlt update 20101030
function <portlet:namespace />docFinish(url)
{
	// yenlt update 20101021
	window.document.getElementById("<portlet:namespace/>hiddenHienTrang").value = "daXuLy";
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = "xuLyChung";
	window.document.getElementById("<portlet:namespace/>tabChung").value = "rad-letter-do-finish";
	var timkiemtheotieuchi = document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value;
	
	if (timkiemtheotieuchi == "true") {
		getParamForListDocumentAction(url);
	} else { // yenlt update 20101021
		viewListDocumentYear(url);
	}
	var showProcessAction = window.document.getElementById("<portlet:namespace />letter-doc-process");
	var showFinishAction = window.document.getElementById("<portlet:namespace />letter-doc-finish");
	
	var tdLetterProcess = window.document.getElementById("<portlet:namespace />td-letter-process");
	var tdLetterDoFinish = window.document.getElementById("<portlet:namespace />td-letter-do-finish");
	var tdLetterNetWork = window.document.getElementById("<portlet:namespace />td-letter-network");
	
	var radLetterProcess = window.document.getElementById("<portlet:namespace />rad-letter-process");
	var radLetterDoFinish = window.document.getElementById("<portlet:namespace />rad-letter-do-finish");
	var radLetterNetwork = window.document.getElementById("<portlet:namespace />rad-letter-network");
	
	var tdLetterDoFinishYear = window.document.getElementById("<portlet:namespace />td-letter-do-finish-year")
	var year = window.document.getElementById("do-finish-year");

	year.style.display = "";
	
	radLetterProcess.checked = false;
	radLetterNetwork.checked = false;
	radLetterDoFinish.checked = true;
	if (showFinishAction && showProcessAction){
		showProcessAction.style.display = "none";
		showFinishAction.style.display = "";

		if (showFinishAction && showFinishAction.style.display == ""){
			tdLetterDoFinish.style.background = "#60BFFC";
			tdLetterDoFinish.style.color = "#075372";
				
			tdLetterProcess.style.background = "#b5edfb";	
			tdLetterProcess.style.color = "#3facf1";
			
			tdLetterNetWork.style.background = "#b5edfb";	
			tdLetterNetWork.style.color = "#3facf1";
			
			radLetterDoFinish.style.background = "#60BFFC";	
			
			tdLetterDoFinishYear.style.background = "#60BFFC";	
			tdLetterDoFinishYear.style.color = "#075372";
			
			radLetterProcess.style.background = "#b5edfb";	
		}
	}
	
	window.document.getElementById("<portlet:namespace />congDaVanXuLyChung0").checked = true;
}

/*
 * Script cho cong van dang xu ly && xu ly chung
 */
function <portlet:namespace/>congVanDangXuLyChung(id)
{
	window.document.getElementById("<portlet:namespace />congVanDangXuLyChung" + id).checked = true;
}

function <portlet:namespace/>congVanDangXuLyTuXuLy(id)
{
	window.document.getElementById("<portlet:namespace />congVanDangXuLyTuXuLy" + id).checked = true;
	
}

function <portlet:namespace/>congDaVanXuLyChung(id)
{
	window.document.getElementById("<portlet:namespace />congDaVanXuLyChung" + id).checked = true;
}

function <portlet:namespace/>congVanDaXuLyTuXuLy(id)
{
	window.document.getElementById("<portlet:namespace />congVanDaXuLyTuXuLy" + id).checked = true;
}

function <portlet:namespace/>congVanDangXuLyChungTreHan (id) {
	window.document.getElementById("<portlet:namespace />congVanDangXuLyChungTreHan" + id).checked = true;
}

function <portlet:namespace/>congVanDangXuLyTuXuLyTreHan (id) {
	window.document.getElementById("<portlet:namespace />congVanDangXuLyTuXuLyTreHan" + id).checked = true;
}

function <portlet:namespace/>congVanDaXuLyChungTreHan (id) {
	window.document.getElementById("<portlet:namespace />congVanDaXuLyChungTreHan" + id).checked = true;
}

function <portlet:namespace/>congVanDaXuLyTuXuLyTreHan (id) {
	window.document.getElementById("<portlet:namespace />congVanDaXuLyTuXuLyTreHan" + id).checked = true;
}

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
	var action = "<%=printReport %>&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />fm")[0].setAttribute("action", action);
	document.<portlet:namespace />fm.submit();
	document.getElementsByName("<portlet:namespace />fm")[0].setAttribute("action", "");
}

function <portlet:namespace />setHiddenStatus(status, isExpired) {
	window.document.getElementById("<portlet:namespace/>hiddenStatus").value = status;
	window.document.getElementById("<portlet:namespace/>hiddenIsExpired").value = isExpired;
}
//ltyen 24/04/2010
function <portlet:namespace />setHiddenStatusDaXuLy(status, isExpired, nguoiXuLy) {
	window.document.getElementById("<portlet:namespace/>hiddenStatus").value = status;
	window.document.getElementById("<portlet:namespace/>hiddenIsExpired").value = isExpired;
	window.document.getElementById("<portlet:namespace/>hiddenNguoiXuLy").value = nguoiXuLy;
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;// yenlt
}
//end
function isInteger(s)
{
      var i;
	s = s.toString();
      for (i = 0; i < s.length; i++)
      {
         var c = s.charAt(i);
         if (isNaN(c)) 
	   {
		alert("<liferay-ui:message key='Accept-number-only'/>");
		return false;
	   }
      }
      return true;
}

//minh update

function goToPageDocumentReceipt(form, url) {
	form.action = url;
	form.submit();
}
//minh update 20100303
//function changProcess(){
	
//	document.getElementById("xulythay").value = "true";
//	document.getElementById("xulythayldvp").value = "false"; 
//	<portlet:namespace />docProcess();
//}

//function changProcessCVP(){
	
//	document.getElementById("xulythay").value = "false";
//	document.getElementById("xulythayldvp").value = "true"; 
//	<portlet:namespace />docProcess();
//}
//end

// yenlt update 20101020
function changeDocumentRecordType() {
	var documentRecordTypeId =  DWRUtil.getValue('socongvancvdtn');
	var elementSelect = document.getElementById('loaicongvancvdtn');

	dwr.util.removeAllOptions('loaicongvancvdtn');
	pcccdocumentreceiptClient.getDocumentType(documentRecordTypeId, function (data) {
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				elementSelect.options[i] = new Option(data[i].documentTypeName, data[i].documentTypeId);
			}
		}
		else {
		}		
	});
}

function getParamForListDocumentAction(url) {
	var tungay = document.getElementById('<portlet:namespace/>tuNgay').value;
	var denngay = document.getElementById('<portlet:namespace/>denNgay').value;

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != tungay && "" != denngay) {
		strFromDate = tungay.toString();
		objFromDate = sgs.stringToDate(strFromDate, "dmy");
		strToDate = denngay.toString();
		objToDate = sgs.stringToDate(strToDate, "dmy");
	}	

	if(isDate(tungay) == false || isDate(denngay) == false) {
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
			'sovanbanden': jQuery('#<portlet:namespace/>sovanbanden').val(),
			'sohieugoc': jQuery('#<portlet:namespace/>sohieugoc').val(),
			'loaisocongvan': jQuery('#socongvancvdtn').val(),
			'issuingplaceId': jQuery('#<portlet:namespace/>issuingplaceId').val(),
			'noiphathanh': jQuery('#<portlet:namespace/>noiphathanh').val(),
			'trichyeu': jQuery('#<portlet:namespace/>trichyeu').val(),
			'tungay': jQuery('#<portlet:namespace/>tuNgay').val(),
			'denngay': jQuery('#<portlet:namespace/>denNgay').val(),
			'ngayhethan': jQuery('#<portlet:namespace/>ngayHetHan').val(),
			'timkiemtheotieuchi': jQuery('#<portlet:namespace/>timkiemtheotieuchi').val(),
			'statusId': jQuery('#<portlet:namespace/>hiddenStatus').val(),
			'tabChung': jQuery('#<portlet:namespace/>tabChung').val(),
			'isExpired': jQuery('#<portlet:namespace/>hiddenIsExpired').val(),
			'hienTrang': jQuery('#<portlet:namespace/>hiddenHienTrang').val(),
			'nguoiXuLy': jQuery('#<portlet:namespace/>hiddenNguoiXuLy').val()
			};
	jQuery('#<portlet:namespace/>listdocument').load(url, params);

}

function changeIssuingplace() {
	var divissuingplace = document.getElementById("divissuingplace");
	var divnoiphathanh = document.getElementById("divnoiphathanh");
	var isCheck = document.getElementById("<portlet:namespace/>ischeck");
	if (isCheck.checked == "") {
		divnoiphathanh.style.display = "";
		divissuingplace.style.display = "none";
	} else {
		divnoiphathanh.style.display = "none";
		divissuingplace.style.display = "";
	}
}

function setLoaiVanBanToBlank() {
	var elementSelect = document.getElementById('loaicongvancvdtn');
	elementSelect.options[0] = new Option("", 0);
}

function <portlet:namespace/>setAllValueToDefault() {
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;
	window.document.getElementById('<portlet:namespace/>sovanbanden').value = "";
	window.document.getElementById('<portlet:namespace/>sohieugoc').value = "";
	window.document.getElementById('socongvancvdtn').value = 0;
	window.document.getElementById('loaicongvancvdtn').options[0] = new Option("", 0);
	window.document.getElementById('<portlet:namespace/>issuingplaceId').value = "";
	window.document.getElementById('<portlet:namespace/>noiphathanh').value = "";
	window.document.getElementById('<portlet:namespace/>trichyeu').value = "";
	window.document.getElementById('<portlet:namespace/>ngayHetHan').value = "";
}

// phan cho xu ly thay
function <portlet:namespace/>setAllValueXLTToDefault() {
	window.document.getElementById('<portlet:namespace/>timkiemtheotieuchi').value = false;
	window.document.getElementById('<portlet:namespace/>sovanbanden').value = "";
	window.document.getElementById('<portlet:namespace/>sohieugoc').value = "";
	window.document.getElementById('socongvancvdtn').value = 0;
	window.document.getElementById('<portlet:namespace/>issuingplaceId').value = "";
	window.document.getElementById('<portlet:namespace/>noiphathanh').value = "";
	window.document.getElementById('<portlet:namespace/>trichyeu').value = "";
}

function viewListDocumentXLT(url) {
	jQuery('#<portlet:namespace/>listdocumentxlt').load(url);
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
	var tungay = document.getElementById('<portlet:namespace/>tuNgay').value;
	var denngay = document.getElementById('<portlet:namespace/>denNgay').value;

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != tungay && "" != denngay) {
		strFromDate = tungay.toString();
		objFromDate = sgs.stringToDate(strFromDate, "dmy");
		strToDate = denngay.toString();
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
			'sovanbanden': jQuery('#<portlet:namespace/>sovanbanden').val(),
			'sohieugoc': jQuery('#<portlet:namespace/>sohieugoc').val(),
			'loaisocongvan': jQuery('#socongvancvdtn').val(),
			'issuingplaceId': jQuery('#<portlet:namespace/>issuingplaceId').val(),
			'noiphathanh': jQuery('#<portlet:namespace/>noiphathanh').val(),
			'trichyeu': jQuery('#<portlet:namespace/>trichyeu').val(),
			'tungay': jQuery('#<portlet:namespace/>tuNgay').val(),
			'denngay': jQuery('#<portlet:namespace/>denNgay').val(),
			'timkiemtheotieuchi': jQuery('#<portlet:namespace/>timkiemtheotieuchi').val(),
			'statusId': jQuery('#<portlet:namespace/>statusId').val(),
			'userIdXLT': jQuery('#<portlet:namespace/>userIdXLT').val(),
			'vtxulythayldb': jQuery('#<portlet:namespace/>vtxulythayldb').val(),
			'vtxulythayldvp': jQuery('#<portlet:namespace/>vtxulythayldvp').val()
			};
	jQuery('#<portlet:namespace/>listdocumentxlt').load(url, params);
}
// end yenlt update 20101020
function showhideformsearch(){
		jQuery('#searchform').toggle();
		jQuery('#up').toggle();
		jQuery('#down').toggle();
	}

// yenlt 20101118
function <portlet:namespace />addTransFrom(url) {
	var documentReceiptIdsValue = document.<portlet:namespace />fm.<portlet:namespace />documentReceiptIdList.value 
	documentReceiptIdsValue = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
	if ("" == documentReceiptIdsValue || "on" == documentReceiptIdsValue) {
		alert("<liferay-ui:message key='vui-long-chon-van-ban' />");
		return false;
	}
	document.<portlet:namespace />fm.<portlet:namespace />documentReceiptIdList.value = documentReceiptIdsValue;
	document.<portlet:namespace />fm.<portlet:namespace />changeCVP.value = "true";
	submitForm(document.<portlet:namespace />fm, url);
}

// end yenlt 20101118
</script>