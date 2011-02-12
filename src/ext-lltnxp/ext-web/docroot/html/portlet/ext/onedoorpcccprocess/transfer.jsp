<%@ include file="/html/portlet/ext/onedoorpcccprocess/js/onedoorpcccprocess-js.jsp" %>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<!-- yenlt update 15-04-2010 -->

<portlet:actionURL var="inphieuchuyen">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/inphieuchuyen" />	
	<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId" %>' value="<%= ParamUtil.getString(renderRequest, "fileId") %>"/>
</portlet:actionURL> 

<!-- end yenlt -->
<portlet:actionURL var="form" >
</portlet:actionURL>
<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String userName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
	String senderId = String.valueOf(loginUser.getUserId());
	
	// yenlt update 24052010
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	// end yenlt 24052010
%>
<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" >
<input type="hidden" name="<portlet:namespace/>departmentId" id="departmentIdBefore" value="">
<input type="hidden" name="isDelegate" value="<%= isDelegate %>" > <!-- yenlt 24052010 -->
<div class="title_categ"><liferay-ui:message key="pccc-XL-xulyhoso"/></div>
<div class="boxcontent">
<table align="center" width="100%" >
	<tr>
    	<td >
    		<div align="left">
      			<label><liferay-ui:message key="pccc-XL-nguoigui"/><font color="red" size="1">(*)</font> :</label>
      		</div>
      	</td>
      	
    	<td>
      		<input type="text" readonly="readonly" name="<portlet:namespace/>nguoiGui" id="nguoiGui" style="width:99%;" value="<%=userName %>" >
      		<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>senderId" value="<%= senderId %>">
      	</td>    
	</tr>
	
	<tr>
    	<td>
    		<div align="left">
    			<label><liferay-ui:message key="pccc-XL-ngaygui"/><font color="red" size="1">(*)</font>:</label>
    		</div>
    	</td>
    	
    	<td>
    		<input type="text" readonly="readonly" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>dateProcess" id="ngayGui" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'>
    	</td>   
	</tr>
	
	<tr>
		<td nowrap="nowrap" width="10%">
			<div align="left">
				<label><liferay-ui:message key="pccc-XL-thoigiangui"/></label>
			</div>
		</td>
    
		<td>
			<input type="text"  name="thoiGianGui" id="applicantTime" style="width:99%;" value="">
		</td>   
	</tr>
	
	<tr>
    	<td>
    		<div align="left">
    			<label><liferay-ui:message key="pccc-XL-nguoiNhan"/><font color="red" size="1">(*)</font>:</label>
    		</div>
    	</td>
    	
		<td>
			<select name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId" id="nguoiNhan" style="width:99.6%;">
	    			<option selected="selected"><liferay-ui:message key="select"/></option>
	    		<logic:iterate id="user" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
	    		<%
		    			String receiverName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
	    		%>
	    			<option onclick="getUserId()" value="<%=user.getUserId() %>"><%=receiverName %></option>
	    		</logic:iterate>
			</select>
		</td>   
	</tr>
	
	<tr>
    	<td nowrap="nowrap">
    		<div align="left">
    			<label><liferay-ui:message key="pccc-XL-thongtinxuly"/>:</label>
    		</div>
    	</td>
    	
		<td rowspan="7">
      		<textarea name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="thongTinXuLy" cols="90" rows="2" style="width: 99%;"></textarea>
      	</td>    
	</tr>
</table>

<portlet:renderURL var="back">
	<portlet:param name="struts_action"	value="/sgs/onedoorpcccprocess/view" />
	<portlet:param name="transitionBack" value="transitionBack" />
	<portlet:param name="processValue" value="<%= processValue %>" /> <!-- yenlt 24052010 -->
	<portlet:param name="isDelegate" value="<%= isDelegate %>" /> <!-- yenlt 24052010 -->
	<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId" %>' value='<%= ParamUtil.getString(renderRequest, "fileId") %>' />
</portlet:renderURL> 

	<div id="table-button" align="right">
				<span onclick="printPhieuChuyen()" ><input class="button-width" type="button" value='<liferay-ui:message key="in-phieu-chuyen"/>' ></span>
				<span onclick="return checknguoinhan();"><liferay-util:include page="/html/portlet/ext/onedoorpcccprocess/common/taskAction.jsp"></liferay-util:include></span>
				<input class="button" type="reset" value='<liferay-ui:message key="reset"/>'/>
		    	<span onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></span>      
	</div>
    
</div>
</form>
<!-- yenlt update phan in phieu chuyen -->
<form method="post" action="<%= inphieuchuyen %>" name="<portlet:namespace />fmPhieuChuyen" id="fmPhieuChuyen">
	<input type="hidden" name="<portlet:namespace/>processInformationPhieuChuyen" id="processInformationPhieuChuyen">
	<input type="hidden" name="<portlet:namespace/>departmentId" id="departmentId" value="">
	<input type="hidden" name="<portlet:namespace/>applicantTimeAfter" id="applicantTimeAfter" value="">
</form>
<script type="text/javascript">
window.onload = function () {
	document.getElementById('nguoiNhan').focus();
	startTime();
}

function printPhieuChuyen() {
	var processInformation = document.getElementById("thongTinXuLy").value;	
	var processInformationPhieuChuyen = document.getElementById("processInformationPhieuChuyen");
	processInformationPhieuChuyen.value = processInformation;	
	//yenlt 16/04/2010
	var departmentIdBefore = document.getElementById('departmentIdBefore').value;
	var departmentId = document.getElementById('departmentId');
	var applicantTime = document.getElementById('applicantTime').value;
	var applicantTimeAfter = document.getElementById('applicantTimeAfter');
	
	departmentId.value = departmentIdBefore;
	applicantTimeAfter.value = applicantTime;
	//end
	var fmPhieuChuyen = document.getElementById("fmPhieuChuyen");	
	fmPhieuChuyen.submit();
}

</script>