<portlet:renderURL var="chitiethoso_baocaothang">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/filedetails" />
</portlet:renderURL>
<script type="text/javascript">
function <portlet:namespace />setURLTenSanPham(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />tensanpham").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLTonDauKy(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />tondauky").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLNhanTrongThang(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />nhantrongthang").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLTongCong(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />tongcong").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLSoDungHan(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />sodunghan").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLSoTreHan(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />sotrehan").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLTrongHan(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />tronghan").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLDaTreHan(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />datrehan").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLChinhSuaBoSung(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />chinhsuabosung").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
function <portlet:namespace />setURLTyLeHoSoDungHan(columeName, fileTypeId) {

	document.getElementById("<portlet:namespace />tylehosodunghan").href = "<%= chitiethoso_baocaothang %>&<portlet:namespace />columeName=" + columeName + "&<portlet:namespace />fileTypeId=" + fileTypeId;
}
</script>