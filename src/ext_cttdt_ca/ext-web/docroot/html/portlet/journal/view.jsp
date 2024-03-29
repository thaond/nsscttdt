<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "web-content");
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("struts_action", "/journal/view");
portletURL.setParameter("tabs1", tabs1);
%>

<script type="text/javascript">
	function <portlet:namespace />deleteArticles() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-web-content") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />groupId.value = "<%= scopeGroupId %>";
			document.<portlet:namespace />fm.<portlet:namespace />deleteArticleIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal/edit_article" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}

	function <portlet:namespace />deleteFeeds() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-feeds") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />groupId.value = "<%= scopeGroupId %>";
			document.<portlet:namespace />fm.<portlet:namespace />deleteFeedIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal/edit_feed" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}

	function <portlet:namespace />deleteStructures() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-structures") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />groupId.value = "<%= scopeGroupId %>";
			document.<portlet:namespace />fm.<portlet:namespace />deleteStructureIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal/edit_structure" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}

	function <portlet:namespace />deleteTemplates() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-templates") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />groupId.value = "<%= scopeGroupId %>";
			document.<portlet:namespace />fm.<portlet:namespace />deleteTemplateIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal/edit_template" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}

	function <portlet:namespace />expireArticles() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-expire-the-selected-web-content") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.EXPIRE %>";
			document.<portlet:namespace />fm.<portlet:namespace />groupId.value = "<%= scopeGroupId %>";
			document.<portlet:namespace />fm.<portlet:namespace />expireArticleIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal/edit_article" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
</script>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="titlecategr_pages"><h4><p><liferay-ui:message key="quan-tri-noi-dung" /></p></h4></div>
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<liferay-ui:tabs
	names="web-content,structures,templates,feeds,recent"
	url="<%= portletURL.toString() %>"
