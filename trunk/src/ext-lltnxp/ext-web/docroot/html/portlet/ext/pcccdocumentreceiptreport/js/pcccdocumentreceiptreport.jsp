<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/tinhHinhThuLyCongVanClient.js'></script>

<script type="text/javascript" >

function <portlet:namespace/>enableItems(userId) {

	// enable
	var selValue = document.getElementById("<portlet:namespace/>departmentId").value;
	if(selValue != "toancoquan" && selValue != "tatcaphongban") {
		document.getElementById("<portlet:namespace/>userId").disabled = "";

		// lay danh sach Chuyen vien cua Phong ban
		tinhHinhThuLyCongVanClient.getUserOfDepartment(selValue, function(data) {
			var sel = document.getElementById("<portlet:namespace/>userId");		
			// empty select tag
			sel.length = 0;
			// option: chon chuyen vien
			var opt = document.createElement('option');
			opt.text = "[--Ch\u1ecdn chuy\u00ean vi\u00ean--]";
			opt.value = "0";
			if(opt.value == userId) {
				opt.selected = "selected";
			}
			// minh update 20100607
			//sel.appendChild(opt);
			try {
				sel.add(opt, null); // standards compliant
			  }
			catch (ex) {
				sel.add(opt); // IE only
			  }
			
			// option: tat ca chuyen vien
			var opt1 = document.createElement('option');
			opt1.text = "T\u1ea5t c\u1ea3 chuy\u00ean vi\u00ean";
			opt1.value = "1";
			if(opt1.value == userId) {
				opt1.selected = "selected";
			}
			
			// minh update 20100607
			//sel.appendChild(opt);
			try {
				sel.add(opt1, null); // standards compliant
			  }
			catch (ex) {
				sel.add(opt1); // IE only
			  }
			
			// option: cac chuyen vien trong phong
			for (var i = 0; i < data.length; i++) {
				var opt2 = document.createElement('option');
				// minh update 20100608
				//opt2.text = data[i].greeting;
				opt2.text = data[i].lastName + ' ' + data[i].middleName + ' ' + data[i].firstName;
				opt2.value = data[i].userId;
				if(data[i].userId == userId) {
					opt2.selected = "selected";
				}
				// minh update 20100607
		    	//sel.appendChild(opt);
				try {
					sel.add(opt2, null); // standards compliant
				  }
				catch(ex) {
					sel.add(opt2); // IE only
				  }
			}
		});
		
	} else { // disable
		document.getElementById("<portlet:namespace/>userId").length = 2;
		document.getElementById("<portlet:namespace/>userId").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenPhongBan").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenPhongBan").checked = "";
		var objItem = document.getElementById("<portlet:namespace/>tenPhongBan");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
		//document.getElementById("<portlet:namespace/>tenChuyenVien").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenChuyenVien").checked = "";
		objItem = document.getElementById("<portlet:namespace/>tenChuyenVien");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
	}

	if(selValue != "toancoquan") {
		//document.getElementById("<portlet:namespace/>tenPhongBan").disabled = "";
		//document.getElementById("<portlet:namespace/>tenPhongBan").checked = "checked";
		var objItem = document.getElementById("<portlet:namespace/>tenPhongBan");
		if (objItem) {
			objItem.disabled = false;
			objItem.checked = true;
		}
		//document.getElementById("<portlet:namespace/>tenChuyenVien").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenChuyenVien").checked = false;
		objItem = document.getElementById("<portlet:namespace/>tenChuyenVien");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
	} else {
		//document.getElementById("<portlet:namespace/>tenPhongBan").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenPhongBan").checked = "";
		objItem = document.getElementById("<portlet:namespace/>tenPhongBan");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
	}
}

function <portlet:namespace/>onChangeChuyenVien() {

	if(document.getElementById("<portlet:namespace/>userId").value == "0") {
		//document.getElementById("<portlet:namespace/>tenPhongBan").disabled = "";
		//document.getElementById("<portlet:namespace/>tenPhongBan").checked = true;
		objItem = document.getElementById("<portlet:namespace/>tenPhongBan");
		if (objItem) {
			objItem.disabled = false;
			objItem.checked = true;
		}
		//document.getElementById("<portlet:namespace/>tenChuyenVien").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenChuyenVien").checked = false;
		objItem = document.getElementById("<portlet:namespace/>tenChuyenVien");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
	} else {
		//document.getElementById("<portlet:namespace/>tenPhongBan").disabled = "disabled";
		//document.getElementById("<portlet:namespace/>tenPhongBan").checked = false;
		objItem = document.getElementById("<portlet:namespace/>tenPhongBan");
		if (objItem) {
			objItem.disabled = true;
			objItem.checked = false;
		}
		//document.getElementById("<portlet:namespace/>tenChuyenVien").disabled = "";
		//document.getElementById("<portlet:namespace/>tenChuyenVien").checked = true;
		objItem = document.getElementById("<portlet:namespace/>tenChuyenVien");
		if (objItem) {
			objItem.disabled = false;
			objItem.checked = true;
		}
	}
}

