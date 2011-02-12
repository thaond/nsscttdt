<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo"%>
<%@page import="com.sgs.portlet.vanbannoibo.model.VanBanNoiBo"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalServiceUtil"%>

<%@ include file="/html/portlet/ext/vanbannoibo/tiepnhanvanbannoibo/js/tiep_nhan.jsp" %>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%
int sttVanbanNoiBo = VanBanNoiBoLocalServiceUtil.getVanBanNoiBosCount() + 1;
List<PmlUser> listUsers = PmlUserLocalServiceUtil.getPmlUsers(-1,-1);
List<PmlEdmDocumentType> listLoaiVanBans = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentTypes(-1,-1);

VanBanNoiBo vanBanNoiBo = (VanBanNoiBo) request.getAttribute("vanBanNoiBo");
List<FileDinhKemVanBanNoiBo> fileDinhKemVanBanNoiBos = new ArrayList<FileDinhKemVanBanNoiBo>();
if(vanBanNoiBo != null){
	fileDinhKemVanBanNoiBos = VanBanNoiBoLocalServiceUtil.getFileDinhKemVanBanNoiBos(vanBanNoiBo.getVanBanNoiBoId());
}
long userId = (Long) request.getAttribute("userId");
Department department = null;
try{
	PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
	String departmentId = pmlUser.getDepartmentsId();
	department = DepartmentLocalServiceUtil.getDepartment(departmentId);
	kyHieuVaoSo += "-";
	kyHieuVaoSo += department.getDepartmentsCode();
}catch(Exception e){
}
String dateNow = "";
try{
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	dateNow = simpleDateFormat.format(date);
}catch(Exception e){
}

%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/vanbannoibo/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"/>
	<portlet:param name="workflowAction" value="true"/>
</portlet:actionURL>

<form name="<portlet:namespace/>fm" action="<%=add %>"  enctype="multipart/form-data" method="post">

<div class="title_categ"><liferay-ui:message key="tiep-nhan-van-ban-noi-bo"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
		<td><label><liferay-ui:message key="so-vao-so-vbnb"/>:</label></td>
		<td>
			<input type="text" readonly="readonly" name="<portlet:namespace/>soVaoSo" value="<%= (vanBanNoiBo != null) ? vanBanNoiBo.getSoVanBanNoiBo() : sttVanbanNoiBo + "/" + kyHieuVaoSo %>">
		</td>
		<td width="18%"><div align="left"><label><liferay-ui:message key="nguoi-ky-vbnb"/>:</label></div></td>
		<td width="32%">
	    	<select name="<portlet:namespace/>nguoiKy" style="width:96%">
	    	<% for(PmlUser pmlUser : listUsers){ %>
	    		<option value="<%=pmlUser.getUserId()%>" <%=(vanBanNoiBo != null && vanBanNoiBo.getNguoiKy() == pmlUser.getUserId()) ? "selected" : "" %>><%=pmlUser.getFullName() %></option>
	    	<%} %>
	    	</select>
		</td>
	</tr>

  	<tr>
  		<td><liferay-ui:message key="loai-van-ban-vbnb"/>&nbsp;:</td>
  		<td width="32%">
	    	<select name="<portlet:namespace/>loaiVanBan" style="width:96%">
	    	<% for(PmlEdmDocumentType loaiVanBan :listLoaiVanBans){ %>
	    		<option value="<%=loaiVanBan.getDocumentTypeId()%>" <%=(vanBanNoiBo != null && vanBanNoiBo.getLoaiVanBanNoiBo() == loaiVanBan.getDocumentTypeId()) ? "selected" : ""%>><%=loaiVanBan.getDocumentTypeName() %></option>
	    	<%} %>
	    	</select>
		</td>
		<td ><liferay-ui:message key="ngay-ky-vbnb"/>&nbsp;:</td>
		<td>
			<input value="<%=dateNow %>" name="<portlet:namespace/>ngayKy" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 140px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
			<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
		</td>
  	</tr>
    
    <tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="trich-yeu-vbnb"/><font color="red">(*)</font> &nbsp;:
		</td>
		<td colspan="3" valign="top">
		   	<textarea name="<portlet:namespace/>trichYeu" rows="2" style="width:98.9%"><%= (vanBanNoiBo != null) ? vanBanNoiBo.getTrichYeu() : "" %></textarea>
		</td>
  	</tr>	
  	
  	<tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="ghi-chu-vbnb"/> &nbsp;:
		</td>
		<td colspan="3" valign="top">
		   	<textarea name="<portlet:namespace/>ghiChu" rows="2" style="width:98.9%"><%=(vanBanNoiBo != null) ? vanBanNoiBo.getGhiChu() : "" %></textarea>
		</td>
  	</tr>
</table>

<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="van-ban-noi-bo-toan-van"/></legend>
		
		<%
		String linkFileDinhKem = "";
		String fileDinhKems = "";
	  	for(FileDinhKemVanBanNoiBo fileDinhKem : fileDinhKemVanBanNoiBos){
	  			fileDinhKems += fileDinhKem.getFileDinhKemVanBanNoiBoId() +"_";
				String path = fileDinhKem.getDuongDanFile();
				String title = (String)fileDinhKem.getTenFileFull().subSequence(0,fileDinhKem.getTenFileFull().indexOf("_"));
				long fileDinhKemId = fileDinhKem.getFileDinhKemVanBanNoiBoId();
				String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirmSend('"+ fileDinhKemId +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
					if(!fileDinhKem.getTenFileFull().equals("")){
						linkFileDinhKem = "<a href =" + path + ">" + title + "</a>" + deleteAction;
					}
		%>
		<%=linkFileDinhKem %>
		<%} %>
		<input type="hidden" name="fileDinhKems" value="<%=fileDinhKems%>">
		
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="van-ban-noi-bo-tieu-de" /></td>
		    	<td width="50%"><liferay-ui:message key="van-ban-noi-bo-ten-tap-tin" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="them-van-ban-noi-bo" />' onclick="uploadResultFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
</fieldset>

<div align="right" id="table-button">
	<input type="hidden" name="<portlet:namespace/>luu" id="luu" value="" />
 	<input id="redirect" name="<portlet:namespace/>redirect" type="hidden">
   	<input type="button" value='<liferay-ui:message key="luu-va-xu-ly"/>' name="luuVaXuLy" onclick="return checkValidate()">	    	
    <input type="submit"  value='<liferay-ui:message key="luu" />' onclick="return checkValidate()">
    <input type="reset" value='<liferay-ui:message key="reset" />' onclick="changeDocumentRecordType()">
    <input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
</div>    
</form>