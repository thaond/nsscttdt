<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<script type="text/javascript">
	
	function <portlet:namespace />checkForm(form){
		var result = true;
		var original = form.original.value;
		var copy = form.copy.value;
		
		if (original == '') {
			alert("<liferay-ui:message key='vui-long-nhap-so-luong-ban-chinh' />");
			result = false;
		} 
		
		if (copy == '') {
			alert("<liferay-ui:message key='vui-long-nhap-so-luong-ban-sao' />");
			result = false;
		}
		
		if (isNaN(original) == true || isNaN(copy) == true) {
				alert("<liferay-ui:message key='chi-nhap-con-so' />");
				result = false;
		}

		if (parseInt(original) < 0 || parseInt(copy) < 0) {
			alert("<liferay-ui:message key='nhap-so-nho-hon-hoac-bang-0' />");
			result = false;
		}
		
		return result;

	}
</script>