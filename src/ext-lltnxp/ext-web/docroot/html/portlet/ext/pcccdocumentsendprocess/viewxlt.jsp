<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegateUtil"%>
<%@page import="com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate"%>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>

<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/quanlycongvandi.jsp"></liferay-util:include>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<!-- minh update 20101223 -->
<portlet:actionURL var="backtolist" windowState="<%= LiferayWindowState.NORMAL.toString() %>">>
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/view" />
</portlet:actionURL>
<%-- minh end update 20101223--%>
<script type="text/javascript">
	window.onload = function () 
	{
		if (document.getElementById('<portlet:namespace/>tuNgay') != null) {
			callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay');
		}
		
		if (document.getElementById('<portlet:namespace/>denNgay') != null) {
			callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay');
		}
	}	
</script>

<%
	//yenlt update 20101028
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	long loaiVB = ParamUtil.getLong(renderRequest, "loaiVB", 0);
	String donViSoanThao = ParamUtil.getString(renderRequest, "donViSoanThao", "");
	String nguoiKy = ParamUtil.getString(renderRequest, "nguoiKy", "");
	String trichYeu = ParamUtil.getString(renderRequest, "trichYeu", "");
	String coQuanNhan = ParamUtil.getString(renderRequest, "coQuanNhan", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tuNgay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denNgay", "");
	
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT", 0);
	String statusId = ParamUtil.getString(renderRequest, "statusId");
	// end yenlt update 20101028
	
	PortletPreferences prefsXLT = renderRequest.getPreferences();
	boolean processTranlate = ParamUtil.getBoolean(renderRequest, "vtxulythayldb", false);
	boolean processTranlateLDVP = ParamUtil.getBoolean(renderRequest, "vtxulythayldvp", false);
	List<Long> listUserXLT = new ArrayList<Long>();
	
	// minh update 20101226
	List<PmlDocumentDelegate> pmlDocumentDelegates = new ArrayList<PmlDocumentDelegate>();
	try {
		pmlDocumentDelegates = PmlDocumentDelegateUtil.findByUserIsDelegateId(PortalUtil.getUserId(renderRequest));
	} catch (Exception e) {}
	
	if (processTranlate) {	
		//String[] listUserLDBXLT = prefsXLT.getValues("listUserLDB", new String[0]);	
		//for (int i = 0; i < listUserLDBXLT.length; i++) {
		//	listUserXLT.add(Long.parseLong(listUserLDBXLT[i]));
		//}	
		for (PmlDocumentDelegate pmlDocumentDelegate : pmlDocumentDelegates) {
			if (pmlDocumentDelegate.getCancelDate() == null 
					&& pmlDocumentDelegate.getFromtDate().getTime() <= new Date().getTime()
					&&( 
						pmlDocumentDelegate.getToDate() == null 
						|| new Date().getTime() <= pmlDocumentDelegate.getToDate().getTime()
						) 
				) {
				if (!listUserXLT.contains(pmlDocumentDelegate.getUserDelegateId())) {
					listUserXLT.add(pmlDocumentDelegate.getUserDelegateId());
				}
			}
		}
	}
	
	else if (processTranlateLDVP) {	
		//String[] listUserLDVPXLT = prefsXLT.getValues("listUser", new String[0]);
		//for (int i = 0; i < listUserLDVPXLT.length; i++) {
		//	listUserXLT.add(Long.parseLong(listUserLDVPXLT[i]));
		//}
		
		for (PmlDocumentDelegate pmlDocumentDelegate : pmlDocumentDelegates) {
			if (pmlDocumentDelegate.getCancelDate() == null 
					&& pmlDocumentDelegate.getFromtDate().getTime() <= new Date().getTime()
					&&( 
						pmlDocumentDelegate.getToDate() == null 
						|| new Date().getTime() <= pmlDocumentDelegate.getToDate().getTime()
						) 
				) {
				if (!listUserXLT.contains(pmlDocumentDelegate.getUserDelegateId())) {
					listUserXLT.add(pmlDocumentDelegate.getUserDelegateId());
				}
			}
		}
	}
	// end minh update 20101226
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/xulythayld");
	portletURL.setParameter("vtxulythayldb", String.valueOf(processTranlate));
	portletURL.setParameter("vtxulythayldvp", String.valueOf(processTranlateLDVP));
	//portletURL.setParameter("statusId", ParamUtil.getString(renderRequest, "statusId"));
	portletURL.setParameter("statusId",statusId); // yenlt update 20101028
	String portletURLString = portletURL.toString();

%>

<script type="text/javascript">
	function nhapLieuThay() {
		var url = "<%= portletURLString %>" ;	
		var rodios = document.getElementsByName("nguoiXuLyThay");
		var idRedirect = document.getElementById("idRedirect");
		
		for (var i = 0; i < rodios.length; i++) {
			if (rodios[i].checked) {
				url +=  "&userIdXLT=" + rodios[i].value;
				document.getElementById("<portlet:namespace/>userIdXLT").value = rodios[i].value;	// yenlt update 20101028				
			}
		}		
		var userIdXLT = document.getElementById("<portlet:namespace/>userIdXLT").value;
		if (userIdXLT == 0) {
			alert("<liferay-ui:message key='vui-long-chon-lanh-dao-de-nhap-lieu-thay'/>");
			return false;
		}	
		viewListDocumentSendXLT(url);	
	}

	function dsNhapLieuThayOnload() {
		var url = "<%= portletURLString %>" ;	
		var rodios = document.getElementsByName("nguoiXuLyThay");
		var idRedirect = document.getElementById("idRedirect");
		
		for (var i = 0; i < rodios.length; i++) {
			if (rodios[i].checked) {
				url +=  "&userIdXLT=" + rodios[i].value;				
				document.getElementById("<portlet:namespace/>userIdXLT").value = rodios[i].value;	// yenlt update 20101028
			}
		}		
		<% if (timkiemtheotieuchi == true) { %>
			getParamForListXLT(url);
		<% } else { %>
			<portlet:namespace/>setAllValueXLTToDefault();
			viewListDocumentSendXLT(url);		
		<% } %>
			
	}

	function getSelectRadio(elementRow){		
		var idElementTd = elementRow.cells[0].id;	
		var elementInput = document.getElementById('nguoiXuLyThay'+idElementTd)
		if (!elementInput.checked) {
			elementInput.checked = true;			
			
		}
		else if (elementInput.checked) {
			elementInput.checked = false;			
		}
	}

	function clickRadio(event, radio){		

		if (radio.checked) {
			radio.checked = false;
		}
		else {
			radio.checked = true;
		}
		if (event) // firefox
		{
			if (event.stopPropagation)
			{
				event.stopPropagation();
			}
			else event.cancelBubble = true;
					
		}
		else // windows
		{
			window.event.cancelBubble = true;
		}
		return true; // co the fa
	}
		
</script>

<div class="title_categ"><liferay-ui:message key="nhan-vien-nhap-lieu-thay-lanh-dao"/></div>
<div class="boxcontent">
<!-- start form search -->
<%
	List<PmlEdmDocumentType> pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
	try {
		// phmphuc close 12/11/2010
		//pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentTypes(-1, -1);
		pmlEdmDocumentTypeList = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
		// end phmphuc update
	} catch (Exception e) {
		pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
	}
	
	List<Department> departments = new ArrayList<Department>();
	try {
		departments = DepartmentLocalServiceUtil.getDepartments(-1, -1);
	} catch (Exception e) {
		departments = new ArrayList<Department>();
	}

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	searchURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/xulythayld");
	String searchURLString = searchURL.toString();
	
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	int yearSearch = calendar.get(Calendar.YEAR);
	
	String fromDate = "01/01/" + yearSearch;
	String toDate = "31/12/" + yearSearch;
	if (!"".equals(tuNgay) && !"".equals(denNgay)) {
		fromDate = tuNgay;
		toDate = denNgay;
	} 
%>
<!-- yenlt update 20101022 -->
<input type="hidden" name="<portlet:namespace />timkiemtheotieuchi" id="<portlet:namespace/>timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>"/>	
<input type="hidden" name="<portlet:namespace />vtxulythayldb" id="<portlet:namespace/>vtxulythayldb" value="<%= String.valueOf(processTranlate) %>"/>	
<input type="hidden" name="<portlet:namespace />vtxulythayldvp" id="<portlet:namespace/>vtxulythayldvp" value="<%= String.valueOf(processTranlateLDVP) %>"/>	
<input type="hidden" name="<portlet:namespace />statusId" id="<portlet:namespace/>statusId" value="<%= String.valueOf(statusId) %>"/>	
<input type="hidden" name="<portlet:namespace />userIdXLT" id="<portlet:namespace/>userIdXLT" value="<%= String.valueOf(userIdXLT) %>">
<!-- end yenlt update 20101022 -->
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%"><liferay-ui:message key="loai-van-ban"/>&nbsp;:</td>
			<td width="35%">
				<select name="<portlet:namespace/>loaiVB" id="<portlet:namespace/>loaiVB" style="width: 92%">
      				<option value="<%= 0 %>" ></option>
		        	<% if (!pmlEdmDocumentTypeList.isEmpty()) { 
		        		for (PmlEdmDocumentType pmlEdmDocumentType : pmlEdmDocumentTypeList) { %>
	      				<option value="<%= pmlEdmDocumentType.getDocumentTypeId() %>" <%=  pmlEdmDocumentType.getDocumentTypeId() == loaiVB ? "selected" : "" %>> <%= pmlEdmDocumentType.getDocumentTypeName() %> </option>
	     			<% 	} 
	     				}%>
		      	</select>
			</td>
			
			<td><liferay-ui:message key="don-vi-soan-thao" />&nbsp;:</td>
			<td>
				<select name="<portlet:namespace />donViSoanThao" id="<portlet:namespace/>donViSoanThao" style="width: 92%">
					<option value=""></option>
					<%
					if (!departments.isEmpty()) {
						for (int idx = 0; idx < departments.size(); idx ++) {
							Department depItem = (Department) departments.get(idx);
					%>
							<option value="<%= depItem.getDepartmentsId() %>" <%= depItem.getDepartmentsId().equals(donViSoanThao) ? "selected" : ""%>><%= depItem.getDepartmentsName() %></option>
					<%
						}
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="nguoi-ky"/>&nbsp;:</td>
			<td ><input id="<portlet:namespace/>nguoiKy" name="<portlet:namespace/>nguoiKy" style="width: 90%" type="text" value="<%= nguoiKy %>" /></td>
			
			<td><liferay-ui:message key="co-quan-nhan"/>&nbsp;:</td>
			<td><input name="<portlet:namespace/>coQuanNhan" id="<portlet:namespace/>coQuanNhan"style="width: 90%" type="text" value="<%= coQuanNhan %>" /></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="tu-ngay"/>&nbsp;:</td>
			<td>
				<input type="text" name="<portlet:namespace/>tuNgay" id="<portlet:namespace/>tuNgay" value="<%= fromDate %>" style="width: 80%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-tuNgay" onClick="callCalendar('<portlet:namespace/>tuNgay','cal-button-tuNgay')" />
			</td>
			<td><liferay-ui:message key="den-ngay"/>&nbsp;:</td>
			<td >
				<input type="text" name="<portlet:namespace/>denNgay" id="<portlet:namespace/>denNgay" value="<%= toDate %>" style="width: 80%"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-denNgay" onClick="callCalendar('<portlet:namespace/>denNgay','cal-button-denNgay')" />
			</td>
		</tr>

		<tr>					
			<td >
				<liferay-ui:message key="trich-yeu"/>:&nbsp;
			</td>			
			<td colspan="3">
				<textarea id="<portlet:namespace/>trichYeu" name="<portlet:namespace/>trichYeu" style="width: 96%" rows="2"/><%= trichYeu %></textarea>
			</td>
		</tr>
		<tr>
		<td><liferay-ui:message key="chon-nguoi-de-nhap-but-phe"/>:</td>
		<td colspan="3">
			<div style="width: 100%">
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
					<tr class="results-header-Scrollbar" >
						<td width="40px" align="center"><label><liferay-ui:message key="select"/></label></td>
						<td ><liferay-ui:message key="ten"/></td>
					</tr>
					</table>	
					<div class="Scrollbarauto">
					<table cellspacing="0" width="100%" class="taglib_Scrollbar table-pml">	
					<%	
					User user2 = null;
					String stype = "";	
					for(int k = 0; k < listUserXLT.size(); k++) {
						try {
							user2 = UserLocalServiceUtil.getUser(listUserXLT.get(k)) ;
							if (k % 2 == 0){
								stype = "results-row";
							}
							else {
								stype = "tr_two results-row";
							}
						} catch (Exception ex) {
							
						}
						
					%>
						<tr class="<%= stype %>" onclick="getSelectRadio(this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
							<td width="40px" id="<%= k%>" align="center">
								<%
						    		String receiverName = user2.getLastName() + " " + user2.getMiddleName() + " " + user2.getFirstName();
						    	%>
								<input type="radio" <%= (ParamUtil.getLong(renderRequest, "userIdXLT") == listUserXLT.get(k) ? "checked" : " ") %> id="nguoiXuLyThay<%= k %>" onclick="getSelectRadioSelf(this)"  name="nguoiXuLyThay" value="<%= listUserXLT.get(k) %>" />
						
							</td>
							
							<td><%= receiverName %>
							(
								<%
									List<Long> listXLT = new ArrayList<Long>();
									listXLT.add(listUserXLT.get(k));
									int total = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users(listXLT, "0");
									if (total <= 0) {
								%>
									<liferay-ui:message key="lanh-dao-khong-co-van-ban"/>
								<%	} else { %>
									<liferay-ui:message key="lanh-dao-co-van-ban"/>
								<%} %>
							)
							</td>
						</tr>
					<%}	%>
						
				</table>
				</div>
			</div>
		</td>
	</tr>	
	</table>	
	<br/>
	<!-- end form search -->
		<div align="right">
			<span onclick="getParamForListXLT('<%= searchURLString %>');">
				<input type="button" name="<portlet:namespace/>search" value='<liferay-ui:message key="quanlycongvan-xulythayldb"/>'/>
			</span>
			<span onclick="javascript:submitForm(document.hrefFm,'<%=backtolist %>');" >
				<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
			</span>
		</div>
		<div id="<portlet:namespace/>listdocumentxlt" class="listdocument-cv"></div>
	</div>
	<br/>

<%

	if (ParamUtil.getLong(renderRequest, "userIdXLT") > 0) {
%>		
<script type="text/javascript">
	dsNhapLieuThayOnload();
</script>
<%
}
String transition = (String) renderRequest.getPortletSession().getAttribute("transition",PortletSession.APPLICATION_SCOPE);
if ("transition".equalsIgnoreCase(transition)) {
%>
		<script type="text/javascript" >	
			alert("<liferay-ui:message key='pcccdocumentreceipt-chuyen-thanh-cong'/>");
		</script>
<%	}
renderRequest.getPortletSession().setAttribute("transition",null,PortletSession.APPLICATION_SCOPE);
%>
