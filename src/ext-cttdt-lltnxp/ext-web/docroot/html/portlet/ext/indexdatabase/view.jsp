<%@ include file="/html/portlet/ext/indexdatabase/init.jsp" %>
<%@ include file="/html/portlet/ext/indexdatabase/js/indexutil.jsp" %>
<div class="title_categ"><liferay-ui:message key="danh-chi-muc-van-ban"/></div>
<div class="boxcontent">
<liferay-ui:tabs names="index-document">
<div class="boxcontent_Tab">
	<input type="button" value='<liferay-ui:message key="reindex-cong-van-den"/>' onclick="<portlet:namespace/>reindexDocumentReceipts('<liferay-ui:message key="loading"/>');"/>&nbsp;
	<input type="button" value='<liferay-ui:message key="reindex-cong-van-di"/>' onclick="<portlet:namespace/>reindexDocumentSends('<liferay-ui:message key="loading"/>');"/>
</div>
</liferay-ui:tabs>
</div>