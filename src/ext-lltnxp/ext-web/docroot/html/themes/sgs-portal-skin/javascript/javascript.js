jQuery(document).ready(
 
	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	var height = window.screen.height;
	//var department = document.getElementById("boxcont-layout").offsetHeight;
	var winW = (window.innerWidth) ? window.innerWidth : document.body.offsetWidth;
	var winH = (window.innerHeight) ? window.innerHeight : document.body.offsetHeight;
	
	var newheight = (winH  - 197 ) ; 
	var heightSearchDoc = (winH  - 180 ) ; 
	var sodu = (height  - 290 ) ; 
	if (document.getElementById('boxcont-layout') != null){
	document.getElementById("boxcont-layout").style.minHeight = newheight + 'px';
	
	//document.getElementById("boxcont-layout").style.overflow = "auto";
	//document.getElementById("boxcont-layout").style.paddingBottom = "15px";
	}
	
	
	
	/*
	var tabheight = window.screen.availHeight;
	var tabContentheight = document.getElementById("boxcont-layout").offsetHeight + 50;
	
alert(tabContentheight)	

	if (tabheight < tabContentheight) { 
	document.getElementById("boxcont-layout").offsetHeight = tabContentheight + "px"; 
	} 
*/
	if ((screen.width>1024) && (screen.height>768)) {
		
		

	/*$("link[rel=stylesheet]:not(:first)").attr({href : "../css/detect1024.css"});*/
	}
	else if ((screen.width==1440) && (screen.height==900)) {
	
	/*$("link[rel=stylesheet]:not(:first)").attr({href : "../css/detect1440.css"});*/
	}
	else
	{
		
		/*$("link[rel=stylesheet]:not(:first)").attr({href : "../css/detect800.css"});*/
	}
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	jQueryObj: the jQuery wrapped object of the current portlet
	*/

	function(portletId, jQueryObj) {
	}
);

