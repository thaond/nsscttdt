<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>
<%@page import="com.sgs.portlet.departmentleader.search.PmlUserLeaderSearch"%>
<%@page import="com.sgs.portlet.departmentleader.action.PmlUserDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlDepartmentsLeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.service.PositionLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentLeaderChecker"%>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	//List<PmlUserDTO>  pmlUserDTOList = (List<PmlUserDTO>) renderRequest.getAttribute("userList"); // phmphuc close 27/05/2010
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	String departmentId = (String) renderRequest.getAttribute("departmentId");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/departmentleader/setleader");
	portletURL.setParameter("departmentId", departmentId);
	portletURL.setParameter("redirect", redirect);
%>

<script type="text/javascript">
	function <portlet:namespace/>updateLeader(url) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addDepartmentLeader.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		document.<portlet:namespace/>fm.<portlet:namespace/>removeDepartmentLeader.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		submitForm(document.<portlet:namespace/>fm);
	}
</script>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<div class="title_categ"><liferay-ui:message key="department_name"/> : <%= departmentName %></div>
	<div class="boxcontent">	
	<!-- <input type="hidden" name="<portlet:namespace />departmentId" id="departmentId" value="<%= departmentId %>"> -->
	<input name="<portlet:namespace/>addDepartmentLeader"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeDepartmentLeader"  type="hidden" value=""/>
	
	<%
		PmlUserLeaderSearch pmlUserLeaderSearch = new PmlUserLeaderSearch(renderRequest, portletURL);
		
		// phmphuc update 27/05/2010
		List<PmlUser> results = PmlUserLocalServiceUtil.findUserListByDepartment(departmentId, pmlUserLeaderSearch.getStart(), pmlUserLeaderSearch.getEnd());
		int total = PmlUserLocalServiceUtil.countUserListByDepartment(departmentId);
	
		// List<PmlUserDTO> results = pmlUserDTOList; // phmphuc close 27/05/2010
		
		pmlUserLeaderSearch.setTotal(total);
		pmlUserLeaderSearch.setResults(results);
		portletURL.setParameter(pmlUserLeaderSearch.getCurParam(), String.valueOf(pmlUserLeaderSearch.getCurValue()));
		
		// chuyen ve rowChecker cua Liferay
		List<String> header = pmlUserLeaderSearch.getHeaderNames();
		RowChecker rowChecker = new PmlDepartmentLeaderChecker(renderResponse);
		pmlUserLeaderSearch.setRowChecker(rowChecker);
		
		/*
		String formName = renderResponse.getNamespace() + "fm";
		String rowName = renderResponse.getNamespace() + "isLeader";
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
		
		pmlUserLeaderSearch.setHeaderNames(header);*/
	%>
	
	<%
		List resultRow = pmlUserLeaderSearch.getResultRows();
		ResultRow row = null;
		PmlUser pmlUser = null;
		long pmlUserId = 0;
		//String isLeader = "";
		boolean isMain = false;
		
		User userHienThi = null;
		String userName = "";
		
		Position position = null;
		
		//int countCheck = 0;
		
		List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
		
		for (int i = 0; i < results.size(); i ++) {
			pmlUser = results.get(i);
			pmlUserId = pmlUser.getUserId();
			
			row = new ResultRow(pmlUser, pmlUserId, i);
			
			try {
				pmlDepartmentsLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId_UserId(departmentId, pmlUserId);
			} catch (Exception e) {
				pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
			}
			
			/* phmphuc close 23/09/2010
			if (pmlDepartmentsLeaderList.size()!= 0 ) {
				isLeader = "1";
				countCheck += 1;
			}

			// checked
			StringBuilder rowNameChecked = new StringBuilder();
			rowNameChecked.append("<input ");
			rowNameChecked.append(("1".equals(isLeader) ? "checked " : " "));
			rowNameChecked.append("name=\"");
			rowNameChecked.append(rowName);
			rowNameChecked.append("\" type=\"checkbox\" value=\"");
			rowNameChecked.append(String.valueOf(pmlUserId));
			rowNameChecked.append("\" ");
			rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
			rowNameChecked.append(formName);
			rowNameChecked.append(", '");
			rowNameChecked.append(rowName);
			rowNameChecked.append("', ");
			rowNameChecked.append(rowAllName);
			rowNameChecked.append(");\"");
			rowNameChecked.append(">");
			
			isLeader = "";
			row.addText(rowNameChecked.toString()); 
			// end phmphuc close
			*/
			
			// STT
			row.addText((i + 1) + ".");
			
			// ten lanh dao
			try {
			userHienThi = UserLocalServiceUtil.getUser(pmlUserId);
			userName = userHienThi.getLastName() + " " + userHienThi.getMiddleName() + " " + userHienThi.getFirstName();
			}
			catch (Exception ex) {}
			
			row.addText(userName);
			
			// chuc vu
			try {
				position = PositionLocalServiceUtil.getPosition(pmlUser.getPositionId());
				row.addText(position.getPositionName());
			} catch (Exception e) {
				row.addText("");
			}
			
			// uu tien	
			for (int j = 0; j < pmlDepartmentsLeaderList.size(); j++) {
				if (pmlUserId == pmlDepartmentsLeaderList.get(j).getUserId() && pmlDepartmentsLeaderList.get(j).getMain()) {
					isMain = true;
					break;
				}
				else {
					isMain = false;
				}
				
			}
			String uuTien = "<input type='radio' onclick='clickCheckBox(event,this)'" + (isMain == true  ? "checked" : " ") +  " value=" + String.valueOf(pmlUserId) +  " name='isLeaderMain'/>";
			isMain = false;
			row.addText(uuTien);
			
			
			resultRow.add(row);
		}
		
	%>

		<liferay-ui:search-iterator searchContainer="<%= pmlUserLeaderSearch %>" />
		<div align="right" id="table-button">
			<input class="button-width" type="button" value='<liferay-ui:message key="save"/>' onclick="<portlet:namespace/>updateLeader('<%= portletURL.toString() %>');"/>
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'/></span></div>
		</div>
	</form>

<!-- <c:if test="</%= (countCheck == results.size()) %/>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
	</c:if> -->

