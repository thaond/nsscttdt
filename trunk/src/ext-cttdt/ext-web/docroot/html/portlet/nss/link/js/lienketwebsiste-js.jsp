<%@ include file="/html/portlet/nss/link/init.jsp" %>

<script type="text/javascript">
	function deleteLienKetWebsite(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function deleteLoaiWebsite(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromLoaiWebsite() {
		var tenLoaiWebsite =  document.getElementById("<portlet:namespace/>tenLoaiWebsite").value;
		if (tenLoaiWebsite.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenLoaiWebsite").focus();
			return false;
		}
		else {
			return true;
		}
				
	}

	function checkFromLienKetWebsite() {
		var valueName =  document.getElementById("<portlet:namespace/>tenwebsite").value;
		var urlWebsite =  document.getElementById("<portlet:namespace/>urlwebsite").value;
		var loaiwebsite =  document.getElementById("<portlet:namespace/>loaiwebsite").value;
		var thuTuWebsite =  document.getElementById("<portlet:namespace/>thutuwebsite").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenwebsite").focus();
			return false;
		} 
		if (urlWebsite.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-url-website"/>');
			document.getElementById("<portlet:namespace/>urlwebsite").focus();
			return false;
		} 
		if (thuTuWebsite.trim () == "") {
			alert('<liferay-ui:message key="vui-long-nhap-thu-tu-website"/>');
			document.getElementById("<portlet:namespace/>thutuwebsite").focus();
			return false;
		} 
		if (thuTuWebsite.trim () <= 0) {
			alert('<liferay-ui:message key="vui-long-nhap-so-lon-hon-0"/>');
			document.getElementById("<portlet:namespace/>thutuwebsite").focus();
			return false;
		}
		if (isNaN(thuTuWebsite) == true) {
			alert("<liferay-ui:message key='chi-nhap-con-so'/>");
			document.getElementById("<portlet:namespace/>thutuwebsite").focus();
			return false;
		}
		if (loaiwebsite.trim () == "0" ) {
			alert('<liferay-ui:message key="vui-long-chon-loai-website"/>');
			document.getElementById("<portlet:namespace/>loaiwebsite").focus();
			return false;
		}
		if (!checkImageUpload()) {
			return false;
		}
		else {
			return true;
		}
	}

	function checkImageUpload(){
		var file = document.getElementById("<portlet:namespace />file").value;
		var type = file.substring(file.lastIndexOf(".") + 1).toLowerCase();
		var typeStandard = "jpg,png,gif";	

		if(typeStandard.search(type.toLowerCase()) == -1) {
			alert("<liferay-ui:message key='sai-dinh-dang'/>");
			document.getElementById("<portlet:namespace />file").focus();
			return false;	
		}
		else {
			return true
		}
	}
	
</script>