
function validateForm(){	
	var format = document.getElementById("format");
	var valueTextTemplate = document.getElementById("textTemplate").value;
	
	var startnumber = document.getElementById("startnumber");
	var valueStartNumber =document.getElementById("startNumber").value;
	
	var des = document.getElementById("des");
	var valueDescription =document.getElementById("description").value;
	var message = "";
	
	if(null == valueTextTemplate || "" == valueTextTemplate ){
		message = "template";
		format.style.display = "inline";
	}
	else{
		format.style.display = "none";
	}
	
	if(null == valueStartNumber || "" == valueStartNumber ){
		message = "startnumber";
		startnumber.style.display = "inline";
	}
	else{
		startnumber.style.display = "none";
	}
	
	if(null == valueDescription || "" == valueDescription ){
		message = "description";
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
//Check Text
var numb = '0123456789';
var lwr = 'abcdefghijklmnopqrstuvwxyzâ';
var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZÂ';
var special = '_+-';
var notOk = ' ,(){}[]*@#$^&';

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
