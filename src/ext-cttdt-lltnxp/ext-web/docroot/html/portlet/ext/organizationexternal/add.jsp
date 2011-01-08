<%@ include file="/html/portlet/ext/organizationexternal/init.jsp" %>

<%@page import="com.sgs.portlet.organizationexternal.model.OrganizationExternal"%>
<%@page import="com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil"%>

<%@page import="com.sgs.portlet.organizationexternal.OrganizationExternalCodeSameCodeException"%>

<script type="text/javascript">
	function vaidateAddEdit() {
		var orgExternalCode = document.getElementById("orgExternalCode");
		var orgExternalName = document.getElementById("orgExternalName");

		if (orgExternalCode.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ma'/>")
			orgExternalCode.focus();
			return false;		
		}

		if (orgExternalName.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ten'/>")
			orgExternalName.focus();
			return false;		
		} 

		else {
			return true;
		}
	}
</script>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/organizationexternal/view");
	
	String orgExternalFlag = request.getAttribute("orgExternalFlag") == null ? "" : String.valueOf(request.getAttribute("orgExternalFlag"));
	
	long orgExternalId = ParamUtil.getLong(request, "orgExternalId");
	String orgExternalCode = "";
	String orgExternalName = "";
	Boolean isOwnerOrg = false;
	
	if (orgExternalFlag.equals("fail")) { // Them that bai
		orgExternalCode = ParamUtil.getString(request, "orgExternalCode");
		orgExternalName = ParamUtil.getString(request, "orgExternalName");
		isOwnerOrg = ParamUtil.getBoolean(request, "isOwnerOrg");
	}
	
	OrganizationExternal orgExternal = null;
	try {
		orgExternal = OrganizationExternalLocalServiceUtil.getOrganizationExternal(orgExternalId);
	} catch (Exception e) {}
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onsubmit="return vaidateAddEdit();" enctype="multipart/form-data">

<liferay-ui:error exception="<%= OrganizationExternalCodeSameCodeException.class %>" message="ma-don-vi-lien-thong-khong-duoc-trung" />

<%
	if (orgExternalId == 0 || orgExternal == null) {
%>

<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
  	<tr>
   		<td width="15%">
    		<label>
    			<liferay-ui:message key="ma-to-chuc" />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
    	<td>
    		<input style="width: 50%" type="text" name="<portlet:namespace />orgExternalCode" id="orgExternalCode" value="<%= orgExternalCode %>"/>
    	</td>
  	</tr>
  
	
  	<tr>
    	<td>
    		<label>
    			<liferay-ui:message key="ten-to-chuc" />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
    	<td>
        	<input style="width: 50%" type="text" name="<portlet:namespace />orgExternalName" id="orgExternalName" value="<%= orgExternalName %>"/>
    	</td>
  	</tr>
  	
  	<tr>
    	<td><label><liferay-ui:message key="la-don-vi-cua-minh" />&nbsp;:</label></td>
    	<td>
    		<input name="<portlet:namespace />isOwnerOrg" type="checkbox" id="isOwnerOrg" <%= isOwnerOrg == true ? "checked=checked" : "" %>"/>   
    	</td>
  	</tr>
  	
	<tr>
		<td></td>
	 	<td > 
	   		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	   		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="add_new" />' /> 
	   		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
	   		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
	   			<input type="button" value='<liferay-ui:message key="back"/>' />
	   		</span>
	   	</td>
	</tr>
</table>
</div>

<%
} else {
%>

<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<input type="hidden" name="<portlet:namespace/>orgExternalId" value="<%= orgExternalId %>" id="orgExternalId" />
<div class="boxcontent">
<table cellspacing="0" width="100%" >
  	<tr>
    	<td width="15%">
    		<label>
    			<liferay-ui:message key="ma-to-chuc" />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
	    <td>
	    	<input type="text" style="width: 50%" name="<portlet:namespace />orgExternalCode" id="orgExternalCode" value="<%= orgExternal.getOrgExternalCode() %>"/>
	    </td>
  	</tr>
  
  	
  	<tr>
    	<td>
    		<label>
    			<liferay-ui:message key="ten-to-chuc" />&nbsp;:<font color="red">(*)</font>
    		</label>
   		</td>
    	<td>
         	<input type="text" style="width: 50%" name="<portlet:namespace />orgExternalName" id="orgExternalName" value="<%= orgExternal.getOrgExternalName() %>"/>
   		</td>
  	</tr>
  	
  	<tr>
		<td>
			<label><liferay-ui:message key="la-don-vi-cua-minh" />&nbsp;:</label>
		</td>
		<td>
			<input name="<portlet:namespace />isOwnerOrg" type="checkbox" id="isOwnerOrg" <%= orgExternal.getIsOwnerOrg() == true ? "checked=checked" : "" %> />
		</td>
	</tr>
  	
  	<tr>
  		<td></td>
	   	<td> 
    		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
    			<input type="button" value='<liferay-ui:message key="back"/>' />
    		</span>
    	</td>
    </tr>
</table>
<%} %>
</div>
</form>

