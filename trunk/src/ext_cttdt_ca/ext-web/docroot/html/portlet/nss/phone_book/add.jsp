<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view");
	portletURL.setParameter(Constants.CMD,Constants.ADD);
	portletURL.setParameter("redirect", redirect);
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/nss/phone_book/view");
%>

<a href="<%= backURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' /></span></a>

<br>

<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace/>fm" onsubmit="return check(this);">
	<table>
		<tr>
			<td><liferay-ui:message key="contact-code" /></td>
			<td><input type="text" id="a" name="<portlet:namespace/>contactBookCode"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="contact-name" /></td>
			<td><input type="text" name="<portlet:namespace/>contactBookName"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="contact-description" /></td>
			<td><input type="text" name="<portlet:namespace/>contactBookDescription"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="contact-active" /></td>
			<td><input type="checkbox" name="<portlet:namespace/>contactBookActive"></td>
		</tr>
	</table>
<input type="submit" value='<liferay-ui:message key="add" />'>
</form>

<script>
	 function check(form){
		 if((checkCode(form) == false) || checkName(form) == false || (checkDescription(form) == false)){
			return false;			 
		 }
	 }
	 
	 function checkCode(form){
		 var contactBookCode = document.<portlet:namespace/>fm.<portlet:namespace/>contactBookCode.value;
			if(contactBookCode == "" || contactBookCode == null){
				alert("<liferay-ui:message key='input-contact-book-code'/>")
				return false;
			}
	    }
	 
	 function checkName(form){
		 var contactBookName = document.<portlet:namespace/>fm.<portlet:namespace/>contactBookName.value;
			if(contactBookName == "" || contactBookName == null){
				alert("<liferay-ui:message key='input-contact-book-name'/>")
				return false;
			}
     }
	
	 function checkDescription(form){
		 var contactBookDescription = document.<portlet:namespace/>fm.<portlet:namespace/>contactBookDescription.value;
			if(contactBookDescription == "" || contactBookDescription == null){
				alert("<liferay-ui:message key='input-contact-book-description'/>")
				return false;
			}
     }
</script>