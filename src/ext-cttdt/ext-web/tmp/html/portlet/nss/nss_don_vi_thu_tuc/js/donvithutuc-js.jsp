<%@ include file="/html/portlet/nss/loai_van_ban/init.jsp" %>

<script type="text/javascript">
	function deleteDonViThuTuc(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromDonViThuTuc() {
		var valueName =  document.getElementById("<portlet:namespace/>tenDonViThuTuc").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenDonViThuTuc").focus();
			return false;
		} else {
			return true;
		}
	}
	
</script>