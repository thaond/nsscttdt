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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "request_processed") %>'>
		<script type="text/javascript">
			jQuery(
				function() {
					window.close();
					opener.<portlet:namespace />changeLogo('<%= themeDisplay.getPathImage() + "/company_logo?img_id=" + company.getLogoId() +"&t=" + ImageServletTokenUtil.getToken(company.getLogoId()) %>');
				}
			);
		</script>
	</c:when>
	<c:otherwise>
		<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_company_logo" /></portlet:actionURL>" class="uni-form" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">

		<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />

		<div class="ctrl-holder">
			<input name="<portlet:namespace />fileName" size="50" type="file" />
		</div>

		<br />

		<div class="button-holder">
			<input type="submit" value="<liferay-ui:message key="save" />" />

			<input type="button" value="<liferay-ui:message key="cancel" />" onClick="window.close();" />
		</div>

		</form>

		<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
			<script type="text/javascript">
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />fileName);
			</script>
		</c:if>
	</c:otherwise>
</c:choose>