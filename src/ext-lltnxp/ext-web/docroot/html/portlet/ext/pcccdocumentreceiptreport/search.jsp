<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportDisplayTerms"%>


<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%><script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<%
	DocumentReportSearch searchContainer = (DocumentReportSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentReportDisplayTerms displayTerms = (DocumentReportDisplayTerms) searchContainer.getDisplayTerms();
	long userId = displayTerms.getUserId();//(renderRequest.getAttribute("userId") == null) ? 0 : (Long) renderRequest.getAttribute("userId");
	Department pmlDepartment = null;
	long userIdLogin = PortalUtil.getUserId(renderRequest);
%>
<fieldset>
<div class="search_tk">
	<table cellspacing="0" width="100%">
		<tr>
			<!-- phong ban -->
			<td align="right" width="10%"><liferay-ui:message key="tinhhinhthulycongvan.phongban" />:&nbsp;</td>
			<td align="left" width="15%">
				<select name="<%= displayTerms.DEPARTMENTID %>" id="<portlet:namespace/>departmentId" style="width: 90%" onchange="<portlet:namespace/>enableItems(<%= userId %>);">
					<% if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTREPORT", ActionKeysExt.VIEWREPORTALL)) { %>
							<option selected="selected" value="toancoquan"><liferay-ui:message key="tinhhinhthulycongvan.toancoquan" /></option>
							<option <%= "tatcaphongban".equals(displayTerms.getDepartmentId()) ? "selected" : "" %> value="tatcaphongban"><liferay-ui:message key="tinhhinhthulycongvan.tatcaphongban" /></option>
							<%
							List<Department> pmlDepartmentList = DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId();
							int pmlDepartmentSize = pmlDepartmentList.size();
							for(int i = 0; i < pmlDepartmentSize; i ++) {
								pmlDepartment = pmlDepartmentList.get(i);
								String selected = pmlDepartment.getDepartmentsId().equals(displayTerms.getDepartmentId()) ? "selected" : "";
								out.print("<option value=\"" + pmlDepartment.getDepartmentsId() + "\" " + selected + ">" + pmlDepartment.getDepartmentsName() + "</option>");
							}
						} else {
							if (!(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTREPORT", ActionKeysExt.VIEWREPORTALL))) {
								try {
									String pmlDepartmentId = PmlUserUtil.findByPrimaryKey(userIdLogin).getDepartmentsId();
									pmlDepartment = DepartmentUtil.findByPrimaryKey(pmlDepartmentId);
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
						}
					%>
				</select>
			</td>
			
			<!-- chuyen vien -->
			<td align="right" width="10%"><liferay-ui:message key="tinhhinhthulycongvan.chuyenvien" />:&nbsp;</td>
			<td align="left" width="18%">
				<select name="<%= displayTerms.USERID %>" id="<portlet:namespace/>userId" style="width: 90%" disabled onchange="<portlet:namespace/>onChangeChuyenVien();">
					<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTREPORT", ActionKeysExt.VIEWREPORTALL) %>">
						<option value="<%= userId %>">[--<liferay-ui:message key="tinhhinhthulycongvan.chonchuyenvien" />--]</option>
						
						<script type="text/javascript">
							<portlet:namespace/>enableItems(<%= userId %>);
						</script>
					</c:if>
					<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTREPORT", ActionKeysExt.TRUONGPHONG) %>">
						<option value="<%= userId %>">[--<liferay-ui:message key="tinhhinhthulycongvan.chonchuyenvien" />--]</option>
						<script type="text/javascript">
							<portlet:namespace/>enableItems(<%= userId %>);
						</script>
					</c:if>
					<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTREPORT", ActionKeysExt.CHUYENVIEN) %>">
						<script type="text/javascript">
							document.getElementById("<portlet:namespace/>userId").disabled = "";
						</script>
						<%
						PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userIdLogin);
						out.print("<option value=\"" + pmlUser.getUserId() + "\">" + TinhHinhThuLyCongVanDWRUtil.getFullName(pmlUser.getUserId()) + "</option>");
						%>
					</c:if>
				</select>
			</td>
			
			<!-- loai van ban thong ke -->
			<td align="right" width="7%"><liferay-ui:message key="tinhhinhthulycongvan.loai" />:&nbsp;</td>
			<td align="left" width="12%">
				<select name="<%= displayTerms.LOAICONGVAN %>" id="<portlet:namespace/>loaiCongVan"  style="width: 100%" onchange="getDocumentRecordByDocTypeId(<%= userIdLogin %>);">
					<% if (plid == 89659) { %>
						<option <%="congvandi".equals(displayTerms.getLoaiCongVan()) ? "selected" : "" %> value="congvandi"><liferay-ui:message key="tinhhinhthulycongvan.congvandi" /></option>
						<option <%="congvanden".equals(displayTerms.getLoaiCongVan()) ? "selected" : "" %> value="congvanden"><liferay-ui:message key="tinhhinhthulycongvan.congvanden" /></option>
					<% } else { %>
						<option <%="congvanden".equals(displayTerms.getLoaiCongVan()) ? "selected" : "" %> value="congvanden"><liferay-ui:message key="tinhhinhthulycongvan.congvanden" /></option>
						<option <%="congvandi".equals(displayTerms.getLoaiCongVan()) ? "selected" : "" %> value="congvandi"><liferay-ui:message key="tinhhinhthulycongvan.congvandi" /></option>
					<% } %>
				</select>
			</td>
			
			<!-- nhom van ban thong ke -->
			<td align="right" width="12%"><liferay-ui:message key="tinhhinhthulycongvan.phannhom" />:&nbsp;</td>
			<td align="left">
				<select name="<%= displayTerms.NHOMCONGVAN %>" id="<portlet:namespace/>nhomCongVan" style="width: 95%">
				</select>
				<input type="hidden" id="nhomcongvanselect" name="nhomcongvanselect" value="<%= displayTerms.getNhomCongVan() %>"/>
			</td>
		</tr>
		
		<tr>
			<!-- tu ngay -->
			<td align="right"><liferay-ui:message key="tinhhinhthulycongvan.tungay" />:&nbsp;</td>
			<td>
				<input type="text" name="<%= displayTerms.FROMDATE %>" id="<portlet:namespace />fromDate" value="<%= HtmlUtil.escape(displayTerms.getFromDate()) %>" style="width: 63%" />
				<input type="image" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')" />
			</td>
			
			<!-- den ngay -->
			<td align="right"><liferay-ui:message key="tinhhinhthulycongvan.denngay" />:&nbsp;</td>
			<td>
				<input type="text" name="<%= displayTerms.TODATE %>" id="<portlet:namespace />toDate" value="<%= HtmlUtil.escape(displayTerms.getToDate()) %>" style="width: 68%" />
				<input type="image" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
			</td>
			
			<!-- do mat -->
			<td align="right"><liferay-ui:message key="pccc-cvdtn-domat" />:&nbsp;</td>
			<td>
				<select name="<%= displayTerms.DOMAT %>" id="<portlet:namespace/>doMat" style="width: 100%">
					<option selected="selected" value=""><liferay-ui:message key="nochoose" /></option>
				<%
					List<PmlEdmConfidentialLevel> confidentialLevelList = PmlEdmConfidentialLevelUtil.findAll();
					int confidentialLevelSize = confidentialLevelList.size();
					for(int i = 0; i < confidentialLevelSize; i ++) {
						PmlEdmConfidentialLevel confidentialLevel = confidentialLevelList.get(i);
						String selected = confidentialLevel.getConfidentialLevelId().equals(displayTerms.getDoMat()) ? "selected" : "";
						out.print("<option value=\"" + confidentialLevel.getConfidentialLevelId() + "\" " + selected + ">" + confidentialLevel.getConfidentialLevelName() + "</option>");
					}
				%>
				</select>
			</td>
			
			<!-- radio button -->
			<td colspan="2" align="right" style="padding: 10px 0 0;">
				<input type="radio" name="<portlet:namespace/>radioTenPhongBan" id="<portlet:namespace/>tenPhongBan" <%= displayTerms.isRadioTenPhongBan() == true ? "checked" : "disabled" %> />&nbsp;<liferay-ui:message key="tinhhinhthulycongvan.tenphongban" />&nbsp;&nbsp;
				<input type="radio" name="<portlet:namespace/>radioTenChuyenVien" id="<portlet:namespace/>tenChuyenVien" <%= displayTerms.isRadioTenChuyenVien() == true ? "checked" : "disabled" %> />&nbsp;<liferay-ui:message key="tinhhinhthulycongvan.tenchuyenvien" />
			</td>
		</tr>
	</table>
	
	<div align="right">
		<input style="margin-right: 0;" type="submit" id="btnXemBaoCao" value='<liferay-ui:message key="tinhhinhthulycongvan.xembaocao" />' />
	</div>
</div>
		
</fieldset>

<script type="text/javascript">
	//minh update 20100607
	getDocumentRecordByDocTypeId(<%= userIdLogin %>);
	if (document.getElementById('<portlet:namespace />fromDate') != null) {
		callCalendar('<portlet:namespace />fromDate','cal-button-FromDate');
	}
	if (document.getElementById('<portlet:namespace />toDate') != null) {
		callCalendar('<portlet:namespace />toDate','cal-button-ToDate');
	}
	if (((document.getElementById("<portlet:namespace/>departmentId").value) == "toancoquan")
			|| (document.getElementById("<portlet:namespace/>departmentId").value) == "tatcaphongban") {
		<portlet:namespace/>enableItems('');
	}

</script>