<%@ include file="/html/portlet/nss/tintonghop/init.jsp" %>

<%
List results = (List)request.getAttribute("view.jsp-results");

int assetIndex = ((Integer)request.getAttribute("view.jsp-assetIndex")).intValue();

TagsAsset asset = (TagsAsset)request.getAttribute("view.jsp-asset");

String title = (String)request.getAttribute("view.jsp-title");
String viewURL = (String)request.getAttribute("view.jsp-viewURL");
String cssClassName = StringPool.BLANK;

String className = (String)request.getAttribute("view.jsp-className");
long classPK = ((Long)request.getAttribute("view.jsp-classPK")).longValue();

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", false);

long selectPlId = 0;
if (asset.getCategories().size() > 0 ) {
	long vocabularyId = asset.getCategories().get(0).getVocabularyId();
	selectPlId = GetterUtil.getLong(preferences.getValue(String.valueOf(vocabularyId), StringPool.BLANK));
}

//lay gia tri cua layoutid

List<com.liferay.portal.model.PortletPreferences> pPlIds = new ArrayList<com.liferay.portal.model.PortletPreferences>();
try {
	pPlIds = PortletPreferencesLocalServiceUtil.getPortletPreferencesByPlid(selectPlId);
} catch (Exception e) {
}

String portletAssetPublisher = "NSS_ASSET_PUBLISHER";
for (int i = 0; i < pPlIds.size(); i++) {
	if(pPlIds.get(i).getPortletId().contains("NSS_ASSET_PUBLISHER_INSTANCE")) {
		portletAssetPublisher =  pPlIds.get(i).getPortletId();
		break;
	}
}

PortletURL viewFullContentURL = new PortletURLImpl(request, portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
viewFullContentURL.setParameter("struts_action", "/nss/asset_publisher/view_content");
viewFullContentURL.setParameter("assetId", String.valueOf(asset.getAssetId()));

if (className.equals(BlogsEntry.class.getName())) {
	BlogsEntry entry = BlogsEntryLocalServiceUtil.getEntry(classPK);

	if (Validator.isNull(title)) {
		title = entry.getTitle();
	}

	String urlTitle = entry.getUrlTitle();

	if (Validator.isNotNull(urlTitle)) {
		viewFullContentURL.setParameter("urlTitle", urlTitle);
	}

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_BLOG);

	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/blogs/find_entry?noSuchEntryRedirect=" + HttpUtil.encodeURL(viewFullContentURL.toString()) + "&entryId=" + entry.getEntryId() : viewFullContentURL.toString();
	cssClassName = AssetPublisherUtil.TYPE_BLOG;
}
else if (className.equals(BookmarksEntry.class.getName())) {
	BookmarksEntry entry = BookmarksEntryLocalServiceUtil.getEntry(classPK);

	if (Validator.isNull(title)) {
		title = entry.getName();
	}

	String entryURL = themeDisplay.getPathMain() + "/bookmarks/open_entry?entryId=" + entry.getEntryId();

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_BOOKMARK);

	viewURL = viewInContext ? entryURL : viewFullContentURL.toString();
	cssClassName = AssetPublisherUtil.TYPE_BOOKMARK;
}
else if (className.equals(DLFileEntry.class.getName())) {
	DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(classPK);

	if (Validator.isNull(title)) {
		StringBuilder sb = new StringBuilder();

		sb.append("<img align=\"left\" border=\"0\" src=\"");
		sb.append(themeDisplay.getPathThemeImages());
		sb.append("/document_library/");
		sb.append(DLUtil.getFileExtension(fileEntry.getName()));
		sb.append(".png\" />");
		sb.append(fileEntry.getTitle());

		title = sb.toString();
	}

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_DOCUMENT);

	viewURL = viewInContext ? themeDisplay.getPathMain() + "/document_library/get_file?p_l_id=" + themeDisplay.getPlid() + "&folderId=" + fileEntry.getFolderId() + "&name=" + HttpUtil.encodeURL(fileEntry.getName()) : viewFullContentURL.toString();
	cssClassName = AssetPublisherUtil.TYPE_DOCUMENT;
}
else if (className.equals(IGImage.class.getName())) {
	IGImage image = IGImageLocalServiceUtil.getImage(classPK);

	PortletURL imageURL = new PortletURLImpl(request, PortletKeys.IMAGE_GALLERY, plid, PortletRequest.RENDER_PHASE);

	imageURL.setWindowState(WindowState.MAXIMIZED);

	imageURL.setParameter("struts_action", "/image_gallery/view");
	imageURL.setParameter("folderId", String.valueOf(image.getFolderId()));

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_IMAGE);

	viewURL = viewInContext ? imageURL.toString() : viewFullContentURL.toString();
	cssClassName = AssetPublisherUtil.TYPE_IMAGE;
}
else if (className.equals(JournalArticle.class.getName())) {
	JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

	String languageId = LanguageUtil.getLanguageId(request);

	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

	if (articleDisplay != null) {
		if (Validator.isNull(title)) {
			title = articleDisplay.getTitle();
		}

		viewFullContentURL.setParameter("urlTitle", articleDisplay.getUrlTitle());
		viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_CONTENT);

		viewURL = viewFullContentURL.toString();
		cssClassName = AssetPublisherUtil.TYPE_CONTENT;
	}
	else {
		show = false;
	}
}
else if (className.equals(MBMessage.class.getName())) {
	MBMessage message = MBMessageLocalServiceUtil.getMBMessage(classPK);

	viewFullContentURL.setParameter("type", "thread");

	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/message_boards/find_message?messageId=" + message.getMessageId() : viewFullContentURL.toString();
	cssClassName = "thread";
}
else if (className.equals(WikiPage.class.getName())) {
	WikiPageResource pageResource = WikiPageResourceLocalServiceUtil.getPageResource(classPK);

	WikiPage wikiPage = WikiPageLocalServiceUtil.getPage(pageResource.getNodeId(), pageResource.getTitle());

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_WIKI);

	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/wiki/find_page?pageResourcePrimKey=" + wikiPage.getResourcePrimKey() : viewFullContentURL.toString();
	cssClassName = AssetPublisherUtil.TYPE_WIKI;
}

viewURL = _checkViewURL(viewURL, currentURL, themeDisplay);
%>

	<c:if test="<%= assetIndex == 0 %>">
		<div class="toptitlerighthidden">
	    <!-- <h3 class="h3hidden"><liferay-ui:message key="Tin-moi-nhat" /></h3> -->
	    <div class="btmtitlerighthidden">
	    <div class="ctrtitlerighthidden">
		<ul class="title-list">
	</c:if>
	<c:if test="<%= show %>">
		<li class="title-list <%= cssClassName %>">
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL) %>">
					<a href="<%= viewURL %>"><%= title %></a> <font class="leddmy"><%=df1.format(asset.getPublishDate()) %></font>
				</c:when>
				<c:otherwise>
					<%= title %> <font class="leddmy"><%=df1.format(asset.getPublishDate()) %></font>
				</c:otherwise>
			</c:choose>

			<liferay-util:include page="/html/portlet/nss/tintonghop/asset_actions.jsp" />
			<div class="asset-metadata">
				<%@ include file="/html/portlet/nss/tintonghop/asset_metadata.jspf" %>
			</div>
		</li>
	</c:if>
	<c:if test="<%= (assetIndex + 1) == results.size() %>">
		</ul>
		</div>
		</div>
		</div>
	</c:if>
