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

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

DLFolder folder = (DLFolder)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDER);

long folderId = BeanParamUtil.getLong(folder, request, "folderId");

long parentFolderId = BeanParamUtil.getLong(folder, request, "parentFolderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
%>

<script type="text/javascript">
	function <portlet:namespace />removeFolder() {
		document.<portlet:namespace />fm.<portlet:namespace />parentFolderId.value = "<%= DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>";

		var nameEl = document.getElementById("<portlet:namespace />parentFolderName");

		nameEl.href = "";
		nameEl.innerHTML = "";
	}

	function <portlet:namespace />saveFolder() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= folder == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectFolder(parentFolderId, parentFolderName) {
		document.<portlet:namespace />fm.<portlet:namespace />parentFolderId.value = parentFolderId;

		var nameEl = document.getElementById("<portlet:namespace />parentFolderName");

		nameEl.href = "<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/document_library/view" /></portlet:renderURL>&<portlet:namespace />folderId=" + parentFolderId;
		nameEl.innerHTML = parentFolderName + "&nbsp;";
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/document_library/edit_folder" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveFolder(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />folderId" type="hidden" value="<%= folderId %>" />
<input name="<portlet:namespace />parentFolderId" type="hidden" value="<%= parentFolderId %>" />

<liferay-ui:error exception="<%= DuplicateFileException.class %>" message="please-enter-a-unique-folder-name" />
<liferay-ui:error exception="<%= DuplicateFolderNameException.class %>" message="please-enter-a-unique-folder-name" />
<liferay-ui:error exception="<%= FolderNameException.class %>" message="please-enter-a-valid-name" />

<div class="parent-title">
	<%= BreadcrumbsUtil.removeLastClass(DLUtil.getBreadcrumbs(parentFolderId, null, rootFolderId, pageContext, renderRequest, renderResponse)) %> &raquo;
	<span class="last"><liferay-ui:message key='<%= ((folder == null) ? Constants.ADD : Constants.UPDATE) + "-folder" %>' /></span>
</div>

<table width="100%" cellspacing="0">

<c:if test="<%= folder != null %>">
	<tr>
		<td width="15%">
			<liferay-ui:message key="parent-folder" />:
		</td>
		<td>

			<%
			String parentFolderName = "";

			try {
				DLFolder parentFolder = DLFolderLocalServiceUtil.getFolder(parentFolderId);

				parentFolderName = parentFolder.getName();
			}
			catch (NoSuchFolderException nscce) {
			}
			%>

			<a href="<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/document_library/view" /><portlet:param name="folderId" value="<%= String.valueOf(parentFolderId) %>" /></portlet:renderURL>" id="<portlet:namespace />parentFolderName">
			<%= parentFolderName %></a>
			<input type="button" value="<liferay-ui:message key="select" />" onClick="var folderWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/document_library/select_folder" /><portlet:param name="folderId" value="<%= String.valueOf(parentFolderId) %>" /></portlet:renderURL>', 'folder', 'directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680'); void(''); folderWindow.focus();" />
			<input id="<portlet:namespace />removeFolderButton" type="button" value="<liferay-ui:message key="remove" />" onClick="<portlet:namespace />removeFolder();" />
		</td>
	</tr>
	
</c:if>

<tr>
	<td>
		<liferay-ui:message key="name" />:
	</td>
	<td>
		<liferay-ui:input-field model="<%= DLFolder.class %>" bean="<%= folder %>" field="name" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="description" />:
	</td>
	<td>
		<liferay-ui:input-field model="<%= DLFolder.class %>" bean="<%= folder %>" field="description" />
	</td>
</tr>

<c:if test="<%= folder != null %>">
	
	<tr>
		<td>
			<liferay-ui:message key="webdav-url" />:
		</td>
		<td>

			<%
			StringBuffer sb = new StringBuffer();

			if (folder != null) {
				DLFolder curFolder = folder;

				while (true) {
					sb.insert(0, WebDAVUtil.encodeURL(curFolder.getName()));
					sb.insert(0, StringPool.SLASH);

					if (curFolder.getParentFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
						break;
					}
					else {
						curFolder = DLFolderLocalServiceUtil.getFolder(curFolder.getParentFolderId());
					}
				}
			}

			Group group = layout.getGroup();
			%>

			<liferay-ui:input-resource
				url='<%= themeDisplay.getPortalURL() + "/tunnel-web/secure/webdav/" + company.getWebId() + group.getFriendlyURL() + "/document_library" + sb.toString() %>'
			/>
		</td>
	</tr>
</c:if>

<c:if test="<%= folder == null %>">
	<tr>
		<td>
			<liferay-ui:message key="permissions" />:
		</td>
		<td>
			<liferay-ui:input-permissions
				modelName="<%= DLFolder.class.getName() %>"
			/>
		</td>
	</tr>
</c:if>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="<liferay-ui:message key="save" />" />
			<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
		</td>
	</tr>
</table>
<br />
</form>

<c:if test="<%= windowState.equals(WindowState.NORMAL) || windowState.equals(LiferayWindowState.POP_UP) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>