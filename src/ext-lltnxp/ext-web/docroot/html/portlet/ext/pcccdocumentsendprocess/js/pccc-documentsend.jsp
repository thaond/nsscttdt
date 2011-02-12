<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@page import="com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway"%>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type='text/javascript'src='/dwr/interface/documentSendUtilClient.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentsendprocessClient.js'></script>

<script type="text/javascript" >
/* function add row*/
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file

window.onload = function () {	
	getDateReturnClient();
}

function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function validateFormEdit() {
	fileUpload();	
	var sovakyhieuvanban = document.getElementById('sohieucvdtn');
	var ngaygui = document.getElementById('ngayguicvdtn');
	var ngaybanhanh =document.getElementById('ngaybanhanhcvdtn');
	var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');

	if (sovakyhieuvanban.value.trim() == "") {
		alert("<liferay-ui:message key='so-va-ky-hieu-van-ban'/>");
		sovakyhieuvanban.focus();
		return false;
	}
	if (isDatevalid(ngaygui.value)==false){
		ngaygui.focus();
		return false;
	}
	
	if(isDatevalid(ngaybanhanh.value)==false ){		
		ngaybanhanh.focus();
		return false;
	}	
	if (noinhancvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>");
		noinhancvdtn.focus();
		return false;
	}

	if (trichyeucvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='doc-r5-alert'/>");
		trichyeucvdtn.focus();
		return false;
	}

	if (!isBookDocumentSendAgencyClient()) {
		return false;
	}

	var isPublish = document.getElementById('<portlet:namespace/>isPublish').value;
	
	if (isPublish == "true") {
		var orgExternalIdHidden = document.getElementById('<portlet:namespace/>orgExternalIdHidden').value;
		var haveChooseOrgExt = false;
		
		for (var i = 0; i < orgExternalIdHidden; i++) {
			var orgExternalId = document.getElementById('orgExternalId'+i);
			if (orgExternalId.checked) {
				haveChooseOrgExt = true;
				break;
			}
		}

		if (haveChooseOrgExt == false) {
			alert("<liferay-ui:message key='vui-long-chon-he-thong'/>");
			return false;

		}
		<%
			boolean flag = DocumentEdmsGateway.DEG.isConnectGateWay(); 
		%>
		
		var isP = '<%= String.valueOf(flag)%>';
		if (isP == "false") {
			alert("<liferay-ui:message key='khong-ket-noi-duoc-he-thong-ben-ngoai'/>");
			return false;
		}
		
	}

	if (checkFileUpload() == false) {
		return false;
	}		

	else {		
		return true;
	}
}

function validateSendDocReceipt(){
	
	fileUpload();	

	var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');
	
	if (!isBookDocumentRecordAgencyClient()) {
		return false;
	}

	if (noinhancvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>");
		noinhancvdtn.focus();
		return false;
	}
	if (trichyeucvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='doc-r5-alert'/>");
		trichyeucvdtn.focus();
		return false;
	}

	if (checkFileUpload() == false) {
		return false;
	}		
	else{
		
		return true;
	}
	
}

/*check number only use for all maybe onKeyPress="return numbersonly(this, event)"
 * or onkeyup="alert(!isNaN(this.value.charAt(this.value.length-1)))"
 */
function numbersonly(myfield, e, dec)
{
var key;
var keychar;

if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);

// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) )
   return true;

// numbers
else if ((("0123456789").indexOf(keychar) > -1))
   return true;

// decimal point jump
else if (dec && (keychar == "."))
   {
   myfield.form.elements[dec].focus();
   return false;
   }
else
	alert("Accept number only!")
   return false;
}


//mimh lam

/**
 * get all issue place when change level send
 */
function changeLevelSend() {
	
	var levelSendId =  DWRUtil.getValue('capgoicvdtn');
	var elementSelect = document.getElementById('noiphathanhcvdtn');
	
	pcccdocumentreceiptClient.getIssuingPlaces(levelSendId, function (data){
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {		
				elementSelect.options[i+1] = new Option(data[i].issuingPlaceName, data[i].issuingPlaceId);
			}
		}
		else {
			//alert ("khong co cap goi cong van");
		}
	});
}

/**
 * get all document type when change documentRecordTo  
 */
