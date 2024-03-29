<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSendSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSendDisplayTerms"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>

<%
	DocumentReportSendSearch searchContainer = (DocumentReportSendSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentReportSendDisplayTerms displayTerms = (DocumentReportSendDisplayTerms) searchContainer.getDisplayTerms();
	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
%>

<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentReportSendDisplayTerms.NHOMCONGVAN %>" style="width: 100px;">
	<option value="<%= portletURLStringFilter %>"><liferay-ui:message key="pccc-cvdtn-tatca"/></option>
	<%
		// phmphuc update loai so van ban - 11/11/2010
		// lay loai VB thuoc VB den
		List<PmlEdmDocumentType> documentTypeList = null;
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		PmlEdmDocumentRecordType recordType = null; 
		try {
			documentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
			
			// lay so VB theo loai VB
			for (int i = 0; i < documentTypeList.size(); i ++) {
				int recordTypeId = documentTypeList.get(i).getDocumentRecordTypeId();
				try {
					recordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(recordTypeId);
					if (!pmlEdmDocumentRecordTypeList.contains(recordType)) {
						pmlEdmDocumentRecordTypeList.add(recordType);
					}
				} catch (Exception e1) { }
			}
		} catch (Exception e) {
			documentTypeList = new ArrayList<PmlEdmDocumentType>();
		}	
		
		/*
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = null;
		try {
			pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch (Exception e){
			pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		}
		*/
		// end phmphuc update 11/11/2010	
		
		int pmlEdmDocumentRecordTypeSize = pmlEdmDocumentRecordTypeList.size();
		
		for (int i  = 0; i < pmlEdmDocumentRecordTypeSize; i ++) {
			PmlEdmDocumentRecordType pmlDocumentRecordType = pmlEdmDocumentRecordTypeList.get(i);
			String selected = displayTerms.getNhomCongVan() == pmlDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "";
			
	%>		
			<option <%= selected %> value="<%= portletURLStringFilter + "&" + DocumentReportSendDisplayTerms.NHOMCONGVAN + "=" + pmlDocumentRecordType.getDocumentRecordTypeId() %>" > 
				<%= pmlDocumentRecordType.getDocumentRecordTypeName() %>
			</option>
	<%		
		}
		
	%>
</select>
