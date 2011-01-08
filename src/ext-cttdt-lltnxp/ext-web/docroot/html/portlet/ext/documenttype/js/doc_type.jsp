<%@ include file="/html/portlet/ext/documenttype/init.jsp" %>

<!-- script type='text/javascript' src='/dwr/engine.js'></script-->
<!-- script type='text/javascript' src='/dwr/util.js'></script-->
<!--script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script-->
<!--script type='text/javascript'src='/dwr/interface/pcccDocumentTypeClient.js'></script-->
<script type="text/javascript" >

/* function add row*/
  
 /*
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file

window.onload = function () {	
	//getDateReturnClient();	
}


function validateCVDDocReceipt(){
	
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
	
	if (!isBookDocumentRecordAgencyClient()) {
		return false;
	}
	
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
*/
/*/---------------phan them file dinh kem*/


/**
 * DHTML date validation script for dd/mm/yyyy. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */
// Declaring valid date character, minimum year and maximum year
/*
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

*/




//mimh lam

/**
 * get all issue place when change level send
 */
 /*
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
*/
/**
 * get all document type when change documentRecordTo  
 */
 /*
function changeDocumentRecordType() {
	var documentRecordTypeId =  DWRUtil.getValue('socongvancvdtn');
	var elementSelect = document.getElementById('loaicongvancvdtn');
	
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
*/

/**
 * get number document when change document type
 */
 /*
function changeDocumentType() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = DWRUtil.getValue('userId');
	pcccdocumentreceiptClient.getNumberDocumentReceipt(documentRecordTypeId, documentTypeId, userId, function (data){
		
		if (data != null) {
			document.getElementById('soCVdencvdtn').value = data;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
	});
}
*/