/>
<div class="borderendTab">
<c:choose>
	<c:when test='<%= tabs1.equals("web-content") %>'>
		<input name="<portlet:namespace />groupId" type="hidden" value="" />
		<input name="<portlet:namespace />deleteArticleIds" type="hidden" value="" />
		<input name="<portlet:namespace />expireArticleIds" type="hidden" value="" />

		<%
		ArticleSearch searchContainer = new ArticleSearch(renderRequest, portletURL);

		List headerNames = searchContainer.getHeaderNames();

		headerNames.add(3, "status");
		headerNames.add(StringPool.BLANK);

		searchContainer.setRowChecker(new RowChecker(renderResponse));
		%>

		<liferay-ui:search-form
			page="/html/portlet/journal/article_search.jsp"
			searchContainer="<%= searchContainer %>"
		/>

		<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">

			<%
			ArticleSearchTerms searchTerms = (ArticleSearchTerms)searchContainer.getSearchTerms();
			%>

			<%@ include file="/html/portlet/journal/article_search_results.jspf" %>
			<input type="button" value="<liferay-ui:message key="expire" />" onClick="<portlet:namespace />expireArticles();" />
			<input type="button" value="<liferay-ui:message key="delete" />" onClick="<portlet:namespace />deleteArticles();" />
			<br><br>
			<%
			List resultRows = searchContainer.getResultRows();

			for (int i = 0; i < results.size(); i++) {
				JournalArticle article = (JournalArticle)results.get(i);

				article = article.toEscapedModel();

				ResultRow row = new ResultRow(article, article.getArticleId() + EditArticleAction.VERSION_SEPARATOR + article.getVersion(), i);

				PortletURL rowURL = renderResponse.createRenderURL();

				rowURL.setWindowState(WindowState.NORMAL);

				rowURL.setParameter("struts_action", "/journal/edit_article");
				rowURL.setParameter("redirect", currentURL);
				rowURL.setParameter("groupId", String.valueOf(article.getGroupId()));
				rowURL.setParameter("articleId", article.getArticleId());
				rowURL.setParameter("version", String.valueOf(article.getVersion()));

				// Article id

				row.addText(article.getArticleId(), rowURL);

				// Title

				row.addText(article.getTitle(), rowURL);

				// Version

				row.addText(String.valueOf(article.getVersion()), rowURL);

				// Status

				String status = null;

				if (article.isExpired()) {
					status = "expired";
				}
				else if (article.isApproved()) {
					status = "approved";
				}
				else {
					status = "not-approved";
				}

				row.addText(LanguageUtil.get(pageContext, status), rowURL);

				// Modified date

				row.addText(dateFormatDateTime.format(article.getModifiedDate()), rowURL);

				// Display date

				row.addText(dateFormatDateTime.format(article.getDisplayDate()), rowURL);

				// Author

				row.addText(PortalUtil.getUserName(article.getUserId(), article.getUserName()), rowURL);

				// Action

				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/journal/article_action.jsp");

				// Add result row

				resultRows.add(row);
			}
			%>

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</c:if>
	</c:when>
	<c:when test='<%= tabs1.equals("structures") %>'>
		<input name="<portlet:namespace />groupId" type="hidden" value="" />
		<input name="<portlet:namespace />deleteStructureIds" type="hidden" value="" />
		<liferay-ui:error exception="<%= RequiredStructureException.class %>" message="required-structures-could-not-be-deleted" />

		<%
		StructureSearch searchContainer = new StructureSearch(renderRequest, portletURL);

		List headerNames = searchContainer.getHeaderNames();

		headerNames.add(StringPool.BLANK);

		searchContainer.setRowChecker(new RowChecker(renderResponse));
		%>

		<liferay-ui:search-form
			page="/html/portlet/journal/structure_search.jsp"
			searchContainer="<%= searchContainer %>"
		/>
		<br />
		<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">

			<%
			StructureSearchTerms searchTerms = (StructureSearchTerms)searchContainer.getSearchTerms();
			%>

			<%@ include file="/html/portlet/journal/structure_search_results.jspf" %>
			<input type="button" value="<liferay-ui:message key="delete" />" onClick="<portlet:namespace />deleteStructures();" />

			<br /><br />

			<%
			List resultRows = searchContainer.getResultRows();

			for (int i = 0; i < results.size(); i++) {
				JournalStructure structure = (JournalStructure)results.get(i);

				structure = structure.toEscapedModel();

				ResultRow row = new ResultRow(structure, structure.getStructureId(), i);

				PortletURL rowURL = renderResponse.createRenderURL();

				rowURL.setWindowState(WindowState.NORMAL);

				rowURL.setParameter("struts_action", "/journal/edit_structure");
				rowURL.setParameter("redirect", currentURL);
				rowURL.setParameter("groupId", String.valueOf(structure.getGroupId()));
				rowURL.setParameter("structureId", structure.getStructureId());

				// Structure id

				row.addText(structure.getStructureId(), rowURL);

				// Name and description

				StringBuilder sb = new StringBuilder();

				sb.append(structure.getName());

				if (Validator.isNotNull(structure.getDescription())) {
					sb.append("<br />");
					sb.append(structure.getDescription());
				}

				row.addText(sb.toString(), rowURL);

				// Action

				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/journal/structure_action.jsp");

				// Add result row

				resultRows.add(row);
			}
			%>

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</c:if>
	</c:when>
	<c:when test='<%= tabs1.equals("templates") %>'>
		<input name="<portlet:namespace />groupId" type="hidden" value="" />
		<input name="<portlet:namespace />deleteTemplateIds" type="hidden" value="" />

		<liferay-ui:error exception="<%= RequiredTemplateException.class %>" message="required-templates-could-not-be-deleted" />

		<%
		TemplateSearch searchContainer = new TemplateSearch(renderRequest, portletURL);

		List headerNames = searchContainer.getHeaderNames();

		headerNames.add(StringPool.BLANK);

		searchContainer.setRowChecker(new RowChecker(renderResponse));
		%>

		<liferay-ui:search-form
			page="/html/portlet/journal/template_search.jsp"
			searchContainer="<%= searchContainer %>"
		/>
		<br />
		<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">

			<%
			TemplateSearchTerms searchTerms = (TemplateSearchTerms)searchContainer.getSearchTerms();

			searchTerms.setStructureIdComparator(StringPool.EQUAL);
			%>

			<%@ include file="/html/portlet/journal/template_search_results.jspf" %>
			<input type="button" value="<liferay-ui:message key="delete" />" onClick="<portlet:namespace />deleteTemplates();" />

			<br /><br />

			<%
			List resultRows = searchContainer.getResultRows();

			for (int i = 0; i < results.size(); i++) {
				JournalTemplate template = (JournalTemplate)results.get(i);

				template = template.toEscapedModel();

				ResultRow row = new ResultRow(template, template.getTemplateId(), i);

				PortletURL rowURL = renderResponse.createRenderURL();

				rowURL.setWindowState(WindowState.NORMAL);

				rowURL.setParameter("struts_action", "/journal/edit_template");
				rowURL.setParameter("redirect", currentURL);
				rowURL.setParameter("groupId", String.valueOf(template.getGroupId()));
				rowURL.setParameter("templateId", template.getTemplateId());

				row.setParameter("rowHREF", rowURL.toString());

				// Template id

				row.addText(template.getTemplateId(), rowURL);

				// Name, description, and image

				row.addJSP("/html/portlet/journal/template_description.jsp");

				// Action

				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/journal/template_action.jsp");

				// Add result row

				resultRows.add(row);
			}
			%>

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</c:if>
	</c:when>
	<c:when test='<%= tabs1.equals("feeds") %>'>
		<input name="<portlet:namespace />groupId" type="hidden" value="" />
		<input name="<portlet:namespace />deleteFeedIds" type="hidden" value="" />

		<%
		FeedSearch searchContainer = new FeedSearch(renderRequest, portletURL);

		List headerNames = searchContainer.getHeaderNames();

		headerNames.add(StringPool.BLANK);

		searchContainer.setRowChecker(new RowChecker(renderResponse));
		%>

		<liferay-ui:search-form
			page="/html/portlet/journal/feed_search.jsp"
			searchContainer="<%= searchContainer %>"
		/>

		<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">

			<%
			FeedSearchTerms searchTerms = (FeedSearchTerms)searchContainer.getSearchTerms();
			%>

			<%@ include file="/html/portlet/journal/feed_search_results.jspf" %>
			<input type="button" value="<liferay-ui:message key="delete" />" onClick="<portlet:namespace />deleteFeeds();" />

			<br /><br />

			<%
			List resultRows = searchContainer.getResultRows();

			for (int i = 0; i < results.size(); i++) {
				JournalFeed feed = (JournalFeed)results.get(i);

				feed = feed.toEscapedModel();

				ResultRow row = new ResultRow(feed, feed.getFeedId(), i);

				PortletURL rowURL = renderResponse.createRenderURL();

				rowURL.setWindowState(WindowState.NORMAL);

				rowURL.setParameter("struts_action", "/journal/edit_feed");
				rowURL.setParameter("redirect", currentURL);
				rowURL.setParameter("groupId", String.valueOf(feed.getGroupId()));
				rowURL.setParameter("feedId", feed.getFeedId());

				row.setParameter("rowHREF", rowURL.toString());

				// Feed id

				row.addText(feed.getFeedId(), rowURL);

				// Name and description

				StringBuilder sb = new StringBuilder();

				sb.append(feed.getName());

				if (Validator.isNotNull(feed.getDescription())) {
					sb.append("<br />");
					sb.append(feed.getDescription());
				}

				row.addText(sb.toString(), rowURL);

				// Action

				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/journal/feed_action.jsp");

				// Add result row

				resultRows.add(row);
			}
			%>

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</c:if>
	</c:when>
	<c:when test='<%= tabs1.equals("recent") %>'>
		<%= LanguageUtil.format(pageContext, "this-page-displays-the-last-x-web-content,-structures,-and-templates-that-you-accessed", String.valueOf(JournalUtil.MAX_STACK_SIZE), false) %>

		<br /><br />

		<table class="lfr-table" width="100%">
		<tr>
			<td valign="top" width="33%">
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header" style="font-size: x-small; font-weight: bold;">
					<td colspan="2">
						<%= LanguageUtil.format(pageContext, "last-x-web-content", String.valueOf(JournalUtil.MAX_STACK_SIZE), false) %>
					</td>
				</tr>

				<%
				Stack recentArticles = JournalUtil.getRecentArticles(renderRequest);

				int recentArticlesSize = recentArticles.size();

				for (int i = recentArticlesSize - 1; i >= 0; i--) {
					JournalArticle article = (JournalArticle)recentArticles.get(i);

					article = article.toEscapedModel();

					String className = "portlet-section-body results-row";
					String classHoverName = "portlet-section-body-hover results-row hover";

					if (MathUtil.isEven(i)) {
						className = "portlet-section-alternate results-row alt";
						classHoverName = "portlet-section-alternate-hover results-row alt hover";
					}
				%>

					<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="editArticleURL">
						<portlet:param name="struts_action" value="/journal/edit_article" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="groupId" value="<%= String.valueOf(article.getGroupId()) %>" />
						<portlet:param name="articleId" value="<%= article.getArticleId() %>" />
						<portlet:param name="version" value="<%= String.valueOf(article.getVersion()) %>" />
					</portlet:renderURL>

					<tr class="<%= className %>" style="font-size: x-small;" onMouseEnter="this.className = '<%= classHoverName %>';" onMouseLeave="this.className = '<%= className %>';">
						<td>
							<a href="<%= editArticleURL %>"><%= article.getArticleId() %></a>
						</td>
						<td>
							<a href="<%= editArticleURL %>"><%= article.getTitle() %></a>
						</td>
					</tr>

				<%
				}
				%>

				</table>
			</td>
			<td valign="top" width="33%">
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header" style="font-size: x-small; font-weight: bold;">
					<td colspan="2">
						<%= LanguageUtil.format(pageContext, "last-x-structures", String.valueOf(JournalUtil.MAX_STACK_SIZE), false) %>
					</td>
				</tr>

				<%
				Stack recentStructures = JournalUtil.getRecentStructures(renderRequest);

				int recentStructuresSize = recentStructures.size();

				for (int i = recentStructuresSize - 1; i >= 0; i--) {
					JournalStructure structure = (JournalStructure)recentStructures.get(i);

					structure = structure.toEscapedModel();

					String className = "portlet-section-body results-row";
					String classHoverName = "portlet-section-body-hover results-row hover";

					if (MathUtil.isEven(i)) {
						className = "portlet-section-alternate results-row alt";
						classHoverName = "portlet-section-alternate-hover results-row alt hover";
					}
				%>

					<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="editStructureURL">
						<portlet:param name="struts_action" value="/journal/edit_structure" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
						<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
					</portlet:renderURL>

					<tr class="<%= className %>" style="font-size: x-small;" onMouseEnter="this.className = '<%= classHoverName %>';" onMouseLeave="this.className = '<%= className %>';">
						<td>
							<a href="<%= editStructureURL %>"><%= structure.getId() %></a>
						</td>
						<td>
							<a href="<%= editStructureURL %>"><%= structure.getName() %></a>
						</td>
					</tr>

				<%
				}
				%>

				</table>
			</td>
			<td valign="top" width="33%">
				<table border="0" cellpadding="4" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header" style="font-size: x-small; font-weight: bold;">
					<td colspan="2">
						<%= LanguageUtil.format(pageContext, "last-x-templates", String.valueOf(JournalUtil.MAX_STACK_SIZE), false) %>
					</td>
				</tr>

				<%
				Stack recentTemplates = JournalUtil.getRecentTemplates(renderRequest);

				int recentTemplatesSize = recentTemplates.size();

				for (int i = recentTemplatesSize - 1; i >= 0; i--) {
					JournalTemplate template = (JournalTemplate)recentTemplates.get(i);

					template = template.toEscapedModel();

					String className = "portlet-section-body results-row";
					String classHoverName = "portlet-section-body-hover results-row hover";

					if (MathUtil.isEven(recentTemplatesSize - i - 1)) {
						className = "portlet-section-alternate results-row alt";
						classHoverName = "portlet-section-alternate-hover results-row alt hover";
					}
				%>

					<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="editTemplateURL">
						<portlet:param name="struts_action" value="/journal/edit_template" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
						<portlet:param name="templateId" value="<%= template.getTemplateId() %>" />
					</portlet:renderURL>

					<tr class="<%= className %>" style="font-size: x-small;" onMouseEnter="this.className = '<%= classHoverName %>';" onMouseLeave="this.className = '<%= className %>';">
						<td>
							<a href="<%= editTemplateURL %>"><%= template.getId() %></a>
						</td>
						<td>
							<a href="<%= editTemplateURL %>"><%= template.getName() %></a>
						</td>
					</tr>

				<%
				}
				%>

				</table>
			</td>
		</tr>
		</table>
	</c:when>
</c:choose>
</div>
</form>