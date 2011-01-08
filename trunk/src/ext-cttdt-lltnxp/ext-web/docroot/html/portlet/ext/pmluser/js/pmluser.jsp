<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>

<script type="text/javascript">

function getSelectRadio(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('pmlUserId'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

function clickRadio(event)
{
	
	if (event) // firefox
	{
		event.stopPropagation();	
	}
	else // windows
		window.event.cancelBubble = true;
	return true; // co the false, bo
}

function submitFormBack(form, url)
{
	
		form.action = url;
		form.submit();
}

function submitForm(form, url)
{
	if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-nguoi-dung' />");
	} 
	else {
		form.action = url;
		form.submit();
	}
}

function submitFormDeleteUser(form, url){
	if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-nguoi-dung' />");
	} 
	else {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-user") %>')) {
			form.action = url;
			form.submit();
		}
	}
}

function validateDisplay() {
	
	var arrRadioElements = document.getElementsByName("pmlUserId");
	
	var res = false;
	for ( var i = 0; i < arrRadioElements.length; i++) {
		if (arrRadioElements[i].checked) {
			res = true;
			break;
		}		
	}

	if(!res) {
		return false;
	}

	else {
		return true;
	}
		
}

function validatePmlUser() 
{
	var screenName = document.getElementById("screenName");
	var email = document.getElementById("email");
	var password = document.getElementById("password");
	var retypePassword = document.getElementById("retypePassword");
	var lastName = document.getElementById("lastName");
	var firstName = document.getElementById("firstName");
	var gender = document.getElementById("gender");
	var positionId = document.getElementById("positionId");
	var departmentId = document.getElementById("departmentId");
	//var teamId = document.getElementById("teamId");

	if (screenName.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-ten-goi'/>");
		screenName.focus();
		return false;
	}

	if (email.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-email'/>");
		email.focus();
		return false;
	}

	if (password.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-mat-khau'/>");
		password.focus();
		return false;
	}

	if (retypePassword.value.trim() != password.value.trim()) {
		alert("<liferay-ui:message key='pmluser-nhap-lai-mat-khau'/>");
		retypePassword.focus();
		return false;
	}

	if (lastName.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-ho-nguoi-dung'/>");
		lastName.focus();
		return false;
	}

	if (firstName.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-ten-nguoi-dung'/>");
		firstName.focus();
		return false;
	}

	if (gender.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-gioi-tinh'/>");
		gender.focus();
		return false;
	}

	if (positionId.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-chuc-vu'/>");
		positionId.focus();
		return false;
	}

	if (departmentId.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-phong-ban'/>");
		departmentId.focus();
		return false;
	}

//	if (teamId.selectedIndex == 0) {
//		alert("<liferay-ui:message key='pmluser-chon-doi'/>");
//		teamId.focus();
//		return false;
//	}

	else {
		return true;
	}
	
}

function validateEditPmlUser() 
{
	var lastName = document.getElementById("lastName");
	var firstName = document.getElementById("firstName");
	var gender = document.getElementById("gender");
	var positionId = document.getElementById("positionId");
	var departmentId = document.getElementById("departmentId");
	var teamId = document.getElementById("teamId");

	if (lastName.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-ho-nguoi-dung'/>");
		lastName.focus();
		return false;
	}

	if (firstName.value.trim() == "") {
		alert("<liferay-ui:message key='pmluser-nhap-ten-nguoi-dung'/>");
		firstName.focus();
		return false;
	}

	if (gender.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-gioi-tinh'/>");
		gender.focus();
		return false;
	}

	if (positionId.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-chuc-vu'/>");
		positionId.focus();
		return false;
	}

	if (departmentId.selectedIndex == 0) {
		alert("<liferay-ui:message key='pmluser-chon-phong-ban'/>");
		departmentId.focus();
		return false;
	}
	
	//if (teamId.selectedIndex == 0) {
	//	alert("<liferay-ui:message key='pmluser-chon-doi'/>");
	//	teamId.focus();
	//	return false;
	//}

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
	   alert("Invalid E-mail ID")
	   return false
	}

	if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
	   alert("Invalid E-mail ID")
	   return false
	}

	if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
	    alert("Invalid E-mail ID")
	    return false
	}

	 if (str.indexOf(at,(lat+1))!=-1){
	    alert("Invalid E-mail ID")
	    return false
	 }

	 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
	    alert("Invalid E-mail ID")
	    return false
	 }

	 if (str.indexOf(dot,(lat+2))==-1){
	    alert("Invalid E-mail ID")
	    return false
	 }
	
	 if (str.indexOf(" ")!=-1){
	    alert("Invalid E-mail ID")
	    return false
	 }

		 return true					
}

function validateEmail(){
	var emailID=document.getElementById('email');
	
	if ((emailID.value==null)||(emailID.value=="")){
		alert("Please Enter your Email ID")
		emailID.focus()
		return false
	}
	if (echeck(emailID.value)==false){
		emailID.value=""
		emailID.focus()
		return false
	}
	return true
	}
</script>
