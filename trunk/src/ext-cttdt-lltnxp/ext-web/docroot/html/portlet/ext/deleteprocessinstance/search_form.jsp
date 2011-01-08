<%@ include file="/html/portlet/ext/deleteprocessinstance/init.jsp" %>

<%@page import="com.sgs.portlet.deleteprocessinstance.search.DeleteDocumentSendUnpublishSearch"%>
<%@page import="com.sgs.portlet.deleteprocessinstance.search.DeleteDocumentSendUnpublishDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="java.util.ArrayList"%>

<%
	DeleteDocumentSendUnpublishSearch searchContainer = (DeleteDocumentSendUnpublishSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DeleteDocumentSendUnpublishDisplayTerms displayTerms = (DeleteDocumentSendUnpublishDisplayTerms)searchContainer.getDisplayTerms();
	
	long documentTypeId = (Long)renderRequest.getAttribute("documentTypeId");
	List<PmlEdmDocumentType> pmlEdmDocumentTypeList = (List<PmlEdmDocumentType>)renderRequest.getAttribute("pmlEdmDocumentTypeList")== null ? 
				new ArrayList<PmlEdmDocumentType>(): (List<PmlEdmDocumentType>)renderRequest.getAttribute("pmlEdmDocumentTypeList");
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_agency" >
	<table class="agency-table">
		<tr>
		 	<td>&nbsp;&nbsp;&nbsp;</td>
			<td>
				<liferay-ui:message key="loai-cong-van"/>
			</td>
			<td>
				<liferay-ui:message key="nguoi-ky"/>
			</td>
			
		</tr>
		
		<tr>
		 	<td>&nbsp;&nbsp;&nbsp;</td>
			<td>
				<select name="<portlet:namespace /><%= DeleteDocumentSendUnpublishDisplayTerms.LOAIVB %>" style="width: 100px;">
					<option value="0"><liferay-ui:message key="pccc-cvdtn-tatca"/></option>
					<logic:iterate id="documentType" name="pmlEdmDocumentTypeList" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request" >
		        		<option  value="<%=documentType.getDocumentTypeId() %>" <%= documentTypeId == documentType.getDocumentTypeId() ? "selected" : "" %> ><%=documentType.getDocumentTypeName() %></option>
		        	</logic:iterate>
				</select>
			</td>
			<td>
				<input name="<portlet:namespace/><%=displayTerms.NGUOIKY%>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getNguoiKy()) %>" />
			</td>
			
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
	<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
