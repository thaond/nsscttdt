<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/pccc-docreceiptprocess.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.ArrayList"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<portlet:actionURL var="form">
</portlet:actionURL>

<form action="<%= form %>" method="post" name="fname" enctype="multipart/form-data" onsubmit="return validateDocumentReport() ;" >
<input type="hidden" name="<portlet:namespace/>receiverIdReportMain" id="<portlet:namespace/>receiverIdReportMain" value="" />
<input type="hidden" name="<portlet:namespace/>receiverIdReports" id="<portlet:namespace/>receiverIdReports" value="" />
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
<div class="title_categ"><liferay-ui:message key="pccc-XL-thongtinxuly"/></div>
<div class="boxcontent">
<ul>
	<li style="width: 100%">
		<table cellspacing="0" width="100%">
			<tr valign="top">
					<td width="12%"><liferay-ui:message key="pccc-XL-ngayxuly"/>&nbsp;:</td>
					<td><%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></td>
				</tr>
				<tr>
					<td ><label><liferay-ui:message key="pccc-XL-thongtinxuly"/>&nbsp;:</label></td>
					<td><textarea name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="processInformation" cols="90" rows="5" style="width: 97%;"><liferay-ui:message key="pccc-XL-daguibaocaocholanhdao"/></textarea></td>
				</tr>
				
				<!--  minh update 20101227 -->
				<tr>
					 <%
						String rowAllName = "checkallbox";
						String formName = "fname";
						String rowName = renderResponse.getNamespace() + "report";
					
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
			  		<td valign="top"><liferay-ui:message key="nguoi-nhan"/>&nbsp;:</td>
				    <td colspan="3">
				      <div class="cvd-filedinhkem table-border-pml Scrollbarauto" style="width: 100%" class="Scrollbarauto">
				      	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
							<tr class="portlet-section-header results-header" >
								<td align="center" width="35px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
								<td width="45px" align="center">STT</td>
								<td ><liferay-ui:message key="name"/></td>
								<td ><liferay-ui:message key="nguoi-nhan-bao-cao-chinh"/></td>
							</tr>
				      	<%
				      	List<User> users = renderRequest.getAttribute("users") != null ? (List<User>) renderRequest.getAttribute("users") : new ArrayList<User>();
						int usersSize = users.size();
						User userModel = null;
						for (int i = 0; i < usersSize; i ++) {
							userModel = users.get(i);
							
						%>
						
							<tr  class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
								<td width="35px" align="center">
									<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />report" value="<%= userModel.getUserId()  %>" type="checkbox"   />
								</td>
								<td width="45px" align="center"><%= i + 1 %>.</td>
								<td><%=  userModel.getLastName().concat(" ") +  userModel.getMiddleName().concat(" ") + userModel.getFirstName() %></td>
								<td><input type="radio"  name="<portlet:namespace/>report"  id="<portlet:namespace/>report<%= userModel.getUserId()  %>" /></td>
							</tr>
						
							<%
						}
						%>
					</table>
				     </div>
				    </td>
				</tr>
				
				
				<!-- yenlt -->
				<tr style="display: none;">
				    <td>
				    	<label>
				    		<liferay-ui:message key="nguoi-nhan" />&nbsp;:
				    	</label>
				    </td>
				    <td>
				        <select name="<portlet:namespace/>receiverId" id="receiverId" style="width: 98%"> 
				        	<option selected="selected">[<liferay-ui:message key="select" />]</option>
				        	<logic:iterate id="userLD" name="users" indexId="i" type="com.liferay.portal.model.User" scope="request" >
				        	<%
				    			String userFullName = "";
				        		userFullName = userLD.getLastName().concat(" ") +  userLD.getMiddleName().concat(" ") + userLD.getFirstName();
				    		%>
				        		<option value="<%= userLD.getUserId() %>" ><%=userFullName %></option>
				        	</logic:iterate>
						</select>   
					</td>
				</tr>
				<!-- end yenlt -->
				
				<!--  end minh update 20101227 -->
			</table>
	</li>
</ul>
<ul>
	<li style="width: 100%">
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="document_attached_file"/></label>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
		   	<td ><liferay-ui:message key="document_attached_file_title" /></td>
		    <td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
		    <td width="15%" align="center"><input style="width: 90%;margin-left: 0" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
		  </tr>
		 </table>
	</fieldset>
	</li>
</ul>
<div align="right" id="table-button">
				<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
				<input onclick="window.history.back()" type="button" value='<liferay-ui:message key="back" />' />
</div>
<script type="text/javascript">
window.onload = function () {
	document.getElementById('processInformation').focus();	
	
}
</script>
</div>
</form>