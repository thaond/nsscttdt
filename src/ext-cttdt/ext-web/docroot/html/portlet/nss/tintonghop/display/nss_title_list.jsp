<%
List results1 = (List)request.getAttribute("view.jsp-results");

int assetIndex1 = ((Integer)request.getAttribute("view.jsp-assetIndex")).intValue();

TagsAsset asset1 = (TagsAsset)request.getAttribute("view.jsp-asset");

String title1 = (String)request.getAttribute("view.jsp-title");
String viewURL1 = (String)request.getAttribute("view.jsp-viewURL");
String cssClassName1 = StringPool.BLANK;

String className1 = (String)request.getAttribute("view.jsp-className");
long classPK1 = ((Long)request.getAttribute("view.jsp-classPK")).longValue();

boolean show1 = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", false);

// phmphuc update 19/07/2010
long vocabularyId = asset.getCategories().get(0).getVocabularyId();
long selectPlId = GetterUtil.getLong(preferences.getValue(String.valueOf(vocabularyId), StringPool.BLANK));

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
// phmphuc end 19/07/2010

PortletURL viewFullContentURL = new PortletURLImpl(request,portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
viewFullContentURL.setParameter("struts_action", "/nss/asset_publisher/view_content");
viewFullContentURL.setParameter("assetId", String.valueOf(asset1.getAssetId()));

	JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK1);

	String languageId = LanguageUtil.getLanguageId(request);

	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

	if (articleDisplay != null) {
		if (Validator.isNull(title1)) {
			title1 = articleDisplay.getTitle();
		}

		PortletURL articleURL = new PortletURLImpl(request,portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
		articleURL.setParameter("struts_action", "/nss/asset_publisher/view_content");
		articleURL.setParameter("urlTitle", articleDisplay.getUrlTitle());
		articleURL.setParameter("type", AssetPublisherUtil.TYPE_CONTENT);

		viewURL1 = articleURL.toString();
		cssClassName1 = AssetPublisherUtil.TYPE_CONTENT;
	}
	else {
		show1 = false;
	}

viewURL1 = _checkViewURL(viewURL1, currentURL, themeDisplay);
%>
<div class="listnewsmore">
	<c:if test="<%= assetIndex1 == 0 %>">
		<ul class="title-list">
	</c:if>

	<c:if test="<%= show1 %>">
		<li>
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL1) %>">
					<a href="<%= viewURL1 %>"><%= title1 %></a> <font class="leddmy"><%=df1.format(asset.getPublishDate()) %></font>
				</c:when>
				<c:otherwise>
					<%= title1 %> <font class="leddmy"><%=df1.format(asset.getPublishDate()) %></font>
				</c:otherwise>
			</c:choose>

			<liferay-util:include page="/html/portlet/nss/tintonghop/asset_actions.jsp" />

		</li>
	</c:if>

	<c:if test="<%= (assetIndex1 + 1) == results.size() %>">
		</ul>
	</c:if>
</div>