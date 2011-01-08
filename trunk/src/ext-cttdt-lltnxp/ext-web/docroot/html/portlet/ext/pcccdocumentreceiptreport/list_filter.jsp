<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailDisplayTerms"%>
<%
	DocumentDetailSearch searchContainer = (DocumentDetailSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentDetailDisplayTerms displayTerms = (DocumentDetailDisplayTerms) searchContainer.getDisplayTerms();
	
	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
%>

<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentDetailDisplayTerms.CAPGUI %>" style="width: 85px;">
	<option value="<%= portletURLStringFilter
				+ "&" + DocumentDetailDisplayTerms.NHOMCONGVAN + "=" + displayTerms.getNhomCongVan()%>" >
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
			String selected = displayTerms.getCapgui() == pmlLevelSend.getLevelSendId()? " selected " : " ";
	%>		
			<option <%= selected %> value="<%= portletURLStringFilter + "&capgui" + "=" +pmlLevelSend.getLevelSendId() + "&" + DocumentDetailDisplayTerms.NHOMCONGVAN + "=" + displayTerms.getNhomCongVan()%>" > 
				<%= pmlLevelSend.getLevelSendName()%>
			</option>
	<%		
		}
	%>
</select>
