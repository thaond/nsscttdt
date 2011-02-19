<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type='text/javascript' src='/dwr/interface/documentSendUtilClient.js'></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<script type="text/javascript" >
/* function add row*/
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file

window.onload = function () {	
	//getDateReturnClient(); // phmphuc close vi ham nay ko duoc dinh nghia
}

function trim (){
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function validateFormEdit() {
	//var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');

	//if (noinhancvdtn.value.trim() == "") {
	//	alert("<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>");
	//	noinhancvdtn.focus();
	//	return false;
	//}

	if (trichyeucvdtn.value.trim() == "") {
		alert("<liferay-ui:message key='doc-r5-alert'/>");
		trichyeucvdtn.focus();
		return false;
	}
	else {
		return true;
	}
}

function validateSendDocReceipt(){
	
	fileUpload();	

	//var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');
	
	if (!isBookDocumentSendAgencyClient()) {
		return false;
	}

	//if (noinhancvdtn.value.trim() == "") {
	//	alert("<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>");
	//	noinhancvdtn.focus();
	//	return false;
	//}
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
		alert("Accept number only!");
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

function uploadReceiptfile() {
	var table=document.getElementById('addfileupload').insertRow(1);
	var title = table.insertCell(0);
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	title.innerHTML = "<input style='width: 95%'  name='titlefile' type='text' id='titlefile" +incstt+"'>";
	nameDocument.innerHTML = "<input style='width: 95%' type='file' name='namefile" + incstt + "' id='namefile" + incstt + "' onchange='getFileNameForTitle(this)'>";
	deleteRow.innerHTML = "<div align='center'><input style='width: 90%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
	incstt += 1;
}

function getFileNameForTitle(obj) {
	if (obj.type != "file") return;
	var id = obj.id;
	var filePath = obj.value;
	if (id != null && id != "") {
		var numOfId = id.replace("namefile", "");
		var titleObj = document.getElementById("titlefile" + numOfId);
		if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
			var arrTmp = filePath.split("\\");
			if (arrTmp.length > 0) {
				var fileName = arrTmp[arrTmp.length - 1];
				if (fileName.length > 0) {
					var lastIdxDot = fileName.lastIndexOf(".");
					if (lastIdxDot > 0) {
						titleObj.value = fileName.substring(0, lastIdxDot);
					}
				} // end if
			} // end if
		} // end if
	} // end if
}

function deleteRow(row)
{
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
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

function mypopupIssuingplace() {   
	var posX = screen.width / 7;
	var posY = screen.height / 5;
	var heightPopup = 3 * posY - 80;
	var widthPopup = 5 * posX;
  	var host = location.host;
  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentsend/popup1.jsp";
  	var mywindow = window.open ( path ,"mywindow","status=1,scrollbars=1,width=" + widthPopup + "px ,height=" + heightPopup + "px");
  
  	mywindow.moveTo(posX , posY);
}

function mypopupSigner()
{   
	var posX = screen.width / 7;
	var posY = screen.height / 5;
	var heightPopup = 3 * posY - 80;
	var widthPopup = 5 * posX;
  	var host = location.host;
 	var path = "http://" + host + "/html/portlet/ext/pcccdocumentsend/popup2.jsp";
  	var mywindow = window.open ( path ,"mywindow","location=0,status=1,scrollbars=1,width=" + widthPopup + "px ,height=" + heightPopup + "px");
  	
  	mywindow.moveTo(posX , posY);
}

function getData(){	
	getDataHelp();
	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
	}
	else{
	
		window.opener.document.getElementById('receiveplace').value = document.getElementById('hidden').value;
		//xuancong close var idIssuingPlace = document.getElementById('issuingPlaceId').value;
		//xuancong close window.opener.document.getElementById('issuingPlaceId').value=idIssuingPlace;
		window.close();
	}
}

function getDataSigner(){
	
	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
	}
	else{
		window.opener.document.getElementById('signer').value = document.getElementById('hidden').value;
		window.opener.document.getElementById('position').value = document.getElementById('position').value;		
		window.close();
		
	}
}

