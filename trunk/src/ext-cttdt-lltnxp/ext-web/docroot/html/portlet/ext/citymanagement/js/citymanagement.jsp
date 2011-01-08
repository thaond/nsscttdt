<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/cityManagement.js'></script>

<script type="text/javascript">

/*
 * city management
 */
 
function edit (id) {
	
	var code = document.getElementById("code" + id);
	var codehidden = document.getElementById("code" + id + "hidden");
	var districtCode = document.getElementById("districtCode" + id);
	var editCode = document.getElementById("editCode" + id);
		
	var name = document.getElementById("name" + id);
	var namehidden = document.getElementById("name" + id + "hidden");
	var districtName = document.getElementById("districtName" + id);
	var editName = document.getElementById("editName" + id);
	
	
	var description = document.getElementById("description" + id);
	var descriptionhidden = document.getElementById("description" + id + "hidden");
	var districtDescription = document.getElementById("districtDescription" + id );
	var editDescription = document.getElementById("editDescription" + id);
	
	
	var editField = document.getElementById("editField" + id);
	var updateField = document.getElementById("updateField" + id);

	code.style.display ="none";	
	editCode.style.display ="inline";
	//code.setAttribute("style", "display:none");	
	//editCode.setAttribute("style", "display:inline");	
	districtCode.value = codehidden.value;
	
		
	name.style.display ="none";	
	editName.style.display ="inline";
	districtName.value = namehidden.value;
	
	description.style.display ="none";	
	editDescription.style.display ="inline";
	districtDescription.value = descriptionhidden.value;
	 
	editField.style.display ="none";	
	updateField.style.display ="inline";
	
	
}

/*
 * yenlt
 */
 function deleteCity (id, url) {
	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-muon-xoa-thanh-pho-nay-khoi-he-thong'/>")) {
		form.action = url;
		form.submit();
	}
	
}


/*
function deleteCity (row, id) {
	if (confirm('</%= UnicodeLanguageUtil.get(pageContext, "ban-muon-xoa-thanh-pho-nay-khoi-he-thong") %>')) {
		cityManagement.deleteCity(id, function(data){
			if (data) {
				document.getElementById('citymanagement').deleteRow(row);
				//window.location.reload();
			}

			else {
				alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
			}
		});
		//document.getElementById('citymanagement').deleteRow(row);
	}
}
*/

function updateCity (id, url) {

	var form = document.<portlet:namespace />fm;
	
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	var codehidden = document.getElementById("code" + id + "hidden");
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var namehidden = document.getElementById("name" + id + "hidden");
	
	var description = document.getElementById("description" + id);
	var editDescription = document.getElementById("editDescription" + id);
	var descriptionhidden = document.getElementById("description" + id + "hidden");
	
	var editField = document.getElementById("editField" + id);
	var updateField = document.getElementById("updateField" + id);

	var cityCode = document.getElementById("districtCode" + id);
	var cityName = document.getElementById("districtName" + id);
	var cityDescription = document.getElementById("districtDescription" + id);

	if (cityCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-thanh-pho'/>");
		cityCode.focus();
	}

	else if (cityName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-thanh-pho'/>");
		cityName.focus();
	}
	
	else if (cityCode.value.trim() != "" && cityName.value.trim() != "") {
		//cityManagement.updateCity(id, cityCode.value, cityName.value, cityDescription.value, function(){});
		code.innerHTML = cityCode.value;
		name.innerHTML = cityName.value;
		description.innerHTML = cityDescription.value;

		code.style.display ="inline";
		editCode.style.display ="none";
		codehidden.value = cityCode.value;
			
		name.style.display ="inline";
		editName.style.display ="none";
		namehidden.value = cityName.value;
			
		description.style.display ="inline";
		editDescription.style.display ="none";
		descriptionhidden.value = cityDescription.value;
		
		editField.style.display ="inline";
		updateField.style.display ="none";

		form.action = url;
		form.submit();
	}
}

