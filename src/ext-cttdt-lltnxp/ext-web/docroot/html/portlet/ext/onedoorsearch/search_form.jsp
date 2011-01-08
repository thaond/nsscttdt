<%@ include file="/html/portlet/ext/onedoorsearch/init.jsp" %>
<%@page import="com.sgs.portlet.onedoorsearch.searchresult.PmlOneDoorReceiveFileSearchResultDisplayTerms"%>
<%@page import="com.sgs.portlet.onedoorsearch.searchresult.PmlOneDoorReceiveFileSearchResult"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<script type="text/javascript">
	window.onload = function (){
		
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

<%
	PmlOneDoorReceiveFileSearchResult receiveFileSearchResult = (PmlOneDoorReceiveFileSearchResult)renderRequest.getAttribute("liferay-ui:search:searchContainer");
	PmlOneDoorReceiveFileSearchResultDisplayTerms displayTerms = (PmlOneDoorReceiveFileSearchResultDisplayTerms)receiveFileSearchResult.getDisplayTerms() ;
%>
<div class="boxsearch_hs">
<ul>
	<li style="width: 40%; padding-right: 3%;">
		<table cellspacing="0" width="100%">
			<tr>
				<td width="28%">
					<label><liferay-ui:message key="pccc-DSHS-mahoso"/></label>:</td>
		        <td>
		        	<input style="width: 50%" title="<liferay-ui:message key="pccc-DSHS-mahoso"/>" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.MA_HS %>" type="text" id="fileId" value="<%= HtmlUtil.escape(displayTerms.getFileId()) %>"></td>        	
		    </tr>
		    <tr>   
		        <td  style="padding-top: 7px;">
		        	<label><liferay-ui:message key="pccc-TN-tenhoso"/></label>:</td>
		        <td style="padding-top: 7px;">
		        	<input style="width: 93%" title="<liferay-ui:message key="pccc-TN-tenhoso"/>" type="text" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.TEN_HS %>" id="fileName" value="<%= HtmlUtil.escape(displayTerms.getFileName()) %>"></td>
			</tr>
			<tr >	        
		        <td><label><liferay-ui:message key="pccc-TN-loaihoso"/></label>:</td>
		        <td >
		        		<select style="width: 95.5%" title="<liferay-ui:message key="pccc-TN-loaihoso"/>" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.FILETYPE %>" id="fileType">
		        			<option value=""><liferay-ui:message key="chon-loai-ho-so-can-tim" /></option>
		          		<logic:iterate id="fileType" name="listFileType" indexId="i" type="com.sgs.portlet.filetype.model.PmlFileType" scope="request" >
		          			<option value="<%=fileType.getFileTypeId() %>" <%= displayTerms.getFileTypeId().equals(fileType.getFileTypeId()) ? "selected" : "" %>><%=fileType.getFileTypeName() %></option>
		          		</logic:iterate>
		            	</select>
		           </td>
			</tr>
			<tr>
				<td style="padding-top: 7px;"><label><liferay-ui:message key="pccc-TN-tennguoinop"/></label>:</td>
		        <td style="padding-top: 7px;"><input style="width: 93%" title="<liferay-ui:message key="pccc-TN-tennguoinop"/>" type="text" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.APPLICANTNAME %>" id="applicantName" value="<%= HtmlUtil.escape(displayTerms.getApplicantName()) %>"></td>
			</tr>
			<tr>
				<td  style="padding-top: 7px;"><label><liferay-ui:message key="pccc-TN-diachi"/></label>:</td>
		        <td  style="padding-top: 7px;"><input style="width: 93%" title="<liferay-ui:message key="pccc-TN-diachi"/>" type="text" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.ADDRESS %>" id="address" value="<%= HtmlUtil.escape(displayTerms.getAddress()) %>"></td>
			</tr>
			<tr>
		        	<td></td>
					<td colspan="3">
						<input style="float: left;margin: 10px 0;" name="" type="submit" value='<liferay-ui:message key="search" />' >
					</td>
      	</tr>

		</table>
	</li>
	<li style="width: 57%">
		<table cellspacing="0" width="100%">
     	<tr>
		        	<td width="26%"><label><liferay-ui:message key="pccc-TN-ngaynhanTN"/></label>:</td>
		        	<td width="29%">
						<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.RECEIVEFROMDATE %>" id="receiveFromDate" value="<%= (!"".equals(displayTerms.getReceiveFromDate()) ? displayTerms.getReceiveFromDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-receiveFromDate" onClick="callCalendar('receiveFromDate','cal-button-receiveFromDate')" />
					</td>
		        	<td width="14%"><label><liferay-ui:message key="pccc-TN-denngay"/></label  >:</td>
		        	<td >
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.RECEIVETODATE %>" id="receiveToDate" value="<%= (!"".equals(displayTerms.getReceiveToDate()) ? displayTerms.getReceiveToDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-receiveToDate" onClick="callCalendar('receiveToDate','cal-button-receiveToDate')" />
					</td>
      	</tr>
      	<tr>
		        	<td><label><liferay-ui:message key="pccc-TN-ngayhentraTN"/></label>:</td>
		        	<td >
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.EXPECTRETURNINGFROMDATE %>" id="expectReturningFromDate" value="<%= (!"".equals(displayTerms.getExpectReturningFromDate()) ? displayTerms.getExpectReturningFromDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-expectReturningFromDate" onClick="callCalendar('expectReturningFromDate','cal-button-expectReturningFromDate')" />
					</td>
		        	<td><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
		        	<td>
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.EXPECTRETURNINGTODATE %>" id="expectReturningToDate" value="<%= (!"".equals(displayTerms.getExpectReturningToDate()) ? displayTerms.getExpectReturningToDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-expectReturningToDate" onClick="callCalendar('expectReturningToDate','cal-button-expectReturningToDate')" />
					</td>
      	</tr>
      	<tr>
		        	<td><label><liferay-ui:message key="pccc-TN-ngayhoanthanhTN"/></label>:</td>
					<td >
						<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.COMPLETEFROMDATE %>" id="completeFromDate" value="<%= (!"".equals(displayTerms.getCompleteFromDate()) ? displayTerms.getCompleteFromDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-completeFromDate" onClick="callCalendar('completeFromDate','cal-button-completeFromDate')" />
					</td>
		        	<td ><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
		        	<td >
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.COMPLETETODATE %>" id="completeToDate" value="<%= (!"".equals(displayTerms.getCompleteToDate()) ? displayTerms.getCompleteToDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-completeToDate" onClick="callCalendar('completeToDate','cal-button-completeToDate')" />
					</td>
      	</tr>
      		   	<tr>
		        	<td><label><liferay-ui:message key="pccc-TN-ngaythuctraTN"/></label>:</td>
		        	<td >
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.EXACTRETURNINGFROMDATE %>" id="exactReturningFromDate" value="<%= (!"".equals(displayTerms.getExactReturningFromDate()) ? displayTerms.getExactReturningFromDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-exactReturningFromDate" onClick="callCalendar('exactReturningFromDate','cal-button-exactReturningFromDate')" />
					</td>
		        	<td ><label><liferay-ui:message key="pccc-TN-denngay"/></label>:</td>
		        	<td >
		        		<input style="width: 65%" type="text"  name="<portlet:namespace/><%= PmlOneDoorReceiveFileSearchResultDisplayTerms.EXACTRETURNINGTODATE %>" id="exactReturningToDate" value="<%= (!"".equals(displayTerms.getExactReturningToDate()) ? displayTerms.getExactReturningToDate(): "")  %>" style="width: 125px" />
						<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-exactReturningToDate" onClick="callCalendar('exactReturningToDate','cal-button-exactReturningToDate')" />
					</td>
      	</tr>
      	<tr>
					<td  style="padding-top: 7px;"><label><liferay-ui:message key="pccc-TN-dienthoai"/></label>:</td>
		        	<td  style="padding-top: 7px;" colspan="3"><input style="width: 90%" title="<liferay-ui:message key="pccc-TN-dienthoai"/>" type="text" name="<%= PmlOneDoorReceiveFileSearchResultDisplayTerms.TELEPHONE %>" id="telephone" value="<%= HtmlUtil.escape(displayTerms.getTelephone()) %>"></td>      	
		    </tr>
      	
	</table>
	
	</li>
</ul>
</div>


