jQuery(
	function() {
		if (Liferay.Browser.isIe() && Liferay.Browser.getMajorVersion() < 7) {
			jQuery('#navigation > ul > li').hover(
				function(event) {
					jQuery(this).addClass('hover');
				},
				function(event) {
					jQuery(this).removeClass('hover');
				}
			);
		}
	}
	
);

var dtCh= "/";
var minYear=1900;
var maxYear=2100;

	function isInteger(s){
		var i;
	    for (i = 0; i < s.length; i++){   
	        var c = s.charAt(i);
	        if (((c < "0") || (c > "9"))) return false;
	    }
	    return true;
	}
	
	function daysInFebruary (year){
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
	
	function stripCharsInBag(s, bag){
		var i;
	    var returnString = "";
	    for (i = 0; i < s.length; i++){   
	        var c = s.charAt(i);
	        if (bag.indexOf(c) == -1) returnString += c;
	    }
	    return returnString;
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
			return false
		}
		if (strMonth.length<1 || month<1 || month>12){
			return false
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
			return false
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
			return false
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
			return false
		}
		return true
	}
	
	var nss = function()
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
	        
	    };
	    return pub;
	}();