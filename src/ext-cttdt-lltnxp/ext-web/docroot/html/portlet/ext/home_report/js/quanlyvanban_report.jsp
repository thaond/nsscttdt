<%@ include file="/html/portlet/ext/home_report/init.jsp" %>

<script type="text/javascript">

function viewListDocumentReport(url) 
{
	jQuery('#<portlet:namespace/>listdocument').load(url);
}

</script>