<%@ include file="/html/portlet/nss/loai_thu_tuc/init.jsp" %>

<script type="text/javascript">
	function deleteLoaiThuTucHanhChinh(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromLoaiThuTucHanhChinh() {
		var valueName =  document.getElementById("<portlet:namespace/>tenLoaiThuTucHanhChinh").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenLoaiThuTucHanhChinh").focus();
			return false;
		} else {
			return true;
		}
	}
	
</script>