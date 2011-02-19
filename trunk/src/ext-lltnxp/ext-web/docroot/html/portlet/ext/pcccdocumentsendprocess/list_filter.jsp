<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp"%>

<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchDisplayTerms"%>

<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>

<%
	PcccDocumentSendProcessSearch searchContainer = (PcccDocumentSendProcessSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PcccDocumentSendProcessSearchDisplayTerms displayTerms = (PcccDocumentSendProcessSearchDisplayTerms) searchContainer.getDisplayTerms();

	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
	// yenlt update 20101022
	boolean vtxulythayldb = ParamUtil.getBoolean(renderRequest, "vtxulythayldb", false);
	boolean vtxulythayldvp = ParamUtil.getBoolean(renderRequest, "vtxulythayldvp", false);
	if (vtxulythayldvp || vtxulythayldb) {
%>	

	

<select onchange="viewListDocumentSendXLT(this.value)"  name="<portlet:namespace /><%=PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN %>" style="width: 100px;">
<% } else { %>
	<select onchange="viewListDocumentSend(this.value)" name="<portlet:namespace /><%= PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN %>" style="width: 100px;">
<% } %>
	<option value="<%= portletURLStringFilter %>"><liferay-ui:message key="pccc-cvdtn-tatca"/></option>
	<%
		// phmphuc update loai so van ban - 11/11/2010
		// lay loai VB thuoc VB den
		//List<PmlEdmDocumentType> documentTypeList = new ArrayList<PmlEdmDocumentType>();
		//PmlEdmDocumentType documentType = null;
		//List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		//PmlEdmDocumentRecordType recordType = null; 
		//try {
			//documentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
			
			// lay so VB theo loai VB
			/*
			for (int i = 0; i < documentTypeList.size(); i ++) {
				int recordTypeId = documentTypeList.get(i).getDocumentRecordTypeId();
				try {
					recordType = PmlEdmDocumentRecordTypeLocalServiceUtil.getPmlEdmDocumentRecordType(recordTypeId);
					if (!pmlEdmDocumentRecordTypeList.contains(recordType)) {
						pmlEdmDocumentRecordTypeList.add(recordType);
					}
				} catch (Exception e1) { }
			}
			*/
		//} catch (Exception e) {
			//documentTypeList = new ArrayList<PmlEdmDocumentType>();
		//}
		
		/*
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = null;
		try {
			pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		} catch (Exception e){
			pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		}
		*/
		// end phmphuc update 11/11/2010
		/*
		int pmlEdmDocumentRecordTypeSize = pmlEdmDocumentRecordTypeList.size();
		
		for (int i  = 0; i < pmlEdmDocumentRecordTypeSize; i ++) {
			PmlEdmDocumentRecordType pmlDocumentRecordType = pmlEdmDocumentRecordTypeList.get(i);
			String selected = displayTerms.getLoaiSoCongVan() == pmlDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "";
		*/	
		
		/* phmphuc update 16/02/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yearSearch = calendar.get(Calendar.YEAR);
		
		long userId = PortalUtil.getUserId(renderRequest);
		PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);		
		Department department = null;
		try {
			department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
		} catch (Exception e) { }
		
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
		if (department != null) {
			pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbdi", department.getAgencyId(), yearSearch);
		}
		// end phmphuc update 16/02/2011
		
		for (int i = 0; i < pmlEdmDocumentRecordTypeList.size(); i++) {
			PmlEdmDocumentRecordType documentRecordType = pmlEdmDocumentRecordTypeList.get(i);
			String selected = displayTerms.getLoaiSoCongVan() == documentRecordType.getDocumentRecordTypeId() ? "selected" : "";
		
	%>		
			<option <%= selected %> value="<%= portletURLStringFilter + "&" + 
				PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + documentRecordType.getDocumentRecordTypeId() %>" > 
				<%= documentRecordType.getDocumentRecordTypeName() %>
			</option>
	<%		
		}
	%>
</select>
