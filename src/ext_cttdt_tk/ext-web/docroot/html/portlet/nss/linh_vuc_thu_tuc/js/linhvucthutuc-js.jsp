<%@ include file="/html/portlet/nss/linh_vuc_thu_tuc/init.jsp" %>

<script type="text/javascript">
	function deleteLinhVucThuTucHanhChinh(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromLinhVucThuTucHanhChinh() {
		var valueName =  document.getElementById("<portlet:namespace/>tenLinhVucThuTucHanhChinh").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenLinhVucThuTucHanhChinh").focus();
			return false;
		} else {
			return true;
		}
	}
	
</script>