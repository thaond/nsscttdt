<%@ include file="/html/portlet/nss/link/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.link.model.LienKetWebsite"%>
<%@page import="com.nss.portlet.link.model.LoaiWebsite"%>


<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="java.io.File"%>
<liferay-util:include page="/html/portlet/nss/link/js/lienketwebsiste-js.jsp"></liferay-util:include>

<%
	String tabs = renderRequest.getParameter("tabs");
	String tabDisplay = renderRequest.getParameter("tabDisplay");
	LienKetWebsite lienKetWebsite = (LienKetWebsite) renderRequest.getAttribute("lienKetWebsite");
	List<LoaiWebsite> loaiWebsiteList = (List<LoaiWebsite>)renderRequest.getAttribute("loaiWebsiteList") == null ? new ArrayList<LoaiWebsite>() : (List<LoaiWebsite>)renderRequest.getAttribute("loaiWebsiteList");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/link/view" );
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("tabDisplay", tabDisplay);
	portletURL.setParameter("tabs", tabs);

%>

<form action="<%=portletURL.toString()%>" enctype="multipart/form-data" method="post" onSubmit="return checkFromLienKetWebsite();"
	name="<portlet:namespace />fm" class="table-border-pml">
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<div class="commom-form">
	 <%
 		if (Validator.isNull(lienKetWebsite)) {
 	%>
 	
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table width="100%" border="0" class="common-table">
		<tr>
			<td>
			<label><liferay-ui:message key="ten-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenwebsite" class="form-input-box" id="<portlet:namespace/>tenwebsite" /></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="url-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />urlwebsite" class="form-input-box" id="<portlet:namespace/>urlwebsite" /></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />mota" class="form-input-box" id="mota" cols="45" rows="4"></textarea></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="thu-tu-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />thutuwebsite" class="form-input-box" id="<portlet:namespace/>thutuwebsite" /></td>
			<td>&nbsp;</td>
		</tr>
	    
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="loai-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
		    <td align="left">
				<select name="<portlet:namespace />loaiwebsite" id="<portlet:namespace/>loaiwebsite" style="width: 71%;">
					<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i=0; i < loaiWebsiteList.size(); i++) {
							LoaiWebsite loaiWebsite = loaiWebsiteList.get(i);
					%>	
		    		<option value="<%= loaiWebsite.getMaLoaiWebsite() %>"><%= loaiWebsite.getTenLoaiWebsite() %></option>
					<%
						}
					%>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="Target" /></label>
			</td>
		    <td align="left">
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 71%;">
					<option value=""><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank"><liferay-ui:message key="blank" /></option>
		    		<option value="_parent"><liferay-ui:message key="parent" /></option>
		    		<option value="_seft"><liferay-ui:message key="seft" /></option>
		    		<option value="_top"><liferay-ui:message key="top" /></option>
		    		<option value="framename"><liferay-ui:message key="framename" /></option>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    
	    
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked" /></td>
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
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
		</tbody>
	</table>
 	<%
 		} else {
 	%>
 	<input type="hidden" name="<portlet:namespace />maWebsite" value="<%=  lienKetWebsite.getMaWebsite()%>">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenwebsite" class="form-input-box" id="<portlet:namespace/>tenwebsite" value="<%= lienKetWebsite.getTenWebsite()%>" /></td>
			<td>&nbsp;</td>
		</tr>
	   <tr>
			<td>
			<label><liferay-ui:message key="url-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />urlwebsite" class="form-input-box" id="<portlet:namespace/>urlwebsite" value="<%= lienKetWebsite.getUrlWebsite()%>"/></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />mota" class="form-input-box" id="mota" cols="45" rows="4"><%= lienKetWebsite.getMoTaWebsite() %></textarea></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="thu-tu-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />thutuwebsite" class="form-input-box" id="<portlet:namespace/>thutuwebsite" value="<%= lienKetWebsite.getThuTuWebsite() %>" /></td>
			<td>&nbsp;</td>
		</tr>
	    
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="loai-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
		    <td align="left">
				<select name="<portlet:namespace />loaiwebsite" id="<portlet:namespace/>loaiwebsite" style="width: 71%;">
					<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i=0; i < loaiWebsiteList.size(); i++) {
							LoaiWebsite loaiWebsite = loaiWebsiteList.get(i);
					%>	
		    		<option value="<%= loaiWebsite.getMaLoaiWebsite() %>" <%= loaiWebsite.getMaLoaiWebsite() == lienKetWebsite.getLoaiWebsite() ? " selected " : "" %>><%= loaiWebsite.getTenLoaiWebsite() %></option>
					<%
						}
					%>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="Target" /></label>
			</td>
		    <td align="left">
				<select name="<portlet:namespace />target" id="<portlet:namespace/>target" style="width: 71%;">
					<option value="" <%= lienKetWebsite.getTarget().equals("") ? " selected " : "" %>><liferay-ui:message key="khong-chon" /></option>
		    		<option value="_blank" <%= lienKetWebsite.getTarget().equals("_blank") ? " selected " : "" %>><liferay-ui:message key="blank" /></option>
		    		<option value="_parent" <%= lienKetWebsite.getTarget().equals("_parent") ? " selected " : "" %>><liferay-ui:message key="parent" /></option>
		    		<option value="_seft" <%= lienKetWebsite.getTarget().equals("_seft") ? " selected " : "" %>><liferay-ui:message key="seft" /></option>
		    		<option value="_top" <%= lienKetWebsite.getTarget().equals("_top") ? " selected " : "" %>><liferay-ui:message key="top" /></option>
		    		<option value="framename" <%= lienKetWebsite.getTarget().equals("framename") ? " selected " : "" %>><liferay-ui:message key="framename" /></option>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= lienKetWebsite.getActive() == 1 ? "checked=checked" : ""%> /></td>
			<td></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="image-website" /></label>
			</td>
			<td>
			<img width='120px' height='90px' src='<%= themeDisplay.getPathImage() %>/link?img_id=<%= lienKetWebsite.getImageId_liferay() %>' />
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
 	<%
 		}
 	%>
 	</div>
 </form>