<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailDisplayTerms"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>

<%
	DocumentDetailSearch searchContainer = (DocumentDetailSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentDetailDisplayTerms displayTerms = (DocumentDetailDisplayTerms) searchContainer.getDisplayTerms();
	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
%>
<%--
<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentDetailDisplayTerms.LOAISOCONGVAN %>" style="width: 80px;">
--%>
<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentDetailDisplayTerms.NHOMCONGVAN %>" style="width: 80px;">
	<option value="<%= portletURLStringFilter
				+ "&" + DocumentDetailDisplayTerms.CAPGUI + "=" + displayTerms.getCapgui()%>" >
			<liferay-ui:message key="pccc-cvdtn-tatca" />
	</option>
	<%
		// phmphuc update loai so van ban - 11/11/2010
		// lay loai VB thuoc VB den
		List<PmlEdmDocumentType> documentTypeList = null;
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		PmlEdmDocumentRecordType recordType = null; 
		try {
			documentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
			
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
		//	String selected = displayTerms.getLoaisocongvan() == pmlDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "";
			String selected = displayTerms.getNhomCongVan() == pmlDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "";
	%>		
			<option <%= selected %> value="<%= portletURLStringFilter + "&" + DocumentDetailDisplayTerms.CAPGUI + "=" + displayTerms.getCapgui()  + "&" + DocumentDetailDisplayTerms.NHOMCONGVAN + "=" + pmlDocumentRecordType.getDocumentRecordTypeId() %>" > 
				<%= pmlDocumentRecordType.getDocumentRecordTypeName() %>
			</option>
	<%		
		}
	%>
</select>