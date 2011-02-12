<%@ include file="/html/portlet/ext/workflow_admin/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.workflow_admin.search.OneDoorWorkflowSearch"%>
<%@page import="com.sgs.portlet.workflow_admin.search.OneDoorWorkflowSearchTems"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlWorkflow"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlWorkflowLocalServiceUtil"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoor.PmlWorkflowCanNotDeleteException"%>
<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>

<script type="text/javascript">
function <portlet:namespace />check_filetype_upload() {
	
	var fileName =	document.getElementById("theFile").value;
	var type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

	if (fileName == "") {
		alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
		return false;
	}
	var typeArr = ["xml"];
	
	for (var i = 0; i < typeArr.length; i++){
		if (typeArr[i] == type) {
			document.getElementById("nameFile").value = fileName.substring(0, fileName.length - 4);			
			return true;
		} else {
			alert("<liferay-ui:message key='sgs_chooseFileUpload'/>");
			return false;
		}
	}
}

	function deleteOneDoorWorkflow(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>


<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/workflow_admin/view");
%>
	<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="title_categ"><liferay-ui:message key="workflow-admin"/></div>
 <div class="boxcontent">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= PmlWorkflowCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<%
		OneDoorWorkflowSearch oneDoorWorkflowSearch = new OneDoorWorkflowSearch(renderRequest, portletURL);
		OneDoorWorkflowSearchTems searchTerms = (OneDoorWorkflowSearchTems)oneDoorWorkflowSearch.getSearchTerms();
		oneDoorWorkflowSearch.setDelta(10);
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/workflow_admin/search_form.jsp"
		searchContainer="<%= oneDoorWorkflowSearch %>" />
		
	
	<%
		List<PmlWorkflow> results = new ArrayList<PmlWorkflow>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlWorkflowLocalServiceUtil.search(searchTerms.getFileTypeName(), searchTerms.getWorkflowName(), searchTerms.isAndOperator(),
					oneDoorWorkflowSearch.getStart(), oneDoorWorkflowSearch.getEnd(), oneDoorWorkflowSearch.getOrderByComparator());
			
			total = PmlWorkflowLocalServiceUtil.searchCount(searchTerms.getFileTypeName(), searchTerms.getWorkflowName(), searchTerms.isAndOperator());
		}
		else {
			results = PmlWorkflowLocalServiceUtil.search(searchTerms.getKeywords(), oneDoorWorkflowSearch.getStart(),
					oneDoorWorkflowSearch.getEnd(), oneDoorWorkflowSearch.getOrderByComparator());
			
			total = PmlWorkflowLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		oneDoorWorkflowSearch.setTotal(total);
		
		oneDoorWorkflowSearch.setResults(results);
		
		portletURL.setParameter(oneDoorWorkflowSearch.getCurParam(), String.valueOf(oneDoorWorkflowSearch.getCurValue()));
	%>
	
	<div id="separator"></div>
	
	<%
		List resultRows = oneDoorWorkflowSearch.getResultRows();
		ResultRow row = null;	
		PmlWorkflow pmlWorkflow = null;
		long pmlWorkflowId = 0;
		PmlFileType fileType = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String delete = "";
		for (int i = 0; i < results.size(); i ++) {
			pmlWorkflow = results.get(i);
			pmlWorkflowId = pmlWorkflow.getWorkflowId();
			
			row = new ResultRow(pmlWorkflow, pmlWorkflowId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ten loai ho so
			try {
				fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(pmlWorkflow.getFileTypeId());
			} catch (Exception e) {
				fileType = null;
			}
			
			if (fileType != null ) {
				row.addText(fileType.getFileTypeName());
			} else {
				row.addText("");
			}
			
			// ten workflow
			
			row.addText(pmlWorkflow.getWorkflow());
			
			// version workflow
			
			row.addText(String.valueOf(pmlWorkflow.getVersion_()));
			
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
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/workflow_admin/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("_workflowId", String.valueOf(pmlWorkflowId));
			rowURLDelete.setParameter("redirect", oneDoorWorkflowSearch.getIteratorURL().toString());
			delete = "<a  href='javascript: ;'  onclick=deleteOneDoorWorkflow('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(delete);
			
			
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= oneDoorWorkflowSearch %>" />
	<br/>
	<div align="right"><input  onclick="showWorkflowForm()" type="button" value='<liferay-ui:message key="add_new"/>'></div> 
	</div>
	</form>

<!--  add  -->
	<div id="workflow" style="display: none;">	
	<portlet:actionURL var="add_process_workflow_admin">
		<portlet:param name="struts_action" value="/sgs/workflow_admin/view" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	</portlet:actionURL>
	
		<form action="<%=add_process_workflow_admin %>" enctype="multipart/form-data" method="post" onsubmit="return <portlet:namespace />check_filetype_upload();">
			<input type="hidden" name="<portlet:namespace />nameFile" id="nameFile"/>
			<div class="title_categ"><liferay-ui:message key="add_new"/></div>
			<div class="boxcontent"> 
 			<table cellspacing="0"  width="100%">
					<tr>
						<td align="right" width="20%"><bean:message key="sgs_filetype_filetypeName"/>&nbsp;:</td>
						<td><select id="_fileTypeId" name="_fileTypeId" style="width: 96%">
								<logic:iterate id="workflow" name="pmlFileTypeList" type="com.sgs.portlet.filetype.model.PmlFileType"	indexId="i"  scope="request">
											<option id="optionID" value="<%= workflow.getFileTypeId()%>" ><%= workflow.getFileTypeName()%></option>
								</logic:iterate>
							</select>
						</td>
					</tr>
					
					<tr>
						<td align="right"><bean:message key="sgs_fileName"/>&nbsp;:</td>
						<td>
							<input type="file" name="<portlet:namespace />theFile" id="theFile" style="width: 95%"/>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="add_new"/>' />
							<input type="reset" value='<liferay-ui:message key="reset"/>' />
							<!-- input onclick="window.history.back()" class="button" type="button"	value='<liferay-ui:message key="back"/>' / --><!-- yenlt close 26082010 -->
						</td>
					</tr>			
				</table>
			</div>
		</form>
</div>							