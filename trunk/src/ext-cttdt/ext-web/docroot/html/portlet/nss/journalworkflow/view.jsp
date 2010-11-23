<%@ include file="/html/portlet/nss/journalworkflow/init.jsp" %>
<%@ include file="/html/portlet/nss/journalworkflow/workflow_action.jspf" %>


<div>
	<%	
		String defaultTab = "";
		if (userTaskNodeList.size() > 0) {
			defaultTab = userTaskNodeList.get(0);
		}
		String tabs1 = ParamUtil.getString(renderRequest, "tabs1", defaultTab);
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("tabs1", tabs1);
		String currentURL = themeDisplay.getURLCurrent();
		ArticleSearchExt searchContainer = new ArticleSearchExt(renderRequest, portletURL);
		searchContainer.setDelta(delta);
		List headerNames = searchContainer.getHeaderNames();
		headerNames.remove(2);
		//headerNames.add(2, "status");
		headerNames.add(StringPool.BLANK);
	%>
<form action="<%=portletURL.toString() %>" method="post" name="<portlet:namespace/>fm1">
	<liferay-ui:tabs portletURL="<%=portletURL %>" names="<%=prepareForTabs(userTaskNodeList) %>"  >
		<% //for (int i = 0; i < userTaskNodeList.size(); i++) {
			if (!tabs1.equals("")) {
		%>
				<input name="<portlet:namespace />groupId" type="hidden" value="" />
				<input name="<portlet:namespace />deleteArticleIds" type="hidden" value="" />
				<input name="<portlet:namespace />expireArticleIds" type="hidden" value="" />
		
				<%
			
			
					//searchContainer.setRowChecker(new RowChecker(renderResponse));
				%>
				<%
					ArticleSearchTerms searchTerms = (ArticleSearchTerms)searchContainer.getSearchTerms();
				%>
		
				<%
					int total = 0;
					
					//List<InstanceBean> instanceBeans = InstanceBeanUtil.findByStatus_Finish(userTaskNodeList.get(i), false);
					List<InstanceBean> instanceBeans = InstanceBeanLocalServiceUtil.findByStatus_Finish(tabs1.replaceAll("_", " "), false);
					total = instanceBeans.size();
					
					searchContainer.setTotal(total);
					
					List results = null;
					
					results = ArticleUtil.getArticles(searchContainer.getStart(), searchContainer.getEnd(), instanceBeans);
					
					searchContainer.setResults(results);
				%>
		
				<br /><br />
		
				<%
					List resultRows = searchContainer.getResultRows();
		
					for (int j = 0; j < results.size(); j++) {
						JournalArticle article = (JournalArticle)results.get(j);
		
						article = article.toEscapedModel();
		
						ResultRow row = new ResultRow(article, article.getArticleId() + EditArticleAction.VERSION_SEPARATOR + article.getVersion(), j);
		
						PortletURL rowURL = new PortletURLImpl(request, "NSS_JOURNAL", plid, PortletRequest.RENDER_PHASE);
		
						rowURL.setWindowState(WindowState.MAXIMIZED);
		
						rowURL.setParameter("struts_action", "/nss/journal/edit_article");
						rowURL.setParameter("redirect", currentURL);
						rowURL.setParameter("instanceId", String.valueOf(InstanceBeanLocalServiceUtil.getInstanceId(article)));
						rowURL.setParameter("groupId", String.valueOf(article.getGroupId()));
						rowURL.setParameter("articleId", article.getArticleId());
						rowURL.setParameter("version", String.valueOf(article.getVersion()));
						
						// Article id
		
						row.addText(article.getArticleId(), rowURL);
		
						// Title
		
						row.addText(article.getTitle(), rowURL);
		
						// Version
		
						//row.addText(String.valueOf(article.getVersion()), rowURL);
		
						// Status
		
						//String status = null;
		
						//if (article.isExpired()) {
						//	status = "expired";
						//}
						//else if (article.isApproved()) {
						//	status = "approved";
						//}
						//else {
						//	status = "not-approved";
						//}
		
						//row.addText(LanguageUtil.get(pageContext, status), rowURL);
		
						// Modified date
		
						row.addText(dateFormatDateTime.format(article.getModifiedDate()), rowURL);
		
						// Display date
		
						row.addText(dateFormatDateTime.format(article.getDisplayDate()), rowURL);
		
						// Author
		
						row.addText(PortalUtil.getUserName(article.getUserId(), article.getUserName()), rowURL);
		
						// Add result row
		
						resultRows.add(row);
					}
				%>
		
				<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		<%
			}
		//} %>
	</liferay-ui:tabs>
</form>
</div>