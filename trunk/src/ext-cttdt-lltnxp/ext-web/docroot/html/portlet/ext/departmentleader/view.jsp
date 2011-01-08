<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentSearch"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentSearchTerms"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.department.DepartmentCanNotDeleteException"%>

<script type="text/javascript">

	function deletePmlDepartment(url) {		
		if (confirm("<liferay-ui:message key='ban-muon-xoa-phong-ban-nay-khoi-he-thong'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/departmentleader/view");
%>

	<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	
	<input name="<portlet:namespace />departmentURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= DepartmentCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<div class="title_categ"><liferay-ui:message key="department-leader"/></div>
	<div class="boxcontent departmentleader">
	<%
		PmlDepartmentSearch departmentSearch = new PmlDepartmentSearch(renderRequest, portletURL);
		PmlDepartmentSearchTerms searchTerms = (PmlDepartmentSearchTerms)departmentSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/departmentleader/search_form.jsp"
		searchContainer="<%= departmentSearch %>" />
	
	     
	<%
		List<Department> results = new ArrayList<Department>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = DepartmentLocalServiceUtil.search(searchTerms.getMaPhong(), 
					searchTerms.getTenPhong(), searchTerms.getTenVietTat(), searchTerms.isAndOperator(), departmentSearch.getStart(), 
					departmentSearch.getEnd(), departmentSearch.getOrderByComparator());
			
			total = DepartmentLocalServiceUtil.searchCount(searchTerms.getMaPhong(), 
					searchTerms.getTenPhong(), searchTerms.getTenVietTat(), searchTerms.isAndOperator());
		}
		else {
			results = DepartmentLocalServiceUtil.search(searchTerms.getKeywords(), departmentSearch.getStart(),
					departmentSearch.getEnd(), departmentSearch.getOrderByComparator());
			
			total = DepartmentLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		departmentSearch.setTotal(total);
		
		departmentSearch.setResults(results);
		
		portletURL.setParameter(departmentSearch.getCurParam(), String.valueOf(departmentSearch.getCurValue()));
	%>
	
	<portlet:renderURL var="add">
		<portlet:param name="struts_action" value="/sgs/departmentleader/add" />		
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
		<portlet:param name="redirect" value="<%= departmentSearch.getIteratorURL().toString()  %>"/>
	</portlet:renderURL>
		
	<span onclick="javascript:submitForm(document.hrefFm,'<%= add %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="add_new" />'/></span>
	<br /> 
	
	<div id="separator"></div>
	
	<%
		List resultRows = departmentSearch.getResultRows();
	
		ResultRow row = null;	
		Department department = null;
		
		String departmentId = "";	
		
		String leaderURL = "";
		String hSCVURL = "";
		String editURL = "";
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			department = results.get(i);
			departmentId = department.getDepartmentsId();
			
			row = new ResultRow(department, departmentId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma phong ban
			
			row.addText(department.getDepartmentsCode());
			
			// ten phong ban
			
			row.addText(department.getDepartmentsName());
			
			// ten viet tat 
			
			row.addText(department.getAbbreviateName());
			
			// phong ban lanh dao
			if (department.getDepartmentsParentId().equals("")) {
				//xuancong close row.addText(department.getDepartmentsName());
				row.addText("");
			} else {
				Department departmentParentId = null;
				try {
					departmentParentId = DepartmentLocalServiceUtil.getDepartment(department.getDepartmentsParentId());
				} catch (Exception e){ }
				if (departmentParentId != null ) {
					row.addText(departmentParentId.getDepartmentsName());
				} else {
					//xuancong close row.addText(department.getDepartmentsName());
					row.addText("");
				}
			}
			
			// mo ta
			
			row.addText(department.getDescription());
			
			// chon lanh sao phong		
			
			PortletURL rowURLLEADER = renderResponse.createRenderURL();
			rowURLLEADER.setWindowState(WindowState.NORMAL);
			rowURLLEADER.setParameter("struts_action", "/sgs/departmentleader/setleader");
			rowURLLEADER.setParameter(Constants.CMD, "VIEW_LEADER");
			rowURLLEADER.setParameter("departmentId", departmentId);
			rowURLLEADER.setParameter("redirect",  departmentSearch.getIteratorURL().toString());
			leaderURL = "<a  href='" + rowURLLEADER.toString() + "'><u>" + "<img src='/html/images/configLDB.gif'/>" + "</u></a>";
			row.addText(leaderURL);
			
			// phan quyen ho so cong viec 
			PortletURL rowURLHSCV = renderResponse.createRenderURL();
			rowURLHSCV.setWindowState(WindowState.NORMAL);
			rowURLHSCV.setParameter("struts_action", "/sgs/departmentleader/departmenthscv");
			rowURLHSCV.setParameter(Constants.CMD, "VIEW_HSCV");
			rowURLHSCV.setParameter("departmentId", departmentId);
			rowURLHSCV.setParameter("redirect",  departmentSearch.getIteratorURL().toString());
			hSCVURL = "<a  href='" + rowURLHSCV.toString() + "'><u>" + "<img src='/html/images/configfile.png'/>" + "</u></a>";
			row.addText(hSCVURL);
			
			
			// sua		
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("struts_action", "/sgs/departmentleader/edit");
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("departmentId", departmentId);
			rowURLEdit.setParameter("redirect",  departmentSearch.getIteratorURL().toString());
			editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
			
			row.addText(editURL);
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/departmentleader/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("departmentId", departmentId);
			rowURLDelete.setParameter("redirect",  departmentSearch.getIteratorURL().toString());			
			deleteURL = "<a  href='javascript: ;'  onclick=deletePmlDepartment('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteURL);
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= departmentSearch %>" />
</div>
</form>

