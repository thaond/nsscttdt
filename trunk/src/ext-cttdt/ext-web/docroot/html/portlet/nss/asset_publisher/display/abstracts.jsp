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

<%@ include file="/html/portlet/nss/asset_publisher/init.jsp" %>

<%
int abstractNumber = ((Integer)request.getAttribute("view.jsp-abstractDelta")).intValue();

List results = (List)request.getAttribute("view.jsp-results");

int assetIndex = ((Integer)request.getAttribute("view.jsp-assetIndex")).intValue();

TagsAsset asset = (TagsAsset)request.getAttribute("view.jsp-asset");

String title = (String)request.getAttribute("view.jsp-title");
String summary = (String)request.getAttribute("view.jsp-summary");
String viewURL = (String)request.getAttribute("view.jsp-viewURL");
String viewURLMessage = (String)request.getAttribute("view.jsp-viewURLMessage");
String cssClassName = StringPool.BLANK;

String className = (String)request.getAttribute("view.jsp-className");
long classPK = ((Long)request.getAttribute("view.jsp-classPK")).longValue();

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", true);

PortletURL viewFullContentURL = renderResponse.createRenderURL();

viewFullContentURL.setParameter("struts_action", "/nss/asset_publisher/view_content");
viewFullContentURL.setParameter("assetId", String.valueOf(asset.getAssetId()));

