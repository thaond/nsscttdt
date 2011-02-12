<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>

<!-- script type='text/javascript' src='/dwr/engine.js'></script-->
<!-- script type='text/javascript' src='/dwr/util.js'></script-->
<!--script type='text/javascript'src='/dwr/interface/pcccdocumentreceiptClient.js'></script-->
<!--script type='text/javascript'src='/dwr/interface/pcccDocumentLevelSendClient.js'></script-->
<script type="text/javascript" >
/* function add row*/
/*
window.onload = function () {	
	getDateReturnClient();	
}
*/

/**

function addnewlevelsend()
{
	document.getElementById("addlevelsendbtn").disabled=true;
	var lastrow=document.getElementById('addlevelsend'). rows.length;
	var table=document.getElementById('addlevelsend').insertRow(lastrow);
	
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
	
	chkbox.innerHTML="<div align='center'><input type='radio' name='chk' value=''/></div>";
	nameDocument.innerHTML="<div style='padding-right: 3px; text-align: right'>" + lastrow + ".</div>";
	codeRow.innerHTML="";
	nameRow.innerHTML="<div style='text-align: center'><input style='width: 98%' type='text' id='levelsendname' name='<portlet:namespace />levelsendname' value='' /></div>";
	editRow.innerHTML="<div style='text-align: right'><input type='submit'  name='editbtn' value='<liferay-ui:message key='document_save'/>' /></div>";
	deleteRow.innerHTML="<div><input type='button'  name='deletebnt' onclick='deleteLevelSendRow(this)' value='<liferay-ui:message key='documentRecordType.huy'/>' /></div> ";
	
	
}

function deleteLevelSendRow(row)
{
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addlevelsend').deleteRow(i);
	 document.getElementById("addlevelsendbtn").disabled=false;
	
}

 function editInfomation (id) {
	var chkLevelSend = document.getElementById("<portlet:namespace />chkLevelSend" + id);
	var span1LevelSend = document.getElementById("<portlet:namespace />span1LevelSend" + id);
	var hiddenLevelSend = document.getElementById("<portlet:namespace />hiddenLevelSend" + id);
	var button1LevelSend = document.getElementById("<portlet:namespace />button1LevelSend" + id);
	var span2LevelSend = document.getElementById("<portlet:namespace />span2LevelSend" + id);
	var span3LevelSend = document.getElementById("<portlet:namespace />span3LevelSend" + id);

	//remove all element in span1LevelSend
	for (var i = 0; i < span1LevelSend.childNodes.length; i++) {
		span1LevelSend.removeChild(span1LevelSend.firstChild);
	}

	// edit attribute of hiddenLevelSend and append to span1LevelSend
	hiddenLevelSend.type = "text";
	span1LevelSend.appendChild(hiddenLevelSend);

	//remove all element in span2LevelSend
	for (var i = 0; i < span2LevelSend.childNodes.length; i++) {
		span2LevelSend.removeChild(span2LevelSend.firstChild);
	}

	// create a button and append to span2LevelSend
	span2LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='document_save'/>' onclick='updateDocumentLevelSend(" + id + ")'/>";

	//remove all element in span3LevelSend
	for (var i = 0; i < span3LevelSend.childNodes.length; i++) {
		span3LevelSend.removeChild(span3LevelSend.firstChild);
	}

	// create a button and append to span3LevelSend
	span3LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='documentRecordType.huy'/>' onclick='resetDocumentLevelSend(" + id + ", \"" + hiddenLevelSend.value + "\")'/>";

	chkLevelSend.checked = "checked";
 }

 function updateDocumentLevelSend(id) {
	var hiddenLevelSend = document.getElementById("<portlet:namespace />hiddenLevelSend" + id);
	if ( hiddenLevelSend.value.trim() =="")
	{
		alert("<liferay-ui:message key='nhapcapcongvan'/>");
	}
	else
	{
		var chkLevelSend = document.getElementById("<portlet:namespace />chkLevelSend" + id);
		var span1LevelSend = document.getElementById("<portlet:namespace />span1LevelSend" + id);
		var button1LevelSend = document.getElementById("<portlet:namespace />button1LevelSend" + id);
		var span2LevelSend = document.getElementById("<portlet:namespace />span2LevelSend" + id);
		var span3LevelSend = document.getElementById("<portlet:namespace />span3LevelSend" + id);
		//remove all element in span1LevelSend
		for (var i = 0; i < span1LevelSend.childNodes.length; i++) {
			span1LevelSend.removeChild(span1LevelSend.firstChild);
		}
	
		hiddenLevelSend.type = "hidden";
		span1LevelSend.innerHTML = hiddenLevelSend.value;
		span1LevelSend.appendChild(hiddenLevelSend);
	
		//remove all element in span2LevelSend
		for (var i = 0; i < span2LevelSend.childNodes.length; i++) {
			span2LevelSend.removeChild(span2LevelSend.firstChild);
		}
	
		// create a button and append to span2LevelSend
		span2LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='recordtype.edit'/>' onclick='editInfomation(" + id + ")'/>";
	
		chkLevelSend.checked = "checked";
		//remove all element in span3LevelSend
		for (var i = 0; i < span3LevelSend.childNodes.length; i++) {
			span3LevelSend.removeChild(span3LevelSend.firstChild);
		}
	
		// create a button and append to span2LevelSend
		var row = span3LevelSend.parentNode.parentNode.rowIndex;
		span3LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='deleteDocumentLevelSend(" + row + " ," + id + ")'/>";
			pcccDocumentLevelSendClient.updateDocumentLevelSend(id, hiddenLevelSend.value, function(data) {
				if (data) {
					alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
				}
				else {
					alert("<liferay-ui:message key='cap-nhat-khong-thanh-cong'/>");
				}
			});
	}
	
 }	 

 //minhnv update
 //xoa cap goi cong van
 function deleteDocumentLevelSend(row, id) {
	var flag = confirm("<liferay-ui:message key='xoacapcongvan'/>");
	if (flag) {
		pcccDocumentLevelSendClient.deleteDocumentLevelSendServer(id, function(data){			
			if (data) {
				document.getElementById('addlevelsend').deleteRow(row);
				//window.location.reload(true);
				alert("<liferay-ui:message key='xoa-thanh-cong'/>");
				
			}
			else {
				alert("<liferay-ui:message key='khong-the-xoa-dong-nay'/>");
				
			}
		});
	 	
	}
	
 }

 function resetDocumentLevelSend(id, hid) {
	var chkLevelSend = document.getElementById("<portlet:namespace />chkLevelSend" + id);
	var span1LevelSend = document.getElementById("<portlet:namespace />span1LevelSend" + id);
	var hiddenLevelSend = document.getElementById("<portlet:namespace />hiddenLevelSend" + id);
	var button1LevelSend = document.getElementById("<portlet:namespace />button1LevelSend" + id);
	var span2LevelSend = document.getElementById("<portlet:namespace />span2LevelSend" + id);
	var span3LevelSend = document.getElementById("<portlet:namespace />span3LevelSend" + id);

	//remove all element in span1LevelSend
	for (var i = 0; i < span1LevelSend.childNodes.length; i++) {
		span1LevelSend.removeChild(span1LevelSend.firstChild);
	}

	hiddenLevelSend.type = "hidden";
	hiddenLevelSend.value = hid;
	span1LevelSend.innerHTML = hiddenLevelSend.value;
	span1LevelSend.appendChild(hiddenLevelSend);
	
	//remove all element in span2LevelSend
	for (var i = 0; i < span2LevelSend.childNodes.length; i++) {
		span2LevelSend.removeChild(span2LevelSend.firstChild);
	}

	// create a button and append to span2LevelSend
	span2LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='recordtype.edit'/>' onclick='editInfomation(" + id + ")'/>";

	//remove all element in span3LevelSend
	for (var i = 0; i < span3LevelSend.childNodes.length; i++) {
		span3LevelSend.removeChild(span3LevelSend.firstChild);
	}

	// create a button and append to span3LevelSend
	var row = span3LevelSend.parentNode.parentNode.rowIndex;
	span3LevelSend.innerHTML = "<input type='button' value='<liferay-ui:message key='documentType.delete'/>' onclick='deleteDocumentLevelSend(" + row + ", " + id + ")'/>";

	chkLevelSend.checked = "checked";
 }
 function testlevelsend() {
	 
	 var namerecord = document.getElementById("levelsendname");
	 if (namerecord.value.trim() == "" ){
		 alert("<liferay-ui:message key='nhapcapcongvan'/>");
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

function editPmlEdmLevelSend (id) {
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	name.style.display="none";
	editName.style.display="inline";
	
	current.style.display="none";
	edit.style.display="inline";
	
	
}


function delettePmlEdmLevelSend(id, url) {
	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
		form.action = url;
		form.submit();
	}
	
}

function cancel (id) {
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	name.style.display="inline";
	editName.style.display="none";
	
	current.style.display="inline";
	edit.style.display="none";
}

function updatePmlEdmLevelSend (id, url) {
	var form = document.<portlet:namespace />fm;
	form.action = url;
	var name = document.getElementById("hidden" + id);
	form.onsubmit = "";
	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
	}
	else {
		form.submit();
	}
}
 // end
</script>	
	
	