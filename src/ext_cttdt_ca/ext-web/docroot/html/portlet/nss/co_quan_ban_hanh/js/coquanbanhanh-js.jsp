<%@ include file="/html/portlet/nss/co_quan_ban_hanh/init.jsp" %>

<script type="text/javascript">
	function deleteCoQuanBanHanh(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromCoQuanBanHanh() {
		var valueName =  document.getElementById("<portlet:namespace/>tenCoQuanBanHanh").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenCoQuanBanHanh").focus();
			return false;
		} else {
			return true;
		}
	}
	
</script>