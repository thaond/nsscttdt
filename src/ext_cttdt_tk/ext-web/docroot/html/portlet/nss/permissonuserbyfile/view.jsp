<%@ include file="/html/portlet/nss/permissonuserbyfile/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.nss.portlet.permissonuserbyfile.search.PermissionUserByFileSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.nss.portlet.department.service.PmlUserLocalServiceUtil"%>
<%@page import="com.nss.portlet.permissonuserbyfile.model.PmlUserFileType"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalServiceUtil"%>


<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/permissonuserbyfile/view");
	
%>


<portlet:actionURL var="form" windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name='struts_action' value='/nss/permissonuserbyfile/view'/>
</portlet:actionURL>

<form action="<%= form %>" method="post" name="<portlet:namespace />fm">
<input type="hidden" name="<portlet:namespace />multiUsers">
<div class="title_categ"><liferay-ui:message key="javax.portlet.title.NSS_PERMISSONUSERBYFILE"/></div>
<div class="boxcontent">

	<%
		PermissionUserByFileSearch searchContainer = new PermissionUserByFileSearch(renderRequest, portletURL);
		searchContainer.setRowChecker(new RowChecker(renderResponse));
		
		List<User> results = null;
		int total = 0;
		results = PmlUserLocalServiceUtil.listUserTheoDoiHoSo(searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		total = PmlUserLocalServiceUtil.countUserTheoDoiHoSo();
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		
		List<ResultRow> resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		String phanQuyen = "";
		for (int i = 0; i < results.size(); i++) {
			User userPermission = results.get(i);
			long userId = userPermission.getUserId();
			userPermission = userPermission.toEscapedModel();
			row = new ResultRow(userPermission, userId, i);
			// stt
			row.addText(String.valueOf(i+1));
			
			// tai khoan
			row.addText(userPermission.getEmailAddress());
			
			// user name
			String fullName = "";
			try {
				fullName = PmlUserLocalServiceUtil.getFullName(userId);
			} catch (Exception e) {
				fullName = "";
			}
			row.addText(fullName);
			
			// ds ho so
			List<PmlUserFileType> pmlUserFileTypeList = new ArrayList<PmlUserFileType>();
			List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
			try {
				pmlUserFileTypeList = PmlUserFileTypeLocalServiceUtil.findByUserId(userId);
			} catch (Exception e) {
				pmlUserFileTypeList = new ArrayList<PmlUserFileType>();
			}
			row.addText("");
			
			// ghi chu
			String description = "";
			if (pmlUserFileTypeList != null && pmlUserFileTypeList.size() != 0) {
				description = pmlUserFileTypeList.get(0).getDescription();
			}
			row.addText(description);

			// phan quyen
			PortletURL phanQuyenURL= renderResponse.createRenderURL();
			phanQuyenURL.setWindowState(WindowState.NORMAL);
			phanQuyenURL.setParameter("struts_action","/nss/permissonuserbyfile/edit");
			phanQuyenURL.setParameter("userId", String.valueOf(userId));
			phanQuyenURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			phanQuyen = "<a href='"+ phanQuyenURL.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(phanQuyen);
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	<br>
	<div align="right">
	  <input type="submit" value='<liferay-ui:message key="permissionuserbyfile-dongbo"/>'></td>
	  <input type="button" value='<liferay-ui:message key="permission.assign" />' onclick="<portlet:namespace />assignMultiUsers()"></td>
	</div>

</div>
</form>

<script type="text/javascript">
	function <portlet:namespace />assignMultiUsers() {
		document.<portlet:namespace />fm.<portlet:namespace />multiUsers.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if (document.<portlet:namespace />fm.<portlet:namespace />multiUsers.value.trim() == "" ){
			alert("<liferay-ui:message key='vui-long-chon-nguoi-dung' />");
			return false;
		} else {
			submitForm(document.<portlet:namespace />fm,
					 "<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>">
					 	<portlet:param name="struts_action" value="/nss/permissonuserbyfile/edit" />
					 	<portlet:param name="redirect" value="<%= searchContainer.getIteratorURL().toString() %>" />
					 	<portlet:param name="<%= Constants.CMD %>" value="ASSIGN" />
					 </portlet:renderURL>");

		}
	}
</script>

<%
	String message = (String) renderRequest.getAttribute("message");
	String editPermission = (String) renderRequest.getPortletSession().getAttribute("editPermission", PortletSession.APPLICATION_SCOPE);
	if ("success".equals(editPermission)) {
%>
<script type="text/javascript" >
	alert("<liferay-ui:message key='cap-nhat-thanh-cong' />");
</script>

<%
	}
	if ("true".equals(message)) {
%> 
<script type="text/javascript">
	alert("<liferay-ui:message key="permissionuserbyfile-dongbothanhcong"/>");
</script> 
<%
	} else if ("false".equals(message)) {
%> 
<script type="text/javascript">
	alert("<liferay-ui:message key="permissionuserbyfile-dongbokhongthanhcong"/>");
</script> 
<%		
	}
	
	renderRequest.getPortletSession().setAttribute("editPermission", null, PortletSession.APPLICATION_SCOPE);
%>
