<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@ include file="/html/common/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<script type="text/javascript">
	function selIssPla(retVal) 
	{ // Tra ve ten don vi
		var parWd = window.opener;

		if (parWd != null)
		{
			parWd.retRecPlace(retVal);
			window.close();
		}
	}
</script>
<div style="width: 100%; height: 100%; overflow: auto;">
	<table width='100%' cellspacing='0' cellpadding='0' class='table-pml'>
		<tr height='100%'>
			<td valign='top' id='content'>
				<table cellpadding='0' cellspacing='0' class='table-pml' width='100%' bgcolor="#999999">
					<tr height='28px' align='center' valign='middle' style='font-weight:bold;' bgcolor='#6CA1B4'>
						<td colspan='2' style='color:#FFFFFF' align='left'><liferay-ui:message key='documentcode.list'/></td>
					</tr>
					<tr height='28' align='center' style='font-weight:bold;' bgcolor='#EAEBDB'>
						<td width='10%' class='td-stt-pml'><liferay-ui:message key='pccc-TN-stt'/></td>
						<td width='40%' class='td-stt-pml'><liferay-ui:message key='documentcode.name'/></td>
					</tr>   
					<%
					List<PmlEdmIssuingPlace> issPlaces = PmlEdmIssuingPlaceLocalServiceUtil.getAll();
					PmlEdmIssuingPlace issPlaItem = null;
					String stlRow = "rowOneT1";
					if (!issPlaces.isEmpty()) {
						for (int idxIP = 0; idxIP < issPlaces.size(); idxIP++) {
							issPlaItem = (PmlEdmIssuingPlace) issPlaces.get(idxIP);
							if (idxIP % 2 == 1) {
								stlRow = "rowOneT1";
							} // end if
							else {
								stlRow = "rowTwoT2";
							} // end else
					%>
							<tr height='25px' ondblclick="selIssPla('<%= issPlaItem.getIssuingPlaceName() %>')" class='<%= stlRow %>'>
								<td class='td-stt-pml' align='right' style='color:#c00;background-color:#EAEBDB; padding-right: 3px'>
									<span id='no'><%= idxIP + 1 %></span>
								</td>
								<td class='td-stt-pml' style='color:#003366;'>
									<div align='left'><%= issPlaItem.getIssuingPlaceName() %></div>
								</td>
							</tr>
					<%
						} // end for
					} // end if
					%>
					<tr height='25px'>
						<td align='right' colspan="2">
							<input type="button" value="<liferay-ui:message key='close' />" onclick="window.close()"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
