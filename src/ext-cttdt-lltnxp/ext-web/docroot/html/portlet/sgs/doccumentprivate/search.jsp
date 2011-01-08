
<%@page import="com.sgs.portlet.doccumentprivate.search.DocumentPrivateSearchTearms"%>
<%@page import="com.sgs.portlet.documentdelegate.util.PmlDocumentDelegateUtil"%>
<%@page import="com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.doccumentprivate.search.DocumentPrivateDisplayTearms"%>
<%@page import="com.sgs.portlet.doccumentprivate.search.DocumentPrivateSearch"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/sgs/doccumentprivate/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<%
	String listUserId = renderRequest.getAttribute("listUserId") != null ? (String)renderRequest.getAttribute("listUserId") : "";
	
	DocumentPrivateSearch searchContainer = (DocumentPrivateSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DocumentPrivateDisplayTearms displayTerms = (DocumentPrivateDisplayTearms) searchContainer.getDisplayTerms();
	DocumentPrivateSearchTearms searchTearms = (DocumentPrivateSearchTearms) searchContainer.getSearchTerms();
	String[] listUserIdArr = new String[0];
	int listUserIdlength = 0;
	if (listUserId != null) {
		listUserIdArr = listUserId.split(",");
		listUserIdlength = listUserIdArr.length;
	}
	
	
	
	
	long userId = 0;
	List<PmlUser> pmlUsers = null;
	try {
		userId = PortalUtil.getUserId(renderRequest);	
		PmlUser pmlUserLogin = PmlUserLocalServiceUtil.getPmlUser(userId);
		pmlUsers = PmlUserUtil.findByDepartmentsId(pmlUserLogin.getDepartmentsId());
		
	} catch (Exception e) {
		pmlUsers = new ArrayList<PmlUser>();
	}
	int pmlUsersSize = pmlUsers.size();
	
	String tuNgay = displayTerms.getTuNgay();
	String denNgay = displayTerms.getDenNgay();
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	tuNgay = tuNgay.equals("") ? "01/01/" + year : tuNgay;
	denNgay = denNgay.equals("") ? "31/12/" + year : denNgay;
	%>

<script type="text/javascript">
	window.onload = function () 
	{

		if (document.getElementById('<portlet:namespace/>tuNgay') != null) {
			callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay');
		}
		
		if (document.getElementById('<portlet:namespace/>denNgay') != null) {
			callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay');
		}
</script>


<!-- form name="<portlet:namespace />search"-->
	<fieldset class="filborder ">
			<table cellspacing="0" width="100%">
				<tr>
					<%
						String rowAllName = "checkallbox";
						String formName = renderResponse.getNamespace() + "fm";
						String rowName = renderResponse.getNamespace() + "search";
						
						
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
						
					
					%>
				  		<td valign="top"><liferay-ui:message key="pccc-cvdtn-nguoi-tao"/>&nbsp;:</td>
					    <td colspan="3">
					      <div class="cvd-filedinhkem table-border-pml" style="width: 100%" class="Scrollbarauto">
					      	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
								<tr class="portlet-section-header results-header" >
									<td align="center" width="35px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
									<td width="45px" align="center">STT</td>
									<td ><liferay-ui:message key="name"/></td>
								</tr>
					      	<%
							
					      	PmlUser pU = null;
					      	boolean checked = false;
							for (int i = 0; i < pmlUsersSize; i ++) {
								pU = pmlUsers.get(i);
								for (int j = 0; j < listUserIdArr.length; j++) {
									if (String.valueOf(pU.getUserId()).equals(listUserIdArr[j])) {
										checked = true;
										break;
									}
									else {
										checked = false;
									}
									
								}
								
								
							%>
							
								<tr  class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
										<td width="35px" align="center">
											<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />search" value="<%= pU.getUserId()  %>" type="checkbox"  <%= checked==true ? "checked" : "" %> />
										</td>
										<td width="45px" align="center"><%= i + 1 %>.</td>
										<td><%= PmlDocumentDelegateUtil.getFullName(pU.getUserId())%></td>					
								</tr>
							
								<%
								
							}
							%>
						</table>
					     </div>
					    </td>
				
				  </tr>
				<tr>
					<td><liferay-ui:message key="tu-ngay"/>&nbsp;:</td>
					<td >
						<input style="width: 80%" type="text" name="<portlet:namespace/>tungay" id="<portlet:namespace/>tuNgay" value="<%= tuNgay %>" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-tuNgay" onClick="callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay')" />
					</td>
					<td ><liferay-ui:message key="den-ngay"/>&nbsp;:</td>
					<td >
						<input style="width: 80%" type="text" name="<portlet:namespace/>denngay" id="<portlet:namespace/>denNgay" value="<%= denNgay %>" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-denNgay" onClick="callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay')" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"><input type="submit" value="<liferay-ui:message key="search"/>" onclick="<portlet:namespace/>getUsersChoice();" /> </td>
				 </tr>
			</table>
	</fieldset>
	
	<c:if test="<%= (pmlUsersSize == listUserIdlength) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
	</c:if>
	
	
<!-- /form-->

<script type="text/javascript">
	function <portlet:namespace/>getUsersChoice() {
		document.<portlet:namespace/>fm.<portlet:namespace/>listUserId.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
	}
</script>