
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.tags.NoSuchPropertyException"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.tags.service.TagsPropertyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.tags.model.TagsProperty"%>
<%@page import="com.liferay.portlet.tags.model.TagsVocabulary"%>
<%@page import="com.liferay.portlet.tags.model.TagsEntryConstants"%>
<%@page import="com.liferay.portlet.tags.service.TagsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.tags.model.TagsEntry"%>
<%@page import="com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalServiceUtil"%>
<%@page import="com.nss.portlet.image_signer.service.ImageSignerLocalServiceUtil"%>
<%@page import="com.nss.portlet.image_signer.model.ImageSigner"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.nss.portlet.digitalsignature.service.SignatureLocalServiceUtil"%>
<%@page import="com.nss.portlet.digitalsignature.model.Signature"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.digitalsignature.util.ArticleSignUtil"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.util.portlet.PortletRequestUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portlet.tags.service.TagsAssetLocalServiceUtil"%>
<%@page import="com.liferay.portlet.tags.model.TagsAsset"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/nss/thong_ke_tin/init.jsp" %>

<%
String articleId = ParamUtil.getString(request,"articleId");

JournalArticle article = JournalArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
List<TagsAsset> tagsAssets = NSSTagsAssetLocalServiceUtil.getTagsAsset(article.getUserId(),String.valueOf(article.getResourcePrimKey()));
TagsAsset tagsAsset = null;
if(tagsAssets != null && tagsAssets.size() >0){
	tagsAsset = tagsAssets.get(0);
}
Map<String,List<String>> map = new HashMap<String,List<String>>();
if(tagsAsset != null){
	List<TagsEntry> tagsEntries = TagsEntryLocalServiceUtil.getAssetEntries(tagsAsset.getAssetId(),TagsEntryConstants.FOLKSONOMY_CATEGORY);
	TagsVocabulary vocabulary = null;
	List<String> listStr = null;
	for (TagsEntry assetEntry : tagsEntries) {
		vocabulary = assetEntry.getVocabulary();
		String tagLabel = null;
		try {
			TagsProperty descriptionProperty = TagsPropertyLocalServiceUtil.getProperty(assetEntry.getEntryId(), themeDisplay.getLanguageId());

			tagLabel = descriptionProperty.getValue();
		}
		catch (NoSuchPropertyException nspee1) {
			try {
				TagsProperty descriptionProperty = TagsPropertyLocalServiceUtil.getProperty(assetEntry.getEntryId(), "en_US");
					tagLabel = descriptionProperty.getValue();
			}
			catch (NoSuchPropertyException nspee2) {
				tagLabel = StringUtil.upperCaseFirstLetter(assetEntry.getName());
			}
		}
		if(map.get(vocabulary.getName()) != null){
			listStr = map.get(vocabulary.getName());
			listStr.add(tagLabel);
			map.put(vocabulary.getName(),listStr);
		}else{
			listStr = new ArrayList<String>();
			listStr.add(tagLabel);
			map.put(vocabulary.getName(),listStr);
		}
	}
}
List<String> strings = new ArrayList<String>();
String category = "unkown";
if(map.size() > 0){
	Iterator iterator = map.keySet().iterator();
	while(iterator.hasNext()){
		String keString = (String)iterator.next();
		category = "--- " + keString + "<br>";
		for(String string : map.get(keString)){
			category += "&nbsp;&nbsp;&nbsp;&nbsp;+" + string +"<br>";
		}
		strings.add(category);
	}
}
String title = article.getTitle();

String className = JournalArticle.class.getName();
long classPK = article.getResourcePrimKey();

boolean showAssetTitle = true;
DateFormat dateFormat = new SimpleDateFormat("hh:mm dd-MM-yyyy");
%>
<div id="centermain">

<div class="asset-full-content">
			<%
			JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);
			String templateId = (String)request.getAttribute(WebKeys.JOURNAL_TEMPLATE_ID);
			String languageId = LanguageUtil.getLanguageId(request);
			int articlePage = ParamUtil.getInteger(request, "page", 1);
			String xmlRequest = PortletRequestUtil.toXML(renderRequest, renderResponse);
			JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(), articleResource.getArticleId(), templateId, null, languageId, themeDisplay,articlePage, xmlRequest);
			%>
			<div class="titlecategories">
				<c:if test="<%= strings.size() == 0 %>">
					<h6>unkown</h6>	
				</c:if>
				<c:forEach var="s" items="<%= strings %>">
					<h6>${s}</h6>	
				</c:forEach>
						    
			</div>
			
			<div class="txtdetail">
				<h5><%= title %></h5>
				<h1><liferay-ui:message key="nss-cap-nhat" />: <%=dateFormat.format(article.getDisplayDate()) %></h1>
			<c:if test="<%= articleDisplay != null %>">

				<div  class="asset-content">
					<c:if test="<%= true %>">
						<%
						String[] availableLocales = articleDisplay.getAvailableLocales();
						%>

						<c:if test="<%= availableLocales.length > 0 %>">
							<div>
								<br />

								<liferay-ui:language languageIds="<%= availableLocales %>" displayStyle="<%= 0 %>" />
							</div>
						</c:if>
					</c:if>

					<div class="journal-content-article">
						<%= articleDisplay.getContent() %>
					</div>
				</div>
			</c:if>
			<c:if test="<%= articleDisplay == null %>">
				<div class="journal-content-article">
				<% String xml = article.getContent(); 
					xml = xml.replace("<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"vi_VN\" default-locale=\"vi_VN\"><static-content language-id=\"vi_VN\"><![CDATA[","");
					xml = xml.replace("]]></static-content></root>","");
				%>
					<%= xml %>
					</div>
			</c:if>
				</div>
</div>
