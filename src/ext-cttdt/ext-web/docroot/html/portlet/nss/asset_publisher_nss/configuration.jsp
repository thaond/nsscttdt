<%@page import="java.util.Iterator"%>
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

<%@ include file="/html/portlet/nss/asset_publisher_nss/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>
<%

String tabs2 = ParamUtil.getString(request, "tabs2");

String redirect = ParamUtil.getString(request, "redirect");

String typeSelection = ParamUtil.getString(request, "typeSelection", StringPool.BLANK);

PortletURL configurationRenderURL = renderResponse.createRenderURL();

configurationRenderURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
configurationRenderURL.setParameter("redirect", redirect);
configurationRenderURL.setParameter("backURL", redirect);
configurationRenderURL.setParameter("portletResource", portletResource);

PortletURL configurationActionURL = renderResponse.createActionURL();

configurationActionURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
configurationActionURL.setParameter("redirect", redirect);
configurationActionURL.setParameter("backURL", redirect);
configurationActionURL.setParameter("portletResource", portletResource);
%>



<script type="text/javascript">
	function <portlet:namespace />chooseSelectionStyle() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'selection-style';

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />moveSelectionDown(assetOrder) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'move-selection-down';
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = assetOrder;

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />moveSelectionUp(assetOrder) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'move-selection-up';
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = assetOrder;

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />saveMetadataFields() {
		document.<portlet:namespace />fm.<portlet:namespace />metadataFields.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentMetadataFields);

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectAsset(assetId, assetParentId, assetTitle, assetOrder) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'add-selection';
		document.<portlet:namespace />fm.<portlet:namespace />assetId.value = assetId;
		document.<portlet:namespace />fm.<portlet:namespace />assetParentId.value = assetParentId;
		document.<portlet:namespace />fm.<portlet:namespace />assetTitle.value = assetTitle;
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = assetOrder;

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectionForType(type) {
		document.<portlet:namespace />fm.<portlet:namespace />typeSelection.value = type;
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = -1;

		submitForm(document.<portlet:namespace />fm, '<%= configurationRenderURL.toString() %>');
	}
</script>

<form action="<%= configurationActionURL.toString() %>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<input name="<portlet:namespace />tabs2" type="hidden" value="<%= HtmlUtil.escape(tabs2) %>" />
<input name="<portlet:namespace />typeSelection" type="hidden" value="" />
<input name="<portlet:namespace />assetId" type="hidden" value="" />
<input name="<portlet:namespace />assetParentId" type="hidden" value="" />
<input name="<portlet:namespace />assetTitle" type="hidden" value="" />
<input name="<portlet:namespace />assetOrder" type="hidden" value="-1" />

