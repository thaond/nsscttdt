<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearch"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	PcccDocumentReceiptProcessSearch searchContainer = (PcccDocumentReceiptProcessSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PcccDocumentReceiptProcessSearchDisplayTerms displayTerms = (PcccDocumentReceiptProcessSearchDisplayTerms) searchContainer.getDisplayTerms();

	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
	// yenlt update 20101022
	boolean vtxulythayldb = ParamUtil.getBoolean(renderRequest, "vtxulythayldb", false);
	boolean vtxulythayldvp = ParamUtil.getBoolean(renderRequest, "vtxulythayldvp", false);
	if (vtxulythayldvp || vtxulythayldb) {
	
%>		
	<select onchange="viewListDocumentXLT(this.value)"  name="<portlet:namespace /><%=PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI %>" style="width: 80px;">
<% } else { // end yenlt update 20101022 %>
	<select onchange="viewListDocument(this.value)"  name="<portlet:namespace /><%=PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI %>" style="width: 80px;">
<% } %>
	<option value="<%= portletURLStringFilter
				+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + displayTerms.getLoaisocongvan() %>" >
			<liferay-ui:message key="pccc-cvdtn-tatca" />
	</option>
	<%
		List<PmlEdmLevelSend> pmlLevelSendList = null;
		
		try {
			 pmlLevelSendList = (List<PmlEdmLevelSend>) PmlEdmLevelSendUtil.findAll();
		} catch (Exception e) {
			pmlLevelSendList = new ArrayList<PmlEdmLevelSend>();
		}		
		
		int pmlLevelSendSize = pmlLevelSendList.size();
		
		for (int i  = 0; i < pmlLevelSendSize; i ++) {
			PmlEdmLevelSend pmlLevelSend = pmlLevelSendList.get(i);
			String selected = displayTerms.getCapgui() == pmlLevelSend.getLevelSendId()? " selected" : " ";
			
	%>		
			<option <%= selected %> value="<%= portletURLStringFilter + "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" +pmlLevelSend.getLevelSendId() 
				+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + displayTerms.getLoaisocongvan()%>" > 
				<%= pmlLevelSend.getLevelSendName()%>
			</option>
	<%		
		}
	%>
</select>
