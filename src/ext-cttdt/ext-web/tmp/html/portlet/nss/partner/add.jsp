<%@ include file="/html/portlet/nss/partner/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.partner.model.Partner"%>
<liferay-util:include page="/html/portlet/nss/partner/js/partner-js.jsp"></liferay-util:include>

<%
	String tabDisplay = renderRequest.getParameter("tabDisplay");
	Partner partner = (Partner) renderRequest.getAttribute("partner");
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/partner/view" );
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("tabDisplay", tabDisplay);
%>

<form action="<%= portletURL.toString() %>" enctype="multipart/form-data" method="post" onSubmit="return checkFromPartner();"
	name="<portlet:namespace />fm" class="table-border-pml">
		
	<%
 		if (Validator.isNull(partner)) {
 	%>
	<div id="div-head-title"><liferay-ui:message key="them-moi"/></div>
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><liferay-ui:message key="ten-partner" /></label>:</td>
			<td><input type="text" style="width: 50%;" name="<portlet:namespace />tenpartner" id="<portlet:namespace/>tenpartner" /></td>
		</tr>
		

		<tr>
			<td><label><liferay-ui:message key="url-partner" /></label>:</td>
			<td><input type="text" style="width: 50%;" name="<portlet:namespace />urlpartner" id="<portlet:namespace/>urlpartner" /></td>
		</tr>
		

		<tr>
			<td><label><liferay-ui:message key="description" /></label>:</td>
			<td><textarea name="<portlet:namespace />motapartner" id="motapartner" style="width: 90%;" rows="3"></textarea></td>
		</tr>
		

	    <tr>
			<td><label><liferay-ui:message key="thu-tu-partner" /></label>:</td>
			<td><input type="text" style="width: 90%;" name="<portlet:namespace />thutupartner" id="<portlet:namespace/>thutupartner" /></td>
		</tr>
		

	    <tr>
			<td><label><liferay-ui:message key="target" /></label>:</td>
		    <td align="left">
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 92%;">
					<option value=""><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank"><liferay-ui:message key="blank" /></option>
		    		<option value="_parent"><liferay-ui:message key="parent" /></option>
		    		<option value="_seft"><liferay-ui:message key="seft" /></option>
		    		<option value="_top"><liferay-ui:message key="top" /></option>
		    		<option value="framename"><liferay-ui:message key="framename" /></option>
		    	</select>
		    </td>
		</tr>
		

		<tr>
			<td> <label><liferay-ui:message key="active" /></label>:</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" /></td>
		</tr>
		

     	<tr>
		    <td class="lfr-label"><liferay-ui:message key="file" />:</td>
			<td>
				<input class="lfr-input-text" id="<portlet:namespace />file" style="width: 90%;" name="<portlet:namespace />file" type="file" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
					<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 </td>
			</tr>
	</table>
	
 	<%
 		} else {
 	%>
 	
 	<input type="hidden" name="<portlet:namespace />mapartner" value="<%= partner.getMaPartner()%>" />
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><liferay-ui:message key="ten-partner" /></label>:</td>
			<td><input type="text" style="width: 50%;" name="<portlet:namespace />tenpartner" id="<portlet:namespace/>tenpartner" value="<%= partner.getTenPartner() %>" /></td>
		</tr>
		

	   <tr>
			<td><label><liferay-ui:message key="url-partner" /></label>:</td>
			<td><input type="text" style="width: 50%;" name="<portlet:namespace />urlpartner" id="<portlet:namespace/>urlpartner" value="<%= partner.getUrlPartner() %>"/></td>
		</tr>
		

		<tr>
			<td> <label><liferay-ui:message key="description" /></label>: </td>
			<td><textarea name="<portlet:namespace />mota" id="motapartner" style="width: 90%;" rows="3"><%= partner.getMoTaPartner() %></textarea></td>
		</tr>
		

	    <tr>
			<td> <label><liferay-ui:message key="thu-tu-partner" /></label>: </td>
			<td><input type="text" style="width: 90%;" name="<portlet:namespace />thutupartner" id="<portlet:namespace/>thutupartner" value="<%= partner.getThuTuPartner() %>" /></td>
		</tr>
		

	    <tr>
			<td> <label><liferay-ui:message key="Target" /></label>: </td>
		    <td align="left">
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 92%;">
					<option value="" <%= partner.getTarget().equals("") ? " selected " : "" %>><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank" <%= partner.getTarget().equals("_blank") ? " selected " : "" %>><liferay-ui:message key="blank" /></option>
		    		<option value="_parent" <%= partner.getTarget().equals("_parent") ? " selected " : "" %>><liferay-ui:message key="parent" /></option>
		    		<option value="_seft" <%= partner.getTarget().equals("_seft") ? " selected " : "" %>><liferay-ui:message key="seft" /></option>
		    		<option value="_top" <%= partner.getTarget().equals("_top") ? " selected " : "" %>><liferay-ui:message key="top" /></option>
		    		<option value="framename" <%= partner.getTarget().equals("framename") ? " selected " : "" %>><liferay-ui:message key="framename" /></option>
		    	</select>
		    </td>
		</tr>
		

		<tr>
			<td> <label><liferay-ui:message key="active" /></label>: </td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" <%= partner.getActive() == 1 ? "checked=checked" : ""%> /></td>
		</tr>
		

		<tr>
			<td><label><liferay-ui:message key="image_partner" /></label>: </td>
			<td><img style="width: 100px;height: auto;" align="top" src='<%= themeDisplay.getPathImage() %>/partner?img_id=<%= partner.getImageId_liferay() %>' />
		</tr>
		

	    <tr>
		    <td><liferay-ui:message key="file" />:</td>
			<td><input id="<portlet:namespace />file" style="width: 90%;" name="<portlet:namespace />file" type="file" /></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
					<input type="submit" class="button"	name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 		</td>
			</tr>
	</table>
 	<%
 		}
 	%>
 </form>