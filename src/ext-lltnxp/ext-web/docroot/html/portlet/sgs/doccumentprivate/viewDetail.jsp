
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.attachedfile.model.AttachedFile"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@include file="/html/portlet/sgs/doccumentprivate/init.jsp" %>

<%-->portlet:renderURL var="back">
	<portlet:param name="struts_action" value="/sgs/doccumentprivate/search"/>
</portlet:renderURL--%>

	<%
		String back =  ParamUtil.get(renderRequest, "redirect", "/sgs/doccumentprivate/search");
	
		PmlEdmDocumentReceipt pml = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
		List<AttachedFile> attachedFiles = (List<AttachedFile>) renderRequest.getAttribute("attachedFiles");
		String ngayDen = new SimpleDateFormat("dd/MM/yyyy").format(pml.getDateArrive());
		String ngayPhatHanh = new SimpleDateFormat("dd/MM/yyyy").format(pml.getIssuingDate());
		// pml.getPrivilegeLevelId()
		
	%>
<form method="post">
<div class="title_categ"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></div>
    <div class="boxcontent">
		<table class="detail_xl" width="100%" cellspacing="0">
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-capgoi"/>:</td>
				<td class="td-right" width="32%"><%=pml.getLevelSendId()%></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-noiphathanh"/></td>
				<td class="td-right" width="32%"><%=pml.getIssuingPlaceOtherName()%></td>
			<tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-sohieu"/>:</td>
				<td class="td-right" width="32%"><%=pml.getDocumentReference()%></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-socongvan"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-socongvan"/>:</td>
				<td class="td-right" width="32%"><%=pml.getDocumentTypeId() %></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-soCVden"/>:</td>
				<td class="td-right" width="32%"><%=pml.getNumberDocumentReceipt() %></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-nguoiky"/>:</td>
				<td class="td-right" width="32%"><%=pml.getSigner()%></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</td>
				<td class="td-right" width="32%"><%=ngayDen%>
				<liferay-ui:message key='hour' />:<%=pml.getThoigiannhancvden()%>
				</td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</td>
				<td class="td-right" width="32%"><%=ngayPhatHanh %></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-domat"/>:</td>
				<td class="td-right" width="32%"><%=pml.getConfidentialLevelId()%></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-dokhan"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"><liferay-ui:message key="cach-thuc-xu-ly"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-tongsongayxuly"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-ngayhethanxuly"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-phongbanthulychinh"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-nguoithulychinh"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-ykienphanphoi"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-TN-trangthaigannhat"/>:</td>
				<td class="td-right" width="32%"></td>
			</tr>
			<tr valign="top">
				<td class="td-left" width="18%"><liferay-ui:message key="pccc-cvdtn-toanvan"/>:</td>
				<td class="td-right" width="32%"></td>
				<td class="td-left" width="18%"></td>
				<td class="td-right" width="32%"></td>
			</tr>
			
			<tr valign="top">
				<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>:</label></td>
				<td colspan="3" class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="5" style="width: 95%"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>				
				<td><span onclick="javascript:submitForm(document.hrefFm, '<%=back%>');">
					<input class="button-width" type="button" value='<liferay-ui:message key="back"/>' >
				</span></td>
			</tr>
		</table>
	</div>
</form>