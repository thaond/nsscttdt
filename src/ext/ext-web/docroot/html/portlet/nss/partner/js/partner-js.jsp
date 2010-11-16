<%@ include file="/html/portlet/nss/partner/init.jsp" %>

<script type="text/javascript">
	function deletePartner(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function checkFromPartner() {
		var valueName =  document.getElementById("<portlet:namespace/>tenpartner").value;
		var urlWebsite =  document.getElementById("<portlet:namespace/>urlpartner").value;
		var thuTuWebsite =  document.getElementById("<portlet:namespace/>thutupartner").value;
		var target =  document.getElementById("<portlet:namespace/>target").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenpartner").focus();
			return false;
		} 
		if (urlWebsite.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-url-partner"/>');
			document.getElementById("<portlet:namespace/>urlpartner").focus();
			return false;
		} 
		if (thuTuWebsite.trim () == "") {
			alert('<liferay-ui:message key="vui-long-nhap-thu-tu-partner"/>');
			document.getElementById("<portlet:namespace/>thutupartner").focus();
			return false;
		} 
		if (thuTuWebsite.trim () == "0") {
			alert('<liferay-ui:message key="vui-long-nhap-so-khac-0"/>');
			document.getElementById("<portlet:namespace/>thutupartner").focus();
			return false;
		} 
		if (isNaN(thuTuWebsite) == true) {
			alert("<liferay-ui:message key='chi-nhap-con-so'/>");
			document.getElementById("<portlet:namespace/>thutupartner").focus();
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
		var typeStandard = "jpg, png, gif";	

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