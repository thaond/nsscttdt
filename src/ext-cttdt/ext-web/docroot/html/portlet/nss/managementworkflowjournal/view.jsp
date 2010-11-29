<%@page import="com.nss.portlet.managementworkflowjournal.ManagementWorkflowJournalCanNotDeleteException"%>
<%@ include file="/html/portlet/nss/managementworkflowjournal/init.jsp" %>
<%@page import="com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal"%>
<%@page import="com.nss.portlet.managementworkflowjournal.search.ManagementWorkflowJournalSearchTerms"%>
<%@page import="com.nss.portlet.managementworkflowjournal.search.ManagementWorkflowJournalSearch"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />


<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/managementworkflowjournal/view");
	String error_delete_workflowjounal = (String) request.getAttribute("error_delete_workflowjounal");
%>
<% if(error_delete_workflowjounal != null){ %>
	<div style="color: red"><liferay-ui:message key="error_delete_workflowjounal"/></div>
<% } %>
	<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<div class="title_categ"><liferay-ui:message key="management-workflow-journal"/></div>
	<div class="boxcontent">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= com.nss.portlet.managementworkflowjournal.ManagementWorkflowJournalCanNotDeleteException.class %>" message="not-deploy-workflow-journal" />
	<%
		ManagementWorkflowJournalSearch managementWorkflowJournalSearch = new ManagementWorkflowJournalSearch(renderRequest, portletURL);
		ManagementWorkflowJournalSearchTerms searchTerms = (ManagementWorkflowJournalSearchTerms)managementWorkflowJournalSearch.getSearchTerms();
		managementWorkflowJournalSearch.setDelta(10);
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/managementworkflowjournal/search_form.jsp"
		searchContainer="<%= managementWorkflowJournalSearch %>" />
	<%
		List<ManagementWorkflowJournal> results = new ArrayList<ManagementWorkflowJournal>();
		int total = 0;
		if (searchTerms.isAdvancedSearch()) {
			results = ManagementWorkflowJournalLocalServiceUtil.search(searchTerms.getWorkflowName(), searchTerms.getVersion(), searchTerms.isAndOperator(),
					managementWorkflowJournalSearch.getStart(), managementWorkflowJournalSearch.getEnd(), managementWorkflowJournalSearch.getOrderByComparator());
			total = ManagementWorkflowJournalLocalServiceUtil.searchCount(searchTerms.getWorkflowName(), searchTerms.getVersion(), searchTerms.isAndOperator());
		}
		else {
			results = ManagementWorkflowJournalLocalServiceUtil.search(searchTerms.getKeywords(), managementWorkflowJournalSearch.getStart(),
					managementWorkflowJournalSearch.getEnd(), managementWorkflowJournalSearch.getOrderByComparator());
			total = ManagementWorkflowJournalLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		managementWorkflowJournalSearch.setTotal(total);
		managementWorkflowJournalSearch.setResults(results);
		portletURL.setParameter(managementWorkflowJournalSearch.getCurParam(), String.valueOf(managementWorkflowJournalSearch.getCurValue()));
	%>
	<div id="separator"></div>

	<%
		List resultRows = managementWorkflowJournalSearch.getResultRows();
		ResultRow row = null;	
		ManagementWorkflowJournal managementWorkflowJournal = null;
		long managementWorkflowJournalId = 0;	
		long processdefinitionId = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			managementWorkflowJournal = results.get(i);
			managementWorkflowJournalId = managementWorkflowJournal.getManagementWorkflowJournalId();
			processdefinitionId = managementWorkflowJournal.getProcessDefinitionId();
			
			row = new ResultRow(managementWorkflowJournal, managementWorkflowJournalId, i);
			// STT
			row.addText(String.valueOf(i + 1));
			// ten quy trinh
			row.addText(managementWorkflowJournal.getWorkflowname());
			// version workflow
			row.addText(String.valueOf(managementWorkflowJournal.getVersion_()));
			// mo ta
			row.addText(managementWorkflowJournal.getDescription());
			// ngay bat dau
			
			if (managementWorkflowJournal.getDateFrom() != null) {
				row.addText(simpleDateFormat.format(managementWorkflowJournal.getDateFrom()));
			} else {
				row.addText("");
			}
			// ngay ket thuc
			if (managementWorkflowJournal.getDateTo() != null) {
				row.addText(simpleDateFormat.format(managementWorkflowJournal.getDateTo()));
			} else {
				row.addText("");
			}
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/managementworkflowjournal/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("manageDocumentWorkflowId", String.valueOf(managementWorkflowJournalId));
			rowURLDelete.setParameter("processdefinitionId", String.valueOf(processdefinitionId));
			rowURLDelete.setParameter("redirect", managementWorkflowJournalSearch.getIteratorURL().toString());
			deleteURL = "<a  href='javascript: ;'  onclick=deleteDocumentWorkflow('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			row.addText(deleteURL);
			
			resultRows.add(row);
		}
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= managementWorkflowJournalSearch %>" />
	<br>
	<div align="right">
		<input onclick="showAddForm()" type="button" value='<liferay-ui:message key="add_new"/>'>
	</div>
