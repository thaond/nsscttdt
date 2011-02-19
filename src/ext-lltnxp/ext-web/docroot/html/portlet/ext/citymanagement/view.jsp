<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.citymanagement.search.CitySearch"%>
<%@page import="com.sgs.portlet.citymanagement.search.CitySearchTerms"%>
<%@page import="com.sgs.portlet.citymanagement.model.City"%>
<%@page import="com.sgs.portlet.citymanagement.service.CityLocalServiceUtil"%>
<%@page import="com.sgs.portlet.citymanagement.CityCanNotDeleteException"%>
<%@page import="com.sgs.portlet.citymanagement.CityCodeSameCodeException"%>
<liferay-util:include page="/html/portlet/ext/citymanagement/js/citymanagement.jsp"></liferay-util:include>
<script type="text/javascript">

	function addCity(url) {	
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
			//checkData();
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	/*
	// phmphuc them 25/08/2010
	// kiem tra add
	function checkData() {
		var code = document.getElementById('<portlet:namespace/>code').value;

		if (code.trim() == "") {
			return true;
		}
		
		cityDWRClient.countCityByCode(code, function (data) {
			if (data > 0) {
				alert("<liferay-ui:message key='ma-tinh-thanhpho-khong-duoc-trung'/>");
				document.getElementById('<portlet:namespace/>code').value = "";
			}
		});
	}

	function checkCityCode() {
		checkData();
	}

	// kiem tra edit
	function checkDataEdit(id) {
		var code = document.getElementById("districtCode" + id).value;

		if (code.trim() == "") {
			return true;
		}
		
		cityDWRClient.countCityByCode(code, function (data) {
			if (data > 1) {
				alert("<liferay-ui:message key='ma-tinh-thanhpho-khong-duoc-trung'/>");
				document.getElementById('<portlet:namespace/>code').value = "";
			}
		});
	}

	function checkCityCodeEdit(id) {
		checkDataEdit(id);
	}
	
	// end phmphuc them 25/08/2010
	*/

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/citymanagement/view");
	
	String cityFlag = request.getAttribute("cityFlag") == null ? "" : String.valueOf(request.getAttribute("cityFlag"));
	String updateFlag = request.getAttribute("updateFlag") == null ? "" : String.valueOf(request.getAttribute("updateFlag"));
	String id = ParamUtil.getString(request, "cityId");
	
	String code = "";
	String name = "";
	String description = "";
	
	if (cityFlag.equals("fail")) { // Them that bai
		code = ParamUtil.getString(request, "code");
		name = ParamUtil.getString(request, "name");
		description = ParamUtil.getString(request, "description");
	}
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/citymanagement/view"/>
</portlet:actionURL>


<form action="<%=add %>" method="post" onsubmit="return validate()" name="<portlet:namespace />fm" enctype="multipart/form-data" >
	<div class="title_categ"><liferay-ui:message key="danh-muc-thanh-pho"/></div>
	<div class="boxcontent">
	<input name="<portlet:namespace />cityURL" type="hidden" value="<%= portletURL.toString() %>" />
	<input name="updateFlag" type="hidden" value="<%= updateFlag %>" id="updateFlag"/>
	<input name="id" type="hidden" value="<%= id %>" id="id"/>
	
	<liferay-ui:error exception="<%= CityCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<liferay-ui:error exception="<%= CityCodeSameCodeException.class %>" message="ma-tinh-thanhpho-khong-duoc-trung" />
		
	<%
		CitySearch citySearch = new CitySearch(renderRequest, portletURL);
		CitySearchTerms searchTerms = (CitySearchTerms)citySearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/citymanagement/search_form.jsp"
		searchContainer="<%= citySearch %>" />
		
	<div id="separator"></div>
	<br/>
	<%
		//URL add issuing place
		PortletURL addCity = renderResponse.createActionURL();
		addCity.setWindowState(WindowState.NORMAL);
		addCity.setParameter(Constants.CMD,Constants.ADD);
		addCity.setParameter("struts_action","/sgs/citymanagement/view");
		addCity.setParameter("redirect", citySearch.getIteratorURL().toString());
	%>
	
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="add-city" /></legend>
			<table cellspacing="0" width="100%">
			<tr>
				<td width="17%" align="right"><label><liferay-ui:message key="citymanagement.code" /><font color="red">(*)</font>:&nbsp;</label></td>
				<td width="10%">
					<input id="<portlet:namespace/>code" name="<portlet:namespace/>code" style="width: 85%" type="text" value="<%= code %>"/>
				</td>
					
				<td width="18%" align="right"><label><liferay-ui:message key="citymanagement.name" /><font color="red">(*)</font>:&nbsp;</label></td>
				<td width="20%" >
					<input id="<portlet:namespace/>name" name="<portlet:namespace/>name" style="width: 95%" type="text" value="<%= name %>" />
				</td>
				
				<td width="5%" align="right"><label><liferay-ui:message key="description" />:&nbsp;</label></td>
				<td align="right" width="22%">
					<input id="<portlet:namespace/>description" name="<portlet:namespace/>description" style="width: 90%" type="text" value="<%= description %>" />
				</td>
				<td align="right"><input onclick="addCity('<%= addCity.toString()  %>')" id="addButton" type="button" value='<liferay-ui:message key="add_new"/>' /></td>
			</tr>
				
		</table>	
				
	</fieldset>
	
	<%
		int total = 0;
		List<City> results = null;
		
		if (searchTerms.isAdvancedSearch()) {
			results = CityLocalServiceUtil.findByTEN_MA_THANH_PHO(searchTerms.getMa(), searchTerms.getTen(),searchTerms.isAndOperator(),
						citySearch.getStart(), citySearch.getEnd(), citySearch.getOrderByComparator());
		
			total = CityLocalServiceUtil.countByTEN_MA_THANH_PHO(searchTerms.getMa(), searchTerms.getTen(),searchTerms.isAndOperator());
		} else {
			results = CityLocalServiceUtil.findByKeywords(searchTerms.getKeywords(), citySearch.getStart(), citySearch.getEnd(), citySearch.getOrderByComparator());
			
			total = CityLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		citySearch.setResults(results);
		citySearch.setTotal(total);
		portletURL.setParameter(citySearch.getCurParam(), String.valueOf(citySearch.getCurValue()));
		
		List resultRow = citySearch.getResultRows();
		ResultRow row = null;
		City city = null;
		
		for (int i=0; i < results.size(); i++) {
			city = results.get(i);
			String cityId = city.getCityID();
			city = city.toEscapedModel();
			
			row = new ResultRow(city, cityId, i);
			
			//URL link quan/huyen
			
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setWindowState(WindowState.NORMAL);
			rowURL.setParameter("struts_action","/sgs/citymanagement/districtmanagement");
			rowURL.setParameter("cityId",cityId);
			rowURL.setParameter("redirect", citySearch.getIteratorURL().toString());
			
			//STT
			row.addText(String.valueOf(i +1),rowURL.toString());

			//ma TP
			StringBuilder cityCode = new StringBuilder();
			
			if (id.equals(cityId) && updateFlag.equals("fail")) {
				cityCode.append("<div id=\"");
				cityCode.append("code".concat(cityId));
				cityCode.append("\" style=\"display: none;\" >");
				cityCode.append(city.getCityCode());
				cityCode.append("<input id=\"");
				cityCode.append("code".concat(cityId).concat("hidden"));
				cityCode.append("\" type=\"hidden\"");
				cityCode.append(" value=\"");
				cityCode.append(city.getCityCode());
				cityCode.append("\">");
				cityCode.append("</div>");	
				
				cityCode.append("<div id=\"");
				cityCode.append("editCode".concat(cityId));
				cityCode.append("\">");
				cityCode.append("<input name=\"");
				cityCode.append("districtCode".concat(cityId));
				cityCode.append("\" style=\"width: 95%\"");
				cityCode.append(" id=\"");
				cityCode.append("districtCode".concat(cityId));
				cityCode.append("\" type=\"text\"");
				cityCode.append(" value=\"");
				cityCode.append(city.getCityCode());
				cityCode.append("\"");
				
				/*cityCode.append(" onblur=\"checkCityCodeEdit('");
				cityCode.append(cityId);
				cityCode.append("');\"");*/
				cityCode.append("/>");
				cityCode.append("</div>");
			} 
			else {
				cityCode.append("<div id=\"");
				cityCode.append("code".concat(cityId));
				cityCode.append("\">");
				cityCode.append(city.getCityCode());
				cityCode.append("<input id=\"");
				cityCode.append("code".concat(cityId).concat("hidden"));
				cityCode.append("\" type=\"hidden\"");
				cityCode.append(" value=\"");
				cityCode.append(city.getCityCode());
				cityCode.append("\">");
				cityCode.append("</div>");	
				
				cityCode.append("<div id=\"");
				cityCode.append("editCode".concat(cityId));
				cityCode.append("\" style=\"display: none;\" >");
				cityCode.append("<input name=\"");
				cityCode.append("districtCode".concat(cityId));
				cityCode.append("\" style=\"width: 95%\"");
				cityCode.append(" id=\"");
				cityCode.append("districtCode".concat(cityId));
				cityCode.append("\" type=\"text\"");
				cityCode.append(" value=\"");
				cityCode.append(city.getCityCode());
				cityCode.append("\"");
				/*cityCode.append(" onblur=\"checkCityCodeEdit('");
				cityCode.append(cityId);
				cityCode.append("');\"");*/
				cityCode.append("/>");
				cityCode.append("</div>");
			}
			
			row.addText(cityCode.toString());
			
			//ten TP
			StringBuilder cityName = new StringBuilder();
			
			if (id.equals(cityId) && updateFlag.equals("fail")) {
				cityName.append("<div id=\"");
				cityName.append("name".concat(cityId));
				cityName.append("\" style=\"display: none;\" >");
				cityName.append(city.getCityName());
				cityName.append("<input id=\"");
				cityName.append("name".concat(cityId).concat("hidden"));
				cityName.append("\" type=\"hidden\"");
				cityName.append(" value=\"");
				cityName.append(city.getCityName());
				cityName.append("\">");
				cityName.append("</div>");	
				
				cityName.append("<div id=\"");
				cityName.append("editName".concat(cityId));
				cityName.append("\">");
				cityName.append("<input name=\"");
				cityName.append("districtName".concat(cityId));
				cityName.append("\" style=\"width: 95%\"");
				cityName.append(" id=\"");
				cityName.append("districtName".concat(cityId));
				cityName.append("\" type=\"text\"");
				cityName.append(" value=\"");
				cityName.append(city.getCityName());
				cityName.append("\" </div>");
			} 
			else {
				cityName.append("<div id=\"");
				cityName.append("name".concat(cityId));
				cityName.append("\">");
				cityName.append(city.getCityName());
				cityName.append("<input id=\"");
				cityName.append("name".concat(cityId).concat("hidden"));
				cityName.append("\" type=\"hidden\"");
				cityName.append(" value=\"");
				cityName.append(city.getCityName());
				cityName.append("\">");
				cityName.append("</div>");	
				
				cityName.append("<div id=\"");
				cityName.append("editName".concat(cityId));
				cityName.append("\" style=\"display: none;\" >");
				cityName.append("<input name=\"");
				cityName.append("districtName".concat(cityId));
				cityName.append("\" style=\"width: 95%\"");
				cityName.append(" id=\"");
				cityName.append("districtName".concat(cityId));
				cityName.append("\" type=\"text\"");
				cityName.append(" value=\"");
				cityName.append(city.getCityName());
				cityName.append("\" </div>");
			}
			
			row.addText(cityName.toString());
			
			//mo ta
			StringBuilder cityDes = new StringBuilder();
			
			if (id.equals(cityId) && updateFlag.equals("fail")) {
				cityDes.append("<div id=\"");
				cityDes.append("description".concat(cityId));
				cityDes.append("\" style=\"display: none;\" >");
				cityDes.append(city.getDescription());
				cityDes.append("<input id=\"");
				cityDes.append("description".concat(cityId).concat("hidden"));
				cityDes.append("\" type=\"hidden\"");
				cityDes.append(" value=\"");
				cityDes.append(city.getDescription());
				cityDes.append("\">");
				cityDes.append("</div>");	
				
				cityDes.append("<div id=\"");
				cityDes.append("editDescription".concat(cityId));
				cityDes.append("\">");
				cityDes.append("<input name=\"");
				cityDes.append("districtDescription".concat(cityId));
				cityDes.append("\" style=\"width: 95%\"");
				cityDes.append(" id=\"");
				cityDes.append("districtDescription".concat(cityId));
				cityDes.append("\" type=\"text\"");
				cityDes.append(" value=\"");
				cityDes.append(city.getDescription());
				cityDes.append("\" </div>");
			}
			else {
				cityDes.append("<div id=\"");
				cityDes.append("description".concat(cityId));
				cityDes.append("\">");
				cityDes.append(city.getDescription());
				cityDes.append("<input id=\"");
				cityDes.append("description".concat(cityId).concat("hidden"));
				cityDes.append("\" type=\"hidden\"");
				cityDes.append(" value=\"");
				cityDes.append(city.getDescription());
				cityDes.append("\">");
				cityDes.append("</div>");	
				
				cityDes.append("<div id=\"");
				cityDes.append("editDescription".concat(cityId));
				cityDes.append("\" style=\"display: none;\" >");
				cityDes.append("<input name=\"");
				cityDes.append("districtDescription".concat(cityId));
				cityDes.append("\" style=\"width: 95%\"");
				cityDes.append(" id=\"");
				cityDes.append("districtDescription".concat(cityId));
				cityDes.append("\" type=\"text\"");
				cityDes.append(" value=\"");
				cityDes.append(city.getDescription());
				cityDes.append("\" </div>");
			}
			
			row.addText(cityDes.toString());
			
			///sua hoac xoa
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
			rowURLEdit.setParameter("struts_action","/sgs/citymanagement/view");
			rowURLEdit.setParameter("cityId",cityId);
			rowURLEdit.setParameter("redirect", citySearch.getIteratorURL().toString());
			
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/citymanagement/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("cityId",cityId);
			rowURLDelete.setParameter("redirect", citySearch.getIteratorURL().toString());

			//script click sua
			
			StringBuilder editOrDelete = new StringBuilder();
			
			if (id.equals(cityId) && updateFlag.equals("fail")) {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(cityId));
				editOrDelete.append("\" style=\"display: none;\" >");
				
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(cityId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteCity('");
				editOrDelete.append(cityId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(cityId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateCity('");
				editOrDelete.append(cityId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(cityId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
			} else {
				editOrDelete.append("<div id=\"");
				editOrDelete.append("editField".concat(cityId));
				editOrDelete.append("\">");
				editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
				editOrDelete.append("' onclick=\"edit('");
				editOrDelete.append(cityId);
				editOrDelete.append("'); \"/>");
				
				//script click xoa
				editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
				editOrDelete.append("' onclick=\"deleteCity('");
				editOrDelete.append(cityId);
				editOrDelete.append("', '");			
				editOrDelete.append(rowURLDelete.toString());			
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
				
				// luu sau khi sua
				editOrDelete.append("<div id=\"");
				editOrDelete.append("updateField".concat(cityId));
				editOrDelete.append("\" style=\"display: none;\" >");
				editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
				editOrDelete.append("' onclick=\"updateCity('");
				editOrDelete.append(cityId);
				editOrDelete.append("', '");
				editOrDelete.append(rowURLEdit.toString());	
				editOrDelete.append("');\"/>");
				
				// click huy
				editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
				editOrDelete.append(" value='");
				editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
				editOrDelete.append("' onclick=\"cancel('");
				editOrDelete.append(cityId);
				editOrDelete.append("');\"/>");
				editOrDelete.append("</div>");
			}
			
			row.addText(editOrDelete.toString());
			
			resultRow.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=citySearch %>" />
</div>
</form>
