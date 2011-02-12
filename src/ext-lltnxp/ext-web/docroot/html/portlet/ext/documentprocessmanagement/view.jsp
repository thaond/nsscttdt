<%@ include file="/html/portlet/ext/documentprocessmanagement/init.jsp" %>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalServiceUtil"%>
<%@page import="com.sgs.portlet.documentprocessmanagement.search.DocumentWorkflowSearchTerms"%>
<%@page import="com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow"%>
<%@page import="com.sgs.portlet.documentprocessmanagement.search.DocumentWorkflowSearch"%>
<%@page import="com.sgs.portlet.document.manageworkflow.PmlManageWorkDocumentFlowCanNotDeleteException"%>
<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<script type="text/javascript">
function <portlet:namespace />check_filetype_upload() {
	var fileName =	document.getElementById("fileWorkflow").value;
	var type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	if (fileName == "") {
		alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
		return false;
	}
	var typeArr = ["xml"];
	for (var i = 0; i < typeArr.length; i++){
		if (typeArr[i] == type) {
			document.getElementById("nameWorkflow").value = fileName.substring(0, fileName.length - 4);			
			return true;
		} else {
			alert("<liferay-ui:message key='sgs_chooseFileUpload'/>");
			return false;
		}
	}
}

function deleteDocumentWorkflow(url) {		
	if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}
</script>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentprocessmanagement/view");
%>
	<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<div class="title_categ"><liferay-ui:message key="document-process-management"/></div>
	<div class="boxcontent">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= PmlManageWorkDocumentFlowCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<%
		DocumentWorkflowSearch documentWorkflowSearch = new DocumentWorkflowSearch(renderRequest, portletURL);
		DocumentWorkflowSearchTerms searchTerms = (DocumentWorkflowSearchTerms)documentWorkflowSearch.getSearchTerms();
		documentWorkflowSearch.setDelta(10);
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/documentprocessmanagement/search_form.jsp"
		searchContainer="<%= documentWorkflowSearch %>" />
	<%
		List<PmlManageWorkDocumentFlow> results = new ArrayList<PmlManageWorkDocumentFlow>();
		int total = 0;
		if (searchTerms.isAdvancedSearch()) {
			results = PmlManageWorkDocumentFlowLocalServiceUtil.search(searchTerms.getDocumentWorkflowName(), searchTerms.getDescription(), searchTerms.isAndOperator(),
					documentWorkflowSearch.getStart(), documentWorkflowSearch.getEnd(), documentWorkflowSearch.getOrderByComparator());
			total = PmlManageWorkDocumentFlowLocalServiceUtil.searchCount(searchTerms.getDocumentWorkflowName(), searchTerms.getDescription(), searchTerms.isAndOperator());
		}
		else {
			results = PmlManageWorkDocumentFlowLocalServiceUtil.search(searchTerms.getKeywords(), documentWorkflowSearch.getStart(),
					documentWorkflowSearch.getEnd(), documentWorkflowSearch.getOrderByComparator());
			total = PmlManageWorkDocumentFlowLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		documentWorkflowSearch.setTotal(total);
		documentWorkflowSearch.setResults(results);
		portletURL.setParameter(documentWorkflowSearch.getCurParam(), String.valueOf(documentWorkflowSearch.getCurValue()));
	%>
	<div id="separator"></div>
	<%
		List resultRows = documentWorkflowSearch.getResultRows();
		ResultRow row = null;	
		PmlManageWorkDocumentFlow pmlWorkflow = null;
		long pmlWorkflowId = 0;	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			pmlWorkflow = results.get(i);
			pmlWorkflowId = pmlWorkflow.getManageDocumentWorkFlowId();
			
			row = new ResultRow(pmlWorkflow, pmlWorkflowId, i);
			// STT
			row.addText(String.valueOf(i + 1));
			// ten quy trinh
			row.addText(pmlWorkflow.getWorkFlowName());
			// loai quy trinh
			row.addText(String.valueOf(pmlWorkflow.getType()));
			// version workflow
			row.addText(String.valueOf(pmlWorkflow.getVersion()));
			// mo ta
			row.addText(pmlWorkflow.getDescription());
			// ngay bat dau
			if (pmlWorkflow.getStartDate() != null) {
				row.addText(simpleDateFormat.format(pmlWorkflow.getStartDate()));
			} else {
				row.addText("");
			}
			// ngay ket thuc
			if (pmlWorkflow.getEndDate() != null) {
				row.addText(simpleDateFormat.format(pmlWorkflow.getEndDate()));
			} else {
				row.addText("");
			}
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.MAXIMIZED);
			rowURLDelete.setParameter("struts_action", "/sgs/documentprocessmanagement/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("manageDocumentWorkflowId", String.valueOf(pmlWorkflowId));
			rowURLDelete.setParameter("redirect", documentWorkflowSearch.getIteratorURL().toString());
			deleteURL = "<a  href='javascript: ;'  onclick=deleteDocumentWorkflow('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			row.addText(deleteURL);
			resultRows.add(row);
		}
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= documentWorkflowSearch %>" />
	<br>
	<div align="right">
		<input onclick="showAddForm()" type="button" value='<liferay-ui:message key="add_new"/>'>
	</div>
</div>
</form>

<!--  add  -->
	<portlet:actionURL var="add_process">
		<portlet:param name="struts_action" value="/sgs/documentprocessmanagement/view" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	</portlet:actionURL>

<div id="showForm" style="display: none;">
<form action="<%= add_process %>" method="post" enctype="multipart/form-data" onsubmit="return <portlet:namespace />check_filetype_upload();" >
			<input type="hidden" name="<portlet:namespace />nameWorkflow" id="nameWorkflow"/>
			<div class="title_categ"><liferay-ui:message key="add_new"/></div>
			<div class="boxcontent">
			<table cellspacing="0" width="100%" >
				<tr>
					<td width="15%"><bean:message key="sgs_fileName"/><font size="1" color="red">(*)</font>&nbsp;:</td>
					<td>
						<input style="width: 90%" type="file" name="<portlet:namespace />fileWorkflow" id="fileWorkflow"/>
					</td>
				</tr>
				<tr>
					<td ><bean:message key="sgs_filetype_filetypeName"/>&nbsp;:</td>
					<td>
						<select id="type" name="type" style="width: 98%">
							<option value="1"><liferay-ui:message key="quy-trinh-cong-van-den-chinh"/></option>
							<option value="2"><liferay-ui:message key="quy-trinh-cong-van-den-phu-cap-phong-ban"/></option>
							<option value="3"><liferay-ui:message key="quy-trinh-cong-van-den-phu-cap-chuyen-vien"/></option>
							<option value="4"><liferay-ui:message key="quy-trinh-cong-van-den-phu-cap-lanh-dao"/></option>
							<option value="0"><liferay-ui:message key="quy-trinh-cong-van-di"/></option>
							<option value="5"><liferay-ui:message key="quy-trinh-cong-van-den-phu-bao-cao"/></option>
							<option value="6"><liferay-ui:message key="quy-trinh-cong-van-di-phu-phat-hanh"/></option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td ><bean:message key="description"/>&nbsp;:</td>
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


<%
	String deloy = (String) renderRequest.getAttribute("deloy");	
	
	if ("success".equalsIgnoreCase(deloy)) {
%>
		<script type="text/javascript" >	
			alert ("<liferay-ui:message key='deploy-workflow-success'/>")
		</script>
		
<%	} if ("fail".equalsIgnoreCase(deloy)) { %>

		<script type="text/javascript" >	
		alert ("<liferay-ui:message key='deploy-workflow-fail' />");
		</script>	
		
<%	} %>