function changeDocumentRecordType() {
	
	var documentRecordTypeId =  DWRUtil.getValue('socongvancvdtn');
	var elementSelect = document.getElementById('loaicongvancvdtn');
	dwr.util.removeAllOptions("loaicongvancvdtn");
	pcccdocumentreceiptClient.getDocumentType(documentRecordTypeId, function (data){
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				elementSelect.options[i] = new Option(data[i].documentTypeName, data[i].documentTypeId);
			}
			//changeDocumentTypePublish();
			changeDocumentTypeSend();
		}

		else {
			//alert("khong co docment type")
		}		
	});
}

function changeDocumentRecordTypeUpdate() {
	var documentRecordTypeId =  DWRUtil.getValue('socongvancvdtn');
	var elementSelect = document.getElementById('loaicongvancvdtn');
	dwr.util.removeAllOptions("loaicongvancvdtn");
	pcccdocumentreceiptClient.getDocumentType(documentRecordTypeId, function (data){
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				elementSelect.options[i] = new Option(data[i].documentTypeName, data[i].documentTypeId);
			}			
			//changeDocumentType();
		}

		else {
			//alert("khong co docment type")
		}		
	});
}

/**
 * get number document when change document type
 */
function changeDocumentType() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = DWRUtil.getValue('userId');
	pcccdocumentreceiptClient.getNumberDocumentReceipt(documentRecordTypeId, documentTypeId, userId, function (data){
		
		if (data != null) {
			//$('soCVdencvdtn').value = data;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
		
	});
	
}

/**
 * get number document when change document type
 */
function changeDocumentTypeSend() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = DWRUtil.getValue('userIdCreator');
	
	var <portlet:namespace/>documentRecordTypeCode = document.getElementById('<portlet:namespace/>documentRecordTypeCode').value;
	var <portlet:namespace/>documentTypeCode = document.getElementById('<portlet:namespace/>documentTypeCode').value;
	var <portlet:namespace/>textAdd = document.getElementById('<portlet:namespace/>textAdd').value;
	var <portlet:namespace/>departmentCode = document.getElementById('<portlet:namespace/>departmentCode').value;
	var <portlet:namespace/>useYear = document.getElementById('<portlet:namespace/>useYear').value;
	var <portlet:namespace/>documentRecordTypeIdHidden = document.getElementById('<portlet:namespace/>documentRecordTypeIdHidden').value;
	
	if (documentRecordTypeId != "" && documentRecordTypeId !="0") {
		pcccdocumentreceiptClient.getNumberPublish(documentRecordTypeId, documentTypeId, userId, <portlet:namespace/>documentRecordTypeIdHidden, <portlet:namespace/>documentRecordTypeCode, <portlet:namespace/>documentTypeCode, <portlet:namespace/>textAdd, <portlet:namespace/>departmentCode,<portlet:namespace/>useYear, function (data){
			if (data != null) {
				
				document.getElementById('sohieucvdtn').value = data;
			}
			else {
				//alert ("khong co so hieu cong van");
			}		
			
		});
	}
	
}



function uploadReceiptfile()
{
	var table=document.getElementById('addfileupload').insertRow(1);

	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	table.style.backgroundColor = "white";

	title.innerHTML="<input style='width: 95%' name='titlefile' type='text' id='titlefile" + incstt +"'>";
	nameDocument.innerHTML="<input style='width: 95%' type='file' name='namefile" + incstt +"' id='namefile" + incstt +"'>";
	deleteRow.innerHTML="<input style='width: 90%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input>";
	incstt += 1;
}

function deleteRow(row)
{
	 var i=row.parentNode.parentNode.rowIndex;
	 document.getElementById('addfileupload').deleteRow(i);
	
}


function fileUpload() {
	
	var listNameRow = "";
	var valueNameFile ="";
	var tileFile ="";
	for(i = 0; i < incstt; i++) {
		if(document.getElementById('namefile'+ i)) {			
			listNameRow += "namefile" + i + "_";
			valueNameFile += document.getElementById('namefile'+ i).value +"/";
		}

		if (document.getElementById('titlefile'+ i)) {
			tileFile += document.getElementById('titlefile'+ i).value + "#";	
		}
	}	
	document.getElementById('nameFieldRow').value = listNameRow;
	document.getElementById('nameFiles').value = valueNameFile;
	document.getElementById('titleFiles').value = tileFile;		
}

