<%@ include file="/html/portlet/ext/onedoorpccc/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<script type='text/javascript'src='/dwr/interface/OneDoorUtilClientpccc.js'></script>

<script type="text/javascript" >
var mywindow = null;
var incstt = 1;
function validateDocReceipt(){
	
	getFileId();
	getNamePaint();
	var messageError="";	
	var loaihoso = document.getElementById('fileTypeIdName');
	var loaihoso_bt = document.getElementById('btn_DocType');
	//var sobiennhan = document.getElementById('numberReceipt');
	var tenhoso = document.getElementById('fileName');
	var nguoigiaohoso = document.getElementById('applicationName');
	var chudautu = document.getElementById('investor');
	var thoigiannophoso = document.getElementById('applicantTime');
	//IsValidTime(thoigiannophoso.value);
	var ngaynophoso = document.getElementById('applicationDate');
	var ngayhentrakhach = document.getElementById('expectedReturningDate');
	var nguoitiepnhan = document.getElementById('receiver');
	var ngaynhaplieu = document.getElementById('inputDataDate');
	/*validate number*/
	var dienthoai = document.getElementById('applicantTelephone');
	var dienthoainhan = document.getElementById('receiverTelephone');
	var soluong = document.getElementById('quantity');
	var nhanDate = new Date(document.getElementById('applicationDate').value);
	var traDate = new Date(document.getElementById('expectedReturningDate').value);
	if(loaihoso.value == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r1-alert'/>\n");
		loaihoso_bt.focus();
		
		return false;
	}
	if(tenhoso.value.trim() == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r3-alert'/>\n");
		tenhoso.value="";
		tenhoso.focus();
		return false;
	}
	if(nguoigiaohoso.value.trim() == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r3nghs-alert'/>\n");
		nguoigiaohoso.value="";
		nguoigiaohoso.focus();
		return false;
	}
	if(chudautu.value.trim() == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r4-alert'/>\n");
		chudautu.value="";
		chudautu.focus();
		return false;
	}
	
	if(IsValidTime(thoigiannophoso.value)==false){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='thoigiannophosokhongdung'/>\n");
		thoigiannophoso.focus();
		return false;
	}
	
	if(isDate(ngaynophoso.value)==false || ngaynophoso.value == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='ngaynophosokhonghople'/>\n");
		ngaynophoso.focus();
		return false;
	}
	
		  
	if(isDate(ngayhentrakhach.value)==false || ngayhentrakhach.value == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='ngayhentrakhachkhonghople'/>\n");
		ngayhentrakhach.focus();
		return false;
	}	
	
	
	
	if(nguoitiepnhan.value.trim() == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r8-alert'/>\n");
		nguoitiepnhan.value="";
		nguoitiepnhan.focus();
		return false;
	}

	if(isDate(ngaynhaplieu.value)==false || ngaynhaplieu.value.trim() == ""){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='ngaynhaplieukhonghople'/>\n");
		ngaynhaplieu.focus();
		return false;
	}

	if (!Compare() ){
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='ngaynhanngaynhaplieuphainhohonngayhentra'/>\n");
		return false;    
	    
	  }

	if (isNaN (dienthoai.value) == true ) {
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='Invalid-Phone-must-be-number'/>\n");
		dienthoai.focus();
		return false;
	}

	if (isNaN (dienthoainhan.value) == true ) {
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='Invalid-Phone-must-be-number'/>\n");
		dienthoainhan.focus();
		return false;
		
	}
	
   if (dienthoai.value.length >15) {
	   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='alert-ord-phonemax'/>\n");
	   dienthoai.focus();
	   return false;
	}
	
   if(dienthoai.value.length >0 && dienthoai.value.length <7){
	   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='alert-ord-phonemin'/>\n");
		dienthoai.focus();
		return false;
	}

   if (dienthoainhan.value.length >15) {
	   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='alert-ord-phonemax'/>\n");
	   dienthoainhan.focus();
	   return false;
	}
	
   if(dienthoainhan.value.length >0 && dienthoainhan.value.length <7){
	   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='alert-ord-phonemin'/>\n");
		dienthoainhan.focus();
		return false;
	}
	
	
	
   else if(document.getElementsByName('copy') && document.getElementsByName('original')) {	   
	   var lengthCopy = document.getElementsByName('copy'); 
	   var lengthOriginal = document.getElementsByName('original');	  
	   for (j = 0; j < lengthCopy.length; j++ ) {
	   if (isNaN (lengthCopy[j].value) == true)  {
		   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r20-nhapbansaolaso'/>\n");
		   lengthCopy[j].focus();
		   return false;
	   }
	  
	   else if (isNaN (lengthOriginal[j].value) == true) {
		   alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r21-nhapbanchinhlaso'/>\n");
		   lengthOriginal[j].focus();
		   return false;
	   }
	   }}
    if(document.getElementsByName('drawName') && document.getElementsByName('quantity')) {
	   var lengthdrawName = document.getElementsByName('drawName'); 
	   var lengthquantity = document.getElementsByName('quantity');	  
		for (k = 0; k < lengthquantity.length; k++ ) {
			   if (isNaN (lengthquantity[k].value) == true || "" == lengthquantity[k].value || "" == lengthdrawName[k].value)  {
				   messageError += "<liferay-ui:message key='pccc-TN-tentailieubanvesoluong'/>\n";
				   
				   if(lengthquantity[k].value == ""){
					   lengthquantity[k].focus();   
					   }
				   if(lengthdrawName[k].value == ""){
					   lengthdrawName[k].focus();   
					   }
				   break;
			   }
		   }
	 }
    
	if(messageError !=""){
		messageError = "<liferay-ui:message key='doc-r8-alert'/>\n" + messageError;
		alert(messageError);
		messageError = "";
		return false;
	}	
	
	else{
		return true;
	}
	
}


