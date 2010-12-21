<%@ include file="/html/portlet/nss/onedoorprocess/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.nss.portlet.position.model.Position"%>
<%@page import="com.nss.portlet.position.service.PositionLocalServiceUtil"%>

<div class="separator"><!-- --></div>
<%
	//int isProcess = Integer.parseInt((String)renderRequest.getParameter("isProcess"));
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	}
	
	int isProcess = GetterUtil.getInteger(prefs.getValue("isProcess", "0"));
	//System.out.println("is process: " + isProcess);
	
	String showStatus = GetterUtil.getString(prefs.getValue("showStatus", ""));
	String[] dsNguoiKy = prefs.getValues("dsNguoiKy", new String[0]);
	//renderRequest.setAttribute("isProcess", String.valueOf(isProcess));
%>
		<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
		<!-- yenlt them display none 20082010 -->
		<div style="display: none;">
			<liferay-ui:message key="chondanhsachthehien" /> <br>
			<INPUT TYPE=RADIO NAME="isProcess" VALUE="1" <%=isProcess == 1 ? "CHECKED" : "" %>><liferay-ui:message key="processList" /><BR>
			<INPUT TYPE=RADIO NAME="isProcess" VALUE="0" <%=isProcess == 0 ? "CHECKED" : "" %>><liferay-ui:message key="watchList" /><BR>
			
			<liferay-ui:message key="chontrangthaithehien" /> <br>
			<INPUT TYPE=RADIO NAME="showStatus" VALUE="all" <%=showStatus.equals("all") ? "CHECKED" : "" %>><liferay-ui:message key="all" /><BR>
			<logic:iterate id="stateProcess" name="listStateProcess" indexId="i" type="com.sgs.portlet.document.model.PmlStateProcess" scope="request" >
				<INPUT TYPE=RADIO NAME="showStatus" VALUE="<%=stateProcess.getStateProcessCode() %>" <%=showStatus.equals(stateProcess.getStateProcessCode()) ? "CHECKED" : "" %>><%=stateProcess.getStateProcessName() %><BR>
			</logic:iterate>
		
		</div>
		<!-- yenlt update 20082010 -->
	  <fieldset style="width: 99%">
		<legend style="color: gray;" class="legend-noborder"><liferay-ui:message key="cau-hinh-ds-nguoi-ky"/></legend>
		
		<table>
		<tr style="height: 28px;"  class="one-gate-no-border-title">
				<td width="2%" class="td-stt-pml">##</td>
				<td width="4%" class="td-stt-pml"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="60%" class="td-stt-pml"><liferay-ui:message key="name" /></td>
				<td width="34%" class="td-stt-pml"><liferay-ui:message key="receipt.position" /></td>
			</tr>
		<tbody class="ma-phat-sinh-code">
			<logic:iterate id="pmlUser" name="userList" indexId="i" type="com.sgs.portlet.pmluser.model.PmlUser" scope="request" >
			<%
				boolean flag = false;
				if (dsNguoiKy != null) {
					for (int j = 0; j < dsNguoiKy.length; j++) {
						if (pmlUser.getUserId() == Long.parseLong(dsNguoiKy[j])) {
							flag = true;
						}
					}
				}
				
				String userName = "";
				User userLiferay = null;
				try {
					userLiferay = UserUtil.findByPrimaryKey(pmlUser.getUserId());
				} catch (Exception e) {
					userLiferay = null;	
				}
				
				if (userLiferay != null) {
					userName = userLiferay.getLastName() + " " + userLiferay.getMiddleName() + " " + userLiferay.getFirstName();
				}
				
				String positionName = "";
				Position position = null;
				try {
					position = PositionLocalServiceUtil.getPosition(pmlUser.getPositionId());
				} catch (Exception e) {
					position = null;	
				}
				if (position != null) {
					positionName = position.getPositionName();
				}
				
			%>
			
			
			
			<tr style="height: 25px" class="${((i % 2)!=0)? 'rowTwoT2':'rowOneT1'}" >
				<td class="td-stt-pml" style="background-color: #DBEAFC;" id="<%=i %>">
					<input type="checkbox" <%=flag == true ? "checked" : "" %> name="dsNguoiKy" id="listUser<%=i %>" value="<%=pmlUser.getUserId() %>" onclick="clickRadio(event)" />
				</td>
				<td class="td-stt-pml" style="background-color: #DBEAFC;"><%=i + 1 %></td>
				<td class="td-stt-pml" ><div align="left"><%= userName %></div></td>
				<td class="td-stt-pml" ><div align="left"><%= positionName %></div></td>
			</tr>
			</logic:iterate>
			</tbody>
			</table>
			
		</fieldset>
		<!-- end yenlt update 20082010 -->
		<input type="submit" value="<liferay-ui:message key="save" />" />
</form>