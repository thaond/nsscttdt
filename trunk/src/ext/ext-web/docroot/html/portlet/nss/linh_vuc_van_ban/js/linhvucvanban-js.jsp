<%@ include file="/html/portlet/nss/linh_vuc_van_ban/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/LinhVucVanBanDWRClient.js'></script>

<script type="text/javascript">
	function deleteLinhVucVanBan(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	function checkFromLinhVucVanBan() {
		var tenLinhVucVanBan =  document.getElementById("<portlet:namespace/>tenLinhVucVanBan").value;
		var tabs =  document.getElementById("tabs").value;
		if (tenLinhVucVanBan.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>tenLinhVucVanBan").focus();
			return false;
		}
		if (tabs == "edit") {
			if (!checkExitParentId()) {
				return false;
			}
		}
		else {
			return true;
		}
	}

	function checkExitParentId() {
		var maLinhVucVanBan =  document.getElementById("<portlet:namespace />maLinhVucVanBan").value;
		var parentId =  document.getElementById("<portlet:namespace />parentId").value;
		LinhVucVanBanDWRClient.checkLinhVucVanBanParentId(maLinhVucVanBan, parentId, {callback:checkParentIdHelp, async:false});
		var result = document.getElementById('checkParentId').value;
		  if ("false" == result ) {
			  return false;
		  }
	
		  else {
			  return true;
		  }	
	}
	
	var checkParentIdHelp = function (data){
		if(data == true){			 
			 alert('<liferay-ui:message key="khong-the-chon-linh-vuc-van-ban"/>');
			 document.getElementById('checkParentId').value = "false";
		}
		else {
			document.getElementById('checkParentId').value = "true";
		}
	};
</script>