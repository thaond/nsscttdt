<%@page import="com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway"%>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>

<%--script type='text/javascript'src='/dwr/interface/pcccdocumentsendprocessClient.js'></script--%>

<script type='text/javascript'src='/dwr/interface/documentSendUtilClient.js'></script>
<script type='text/javascript'src='/dwr/interface/tinhHinhThuLyCongVanClient.js'></script>

<script type='text/javascript' >
var incstt = 0;


function validateFormEdit() {
	fileUpload();	
	
	var sovakyhieuvanban = document.getElementById('sohieucvdtn');
	var ngaygui = document.getElementById('ngayguicvdtn');
	var ngaybanhanh =document.getElementById('ngaybanhanhcvdtn');
	//var noinhancvdtn = document.getElementById('receiveplace');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');
	var creator = document.getElementById('creator');

	if (creator.value == 0) {
		alert("<liferay-ui:message key='chon-nguoi-soan-van-ban'/>");
		creator.focus();
		return false;
	}

	/*
	if (sovakyhieuvanban.value.trim() == "" || isNaN(sovakyhieuvanban.value) || sovakyhieuvanban.value < 1) {
		alert("<liferay-ui:message key='vui-long-nhap-so-va-lon-hon-0'/>");
		sovakyhieuvanban.focus();
		return false;
	}
	*/
	if (isDatevalid(ngaygui.value)==false){
		ngaygui.focus();
		return false;
	}
	
	if(isDatevalid(ngaybanhanh.value)==false ){		
		ngaybanhanh.focus();
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

/**	
 * phmphuc them 11/11/2010
 * lay so cong van theo loai cong van duoc chon
 */
 /*
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

//lay so hieu + phan mo rong phong ban theo loai vb
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
	
	pcccdocumentsendprocessClient.getSoHieuVB(documentTypeId, numofdirector, function (data) {
		if (data != 0) {
			if (document.getElementById('sohieucvdtn') != null){
				document.getElementById('sohieucvdtn').value = data;
			}
		}
	});
	
	pcccdocumentsendprocessClient.getPhanMoRong(documentTypeId, departmentsId, numofdirector, function (data) {
		if (data != null && data != "") {
			document.getElementById('phanmorong').value = data;
		}
	});
}
*/
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

//yenlt update 20101029
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

/**
 * phmphuc update 07/01/2010
 * kiem tra so va ky hieu van ban da ton tai chua truoc khi cho phat hanh
 */
 /*
function kiemTraSoVaKyHieuVB() {
	// Ham kiem tra document reference, tra ve true/false
	var sohieu = document.getElementById("sohieucvdtn");
	var phanmorong = document.getElementById("phanmorong");
	var ngaybanhanh = document.getElementById("ngaybanhanhcvdtn");

	var yearForCheck = 0;

	if (sohieu == null || sohieu.value == "" || ngaybanhanh == null) {
		return true; // Khong kiem tra duoc, tra ve true.
	}

	var sovbphathanh = sohieu.value + phanmorong.value;

	try {
		var arrDate = ngaybanhanh.value.split("/");
		yearForCheck = parseInt(arrDate[2]);
	} catch (err) {
		yearForCheck = 0;
	}
		
	pcccdocumentsendprocessClient.kiemTraSoVaKyHieuVBPhatHanh(sovbphathanh, yearForCheck, 0, function (data) {
		if (data > 0) { // neu ton tai so den theo so
			alert("<liferay-ui:message key='so-va-ky-hieu-vb-phat-hanh-da-ton-tai'/>");

			// lay so
			changeSoVaKyHieuVB();
		}
	});
}

function changeSoVaKyHieuVB() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var departmentsId = DWRUtil.getValue('departmentsId');
	var numofdirector = DWRUtil.getValue('numofdirector');

	pcccdocumentsendprocessClient.getSoHieuVB(documentTypeId, numofdirector, function (data) {
		if (data != 0) {
			document.getElementById('sohieucvdtn').value = data;
		}
	});
	
	pcccdocumentsendprocessClient.getPhanMoRong(documentTypeId, departmentsId, numofdirector, function (data) {
		if (data != null && data != "") {
			document.getElementById('phanmorong').value = data;
		}
	});
}
*/
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
		
			changeDocumentTypeSend();
		}
		else {
			//alert("khong co docment type")
		}		
	});
}