function getDataCreator(){
	
	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-tn-vuilongchonnguoidung'/>");
	}
	else{
		window.opener.document.getElementById('creator').value = document.getElementById('hidden').value;
		window.opener.document.getElementById('dept').value = document.getElementById('department').value;		
		window.opener.document.getElementById('creatorIdSP').value = document.getElementById('creatorId').value;
		window.close();
		
	}
}

function getDataHelpSigner(chkId){	
	var elementRadioChecked = document.getElementById(chkId);
	if (elementRadioChecked.checked) {
		elementRadioChecked.checked = false;
	} else {
		elementRadioChecked.checked = true;
	}
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	//document.getElementById('signerId').value = arr[1];
	//document.getElementById('position').value = arr[2];
}

function getDataHelpCreator(chkId){	
	var elementRadioChecked = document.getElementById(chkId);
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('creatorId').value = arr[1];
	document.getElementById('department').value = arr[2];
	
}

function getDataHelpSigneOnRow(tdTable){	
	var idRow = (tdTable.id.split('_'))[1];	
	// minh update 20100531
	//var trTable = document.getElementById(idRow);
	//var elementRadioChecked = trTable.cells[0].firstChild;
	var elementRadioChecked = document.getElementById("chk_"+idRow);
	// minh update 20100531	
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	//document.getElementById('signerId').value = arr[1];
	//document.getElementById('position').value = arr[2];	
	window.opener.document.getElementById('signer').value = document.getElementById('hidden').value;
	window.opener.document.getElementById('position').value = document.getElementById('position').value;		
	window.close();
}

function getDataHelpCreatorOnRow(tdTable){	
	var idRow = (tdTable.id.split('_'))[1];	
	var trTable = document.getElementById(idRow);
	var elementRadioChecked = trTable.cells[0].firstChild;
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('creatorId').value = arr[1];
	document.getElementById('department').value = arr[2];
	
	window.opener.document.getElementById('creator').value = document.getElementById('hidden').value;
	window.opener.document.getElementById('dept').value = document.getElementById('department').value;	
	window.close();
}

function checkIssuePlace(elementRow) {	
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('chk_'+idElementTd);
	if (!elementInput.checked) {
		elementInput.checked = true;			
	}
	else {
		elementInput.checked = false;
	}
}

function clickCheckBox(event,eleCheckBox)
{
	//checkIssuePlace(eleCheckBox);
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

function getDataHelp(){	

	//var elementRadioChecked = trTable.cells[0].firstChild;
	//elementRadioChecked.checked = true;
	//var arr = elementRadioChecked.value.split("#");
	//document.getElementById('hidden').value = arr[0];
	//document.getElementById('issuingPlaceId').value = arr[1];
	
	var chkArr = document.getElementsByName("chk");
	var listId = "";
	var listValue = "";
	var arr = null;
	for (i = 0; i < chkArr.length; i++) {
		if (chkArr[i].checked) {
			arr = chkArr[i].value.split("#");
			listValue += arr[0]+",";
			listId += arr[1]+ ",";
		}		
	}	
	document.getElementById('hidden').value = listValue.substring(0, listValue.length -1 );
	//document.getElementById('issuingPlaceId').value = listId.substring(0,listValue.length -1 );
	
}

function getDataHelpTemp(trTable){		
	checkIssuePlace(trTable);
	
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
	var daysInMonth = DaysArray(12);
	var pos1=dtStr.indexOf(dtCh);
	var pos2=dtStr.indexOf(dtCh,pos1+1);
	var strDay=dtStr.substring(0,pos1);
	var strMonth=dtStr.substring(pos1+1,pos2);
	var strYear=dtStr.substring(pos2+1);
	strYr=strYear;
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
	}
	month=parseInt(strMonth, 10);
	day=parseInt(strDay, 10);
	year=parseInt(strYr, 10);
	
	if (strMonth.length<1 || month<1 || month>12){
		alert("<liferay-ui:message key='Please-enter-a-valid-month'/>");
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("<liferay-ui:message key='please-enter-a-valid-day'/>");
		return false;
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("<liferay-ui:message key='Please-enter-a-valid-4-digit-year'/>");
		return false;
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("<liferay-ui:message key='Please-enter-a-valid-date'/>");
		return false;
	}
	return true;
}

