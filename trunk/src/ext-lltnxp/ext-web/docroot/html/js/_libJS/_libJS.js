/* Dinh nghia cac ham javascript dung chung cho toan bo portal */

	function trim(str) {
		if (!str || !str.length) return '';
		var c = str.charCodeAt(0);
		while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
			str = str.substring(1);
			if (str.length > 0) c = str.charCodeAt(0);
		}
	if (str.length > 0) {
			c = str.charCodeAt(str.length - 1);
			while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
				str = str.substring(0, str.length - 1);
				if (str.length > 0) c = str.charCodeAt(str.length - 1, 1);
			}
		}
		return str;
	}

	function getFirstDigitChars(strCheck) {
	    var re = /\d+/;
	    return strCheck.match(re);
	}
	
	function isDate(sd) {
		var s = splitDateString(sd);
		if (s == null) return false;
		var err = true;
		if (s.length == 3) {
			d = Math.ceil(s[0]);
			m = Math.ceil(s[1]);
			y = Math.ceil(s[2]);
			if (s[0].length <= 2) {
				if (y > 70) y = 1900 + y;
				else y = 2000 + y;
			}
			if (s[2] > 9999 || s[2] < 1000) return false;
			if ((trim(s[1])).length < 2 || (trim(s[0])).length < 2 ) return false;
			dd = new Date(y, m - 1, d);		
			if (dd && dd.getFullYear() == y && (dd.getMonth() == m - 1) && dd.getDate() == d) err = false;	
		}
		return (!err);
	}
	
	function splitDateString(str) {

		var sd = trim(str);
		if (!sd.length) return null;
		var s = sd.replace("-", "/");
		s = s.replace("-", "/");
		s = s.replace("-", "/");
		s = s.split("/");
		return s;
	}
	
	function isFileWithExt(strCheck, ext) {
		flag = true;
		strCheck = strCheck.toLowerCase();
		arrCheck = strCheck.split(".");
		if (arrCheck.length < 2) flag = false;
		else {
			
			if (ext != arrCheck[arrCheck.length - 1]) flag = false;
		}
		return flag;
	}

/*
 * Author: Xuan Cong
 * Function name: isNumeric
 * Function: check the str is a numeric string
 * Return: boolean 
 */
