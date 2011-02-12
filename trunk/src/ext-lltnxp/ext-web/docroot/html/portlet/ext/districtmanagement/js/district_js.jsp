<%@ include file="/html/portlet/ext/districtmanagement/init.jsp" %>


<script type="text/javascript">
function <portlet:namespace />checkForm(form) {
	if(form.districtCode.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ma"/>');
		form.districtCode.focus();
		return false;
	}
	if(form.districtName.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
		form.districtName.focus();
		return false;
	}
	if(form.cityID.value == 0) {
		alert('<liferay-ui:message key="vui-long-chon-tinh-thanh-pho"/>');
		form.cityID.focus();
		return false;
	}
	return true;
}
/*
function checkData() {
	var districtCode = document.getElementById('districtCode').value;
	var districtCodeHidden = document.getElementById('districtCodeHidden').value;

	if (districtCode.trim() == "") {
		return true;
	}
	
	districtDWRClient.countDistrictByCode(districtCode, function (data) {
		if ((districtCodeHidden != districtCode && data > 0) || (districtCodeHidden == districtCode && data != 1)) { // neu ton tai ma loai ho so
			alert("<liferay-ui:message key='ma-quan-huyen-khong-duoc-trung'/>");
			document.getElementById('districtCode').value = districtCodeHidden;
			document.getElementById('districtCode').focus();
		}
	});
}

function checkFocusDistrictCode() {
	checkData();
	return;
}*/

</script>