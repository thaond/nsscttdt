<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type='text/javascript'src='/dwr/interface/documentSendUtilClient.js'></script>

<script type="text/javascript">
 
 // check book document exist ??? use ajax synchronied
 function checkBookDocumentRecord() {	 

 	var mainDepartmentId =  DWRUtil.getValue('selectedOptionsmain');
 	var documentReciepId = document.getElementById('documentReceiptId').value;
 	
 	pcccdocumentreceiptClient.isBookDocumentRecord(mainDepartmentId, documentReciepId, {callback:setValuesInDWR, async:false});

 	var result = document.getElementById('isBookDocumentRecord').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='Book-document-record-not-exist'/>\n");
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
 	
//ham dong mo xem qua trinh xu ly

function openProcess() {
	
	if (document.getElementById('seriesProcess').style.display == "inline") {	
		document.getElementById('seriesProcess').style.display = "none";
	}
	
	else if (document.getElementById('seriesProcess').style.display == "none") {		
		document.getElementById('seriesProcess').style.display = "inline";
	}
	
}
/*
 * start by triltm
 * Khi check vao cac checkbox chon nguoi nhan thi chuong trinh tu dong add nguoi dc chon vo danh sach
 * de chon nguoi xu ly chinh
 */
function checkUserAssign(elementRow) {
	
	var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('nguoiNhan'+idElementTd);
	
	if (!elementInput.checked) {
		elementInput.checked = true;			
		selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, elementInput.value );
	}
	else {
		elementInput.checked = false;
		var arrOption = selectedOptionsmain.options;		
		for ( var i = 0; i < arrOption.length; i++) {
			if (elementInput.value == arrOption[i].value) {
					
				selectedOptionsmain.remove(i);
				break; 
			}
		} 	
	}
	
}

/*
 * 
 * Ham check tat ca hoac bo tat ca user-phong ban o chuyen phong ban
 * de chon nguoi xu ly chinh
 */
function checkAllOrNoneUserAssign(self) {
	var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	var arrInput = document.getElementsByName('<portlet:namespace/>supportUsers');
	if (self.checked) {
		var elementRow;	
		for (i=0; i < arrInput.length; i++)	{
			elementRow = arrInput[i].parentNode.parentNode;
			selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, arrInput[i].value);
		}
	}
	else {
		dwr.util.removeAllOptions('selectedOptionsmain')
	}
	
}

/*
 * 
 * Ham check tat ca hoac bo tat ca user-phong ban o chuyen chuyen vien
 * de chon nguoi xu ly chinh
 */
function checkAllOrNoneUserAssignTwo(self) {
	var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	var arrInput = document.getElementsByName('<portlet:namespace/>supportUsers');
	if (self.checked) {
		var elementRow;	
		for (i=0; i < arrInput.length; i++)	{
			elementRow = arrInput[i].parentNode.parentNode;
			selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, arrInput[i].value);
		}
	}
	else {
		dwr.util.removeAllOptions('selectedOptionsmain')
	}
	
}

//ham nay goi khi click tren chinh checkbox chon phong ban hoac nhan vien
function checkInUserAssign(elementInput) {	
	
	var selectedOptionsmain = document.getElementById('selectedOptionsmain');	
	if (elementInput.checked) {
		var elementRow = elementInput.parentNode.parentNode;				
		selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, elementInput.value );
	}
	else {
		
		var arrOption = selectedOptionsmain.options;		
		for ( var i = 0; i < arrOption.length; i++) {
			if (elementInput.value == arrOption[i].value) {					
				selectedOptionsmain.remove(i);
				break; 
			}
		} 	
	}
	
}

