<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>

<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>

<%@page import="javax.portlet.WindowState"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/quanlycongvandi.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />

<%
	int totalPages = Integer.parseInt(request.getAttribute("totalPages").toString());
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	int statusId = ParamUtil.getInteger(renderRequest, "statusId", 0);
	String sortBy = renderRequest.getAttribute("sortBy") != null ? renderRequest.getAttribute("sortBy").toString() : "";
	boolean isExpired = ParamUtil.getBoolean(renderRequest, "isExpired", false);
	List<PmlEdmDocumentReceiptDTO> list = (List<PmlEdmDocumentReceiptDTO>) renderRequest.getAttribute("quanLyCongVanDiDTOList");
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");
	
	String documentRecordTypeId = String.valueOf(renderRequest.getAttribute("documentRecordTypeId"));
%>

<form>
<div id="<portlet:namespace />documentSendList">
<portlet:renderURL var="sort" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="<%=Constants.CMD %>" value="sort" />
	<portlet:param name="flag" value='<%=renderRequest.getAttribute("flag") != null ? String.valueOf(renderRequest.getAttribute("flag")) : "0" %>' />
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
	<portlet:param name="statusId" value='<%="" + statusId %>' />
	<portlet:param name="isExpired" value="<%=String.valueOf(isExpired) %>" />
	<portlet:param name="hienTrang" value="<%=hienTrang %>" />
	<portlet:param name="documentRecordTypeId" value="<%=documentRecordTypeId %>" />
