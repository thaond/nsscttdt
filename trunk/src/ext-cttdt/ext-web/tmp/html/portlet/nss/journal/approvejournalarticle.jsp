<%@ include file="/html/portlet/init.jsp" %>

<portlet:actionURL var="form" >
</portlet:actionURL>

<form name="<portlet:namespace/>form"  method="post" action="<%= form %>" >
	<div class="title_categ"><liferay-ui:message key="thong-tin-luan-chuyen-tin"/></div>
	<%
	List<User> users = (List<User>)request.getAttribute("users");
	String userIds = "";
	for (int i = 0; i < users.size() - 1; i++) {
		userIds += users.get(i).getUserId() + "_";
	}
	if (users.size() > 0) {
		userIds += users.get(users.size() - 1).getUserId();
	}
	%>
	<br>
	<input type="hidden" name="<portlet:namespace/>userIds" value="${userIds }"/>
	<input type="hidden" name="<portlet:namespace/>groupId" value="${groupId }"/>
	<input type="hidden" name="<portlet:namespace/>articleId" value="${articleId }"/>
	<input type="hidden" name="<portlet:namespace/>version" value="${version }"/>
	<div style="float: right;">
	<liferay-ui:message key="nss-journal-use-sign" /> : <input type="checkbox" name="<portlet:namespace />signArticle"  checked="checked"/>
	</div>
	<div class="boxcontent">
		<table cellspacing="0" width="100%">
			<tr valign="top" >				
				<td width="14%" ><label><liferay-ui:message key="thong-tin-xu-ly" /></label> &nbsp;:</td>
				<td align="right"><textarea name="<portlet:namespace/>processInformation" id="processInformation" rows="2" style="width: 98%"></textarea></td>
			</tr>
		</table>

		<div align="right" id="table-button">		
			<liferay-util:include page="/html/portlet/nss/journal/common/taskAction.jsp"></liferay-util:include>
			<a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
		</div>
	</div>
</form>