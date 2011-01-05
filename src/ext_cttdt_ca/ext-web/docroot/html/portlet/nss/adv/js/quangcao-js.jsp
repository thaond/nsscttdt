<%@ include file="/html/portlet/nss/adv/init.jsp" %>

<script type="text/javascript">
	function deleteQuangCao(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromQuangCao() {
		var valueName =  document.getElementById("<portlet:namespace/>tenQuangCao").value;
		var urlWebsite =  document.getElementById("<portlet:namespace/>urlQuangCao").value;
		var thuTuWebsite =  document.getElementById("<portlet:namespace/>thutuQuangCao").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenQuangCao").focus();
			return false;
		} 
		if (urlWebsite.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-url-website"/>');
			document.getElementById("<portlet:namespace/>urlQuangCao").focus();
			return false;
		} 
		if (thuTuWebsite.trim () == "") {
			alert('<liferay-ui:message key="vui-long-nhap-thu-tu-website"/>');
			document.getElementById("<portlet:namespace/>thutuQuangCao").focus();
			return false;
		} 
		if (isNaN(thuTuWebsite) == true) {
			alert("<liferay-ui:message key='chi-nhap-con-so'/>");
			document.getElementById("<portlet:namespace/>thutuQuangCao").focus();
			return false;
		}
		if(thuTuWebsite <=0 ){
			alert("<liferay-ui:message key='vui-long-nhap-so-lon-hon-0'/>");
			document.getElementById("<portlet:namespace/>thutuQuangCao").focus();
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