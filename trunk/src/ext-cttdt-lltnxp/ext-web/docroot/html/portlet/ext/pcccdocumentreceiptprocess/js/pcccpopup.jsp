<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/documentSendUtilClient.js'></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<script type="text/javascript" >
/* function add row*/
var incstt = 0;
var stringDocumentAttach ="";//contain string ten of element upload file


function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function getDataHelp(trTable){	

	var elementRadioChecked = trTable.cells[1].firstChild;
	elementRadioChecked.checked = true;
	var arr = elementRadioChecked.value.split("#");
	document.getElementById('hidden').value = arr[0];
	document.getElementById('fileTypeId').value = arr[1];
}

function getData(){	

	if (document.getElementById('hidden').value == "") {
		alert ("<liferay-ui:message key='pccc-TN-vuilongchonloaihoso'/>");
	}
	else {
		window.opener.document.getElementById('receiveplace').value = document.getElementById('hidden').value;
		var idIssuingPlace = document.getElementById('issuingPlaceId').value;
		window.opener.document.getElementById('issuingPlaceId').value=idIssuingPlace;
		window.close();
		
	}
}

/*
 * open popup receivingplace
 */
function openReceivingPlacePopup() {
	var host = location.host;
	var path = "http://" + host + "/html/portlet/ext/pcccdocumentreceiptprocess/receivingplacepopup.jsp"; 
	var openWindow = window.open(path, "openWindow", "model = true, location = 1, status = 1, scrollbars = 1, width = 800px, height = 400px");
	var posX = screen.width / 4;
	var posY = screen.width / 4;
	openWindow.moveTo(posX, posY);
} 

function openSignerPopup()
{   
  var host = location.host;
  var path = "http://" + host + "/html/portlet/ext/pcccdocumentreceiptprocess/signerpopup.jsp";
  var mywindow = window.open ( path ,"mywindow","modal=true,location=1,status=1,scrollbars=1,width=800px,height=400px");
  var posX = screen.width / 4;
  var posY = screen.height / 4;
  mywindow.moveTo(posX , posY);
}
</script>
	
	
	