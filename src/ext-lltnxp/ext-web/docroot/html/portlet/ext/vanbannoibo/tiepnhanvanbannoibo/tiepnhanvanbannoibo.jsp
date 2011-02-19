<%@page import="com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo"%>
<%@page import="com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoUtil"%>
<%@ include file="/html/portlet/ext/vanbannoibo/tiepnhanvanbannoibo/js/tiep_nhan.jsp" %>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

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
<%@page import="com.sgs.portlet.vanbannoibo.workflow.VanBanNoiBoPortletAction"%>
<%@page import="com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalServiceUtil"%>
<%@page import="com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"%>

<%
String dateNow = "";
Date date = new Date();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
try{
	dateNow = simpleDateFormat.format(date);
}catch(Exception e){
}

int year = date.getYear() + 1900;
List<VanBanNoiBo> vanBanNoiBoByYears = VanBanNoiBoLocalServiceUtil.getVanBanNoiBoByYear(year);
//int sttVanbanNoiBo = VanBanNoiBoLocalServiceUtil.getVanBanNoiBosCount() + 1;
int sttVanbanNoiBo = vanBanNoiBoByYears.size() + 1;

List<PmlUser> listUsers = PmlUserLocalServiceUtil.getPmlUsers(-1,-1);
//List<PmlEdmDocumentType> listLoaiVanBans = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentTypes(-1,-1);

VanBanNoiBo vanBanNoiBo = (VanBanNoiBo) request.getAttribute("vanBanNoiBo");
List<FileDinhKemVanBanNoiBo> fileDinhKemVanBanNoiBos = new ArrayList<FileDinhKemVanBanNoiBo>();