function clickCheckBox(event,eleCheckBox)
{
	checkInUserAssign(eleCheckBox);
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


/*
 * Check validate chuyen phan cong cho chuyen vien
 */

 function subUserAss(){
	 if (!validateUserAssign()){
	 	return false;
	 }
	 else
	 {
	 	// gan du lieu truoc khi submit form.		 
		 var dateNumberProcessValue = document.getElementById('dateNumberProcess');
		 var totalDateProcessCalenValue = document.getElementById('totalDateProcessCalen');
		 check_1 = document.getElementById("check_1");
         check_2 = document.getElementById("check_2");
		 if (totalDateProcessCalenValue.disabled == true && check_2.checked == true )
		 	totalDateProcessCalenValue.value = "";
		 if (dateNumberProcessValue.disabled == true && check_1.checked == true)
		 	dateNumberProcessValue.value = 0;
	 }
	 return true;
 }

 
 function validateUserAssign() {
	 //var processInformation = document.getElementById('processInformation');
	 var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	 var dateNumberProcess = document.getElementById('dateNumberProcess');
	 var totalDateProcessCalen = document.getElementById('totalDateProcessCalen');	 
	 var timeRemain = document.getElementById('timeRemain');
	// minh update 20101117
	 var <portlet:namespace />checkInfo = document.getElementById('<portlet:namespace />checkInfo');
	// if (<portlet:namespace />checkInfo.checked) {
	//	 if (processInformation.value.trim() == "") {
	//		 alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
	//		 processInformation.focus();
	//		 return false;
	//	 }
	// }
	 if (selectedOptionsmain.options.length == 0) {
		 alert('<liferay-ui:message key="vui-long-chon-nguoi-nhan"/>');
		 selectedOptionsmain.focus();
		 return false;
	 }

//	 if (dateNumberProcess.value.trim() == "") {
//			 alert('<liferay-ui:message key="nhap-so-ngay-xu-ly-phai-la-so" />');
//			 dateNumberProcess.focus();
//			 return false;
//	 }	
	 
	 if (dateNumberProcess.value.trim() != "") {
		 if(isNaN(dateNumberProcess.value)) {
			 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
			 dateNumberProcess.focus();
			 return false;
		 }
	 }

	 if (parseInt(dateNumberProcess.value) < 0) {		
		 alert('<liferay-ui:message key=" so-ngay-xu-ly-cua-chuyen-vien-phai-la-so-nguyen-duong" />');
		 dateNumberProcess.focus();
		 return false;
	 }

	if (parseInt(timeRemain.value.trim()) > 0) {	
		
		 if (parseInt(timeRemain.value.trim()) < parseInt(dateNumberProcess.value.trim())) {
			alert('<liferay-ui:message key="so-ngay-con-lai-phai-lon-hon-so-ngay-xu-ly" />');
			dateNumberProcess.focus();
			return false;
		}

	}	
		
	if(isDate(totalDateProcessCalen.value.trim()) == false && totalDateProcessCalen.disabled == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		totalDateProcessCalen.focus();
		return false;
	 } 
	 if (!CompareCalenNowUserAss()){
		 return false;
	 }
	 else {
		 return true;
	 }
}
 
		// Kiem tra calendar nhap
		function CompareCalenNowUserAss(){
		// Kiem tra calendar so ngay xu ly voi ngay hien tai
			var dateHT = document.getElementById("<portlet:namespace />dateNow");
			var dateTotalCL = document.getElementById("totalDateProcessCalen");
			var dateXLChinh = document.getElementById("ddXLChinh");
			var dateXLDuocGiao = document.getElementById("ddXLDuocGiao");
			var strdateHT = dateHT.value.toString();
			var strdateTotalCL = dateTotalCL.value.toString();
			var objHT = sgs.stringToDate(strdateHT,"dmy");
			var objTotalCL = sgs.stringToDate(strdateTotalCL,"dmy"); 
			var strdateXLChinh = dateXLChinh.value.toString();
			var objXLChinh = sgs.stringToDate(strdateXLChinh,"dmy");
			var strdateXLDuocGiao = dateXLDuocGiao.value.toString();
			var objXLDuocGiao = sgs.stringToDate(strdateXLDuocGiao,"dmy");
			// Kiem tra so ngay xu ly chinh voi ngay nhap tren Calen phai nho hon ngay xu ly chinh		
			if (dateXLChinh.value.trim() != "")
			{
				if (objTotalCL > objXLChinh && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled == false)){
					alert('<liferay-ui:message key = "ngay-giai-quyet-phai-nho-hon-tong-thoi-gian"/>');
					dateTotalCL.focus();
					return false;
				}
			}
			// Kiem tra so ngay xu ly duoc giao so voi ngay nhap tren Calen phai nho hon ngay duoc giao
			if (dateXLDuocGiao.value.trim() !="")
			{
				if (objTotalCL > objXLDuocGiao && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled == false))
				{
					alert('<liferay-ui:message key = "ngay-giai-quyet-phai-nho-hon-so-ngay-duoc-giao"/>');
					dateTotalCL.focus();
					return false;
				}
			}
			// kiem tra ngay giai quyet phai lon hon ngay hien tai
			if (objTotalCL < objHT && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled ==false))
			{
				alert('<liferay-ui:message key="ngay-giai-quyet-phai-lon-hon-ngay-hien-tai"/>');
				dateTotalCL.focus();
				return false;
			}
			//
			return true;
		}


