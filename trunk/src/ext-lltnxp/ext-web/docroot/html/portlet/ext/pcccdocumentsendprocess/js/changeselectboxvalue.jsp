<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pcccdocumentsendClient.js'></script>

<script type="text/javascript">


/*
var selectedList;
var availableList;
var departmentMain;

function createListObjects(){
    availableList = document.getElementById("availableOptions");
    selectedList = document.getElementById("selectedOptions");
    departmentMain = document.getElementById("selectedOptionsmain");
    
}

function delAttribute(){
   selIndex = selectedList.selectedIndex;  
   
   if(selIndex < 0 )
      return;
   var nodeTransition = selectedList.options.item(selIndex);
   //transition.setAttribute('ondblclick','addAttribute()');
   
   availableList.appendChild(nodeTransition);
   departmentMain.removeChild(departmentMain.options.item(selIndex))
   
   selectNone(selectedList,availableList);   
   setSize(availableList,selectedList);
   
   
  
}

function addAttribute(){
   addIndex = availableList.selectedIndex;  
   if(addIndex < 0 )
      return;  
   var nodeTransition =  availableList.options.item(addIndex);
   //nodeTransition.setAttribute('ondblclick','delAttribute()');
   
   var newNode=availableList.options.item(addIndex).cloneNode(true);

   selectedList.appendChild(nodeTransition);
   departmentMain.appendChild( newNode);  
   
   selectNone(selectedList,availableList);  
   setSize(selectedList,availableList);
  
   
}

function setTop(top){
	document.getElementById
      ('someLayer').style.top = top;
}
function setLayerTop(lyr,top){
	lyr.style.top = top;
}

function setSize(list1,list2){
    list1.size = getSize(list1);
    list2.size = getSize(list2);
}

function selectNone(list1,list2){
    list1.selectedIndex = -1;
    list2.selectedIndex = -1;
   
    addIndex = -1;
    selIndex = -1;
    selIndexMain = -1;
    
}

function getSize(list){
   
    var len = list.childNodes.length;
    var nsLen = 0;
    //nodeType returns 1 for elements
    for(i=0; i<len; i++){
        if(list.childNodes.item(i).nodeType==1)
            nsLen++;
    }
    if(nsLen<2)
        return 2;
    else
        return nsLen;
}

function delAll(){
	var len = selectedList.length -1;
	
    for(i = len; i >= 0; i--){    	
       availableList.appendChild(selectedList.item(i));
       departmentMain.removeChild(departmentMain.item(i));
    }
    
   selectNone(selectedList,availableList);
   setSize(selectedList,availableList);
}

function addAll(){
    var len = availableList.length -1;
    for(i=len; i>=0; i--){
       var newAddAll=availableList.item(i).cloneNode(true);   	
       selectedList.appendChild(availableList.item(i));
       departmentMain.appendChild(newAddAll);
        
    }   
   selectNone(selectedList,availableList);   
   setSize(selectedList,availableList);
}


//------------------------------------------

//select all department had choice to process 
 function selectMultiDepartments() {
 	var list = document.getElementById("selectedOptions");
 	for (i = 0; i < list.length; i++) {
 		list.options[i].selected = true;
 	}
 }

 */ 
 
 // check book document exist ??? use ajax synchronied
 function checkBookDocumentRecord() {	 
// 	selectMultiDepartments();
//	var phongban = document.getElementById('selectedOptionsmain');
// 	var processInformation = document.getElementById('processInformation');

 	var mainDepartmentId =  DWRUtil.getValue('selectedOptionsmain');
 	var documentReciepId = document.getElementById('documentSendId').value;
 	
 	pcccdocumentsendClient.isBookDocumentRecord(mainDepartmentId, documentReciepId, {callback:setValuesInDWR, async:false});

 	var result = document.getElementById('isBookDocumentRecord').value;
 	
 	if (result == 'false') {
 	 	alert ("<liferay-ui:message key='Book-document-record-not-exist'/>\n");
 	 	return false;
 	}
 	/* 	
 	if (phongban.selectedIndex == -1) {
 		alert("<liferay-ui:message key='phancongphongxuly'/>\n");
 		phongban.focus();
 		return false;
	}
	
 	if (processInformation.value == "") {
 		alert("<liferay-ui:message key='nhapthongtinxuly'/>\n");
		processInformation.focus();
		return false;
	}
	*/

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
	var elementInput = document.getElementById('nguoiNhan'+idElementTd)
	
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
 function validateUserAssign() {
	 var processInformation = document.getElementById('processInformation');
	 var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	 var dateNumberProcess = document.getElementById('dateNumberProcess');
	 var timeRemain = document.getElementById('timeRemain');
	 
	 if (processInformation.value.trim() == "") {
		 alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
		 processInformation.focus();
		 return false;
	 }
	 if (selectedOptionsmain.options.length == 0) {
		 alert('<liferay-ui:message key="vui-long-chon-nguoi-nhan"/>');
		 selectedOptionsmain.focus();
		 return false;
	 }
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
	
		
	 if (parseInt(timeRemain.value.trim()) < parseInt(dateNumberProcess.value.trim())) {
		alert('<liferay-ui:message key="so-ngay-con-lai-phai-lon-hon-so-ngay-xu-ly" />');
		dateNumberProcess.focus();
		return false;
	}
	 else {
		 return true;
	 }
}

/*
 * validate cho form chuyen lanh dao
 */
function validateTransForm() {	
	var thongTinXuLy = document.getElementById('thongTinXuLy');
	var res = false;
	if (thongTinXuLy.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
		thongTinXuLy.focus();
		return false;
	}
	
	var arrRadioElements = document.getElementsByName("<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId");

	
	for ( var i = 0; i < arrRadioElements.length; i++) {
		if (arrRadioElements[i].checked) {
			res = true;
			break;
		}		
	}

	if(res == false) {
		alert('<liferay-ui:message key="vui-long-chon-nguoi-xu-ly"/>');
		arrRadioElements[0].focus();
	 return false;
	}
	
	else {
		return true;
	}
		
}

/*
 * Check validate chuyen phan cong cho phong ban
 */
 function validateDepartmentAssign() {
	 var processInformation = document.getElementById('processInformation');
	 var selectedOptionsmain = document.getElementById('selectedOptionsmain');
	 var totalDateProcess = document.getElementById('totalDateProcess');
	 var dateNumberProcess = document.getElementById('dateNumberProcess');
	 var documentType = document.getElementsByName('<portlet:namespace />documentType');

	 if (processInformation.value.trim() == "") {
		 alert('<liferay-ui:message key="vui-long-nhap-yeu-cau-xu-ly"/>');
		 processInformation.focus();
		 return false;
	 }
	 if (selectedOptionsmain.options.length == 0) {
		 alert('<liferay-ui:message key="vui-long-chon-phong-ban"/>');
		 selectedOptionsmain.focus();
		 return false;
	 }

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

		if (totalDateProcess.value.trim() != "") {
			 if(isNaN(totalDateProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 totalDateProcess.focus();
				 return false;
			 }
		 }

		 if (dateNumberProcess.value.trim() != "") {
			 if(isNaN(dateNumberProcess.value)) {
				 alert('<liferay-ui:message key="ngay-xu-ly-phai-la-so" />');
				 dateNumberProcess.focus();
				 return false;
			 }
		 }

		 if (parseInt(totalDateProcess.value) < 0) {			 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-la-so-nguyen-duong" />');
			 totalDateProcess.focus();
			 return false;
		 }	

		 if (parseInt(dateNumberProcess.value) < 0) {			 
			 alert('<liferay-ui:message key="so-ngay-xu-ly-phai-la-so-nguyen-duong" />');
			 dateNumberProcess.focus();
			 return false;
		 }		

		 if (parseInt(totalDateProcess.value) < parseInt(dateNumberProcess.value)) {			 
			 alert('<liferay-ui:message key="tong-so-ngay-phai-lon-hon-so-ngay-xu-ly" />');
			 dateNumberProcess.focus();
			 return false;
		 }

		 if (!checkBookDocumentRecord()){
			 return false;
		 }

	 else {
		 return true;
	 }

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
		event.stopPropagation();	
	}
	else // windows
		window.event.cancelBubble = true;
	return true; // co the false, bo
}


// phan cho forn gop y thong tin

// them mot domg upload file
var numFileUpload = 0;
var stringDocumentAttach ="";//contain string ten of element upload file
function sendumentSendRow() {	
	var table = document.getElementById('attFile').insertRow(1);
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);
	
	title.innerHTML="<input name='titleDocumentAttach' type='text' id='tD" +numFileUpload+"'>";
	nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>documentAttach" +numFileUpload+"' id='dA" +numFileUpload+"'>";
	deleteRow.innerHTML="<input type='button' value='delete' onclick='deleteRow(this)' ></input>";
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
			valueListDocument += document.getElementById('dA'+ i).value +"/";
			tileListDocument += document.getElementById('tD'+ i).value +"#"
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
	var i=r.parentNode.parentNode.rowIndex;
	document.getElementById('attFile').deleteRow(i);
}


</script>