<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearch"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>

<%
	PcccDocumentReceiptProcessSearch searchContainer = (PcccDocumentReceiptProcessSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PcccDocumentReceiptProcessSearchDisplayTerms displayTerms = (PcccDocumentReceiptProcessSearchDisplayTerms) searchContainer.getDisplayTerms();

	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
	
	// yenlt update 20101022
	boolean vtxulythayldb = ParamUtil.getBoolean(renderRequest, "vtxulythayldb", false);
	boolean vtxulythayldvp = ParamUtil.getBoolean(renderRequest, "vtxulythayldvp", false);
	if (vtxulythayldvp || vtxulythayldb) {
%>	

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>

		<select onchange="viewListDocumentXLT(this.value)"  name="<portlet:namespace /><%=PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN %>" style="width: 80px;">
	<% } else { %>
		<select onchange="viewListDocument(this.value)"  name="<portlet:namespace /><%=PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN %>" style="width: 80px;">
	<% } %>
	<option value="<%= portletURLStringFilter
				+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" + displayTerms.getCapgui()%>" >
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
			String selected = displayTerms.getLoaisocongvan() == pmlDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "";
			
	%>		
			
			<option <%= selected %> value="<%= portletURLStringFilter 
						+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" +displayTerms.getCapgui() 
						+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + pmlDocumentRecordType.getDocumentRecordTypeId()%>" > 
						<%= pmlDocumentRecordType.getDocumentRecordTypeName() %>
			</option>
	<%		
		}
		
	%>
	
</select>
