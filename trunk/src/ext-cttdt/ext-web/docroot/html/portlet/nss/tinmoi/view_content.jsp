<%@ include file="/html/portlet/nss/tinmoi/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long assetId = ParamUtil.getLong(renderRequest, "assetId");
String type = ParamUtil.getString (renderRequest, "type");
String urlTitle = ParamUtil.getString (renderRequest, "urlTitle");

List results = new ArrayList();

int assetIndex = 0;

TagsAsset asset = null;

String className = StringPool.BLANK;
long classPK = 0;

try {
	if (Validator.isNotNull(urlTitle)) {
		if (type.equals (AssetPublisherUtil.TYPE_BLOG)) {
			BlogsEntry entry = BlogsEntryServiceUtil.getEntry(scopeGroupId, urlTitle);

			className = BlogsEntry.class.getName();
			classPK = entry.getPrimaryKey();
		}
		else if (type.equals (AssetPublisherUtil.TYPE_CONTENT)) {
			JournalArticle article = JournalArticleServiceUtil.getArticleByUrlTitle(scopeGroupId, urlTitle);

			className = JournalArticle.class.getName();
			classPK = article.getResourcePrimKey();
		}
		asset = TagsAssetLocalServiceUtil.getAsset(className, classPK);
	}
	else {
		asset = TagsAssetLocalServiceUtil.getAsset(assetId);

		className = PortalUtil.getClassName(asset.getClassNameId());
		classPK = asset.getClassPK();
	}

	String title = asset.getTitle();
	String summary = StringPool.BLANK;
	String viewURL = StringPool.BLANK;
	String viewURLMessage = StringPool.BLANK;
	String editURL = StringPool.BLANK;

	boolean show = true;

	request.setAttribute("view.jsp-results", results);

	request.setAttribute("view.jsp-assetIndex", new Integer(assetIndex));

	request.setAttribute("view.jsp-asset", asset);

	request.setAttribute("view.jsp-title", title);
	request.setAttribute("view.jsp-summary", summary);
	request.setAttribute("view.jsp-viewURL", viewURL);
	request.setAttribute("view.jsp-viewURLMessage", viewURLMessage);

	request.setAttribute("view.jsp-className", className);
	request.setAttribute("view.jsp-classPK", new Long(classPK));

	request.setAttribute("view.jsp-show", new Boolean(show));
%>

	<!--<div align="right">
		&laquo; <a href="<%= HtmlUtil.escape(redirect) %>"><liferay-ui:message key="back" /></a>
	</div>-->

	<div>
		<liferay-util:include page="/html/portlet/nss/tinmoi/display/full_content.jsp" />
	</div>

	<liferay-util:include page="/html/portlet/nss/tinmoi/asset_html_metadata.jsp" />

<%
}
catch (Exception e) {
	_log.error(e.getMessage());
}
%>

<!-- start them tin lien quan by triltm -->

<%
PortletURL portletURL = renderResponse.createRenderURL();
SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);
long[] entryIds = TagsEntryLocalServiceUtil.getEntryIds(scopeGroupId, entries);
long[] notEntryIds = TagsEntryLocalServiceUtil.getEntryIds(scopeGroupId, notEntries); 

if (allowEmptyResults && (entryIds.length == 0) && (notEntryIds.length == 0)) {
	entryIds = new long[] {-1};
}

Date now = new Date();

int total = TagsAssetLocalServiceUtil.getAssetsCount(scopeGroupId, classNameIds, entryIds, notEntryIds, andOperator, excludeZeroViewCount, now, now);


List<TagsAsset> assetList = new ArrayList<TagsAsset>();
List<TagsAsset> assets = TagsAssetLocalServiceUtil.getAssets(scopeGroupId, classNameIds, entryIds, notEntryIds, andOperator, orderByColumn1, orderByColumn2, orderByType1, orderByType2, excludeZeroViewCount, now, now, searchContainer.getStart(), total);
List<TagsEntry> assetEntries = TagsEntryLocalServiceUtil.getAssetEntries(asset.getAssetId(), TagsEntryConstants.FOLKSONOMY_TAG);

for (TagsAsset tagasset : assets) {
	List<TagsEntry> tgentries = tagasset.getEntries();
	for (TagsEntry assetEntry : assetEntries) {
		for (TagsEntry entriy : tgentries) {
			if (assetEntry.getEntryId() == entriy.getEntryId()) {
				if ((!assetList.contains(tagasset)) && (!tagasset.equals(asset)) && tagasset.getPublishDate().before(asset.getPublishDate())) {
				assetList.add(tagasset);
				}
			}
		}
	}
}
if (assetList.size() != 0) {
%>

<style type="text/css">
.portlet-asset-publisher ul.title-list {
	margin: 0 !important;
}
</style>

<div class="listnewsmore">
<p class="textmore"><liferay-ui:message key="nss-cac-tin-khac"/></p>
<%
}
for (int i = 0; (i < assetList.size()) && (i < delta); i++) {
	TagsAsset asset1 = assetList.get(i);

	String className1 = PortalUtil.getClassName(asset.getClassNameId());
	long classPK1 = asset1.getClassPK();

	String title1 = asset1.getTitle();
	String summary1 = StringPool.BLANK;
	String viewURL1 = StringPool.BLANK;
	String viewURLMessage1 = StringPool.BLANK;
	String editURL1 = StringPool.BLANK;

	boolean show1 = true;

	request.setAttribute("view.jsp-assetIndex", new Integer(i));

	request.setAttribute("view.jsp-asset", asset1);

	request.setAttribute("view.jsp-title", title1);
	request.setAttribute("view.jsp-summary", summary1);
	request.setAttribute("view.jsp-viewURL", viewURL1);
	request.setAttribute("view.jsp-viewURLMessage", viewURLMessage1);

	request.setAttribute("view.jsp-className", className1);
	request.setAttribute("view.jsp-classPK", new Long(classPK1));

	request.setAttribute("view.jsp-show", new Boolean(show1));

	try {
%>

<div><liferay-util:include page="/html/portlet/nss/tinmoi/display/title_list.jsp" /></div>

<%
	} catch (Exception e) {
		e.printStackTrace();
	}

 } %>
 </div>
<!-- end them tin lien quan by triltm -->

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.nss.tinmoi.view_content.jsp");
%>