function isNumeric(str) {
	if (!str || str.length == 0) return false;

	var strValid = "0123456789.-";
	var retVal = true;
	for (var idx = 0; idx < str.length; idx++) {
		var symb = str.charAt(idx);
		if (strValid.indexOf(symb) == -1) {
			retVal = false;
			break;
		}
	}
	if (isNaN(str)) {
		retVal = false;
	}
	
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isNegativeNumeric
 * Function: check the str is a numeric string and it's value is less than 0
 * Return: boolean 
 */

function isNegativeNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isNumeric(str)) {// Not a numeric string
		retVal = false;
	}
	else {
		if (parseFloat(str) >= 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isNotNegativeNumeric
 * Function: check the str is a numeric string and it is a not negative number
 * Return: boolean 
 */
function isNotNegativeNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isNumeric(str)) { // Not a numeric string
		retVal = false;
	}
	else {
		if (parseFloat(str) < 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isPositiveNumeric
 * Function: check the str is a numeric string and it is a positive number
 * Return: boolean 
 */
function isPositiveNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isNumeric(str)) { // Not a numeric string
		retVal = false;
	}
	else {
		if (parseFloat(str) <= 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isNotPositiveNumeric
 * Function: check the str is a numeric string and it is a not positive number
 * Return: boolean 
 */
function isNotPositiveNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isNumeric(str)) { // Not a numeric string
		retVal = false;
	}
	else {
		if (parseFloat(str) > 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isIntegerNumeric
 * Function: check the str is a numeric string and it's data type is integer
 * Return: boolean 
 */
function isIntegerNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isNumeric(str)) { // Not a numeric string
		retVal = false;
	}
	else {
		var intVal = parseInt(str) + "";
		if (intVal != str) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isIntegerNegativeNumeric
 * Function: check the str is a integer string and it's value is less than 0
 * Return: boolean 
 */
function isIntegerNegativeNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isIntegerNumeric(str)) { // Not a integer string
		retVal = false;
	}
	else {
		if (parseInt(str) >= 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isIntegerNotNegativeNumeric
 * Function: check the str is a integer string and it is a not integer negative number
 * Return: boolean 
 */
function isIntegerNotNegativeNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isIntegerNumeric(str)) { // Not a integer string
		retVal = false;
	}
	else {
		if (parseInt(str) < 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isIntegerPositiveNumeric
 * Function: check the str is a integer string and it is a positive number
 * Return: boolean 
 */
function isIntegerPositiveNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isIntegerNumeric(str)) { // Not a integer string
		retVal = false;
	}
	else {
		if (parseInt(str) <= 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Xuan Cong
 * Function name: isIntegerNotPositiveNumeric
 * Function: check the str is a integer string and it is a not positive number
 * Return: boolean 
 */
function isIntegerNotPositiveNumeric(str) {
	// retVal: return value
	var retVal = true;
	if (!isIntegerNumeric(str)) { // Not a integer string
		retVal = false;
	}
	else {
		if (parseInt(str) > 0) retVal = false;
	}
	return retVal;
}

/*
 * Author: Gia Bao
 * Function name: isEmail
 * Function: check the str is a valid email address
 * Return: boolean 
 */
function isEmail(str) {
	str = trim(str);
	var re = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    if (!str.match(re)) {
        return false;
    }
    return true;
}

/*
 * Author: Xuan Cong
 * Function name: formatDate
 * Function: format date value to string value
 * Return: string of date if valid or empty string if not valid
 */
function formatDate(date, mask) {
	// date: date value
	// mask: accept: d, m, y, /
	// ********** Check the mask is valid **********
	for (idxM = 0; idxM < mask.length; idxM++) {
		var itemVal = mask.charAt(idxM);
		if (itemVal != 'd' && itemVal != 'm' && itemVal != 'y' && itemVal != '/') {
			return "";
		}
	}
	var arrMask = mask.split("/");
	if (arrMask.length != 3) return "";
	
	// ********** Get each parts of date **********
	var vDay = date.getDate();
	var vMonth = date.getMonth() + 1;
	var vYear = date.getYear();
	
	// ********** Checking and replace each element of array **********
	for (idxM = 0; idxM < arrMask.length; idxM++) {
		var itemVal = arrMask[idxM];
		if (itemVal == "d") arrMask[idxM] = "" + vDay;
		else if (itemVal == "dd") {
			if (vDay < 10) arrMask[idxM] = "0" + vDay;
			else arrMask[idxM] = "" + vDay;
		}
		else if (itemVal == "m") arrMask[idxM] = "" + vMonth;
		else if (itemVal == "mm") {
			if (vMonth < 10) arrMask[idxM] = "0" + vMonth;
			else arrMask[idxM] = "" + vMonth;
		}
		else if (itemVal == "yy") arrMask[idxM] = ("" + vYear).substring(2, 4);
		else if (itemVal == "yyyy") arrMask[idxM] = "" + vYear;
		else return "";
	}
	
	// ********** return value **********
	return arrMask.join("/");
}

/*
 * Author: Xuan Cong
 * Function name: replaceAll
 * Function: replace all search string with subsitute string
 * Return: string
 */
function replaceAll(srcStr, searStr, subsStr) {
	var re = new RegExp(searStr, "g");
	return srcStr.replace(re, subsStr);
}

/*
 * Author: Xuan Cong
 * Function name: compare2Date
 * Function: compare 2 date string with format d/m/yyyy or d/mm/yyyy or dd/m/yyyy or dd/mm/yyyy
 * Return: number. -1: date1 < date2; 0: two dates equal; 1: date1 > date2
 */
function compare2Date(strDate1, strDate2) {
	var arrDate1 = strDate1.split("/");
	var arrDate2 = strDate2.split("/");
	var valDate1 = parseInt(arrDate1[2]) * 10000 + parseInt("1" + arrDate1[1]) % 100 * 100 + parseInt("1" + arrDate1[0]) % 100;
	var valDate2 = parseInt(arrDate2[2]) * 10000 + parseInt("1" + arrDate2[1]) % 100 * 100 + parseInt("1" + arrDate2[0]) % 100;
	if (valDate1 < valDate2) return -1;
	if (valDate1 == valDate2) return 0;
	return 1;
}

/*
 * Author: Xuan Cong
 * Function name: _getBrowserName
 * Function: get the name of browser
 * Return: firefox, opera, chrome, msie, unknown
 */
function _getBrowserName() {
	var retVal = "";
	var userAgent = navigator.userAgent.toLowerCase();

	if (userAgent.indexOf("firefox") >= 0) {
		retVal = "firefox";
	}
	else if (userAgent.indexOf("opera") >= 0) {
		retVal = "opera";
	}
	else if (userAgent.indexOf("chrome") >= 0) {
		retVal = "chrome";
	}
	else if (userAgent.indexOf("msie") >= 0) {
		retVal = "msie";
	}
	else {
		retVal = "unknown";
	}
	
	return retVal;
}