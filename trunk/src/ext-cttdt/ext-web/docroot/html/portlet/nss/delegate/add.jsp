<%@ include file="/html/portlet/nss/delegate/init.jsp" %>

<%@page import="java.util.List"%>


<%@page import="com.nss.portlet.department.model.Department"%>
<%@page import="com.nss.portlet.department.service.DepartmentLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/delegate/js/delegate_add_js.jsp"></liferay-util:include>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<%
	String assigner = (String)renderRequest.getAttribute("assigner");
	String redirect = renderRequest.getParameter("redirect");
	String[] pmlFileTypeChecked = (String[]) renderRequest.getAttribute("pmlFileTypeChecked")== null ? new String[]{} : (String[]) renderRequest.getAttribute("pmlFileTypeChecked");
%>
<portlet:actionURL var="add">
	<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
	<portlet:param name="struts_action" value="/nss/delegate/view"/>
</portlet:actionURL>

<form action="<%= add %>" method="post" name="<portlet:namespace />fm" onsubmit="return validate();">
	<input type="hidden" name="<portlet:namespace />currUser" value="<%= user.getUserId() %>" />
	<div class="commom-form">

	<%
		if (PortalUtil.getUser(renderRequest) == null) {
	%>
		<div><liferay-ui:message key="delegate-chuadangnhap"/></div>
	<%
	} 
	else {
	%>
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_DELEGATE"/></div>
		<table cellspacing="0" width="100%">
				<tr>
					<td style="width: 20%"><label><liferay-ui:message key="delegate-nguoiuyquyen"/>&nbsp;:<font color="red">(*)</font></label></td>
					<td ><input style="width: 50%" type="text" name="assigner" readonly="readonly" id="assigner" value='<%=assigner != null ? assigner : "" %>' /></td>
				</tr>
				<tr>
				<td><label><liferay-ui:message key="delegate-nguoiduocuyquyen"/>&nbsp;:<font color="red">(*)</font></label></td>
					<td>
						<select style="width: 51%" name="<portlet:namespace />department" onchange="<portlet:namespace />changeDepartment();">
							<option value="" selected="selected">[-- <liferay-ui:message key="select"/> --]</option>
							<%
							List<Department> deps = DepartmentLocalServiceUtil.getDepartments(-1, -1);
							if (deps != null && !deps.isEmpty()) {
								for (int idxD = 0; idxD < deps.size(); idxD ++) {
									Department depItem = deps.get(idxD);
							%>
									<option value="<%= depItem.getDepartmentsId() %>">&nbsp;<%= depItem.getDepartmentsName() %></option>
							<%
								}
							}
							%>
						</select>&nbsp;
						<select style="width: 30%" name="receiver" id="receiver">
							<option value="" selected="selected">[-- <liferay-ui:message key="select"/> --]</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label><liferay-ui:message key="delegate-ngaybatdauuyquyen"/>&nbsp;:<font color="red">(*)</font></label></td>
					<td>
					<input type="text" name="startDate" id="startDate" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>' maxlength="10" />
					<input align="top" type="image" id="cal-button" src="/html/images/cal.gif" />
						<script type="text/javascript">
							Calendar.setup( {
								inputField :"startDate",
								button :"cal-button",
								align :"br"
							});
						</script>
				</td>
			</tr>
			<tr>
				<td><label><liferay-ui:message key="delegate-ngayketthucuyquyen"/>&nbsp;:<font color="red">(*)</font> </label></td>
					<td>
					<input type="text" name="endDate" id="endDate" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>' maxlength="10" />
					<input align="top" type="image" id="cal-button-endDate" src="/html/images/cal.gif" />
						<script type="text/javascript">
							Calendar.setup( {
								inputField :"endDate",
								button :"cal-button-endDate",
								align :"br"
							});
						</script>
				</td>
			</tr>
			<tr>
				<td valign="top"><label><liferay-ui:message key="delegate-loaihoso"/>&nbsp;:<font color="red">(*)</font> </label></td>
					<td>
				    <table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
							<td width="45px" style="text-align: center;">
								<input class="styled" type="checkbox" onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<portlet:namespace/>fileTypes', this);"
									name="checkallbox" id="checkallbox"/>
							</td>
								<td><liferay-ui:message key="all" /></td>
							</tr>
					
							<logic:iterate id="fileType" name="fileTypes" indexId="k" type="com.nss.portlet.filetype.model.PmlFileType" scope="request" >						
								<%
									String check = "";
									
									for (int i = 0; i < pmlFileTypeChecked.length ; i++) {
										if (fileType.getFileTypeId().equals(pmlFileTypeChecked[i])) {
											check = "checked=checked";
											break;
										}
									}
								%>
								
							<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'} " >
								<td width="45px" id="<%= k %>" style="text-align: center;">
											<input class="styled" type="checkbox" onclick="Liferay.Util.checkAllBox(<portlet:namespace />fm,'<portlet:namespace/>fileTypes', checkallbox);"
												<%= check %> name="<portlet:namespace/>fileTypes" id="<%= k %>" value="<%= fileType.getFileTypeId()%>" />
								</td>
								<td><%= fileType.getFileTypeName() %></td>
							</tr>
								
								</logic:iterate>
					
					</table>
				</td>
			</tr>
		</table>
		<br>
		<div align="right">
				<input type="submit" value='<liferay-ui:message key="save"/>'/>
				<input type="reset" value='<liferay-ui:message key="reset"/>'/>
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button" value='<liferay-ui:message key="back"/>'/></span>
		</div>
		
	<%
	}
	%>
</div>
</form>
