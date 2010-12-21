<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.nss.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.journal.model.JournalArticle"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/nss/thong_ke_tin/init.jsp" %>
<style>
#centermain{
	float: left;
	padding-right: 20px;
	width: 95%;
}

</style>
<%
long userId = ParamUtil.getLong(request,"userId",0);
String articleIds = ParamUtil.getString(request,"articleIds");
String backURL = ParamUtil.getString(request,"backURL");
String date_from = ParamUtil.getString(request,"date_from");
String date_to = ParamUtil.getString(request,"date_to");
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("struts_action", "/nss/thong_ke_tin/view");
portletURL.setParameter(com.liferay.portal.kernel.util.Constants.CMD, "detailArticle");
portletURL.setParameter("backURL",backURL);
portletURL.setParameter("articleIds",articleIds);
portletURL.setParameter("date_from",date_from);
portletURL.setParameter("date_to",date_to);
%>
<% 
String[] articleIdArray = articleIds.split(",");
List<JournalArticle> articles = new ArrayList<JournalArticle>();
for(String str : articleIdArray){
	articles.add(JournalArticleLocalServiceUtil.getArticle(Long.parseLong(str)));
}
DateFormat dateFormat = new SimpleDateFormat("hh:mm dd-MM-yyyy");
%>
<liferay-ui:message key="tk-tu-ngay"/> :<%=" "+date_from + " "%><liferay-ui:message key="tk-den-ngay"/> :<%= " "+date_to %>
	<liferay-ui:tabs names="tk-details" backURL="<%= backURL %>"/>
	<liferay-ui:search-container iteratorURL="<%= portletURL %>" delta="20"	emptyResultsMessage="khong-co-thong-ke-nao">
	
		<liferay-ui:search-container-results
		results="<%= com.liferay.portal.kernel.util.ListUtil.subList(articles,searchContainer.getStart(),searchContainer.getEnd()) %>"
		total="<%= articles.size() %>" />
		<% int stt = 1; 
			String ac = "";
			String status = null;
		%>
		<liferay-ui:search-container-row
		className="com.nss.portlet.journal.model.JournalArticle" modelVar="article">
		
		<portlet:renderURL var="edit_article" windowState="<%= com.liferay.portal.kernel.portlet.LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
			<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="edit_aticle" />
			<portlet:param name="articleId" value="<%= String.valueOf(article.getPrimaryKey()) %>" />
		</portlet:renderURL>
		<%ac = "javascript:popUpEditArticle('" + edit_article + "')"; %>
		<liferay-ui:search-container-column-text name="id" value="<%= article.getArticleId() %>" href="<%= ac %>" />
		<%

				if (article.isExpired()) {
					status = "expired";
				}
				else if (article.isApproved()) {
					status = "approved";
				}
				else {
					status = "not-approved";
				}
		%>
		<liferay-ui:search-container-column-text name="name" value="<%= article.getTitle() %>" href="<%= ac %>" />
		
		<liferay-ui:search-container-column-text name="author" value="<%= article.getUserName() %>" href="<%= ac %>" />

		<liferay-ui:search-container-column-text name="status" value="<%= com.liferay.portal.kernel.language.LanguageUtil.get(pageContext, status) %>" href="<%= ac %>" />
			
		<liferay-ui:search-container-column-text name="modified-date" value="<%= dateFormat.format(article.getModifiedDate()) %>" href="<%= ac %>" />
		
		<liferay-ui:search-container-column-text name="display-date" value="<%= dateFormat.format(article.getDisplayDate()) %>" href="<%= ac %>" />
		
		<liferay-ui:search-container-column-text name="nss-tk-so-anh" value="<%= String.valueOf(WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(article.getResourcePrimKey()).getCountImageOfArticle()) %>" href="<%= ac %>" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>
<div class="separator"></div>
<%
PortletURL portletURL1 = renderResponse.createActionURL();
portletURL1.setWindowState(WindowState.NORMAL);

portletURL1.setParameter("struts_action", "/nss/thong_ke_tin/view");
portletURL1.setParameter(com.liferay.portal.kernel.util.Constants.CMD, "detailArticle");
portletURL1.setParameter("backURL",backURL);
portletURL1.setParameter("articleIds",articleIds);
%>
<form action="<%= portletURL1.toString() %>" method="post" name="<portlet:namespace />fm1" onSubmit="submitForm(this); return false;">
<div style="float: right;">
	<input type="hidden" name='<portlet:namespace/>report' value="reportDetails" />
	<input type="hidden" name='<portlet:namespace/>date_from' value="<%= date_from %>" />
	<input type="hidden" name='<portlet:namespace/>date_to' value="<%= date_to %>" />
	<input type="submit" value='<liferay-ui:message key="tk-xuat-report"/>'/>
</div>
</form>
<script type="text/javascript">
function popUpEditArticle(url){
	var popup = new Liferay.Popup(
		{
			title: '<liferay-ui:message key="nss-thong-ke-tin"/>',
			position: ['center',10],
			modal:true,
			width:950,
			height:'auto',
			xy: ['center', 100],
			url: url,
			scroll: 'auto'
		}
	);
}
</script>