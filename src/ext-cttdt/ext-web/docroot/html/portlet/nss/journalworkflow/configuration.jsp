<%@ include file="/html/portlet/nss/journalworkflow/init.jsp" %>

<%
	List<Role> roles = RoleFilter.getRolesHavePermission(themeDisplay.getCompanyId(), ActionKeys.ADD_ARTICLE);
	List<JournalProcessDefinition> processDefinitions = null;
	
	try {
		//processDefinitions = ProcessDefinitionUtil.findAll();
		processDefinitions = JournalProcessDefinitionLocalServiceUtil.getJournalProcessDefinitions(-1,-1);
	} catch(SystemException e) {
		e.printStackTrace();
	}
	
	JournalProcessDefinition pTemp = null;
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest,portletResource);
	
	businessProcessId = GetterUtil.getLong(preferences.getValue("bpid",""));
	
	try {
		if (businessProcessId > 0)
		processDefinition = JournalProcessDefinitionLocalServiceUtil.getJournalProcessDefinition(Long.valueOf(businessProcessId));
	} catch (SystemException e) {
		e.printStackTrace();
	} catch (PortalException e) {
		e.printStackTrace();
	}
	if (processDefinition != null) {
		taskNodeName = XmlRead.getNodeName("task-node", processDefinition.getContent());
	}
	currentRoles = new String[taskNodeName.size()];
	for (int i = 0; i < taskNodeName.size(); i++) {
		currentRoles[i] = preferences.getValue(taskNodeName.get(i),"");
	}
	long currentBpid = 0;
	if (processDefinition != null) currentBpid= processDefinition.getJournalProcessDefinitionId();
	
	delta = GetterUtil.getInteger(preferences.getValue("delta",""));
%>

<script type="text/javascript">
	
	function <portlet:namespace />save() {
		jQuery('#<portlet:namespace />fm1').ajaxSubmit();
		submitForm(document.<portlet:namespace />fm1);
	}
	function <portlet:namespace />chooseBusinessProcess(bpid) {
		document.<portlet:namespace />fm1.<portlet:namespace />currentBpid.value = bpid;
		submitForm(document.<portlet:namespace />fm1);
	}
	
</script>

<liferay-portlet:actionURL portletConfiguration="true" var="confURL"></liferay-portlet:actionURL>

<form action="<%=confURL %>" method="post" name="<portlet:namespace/>fm1">
	<input type="hidden" name="<portlet:namespace />currentBpid" value="<%=currentBpid %>"/>
		<table>
			<tr>
				<td><liferay-ui:message key="choose-bussiness-process"/></td>
				<td>
					<select name="<portlet:namespace/>bpid" onchange="<portlet:namespace />chooseBusinessProcess(this.value);">
						<option><liferay-ui:message key="please-select"/></option>
						<c:if test="<%=processDefinitions != null %>">
							<%for (int i = 0; i < processDefinitions.size(); i++) {
								pTemp = processDefinitions.get(i);
							%>
								<option value="<%=pTemp.getJournalProcessDefinitionId() %>" <%=(currentBpid == pTemp.getJournalProcessDefinitionId()) ? "selected" : "" %>><%=pTemp.getName() + " - " + pTemp.getVersion() %></option>
							<%} %>
						</c:if>
					</select>
				</td>
			</tr>
			<% if (taskNodeName.size() > 0) {
				for (int i = 0; i < taskNodeName.size(); i ++) {
					String name = taskNodeName.get(i);
					if ("bien tap".equals(taskNodeName.get(i))) {
						name = "bientap";
					}
					
				%>
			<tr>
				<td><liferay-ui:message key="<%= name %>"/></td>
				<td>
					<select name="<portlet:namespace/><%=taskNodeName.get(i) %>">
						<option value="" selected="selected"><liferay-ui:message key="please-select"/></option>
						<%for (int j = 0; j < roles.size(); j++) {%> 
						<option value="<%=roles.get(j).getName() %>" <%= (currentRoles[i].equals(roles.get(j).getName())) ? "selected" : "" %>><%=roles.get(j).getName() %></option>
						<%} %>
					</select>
				</td>
			</tr>
				<% 
					}
				}
			%>
			<tr>
				<td><liferay-ui:message key="maximum-items-to-display" /></td>
				<td>
					<select name="<portlet:namespace />delta">
						<option <%= (delta == 1) ? "selected" : "" %> value="1">1</option>
						<option <%= (delta == 2) ? "selected" : "" %> value="2">2</option>
						<option <%= (delta == 3) ? "selected" : "" %> value="3">3</option>
						<option <%= (delta == 4) ? "selected" : "" %> value="4">4</option>
						<option <%= (delta == 5) ? "selected" : "" %> value="5">5</option>
						<option <%= (delta == 10) ? "selected" : "" %> value="10">10</option>
						<option <%= (delta == 15) ? "selected" : "" %> value="15">15</option>
						<option <%= (delta == 20) ? "selected" : "" %> value="20">20</option>
						<option <%= (delta == 25) ? "selected" : "" %> value="25">25</option>
						<option <%= (delta == 30) ? "selected" : "" %> value="30">30</option>
						<option <%= (delta == 40) ? "selected" : "" %> value="40">40</option>
						<option <%= (delta == 50) ? "selected" : "" %> value="50">50</option>
						<option <%= (delta == 60) ? "selected" : "" %> value="60">60</option>
						<option <%= (delta == 70) ? "selected" : "" %> value="70">70</option>
						<option <%= (delta == 80) ? "selected" : "" %> value="80">80</option>
						<option <%= (delta == 90) ? "selected" : "" %> value="90">90</option>
						<option <%= (delta == 100) ? "selected" : "" %> value="100">100</option>
					</select>
				</td>
			</tr>
		</table>
	<input type="button" value="<liferay-ui:message key="save"/>" onclick="<portlet:namespace />save();"/>
</form>