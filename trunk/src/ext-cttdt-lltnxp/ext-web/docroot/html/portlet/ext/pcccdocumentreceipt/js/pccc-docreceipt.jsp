<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%
// Lay phan mo rong cua cong van
String phanMoRong = PropsUtil.get("congvan.den.morong");
%>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type="text/javascript" >
/* function add row*/
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file
window.onload = function () {	
	getDateReturnClient();	
}

// kiem tra noi phat hanh truoc nguoi ky - phmphuc get 09/07/2010
/* phmphuc close 26/07/2010
function checkSigner() {
	var nguoiky = document.getElementById('nguoikycvdtn');	
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	var messageError = "";
	if (noiphathanh.selectedIndex == 0 && khac.value.trim() == "") {
       	messageError = "<liferay-ui:message key='vui-long-chon-noi-phat-hanh-truoc'/>\n";
       	alert(messageError);
       	noiphathanh.focus();
       	return false;
    }	
}*/ 
// end

function validateCVDDocReceipt() {
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
	var sohieu = document.getElementById('sohieucvdtn');	

	var editnumber = document.getElementById('editnumber');
	var phanso = document.getElementById('phanso');	

	//so cong van den cua lanh dao khong can thiet ben thu thiem
//	if (!isBookDocumentRecordAgencyClient()) {
//		return false;
//	}
	
	if (socongvanden.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-so-cong-van-den'/>\n";
	    alert(messageError);
	    socongvanden.value = "";
	    socongvanden.focus();
		return false;
	}

	// phmphuc update 05/01/2011 - kiem tra them phanso nhap vao
	if (!editnumber.checked) {
		if (phanso.value == "" || isNaN(phanso.value) || phanso.value < 1) {
			messageError = "<liferay-ui:message key='vui-long-nhap-so-va-lon-hon-0'/>\n";
		    alert(messageError);
		    phanso.focus();
			return false;
		} 
	}
	
	if (sohieu.value.trim() == "") {
	    messageError = "<liferay-ui:message key='vui-long-nhap-so-hieu'/>\n";
	    alert(messageError);
	    sohieu.value = "";
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
	    noiphathanh.focus();
	    return false;
	}
	
    //if (nguoiky.value.trim() == "") {
    //	messageError = "<liferay-ui:message key='vui-long-nhap-thong-tin-nguoi-ky'/>\n";
    //	alert(messageError);
    //	nguoiky.value = "";
    //	nguoiky.focus();
    //	return false;
    //}

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
	
function clickRadio(event) {	
	if (event) { // firefox
		event.stopPropagation();	
	}
	else // windows
		window.event.cancelBubble = true;
	return true; // co the false, bo
}

function checkonchangBR3() {
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	var nguoiKy = document.getElementById('nguoikycvdtn');
	var hidSignerList = document.getElementById("hidSignerList");
	if (noiphathanh.selectedIndex > 0 ) {
		khac.value = "";
	    khac.disabled = true;
	    // ***** Phan xu ly lay ten nguoi ky *****
		pcccdocumentreceiptClient.getPmlEdmIssuingPlace(noiphathanh.value, function (data) {
			if (data != null && data != "") { // Lay duoc doi truong
				var signer = data.signer;
				if (hidSignerList != null) {
				hidSignerList.value = signer;
				}
				nguoiKy.value = signer.split(";")[0];
			}
			else {
				if (nguoiKy != null) nguoiKy.value = "";
			}
		});
	}
	
	if (noiphathanh.selectedIndex == 0 ) {
	    khac.disabled =false;
	    khac.focus();
	    messageError = "<liferay-ui:message key='pccc-cvdtn-RB3'/>\n";
	  }
}

/*/---------------phan them file dinh kem*/

/**
 * DHTML date validation script for dd/mm/yyyy. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */
// Declaring valid date character, minimum year and maximum year
var dtCh = "/";
var minYear = 1900;
var maxYear = 2100;
var ngaynop = document.getElementById('applicationDate');
var ngayhen = document.getElementById('expectedReturningDate');
var ngaynhap = document.getElementById('inputDataDate');

function isInteger(s) {
	var i;
    for (i = 0; i < s.length; i++) {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag) {
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++) {   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year) {
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31;
		if (i == 4 || i == 6 || i == 9 || i == 11) {
			this[i] = 30;
   } 
		if (i == 2) {
			this[i] = 29;
		}
   } 
   return this;
}

function isDate(dtStr) {
	var daysInMonth = DaysArray(12)
	var pos1 = dtStr.indexOf(dtCh);
	var pos2 = dtStr.indexOf(dtCh, pos1 + 1);
	var strDay = dtStr.substring(0, pos1);
	var strMonth = dtStr.substring(pos1 + 1, pos2);
	var strYear = dtStr.substring(pos2 + 1);
	strYr = strYear;
	if (strDay.charAt(0) == "0" && strDay.length > 1) strDay = strDay.substring(1);
	if (strMonth.charAt(0) == "0" && strMonth.length > 1) strMonth = strMonth.substring(1);
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0) == "0" && strYr.length > 1) strYr = strYr.substring(1);
	}
	month = parseInt(strMonth);
	day = parseInt(strDay);
	year = parseInt(strYr);
	if (pos1 == -1 || pos2 == -1) {
		//alert("The date format should be : dd/mm/yyyy");
		return false;
	}
	if (strMonth.length < 1 || month < 1 || month > 12) {
		alert("<liferay-ui:message key='Please-enter-a-valid-month'/>");
		return false;
	}
	if (strDay.length < 1 || day < 1 || day > 31 || (month == 2 && day > daysInFebruary(year)) || day > daysInMonth[month]) {
		alert("<liferay-ui:message key='please-enter-a-valid-day'/>");
		return false;
	}
	if (strYear.length != 4 || year == 0 || year < minYear || year > maxYear) {
		alert("<liferay-ui:message key='Please-enter-a-valid-4-digit-year'/>");
		return false;
	}
	if (dtStr.indexOf(dtCh, pos2 + 1) != -1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
		alert("<liferay-ui:message key='Please-enter-a-valid-date'/>");
		return false;
	}
