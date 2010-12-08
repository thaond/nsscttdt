<%@ include file="/html/portlet/nss/necessary_info/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.necessary_info.model.ThongTinCanThiet"%>

<liferay-util:include page="/html/portlet/nss/necessary_info/js/thongtincanthiet-js.jsp"></liferay-util:include>

<%
	ThongTinCanThiet thongTinCanThiet = (ThongTinCanThiet) renderRequest.getAttribute("thongTinCanThiet");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/necessary_info/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>"enctype="multipart/form-data" method="post" onSubmit="return checkFromThongTinCanThiet();" name="<portlet:namespace />fm" class="table-border-pml">
<input type="hidden" name="<portlet:namespace />maThongTinCanThiet" value="<%= thongTinCanThiet.getMaThongTinCanThiet()%>">
<fieldset>
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table width="100%" cellspacing="0">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ten-thong-tin-can-thiet" /></label>:
			</td>
			<td><input type="text" name="<portlet:namespace />tenThongTinCanThiet" style="width: 95%" id="<portlet:namespace/>tenThongTinCanThiet" value="<%= thongTinCanThiet.getTenThongTinCanThiet() %>" /></td>

		</tr>

		<tr>
			<td>
			<label><liferay-ui:message key="url-website" /></label>:
			</td>
			<td><input type="text" name="<portlet:namespace />urlThongTinCanThiet" style="width: 95%" id="<portlet:namespace/>urlThongTinCanThiet" value="<%= thongTinCanThiet.getUrlWebsite() %>"/></td>

		</tr>

		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />mota" style="width: 95%" id="mota" rows="3"><%= thongTinCanThiet.getMoTaThongTinCanThiet() %></textarea></td>

		</tr>

	    <tr>
			<td>
			<label><liferay-ui:message key="thu-tu-thong-tin-can-thiet" /></label>:
			</td>
			<td><input type="text" name="<portlet:namespace />thutuThongTinCanThiet" style="width: 95%" id="<portlet:namespace/>thutuThongTinCanThiet" value="<%= thongTinCanThiet.getThuTuThongTin() %>"/></td>

		</tr>

	    
	    <tr>
			<td>
			<label><liferay-ui:message key="Target" /></label>:
			</td>
		    <td>
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 97%;">
					<option value="" <%= thongTinCanThiet.getTarget().equals("") ? " selected " : "" %>><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank" <%= thongTinCanThiet.getTarget().equals("_blank") ? " selected " : "" %>><liferay-ui:message key="blank" /></option>
		    		<option value="_parent" <%= thongTinCanThiet.getTarget().equals("_parent") ? " selected " : "" %>><liferay-ui:message key="parent" /></option>
		    		<option value="_seft" <%= thongTinCanThiet.getTarget().equals("_seft") ? " selected " : "" %>><liferay-ui:message key="seft" /></option>
		    		<option value="_top" <%= thongTinCanThiet.getTarget().equals("_top") ? " selected " : "" %>><liferay-ui:message key="top" /></option>
		    		<option value="framename" <%= thongTinCanThiet.getTarget().equals("framename") ? " selected " : "" %>><liferay-ui:message key="framename" /></option>
		    	</select>
		    	</select>
		    </td>

		</tr>

	    <tr>
			<td>
			<label><liferay-ui:message key="image-website" /></label>:
			</td>
			<td>
			<img style="width: 120px; height: auto;" src='<%= themeDisplay.getPathImage() %>/necessary_info?img_id=<%= thongTinCanThiet.getImageId_liferay() %>' />
		</tr>

		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td>
			<input  name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= thongTinCanThiet.getActive() == 1 ? "checked=checked" : ""%> />
			</td>
		</tr>
     	<tr>
		    <td>
				<liferay-ui:message key="file" />:
			</td>
			<td>
				<input style="width: 95%" id="<portlet:namespace />file" name="<portlet:namespace />file" type="file" />
			</td>
		</tr>
		
		<tr>
			<td></td>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
					<input type="submit" class="button"	name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' /></a>
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 		</td>
			</tr>
	</table>
	</fieldset>
</form>