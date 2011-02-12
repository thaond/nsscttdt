<%@ include file="/html/portlet/login/init.jsp" %>
<div class="banner_fs"></div>
<div class="boxremember">
<liferay-ui:tabs names="forgot-password">
	<liferay-ui:section>
		<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="forgotPasswordURL">
			<portlet:param name="struts_action" value="/login/view" />
		</portlet:actionURL>

		<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="captchaURL" >
			<portlet:param name="struts_action" value="/login/captcha" />
		</portlet:actionURL>

		<%
		String forgotPasswordHREF = forgotPasswordURL.toString();
		String captchaHREF = captchaURL.toString();
		%>

		<%@ include file="/html/portal/login_forgot_password.jspf" %>
	</liferay-ui:section>
</liferay-ui:tabs>
</div>
<script type="text/javascript">
	Liferay.Util.focusFormField(document.fm3.emailAddress);
</script>