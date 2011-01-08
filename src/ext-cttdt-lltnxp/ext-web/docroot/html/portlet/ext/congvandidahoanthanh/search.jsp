<%@ include file="/html/portlet/ext/congvandidahoanthanh/init.jsp" %>

<%@page import="com.sgs.portlet.congvandidahoanthanh.search.CVDiDaHoanThanhSearch"%>
<%@page import="com.sgs.portlet.congvandidahoanthanh.search.CVDiDaHoanThanhDisplayTerms"%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<script type="text/javascript">
window.onload = function (){
	if (document.getElementById('<portlet:namespace/>fromDate') != null) {
		callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate');
	}
	if (document.getElementById('<portlet:namespace/>toDate') != null) {
		callCalendar('<portlet:namespace/>toDate','cal-button-ToDate');
	}
}
</script>

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/sgs/congvandidahoanthanh/view" />
</portlet:actionURL>

<%
	CVDiDaHoanThanhSearch searchContainer = (CVDiDaHoanThanhSearch)request.getAttribute("liferay-ui:search:searchContainer");
	CVDiDaHoanThanhDisplayTerms displayTerms = (CVDiDaHoanThanhDisplayTerms) searchContainer.getDisplayTerms();
	
	int[] loaiSoCongVanChecked = displayTerms.getLoaiSoCongVan();
%>
<div style="text-align: center;">
	<fieldset>
		<table cellpadding="0" cellspacing="0" border="0" class="table-report" >
		
			<tr>
				<td align="left" valign="top" class="minlabel"><liferay-ui:message key="chonloaisocongvanbaocao" />:&nbsp;</td>
				<td colspan="5">
					<div class="table-list-border">
						<table cellpadding="0" cellspacing="0" border="0" class="table-list">
							<tr class="title-bg-header" style="width: 100%" >
								<td width="5%" class="td-stt-pml-left">
								<input class="styled" type="checkbox" onclick="Liferay.Util.checkAll(<portlet:namespace />frmReport,'<portlet:namespace/>pmlEdmDocumentRecordTypes', this);"
									name="checkallbox" id="checkallbox"/>
								</td>
								<td class="td-stt-pml-left"><liferay-ui:message key="all" /></td>
							</tr>
						</table>
			
						<div class="tbody-report">
							<table cellpadding="0" cellspacing="0" border="0">
								<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request" indexId="k">
								<%
									String check = "";		
									for (int i = 0; i < loaiSoCongVanChecked.length; i++) {
										if ((int) pmlEdmDocumentRecordType.getDocumentRecordTypeId() == loaiSoCongVanChecked[i]) {
											check = "checked=checked";
											break;
										}
									}
								%>
								
									<tr class="${((k % 2) == 0) ? 'row5' : 'row6'} " >
										<td width="5%" id="<%= k %>" class="td-stt-pml-left">
											<input class="styled" type="checkbox" onclick="Liferay.Util.checkAllBox(<portlet:namespace />frmReport,'<portlet:namespace/>pmlEdmDocumentRecordTypes', checkallbox);"
												<%= check %> name="<portlet:namespace/>pmlEdmDocumentRecordTypes" id="pmlEdmDocumentRecordType<%= k %>" value="<%= String.valueOf(pmlEdmDocumentRecordType.getDocumentRecordTypeId()) %>" />
										</td>
										<td class="td-stt-pml-left"><%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %></td>
									</tr>
								</logic:iterate>
							</table>
						</div>
					</div>
				</td>
			</tr>
			
			<tr height="10" />
		
			<tr>
				<td align="right"><liferay-ui:message key="tinhhinhthulycongvan.tungay" />:&nbsp;</td>
				<td align="left">
					<input type="text" name="<portlet:namespace/><%= displayTerms.FROMDATE %>" id="<portlet:namespace />fromDate" value="<%= HtmlUtil.escape(displayTerms.getFromDate()) %>" style="width: 128px" />
					<input type="image" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')" />
				</td>
				
				<td align="right"><liferay-ui:message key="tinhhinhthulycongvan.denngay" />:&nbsp;</td>
				<td align="left">
					<input type="text" name="<portlet:namespace/><%= displayTerms.TODATE %>" id="<portlet:namespace />toDate" value="<%= HtmlUtil.escape(displayTerms.getToDate()) %>" style="width: 128px" />
					<input type="image" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
				</td>
				
				<td align="right">
					<input type="button" onclick="<portlet:namespace />setActionFrom('')"  value='<liferay-ui:message key="tinhhinhthulycongvan.xembaocao" />' />
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<%
	List<PmlEdmDocumentRecordType>  pmlEdmDocumentRecordTypeList = (List<PmlEdmDocumentRecordType>)renderRequest.getAttribute("pmlEdmDocumentRecordTypeList");
%>	

<c:if test="<%= (loaiSoCongVanChecked.length == pmlEdmDocumentRecordTypeList.size()) %>">
	<script type="text/javascript">
		document.<portlet:namespace />frmReport.checkallbox.checked = true;
	</script>
</c:if>

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/sgs/congvandidahoanthanh/view" />
</portlet:actionURL>

<script type="text/javascript">
function <portlet:namespace />setActionFrom(param) {
	var action = "<%= report %>"; 

	var fromDate = document.getElementById('<portlet:namespace/>fromDate');
	var toDate = document.getElementById('<portlet:namespace/>toDate');

	var strFromDate = "";
	var objFromDate = "";
	var strToDate = "";
	var objToDate = "";
	
	if ("" != fromDate && "" != toDate) {
		strFromDate = fromDate.value.toString();
		objFromDate = sgs.stringToDate(strFromDate,"dmy");
		strToDate = toDate.value.toString();
		objToDate = sgs.stringToDate(strToDate,"dmy");
	}	

	if (param != "") {
		action = action + "&" + param;
	}
	
	else {
		document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
	}
	
	if (objFromDate > objToDate) {
		alert('<liferay-ui:message key="error-date" />');
		document.getElementById('<portlet:namespace/>toDate').focus();		
	}

	else {
		submitForm (document.<portlet:namespace />frmReport, action);
	}
}
</script>