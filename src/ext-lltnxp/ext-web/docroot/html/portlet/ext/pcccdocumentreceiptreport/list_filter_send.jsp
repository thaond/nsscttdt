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

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%
	DocumentReportSendSearch searchContainer = (DocumentReportSendSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentReportSendDisplayTerms displayTerms = (DocumentReportSendDisplayTerms) searchContainer.getDisplayTerms();
	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
%>

<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentReportSendDisplayTerms.NHOMCONGVAN %>" style="width: 100px;">
	<option value="<%= portletURLStringFilter %>"><liferay-ui:message key="pccc-cvdtn-tatca"/></option>
	<%
		/*
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
		*/
		
		/*
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = null;
		try {
			pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch (Exception e){
			pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		}
		*/
		// end phmphuc update 11/11/2010	
		
		/* phmphuc update 10/02/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);

		long userId = PortalUtil.getUserId(renderRequest);
		PmlUser pmlUser = null;
		Department department = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
		} catch (Exception e) { }
		
		if (department != null) {
			try {
				pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbdi", department.getAgencyId(), currentYear);
			} catch (Exception e) { }
		}
		
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