/**
 * get number document when change document type
 */
function changeDocumentTypeSend() {
	var documentTypeId =  DWRUtil.getValue('loaicongvancvdtn');
	var documentRecordTypeId = DWRUtil.getValue('socongvancvdtn');
	//var userId = DWRUtil.getValue('userId');
	var dept = DWRUtil.getValue('dept');
	
	var <portlet:namespace/>documentRecordTypeCode = document.getElementById('<portlet:namespace/>documentRecordTypeCode').value;
	var <portlet:namespace/>documentTypeCode = document.getElementById('<portlet:namespace/>documentTypeCode').value;
	var <portlet:namespace/>textAdd = document.getElementById('<portlet:namespace/>textAdd').value;
	var <portlet:namespace/>departmentCode = document.getElementById('<portlet:namespace/>departmentCode').value;
	var <portlet:namespace/>useYear = document.getElementById('<portlet:namespace/>useYear').value;
	var <portlet:namespace/>documentRecordTypeIdHidden = document.getElementById('<portlet:namespace/>documentRecordTypeIdHidden').value;
	// minh upate 20110215
	var <portlet:namespace/>soVanBanCuaPhong = document.getElementById('soVanBanCuaPhong').checked;
	//var departmentsId = document.getElementById('departmentsId').value;
	
	//var departmentsId = document.getElementById('departmentsId').value;
	//pcccdocumentreceiptClient.getNumberPublish(documentRecordTypeId, documentTypeId, userId,<portlet:namespace/>documentRecordTypeIdHidden, <portlet:namespace/>documentRecordTypeCode, <portlet:namespace/>documentTypeCode, <portlet:namespace/>textAdd, <portlet:namespace/>departmentCode, <portlet:namespace/>useYear, function (data){
	pcccdocumentreceiptClient.getNumberPublish(documentRecordTypeId, documentTypeId, dept, "", 
			<portlet:namespace/>documentRecordTypeIdHidden, <portlet:namespace/>documentRecordTypeCode, <portlet:namespace/>documentTypeCode, 
			<portlet:namespace/>textAdd, <portlet:namespace/>departmentCode, <portlet:namespace/>useYear,<portlet:namespace/>soVanBanCuaPhong, function (data){
		if (data != null) {
			document.getElementById('sohieucvdtn').value = data;
		}
		else {
			//alert ("khong co so hieu cong van");
		}		
	});
}

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

function getUsersByChangeDepartment() {
	// minh upate 20110218
	dwr.engine.beginBatch();
	// end minh upate 20110218

	var dept =  DWRUtil.getValue('dept');
	var elementSelect = document.getElementById('creator');
	dwr.util.removeAllOptions("creator");

	elementSelect.options[0] = new Option("<liferay-ui:message key='tinhhinhthulycongvan.chonchuyenvien'/>", 0);

	tinhHinhThuLyCongVanClient.getUserOfDepartment(dept, function (data){
		if (data.length > 0) {
			for ( var i = 0; i < data.length; i++) {
				var text = data[i].lastName + ' ' + data[i].middleName + ' ' + data[i].firstName;
				elementSelect.options[i] = new Option(text, data[i].userId);
			}
		}
		else {
			//alert("khong co docment type")
		}		
	});
	dwr.engine.endBatch({
		  async:false
		});
	
	// minh upate 20110218
	dwr.engine.beginBatch();
	//changeDocumentTypeSend();
	var departmentCode = document.getElementById('<portlet:namespace/>departmentCode').value;
	var vauleChecked = document.getElementById('soVanBanCuaPhong').checked;
	if (departmentCode) {
		if (vauleChecked) {
			loadDocumentRecordType();
		}
	}
	// end minh upate 20110218
	
	dwr.engine.endBatch({
		  async:false
		});
	
}

/*
 * minh update 20100215
 */
// load so van ban the do vi hay la phong

	function loadDocumentRecordType() {
		var  valueChecked = document.getElementById("soVanBanCuaPhong").checked;
		var  userIdLogin = document.getElementById("creator").value;
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