function mypopup()
 {   
	var host = location.host;
	var path = "http://" + host + "/html/portlet/ext/onedoorpccc/popup.jsp";

	var width = 0;
	var height = 0;
	var left = 0;
	var top = 0;	
	width = Math.floor((screen.availWidth * 3)/5);
	height = 500;
	left = Math.floor((screen.width/2)-(width/2));
	top = 100;

	
   mywindow = window.open ( path ,"mywindow","resizable=yes,location=0,status=0,menubar=no,toolbar=no,scrollbars=1,width=" + width + "px,height=" + height + "px");
   mywindow.moveTo(left , top);

 } 
 
function parent_disable() {
 	if(mywindow && !mywindow.closed)
 		mywindow.focus();
}

function getDataHelp(trTable){	

	var elementRadioChecked = trTable.cells[1].firstChild;
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('fileTypeId').value = arr[1];
}

function getData(){	
	
if (document.getElementById('hidden').value == "") {
	alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
	
}
else{
	
	var currentDate = window.opener.document.getElementById('applicationDateHidden').value;	
	window.opener.document.getElementById('applicationDate').value = currentDate;
	window.opener.document.getElementById('inputDataDate').value = currentDate;
	window.opener.document.getElementById('fileTypeIdName').value = document.getElementById('hidden').value;
	var idfileType = document.getElementById('fileTypeId').value;	 	

	//kienbqc start
	window.opener.document.getElementById('fileTypeId').value = idfileType;
	//kienbqc end
	
 	fillDocment(idfileType);
 	window.opener.document.getElementById('fileName').focus();
	}
 	
 }

function Compare(){
	var ngaynhaplieuDate = document.getElementById('inputDataDate');
	var nhanDate = document.getElementById('applicationDate');
	var traDate = document.getElementById('expectedReturningDate');
	var strdate = nhanDate.value.toString();
	var objnn = sgs.stringToDate(strdate,"dmy");
	var strdatennl = ngaynhaplieuDate.value.toString();
	var objnnl = sgs.stringToDate(strdatennl,"dmy");
	var strdatenht = traDate.value.toString();
	var objnht = sgs.stringToDate(strdatenht,"dmy");
	 
	if (objnn >= objnht ){
	    return false;
	}  
	if (objnnl >= objnht){
		    return false;
	}  
	
	else{
		return true;
	}
}
/*/---------------phan them file dinh kem*/


