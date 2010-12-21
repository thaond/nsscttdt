<%@ include file="/html/portlet/nss/adv/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-util:include page="/html/portlet/nss/adv/js/quangcao-js.jsp"></liferay-util:include>

<%

	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/adv/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" enctype="multipart/form-data" method="post" onSubmit="return checkFromQuangCao();" name="<portlet:namespace />fm">
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table width="100%" cellspacing="0">
		<tr>
			<td width="18%">
			<label><liferay-ui:message key="ten-quang-cao" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text" name="<portlet:namespace />tenQuangCao" style="width: 90%" id="<portlet:namespace/>tenQuangCao" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="url-website" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text" name="<portlet:namespace />urlQuangCao" style="width: 90%" id="<portlet:namespace/>urlQuangCao" /></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />mota" style="width: 90%" id="mota" rows="3"></textarea></td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="thu-tu-quang-cao" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text" name="<portlet:namespace />thutuQuangCao" style="width: 90%" id="<portlet:namespace/>thutuQuangCao" /></td>
		</tr>
	    <tr>
			<td>
			<label><liferay-ui:message key="Target" /></label>:
			</td>
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
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
		</tr>
     	<tr >
		    <td >
				<liferay-ui:message key="file" />:
			</td>
			<td>
				<input id="<portlet:namespace />file" name="<portlet:namespace />file" type="file" style="width: 90%"/>
			</td>
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
</div>
</form>
