<%@ include file="/html/portlet/ext/agency/init.jsp" %>
<%@page import="com.sgs.portlet.onedoor.model.PmlAgencyLeader"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<liferay-util:include page="/html/portlet/ext/agency/js/agencyValidate.jsp"></liferay-util:include>
<%@page import="com.sgs.portlet.agency.service.AgencyLocalServiceUtil"%>
<%@page import="com.sgs.portlet.agency.AgencyCodeSameCodeException"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>agency</title>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/agency/view");
	
	String agencyFlag = request.getAttribute("agencyFlag") == null ? "" : String.valueOf(request.getAttribute("agencyFlag"));
	
	String agencyId = ParamUtil.getString(request, "agencyId");
	long userAgencyId = ParamUtil.getLong(request, "userAgencyId");
	
	String agencyCode = "";
	String agencyName = "";
	String description = "";
	boolean active = true;
	long userID = 0;
	
	if (agencyFlag.equals("fail")) { // Them that bai
		agencyCode = ParamUtil.getString(request, "agencyCode");
		agencyName = ParamUtil.getString(request, "agencyName");
		description = ParamUtil.getString(request, "description");
		active = ParamUtil.getBoolean(request, "active");		
		userID = ParamUtil.getLong(request, "userID");
	}
	
	Agency agency = null;
	PmlAgencyLeader agencyLeader = null;
	String userFullName = "";
	if (!agencyId.equals("")) {
		try {
			agency = AgencyLocalServiceUtil.getAgency(agencyId);
			agencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(agencyId);
			User userAgency = UserLocalServiceUtil.getUser(userAgencyId);
			userFullName = userAgency.getLastName().concat(" ").concat(userAgency.getMiddleName()).concat(" ").concat(userAgency.getFirstName());
		} catch (Exception e) {}
	}
%>

<form action="<%= portletURL.toString() %>" method="post" onSubmit="return checkformAgency(this);"
	name="<portlet:namespace />fm" enctype="multipart/form-data" >
	
	<liferay-ui:error exception="<%= AgencyCodeSameCodeException.class %>" message="ma-co-quan-khong-duoc-trung" />
<%
	//Agency agency = (Agency)renderRequest.getAttribute("agency");	
	//PmlAgencyLeader agencyLeader = (PmlAgencyLeader)renderRequest.getAttribute("agencyLeader");

	if (agencyId.equals("") || null == agency) {
%>
<div class="title_categ"><liferay-ui:message key="agency.add"/></div>
<div class="boxcontent">
 <table class="bgtran" width="100%" cellspacing="0" >
 <tr>
    <td width="15%">
    	<label>
    		<liferay-ui:message key="agency.code" />&nbsp;:<font color="red">(*)</font> 
    	</label>
    </td>
    <td>
    	<input style="width: 50%" type="text" name="<portlet:namespace />agencyCode" id="agencyCode" value="<%= agencyCode %>"/>
    </td>

  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="agency.name" />&nbsp;:<font color="red">(*)</font> 
    	</label>
    </td>
    <td>
         <input style="width: 99%" type="text" name="<portlet:namespace />agencyName" id="agencyName" value="<%= agencyName %>"/>
    </td>

  </tr>
  <tr>
    <td valign="top"><label>
    		<liferay-ui:message key="nguoi-dung-dau-co-quan" />&nbsp;:
    	</label>
    </td>
    <td>
    	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
    				<td width="30px" align="center">#</td>
					<td width="30px" align="center"><liferay-ui:message key="pccc-TN-stt" /></td>
					<td width="70%"><liferay-ui:message key="pmluser-danh-sach-nguoi-dung" /></td>
					<td ><liferay-ui:message key="receipt.position" /></td>
				</tr>
			<tbody class="ma-phat-sinh-code">
			<logic:iterate id="userDTO" name="pmlUserDTOList" type="com.sgs.portlet.pmluser.DTO.PmlUserDTO" indexId="i" scope="request">
			
				<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}" onclick="getSelectRadio(this)">
					<td align="center" id="<%=i %>"><input type="radio" id="userID<%=i %>" name="userID" value="<%= userDTO.getPmlUserId() %>"
						<%= (userID == userDTO.getPmlUserId()) ? "checked=checked":"" %> onclick="clickRadio(event)"/></td>
					<td align="center"><%= (i + 1) %></td>
					<td ><%= userDTO.getFullName() %></td>
					<td ><%= userDTO.getPositionName() %></td>
				</tr>
			</logic:iterate>
			</tbody>
	</table>
        	
    </td>	

  </tr>
  <tr valign="top">
    <td><label>
    		<liferay-ui:message key="agency.description" />&nbsp;:
    	</label>
    </td>
    <td>
    	<textarea name="<portlet:namespace />description" id="description" style="width: 99%" rows="5"><%= description %></textarea></td>

  </tr>
  <tr>
    <td><label>
    		<liferay-ui:message key="agency.active" />&nbsp;:
    	</label></td>
    <td>
           <input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked" value="<%= active %>"/></td>
    <td>               </td>
  </tr>
  <tr>
    <td></td>
    <td> 
    	<input style="margin-left: 0;" name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	    		<input style="margin-left: 0;" type="submit" name="button" id="button" value="<liferay-ui:message key="add_new" />" /> 
	    		<input type="reset" name="reset" id="reset" value="<liferay-ui:message key="reset" />" />
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
	<input type="hidden" name="<portlet:namespace />agencyId" value="<%=agency.getAgencyId() %>"/>
	<div class="title_categ"><liferay-ui:message key="agency.update"/></div>
	<div class="boxcontent">
