<%@ include file="/html/portlet/ext/career/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.career.CareerCodeSameCodeException"%>
<%@page import="com.sgs.portlet.career.service.CareerLocalServiceUtil"%>
<script type="text/javascript">
	function vaidateAddEdit() {
		var careerCode = document.getElementById("careerCode");
		var careerName = document.getElementById("careerName");
		if (careerCode.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ma'/>")
			careerCode.focus();
			return false;		
		}
		if (careerName.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ten'/>")
			careerName.focus();
			return false;		
		} else {
			return true;
		}
	}
	
</script>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/career/view");
	
	String careerFlag = request.getAttribute("careerFlag") == null ? "" : String.valueOf(request.getAttribute("careerFlag"));
	
	String careerId = ParamUtil.getString(request, "careerId");
	String careerCode = "";
	String careerName = "";
	String description = "";
	Boolean active = true;
	
	if (careerFlag.equals("fail")) { // Them that bai
		careerCode = ParamUtil.getString(request, "careerCode");
		careerName = ParamUtil.getString(request, "careerName");
		description = ParamUtil.getString(request, "description");
		active = ParamUtil.getBoolean(request, "active");
	}
	
	Career career = null;
	try {
		career = CareerLocalServiceUtil.getCareer(careerId);
	} catch (Exception e) {}
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onsubmit="return vaidateAddEdit();" enctype="multipart/form-data">

<liferay-ui:error exception="<%= CareerCodeSameCodeException.class %>" message="ma-nganh-nghe-khong-duoc-trung" />

<%
	if (careerId.equals("") || career == null) {
%>
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
  	<tr>
   		<td width="15%">
    		<label>
    			<liferay-ui:message key="code." />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
    	<td>
    		<input style="width: 50%" type="text" name="<portlet:namespace />careerCode" id="careerCode" value="<%= careerCode %>"/>
    	</td>
  	</tr>
  
	
  	<tr>
    	<td>
    		<label>
    			<liferay-ui:message key="name." />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
    	<td>
        	<input style="width: 50%" type="text" name="<portlet:namespace />careerName" id="careerName" value="<%= careerName %>"/>
    	</td>
  	</tr>
  	
  	
  	<tr valign="top">
    	<td>
    		<label><liferay-ui:message key="description." />&nbsp;:</label>
    	</td>
    	<td>
    		<textarea style="width: 95%" name="<portlet:namespace />description" id="description" rows="5"><%= description %></textarea>
    	</td>
  	</tr>
  
  	
  	<tr>
    	<td><label><liferay-ui:message key="active." />&nbsp;:</label></td>
    	<td>
    		<input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked" value="<%= active %>"/>   
    	</td>
  	</tr>

	<tr>
		<td></td>
	 	<td > 
	   		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	   		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="add_new" />' /> 
	   		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
	   		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
	   			<input type="button"	value='<liferay-ui:message key="back"/>' />
	   		</span>
	   	</td>
	</tr>
</table>
</div>
<%
} else {
%>
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<input type="hidden" name="<portlet:namespace/>careerId" value="<%= careerId %>" id="careerId" />
<div class="boxcontent">
<table cellspacing="0" width="100%" >
  	<tr>
    	<td width="15%">
    		<label>
    			<liferay-ui:message key="code." />&nbsp;:<font color="red">(*)</font>
    		</label>
    	</td>
	    <td>
	    	<input type="text" style="width: 50%" name="<portlet:namespace />careerCode" id="careerCode" value="<%= career.getCareerCode() %>"/>
	    </td>
  	</tr>
  
  	
  	<tr>
    	<td>
    		<label>
    			<liferay-ui:message key="name." />&nbsp;:<font color="red">(*)</font>
    		</label>
   		</td>
    	<td>
         	<input type="text" style="width: 50%" name="<portlet:namespace />careerName" id="careerName" value="<%= career.getCareerName() %>"/>
   		</td>
  	</tr>
  	
  	
	<tr valign="top">
		<td>
	    	<label><liferay-ui:message key="description." />&nbsp;:</label>
	    </td>
	    <td>
	    	<textarea name="<portlet:namespace />description" style="width: 95%" id="description" rows="5"><%= career.getDescription() %></textarea>    
	    </td>
  	</tr>
  	
  	
 	<tr>
		<td>
			<label><liferay-ui:message key="active" />&nbsp;:</label>
		</td>
		<td>
			<input name="<portlet:namespace />active" type="checkbox" id="active" <%=career.getActive().equals("1") ? "checked=checked" : ""%> />
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

