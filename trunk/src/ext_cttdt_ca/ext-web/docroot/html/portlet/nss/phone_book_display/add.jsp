<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

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
				<td><liferay-ui:message key="detail-email" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookEmail"></td>
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
		 if((checkCode(fm) == false) || checkName(fm) == false || (checkDescription(fm) == false) || (checkZip(fm) == false) 
				 || (checkInternal(fm) == false) || (checkHome(fm) == false) || (checkMobile(fm) == false) || (checkEmail(fm) == false)){
			return false;			 
		 }
	 }
	
	 function checkCode(fm){
		var detailBookCode = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookCode.value;
		if(detailBookCode == "" || detailBookCode == null){
			alert("<liferay-ui:message key='input-detail-book-code'/>")
			return false;
		}
	 }
	 
	 function checkName(fm){
		var detailBookName = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookName.value;
		if(detailBookName == "" || detailBookName == null){
			alert("<liferay-ui:message key='input-detail-book-name'/>")
			return false;
		}
     }
	
	 function checkDescription(fm){
		var detailBookDescription = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookDescription.value;
		if(detailBookDescription == "" || detailBookDescription == null){
			alert("<liferay-ui:message key='input-detail-book-description'/>")
			return false;
		}
     }
	 
	 function checkZip(fm) {
		 var detailBookZip = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookZip.value;
	     var checkNum = /([0-9])/;
	        
	     if (detailBookZip != ""){
		      if(detailBookZip < 0 || !checkNum.test(detailBookZip) || isNaN(detailBookZip)){
		    	  alert("<liferay-ui:message key='input-number-validate'/>")
		        return false;
		      }else if(detailBookZip.length < 7 || detailBookZip.length >11){
		    	  alert("<liferay-ui:message key='input-length-number'/>")
		        return false;
		      }
	   	 }
	 }
	 
	 function checkInternal(fm) {
		 var detailBookInternal = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookInternal.value;
	     var checkNum = /([0-9])/;
	        
	     if (detailBookInternal != ""){
		      if(detailBookInternal < 0 || !checkNum.test(detailBookInternal) || isNaN(detailBookInternal)){
		    	  alert("<liferay-ui:message key='input-number-validate'/>")
		        return false;
		      }else if(detailBookInternal.length < 7 || detailBookInternal.length >11){
		    	  alert("<liferay-ui:message key='input-length-number'/>")
		        return false;
		      }
	   	 }
	 }
	 
	 function checkHome(fm) {
		 var detailBookHome = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookHome.value;
	     var checkNum = /([0-9])/;
	        
	     if (detailBookHome != ""){
		      if(detailBookHome < 0 || !checkNum.test(detailBookHome) || isNaN(detailBookHome)){
		    	  alert("<liferay-ui:message key='input-number-validate'/>")
		        return false;
		      }else if(detailBookHome.length < 7 || detailBookHome.length >11){
		    	  alert("<liferay-ui:message key='input-length-number'/>")
		        return false;
		      }
	   	 }
	 }
	 
	 function checkMobile(fm) {
		 var detailBookMobile = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookMobile.value;
	     var checkNum = /([0-9])/;
	        
	     if (detailBookMobile != ""){
		      if(detailBookMobile < 0 || !checkNum.test(detailBookMobile) || isNaN(detailBookMobile)){
		    	  alert("<liferay-ui:message key='input-number-validate'/>")
		        return false;
		      }else if(detailBookMobile.length < 7 || detailBookMobile.length >11){
		    	  alert("<liferay-ui:message key='input-length-number'/>")
		        return false;
		      }
	   	 }
	 }
	 
	 function checkEmail(fm) {
		 var detailBookEmail = document.<portlet:namespace/>fm.<portlet:namespace/>detailBookEmail.value;
	     var regex = /^(([\-\w]+)\.?)+@(([\-\w]+)\.?)+\.[a-zA-Z]{2,4}$/;
	     if (detailBookEmail != ""){
	    	 if (!regex.test(detailBookEmail)){
	    		 alert("<liferay-ui:message key='input-email-validate'/>")
		       return false;
	    	}
	 	}
	 }

</script>
