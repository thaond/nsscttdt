<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<script type="text/javascript" >
/* function add row*/
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file

function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function validateCVDDocReceipt(){
	fileUpload();	
	
	var socongvan = document.getElementById('socongvancvdtn');	
	var loaicongvan = document.getElementById('loaicongvancvdtn');	
	//var nguoiky = document.getElementById('nguoikycvdtn');	
	var socongvanden = document.getElementById('soCVdencvdtn');	
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	var ngayphathanh = document.getElementById('ngayphathanhcvdtn');
	var ngayden = document.getElementById('ngaydencvdtn');
	var trichyeu = document.getElementById('trichyeucvdtn');
	var nph = ngayphathanh.value;
	var nd = ngayden.value
	var cvdtime = document.getElementById('dateArriveTime');
	var sohieu = document.getElementById('sohieucvdtn');

	//var editnumber = document.getElementById('editnumber');
	//var phanso = document.getElementById('phanso');
	
	if (socongvanden.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-so-cong-van-den'/>\n";
	    alert(messageError);
	    socongvanden.focus();
		return false;
	}

	/*
	// phmphuc update 05/01/2011 - kiem tra them phanso nhap vao
	if (!editnumber.checked) {
		if (phanso.value == "" || isNaN(phanso.value) || phanso.value < 1) {
			messageError = "<liferay-ui:message key='vui-long-nhap-so-va-lon-hon-0'/>\n";
		    alert(messageError);
		    phanso.focus();
			return false;
		} 
	}*/

	if (sohieu.value.trim() == "") {
	    messageError = "<liferay-ui:message key='vui-long-nhap-so-hieu'/>\n";
	    alert(messageError);
		sohieu.focus();
		return false;
	} else {
		// kiem tra so hieu ko duoc trung, neu trung thi ko luu
		// checkDocRef();
	}

	if (ngayphathanh.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-ngay-phat-hanh'/>\n";
	    alert(messageError);
	    ngayphathanh.value = "";
	    ngayphathanh.focus();
		return false;
	}

	if (ngayden.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-ngay-den'/>\n";
	    alert(messageError);
	    ngayden.value = "";
	    ngayden.focus();
		return false;
	}

	if (noiphathanh.selectedIndex == 0 && khac.value.trim() == "") {
	    messageError = "<liferay-ui:message key='pccc-cvdtn-RB3'/>\n";
	    alert(messageError);
	    khac.value = "";
	    return false;
	}

	/*	
	if (nguoiky.value.trim() == "") {
    	messageError = "<liferay-ui:message key='vui-long-nhap-thong-tin-nguoi-ky'/>\n";
    	alert(messageError);
    	nguoiky.value = "";
    	nguoiky.focus();
    	return false;
    }*/	

	if (isDate(nph) == false) {
		ngayphathanh.focus();
		return false;
	}
	
	if (isDate(nd) == false ) {		
		ngayden.focus();
		return false;
	}	
	
	var todaycompare = new Date();
	
	var obj2 = nph.toString();
	var nphcompare = sgs.stringToDate(obj2, "dmy");

	var obj3 = nd.toString();
	var ndcompare = sgs.stringToDate(obj3, "dmy");
		
	if (nphcompare  >= todaycompare) {
	    messageError = "<liferay-ui:message key='ngayphathanhphainhohonhoacbangngayhientai'/>\n";
	    alert(messageError);
	    ngayphathanh.focus();
	    return false;
	  }
	  
	if (ndcompare >= todaycompare) {
	    messageError = "<liferay-ui:message key='ngaydenphainhohonhoacbangngayhientai'/>\n";
	    alert(messageError);
	    ngayden.focus();
	    return false;
	  }
	  
	if (ndcompare < nphcompare) {
	    messageError = "<liferay-ui:message key='pccc-cvdtn-RB17'/>\n";
	    alert(messageError);
	    ngayphathanh.focus();
	    return false;
	}
	
	if (trichyeu.value.trim() == "") {
    	messageError = "<liferay-ui:message key='nhap-thong-tin-trich-yeu'/>\n";
    	alert(messageError);
    	trichyeu.value = "";
    	trichyeu.focus();
    	return false;
    }
	
	if (checkFileUpload() == false) {
		return false;
	}
	else {
		return true;
	}
	
}