</portlet:renderURL>
	<table align="center" width="100%" cellpadding="0" cellspacing="0" class="tab-doc-process-list-base">
	<tr style="height: 28px;">
		<td class="td-stt-pml"><div align="center"><liferay-ui:message key="sgs_onedoor_no."/></div></td>
		<td width="10%" class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=loaiCongVan&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="pccc-cvdtn-loaicongvan"/></div></td>
		
	    <td class="td-stt-pml" style="cursor: pointer;" ><div align="center"><liferay-ui:message key="receipt.detail"/></div></td>
	     
	    <td class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=nguoiTao&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="receipt.creator"/></div></td>
	    <td class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=nguoiKy&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="receipt.signer"/></div></td>
	    <td class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=noiNhan&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="receipt.receiveplace"/></div></td>
	    <td class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=trichYeu&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="receipt.briftcontent"/></div></td>
	    <td class="td-stt-pml" style="cursor: pointer;" onclick="viewListDocumentSendAction('<%=sort %>&sortBy=trangThai&page=<%=currentPage %>');"><div align="center"><liferay-ui:message key="document_status"/></div></td>
	</tr>
	<portlet:renderURL var="filter">
		<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
		<portlet:param name="statusId" value='<%="" + statusId %>' />
		<portlet:param name="isExpired" value="<%=String.valueOf(isExpired) %>" />
		<portlet:param name="hienTrang" value="<%=hienTrang %>" />
	</portlet:renderURL>
	<tr style="height: 28px;">
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml">
			<div align="center">
				<select name="<portlet:namespace />documentRecordType" style="width: 99%" onchange="viewListDocumentSendAction('<%=filter %>&documentRecordTypeId=' + this.value);">
					<option value="all"><liferay-ui:message key="pccc-cvdtn-tatca"/></option>
					<%
					List<PmlEdmDocumentRecordType> documentRecordTypeList = (List<PmlEdmDocumentRecordType>)renderRequest.getAttribute("documentRecordTypeList");
					int size = documentRecordTypeList.size();
					for (int i = 0; i < size; i++) {
						PmlEdmDocumentRecordType pmlDocumentRecordType = documentRecordTypeList.get(i);
						String selected = documentRecordTypeId.equals(pmlDocumentRecordType.getDocumentRecordTypeId() + "") ? "selected" : "";
						out.print("<option value=\"" + pmlDocumentRecordType.getDocumentRecordTypeId() + "\" " + selected + ">" + pmlDocumentRecordType.getDocumentRecordTypeName() +"</option>");
					}
					%>
				</select>
			</div>
		</td>
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml"></td>
		<td class="td-stt-pml"></td>
	</tr>
	<%
		if (list.isEmpty()) {
	%>
	<tr>
		<td align="center" valign="middle" colspan="8" rowspan="5" class="tr-pup-list-base-02"><div style="padding-top: 30px"><liferay-ui:message key="pccc-TN-khongtontaidulieu"/></div></td>
	</tr>
	<%
		}
	%>
	
	<logic:iterate id="documentSendDTO" name="quanLyCongVanDiDTOList"
		type="com.sgs.portlet.document.send.dto.DocumentSendDTO" indexId="i" scope="request">	
	<%
		String stt = ((currentPage - 1) * currentLimit) + (i + 1) + "";
	%>					
	<portlet:renderURL var="detail" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
    		<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/detail" />
    		<portlet:param name="documentSendId" value="<%=String.valueOf(documentSendDTO.getDocumentSendId()) %>"/>
    		<portlet:param name="page" value="<%=String.valueOf(currentPage) %>"/>
    		<portlet:param name="limit" value="<%=String.valueOf(currentLimit) %>"/>
    		<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>" value="true"/>
    		<portlet:param name="hienTrang" value="<%=hienTrang %>"/>
    	</portlet:renderURL>
  	<tr style="height: 25px;" class="<%=(i % 2) == 0 ? "rowOne" : "rowTwo" %>">	
		<td class="td-stt-pml"><div align="center"><%=stt %></div></td>
		<td><div style="text-align: left; padding-left: 2px"><%=documentSendDTO.getDocumentType() %></div></td>
		
		<td><div style="text-align: left; padding-left: 2px"><a href="<%=detail %>"><liferay-ui:message key="receipt.detail"/></a></div></td>
		<td><div style="text-align: left; padding-left: 2px"><%= documentSendDTO.getEditor() %></div></td>
		<td><div style="text-align: left; padding-left: 2px"><%= documentSendDTO.getSigner() %></div></td>
		<td><div style="text-align: left; padding-left: 2px"><%= documentSendDTO.getReceivingPlace() %></div></td>
		<td><div style="text-align: left; padding-left: 2px"><%= documentSendDTO.getBriefContent() %></div></td>
		<td nowrap="nowrap"><div style="text-align: left; padding-left: 2px"><liferay-ui:message key="<%= documentSendDTO.getState() %>"/></div></td>
	</tr>
	</logic:iterate>	
	</table>

	<%
	if (totalPages > 0) {
	%>
		
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td align="right">
		<%
		String flag = "";
		if (renderRequest.getAttribute("flag") != null) {
			if ("0".equals(renderRequest.getAttribute("flag").toString())) {
				flag = "1";
			} else {
				flag = "0";
			}
		}
		%>
	
		<portlet:renderURL var="quanLyConVanPageURL">
			<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/list" />
			<portlet:param name="statusId" value='<%="" + statusId %>' />
			<portlet:param name="<%=Constants.CMD %>" value="sort" />
			<portlet:param name="sortBy" value="<%=sortBy %>" />
			<portlet:param name="flag" value="<%=flag %>" />
		</portlet:renderURL>
		<%
		
		if (totalPages > 0) {
			out.print("<a class=\"paging-first\" href=\"#\" onclick=\"viewListDocumentSendAction('" + quanLyConVanPageURL + "&page=1');\">&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;");
		} else {
			out.print("<img src=\"/html/portlet/ext/pcccdocumentsendprocess/images/paging/paging_first.png\" />&nbsp;&nbsp;");
		}
		
		if (currentPage > 1) {
			out.print("&nbsp;<a class=\"paging-previous\" href=\"#\" onclick=\"viewListDocumentSendAction('" + quanLyConVanPageURL + "&page=" + (currentPage - 1) + "');\">&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;");
		} else {
			out.print("&nbsp;<img src=\"/html/portlet/ext/pcccdocumentsendprocess/images/paging/paging_previous.png\">&nbsp;&nbsp;&nbsp;");
		}
		
		for (int i  = 1; i <= totalPages; i ++) {
			if (i == currentPage) {
				out.print("&nbsp;<font color=\"red\">" + i + "</font>&nbsp;");
			} else {
				out.print("&nbsp;<a href=\"#\" onclick=\"viewListDocumentSendAction('" + quanLyConVanPageURL + "&page=" + i + "');\">" + i + "</a>&nbsp;");
			}
		}
		if (currentPage < totalPages) {
			out.print("&nbsp;&nbsp;&nbsp;<a class=\"paging-next\" href=\"#\" onclick=\"viewListDocumentSendAction('" + quanLyConVanPageURL + "&page=" + (currentPage + 1) + "');\">&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;");
		} else {
			out.print("&nbsp;&nbsp;&nbsp;<img src=\"/html/portlet/ext/pcccdocumentsendprocess/images/paging/paging_next.png\" />&nbsp;&nbsp;");
		}
		
		if (totalPages > 0) {
			out.print("&nbsp;&nbsp;<a class=\"paging-last\" href=\"#\" onclick=\"viewListDocumentSendAction('" + quanLyConVanPageURL + "&page=" + totalPages + "');\">&nbsp;&nbsp;&nbsp;&nbsp;</a>");
		} else {
			out.print("&nbsp;&nbsp;<img src=\"/html/portlet/ext/pcccdocumentsendprocess/images/paging/paging_last.png\" />");
		}
		
		%>
		&nbsp;&nbsp;&nbsp;
		</td>
		
	</tr>
	</table>
	
	<%
	}
	%>
					
</div>

</form>