function fillDocment(kindDocument) {
	getProcessTime(kindDocument);	
	getProcessTransitionClient(kindDocument);
	
}

function getAttachedFile(listAttachedFile){	
	var trInfo = "";
	if(listAttachedFile.length > 0 ){
	
	trInfo += "<table width='100%' cellspacing='0' class='tabborJS_tn'>";
	
		for ( var i= 0; i < listAttachedFile.length; i++) {		
			var pmlFileAttachedFile = listAttachedFile[i];	
			var at = "";	
			if (i % 2 == 0){
				at = "rowOne";
			}
			else {
				at = "rowTwo";
			}
			if(pmlFileAttachedFile != null){
				
				trInfo += "<tr class='"+ at+"'>";
				trInfo += "<td width='4%'><div align='center'><span id='no' style='font-weight: bold;'>"+ (i+1)  + "</span>.</div></td>";
				trInfo += "<td width='3%' ><div align='center'><input type='checkbox' name='attachedFile' id='checkbox' value='" + pmlFileAttachedFile.filetypeAttachedFileId +"' checked='true'></div></td>";
				trInfo += "<td width='50%'  ><div align='left' id='nameAttachFile' >&nbsp;" + pmlFileAttachedFile.attachedFileName  + "</div></td>";
				trInfo += "<td width='10%' ><div align='center'><input size='3' type='text' id='original"+ i + "' name='original' value='"+pmlFileAttachedFile.original+"' /> </div></td>";
				trInfo += "<td width='10%' ><div align='center'><input size='3' type='text' id='copy" + i + "' name='copy' value='"+ pmlFileAttachedFile.copy_ +"' /></div></td>";
				trInfo += "<td ><div align='center'><input type='text' style='width:90%' id='noteAttachedFile"+ i + "' value='"+ pmlFileAttachedFile.note +"' /></div></td>";
				trInfo += "</tr>";
			}
			
		}
		trInfo += "</table>";	
		
	
		window.opener.document.getElementById('rowDocument').innerHTML = trInfo;
		var host = location.host;
		var path = "http://" + host + "/html/portlet/ext/onedoorpccc/popup.jsp";
		var mywindow = window.open ( "" ,"mywindow","location=1,status=1,scrollbars=1,scrollbars=yes,location=0,width=800px,height=400px");
		mywindow.close();
	}

	else {
		var host = location.host;
		var path = "http://" + host + "/html/portlet/ext/onedoorpccc/popup.jsp";
		var mywindow = window.open ( "" ,"mywindow","location=1,status=1,scrollbars=1,scrollbars=yes,location=0,width=800px,height=400px");
		mywindow.close();
		
	}
}

function getFileId() {
	var str = "";
	var listName = document.getElementsByName('attachedFile');
	for(var i=0; i < listName.length; i++) {
		if(listName[i].checked) {			
		   str = str + listName[i].value+"_" +document.getElementById('original'+i).value +"_"+document.getElementById('copy'+i).value +"_"+ document.getElementById('noteAttachedFile'+i).value;
		   if (i < listName.length - 1) {
			   str += "#";
		   }
		}
	}
	
	document.getElementById('listAttachFileId').value = str;
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
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
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
		//alert("The date format should be : dd/mm/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		//alert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		//alert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		//alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		//alert("Please enter a valid date")
		return false
	}
return true
}

