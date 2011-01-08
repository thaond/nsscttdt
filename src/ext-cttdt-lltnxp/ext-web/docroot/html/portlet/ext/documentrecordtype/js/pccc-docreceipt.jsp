<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<!-- script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script-->
<script type='text/javascript'src='/dwr/interface/pcccDocumentRecordTypeClient.js'></script>

<script type="text/javascript" >
/* function add row*/
 /*
window.onload = function () {	
	getDateReturnClient();
}
*/
/**

function addnewrecordtype()
{
	document.getElementById("addrecordtypebtn").disabled=true;
	var lastrow=document.getElementById('addrecordtype').rows.length;
	var table=document.getElementById('addrecordtype').insertRow(lastrow);
	var chkbox = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var codeRow = table.insertCell(2);
	var nameRow = table.insertCell(3);
	var editRow = table.insertCell(4);
	var deleteRow = table.insertCell(5);

	table.style.height = "25px";
	chkbox.style.backgroundColor = "#EBEADB";
	nameDocument.style.backgroundColor = "#EBEADB";
	if (lastrow % 2 == 0) {
		table.style.backgroundColor = "#E4E4E4";
	}
	else {
		table.style.backgroundColor = "#F2F2F2";
	}

	chkbox.innerHTML="<div align='center'><input type='radio' name='chk' value='' /></div>";
	nameDocument.innerHTML="<div style='padding-right: 3px; text-align: right'>" + lastrow + ".</div>";
	//codeRow.innerHTML="";
	codeRow.innerHTML="<div style='text-align: center'><input style='width: 98%' type='text' id='rdcode' name='<portlet:namespace />recordcode' value='' /></div>";
	nameRow.innerHTML="<div style='text-align: center'><input style='width: 98%' type='text' id='rdname' name='<portlet:namespace />recordname' value='' /></div>";
	editRow.innerHTML="<div style='text-align: right'><input type='submit'  name='editbtn' value='<liferay-ui:message key='document_save'/>' /></div>";
	deleteRow.innerHTML="<div><input type='button' name='deletebnt' onclick='deleteRow(this)' value='<liferay-ui:message key='documentRecordType.huy'/>' /></div> ";
	
	
}

function deleteRow(row)
{
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addrecordtype').deleteRow(i);
	 document.getElementById("addrecordtypebtn").disabled=false;
	
}



 function <portlet:namespace />editInfomation (id) {
	var chk = document.getElementById("<portlet:namespace />chk" + id);
	var spanCode = document.getElementById("<portlet:namespace />spanCode" + id);
	var span1 = document.getElementById("<portlet:namespace />span1" + id);
	var hiddenCode = document.getElementById("<portlet:namespace />hiddenCode" + id);
	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	var button1 = document.getElementById("<portlet:namespace />button1" + id);
	var span2 = document.getElementById("<portlet:namespace />span2" + id);
	var span3 = document.getElementById("<portlet:namespace />span3" + id);
	
	//remove all element in spanCode (o chua ma so cong van)
	for (var i = 0; i < spanCode.childNodes.length; i++) {
		spanCode.removeChild(spanCode.firstChild);
	}
	
	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}
	
	// edit attribute of hiddenCode and append to spanCode
	hiddenCode.type = "text";
	spanCode.appendChild(hiddenCode);
	
	// edit attribute of hidden and append to span1
	hidden.type = "text";
	span1.appendChild(hidden);

	//remove all element in span2
	for (var i = 0; i < span2.childNodes.length; i++) {
		span2.removeChild(span2.firstChild);
	}
	// create a button and append to span2
	span2.innerHTML = "<input type='button' value='<liferay-ui:message key='document_save'/>' onclick='<portlet:namespace />updateDocumentRecordType(" + id + ")'/>";
	//remove all element in span3
	for (var i = 0; i < span3.childNodes.length; i++) {
		span3.removeChild(span3.firstChild);
	}
	// create a button and append to span3
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentRecordType.huy'/>' onclick='<portlet:namespace />resetDocumentRecordType(" + id + ", \"" + hidden.value + "\", \"" + hiddenCode.value + "\")'/>";
	
	chk.checked = "checked";
 }

 function <portlet:namespace />updateDocumentRecordType(id) {
	
	var hiddenCode = document.getElementById("<portlet:namespace />hiddenCode" + id);
	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	
	if ( hiddenCode.value.trim() =="")
	{
		alert("<liferay-ui:message key='nhap-ma-so-cong-van'/>");
	}
	
	else if ( hidden.value.trim() =="")
	{
		alert("<liferay-ui:message key='nhapsocongvan'/>");
	}
	else
	{
	
		var chk = document.getElementById("<portlet:namespace />chk" + id);
		var spanCode = document.getElementById("<portlet:namespace />spanCode" + id);
		var span1 = document.getElementById("<portlet:namespace />span1" + id);
		
		var button1 = document.getElementById("<portlet:namespace />button1" + id);
		var span2 = document.getElementById("<portlet:namespace />span2" + id);
		var span3 = document.getElementById("<portlet:namespace />span3" + id);
		
		//remove all element in spanCode
		for (var i = 0; i < spanCode.childNodes.length; i++) {
			spanCode.removeChild(spanCode.firstChild);
		}
		
		//remove all element in span1
		for (var i = 0; i < span1.childNodes.length; i++) {
			span1.removeChild(span1.firstChild);
		}
		
		hiddenCode.type = "hidden";
		hidden.type = "hidden";
		spanCode.innerHTML = hiddenCode.value;
		spanCode.appendChild(hiddenCode);
		span1.innerHTML = hidden.value;
		span1.appendChild(hidden);
	
		//remove all element in span2
		for (var i = 0; i < span2.childNodes.length; i++) {
			span2.removeChild(span2.firstChild);
		}
	
		// create a button and append to span2
		span2.innerHTML = "<input type='button' value='<liferay-ui:message key='recordtype.edit'/>' onclick='<portlet:namespace />editInfomation(" + id + ")'/>";
	
		chk.checked = "checked";
	
		//remove all element in span3
		for (var i = 0; i < span3.childNodes.length; i++) {
			span3.removeChild(span3.firstChild);
		}
	
		// create a button and append to span3
		var row = span3.parentNode.parentNode.rowIndex;
		span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='<portlet:namespace />deleteDocumentRecordType(" + row + " ," + id + ")'/>";
		
		var code_name = hiddenCode.value + "_" + hidden.value; //gom 2 bien lam 1 de truyen di
		
		pcccDocumentRecordTypeClient.updateDocumentRecordType(id, code_name, function(data) {
				if (data) {
					alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
				}
				else {
					alert("<liferay-ui:message key='cap-nhat-khong-thanh-cong'/>");
				}
			});
	}
	
	
 }	 

 function <portlet:namespace />deleteDocumentRecordType(row, id) {
	var flag = confirm("<liferay-ui:message key='recordtype.delete.confirm'/>");
	if (flag) {
		pcccDocumentRecordTypeClient.deleteDocumentRecordType(id, function(data){
				if (data) {
					document.getElementById('addrecordtype').deleteRow(row);
					//window.location.reload(true);
					alert("<liferay-ui:message key='xoa-thanh-cong'/>");
					
				}
				else {
					alert("<liferay-ui:message key='khong-the-xoa-dong-nay'/>");
					
				}
			});
		 	
		}
 }

 function <portlet:namespace />resetDocumentRecordType(id, hid, hCid) {
 	var chk = document.getElementById("<portlet:namespace />chk" + id);
 	var spanCode = document.getElementById("<portlet:namespace />spanCode" + id);
	var span1 = document.getElementById("<portlet:namespace />span1" + id);
	var hiddenCode = document.getElementById("<portlet:namespace />hiddenCode" + id);
	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	var button1 = document.getElementById("<portlet:namespace />button1" + id);
	var span2 = document.getElementById("<portlet:namespace />span2" + id);
	var span3 = document.getElementById("<portlet:namespace />span3" + id);

	//remove all element in spanCode
	for (var i = 0; i < spanCode.childNodes.length; i++) {
		spanCode.removeChild(spanCode.firstChild);
	}

	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}

	hiddenCode.type = "hidden";
	hidden.type = "hidden";
	hiddenCode.value = hCid;
	hidden.value = hid;
	spanCode.innerHTML = hiddenCode.value;
	spanCode.appendChild(hiddenCode);
	span1.innerHTML = hidden.value;
	span1.appendChild(hidden);
	
	//remove all element in span2
	for (var i = 0; i < span2.childNodes.length; i++) {
		span2.removeChild(span2.firstChild);
	}

	// create a button and append to span2
	span2.innerHTML = "<input type='button' value='<liferay-ui:message key='recordtype.edit'/>' onclick='<portlet:namespace />editInfomation(" + id + ")'/>";

	//remove all element in span3
	for (var i = 0; i < span3.childNodes.length; i++) {
		span3.removeChild(span3.firstChild);
	}

	// create a button and append to span3
	var row = span3.parentNode.parentNode.rowIndex;
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='<portlet:namespace />deleteDocumentRecordType(" + row + ", " + id + ")'/>";

	chk.checked = "checked";
 }
 function test()
 {	
 	 var coderecord = document.getElementById("rdcode");	
	 var namerecord = document.getElementById("rdname");
	 
	 if (coderecord.value.trim() == "" ){
		 alert("<liferay-ui:message key='nhap-ma-so-cong-van'/>");
		 coderecord.focus();
		 return false;
	 }
	 
	 else if (namerecord.value.trim() == "" ){
		 alert("<liferay-ui:message key='nhapsocongvan'/>");
		 namerecord.focus();
		 return false;
	 }
	 else{
		 return true;
		 }
	 
		 	
 }
*/
// minh 20100206	

