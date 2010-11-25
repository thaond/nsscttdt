<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

<script type="text/javascript">
	function deleteCauHoi(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	function checkFormAddCauHoi(){
		var tieuDeCauHoi = document.getElementById('tieuDeCauHoi');
		var tenNguoiHoi = document.getElementById('tenNguoiHoi');
		var email = document.getElementById('email');
		var maChuDeCauHoi = document.getElementById('maChuDeCauHoi');
		var noiDung = document.getElementById('noiDung');

		if (tieuDeCauHoi.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-tieu-de-cau-hoi"/>');
			document.getElementById("tieuDeCauHoi").focus();
			return false;
		}
		if (tenNguoiHoi.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-ten-nguoi-hoi"/>');
			document.getElementById("tenNguoiHoi").focus();
			return false;
		}
		if (email.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-email"/>');
			document.getElementById("email").focus();
			return false;
		}
		if (maChuDeCauHoi.selectedIndex == 0) {
			alert('<liferay-ui:message key="vui-long-chon-chu-de-cau-hoi"/>');
			document.getElementById("maChuDeCauHoi").focus();
			return false;
		}
		if (noiDung.value.trim() == "") {
			alert('<liferay-ui:message key="vui-long-nhap-noi-dung"/>');
			document.getElementById("noiDung").focus();
			return false;
		}
		else {
			return true;
		}
	}
	
	function echeck(str) {
	
		var at="@"
		var dot="."
		var lat=str.indexOf(at)
		var lstr=str.length
		var ldot=str.indexOf(dot)
		if (str.indexOf(at)==-1){
		   alert('<liferay-ui:message key="email-khong-hop-le" />');
		   return false;
		}
	
		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		   alert('<liferay-ui:message key="email-khong-hop-le" />');
		   return false;
		}
	
		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
			alert('<liferay-ui:message key="email-khong-hop-le" />');
			return false;
		}
	
		 if (str.indexOf(at,(lat+1))!=-1){
			 alert('<liferay-ui:message key="email-khong-hop-le" />');
			 return false;
		 }
	
		 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
			 alert('<liferay-ui:message key="email-khong-hop-le" />');
			 return false;
		 }
	
		 if (str.indexOf(dot,(lat+2))==-1){
			 alert('<liferay-ui:message key="email-khong-hop-le" />');
			 return false;
		 }
		
		 if (str.indexOf(" ")!=-1){
			 alert('<liferay-ui:message key="email-khong-hop-le" />');
			 return false;
		 }
	
			 return true					
	}

	function validateEmail(){
		var emailID = document.getElementById('email');
		
		if ((emailID.value==null)||(emailID.value=="")){
			alert('<liferay-ui:message key="vui-long-nhap-email" />');
			emailID.focus();
			return false;
		}
		if (echeck(emailID.value)==false){
			emailID.focus();
			return false;
		}
		return true;
	}

	function getFileName(fileName){
		var name = document.getElementById('fileName');
		var fullName = fileName;
		var shortName = fullName.match(/[^\/\\]+$/);
		name.value = shortName;
	}
</script>