function cancel (id) {
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var description = document.getElementById("description" + id);
	var editDescription = document.getElementById("editDescription" + id);
	var editField = document.getElementById("editField" + id);
	var updateField = document.getElementById("updateField" + id);

	code.style.display ="inline";
	editCode.style.display ="none";
	name.style.display ="inline";
	editName.style.display ="none";
	description.style.display ="inline";
	editDescription.style.display ="none";
	editField.style.display ="inline";
	updateField.style.display ="none";
}

function addRow () {
	
	var cityTableLenght = document.getElementById('citymanagement').rows.length;
	
	var cityTable = document.getElementById('citymanagement').insertRow(cityTableLenght);
	
	
	cityTable.style.height = "25px";
	if (cityTableLenght % 2 == 0) {
		cityTable.style.backgroundColor = "#E4E4E4";
	}
	else {
		cityTable.style.backgroundColor = "#F2F2F2";
	}
	
	var stt = cityTable.insertCell(0);
	var code = cityTable.insertCell(1);
	var name = cityTable.insertCell(2);
	var description = cityTable.insertCell(3);
	var button = cityTable.insertCell(4);

	var addButton = document.getElementById("addButton");
	//alert(cityTable)
	addButton.disabled = true;
	
	stt.style.backgroundColor = "#DBEAFC";
	stt.innerHTML = "<div style='text-align: center;'>" + cityTableLenght + "</div>";
	code.innerHTML = "<div style='padding-left: 5px'><input style='width: 96%' type='text' name='code' id='codeAdd' /></div>";
	name.innerHTML = "<div style='padding-left: 5px'><input style='width: 96%' type='text' name='name' id='nameAdd' /></div>";
	description.innerHTML = "<div style='padding-left: 5px'><input style='width: 96%' type='text' name='description' id='descriptionAdd' /></div>";
	button.innerHTML = "<a onClick='return validate()'><div align='center'>" + "<img title='<liferay-ui:message key='citymanagement.button-save'/>' src='/html/images/edit.gif' /></a> <img title='<liferay-ui:message key='delete'/>' src='/html/images/xp_delete.gif' onclick='deleteRow(this);' />";
	
}

function deleteRow(cityTable) {
	var i = document.getElementById('citymanagement').rows.length - 1;
	document.getElementById('citymanagement').deleteRow(i);
	var addButton = document.getElementById("addButton"); 
	addButton.disabled = false;
}

function validate() {
	
	var code = document.getElementById("codeAdd");
	var name = document.getElementById("nameAdd");

	if (code.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma'/>");
		code.focus();
		return false;
	}

	if (name.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten'/>");
		name.focus();
		return false;
	}
	else {
		document.myform.submit()
	}
	
}

/*
 * district management
 */
 
 /* yenlt close
 function deleteDistrict (row, id) {
 	if (confirm('</%= UnicodeLanguageUtil.get(pageContext, "ban-muon-xoa-quan-nay-khoi-he-thong") %>')) {
 		cityManagement.deleteDistrict(id, function(data){
 			if (data) {
 				document.getElementById('citymanagement').deleteRow(row);
 				//window.location.reload();
 			}

 			else {
 				alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
 			}
 		});
 		//document.getElementById('citymanagement').deleteRow(row);
 	}
 }
 */

