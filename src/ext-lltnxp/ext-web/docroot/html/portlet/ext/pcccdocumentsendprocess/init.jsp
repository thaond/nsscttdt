<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@ include file="/html/common/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	PortletPreferences pref = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		pref = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String[] congVanDiDangXuLyChung = pref.getValues("congVanDiDangXuLyChung", new String[0]);
	String[] congVanDiDangXuLyTuXuLy = pref.getValues("congVanDiDangXuLyTuXuLy", new String[0]);
	String[] congVanDiDaXuLyChung = pref.getValues("congVanDiDaXuLyChung", new String[0]);
	String[] congVanDiDaXuLyTuXuLy = pref.getValues("congVanDiDaXuLyTuXuLy", new String[0]);
	String[] listUser = pref.getValues("listUser", new String[0]);
	String[] listUserLDB = pref.getValues("listUserLDB", new String[0]);
	
	boolean documentRecordTypeCode = PrefsParamUtil.getBoolean(pref, request, "documentRecordTypeCode",false);
	boolean documentTypeCode = PrefsParamUtil.getBoolean(pref, request, "documentTypeCode",false);
	String textAdd = PrefsParamUtil.getString(pref, request, "textAdd","");
	textAdd = textAdd.trim();
	
	boolean departmentCode = PrefsParamUtil.getBoolean(pref, request, "departmentCode",false);
	boolean useYear = PrefsParamUtil.getBoolean(pref, request, "useYear",false);
%>

<script type="text/javascript">

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

function isDateOk(dtStr){
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
		//alert("The date format should be : dd/mm/yyyy");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("<liferay-ui:message key='Please-enter-a-valid-month'/>");
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("<liferay-ui:message key='please-enter-a-valid-day'/>");
		return false;
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("<liferay-ui:message key='Please-enter-a-valid-4-digit-year'/>");
		return false;
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("<liferay-ui:message key='Please-enter-a-valid-date'/>");
		return false;
	}
return true;

}

/*check gia tri hop le tu ngay de ngay form tim kiem cong van*/

function validateFormSearch() {
	var searchTungay = document.getElementById('HSCV-FROM');
	var searchDenngay = document.getElementById('HSCV-TO');
	
	if (isDateOk(searchTungay.value)==false){
		searchTungay.focus();
		return false;
	}
	
	if(isDateOk(searchDenngay.value)==false ){		
		searchDenngay.focus();
		return false;
	}	

		
	var obj2 = searchTungay.value.toString();
	var fromDatecompare = sgs.stringToDate(obj2, "dmy");

	var obj3 = searchDenngay.value.toString();
	var toDatecompare = sgs.stringToDate(obj3, "dmy");
		
		  
	if (toDatecompare < fromDatecompare){
		alert("<liferay-ui:message key='khoang-thoi-gian-khong-hop-le'/>\n");
	    searchTungay.focus();
	    return false;
	  }
	else{
		return true;
	}
	
	  
}

function validateFormSearchCVDI() {
	var searchTu = document.getElementById('HSCV-TU');
	var searchDen = document.getElementById('HSCV-DEN');
	
	if (isDateOk(searchTu.value)==false){
		searchTu.focus();
		return false;
	}
	
	if(isDateOk(searchDen.value)==false ){		
		searchDen.focus();
		return false;
	}	

		
	var obj4 = searchTu.value.toString();
	var tungay = sgs.stringToDate(obj4, "dmy");

	var obj5 = searchDen.value.toString();
	var denngay = sgs.stringToDate(obj5, "dmy");
		
		  
	if (denngay < tungay){
		alert("<liferay-ui:message key='khoang-thoi-gian-khong-hop-le!'/>\n");
	    searchTu.focus();
	    return false;
	  }
	else{
		return true;
	}
	
	  
}


</script>