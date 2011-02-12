<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/html/portlet/ext/callportletother/init.jsp" %>


<liferay-portlet:actionURL var="form" portletConfiguration="true"></liferay-portlet:actionURL>

<form action="<%=form %>" method="post">
	<table style="width: 100%; margin-top: 10px; margin-bottom: 5px">
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="sharing-portlet" />: <div>
			</td>
			<td align="left">
			 	<textarea name='<portlet:namespace/>scriptSharing' class="lfr-textarea"> <%= HtmlUtil.escape(scriptSharing) %></textarea>
			</td>
		</tr>
	</table>
	
	
	<table>
		<tr>
			<td>
				<div style="padding-left: 5px">
					<input type="submit" value='<liferay-ui:message key="save" />'/>
				</div>
			</td>
		</tr>
	</table>

</form>
