<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.documentdelegate.util.PmlDocumentDelegateUtil"%>
<%@page import="com.sgs.portlet.documentdelegate.search.PmlDocumentDelegateSearchTerms"%>
<%@page import="com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate"%>
<%@page import="com.sgs.portlet.documentdelegate.search.PmlDocumentDelegateSearch"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/ext/documentdelegate/init.jsp" %>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.util.PmlUserUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="java.util.List"%>

<%
	
	List<PmlUser> pmlUserDelegates = renderRequest.getAttribute("pmlUserDelegates") != null ? (List<PmlUser>) renderRequest.getAttribute("pmlUserDelegates") : new ArrayList<PmlUser>();
	List<PmlUser> pmlUserIsDelegates = renderRequest.getAttribute("pmlUserIsDelegates") != null ? (List<PmlUser>) renderRequest.getAttribute("pmlUserIsDelegates"): new ArrayList<PmlUser>();
	String selected = "";
	String userFullName = "";
	User userModel = null;
	long userDelelegate = ParamUtil.getLong(renderRequest, "userDelelegate", 0);
	if (pmlUserDelegates.size() == 1) {
		userDelelegate = PortalUtil.getUserId(renderRequest);
	}
	boolean dateAllUser = ParamUtil.getBoolean(renderRequest,"dateAllUser", true);
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("userDelelegate", String.valueOf(userDelelegate));
	portletURL.setParameter("struts_action", "/sgs/documentdelegate/view");
	
	String portletURLUserDelegateString = portletURL.toString() + "&dateAllUser="+ String.valueOf(dateAllUser);
	
	portletURL.setParameter("userDelelegate", String.valueOf(userDelelegate));
	
	String portletURLCheckString = portletURL.toString();
	
	portletURL.setParameter("dateAllUser", String.valueOf(dateAllUser));
	
	boolean checkAllUser = ParamUtil.getBoolean(renderRequest, "checkAllUser", false);
