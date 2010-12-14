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
<%
long userId = ParamUtil.getLong(request,"userId",0);
String articleIds = ParamUtil.getString(request,"articleIds");
String backURL = ParamUtil.getString(request,"backURL");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("struts_action", "/nss/thong_ke_tin/view");
portletURL.setParameter(com.liferay.portal.kernel.util.Constants.CMD, "detailArticle");
portletURL.setParameter("backURL",backURL);
portletURL.setParameter("articleIds",articleIds);
%>
<% 
String[] articleIdArray = articleIds.split(",");
List<JournalArticle> articles = new ArrayList<JournalArticle>();
for(String str : articleIdArray){
	articles.add(JournalArticleLocalServiceUtil.getArticle(Long.parseLong(str)));
}
DateFormat dateFormat = new SimpleDateFormat("hh:mm dd-MM-yyyy");
%>
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
		<liferay-ui:search-container-column-text name="Id" value="<%= article.getArticleId() %>" href="<%= ac %>" />
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
		<liferay-ui:search-container-column-text name="Ten" value="<%= article.getTitle() %>" href="<%= ac %>" />

		<liferay-ui:search-container-column-text name="Trang thai" value="<%= com.liferay.portal.kernel.language.LanguageUtil.get(pageContext, status) %>" href="<%= ac %>" />
			
		<liferay-ui:search-container-column-text name="Ngay sua" value="<%= dateFormat.format(article.getModifiedDate()) %>" href="<%= ac %>" />
		
		<liferay-ui:search-container-column-text name="Ngay xuat " value="<%= dateFormat.format(article.getDisplayDate()) %>" href="<%= ac %>" />
		
		<liferay-ui:search-container-column-text name="So anh su dung" value="<%= String.valueOf(WorkflowJournalArticleLocalServiceUtil.getWorkflowJournalArticle(article.getResourcePrimKey()).getCountImageOfArticle()) %>" href="<%= ac %>" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>
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