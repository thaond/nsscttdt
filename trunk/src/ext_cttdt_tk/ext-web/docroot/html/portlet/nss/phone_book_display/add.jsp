<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%	
	long contactBookId = ParamUtil.getLong(renderRequest,"contactBookId");
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view_detail");
	portletURL.setParameter(Constants.CMD,Constants.ADD);
	portletURL.setParameter("redirect", redirect);
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/nss/phone_book/view");
	backURL.setParameter("redirect", redirect);
	backURL.setParameter(Constants.CMD,"DETAIL");
	backURL.setParameter("contactBookId", String.valueOf(contactBookId));
	backURL.setParameter("tabs", "detail");
%>

<a href="<%= backURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' /></span></a>

<br>

<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace/>fm" onsubmit="return check(this);">
	<input type="hidden" name="<portlet:namespace/>contactBookId" value="<%=contactBookId %>">
		<table>
			<tr>
				<td><liferay-ui:message key="detail-code" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookCode"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-name" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookName"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-description" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookDescription"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-zip" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookZip"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-internal" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookInternal"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-home" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookHome"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-mobile" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookMobile"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-active" /></td>
				<td><input type="checkbox" name="<portlet:namespace/>detailBookActive"></td>
			</tr>
		</table>
	<input type="submit" value='<liferay-ui:message key="add" />'>
</form>

<script type="text/javascript">

	 function check(fm){
		 if((checkCode(fm) == false) || checkName(fm) == false || (checkDescription(fm) == false) || (checkMobile(fm) == false)){
			return false;			 
		 }
	 }
	
	 function checkCode(fm){
		var detailBookCode = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookCode.value;
		if(detailBookCode == "" || detailBookCode == null){
			alert("input-detail-book-code");
			return false;
		}
	 }
	 
	 function checkName(fm){
		var detailBookName = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookName.value;
		if(detailBookName == "" || detailBookName == null){
			alert("input-detail-book-name");
			return false;
		}
     }
	
	 function checkDescription(fm){
		var detailBookDescription = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookDescription.value;
		if(detailBookDescription == "" || detailBookDescription == null){
			alert("input-detail-book-description");
			return false;
		}
     }
	 
	 function checkMobile(fm) {
		 var detailBookMobile = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookMobile.value;
	     var checkNum = /([0-9])/;
	        
	     if (detailBookMobile != ""){
		      if(detailBookMobile < 0 || !checkNum.test(detailBookMobile) || isNaN(detailBookMobile)){
		      	 alert("input-number-validate");
		        return false;
		      }else if(detailBookMobile.length < 7 || detailBookMobile.length >11){
		        alert("input-length-number");
		        return false;
		      }
	   	 }
	 }
</script>