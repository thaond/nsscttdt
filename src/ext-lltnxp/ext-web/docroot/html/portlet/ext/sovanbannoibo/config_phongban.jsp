<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoUtil"%>
<%@page import="com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.PhongBanSearchTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.PhongBanDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.PhongBanSearch"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>

<%	
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	portletURL.setParameter("tab", "config_phongban");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	String backURLString = backURL.toString();
	
	long soVanBanNoiBoId = 0;
	try{
		soVanBanNoiBoId = (Long) request.getAttribute("soVanBanNoiBoId");
	}catch(Exception e){
	}
	List<Department> results = DepartmentLocalServiceUtil.getDepartments(-1,-1);
%>

<div class="title_categ"><liferay-ui:message key="phong-ban-van-ban-noi-bo"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace/>addPhongBan"  type="hidden" value=""/>
	<input name="<portlet:namespace/>soVanBanNoiBoId" type="hidden" value="<%=(soVanBanNoiBoId != 0) ? soVanBanNoiBoId : "" %>">
    	<%
    	PhongBanSearch phongbanSearch = new PhongBanSearch(renderRequest, portletURL);
    	PhongBanDisplayTerms displayTerms = (PhongBanDisplayTerms)phongbanSearch.getDisplayTerms();
    	PhongBanSearchTerms searchTerms = (PhongBanSearchTerms) phongbanSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", PhongBanDisplayTerms.DEPARTMENTSCODE);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = phongbanSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	
    	int countPhongBanVanBanNoiBo = 0;
		String phongBanIsCheck = "";
		StringBuilder rowNameChecked=null;
		
    	List<String> header = phongbanSearch.getHeaderNames();
    	String formName = renderResponse.getNamespace() + "fm";
    	String rowNamePhongBan = renderResponse.getNamespace() + "phongBan";
		String rowAllNamePhongBan = renderResponse.getNamespace() +"allPhongBanVanBanNoiBo";
		
		StringBuilder rowAllPhongBanVanBanNoiBoChecked = new StringBuilder();
		rowAllPhongBanVanBanNoiBoChecked.append("<input name=\"");
		rowAllPhongBanVanBanNoiBoChecked.append(rowAllNamePhongBan);
		rowAllPhongBanVanBanNoiBoChecked.append("\" type=\"checkbox\" ");
		rowAllPhongBanVanBanNoiBoChecked.append("onClick=\"Liferay.Util.checkAll(");
		rowAllPhongBanVanBanNoiBoChecked.append(formName);
		rowAllPhongBanVanBanNoiBoChecked.append(", '");
		rowAllPhongBanVanBanNoiBoChecked.append(rowNamePhongBan);
		rowAllPhongBanVanBanNoiBoChecked.append("', this");
		rowAllPhongBanVanBanNoiBoChecked.append(");\"> ");
		header.add(0,rowAllPhongBanVanBanNoiBoChecked.toString());
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/sovanbannoibo/phongban_search_form.jsp" searchContainer="<%= phongbanSearch %>" />
		<input type="button" name="<portlet:namespace/>config" value='<liferay-ui:message key="update-phong-ban"/>' onclick="<portlet:namespace/>updateConfig();" />
		<a href="<%=backURLString %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
		
				<%
				int count = 0;
				List<Department> listPhongBan = new ArrayList<Department>();
				if (!displayTerms.isAdvancedSearch()) {
					count = DepartmentLocalServiceUtil.searchCount(searchTerms.getKeywords());
					listPhongBan = DepartmentLocalServiceUtil.search(searchTerms.getKeywords(), phongbanSearch.getStart(), phongbanSearch.getEnd(), phongbanSearch.getOrderByComparator());
				}else{
					count = DepartmentLocalServiceUtil.searchCount(searchTerms.getDepartmentsCode(), searchTerms.getDepartmentsName(), searchTerms.getAbbreviateName(), searchTerms.isAndOperator());
					listPhongBan = DepartmentLocalServiceUtil.search(searchTerms.getDepartmentsCode(), searchTerms.getDepartmentsName(), searchTerms.getAbbreviateName(),
							searchTerms.isAndOperator(), phongbanSearch.getStart(), phongbanSearch.getEnd(), phongbanSearch.getOrderByComparator());
				}
				
				phongbanSearch.setResults(listPhongBan);
				phongbanSearch.setTotal(count);
				portletURL.setParameter(phongbanSearch.getCurParam(), String.valueOf(phongbanSearch.getCurValue()));
				List<ResultRow> resultRows = phongbanSearch.getResultRows();
					
					for(int i = 0; i < listPhongBan.size(); i++){
						Department department = listPhongBan.get(i);
						String departmentId = department.getDepartmentsId();
						
						ResultRow row = new ResultRow(department, departmentId, i);
						
						//check
						List<SoPhongVanBanNoiBo> list = SoPhongVanBanNoiBoUtil.findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,departmentId);
						if(list.size() > 0){
							phongBanIsCheck = "1";
							countPhongBanVanBanNoiBo += 1;
						}

						// checked
						rowNameChecked = new StringBuilder();
						rowNameChecked.append("<input ");
						rowNameChecked.append(("1".equals(phongBanIsCheck) ? "checked " : " "));
						rowNameChecked.append("name=\"");
						rowNameChecked.append(rowNamePhongBan);
						rowNameChecked.append("\" type=\"checkbox\" value=\"");
						rowNameChecked.append(departmentId);
						rowNameChecked.append("\" ");
						rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
						rowNameChecked.append(formName);
						rowNameChecked.append(", '");
						rowNameChecked.append(rowNamePhongBan);
						rowNameChecked.append("', ");
						rowNameChecked.append(rowAllNamePhongBan);
						rowNameChecked.append(");\"");
						rowNameChecked.append(">");
						
						phongBanIsCheck = "";
						row.addText(rowNameChecked.toString());
						// STT
						row.addText(String.valueOf(i + 1));
						
						//ma
						row.addText(department.getDepartmentsCode());
						
						//ten
						row.addText(department.getDepartmentsName());
						
						//ten viet tat
						row.addText(department.getAbbreviateName());
						
						resultRows.add(row);
					}
			%>
		
			<liferay-ui:search-iterator searchContainer="<%= phongbanSearch %>" />
	</form>
</div>
<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script>

<script type="text/javascript">
	function <portlet:namespace/>updateConfig(){
		var phongBanCheckboxs = document.getElementsByName("<portlet:namespace/>phongBan");
		var listPhongBanCheck = "";
		for (var i = 0; i < phongBanCheckboxs.length; i++) {
			if (phongBanCheckboxs[i].checked) {
				listPhongBanCheck += phongBanCheckboxs[i].value + ",";
			}
		}
		document.<portlet:namespace/>fm.<portlet:namespace/>addPhongBan.value = listPhongBanCheck;
		if (confirm("<liferay-ui:message key='ban-co-muon-tiep-tuc-khong'/>")){
			submitForm(document.<portlet:namespace/>fm,
					"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
					<portlet:param name="struts_action" value="/sgs/sovanbannoibo/view" />
					<portlet:param name="tab" value="config_phongban" />
					<portlet:param name="<%=Constants.CMD%>" value="CONFIGUPDATEPHONGBAN" />
					</portlet:actionURL>");
		}
	}
</script>

<c:if test="<%= (countPhongBanVanBanNoiBo == results.size()) %>">
	<script type="text/javascript">
			document.<portlet:namespace />fm.<portlet:namespace />allPhongBanVanBanNoiBo.checked = true;
	</script>
</c:if>