function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function editDocumentRecordType (id) {
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	code.style.display = "none";		
	editCode.style.display = "inline";		
	
	name.style.display = "none";
	editName.style.display = "inline";		

	current.style.display = "none";
	edit.style.display = "inline";
}


function deletteDocumentRecordType(id, url) {
	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
		form.action = url;
		form.submit();
	}
	
}

function cancel (id) {
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	code.style.display = "inline";		
	editCode.style.display = "none";		
	
	name.style.display = "inline";
	editName.style.display = "none";		

	current.style.display = "inline";
	edit.style.display = "none";
}

function updateDocumentRecordType (id, url) {
	var form = document.<portlet:namespace />fm;
	form.action = url;
	var code = document.getElementById("hiddenCode" + id);
	var name = document.getElementById("hidden" + id);
	
	form.onsubmit = "";
	
	
	if (code.value.trim () == "") {
		alert('<liferay-ui:message key="vui-long-nhap-documenttype-code"/>');
		code.focus();
		
	}  else	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
		name.focus();
	} 
	else {
		form.submit();
	}
}

function checkDRTCode(dRTCode) {
	var res = false;
	dwr.engine.beginBatch();
		pcccDocumentRecordTypeClient.checkCodeDocumentRecordType(dRTCode, function(data){
		 if (data) {			
			 res = true;
		 }	
		});
	dwr.engine.endBatch({
		  async:false
	});
	
	return res;
}

// end
 
</script>
	
	
	