// yenlt update 31052010
function validateWriteDoc(){
	fileUpload();	
	
	var messageError="";
	//var noinhancvdtn = document.getElementById('receiveplace');	
	var nguoikycvdtn = document.getElementById('signer');	
	var socongvancvdtn = document.getElementById('socongvancvdtn');	
	var loaicongvancvdtn = document.getElementById('loaicongvancvdtn');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');

	if (socongvancvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-so-cong-van-den'/>\n";
	    alert(messageError);
	    socongvancvdtn.focus();
		return false;
	}	
	if (loaicongvancvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-loai-cong-van-den'/>\n";
	    alert(messageError);
	    loaicongvancvdtn.focus();
		return false;
	}	

	//if (noinhancvdtn.value.trim() == "") {
	//	messageError = "<liferay-ui:message key='vui-long-nhap-thong-tin-noi-nhan'/>\n";
	//    alert(messageError);
	//    noinhancvdtn.focus();
	//	return false;
	//}


	if (nguoikycvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-thong-tin-nguoi-ky'/>\n";
	    alert(messageError);
	    nguoikycvdtn.focus();
		return false;
	}


	if (trichyeucvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='doc-r5-alert'/>\n";
	    alert(messageError);
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
// end yenlt 31052010

function checkonchangBR3(){
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	if (noiphathanh.selectedIndex > 0 ){
		khac.value ="";
	    khac.disabled =true;
	  }
	
	if (noiphathanh.selectedIndex == 0 ){
	    khac.disabled =false;
	    messageError = "<liferay-ui:message key='pccc-cvdtn-RB3'/>\n";
	  }
}

/*/---------------phan them file dinh kem*/


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

function ValidateFormIsvaliddate(){
	
	var ngayphathanhisvalid = document.getElementById('ngayphathanhcvdtn');
	var ngaydenisvalid = document.getElementById('ngaydencvdtn');
	
	if (isDate(ngayphathanhisvalid.value)==false){
		ngaynop.focus();
		ngaynop.select();
		return false
	}
	
	if (isDate(ngaydenisvalid.value)==false){
		ngayhen.focus();
		ngayhen.select();
		return false
	}
	
    return true
 }



/*---------validate time hh:mm:ss*/
function IsValidTime(timeStr) {
	// Checks if time is in HH:MM:SS  format.

	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s)?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
	alert("Time is not in a valid format (HH:MM:SS).");
	return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 23) {
	alert("Hour must be between 0 and 23.");
	return false;
	}

	if (minute<0 || minute > 59) {
	alert ("Minute must be between 0 and 59.");
	return false;
	}
	if (second != null && (second < 0 || second > 59)) {
	alert ("Second must be between 0 and 59.");
	return false;
	}
	return false;
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
	elementSelect.options.length = 1;
	var otherplace = document.getElementById('khaccvdtn').disabled =false;	
	pcccdocumentreceiptClient.getIssuingPlaces(levelSendId, function (data) {
		if (data.length > 0) {
			elementSelect.options.length = 1 + data.length;
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

	if (elementSelect.hasChildNodes()) {
	    while (elementSelect.childNodes.length >= 1) {
	    	elementSelect.removeChild(elementSelect.firstChild);       
	    } 
	}
	pcccdocumentreceiptClient.getDocumentType(documentRecordTypeId, function (data){
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				elementSelect.options[i] = new Option(data[i].documentTypeName, data[i].documentTypeId);
			}
			changeDocumentType();
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
	//var loaicongvancvdtnHidden =  DWRUtil.getValue('loaicongvancvdtnHidden');
	var soCVdencvdtnHidden =  DWRUtil.getValue('soCVdencvdtnHidden');
	
	var <portlet:namespace/>documentRecordTypeIdHidden =  DWRUtil.getValue('<portlet:namespace/>documentRecordTypeIdHidden');

	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = DWRUtil.getValue('userId');
	var <portlet:namespace/>documentRecordTypeCode = document.getElementById('<portlet:namespace/>documentRecordTypeCode').value;
	var <portlet:namespace/>documentTypeCode = document.getElementById('<portlet:namespace/>documentTypeCode').value;
	var <portlet:namespace/>textAdd = document.getElementById('<portlet:namespace/>textAdd').value;
	var <portlet:namespace/>departmentCode = document.getElementById('<portlet:namespace/>departmentCode').value;
	var <portlet:namespace/>useYear = document.getElementById('<portlet:namespace/>useYear').value;
	pcccdocumentreceiptClient.getNumberDocumentReceipt(documentRecordTypeId, documentTypeId, userId, <portlet:namespace/>documentRecordTypeIdHidden , <portlet:namespace/>documentRecordTypeCode, <portlet:namespace/>documentTypeCode, <portlet:namespace/>textAdd, <portlet:namespace/>departmentCode, <portlet:namespace/>useYear, function (data) {
		if (data != null) {
			/*
			if (!eval(<portlet:namespace/>documentRecordTypeCode) && eval(<portlet:namespace/>documentTypeCode)) {
				var dataArr = data.split("-");
				data = dataArr[0].split("/")[0] + "/" + dataArr[1];
				if (<portlet:namespace/>textAdd != "") {
					data +="-" + <portlet:namespace/>textAdd;
				}
			} else if (eval(<portlet:namespace/>documentRecordTypeCode) && !eval(<portlet:namespace/>documentTypeCode)) {
				data = data.split("-")[0];
				if (<portlet:namespace/>textAdd != "") {
					data +="-" + <portlet:namespace/>textAdd;
				}
			} else if (!eval(<portlet:namespace/>documentRecordTypeCode) && !eval(<portlet:namespace/>documentTypeCode)) {
				data = data.split("/")[0] + <portlet:namespace/>textAdd;
			} else {
				data = data + "-" + <portlet:namespace/>textAdd;
			}
			
			if (documentRecordTypeIdHidden == documentRecordTypeId ) {
				data = (parseInt(soCVdencvdtnHidden.split("/")[0])) + "/" + data.split("/")[1]
			}
                       */
			
			document.getElementById('soCVdencvdtn').value = data ;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
	});
}



function uploadReceiptfile()
{
	var table=document.getElementById('addfileupload').insertRow(1);
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	title.innerHTML="<input style='width: 95%' name='<portlet:namespace/>titlefile' type='text' id='titlefile" +incstt+"'>";
	nameDocument.innerHTML="<input style='width: 95%' type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"'>";
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
	for(i = incstt -1 ; i >= 0; i--) {
		if(document.getElementById('namefile'+ i)) {			
			var valueNameFile1 = document.getElementById('namefile'+ i).value;
			var fileTitle = document.getElementById('titlefile'+ i);
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1);
			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
				fileTitle.focus();
				return false;
			}
				
			if("html" == type || "htm" == type || "doc" == type || "docx" == type || "xls" == type || "xlsx" == type || "jpg" == type || "pmp" == type || "pdf" == type) {
				return true;
			}
			else {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>");
				fileTitle.focus();
				return false;
			}
		}
	}
	return true;
}

/*
 * open popup
 */
function <portlet:namespace/>openReceivingPlacePopup() {
	var host = location.host;
	alert(host);
	var path = "http://" + host + "/html/portlet/ext/pcccdocumentsend/popup1.jsp"; 
	var openWindow = window.open(path, "openWindow", "model = true, location = 1, status = 1, scrollbars = 1, width = 800px, height = 400px");
	var posX = screen.width / 4;
	var posY = screen.width / 4;
	openWindow.moveTo(posX, posY);
}
//yenlt check chon nguoi nhan bao cao 06052010
function checkReceiver(){
	var receiverId = document.getElementById("receiverId");
	if (receiverId.value.trim() == "[Ch\u1ecdn]"){
		alert("<liferay-ui:message key='chon-nguoi-nhan'/>")
		receiverId.focus();
		return false;		
	}
}

// end yenlt 06052010

// kiem tra du lieu dau vao cua cong van bao cao co hop ly hay khong
function validateDocumentReport(){
	// minh update 20101227
	var listUserReceiptReport = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
	document.getElementById('<portlet:namespace/>receiverIdReports').value = listUserReceiptReport;
	var listUserReceiptReportArr = listUserReceiptReport.split(",");
	var checkReport = false;
	for (var i=0; i<listUserReceiptReportArr.length; i++) {
		if ((document.getElementById("<portlet:namespace/>report" + listUserReceiptReportArr[i])!=null)
				&& (document.getElementById("<portlet:namespace/>report" + listUserReceiptReportArr[i])).checked){
			document.getElementById('<portlet:namespace/>receiverIdReportMain').value = listUserReceiptReportArr[i];
			checkReport = true;
		}
	}
	
	fileUpload(); // yenlt
	if (checkFileUpload() == false) {		
		return false;
	}
	
	if (!checkReport) {
		alert("<liferay-ui:message key='chon-nguoi-nhan-bao-cao-va-nguoi-nhan-bao-cao-chinh'/>")
		return false;
	}
	//if (checkReceiver() == false) {
	//	return false;
	//}
	
	// end minh update 20101227
	else {
		return true;
	}
}

//phmphuc get 12/07/2010 - neu so van ban di phuc dap khong ton tai se hien thi dong thong bao
function checkReponseNumberDocument(valueReponseNumberDocument) {
	var cohaykhongsocongvandiphucdap = document.getElementById('cohaykhongsocongvandiphucdap');

	if (valueReponseNumberDocument.trim()== "") {
		cohaykhongsocongvandiphucdap.innerHTML = "";
	}
	else {
		pcccdocumentreceiptClient.checkReponseNumberDocument(valueReponseNumberDocument, function (data) {
			if (data) {
				cohaykhongsocongvandiphucdap.innerHTML = "<liferay-ui:message key='so-cong-van-phuc-dap-da-tontai'/>"
			}
			else {
				cohaykhongsocongvandiphucdap.innerHTML = "<liferay-ui:message key='so-cong-van-phuc-dap-khong-ton-tai'/>"
			}
		});
	}
} 

// phmphuc get 12/07/2010 - thay doi Ngay den
function doStop() {
	var edit = document.getElementById('edittime');
	var focusdate = document.getElementById('ngaydencvdtn');
	var cal = document.getElementById('cal-button-dateArrive');

	if(edit.checked) {
		focusdate.focus();
		focusdate.removeAttribute('readOnly');
		cal.setAttribute('src', '/html/images/cal.gif');
	} else {
		focusdate.setAttribute('readOnly', 'readonly');
		cal.removeAttribute('src');
	}
}

// minh update 30/10/2010
function deleteRowFileUpload(r, id)
{
	var str_fileattachedfile = document.getElementById('str_fileattachedfiletodelete').value;
	str_fileattachedfile += id + "/";
	document.getElementById('str_fileattachedfiletodelete').value = str_fileattachedfile;
	
	 var i = r.parentNode.parentNode.rowIndex;
	 document.getElementById("recentFile").deleteRow(i);
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

/* phmphuc add functions 05/01/2011
 * cho phep cap nhat so den theo so
 * nhung phai kiem tra so den da ton tai chua
 */
function editNumberDocumentReceipt() {
	var editnumber = document.getElementById('editnumber');
	var soCVdencvdtn = document.getElementById('soCVdencvdtn');
	
	var div1 = document.getElementById('div1');
	var div2 = document.getElementById('div2');
	var phanso = document.getElementById('phanso');
	var phanmorong = document.getElementById('phanmorong');

	// Check: lay so tu dong
	if (editnumber.checked) {
		div1.style.display = "inline";
		div2.style.display = "none";
	} 
	// Uncheck: cho thay doi so bang tay
	else {
		div1.style.display = "none";
		div2.style.display = "inline";
	}
}

function checkNumberDocumentReceipt() {
	// Ham kiem tra document reference, tra ve true/false
	var phanso = document.getElementById("phanso");
	var phanmorong = document.getElementById("phanmorong");
	var ngayPHObj = document.getElementById("ngayphathanhcvdtn");

	var documentReceiptId = document.getElementById("documentreceiptid");
	var phansohidden = document.getElementById("phansohidden");
	
	var yearForCheck = 0;

	if (phanso == null || phanso.value == "" || ngayPHObj == null) {
		return true; // Khong kiem tra duoc, tra ve true.
	}

	var numberDocumentReceipt = phanso.value + phanmorong.value;

	try {
		var arrDate = ngayPHObj.value.split("/");
		yearForCheck = parseInt(arrDate[2]);
	} catch (err) {
		yearForCheck = 0;
	}

	pcccdocumentreceiptClient.countByNumberDocumentReceipt(numberDocumentReceipt, yearForCheck, documentReceiptId.value, function (data) {
		if (data > 0) { // neu ton tai so den theo so
			alert("<liferay-ui:message key='so-den-theo-so-da-ton-tai'/>");
			document.getElementById("phanso").value = phansohidden.value;
		}
	});
}

function checkDocRef() {
	// Ham kiem tra document reference, tra ve true/false
	var docRefObj = document.getElementById("sohieucvdtn");
	var ngayPHObj = document.getElementById("ngayphathanhcvdtn");

	var documentReceiptId = document.getElementById("documentreceiptid");
	var sohieucvdtnhidden = document.getElementById("sohieucvdtnhidden");

	var yearForCheck = 0;

	if (docRefObj == null || docRefObj.value == "" || ngayPHObj == null) {
		return true; // Khong kiem tra duoc, tra ve true.
	}

	try {
		var arrDate = ngayPHObj.value.split("/");
		yearForCheck = parseInt(arrDate[2]);
	} catch (err) {
		yearForCheck = 0;
	}
		
	pcccdocumentreceiptClient.countByDocumentReference(docRefObj.value, yearForCheck, documentReceiptId.value, function (data) {
		if (data > 0) {// neu ton tai so hieu trung
			alert("<liferay-ui:message key='sohieu_phaico_khongtrung'/>");
			document.getElementById("sohieucvdtn").value = sohieucvdtnhidden.value;
		}
	});
}
/* end phmphuc add functions 05/01/2011 */

</script>
