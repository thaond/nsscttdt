<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="java.util.Date"%><head>
	<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
	<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
</head>

<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>
<%
	long documentReceiptId = ParamUtil.getLong(request, "documentReceiptId");
	long docRecLogId = ParamUtil.getLong(request, "docRecLogId");
	long userId = PortalUtil.getUserId(renderRequest);
	SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<Long> processTypeIdList = renderRequest.getAttribute("processTypeIdList") == null ? new ArrayList<Long>() : (List<Long>) renderRequest.getAttribute("processTypeIdList");
	if (documentReceiptId <= 0 || docRecLogId <= 0) return;
	// Lay doi tuong van ban den
	PmlEdmDocumentReceipt docRec = null;
	try {
		docRec = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
	}
	catch (Exception ex) {
		System.out.println("Khong xac dinh duoc van ban den trong trang editprocesstype.jsp");
		return;
	}
	// Lay doi tuong log can hieu chinh cua van ban den
	PmlDocumentReceiptLog docRecLog = null;
	try {
		docRecLog = PmlDocumentReceiptLogUtil.findByPrimaryKey(docRecLogId);
	}
	catch (Exception ex) {
		System.out.println("Khong xac dinh duoc log cua van ban den trong trang editprocesstype.jsp");
		return;
	}
	
%>
<portlet:actionURL var="action_edit" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/editprocesstype" />
</portlet:actionURL>
<portlet:renderURL var="redirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/editprocesstype" />
	<portlet:param name="documentReceiptId" value="<%= String.valueOf(documentReceiptId) %>" />
	<portlet:param name="docRecLogId" value="<%= String.valueOf(docRecLogId) %>" />
</portlet:renderURL>
<div class="boxcontent">
<form action="<%= action_edit %>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data" >
	<input type="hidden" name="<portlet:namespace />documentReceiptId" value="<%= documentReceiptId %>" />
	<input type="hidden" name="<portlet:namespace />documentReceiptLogId" value="<%= docRecLogId %>" />
	<input type="hidden" name="<portlet:namespace /><%= Constants.CMD %>" />
	<input type="hidden" name="<portlet:namespace />redirect" value='<%= redirectURL %>'/>
	<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="process-type"/></label>
			<table cellspacing="0" width="100%">
				<%
				// Lay ma so phong, ten phong, ten nguoi dung
				String depId = ""; // Ma so phong ban
				String depName = ""; // Ten phong ban
				String userName = ""; // Ten nguoi dung
				try {
					PmlUser curUser = PmlUserUtil.findByPrimaryKey(userId);
					userName = curUser.getLastName() + " " + curUser.getMiddleName() + " " + curUser.getFirstName();
					depId = curUser.getDepartmentsId();
					depName = DepartmentUtil.findByPrimaryKey(depId).getDepartmentsName();
				}
				catch (Exception ex) {
					depId = "";
					depName = "";
					userName = "";
				}
				
				
				
				%>
				<tr>
					<td width="25%" class="td-left"><label><liferay-ui:message key="person-processtype"/>:</label></td>
					<td colspan="3" class="td-right">
						<%= userName %>
						<input type="hidden" name="<portlet:namespace />processTypeUserId" value="<%= userId %>" />
					</td>
					
				</tr>
				<tr>
					<td width="25%" class="td-left"><label><liferay-ui:message key="department-processtype"/>:</label></td>
					<td  class="td-right" colspan="3">
						<%= depName %>
						<input type="hidden" name="<portlet:namespace />processTypeDepId" value="<%= depId %>" />
					</td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="date-start-processtype"/>:</label></td>
					<td class="td-right" colspan="3"><%= sDFormat.format(new Date()) %>	</td>
				</tr>
				<tr>
					<td class="td-left">
						<label><liferay-ui:message key="reason-processtype"/></label>
						<font color="red">(*)</font>:
					</td>
					<td class="td-right" colspan="3">
						<textarea name="<portlet:namespace />processTypeReason" rows="3" style="width: 98%;"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td-left">
						<label><liferay-ui:message key="ten-cach-thuc-xu-ly"/></label>
						<font color="red">(*)</font>:
					</td>
					<td class="td-right" colspan="3">
						<div class="Scrollbarauto" style="width: 99%">
							<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
									<tr class="portlet-section-header results-header" >
										<td style="width:45px" align="center">##</td>
										<td ><liferay-ui:message key="ten-cach-thuc-xu-ly"/></td>
									</tr>
								<logic:iterate id="processType" name="processTypeList" type="com.ext.portlet.processtype.model.ProcessType" scope="request" indexId="l">
									<tr class="${((l % 2) == 0) ? 'results-row' : 'tr_two results-row' }">
										<%
										String checkPTItem = "";
										if (processTypeIdList.contains(processType.getProcessTypeId())) {
											checkPTItem = "checked";
										}
										%>
										<td  id="<%= l%>" align="center">
											<input class="styled" type="radio" name="<portlet:namespace/>processType" id="cachThucXL<%= l %>" value="<%= processType.getProcessTypeId() %>" <%= checkPTItem %> />
										</td>
										<td><%= processType.getName() %></td>
									</tr>
								</logic:iterate>
							</table>
						</div>
						</td>
					</tr>
					<tr>
						<td ></td>
						<td colspan="3">
							<input style="margin-left: 0;" type="button" value="<liferay-ui:message key="update" />" onclick="<portlet:namespace />saveNewProcessType();" />
							<input type="button" value="<liferay-ui:message key="close" />" onclick="window.close();" />
						</td>
					</tr>
				</table>
</fieldset>
</form>
</div>
<script language="javascript">
	/**
	 * Kiem tra gia tri nhap vao tren form de luu gia han
	 */
	function <portlet:namespace />doCheckInput() {
		var objExam = null;
		// Kiem tra li do sua cach thuc xu ly
		objExam = document.<portlet:namespace />fm.<portlet:namespace />processTypeReason;
		if (trim(objExam.value) == "") {
			alert("<liferay-ui:message key='please-input-processtype-reason' />");
			if (objExam.readOnly == false && objExam.disabled == false) {
				objExam.focus();
			}
			return false;
		}

		//kiem tra check checkbox cach thuc xu ly
		var processType = document.<portlet:namespace />fm.<portlet:namespace/>processType;
		var chk = false;
		for ( var i = 0; i < processType.length; i++) {
			if (processType[i].checked) {
				chk = true;
				break;
			}		
		}
	 	if(!chk) {
			alert('<liferay-ui:message key="vui-long-chon-cach-thuc-xu-ly"/>');
			return false;
		}
		return true;
	}
	/**
	 * Luu gia han vao database
	 */
	function <portlet:namespace />saveNewProcessType() {
		// Kiem tra gia tri nhap vao
		if (<portlet:namespace />doCheckInput() == false) return;
		// Dat gia tri cmd la UPDATE (them moi) va submit form
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "ban-co-that-su-muon-cap-nhat-cach-thuc-xu-ly") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.UPDATE %>";
			submitForm(document.<portlet:namespace />fm);
			alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
			opener.location.reload();
			window.close();
		}
	}
</script>