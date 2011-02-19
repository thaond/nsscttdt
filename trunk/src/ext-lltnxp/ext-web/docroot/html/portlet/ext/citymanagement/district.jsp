<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.citymanagement.model.City"%>
<%@page import="com.sgs.portlet.citymanagement.search.DistrictSearch"%>
<%@page import="com.sgs.portlet.districtmanagement.model.District"%>
<%@page import="com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil"%>
<%@page import="com.sgs.portlet.districtmanagement.DistrictCanNotDeleteException"%>
<%@page import="com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException"%>
<%@page import="com.sgs.portlet.citymanagement.service.CityLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/citymanagement/js/citymanagement.jsp"></liferay-util:include>
<script type="text/javascript">
	function addDistrict(url) {	
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
	String districtFlag = request.getAttribute("districtFlag") == null ? "" : String.valueOf(request.getAttribute("districtFlag"));
	String updateFlag = request.getAttribute("updateFlag") == null ? "" : String.valueOf(request.getAttribute("updateFlag"));
	String id = ParamUtil.getString(request, "districtId");
	
	City city = null;
	String cityId = ParamUtil.getString(request, "cityId");
	try {
		city = CityLocalServiceUtil.getCity(cityId);
	} catch (Exception e) { }
	
	
	String code = "";
	String name = "";
	String description = "";
	
	if (districtFlag.equals("fail")) { // Them that bai
		code = ParamUtil.getString(request, "code");
		name = ParamUtil.getString(request, "name");
		description = ParamUtil.getString(request, "description");
	}

	//City city = (City) renderRequest.getAttribute("city");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action","/sgs/citymanagement/districtmanagement");
	portletURL.setParameter("cityId", cityId);
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/citymanagement/districtmanagement"/>
	<portlet:param name="cityId" value="<%= cityId %>"/>
</portlet:actionURL>
<form action="<%=add %>" method="post" onsubmit="return validate();" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input name="<portlet:namespace />districtURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= DistrictCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<liferay-ui:error exception="<%= DistrictCodeSameCodeException.class %>" message="ma-quan-huyen-khong-duoc-trung" />
		
<div class="title_categ"><liferay-ui:message key="districtmanagement.head"/></div>
<div class="boxcontent">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="16%" style="font-weight: bold;"><liferay-ui:message key="citymanagement.code"/> &nbsp;:</td>
			<td style="color: #FF5A00;font-weight: bold;"><%= city.getCityCode() %></td>
		</tr>
		<tr>
			<td style="font-weight: bold;"><liferay-ui:message key="citymanagement.name"/>&nbsp;:</td>
			<td style="color: #3286d4;font-weight: bold;"><%= city.getCityName() %></td>
		</tr>
		<tr>
			<td style="font-weight: bold;"><liferay-ui:message key="description"/>&nbsp;:</td>
			<td ><%= city.getDescription() %></td>
		</tr>
	</table>
	
	<%
		DistrictSearch districtSearch = new DistrictSearch(renderRequest, portletURL);
	%>
	
	<div id="separator"></div>
	<br/>
	
	<%
		//URL add issuing place
		PortletURL addDistrict = renderResponse.createActionURL();
		addDistrict.setWindowState(WindowState.NORMAL);
		addDistrict.setParameter(Constants.CMD,Constants.ADD);
		addDistrict.setParameter("struts_action","/sgs/citymanagement/districtmanagement");
		addDistrict.setParameter("cityId", city.getCityID());
		addDistrict.setParameter("redirect", districtSearch.getIteratorURL().toString());
	%>
	
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="them-quan-huyen" /></legend>
		<table cellspacing="0" width="100%">
			<tr>
				<td width="15%"  align="right"><label><liferay-ui:message key="districtmanagement.code" /><font color="red">(*)</font>:&nbsp;</label></td>
				<td width="10%">
					<input id="<portlet:namespace/>code" name="<portlet:namespace/>code" style="width: 95%" type="text" value="<%= code %>" />
				</td>
					
				<td width="15%"  align="right"><label><liferay-ui:message key="districtmanagement.name" /><font color="red">(*)</font>:&nbsp;</label></td>
				<td width="20%">
					<input id="<portlet:namespace/>name" name="<portlet:namespace/>name" style="width: 90%" type="text" value="<%= name %>" />
				</td>
				
				<td width="5%"  align="right"><label><liferay-ui:message key="description" />:&nbsp;</label></td>
				<td width="25%" >
					<input id="<portlet:namespace/>description" name="<portlet:namespace/>description" style="width: 95%" type="text" value="<%= description %>" />
				</td>
				<td><input onclick="addDistrict('<%= addDistrict.toString()  %>')" id="addButton" type="button" value='<liferay-ui:message key="add_new"/>' />	</td>
			</tr>
				
		</table>	
	</fieldset>
	<br/><br/>
	<%
		int total = 0;
		List<District> results = null;
		
		total = DistrictLocalServiceUtil.searchCount(city.getCityID());
		results = DistrictLocalServiceUtil.search(city.getCityID(), districtSearch.getStart(), districtSearch.getEnd());
		
		districtSearch.setTotal(total);
		districtSearch.setResults(results);
		
		portletURL.setParameter(districtSearch.getCurParam(), String.valueOf(districtSearch.getCurValue()));
		
		List resultRow = districtSearch.getResultRows();
		ResultRow row = null;
		District district = null;
		
		for (int i=0; i < results.size(); i++) {
			district = results.get(i);
			String districtId = district.getDistrictId();
			district = district.toEscapedModel();
			row = new ResultRow(district, districtId, i);
			
			//URL link phuong/xa
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setWindowState(WindowState.NORMAL);
			rowURL.setParameter("struts_action","/sgs/citymanagement/wardmanagement");
			rowURL.setParameter("districtId",districtId);
			rowURL.setParameter("cityId",city.getCityID());
			rowURL.setParameter("redirect", districtSearch.getIteratorURL().toString());
			
			//STT
			row.addText(String.valueOf(i +1), rowURL.toString());
			
			//ma quan
			StringBuilder districtCode = new StringBuilder();
			
			if (id.equals(districtId) && updateFlag.equals("fail")) {
				districtCode.append("<div id=\"");
				districtCode.append("code".concat(districtId));
				districtCode.append("\" style=\"display: none;\" >");
				districtCode.append(district.getDistrictCode());
				districtCode.append("<input id=\"");
				districtCode.append("code".concat(districtId).concat("hidden"));
				districtCode.append("\" type=\"hidden\"");
				districtCode.append(" value=\"");
				districtCode.append(district.getDistrictCode());
				districtCode.append("\">");
				districtCode.append("</div>");	
				
				districtCode.append("<div id=\"");
				districtCode.append("editCode".concat(districtId));
				districtCode.append("\">");
				districtCode.append("<input name=\"");
				districtCode.append("districtCode".concat(districtId));
				districtCode.append("\" style=\"width: 95%\"");
				districtCode.append(" id=\"");
				districtCode.append("districtCode".concat(districtId));
				districtCode.append("\" type=\"text\"");
				districtCode.append(" value=\"");
				districtCode.append(district.getDistrictCode());
				districtCode.append("\" </div>");
			} 
			else {
				districtCode.append("<div id=\"");
				districtCode.append("code".concat(districtId));
				districtCode.append("\">");
				districtCode.append(district.getDistrictCode());
				districtCode.append("</div>");	
				districtCode.append("<input id=\"");
				districtCode.append("code".concat(districtId).concat("hidden"));
				districtCode.append("\" type=\"hidden\"");
				districtCode.append(" value=\"");
				districtCode.append(district.getDistrictCode());
				districtCode.append("\">");
				districtCode.append("<div id=\"");
				districtCode.append("editCode".concat(districtId));
				districtCode.append("\" style=\"display: none;\" >");
				districtCode.append("<input name=\"");
				districtCode.append("districtCode".concat(districtId));
				districtCode.append("\" style=\"width: 95%\"");
				districtCode.append(" id=\"");
				districtCode.append("districtCode".concat(districtId));
				districtCode.append("\" type=\"text\"");
				districtCode.append(" value=\"");
				districtCode.append(district.getDistrictCode());
				districtCode.append("\" </div>");
			}
			
			row.addText(districtCode.toString());
			
			//ten quan
			StringBuilder districtName = new StringBuilder();
			
			if (id.equals(districtId) && updateFlag.equals("fail")) {
				districtName.append("<div id=\"");
				districtName.append("name".concat(districtId));
				districtName.append("\" style=\"display: none;\" >");
				districtName.append(district.getDistrictName());
				districtName.append("<input id=\"");
				districtName.append("name".concat(districtId).concat("hidden"));
				districtName.append("\" type=\"hidden\"");
				districtName.append(" value=\"");
				districtName.append(district.getDistrictName());
				districtName.append("\">");
				districtName.append("</div>");	
				
				districtName.append("<div id=\"");
				districtName.append("editName".concat(districtId));
				districtName.append("\">");
				districtName.append("<input name=\"");
				districtName.append("districtName".concat(districtId));
				districtName.append("\" style=\"width: 95%\"");
				districtName.append(" id=\"");
				districtName.append("districtName".concat(districtId));
				districtName.append("\" type=\"text\"");
				districtName.append(" value=\"");
				districtName.append(district.getDistrictName());
				districtName.append("\" </div>");
			}
			else {
				districtName.append("<div id=\"");
				districtName.append("name".concat(districtId));
				districtName.append("\">");
				districtName.append(district.getDistrictName());
				districtName.append("<input id=\"");
				districtName.append("name".concat(districtId).concat("hidden"));
				districtName.append("\" type=\"hidden\"");
				districtName.append(" value=\"");
				districtName.append(district.getDistrictName());
				districtName.append("\">");
				districtName.append("</div>");	
				
				districtName.append("<div id=\"");
				districtName.append("editName".concat(districtId));
				districtName.append("\" style=\"display: none;\" >");
				districtName.append("<input name=\"");
				districtName.append("districtName".concat(districtId));
				districtName.append("\" style=\"width: 95%\"");
				districtName.append(" id=\"");
				districtName.append("districtName".concat(districtId));
				districtName.append("\" type=\"text\"");
				districtName.append(" value=\"");
				districtName.append(district.getDistrictName());
				districtName.append("\" </div>");
			}
			
			row.addText(districtName.toString());

			//mo ta quan
			StringBuilder districtDes = new StringBuilder();
			
			if (id.equals(districtId) && updateFlag.equals("fail")) {
				districtDes.append("<div id=\"");
				districtDes.append("description".concat(districtId));
				districtDes.append("\" style=\"display: none;\" >");
				districtDes.append(district.getDescription());
				districtDes.append("<input id=\"");
				districtDes.append("description".concat(districtId).concat("hidden"));
				districtDes.append("\" type=\"hidden\"");
				districtDes.append(" value=\"");
				districtDes.append(district.getDescription());
				districtDes.append("\">");
				districtDes.append("</div>");	
				
				districtDes.append("<div id=\"");
				districtDes.append("editDescription".concat(districtId));
				districtDes.append("\">");
				districtDes.append("<input name=\"");
				districtDes.append("districtDescription".concat(districtId));
				districtDes.append("\" style=\"width: 95%\"");
				districtDes.append(" id=\"");
				districtDes.append("districtDescription".concat(districtId));
				districtDes.append("\" type=\"text\"");
				districtDes.append(" value=\"");
				districtDes.append(district.getDescription());
				districtDes.append("\" </div>");
			}
			else {
				districtDes.append("<div id=\"");
				districtDes.append("description".concat(districtId));
				districtDes.append("\">");
				districtDes.append(district.getDescription());
				districtDes.append("</div>");	
				districtDes.append("<input id=\"");
				districtDes.append("description".concat(districtId).concat("hidden"));
				districtDes.append("\" type=\"hidden\"");
				districtDes.append(" value=\"");
				districtDes.append(district.getDescription());
				districtDes.append("\">");
				districtDes.append("<div id=\"");
				districtDes.append("editDescription".concat(districtId));
				districtDes.append("\" style=\"display: none;\" >");
				districtDes.append("<input name=\"");
				districtDes.append("districtDescription".concat(districtId));
				districtDes.append("\" style=\"width: 95%\"");
				districtDes.append(" id=\"");
				districtDes.append("districtDescription".concat(districtId));
				districtDes.append("\" type=\"text\"");
				districtDes.append(" value=\"");
				districtDes.append(district.getDescription());
				districtDes.append("\" </div>");
			}
			
			row.addText(districtDes.toString());	
			
			///sua hoac xoa quan
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
			rowURLEdit.setParameter("struts_action","/sgs/citymanagement/districtmanagement");
			rowURLEdit.setParameter("districtId",districtId);
			rowURLEdit.setParameter("cityId", city.getCityID());
			rowURLEdit.setParameter("redirect", districtSearch.getIteratorURL().toString());
			
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/citymanagement/districtmanagement");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("districtId",districtId);
			rowURLDelete.setParameter("cityId", city.getCityID());
			rowURLDelete.setParameter("redirect", districtSearch.getIteratorURL().toString());

			//script click sua
			
			StringBuilder editOrDelete = new StringBuilder();
			
			if (id.equals(districtId) && updateFlag.equals("fail")) {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(districtId));
				editOrDelete.append("\" style=\"display: none;\" >");
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.gif\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(districtId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/xoa.gif\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteDistrict('");
				editOrDelete.append(districtId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(districtId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateDistrict('");
				editOrDelete.append(districtId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(districtId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
			}
			else {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(districtId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(districtId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteDistrict('");
				editOrDelete.append(districtId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(districtId));
				editOrDelete.append("\" style=\"display: none;\" >");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateDistrict('");
				editOrDelete.append(districtId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(districtId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
			}
			
			row.addText(editOrDelete.toString());
			
			resultRow.add(row);		
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=districtSearch %>" />

	<portlet:renderURL var="cityDetail">
		<portlet:param name="struts_action" value="/sgs/citymanagement/view"/>	
	</portlet:renderURL>
	<div align="right" id="table-button">
		<input type="button" onclick="javascript:submitForm(document.hrefFm,'<%= cityDetail %>');" value='<liferay-ui:message key="back"/>'/>
	</div>
</div>
</form>