String dateCreateString = "";
if(vanBanNoiBo != null){
	fileDinhKemVanBanNoiBos = VanBanNoiBoLocalServiceUtil.getFileDinhKemVanBanNoiBos(vanBanNoiBo.getVanBanNoiBoId());
	Date dateCreate = vanBanNoiBo.getNgayKy();
	dateCreateString = simpleDateFormat.format(dateCreate);
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
long soVanBanId = 0;
List<LoaiVanBanNoiBo> loaiVanBanNoiBos = new ArrayList<LoaiVanBanNoiBo>();
List<SoVanBanNoiBo> soVanBanNoiBos = soVanBanNoiBos = SoVanBanNoiBoLocalServiceUtil.getSoVanBanNoiBos(-1,-1);
try{
	soVanBanId = (Long) request.getAttribute("soVanBanId");
	List<SoLoaiVanBanNoiBo> soLoaiVanBanNoiBos = SoLoaiVanBanNoiBoUtil.findBySoVanBanNoiBo(soVanBanId);
	for(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : soLoaiVanBanNoiBos){
		LoaiVanBanNoiBo loaiVBNB = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBo(soLoaiVanBanNoiBo.getLoaiVanBanNoiBoId());
		loaiVanBanNoiBos.add(loaiVBNB);
	}		
}catch(Exception e){
}
if(vanBanNoiBo != null && soVanBanId == 0){
	soVanBanId = vanBanNoiBo.getSoVanBanNoiBo();
}
System.out.println("soVanBanId ++++++++++ "+soVanBanId);
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/vanbannoibo/tiepnhanvanbannoibo" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"/>
	<portlet:param name="workflowAction" value="true"/>
	<portlet:param name="workflowActionName" value='<%=VanBanNoiBoPortletAction.COMMAND_PREFIX + ".AddVanBanNoiBoCommand"%>'/>
</portlet:actionURL>

<form name="<portlet:namespace/>fm" action="<%=add %>"  enctype="multipart/form-data" method="post">
<input name="<portlet:namespace/>fileDinhKemVanBanNoiBoId" type="hidden" value="" />
<input type="hidden" name="<portlet:namespace/>vanBanNoiBoId" value="<%=(vanBanNoiBo != null) ? String.valueOf(vanBanNoiBo.getVanBanNoiBoId()) : "" %>"> 

<div class="title_categ"><liferay-ui:message key="tiep-nhan-van-ban-noi-bo"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
		<td><label><liferay-ui:message key="so-vao-so-vbnb"/>:</label></td>
		<td>
			<input type="text" readonly="readonly" name="<portlet:namespace/>soVaoSo" value="<%= (vanBanNoiBo != null) ? vanBanNoiBo.getSoVaoSoVanBanNoiBo() : sttVanbanNoiBo + "/" + kyHieuVaoSo %>">
		</td>
		<td><div align="left"><label><liferay-ui:message key="nguoi-ky-vbnb"/>:</label></div></td>
		<td>
	    	<select name="<portlet:namespace/>nguoiKy" style="width:96%">
	    	<% for(PmlUser pmlUser : listUsers){ %>
	    		<option value="<%=pmlUser.getUserId()%>" <%=(vanBanNoiBo != null && vanBanNoiBo.getNguoiKy() == pmlUser.getUserId()) ? "selected" : "" %>><%=pmlUser.getFullName() %></option>
	    	<%} %>
	    	</select>
		</td>
		<td><liferay-ui:message key="ngay-ky-vbnb"/>&nbsp;:</td>
		<td>
			<input value="<%= (!("").equals(dateCreateString)) ? dateCreateString : dateNow %>" name="<portlet:namespace/>ngayKy" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 140px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
			<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
		</td>
	</tr>

  	<tr>
  		<td><liferay-ui:message key="so-van-ban-vbnb"/>&nbsp;:</td>
  		<td>
	    	<select name="<portlet:namespace/>soVanBan" style="width:96%">
	    	<option value=""/>
	    	<% for(SoVanBanNoiBo soVanBanNoiBo : soVanBanNoiBos){ %>
	    		<option onclick="selectSoVanBanNoiBo()" value="<%=soVanBanNoiBo.getSoVanBanNoiBoId()%>" <%=(soVanBanId != 0 && soVanBanId == soVanBanNoiBo.getSoVanBanNoiBoId()) ? "selected" : ""%>><%=soVanBanNoiBo.getTenSoVanBanNoiBo() %></option>
	    	<%} %>
	    	</select>
		</td>
  		<td><liferay-ui:message key="loai-van-ban-vbnb"/>&nbsp;:</td>
  		<td>
	    	<select name="<portlet:namespace/>loaiVanBan" style="width:96%">
	    	<% for(LoaiVanBanNoiBo loaiVanBanNoiBo : loaiVanBanNoiBos){ %>
	    		<option value="<%=loaiVanBanNoiBo.getLoaiVanBanNoiBoId()%>" <%=(vanBanNoiBo != null && vanBanNoiBo.getLoaiVanBanNoiBo() == loaiVanBanNoiBo.getLoaiVanBanNoiBoId()) ? "selected" : ""%>><%=loaiVanBanNoiBo.getTenLoaiVanBanNoiBo() %></option>
	    	<%} %>
	    	</select>
		</td>
		<td></td>
		<td></td>
  	</tr>
    
    <tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="trich-yeu-vbnb"/><font color="red">(*)</font> &nbsp;:
		</td>
		<td colspan="5" valign="top">
		   	<textarea name="<portlet:namespace/>trichYeu" rows="2" style="width:98.9%"><%= (vanBanNoiBo != null) ? vanBanNoiBo.getTrichYeu() : "" %></textarea>
		</td>
  	</tr>	
  	
  	<tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="ghi-chu-vbnb"/> &nbsp;:
		</td>
		<td colspan="5" valign="top">
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
	<input type="hidden" name="<portlet:namespace/>selectSoVanBanNoiBo" id="selectSoVanBanNoiBo" value="" />
	<input type="hidden" name="<portlet:namespace/>deleteFile" id="deleteFile" value="" />
	<input type="hidden" name="<portlet:namespace/>luu" id="luu" value="" />
 	<input id="redirect" name="<portlet:namespace/>redirect" type="hidden">
   	<input type="button" value='<liferay-ui:message key="luu-va-xu-ly"/>' name="luuVaXuLy" onclick="return checkValidate()">	    	
    <input type="submit"  value='<liferay-ui:message key="luu" />' onclick="return checkValidate()">
    <input type="reset" value='<liferay-ui:message key="reset" />' onclick="changeDocumentRecordType()">
    <input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
</div>    
</form>

<script type="text/javascript">
	function deleteConfirmSend(fileDinhKemVanBanNoiBoId) {
		document.<portlet:namespace/>fm.<portlet:namespace/>fileDinhKemVanBanNoiBoId.value = fileDinhKemVanBanNoiBoId;
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			sendDelete();
		}
	}
	
	function sendDelete(){
		document.<portlet:namespace/>fm.<portlet:namespace/>deleteFile.value = "deleteFile";
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/vanbannoibo/tiepnhanvanbannoibo" />
			<portlet:param name="<%=Constants.CMD%>" value="DELETEFILEATTACT" />
			</portlet:actionURL>");
	}
	
	function selectSoVanBanNoiBo(){
		document.<portlet:namespace/>fm.<portlet:namespace/>selectSoVanBanNoiBo.value = "selectSoVanBanNoiBo";
		document.<portlet:namespace/>fm.<portlet:namespace/>luu.value = "luu";
		submitForm(document.<portlet:namespace/>fm,
				"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
				<portlet:param name="struts_action" value="/sgs/vanbannoibo/tiepnhanvanbannoibo" />
				<portlet:param name="<%=Constants.CMD%>" value="SELECTSOVANBANNOIBO" />
				</portlet:actionURL>");
	}
</script>