<c:choose>
	<c:when test="<%= typeSelection.equals(StringPool.BLANK) %>">
		<liferay-ui:message key="asset-selection" />

		<select name="<portlet:namespace />selectionStyle" onchange="<portlet:namespace />chooseSelectionStyle();">
			<option <%= selectionStyle.equals("dynamic") ? " selected=\"selected\"" : "" %> value="dynamic"><liferay-ui:message key="dynamic" /></option>
			<option <%= selectionStyle.equals("manual") ? " selected=\"selected\"" : "" %> value="manual"><liferay-ui:message key="manual" /></option>
		</select>

		<br /><br />

		<c:choose>
			<c:when test='<%= selectionStyle.equals("manual") %>'>
				<liferay-ui:tabs
					names="selection,display-settings"
					formName="fm"
					param="tabs2"
					refresh="<%= false %>"
				>
					<liferay-ui:section>

						<%
						String portletId = portletResource;
						%>

						<%@ include file="/html/portlet/nss/asset_publisher_nss/add_asset.jspf" %>

						<select name="<portlet:namespace/>assetType" onchange="<portlet:namespace />selectionForType(this.options[this.selectedIndex].value);">
							<option value=""><liferay-ui:message key="select-existing" />...</option>

							<%
							for (int i = 0; i < TagsUtil.ASSET_TYPE_CLASS_NAMES.length; i++) {
								if (!TagsUtil.ASSET_TYPE_CLASS_NAMES[i].equals(MBMessage.class.getName()) && !TagsUtil.ASSET_TYPE_CLASS_NAMES[i].equals(WikiPage.class.getName())) {
								%>

									<option value="<%= TagsUtil.ASSET_TYPE_CLASS_NAMES[i] %>"><liferay-ui:message key='<%= "model.resource." + TagsUtil.ASSET_TYPE_CLASS_NAMES[i] %>' /></option>

								<%
								}
							}
							%>

						</select>

						<br /><br />

						<%
						List<Long> deletedAssets = new ArrayList<Long>();

						List<String> headerNames = new ArrayList<String>();

						headerNames.add("type");
						headerNames.add("title");
						headerNames.add(StringPool.BLANK);

						SearchContainer searchContainer = new SearchContainer(renderRequest, new DisplayTerms(renderRequest), new DisplayTerms(renderRequest), SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, configurationRenderURL, headerNames, LanguageUtil.get(pageContext, "no-assets-selected"));

						int total = manualEntries.length;

						searchContainer.setTotal(total);

						List results = ListUtil.fromArray(manualEntries);

						int end = (manualEntries.length < searchContainer.getEnd()) ? manualEntries.length : searchContainer.getEnd();

						results = results.subList(searchContainer.getStart(), end);

						searchContainer.setResults(results);

						List resultRows = searchContainer.getResultRows();

						for (int i = 0; i < results.size(); i++) {
							String assetEntry = (String)results.get(i);

							Document doc = SAXReaderUtil.read(assetEntry);

							Element root = doc.getRootElement();

							int assetOrder = searchContainer.getStart() + i;

							DocUtil.add(root, "asset-order", assetOrder);

							if (assetOrder == (total - 1)) {
								DocUtil.add(root, "last", true);
							}
							else {
								DocUtil.add(root, "last", false);
							}

							String assetType = root.element("asset-type").getText();
							long assetId = GetterUtil.getLong(root.element("asset-id").getText());

							TagsAsset asset = null;

							try {
								asset = TagsAssetLocalServiceUtil.getAsset(assetId);

								asset = asset.toEscapedModel();
							}
							catch (NoSuchAssetException nsae) {
								deletedAssets.add(assetId);

								continue;
							}

							ResultRow row = new ResultRow(doc, null, assetOrder);

							PortletURL rowURL = renderResponse.createRenderURL();

							rowURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
							rowURL.setParameter("redirect", redirect);
							rowURL.setParameter("backURL", redirect);
							rowURL.setParameter("portletResource", portletResource);
							rowURL.setParameter("typeSelection", assetType);
							rowURL.setParameter("assetId", String.valueOf(assetId));
							rowURL.setParameter("assetOrder", String.valueOf(assetOrder));

							// Type

							row.addText(LanguageUtil.get(pageContext, "model.resource." + assetType), rowURL);

							// Title

							if (assetType.equals(IGImage.class.getName())) {
								IGImage image = IGImageLocalServiceUtil.getImage(asset.getClassPK());

								image = image.toEscapedModel();

								StringBuilder sb = new StringBuilder();

								sb.append("<img border=\"1\" src=\"");
								sb.append(themeDisplay.getPathImage());
								sb.append("/image_gallery?img_id=");
								sb.append(image.getSmallImageId());
								sb.append("&t=");
								sb.append(ImageServletTokenUtil.getToken(image.getSmallImageId()));
								sb.append("\" title=\"");
								sb.append(image.getDescription());
								sb.append("\" />");

								row.addText(sb.toString(), rowURL);
							}
							else {
								row.addText(asset.getTitle(), rowURL);
							}

							// Action

							row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/nss/asset_publisher_nss/asset_selection_action.jsp");

							// Add result row

							resultRows.add(row);
						}

						AssetPublisherUtil.removeAndStoreSelection(deletedAssets, preferences);
						%>

						<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

						<br />

						<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
					</liferay-ui:section>
					<liferay-ui:section>
						<%@ include file="/html/portlet/nss/asset_publisher_nss/display_settings.jspf" %>

						<br />

						<input type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveMetadataFields();" />

						<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
					</liferay-ui:section>
				</liferay-ui:tabs>
			</c:when>
			<c:when test='<%= selectionStyle.equals("dynamic") %>'>
				<liferay-ui:tabs
					names="query-logic,display-settings"
					formName="fm"
					param="tabs2"
					refresh="<%= false %>"
				>
					<liferay-ui:section>
						<liferay-ui:tags-error />

						<liferay-ui:message key="asset-type" />

						<select name="<portlet:namespace/>classNameId">
							<option value=""><liferay-ui:message key="all" /></option>

							<%
							TagsAssetType[] assetTypes = TagsAssetServiceUtil.getAssetTypes(themeDisplay.getLocale().toString());

							for (int i = 0; i < assetTypes.length; i++) {
							%>

								<option <%= (classNameId == assetTypes[i].getClassNameId()) ? "selected" : "" %> value="<%= assetTypes[i].getClassNameId() %>"><liferay-ui:message key='<%= "model.resource." + assetTypes[i].getClassName() %>' /></option>

							<%
							}
							%>

						</select>

						<br /><br />
						 
						<!-- add category by triltm -->
						
						<liferay-ui:message key="group-by-tags-within-tags-set" />

						<select name="<portlet:namespace />category">
							<option value=""><liferay-ui:message key="none" /></option>

							<%
							List<TagsVocabulary> vocabularies = TagsVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, TagsEntryConstants.FOLKSONOMY_CATEGORY);
							String idVocabularies = "";
							for (TagsVocabulary vocabulary : vocabularies) {
								idVocabularies += vocabulary.getVocabularyId() + "_";
							}
							idVocabularies = idVocabularies.substring(0, idVocabularies.length() -1);
							for (TagsVocabulary vocabulary : vocabularies) {
							%>

								<option onclick="displayAndHidden('<%= idVocabularies %>', '<%= String.valueOf(vocabulary.getVocabularyId()) %>')" <%= category.equals(vocabulary.getName()) ? "selected" : "" %> value="<%= vocabulary.getName() %>"><%= vocabulary.getName() %></option>

							<%
							}
							%>

						</select>
						
						<!-- minhnv 20100813 -->
						
						<liferay-ui:message key="chon-trang-hien-thi" /> 
						
						<%
							PortletPreferences preferencesLayout = renderRequest.getPreferences();
							
							String portletResourceLayout = ParamUtil.getString(request, "portletResource");
							
							if (Validator.isNotNull(portletResource)) {
								preferencesLayout = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResourceLayout);
							}
							
							long rootLayoutId = GetterUtil.getLong(preferencesLayout.getValue("root-layout-id", StringPool.BLANK));
							
							int displayDepth = GetterUtil.getInteger(preferencesLayout.getValue("display-depth", StringPool.BLANK));
							boolean includeRootInTree = GetterUtil.getBoolean(preferencesLayout.getValue("include-root-in-tree", StringPool.BLANK));
							boolean showCurrentPage = GetterUtil.getBoolean(preferencesLayout.getValue("show-current-page", StringPool.BLANK));
							boolean useHtmlTitle = GetterUtil.getBoolean(preferencesLayout.getValue("use-html-title", StringPool.BLANK));
							boolean showHiddenPages = GetterUtil.getBoolean(preferencesLayout.getValue("show-hidden-pages", StringPool.BLANK));
							
							if (rootLayoutId == LayoutConstants.DEFAULT_PARENT_LAYOUT_ID) {
								includeRootInTree = false;
							}
						
							List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), layout.isPrivateLayout(), rootLayoutId);

							StringBuilder sb = new StringBuilder();
							sb.append("<select name='selectPlId'>");
							sb.append("<option selected='selected' value='0'><liferay-ui:message key='none' /></option>");
							_buildSiteMap(selectPlId, layout, rootLayouts, rootLayoutId, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, 1, themeDisplay, sb);
							sb.append("</select>");	
							%>
							<%= sb.toString() %>
					<%!
						private void _buildLayoutView(long selectPlId, Layout layout, String cssClass, boolean useHtmlTitle, ThemeDisplay themeDisplay, StringBuilder sb) throws Exception {
							sb.append("<option value=\"");
							sb.append(layout.getPlid());
							sb.append("\" ");
							if (layout.getPlid() == selectPlId) {
								sb.append(" selected='selected' ");
							}
							sb.append(" > ");
							
							String layoutName = layout.getName(themeDisplay.getLocale());
						
							if (useHtmlTitle) {
								layoutName = layout.getHTMLTitle(themeDisplay.getLocale());
							}
						
							sb.append(layoutName);
							sb.append("</option>");
						}
						
						private void _buildSiteMap(long selectPlId, Layout layout, List<Layout> layouts, long rootLayoutId, boolean includeRootInTree, int displayDepth, boolean showCurrentPage, boolean useHtmlTitle, boolean showHiddenPages, int curDepth, ThemeDisplay themeDisplay, StringBuilder sb) throws Exception {
							if (layouts.size() == 0) {
								return;
							}
						
							PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
							boolean showRoot = (rootLayoutId > 0) && (curDepth == 1) && includeRootInTree;
						
							if (showRoot) {
								Layout rootLayout = LayoutLocalServiceUtil.getLayout(layout.getGroupId(), layout.isPrivateLayout(), rootLayoutId);
						
								String cssClass = "root";
						
								if (rootLayout.getPlid() == layout.getPlid()) {
									cssClass += " current";
								}
						
								_buildLayoutView(selectPlId,rootLayout, cssClass, useHtmlTitle, themeDisplay, sb);
						
							}
						
							for (int i = 0; i < layouts.size(); i++) {
								Layout curLayout = layouts.get(i);
						
								if ((showHiddenPages || !curLayout.isHidden()) && LayoutPermissionUtil.contains(permissionChecker, curLayout, ActionKeys.VIEW)) {
									String cssClass = StringPool.BLANK;
						
									if (curLayout.getPlid() == layout.getPlid()) {
										cssClass = "current";
									}
						
									_buildLayoutView(selectPlId, curLayout, cssClass, useHtmlTitle, themeDisplay, sb);
						
									if ((displayDepth == 0) || (displayDepth > curDepth)) {
										_buildSiteMap(selectPlId, layout, curLayout.getChildren(), rootLayoutId, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, curDepth + 1, themeDisplay, sb);
									}
								}
							}
						}
					%>
					
				<!-- MoNT start 17/11/2010 -->
					Tin abstract 
					<% int countAbstract = Integer.parseInt(valueAbstract); %>
					<select name="valueAbstract">
					<%for(int i=1;i<=5;i++){%>
						<% if(countAbstract==i){ %>
						<option value="<%=i %>" selected="selected"><%=i %></option>		
						<%}else{%>
						<option value="<%=i %>" ><%=i %></option>	
						<%}%>			
					<%}%>
					</select>
					Tin lien quan
					<% int countChildren = Integer.parseInt(valueChildren); %>
					<select name="valueChildren">
					<%for(int i=1;i<=10;i++){%>
						<% if(countChildren==i){ %>
						<option value="<%=i %>" selected="selected"><%=i %></option>		
						<%}else{%>
						<option value="<%=i %>" ><%=i %></option>	
						<%}%>			
					<%}%>
					</select>
				<!-- MoNT end 17/11/2010 -->	
					
					 <br/> <br/>
					<%
					//List<TagsVocabulary> vocabularies = TagsVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, TagsEntryConstants.FOLKSONOMY_CATEGORY);
				    List<TagsEntry> tagsEntrys = new ArrayList<TagsEntry>();
				   
				    for (TagsVocabulary vocabulary : vocabularies) {
				    	try {
					    	tagsEntrys= JournalProcessDefinitionLocalServiceUtil.getListTagsEntry(vocabulary.getVocabularyId());
					
					 if (category.equals(vocabulary.getName())) {
					%>
						<div id="<%= vocabulary.getVocabularyId()%>" style="display: inline;">
					<%	 
					 } else {
					%>
					<div id="<%= vocabulary.getVocabularyId()%>" style="display: none">
					<%
					 }
					 for(int j=0;j<tagsEntrys.size();j++){
						 TagsEntry tE=tagsEntrys.get(j);
						//for (TagsEntry tE: tagsEntrys) {
					%>		
						<label><%= tE.getName().concat(":        ") %></label>
						<liferay-ui:message key="chon-trang-hien-thi" />: 
						<%
						long  tEPreferences = GetterUtil.getLong(preferences.getValue(String.valueOf(tE.getEntryId()), StringPool.BLANK));
						
						sb = new StringBuilder(); 
						sb.append("<select name=\"");
						sb.append(tE.getEntryId());
						sb.append("\" ");
						sb.append("<option selected='selected' value='0'><liferay-ui:message key='none' /></option>");
						_buildSiteMap(tEPreferences, layout, rootLayouts, rootLayoutId, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, 1, themeDisplay, sb);
						sb.append("</select>");	
						%>
						<%= sb.toString() %>
						
				<!-- MoNT start 19/11/2010 -->
						Tin abstract Entry
						<select name="valueAbstractEntry<%=tE.getEntryId() %>">
						<% Iterator<Map.Entry<String,String>> iteratorAbstractEntry = mapValueAbstractEntry.entrySet().iterator();
							while(iteratorAbstractEntry.hasNext()){
								Map.Entry<String,String> entry = iteratorAbstractEntry.next();
								String key= entry.getKey();
								int entryId= Integer.parseInt(key);
								String value= entry.getValue();
								int entryValue= Integer.parseInt(value);
						%>
								<% for(int i=1;i<=5;i++){ %>
									<option value="<%=i %>" <%= entryValue == i ? "selected" :" " %>> <%=i %></option>
								<%}%>
						<%}%>
					
						</select>
						
						Tin lien quan Entry
						<select name="valueChildrenEntry<%=tE.getEntryId() %>">
						<% Iterator<Map.Entry<String,String>> iteratorChildrenEntry = mapValueChildrenEntry.entrySet().iterator();%>
						<% while(iteratorChildrenEntry.hasNext()){ 
							Map.Entry<String,String> entry = iteratorChildrenEntry.next();
							String key= entry.getKey();
							int entryId= Integer.parseInt(key);
							String value= entry.getValue();
							int entryValue= Integer.parseInt(value);
							%>
								<% for(int i=1;i<=5;i++){ %>
									<option value="<%=i %>" <%= entryValue == i ? "selected" :" " %>> <%=i %></option>
								<%}%>
						<%}%>
						</select>
					
				<!-- MoNT end 19/11/2010 -->
				
						 <br/> <br/>
					<%	
						}
					%>
					</div>
					
					<%    	
					    } catch (Exception e) {}
				    }
				    
					
					%>		
				
				<!-- end minhnv 20100813 -->			

						<liferay-ui:message key="displayed-content-must-contain-the-following-categories" />

						<br /><br />
						<liferay-ui:tags-selector
							hiddenInput="tagsCategories"
							curTags="<%= StringUtil.merge(tagsCategories) %>"
							folksonomy="<%= false %>"
							focus="<%= false %>"
						/>
						
						<br /><br />
						
						<liferay-ui:message key="displayed-content-must-not-contain-the-following-categories" />

						<br /><br />
						
						<liferay-ui:tags-selector
							hiddenInput="notTagsCategories"
							curTags="<%= StringUtil.merge(notTagsCategories) %>"
							folksonomy="<%= false %>"
							focus="<%= false %>"
						/>

						<!-- end category by triltm -->
						
						
						
						<br /><br />

						<liferay-ui:message key="include-tags-specified-in-the-url" />

						<liferay-ui:input-checkbox param="mergeUrlTags" defaultValue="<%= mergeUrlTags %>" />

						<br /><br />

						<liferay-ui:message key="search-operator" />

						<select name="<portlet:namespace />andOperator">
							<option <%= andOperator ? "selected" : "" %> value="1"><liferay-ui:message key="and" /></option>
							<option <%= !andOperator ? "selected" : "" %> value="0"><liferay-ui:message key="or" /></option>
						</select>
					</liferay-ui:section>
					<liferay-ui:section>
						<%@ include file="/html/portlet/nss/asset_publisher_nss/display_settings.jspf" %>
					</liferay-ui:section>
				</liferay-ui:tabs>

				<br />

				<input type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveMetadataFields();" />

				<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</c:when>
		</c:choose>
	</c:when>
	<c:when test="<%= typeSelection.equals(BlogsEntry.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= BlogsEntry.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + BlogsEntry.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_blogs_entry.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(BookmarksEntry.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= BookmarksEntry.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + BookmarksEntry.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_bookmarks_entry.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(DLFileEntry.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= DLFileEntry.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + DLFileEntry.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_document_library_file_entry.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(IGImage.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= IGImage.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + IGImage.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_image_gallery_image_entry.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(JournalArticle.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= JournalArticle.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + JournalArticle.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_journal_article.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(MBMessage.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= MBMessage.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + MBMessage.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_message_boards_message.jspf" %>
	</c:when>
	<c:when test="<%= typeSelection.equals(WikiPage.class.getName()) %>">
		<input name="<portlet:namespace />assetType" type="hidden" value="<%= WikiPage.class.getName() %>" />

		<liferay-ui:message key="select" />: <liferay-ui:message key='<%= "model.resource." + WikiPage.class.getName() %>' />

		<br /><br />

		<%@ include file="/html/portlet/nss/asset_publisher_nss/select_wiki_page.jspf" %>
	</c:when>
</c:choose>

</form>

<script>
	function displayAndHidden(listVocabularieIds, idVocabularieId) {
	 var lVArray = listVocabularieIds.split("_");
	 for (i = 0; i < lVArray.length; i++) {
		 document.getElementById(lVArray[i]).style.display = "none";
	 } 
	 document.getElementById(idVocabularieId).style.display = "inline";
	}
</script>