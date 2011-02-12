<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/PhieuChuyenClient.js'></script>
<script language="JavaScript" type="text/javascript">

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
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
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

	title.innerHTML = '<div align="center" name="no_"></div>';
	tentailieubanve.innerHTML = '<div><input style="width: 95%" type="text" id="tentailieubanve_' + stt + '" name="tentailieubanve_' + stt + '"/></div>';
	soluong.innerHTML = '<div align="center"><input style="width: 80%" type="text" id="soluong_' + stt + '" name="soluong_' + stt + '"/></div>';
	ghichu.innerHTML = '<div align="center"><input style="width: 95%" type="text"  name="<portlet:namespace />ghichu_' + stt + '" value="" /></div>';
	deleteRow.innerHTML = '<input type="button" value="<liferay-ui:message key="delete" />" onclick="deleteEditRow(this, ' + stt +')">';

	//var currentTableLength = document.getElementById("tbl_DocDrawingMain").rows.length - 1;
	var currentTableLength = document.getElementById("tbl_DocDrawing").rows.length;
	
	//var tdNo = document.getElementsByName("no_");
	//for ( var i = 0; i < tdNo.length; i++) {
	for ( var i = 1; i < currentTableLength; i++) {
		
		var arrRow = document.getElementById('tbl_DocDrawing').rows[i];
		 //currentTableLength += 1;
		 //tdNo[i].innerHTML = "<span  id='no_'>"+ currentTableLength  + ".</span>";
		  arrRow.cells[0].innerHTML = "<div align='center'  id='no_'>"+ i  + ".</div>";
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
			//var currentTableLength = document.getElementById("tbl_DocDrawingMain").rows.length - 1;
			var currentTableLength = document.getElementById("tbl_DocDrawing").rows.length;
			//var tdNo = document.getElementsByName("no_");
			 //for ( var i = 0; i < tdNo.length; i++) {
			 for ( var i = 1; i < currentTableLength; i++) {
				 //currentTableLength += 1;
				 //tdNo[i].innerHTML = "<span  id='no'>"+ currentTableLength  + ".</span>";
				 var arrRow = document.getElementById('tbl_DocDrawing').rows[i];
				 arrRow.cells[0].innerHTML = "<span  id='no'>"+ i  + ".</span>";
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
function checkBeginEndDate(){
	var beginDate = document.getElementById('<portlet:namespace/>beginDate');
	var endDate = document.getElementById('<portlet:namespace/>endDate');
	var selectinput = document.getElementById('select');	
	
	var d1 = new Date(beginDate.value);
	var d2 = new Date(endDate.value)
	if (selectinput.selectedIndex > 4) {
		if ("" == beginDate.value || "" == endDate.value ||d1 > d2 ) {
			return false;
		}
		else{
			return true;
		}
	}
	else {
		return true;
	}
}

function checkonchangBR33(){
	var selectinput = document.getElementById('select');	
	var keyword = document.getElementById('<portlet:namespace/>keyword');	
	var loc = document.getElementById('<portlet:namespace/>loc');
	var comman = document.getElementById('<portlet:namespace/>comman');	
	var day = document.getElementById('<portlet:namespace/>day');
	//var status = document.getElementById('<portlet:namespace/>status');
	//var fileStatusFilter = document.getElementById("<portlet:namespace/>fileStatusFilter");
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
		//if(fileStatusFilter != null){
		 //  fileStatusFilter.checked=false;
		//}
	}

//minh add
	// minh update 20100505
	if (selectinput.selectedIndex < 3) {
		comman.style.display = "inline";
		//status.style.display = "none";
		
		if(day != null){
			day.style.display = "none";
		}
		
		//if(fileStatusFilter != null){
		//	fileStatusFilter.checked=false;
		//}
		fileTypeFilterDiv.style.display = "none";
		
		beginDate.value = "";
		endDate.value = "";	
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	}
	
	else if (selectinput.selectedIndex == 3){
		comman.style.display = "none";
		//status.style.display = "none";
		day.style.display = "none";
		fileTypeFilterDiv.style.display = "inline";
		beginDate.value = "";
		endDate.value = "";
		keyword.value = "";
		
		document.getElementById('<portlet:namespace/>loc').disabled = true;
		
		
	}
	
	/*









	else if (selectinput.selectedIndex == 4){
	
		comman.style.display = "none";
		status.style.display = "inline";
		day.style.display = "none";
		beginDate.value = "";
		endDate.value = "";
		keyword.value = "";

		var arr =  document.getElementsByName('<portlet:namespace/>fileStatusFilter');
		document.getElementById('<portlet:namespace/>loc').disabled = true;
		

		for (i = 0; i < arr.length ; i++){
			if (arr[i].checked){				
				document.getElementById('<portlet:namespace/>loc').disabled = false;
				break;
			}
		}
	}
	*/
	// minh update 20100505



	else {
		comman.style.display = "none";
		//status.style.display = "none";
		day.style.display = "inline";
		fileTypeFilterDiv.style.display = "none";
		keyword.value = "";		
		document.getElementById('<portlet:namespace/>loc').disabled = false;
	}

	//end add
}

function submitAll(url){
	var selectinput = document.getElementById('select');	
	
	if (selectinput.selectedIndex == 0 ){
		javascript:submitForm(document.hrefFm, url);
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

function displayAndHidden () {
	
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

//yenlt 16/04/2010
function getUserId(){
	var receiverId = document.getElementById('nguoiNhan').value;
	PhieuChuyenClient.getDepartmentId(receiverId,{callback:setDepartmentId, async:false});
}

var setDepartmentId = function(data){
	var departmentIdBefore = document.getElementById('departmentIdBefore');
	departmentIdBefore.value = data;
}

//end
// yenlt 20082010
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
// end yenlt 20082010
</script>
