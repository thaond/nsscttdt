<%@ include file="/html/portlet/nss/co_quan_ban_hanh/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>
<liferay-util:include page="/html/portlet/nss/co_quan_ban_hanh/js/coquanbanhanh-js.jsp"></liferay-util:include>
<%
CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) renderRequest.getAttribute("coQuanBanHanh");
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/co_quan_ban_hanh/view" );
	portletURL.setParameter("redirect", redirect);
%>
<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromCoQuanBanHanh();" name="<portlet:namespace />fm">
<input type="hidden" name="<portlet:namespace />maCoQuanBanHanh" value="<%= coQuanBanHanh.getMaCoQuanBanHanh()%>">
<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ten-co-quan-ban-hanh" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input style="width: 90%;" type="text" name="<portlet:namespace />tenCoQuanBanHanh" id="<portlet:namespace/>tenCoQuanBanHanh" value="<%= coQuanBanHanh.getTenCoQuanBanHanh()%>" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%;" rows="3"><%= coQuanBanHanh.getDescription() %></textarea></td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= coQuanBanHanh.getActive() == 1 ? "checked=checked" : ""%> /></td>
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
</div>
</form>
