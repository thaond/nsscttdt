<script type="text/javascript">
	function checkInput(){
		if(document.<portlet:namespace/>fm.<portlet:namespace/>kyHieuLoaiVanBanNoiBo.value == ""){
			alert("<liferay-ui:message key='input-ky-hieu-loai-van-ban-noi-bo'/>");
			return false;
		}
		if(document.<portlet:namespace/>fm.<portlet:namespace/>tenLoaiVanBanNoiBo.value == ""){
			alert("<liferay-ui:message key='input-ten-loai-van-ban-noi-bo'/>");
			return false;
		}
	}
</script>