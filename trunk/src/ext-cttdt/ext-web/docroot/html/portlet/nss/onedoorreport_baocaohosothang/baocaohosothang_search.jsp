<%@ include file="/html/portlet/nss/onedoorreport_baocaohosothang/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.onedoorreport_baocaohosothang.search.BaoCaoHoSoThangSearch"%>
<%@page import="com.nss.portlet.onedoorreport_baocaohosothang.search.BaoCaoHoSoThangDisplayTerms"%>

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

<%
	BaoCaoHoSoThangSearch searchContainer = (BaoCaoHoSoThangSearch)request.getAttribute("liferay-ui:search:searchContainer");
	BaoCaoHoSoThangDisplayTerms displayTerms = (BaoCaoHoSoThangDisplayTerms)searchContainer.getDisplayTerms();
%>
<div class="search_bct">
	<ul>
		<li style="width: 40%">
			<table cellspacing="0" width="100%">
						<tr>
							<td class="lft_bct" width="25%"><liferay-ui:message key="onedoorpcccreport-tungay" />:&nbsp;</td>
							<td align="left">
								<input type="text" name="<portlet:namespace/><%= BaoCaoHoSoThangDisplayTerms.TUNGAY %>" id="<portlet:namespace />fromDate" value="<%= HtmlUtil.escape(displayTerms.getFromDate()) %>" style="width: 200px" />
								<input align="top" type="image" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>fromDate','cal-button-FromDate')"/> 
							</td>
						</tr>
			</table>
		</li>
		<li style="width: 38%">
			<table cellspacing="0" width="100%">
						<tr>
							<td class="lft_bct" width="20%"><liferay-ui:message key="onedoorpcccreport-denngay" />:&nbsp;</td>
							<td align="left">
								<input type="text" name="<portlet:namespace/><%= BaoCaoHoSoThangDisplayTerms.DENNGAY %>" id="<portlet:namespace />toDate" value="<%= HtmlUtil.escape(displayTerms.getToDate()) %>" style="width: 200px" />
								<input type="image" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
							</td>
						</tr>
			</table>
		</li>
		<li style="width: 22%">
			<table cellspacing="0" width="100%">
						<tr align="left">
							<td colspan="2">
								<input type="submit" id="btnXemBaoCao" value='<liferay-ui:message key="onedoorpcccreport-xuatthongke" />' onclick="<portlet:namespace />setActionFrom('xembaocao');"/>
							</td>
						</tr>
			</table>
		</li>
	</ul>
</div>
	
<div class="contain-title-report">
		<h2 class="report-title-HS"><liferay-ui:message key="onedoorpcccreport-tieudebaocaohosothang" /></h2>
		<h5>(<liferay-ui:message key="onedoorpcccreport-tinhtungay" /> <%= HtmlUtil.escape(displayTerms.getFromDate()) %> <liferay-ui:message key="onedoorpcccreport-denngay" /> <%= HtmlUtil.escape(displayTerms.getToDate()) %>)</h5>
		
</div>