%>
<div class="title_categ"><liferay-ui:message key="uy-quyen"/></div>
<div class="boxcontent">

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;" class="retureadd">
		<input name="<portlet:namespace/>addUserIsDelegate"  type="hidden" value=""/>
		<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message key="thuc-hien-uy-quyen"/></label>
				<table cellspacing="0" width="100%">
					<tr>
					  	<td width="20%"><liferay-ui:message key="nguoi-uy-quyen"/>&nbsp;:</td>
					  	<td>			  
					  		<select name='<portlet:namespace/>userDelelegate' id="<portlet:namespace/>userDelelegate" onchange="javascript:submitForm(document.hrefFm, this.value)">
					  			<%
					  			 if (pmlUserDelegates.size() > 1) {
					  			%>
					  			 <option value="<%= portletURLUserDelegateString %>&userDelelegate=0" <%= userDelelegate == 0 ?  "selected" :"" %> ></option>
					  			<% 
					  			 }
					  			for (PmlUser pmlUserDelegate : pmlUserDelegates) {
					  				userModel = UserLocalServiceUtil.getUser(pmlUserDelegate.getUserId());
					  				userFullName = userModel.getLastName() + " "+ userModel.getMiddleName() + " "+ userModel.getFirstName();
					  			%>
					  				<option value="<%= portletURLUserDelegateString %>&userDelelegate=<%= pmlUserDelegate.getUserId()%>" <%= userDelelegate == pmlUserDelegate.getUserId() ?  "selected" :"" %> > <%= userFullName %></option>
					  			<%
					  			}
					  			
					  			%>
					  		</select>
					  		
					  		&nbsp;&nbsp;&nbsp;
					  		<liferay-ui:message key="check-all-user"/>
						 	<input type="checkbox" id="checkAllUser" name="<portlet:namespace/>checkAllUser" 
						 			<%= checkAllUser ? "checked" : "" %> onclick="checkAllUserFunction()"/>
					 	</td>
					 	
					</tr>
				
				<% if (!dateAllUser) {%>
				<tr>
						<td><liferay-ui:message key="chon-ngay-uy-quyen"/>&nbsp;:</td>
						<td>
							<input style="width: 35%;" type="text" name="<portlet:namespace/>fromDateDelegate" id="fromDateDelegate" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>'>
							   <img align="top" style="cursor: pointer" id="cal-button-fromDateDelegate" src="/html/images/cal.gif" onclick="callCalendar('fromDateDelegate','cal-button-fromDateDelegate')"/>
						</td>
					</tr>
					<tr>
						<td><liferay-ui:message key="chon-ngay-ket-thuc-uy-quyen"/>&nbsp;:</td>
						<td>
							<input style="width: 35%;" type="text" name="<portlet:namespace/>toDateDelegate" id="toDateDelegate" value=''>
						    <img align="top" style="cursor: pointer" id="cal-button-toDateDelegate" src="/html/images/cal.gif" onclick="callCalendar('toDateDelegate','cal-button-toDateDelegate')"/>
						</td>
					</tr>
					<%} %>
					<tr>
						<td><liferay-ui:message key="chon-ngay-uy-quyen-cu-the"/>&nbsp;:</td>
						<td align="left">
							<input style="padding-right: 10px;" type="checkbox" "<%= ParamUtil.getBoolean(renderRequest,"dateAllUser", true) == true ? "checked" : "" %>" name="<portlet:namespace/>dateAllUser" id="dateAllUser" onclick="javascript:submitForm(document.hrefFm, '<%= portletURLCheckString %>' + '&dateAllUser='+ this.checked)"  >
							<liferay-ui:message key="xu-dung-ngay-uy-quyen-cu-the"/>						
						</td>
					</tr>
				<tr>
				<td></td>
						<td >
					      <div style="width: 100%" class="Scrollbarauto">
					      
					      	<%
								String rowAllName = "checkallbox";
								String formName = renderResponse.getNamespace() + "fm";
								String rowName = renderResponse.getNamespace() + "userIsDelelegate";
							
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
					      	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
								<tr class="portlet-section-header results-header" >
									<td align="center" width="40px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
									<td width="30px" align="center">STT</td>
									<td ><liferay-ui:message key="nguoi-duoc-uy-quyen"/></td>
									<% if (dateAllUser) {%>
									<td width="30%"><liferay-ui:message key="chon-ngay-uy-quyen"/></td>
									<td width="30%"><liferay-ui:message key="chon-ngay-ket-thuc-uy-quyen"/></td>
									<% } %>
								</tr>
						      	<%
						      	int i = 0;
						      	long userIsDelegateLong = 0;
						      	for (PmlUser pmlUserIsDelegate : pmlUserIsDelegates) {
						      		userModel = UserLocalServiceUtil.getUser(pmlUserIsDelegate.getUserId());
					  				userFullName = userModel.getLastName() + " "+ userModel.getMiddleName() + " "+ userModel.getFirstName();
					  				userIsDelegateLong = pmlUserIsDelegate.getUserId();
								%>
								
									<tr  class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
										<td align="center">
											<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />userIsDelelegate" value="<%= userIsDelegateLong  %>" type="checkbox"   />
										</td>
										<td align="center"><%= i + 1 %>.</td>
										<td><%= userFullName %></td>
										<% if (dateAllUser) {%>
										<td >
											<input  style="width: 75%;" type="text" name="<portlet:namespace/>fromDateDelegate<%= pmlUserIsDelegate.getUserId() %>" id="fromDateDelegate<%= pmlUserIsDelegate.getUserId() %>" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>'>
				    						<img align="top" style="cursor: pointer" id="cal-button-fromDateDelegate<%= userIsDelegateLong %>" src="/html/images/cal.gif" onclick="callCalendar('fromDateDelegate<%= userIsDelegateLong %>','cal-button-fromDateDelegate<%= userIsDelegateLong %>')"/>
										</td>
										<td>
											<input style="width: 75%;" type="text" name="<portlet:namespace/>toDateDelegate<%= pmlUserIsDelegate.getUserId() %>" id="toDateDelegate<%= pmlUserIsDelegate.getUserId() %>" value=''>
				    						<img align="top" style="cursor: pointer" id="cal-button-toDateDelegate<%= userIsDelegateLong %>" src="/html/images/cal.gif" onclick="callCalendar('toDateDelegate<%= userIsDelegateLong %>','cal-button-toDateDelegate<%= userIsDelegateLong %>')"/>
										</td>	
										<% } %>				
									</tr>
								
								<%
								i++;
								}
								%>
							</table>
					     </div>
					    </td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input style="margin-left: 0; width: 80px;" type="button" value='<liferay-ui:message key="save"/>' onclick="<portlet:namespace/>updateDocumentDelegate(document.getElementById('<portlet:namespace/>userDelelegate').value + '&dateAllUser='+ document.getElementById('dateAllUser').checked);"/>
						</td>
					</tr>
				</table>
			</fieldset>	
			
			
	<%
	
		PmlDocumentDelegateSearch pmlDocumentDelegateSearch = new PmlDocumentDelegateSearch(renderRequest, portletURL);
	    PmlDocumentDelegateSearchTerms pmlDocumentDelegateSearchTerms = (PmlDocumentDelegateSearchTerms) pmlDocumentDelegateSearch.getSearchTerms();
	    
	    List<PmlDocumentDelegate> results = new ArrayList<PmlDocumentDelegate>();
	    int total = 0;
	    if (userDelelegate > 0 ||  pmlUserDelegates.size() == 1) {
			 results = PmlDocumentDelegateLocalServiceUtil.getPmlDocumentDelegate_SD_TD_USERISDELEGATE(userDelelegate, 
							pmlDocumentDelegateSearchTerms.getFromDateDelegate(), pmlDocumentDelegateSearchTerms.getToDateDelegate(), pmlDocumentDelegateSearchTerms.getListUserIsDelegate(),
							pmlDocumentDelegateSearch.getStart(), pmlDocumentDelegateSearch.getEnd(), pmlDocumentDelegateSearch.getOrderByComparator());
			
			
			 total =PmlDocumentDelegateLocalServiceUtil.countPmlDocumentDelegate_SD_TD_USERISDELEGATE(userDelelegate, 
					pmlDocumentDelegateSearchTerms.getFromDateDelegate(), pmlDocumentDelegateSearchTerms.getToDateDelegate(), pmlDocumentDelegateSearchTerms.getListUserIsDelegate());
	    } else {
	    	results = PmlDocumentDelegateLocalServiceUtil.getPmlDocumentDelegates(pmlDocumentDelegateSearch.getStart(), pmlDocumentDelegateSearch.getEnd());
	    	total =PmlDocumentDelegateLocalServiceUtil.getPmlDocumentDelegatesCount();
	    	
	    }
		pmlDocumentDelegateSearch.setTotal(total);
		pmlDocumentDelegateSearch.setResults(results);
		portletURL.setParameter(pmlDocumentDelegateSearch.getCurParam(), String.valueOf(pmlDocumentDelegateSearch.getCurValue()));
	%>
	
	<%
		List resultRow = pmlDocumentDelegateSearch.getResultRows();
		ResultRow row = null;
		PmlDocumentDelegate pmlDocumentDelegate = null;
		long pmlDocumentDelegateId = 0;
		
		
		for (int z = 0; z < results.size(); z++) {
			pmlDocumentDelegate = results.get(z);
			pmlDocumentDelegateId = pmlDocumentDelegate.getDocumentDelegateId();
			row = new ResultRow(pmlDocumentDelegate, pmlDocumentDelegateId, z);
			// STT
			row.addText(String.valueOf(z + 1));
			
			// ten nguoi uy quyen
			row.addText(PmlDocumentDelegateUtil.getFullName(pmlDocumentDelegate.getUserDelegateId()));
			
			// ten nguoi duoc uy quyen
			row.addText(PmlDocumentDelegateUtil.getFullName(pmlDocumentDelegate.getUserIsDelegateId()));
			
			
			// ngay bat dau uy quyen
			if (pmlDocumentDelegate.getFromtDate() != null && !"".equals(pmlDocumentDelegate.getFromtDate())) {
				row.addText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentDelegate.getFromtDate()));
			} else {
				row.addText("");
			}
			// ngay ket thuc uy quyen
			if (pmlDocumentDelegate.getToDate() != null && !"".equals(pmlDocumentDelegate.getToDate())) {
				row.addText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentDelegate.getToDate()));
			} else {
				row.addText("");
			}
			
			// ngay ngung uy quyen
			if (pmlDocumentDelegate.getCancelDate() != null && !"".equals(pmlDocumentDelegate.getCancelDate())) {
				row.addText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentDelegate.getCancelDate()));
			} else {
				row.addText("");
			}
			
			// huy bo uy quyen
			
			if (pmlDocumentDelegate.getCancelDate() == null && (pmlDocumentDelegate.getToDate() == null ||  pmlDocumentDelegate.getToDate().getTime() + 86400000  >= new Date().getTime())) {
					row.addText("<a onclick='" + renderResponse.getNamespace() + "cancelDocumentDelegate("+  pmlDocumentDelegateId + ");'><img src='/html/images/blue.gif' border='0' /> </a>");
			
			} else { 
				row.addText("<img src='/html/images/red.gif' border='0' />");
			} 
			
			resultRow.add(row);
		}
		
	%>

		<liferay-ui:search-iterator searchContainer="<%= pmlDocumentDelegateSearch %>" />
			