//kiem tra so cong van den cua lanh dao so co hay khong
/*
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
*/

//check book document send exist ??? use ajax synchronied
 function isBookDocumentSendAgencyClient() {
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = document.getElementById('userId').value	
	pcccdocumentreceiptClient.isBookDocumentSendAgency(documentRecordTypeId, userId, {callback:setValuesDocumentSendAgencyInDWR, async:false});
	var result = document.getElementById('isBookDocumentRecord').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='Book-document-send-not-exist'/>");
 	 	return false;
 	}
 	else {
 		return true;
 	} 	
}

var setValuesDocumentSendAgencyInDWR = function (data) {
	 
 	if (!data) {
 		document.getElementById('isBookDocumentRecord').value = false; 
 	}
 	else { 	 	
 		document.getElementById('isBookDocumentRecord').value = true;
 	}
 };
 

 function processButtonSend(url) {
		document.getElementById('redirect').value = url;
		var result = validateSendDocReceipt();
		if (result) {
			document.formdocumentsend.submit();
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		}
	}
	
var rowAdd = 0; 
function addNewRelUnit(tblId, idButSave) {
	if (rowAdd == 0) {
	var tblObj = document.getElementById(tblId);
	if (tblObj == null) return;
	var newRow = tblObj.insertRow(tblObj.rows.length);
	//newRow.class = "rowOneT1";
	newRow.setAttribute("class", "rowOneT1");
	newRow.style.backgroundColor = "#EAEBDB";
	// Checkbox
	var tdChk = newRow.insertCell(0);
	// Stt
	var tdStt = newRow.insertCell(1);
	// Ma so
	var tdCode = newRow.insertCell(2);
	var txtCode = document.createElement("input");
	txtCode.type = "text";
	txtCode.name = "txtNewCode";
	txtCode.id = "txtNewCode";
	txtCode.style.width = "98%";
	tdCode.appendChild(txtCode);
	// Ten
	var tdName = newRow.insertCell(3);
	var txtName = document.createElement("input");
	txtName.type = "text";
	txtName.name = "txtNewName";
	txtName.id = "txtNewName";
	txtName.style.width = "98%";
	tdName.appendChild(txtName);
	// Ghi chu
	var tdNote = newRow.insertCell(4);
	var txtNote = document.createElement("input");
	txtNote.type = "text";
	txtNote.name = "txtNewNote";
	txtNote.id = "txtNewNote";
	txtNote.style.width = "98%";
	tdNote.appendChild(txtNote);
	// Hien thi nut
	var btnSave = document.getElementById(idButSave);
	if (btnSave != null) {
		btnSave.setAttribute('type','button');
	} // end if
	
	// horizontal and vertical scroll increments
	var divContent = document.getElementById('content');
	window.scrollBy(0,divContent.clientHeight); 
	rowAdd=1;
	}
}

function checkValidForNewRelUnit() {
	// ******** Kiem tra du lieu nhap tren form de them moi **********
	// Ma so
	var objItem = document.getElementById("txtNewCode");
	if (objItem.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ma-so' />");
		if (objItem.disabled == false) objItem.focus();
		return false;	
	}
	// Ten
	var objItem = document.getElementById("txtNewName");
	if (objItem.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ten-don-vi' />");
		if (objItem.disabled == false) objItem.focus();
		return false;	
	}
	return true;
}

function saveNewRelUnit() {
	// ************ Ham dung luu don vi moi vao database *************
	if (checkValidForNewRelUnit() == false) return;
	// Lay gia tri
	var issuingPlaceId = document.getElementById("txtNewCode").value;
	var issuingPlaceName = document.getElementById("txtNewName").value;
	var note = document.getElementById("txtNewNote").value;

	// Them vao database
	pcccdocumentreceiptClient.addPmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName, note, function (data) {
		if (data == true) { // Them thanh cong
			alert("<liferay-ui:message key='da-them-don-vi-moi' />");
			rowAdd=0;
			window.location.reload(true);
		}
		else {
			alert("<liferay-ui:message key='khong-them-duoc-don-vi-moi.vui-long-kiem-tra-du-lieu-nhap' />");
		}
	});
}