/*/get hostname of web
 * 
 */
function getHostName(elementA, value) {
	elementA.setAttribute("href","http://" + window.location.host + value );
	
}

function checkFileUpload() {
	
	var result = true;
	for(i = incstt - 1; i >= 0; i--) {
		if(document.getElementById('namefile'+ i)) {			
			var valueNameFile1 = document.getElementById('namefile'+ i).value;
			var fileTitle = document.getElementById('titlefile'+ i);
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
				document.getElementById('namefile'+ i).focus();
				fileTitle.focus();
				result = false;
				break;
			}

			var typeStandard = "xls,html,htm,doc,docx,xlsx,jpg,pmp,pdf";	
			
			if(typeStandard.search(type) == -1) {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>\n<liferay-ui:message key='delegate-dinhdangchophep'/>");
				fileTitle.focus();
				result = false;	
				break;
			}

			if (fileTitle.value.trim() == "") {
				alert("<liferay-ui:message key='pccc-vuilongnhaptieude'/>");
				fileTitle.focus();
				result = false;
				break;
			}
		}
	}
	return result;
}

function mypopupIssuingplace()
{   
  var host = location.host;
  var path = "http://" + host + "/html/portlet/ext/pcccdocumentsend/popup1.jsp";
  var mywindow = window.open ( path ,"mywindow","modal=true,location=1,status=1,scrollbars=1,width=800px,height=400px");
  var posX = screen.width / 4;
  var posY = screen.height / 4;
  mywindow.moveTo(posX , posY);
}
function mypopupSigner()
{   
  var host = location.host;
  var path = "http://" + host + "/html/portlet/ext/pcccdocumentsend/popup2.jsp";
  var mywindow = window.open ( path ,"mywindow","modal=true,location=1,status=1,scrollbars=1,width=800px,height=400px");
  var posX = screen.width / 4;
  var posY = screen.height / 4;
  mywindow.moveTo(posX , posY);
}
/*popup chon nguoi ky trong trang cho so vb di  */
function mypopupCreator()
{   
  var host = location.host;
  var path = "http://" + host + "/html/portlet/ext/pcccdocumentsendprocess/popupCreator.jsp";
  var mywindow = window.open ( path ,"mywindow","modal=true,location=1,status=1,scrollbars=1,width=800px,height=400px");
  var posX = screen.width / 4;
  var posY = screen.height / 4;
  mywindow.moveTo(posX , posY);
}
function getData(){	

	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
		
	}
	else{
		

		window.opener.document.getElementById('receiveplace').value = document.getElementById('hidden').value;
		var idIssuingPlace = document.getElementById('issuingPlaceId').value;
		window.opener.document.getElementById('issuingPlaceId').value=idIssuingPlace;
		window.close();
		
		}
}
function getDataSigner(){	

	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
		
	}
	else{
		

		window.opener.document.getElementById('signer').value = document.getElementById('hidden').value;
		var idIssuingPlace = document.getElementById('signerId').value;
		window.opener.document.getElementById('signerId').value=idIssuingPlace;
		window.close();
		
		}
}
function getDataHelpSigner(trTable){	

	var elementRadioChecked = trTable.cells[1].firstChild;
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('signerId').value = arr[1];
}
function getDataHelp(trTable){	

	var elementRadioChecked = trTable.cells[1].firstChild;
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('issuingPlaceId').value = arr[1];
}

/**
 * DHTML date validation script for dd/mm/yyyy. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */
// Declaring valid date character, minimum year and maximum year
var dtCh= "/";
var minYear=1900;
var maxYear=2100;
var ngaynop = document.getElementById('applicationDate');
var ngayhen = document.getElementById('expectedReturningDate');
var ngaynhap = document.getElementById('inputDataDate');

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDatevalid(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth, 10)
	day=parseInt(strDay, 10)
	year=parseInt(strYr, 10)
	if (pos1==-1 || pos2==-1){
		alert("<liferay-ui:message key='The-date-format-should-be'/>");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("<liferay-ui:message key='Please-enter-a-valid-month'/>");
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("<liferay-ui:message key='please-enter-a-valid-day'/>");
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("<liferay-ui:message key='Please-enter-a-valid-4-digit-year'/>");
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("<liferay-ui:message key='Please-enter-a-valid-date'/>");
		return false
	}
