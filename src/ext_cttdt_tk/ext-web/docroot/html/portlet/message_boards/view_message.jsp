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

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

MBMessageDisplay messageDisplay = (MBMessageDisplay)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

MBMessage message = messageDisplay.getMessage();

MBCategory category = messageDisplay.getCategory();

MBThread thread = messageDisplay.getThread();

MBThread previousThread = messageDisplay.getPreviousThread();
MBThread nextThread = messageDisplay.getNextThread();

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

String threadView = messageDisplay.getThreadView();
%>

<script type="text/javascript">
	function <portlet:namespace />addAnswerFlag(messageId) {
		Liferay.Service.MB.MBMessageFlag.addAnswerFlag(
			{
				messageId: messageId
			}
		);

		var addAnswerFlagDiv = jQuery('#<portlet:namespace />addAnswerFlagDiv').clone();

		var html = addAnswerFlagDiv.html();

		html = '<div class="answer" id="<portlet:namespace />deleteAnswerFlag_' + messageId + '">' + html + '</div>';
		html = html.replace(/@MESSAGE_ID@/g, messageId);

		jQuery('#<portlet:namespace />message_' + messageId).find('div.tags:first').html(html);

		jQuery('#<portlet:namespace />addAnswerFlag_' + messageId).remove();
	}

	function <portlet:namespace />deleteAnswerFlag(messageId) {
		Liferay.Service.MB.MBMessageFlag.deleteAnswerFlag(
			{
				messageId: messageId
			}
		);

		var deleteAnswerFlagDiv = jQuery('#<portlet:namespace />deleteAnswerFlagDiv').clone();

		var html = deleteAnswerFlagDiv.html();

		html = '<li id="<portlet:namespace />addAnswerFlag_' + messageId + '">' + html + '</li>';
		html = html.replace(/@MESSAGE_ID@/g, messageId);

		jQuery('#<portlet:namespace />message_' + messageId).find('ul.edit-controls:first').prepend(html);

		jQuery('#<portlet:namespace />deleteAnswerFlag_' + messageId).remove();
	}

	<c:if test="<%= thread.getRootMessageId() != message.getMessageId() %>">
		jQuery(
			function() {
				document.getElementById("<portlet:namespace />message_" + <%= message.getMessageId() %>).scrollIntoView(true);
			}
		);
	</c:if>
</script>

<div id="<portlet:namespace />addAnswerFlagDiv" style="display: none;">
	<liferay-ui:icon
		image="checked"
		message="answer"
		label="<%= true %>"
	/>

	(<a href="javascript: <portlet:namespace />deleteAnswerFlag('@MESSAGE_ID@');"><liferay-ui:message key="unmark" /></a>)
</div>

<div id="<portlet:namespace />deleteAnswerFlagDiv" style="display: none;">

	<%
	String taglibMarkAsAnAnswerURL = "javascript: " + renderResponse.getNamespace() + "addAnswerFlag('@MESSAGE_ID@');";
	%>

	<liferay-ui:icon
		image="checked"
		message="mark-as-an-answer"
		url="<%= taglibMarkAsAnAnswerURL %>"
		label="<%= true %>"
	/>
</div>

<c:if test="<%= includeFormTag %>">
	<input name="<portlet:namespace />breadcrumbsCategoryId" type="hidden" value="<%= category.getCategoryId() %>" />
	<input name="<portlet:namespace />breadcrumbsMessageId" type="hidden" value="<%= message.getMessageId() %>" />
	<input name="<portlet:namespace />threadId" type="hidden" value="<%= message.getThreadId() %>" />
</c:if>
<div class="boxlayout">
<liferay-util:include page="/html/portlet/message_boards/tabs1.jsp" />
<div class="borderendTab">
<table cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td class="stretch">
		<div class="breadcrumbs">
			<%= MBUtil.getBreadcrumbs(null, message, pageContext, renderRequest, renderResponse) %>
		</div>
	</td>

	<c:if test="<%= PropsValues.MESSAGE_BOARDS_THREAD_VIEWS.length > 1 %>">
		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadImpl.THREAD_VIEW_COMBINATION) %>">
			<td class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadImpl.THREAD_VIEW_COMBINATION);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_combination"
					message="combination-view"
					url="<%= currentURLObj.toString() %>"
					method="get"
				/>
			</td>
		</c:if>

		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadImpl.THREAD_VIEW_FLAT) %>">
			<td class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadImpl.THREAD_VIEW_FLAT);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_flat"
					message="flat-view"
					url="<%= currentURLObj.toString() %>"
					method="get"
				/>
			</td>
		</c:if>

		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadImpl.THREAD_VIEW_TREE) %>">
			<td class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadImpl.THREAD_VIEW_TREE);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_tree"
					message="tree-view"
					url="<%= currentURLObj.toString() %>"
					method="get"
				/>
			</td>
		</c:if>
	</c:if>