/*
function addnewtype()
{
	document.getElementById("btnaddtype").disabled=true;
	var lastrow = document.getElementById('addtype'). rows.length-1;
	var lastrowstt = lastrow;
	var table=document.getElementById('addtype').insertRow(lastrow);
	var chkbox = table.insertCell(0);
	var stt = table.insertCell(1);
	var documentTypeCode = table.insertCell(2);
	var documentTypeName = table.insertCell(3);
	var documentRecordTypeName = table.insertCell(4);
	var editButton = table.insertCell(5);
	var deleteButton = table.insertCell(6);
	
	chkbox.style.backgroundColor = "#EBEADB";
	stt.style.backgroundColor = "#EBEADB";
	stt.style.textAlign = "right";
	
	chkbox.innerHTML="<span  Style='height:15px;padding-top:10px;vertical-align:middle;'   align='center' > <input type='radio'  style='text-align: center;' name='chk' value='' /></span>";
	stt.innerHTML="<span id='stt' Style='height:15px;padding-top:10px;text-align:right;' >"+lastrowstt+".</span>";
	documentTypeCode.innerHTML="<span  Style='height:15px;padding-top:10px;vertical-align:middle;'  align='center'  ></span>";
	documentTypeName.innerHTML="<span  Style='height:15px;padding-top:10px;vertical-align:middle;'    ><input type='text' name='<portlet:namespace />typename' value='' /></span>";
	
	var span = document.createElement("span");
	var selectDocumentRecordType = document.createElement("select");
	var optionDefault = document.createElement("option");
	optionDefault.text = "--------------";
	selectDocumentRecordType.name = "selectDocumentRecordType";
	selectDocumentRecordType.appendChild(optionDefault);

	pcccDocumentTypeClient.getPmlEdmDocumentRecordTypeList(function(data) {
		for (var i = 0; i < data.length; i++) {
			var option = document.createElement("option");
			option.value = data[i].documentRecordTypeId;
			option.text = data[i].documentRecordTypeName;
			selectDocumentRecordType.appendChild(option);
		}
	});

	span.setAttribute("style", "height:15px;padding-top:10px");
	span.appendChild(selectDocumentRecordType);
	documentRecordTypeName.appendChild(span);
	
	editButton.innerHTML="<span  Style='height:15px;padding-top:10px'  align='center'  ><input type='submit'   name='editbtn' value='<liferay-ui:message key='document_save'/>' /></span>";
	deleteButton.innerHTML="<span  Style='height:15px;padding-top:10px'  align='center'  ><input type='button'  name='deletebnt' onclick='deleteRow(this)' value='<liferay-ui:message key='documentRecordType.delete'/>' /></span> ";
}

//minh update
	function checkSubmit(){
		var indexlastrow = document.getElementById('addtype'). rows.length-2;
		var rowLast = document.getElementById('addtype'). rows[indexlastrow];
		var listCells = rowLast.childNodes;
		
		var valueTenLoaiCV = (listCells[3].childNodes)[0].childNodes[0].value;		
		var indexTenSoCV = (listCells[4].childNodes)[0].childNodes[0].selectedIndex;
		
		if ("" == valueTenLoaiCV.trim() ) {
			alert("<liferay-ui:message key='nhap-ten-loai-cong-van'/>");
			(listCells[3].childNodes)[0].childNodes[0].focus();
			return false;
		}  		
		else if (indexTenSoCV == 0)  {
			alert("<liferay-ui:message key='chon-so-cong-van'/>");
			(listCells[4].childNodes)[0].childNodes[0].focus();
			return false;
		}  
		return true;
	}


function deleteRow(row)
{
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addtype').deleteRow(i);
	 document.getElementById("btnaddtype").disabled=false;

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
*/
/*/get hostname of web
 * 
 */
 /*
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
				
			if("html" == type || "htm" == type || "doc" == type || "docx" == type || "xls" == type || "xlsx" == type || "jpg" == type || "pmp" == type) {
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

//kiem tra so cong van cua lanh dao so co hay khong

function isBookDocumentRecordAgencyClient() {
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	var userId = document.getElementById('userId').value	
	pcccdocumentreceiptClient.isBookDocumentRecordAgency(documentRecordTypeId, userId, {callback:setValuesInDWR, async:false});
	var result = document.getElementById('isBookDocumentRecord').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='so-cong-van-cua-phong-ban-chua-co'/>");
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

 function editInfomation (id) {
	var chk = document.getElementById("chk" + id);
	var span1 = document.getElementById("span1" + id);
	var hidden = document.getElementById("hidden" + id);
	var button1 = document.getElementById("button1" + id);
	var span2 = document.getElementById("span2" + id);
	var span3 = document.getElementById("span3" + id);
	var div1 = document.getElementById("div1" + id);
	var div2 = document.getElementById("div2" + id);

	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}

	// edit attribute of hidden and append to span1
	hidden.type = "text";
	span1.appendChild(hidden);

	//remove all element in span2
	for (var i = 0; i < span2.childNodes.length; i++) {
		span2.removeChild(span2.firstChild);
	}

	// create a button and append to span2
	span2.innerHTML = "<input type='button' value='<liferay-ui:message key='luu.'/>' onclick='updateDocumentType(" + id + ")'/>";

	// invisible div1 and available div2
	div1.setAttribute("style", "display:none");
	div2.setAttribute("style", "");

	//remove all element in span3
	for (var i = 0; i < span3.childNodes.length; i++) {
		span3.removeChild(span3.firstChild);
	}

	// create a button and append to span3
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='huy.'/>' onclick='resetDocumentType(" + id + ", \"" + hidden.value + "\")'/>";
		
	chk.checked = "checked";
 }

 function updateDocumentType(id) {
	var selectoption = document.getElementById("selectoption");
		
	if ((selectoption.options[selectoption.selectedIndex]).id == 0) {
		alert("<liferay-ui:message key='chon-loai-cong-van'/>");
	} else {

		var chk = document.getElementById("chk" + id);
		var span1 = document.getElementById("span1" + id);
		var hidden = document.getElementById("hidden" + id);
		var button1 = document.getElementById("button1" + id);
		var span2 = document.getElementById("span2" + id);
		var span3 = document.getElementById("span3" + id);
		var div1 = document.getElementById("div1" + id);
		var div2 = document.getElementById("div2" + id);
		
		//remove all element in span1
		for (var i = 0; i < span1.childNodes.length; i++) {
			span1.removeChild(span1.firstChild);
		}
		
		hidden.type = "hidden";
		span1.innerHTML = hidden.value;
		span1.appendChild(hidden);
		
		//remove all element in span2
		for (var i = 0; i < span2.childNodes.length; i++) {
			span2.removeChild(span2.firstChild);
		}
		
		// create a button and append to span2
		span2.innerHTML = "<input type='button' value='<liferay-ui:message key='edit' />' onclick='editInfomation(" + id + ")'/>";

		// remove all element in div1
		for (var i = 0; i < div1.childNodes.length; i++) {
			div1.removeChild(div1.firstChild);
		}

		// add selected value to div1
		div1.innerHTML = selectoption.value;
		// invisible div1 and available div2
		div1.setAttribute("style", "");
		div2.setAttribute("style", "display:none");
			
		//remove all element in span3
		for (var i = 0; i < span3.childNodes.length; i++) {
			span3.removeChild(span3.firstChild);
		}
			
		// create a button and append to span3
		var row = span3.parentNode.parentNode.rowIndex;
		span3.innerHTML = "<input type='button' value='<liferay-ui:message key='delete' />' onclick='deleteDocumentType(" + row + " ," + id + ")'/>";
		
		chk.checked = "checked";

		//alert((selectoption.options[selectoption.selectedIndex]).id);
		//var documentRecordTypeId = selectoption.options[selectoption.selectedIndex]).id;
		pcccDocumentTypeClient.updateDocumentType(id, hidden.value, (selectoption.options[selectoption.selectedIndex]).id, function(data) {
				if (data) {
					alert("<liferay-ui:message key='cap-nhat-loai-cv-thanh-cong'/>");
				}
				else {
					alert("<liferay-ui:message key='cap-nhat-loai-cv-khong-thanh-cong'/>");
				}
			});
	}
 }	 

 function deleteDocumentType(row, id) {
	 var flag = confirm("<liferay-ui:message key='xoaloaicongvan'/>");
	 if (flag){
		pcccDocumentTypeClient.deleteDocumentType(id, function(data){
			if (data) {
				//document.getElementById('addlevelsend').deleteRow(row);
				window.location.reload(true);
				alert("<liferay-ui:message key='xoa-thanh-cong'/>");
				
			}
			else {
				alert("<liferay-ui:message key='khong-the-xoa-dong-nay'/>");
				
			}
		});
 	//var i=row.parentNode.parentNode.parentNode.rowIndex;
 	//document.getElementById('addtype').deleteRow(row);
 	}
 }

 function setSelectedIndex (select) {
	var selectoption = document.getElementById("selectoption");
	//alert(select.selectedIndex);
	selectoption.selectedIndex = select.selectedIndex; 
 }	 

 function resetDocumentType (id, hid) {
	var chk = document.getElementById("chk" + id);
	var span1 = document.getElementById("span1" + id);
	var hidden = document.getElementById("hidden" + id);
	var button1 = document.getElementById("button1" + id);
	var span2 = document.getElementById("span2" + id);
	var span3 = document.getElementById("span3" + id);
	var div1 = document.getElementById("div1" + id);
	var div2 = document.getElementById("div2" + id);

	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}

	hidden.type = "hidden";
	hidden.value = hid;
	span1.innerHTML = hidden.value;
	span1.appendChild(hidden);
		
	//remove all element in span2
	for (var i = 0; i < span2.childNodes.length; i++) {
		span2.removeChild(span2.firstChild);
	}

	// create a button and append to span2
	span2.innerHTML = "<input type='button' value='<liferay-ui:message key='edit' />' onclick='editInfomation(" + id + ")'/>";

	// invisible div1 and available div2
	div1.setAttribute("style", "");
	div2.setAttribute("style", "display:none");
	
	//remove all element in span3
	for (var i = 0; i < span3.childNodes.length; i++) {
		span3.removeChild(span3.firstChild);
	}

	// create a button and append to span3
	var row = span3.parentNode.parentNode.rowIndex;
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='delete' />' onclick='deleteDocumentType(" + row + ", " + id + ")'/>";

	chk.checked = "checked";
 }
*/

