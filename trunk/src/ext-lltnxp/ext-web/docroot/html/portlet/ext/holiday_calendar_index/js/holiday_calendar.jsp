<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>

<script type="text/javascript">
	function checkDateCreate(){
		var dateCreate = document.<portlet:namespace/>fm.<portlet:namespace/>holidayCalendarDateCreate.value;
	    if(isDateTime(dateCreate) == false){
	    	return false;
	    }
	}
	
	function checkDate() {
	  	 if (checkDateFrom() == false || checkDateTo() == false){
	      	 return false;
	   	 } else {
	    	 return true;
	     }
	}

	function checkDateFrom(){
		var dateFrom = document.<portlet:namespace />fm.<portlet:namespace />dateFrom.value;
	    if((dateFrom != "") && (isDateTime(dateFrom) == false)){
	    	return false;
	    }else{
	    	return true;
	    }
	}
	    
	function checkDateTo(){
		var dateTo = document.<portlet:namespace />fm.<portlet:namespace />dateTo.value;
	   	if((dateTo != "") && (isDateTime(dateTo) == false)){
	    	return false;
	    }else{
	    	return true;
	    }
	}

	var dtCh= "/";
	function isInteger(s){
	   var i;
	   	for (i = 0; i < s.length; i++){   
	       var c = s.charAt(i);
	       if (((c < "0") || (c > "9"))) return false;
	   	}
	   return true;
	}

	function stripCharsInBag(s, bag){
	   var i;
	   var returnString = "";
	   	for(i = 0; i < s.length; i++){   
	        var c = s.charAt(i);
	        if (bag.indexOf(c) == -1) returnString += c;
	    }
	   return returnString;
	}

	function daysInFebruary (year){
	   return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	   
	function DaysArray(n) {
	   for(var i = 1; i <= n; i++) {
	    	this[i] = 31
	    	if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
	    	if (i==2) {this[i] = 29}
	   } 
	   return this
	}

	function isDateTime(dtStr){
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
	    month=parseInt(strMonth)
	    day=parseInt(strDay)
	    year=parseInt(strYr)
	    	if (pos1==-1 || pos2==-1){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
	    		alert("<liferay-ui:message key='input-date-validate'/>")
	    		return false
	    	}
	    	if (strMonth.length<1 || month<1 || month>12){
	    		alert("<liferay-ui:message key='input-month-validate'/>")
	    		return false
	    	}
	    	if (strYear.length != 4 || year==0){
	    		alert("<liferay-ui:message key='input-year-validate'/>")
	    		return false
	    	}
	    	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	return true
	    }
</script>