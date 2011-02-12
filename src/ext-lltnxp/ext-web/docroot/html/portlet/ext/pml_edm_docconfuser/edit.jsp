<%@ include file="/html/portlet/ext/pml_edm_docconfuser/init.jsp" %>

<%@page import="com.ext.portal.util.WebKeysExt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>

<!-- minh close 20100528 -->
<!-- %@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %-->
<!-- end minh close 20100528 -->
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%><link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%
	String portletResource = ParamUtil.getString(request, "portletResource");
	String redirect = ParamUtil.getString(request, "redirect");
	String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);
	
	if (originalRedirect.equals(StringPool.BLANK)) {
		originalRedirect = redirect;
	}
	else {
		redirect = originalRedirect;
	}
	
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	// Object processing
	PmlEdmDocConfUser pmlEdmDocConfUser = (PmlEdmDocConfUser) request.getAttribute(WebKeysExt.PMLEDMDOCCONFUSER);
	
	String PmlEdmDocConfUserAUFlag = "";
	String cmd = ParamUtil.getString(request, Constants.CMD);
	
	// Object properties
	long dcuId = 0;
	long userId = 0;
	boolean viewAllDoc = false;
	String viewDepDoc = "";
	
	// Get the list of all user
	long companyId = themeDisplay.getCompanyId(); 
	List<User> users = PmlEdmDocConfUserLocalServiceUtil.getUserByCompany(companyId);
	// yenlt update 280802010
	List<PmlEdmDocConfUser> pmlEdmDocConfUserList = PmlEdmDocConfUserLocalServiceUtil.getPmlEdmDocConfUsers(-1,-1);
	for (int i=0; i < pmlEdmDocConfUserList.size(); i++) {
		User userPortal = null;
		try {
			userPortal = UserLocalServiceUtil.getUser(pmlEdmDocConfUserList.get(i).getUserId());
		} catch (Exception e) {
			
		}
		if (null != userPortal) {
			users.remove(userPortal);
		}
	}
	// end yenlt update 280802010
	
	// Get the list of all department
	List<Department> departments = DepartmentLocalServiceUtil.findAll();

	if (pmlEdmDocConfUser != null) {
		dcuId = pmlEdmDocConfUser.getDcuId();
		userId = pmlEdmDocConfUser.getUserId();
		viewAllDoc = pmlEdmDocConfUser.getViewAllDoc();
		viewDepDoc = pmlEdmDocConfUser.getViewDepDoc();
	}
	else {
		PmlEdmDocConfUserAUFlag = request.getAttribute("PmlEdmDocConfUserAUFlag") == null ? "" : String.valueOf(request.getAttribute("PmlEdmDocConfUserAUFlag"));
		if (PmlEdmDocConfUserAUFlag.equals("fail")) { // Add or update fail
			if (cmd.equals(Constants.UPDATE)) {
				// Primary key
				dcuId = ParamUtil.getLong(request, "dcuId");
			}
			// Other fields
			userId = ParamUtil.getLong(request, "userId");
			viewAllDoc = ParamUtil.getBoolean(request, "viewAllDoc");
			viewDepDoc = ParamUtil.getString(request, "viewDepDoc");
		}
	}
%>