function ValidateForm(){
	
	var ngaynop = document.getElementById('applicationDate');
	var ngayhen = document.getElementById('expectedReturningDate');
	var ngaynhap = document.getElementById('inputDataDate');
	
	if (isDate(ngaynop.value)==false){
		ngaynop.focus();
		ngaynop.select();
		return false
	}
	
	if (isDate(ngayhen.value)==false){
		ngayhen.focus();
		ngayhen.select();
		return false
	}
	
	if (isDate(ngaynhap.value)==false){
		ngaynhap.focus();
		ngaynhap.select();
		return false
	}
	
    return true
 }

//get process time total of file type
function getProcessTime(fileTypeId) {
	OneDoorUtilClientpccc.getProcessTime(fileTypeId, getTotalHelp);
		
}

function getTotalHelp(timeTotal) {
	var processDateNumber = 0;
	if (timeTotal % 8 == 0){
		processDateNumber = timeTotal / 8
	}
	else {
		var temp = timeTotal / 8;
		temp = (temp + "").split(".")[0]; 
		processDateNumber = parseInt(temp) + 1;
	}		
	
	window.opener.document.getElementById("totalHour").value = timeTotal;
	window.opener.document.getElementById("totalDate").value = processDateNumber;
	getDateReturnClient();
}

/**
 * 
 */
function getDateReturnClient() {	
	var processDateNumber = window.opener.document.getElementById("totalDate").value;
	var dateReceipt =  window.opener.document.getElementById("applicationDate").value;	
	var expectedReturningDate = window.opener.document.getElementById("expectedReturningDate");
	OneDoorUtilClientpccc.getExpectedReturningDate(processDateNumber, dateReceipt, function(data){
		expectedReturningDate.value = data;
	});
	
}
/**
 * change return date when receipt date 
 */
function getDateReturnWhenapplicationDateOnchange() {
	
	var processDateNumber = document.getElementById("totalDate").value;
	var dateReceipt =  document.getElementById("applicationDate").value;
	
	var validformat=/^\d{2}\/\d{2}\/\d{4}$/ //Basic check for format validity
	
	if (dateReceipt.match(validformat) && (processDateNumber != "")&& (dateReceipt != "")) {		
		var expectedReturningDate = document.getElementById("expectedReturningDate");
		OneDoorUtilClientpccc.getExpectedReturningDate(processDateNumber, dateReceipt, function(data){
			
			expectedReturningDate.value = data;
		});
	}	
}

function getProcessTransitionClient(fileTypeId) {
	var divTrinhTuXuLy = window.opener.document.getElementById("trinhtuxuly");
	OneDoorUtilClientpccc.getProcessTransition(fileTypeId, function(data){
		
		var meg = "";
		meg += "<table width='100%' cellspacing='0' class='tabborJS_tn'>";
		
		
		for ( var i = data.length -1 ; i >= 0; i--) {		
			var j =  data.length - i  
			var color = "";	
			if (i % 2 == 0){
				color = "rowOne";
			}
			else {
				color = "rowTwo";
			}
			meg += "<tr class='"+ color+"'  align='center' valign='middle'>";
			meg += "<td width='4%' ><div align='center'><font style='font-weight: bold'>" + j + ".</font></div></td>";
			meg += "<td width='38%' ><div align='left'><liferay-ui:message key='"+(data[i].nameTransition).toString() +"'/></div></td>"; 
			meg += "<td width='20%' ><div align='center'>"+data[i].processTime +"</div></td>";
			meg += "<td width='38%' >"+ data[i].ghiChu + "</td>";            
			meg +="</tr>";
			
		}
		meg += "</table>";
		divTrinhTuXuLy.innerHTML = meg;
		OneDoorUtilClientpccc.getListPmlFileTypeAttachedFile(fileTypeId,getAttachedFile);
	});
}


