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

function check( form ){
	
   if (form.receiver.selectedIndex == 0 ) {
   form.receiver.focus();
    return false ;
  }
   else{
 
	   return true ;
}
}

/*------------------------------------------ check attachedFile form input----------------------
 * 
 */
function checkformAttachedfile( form )
{
   if (form.attachedFileCode.value == "" || null == form.attachedFileCode.value) {
   form.attachedFileCode.focus();
    return false ;
  }
 else if (form.attachedFileName.value == "" || null == form.attachedFileName.value) {
     form.attachedFileName.focus();
    return false ;
  }
   return true ;
}
/*------------------------------------------ check country form input----------------------
 * 
 */
function checkformCountry( form )
{
   if (form.countryCode.value == "" || null == form.countryCode.value) {
   form.countryCode.focus();
    return false ;
  }
 else if (form.countryName.value == "" || null == form.countryName.value) {
     form.countryName.focus();
    return false ;
  }
   return true ;
}
/*------------------------------------------ check nation form input----------------------
 * 
 */
function checkformNation( form )
{
   if (form.nationCode.value == "" || null == form.nationCode.value) {
   form.nationCode.focus();
    return false ;
  }
 else if (form.nationName.value == "" || null == form.nationName.value) {
     form.nationName.focus();
    return false ;
  }
   return true ;
}

/*------------------------------------------ check Role form input----------------------
 * 
 */
function checkformRole( form )
{
   if (form.roleCode.value == "" || null == form.roleCode.value) {
   form.roleCode.focus();
    return false ;
  }
 else if (form.roleName.value == "" || null == form.roleName.value) {
     form.roleName.focus();
    return false ;
  }
   return true ;
}
/*------------------------------------------ check department form input----------------------
 * 
 */
function checkformDep( form )
{
   if (form.departmentsCode.value == "" || null == form.departmentsCode.value) {
   form.departmentsCode.focus();
    return false ;
  }
 else if (form.departmentsName.value == "" || null == form.departmentsName.value) {
     form.departmentsName.focus();
    return false ;
  }
   return true ;
}
/*------------------------------------------ check position form input----------------------
 * 
 */
function checkformPosition( form )
{
   if (form.positionCode.value == "" || null == form.positionCode.value) {
   form.positionCode.focus();
    return false ;
  }
 else if (form.positionName.value == "" || null == form.positionName.value) {
     form.positionName.focus();
    return false ;
  }
   return true ;
}

/*
*
*function change color for tr and mouseover color
*/
function focusColorWhite(tr){

	defaultColor = tr.style.backgroundColor;

	tr.style.backgroundColor = "#FFFAFA" ;
	tr.style.color = "#000099" ;
	
}
function focusColor2(tr){

	defaultColor = tr.style.backgroundColor;

	tr.style.backgroundColor = "#c5e4f6" ;
	tr.style.color = "#000099" ;
	
}
function focusColor1(tr){

	defaultColor = tr.style.backgroundColor;

	tr.style.backgroundColor = "#A8D6ED" ;
}


function nofocusColor1(tr){


	tr.style.backgroundColor = defaultColor;
	
}

function focusColor(tr){
	
	defaultColor = tr.getAttribute('class');
	tr.style.backgroundColor = "#6CA1B4";
	
}

function nofocusColor(tr){


	tr.style.backgroundColor = "";
	tr.style.color = "" ;
	
}


/*/hungDv
 * 
 */
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
/*/Check Text
 * 
 */
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

function checkChar(e)
{
var keynum;
var keychar;

if(window.event) /* IE*/
  {
  keynum = e.keyCode;
  }
else if(e.which) /*/ Netscape/Firefox/Opera*/
  {
  keynum = e.which;
  }
keychar = String.fromCharCode(keynum);
return !isValid(keychar,notOk);
}
function goBack()
{
window.history.back()
}
function Sure() {
	i = confirm('<bean:message key="confirmDelete"/>');
	if(i == 0) return false;
}

function checkonchangBRloc(){
	
	var selectinputcvd = document.getElementById('select');	
	var keywordcvd = document.getElementById('keyword');	
	var loccvd = document.getElementById('loc');	
	if (selectinputcvd.selectedIndex > 0 ){
		keywordcvd.value ="";
		keywordcvd.disabled =false;
		loccvd.disabled = false;
	  }
	
	if (selectinputcvd.selectedIndex == 0 ){
		keywordcvd.disabled =true;
		loccvd.disabled = true;
	   
	  }
	  
}

function showAddForm () {
	jQuery('#showForm').toggle('slide');
}

function showWorkflowForm () {
	jQuery('#workflow').toggle('slide');
}


function displayTabSearch(tabTitle){
	if(tabTitle == "timcongvanden"){
		
		var tab1 = document.getElementById("main");
		tab1.style.display= "inline";
		
		var tab2 = document.getElementById("tab2");
		tab2.style.display= "none";
		var td1 = document.getElementById("td1");
		var td2 = document.getElementById("td2");
		td1.className="selected";
		td2.className="";
		
	}
	
	else{
		var tab1 = document.getElementById("main");
		tab1.style.display= "none";	
		var tab2 = document.getElementById("tab2");
		tab2.style.display= "inline";
		var td1 = document.getElementById("td1");
		var td2 = document.getElementById("td2");
		td2.className="selected";
		td1.className="";
	}

}