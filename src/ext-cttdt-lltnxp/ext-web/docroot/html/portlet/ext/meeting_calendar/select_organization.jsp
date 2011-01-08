<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalComponent"%>
<%@page import="com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil"%>

<form method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveForm(); return false;">
<liferay-ui:tabs names="organizations" />
<%
PortletURL portletURL = renderResponse.createRenderURL();
String orgIds = ParamUtil.getString(request, "orgIds");

portletURL.setParameter("struts_action", "/ext/meeting_calendar/select_organization");
%>
<%
out.print(orgIds);
String[] strorgIds = orgIds.split(",");
long[] listorgIds = new long[strorgIds.length];
if(orgIds!=""){
	for(int i=0;i<strorgIds.length;i++){
		listorgIds[i] = Long.valueOf(strorgIds[i]);
	}
}
OrganizationSearch searchContainerOrg = new OrganizationSearch(renderRequest, portletURL);
OrganizationDisplayTerms displayTermsOrg = (OrganizationDisplayTerms)searchContainerOrg.getDisplayTerms();
Organization organization = null;
if (displayTermsOrg.getParentOrganizationId() > 0) {
	try {
		organization = OrganizationLocalServiceUtil.getOrganization(displayTermsOrg.getParentOrganizationId());
	}
	catch (NoSuchOrganizationException nsoe) {
	}
}
OrganizationSearchTerms searchTermsOrg = (OrganizationSearchTerms)searchContainerOrg.getSearchTerms();
LinkedHashMap organizationParams = new LinkedHashMap();
long parentOrganizationId = OrganizationConstants.ANY_PARENT_ORGANIZATION_ID;
//long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID
List results = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentOrganizationId, searchTermsOrg.getName(), searchTermsOrg.getType(), searchTermsOrg.getStreet(), searchTermsOrg.getCity(), searchTermsOrg.getZip(), searchTermsOrg.getRegionIdObj(), searchTermsOrg.getCountryIdObj(), organizationParams, searchTermsOrg.isAndOperator(), searchContainerOrg.getStart(), searchContainerOrg.getEnd(), searchContainerOrg.getOrderByComparator());
int total = OrganizationLocalServiceUtil.searchCount(company.getCompanyId(), parentOrganizationId, searchTermsOrg.getName(), searchTermsOrg.getType(), searchTermsOrg.getStreet(), searchTermsOrg.getCity(), searchTermsOrg.getZip(), searchTermsOrg.getRegionIdObj(), searchTermsOrg.getCountryIdObj(), organizationParams, searchTermsOrg.isAndOperator());

List headerNames = new ArrayList();
headerNames.add("organization");
searchContainerOrg.setHeaderNames(headerNames);
RowChecker rowChecker = new RowChecker(renderResponse);
searchContainerOrg.setRowChecker(rowChecker);
searchContainerOrg.setTotal(total);
searchContainerOrg.setResults(results);
List resultRows = searchContainerOrg.getResultRows();
searchContainerOrg.setId(renderResponse.getNamespace()+"searchContainerOrg");

for (int i = 0; i < results.size(); i++) {
	Organization curOrganization = (Organization) results.get(i);
	ResultRow row = null;
	if(Arrays.binarySearch(listorgIds, curOrganization.getOrganizationId()) >= 0){
		row = new ResultRow(curOrganization, curOrganization.getOrganizationId()+"_"+curOrganization.getName(), i,true);
	}
	else{
		row = new ResultRow(curOrganization, curOrganization.getOrganizationId()+"_"+curOrganization.getName(), i);
	}
	
	//row.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(check, row.getPrimaryKey()));
	
	row.addText(curOrganization.getName());
	resultRows.add(row);
}
%>
<input type="submit" value="<liferay-ui:message key="save" />" />
<liferay-ui:search-iterator searchContainer="<%= searchContainerOrg %>" />
</form>

<script type="text/javascript">
	function <portlet:namespace />saveForm() {
		var objItems = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		var rowColumns = objItems.split(",");
		var orgIds = "";
		var orgNames = "";
		for(var i=0; i<rowColumns.length; i++){
			var Items = rowColumns[i].split("_");
			
			if (orgIds != "") orgIds += "," + Items[0];
			else orgIds = Items[0];
			if (orgNames != "") orgNames += "," + Items[1];
			else orgNames = Items[1];
		}
		
		opener.<%=renderResponse.getNamespace()%>selectOrganization(orgIds, orgNames);
		window.close();
	}
	
	Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
</script>