return true
}

//kiem tra so cong van cua lanh dao so co hay khong

function isBookDocumentRecordAgencyClient() {
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = document.getElementById('userId').value	
	pcccdocumentreceiptClient.isBookDocumentRecordAgency(documentRecordTypeId, userId, {callback:setValuesInDWR, async:false});
	var result = document.getElementById('isBookDocumentRecord').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='Book-document-record-not-exist'/>");
 	 	return false;
 	}
 	else {
 		return true;
 	} 	
}

var setValuesInDWR = function (data){
	
	 
 	if (!data) {
 		document.getElementById('isBookDocumentRecord').value = false; 
 	}
 	else { 	 	
 		document.getElementById('isBookDocumentRecord').value = true;
 	}
 };

//check book document send exist ??? use ajax synchronied
 function isBookDocumentSendAgencyClient() {
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = document.getElementById('userId').value	
	pcccdocumentreceiptClient.isBookDocumentSendAgency(documentRecordTypeId, userId, {callback:setValuesDocumentSendAgencyInDWR, async:false});
	var result = document.getElementById('isBookDocumentSend').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='Book-document-send-not-exist'/>");
 	 	return false;
 	}
 	else {
 		return true;
 	} 	
}

var setValuesDocumentSendAgencyInDWR = function (data){
	 
 	if (!data) {
 		document.getElementById('isBookDocumentSend').value = false; 
 	}
 	else { 	 	
 		document.getElementById('isBookDocumentSend').value = true;
 	}
 };
 
 function changeDocumentTypePublish() {
		var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
		var departmentsId = DWRUtil.getValue('departmentsId');
		/*xuancong close start
		pcccdocumentreceiptClient.getNumberDocumentPublish( documentTypeId, departmentsId, function (data){
			if (data != null) {
				document.getElementById('sohieucvdtn').value = data;
			}
			else {
			}		
		});
		xuancong close end */
		
		var issuingYear = 0;
		pcccdocumentreceiptClient.getNumberDocumentPublishByTDY(documentTypeId, departmentsId, issuingYear, function (data) {
			if (data != null && data != "") {
				document.getElementById('sohieucvdtn').value = data;
			}
			else {
			}		
		});
	}
function checkUpdateform(){
	fileUpload();
	var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');
	var ngaybanhanh = document.getElementById('ngaybanhanhcvdtn');

	// Kiem tra ngay ban hanh neu co
	if (ngaybanhanh != null && ngaybanhanh.value.trim() != "") {
		if (isDatevalid(ngaybanhanh.value) == false) {		
			if (ngaybanhanh.disabled == false) {
				ngaybanhanh.focus();
			}
			ngaybanhanh.select();
			return false;
		}
	}
	if (noinhancvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>");
		noinhancvdtn.focus();
		return false;
	}
	if (trichyeucvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='doc-r5-alert'/>");
		trichyeucvdtn.focus();
		return false;
	}

	if (checkFileUpload() == false) {
		return false;
	}		
	else{
		
		return true;
	}
	
}

// yenlt update 20101029
function unChooseOrgExternal() {
	var divORG = document.getElementById('divorgexternal');
	document.getElementById('<portlet:namespace/>isPublish').value = "false";
	divORG.style.display = "none";
}

function chooseOrgExternal() {
	var divORG = document.getElementById('divorgexternal');
	document.getElementById('<portlet:namespace/>isPublish').value = "true";
	divORG.style.display = "";
}

function clickCheckBoxORG(event,eleCheckBox)
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

// end yenlt 20101029

/**	
 * phmphuc them 11/11/2010
 * lay so cong van theo loai cong van duoc chon
 */
function getDocumentRecordByDocTypeId() {
	var documentTypeId = DWRUtil.getValue('loaicongvancvdtn');
	var elementSelect = document.getElementById('socongvancvdtn');
	
	pcccdocumentreceiptClient.getDocumentRecordByDocType(documentTypeId, function (data) {
		if(data != null){
			elementSelect.options[0] = new Option(data.documentRecordTypeName, data.documentRecordTypeId);
		}
	});
	changeSoHieuVBPublic();
}

