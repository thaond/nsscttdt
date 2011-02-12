<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentHSCVSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="javax.portlet.PortletURL"%>
<liferay-util:include page="/html/portlet/ext/departmentleader/js/departmentleader.jsp" ></liferay-util:include>
<%

	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/departmentleader/departmenthscv");
	portletURL.setParameter(Constants.CMD, Constants.ADD);
	portletURL.setParameter("redirect", redirect);
	
	List<PmlHoSoCongViec>  pmlHoSoCongViecList = (List<PmlHoSoCongViec>) renderRequest.getAttribute("hscvList");
	Department departmentName = (Department) renderRequest.getAttribute("department");
	int countHSCVExist = (Integer) renderRequest.getAttribute("countHSCVExist");
%>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
		<input type="hidden" name="<portlet:namespace />departmentId" value="<%= departmentName.getDepartmentsId() %>" /> 
		<div class="title_categ"><liferay-ui:message key="department_name"/> : <%= departmentName.getDepartmentsName() %></div>
		<div class="boxcontent">
	<%
		PmlDepartmentHSCVSearch pmlDepartmentHSCVSearch   = new PmlDepartmentHSCVSearch(renderRequest, portletURL);
	
		List<PmlHoSoCongViec> results = pmlHoSoCongViecList;
		
		pmlDepartmentHSCVSearch.setTotal(results.size());
		
		pmlDepartmentHSCVSearch.setResults(results);
		
		portletURL.setParameter(pmlDepartmentHSCVSearch.getCurParam(), String.valueOf(pmlDepartmentHSCVSearch.getCurValue()));
		
		List<String> header = pmlDepartmentHSCVSearch.getHeaderNames();
		
		String formName = renderResponse.getNamespace() + "fm";
		String rowName = renderResponse.getNamespace() + "HSCV";
		String rowAllName = "checkallbox";
		
		StringBuilder rowAllNameChecked = new StringBuilder();
		rowAllNameChecked.append("<input name=\"");
		rowAllNameChecked.append(rowAllName);
		rowAllNameChecked.append("\" type=\"checkbox\" ");
		rowAllNameChecked.append("onClick=\"Liferay.Util.checkAll(");
		rowAllNameChecked.append(formName);
		rowAllNameChecked.append(", '");
		rowAllNameChecked.append(rowName);
		rowAllNameChecked.append("', this");
		rowAllNameChecked.append(");\">");
		header.add(0, rowAllNameChecked.toString());
		
		pmlDepartmentHSCVSearch.setHeaderNames(header);
	%>
	
	
	<%
		List resultRows = pmlDepartmentHSCVSearch.getResultRows();
	
		PmlHoSoCongViec pmlHoSoCongViec = null;
		
		ResultRow row = null;	
		
		long pmlHoSoCongViecId  = 0;
		
		int countCheck = 0;
		
		for (int i = 0; i < results.size(); i ++) {
			pmlHoSoCongViec = results.get(i);
			pmlHoSoCongViecId = pmlHoSoCongViec.getIdHoSoCongViec();
			
			row = new ResultRow(pmlHoSoCongViec, pmlHoSoCongViecId, i);
			
			
			// checked
			StringBuilder rowNameChecked = new StringBuilder();
			rowNameChecked.append("<input ");
			rowNameChecked.append(i <= (countHSCVExist - 1) ? "checked " : " ");
			rowNameChecked.append("name=\"");
			rowNameChecked.append(rowName);
			rowNameChecked.append("\" type=\"checkbox\" value=\"");
			rowNameChecked.append(String.valueOf(pmlHoSoCongViecId));
			rowNameChecked.append("\" ");
			rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
			rowNameChecked.append(formName);
			rowNameChecked.append(", '");
			rowNameChecked.append(rowName);
			rowNameChecked.append("', ");
			rowNameChecked.append(rowAllName);
			rowNameChecked.append(");\"");
			rowNameChecked.append(">");
			
			row.addText(rowNameChecked.toString());
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// tieu de
			
			row.addText(pmlHoSoCongViec.getTieuDe());
			
			// noi dung
			
			row.addText(pmlHoSoCongViec.getTomTatNoiDung());
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pmlDepartmentHSCVSearch %>" />
		
		<div align="right" id="table-button">
					<input class="button-width" type="submit" value='<liferay-ui:message key="save"/>'/>
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'/></span></div>
		</div>
</form>

	<c:if test="<%= (countHSCVExist == results.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
	</c:if>

