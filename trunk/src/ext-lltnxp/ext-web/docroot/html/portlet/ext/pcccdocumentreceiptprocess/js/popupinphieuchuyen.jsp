<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>

<script type="text/javascript">


function <portlet:namespace />inDSPhieuChuyen(url) {
	var documentReceiptIdsValue = document.<portlet:namespace />fm.<portlet:namespace />documentReceiptIdList.value; 
	documentReceiptIdsValue = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");

	if ("" == documentReceiptIdsValue || "on" == documentReceiptIdsValue) {
		alert("<liferay-ui:message key='vui-long-chon-van-ban' />");
		return false;
	}
	document.<portlet:namespace />fm.<portlet:namespace />documentReceiptIdList.value = documentReceiptIdsValue;

	url += "&documentReceiptIdList=" + document.<portlet:namespace />fm.<portlet:namespace />documentReceiptIdList.value;

	// cho phan popup chon receiver
	var extWin = window.open(url, 'extendwin', 'directories=no, height=400, location=no, menubar=no, resizable=yes, scrollbars=yes, status=no, toolbar=no, width=1000');
	extWin.focus();
}

</script>