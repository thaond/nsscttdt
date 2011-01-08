<%@ include file="/html/portlet/ext/home_report/init.jsp" %>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page	import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>

<%
	HomeReportSearch searchContainer = (HomeReportSearch)request.getAttribute("liferay-ui:search:searchContainer");
	HomeReportDisplayTerms displayTerms = (HomeReportDisplayTerms) searchContainer.getDisplayTerms();
	
	// thong tin danh cho user dang nhap
	long userLogin = PortalUtil.getUserId(renderRequest);
	String pmlDepartmentId = "";
	Department pmlDepartment = null;
	try {
		pmlDepartmentId = PmlUserUtil.findByPrimaryKey(userLogin).getDepartmentsId();
		pmlDepartment = DepartmentUtil.findByPrimaryKey(pmlDepartmentId);
	} catch (Exception e) { }

	// lay user tu form search
	long userId = displayTerms.getUserId();
	String loaiCongVan = (renderRequest.getAttribute("loaiThongKe").equals("")) ? "congvanden" : (String) renderRequest.getAttribute("loaiThongKe");
	String departmentIdChoice = (renderRequest.getAttribute("departmentIdChoice").equals("")) ? "chonphongban" : (String) renderRequest.getAttribute("departmentIdChoice");
	
	// list user
	List<PmlUser> pmlUserRoleGDs = new ArrayList<PmlUser>();
	if (departmentIdChoice.equals("chonphongban")) {
		
		List<Department> departmentList = DepartmentUtil.findAll();
		for(Department d : departmentList) {
			pmlUserRoleGDs.addAll(PmlUserUtil.findByDepartmentsId(d.getDepartmentsId()));
		}
	} else {
		pmlUserRoleGDs  = PmlUserUtil.findByDepartmentsId(departmentIdChoice);
	}
%>

<%	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/home_report/view");
%>

<input type="hidden" id="<portlet:namespace/>url" value="<%= portletURL.toString() %>"/>
<!-- <div class="title_allbos"></div> -->

