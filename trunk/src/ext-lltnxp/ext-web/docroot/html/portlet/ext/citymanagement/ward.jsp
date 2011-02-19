<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>
<%@page import="com.sgs.portlet.citymanagement.model.City"%>
<%@page import="com.sgs.portlet.districtmanagement.model.District"%>
<%@page import="com.sgs.portlet.citymanagement.search.WardsSearch"%>
<%@page import="com.sgs.portlet.wardsmanagement.model.Wards"%>
<%@page import="com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil"%>
<%@page import="com.sgs.portlet.wardsmanagement.WardCodeSameCodeException"%>
<%@page import="com.sgs.portlet.citymanagement.service.CityLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/citymanagement/js/citymanagement.jsp"></liferay-util:include>
<script type="text/javascript">

	function addWard(url) {	
		var valueCode =  document.getElementById("<portlet:namespace/>code").value;
		var valueName =  document.getElementById("<portlet:namespace/>name").value;
		if (valueCode.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ma"/>');
			document.getElementById("<portlet:namespace/>code").focus();
			return false;
		} 
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>name").focus();
			return false;
		} 
		else {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	String wardFlag = request.getAttribute("wardFlag") == null ? "" : String.valueOf(request.getAttribute("wardFlag"));
	String updateFlag = request.getAttribute("updateFlag") == null ? "" : String.valueOf(request.getAttribute("updateFlag"));
	String id = ParamUtil.getString(request, "wardsId");
	
	City city = null;
	String cityId = (String)request.getAttribute("cityId");
	try {
		city = CityLocalServiceUtil.getCity(cityId);
	} catch (Exception e) { }
	
	District district = null;
	String districtId = ParamUtil.getString(request, "districtId");
	try {
		district = DistrictLocalServiceUtil.getDistrict(districtId);
	} catch (Exception e) { }
	
	String code = "";
	String name = "";
	String description = "";
	
	if (wardFlag.equals("fail")) { // Them that bai
		code = ParamUtil.getString(request, "code");
		name = ParamUtil.getString(request, "name");
		description = ParamUtil.getString(request, "description");
	}

	//City city = (City) renderRequest.getAttribute("city");
	//District district  = (District) renderRequest.getAttribute("district");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action","/sgs/citymanagement/wardmanagement");
	portletURL.setParameter("districtId", districtId);
	portletURL.setParameter("cityId", cityId);
%>


<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/citymanagement/wardmanagement"/>
	<portlet:param name="districtId" value="<%= districtId %>"/>
	<portlet:param name="cityId" value="<%= cityId %>"/>
</portlet:actionURL>

<form action="<%=add %>" method="post" onsubmit="return validate();" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<liferay-ui:error exception="<%= WardCodeSameCodeException.class %>" message="ma-phuong-xa-khong-duoc-trung" />
	<input name="<portlet:namespace />wardURL" type="hidden" value="<%= portletURL.toString() %>" />

<div class="title_categ"><liferay-ui:message key="wards-management"/></div>
<div class="boxcontent">	
	<table cellspacing="0" width="100%">
		<tr>
			<td width="16%" style="font-weight: bold;"><liferay-ui:message key="districtmanagement.code"/> :</td>
			<td style="color: #FF5A00;font-weight: bold;"><%= district.getDistrictCode() %></td>
		</tr>
		<tr>
			<td style="font-weight: bold;"><liferay-ui:message key="districtmanagement.name"/> :</td>
			<td style="color: #3286d4;font-weight: bold;"><%= district.getDistrictName() %></td>
		</tr>
		<tr>
			<td style="font-weight: bold;"><liferay-ui:message key="description"/> :</td>
			<td ><%= district.getDescription() %></td>
		</tr>
		<tr>
			<td style="font-weight: bold;"><liferay-ui:message key="citymanagement.name"/> :</td>
			<td style="color: #3286d4;font-weight: bold;"><%= city.getCityName() %></td>
		</tr>
	</table>
	
	<%
		WardsSearch wardsSearch = new WardsSearch(renderRequest, portletURL);
	%>
	
	<div id="separator"></div>
	<br/>
	
	<%
		//URL add issuing place
		PortletURL addWards = renderResponse.createActionURL();
		addWards.setWindowState(WindowState.NORMAL);
		addWards.setParameter(Constants.CMD,Constants.ADD);
		addWards.setParameter("struts_action","/sgs/citymanagement/wardmanagement");
		addWards.setParameter("districtId", district.getDistrictId());
		addWards.setParameter("cityId", cityId);
		addWards.setParameter("redirect", wardsSearch.getIteratorURL().toString());
	%>
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="them-phuong-xa" /></legend>
		<table cellspacing="0" width="100%">
			<tr>
				<td width="15%"  align="right">
					<label><liferay-ui:message key="wardsmanagement.code" />&nbsp;:<font color="red">(*)</font></label></td>
				<td width="10%">
					<input id="<portlet:namespace/>code" name="<portlet:namespace/>code" style="width: 95%" type="text" value="<%= code %>" />
				</td>
					
				<td width="15%" align="right"><label><liferay-ui:message key="wardsmanagement.name" />&nbsp;:<font color="red">(*)</font></label></td>
				<td width="20%">
					<input id="<portlet:namespace/>name" name="<portlet:namespace/>name" style="width: 90%" type="text" value="<%= name %>" />
				</td>
				
				<td width="5%" align="right"><label><liferay-ui:message key="description" />&nbsp;:</label></td>
				<td width="25%">
					<input id="<portlet:namespace/>description" name="<portlet:namespace/>description" style="width: 95%" type="text" value="<%= description %>" />
				</td>
				<td><input onclick="addWard('<%= addWards.toString() %>')" id="addButton" type="button" value='<liferay-ui:message key="add_new"/>' />		</td>
			</tr>
				
		</table>	
	</fieldset>
	<br/><br/>
	
	<%
		int total = 0;
		List<Wards> results = null;
		
		total = WardsLocalServiceUtil.searchCount(district.getDistrictId());
		results = WardsLocalServiceUtil.search(district.getDistrictId(), wardsSearch.getStart(), wardsSearch.getEnd());
		
		wardsSearch.setTotal(total);
		wardsSearch.setResults(results);
		
		portletURL.setParameter(wardsSearch.getCurParam(), String.valueOf(wardsSearch.getCurValue()));
		
		List resultRow = wardsSearch.getResultRows();
		ResultRow row = null;
		Wards wards = null;
		
		for ( int i=0; i < results.size(); i++) {
			wards = results.get(i);
			String wardsId = wards.getWardsId();
			wards = wards.toEscapedModel();
			
			row = new ResultRow(wards, wardsId, i);
			
			//STT
			row.addText(String.valueOf(i +1));
			
			//ma phuong
			StringBuilder wardCode = new StringBuilder();
			
			if (id.equals(wardsId) && updateFlag.equals("fail")) {
				wardCode.append("<div id=\"");
				wardCode.append("code".concat(wardsId));
				wardCode.append("\" style=\"display: none;\" >");
				wardCode.append(wards.getWardsCode());
				wardCode.append("<input id=\"");
				wardCode.append("code".concat(wardsId).concat("hidden"));
				wardCode.append("\" type=\"hidden\"");
				wardCode.append(" value=\"");
				wardCode.append(wards.getWardsCode());
				wardCode.append("\">");
				wardCode.append("</div>");	
				
				wardCode.append("<div id=\"");
				wardCode.append("editCode".concat(wardsId));
				wardCode.append("\">");
				wardCode.append("<input name=\"");
				wardCode.append("districtCode".concat(wardsId));
				wardCode.append("\" style=\"width: 95%\"");
				wardCode.append(" id=\"");
				wardCode.append("districtCode".concat(wardsId));
				wardCode.append("\" type=\"text\"");
				wardCode.append(" value=\"");
				wardCode.append(wards.getWardsCode());
				wardCode.append("\" </div>");
			}
			else {
				wardCode.append("<div id=\"");
				wardCode.append("code".concat(wardsId));
				wardCode.append("\">");
				wardCode.append(wards.getWardsCode());
				wardCode.append("<input id=\"");
				wardCode.append("code".concat(wardsId).concat("hidden"));
				wardCode.append("\" type=\"hidden\"");
				wardCode.append(" value=\"");
				wardCode.append(wards.getWardsCode());
				wardCode.append("\">");
				wardCode.append("</div>");	
				
				wardCode.append("<div id=\"");
				wardCode.append("editCode".concat(wardsId));
				wardCode.append("\" style=\"display: none;\" >");
				wardCode.append("<input name=\"");
				wardCode.append("districtCode".concat(wardsId));
				wardCode.append("\" style=\"width: 95%\"");
				wardCode.append(" id=\"");
				wardCode.append("districtCode".concat(wardsId));
				wardCode.append("\" type=\"text\"");
				wardCode.append(" value=\"");
				wardCode.append(wards.getWardsCode());
				wardCode.append("\" </div>");
			}
			
			row.addText(wardCode.toString());
			
			//ten phuong
			StringBuilder wardsName = new StringBuilder();
			
			if (id.equals(wardsId) && updateFlag.equals("fail")) {
				wardsName.append("<div id=\"");
				wardsName.append("name".concat(wardsId));
				wardsName.append("\" style=\"display: none;\" >");
				wardsName.append(wards.getWardsName());
				wardsName.append("<input id=\"");
				wardsName.append("name".concat(wardsId).concat("hidden"));
				wardsName.append("\" type=\"hidden\"");
				wardsName.append(" value=\"");
				wardsName.append(wards.getWardsName());
				wardsName.append("\">");
				wardsName.append("</div>");	

				wardsName.append("<div id=\"");
				wardsName.append("editName".concat(wardsId));
				wardsName.append("\">");
				wardsName.append("<input name=\"");
				wardsName.append("districtName".concat(wardsId));
				wardsName.append("\" style=\"width: 95%\"");
				wardsName.append(" id=\"");
				wardsName.append("districtName".concat(wardsId));
				wardsName.append("\" type=\"text\"");
				wardsName.append(" value=\"");
				wardsName.append(wards.getWardsName());
				wardsName.append("\" </div>");
			}
			else {
				wardsName.append("<div id=\"");
				wardsName.append("name".concat(wardsId));
				wardsName.append("\">");
				wardsName.append(wards.getWardsName());
				wardsName.append("<input id=\"");
				wardsName.append("name".concat(wardsId).concat("hidden"));
				wardsName.append("\" type=\"hidden\"");
				wardsName.append(" value=\"");
				wardsName.append(wards.getWardsName());
				wardsName.append("\">");
				wardsName.append("</div>");	
				
				wardsName.append("<div id=\"");
				wardsName.append("editName".concat(wardsId));
				wardsName.append("\" style=\"display: none;\" >");
				wardsName.append("<input name=\"");
				wardsName.append("districtName".concat(wardsId));
				wardsName.append("\" style=\"width: 95%\"");
				wardsName.append(" id=\"");
				wardsName.append("districtName".concat(wardsId));
				wardsName.append("\" type=\"text\"");
				wardsName.append(" value=\"");
				wardsName.append(wards.getWardsName());
				wardsName.append("\" </div>");
			}
			
			row.addText(wardsName.toString());

			//mo ta phuong
			StringBuilder wardsDes = new StringBuilder();
			
			if (id.equals(wardsId) && updateFlag.equals("fail")) {
				wardsDes.append("<div id=\"");
				wardsDes.append("description".concat(wardsId));
				wardsDes.append("\" style=\"display: none;\" >");
				wardsDes.append(wards.getDescription());
				wardsDes.append("<input id=\"");
				wardsDes.append("description".concat(wardsId).concat("hidden"));
				wardsDes.append("\" type=\"hidden\"");
				wardsDes.append(" value=\"");
				wardsDes.append(wards.getDescription());
				wardsDes.append("\">");
				wardsDes.append("</div>");	
				
				wardsDes.append("<div id=\"");
				wardsDes.append("editDescription".concat(wardsId));
				wardsDes.append("\">");
				wardsDes.append("<input name=\"");
				wardsDes.append("districtDescription".concat(wardsId));
				wardsDes.append("\" style=\"width: 95%\"");
				wardsDes.append(" id=\"");
				wardsDes.append("districtDescription".concat(wardsId));
				wardsDes.append("\" type=\"text\"");
				wardsDes.append(" value=\"");
				wardsDes.append(wards.getDescription());
				wardsDes.append("\" </div>");
			}
			else {
				wardsDes.append("<div id=\"");
				wardsDes.append("description".concat(wardsId));
				wardsDes.append("\">");
				wardsDes.append(wards.getDescription());
				wardsDes.append("<input id=\"");
				wardsDes.append("description".concat(wardsId).concat("hidden"));
				wardsDes.append("\" type=\"hidden\"");
				wardsDes.append(" value=\"");
				wardsDes.append(wards.getDescription());
				wardsDes.append("\">");
				wardsDes.append("</div>");	
				
				wardsDes.append("<div id=\"");
				wardsDes.append("editDescription".concat(wardsId));
				wardsDes.append("\" style=\"display: none;\" >");
				wardsDes.append("<input name=\"");
				wardsDes.append("districtDescription".concat(wardsId));
				wardsDes.append("\" style=\"width: 95%\"");
				wardsDes.append(" id=\"");
				wardsDes.append("districtDescription".concat(wardsId));
				wardsDes.append("\" type=\"text\"");
				wardsDes.append(" value=\"");
				wardsDes.append(wards.getDescription());
				wardsDes.append("\" </div>");
			}
			
			row.addText(wardsDes.toString());
			
			//sua hoac xoa phuong
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
			rowURLEdit.setParameter("struts_action","/sgs/citymanagement/wardmanagement");
			rowURLEdit.setParameter("wardsId",wardsId);
			rowURLEdit.setParameter("districtId", district.getDistrictId());
			rowURLEdit.setParameter("cityId", cityId);
			rowURLEdit.setParameter("redirect", wardsSearch.getIteratorURL().toString());
			
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.MAXIMIZED);
			rowURLDelete.setParameter("struts_action","/sgs/citymanagement/wardmanagement");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("wardsId",wardsId);
			rowURLDelete.setParameter("districtId", district.getDistrictId());
			rowURLDelete.setParameter("cityId", cityId);
			rowURLDelete.setParameter("redirect", wardsSearch.getIteratorURL().toString());

			//script click sua
			
			StringBuilder editOrDelete = new StringBuilder();
			
			if (id.equals(wardsId) && updateFlag.equals("fail")) {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(wardsId));
				editOrDelete.append("\" style=\"display: none;\" >");
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(wardsId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteWard('");
				editOrDelete.append(wardsId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(wardsId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateWard('");
				editOrDelete.append(wardsId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(wardsId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
			}
			else {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(wardsId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(wardsId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteWard('");
				editOrDelete.append(wardsId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(wardsId));
				editOrDelete.append("\" style=\"display: none;\" >");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateWard('");
				editOrDelete.append(wardsId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(wardsId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
			}
			
			row.addText(editOrDelete.toString());
			
			resultRow.add(row);		
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=wardsSearch %>" />

	<portlet:renderURL var="districtDetail">
		<portlet:param name="struts_action" value="/sgs/citymanagement/districtmanagement"/>
		<portlet:param name="cityId" value="<%= city.getCityID() %>"/>
	</portlet:renderURL>
	
	<div align="right" id="table-button">
				<input type="button" onclick="javascript:submitForm(document.hrefFm,'<%= districtDetail %>');" value='<liferay-ui:message key="back"/>'/>
	</div>
	
</div>
</form>


<% 
	Boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
	if (delete != null && !delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>