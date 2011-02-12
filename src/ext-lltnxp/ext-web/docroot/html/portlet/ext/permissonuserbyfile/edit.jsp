<%@ include file="/html/portlet/ext/permissonuserbyfile/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<liferay-util:include page="/html/portlet/ext/permissonuserbyfile/js/permissionuserbyfile.jsp"></liferay-util:include>
<%
	String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
	String multiUserIds = ""; 
	if (Validator.isNotNull(cmd) && "ASSIGN".equals(cmd)) {
		multiUserIds = (String)renderRequest.getAttribute("multiUserIds") == null? "" : (String)renderRequest.getAttribute("multiUserIds");
	}
	long userId = ParamUtil.getLong(renderRequest, "userId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	List<PmlUserFileType> listOldFileType = (List<PmlUserFileType>)renderRequest.getAttribute("listOldFileType") == null ? new ArrayList<PmlUserFileType>()
				: (List<PmlUserFileType>)renderRequest.getAttribute("listOldFileType");
	List<PmlFileType> listFileType = (List<PmlFileType>)renderRequest.getAttribute("listfiletype") == null ? new ArrayList<PmlFileType>()
				: (List<PmlFileType>)renderRequest.getAttribute("listfiletype");
	
	int listOldSize = listOldFileType.size();
	String description = (String) renderRequest.getAttribute("description") == null ? "" : (String) renderRequest.getAttribute("description");
%>

<portlet:actionURL var="edit" windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="struts_action" value="/sgs/permissonuserbyfile/edit"/>
	<% if ("ASSIGN".equals(cmd)) { %>
		<portlet:param name="<%= Constants.CMD %>" value="ASSIGN"/>
		<portlet:param name="multiUserIds" value="<%= multiUserIds %>"/>
	<% } %>
	<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
</portlet:actionURL>

<form action="<%= edit %>" name="<portlet:namespace />fm" method="post" >
<div class="title_categ"><liferay-ui:message key="permisson.watchfor" /></div>
<div class="boxcontent">
<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
				<td width="3%" align="center">
					<input class="styled" type="checkbox" onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<portlet:namespace/>fileTypes', this);" name="checkallbox" id="checkallbox"/>
				</td>
				<td width="45px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="20%"><liferay-ui:message key="recordtype.code"/></td>
				<td><liferay-ui:message key="permisson.doctype.name"/></td>
			</tr>
			<%
					for (int k = 0; k < listFileType.size(); k++) {
						PmlFileType fileType = listFileType.get(k);
						String check = "";
						for (int j = 0; j < listOldSize; j++) {
							PmlUserFileType type = listOldFileType.get(j);
							if (type.getFileTypeId().equals(fileType.getFileTypeId())) {
								check = "checked=checked";
								break;
							}
						}
			%>
			
			
			<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'}" >
						<td align="center" id="<%= k %>">
							<input class="styled" type="checkbox" onclick="Liferay.Util.checkAllBox(<portlet:namespace />fm,'<portlet:namespace/>fileTypes', checkallbox);"
							<%= check %> name="<portlet:namespace/>fileTypes" id="<%= k %>" value="<%= fileType.getFileTypeId()%>" />
						</td>
						<td align="center" ><%= k+1 %></td>
						<td ><%=fileType.getFileTypeCode()%></td>
						<td ><%=fileType.getFileTypeName()%></td>
			</tr>
			<% } %>
</table>
<br>
<table cellspacing="0" width="100%">
	<tr>
		<td valign="top" width="15%">
			<liferay-ui:message key="permisson.explain" />&nbsp;:
		</td>
		<td align="right">
			<textarea name="<portlet:namespace />description" style="width:98%" rows="5" ><%=description %></textarea>
		</td>
	</tr>
</table>
<br>		
<div align="right" id="table-button" >
  			<input type="submit" value='<liferay-ui:message key="update" />'>
			<input type="reset" value='<liferay-ui:message key="reset"/>'>
			<span onclick="submitFormBack(document.hrefFm,'<%= redirect.toString() %>');"><input type="button" value='<liferay-ui:message key="back"/>' /></span>
			 <input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect%>">
</div>

<c:if test="<%= (listOldFileType.size() == listFileType.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
</c:if>
</div>
</form>
