<%@ include file="/html/portlet/nss/media_library/init.jsp" %>

<script type="text/javascript">

	function deleteMediaLibrary(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function checkFormAddMediaLibrary(){
		var maMediaChuDe = document.getElementById('maMediaChuDe');
		//var file = document.getElementById('file');

		if (maMediaChuDe.selectedIndex == 0) {
			alert('<liferay-ui:message key="vui-long-chon-media-chu-de"/>');
			document.getElementById("maMediaChuDe").focus();
			return false;
		}
		/*
		if (file.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-tieu-de-cau-hoi"/>');
			document.getElementById("file").focus();
			return false;
		}
		*/
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