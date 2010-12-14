<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<script type="text/javascript">
	function deleteCauHoi(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function checkFormAddCauTraLoi(){
		var noiDung = document.getElementById('noiDungTraLoi');
		if (noiDung.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-noi-dung"/>');
			document.getElementById("noiDungTraLoi").focus();
			return false;
		}
		else {
			return true;
		}
	}
	
	function checkFormAddCauHoi(){
		var tieuDeCauHoi = document.getElementById('tieuDeCauHoi');
		var noiDung = document.getElementById('noiDungHoi');
		if (tieuDeCauHoi.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-tieu-de-cau-hoi"/>');
			document.getElementById("tieuDeCauHoi").focus();
			return false;
		}
		if (noiDung.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-noi-dung"/>');
			document.getElementById("noiDungHoi").focus();
			return false;
		}
		else {
			return true;
		}
	}

	function getFileName(fileName){
		var name = document.getElementById('fileName');
		var fullName = fileName;
		var shortName = fullName.match(/[^\/\\]+$/);
		name.value = shortName;
	}

</script>