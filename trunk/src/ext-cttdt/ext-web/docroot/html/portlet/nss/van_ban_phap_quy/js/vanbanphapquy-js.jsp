<%@ include file="/html/portlet/nss/van_ban_phap_quy/init.jsp" %>

<script type="text/javascript">
var incstt = 0; // add row

function <portlet:namespace />validateFormVanBanPhapQuy() {
	fileUpload();

	var kyHieuVanBan = document.getElementById('kyHieuVanBan').value;
	var maLoaiVanBan = document.getElementById('maLoaiVanBan').value;
	var maLinhVucVanBan = document.getElementById('maLinhVucVanBan').value;
	var maCoQuanBanHanh = document.getElementById('maCoQuanBanHanh').value;

	if (kyHieuVanBan.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ky-hieu-van-ban"/>');
		document.getElementById("kyHieuVanBan").focus();
		return false;
	}
	if (maLoaiVanBan.trim() == "0") {
		alert('<liferay-ui:message key="vui-long-chon-loai-van-ban"/>');
		document.getElementById("maLoaiVanBan").focus();
		return false;
	}
	if (maLinhVucVanBan.trim() == "0") {
		alert('<liferay-ui:message key="vui-long-chon-linh-vuc-van-ban"/>');
		document.getElementById("maLinhVucVanBan").focus();
		return false;
	}
	if (maCoQuanBanHanh.trim() == "0") {
		alert('<liferay-ui:message key="vui-long-chon-co-quan-ban-hanh"/>');
		document.getElementById("maCoQuanBanHanh").focus();
		return false;
	}
	if (checkFileUpload() == false) {
		return false;
	}

	var ngayCoHieuLuc = document.getElementById('<portlet:namespace/>ngayCoHieuLuc').value;
	var ngayCoHieuLucDate = new Date(ngayCoHieuLuc);
	var ngayHetHieuLuc = document.getElementById('<portlet:namespace/>ngayHetHieuLuc').value;
	var ngayHetHieuLucDate = new Date(ngayHetHieuLuc);

	if (ngayHetHieuLucDate < ngayCoHieuLucDate) {
		alert('<liferay-ui:message key="ngay-het-hieu-luc-phai-lon-hon-hoac-bang-ngay-co-hieu-luc"/>');
		return false;
	}
	else {
		return true;
	}
}

function deleteVanBanPhapQuy(url){
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}

function uploadVanBanPhapQuyFile()
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

function deleteRow(row)
{
	 var i=row.parentNode.parentNode.parentNode.rowIndex;
	 document.getElementById('addfileupload').deleteRow(i);
}

function deleteRowFileUpload(r, id)
{
	var str_filedinhkem = document.getElementById('str_filevanbanphapquytodelete').value;
	str_filedinhkem += id + "/";
	document.getElementById('str_filevanbanphapquytodelete').value = str_filedinhkem;
	
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

/*/get hostname of web
 * 
 */
function getHostName(elementA, value) {
	elementA.setAttribute("href","http://" + window.location.host + value );
}

</script>