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

<%@ include file="/html/portlet/image_gallery/init.jsp" %>

<%
IGFolder folder = (IGFolder)request.getAttribute(WebKeys.IMAGE_GALLERY_FOLDER);

long folderId = BeanParamUtil.getLong(folder, request, "folderId", IGFolderImpl.DEFAULT_PARENT_FOLDER_ID);
%>

<form method="post" name="<portlet:namespace />fm">

<liferay-ui:tabs names="folders" />

<c:if test="<%= folder != null %>">
	<div class="breadcrumbs">
		<%= IGUtil.getBreadcrumbs(folder, null, pageContext, renderRequest, renderResponse) %>
	</div>
</c:if>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/image_gallery/select_folder");
portletURL.setParameter("folderId", String.valueOf(folderId));

List<String> headerNames = new ArrayList<String>();

headerNames.add("folder");
headerNames.add("num-of-folders");
headerNames.add("num-of-documents");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);

int total = IGFolderLocalServiceUtil.getFoldersCount(scopeGroupId, folderId);

searchContainer.setTotal(total);

List results = IGFolderLocalServiceUtil.getFolders(scopeGroupId, folderId, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	IGFolder curFolder = (IGFolder)results.get(i);

	curFolder = curFolder.toEscapedModel();

	ResultRow row = new ResultRow(curFolder, curFolder.getFolderId(), i);

	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setParameter("struts_action", "/image_gallery/select_folder");
	rowURL.setParameter("folderId", String.valueOf(curFolder.getFolderId()));

	// Name

	StringBuilder sb = new StringBuilder();

	sb.append("<img align=\"left\" border=\"0\" src=\"");
	sb.append(themeDisplay.getPathThemeImages());
	sb.append("/common/folder.png\">");
	sb.append(curFolder.getName());

	row.addText(sb.toString(), rowURL);

	// Statistics

	List subfolderIds = new ArrayList();

	subfolderIds.add(new Long(curFolder.getFolderId()));

	IGFolderLocalServiceUtil.getSubfolderIds(subfolderIds, scopeGroupId, curFolder.getFolderId());

	int foldersCount = subfolderIds.size() - 1;
	int imagesCount = IGImageLocalServiceUtil.getFoldersImagesCount(subfolderIds);

	row.addText(String.valueOf(foldersCount), rowURL);
	row.addText(String.valueOf(imagesCount), rowURL);

	// Action

	sb = new StringBuilder();

	sb.append("opener.");
	sb.append(renderResponse.getNamespace());
	sb.append("selectFolder('");
	sb.append(curFolder.getFolderId());
	sb.append("', '");
	sb.append(UnicodeFormatter.toString(curFolder.getName()));
	sb.append("'); window.close();");

	row.addButton("right", SearchEntry.DEFAULT_VALIGN, LanguageUtil.get(pageContext, "choose"), sb.toString());

	// Add result row

	resultRows.add(row);
}

boolean showAddFolderButton = IGFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER);
%>

<c:if test="<%= showAddFolderButton %>">
	<div>
		<input type="button" value="<liferay-ui:message key="add-folder" />" onClick="location.href = '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/image_gallery/edit_folder" /><portlet:param name="redirect" value="<%= currentURL %>" /><portlet:param name="parentFolderId" value="<%= String.valueOf(folderId) %>" /></portlet:renderURL>';" />
	</div>

	<c:if test="<%= results.size() > 0 %>">
	</c:if>
</c:if>
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</form>