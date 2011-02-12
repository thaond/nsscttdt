<%@ include file="/html/portlet/ext/generatetemplateid/init.jsp" %>

<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript"
	src="/dwr/interface/pmlTemplateIdDwrClient.js"></script>
	
<script type="text/javascript">

function validateFormIdtemplate(){	
	var format = document.getElementById("format");
	var valueTextTemplate = document.getElementById("textTemplate").value;
	
	var startnumber = document.getElementById("startNumber");
	var valueStartNumber =document.getElementById("startNumber").value;
	
	var des = document.getElementById("des");
	var valueDescription =document.getElementById("description").value;
	var message = "";
	
	if(null == valueTextTemplate || "" == valueTextTemplate ){
		message = "template";
		alert("<liferay-ui:message key='vui-long-nhap-dinh-dang'/>");
		format.style.display = "inline";
	}
	else{
		format.style.display = "none";
	}
	
	if (!checkOnlyContainText(valueTextTemplate)){
		if(null == valueStartNumber || "" == valueStartNumber ){
			message = "startnumber";
			alert("<liferay-ui:message key='vui-long-nhap-so-bat-dau'/>");
			startnumber.style.display = "inline";
		}
		else{
			startnumber.style.display = "none";
		}
	}
	
	if(null == valueDescription || "" == valueDescription ){
		message = "description";
		alert("<liferay-ui:message key='vui-long-nhap-mo-ta'/>");
		des.style.display = "inline";
	}
	else{
		des.style.display = "none";
	}
	
	if("" != message ){
		return false;
	}
	else{
		return true;
	}
	

}

/**
 * Yenlt 11/03/2010
 */
function checkOnlyContainText(str){

	pmlTemplateIdDwrClient.checkOnlyContainText(str,{callback:checkContainText, async:false});

	var result = document.getElementById('checkContainText').value;
	if ( "false" == result) {
		
		return false;
	} else {
		return true;
	}
	
}

var checkContainText = function (data){
	if(data == true){			 
		 document.getElementById('checkContainText').value = "true";
	}
	else {
		document.getElementById('checkContainText').value = "false";
	}
};
 //end

function focusColor(tr){
	defaultColor = tr.getAttribute('class');
	tr.setAttribute("class", "focusRow") ;
}

function nofocusColor(tr){
	tr.setAttribute("class", defaultColor) ;
}

//hungDv
function changeValue(option)
{
	if (option.value == "[Text]")
	{
		document.getElementById('textValue').style.display = "inline";
	}else{
		document.getElementById('textValue').value = '';
		document.getElementById('textValue').style.display = "none";
	}
}
function butAdd()
{
	if(document.getElementById('optTemplate').value == '[Text]')
	{
		document.getElementById('textTemplate').value += document.getElementById('textValue').value;
		document.getElementById('textValue').value = '';
	}else{
		document.getElementById('textTemplate').value += document.getElementById('optTemplate').value;
	}
}
function butClear()
{
	document.getElementById('textTemplate').value = '';
}

function isValid(parm,val) {
  if (parm == "") return true;
  for (i=0; i<parm.length; i++) {
    if (val.indexOf(parm.charAt(i),0) == -1) return false;
  }
  return true;
}
/////
function checkChar(e)
{
var keynum;
var keychar;

if(window.event) // IE
  {
  keynum = e.keyCode;
  }
else if(e.which) // Netscape/Firefox/Opera
  {
  keynum = e.which;
  }
keychar = String.fromCharCode(keynum);
return !isValid(keychar,notOk);
}

</script>
