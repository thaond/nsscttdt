<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
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
	<div class="parent-title"><liferay-ui:message key="management-workflow-journal"/></div>
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
		String dateFrom = "";
		String dateTo = "";
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
				dateFrom = simpleDateFormat.format(managementWorkflowJournal.getDateFrom());
			} else {
				row.addText("");
			}
			// ngay ket thuc
			if (managementWorkflowJournal.getDateTo() != null) {
				row.addText(simpleDateFormat.format(managementWorkflowJournal.getDateTo()));
				dateTo = simpleDateFormat.format(managementWorkflowJournal.getDateTo());
			} else {
				row.addText("");
				dateTo = "";
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
	<form name="<portlet:namespace />addform" action="<%= add_process %>" method="post" enctype="multipart/form-data" onsubmit="return <portlet:namespace />check_filetype_upload(this);" >
			<input type="hidden" name="<portlet:namespace />nameWorkflow" id="nameWorkflow"/>
			<!-- MoNT start 1/12/2010 -->
			<input name="<portlet:namespace />managementWorkflowJournalId" type="hidden" value="<%=managementWorkflowJournalId %>">
			<input name="<portlet:namespace />dateFromWorkFlow" type="hidden" value="<%=dateFrom %>">
			<input name="<portlet:namespace />dateToWorkFlow" type="hidden" value="<%=dateTo %>">
			<input name="<portlet:namespace />dateSaveUpdate" type="hidden" value="">
			<!-- MoNT end 1/12/2010 -->
			<fieldset class="filborder">	
			<label class="laborder"><liferay-ui:message key="add_new"/></label>
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
							<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
							(dd/mm/yyyy)
						</td>
					</tr>
					<tr>
						<td width="15%"><liferay-ui:message key="date_to"/>&nbsp;:</td>
						<td>
							<input name="<portlet:namespace />dateTo" id="<portlet:namespace />cal_to_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
							<img align="top" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
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
				</fieldset>
	</form>
</div>
<script type="text/javascript">
function <portlet:namespace />check_filetype_upload(form) {
	var fileName =	document.getElementById("fileWorkflow").value;
	var type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	if (fileName == "") {
		alert("<liferay-ui:message key='please-select-file-deploy'/>");
		return false;
	}
	if ("xml" == type) {
		document.getElementById("nameWorkflow").value = fileName.substring(0, fileName.length - 4);	
		// MoNT start 1/12/2010 
		var dateFromWorkFlow = form.<portlet:namespace />dateFromWorkFlow.value;
		var dateToWorkFlow = form.<portlet:namespace />dateToWorkFlow.value;
		if(checkDate(form) == true){
			var dateFrom = form.<portlet:namespace/>dateFrom.value;
			var dateTo = form.<portlet:namespace/>dateTo.value;
			var compareDateFromNow = checkDateFromNow(form);
			var compareFromOldFromNew = compareDate(form,dateFromWorkFlow,dateFrom);
			var compareFromNewToOld = compareDate(form,dateToWorkFlow,dateFrom);
			var compareDateFromTo = compareDate(form,dateFrom,dateTo);
			if(compareDateFromNow == false){
				alert("<liferay-ui:message key='date-from-must-not-be-less-than-date-now'/>");
				return false;
			}else if(compareFromOldFromNew == false){
				alert("<liferay-ui:message key='date-from-new-must-not-be-less-than-date-from-old'/>");
				return false;
			}else if(dateTo != ""){
				if(compareDateFromTo == false){
					alert("<liferay-ui:message key='date-to-must-not-be-less-than-date-from'/>");
					return false;
				}
			}
			if(dateToWorkFlow == ""){
				if(dateFromWorkFlow != ""){
					form.<portlet:namespace />dateSaveUpdate.value="saveAndUpdate";
					confirmUpdateWorkFlow();
					return false;
				}else{
					form.<portlet:namespace />dateSaveUpdate.value="save";	
				}
				return true;
			}else if(compareFromNewToOld == true){
				form.<portlet:namespace />dateSaveUpdate.value="save";
				return true;
			}else if(compareFromNewToOld == false){
				form.<portlet:namespace />dateSaveUpdate.value="saveAndUpdate";	
				confirmUpdateWorkFlow();
				return false;
			}
			return false;
		// MoNT end 1/12/2010 
		}else{
			return false;
		}
	} else {
		alert("<liferay-ui:message key='please-select-file-xml'/>");
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
	
	// MoNT start 1/12/2010 
	function checkDate(form) {
	  	 if (checkDateFrom(form) == false){
	      	 return false;
	   	 } else {
	    	 return true;
	     }
	}

	function checkDateFrom(form){
	    if(isDateTime(form.<portlet:namespace/>dateFrom.value) == false){
	    	return false;
	    }else{
	    	return true;
	    }
	}
	    
	function checkDateTo(form){
	   	if(isDateTime(form.<portlet:namespace/>dateTo.value) == false){
	    	return false;
	    }else{
	    	return true;
	    }
	}

	var dtCh= "/";
	function isInteger(s){
	   var i;
	   	for (i = 0; i < s.length; i++){   
	       var c = s.charAt(i);
	       if (((c < "0") || (c > "9"))) return false;
	   	}
	   return true;
	}

	function stripCharsInBag(s, bag){
	   var i;
	   var returnString = "";
	   	for(i = 0; i < s.length; i++){   
	        var c = s.charAt(i);
	        if (bag.indexOf(c) == -1) returnString += c;
	    }
	   return returnString;
	}

	function daysInFebruary (year){
	   return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	   
	function DaysArray(n) {
	   for(var i = 1; i <= n; i++) {
	    	this[i] = 31
	    	if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
	    	if (i==2) {this[i] = 29}
	   } 
	   return this
	}

	function isDateTime(dtStr){
	    var daysInMonth = DaysArray(12)
	    var pos1=dtStr.indexOf(dtCh)
	    var pos2=dtStr.indexOf(dtCh,pos1+1)
	    var strDay=dtStr.substring(0,pos1)
	    var strMonth=dtStr.substring(pos1+1,pos2)
	    var strYear=dtStr.substring(pos2+1)
	    strYr=strYear
	    if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	    if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	    	for (var i = 1; i <= 3; i++) {
	    		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	    	}
	    month=parseInt(strMonth)
	    day=parseInt(strDay)
	    year=parseInt(strYr)
	    	if (pos1==-1 || pos2==-1){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
	    		alert("<liferay-ui:message key='input-date-validate'/>")
	    		return false
	    	}
	    	if (strMonth.length<1 || month<1 || month>12){
	    		alert("<liferay-ui:message key='input-month-validate'/>")
	    		return false
	    	}
	    	if (strYear.length != 4 || year==0){
	    		alert("<liferay-ui:message key='input-year-validate'/>")
	    		return false
	    	}
	    	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	    		alert("<liferay-ui:message key='input-date-validate-dd-mm-yyyy'/>")
	    		return false
	    	}
	    	return true
	    }
	    
	 function checkDateFromNow(form){
	    var dateFrom = form.<portlet:namespace/>dateFrom.value;
	    var dayFrom = dateFrom.substring(0,2);
		var monthFrom = dateFrom.substring(3,5);
		var yearFrom = dateFrom.substring(6,10);
			
		var dateNow = new Date();
		var month = dateNow.getMonth() + 1;
		var day = dateNow.getDate();
		var year = dateNow.getFullYear();
			
		if(Date.parse(monthFrom + "/" + dayFrom + "/" + yearFrom) < Date.parse(month + "/" + day + "/" + year)){
	    	return false;	  
	    }else{
	    	return true;
	    }
	 }
	    
	 function compareDate(form,dateFrom,dateTo){
		var dayFrom = dateFrom.substring(0,2);
		var monthFrom = dateFrom.substring(3,5);
		var yearFrom = dateFrom.substring(6,10);
			
		var dayTo = dateTo.substring(0,2);
		var monthTo = dateTo.substring(3,5);
		var yearTo = dateTo.substring(6,10);
			
		if(Date.parse(monthTo + "/" + dayTo + "/" + yearTo) < Date.parse(monthFrom + "/" + dayFrom + "/" + yearFrom)){
	    	return false;	  
	    }else{
	    	return true;
	    }
	 }
	    
	 function confirmUpdateWorkFlow() {
		if (confirm('<%=UnicodeLanguageUtil.get(pageContext,
			"update-work-flow-old")%>')) {
			submitForm(document.<portlet:namespace/>addform,
		    	"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
		    	<portlet:param name="struts_action" value="/nss/managementworkflowjournal/view" />
		    	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
		    	</portlet:actionURL>");
		}
	}
	 // MoNT end 1/12/2010 
</script>
