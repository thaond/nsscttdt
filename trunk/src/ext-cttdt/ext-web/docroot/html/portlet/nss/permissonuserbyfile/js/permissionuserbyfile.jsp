<%@ include file="/html/portlet/nss/permissonuserbyfile/init.jsp" %>

<script type="text/javascript">
function getSelectRadio(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('radio'+idElementTd)
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

function validateDisplay() {
	
	var arrRadioElements = document.getElementsByName("userId");
	
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
</script>
