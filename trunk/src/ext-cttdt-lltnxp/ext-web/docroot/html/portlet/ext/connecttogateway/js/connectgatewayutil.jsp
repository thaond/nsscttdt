<%@ include file="/html/portlet/ext/indexdatabase/init.jsp" %>

<script type="text/javascript">

window.onload = function() {
	document.getElementById('stop_thread').disabled = true;
	document.getElementById('stop_timer').disabled = true;
}

function <portlet:namespace/>createConnectionByThread(url) {
	document.getElementById('create_thread').disabled = true;
	document.getElementById('stop_thread').disabled = false;
	
	document.getElementById('create_timer').disabled = true;
	document.getElementById('stop_timer').disabled = true;

	if (document.getElementById('stop_thread').disabled == false) {
		submitForm(document.<portlet:namespace />form, url);
	}
}
/*
function <portlet:namespace/>createConnectionByTimer() {
	document.getElementById('create_thread').disabled = true;
	document.getElementById('stop_thread').disabled = true;

	document.getElementById('create_timer').disabled = true;
	document.getElementById('stop_timer').disabled = false;
}

function <portlet:namespace/>stopConnect() {
	document.getElementById('create_thread').disabled = false;
	document.getElementById('stop_thread').disabled = true;

	document.getElementById('create_timer').disabled = false;
	document.getElementById('stop_timer').disabled = true;
}

function validateForm() {
	var careerCode = document.getElementById("careerCode");
	var careerName = document.getElementById("careerName");
	if (careerCode.value.trim() == ""){
		alert("<liferay-ui:message key='vui-long-nhap-ma'/>")
		careerCode.focus();
		return false;		
	}
	if (careerName.value.trim() == ""){
		alert("<liferay-ui:message key='vui-long-nhap-ten'/>")
		careerName.focus();
		return false;		
	} else {
		return true;
	}
}
*/
</script>
