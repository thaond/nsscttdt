<%@ include file="/html/portlet/nss/agency/init.jsp" %>

<script type="text/javascript">

function checkformAgency(form)
{
  if (form.agencyCode.value.trim() == "" || null == form.agencyCode.value.trim()) {
	   	alert("<liferay-ui:message key='nhap-ma-co-quan' />");
   		form.agencyCode.focus();
    return false ;
  }
  else if (form.agencyName.value.trim() == "" || null == form.agencyName.value.trim()) {
	 alert("<liferay-ui:message key='nhap-ten-co-quan' />");
	 form.agencyName.focus();
    return false ;
  }
  else if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-nguoi-dung' />!");
		return false ;
	} 
   return true ;
}
function validateDisplay() {
	
	var arrRadioValues = document.getElementsByName("userID");
	
	var res = false;
	for ( var i = 0; i < arrRadioValues.length; i++) {
		if (arrRadioValues[i].checked) {
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
function getSelectRadio(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('userID'+idElementTd)
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
</script>