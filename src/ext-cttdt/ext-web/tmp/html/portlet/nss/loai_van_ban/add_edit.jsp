<%@ include file="/html/portlet/nss/loai_van_ban/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>

<liferay-util:include page="/html/portlet/nss/loai_van_ban/js/loaivanban-js.jsp"></liferay-util:include>

<%
	LoaiVanBan loaiVanBan = (LoaiVanBan) renderRequest.getAttribute("loaiVanBan");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/loai_van_ban/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromLoaiVanBan();"
	name="<portlet:namespace />fm" >
	<div class="commom-form">
	 <%
 		if (Validator.isNull(loaiVanBan)) {
 	%>
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table width="100%" cellspacing="0">
		<tr>
			<td width="15%">
			<label><liferay-ui:message key="ten-loai-van-ban" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input style="width: 90%" type="text" name="<portlet:namespace />tenLoaiVanBan" id="<portlet:namespace/>tenLoaiVanBan" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%" rows="3"></textarea></td>
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
<br/>
 	<%
 		} else {
 	%>
 	<input type="hidden" name="<portlet:namespace />maLoaiVanBan" value="<%=  loaiVanBan.getMaLoaiVanBan()%>">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table width="100%" cellspacing="0">
		<tr>
			<td width="15%">
			<label><liferay-ui:message key="ten-loai-van-ban" /></label>:
			</td>
			<td><input style="width: 90%" type="text" name="<portlet:namespace />tenLoaiVanBan" id="<portlet:namespace/>tenLoaiVanBan" value="<%= loaiVanBan.getTenLoaiVanBan()%>" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%" rows="3"><%= loaiVanBan.getDescription() %></textarea></td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= loaiVanBan.getActive() == 1 ? "checked=checked" : ""%> /></td>
		</tr>
		<tr>
	     	<td></td>
	     	<td>
	     		<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
					<input type="submit" class="button"	name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
	     	</td>
	     </tr>
	</table>
<br/>
 	<%
 		}
 	%>
 </div>
 </form>
 