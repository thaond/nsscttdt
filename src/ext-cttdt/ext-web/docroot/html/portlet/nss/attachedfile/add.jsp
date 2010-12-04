<%@ include file="/html/portlet/nss/attachedfile/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="com.nss.portlet.attachedfile.model.AttachedFile"%>
<%@page import="com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil"%>
<%@page import="com.nss.portlet.attachedfile.AttachedFileCodeSameCodeException"%>

<script type="text/javascript">
	function validateAttachedfile() {
		var attachedFileCode = document.getElementById("attachedFileCode");
		var attachedFileName = document.getElementById("attachedFileName");
		if (attachedFileCode.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ma'/>")
			attachedFileCode.focus();
			return false;		
		}
		if (attachedFileName.value.trim() == ""){
			alert("<liferay-ui:message key='vui-long-nhap-ten'/>")
			attachedFileName.focus();
			return false;		
		} 
		else {
			return true;
		}
	}

</script>

<%
	
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	
	String attachedFileFlag = request.getAttribute("attachedFileFlag") == null ? "" : String.valueOf(request.getAttribute("attachedFileFlag"));
	
	String attachedFileId = ParamUtil.getString(request, "attachedFileId");
	String attachedFileCode = "";
	String attachedFileName = "";
	String description = "";
	Boolean active = true;
	
	if (attachedFileFlag.equals("fail")) { // Them that bai
		attachedFileCode = ParamUtil.getString(request, "attachedFileCode");
		attachedFileName = ParamUtil.getString(request, "attachedFileName");
		description = ParamUtil.getString(request, "description");
		active = ParamUtil.getBoolean(request, "active");
	}
	
	AttachedFile attachedFile = null;
	try {
		attachedFile = AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId);
	} catch (Exception e) {}
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/nss/attachedfile/view"/>
	<portlet:param name="attachedFileId" value="<%= attachedFileId %>"/>
</portlet:actionURL>

<form action="<%= update %>" method="post" onSubmit="return validateAttachedfile();" enctype="multipart/form-data" name="<portlet:namespace />fm">

<liferay-ui:error exception="<%= AttachedFileCodeSameCodeException.class %>" message="ma-ho-so-dinh-kem-khong-duoc-trung" />
<div class="commom-form">

<%
	if (attachedFileId.equals("") || attachedFile == null) {
%>
	<div class="parent-title"><liferay-ui:message key="add_new"/></div>
		<table width="100%" cellspacing="0" >
			  <tr>
			    <td width="20%">
	    			<label>
			    		<liferay-ui:message key="code." /><font color="#FF0000" size="1">(*)</font>
			    	</label>
			    </td>
			    <td>
			    	<input style="width: 50%" type="text" name="<portlet:namespace />attachedFileCode" id="attachedFileCode" value="<%= attachedFileCode %>"/>
			    </td>

			  </tr>
			  <tr>
			    <td>
			    	<label>
			    		<liferay-ui:message key="pccc-TN-tenhosodinhkem" /><font color="#FF0000" size="1">(*)</font>
			    	</label>
			    </td>
			    <td>
			         <input style="width: 98%" type="text" name="<portlet:namespace />attachedFileName" id="attachedFileName" value="<%= attachedFileName %>"/>
			    </td>							
			  </tr>
			  <tr valign="top">
			    <td>
			    	<label>
			    		<liferay-ui:message key="description" />
			    	</label>
			    </td>
			    <td>
			    	<textarea style="width: 98%" name="<portlet:namespace />description" id="description" rows="5"><%= description %></textarea></td>
			    
			  </tr>
			  <tr>
			    <td>
			    	<label>
			    		<liferay-ui:message key="active." />
			    	</label>
			    </td>
			    <td>
			           <input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked" value="<%= active %>"/>   </td>
			    <td></td>
		  	</tr>
			<tr>
				<td></td>
					<td>
						<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
			    		<input style="margin-left: 0" type="submit" name="button" id="button" value='<liferay-ui:message key="luu" />' /> 
			    		<input  type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
			    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
				   			<input type="button"	value='<liferay-ui:message key="back"/>' />
				   		</span>
				 	</td>
			</tr>
		 </table>
		<%
		} else {
		%>
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
		<table width="100%" cellspacing="0" >
  
			<tr>
			  <td width="20%">
			  	<label>
			  		<liferay-ui:message key="code." /><font color="#FF0000" size="1">(*)</font>
			  	</label>
			  </td>
			  <td>
			  	<input style="width: 50%" type="text" name="<portlet:namespace />attachedFileCode" id="attachedFileCode" value="<%=attachedFile.getAttachedFileCode() %>"/>
			  </td>
			</tr>
			
			<tr>
			  <td>
			  	<label>
			  		<liferay-ui:message key="pccc-TN-tenhosodinhkem" /><font color="#FF0000" size="1">(*)</font>
			  	</label>
			  </td>
			  <td>
			       <input style="width: 98%" type="text" 
			       		name="<portlet:namespace />attachedFileName" 
			       		id="attachedFileName" 
			       		value="<%=attachedFile.getAttachedFileName() %>"/>
			  </td>
			</tr>
			  
			<tr valign="top">
			  <td>
			  	<label>
			  		<liferay-ui:message key="description." />
			  	</label>
			  </td>
			  <td>
			  	<textarea style="width: 98%" name="<portlet:namespace />description" id="description" rows="5"><%=attachedFile.getDescription() %></textarea>    
			  </td>
			</tr>
			
			<tr>
			 <td>
			 	<label>
			 		<liferay-ui:message key="active." />
			 	</label>
			 </td>
			 <td>
			        <input name="<portlet:namespace />active" 
			        		  type="checkbox" 
			        		  id="active" 
			        		  <%=attachedFile.getActive().equals("1") ? "checked=checked":""%>/>   
			  </td>
			  <td></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			  		<input style="margin-left: 0" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
			  		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
			  		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
			   			<input type="button"	value='<liferay-ui:message key="back"/>' />
			   		</span>
			 	</td>
			</tr>
		</table>
	</div>
		<%} %>

</form>