function <portlet:namespace/>compare2Date(fromDate, toDate) {
	
	var strFromDate = fromDate.value.toString();
	var objFromDate = sgs.stringToDate(strFromDate,"dmy");
	var strToDate = toDate.value.toString();
	var objToDate = sgs.stringToDate(strToDate,"dmy");

	if(objFromDate > objToDate) {
		return false;
	}
	return true;
}

function <portlet:namespace/>checkForm(form) {

	var fromDate = document.getElementById('<portlet:namespace/>fromDate');
	var toDate = document.getElementById('<portlet:namespace/>toDate');
	// lay ngay hien tai
	var ngayHienTai = new Date();
	var year = ngayHienTai.getFullYear();
	var month = ngayHienTai.getMonth()+1;
	var day = ngayHienTai.getDate();
	var toDay = day + "/" + month + "/" + year;

	var strToDate = toDate.value.toString();
	var objToDate = sgs.stringToDate(strToDate,"dmy");
	var strToDay = toDay.toString();
	var objToDay = sgs.stringToDate(strToDay,"dmy");
	
	if(fromDate.value == "") {
		fromDate.focus();
		return false;
	}
	if(isDate(fromDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		fromDate.focus();
		return false;
	} 
	if(toDate.value == "") {
		toDate.focus();
		return false;
	}
	if(isDate(toDate.value) == false) {
		alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
		toDate.focus();
		return false;
	}
	if(<portlet:namespace/>compare2Date(fromDate, toDate) == false) {
		alert("Ch\u1ecdn ng\u00e0y th\u1ed1ng k\u00ea kh\u00f4ng ch\u00ednh x\u00e1c.\n('T\u1eeb ng\u00e0y' ph\u1ea3i nh\u1ecf h\u01a1n ho\u1eb7c b\u1eb1ng '\u0110\u1ebfn ng\u00e0y').");
		fromDate.focus();
		return false;
	}
	if (objToDate > objToDay) {
		alert("\u0110\u1ebfn ng\u00e0y kh\u00f4ng \u0111\u01b0\u1ee3c l\u1edbn h\u01a1n ng\u00e0y hi\u1ec7n t\u1ea1i.");
		document.getElementById('<portlet:namespace/>toDate').focus();	
		return false;
	}
	return true;
}

function selectOnChange(url, filterValue) {

	var action = url + "&" + filterValue;
	document.getElementsByName("<portlet:namespace />frmDanhSachCongVan")[0].setAttribute("action", action);
	document.<portlet:namespace />frmDanhSachCongVan.submit();
	document.getElementsByName("<portlet:namespace />frmDanhSachCongVan")[0].setAttribute("action", "");
}

function <portlet:namespace />addReportActionFrom1(url, reportType) {
	
	var action = url + "&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />frmDanhSachCongVan")[0].setAttribute("action", action);
	document.<portlet:namespace />frmDanhSachCongVan.submit();
	document.getElementsByName("<portlet:namespace />frmDanhSachCongVan")[0].setAttribute("action", "");
}

/**	
 * phmphuc them 11/11/2010
 * lay so cong van theo loai cong van duoc chon
 */
function getDocumentRecordByDocTypeId(userId) {
	var type = DWRUtil.getValue('<portlet:namespace/>loaiCongVan');
	var nhomcongvanselect = DWRUtil.getValue('nhomcongvanselect');
	
	var nhomCongVan = document.getElementById('<portlet:namespace/>nhomCongVan');

	// remove all elements select
	if (nhomCongVan.hasChildNodes()) {
	    while (nhomCongVan.childNodes.length >= 1) {
	    	nhomCongVan.removeChild(nhomCongVan.firstChild);       
	    } 
	}
		
	// add new all elements select
	nhomCongVan.options[0] = new Option('<liferay-ui:message key="tinhhinhthulycongvan.chonphannhom" />', 0);

	tinhHinhThuLyCongVanClient.getDocumentRecordByDocType(userId, type, function (data) {
		if (data != null) {
			for (var i = 0; i < data.length; i ++) {
				nhomCongVan.options[i+1] = new Option(data[i].documentRecordTypeName, data[i].documentRecordTypeId);
				if (data[i].documentRecordTypeId == nhomcongvanselect) {
					nhomCongVan.options[i+1].selected = "selected";
				}
			}
		}
	});
}
</script>
	