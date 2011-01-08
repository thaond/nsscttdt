<%@ include file="/html/portlet/ext/pml_template/init.jsp" %>

<script type="text/javascript">
function deleteTemplate(url) {		
	if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}

function validateForm() {
	var code = document.getElementById('code');
	var name = document.getElementById('name');
	var number = document.getElementById('number');
	var ngayBanHanh = document.getElementById('<portlet:namespace/>ngayBanHanh');
	var department = document.getElementById('department');
	if (code.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ma'/>");
		code.focus();
		return false;
	}
	if (name.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ten'/>");
		name.focus();
		return false;
	}
	if (number.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-so-van-ban'/>");
		number.focus();
		return false;
	}
	if (isNaN(number.value.trim()) == true) {
		alert("<liferay-ui:message key='chi-nhap-con-so'/>");
		number.focus();
		return false;
	}
	if (ngayBanHanh.value.trim() == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ngay-ban-hanh'/>");
		ngayBanHanh.focus();
		return false;
	}
	if (department.selectedIndex == 0) {
		alert("<liferay-ui:message key='vui-long-chon-phong-ban-hanh'/>");
		department.focus();
		return false;
	}

	else {
		return true;
	}
}

function getFileName(fileName){
	var name = document.getElementById('fileName');
	var fullName = fileName;
	var shortName = fullName.match(/[^\/\\]+$/);
	name.value = shortName;
}

function checkNgayBanHanh(){
	var ngayBanHanh = document.getElementById('<portlet:namespace/>ngayBanHanh');
	var selectinput = document.getElementById('select');	
	
	if (selectinput.selectedIndex == 3) {
		if ("" == ngayBanHanh.value.trim()) {
			alert('<liferay-ui:message key="vui-long-chon-ngay-ban-hanh" />');
			return false;
		}
		if(isDate(ngayBanHanh.value) == false) {
			alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
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
	var ngayBanHanh = document.getElementById('<portlet:namespace/>ngayBanHanh');
	var comman = document.getElementById('<portlet:namespace/>comman');	
	var day = document.getElementById('<portlet:namespace/>day');
	var loctheophongban = document.getElementById('<portlet:namespace/>loctheophongban');
	//var departmentIdFilter = document.getElementById('<portlet:namespace/>departmentIdFilter');
	
	if (selectinput.selectedIndex == 0 ){
		keyword.disabled = true;
		keyword.value = "";
		loc.disabled = true;
	  }

	else if (selectinput.selectedIndex > 0 && keyword.value == "") {
		keyword.disabled = false;
		loc.disabled = true;
	}

	if (selectinput.selectedIndex < 3) {
		comman.style.display = "inline";
		
		if (day != null){
			day.style.display = "none";
		}
		loctheophongban.style.display = "none";
		
		ngayBanHanh.value = "";
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	} else if (selectinput.selectedIndex == 3){ // loc theo ngay ban hanh
		comman.style.display = "none";
		loctheophongban.style.display = "none";
		day.style.display = "inline";
		keyword.value = "";		
		document.getElementById('<portlet:namespace/>loc').disabled = false;
	} else { // loc theo phong ban
		comman.style.display = "none";
		day.style.display = "none";
		loctheophongban.style.display = "inline";
		ngayBanHanh.value = "";
		keyword.value = "";
		
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	}

}

function enableButton () {
	document.getElementById('<portlet:namespace/>loc').disabled = false;
}
</script>