<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>

<liferay-portlet:actionURL var="form" portletConfiguration="true"></liferay-portlet:actionURL>
<%

PortletPreferences prefs = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

boolean privateDocument = PrefsParamUtil.getBoolean(prefs, request, "privateDocument",false);
boolean documentRecordTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentRecordTypeCode",false);
boolean documentTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentTypeCode",false);
String textAdd = PrefsParamUtil.getString(prefs, request, "textAdd","");
textAdd = textAdd.trim();

boolean departmentCode = PrefsParamUtil.getBoolean(prefs, request, "departmentCode",false);
boolean useYear = PrefsParamUtil.getBoolean(prefs, request, "useYear",false);

%>
<form action="<%=form %>" method="post">
	<table style="width: 100%; margin-top: 10px; margin-bottom: 5px">
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="document-private" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>privateDocument" type="checkbox" size="5" <%=  privateDocument == true ? "checked": ""  %>  />
			</td>
		</tr>
		
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="phan-mo-rong" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>textAdd" type="text" value="<%=  HtmlUtil.escape(textAdd)%>"  />
			</td>
		</tr>
		
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-so-van-ban" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>documentRecordTypeCode" type="checkbox"  <%=  documentRecordTypeCode == true ? "checked": ""  %>  />
			</td>
		</tr>
		
			<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-loai-van-ban" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>documentTypeCode" type="checkbox"   <%=  documentTypeCode == true ? "checked": ""  %>  />
			</td>
		</tr>
		
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-ma-phong-ban" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>departmentCode" type="checkbox"   <%=  departmentCode == true ? "checked": ""  %>  />
			</td>
		</tr>
		
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="su-dung-nam-hien-tai" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>useYear" type="checkbox"   <%=  useYear == true ? "checked": ""  %>  />
			</td>
		</tr>
		
	</table>
	
	
	<table>
		<tr>
			<td>
				<div style="padding-left: 5px">
					<input type="submit" value='<liferay-ui:message key="save" />'/>
				</div>
			</td>
		</tr>
	</table>

</form>
