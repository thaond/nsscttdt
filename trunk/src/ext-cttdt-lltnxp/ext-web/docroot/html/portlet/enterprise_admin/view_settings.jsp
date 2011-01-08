<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>
<%
	String tabs2 = ParamUtil.getString(request, "tabs2");
	String tabs3 = ParamUtil.getString(request, "tabs3");
	String portletURLString = (String)request.getAttribute("view.jsp-portletURLString");
%>
<!--<liferay-ui:tabs names="general,authentication,default-user-associations,reserved-screen-names,mail-host-names,email-notifications" param="tabs2" url="<%= portletURLString %>"/>  -->
<liferay-ui:tabs names="general,authentication,reserved-screen-names,mail-host-names,email-notifications" param="tabs2" url="<%= portletURLString %>"/>
<div class="boxcontent_Tab">
<c:choose>
	<c:when test='<%= tabs2.equals("authentication") %>'>
		<liferay-ui:tabs names="general,ldap,cas,ntlm,open-id,open-sso,siteminder" param="tabs3" url="<%= portletURLString %>"/>
		<div class="boxcontent_Tab">
		<c:choose>
			<c:when test='<%= tabs3.equals("ldap") %>'>
				<%@ include file="/html/portlet/enterprise_admin/authentication_ldap.jspf" %>
			</c:when>
			<c:when test='<%= tabs3.equals("cas") %>'>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="20%">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="enabled" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.CAS_AUTH_ENABLED, PropsValues.CAS_AUTH_ENABLED) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="import-cas-users-from-ldap" />&nbsp;:
						<liferay-ui:icon-help message="import-cas-users-from-ldap-help" />
					</td>
					<td>
						<liferay-ui:input-checkbox param="importFromLdap" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.CAS_IMPORT_FROM_LDAP, PropsValues.CAS_IMPORT_FROM_LDAP) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="login-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />loginUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.CAS_LOGIN_URL, PropsKeys.CAS_LOGIN_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="logout-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />logoutUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.CAS_LOGOUT_URL, PropsKeys.CAS_LOGOUT_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="server-name" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />serverName" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.CAS_SERVER_NAME, PropsKeys.CAS_SERVER_NAME) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="service-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />serviceUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.CAS_SERVICE_URL, PropsKeys.CAS_SERVICE_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="validate-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />validateUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.CAS_VALIDATE_URL, PropsKeys.CAS_VALIDATE_URL) %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateCAS');" />
					</td>
				</tr>
				</table>
				
			</c:when>
			<c:when test='<%= tabs3.equals("ntlm") %>'>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="18%">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="enabled" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.NTLM_AUTH_ENABLED, PropsValues.NTLM_AUTH_ENABLED) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="domain-controller" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />domainController" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_DOMAIN_CONTROLLER, PropsValues.NTLM_DOMAIN_CONTROLLER) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="domain" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />domain" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_DOMAIN, PropsValues.NTLM_DOMAIN) %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateNtlm');" />
					</td>
				</tr>
				</table>
				
			</c:when>
			<c:when test='<%= tabs3.equals("open-id") %>'>
				<table cellspacing="0" width="100%">
				<tr >
					<td width="12%" style="vertical-align: middle;">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td width="5%" style="vertical-align: middle;">
						<liferay-ui:input-checkbox param="enabled" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.OPEN_ID_AUTH_ENABLED, PropsValues.OPEN_ID_AUTH_ENABLED) %>' />
					</td>
					<td style="vertical-align: middle;">
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateOpenId');" />
					</td>
				</tr>
				</table>

			</c:when>
			<c:when test='<%= tabs3.equals("open-sso") %>'>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="20%">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="enabled" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.OPEN_SSO_AUTH_ENABLED, PropsValues.OPEN_SSO_AUTH_ENABLED) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="login-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />loginUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LOGIN_URL, PropsValues.OPEN_SSO_LOGIN_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="logout-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />logoutUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LOGOUT_URL, PropsValues.OPEN_SSO_LOGOUT_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="service-url" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />serviceUrl" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_SERVICE_URL, PropsValues.OPEN_SSO_SERVICE_URL) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="screen-name-attribute" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />screenNameAttr" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_SCREEN_NAME_ATTR, PropsValues.OPEN_SSO_SCREEN_NAME_ATTR) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="email-address-attribute" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />emailAddressAttr" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_EMAIL_ADDRESS_ATTR, PropsValues.OPEN_SSO_EMAIL_ADDRESS_ATTR) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="first-name-attribute" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />firstNameAttr" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_FIRST_NAME_ATTR, PropsValues.OPEN_SSO_FIRST_NAME_ATTR) %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="last-name-attribute" />&nbsp;:
					</td>
					<td>
						<input style="width: 90%" name="<portlet:namespace />lastNameAttr" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LAST_NAME_ATTR, PropsValues.OPEN_SSO_LAST_NAME_ATTR) %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateOpenSSO');" />
					</td>
				</tr>
				</table>

			</c:when>
			<c:when test='<%= tabs3.equals("siteminder") %>'>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="20%">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="enabled" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.SITEMINDER_AUTH_ENABLED, PropsValues.SITEMINDER_AUTH_ENABLED) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="import-siteminder-users-from-ldap" />&nbsp;:
						<liferay-ui:icon-help message="import-siteminder-users-from-ldap-help" />
					</td>
					<td>
						<liferay-ui:input-checkbox param="importFromLdap" defaultValue='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.SITEMINDER_IMPORT_FROM_LDAP, PropsValues.SITEMINDER_IMPORT_FROM_LDAP) %>' />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="user-header" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px" name="<portlet:namespace />userHeader" type="text" value="<%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.SITEMINDER_USER_HEADER, PropsValues.SITEMINDER_USER_HEADER) %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;"  type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateSiteMinder');" />
					</td>
				</tr>
				</table>

			</c:when>
			<c:otherwise>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="45%"> 
						<liferay-ui:message key="how-do-users-authenticate" />&nbsp;:
					</td>
					<td>
						<select name="<portlet:namespace />authType" style="width: 150px;">
							<option <%= company.getAuthType().equals(CompanyConstants.AUTH_TYPE_EA) ? "selected" : "" %> value="<%= CompanyConstants.AUTH_TYPE_EA %>"><liferay-ui:message key="by-email-address" /></option>
							<option <%= company.getAuthType().equals(CompanyConstants.AUTH_TYPE_SN) ? "selected" : "" %> value="<%= CompanyConstants.AUTH_TYPE_SN %>"><liferay-ui:message key="by-screen-name" /></option>
							<option <%= company.getAuthType().equals(CompanyConstants.AUTH_TYPE_ID) ? "selected" : "" %> value="<%= CompanyConstants.AUTH_TYPE_ID %>"><liferay-ui:message key="by-user-id" /></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="allow-users-to-automatically-login" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="autoLogin" defaultValue="<%= company.isAutoLogin() %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="allow-users-to-request-forgotten-passwords" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="sendPassword" defaultValue="<%= company.isSendPassword() %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="allow-strangers-to-create-accounts" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="strangers" defaultValue="<%= company.isStrangers() %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="allow-strangers-to-create-accounts-with-a-company-email-address" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="strangersWithMx" defaultValue="<%= company.isStrangersWithMx() %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="require-strangers-to-verify-their-email-address" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-checkbox param="strangersVerify" defaultValue="<%= company.isStrangersVerify() %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateSecurity');" />
					</td>
				</tr>
				</table>

			</c:otherwise>
		</c:choose>
		</div>
	</c:when>
	<c:when test='<%= tabs2.equals("default-user-associations") %>'>
		<liferay-ui:message key="enter-the-default-community-names-per-line-that-are-associated-with-newly-created-users" />
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />defaultGroupNames"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_GROUP_NAMES) %></textarea>
		<br /><br />
		<liferay-ui:message key="enter-the-default-role-names-per-line-that-are-associated-with-newly-created-users" />
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />defaultRoleNames"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_ROLE_NAMES) %></textarea>
		<br /><br />
		<liferay-ui:message key="enter-the-default-user-group-names-per-line-that-are-associated-with-newly-created-users" />
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />defaultUserGroupNames"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_USER_GROUP_NAMES) %></textarea>
		<br /><br />
		<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateDefaultGroupsAndRoles');" />
	</c:when>
	<c:when test='<%= tabs2.equals("reserved-screen-names") %>'>
		<liferay-ui:message key="enter-one-screen-name-per-line-to-reserve-the-screen-name" />
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />reservedScreenNames"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_RESERVED_SCREEN_NAMES) %></textarea>
		<br /><br />
		<liferay-ui:message key="enter-one-user-email-address-per-line-to-reserve-the-user-email-address" />
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />reservedEmailAddresses"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_RESERVED_EMAIL_ADDRESSES) %></textarea>
		<br /><br />
		<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateReservedUsers');" />
	</c:when>
	<c:when test='<%= tabs2.equals("mail-host-names") %>'>
		<%= LanguageUtil.format(pageContext, "enter-one-mail-host-name-per-line-for-all-additional-mail-host-names-besides-x", company.getMx(), false) %>
		<br />
		<textarea rows="3" style="width: 98%" name="<portlet:namespace />mailHostNames"><%= PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_MAIL_HOST_NAMES) %></textarea>
		<br /><br />
		<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveSettings('updateMailHostNames');" />
	</c:when>
	<c:when test='<%= tabs2.equals("email-notifications") %>'>
		<script type="text/javascript">
			<%
			String emailFromName = ParamUtil.getString(request, "emailFromName", PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME));
			String emailFromAddress = ParamUtil.getString(request, "emailFromAddress", PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

			String emailUserAddedSubject = ParamUtil.getString(request, "emailUserAddedSubject", PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT));
			String emailUserAddedBody = ParamUtil.getString(request, "emailUserAddedBody", PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY));

			String emailPasswordSentSubject = ParamUtil.getString(request, "emailPasswordSentSubject", PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT));
			String emailPasswordSentBody = ParamUtil.getString(request, "emailPasswordSentBody", PrefsPropsUtil.getContent(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY));

			String editorParam = "";
			String editorContent = "";

			if (tabs3.equals("account-created-notification")) {
				editorParam = "emailUserAddedBody";
				editorContent = emailUserAddedBody;
			}
			else if (tabs3.equals("password-changed-notification")) {
				editorParam = "emailPasswordSentBody";
				editorContent = emailPasswordSentBody;
			}
			%>

			function <portlet:namespace />initEditor() {
				return "<%= UnicodeFormatter.toString(editorContent) %>";
			}

			function <portlet:namespace />saveEmails() {
				document.<portlet:namespace />fm.method = "post";
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "updateEmails";

				<c:if test='<%= tabs3.endsWith("-notification") %>'>
					document.<portlet:namespace />fm.<portlet:namespace /><%= editorParam %>.value = window.<portlet:namespace />editor.getHTML();
				</c:if>

				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_settings" /></portlet:actionURL>");
			}
		</script>
		<liferay-ui:tabs names="general,account-created-notification,password-changed-notification" param="tabs3" url="<%= portletURLString %>"	/>
		<div class="boxcontent_Tab">
		<liferay-ui:error key="emailFromAddress" message="please-enter-a-valid-email-address" />
		<liferay-ui:error key="emailFromName" message="please-enter-a-valid-name" />
		<liferay-ui:error key="emailPasswordSentBody" message="please-enter-a-valid-body" />
		<liferay-ui:error key="emailPasswordSentSubject" message="please-enter-a-valid-subject" />
		<liferay-ui:error key="emailUserAddedBody" message="please-enter-a-valid-body" />
		<liferay-ui:error key="emailUserAddedSubject" message="please-enter-a-valid-subject" />

		<c:choose>
			<c:when test='<%= tabs3.endsWith("-notification") %>'>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="20%">
						<liferay-ui:message key="enabled" />&nbsp;:
					</td>
					<td>
						<c:choose>
							<c:when test='<%= tabs3.equals("account-created-notification") %>'>
								<liferay-ui:input-checkbox param="emailUserAddedEnabled" defaultValue="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>" />
							</c:when>
							<c:when test='<%= tabs3.equals("password-changed-notification") %>'>
								<liferay-ui:input-checkbox param="emailPasswordSentEnabled" defaultValue="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_ENABLED) %>" />
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="subject" />&nbsp;:
					</td>
					<td>
						<c:choose>
							<c:when test='<%= tabs3.equals("account-created-notification") %>'>
								<input name="<portlet:namespace />emailUserAddedSubject" type="text" value="<%= emailUserAddedSubject %>" />
							</c:when>
							<c:when test='<%= tabs3.equals("password-changed-notification") %>'>
								<input name="<portlet:namespace />emailPasswordSentSubject" type="text" value="<%= emailPasswordSentSubject %>" />
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="body" />&nbsp;:
					</td>
					<td>
						<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />
						<input name="<portlet:namespace /><%= editorParam %>" type="hidden" value="" />
					</td>
				</tr>
				</table>
				<br />
				<b><liferay-ui:message key="definition-of-terms" /></b>
				<br /><br />
				<table cellspacing="0" width="100%">
				<tr>
					<td width="21%">
						<b>[$FROM_ADDRESS$]</b>&nbsp;:
					</td>
					<td>
						<%= emailFromAddress %>
					</td>
				</tr>
				<tr>
					<td>
						<b>[$FROM_NAME$]</b>&nbsp;:
					</td>
					<td>
						<%= emailFromName %>
					</td>
				</tr>
				<tr>
					<td>
						<b>[$PORTAL_URL$]</b>&nbsp;:
					</td>
					<td>
						<%= company.getVirtualHost() %>
					</td>
				</tr>

				<c:if test='<%= tabs3.equals("password-changed-notification") %>'>
					<tr>
						<td>
							<b>[$REMOTE_ADDRESS$]</b>&nbsp;:
						</td>
						<td>
							The browser's remote address
						</td>
					</tr>
					<tr>
						<td>
							<b>[$REMOTE_HOST$]</b>&nbsp;:
						</td>
						<td>
							The browser's remote host
						</td>
					</tr>
				</c:if>

				<tr>
					<td>
						<b>[$TO_ADDRESS$]</b>&nbsp;:
					</td>
					<td>
						The address of the email recipient
					</td>
				</tr>
				<tr>
					<td>
						<b>[$TO_NAME$]</b>&nbsp;:
					</td>
					<td>
						The name of the email recipient
					</td>
				</tr>

				<c:if test='<%= tabs3.equals("password-changed-notification") %>'>
					<tr>
						<td>
							<b>[$USER_AGENT$]</b>&nbsp;:
						</td>
						<td>
							The browser's user agent
						</td>
					</tr>
				</c:if>

				<tr>
					<td>
						<b>[$USER_ID$]</b>&nbsp;:
					</td>
					<td>
						The user ID
					</td>
				</tr>
				<tr>
					<td>
						<b>[$USER_PASSWORD$]</b>&nbsp;:
					</td>
					<td>
						The user password
					</td>
				</tr>
				<tr>
					<td>
						<b>[$USER_SCREENNAME$]</b>&nbsp;:
					</td>
					<td>
						The user screen name
					</td>
				</tr>
				</table>
			</c:when>
			<c:otherwise>
				<table cellspacing="0" width="100%">
				<tr>
					<td width="10%">
						<liferay-ui:message key="name" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px;" name="<portlet:namespace />emailFromName" type="text" value="<%= emailFromName %>" />
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="address" />&nbsp;:
					</td>
					<td>
						<input style="width: 300px;" name="<portlet:namespace />emailFromAddress" type="text" value="<%= emailFromAddress %>" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />saveEmails();" />
					</td>
				</tr>
				
				</table>
			</c:otherwise>
		</c:choose>
		</div>
		
	</c:when>
	<c:otherwise>
		<%@ include file="/html/portlet/enterprise_admin/company.jspf" %>
	</c:otherwise>
</c:choose>
</div>
<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.enterprise_admin.view.jsp";
%>