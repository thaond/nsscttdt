<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>

<script type="text/javascript">

function viewListDocumentReport(url) 
{
	jQuery('#<portlet:namespace/>listdocument').load(url);
}

</script>