//yenlt 
 function deleteDistrict(id, url) {
 	var form = document.<portlet:namespace />fm;
 	if (confirm("<liferay-ui:message key='ban-muon-xoa-quan-nay-khoi-he-thong'/>")) {
 		form.action = url;
 		form.submit();
 	}
 	
 }

 function updateDistrict (id, url) {

	 var form = document.<portlet:namespace />fm;
	 
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	var codehidden = document.getElementById("code" + id + "hidden");
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var namehidden = document.getElementById("name" + id + "hidden");
	
	var description = document.getElementById("description" + id);
	var editDescription = document.getElementById("editDescription" + id);
	var descriptionhidden = document.getElementById("description" + id + "hidden");
	
	var editField = document.getElementById("editField" + id);
	var updateField = document.getElementById("updateField" + id);

	var districtCode = document.getElementById("districtCode" + id);
	var districtName = document.getElementById("districtName" + id);
	var districtDescription = document.getElementById("districtDescription" + id);

	if (districtCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-quan'/>");
		districtCode.focus();
	}

	else if (districtName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-quan'/>");
		districtName.focus();
	}
	
	else if (districtCode.value.trim() != "" && districtName.value.trim() != "") {
		//cityManagement.updateDistrict(id, districtCode.value, districtName.value, districtDescription.value, function(){});
		code.innerHTML = districtCode.value;
		name.innerHTML = districtName.value;
		description.innerHTML = districtDescription.value;

		code.style.display ="inline";
		editCode.style.display ="none";
		codehidden.value = districtCode.value;
		
		name.style.display ="inline";
		editName.style.display ="none";
		namehidden.value = districtName.value;
		
		description.style.display ="inline";
		editDescription.style.display ="none";
		descriptionhidden.value = districtDescription.value;
		
		editField.style.display ="inline";
		updateField.style.display ="none";

		//window.location.reload();

		form.action = url;
		form.submit();
	}
}

 /*
  * ward management
  */

 function deleteWard(id, url) {
	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-muon-xoa-phuong-xa-nay-khoi-he-thong'/>")) {
		form.action = url;
		form.submit();
	}
}
	
//function deleteWard (id,url) {

	
	//if (confirm('</%= UnicodeLanguageUtil.get(pageContext, "ban-muon-xoa-phuong-xa-nay-khoi-he-thong") %>')) {
	 //	alert("======  "+ id);
		//cityManagement.deleteWard(id, function(){});
		//document.getElementById('citymanagement').deleteRow(row);
	//}
	 
//}

function updateWard (id, url) {

	var form = document.<portlet:namespace />fm;
	 
	var code = document.getElementById("code" + id);
	var editCode = document.getElementById("editCode" + id);
	var codehidden = document.getElementById("code" + id + "hidden");
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var namehidden = document.getElementById("name" + id + "hidden");
	
	var description = document.getElementById("description" + id);
	var editDescription = document.getElementById("editDescription" + id);
	var descriptionhidden = document.getElementById("description" + id + "hidden");
	
	var editField = document.getElementById("editField" + id);
	var updateField = document.getElementById("updateField" + id);

	var wardCode = document.getElementById("districtCode" + id);
	var wardName = document.getElementById("districtName" + id);
 	var wardDescription = document.getElementById("districtDescription" + id);

	if (wardCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-phuong-xa'/>");
		wardCode.focus();
	}

	else if (wardName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-phuong-xa'/>");
		wardName.focus();
	}
 		
	else if (wardCode.value.trim() != "" && wardName.value.trim() != "") {
		//cityManagement.updateWard(id, wardCode.value, wardName.value, wardDescription.value, function(){});
		code.innerHTML = wardCode.value;
		name.innerHTML = wardName.value;
		description.innerHTML = wardDescription.value;

		code.style.display ="inline";
		editCode.style.display ="none";
		codehidden.value = wardCode.value;
		
		name.style.display ="inline";
		editName.style.display ="none";
		namehidden.value = wardName.value;
		
		description.style.display ="inline";
		editDescription.style.display ="none";
		descriptionhidden.value = wardDescription.value;
		
		editField.style.display ="inline";
		updateField.style.display ="none";

		form.action = url;
		form.submit();
	}
}

	
function checkSubmitForm(){
	alert('123');
	var cityCode = document.getElementById("districtCode");
	var cityName = document.getElementById("districtName");
	if (cityCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-thanh-pho'/>");
		cityCode.focus();
		return false;
	}

	else if (cityName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-thanh-pho'/>");
		cityName.focus();
		return false;
	}
	else{
		return true;
	}
}
</script>