jQuery(document).last(

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);
function thoi(){
var test = document.getElementById('test');
 if(isDate(test.value)==false || test.value == ""){
		alert("<liferay-ui:message key='ngayhentrakhachkhonghople'/>\n");
		test.focus();
	}	}
	
	var sgs = function()
{
    var days = [ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
    var formatPhone = /(^\d{10,11}$)|(^\d{7,8}$)|(^\(\d{2}\)\d{8}$)|(^\(\d{3}\)\d{7}$)|(^\d{2}[\x20|\-]\d{8}$)|(^\d{3}[\x20|\-]\d{7}$)/;
    // private function
    // parse chuoi str theo format da dinh, tra ve
    // mang chua 3 thanh phan day, month, year
    parseDateElements = function(str, format)
    {
        var pattern; // regexp de test
        var dateElements = new Array(3); // array
        // dateElements[0]: day
        // dateElements[1]: month
        // dateElements[2]: year
    
        format = format.toString().toLowerCase();
        
        if (format == "dmy" || format == "mdy")
        {
            pattern = /^\d{1,2}([\-|\/])\d{1,2}\1\d{4}$/;
            if (str.search(pattern) == -1) return null;
            arr = str.match(/\d+/g);
            
            if (format.substring(0, 1) == "d")
            {
                dateElements[0] = parseInt(arr[0], 10);
                dateElements[1] = parseInt(arr[1], 10);
                dateElements[2] = parseInt(arr[2], 10);
            }
            else
            {
                dateElements[0] = parseInt(arr[1], 10);
                dateElements[1] = parseInt(arr[0], 10);
                dateElements[2] = parseInt(arr[2], 10);
            }
            return dateElements;
        }   
        else if (format == "dym" || format == "myd")
        {
            pattern = /^\d{1,2}([\-|\/])\d{4}\1\d{1,2}$/;
            if (str.search(pattern) == -1) return null;
            arr = str.match(/\d+/g);
            
            if (format.substring(0, 1) == "d")
            {
                dateElements[0] = parseInt(arr[0], 10);
                dateElements[1] = parseInt(arr[2], 10);
                dateElements[2] = parseInt(arr[1], 10);
            }
            else
            {
                dateElements[0] = parseInt(arr[2], 10);
                dateElements[1] = parseInt(arr[0], 10);
                dateElements[2] = parseInt(arr[1], 10);
            }
            return dateElements;
        }
        else if (format == "ydm" || format == "ymd")
        {
            pattern = /^\d{4}([\-|\/])\d{1,2}\1\d{1,2}$/;
            if (str.search(pattern) == -1) return null;
            arr = str.match(/\d+/g);
            if (format.substring(1, 2) == "d")
            {
                dateElements[0] = parseInt(arr[1], 10);
                dateElements[1] = parseInt(arr[2], 10);
                dateElements[2] = parseInt(arr[0], 10);
            }
            else
            {
                dateElements[0] = parseInt(arr[2], 10);
                dateElements[1] = parseInt(arr[1], 10);
                dateElements[2] = parseInt(arr[0], 10);
            }
            return dateElements;
        }
        else 
            return null; // malformat, return null;
    }
    
    var pub = 
    {
        /**
         * compares 2 dates date1, date2 for ordering
         *      d1, d2: JavaScript dates object to be compared
         * return:
         *          the value 0 if the argument date1 is equal to date2; 
         *          a value less than 0 if date1 is before date2 argument; 
         *          and a value greater than 0 if date1 is after date2 argument
        */
        compareDate : function(date1, date2)
        {
            var y1 = parseInt(date1.getFullYear(), 10);
            var y2 = parseInt(date2.getFullYear(), 10);
            if (y1 != y2) return y1 - y2;
    
            var m1 = parseInt(date1.getMonth(), 10);
            var m2 = parseInt(date2.getMonth(), 10);
            if (m1 != m2) return m1 - m2;
    
            return parseInt(date1.getDate(), 10) - parseInt(date2.getDate(), 10);
        },
        /**
         * Kiem tra (d, m, y) co la 1 ngay dung nghia. 
         * Vi du: 30/12/2007 khong co nghia
        */
        isValidDate : function(d, m, y)
        {
            d = parseInt(d, 10);
            m = parseInt(m, 10);
            y = parseInt(y, 10);
            
            if (m > 12 || m < 1) return false;
            
            var leapDay = 0;
            if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)))
                leapDay = 1; // nam nhuan
            return (d < 1 || d > days[m] + leapDay) ? false : true;
        },
        /**
         * tests whether format of a string is a valid date and converts this string 
         * to an JavaScript date object
         *
         * input:
         *          str: string to be tested
         *          format: format of a valid date string
         *              format must be element of { "dmy", "dym", "mdy", "myd", "ydm", "ymd" }
         *              
         * return:
         *          a JavaScript Date object or null (if there is something wrong)
         *
         * Quy dinh: 
         *          day, month: 1->2 digit(s)
         *          year: 4 digits
         *          separator: - or /
         *          
        */

        // format date: dmy, dym, mdy, myd, ydm, ymd
        stringToDate : function (str, format)
        {
		var dateElements = parseDateElements(str, format); // array
            // kiem tra ngay OK?
            if (dateElements != null && pub.isValidDate(dateElements[0], dateElements[1], dateElements[2]))
                return new Date(dateElements[2], dateElements[1] - 1, dateElements[0]);
            
			//alert("Error ....... Ngay: " + str + ", format: " + format);
			//alert(dateElements.length + " " + dateElements[0] + " " + dateElements[1] + " " + dateElements[2]);
			return null;
        },
        
        stringToPhone : function(str)
        {
            if (arguments.length > 1)
            {
                if (str.search(arguments[1].toString()) == -1) return null;
            }
            else
            {
                if (str.search(formatPhone) == -1) return null;
            }
            
            var arr = str.match(/\d+/g);
            
            var result = "";
            for (var i = 0; i < arr.length; i ++)
                result += arr[i];
            
            return result;
        }
    };
    return pub;
}();


