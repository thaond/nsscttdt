<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>

<%@page import="javax.portlet.PortletURL"%>

<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	
	String documentReceiptIdList = renderRequest.getAttribute("documentReceiptIdList").equals("") ? "" : (String)renderRequest.getAttribute("documentReceiptIdList");
%>

<%
	List<String> userNameList = new ArrayList<String>(); 
	try {
		Department department = null;
		String userName = "";
		String deparmentName = "";
		List<PmlUser> userList = PmlUserLocalServiceUtil.findUserListByDepartmentId("chonphongban", -1, -1, null);
		int size = userList.size();
		PmlUser pmlUser = null;
		for (int k = 0; k < size; k ++) {
			pmlUser = userList.get(k);
			try {
				userName = pmlUser.getLastName().concat(" ") +  pmlUser.getMiddleName().concat(" ") + pmlUser.getFirstName();
				try {
					department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
					deparmentName = department.getDepartmentsName();
				} catch (Exception e){}
				userNameList.add(userName.concat(" [").concat(deparmentName).concat("]"));
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
	} catch (Exception e1) { 
		System.out.println("ERROR: no user or deparment in file indsphieuchuyen.jsp");
	}
%>

<script type="text/javascript">
	var nguoiNhan = '<%= userNameList%>'.substring(1, '<%= userNameList%>'.length -1).split(',');
	$().ready(function() {
		jQuerythoind("#<portlet:namespace />receiverid").autocomplete(nguoiNhan, {		
			minChars: 0,
			matchContains: true,
			autoFill: true});
	
	});

	function changeBoxReceiver() {
		var choose = document.getElementById("<portlet:namespace />choose");
		var inputreceiver = document.getElementById("inputreceiver");
		var tablereceivers = document.getElementById("tablereceivers");

		if (choose.checked) {
			inputreceiver.style.display = "inline";	
			tablereceivers.style.display = "none";
		}
		else {
			inputreceiver.style.display = "none";	
			tablereceivers.style.display = "inline";
		}
	}

	function fixReceiverToTextField() {
		var receiverid = document.getElementById("<portlet:namespace />receiverid").value;
		document.getElementById("<portlet:namespace />receiverName").value = receiverid;
	}
</script>

<%
	PortletURL inPhieuChuyenURL = renderResponse.createActionURL();
	inPhieuChuyenURL.setWindowState(WindowState.NORMAL);
	inPhieuChuyenURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/inphieuchuyen");
	inPhieuChuyenURL.setParameter("cmd", "PRINTS_LIST");
	inPhieuChuyenURL.setParameter("documentReceiptIdList", documentReceiptIdList);
%>

<form name="<portlet:namespace/>form" method="post" action="<%= inPhieuChuyenURL.toString() %>">
<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
	<tr valign="top"  >	
		<td width="14%" ><label><liferay-ui:message key="LCCV-yeucauxuly" /></label> &nbsp;:</td>
		<td align="left"><textarea name="<portlet:namespace/>processInformation" id="processInformation" rows="4" style="width: 98%"></textarea></td>
	</tr>
	
	<tr>
		<td></td>
		<td style="padding-left: 1.0%;">
			<span style="background: #ccf1f7;padding: 2px 5px;">
				<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> 
								&nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
				</span>
		</td>
	</tr>

	<tr valign="top" >
		<td ><label><liferay-ui:message key="LCCV-nguoinhan" /></label> : 
			<input type="checkbox" name="<portlet:namespace/>choose" id="<portlet:namespace />choose" checked="checked" onclick="changeBoxReceiver();" >
		</td>
		<td align="left">
		<div id="inputreceiver" style="width: 99%">
			<input style="width:72.5%" type="text" name="<portlet:namespace/>receiverid" id="<portlet:namespace />receiverid" onchange="fixReceiverToTextField();">&nbsp;&nbsp;
			<input type="hidden" id="<portlet:namespace />receiverName" name="<portlet:namespace />receiverName">
		</div>
		
		<div style="width: 99%; display: none;" id="tablereceivers">
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td align="center" width="40px"><liferay-ui:message key="select"/></td>
					<td width="40%"><liferay-ui:message key="LCCV-chuyenvien"/></td>
					<td ><liferay-ui:message key="LCCV-tenphongban"/></td>
				</tr>
				
				<%
					List<PmlUser> userList = null;
					Department department = null;
					try {
						String userName = "";
						String deparmentName = "";
						userList = PmlUserLocalServiceUtil.findUserListByDepartmentId("chonphongban", -1, -1, null);
						for (int k = 0; k < userList.size(); k ++) {
							PmlUser pmlUser = userList.get(k);
							try {
								userName = pmlUser.getLastName().concat(" ") +  pmlUser.getMiddleName().concat(" ") + pmlUser.getFirstName();
								department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
								deparmentName = department.getDepartmentsName();
							%>
							<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'}" onclick="getSelectRadio(this)">
								<td align="center" id="<%= k %>">
									<input class="styled" type="radio" onclick="clickRadio(event)" name="<portlet:namespace/>supportUsers" id="nguoiNhan<%= k %>" value="<%= String.valueOf(pmlUser.getUserId()) %>" />
								</td>
								<td><%= userName %></td>
								<td><%= deparmentName %></td>
							</tr>
							<%
							} catch (Exception e2) { }
						}
					} catch (Exception e1) { 
						System.out.println("ERROR: no user or deparment in file indsphieuchuyen.jsp");
					}
				%>
				
			</table>
		</div>
		</td>
	</tr>

</table>
</div>

<div align="right" id="table-button">
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="100%" align="right">
				<input type="submit" value="<liferay-ui:message key="in-phieu-chuyen" />"/>&nbsp;
				<input type="button" value="<liferay-ui:message key="close" />" onclick="window.close();" />&nbsp;
			</td>
		</tr>
	</table>
</div>
</form>