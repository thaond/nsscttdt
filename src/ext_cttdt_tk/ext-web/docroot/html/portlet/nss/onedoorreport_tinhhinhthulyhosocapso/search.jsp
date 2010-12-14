<%@ include file="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/init.jsp" %>

<script type="text/javascript">
	function setDataForSearch() {
		var fileId = document.getElementById('fileId').value;
		var fileName = document.getElementById('fileName').value;
		var applicantName = document.getElementById('applicantName').value;
		var address = document.getElementById('address').value;
		var telephone = document.getElementById('telephone').value;
		var email = document.getElementById('email').value;
		var fileStatus = document.getElementById('fileStatus').value;
		var fileType = document.getElementById('fileType').value;
		var receiveFromDate = document.getElementById('receiveFromDate').value;
		var receiveToDate = document.getElementById('receiveToDate').value;
		var expectReturningFromDate = document.getElementById('expectReturningFromDate').value;
		var expectReturningToDate = document.getElementById('expectReturningToDate').value;
		var completeFromDate = document.getElementById('completeFromDate').value;
		var completeToDate = document.getElementById('completeToDate').value;
		var exactReturningFromDate = document.getElementById('exactReturningFromDate').value;
		var exactReturningToDate = document.getElementById('exactReturningToDate').value;

		window.returnValue = fileId + "_" + fileName + "_" + applicantName + "_" + address + "_"
		+ telephone + "_" + email + "_" + fileStatus + "_" + fileType + "_" + receiveFromDate + "_" + receiveToDate + "_" 
		+ expectReturningFromDate + "_" + expectReturningToDate + "_" + completeFromDate + "_" + completeToDate + "_" + exactReturningFromDate + "_" + exactReturningToDate;
		window.close();
	}
		
</script>
<style type="text/css">
td {
	text-align: right;
}
</style>
<div id="search-popup" style="overflow: hidden">
<fieldset style="background-color: #EAEAEA">
<table style="width: 97%" class="bgdocsend" style="background-color: #EAEAEA">
<tr>
	<td colspan="2" width="48%" style="background-color: #EAEAEA">
	<fieldset style="background-color: #EAEAEA"><legend class="legend-noborder" style="background-color: #EAEAEA"><liferay-ui:message key="pccc-TN-thongtinhoso"/></legend>
		<table width="100%" style="background-color: #EAEAEA">
      	<tr>
        	<td style="width: 35%"><label><liferay-ui:message key="pccc-DSHS-mahoso"/></label>:</td>
        	<td><input  style="width: 98%" title="<liferay-ui:message key="pccc-DSHS-mahoso"/>" name="fileId" type="text" id="fileId"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-tenhoso"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-tenhoso"/>" type="text" name="fileName" id="fileName"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-tennguoinop"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-tennguoinop"/>" type="text" name="applicantName" id="applicantName"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-diachi"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-diachi"/>" type="text" name="address" id="address"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-dienthoai"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-dienthoai"/>" type="text" name="telephone" id="telephone"></td>
      	</tr>
      	<tr>
        	<td ><label><liferay-ui:message key="pccc-TN-email"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-email"/>" type="text" name="email" id="email"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-trangthaihoso"/></label>:</td>
        	<td>
          		<select style="width: 99%" title="<liferay-ui:message key="pccc-TN-trangthaihoso"/>" name="fileStatus" id="fileStatus">
          			<option value=""><liferay-ui:message key="chon-trang-thai-ho-so-can-tim" /></option>
          		<logic:iterate id="fileStatus" name="listFileStatus" indexId="i" type="com.nss.portlet.onedoor.model.PmlFileStatus" scope="request" >
          			<option value="<%=fileStatus.getFileStatusId() %>"><%=fileStatus.getFileStatusName() %></option>
          		</logic:iterate>
          		</select>
        	</td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-loaihoso"/></label>:</td>
        	<td>
        		<select style="width: 99%" title="<liferay-ui:message key="pccc-TN-loaihoso"/>" name="fileType" id="fileType">
        			<option value=""><liferay-ui:message key="chon-loai-ho-so-can-tim" /></option>
          		<logic:iterate id="fileType" name="listFileType" indexId="i" type="com.nss.portlet.filetype.model.PmlFileType" scope="request" >
          			<option value="<%=fileType.getFileTypeId() %>"><%=fileType.getFileTypeName() %></option>
          		</logic:iterate>
            	</select>
            </td>
      	</tr>
		</table>
	</fieldset>
	</td>
	<td colspan="2" width="52%" style="background-color: #EAEAEA">
	<fieldset style="background-color: #EAEAEA"><legend class="legend-noborder" style="background-color: #EAEAEA"><liferay-ui:message key="pccc-TN-thongtinngaythang"/></legend>
    	<table width="100%" >
      	<tr>
        	<td style="width: 35%"><label><liferay-ui:message key="pccc-TN-ngaynhanTN"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngaynhantungay"/>" type="text" name="receiveFromDate" id="receiveFromDate"></td>
      	</tr>
		<tr>
        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label  >:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngaynhandenngay"/>" type="text" name="receiveToDate" id="receiveToDate"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-ngayhentraTN"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngayhentratungay"/>" type="text" name="expectReturningFromDate" id="expectReturningFromDate"></td>
     	 </tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngayhentradenngay"/>" type="text" name="expectReturningToDate" id="expectReturningToDate"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-ngayhoanthanhTN"/></label>:</td>
			<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngayhoanthanhtungay"/>" type="text" name="completeFromDate" id="completeFromDate"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngayhoanthanhdenngay"/>" type="text" name="completeToDate" id="completeToDate"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-ngaythuctraTN"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngaythuctratungay"/>" type="text" name="exactReturningFromDate" id="exactReturningFromDate"></td>
      	</tr>
      	<tr>
        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
        	<td><input style="width: 98%" title="<liferay-ui:message key="pccc-TN-ngaythuctradenngay"/>" type="text" name="exactReturningToDate" id="exactReturningToDate"></td>
      	</tr>
    	</table>
	</fieldset>
    </td>
</tr>
</table>

<table style="width: 97%" >
<tr height="35">
	<td ></td>
    <td colspan="3" class="bgsearch">
    	<input class="button-width" name="" type="button" value='<liferay-ui:message key="search" />' onclick="setDataForSearch();" >
  		<input class="button-width" name="" type="button" value='<liferay-ui:message key="skip"/>' onclick="window.close();">
  	</td>
  </tr>
</table>
</fieldset></div>