// lay so hieu + phan mo rong phong ban theo loai vb
function changeSoHieuVBPublic() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
 	var departmentsId = DWRUtil.getValue('departmentsId');
 	var numofdirector = DWRUtil.getValue('numofdirector');

 	if (document.getElementById('numofdirector').checked) {
 		document.getElementById('phanmorong').removeAttribute('readonly');
 	}
 	else {
 		document.getElementById('phanmorong').setAttribute('readonly', 'readonly');
 	}

 	// lay so
 	getSoVaKyHieuVB();
}

 // lay so cong van va so / ky hieu vb di phat hanh theo loai vb
function getDocumentRecordByDocTypeIdPhatHanh() {
 	var documentTypeId = DWRUtil.getValue('loaicongvancvdtn');
 	var elementSelect = document.getElementById('socongvancvdtn');
 	
 	pcccdocumentreceiptClient.getDocumentRecordByDocType(documentTypeId, function (data) {
 		if(data != null){
 			elementSelect.options[0] = new Option(data.documentRecordTypeName, data.documentRecordTypeId);
 		}
 	});
 	getSoVaKyHieuVB();
}

 // neu edit so va ky hieu vb di thi kiem tra so / ky hieu do da ton tai trong db chua
function kiemTraSoVaKyHieuVB() {
  	// Ham kiem tra document reference, tra ve true/false
  	var sohieu = document.getElementById("sohieucvdtn");
  	var phanmorong = document.getElementById("phanmorong");
  	var ngaybanhanh = document.getElementById("ngaybanhanhcvdtn");
  	
  	var documentSendIdHidden = document.getElementById("documentSendId");
 	var documentSendId = 0;
  	
  	var yearForCheck = 0;

  	if (sohieu == null || sohieu.value == "" || ngaybanhanh == null) {
  		return true; // Khong kiem tra duoc, tra ve true.
  	}

  	var sovbphathanh = sohieu.value.trim() + phanmorong.value.trim();

  	try {
  		var arrDate = ngaybanhanh.value.split("/");
  		yearForCheck = parseInt(arrDate[2]);
  	} catch (err) {
  		yearForCheck = 0;
  	}

 	if (documentSendIdHidden != null) {
 		documentSendId = documentSendIdHidden.value;
 	} else {
 		documentSendId = 0;
 	}
 		
  	pcccdocumentsendprocessClient.kiemTraSoVaKyHieuVBPhatHanh(sovbphathanh, yearForCheck, documentSendId, function (data) {
  		if (data > 0) { // neu ton tai so den theo so
  			alert("<liferay-ui:message key='so-va-ky-hieu-vb-phat-hanh-da-ton-tai'/>");

  			// lay so
 			getSoVaKyHieuVB();
  		}
  	});
}

 //ham lay so va ky hieu vb di
function getSoVaKyHieuVB() {
  	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
  	var departmentsId = DWRUtil.getValue('departmentsId');
  	var numofdirector = DWRUtil.getValue('numofdirector');

  	var sohieuHidden = document.getElementById("sohieuHidden");
  	var phanmorongHidden = document.getElementById("phanmorongHidden");
  	var loaiVBHidden = document.getElementById("loaiVBHidden");
  	
  	pcccdocumentsendprocessClient.getSoHieuVB(documentTypeId, numofdirector, function (data) {
 		if (data != 0) {
 			if (sohieuHidden != null 
 					&& loaiVBHidden != null  && loaiVBHidden.value == documentTypeId) {
 				document.getElementById('sohieucvdtn').value = sohieuHidden.value;
 			} else {
 				document.getElementById('sohieucvdtn').value = data;
 			}
 		}
 	});

  	pcccdocumentsendprocessClient.getPhanMoRong(documentTypeId, departmentsId, numofdirector, function (data) {
 		if (data != null && data != "") {
 			if (phanmorongHidden != null 
 					&& loaiVBHidden != null  && loaiVBHidden.value == documentTypeId){
 				document.getElementById('phanmorong').value = phanmorongHidden.value;
 			} else {
 				document.getElementById('phanmorong').value = data;
 			}
 		}
 	});
}
</script>
	