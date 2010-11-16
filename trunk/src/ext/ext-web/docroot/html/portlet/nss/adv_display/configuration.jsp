<%@ include file="/html/portlet/nss/adv_display/init.jsp" %>


<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setParameter("struts_action", "/portlet_configuration/edit_configuration" );
	portletURL.setParameter("portletResource", portletResource);

%>

<form action="<%=portletURL.toString()%>"  method="post">
	<table width="100%" border="0" class="table-border-pml">
		<tr>
			<td>
			<label><liferay-ui:message key="che-do-hien-thi" /></label>
			</td>
			<td align="left">
				<select name="<portlet:namespace />displayStyleAdv" id="<portlet:namespace/>displayStyleAdv" style="width: 71%;">
					<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<option <%= displayStyleAdv.equals("select") ? "selected" : "" %> value="select"><liferay-ui:message key="select-display" /></option>
					<option <%= displayStyleAdv.equals("image") ? "selected" : "" %> value="image"><liferay-ui:message key="image-display" /></option>
					<option <%= displayStyleAdv.equals("up") ? "selected" : "" %> value="up"><liferay-ui:message key="up-display" /></option>
					<option <%= displayStyleAdv.equals("right") ? "selected" : "" %> value="right"><liferay-ui:message key="right-display" /></option>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    <tr height="10"></tr>
	    
	</table>

	<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
	<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
</form>