</tr>
</table>
<table cellspacing="0" width="100%" class="thread-controls" style="background: #daf5fd;">
	<tr>
		<td width="50%">
			<div class="portlet-section-header results-header title">
				<%= HtmlUtil.escape(message.getSubject()) %>
			</div>
		</td>
		<td width="30%">
			<div class="thread-actions">
				<table class="lfr-table">
				<tr>
					<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.ADD_MESSAGE) %>">
						<td>
							<portlet:renderURL var="addMessageURL">
								<portlet:param name="struts_action" value="/message_boards/edit_message" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
								<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
							</portlet:renderURL>
		
							<liferay-ui:icon image="post" message="post-new-thread" url="<%= addMessageURL %>" label="<%= true %>" />
						</td>
					</c:if>
		
					<c:if test="<%= MBMessagePermission.contains(permissionChecker, message, ActionKeys.SUBSCRIBE) %>">
						<td>
							<c:choose>
								<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(user.getCompanyId(), user.getUserId(), MBThread.class.getName(), message.getThreadId()) %>">
									<portlet:actionURL var="unsubscribeURL">
										<portlet:param name="struts_action" value="/message_boards/edit_message" />
										<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
									</portlet:actionURL>
		
									<liferay-ui:icon image="unsubscribe" url="<%= unsubscribeURL %>" label="<%= true %>" />
								</c:when>
								<c:otherwise>
									<portlet:actionURL var="subscribeURL">
										<portlet:param name="struts_action" value="/message_boards/edit_message" />
										<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
									</portlet:actionURL>
		
									<liferay-ui:icon image="subscribe" url="<%= subscribeURL %>" label="<%= true %>" />
								</c:otherwise>
							</c:choose>
						</td>
					</c:if>
		
					<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.MOVE_THREAD) %>">
						<td>
							<portlet:renderURL var="editThreadURL">
								<portlet:param name="struts_action" value="/message_boards/move_thread" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
								<portlet:param name="threadId" value="<%= String.valueOf(message.getThreadId()) %>" />
							</portlet:renderURL>
		
							<liferay-ui:icon image="forward" message="move-thread" url="<%= editThreadURL %>" label="<%= true %>" />
						</td>
					</c:if>
				</tr>
				</table>
			</div>
		</td>
		<td >
			<div class="thread-navigation">
				<liferay-ui:message key="threads" />
				[
				<c:if test="<%= previousThread != null %>">
					<a href="<portlet:renderURL><portlet:param name="struts_action" value="/message_boards/view_message" /><portlet:param name="messageId" value="<%= String.valueOf(previousThread.getRootMessageId()) %>" /></portlet:renderURL>">
				</c:if>
		
				<liferay-ui:message key="previous" />
				<c:if test="<%= previousThread != null %>">
					</a>
				</c:if>
				|
				<c:if test="<%= nextThread != null %>">
					<a href="<portlet:renderURL><portlet:param name="struts_action" value="/message_boards/view_message" /><portlet:param name="messageId" value="<%= String.valueOf(nextThread.getRootMessageId()) %>" /></portlet:renderURL>">
				</c:if>
		
				<liferay-ui:message key="next" />
				<c:if test="<%= nextThread != null %>">
					</a>
				</c:if>
				]
			</div>
		</td>
	</tr>
</table>

<div>

	<%
	MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

	List<MBMessage> messages = null;

	if (treeWalker != null) {
		messages = new ArrayList<MBMessage>();

		messages.addAll(treeWalker.getMessages());

		messages = ListUtil.sort(messages, new MessageCreateDateComparator(true));
	}

	TagsUtil.addLayoutTagsEntries(request, TagsEntryLocalServiceUtil.getEntries(MBMessage.class.getName(), thread.getRootMessageId(), true));
	%>

	<div class="message-scroll" id="<portlet:namespace />message_0"></div>

	<c:if test='<%= threadView.equals(MBThreadImpl.THREAD_VIEW_COMBINATION) && (messages.size() > 1) %>'>
		<liferay-ui:toggle-area id="toggle_id_message_boards_view_message_thread">
			<table class="toggle_id_message_boards_view_message_thread">

			<%
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, treeWalker.getRoot());
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
			%>

			<liferay-util:include page="/html/portlet/message_boards/view_thread_shortcut.jsp" />

			</table>
		</liferay-ui:toggle-area>
	</c:if>

	<c:choose>
		<c:when test='<%= threadView.equals(MBThreadImpl.THREAD_VIEW_TREE) %>'>

			<%
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, treeWalker.getRoot());
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
			%>

			<liferay-util:include page="/html/portlet/message_boards/view_thread_tree.jsp" />
		</c:when>
		<c:otherwise>
			<%@ include file="/html/portlet/message_boards/view_thread_flat.jspf" %>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="<%= includeFormTag %>">
</div>
</div>
</c:if>

<%
MBMessageFlagLocalServiceUtil.addReadFlags(themeDisplay.getUserId(), thread);

message = messageDisplay.getMessage();

PortalUtil.setPageSubtitle(message.getSubject(), request);
PortalUtil.setPageDescription(message.getSubject(), request);

List<TagsEntry> tagsEntries = TagsEntryLocalServiceUtil.getEntries(MBMessage.class.getName(), message.getMessageId(), true);

PortalUtil.setPageKeywords(ListUtil.toString(tagsEntries, "name"), request);
%>