</form>
</div>	
	<script type="text/javascript">
	
	
	<% 
	int count = pmlUserIsDelegates.size();
	long userIdCount = 0;
	for (int j=0 ; j < count; j++) { 
		userIdCount = pmlUserIsDelegates.get(j).getUserId();
	%>
		if (document.getElementById('fromDateDelegate<%= userIdCount%>') != null) {
			callCalendar('fromDateDelegate<%= userIdCount%>','cal-button-fromDateDelegate<%= userIdCount%>');
		}
		
		if (document.getElementById('toDateDelegate<%= userIdCount%>') != null) {
			callCalendar('toDateDelegate<%= userIdCount%>','cal-button-toDateDelegate<%= userIdCount%>');
		}
	<%} %>
	
	if (document.getElementById('fromDateDelegate') != null) {
		callCalendar('fromDateDelegate','cal-button-fromDateDelegate');
	}
		
	if (document.getElementById('toDateDelegateSearch') != null) {
		callCalendar('toDateDelegate','cal-button-toDateDelegate');
	}
	
	function <portlet:namespace/>updateDocumentDelegate(url) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addUserIsDelegate.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
		document.<portlet:namespace/>fm.action = url + "&update=true";
		submitForm(document.<portlet:namespace/>fm);
	}
	
	function <portlet:namespace/>searchDocumentDelegate(url) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addUserIsDelegate.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
		document.<portlet:namespace/>fm.action = url + "&update=false";
		submitForm(document.<portlet:namespace/>fm);
	}
	
	function <portlet:namespace/>cancelDocumentDelegate(pDId) {
		var url = document.getElementById('<portlet:namespace/>userDelelegate').value + '&dateAllUser='+ document.getElementById('dateAllUser').checked + '&pmlDocumentDelegateId=' + pDId;
		document.<portlet:namespace/>fm.action = url + "&cancel=true";
		submitForm(document.<portlet:namespace/>fm);
	}
	
	function <portlet:namespace/>checkDateAllUser() {
		
	}

	function checkAllUserFunction() {
		submitForm(document.<portlet:namespace/>fm);
	}
	</script>