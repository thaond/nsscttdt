<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
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

<%
String redirect = ParamUtil.getString(request, "redirect");

String sessionId = ParamUtil.getString(request, "sessionId");

UserTracker userTracker = LiveUsers.getUserTracker(company.getCompanyId(), sessionId);

List<UserTrackerPath> paths = userTracker.getPaths();

userTracker = userTracker.toEscapedModel();
%>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_session" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="thong-tin-he-thong"/></div>
<div class="boxcontent">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />sessionId" type="hidden" value="<%= HtmlUtil.escape(sessionId) %>" />
<liferay-util:include page="/html/portlet/enterprise_admin/tabs1.jsp">
	<liferay-util:param name="tabs1" value="monitoring" />
</liferay-util:include>
<div class="boxcontent_Tab">
<liferay-ui:tabs names="live-session" />
<div class="boxcontent_Tab">
<c:choose>
	<c:when test="<%= userTracker == null %>">
		<liferay-ui:message key="session-id-not-found" />

		<br /><br />

		<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
	</c:when>
	<c:otherwise>

		<%
		User user2 = null;

		try {
			user2 = UserLocalServiceUtil.getUserById(userTracker.getUserId());
		}
		catch (NoSuchUserException nsue) {
		}
		%>

		<table cellspacing="0" width="100%">
		<tr>
			<td width="25%">
				<liferay-ui:message key="session-id" />&nbsp;:
			</td>
			<td>
				<%= HtmlUtil.escape(sessionId) %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="user-id" />&nbsp;:
			</td>
			<td>
				<%= userTracker.getUserId() %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="name" />&nbsp;:
			</td>
			<td>
				<%= (user2 != null) ? user2.getFullName() : LanguageUtil.get(pageContext, "not-available") %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="email-address" />&nbsp;:
			</td>
			<td>
				<%= (user2 != null) ? user2.getEmailAddress() : LanguageUtil.get(pageContext, "not-available") %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="last-request" />&nbsp;:
			</td>
			<td>
				<%= dateFormatDateTime.format(userTracker.getModifiedDate()) %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="num-of-hits" />&nbsp;:
			</td>
			<td>
				<%= userTracker.getHits() %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="browser-os-type" />&nbsp;:
			</td>
			<td>
				<%= userTracker.getUserAgent() %>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="remote-host-ip" />&nbsp;:
			</td>
			<td>
				<%= userTracker.getRemoteAddr() %> / <%= userTracker.getRemoteHost() %>
			</td>
		</tr>
		<tr >
			<td >
				<b><liferay-ui:message key="accessed-urls" /></b>&nbsp;:
			</td>
			<td >
				<span>
				[<a href="javascript: void(0);" onClick="Liferay.Util.toggleByIdSpan(this, '<portlet:namespace />accessedUrls'); self.focus();"><span><liferay-ui:message key="show" /></span><span style="display: none;"><liferay-ui:message key="hide" /></span></a>]
				</span>
			</td>
		</tr>
		<tr >
			<td width="25%"></td>
			<td >
				<div id="<portlet:namespace />accessedUrls" style="display: none;">
					<table cellspacing="0" width="100%" class="taglib-search-iterator table-pml">
					<tr class="portlet-section-header results-header" >
						<td width="75%"><liferay-ui:message key="Ten-URL"/></td>
						<td align="center"><liferay-ui:message key="Thoi-gian-xu-ly"/></td>
					</tr>
					<%
					for (int i = 0; i < paths.size(); i++) {
						UserTrackerPath userTrackerPath = paths.get(i);

						String className = "portlet-section-body results-row";
						String classHoverName = "portlet-section-body-hover results-row hover";

						if (MathUtil.isEven(i)) {
							className = "portlet-section-alternate results-row alt";
							classHoverName = "portlet-section-alternate-hover results-row alt hover";
						}
					%>

						<tr class="<%= className %>"  onMouseEnter="this.className = '<%= classHoverName %>';" onMouseLeave="this.className = '<%= className %>';">
							<td >
								<%= StringUtil.replace(userTrackerPath.getPath(), "&", "& ") %>
							</td>
							<td align="center">
								<%= dateFormatDateTime.format(userTrackerPath.getPathDate()) %>
							</td>
						</tr>

					<%
					}
					%>

					</table>
				</div>
			</td>
		</tr>
		<tr >
			<td width="25%">
				<b><liferay-ui:message key="session-attributes" /></b>
			</td>
			<td >
				<span >
				[<a href="javascript: void(0);" onClick="Liferay.Util.toggleByIdSpan(this, '<portlet:namespace />sessionAttributes'); self.focus();"><span><liferay-ui:message key="show" /></span><span style="display: none;"><liferay-ui:message key="hide" /></span></a>]
				</span>
			</td>
		</tr>
		<tr>
			<td width="25%"></td>
			<td >
				<div id="<portlet:namespace />sessionAttributes" style="display: none;">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
					<tr class="portlet-section-header results-header" >
						<td ><liferay-ui:message key="Session-Attributes"/></td>
					</tr>
					<%
					boolean userSessionAlive = true;

					HttpSession userSession = PortalSessionContext.get(sessionId);

					if (userSession != null) {
						try {
							int counter = 0;

							Set sortedAttrNames = new TreeSet();

							Enumeration enu = userSession.getAttributeNames();

							while (enu.hasMoreElements()) {
								String attrName = (String)enu.nextElement();

								sortedAttrNames.add(attrName);
							}

							Iterator itr = sortedAttrNames.iterator();

							while (itr.hasNext()) {
								String attrName = (String)itr.next();

								String className = "portlet-section-body results-row";
								String classHoverName = "portlet-section-body-hover results-row hover";

								if (MathUtil.isEven(counter++)) {
									className = "portlet-section-alternate results-row alt";
									classHoverName = "portlet-section-alternate-hover results-row alt hover";
								}
					%>

								<tr class="<%= className %>" onMouseEnter="this.className = '<%= classHoverName %>';" onMouseLeave="this.className = '<%= className %>';">
									<td >
										<%= attrName %>
									</td>
								</tr>

					<%
							}
						}
						catch (Exception e) {
							userSessionAlive = false;

							e.printStackTrace();
						}
					}
					%>

					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<c:if test="<%= userSessionAlive && !session.getId().equals(sessionId) %>">
					<input style="margin-left: 0;" type="submit" value="<liferay-ui:message key="back" />" />
				</c:if>
				<input  type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</td>
		</tr>
</table>
</c:otherwise>
</c:choose>
</div>
</div>
</form>