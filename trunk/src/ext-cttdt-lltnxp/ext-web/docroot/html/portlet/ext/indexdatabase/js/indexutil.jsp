<%@ include file="/html/portlet/ext/indexdatabase/init.jsp" %>


<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%><script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/IndexUtil.js'></script>
<%
//User user = PortalUtil.getUser(renderRequest);
%>
<script type="text/javascript">
function <portlet:namespace/>reindexDocumentReceipts(msg) {
	dwr.util.useLoadingMessage(msg);
	var companyId = '<%=String.valueOf(user.getCompanyId())%>';
	IndexUtil.reIndexDocumentReceipts(companyId, function(data){
		if (data) {
			alert('<liferay-ui:message key="tao-lai-chi-muc-thanh-cong"/>');
		} else {
			alert('<liferay-ui:message key="tao-lai-chi-muc-khong-thanh-cong"/>');
		}
	});
}

function <portlet:namespace/>reindexDocumentSends(msg) {
	dwr.util.useLoadingMessage(msg);
	var companyId = '<%=String.valueOf(user.getCompanyId())%>';
	IndexUtil.reIndexDocumentSends(companyId, function(data){
		if (data) {
			alert('<liferay-ui:message key="tao-lai-chi-muc-thanh-cong"/>');
		} else {
			alert('<liferay-ui:message key="tao-lai-chi-muc-khong-thanh-cong"/>');
		}
	});
}
</script>
<div></div>