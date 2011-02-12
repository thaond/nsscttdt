<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>


<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<script type="text/javascript">
function validateDocumentCVP_OR_LB(){
	var listUserReceipt = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
	document.getElementById('<portlet:namespace/>receiverIds').value = listUserReceipt;
	var listUserReceiptArr = listUserReceipt.split(",");
	var checkMain = false;
	for (var i=0; i<listUserReceiptArr.length; i++) {
		if ((document.getElementById("<portlet:namespace/>CVP_OR_LD" + listUserReceiptArr[i])!=null)
				&& (document.getElementById("<portlet:namespace/>CVP_OR_LD" + listUserReceiptArr[i])).checked){
			document.getElementById('<portlet:namespace/>receiverIdMain').value = listUserReceiptArr[i];
			checkMain = true;
		}
	}
	
	if (!checkMain) {
		alert("<liferay-ui:message key='chon-lanh-dao-xu-ly-chinh'/>")
		return false;
	}
	
	else {
		return true;
	}
}
</script>
<portlet:actionURL var="form" > 
</portlet:actionURL>

<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	List<User> userList = request.getAttribute("users") != null ? (List<User>) request.getAttribute("users") : new ArrayList<User>(); 
%>

<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" onsubmit="return validateDocumentCVP_OR_LB();">
<input type="hidden" name="<portlet:namespace/>receiverIdMain" id="<portlet:namespace/>receiverIdMain" value="" />
<input type="hidden" name="<portlet:namespace/>receiverIds" id="<portlet:namespace/>receiverIds" value="" />

<div class="title_categ"><liferay-ui:message key="LCCV-thongtinluanchuyencongvan"/></div>
<div class="boxcontent">
	<table cellspacing="0" width="100%">
	
		<tr valign="top"  >	
				<td width="14%" ><label><liferay-ui:message key="LCCV-trinhkydenghi" /></label> &nbsp;:</td>
				<td align="right"><textarea name="<portlet:namespace/>processInformation" id="processInformation" rows="2" style="width: 98%"></textarea></td>
		</tr>

		<tr>
			<td></td>
			<td style="padding-left: 1.1%;">
				<span style="background: #ccf1f7;padding: 2px 5px;">
				<liferay-ui:message key="LCCV-ngaygiochuyen" /> : <b><%=new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()) %></b> &nbsp;&nbsp;&nbsp;<liferay-ui:message key="LCCV-nguoichuyen" /> : <b><%=loginName %></b>
				</span>
				</td>
		</tr>

		<tr valign="top" >
			<td ><label><liferay-ui:message key="LCCV-nguoinhan" /></label> &nbsp;:</td>
			<td align="right">
			
				<%
						String rowAllName = "checkallbox";
						String formName = renderResponse.getNamespace() + "form";
						String rowName = renderResponse.getNamespace() + "CVP_OR_LD";
					
						StringBuilder rowAllNameChecked = new StringBuilder();
						rowAllNameChecked.append("<input name=\"");
						rowAllNameChecked.append(rowAllName);
						rowAllNameChecked.append("\" type=\"checkbox\" ");
						rowAllNameChecked.append("onClick=\"Liferay.Util.checkAll(");
						rowAllNameChecked.append(formName);
						rowAllNameChecked.append(", '");
						rowAllNameChecked.append(rowName);
						rowAllNameChecked.append("', this");
						rowAllNameChecked.append(");\">");
						
					
				%>
					
				 <div class="cvd-filedinhkem table-border-pml Scrollbarauto" style="width: 100%" class="Scrollbarauto">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
						<tr class="portlet-section-header results-header" >
							<td align="center" width="35px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
							<td width="45px" align="center">STT</td>
							<td ><liferay-ui:message key="LCCV-tenphongbanchuyenvien"/></td>
							<td ><liferay-ui:message key="lanh-dao-xu-ly-chinh"/></td>
						</tr>
						<logic:iterate id="user" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
						<%
					    	String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
					    %>
						<tr  class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
							<td width="35px" align="center">
									<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />CVP_OR_LD" value="<%= user.getUserId()  %>" type="checkbox"   />
								</td>
								<td width="45px" align="center"><%= i + 1 %>.</td>
								<td><%=  fullName %></td>
								<td><input type="radio"  name="<portlet:namespace/>CVP_OR_LD_RADIO"  id="<portlet:namespace/>CVP_OR_LD<%= user.getUserId()  %>" /></td>
						</tr>
						</logic:iterate>
					</table>
				</div>
			</td>
		</tr>
	</table>

	<div align="right" id="table-button">
		<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
		<a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
	</div>
</div>
</form>

<script type="text/javascript">
	window.onload = function () {
		if(document.getElementById('processInformation') != null ){		
			document.getElementById('processInformation').focus();
		}
		
	}
</script>