return true;
}

function ValidateFormIsvaliddate() {
	
	var ngayphathanhisvalid = document.getElementById('ngayphathanhcvdtn');
	var ngaydenisvalid = document.getElementById('ngaydencvdtn');
	
	if (isDate(ngayphathanhisvalid.value) == false) {
		ngaynop.focus();
		ngaynop.select();
		return false;
	}
	
	if (isDate(ngaydenisvalid.value) == false) {
		ngayhen.focus();
		ngayhen.select();
		return false;
	}
	
    return true;
 }

/*---------validate time hh:mm:ss*/
function IsValidTime(timeStr) {
	// Checks if time is in HH:MM:SS  format.

	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s)?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
	alert("<liferay-ui:message key='dinh-dang-thoi-gian-khong-dung' />");
	return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second == "") { 
		second = null; 
	}
	if (ampm == "") { 
		ampm = null;
	}

	if (hour < 0  || hour > 23) {
	alert("<liferay-ui:message key='gio-khong-hop-le' />");
	return false;
	}

	if (minute < 0 || minute > 59) {
	alert ("<liferay-ui:message key='phut-khong-hop-le' />");
	return false;
	}
	if (second != null && (second < 0 || second > 59)) {
	alert ("<liferay-ui:message key='giay-khong-hop-le' />");
	return false;
	}
	return true;
}
/*check number only use for all maybe onKeyPress="return numbersonly(this, event)"
 * or onkeyup="alert(!isNaN(this.value.charAt(this.value.length-1)))"
 */
