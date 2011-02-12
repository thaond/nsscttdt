<%@ include file="/html/portlet/ext/holidaymanagement/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/holidayDWRClient.js'></script>
<script language="JavaScript" type="text/javascript">

function getSelectRadio(elementRow)
{		
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('holidayId'+idElementTd)
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
/* yenlt close 27082010
function submitForm(form, url)
{
	if (!validate()) {
		alert("<liferay-ui:message key='vui-long-chon-ngay' />");
	} 
	else {
		form.action = url;
		form.submit();
	}
}
*/
function validate() {
	
	var arrRadioElements = document.getElementsByName("holidayId");
	
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

function addRow() {
	var table=document.getElementById('holidayTable').insertRow(1);
	var holidayType = table.insertCell(0);
	var holiday = table.insertCell(1);
	var deleteRow = table.insertCell(2);

	var stt = parseInt(document.getElementById('stt').value) + 1;
	document.getElementById('stt').value = stt;

	var name = "holiday" + stt;
	var idinp = "holiday" + stt;
	var idimag = "holidayimage" + stt;
	document.getElementById('arr_ngaynghile').value = "_" + name + document.getElementById('arr_ngaynghile').value;
	table.setAttribute("class", "portlet-section-header results-row");
	table.setAttribute("className", "portlet-section-header results-row");
	
	holidayType.innerHTML = '<div align="center"><input style="width: 95%" type="text" id="holidayType" name="holidayType" value="Holiday" readonly="readonly"/></div>';
	holiday.innerHTML = '<div align="center"><input style="width: 60%" type="text" id="' + idinp + '" name="' + name + '" onblur="checkValueHolidayInput(this);"/>' + 
						'&nbsp;&nbsp;<span style="color:gray;font-size: x-small"> (dd/mm/yyyy)</div>';
	deleteRow.innerHTML = '<div align="center"><input type="button" value="<liferay-ui:message key="delete" />" onclick="deleteRow(this)" /></div></td>';
}

function deleteRow(r)
{
	var j=r.parentNode.parentNode.parentNode.rowIndex;
	document.getElementById('holidayTable').deleteRow(j);
	var stt = parseInt(document.getElementById('stt').value) -1;
	document.getElementById('stt').value = stt;
}

/*
 * phmphuc update kiem tra form, rang buoc dieu kien truoc khi submit form
 */
	function <portlet:namespace />checkForm (form) {
	
		if (checkInputRadio() == false && document.getElementById('stt').value == 1) {
			alert("<liferay-ui:message key='vui-long-chon-ngay'/>");
			return false;
		}
	
		if (checkHolidayInput() == false) {
			return false;
		}
		else {
			return true;
		}	
	}
	
	function checkInputRadio() {
		var tagInput = document.getElementsByTagName("input");
		var res = false;
		
		for(var n = 0; n < tagInput.length; n ++) {
			if(tagInput[n].type == "radio") {
				if (tagInput[n].checked) {
					res = true;
					break;
				}
			}
		}
		return res;
	}
	
	function checkHolidayInput() {
		var stt = document.getElementById('stt').value;
		var res = true;
		
		for (var i = stt; i > 1; i --) {
			var dateInput = document.getElementById('holiday' + i);
	
			if (dateInput != null) {
				if (dateInput.value.trim() == "") {
					alert("<liferay-ui:message key='vui-long-chon-ngay' />");
					document.getElementById('holiday'+ i).focus();
					res = false;
					break;
				}
				if (isDate(dateInput.value) == false || dateInput.value.length != 10) {
					alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
					document.getElementById('holiday' + i).focus();
					res = false;
					break;
				}
		
				for (var j = i; j > 1; j --) {
					var dateInputTemp = document.getElementById('holiday' + j);
					if (dateInputTemp != null) {
						if (dateInput.id != dateInputTemp.id && dateInput.value == dateInputTemp.value) {
							alert("<liferay-ui:message key='ngay-nghi-da-ton-tai'/>");
							document.getElementById('holiday'+ i).value = "";
							res = false;
							break;
						}
					}
				}
			}
		}
		return res;
	}
// end kiem tra form

/**
 * ham kiem tra danh cho Them moi
 */
	// kiem tra ngay nghi trong tuan - input check
	function checkValueDayInput(dateChoose) {
		checkNgayNghiTrongTuan(dateChoose);
		return;
	}
	
	function checkNgayNghiTrongTuan(dateChoose) {
		if (dateChoose.value.trim() == "") {
			return true;
		}
		
		var arrDateChoose = dateChoose.value.split("/");
		var holidayValue = arrDateChoose[1];
	
		holidayDWRClient.countHolidayByValue(holidayValue, function (data) {
			if (data > 0) {
				alert("<liferay-ui:message key='ngay-nghi-da-ton-tai'/>");
				dateChoose.checked = false;
			}
		});
	}
	
	// kiem tra ngay nghi le - holiday
	function checkValueHolidayInput(dateInput) {
		checkNgayNghiLe(dateInput);
		return;
	}
	
	function checkNgayNghiLe(dateInput) {
		holidayDWRClient.countHolidayByValue(dateInput.value, function (data) {
			if (data > 0) {
				alert("<liferay-ui:message key='ngay-nghi-da-ton-tai'/>");
				dateInput.value = "";
			}
		});
	}

	
/**
 * ham kiem tra danh cho edit
 */
 	// kiem tra form edit
 	function checkFormEdit(form) {
		var holidayValue = document.getElementById('holidayValue');
		var holidayValueHidden = document.getElementById('holidayValueHidden');

		if (holidayValue != null) {
			if (holidayValue.value.trim() == "") {
				alert("<liferay-ui:message key='vui-long-chon-ngay' />");
				document.getElementById('holidayValue').value = holidayValueHidden.value;
				document.getElementById('holidayValue').focus();
				return false;
			}
			if (isDate(holidayValue.value) == false || holidayValue.value.length != 10) {
				alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
				document.getElementById('holidayValue').value = holidayValueHidden.value;
				document.getElementById('holidayValue').focus();
				return false;
			}
		}
 	}
 	
	// kiem tra ngay nghi le - holiday
	function checkValueHolidayInputEdit() {
		checkNgayNghiLeEdit();
		return;
	}

	function checkNgayNghiLeEdit() {
		var holidayValue = document.getElementById('holidayValue').value;
		var holidayValueHidden = document.getElementById('holidayValueHidden').value;

		if (holidayValue.trim() == "") {
			return true;
		}

		holidayDWRClient.countHolidayByValue(holidayValue, function (data) {
			if ((holidayValue == holidayValueHidden && data > 1) || (holidayValue != holidayValueHidden && data > 0)) {
				alert("<liferay-ui:message key='ngay-nghi-da-ton-tai'/>");
				document.getElementById('holidayValue').value = holidayValueHidden;
			}
		});
	}
</script>