/**
 * DHTML date validation script for dd/mm/yyyy. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 *ham kiem tra dung dinh dang ngay hay khong 
 example :
 var ngaynophoso = document.getElementById('applicationDate');
 if(isDate(ngayhentrakhach.value)==false || ngayhentrakhach.value == ""){
		messageError += "<liferay-ui:message key='ngayhentrakhachkhonghople'/>\n";
		ngayhentrakhach.focus();
	}	
 */
// Declaring valid date character, minimum year and maximum year
var dtCh= "/";
var minYear=1900;
var maxYear=2100;
var ngaynop = document.getElementById('applicationDate');
var ngayhen = document.getElementById('expectedReturningDate');
var ngaynhap = document.getElementById('inputDataDate');

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth, 10)
	day=parseInt(strDay, 10)
	year=parseInt(strYr, 10)
	if (pos1==-1 || pos2==-1){
		//alert("The date format should be : dd/mm/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		//alert("<liferay-ui:message key='Please-enter-a-valid-month'/>");
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		//alert("<liferay-ui:message key='please-enter-a-valid-day'/>");
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		//alert("<liferay-ui:message key='Please-enter-a-valid-4-digit-year'/>");
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		//alert("<liferay-ui:message key='Please-enter-a-valid-date'/>");
		return false
	}
return true
}

/*---------validate time hh:mm:ss*/
<!-- Begin
function IsValidTime(timeStr) {
/*
if(IsValidTime(thoigiannophoso.value)==false){
		messageError += "<liferay-ui:message key='thoigiannophosokhongdung'/>\n";
		thoigiannophoso.focus();
	}
 Checks if time is in HH:MM:SS AM/PM format.
The seconds and AM/PM are optional.
them vao timePat nay neu check dinh dang gio co ampm
var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
*/
var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?$/;

var matchArray = timeStr.match(timePat);
if (matchArray == null) {
//alert("Time is not in a valid format.");
return false;
}
hour = matchArray[1];
minute = matchArray[2];
second = matchArray[4];
//ampm = matchArray[6];

if (second=="") { second = null; }
//if (ampm=="") { ampm = null }

if (hour < 0  || hour > 23) {
//alert("Hour must be between 1 and 12. (or 0 and 23 for military time)");
return false;
}
if (hour <= 12 ) {
//if (confirm("Please indicate which time format you are using.  OK = Standard Time, CANCEL = Military Time")) {
//alert("You must specify AM or PM.");
//return false;
 //  }
}
if  (hour > 12 ) {
//alert("You can't specify AM or PM for military time.");
//return false;
}
if (minute<0 || minute > 59) {
//alert ("Minute must be between 0 and 59.");
return false;
}
if (second != null && (second < 0 || second > 59)) {
//alert ("Second must be between 0 and 59.");
return false;
}
return true;
}
//  End -->

/*check number only use for all maybe onKeyPress="return numbersonly(this, event)"
 * tam thoi de day sau nay se tach ra thanh ham dung chung de check number
 **/
function numbersonly(myfield, e, dec)
{
var key;
var keychar;

if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);

// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) )
   return true;

// numbers
else if ((("0123456789").indexOf(keychar) > -1))
   return true;

// decimal point jump
else if (dec && (keychar == "."))
   {
   myfield.form.elements[dec].focus();
   return false;
   }
else
	alert("<liferay-ui:message key='Accept-number-only'/>")
   return false;
}

function clickCheckBox(event,eleCheckBox)
{
	
	if (event) 
	{
		if (event.stopPropagation)
		{
			event.stopPropagation();
		}
		else event.cancelBubble = true;
				
	}
	else // windows
	{
		window.event.cancelBubble = true;
	}
	return true; 
}

