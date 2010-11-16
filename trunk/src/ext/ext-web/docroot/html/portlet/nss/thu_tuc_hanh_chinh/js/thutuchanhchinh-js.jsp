<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/DonViThuTucDWRClient.js'></script>

<script type="text/javascript">
var incstt = 0; // add row

function <portlet:namespace />validateFormThuTucHanhChinh() {
	fileUpload();

	var tenThuTucHanhChinh = document.getElementById('tenThuTucHanhChinh').value;
	var maLinhVucThuTuc = document.getElementById('maLinhVucThuTuc').value;
	var maDonViThuTuc = document.getElementById('maDonViThuTuc').value;

	if (tenThuTucHanhChinh.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten-thu-tuc-hanh-chinh"/>');
		document.getElementById("tenThuTucHanhChinh").focus();
		return false;
	}
	if (maLinhVucThuTuc.trim() == "0") {
		alert('<liferay-ui:message key="vui-long-chon-linh-vuc-thu-tuc"/>');
		document.getElementById("maLinhVucThuTuc").focus();
		return false;
	}
	if (maDonViThuTuc.trim() == "0") {
		alert('<liferay-ui:message key="vui-long-chon-co-quan-thuc-hien"/>');
		document.getElementById("maDonViThuTuc").focus();
		return false;
	}
	if (checkFileUpload() == false) {
		return false;
	}
	else {
		return true;
	}
}

function deleteThuTucHanhChinh(url){
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}


function uploadThuTucHanhChinhFile()
{
	var table=document.getElementById('addfileupload').insertRow(1);
	
	var title = table.insertCell(0);
	var nameDocument = table.insertCell(1);
	var deleteRow = table.insertCell(2);

	table.style.backgroundColor = "white";
	title.className = "td-stt-pml";
	nameDocument.className = "td-stt-pml";
	deleteRow.className = "td-stt-pml";
	
	title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile' type='text' maxlength='255' id='titlefile" +incstt+"'>";
	nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"' onchange='getFileNameForTitle(this)'>";
	deleteRow.innerHTML="<div align='center'><input type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
	incstt += 1;
}

function getFileNameForTitle(obj) {
	if (obj.type != "file") return;
	var id = obj.id;
	var filePath = obj.value;
	if (id != null && id != "") {
		var numOfId = id.replace("namefile", "");
		var titleObj = document.getElementById("titlefile" + numOfId);
		if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
			var arrTmp = filePath.split("\\");
			if (arrTmp.length > 0) {
				var fileName = arrTmp[arrTmp.length - 1];
				if (fileName.length > 0) {
					var lastIdxDot = fileName.lastIndexOf(".");
					if (lastIdxDot > 0) {
						titleObj.value = fileName.substring(0, lastIdxDot);
					}
				} // end if
			} // end if
		} // end if
	} // end if
}

function deleteRow(row) {
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addfileupload').deleteRow(i);
}

function deleteRowFileUpload(r, id) {
	var str_filedinhkem = document.getElementById('str_filethutuchanhchinhtodelete').value;
	str_filedinhkem += id + "/";
	document.getElementById('str_filethutuchanhchinhtodelete').value = str_filedinhkem;
	
	 var i = r.parentNode.parentNode.rowIndex;
	 document.getElementById("recentFile").deleteRow(i);
}

function fileUpload() {
	var listNameRow = "";
	var valueNameFile ="";
	var tileFile ="";
	for(i = 0; i < incstt; i++) {
		if(document.getElementById('namefile'+ i)) {			
			listNameRow += "namefile" + i + "_";
			valueNameFile += document.getElementById('namefile'+ i).value +"/";
		}

		if (document.getElementById('titlefile'+ i)) {
			tileFile += document.getElementById('titlefile'+ i).value + "#";	
		}
	}
	document.getElementById('nameFieldRow').value = listNameRow;
	document.getElementById('nameFiles').value = valueNameFile;
	document.getElementById('titleFiles').value = tileFile;		
}

function checkFileUpload() {
	var result = true;
	for(i = incstt - 1; i >= 0; i--) {
		if(document.getElementById('namefile'+ i)) {			
			var valueNameFile1 = document.getElementById('namefile'+ i).value;
			var fileTitle = document.getElementById('titlefile'+ i);
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='vui-long-chon-tap-tin-dinh-kem'/>");
				document.getElementById('namefile'+ i).focus();
				fileTitle.focus();
				result = false;
				break;
			}

			var typeStandard = "xls,html,htm,doc,docx,xlsx,jpg,pmp,pdf";	
			
			if(typeStandard.search(type.toLowerCase()) == -1) {
				alert("<liferay-ui:message key='sai-dinh-dang'/>");
				fileTitle.focus();
				result = false;	
				break;
			}

			if (fileTitle.value.trim() == "") {
				alert("<liferay-ui:message key='vui-long-nhap-tieu-de'/>");
				fileTitle.focus();
				result = false;
				break;
			}
		}
	}
	return result;
}

function selectRadioCapDonVi(value) {
	var divOnChange = window.document.getElementById("donViOnChange");
	document.getElementById('<portlet:namespace/>radioCapDV').value = value;

 	var inner = "";
	DonViThuTucDWRClient.getListDonViThuTuc(document.getElementById('<portlet:namespace/>radioCapDV').value, function(data){
		if (data.length > 0) {
			inner += "<select name='<portlet:namespace />maDonViThuTuc' id='maDonViThuTuc' style='width: 18%;' >";
				inner += "<option value='0'><liferay-ui:message key='khong-chon' /></option>";
				for ( var i = 0; i < data.length; i++) {		
					inner += "<option value='" + data[i].maDonViThuTuc + "'>" + data[i].tenDonViThuTuc + "</option>";
				}
			inner += "</select>";
		}
		else {
		}
		divOnChange.innerHTML = inner;
	});
}

function selectCapDonVi(value) {
	var divOnChange = window.document.getElementById("donViOnChange");
	var displayTermsMaDV = document.getElementById("<portlet:namespace/>displayTermsMaDV").value;
	document.getElementById('<portlet:namespace/>radioCapDV').value = value;
 	var inner = "";
	DonViThuTucDWRClient.getListDonViThuTuc(document.getElementById('<portlet:namespace/>radioCapDV').value, function(data){
		if (data.length > 0) {
			inner += "<select name='<portlet:namespace />donViThuTuc' id='maDonViThuTuc' style='width: 100%;' >";
				inner += "<option value='0'><liferay-ui:message key='tat-ca' /></option>";
				for ( var i = 0; i < data.length; i++) {
					var selected = "";		
					if (displayTermsMaDV == data[i].maDonViThuTuc) {
						selected = "selected";
					}
					inner += "<option " + selected + " value='" + data[i].maDonViThuTuc + "'>" + data[i].tenDonViThuTuc + "</option>";
				}
			inner += "</select>";
		}
		else {
		}
		divOnChange.innerHTML = inner;
	});
}

function setDisplayTermsMaDV(value) {
	document.getElementById("<portlet:namespace/>displayTermsMaDV").value = value; 
}
/*/get hostname of web
 * 
 */
function getHostName(elementA, value) {
	elementA.setAttribute("href","http://" + window.location.host + value );
}


</script>
