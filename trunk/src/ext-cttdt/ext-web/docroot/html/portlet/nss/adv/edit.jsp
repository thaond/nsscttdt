<%@ include file="/html/portlet/nss/adv/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.adv.model.QuangCao"%>

<liferay-util:include page="/html/portlet/nss/adv/js/quangcao-js.jsp"></liferay-util:include>

<%
	QuangCao quangCao = (QuangCao) renderRequest.getAttribute("quangCao");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/adv/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>"enctype="multipart/form-data" method="post" onSubmit="return checkFromQuangCao();" name="<portlet:namespace />fm">
<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
	<input type="hidden" name="<portlet:namespace />maQuangCao" value="<%= quangCao.getMaQuangCao()%>">
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-quang-cao" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenQuangCao" class="form-input-box" id="<portlet:namespace/>tenQuangCao" value="<%= quangCao.getTenQuangCao() %>" /></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="url-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />urlQuangCao" class="form-input-box" id="<portlet:namespace/>urlQuangCao" value="<%= quangCao.getUrlWebsite() %>"/></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />mota" class="form-input-box" id="mota" cols="45" rows="5"><%= quangCao.getMoTaQuangCao() %></textarea></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="thu-tu-quang-cao" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />thutuQuangCao" class="form-input-box" id="<portlet:namespace/>thutuQuangCao" value="<%= quangCao.getThuTuQuangCao() %>"/></td>
			<td>&nbsp;</td>
		</tr>
	    
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="Target" /></label>
			</td>
		    <td align="left">
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 71%;">
					<option value="" <%= quangCao.getTarget().equals("") ? " selected " : "" %>><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank" <%= quangCao.getTarget().equals("_blank") ? " selected " : "" %>><liferay-ui:message key="blank" /></option>
		    		<option value="_parent" <%= quangCao.getTarget().equals("_parent") ? " selected " : "" %>><liferay-ui:message key="parent" /></option>
		    		<option value="_seft" <%= quangCao.getTarget().equals("_seft") ? " selected " : "" %>><liferay-ui:message key="seft" /></option>
		    		<option value="_top" <%= quangCao.getTarget().equals("_top") ? " selected " : "" %>><liferay-ui:message key="top" /></option>
		    		<option value="framename" <%= quangCao.getTarget().equals("framename") ? " selected " : "" %>><liferay-ui:message key="framename" /></option>
		    	</select>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="image-website" /></label>
			</td>
			<td>
			<img width='120px' height='90px' src='<%= themeDisplay.getPathImage() %>/adv?img_id=<%= quangCao.getImageId_liferay() %>' />
			<td></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= quangCao.getActive() == 1 ? "checked=checked" : ""%> /></td>
			<td></td>
			<td></td>
		</tr>
     	<tr height="10">
		    <td class="lfr-label">
				<liferay-ui:message key="file" />
			</td>
			<td>
				<input class="lfr-input-text" id="<portlet:namespace />file" name="<portlet:namespace />file" type="file" />
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<table id="table-button">
		<tbody>
			<tr>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
					<input type="submit" class="button"	name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' /></a>
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 		</td>
			</tr>
		</tbody>
	</table>
	</div>
</form>