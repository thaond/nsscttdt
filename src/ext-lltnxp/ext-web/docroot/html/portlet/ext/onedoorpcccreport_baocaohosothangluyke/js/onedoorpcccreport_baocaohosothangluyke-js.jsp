<%@ include file="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/init.jsp" %>
<script language="JavaScript" type="text/javascript">

function <portlet:namespace/>compare2Date(fromDate, toDate) {
	
	var strFromDate = fromDate.value.toString();
	var objFromDate = sgs.stringToDate(strFromDate,"dmy");
	var strToDate = toDate.value.toString();
	var objToDate = sgs.stringToDate(strToDate,"dmy");

	if(objFromDate > objToDate) {
		return false;
	}
	return true;
}
function <portlet:namespace/>checkForm(form) {
	var fromDate = document.getElementById('<portlet:namespace/>fromDate');
	var toDate = document.getElementById('<portlet:namespace/>toDate');
	if(fromDate.value == "") {
		fromDate.focus();
		return false;
	}
	if(isDate(fromDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		fromDate.focus();
		return false;
	} 
	if(toDate.value == "") {
		toDate.focus();
		return false;
	}
	if(isDate(toDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		toDate.focus();
		return false;
	}
	if(<portlet:namespace/>compare2Date(fromDate, toDate) == false) {
		alert("Ch\u1ecdn ng\u00e0y th\u1ed1ng k\u00ea kh\u00f4ng ch\u00ednh x\u00e1c.\n('T\u1eeb ng\u00e0y' ph\u1ea3i nh\u1ecf h\u01a1n ho\u1eb7c b\u1eb1ng '\u0110\u1ebfn ng\u00e0y').");
		fromDate.focus();
		return false;
	}
	return true;
}
function validateDocProcess(){
	fileUpload();	
	getFileId();
	
	var messageError="";	
	var loaihoso = document.getElementById('fileTypeIdName');
	var loaihoso_bt = document.getElementById('btn_DocType');
	//var sobiennhan = document.getElementById('numberReceipt');
	var tenhoso = document.getElementById('fileName');
	var nguoigiaohoso = document.getElementById('applicationName');
	var chudautu = document.getElementById('investor');
	/*validate number*/
	var dienthoai = document.getElementById('applicantTelephone');
	var dienthoainhan = document.getElementById('receiverTelephone');

	if (checkUploadFile() == false) {
		return false;
	}
	
	if(loaihoso.value == ""){
		messageError =	"<liferay-ui:message key='pccc-r1-alert'/>\n";
		alert(messageError);
		loaihoso_bt.focus();
	}
	
	
	if(tenhoso.value.trim() == ""){
		messageError = "<liferay-ui:message key='doc-r8-alert'/> <liferay-ui:message key='pccc-r3-alert'/>";
		alert(messageError);
		tenhoso.focus();
		return false;
	}
	if(nguoigiaohoso.value.trim() == ""){
		messageError = "<liferay-ui:message key='doc-r8-alert'/> <liferay-ui:message key='pccc-r3nghs-alert'/>";
		alert(messageError);
		nguoigiaohoso.focus();
		return false;
	}
	
	if(chudautu.value.trim() == ""){
		messageError = "<liferay-ui:message key='doc-r8-alert'/> <liferay-ui:message key='pccc-r4-alert'/>";
		alert(messageError);
		chudautu.focus();
		return false;
	}

	if (isNaN (dienthoai.value) == true ) {
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='Invalid.Phone must be number'/>\n");
		dienthoai.focus();
		return false;
	}

	if (isNaN (dienthoainhan.value) == true ) {
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='Invalid.Phone must be number'/>\n");
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

   	var str_paintdocumnet = document.getElementById('str_paintdocumnet').value
   	str_paintdocumnet = str_paintdocumnet.split(",,,/").join("");
   	var arrStrStr_paintdocumnet = str_paintdocumnet.split("/");
   	for (i = 0; i < arrStrStr_paintdocumnet.length - 1; i++) {
   	   	var arr = arrStrStr_paintdocumnet[i].split(",");
   	   	var tentailieubanve = document.getElementById(arr[1]);
   	 	var sobanve = document.getElementById(arr[2]);
   	   	if(tentailieubanve.value == "") {
   	   	   	alert("<liferay-ui:message key='pccc-TN-tentailieubanvesoluong'/>");
   	   		tentailieubanve.focus();
   	   	   	return false;
   	   	}
	   	 if(isNaN(sobanve.value)==true || sobanve.value.trim() == "")  {
		   	   	alert("<liferay-ui:message key='pccc-TN-tentailieubanvesoluong'/>");
		   	 	sobanve.focus();
		   	   	return false;
		   	}
   	}  
	return true;
}
/*/---------------phan them file dinh kem*/

/*/ function add row*/
var numFileUpload = 0;
var position = 1;
var positionFileUpload = 1;
var positionPaintDocument = 0;
var stringDocumentAttach ="";//contain string ten of element upload file
function insDocumentReceiptRow()
{
	var table=document.getElementById('attFile').insertRow(0);
	var nameDocument = table.insertCell(0);
	nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>documentAttach" +numFileUpload+"' id='dA" +numFileUpload+"'>"
	+"<input type='button' value='<liferay-ui:message key="delete"/>' onclick='deleteRow(this)' >";
	numFileUpload += 1;
	positionFileUpload += 1;
}

function fileUpload() {
	var listDocument = "";
	var valueListDocument ="";
	for(i = 0; i < numFileUpload; i++) {
		if(document.getElementById('dA'+ i)) {			
			listDocument += "documentAttach" + i + "_";
			valueListDocument += document.getElementById('dA'+ i).value +"/";
					
		}
	}
	document.getElementById('manyFile').value = listDocument;
	document.getElementById('valueManyFile').value = valueListDocument;
}

function addRowEdit(stt) {
	var tbl_DocDrawingLength = document.getElementById("tbl_DocDrawing").rows.length;
	var table=document.getElementById('tbl_DocDrawing').insertRow(tbl_DocDrawingLength);
	var title = table.insertCell(0);
	var tentailieubanve = table.insertCell(1);
	var soluong = table.insertCell(2);
	var ghichu = table.insertCell(3);
	var deleteRow = table.insertCell(4);

	title.width = "4%";
	tentailieubanve.width = "43%";
	soluong.width = "8%";
	ghichu.width = "39%";
	document.getElementById('stt').value = ++stt;

	title.innerHTML = '<div style="color:#DC0C0C;text-align:center; background-color:#EAEBDB" name="no_"></div>';
	tentailieubanve.innerHTML = '<div align="center"><input style="width: 95%" type="text" maxlength="100" id="tentailieubanve_' + stt + '" name="tentailieubanve_' + stt + '"/></div>';
	soluong.innerHTML = '<div align="center"><input style="width: 80%" type="text" id="soluong_' + stt + '" name="soluong_' + stt + '"/></div>';
	ghichu.innerHTML = '<div align="center"><input style="width: 95%" type="text" maxlength="200" name="<portlet:namespace />ghichu_' + stt + '" value="" /></div>';
	deleteRow.innerHTML = '<input type="button" value="<liferay-ui:message key="delete" />" onclick="deleteEditRow(this, ' + stt +')">';

	var currentTableLength = document.getElementById("tbl_DocDrawingMain").rows.length - 1;
	
	var tdNo = document.getElementsByName("no_");
	for ( var i = 0; i < tdNo.length; i++) {
		 currentTableLength += 1;
		 tdNo[i].innerHTML = "<span  id='no_'>"+ currentTableLength  + ".</span>";
	}
}

function deleteEditRow(r, stt) {
	var str_paintdocumnet = document.getElementById('str_paintdocumnet').value; 
	str_paintdocumnet = str_paintdocumnet.replace("tentailieubanve_" + stt, "");
	str_paintdocumnet = str_paintdocumnet.replace("soluong_" + stt, "");
	str_paintdocumnet = str_paintdocumnet.replace("ghichu_" + stt, "");
	document.getElementById('str_paintdocumnet').value = str_paintdocumnet;
	
	var i = r.parentNode.parentNode.rowIndex;
	document.getElementById('tbl_DocDrawing').deleteRow(i);

	//phan cho viec set lai so thu tu
			var currentTableLength = document.getElementById("tbl_DocDrawingMain").rows.length - 1;
			var tdNo = document.getElementsByName("no_");
			 for ( var i = 0; i < tdNo.length; i++) {
				 currentTableLength += 1;
				 tdNo[i].innerHTML = "<span  id='no'>"+ currentTableLength  + ".</span>";
			}
}

function deleteRowFileUpload(r, id) {
	var str_fileattachedfile = document.getElementById('str_fileattachedfile').value;
	str_fileattachedfile += id + "/";
	document.getElementById('str_fileattachedfile').value = str_fileattachedfile;
	
	 var i = r.parentNode.parentNode.rowIndex;
	 document.getElementById("tblFileUpload").deleteRow(i);
	 if (positionFileUpload > 0) {
		 positionFileUpload -= 1;
	 }
}

function deleteRow(r)
{
	 var i=r.parentNode.parentNode.rowIndex;
	 document.getElementById('attFile').deleteRow(i);
	 if (positionFileUpload > 0) {
		 positionFileUpload -= 1;
	 }
	 
}

function deleteEditMainRow(r, id)
{
	var str_paintdocumnet = document.getElementById('str_paintdocumnet').value;
	str_paintdocumnet = str_paintdocumnet.replace(id, "");
	str_paintdocumnet = str_paintdocumnet.replace("tentailieubanve_" + id, "");
	str_paintdocumnet = str_paintdocumnet.replace("soluong_" + id, "");
	str_paintdocumnet = str_paintdocumnet.replace("ghichu_" + id, "");
	document.getElementById('str_paintdocumnet').value = str_paintdocumnet;
	
	var i = r.parentNode.parentNode.rowIndex;
	document.getElementById('tbl_DocDrawingMain').deleteRow(i);

	var currentTableLength = document.getElementById("tbl_DocDrawingMain").rows.length - 1;
	var sttbv = document.getElementsByName("sttbv");
	for (var j = 0; j < currentTableLength; j++) {
		var stt = j + 1;
		sttbv[j].innerHTML = "<span id='sttbv'>"+ stt  + ".</span>";
	}
	
	var tdNo = document.getElementsByName("no_");
	for ( var i = 0; i < tdNo.length; i++) {
		 currentTableLength += 1;
		 tdNo[i].innerHTML = "<span  id='no'>"+ currentTableLength  + ".</span>";
	}
	 
}

function setStrPaintDocumnet(id, name, quantity, note) {

	document.getElementById('str_paintdocumnet').value += id + "," + name + "," + quantity + "," + note + "/";
}

function delStrPaintDocumnet(id, name, quantity, note) {

	var str_paintdocumnet = document.getElementById('str_paintdocumnet').value; 
	str_paintdocumnet = str_paintdocumnet.replace(id, "");
	str_paintdocumnet = str_paintdocumnet.replace(name, "");
	str_paintdocumnet = str_paintdocumnet.replace(quantiry, "");
	str_paintdocumnet = str_paintdocumnet.replace(note, "");
	document.getElementById('str_paintdocumnet').value = str_paintdocumnet;
}

function setStrAttachedFile(check, id, attachedfileid, name, original, copy, note) {

	var str_attachedfile = document.getElementById('str_attachedfile').value; 
	if(check == false) {
		
		str_attachedfile = str_attachedfile.replace(id, "");
		str_attachedfile = str_attachedfile.replace(attachedfileid, "");
		str_attachedfile = str_attachedfile.replace(name, "");
		str_attachedfile = str_attachedfile.replace(original, "");
		str_attachedfile = str_attachedfile.replace(copy, "");
		str_attachedfile = str_attachedfile.replace(note, "");
	} else {
		str_attachedfile += id + "," + attachedfileid + "," + name + "," + original + "," + copy + "," + note + "/";
	}
	
	document.getElementById('str_attachedfile').value = str_attachedfile;
	
}

/*/get hostname of web
 * 
 */
function getHostName(elementA, value) {
	elementA.setAttribute("href","http://" + window.location.host + value );
	
}
function checkonchangBR33(){
	var selectinput = document.getElementById('select');	
	var keyword = document.getElementById('<portlet:namespace/>keyword');	
	var loc = document.getElementById('<portlet:namespace/>loc');
	var comman = document.getElementById('<portlet:namespace/>comman');	
	var day = document.getElementById('<portlet:namespace/>day');
	var beginDate = document.getElementById('<portlet:namespace/>beginDate');
	var endDate = document.getElementById('<portlet:namespace/>endDate');
	
	var fileTypeFilterDiv = document.getElementById('<portlet:namespace/>fileTypeFilterDiv');
	var fileTypeFilter = document.getElementById('<portlet:namespace/>fileTypeFilter');

	if (selectinput.selectedIndex == 0 ){
		keyword.disabled = true;
		keyword.value = "";
		loc.disabled = true;
	  }

	else if (selectinput.selectedIndex > 0 && keyword.value == "") {
		keyword.disabled =false;
		loc.disabled = true;
	}
	if (selectinput.selectedIndex < 3) {
		comman.style.display = "inline";
		
		if(day != null){
			day.style.display = "none";
		}
		
		fileTypeFilterDiv.style.display = "none";
		
		beginDate.value = "";
		endDate.value = "";	
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	}
	
	else if (selectinput.selectedIndex == 3){
		comman.style.display = "none";
		day.style.display = "none";
		fileTypeFilterDiv.style.display = "inline";
		beginDate.value = "";
		endDate.value = "";
		keyword.value = "";
		
		document.getElementById('<portlet:namespace/>loc').disabled = true;
		
		
	}
	
	else {
		comman.style.display = "none";
		day.style.display = "inline";
		fileTypeFilterDiv.style.display = "none";
		keyword.value = "";		
		document.getElementById('<portlet:namespace/>loc').disabled = false;
	}
}

function enableButton () 
{
	document.getElementById('<portlet:namespace/>loc').disabled = false;
}

function checknguoinhan(){
	var Error="";	
	var nguoinhan = document.getElementById('nguoiNhan');
	var processInformation = document.getElementById('thongTinXuLy');
	if (nguoinhan.selectedIndex == 0) {
		Error += "<liferay-ui:message key='chonnguoitiepnhanxuly'/>\n";
		alert(Error);
		nguoinhan.focus();
		return false;
	}
			
	else{
		return true;
		
	}
}

function checkUploadFile() {
	var result = true;
	for(i = 0; i < numFileUpload; i++) {
		if(document.getElementById('dA'+ i)) {			
			var valueNameFile1 = document.getElementById('dA'+ i).value;
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();
			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
				result = false;				
				break;
			}
			
			var typeStandard = "xls,html,htm,doc,docx,xlsx,jpg,pmp,pdf"	
				
			if(typeStandard.search(type.toLowerCase()) == -1 ) {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>");
				result = false;	
				break;			
			}
		}
		
	}
	
	return result;
}

function displayAndHiddenReport() {
	
	  var divclass = document.getElementById('listdivpccc');
	  var full = document.getElementById('<portlet:namespace/>divcontent2');
	  if (divclass.style.display == "none") {		  
		  divclass.style.display = "inline";
		  document.getElementById("back").className = "back";
		  
	  }
	  else {
		  divclass.style.display = "none";
		  document.getElementById("back").className = "outer-full";
	  }
}

function imageChange(str, flag) {
	var div = document.getElementById(str);
	if (flag == 0) {
		div.innerHTML = "<img src='/html/images/asc_ico_01.gif'/>";
	}
	else {
		div.innerHTML = "<img src='/html/images/desc_ico_01.gif'/>";
	}
	div.style.display = "inline";
}
</script>