/*
 * validate cho form chuyen lanh dao
 */
function validateTransForm() {	
	//var thongTinXuLy = document.getElementById('processInformation');
	
	//if (thongTinXuLy != null && thongTinXuLy.value.trim() == "") {
	//	alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
	//	thongTinXuLy.focus();
	//	return false;
	//}
	
	
	var arrRadioElements = document.getElementsByName("<portlet:namespace/>receiverId");
	
	var res = false;
	for ( var i = 0; i < arrRadioElements.length; i++) {
		if (arrRadioElements[i].checked) {
			res = true;
			break;
		}		
	}

	if(!res) {
		alert('<liferay-ui:message key="vui-long-chon-lanh-dao"/>');
		arrRadioElements[0].focus();
	 return false;
	}
	return true;
		
}

/*
 * Check validate chuyen phan cong cho phong ban
 */

 function subDepart(){
	 if (!validateDepartmentAssign()){
	 	return false;
	 }
	 else
	 {
	 	// gan du lieu truoc khi submit form.
		 var totalDateProcessValue = document.getElementById('totalDateProcess');
		 var dateNumberProcessValue = document.getElementById('dateNumberProcess');
		 var totalDateProcessCalenValue = document.getElementById('totalDateProcessCalen');
		 var totalDateProcessCalenResValue = document.getElementById('totalDateProcessCalenRes');
		 if (totalDateProcessValue.disabled == true)
		 	totalDateProcessValue.value = 0;
		 if (totalDateProcessCalenValue.disabled == true)
		 	totalDateProcessCalenValue.value = "";
		 if (dateNumberProcessValue.disabled == true)
		 	dateNumberProcessValue.value = 0;
		 if (totalDateProcessCalenResValue.disabled == true)
		 	totalDateProcessCalenResValue.value = "";
	 }
	 return true;
 }

 /*
  * kiem tra co phai la LDP xu ly chinh?
  */
  function checkDepartmentLeader(){
	 // var checkBoolean = false;
	  var checkUserMainBoolean = true;
	  <% 
	  	listUserLDB = prefs.getValues("listUserLDB", new String[0]);
	
	  	String listUserLDBString  = "";
	    for (int i = 0; i < listUserLDB.length; i++) {
	    	if (i == listUserLDB.length - 1) {
	    		listUserLDBString += String.valueOf(listUserLDB[i]);
	    		break;
	    	}
	    	listUserLDBString += String.valueOf(listUserLDB[i]).concat("_");
	    }
	  %>
	//  var arrSupportUsers = document.getElementsByName("<portlet:namespace/>supportUsers");
	  var mainUser = document.getElementById("selectedOptionsmain");
	 
	  var arrListUserLDBString = "<%= listUserLDBString %>".split("_");

	  // lay danh sach nhung can bo duoc chon
	//  var arrSupportUsersChecked = new Array();;
	//  var count = 0;	
	//  for (var i=0; i<arrSupportUsers.length; i++) {		  
	//	  if (arrSupportUsers[i].checked) {
	//	  	arrSupportUsersChecked[count] = arrSupportUsers[i];
	//	  	count +=1;
	//	  }   
	//  }

	  // lay can bo la nguoi xu ly chinh
	  var mainUserValue = "";
	  for (var i=0; i<mainUser.length; i++) {
		  if (mainUser.options[i].selected) {
			  mainUserValue = mainUser.options[i].value;
			  break;
		  }   
	  }	
	 
	// kiem tra xem co pho truong ban va lanh dao phong khong
	  var countMainUser = 0;	
	  for (var i = 0; i < mainUser.length; i++) {
		  for (var j = 0; j < arrListUserLDBString.length; j++) {
			  if (mainUser.options[i].value == arrListUserLDBString[j]) {
				  countMainUser +=1;
				  break;
			  } 
		  }
	  }
	  document.getElementById("countLDB").value = countMainUser + "";  
	  
	// chi co pho lanh dao ban	
	  if (countMainUser == mainUser.length) {
		  
		//return false;
		  return true;
	  }
		
	  for (var i = 0; i < arrListUserLDBString.length; i++) {
		 if (mainUserValue != arrListUserLDBString[i]) {
			 checkUserMainBoolean = false;
		 } else {
			 checkUserMainBoolean = true;
			 break;
		 }
	  }
	return checkUserMainBoolean;
  }

 function validateAgencyProcess() {
	 //var processInformation = document.getElementById('processInformation');	
	 var totalDateProcess = document.getElementById('totalDateProcess');
	 var dateNumberProcess = document.getElementById('dateNumberProcess');
	 var totalDateProcessCalen = document.getElementById('totalDateProcessCalen');
	 var totalDateProcessCalenRes = document.getElementById('totalDateProcessCalenRes');
	 
	 var documentType = document.getElementsByName('<portlet:namespace />documentType');

	// if (processInformation.value.trim() == "") {
	//	 alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
	//	 processInformation.focus();
	//	 return false;
	 //}

	 var res = false;
		for ( var i = 0; i < documentType.length; i++) {
			if (documentType[i].checked) {
				res = true;
				break;
			}		
		}

		if(!res) {
			alert('<liferay-ui:message key="vui-long-chon-cach-thuc-xu-ly"/>');
			documentType[0].focus();
		 return false;
		}

		if (totalDateProcess.value.trim() != "" && totalDateProcess.disabled == false) {

			 if(isNaN(totalDateProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 totalDateProcess.focus();
				 return false;
			 }
		 }

		 if (dateNumberProcess.value.trim() != "" && dateNumberProcess.disabled == false) {
		 
				
			 if(isNaN(dateNumberProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 dateNumberProcess.focus();
				 return false;
			 }
		 }

		 if (parseInt(totalDateProcess.value) < 0 && totalDateProcess.disabled == false) {			 
	 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-la-so-nguyen-duong" />');
			 totalDateProcess.focus();
			 return false;
		 }	

		 if (parseInt(dateNumberProcess.value) < 0 && dateNumberProcess.disabled == false) {			 
	 
			 alert('<liferay-ui:message key="so-ngay-xu-ly-phai-la-so-nguyen-duong" />');
			 dateNumberProcess.focus();
			 return false;
		 }		

		 if (parseInt(totalDateProcess.value) < parseInt(dateNumberProcess.value) && totalDateProcess.disabled == false && dateNumberProcess.disabled == false) {			 
			 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-lon-hon-so-ngay-xu-ly" />');
			 dateNumberProcess.focus();
			 return false;
		 }

			if(isDate(totalDateProcessCalen.value) == false && totalDateProcessCalen.disabled == false) {
				alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
				totalDateProcessCalen.focus();
				return false;
			 } 
			 
			 if(isDate(totalDateProcessCalenRes.value) == false && totalDateProcessCalenRes.disabled == false) {
				alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
				totalDateProcessCalenRes.focus();
				return false;
			 } 
			 if (!CompareCalenNow()){
			 	return false;
			 }
			// else {
			// 	return true;
			// }

//		cong van den khong can vao so o phong ben thu thiem				 
//		 if (!checkBookDocumentRecord()){
//			 return false;
//		 }

	 else {
		 return true;
	 }

}
 
 function validateDepartmentAssign() {
	// var processInformation = document.getElementById('processInformation');
	 var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	 var totalDateProcess = document.getElementById('totalDateProcess');
	 var dateNumberProcess = document.getElementById('dateNumberProcess');
	 var totalDateProcessCalen = document.getElementById('totalDateProcessCalen');
	 var totalDateProcessCalenRes = document.getElementById('totalDateProcessCalenRes');
	 //minh update 20100316
	//  var documentReceiptType = document.getElementById('documentReceiptType');
	 //end
	 var documentType = document.getElementsByName('<portlet:namespace />documentType');

	 // minh update 20101117
	 var <portlet:namespace />checkInfo = document.getElementById('<portlet:namespace />checkInfo');
	 //if (<portlet:namespace />checkInfo.checked) {
	//	 if (processInformation.value.trim() == "") {
	//		 alert("s")
	//		 alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
	//		 processInformation.focus();
	//		 return false;
	//	 }
 	// }
	// end  minh update 20101117
	 if (selectedOptionsmain.options.length == 0) {
		 alert('<liferay-ui:message key="vui-long-chon-phong-ban"/>');
		 selectedOptionsmain.focus();
		 return false;
	 }

/* kiem tra check radio cach thuc xu ly
	 var documentType = document.getElementsByName('<portlet:namespace />documentType');	
	 var res = false;
		for ( var i = 0; i < documentType.length; i++) {
			if (documentType[i].checked) {
				res = true;
				break;
			}		
		}

		if(!res) {
			alert('<liferay-ui:message key="vui-long-chon-cach-thuc-xu-ly"/>');
			documentType[0].focus();
		 return false;
		}
	*/	
	
	//kiem tra check checkbox cach thuc xu ly
	var processType = document.getElementsByName('<portlet:namespace/>processType');
	var chk = false;
	for ( var i = 0; i < processType.length; i++) {
		if (processType[i].checked) {
			chk = true;
			break;
		}		
	 }
	// minh update 20100316
	
	//if (documentReceiptType.value == "") { 
		 if(!chk) {
			alert('<liferay-ui:message key="vui-long-chon-cach-thuc-xu-ly"/>');
			return false;
		 }
	//}
	 // end

		if (totalDateProcess.value.trim() != "" && totalDateProcess.disabled == false) {

			 if(isNaN(totalDateProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 totalDateProcess.focus();
				 return false;
			 }
		 }

		 if (dateNumberProcess.value.trim() != "" && dateNumberProcess.disabled == false) {
		 
				
			 if(isNaN(dateNumberProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 dateNumberProcess.focus();
				 return false;
			 }
		 }

		 if (parseInt(totalDateProcess.value) < 0 && totalDateProcess.disabled == false) {			 
	 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-la-so-nguyen-duong" />');
			 totalDateProcess.focus();
			 return false;
		 }	

		 if (parseInt(dateNumberProcess.value) < 0 && dateNumberProcess.disabled == false) {			 
	 
			 alert('<liferay-ui:message key="so-ngay-xu-ly-phai-la-so-nguyen-duong" />');
			 dateNumberProcess.focus();
			 return false;
		 }		

		 if (parseInt(totalDateProcess.value) < parseInt(dateNumberProcess.value) && totalDateProcess.disabled == false && dateNumberProcess.disabled == false) {			 
			 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-lon-hon-so-ngay-xu-ly" />');
			 dateNumberProcess.focus();
			 return false;
		 }

			if(isDate(totalDateProcessCalen.value) == false && totalDateProcessCalen.disabled == false) {
				alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
				totalDateProcessCalen.focus();
				return false;
			 } 
			 
			 if(isDate(totalDateProcessCalenRes.value) == false && totalDateProcessCalenRes.disabled == false) {
				alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
				totalDateProcessCalenRes.focus();
				return false;
			 } 
			 if (!CompareCalenNow()){
			 	return false;
			 }
			// else {
			// 	return true;
			// }

//		cong van den khong can vao so o phong ben thu thiem				 
//		 if (!checkBookDocumentRecord()){
//			 return false;
//		 }

	if (checkDepartmentLeader()) {
		alert('<liferay-ui:message key="chon-lanh-dao-phong-xu-ly-chinh" />');
		selectedOptionsmain.focus();
		return false;
	}	

	 else {
		 return true;
	 }

}

 /*
	* Kiem tra ngay hop le trong 2 calendar	
	*/
	function CompareCalenNow(){
	// Kiem tra calendar so ngay xu ly voi ngay hien tai
		var dateHT = document.getElementById("<portlet:namespace />dateNow");
		var dateTotalCL = document.getElementById("totalDateProcessCalen");
		var dateTotalCLRes = document.getElementById("totalDateProcessCalenRes");
		var strdateTotalCLRes = dateTotalCLRes.value.toString();
		var objTotalCLRes = sgs.stringToDate(strdateTotalCLRes,"dmy"); 
		var strdateHT = dateHT.value.toString();
		var strdateTotalCL = dateTotalCL.value.toString();
		var objHT = sgs.stringToDate(strdateHT,"dmy");
		var objTotalCL = sgs.stringToDate(strdateTotalCL,"dmy"); 
		// kiem tra ngay xu ly phai lon hon ngay hien tai
		if (objTotalCL < objHT && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled ==false)){
			alert('<liferay-ui:message key="ngay-xu-ly-phai-lon-hon-ngay-hien-tai" />');
			dateTotalCL.focus();
			return false;
		}  		
		// Kiem tra ngay giai quyet phai nho hon ngay xu ly
		if (objTotalCLRes > dateTotalCL  && (isDate(dateTotalCLRes.value) == true && dateTotalCLRes.disabled ==false) && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled ==false)){
			alert('<liferay-ui:message key="ngay-giai-quyet-phai-nho-hon-ngay-xu-ly" />');
			dateTotalCLRes.focus();
			return false;
		}
		//Kiem tra ngay giai quyet phai lon hon ngay hien tai
		if ((objTotalCLRes < objHT)  && (isDate(dateTotalCLRes.value) == true && dateTotalCLRes.disabled ==false)){
			alert('<liferay-ui:message key="ngay-giai-quyet-phai-lon-hon-ngay-hien-tai" />');
			dateTotalCLRes.focus();
			return false;
		}
		//Kiem tra ngay xu ly phai lon hon ngay giai quyet
		if ((objTotalCL < objTotalCLRes) && (isDate(dateTotalCLRes.value) == true && dateTotalCLRes.disabled ==false) && (isDate(dateTotalCL.value) == true && dateTotalCL.disabled ==false)){
			alert('<liferay-ui:message key="ngay-xu-ly-phai-lon-hon-ngay-giai-quyet" />');
			dateTotalCL.focus();
			return false;
		}
		return true;
	}	

function getSelectRadio(elementRow){		
		
		var idElementTd = elementRow.cells[0].id;	
		var elementInput = document.getElementById('nguoiNhan'+idElementTd)
		if (!elementInput.checked) {
			elementInput.checked = true;			
			
		}
		else if (elementInput.checked) {
			elementInput.checked = false;			
		}
	}

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


// phan cho forn gop y thong tin

// them mot domg upload file
var numFileUpload = 0;
var stringDocumentAttach ="";//contain string ten of element upload file
function insDocumentReceiptRow() {	
	var table = document.getElementById('attFile').insertRow(1);
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	
	title.innerHTML="<input style='width: 95%' name='titleDocumentAttach' type='text' id='tD" +numFileUpload+"'>";
	nameDocument.innerHTML="<input style='width: 95%' type='file' name='<portlet:namespace/>documentAttach" +numFileUpload+"' id='dA" +numFileUpload+"'>";
	deleteRow.innerHTML="<div align='center'><input style='width: 90%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
	numFileUpload += 1;
}

function fileUpload() {
	var processInformation = document.getElementById('processInformation')

	if ("" == processInformation.value.trim()) {
		alert('<liferay-ui:message key="nhapthongtinxuly"/>');
		processInformation.focus();
		return false;
	}

	
	var listDocument = "";
	var valueListDocument ="";
	var tileListDocument ="";
	
	for(i = 0; i < numFileUpload; i++) {
		if(document.getElementById('dA'+ i)) {			
			listDocument += "documentAttach" + i + "_";
			
			if (document.getElementById('tD'+ i).value == "") {
				alert('<liferay-ui:message key="nhap-tieu-de"/>');
				return false;
			}
			tileListDocument += document.getElementById('tD'+ i).value +"#"
			
			if (document.getElementById('dA'+ i).value == "") {
				alert('<liferay-ui:message key="dinh-kem-tap-tin"/>');
				
				return false; 
			}
			valueListDocument += document.getElementById('dA'+ i).value +"/";
		}
	}
	
	document.getElementById('manyFile').value = listDocument;
	document.getElementById('valueManyFile').value = valueListDocument;
	document.getElementById('titleManyFile').value = tileListDocument;	
	
	return true;
}


/*/function delete row
 * 
 */
function deleteRow(r)
{
	var i=r.parentNode.parentNode.parentNode.rowIndex;
	document.getElementById('attFile').deleteRow(i);
	
}

/* phmphuc get 10/07/2010
 * neu check vao Khong can chon thoi gian, thi disabled cac o tong thoi gian va thoi gian giai quyet cua phong
 */
function noChooseTime() {
	var nochoosetime = document.getElementById("nochoosetime");
	var totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
	var totalDateProcessCalenRes = document.getElementById("totalDateProcessCalenRes");

	var	totalDateProcessDis = document.getElementById("totalDateProcess");
	var dateNumberProcess = document.getElementById("dateNumberProcess");

	check_1 = document.getElementById("check_1");

	if(nochoosetime.checked) {
		totalDateProcessCalen.disabled = true;
		totalDateProcessCalenRes.disabled = true;
	
		totalDateProcessDis.disabled = true;		
		dateNumberProcess.disabled = true;
	}
	else {
		if (check_1.checked == true) {
			saveChoiceDateNum();
		}
		else {
			saveChoiceDateCalen();
		}
	}
}
// end

function saveChoiceDateNum(){
	totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
	totalDateProcessCalen.disabled = true;
	totalDateProcessCalenRes = document.getElementById("totalDateProcessCalenRes");
	//totalDateProcessCalenRes.value = ""; // phmphuc close 18/11/2010
	totalDateProcessCalenRes.disabled = true;

	totalDateProcessDis = document.getElementById("totalDateProcess");
	totalDateProcessDis.disabled = false;		
	dateNumberProcess = document.getElementById("dateNumberProcess");
	//dateNumberProcess.value = totalDateProcessDis.value; // phmphuc close 18/11/2010
	dateNumberProcess.disabled = false;
	
	check_1 = document.getElementById("check_1");
	check_1.checked = true;
	check_2 = document.getElementById("check_2");
	check_2.checked = false;
	check_3 = document.getElementById("check_3");
	check_3.checked = true;
	check_4 = document.getElementById("check_4");
	check_4.checked = false;

	// neu chon vao radio button thi set nochoosetime.checked = false
	nochoosetime = document.getElementById("nochoosetime");
	nochoosetime.checked = false;
}

function saveChoiceDateCalen(){
	totalDateProcessCalen = document.getElementById("totalDateProcessCalen");
	totalDateProcessCalen.disabled = false;
	totalDateProcessCalenRes = document.getElementById("totalDateProcessCalenRes");
	//totalDateProcessCalenRes.value = totalDateProcessCalen.value; // phmphuc close 18/11/2010
	totalDateProcessCalenRes.disabled = false;

	totalDateProcessDis = document.getElementById("totalDateProcess");
	totalDateProcessDis.disabled = true;
	dateNumberProcess = document.getElementById("dateNumberProcess");
	//dateNumberProcess.value = ""; // phmphuc close 18/11/2010
	dateNumberProcess.disabled = true;

	check_1 = document.getElementById("check_1");
	check_1.checked = false;
	check_2 = document.getElementById("check_2");
	check_2.checked = true;
	check_3 = document.getElementById("check_3");
	check_3.checked = false;
	check_4 = document.getElementById("check_4");
	check_4.checked = true;

	// neu chon vao radio button thi set nochoosetime.checked = false
	nochoosetime = document.getElementById("nochoosetime");
	nochoosetime.checked = false;
}

/*
 * chon thong tin xu ly chung hay khong  
 */
 
 function choiceProcessInformation(self) {
	var pI =  document.getElementById('processInformation');
	var sU = document.getElementsByName('<portlet:namespace/>supportUsers');
	var size = sU.length;
	
	if (self.checked) {
		pI.disabled = "";
		for (i=0; i < size; i++) {
			document.getElementById('<portlet:namespace/>user'+i).style.display = "none";
		}
	} else {
		pI.disabled = "disabled";		
		for (i=0; i < size; i++) {
			if (sU[i].checked) {
			document.getElementById('<portlet:namespace/>user'+i).style.display = "inline";
			}
		}
	}
 }
 
 /*
  * mo textarea tuong ung voi moi user
  */
  
 function openProcessInfoForEveryUser(self) {
		elementColumn = self.parentNode;
		var checkInfo = document.getElementById('<portlet:namespace />checkInfo');
		if (!checkInfo.checked) {
			if (self.checked) {
				document.getElementById("<portlet:namespace />user"+elementColumn.id).style.display = "inline";
			} else {
				document.getElementById("<portlet:namespace />user"+elementColumn.id).style.display = "none";
			}
		} else {
			document.getElementById("<portlet:namespace />user"+elementColumn.id).style.display = "none";
		}
 }
 
 /*
  * mo textarea tuong ung voi moi user khi chon o vi tri bat ky
  */
 function openProcessInfoForEveryUserTr(self) {
	 var inp = document.getElementById("nguoiNhan"+self.cells[0].id);
	 var checkInfo = document.getElementById('<portlet:namespace />checkInfo');
	 if (!checkInfo.checked) {
		if (inp.checked) {
			document.getElementById("<portlet:namespace />user"+self.cells[0].id).style.display = "inline";
		} else {
			document.getElementById("<portlet:namespace />user"+self.cells[0].id).style.display = "none";
		}
	 } else {
		 document.getElementById("<portlet:namespace />user"+self.cells[0].id).style.display = "none";
	}
 }
 
 /*
  * mo hoac dong tat ca textarea tuong ung voi moi user
  */
 function openAllInfo(self) {
		var sU = document.getElementsByName('<portlet:namespace/>supportUsers');
		var size = sU.length;
		var checkInfo = document.getElementById('<portlet:namespace />checkInfo');
		if (checkInfo.checked) {
			for (i=0; i < size; i++) {
				document.getElementById('<portlet:namespace/>user'+i).style.display = "none";
			}
		} else {
			for (i=0; i < size; i++) {
				if (sU[i].checked) {
					document.getElementById('<portlet:namespace/>user'+i).style.display = "inline";
				} else {
					document.getElementById('<portlet:namespace/>user'+i).style.display = "none";
				}
			}
			
		}
	 }
 
</script>