<table width="100%" border="0" class="bgtran">
  <tr>
    <td width="15%">
    	<label>
    		<liferay-ui:message key="agency.code" />&nbsp;:<font color="red">(*)</font> 
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 50%" name="<portlet:namespace />agencyCode" id="agencyCode" value="<%=agency.getAgencyCode() %>"/>
    </td>

  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="agency.name" />&nbsp;:<font color="red">(*)</font> 
    	</label>
    </td>
    <td>
         <input type="text" style="width: 99%"	name="<portlet:namespace />agencyName" id="agencyName" 	value="<%=agency.getAgencyName() %>"/>
    </td>

  </tr>
  <tr>
    <td><label>
    		<liferay-ui:message key="lanh-dao-hien-tai" />&nbsp;:
    	</label>
    </td>
    <td><label><b>
         <%= userFullName %>
        </b></label>
    </td>

  </tr>
  <tr>
    <td valign="top"><label>
    		<liferay-ui:message key="lanh-dao-thay-the" />&nbsp;:
    	</label>
    </td>
    <td class="input-pml">
    	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
    			<td width="30px" align="center">#</td>
					<td width="30px" align="center"><liferay-ui:message key="pccc-TN-stt" /></td>
					<td width="70%"><liferay-ui:message key="pmluser-danh-sach-nguoi-dung" /></td>
					<td ><liferay-ui:message key="receipt.position" /></td>
				</tr>
				<tbody class="ma-phat-sinh-code">
			<logic:iterate id="userDTO" name="pmlUserDTOList" type="com.sgs.portlet.pmluser.DTO.PmlUserDTO" indexId="i" scope="request">
			
				<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}" onclick="getSelectRadio(this)">
					<td align="center" id="<%=i %>"><input type="radio" id="userID<%=i %>" name="userID" value="<%= userDTO.getPmlUserId() %>" <%= (agencyLeader.getUserId() == userDTO.getPmlUserId()) ? "checked=checked":"" %> onclick="clickRadio(event)"/></div></td>
					<td align="center"><div align="center"><%= (i + 1) %></td>
					<td ><%=userDTO.getFullName() %></td>
					<td ><%=userDTO.getPositionName() %></td>
				</tr>
			</logic:iterate>
			</tbody>
	</table>
        	
    </td>	

  </tr>
  <tr valign="top">
    <td><label>
    		<liferay-ui:message key="agency.description" />&nbsp;:
    	</label>
    </td>
    <td>
    	<textarea class="input-pml" name="<portlet:namespace />description" id="description"  style="width: 99%" rows="5"><%=agency.getDescription() %></textarea>    
    </td>

  </tr>
  <tr>
    <td><label>
    		<liferay-ui:message key="agency.active" />&nbsp;:
    	</label>
    </td>
    <td>
           <input name="<portlet:namespace />active" 
           		  type="checkbox" 
           		  id="active" 
           		  <%=agency.getActive().equals("1") ? "checked=checked":""%>/>   
    </td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td > 
    	<input style="margin-left: 0;" name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    		<input style="margin-left: 0;" type="submit" name="button" id="button" value="<liferay-ui:message key="update" />" /> 
    		<input type="reset" name="reset" id="reset" value="<liferay-ui:message key="reset" />" />
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
    			<input type="button" value='<liferay-ui:message key="back"/>' />
    		</span>	
    </td>
  </tr>
  </table>
</div>
<%} %>
</form>
