<%@ include file="/html/portlet/ext/processtype/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type='text/javascript'src='/dwr/interface/pcccDocumentRecordTypeClient.js'></script>
<script type='text/javascript'src='/dwr/interface/processTypeClient.js'></script>
<script type="text/javascript" >

function trim() {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function addnewprocesstype() {	
	document.getElementById("addprocesstypebtn").disabled=true;
	var lastrow=document.getElementById('addprocesstype').rows.length;
	var table=document.getElementById('addprocesstype').insertRow(lastrow);
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	var chkbox = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var nameRow = table.insertCell(2);
	var flagRow = table.insertCell(3);
	var editRow = table.insertCell(4);
	//var deleteRow = table.insertCell(5);
	//table.style.height = "25px";
	//chkbox.style.backgroundColor = "#EBEADB";
	//nameDocument.style.backgroundColor = "#EBEADB";
	if (lastrow % 2 == 0) {
		table.style.backgroundColor = "#daf5fd";
	} else {
		table.style.backgroundColor = "#f9ffff";
	}

	chkbox.innerHTML="<div align='center'><input  type='radio' name='chk' value='' /></div>";
	nameDocument.innerHTML="<div style='padding-right: 3px; text-align: right'>" + lastrow + ".</div>";
	nameRow.innerHTML="<div style='text-align: center'><input style='width: 95%' type='text' id='ptname' name='<portlet:namespace />ptname' value='' /></div>";
	flagRow.innerHTML="<div style='text-align: center'>" + 
							"<select style='width: 60%' id='ptflag' name='<portlet:namespace />ptflag'>" +
								"<option value='1'>1</option>" +
								"<option value='2'>2</option>" +
								"<option value='3'>3</option>" +
							"</select>" +
					  "</div>";
	editRow.innerHTML="<div align='center'> " +
							"<img class='image-edit' src='/html/images/image-save.png' onclick='test()'> " +
							"<img class='image-edit' src='/html/images/image-cancel.png' onclick='deleteRow(this)'/>" +
					  "</div>";
	//deleteRow.innerHTML="<div><input type='button' name='deletebnt' onclick='deleteRow(this)' value='<liferay-ui:message key='documentRecordType.huy'/>' /></div> ";
}

function deleteRow(row) {
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addprocesstype').deleteRow(i);
	 document.getElementById("addprocesstypebtn").disabled=false;
}
function <portlet:namespace />deleteProcessType(row, id) {
	 
	var flag = confirm("<liferay-ui:message key='process.delete.confirm'/>");
	if (flag) {
		processTypeClient.deleteProcessType(id, function(data){
				if (data) {
					document.getElementById('addprocesstype').deleteRow(row);
					//window.location.reload(true);
					alert("<liferay-ui:message key='xoa-thanh-cong'/>");
				} else {
					alert("<liferay-ui:message key='khong-the-xoa-dong-nay'/>");
				}
			});
	}
}

//yenlt update 28082010
function test() {
	var nameProcessType = document.getElementById("ptname");
	var flagProcessType = document.getElementById("ptflag");
	if (nameProcessType.value.trim() == "" ){
		alert("<liferay-ui:message key='nhap-ten'/>");
		nameProcessType.focus();
		return false;
	}
	if (flagProcessType.value.trim() == "" || isNaN(flagProcessType.value)) {
		alert("<liferay-ui:message key='nhap-ma-so'/>");
		flagProcessType.focus();
		return false;
	} else if(flagProcessType.value > 3 || flagProcessType.value < 1) {
		alert("<liferay-ui:message key='nhap-ma-so-tu-1-den-3'/>");
		flagProcessType.focus();
		return false;
	} else {
		document.<portlet:namespace />fm.submit();
		//return true;
	}
}

function <portlet:namespace />editProcessType(id) {
	var processTypeName = document.getElementById("processTypeName" + id);
	var editProcessTypeName = document.getElementById("editProcessTypeName" + id);
	 
	var processTypeFlag = document.getElementById("processTypeFlag" + id);
	var editProcessTypeFlag = document.getElementById("editProcessTypeFlag" + id);

 	var current = document.getElementById("current" + id);
 	var edit = document.getElementById("edit" + id);

 	processTypeName.style.display = "none";	
 	editProcessTypeName.style.display = "inline";	
 	 
 	processTypeFlag.style.display = "none";	
 	editProcessTypeFlag.style.display = "inline";
 		 
 	current.style.display = "none";	
 	edit.style.display = "inline";	 
}

function <portlet:namespace />cancel(id) {
	var processTypeName = document.getElementById("processTypeName" + id);
	var editProcessTypeName = document.getElementById("editProcessTypeName" + id);
	 
	var processTypeFlag = document.getElementById("processTypeFlag" + id);
	var editProcessTypeFlag = document.getElementById("editProcessTypeFlag" + id);

 	var current = document.getElementById("current" + id);
 	var edit = document.getElementById("edit" + id);

 	processTypeName.style.display = "inline";	
 	editProcessTypeName.style.display = "none";	
 	 
 	processTypeFlag.style.display = "inline";	
 	editProcessTypeFlag.style.display = "none";
 		 
 	current.style.display = "inline";	
 	edit.style.display = "none";	 
}

function <portlet:namespace />updateProcessType(id) {
	var hiddenProcessTypeName = document.getElementById("hiddenProcessTypeName" + id);
 	if (hiddenProcessTypeName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten'/>");
		return false;
	}
 	else {
 		document.getElementById("<portlet:namespace />cmd").value = "update";
 		document.getElementById("processTypeId").value = id;
 		document.<portlet:namespace />fm.submit();
 	}
}
// end yenlt update 28082010
/* yenlt close start 28082010
function <portlet:namespace />editInfomation (id) {
	var chk = document.getElementById("<portlet:namespace />chk" + id);
	//span chua name
	var span1 = document.getElementById("<portlet:namespace />span1" + id);
	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	var combox = document.getElementById("<portlet:namespace />combox" + id);
	//span chua flag
	var spanFlag = document.getElementById("<portlet:namespace />spanFlag" + id);
	var hiddenFlag = document.getElementById("<portlet:namespace />hiddenFlag" + id);
	
	var button1 = document.getElementById("<portlet:namespace />button1" + id);
	//button 1
	var span2 = document.getElementById("<portlet:namespace />span2" + id);
	//button 2
	var span3 = document.getElementById("<portlet:namespace />span3" + id);

	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}
	
	//remove all element in spanflag
	for (var i = 0; i < spanFlag.childNodes.length; i++) {
		spanFlag.removeChild(spanFlag.firstChild);
	}

	//edit attribute of hidden and append to span1
	hidden.type = "text";
	span1.appendChild(hidden);
	
	//edit attribute of hidden and append to spanflag
	hiddenFlag.type = "text";
	
	spanFlag.appendChild(hiddenFlag);
	
	//remove all element in span2
	for (var i = 0; i < span2.childNodes.length; i++) {
		span2.removeChild(span2.firstChild);
	}
	// create a button and append to span2
	span2.innerHTML = "<input type='button' value='<liferay-ui:message key='document_save'/>' onclick='<portlet:namespace />updateProcessType(" + id + ")'/>";
	//remove all element in span3
	for (var i = 0; i < span3.childNodes.length; i++) {
		span3.removeChild(span3.firstChild);
	}
	// create a button and append to span3
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentRecordType.huy'/>' onclick='<portlet:namespace />resetProcessType(" + id + " , \"" + hidden.value + "\", \"" + hiddenFlag.value + "\")'/>";
	
	chk.checked = "checked";
}

function <portlet:namespace />updateProcessType(id) {

	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	if ( hidden.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten'/>");
	}
	
	var hiddenFlag = document.getElementById("<portlet:namespace />hiddenFlag" + id);
	if ( hiddenFlag.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-so'/>");
	} else {
	
		var chk = document.getElementById("<portlet:namespace />chk" + id);
		var span1 = document.getElementById("<portlet:namespace />span1" + id);
		var spanFlag = document.getElementById("<portlet:namespace />spanFlag" + id);
		
		var button1 = document.getElementById("<portlet:namespace />button1" + id);
		var span2 = document.getElementById("<portlet:namespace />span2" + id);
		var span3 = document.getElementById("<portlet:namespace />span3" + id);
		
		//remove all element in span1
		for (var i = 0; i < span1.childNodes.length; i++) {
			span1.removeChild(span1.firstChild);
		}
		
		//remove all element in spanFlag
		for (var i = 0; i < spanFlag.childNodes.length; i++) {
			spanFlag.removeChild(spanFlag.firstChild);
		}
	
		hidden.type = "hidden";
		hiddenFlag.type = "hidden";
		span1.innerHTML = hidden.value;
		span1.appendChild(hidden);
		//spanFlag.innerHTML = hiddenFlag.value;
		spanFlag.appendChild(hiddenFlag);
	
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
		span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='<portlet:namespace />deleteProcessType(" + row + " ," + id + ")'/>";
		
		processTypeClient.updateProcessType(id, hidden.value, hiddenFlag.value, function(data) {
				if (data) {
					alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
				}
				else {
					alert("<liferay-ui:message key='cap-nhat-khong-thanh-cong'/>");
				}
			});
	}
}	 
*/


/* yenlt close 28082010
function <portlet:namespace />resetProcessType(id, hid, hFid) {
 	var chk = document.getElementById("<portlet:namespace />chk" + id);
	var span1 = document.getElementById("<portlet:namespace />span1" + id);
	var spanFlag = document.getElementById("<portlet:namespace />spanFlag" + id);
	var hidden = document.getElementById("<portlet:namespace />hidden" + id);
	var hiddenFlag = document.getElementById("<portlet:namespace />hiddenFlag" + id);
	var button1 = document.getElementById("<portlet:namespace />button1" + id);
	var span2 = document.getElementById("<portlet:namespace />span2" + id);
	var span3 = document.getElementById("<portlet:namespace />span3" + id);

	//remove all element in span1
	for (var i = 0; i < span1.childNodes.length; i++) {
		span1.removeChild(span1.firstChild);
	}
	
	//remove all element in spanFlag
	for (var i = 0; i < spanFlag.childNodes.length; i++) {
		spanFlag.removeChild(spanFlag.firstChild);
	}

	hidden.type = "hidden";
	hidden.value = hid;
	span1.innerHTML = hidden.value;
	span1.appendChild(hidden);
	
	hiddenFlag.type = "hidden";
	hiddenFlag.value = hFid;
	spanFlag.innerHTML = hiddenFlag.value;
	spanFlag.appendChild(hiddenFlag);
	
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
	span3.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='<portlet:namespace />deleteProcessType(" + row + ", " + id + ")'/>";

	chk.checked = "checked";
}
*/

</script>