</div>
</form>

<!--  add  -->
	<portlet:actionURL var="add_process">
		<portlet:param name="struts_action" value="/nss/managementworkflowjournal/view" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	</portlet:actionURL>

<div id="showForm" style="display: none;">
	<form action="<%= add_process %>" method="post" enctype="multipart/form-data" onsubmit="return <portlet:namespace />check_filetype_upload();" >
			<input type="hidden" name="<portlet:namespace />nameWorkflow" id="nameWorkflow"/>
			<div class="title_categ"><liferay-ui:message key="add_new"/></div>
			<div class="boxcontent">
				<table cellspacing="0" width="100%" >
					<tr>
						<td width="15%"><liferay-ui:message key="file-deploy"/>&nbsp;:</td>
						<td>
							<input style="width: 90%" type="file" name="<portlet:namespace />fileWorkflow" id="fileWorkflow"/>
						</td>
					</tr>
					<tr>
						<td width="15%"><liferay-ui:message key="date_from"/>&nbsp;:</td>
						<td>
							<input name="<portlet:namespace />dateFrom" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
							<img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
							(dd/mm/yyyy)
						</td>
					</tr>
					<tr>
						<td width="15%"><liferay-ui:message key="date_to"/>&nbsp;:</td>
						<td>
							<input name="<portlet:namespace />dateTo" id="<portlet:namespace />cal_to_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
							<img src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
							(dd/mm/yyyy)
						</td>
					</tr>
					
					<tr>
						<td ><liferay-ui:message key="description"/>&nbsp;:</td>
						<td><textarea name="description" id="description" rows="5" style="width: 97%"></textarea></td>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="save"/>' />
							<input type="reset" value='<liferay-ui:message key="reset"/>' />
						</td>
					</tr>
				</table>
			</div>
	</form>
</div>
<script type="text/javascript">
	function <portlet:namespace />check_filetype_upload() {
		var fileName =	document.getElementById("fileWorkflow").value;
		var type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if (fileName == "") {
			alert("<liferay-ui:message key='vui-long-chon-tap-tin-'/>");
			return false;
		}
		if ("xml" == type) {
			document.getElementById("nameWorkflow").value = fileName.substring(0, fileName.length - 4);			
			return true;
		} else {
			alert("<liferay-ui:message key='vui-long-chon-file-xml'/>");
			return false;
		}
	}
	
	function deleteDocumentWorkflow(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	function showAddForm () {
		jQuery('#showForm').toggle('slide');
	}
	
	if (document.getElementById('<portlet:namespace />cal_from_date') != null) {
		callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate');
	}
		
	if (document.getElementById('<portlet:namespace />cal_to_date') != null) {
		callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate');
	}
		
	
</script>