if (className.equals(BlogsEntry.class.getName())) {
	BlogsEntry entry = BlogsEntryLocalServiceUtil.getEntry(classPK);

	if (Validator.isNull(title)) {
		title = entry.getTitle();
	}

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_BLOG);

	String urlTitle = entry.getUrlTitle();

	if (Validator.isNotNull(urlTitle)) {
		viewFullContentURL.setParameter("urlTitle", urlTitle);
	}

	summary = StringUtil.shorten(HtmlUtil.stripHtml(entry.getContent()), abstractLength);
	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/blogs/find_entry?noSuchEntryRedirect=" + HttpUtil.encodeURL(viewFullContentURL.toString()) + "&entryId=" + entry.getEntryId() : viewFullContentURL.toString();
	viewURLMessage = viewInContext ? "view-in-context" : "read-more";
	cssClassName = AssetPublisherUtil.TYPE_BLOG;
}
else if (className.equals(BookmarksEntry.class.getName())) {
	BookmarksEntry entry = BookmarksEntryLocalServiceUtil.getEntry(classPK);

	if (Validator.isNull(title)) {
		title = entry.getName();
	}

	String entryURL = themeDisplay.getPathMain() + "/bookmarks/open_entry?entryId=" + entry.getEntryId();

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_BOOKMARK);

	summary = entry.getComments();
	viewURL = viewInContext ? entryURL : viewFullContentURL.toString();
	viewURLMessage = viewInContext ? "go" : "read-more";
	cssClassName = AssetPublisherUtil.TYPE_BOOKMARK;
}
else if (className.equals(DLFileEntry.class.getName())) {
	DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(classPK);

	String fileEntryURL = themeDisplay.getPathMain() + "/document_library/get_file?p_l_id=" + themeDisplay.getPlid() + "&folderId=" + fileEntry.getFolderId() + "&name=" + HttpUtil.encodeURL(fileEntry.getName());

	StringBuilder sb = new StringBuilder();

	sb.append("<a href=\"");
	sb.append(fileEntryURL);
	sb.append("\"><img align=\"left\" border=\"0\" src=\"");
	sb.append(themeDisplay.getPathThemeImages());
	sb.append("/document_library/");
	sb.append(DLUtil.getFileExtension(fileEntry.getName()));
	sb.append(".png\" />");
	sb.append(fileEntry.getTitle());
	sb.append("</a>");

	summary = fileEntry.getDescription();

	if (Validator.isNull(title)) {
		title = sb.toString();
	}
	else {
		sb.append("<br />");
		sb.append(summary);

		summary = sb.toString();
	}

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_DOCUMENT);

	viewURL = viewInContext ? fileEntryURL : viewFullContentURL.toString();
	viewURLMessage = viewInContext ? "download" : "read-more";
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
	viewURLMessage = viewInContext ? "view-album" : "view";
	cssClassName = AssetPublisherUtil.TYPE_IMAGE;

	StringBuilder sb = new StringBuilder();

	Image smallImage = ImageLocalServiceUtil.getImage(image.getSmallImageId());

	if (smallImage != null) {
		long smallImageId = smallImage.getImageId();

		sb.append("<a href=\"");
		sb.append(_checkViewURL(viewURL, currentURL, themeDisplay));
		sb.append("\"><img align=\"left\" alt=\"");
		sb.append(LanguageUtil.get(pageContext, viewURLMessage));
		sb.append("\" border=\"0\" src=\"");
		sb.append(themeDisplay.getPathImage());
		sb.append("/image_gallery?img_id=");
		sb.append(smallImageId);
		sb.append("\" style=\"float: left; padding-right: 10px;\" /></a>");
	}

	sb.append(StringUtil.shorten(image.getDescription(), abstractLength));

	summary = sb.toString();
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
		
		String _viewURL = _checkViewURL(viewURL, currentURL, themeDisplay);
		
		StringBuilder sb = new StringBuilder();

		if (articleDisplay.isSmallImage()) {
			sb.append("<div class=\"shownew\">");
			//sb.append("<div style=\"float: left; margin-bottom: 10px; padding-right: 10px;\">");
			sb.append("<a href=\"" + _viewURL + "\"><img alt=\"");
			sb.append(LanguageUtil.get(pageContext, "web-content-image"));
			sb.append("\" width=\"");
			sb.append(dimensionWidth);
			sb.append("px");
			sb.append("\" height=\"");
			sb.append(dimensionHeight);
			sb.append("px\" src=\"");
			//sb.append("src=\"");

			if (Validator.isNotNull(articleDisplay.getSmallImageURL())) {
				sb.append(articleDisplay.getSmallImageURL());
			}
			else {
				sb.append(themeDisplay.getPathImage());
				sb.append("/journal/article?img_id=");
				sb.append(articleDisplay.getSmallImageId());
				sb.append("&t=");
				sb.append(ImageServletTokenUtil.getToken(articleDisplay.getSmallImageId()));
			}

			//sb.append("\" /></a></div>");
			sb.append("\" /></a>");
		}

		if (abstractNumber == 1) {
			sb.append("<h5><a style=\"font-size:20px\" href=\"" + viewURL + "\">" + "" + title + "</a></h5>");
		} else {
			sb.append("<h5><a href=\"" + viewURL + "\">" + "" + title + "</a></h5>");
		}
		
		sb.append("<h1>" + df.format(asset.getPublishDate()) + "</h1>");
		
		sb.append("<span>" +  StringUtil.shorten(HtmlUtil.stripHtml(articleDisplay.getDescription()), abstractLength) + "</span>");

		sb.append("</div>");
		
		summary = sb.toString();

		if (Validator.isNull(summary)) {
			summary = StringUtil.shorten(HtmlUtil.stripHtml(articleDisplay.getContent()), abstractLength);
		}

		viewURLMessage = "read-more";
		cssClassName = AssetPublisherUtil.TYPE_CONTENT;
	}
	else {
		show = false;
	}
}
else if (className.equals(MBMessage.class.getName())) {
	MBMessage message = MBMessageLocalServiceUtil.getMessage(classPK);

	viewFullContentURL.setParameter("type", "thread");

	summary = StringUtil.shorten(message.getBody(), abstractLength);
	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/message_boards/find_message?messageId=" + message.getMessageId() : viewFullContentURL.toString();
	viewURLMessage = viewInContext ? "view-in-context" : "read-more";
	cssClassName = "thread";
}
else if (className.equals(WikiPage.class.getName())) {
	WikiPageResource pageResource = WikiPageResourceLocalServiceUtil.getPageResource(classPK);

	WikiPage wikiPage = WikiPageLocalServiceUtil.getPage(pageResource.getNodeId(), pageResource.getTitle());

	summary = wikiPage.getContent();

	if (wikiPage.getFormat().equals("html")) {
		summary = HtmlUtil.stripHtml(summary);
	}

	viewFullContentURL.setParameter("type", AssetPublisherUtil.TYPE_WIKI);

	summary = StringUtil.shorten(summary, abstractLength);
	viewURL = viewInContext ? themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/wiki/find_page?pageResourcePrimKey=" + wikiPage.getResourcePrimKey() : viewFullContentURL.toString();
	viewURLMessage = viewInContext ? "view-in-context" : "read-more";
	cssClassName = AssetPublisherUtil.TYPE_WIKI;
}

viewURL = _checkViewURL(viewURL, currentURL, themeDisplay);
%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<c:if test="<%= show %>">
	<div class="asset-abstract assetall">
		<liferay-util:include page="/html/portlet/nss/asset_publisher/asset_actions.jsp" />
		<div class="asset-content">
			<p class="asset-summary"><%= summary%></p>
		</div>
		<div class="asset-metadata"><%@ include file="/html/portlet/nss/asset_publisher/asset_metadata.jspf" %></div>
	</div>
</c:if>