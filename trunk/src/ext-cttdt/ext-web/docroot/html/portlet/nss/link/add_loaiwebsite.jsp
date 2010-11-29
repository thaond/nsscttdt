<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.link.model.LoaiWebsite"%>
<liferay-util:include page="/html/portlet/nss/link/js/lienketwebsiste-js.jsp"></liferay-util:include>

<%
	String tabs = renderRequest.getParameter("tabs");
	String tabLoai = renderRequest.getParameter("tabLoai");
	LoaiWebsite loaiWebsite = (LoaiWebsite)renderRequest.getAttribute("loaiWebsite"); 
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/link/viewloaiwebsite" );
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("tabLoai", tabLoai);
	portletURL.setParameter("tabs", tabs);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromLoaiWebsite();"
	name="<portlet:namespace />fm">
	 <%
 		if (Validator.isNull(loaiWebsite)) {
 	%>
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ten-loai-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text" name="<portlet:namespace />tenLoaiWebsite"style="width: 90%" id="<portlet:namespace/>tenLoaiWebsite" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />mota"style="width: 90%" id="mota" rows="3"></textarea></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
		</tr>
	     
		<tr>
			<td></td>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
	</table>
 	<%
 		} else {
 	%>
 	<input type="hidden" name="<portlet:namespace />maLoaiWebsite" value="<%= loaiWebsite.getMaLoaiWebsite() %>">
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
				<label><liferay-ui:message key="ten-loai-website" /></label>
				<span style="color: rgb(255, 0, 0);"> *</span>:
				</td>
				<td><input type="text" name="<portlet:namespace />tenLoaiWebsite"style="width: 90%" id="<portlet:namespace/>tenLoaiWebsite" value="<%= loaiWebsite.getTenLoaiWebsite() %>"/></td>
			</tr>
		    
			<tr>
				<td>
				<label><liferay-ui:message key="description" /></label>:
				</td>
				<td><textarea name="<portlet:namespace />mota"style="width: 90%" id="mota" rows="3"><%= loaiWebsite.getMoTaLoaiWebsite() %></textarea></td>
			</tr>
		    
			<tr>
				<td>
				<label><liferay-ui:message key="active" /></label>:
				</td>
				<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
					<%= loaiWebsite.getActive() == 1 ? " checked=checked" : ""%>/></td>
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
	 	<%
	 		}
	 	%>
 </form>
