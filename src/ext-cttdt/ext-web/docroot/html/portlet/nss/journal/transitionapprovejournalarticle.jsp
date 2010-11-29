<%@ include file="/html/portlet/init.jsp" %>

<portlet:actionURL var="form" >
</portlet:actionURL>

<form name="<portlet:namespace/>form"  method="post" action="<%= form %>" >
	<div class="title_categ"><liferay-ui:message key="thong-tin-luan-chuyen-tin"/></div>

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