<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentsendClient.js'></script>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

function validateCVDDocSend(){
	
	fileUpload();	
	
	
	var messageError="";
	var sohieu = document.getElementById('sohieucvdtn');	
	var socongvan = document.getElementById('socongvancvdtn');	
	var loaicongvan = document.getElementById('loaicongvancvdtn');	
	var nguoiky = document.getElementById('nguoikycvdtn');	
	var socongvanden = document.getElementById('soCVdencvdtn');	
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	var ngayphathanh = document.getElementById('ngayphathanhcvdtn');
	var ngayden = document.getElementById('ngaydencvdtn');
	var trichyeu = document.getElementById('trichyeucvdtn');
	var nph = ngayphathanh.value;
	var nd = ngayden.value
	
/*
	if(isNaN(ngayphathanh.value) ||(isNaN(ngayden.value)) == true ){
		messageError += "The date format should be : dd/mm/yyyy and only contain characters 0-9!\n";
	}
*/
	if (!checkFileUpload()) {
		return false;
	}
	if (sohieu.value.trim() == "" || socongvan.value == "" || loaicongvan.value == "" || socongvanden == "" || nph == "" || nd == ""){
	    messageError += "<liferay-ui:message key='pccc-cvdtn-RB4'/>\n";
		sohieu.value = "";
		sohieu.focus();
		return false;
	  }	

    if (nguoiky.value.trim() == "") {
    	messageError += "<liferay-ui:message key='pccc-cvdtn-RB4'/>\n";
    	nguoiky.value = "";
    	nguoiky.focus();
    	return false;
    }

    if (trichyeu.value.trim() == "") {
    	messageError += "<liferay-ui:message key='pccc-cvdtn-RB4'/>\n";
    	trichyeu.value = "";
    	trichyeu.focus();
    	return false;
    }
    
	 /* if (sohieu.value == "" || null == sohieu.value) {
		   sohieu.focus();
		    return false ;
		  }*/
	if (noiphathanh.selectedIndex == 0 && khac.value.trim() == ""){
	    messageError += "<liferay-ui:message key='pccc-cvdtn-RB3'/>\n";
	    khac.value = "";
	    khac.focus();
	    return false;
	  }
		  	
	
	
	if (nd < nph){
	    messageError += "<liferay-ui:message key='pccc-cvdtn-RB17'/>\n";
	  }

	var nphDate = new Date(nph);
	var today = new Date();
		
	if (today >= nphDate){
	    messageError += "<liferay-ui:message key='pccc-cvdtn-RB18'/>\n";
	    
	  }
	
	//if (noiphathanh.selectedIndex == 0 ){
		//if (khac.trim() == "") {
			//messageError += "<liferay-ui:message key='pccc-cvdtn-RB18'/>\n";
		//}
	//}

	if(isDate(nd)==false || isDate(nph)==false ||messageError !=""){
		messageError = "<liferay-ui:message key='doc-r8-alert'/>\n" + messageError;
		alert(messageError);
		messageError = "";
		return false;
	}	
	
	else{
		return true;
	}
	
}

function checkonchangBR3(){
	var noiphathanh = document.getElementById('noiphathanhcvdtn');	
	var khac = document.getElementById('khaccvdtn');	
	if (noiphathanh.selectedIndex > 0 ){
		khac.value ="";
	    khac.disabled =true;
	  }
	
	if (noiphathanh.selectedIndex == 0 ){
	    khac.disabled =false;
	    messageError += "<liferay-ui:message key='pccc-cvdtn-RB3'/>\n";
	  }
}

/*/---------------phan them file dinh kem*/


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

function isDate(dtStr){
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
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		//alert("The date format should be : dd/mm/yyyy");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("<liferay-ui:message key='Please enter a valid month'/>");
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("<liferay-ui:message key='Please-enter-a-valid-day'/>");
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
	
	pcccdocumentsendClient.getIssuingPlaces(levelSendId, function (data){
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
	
	pcccdocumentsendClient.getDocumentType(documentRecordTypeId, function (data){
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
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = DWRUtil.getValue('userId');
	pcccdocumentsendClient.getNumberDocumentSend(documentRecordTypeId, documentTypeId, userId, function (data){
		
		if (data != null) {
			//$('soCVdencvdtn').value = data;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
	});
}



function uploadSendfile()
{
	var table=document.getElementById('addfileupload').insertRow(1);
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	title.innerHTML="<input style='width: 95%' name='<portlet:namespace/>titlefile' type='text' id='titlefile" +incstt+"'>";
	nameDocument.innerHTML="<input style='width: 95%' type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"'>";
	deleteRow.innerHTML="<div align='center'><input style='width: 90%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
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
	
	for(i = 0; i < incstt; i++) {
		if(document.getElementById('namefile'+ i)) {			
			var valueNameFile1 = document.getElementById('namefile'+ i).value;
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1);
			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
				return false;
			}
				
			if("html" == type || "htm" == type || "doc" == type || "docx" == type || "xls" == type || "xlsx" == type || "jpg" == type || "pmp" == type || "pdf" == type) {
				return true;
			}
			else {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>");
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
</script>
	
	
	