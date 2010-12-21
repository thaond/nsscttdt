<%@ include file="/html/portlet/nss/department/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.department.search.PmlUserLeaderSearch"%>
<%@page import="com.nss.portlet.department.model.PmlUser"%>
<%@page import="com.nss.portlet.department.service.PmlUserLocalServiceUtil"%>
<%@page import="com.nss.portlet.position.model.Position"%>
<%@page import="com.nss.portlet.department.model.PmlDepartmentsLeader"%>
<%@page import="com.nss.portlet.position.service.PositionLocalServiceUtil"%>

<%@page import="com.nss.portlet.department.search.PmlDepartmentLeaderChecker"%>
<%@page import="com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil"%>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	String departmentId = (String) renderRequest.getAttribute("departmentId");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/department/setleader");
	portletURL.setParameter("departmentId", departmentId);
	portletURL.setParameter("redirect", redirect);
%>

<script type="text/javascript">
	function clickCheckBox(event,eleCheckBox)
	{
		// firefox
		if (event) 
		{
			if (event.stopPropagation)
			{
				event.stopPropagation();
			}
			else event.cancelBubble = true;
					
		}  // windows
		else
		{
			window.event.cancelBubble = true;
		}
	}
	function <portlet:namespace/>updateLeader(url) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addDepartmentLeader.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		document.<portlet:namespace/>fm.<portlet:namespace/>removeDepartmentLeader.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		submitForm(document.<portlet:namespace/>fm);
	}
</script>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="department_name"/> : <%= departmentName %></div>
	<input name="<portlet:namespace/>addDepartmentLeader"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeDepartmentLeader"  type="hidden" value=""/>
	
	<%
		PmlUserLeaderSearch pmlUserLeaderSearch = new PmlUserLeaderSearch(renderRequest, portletURL);
		
		List<PmlUser> results = PmlUserLocalServiceUtil.findUserListByDepartment(departmentId, pmlUserLeaderSearch.getStart(), pmlUserLeaderSearch.getEnd());
		int total = PmlUserLocalServiceUtil.countUserListByDepartment(departmentId);
	
		pmlUserLeaderSearch.setTotal(total);
		pmlUserLeaderSearch.setResults(results);
		portletURL.setParameter(pmlUserLeaderSearch.getCurParam(), String.valueOf(pmlUserLeaderSearch.getCurValue()));
		
		RowChecker rowChecker = new PmlDepartmentLeaderChecker(renderResponse);
		pmlUserLeaderSearch.setRowChecker(rowChecker);
		
	%>
	
	<%
		List resultRow = pmlUserLeaderSearch.getResultRows();
		ResultRow row = null;
		PmlUser pmlUser = null;
		long pmlUserId = 0;
		boolean isMain = false;
		
		User userHienThi = null;
		String userName = "";
		
		Position position = null;
		
		List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
		
		for (int i = 0; i < results.size(); i ++) {
			pmlUser = results.get(i);
			pmlUserId = pmlUser.getUserId();
			
			row = new ResultRow(pmlUser, pmlUserId, i);
			
			try {
				pmlDepartmentsLeaderList = PmlDepartmentsLeaderLocalServiceUtil.findByDepartmentsId_UserId(departmentId, pmlUserId);
			} catch (Exception e) {
				pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
			}
			
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

