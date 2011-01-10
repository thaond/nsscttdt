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

<%@ include file="/html/portlet/nss/vote/init.jsp" %>

<%
String redirect = StringPool.BLANK;

PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeys.POLLS_QUESTION);

question = question.toEscapedModel();

List<PollsChoice> choices = question.getChoices();

boolean hasVoted = PollsUtil.hasVoted(request, question.getQuestionId());

if (!question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE)) {
	String cmd = ParamUtil.getString(request, Constants.CMD);

	if (cmd.equals(Constants.ADD)) {
		long choiceId = ParamUtil.getLong(request, "choiceId");

		try {
			PollsVoteServiceUtil.addVote(question.getQuestionId(), choiceId);

			SessionMessages.add(renderRequest, "vote_added");

			PollsUtil.saveVote(request, question.getQuestionId());

			hasVoted = true;
		}
		catch (DuplicateVoteException dve) {
			SessionErrors.add(renderRequest, dve.getClass().getName());
		}
		catch (NoSuchChoiceException nsce) {
			SessionErrors.add(renderRequest, nsce.getClass().getName());
		}
		catch (QuestionExpiredException qee) {
		}
	}
}
%>

<div class="topbox">
        <h4><liferay-ui:message key="nss-binh-chon" /></h4>
        	<div class="bottombox">
            <div class="centerbox">
			<div class="question">
			<form action="<portlet:renderURL><portlet:param name="struts_action" value="/polls_display/view" /></portlet:renderURL>" method="post" name="<portlet:namespace />fm">
			<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
			<input name="<portlet:namespace />questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			
			<liferay-ui:success key="vote_added" message="thank-you-for-your-vote" />
			
			<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
			<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />
			
			<span><%= question.getDescription() %></span>
			
			<ul>
			
			<c:choose>
				<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
			
					<%
					for (PollsChoice choice : choices) {
						choice = choice.toEscapedModel();
					%>
						<li>
							<input name="<portlet:namespace />choiceId" type="radio" value="<%= choice.getChoiceId() %>" />
							<%= choice.getDescription() %>
						</li>
					<%
					}
					%>
			
					<li>
						<a href="javascript:;" onClick="submitForm(document.<portlet:namespace />fm);"><img src="/html/images/bttsent.jpg" align="absbottom" /></a> 
						<a href="#"><liferay-ui:message key="nss-xem-ket-qua" /> &raquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<%@ include file="/html/portlet/polls/view_question_results.jspf" %>
				</c:otherwise>
			</c:choose>
			</ul>
			</form>
			</div>
		</div>
	</div>
</div>