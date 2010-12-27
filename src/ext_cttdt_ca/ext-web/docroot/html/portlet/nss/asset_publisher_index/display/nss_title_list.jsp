<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%
List results1 = (List)request.getAttribute("aaa");
//System.out.println("-------------------------------------------------"+results1.size());
int assetIndex1 = ((Integer)request.getAttribute("view.jsp-assetIndex")).intValue();

TagsAsset asset1 = (TagsAsset)request.getAttribute("view.jsp-asset");

//MoNT update start 27/12/2010
//System.out.println("----"+results.size());
String s = "-----------------";
for(int i=0;i<asset1.getCategories().size();i++){
	s += asset1.getCategories().get(i).getVocabularyId()+"/";
}
//System.out.println(s);

Set<Long> setVocabularyId = new HashSet<Long>();
long selectPlId = 0;
if (asset1.getCategories().size() > 0 ) {
	long vocabularyId = 0;
	for(int i=0;i<asset1.getCategories().size();i++){
		vocabularyId = asset1.getCategories().get(i).getVocabularyId();
		setVocabularyId.add(vocabularyId);
		selectPlId = GetterUtil.getLong(preferences.getValue(String.valueOf(vocabularyId), StringPool.BLANK));
			//System.out.println(vocabularyId+" ////////// "+selectPlId);			
	}
	System.out.println("setVocabularyId  --  "+setVocabularyId.toString());
	//System.out.println(vocabularyId+"??????????? "+selectPlId);
}
List<com.liferay.portal.model.PortletPreferences> pPlIds = new ArrayList<com.liferay.portal.model.PortletPreferences>();
try {
	pPlIds = PortletPreferencesLocalServiceUtil.getPortletPreferencesByPlid(selectPlId);
} catch (Exception e) {
}

String portletAssetPublisher = "NSS_ASSET_PUBLISHER_INDEX";
for (int i = 0; i < pPlIds.size(); i++) {
	if(pPlIds.get(i).getPortletId().contains("NSS_ASSET_PUBLISHER_INSTANCE")) {
		portletAssetPublisher =  pPlIds.get(i).getPortletId();
		break;
	}
}
//MoNT update end 27/12/2010

String title1 = (String)request.getAttribute("view.jsp-title");
String viewURL1 = (String)request.getAttribute("view.jsp-viewURL");
String cssClassName1 = StringPool.BLANK;

String className1 = (String)request.getAttribute("view.jsp-className");
long classPK1 = ((Long)request.getAttribute("view.jsp-classPK")).longValue();

boolean show1 = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", false);

PortletURL viewFullContentURL = new PortletURLImpl(request, portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
//PortletURL viewFullContentURL = renderResponse.createRenderURL();
viewFullContentURL.setParameter("struts_action", "/nss/asset_publisher/view_content");
viewFullContentURL.setParameter("assetId", String.valueOf(asset1.getAssetId()));

	JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK1);

	String languageId = LanguageUtil.getLanguageId(request);

	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

	if (articleDisplay != null) {
		if (Validator.isNull(title1)) {
			title1 = articleDisplay.getTitle();
		}

		//PortletURL articleURL = renderResponse.createRenderURL();
		PortletURL articleURL = new PortletURLImpl(request, portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );

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
<c:if test="<%= results.size() > delta %>">
	<c:if test="<%= assetIndex1 == 1 %>">
	<div class="listany">
	<ul>
	</c:if>
	<c:if test="<%= show1 %>">
	
		<li>
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL1) %>">
					<a href="<%= viewURL1 %>"><%= title1 %>
						<font class="leddmy"><%=df1.format(asset1.getPublishDate()) %></font>
					</a> 
				</c:when>
				<c:otherwise>
					<%= title1 %> <font class="leddmy"><%=df1.format(asset1.getPublishDate()) %></font>
				</c:otherwise>
			</c:choose>

			<liferay-util:include page="/html/portlet/nss/asset_publisher_index/asset_actions.jsp" />

		</li>
	</c:if>

	<c:if test="<%= (assetIndex1 + 1) == delta %>">
	
	</ul>
	</div>
	</c:if>
	</c:if>
	
	<c:if test="<%= results.size() <= delta %>">
	<c:if test="<%= assetIndex1 == 1 %>">
	<div class="listany">
	<ul>
	</c:if>
	<c:if test="<%= show1 %>">
	
		<li>
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL1) %>">
					<a href="<%= viewURL1 %>"><%= title1 %>
						<font class="leddmy"><%=df1.format(asset1.getPublishDate()) %></font>
					</a> 
				</c:when>
				<c:otherwise>
					<%= title1 %> <font class="leddmy"><%=df1.format(asset1.getPublishDate()) %></font>
				</c:otherwise>
			</c:choose>

			<liferay-util:include page="/html/portlet/nss/asset_publisher_index/asset_actions.jsp" />

		</li>
	</c:if>

	<c:if test="<%= (assetIndex1 + 1) == results.size() %>">
	
	</ul>
	</div>
	</c:if>
	</c:if>