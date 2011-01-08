<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.util.PmlFileStatusUtil"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusSearch"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusSearchTerms"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusStateProcessSearch"%>
<%@page import="com.sgs.portlet.document.receipt.PmlFileStatusStateProcessCanNotDeleteException"%>
<script type="text/javascript">

	function deleteOneDoorStateProcess(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	String tabsProcessOnedoor = (String)request.getAttribute("tabs");
	String redirectfileStatus = (String)request.getAttribute("redirect");

	long filestatusId = (Long)request.getAttribute("fileStatusId");	
  	List<PmlFileStatusStateProcess> listFileStatusStateProcess = request.getAttribute("listFileStatusStateProcess") == null ? new ArrayList<PmlFileStatusStateProcess>() : (List<PmlFileStatusStateProcess>)request.getAttribute("listFileStatusStateProcess");
	
	
	PortletURL displayURL = renderResponse.createRenderURL();
	displayURL.setWindowState(WindowState.NORMAL);
	displayURL.setParameter("struts_action", "/sgs/pmledm_filestatus/display_stateprocess_onedoor");
	displayURL.setParameter("fileStatusId", String.valueOf(filestatusId));
	displayURL.setParameter("tabs", tabsProcessOnedoor);
%>

<portlet:actionURL var="display_process">
	<portlet:param name="struts_action" value="/sgs/pmledm_filestatus/display_stateprocess_onedoor"/>
</portlet:actionURL>

	<form action="<%=display_process %>" method="post" name="<portlet:namespace/>fm">
	<div class="title_categ"><liferay-ui:message key="dinh-nghia-trang-thai"/></div>
	 <div class="boxcontent">
	<input name="<portlet:namespace />ondoorStateURL" type="hidden" value="<%= displayURL.toString() %>" />
	<liferay-ui:error exception="<%= PmlFileStatusStateProcessCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
		<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirectfileStatus) %>" />
		
		<%
			PmlFileStatusStateProcessSearch searchContainerDisplay = new PmlFileStatusStateProcessSearch(renderRequest,displayURL);
			searchContainerDisplay.setTotal(listFileStatusStateProcess.size());
		%>
		
		<%
			// URL add
			PortletURL addfilestatusStateProcessURL = renderResponse.createRenderURL();
			addfilestatusStateProcessURL.setWindowState(WindowState.NORMAL);
			addfilestatusStateProcessURL.setParameter("struts_action", "/sgs/pmledm_filestatus/add_stateprocess_onedoor");
			addfilestatusStateProcessURL.setParameter("tabs", tabsProcessOnedoor);
			addfilestatusStateProcessURL.setParameter("redirect", redirectfileStatus);
			addfilestatusStateProcessURL.setParameter("redirect1", searchContainerDisplay.getIteratorURL().toString());
			addfilestatusStateProcessURL.setParameter("fileStatusId", String.valueOf(filestatusId)); 
			String addfilestatusString = addfilestatusStateProcessURL.toString();
			
			//URL back
			PortletURL backURL = renderResponse.createRenderURL();
			backURL.setWindowState(WindowState.NORMAL);
			backURL.setParameter("struts_action", "/sgs/pmledm_filestatus/view");
			backURL.setParameter("tabs",tabsProcessOnedoor);
			backURL.setParameter("redirect", redirectfileStatus);
			
		%>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= addfilestatusStateProcessURL %>');">
			<input type="button" name="<portlet:namespace/>them" value="<liferay-ui:message key="add_new"/>"/>
		</span>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= backURL.toString() %>');">
			<input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' />
		</span>
		<div class="separator"></div>
		
		<%
			PmlFileStatus pmlFileStatus = null;
			PmlFileStatusStateProcess pmlFileStatusStateProcess = null;
			PmlStateProcess pmlStateProcess = null;
			
			List resultRows = searchContainerDisplay.getResultRows();
			ResultRow row = null;
			String stt = "";
			String filestatuscode = "";
			String fileStatusStateProcessCode = "";
			String fileStatusStateProcessName = "";		
			String update= "";
			String delete = "";
			
			for(int i=0; i<listFileStatusStateProcess.size(); i++){
				pmlFileStatusStateProcess = (PmlFileStatusStateProcess) listFileStatusStateProcess.get(i);
				pmlFileStatusStateProcess.toEscapedModel();
				
				row = new ResultRow(pmlFileStatusStateProcess, pmlFileStatusStateProcess.getFileStatusId(), i);
				stt = i+1+".";
				
				//edit URL
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter("struts_action","/sgs/pmledm_filestatus/edit_stateprocess_onedoor");
				rowURLEdit.setParameter("statusId",String.valueOf(pmlFileStatusStateProcess.getId()));
				rowURLEdit.setParameter("fileStatusId",String.valueOf(pmlFileStatusStateProcess.getFileStatusId()));
				rowURLEdit.setParameter("stateProcessId",String.valueOf(pmlFileStatusStateProcess.getStateProcessId()));
				rowURLEdit.setParameter("tabs", tabsProcessOnedoor);
				rowURLEdit.setParameter("redirect", redirectfileStatus);
				rowURLEdit.setParameter("redirect1", searchContainerDisplay.getIteratorURL().toString());
				
				//delete URL
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action","/sgs/pmledm_filestatus/display_stateprocess_onedoor");
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("statusId",String.valueOf(pmlFileStatusStateProcess.getId()));
				rowURLDelete.setParameter("fileStatusId",String.valueOf(pmlFileStatusStateProcess.getFileStatusId()));
				rowURLDelete.setParameter("stateProcessId",String.valueOf(pmlFileStatusStateProcess.getStateProcessId()));
				rowURLDelete.setParameter("tabs", tabsProcessOnedoor);
				rowURLDelete.setParameter("redirect", redirectfileStatus);
				rowURLDelete.setParameter("redirect1", searchContainerDisplay.getIteratorURL().toString());
				// get filestatuscode
				long fileStatusId = pmlFileStatusStateProcess.getFileStatusId();
				try {
					pmlFileStatus = PmlFileStatusLocalServiceUtil.getPmlFileStatus(fileStatusId);
					
				} catch (Exception e) {				
				}
				
				if (null != pmlFileStatus) {
					filestatuscode = pmlFileStatus.getFileStatusCode();
				}
				
				// get stateProcessCode
				long stateProcessId = pmlFileStatusStateProcess.getStateProcessId();
				try {
					pmlStateProcess = PmlStateProcessLocalServiceUtil.getPmlStateProcess(stateProcessId);
				} catch (Exception e) {
					
				}
				
				if ( null != pmlStateProcess){
					fileStatusStateProcessCode = pmlStateProcess.getStateProcessCode();
					
					// get Description
					fileStatusStateProcessName = pmlFileStatusStateProcess.getDescription();
				}
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				delete = "<a  href='javascript: ;' onclick=deleteOneDoorStateProcess('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(stt);
				row.addText(filestatuscode);
				row.addText(fileStatusStateProcessCode);
				row.addText(fileStatusStateProcessName);
				row.addText(update);
				row.addText(delete);
				
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainerDisplay %>" />
</div>
</form>

