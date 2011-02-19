<script type="text/javascript">
	function checkInput(){
		if(document.<portlet:namespace/>fm.<portlet:namespace/>maSoVanBanNoiBo.value == ""){
			alert("<liferay-ui:message key='input-ma-so-van-ban-noi-bo'/>");
			return false;
		}
		if(document.<portlet:namespace/>fm.<portlet:namespace/>tenSoVanBanNoiBo.value == ""){
			alert("<liferay-ui:message key='input-ten-so-van-ban-noi-bo'/>");
			return false;
		}
	}
</script>