<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="tieu-thuc-lap-bao-cao"/></label>
	<table cellspacing="0" width="100%">
		<tr>
			<td width="18%"><liferay-ui:message key="danh-sach-phong-ban" />&nbsp;:</td>
			<td width="35%">
				<select style="width: 91%" name="<%= HomeReportDisplayTerms.DEPARTMENTID %>" id="<portlet:namespace/>departmentId" onchange="<portlet:namespace/>enableItemsUser('true');">
							<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC) %>">
								<option selected="selected" value="chonphongban"></option>
									<%
									List<Department> pmlDepartmentList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId();
									int pmlDepartmentSize = pmlDepartmentList.size();
									for(int i = 0; i < pmlDepartmentSize; i ++) {
									Department department = pmlDepartmentList.get(i);
									String selected = department.getDepartmentsId().equals(displayTerms.getDepartmentId()) ? "selected" : "";
									out.print("<option value=\"" + department.getDepartmentsId() + "\" " + selected + ">" + department.getDepartmentsName() + "</option>");
									}
									%>
							</c:if>
				
							<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG) %>">
							<%
									if (!(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))) {	
									try {
									out.print("<option value=\"" + pmlDepartmentId + "\">" + pmlDepartment.getDepartmentsName() + "</option>");
						 			} catch (Exception e) {}
									}
							%>
							</c:if>
				
							<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.CHUYENVIEN) %>">
							<%
								if (!(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))
								&& !(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG))) {
								try {
								String pmlDepartmentParentId = "";
								Department pmlDepartmentParent = null;
								if (pmlDepartment != null) {
									pmlDepartmentParentId = pmlDepartment.getDepartmentsParentId();
									if (pmlDepartmentParentId != null && !"".equals(pmlDepartmentParentId)) {
										try {
											pmlDepartmentParent = DepartmentUtil.findByPrimaryKey(pmlDepartmentParentId);
											out.print("<option value=\"" + pmlDepartmentParent.getDepartmentsId() + "\">" + pmlDepartmentParent.getDepartmentsName() + "</option>");
										} catch (Exception e) {}
									} else {
										out.print("<option value=\"" + pmlDepartment.getDepartmentsId() + "\">" + pmlDepartment.getDepartmentsName() + "</option>");
									}
								} 
						 	} catch (Exception e) {}
							}
							%>
						</c:if>
					</select>
			</td>
			<td width="12%">&nbsp;</td>
			<td></td>		
		</tr>
		<tr>
						<td ><liferay-ui:message key="tong-hop" />&nbsp;:</td>
						<td>
							<select name="<%= HomeReportDisplayTerms.USERID %>" id="<portlet:namespace/>userId" style="width: 91%" onchange="<portlet:namespace/>enableItemsUser('false')">
								<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC) %>">
									<option selected="selected" value="0"><liferay-ui:message key="theo-chuyen-vien" /></option>
									<%	
										try {
											for (PmlUser pmluser: pmlUserRoleGDs) {
												if (userId == pmluser.getUserId()) {
													out.print("<option selected='selected' value=\"" + pmluser.getUserId() + "\">" + HomeReportDWRUtil.getFullName(pmluser.getUserId()) + "</option>");
												} else {
													out.print("<option  value=\"" + pmluser.getUserId() + "\">" + HomeReportDWRUtil.getFullName(pmluser.getUserId()) + "</option>");
													
												}
											}
									 	} catch (Exception e) {}
									%>
								</c:if>
								
								<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG) %>">
									<%
									if (!(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))) {	
									%>
									<option selected="selected" value="0"><liferay-ui:message key="theo-chuyen-vien" /></option>
									
									<%	try {
											List<PmlUser> listUsers = PmlUserUtil.findByDepartmentsId(pmlDepartmentId);
											for (PmlUser pmluser: listUsers) {
												if (userId == pmluser.getUserId()) {
													out.print("<option selected='selected' value=\"" + pmluser.getUserId() + "\">" + HomeReportDWRUtil.getFullName(pmluser.getUserId()) + "</option>");
												} else {
												out.print("<option  value=\"" + pmluser.getUserId() + "\">" + HomeReportDWRUtil.getFullName(pmluser.getUserId()) + "</option>");
													
												}
											}
									 	} catch (Exception e) {}
									}
									%>
								</c:if>
								
								<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.CHUYENVIEN) %>">
									<%
									if (!(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))
											&& !(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG))) {
										PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userLogin);
										out.print("<option value=\"" + pmlUser.getUserId() + "\">" + HomeReportDWRUtil.getFullName(pmlUser.getUserId()) + "</option>");
									}
									%>
								</c:if>
							</select>
						</td>
			<td><liferay-ui:message key="loai-thong-ke" />&nbsp;:</td>
			<td>
				<select style="width: 91%" name="<%= HomeReportDisplayTerms.LOAITHONGKE %>" id="<portlet:namespace/>loaiCongVan" onchange="<portlet:namespace/>enableItemsUser('false')">
								<option <%="congvanden".equals(displayTerms.getLoaiThongKe()) ? "selected" : "" %> value="congvanden"><liferay-ui:message key="cong-van-den" /></option>
								<option <%="congvandi".equals(displayTerms.getLoaiThongKe()) ? "selected" : "" %> value="congvandi"><liferay-ui:message key="cong-van-di" /></option>
							</select>
			</td>		
		</tr>
		<tr>
			<td><liferay-ui:message key="tu-ngay" />&nbsp;:</td>
			<td>
				<input type="text" name="<%= displayTerms.FROMDATE %>" id="<portlet:namespace/>fromDate" value="<%= HtmlUtil.escape(displayTerms.getFromDate()) %>" style="width: 78%" onchange="<portlet:namespace/>enableItemsUser('false')"/>
							<input align="top" type="image" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')" />
			</td>
			<td><liferay-ui:message key="den-ngay" />&nbsp;:</td>
			<td>
				<input type="text" name="<%= displayTerms.TODATE %>" id="<portlet:namespace/>toDate" value="<%= HtmlUtil.escape(displayTerms.getToDate()) %>" style="width: 80%" onchange="<portlet:namespace/>enableItemsUser('false')"/>
							<input align="top" type="image" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
			</td>		
		</tr>
	</table>
</fieldset>
<script type="text/javascript">

	if (document.getElementById('<portlet:namespace />fromDate') != null) {
		callCalendar('<portlet:namespace />fromDate','cal-button-FromDate');
	}
	if (document.getElementById('<portlet:namespace />toDate') != null) {
		callCalendar('<portlet:namespace />toDate','cal-button-ToDate');
	}
</script>