//minh 20100209	
 function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}	
	
 function editDocumentType (id) {
	 var documentTypeSymbol = document.getElementById("documentTypeSymbol" + id);
	 var editDocumentTypeSymbol = document.getElementById("editDocumentTypeSymbol" + id);
		 
 	var documentTypeName = document.getElementById("documentTypeName" + id);
 	var editDocumentTypeName = document.getElementById("editDocumentTypeName" + id);
 	
 	var documentRecordTypeName = document.getElementById("documentRecordTypeName" + id);
 	var editDocumentRecordTypeName = document.getElementById("editDocumentRecordTypeName" + id);

 	var sendReceiptDistinction = document.getElementById("sendReceiptDistinction" + id);
	var editSendReceiptDistinction = document.getElementById("editSendReceiptDistinction" + id);

	var haveDepartExtends = document.getElementById("haveDepartExtends" + id);
	var editHaveDepartExtends = document.getElementById("editHaveDepartExtends" + id);
 	
 	var current = document.getElementById("current" + id);
 	var edit = document.getElementById("edit" + id);

 	documentTypeSymbol.style.display = "none";	
 	editDocumentTypeSymbol.style.display = "inline";

 	documentTypeName.style.display = "none";	
 	editDocumentTypeName.style.display = "inline";

 	documentRecordTypeName.style.display = "none";
 	editDocumentRecordTypeName.style.display = "inline";	

 	sendReceiptDistinction.style.display = "none";
 	editSendReceiptDistinction.style.display = "inline";

 	haveDepartExtends.style.display = "none";
 	editHaveDepartExtends.style.display = "inline";
 	
 	current.style.display = "none";	
 	edit.style.display = "inline";
 }


 function deletteDocumentType(id, url) {
 	var form = document.<portlet:namespace />fm;
 	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
 		form.action = url;
 		form.submit();
 	}
 	
 }

 function cancel (id) {
	var documentTypeSymbol = document.getElementById("documentTypeSymbol" + id);
	var editDocumentTypeSymbol = document.getElementById("editDocumentTypeSymbol" + id);
	 
	var documentTypeName = document.getElementById("documentTypeName" + id);
	var editDocumentTypeName = document.getElementById("editDocumentTypeName" + id);
	 	
	var documentRecordTypeName = document.getElementById("documentRecordTypeName" + id);
	var editDocumentRecordTypeName = document.getElementById("editDocumentRecordTypeName" + id);

	var sendReceiptDistinction = document.getElementById("sendReceiptDistinction" + id);
	var editSendReceiptDistinction = document.getElementById("editSendReceiptDistinction" + id);

	var haveDepartExtends = document.getElementById("haveDepartExtends" + id);
	var editHaveDepartExtends = document.getElementById("editHaveDepartExtends" + id);
 	
 	var current = document.getElementById("current" + id);
 	var edit = document.getElementById("edit" + id);

 	documentTypeSymbol.style.display = "inline";	
 	editDocumentTypeSymbol.style.display = "none";

 	documentTypeName.style.display = "inline";	
 	editDocumentTypeName.style.display = "none";

 	documentRecordTypeName.style.display = "inline";
 	editDocumentRecordTypeName.style.display = "none";	

 	sendReceiptDistinction.style.display = "inline";
 	editSendReceiptDistinction.style.display = "none";

 	haveDepartExtends.style.display = "inline";
 	editHaveDepartExtends.style.display = "none";

 	current.style.display = "inline";	
 	edit.style.display = "none";
 }

 function updateDocumentType (id, url) {
 	var form = document.<portlet:namespace />fm;
 	form.action = url;
 	var documentTypeSymbol = document.getElementById("hiddenDocumentTypeSymbol" + id);
 	var documentName = document.getElementById("hiddenDocumentName" + id);
 	var documentRecordName = document.getElementById("hiddenDocumentRecordName" + id);
 
 	form.onsubmit = "";
 	if (documentTypeSymbol.value.trim () == "") {
 		alert('<liferay-ui:message key="vui-long-nhap-ma-loai-cv"/>');
 		documentTypeSymbol.focus();
 		
 	} else if (documentName.value.trim () == "") {
 		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
 		documentName.focus();
 		
 	} else	if (documentRecordName.value.trim() == "") {
 		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
 		documentRecordName.focus();
 		
 	} else {
 		form.submit();
 	}
 }
 // end
</script>
	
	
	