/*---------validate time hh:mm:ss*/
<!-- Begin
function IsValidTime(timeStr) {
// Checks if time is in HH:MM:SS AM/PM format.
// The seconds and AM/PM are optional.
//var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?$/;

var matchArray = timeStr.match(timePat);
if (matchArray == null) {
//alert("Time is not in a valid format.");
return false;
}
hour = matchArray[1];
minute = matchArray[2];
second = matchArray[4];
//ampm = matchArray[6];

if (second=="") { second = null; }
//if (ampm=="") { ampm = null }

if (hour < 0  || hour > 23) {
//alert("Hour must be between 1 and 12. (or 0 and 23 for military time)");
return false;
}
if (hour <= 12 ) {
//if (confirm("Please indicate which time format you are using.  OK = Standard Time, CANCEL = Military Time")) {
//alert("You must specify AM or PM.");
//return false;
 //  }
}
if  (hour > 12 ) {
//alert("You can't specify AM or PM for military time.");
//return false;
}
if (minute<0 || minute > 59) {
//alert ("Minute must be between 0 and 59.");
return false;
}
if (second != null && (second < 0 || second > 59)) {
//alert ("Second must be between 0 and 59.");
return false;
}
return true;
}
//  End -->

function processButton(url) {
	
	document.getElementById('redirect').value = url;
	var result = validateDocReceipt();
	//alert(url);
	if (result) {
		document.fm_tiepnhan.submit();
		alert("<liferay-ui:message key='pccc-TN-thanh-cong'/>");
	}
}
	//  End -->
	
/*check number only use for all maybe onKeyPress="return numbersonly(this, event)"
 * tam thoi de day sau nay se tach ra thanh ham dung chung de check number
 **/
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
	alert("<liferay-ui:message key='Accept-number-only'/>")
   return false;
}

 function uploadReceiptfile()
 {
 	var table=document.getElementById('adddraw').insertRow(1);
 	var sttadd = table.insertCell(0);
 	var title = table.insertCell(1);
 	var nameDocument = table.insertCell(2);
 	var ghichuadd = table.insertCell(3);
 	var deleteRow = table.insertCell(4);
 
 	sttadd.innerHTML="<div align='center' scope='row' name='nonum' ></div>";
 	title.innerHTML="<div ><input type='text' Style='width:98%'  id='drawName" +incstt+"' name='drawName'/></div>";
 	nameDocument.innerHTML="<div align='center'><input width='98%' type='text'  id='quantity" +incstt+"' name='quantity'/></div>";
 	ghichuadd.innerHTML="<div><input Style='width:98%' type='text' id='notedraw" +incstt+"' name='notedraw'/></div>";
 	deleteRow.innerHTML="<input type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' /><input type='hidden' value='"+incstt+"' name='list' />";
 	
 	
 	//if (incstt > 0 ) {
		var tdNo = (document.getElementById('adddraw').rows).length;
		//var tdNo = document.getElementsByName("nonum");
		// for ( var i = 0; i < tdNo.length; i++) {
		 for ( var i = 1; i < tdNo-1; i++) {
		     var arrRow = document.getElementById('adddraw').rows[i];
			 //var sttn = i; 
			// tdNo[i].innerHTML = "<span  id='no'>"+ sttn  + ".</span>";
			 arrRow.cells[0].innerHTML = "<span  id='no'>"+ i  + ".</span>";
		}
	// }
 	incstt += 1;
 	
 }
 
 /*/functin delete row*/
 function deleteRow(rowadd)
 {
 	 var i=rowadd.parentNode.parentNode.rowIndex;
 	 document.getElementById('adddraw').deleteRow(i);

 	 //phan cho viec set lai so thu tu
 	 //if (incstt > 0 ) {
 		 	var tdNo = (document.getElementById('adddraw').rows).length; 		 	
 			//var tdNo = document.getElementsByName("nonum");
 			// for ( var i = 0; i < tdNo.length; i++) {
 			for ( var i = 1; i < tdNo-1; i++) {
 				var arrRow = document.getElementById('adddraw').rows[i];
 				//var stt = i; 
 				//tdNo[i].innerHTML = "<span  id='no'>"+ stt  + ".</span>";
 				 arrRow.cells[0].innerHTML = "<span  id='no'>"+ i  + ".</span>";
 			}
 	// }
 	 incstt -= 1;
 }
 
 function filedraw() {
		var listNameRow = "";
		var valueNameFile ="";
		var notedraw ="";
		var soluong="";
		for(i = 0; i < incstt; i++) {
			if(document.getElementById('drawName'+ i)) {			
			
				valueNameFile += document.getElementById('drawName'+ i).value +"/";
				soluong += document.getElementById('quantity'+ i).value + "/";	
				notedraw += document.getElementById('note'+ i).value + "/";
			}

			
		}
		alert(valueNameFile +"soluong: "+soluong+"ghichu:"+notedraw);
	
		document.getElementById('drawName').value = valueNameFile;
		document.getElementById('quantity').value = soluong;
		document.getElementById('notedraw').value = notedraw;		
	}

 	function getNamePaint() {	
		var string1 = "";
		var lNamepaint = document.getElementsByName('drawName');
		for(var i=0; i < lNamepaint.length; i++) {
			//var listname = lNamepaint[i];
			if(lNamepaint[i]) {
				//j = i+1;
			//string1 += Listname.value+"_" +document.getElementById('drawName'+j).value +"_"+document.getElementById('quantity'+j).value +"_"+ document.getElementById('notedraw'+j).value;
			string1 += document.getElementsByName('list')[i].value +"_"+ lNamepaint[i].value +"_"+document.getElementsByName('quantity')[i].value +"_"+ document.getElementsByName('notedraw')[i].value;
			   if (i < lNamepaint.length - 1) {
				  string1 += "#";
			   }
			}
		}
		
		document.getElementById('listnamepaint').value = string1;
	}

 function trim(str)
 {
     if(!str || typeof str != 'string')
         return null;

     return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
 }
 function checkonchangkeyup(){
	
		var selectinputfiletype = document.getElementById('fileTypeIdName');	
		var ngaynopkeyup = document.getElementById('applicationDate');	
		
		
		if (selectinputfiletype.value == "" ){
			ngaynopkeyup.disabled =true;
		   
		  }
		else{
			ngaynopkeyup.disabled =false;

			}
		  
	}



 function startTime()
 {
 var today=new Date();
 var h=today.getHours();
 var m=today.getMinutes();
 var s=today.getSeconds();
 // add a zero in front of numbers<10
 m=checkTime(m);
 s=checkTime(s);
 document.getElementById('applicantTime').value=h+":"+m+":"+s;
 t=setTimeout('startTime()',500);

 }

 function checkTime(i)
 {
 if (i<10)
   {
   i="0" + i;
   }
 return i;
 }

