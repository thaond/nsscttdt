<%@ include file="/html/portlet/my_account/init.jsp" %>
<div class="banner_fs"></div>
<%
String openId = ParamUtil.getString(request, "openId");
User user2 = null;
Contact contact2 = null;
Calendar birthday = CalendarFactoryUtil.getCalendar();
birthday.set(Calendar.MONTH, Calendar.JANUARY);
birthday.set(Calendar.DATE, 1);
birthday.set(Calendar.YEAR, 1970);
boolean male = BeanParamUtil.getBoolean(contact2, request, "male", true);
%>
<form class="formaddact" action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" ><portlet:param name="saveLastPath" value="0" /><portlet:param name="struts_action" value="/login/create_account" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
<c:if test="<%= Validator.isNotNull(openId) %>">
	<input name="<portlet:namespace />openId" type="hidden" value="<%= HtmlUtil.escape(openId) %>" />
</c:if>

<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />
<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />

<c:if test='<%= SessionMessages.contains(request, "missingOpenIdUserInformation") %>'>
	<span class="portlet-msg-info">
		<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
	</span>
</c:if>
<div class="boxaddacount">
		<ul>
			<li class="titlecap"><liferay-ui:message key="thong-tin-dang-ky-ten-truy-cap" /></li>
		</ul>
		<ul>
			<li class="lftxt">
				<liferay-ui:message key="first-name" />
			</li>
			<li class="rgtinp">
				<liferay-ui:input-field model="<%= Contact.class %>" bean="<%= contact2 %>" field="firstName" />
			</li>
		</ul>
		<ul>
			<li class="lftxt">
				<liferay-ui:message key="middle-name" />
			</li>
			<li class="rgtinp">
				<liferay-ui:input-field model="<%= Contact.class %>" bean="<%= contact2 %>" field="middleName"/>
			</li>
		</ul>
		<ul>
			<li class="lftxt">
				<liferay-ui:message key="last-name" />
			</li>
			<li class="rgtinp">
				<liferay-ui:input-field model="<%= Contact.class %>" bean="<%= contact2 %>" field="lastName" />
			</li>
		</ul>

		<c:if test="<%= !PropsValues.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE %>" >
			<ul>
				<li class="lftxt">
					<liferay-ui:message key="screen-name" />
				</li>
				<li class="rgtinp">
					<liferay-ui:input-field model="<%= User.class %>" bean="<%= user2 %>" field="screenName" />
				</li>
			</ul>
		</c:if>

		<ul>
			<li class="lftxt">
				<liferay-ui:message key="email-address" />
			</li>
			<li class="rgtinp">
				<liferay-ui:input-field model="<%= User.class %>" bean="<%= user2 %>" field="emailAddress" />
			</li>
		</ul>

		<c:choose>
			<c:when test="<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY)) %>">
				<ul>
					<li class="lftxt">
						<liferay-ui:message key="birthday" />
					</li>
					<li class="rgtinp">
						<liferay-ui:input-field model="<%= Contact.class %>" bean="<%= contact2 %>" field="birthday" defaultValue="<%= birthday %>" />
					</li>
				</ul>
			</c:when>
			<c:otherwise>
				<input name="<portlet:namespace />birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
				<input name="<portlet:namespace />birthdayDay" type="hidden" value="1" />
				<input name="<portlet:namespace />birthdayYear" type="hidden" value="1970" />
			</c:otherwise>
		</c:choose>

		<c:if test="<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE)) %>">
			<ul>
				<li class="lftxt">
					<liferay-ui:message key="gender" />
				</li>
				<li class="rgtinp">
					<select name="<portlet:namespace />male">
						<option value="1"><liferay-ui:message key="male" /></option>
						<option <%= !male? "selected" : "" %> value="0"><liferay-ui:message key="female" /></option>
					</select>
				</li>
			</ul>
		</c:if>

	<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
				<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="captchaURL">
				<portlet:param name="struts_action" value="/my_account/captcha" />
				</portlet:actionURL>
				<liferay-ui:captcha url="<%= captchaURL %>" />
				
				
	</c:if>
			<ul>
				<li class="lftxt"></li>
				<li class="rgtinp">
					<input type="submit" value="<liferay-ui:message key="save" />" class="btsaveacount"/>
					<input type="button" onclick="javascript:history.go(-1) " value="<liferay-ui:message key="back" />"/>
				</li>
			</ul>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />firstName);
	</script>
</c:if>