function numbersonly(myfield, e, dec) {
var key;
var keychar;

	if (window.event) {
   key = window.event.keyCode;
	} else if (e) {
   key = e.which;
	} else {
   return true;
	}
keychar = String.fromCharCode(key);

// control keys
	if ((key == null) || (key == 0) || (key == 8) || 
		(key == 9) || (key == 13) || (key == 27)) {
   return true;
	} else if ((("0123456789").indexOf(keychar) > -1)) {
	   return true;
	} else if (dec && (keychar == ".")) {
   myfield.form.elements[dec].focus();
   return false;
	} else {
		alert("Accept number only!");
	}
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
	
	pcccdocumentreceiptClient.getDocumentType(documentRecordTypeId, function (data) {
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				elementSelect.options[i] = new Option(data[i].documentTypeName, data[i].documentTypeId);
			}

			
			// So cong van den khong phu thuoc vao loai cong van hay so cong van
			// xuancong close changeDocumentType();

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
	pcccdocumentreceiptClient.getNumberDocumentReceipt(documentRecordTypeId, documentTypeId, userId, function (data) {
		
		if (data != null) {
			document.getElementById('soCVdencvdtn').value = data;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
	});
}

function uploadReceiptfile()
{
	var table=document.getElementById('addfileupload').insertRow(1);
	
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);

	table.style.backgroundColor = "white";
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile' type='text' maxlength='255' id='titlefile" +incstt+"'>";
	nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"' onchange='getFileNameForTitle(this)'>";
	deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
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

function deleteRowFileUpload(r, id)
{
	var str_fileattachedfile = document.getElementById('str_fileattachedfiletodelete').value;
	str_fileattachedfile += id + "/";
	document.getElementById('str_fileattachedfiletodelete').value = str_fileattachedfile;
	
	 var i = r.parentNode.parentNode.rowIndex;
	 document.getElementById("recentFile").deleteRow(i);
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
			
			if(typeStandard.search(type.toLowerCase()) == -1) {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>");
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
/***bat dau chay thoi gian****/ 
 
 // Global variables for timer.    
  
var timerID = null;  
  
var timerRunning = false; 

function startTime() {
	var today = new Date();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
 // add a zero in front of numbers<10
	m = checkTime(m);
	s = checkTime(s);
	document.getElementById('dateArriveTime').value = h + ":" + m + ":" + s;
	t = setTimeout('startTime()', 500);
 timerRunning = true;  
 }
 
function startclock () {  
 // Make sure the clock is stopped    

 stopclock();  
 startTime();  
}

function doStop() {
	var edit = document.getElementById('edittime');
	var focustime = document.getElementById('dateArriveTime');

	/*
	if(edit.checked) {
		stopclock();
		focustime.focus();
	} else{
		startclock();
	}*/
	
	/*
	 * Khi không check vào Sua thi khong duoc cho thay doi ngay den thong qua calendar.
	 * An calendar 
	 * Khong cho thay doi gia tri cua Gio
	 */
	var focusdate = document.getElementById('ngaydencvdtn');
	var cal = document.getElementById('calendarImage');
	startTime();

	if(edit.checked) {
		focusdate.focus();
		focusdate.removeAttribute('readOnly');
		cal.style.display = "inline";
	} else {
		focusdate.setAttribute('readOnly', 'readonly');
		cal.style.display = "none";
	}
	// end
}


function stopclock () {  
	if(timerRunning) {
    clearTimeout(t);  
	}
 timerRunning = false;  
 }  
 
 function checkTime(i)
 {
 if (i<10)
   {
		i = "0" + i;
   }
 return i;
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

var setValuesInDWR = function (data) {	 
 	if (!data) {
 		document.getElementById('isBookDocumentRecord').value = false; 
 	}
 	else { 	 	
 		document.getElementById('isBookDocumentRecord').value = true;
 	}
 };

 function getGeneralNumberDocumentReceipt() {
 	var ngayDen = DWRUtil.getValue('ngaydencvdtn');
 	pcccdocumentreceiptClient.getGeneralNumberDocumentReceipt(ngayDen, function (data) {
 		
		if (data != -1) {
			var soKeTiep = data + 1;
			document.getElementById('soCVdencvdtn').value = soKeTiep + "<%= phanMoRong %>";
		}
		else {
			document.getElementById('soCVdencvdtn').value = "";
		}
	});
 }

 function processButton(url) {		
		document.getElementById('redirect').value = url;
		var result =validateCVDDocReceipt();
		//alert(url);
		if (result) {
			document.fname.submit();
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		}
}

function checkReponseNumberDocument(valueReponseNumberDocument) {
	var cohaykhongsocongvandiphucdap = document.getElementById('cohaykhongsocongvandiphucdap');
	var socongvandiphucdap = document.getElementById('socongvandiphucdap');

	// phmphuc update 10/07/2010 - khi xoa so van ban di phuc dap thi dong nay phai an
	if (valueReponseNumberDocument.trim()== "") {
		cohaykhongsocongvandiphucdap.innerHTML = "";//"<liferay-ui:message key='so-cong-van-phuc-dap-khong-ton-tai'/>"
	}
	else {
		pcccdocumentreceiptClient.checkReponseNumberDocument(valueReponseNumberDocument, function (data) {
			if (data) {
				cohaykhongsocongvandiphucdap.innerHTML = "<liferay-ui:message key='so-cong-van-phuc-dap-da-tontai'/>"
			}
			else {
				cohaykhongsocongvandiphucdap.innerHTML = "<liferay-ui:message key='so-cong-van-phuc-dap-khong-ton-tai'/>"
				socongvandiphucdap.focus();
			}
		});
	}
} 
  
function addEditRelUnitPop() {   
	var posX = screen.width / 7;
	var posY = screen.height / 5;
	var heightPopup = 450;
	var widthPopup = 5 * posX;
  	var host = location.host;
  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentreceipt/addeditrelunit.jsp";
  	var objPop = window.open (path, "objPop", "status=1,scrollbars=1,width=" + widthPopup + "px ,height=" + heightPopup + "px");
  
  	objPop.moveTo(posX , posY);
}

function selectSigner() {   
	var hidSignerList = document.getElementById("hidSignerList");
	var signerList = "";
	if (hidSignerList != null) {
		signerList = hidSignerList.value;
	} // end if
	// Parse ra danh sach de chon
	var signerContent = "";
	if (signerList.length > 0) {
		var arrSigner = signerList.split(";");
		for (var idx = 0; idx < arrSigner.length; idx ++) {
			var color = "#EFE2A4";
			if (idx % 2 == 0) color = "#E0EBEF";
			if (arrSigner[idx].length > 0) {
				signerContent += "<div style='height: 20px; padding-left: 4px; vertical-align: middle; cursor: pointer; background-color: " + color + "' onclick='retSigner(this)'>" + arrSigner[idx] + "</div>";
			} // end if
		} // end for
	} // end if
	document.getElementById("divSignerList").innerHTML = signerContent;
	document.getElementById("divSignerContain").style.display = "block";
}

function retSigner(obj) {
	if (obj == null) return;
	var nguoiKy = document.getElementById("nguoikycvdtn");
	if (nguoiKy) {
		nguoiKy.value = obj.innerHTML;
		document.getElementById("divSignerContain").style.display = "none";
	} // end if
}

function checkDocRef() {
	// Ham kiem tra document reference, tra ve true/false
	var docRefObj = document.getElementById("sohieucvdtn");
	var ngayPHObj = document.getElementById("ngayphathanhcvdtn");
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
		
	pcccdocumentreceiptClient.countByDocrefIssyearArrYear(docRefObj.value, yearForCheck, true, 0, false, function (data) {
		if (data > 0) {// neu ton tai so hieu trung
			alert("<liferay-ui:message key='sohieu_phaico_khongtrung'/>");
			//docRefObj.value = "";
			docRefObj.focus();
		}
	});
}

function lostFocusDocRef() {
	// Kiem tra document reference khi mat focus
	checkDocRef();
	return;
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
		document.getElementById('sohieucvdtn').focus();
	} 
	// Uncheck: cho thay doi so bang tay
	else {
		div1.style.display = "none";
		div2.style.display = "inline";

		// lay so
		var ngayDen = DWRUtil.getValue('ngaydencvdtn');
	 	pcccdocumentreceiptClient.getGeneralNumberDocumentReceipt(ngayDen, function (data) {
			if (data != -1) {
				var soKeTiep = data + 1;
				document.getElementById('phanso').value = soKeTiep;
				document.getElementById('phanmorong').value = "<%= phanMoRong %>";
			}
		});
	}
}

function checkNumberDocumentReceipt() {
	// Ham kiem tra document reference, tra ve true/false
	var phanso = document.getElementById("phanso");
	var phanmorong = document.getElementById("phanmorong");
	var ngayPHObj = document.getElementById("ngayphathanhcvdtn");
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
		
	pcccdocumentreceiptClient.countByNumberDocumentReceipt(numberDocumentReceipt, yearForCheck, 0, function (data) {
		if (data > 0) { // neu ton tai so den theo so
			alert("<liferay-ui:message key='so-den-theo-so-da-ton-tai'/>");

			// lay so
			var ngayDen = DWRUtil.getValue('ngaydencvdtn');
		 	pcccdocumentreceiptClient.getGeneralNumberDocumentReceipt(ngayDen, function (data) {
				if (data != -1) {
					var soKeTiep = data + 1;
					document.getElementById('phanso').value = soKeTiep;
					document.getElementById('phanmorong').value = "<%= phanMoRong %>";
				}
			});
		}
	});
}
/* end phmphuc add functions 05/01/2011 */

</script>