// ********** Doc danh sach nguoi dung va tao ra combo box dung de them nguoi dung ****************
var cboUserForAdd = document.createElement("select");

documentSendUtilClient.getUserDTOList(function (data) {
	if (data.length > 0) {
		for (var i = 0; i < data.length; i++) {		
			var pmlSigner = data[i];
			var newOpt = document.createElement("option");
			newOpt.setAttribute("value", pmlSigner.userId);
			newOpt.appendChild(document.createTextNode(pmlSigner.userName));
			cboUserForAdd.appendChild(newOpt);
		}
	}
	else {
		//alert ("khong co cap goi cong van");
	}
});

// ********** Ham dung de them nguoi ky moi ******************
var addSigner = 0;
function addNewSigner(tblId, idButSave) {
	if (addSigner == 0) {
	var tblObj = document.getElementById(tblId);
	if (tblObj == null) return;
	var newRow = tblObj.insertRow(tblObj.rows.length);
	//newRow.class = "rowOneT1";
	newRow.setAttribute("class", "rowOneT1");
	newRow.style.backgroundColor = "#EAEBDB";
	// Checkbox
	var tdChk = newRow.insertCell(0);
	// Stt
	var tdStt = newRow.insertCell(1);
	// Ten nguoi dung
	var tdCode = newRow.insertCell(2);
	cboUserForAdd.setAttribute("id", "cboUserForAdd");
	tdCode.appendChild(cboUserForAdd);
	// Chuc vu
	var tdName = newRow.insertCell(3);

	// Hien thi nut
	var btnSave = document.getElementById(idButSave);
	if (btnSave != null) {
		btnSave.setAttribute('type','button');
	} // end if
	
	// horizontal and vertical scroll increments
	var divContent = document.getElementById('content');
	window.scrollBy(0,divContent.clientHeight); 
	addSigner = 1;
	}
}

// ******* Ham kiem tra du lieu nhap de them nguoi ky ***************
function checkValidForNewSigner() {
	// Ma so nguoi dung
	var objItem = document.getElementById("cboUserForAdd");
	if (objItem == null) return false;
	if (objItem.value.trim() == "" ) {
		alert("<liferay-ui:message key='vui-long-chon-nguoi-dung' />");
		if (objItem.disabled == false) objItem.focus();
		return false;	
	}
	return true;
}

// ************ Ham dung luu nguoi moi vao database *************
function saveNewSigner() {
	if (checkValidForNewSigner() == false) return;
	// Lay gia tri
	var userId = document.getElementById("cboUserForAdd").value;

	// Them vao database
	documentSendUtilClient.addSigner(userId, function (data) {
		if (data == true) { // Them thanh cong
			alert("<liferay-ui:message key='da-them-nguoi-ky-moi' />");
			addSigner = 0;
			window.location.reload(true);
		}
		else {
			alert("<liferay-ui:message key='khong-them-duoc-nguoi-ky-moi.vui-long-kiem-tra-du-lieu-nhap' />");
		}
	});
}

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
}

/*
 * minh update 20100215
 */
// load so van ban the do vi hay la phong

	function loadDocumentRecordType() {
		var  valueChecked = document.getElementById("soVanBanCuaPhong").checked;
		var  userIdLogin = document.getElementById("userIdLogin").value;
		var  socongvancvdtnSelect = document.getElementById("socongvancvdtn");
		DWRUtil.removeAllOptions("socongvancvdtn");
		DWRUtil.removeAllOptions("loaicongvancvdtn");
		pcccdocumentreceiptClient.loadDocumentRecordType(userIdLogin, valueChecked, function (data){
			if (data.length > 0) {
				for ( var i = 0; i < data.length; i++) {
					socongvancvdtnSelect.options[i] = new Option(data[i].documentRecordTypeName, data[i].documentRecordTypeId);
				}
				// load lai loai van ban theo so cua so hoac phong
				changeDocumentRecordType();
			}
	
			else {
				//alert("khong co docment type")
			}		
		});
	}

</script>
	