<script type="text/javascript">

	function <portlet:namespace />savePmlEdmDocConfUser(cmd) {
		<portlet:namespace />getDepId();
		if (cmd == null) {
			cmd = "<%= pmlEdmDocConfUser != null || (pmlEdmDocConfUser == null && PmlEdmDocConfUserAUFlag.equals("fail") && dcuId > 0) ? Constants.UPDATE : Constants.ADD %>";
		}

		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />getDepId() {
		var depItem = document.<portlet:namespace />fm.<portlet:namespace />depItem;
		var selDepIds = ""; // Ma so phong ban duoc chon
		if (depItem != null) {
			for (var idx = 0; idx < depItem.length; idx++) {
				if (depItem[idx].checked == true) {
					if (selDepIds != "") selDepIds += ",";
					selDepIds += depItem[idx].value;
				}
			}
		}
		document.<portlet:namespace />fm.<portlet:namespace />viewDepDoc.value = selDepIds;		
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_edm_docconfuser/edit" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />portletResource" type="hidden" value="<%= HtmlUtil.escape(portletResource) %>" />
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
	<input name="<portlet:namespace />originalRedirect" type="hidden" value="<%= HtmlUtil.escape(originalRedirect) %>" />
	<input name="<portlet:namespace />referringPortletResource" type="hidden" value="<%= HtmlUtil.escape(referringPortletResource) %>" />
	<input name="<portlet:namespace />dcuId" type="hidden" value="<%= dcuId %>" />
	<input name="<portlet:namespace />viewDepDoc" type="hidden" value="<%= viewDepDoc %>" />
	<div class="title_categ"><liferay-ui:message key="phan-quyen-van-ban"/></div>
	<div class="boxcontent">
	<table cellspacing="0" width="100%">
				<tr>
					<td width="23%"><liferay-ui:message key="view-all-document-of-unit" />&nbsp;:</td>
					<td><input type="checkbox" name="<portlet:namespace />viewAllDoc" <%= viewAllDoc == true ? "checked" : "" %> /></td>
				</tr>
				<c:if test='<%= pmlEdmDocConfUser != null || (pmlEdmDocConfUser == null && PmlEdmDocConfUserAUFlag.equals("fail") && dcuId > 0) %>'>
					<tr>
						<td><liferay-ui:message key="config-for-user" />&nbsp;:</td>
						<td >
							<%
								String userName = "";
								if (userId > 0) {
									for (int idx = 0; idx < (users != null ? users.size() : 0); idx++) {
										com.liferay.portal.model.User user1 = (com.liferay.portal.model.User) users.get(idx);
										if (user1.getUserId() == userId) {
											userName = user1.getLastName() + ' ' + user1.getMiddleName() + ' ' + user1.getFirstName();
											break;
										}
									}
								}
								%>
								<strong>
								<%= userName %>
								</strong>
								<input type="hidden" name="<portlet:namespace />userId" value="<%= userId %>">
						</td>
					</tr>
				</c:if>
				<c:if test='<%= pmlEdmDocConfUser == null && (!PmlEdmDocConfUserAUFlag.equals("fail") || dcuId <= 0) %>'>
					<tr>
						<td>
							<liferay-ui:message key="choose-user" />&nbsp;:
						</td>
						<td>
							<select style="width: 50%" name="<portlet:namespace />userId">
								<%
								for (int idx = 0; idx < (users != null ? users.size() : 0); idx++) {
									com.liferay.portal.model.User user2 = (com.liferay.portal.model.User) users.get(idx);
								%>
									<option <%= user2.getUserId() == userId ? "selected" : "" %> value="<%= user2.getUserId() %>"><%= user2.getLastName() + ' ' + user2.getMiddleName() + ' ' + user2.getFirstName() %></option>
								<%
								}
								%>
							</select>
						</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="2">
					<fieldset class="filborder">
					<label class="laborder"><liferay-ui:message key="view-document-of-department" /></label>
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="results-header-Scrollbar" >
									<td width="45px" align="center">
										<liferay-ui:message key="choose" />
									</td>
									<td >
										<liferay-ui:message key="department" />
									</td>
					</tr>
					</table>	
					<div class="Scrollbarauto">
					<table cellspacing="0" width="100%" class="taglib_Scrollbar table-pml">	
								<%
								StringTokenizer token = new StringTokenizer(viewDepDoc, ",");
								ArrayList<String> arlDepDoc = new ArrayList<String>();
								while (token.hasMoreTokens()) {
									arlDepDoc.add(String.valueOf(token.nextElement()));
								}
								for (int idx = 0; idx < (departments != null ? departments.size() : 0); idx++) {
									Department department = (Department) departments.get(idx);
								%>
					<tr class='<%= (idx % 2 == 0) ? "results-row" : "tr_two results-row" %>'>
										<td align="center" width="45px">
											<input type="checkbox" name="<portlet:namespace />depItem" value="<%= department.getDepartmentsId() %>" <%= arlDepDoc.contains(department.getDepartmentsId()) ? "checked" : "" %> />
										</td>
										<td>
											<%= department.getDepartmentsName() %>
										</td>
					</tr>
								<%
								}
								%>
					</table>
					</div>
					</fieldset>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<% if (null == pmlEdmDocConfUser) { %>
							<input style="margin-right: 0;" type="button" value='<liferay-ui:message key="save" />'  onClick="<portlet:namespace />savePmlEdmDocConfUser()" />
						<% } else { %>
							<input style="margin-right: 0;" type="button" value='<liferay-ui:message key="update" />'  onClick="<portlet:namespace />savePmlEdmDocConfUser()" />
						<% } %>
							<input type="button" value='<liferay-ui:message key="back" />' onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
					</td>
				</tr>
			</table>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />viewAllDoc);
	</script>
</c:if>