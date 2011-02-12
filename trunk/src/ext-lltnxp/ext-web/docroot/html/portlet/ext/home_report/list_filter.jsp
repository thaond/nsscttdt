<%@ include file="/html/portlet/ext/home_report/init.jsp" %>

<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>

<%
	DocumentReceiptViewListSearch searchContainer = (DocumentReceiptViewListSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DocumentReceiptViewListDisplayTerms displayTerms = (DocumentReceiptViewListDisplayTerms) searchContainer.getDisplayTerms();
	
	String portletURLStringFilter = (String) request.getAttribute("view.jsp-portletURLString");
%>

<select onchange="viewListDocumentReport(this.value)" name="<portlet:namespace /><%= DocumentReceiptViewListDisplayTerms.CAPGUI %>" style="width: 85px;">
	<option value="<%= portletURLStringFilter
				+ "&" + DocumentReceiptViewListDisplayTerms.LOAISOCONGVAN + "=" + displayTerms.getLoaisocongvan()%>" >
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
			<option <%= selected %> value="<%= portletURLStringFilter + "&capgui" + "=" +pmlLevelSend.getLevelSendId() + 
												"&" + DocumentReceiptViewListDisplayTerms.LOAISOCONGVAN + "=" + displayTerms.getLoaisocongvan()%>" > 
					<%= pmlLevelSend.getLevelSendName()%>
			</option>
	<%		
		}
	%>
</select>
