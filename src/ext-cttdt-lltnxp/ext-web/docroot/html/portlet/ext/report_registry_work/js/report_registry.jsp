<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>

<script type="text/javascript">
	var incstt = 0;
	var incstt1 = 0;
	
	function checkValidate(){
		if(checkInput() == false || checkFileUpload() == false || checkFileUpload1() == false){
			return false;
		}else{
			fileUpload();
			fileUpload1();
		}
	}
	
	function checkInput(){
		if(document.<portlet:namespace/>fm.<portlet:namespace/>reportRegistryCode.value == ""){
			alert("<liferay-ui:message key='input-department-code'/>");
			return false;
		}
		if(document.<portlet:namespace/>fm.<portlet:namespace/>department.value == ""){
			alert("<liferay-ui:message key='input-department-name'/>");
			return false;
		}
	}
	
	function uploadResultFile(){
		var table=document.getElementById('addfileupload').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile' type='text' maxlength='255' id='titlefile" +incstt+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"' onchange='getFileNameForTitle(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
		incstt += 1;
	}
	
	function uploadProgramFile(){
		var table=document.getElementById('addfileupload1').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile1' type='text' maxlength='255' id='titlefile1" +incstt1+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile1" +incstt1+"' id='namefile1" +incstt1+"' onchange='getFileNameForTitle1(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow1(this)' ></input></div>";
		incstt1 += 1;
	}
	
	function getFileNameForTitle(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile", "");
			var titleObj = document.getElementById("titlefile" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}
	
	function getFileNameForTitle1(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile1", "");
			var titleObj = document.getElementById("titlefile1" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}

	function deleteRow(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload').deleteRow(i);
	}
	
	function deleteRow1(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload1').deleteRow(i);
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
	
	function fileUpload1() {
		var listNameRow = "";
		var valueNameFile ="";
		var tileFile ="";
		for(i = 0; i < incstt; i++) {
			if(document.getElementById('namefile1'+ i)) {			
				listNameRow += "namefile1" + i + "_";
				valueNameFile += document.getElementById('namefile1'+ i).value +"/";
			}

			if (document.getElementById('titlefile1'+ i)) {
				tileFile += document.getElementById('titlefile1'+ i).value + "#";	
			}
		}
		document.getElementById('nameFieldRow1').value = listNameRow;
		document.getElementById('nameFiles1').value = valueNameFile;
		document.getElementById('titleFiles1').value = tileFile;		
	}
	
	function checkFileUpload() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile'+ i).value;
				var fileTitle = document.getElementById('titlefile'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	function checkFileUpload1() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile1'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile1'+ i).value;
				var fileTitle = document.getElementById('titlefile1'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile1'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
</script>
