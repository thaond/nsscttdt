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

<%@ include file="/html/portal/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "already-registered");

String tabs1Names = "already-registered";


if (tabs1Names.equals("already-registered")) {
	tabs1Names = StringPool.BLANK;
}

String redirect = ParamUtil.getString(request, "redirect");

PortletURL createAccountURL = themeDisplay.getURLCreateAccount();

String forgotPasswordHREF = themeDisplay.getPathMain() + "/portal/login";
String captchaHREF = themeDisplay.getPathMain() + "/portal/login_captcha";
%>
<div class="bgcolorlog">
<div id="containerlog-login">

<c:if test="<%= SessionErrors.contains(request, PrincipalException.class.getName()) %>">
	<span class="portlet-msg-error">
		<liferay-ui:message key="you-have-attempted-to-access-a-section-of-the-site-that-requires-authentication" />
		<liferay-ui:message key="please-sign-in-to-continue" />
	</span>
</c:if>

<c:choose>
	<c:when test="<%= company.isSendPassword() %>">
		<liferay-ui:tabs
			names="<%= tabs1Names %>"
			url2="<%= createAccountURL.toString() %>"
			refresh="<%= false %>"
		>
			<liferay-ui:section>
				<%@ include file="/html/portal/login_create_account.jspf" %>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/portal/login_forgot_password.jspf" %>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:when>
	<c:otherwise>
		<liferay-ui:tabs
			names="<%= tabs1Names %>"
			url1="<%= createAccountURL.toString() %>"
			refresh="<%= false %>"
		>
			<liferay-ui:section>
				<%@ include file="/html/portal/login_create_account.jspf" %>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/portal/login_forgot_password.jspf" %>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	<c:choose>
		<c:when test='<%= tabs1.equals("already-registered") %>'>
			Liferay.Util.focusFormField(document.fm1.login);
		</c:when>
		<c:when test='<%= tabs1.equals("forgot-password") %>'>
			Liferay.Util.focusFormField(document.fm3.emailAddress);
		</c:when>
	</c:choose>
</script>
    			

</div>
</div>
<style>
* {margin: 0; padding: 0}
.bgcolorlog {width: 100%; height: 100%;padding: 50px 0 0;background:#1E7DB5 url(/html/images/login/linetopbg.jpg) no-repeat top left;}
#containerlog-login {	width: 315px;height: 160px;background: url(/html/images/login/bglog.jpg) no-repeat top left;margin: 0 auto 0;padding: 160px 265px 110px 370px;}
#containerlog-login legend {display: none; padding-top: 0;}
#containerlog-login .lfr-portal-login .lfr-input-text {width: 250px;}
input.submit-button,input.submit-button.focus,.ie7 input.submit-button,.ie7 input.submit-button.focus
{
	background: url("/html/images/login/buttongo.png") no-repeat top left; height: 57px; width: 93px;border-style: none;padding: 0;margin: 0;
}
.ie7 input.submit-button:hover,input.submit-button:hover
{
	background: url("/html/images/login/buttongo_hv.png") no-repeat top left; height: 57px; width: 93px;border-style: none;padding: 0;margin: 0;
}
.txtli {
	width: 95px;margin-top: 3px;color: #fff;text-transform: capitalize;
}
.uni-form .block-labels label.add_remember {
	padding: 10px 0;color: #fff;font-size: 11px;display: inline;
}
input.txtlogin,input.txtpass,input.txtlogin:hover,input.txtpass:hover,input.txtlogin.focus,input.txtpass.focus {
	border-style: none;width: 110px;margin-top: 3px;
}
.lfr-portal-login form {
	float:left;width:320px;padding-top: 10px;
}
.ctrl-holder td {padding: 0;}
td.addmb {padding-top: 10px;}
.ie .lfr-portal-login,.lfr-portal-login {
	height: 167px;margin: 0;padding: 0
}
.addresslog {color: #e5f6ff;}
.caplock {color: #fff;font-size: 11px;}
</style>