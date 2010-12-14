<%@ include file="/html/portlet/nss/onedoorprocess/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>

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

	function closePopup() {	
		window.returnValue = "";
		window.close();
	}	

	window.onload = function () {
		if (document.getElementById('receiveFromDate') != null) {
			callCalendar('receiveFromDate','cal-button-receiveFromDate');
		}
		if (document.getElementById('receiveToDate') != null) {
			callCalendar('receiveToDate','cal-button-receiveToDate');
		}
			
		if (document.getElementById('expectReturningFromDate') != null) {
			callCalendar('expectReturningFromDate','cal-button-expectReturningFromDate');
		}
		if (document.getElementById('expectReturningToDate') != null) {
			callCalendar('expectReturningToDate','cal-button-expectReturningToDate');
		}
		
		if (document.getElementById('completeFromDate') != null) {
			callCalendar('completeFromDate','cal-button-completeFromDate');
		}
		if (document.getElementById('completeToDate') != null) {
			callCalendar('completeToDate','cal-button-completeToDate');
		}	
		
		if (document.getElementById('exactReturningFromDate') != null) {
			callCalendar('exactReturningFromDate','cal-button-exactReturningFromDate');
		}
		if (document.getElementById('exactReturningToDate') != null) {
			callCalendar('exactReturningToDate','cal-button-exactReturningToDate');
		}	
	}	
</script>

<div id="search-popup">
<ul>
	<li style="width: 49%; padding-right: 2%">
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinhoso"/></label>
					<table width="100%" cellspacing="0">
			      	<tr>
			        	<td width="40%"><label><liferay-ui:message key="pccc-DSHS-mahoso"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-DSHS-mahoso"/>" name="fileId" type="text" id="fileId"></td>
			      	</tr>
			      	<tr>
			        	<td><label><liferay-ui:message key="pccc-TN-tenhoso"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-TN-tenhoso"/>" type="text" name="fileName" id="fileName"></td>
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
			      	<tr>
			        	<td><label><liferay-ui:message key="pccc-TN-tennguoinop"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-TN-tennguoinop"/>" type="text" name="applicantName" id="applicantName"></td>
			      	</tr>
			      	<tr>
			        	<td><label><liferay-ui:message key="pccc-TN-diachi"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-TN-diachi"/>" type="text" name="address" id="address"></td>
			      	</tr>
			      	<tr>
			        	<td><label><liferay-ui:message key="pccc-TN-dienthoai"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-TN-dienthoai"/>" type="text" name="telephone" id="telephone"></td>
			      	</tr>
			      	<tr >
			        	<td ><label><liferay-ui:message key="pccc-TN-email"/></label>:</td>
			        	<td><input style="width: 97%" title="<liferay-ui:message key="pccc-TN-email"/>" type="text" name="email" id="email"></td>
			      	</tr>
			      	
			      	<tr style="display: none;">
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
			      	
			      	
			      	
					</table>
				</fieldset>
	</li>
	<li style="width: 49%">
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinngaythang"/></label>
				    	<table width="100%" cellspacing="0">		    	
				      	<tr>
				        	<td width="40%"><label><liferay-ui:message key="pccc-TN-ngaynhanTN"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngaynhantungay"/>" type="text" name="receiveFromDate" id="receiveFromDate" >
							</td>
				      	</tr>
				      	
						<tr>
				        	<td ><label><liferay-ui:message key="pccc-TN-denngay"/></label  >:</td>
				        	<td >
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngaynhandenngay"/>" type="text" name="receiveToDate" id="receiveToDate">
				        	</td>
				      	</tr>
				      	<tr>
				        	<td ><label><liferay-ui:message key="pccc-TN-ngayhentraTN"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngayhentratungay"/>" type="text" name="expectReturningFromDate" id="expectReturningFromDate">
				        	</td>
				     	 </tr>
				      	<tr>
				        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngayhentradenngay"/>" type="text" name="expectReturningToDate" id="expectReturningToDate">
				        	</td>
				      	</tr>
				      	<tr>
				        	<td><label><liferay-ui:message key="pccc-TN-ngayhoanthanhTN"/></label>:</td>
							<td>
								<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngayhoanthanhtungay"/>" type="text" name="completeFromDate" id="completeFromDate">
							</td>
				      	</tr>
				      	<tr>
				        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngayhoanthanhdenngay"/>" type="text" name="completeToDate" id="completeToDate">
				        	</td>
				      	</tr>
				      	<tr>
				        	<td><label><liferay-ui:message key="pccc-TN-ngaythuctraTN"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngaythuctratungay"/>" type="text" name="exactReturningFromDate" id="exactReturningFromDate">
				        	</td>
				      	</tr>
				      	<tr>
				        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
				        	<td>
				        		<input style="width: 97%" title="<liferay-ui:message key="pccc-TN-ngaythuctradenngay"/>" type="text" name="exactReturningToDate" id="exactReturningToDate">
				        	</td>
				      	</tr>
				    	</table>
					</fieldset>
	</li>
</ul>
</div>
<div id="btpopup_tn" align="right">
			    	<input class="button-width" name="" type="button" value='<liferay-ui:message key="search" />' onclick="setDataForSearch();" >
			  		<input style="margin-right: 15px" class="button-width" name="" type="button" value='<liferay-ui:message key="skip"/>' onclick="closePopup();">
</div>
