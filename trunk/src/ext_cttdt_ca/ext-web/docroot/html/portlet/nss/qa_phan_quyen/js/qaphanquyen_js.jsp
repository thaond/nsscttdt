<%@ include file="/html/portlet/nss/qa_phan_quyen/init.jsp" %>


<script type="text/javascript">

	function reloadPhanQuyen(url) {
		submitForm(document.<portlet:namespace />fm, url);
	}
	
	function checkMaChuDeCauHoiSelected() {
		var maChuDeCauHoi = document.getElementById('maChuDeCauHoi');
		if (maChuDeCauHoi.selectedIndex == 0) {
			alert('<liferay-ui:message key="vui-long-chon-chu-de-cau-hoi"/>');
			document.getElementById("maChuDeCauHoi").focus();
			return false;
		}
		else {
			return true;
		}
	}
	 
</script>