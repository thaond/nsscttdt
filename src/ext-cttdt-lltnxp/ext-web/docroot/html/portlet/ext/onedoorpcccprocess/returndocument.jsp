<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCC"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp" %>

<script type="text/javascript">
window.onload = function () {
	document.getElementById('nguoiNhan').focus();
}
</script>


<script type="text/javascript">

function <portlet:namespace/>checkForm(form) {
	if(form.<portlet:namespace/>nguoiNhan.value == "") {
		alert("<liferay-ui:message key='doc-r8-alert'/>\n<liferay-ui:message key='pccc-r8-alert'/>\n");
		form.<portlet:namespace/>nguoiNhan.focus();
		return false;
	}
	if(form.<portlet:namespace/>soCongVan.value == "") {
		alert('<liferay-ui:message key="nhapsocongvan"/>');
		form.<portlet:namespace/>soCongVan.focus();
		return false;
	}
	if(isNaN(form.<portlet:namespace/>soTien.value) == true) {
		form.<portlet:namespace/>soTien.focus();
		return false;
	}
	if(form.<portlet:namespace/>ngayNhanGiayPhep.value == "") {
		form.<portlet:namespace/>ngayNhanGiayPhep.focus();
		return false;
	}
	if(isDate(form.<portlet:namespace/>ngayNhanGiayPhep.value) == false) {
		alert('<liferay-ui:message key="pccc-error-date"/>');
		form.<portlet:namespace/>ngayNhanGiayPhep.focus();
		return false;
	}
	return true;
	alert('<liferay-ui:message key="hosodaluu"/>');
}

</script>

<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String userName = loginUser.getLastName() + " "+ loginUser.getMiddleName() + " " + loginUser.getFirstName();   
	String senderId = String.valueOf(loginUser.getUserId());
	PmlFilePCCC filePccc = (PmlFilePCCC) renderRequest.getAttribute("filePccc");
	PmlOneDoorReceiveFile pmlFile = (PmlOneDoorReceiveFile) renderRequest.getAttribute("pmlFile");
	PmlFileType fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(pmlFile.getFileTypeId());
	String fileTypeName = fileType.getFileTypeName();
	// yenlt 24052010
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	// end yenlt 24052010
%>

<portlet:actionURL var="form" >
</portlet:actionURL>

<form name="form"  method="post" action="<%=form%>" onsubmit="return <portlet:namespace/>checkForm(this)">
<input type="hidden" name="isDelegate" value="<%= isDelegate %>" > <!-- yenlt 24052010 -->
<div class="title_categ"><liferay-ui:message key="pccc-XL-xulytrahoso"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%" >
	<tr>
	    <td width="15%">
	    	<label>
			     <liferay-ui:message key="pccc-TN-loaihoso"/> :
			</label>
	     </td>
	    <td>
      		<input type="text" readonly="readonly" name="<portlet:namespace/>loaiHoSo" id="loaiHoSo" style="width:99%;" value="<%=fileTypeName %>" >
      		<input type="hidden" name="<portlet:namespace/>fileId" value="<%= pmlFile.getFileId() %>" />
      	</td>
  	</tr>
  	<tr>
	    <td>
	    	<label>
			     <liferay-ui:message key="pccc-TN-tenhoso"/>
			     <font color="red">(*)</font>:
			</label>
	     </td>
	    <td>
      		<input type="text" readonly="readonly" name="<portlet:namespace/>tenHoSo" id="tenHoSo" style="width:99%;" value="<%=filePccc.getFileName() %>" >
      	</td>
  	</tr>
    <tr>
	    <td>
	    	<label>
	      		<liferay-ui:message key="pccc-TN-nguoitrahoso"/>
	      		<font color="red">(*)</font>:
	      	</label>
	    </td>
	    <td>
	      <input type="text" readonly="readonly" name="<portlet:namespace/>nguoiTra" id="nguoiTra" style="width:99%;" value="<%=userName %>" >
	      <input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>senderId" value="<%= senderId %>"></td>
	    </td>
	  </tr>
	  <tr>
		    <td>
		    	<label>
		      		<liferay-ui:message key="pccc-TN-ngaytrahoso"/>
		      		<font color="red">(*)</font>:
		      	</label>
		    </td>
		    <td>
		    	<input type="text" readonly="readonly" name="<portlet:namespace/>ngayTra" id="ngayTra" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'>
		    	<input type="hidden" readonly="readonly" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>dateProcess" id="ngayGui" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'>
		    </td>   
	  </tr>
	  <tr>
	    	<td>
	    		<label>
	     		 	<liferay-ui:message key="pccc-TN-nguoinhan"/> 
	     		 	<font color="red">(*)</font>:
	      		</label>
	      	</td>
	    	<td>
	    		<input type="text" name="<portlet:namespace/>nguoiNhan" id="nguoiNhan" style="width:99%;"  />
	    	</td>   
	  </tr>
	  <tr>
	    	<td>
	    		<label>
	     		 	<liferay-ui:message key="pccc-TN-socongvan"/>
	      			<font color="red">(*)</font>:
	      		</label>
	      	</td>
	    	<td>
	    		<input type="text" name="<portlet:namespace/>soCongVan" id="soCongVan" style="width:99%;" value="">
	    	</td>   
	  </tr>
	  <tr>
	    	<td>
	    		<label>
	     		 	<liferay-ui:message key="pccc-TN-sohoadon"/> :
	      		</label>
	      	</td>
	    	<td>
	    		<input type="text" name="<portlet:namespace/>soHoaDon" id="soHoaDon" style="width:99%;" value="">
	    	</td>   
	  </tr>
	  <tr>
	    	<td>
	    		<label>
	     		 	<liferay-ui:message key="pccc-TN-sotien"/> :
	      		</label>
	      	</td>
	    	<td>
	    		<input type="text" name="<portlet:namespace/>soTien" id="soTien" style="width:99%;" value="">
	    	</td>   
	  </tr>
	  <tr>
	    	<td>
	    		<label>
	     		 	<liferay-ui:message key="pccc-TN-ngaynhangiayphep"/> :
	      		</label>
	      	</td>
	    	<td>
	    		<input type="text" name="<portlet:namespace/>ngayNhanGiayPhep" id="ngayNhanGiayPhep" style="width:99%;" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date())%>'></td>   
	  </tr>
	  <tr valign="top">
	    <td><label>
	      <liferay-ui:message key="pccc-TN-ghichu"/>
	      :</label></td>
	    <td rowspan="3">
	      <textarea name="<portlet:namespace/>ghiChu" id="ghiChu" rows="2" style="width: 99%;height: 70px;"></textarea></td>    
	  </tr>
	  
  </table>
   <!-- yenlt 24052010 -->
   <portlet:renderURL var="back">
		<portlet:param name="struts_action"	value="/sgs/onedoorpcccprocess/view" />
		<portlet:param name="transitionBack" value="transitionBack" />
		<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId" %>' value='<%= ParamUtil.getString(renderRequest, "fileId") %>' />
		<portlet:param name="isDelegate" value="<%= isDelegate %>" />
		<portlet:param name="processValue" value="<%= processValue %>" /> 
	</portlet:renderURL> 
	<!-- yenlt 24052010 -->
	<div id="table-button" align="right">
		<liferay-util:include page="/html/portlet/ext/onedoorpcccprocess/common/taskAction.jsp"></liferay-util:include>
		     	<input class="button-width" type="reset" value='<liferay-ui:message key="reset"/>'>
		     	<a onclick="javascript:submitForm(document.hrefFm,'<%= back %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a>
	</div>
</div>
</form>
