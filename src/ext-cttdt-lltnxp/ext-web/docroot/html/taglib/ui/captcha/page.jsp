<%@ include file="/html/taglib/init.jsp" %>
<%@ page import="com.liferay.portal.captcha.CaptchaUtil" %>
<%
String url = (String)request.getAttribute("liferay-ui:captcha:url");
boolean captchaEnabled = false;
if (portletRequest != null) {
	captchaEnabled = CaptchaUtil.isEnabled(portletRequest);
}
else {
	captchaEnabled = CaptchaUtil.isEnabled(request);
}
%>
<c:if test="<%= captchaEnabled %>">
	<div>
		<img alt="captcha" src="<%= url %>" class="imgcapcha"/>
	</div>
	<div class="lfr-table">
	<ul>
		<li class="lftxt">
			<liferay-ui:message key="text-verification" />
		</li>
		<li class="rgtinp">
			<input name="<%= namespace %>captchaText" size="10" type="text" value="" />
		</li>
	</ul>
	</div>
</c:if>