/*
 * reset function by triltm
 */
function resetData() 
{
	document.getElementById('fileName').value = "";
	document.getElementById('applicationName').value = "";
	document.getElementById('applicantRepresentation').value = "";
	document.getElementById('permanentAddress').value = "";
	document.getElementById('applicantTelephone').value = "";
	document.getElementById('receiverUnit').value = "";
	document.getElementById('receiverRepresentation').value = "";
	document.getElementById('receiverTelephone').value = "";
	document.getElementById('projectName').value = "";
	document.getElementById('applicantCategory').value = "";
	document.getElementById('addressBuilder').value = "";
	document.getElementById('investor').value = "";
	document.getElementById('designCop').value = "";
	document.getElementById('txt_DocNum').value = "";
	document.getElementById('noteinformationManagement').value = "";
	document.getElementById('conclusion').value = "";
}

function showhideAttachfile(){

		jQuery('#rowDocument').toggle();
		jQuery('#div-title').toggle();
		jQuery('#up').toggle();
		jQuery('#down').toggle();
	}

function showHideDrawFile(){
	
	jQuery('#div-draw').toggle();
	jQuery('#up-bv').toggle();
	jQuery('#down-bv').toggle();
}
function showHideSortFile(){
	
	jQuery('#div-sort').toggle();
	jQuery('#up-st').toggle();
	jQuery('#down-st').toggle();
}
</script>
	
	
	