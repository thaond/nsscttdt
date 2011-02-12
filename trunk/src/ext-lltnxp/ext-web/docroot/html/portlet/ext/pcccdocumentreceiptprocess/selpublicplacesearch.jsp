<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@ include file="/html/common/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<style>
	body,html {margin: 0;padding: 0;font-family: Arial, Tahoma;font-size: 12px;}
	.results-header td,.results-header th {font-weight: bold; color: #023c60;padding: 5px 2px;border-width: 1px;border-color: #d5f5ff #8ad1fe #8ad1fe #d5f5ff ;border-style: solid;}
	.results-row td, .results-row th {border-right: 1px solid #8ad1fe;padding: 8px 5px;font-size:9pt;background: #f9ffff;}
	.results-header {
		background:#d5f5ff url(/html/themes/sgs-portal-skin/images/imgbasic/bgresult.jpg) repeat-x top left;
	}
	.ie7 .taglib-search-iterator .results-header td {
		background:#d5f5ff url(/html/themes/sgs-portal-skin/images/imgbasic/bgresult.jpg) repeat-x top left;
	}
	.results-row.alt td {
		background: #daf5fd;
	}
	.tr_two td {background: #daf5fd;}
</style>
<script type="text/javascript">
	function selIssPla(retVal) 
	{ // Tra ve ten don vi
		var parWd = window.opener;

		if (parWd != null)
		{
			parWd.retPubPlace(retVal);
			window.close();
		}
	}
</script>
<table id='content' class="taglib-search-iterator table-pml" cellspacing="0" width="100%" style="padding-bottom: 30px;font-size: 12px;">				
					<tr style="background: #0f8aa9;">
						<td></td>
						<td style="padding:5px 0; text-transform: uppercase;background: #0f8aa9;color: #fff;font-weight: bold;"><liferay-ui:message key='documentcode.list'/></td>
					</tr>
					<tr class="portlet-section-header results-header" >
						<td width="45px" align='center'><liferay-ui:message key='pccc-TN-stt'/></td>
						<td ><liferay-ui:message key='documentcode.name'/></td>
					</tr>   			  
					<%
					List<PmlEdmIssuingPlace> issPlaces = PmlEdmIssuingPlaceLocalServiceUtil.getAll();
					PmlEdmIssuingPlace issPlaItem = null;
					String stlRow = "tr_two results-row";
					if (!issPlaces.isEmpty()) {
						for (int idxIP = 0; idxIP < issPlaces.size(); idxIP++) {
							issPlaItem = (PmlEdmIssuingPlace) issPlaces.get(idxIP);
							if (idxIP % 2 == 1) {
								stlRow = "tr_two results-row";
							} // end if
							else {
								stlRow = "results-row";
							} // end else
					%>
							<tr ondblclick="selIssPla('<%= issPlaItem.getIssuingPlaceName() %>')" class='<%= stlRow %>'>
								<td align="center">
									<span id='no'><%= idxIP + 1 %></span>
								</td>
								<td>
									<%= issPlaItem.getIssuingPlaceName() %>
								</td>
							</tr>
					<%
						} // end for
					} // end if
					%>
</table>
<div align="right" class="btpup_vbto"><input type="button" value="<liferay-ui:message key='close' />" onclick="window.close()"/></div>
