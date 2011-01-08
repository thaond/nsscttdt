<%@ include file="/html/portlet/ext/onedoorpccc/init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp"></liferay-util:include>
<%
	Date date = new Date();
	long datetime = date.getTime() + (long) 7*60*60*1000; //cong them mui gio
	String txt_TimeStart = new SimpleDateFormat("hh:mm:ss").format(datetime); //thoi gian nop ho so
	String txt_DateStart = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay nop ho so
	
	String txt_DateInput= new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //ngay nhap lieu
	String message = (String)renderRequest.getAttribute("message");
%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<jsp:useBean id="listFileType" type="java.util.List" scope="request"></jsp:useBean>
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/onedoorpccc/add" />
	<portlet:param name="<%=Constants.CMD %>" value="<%Constants.ADD %>" />
	<portlet:param name="workflowAction" value="true" />
	<portlet:param name="workflowActionName"
		value='<%=OneDoorProcessPortletAction.COMMAND_PREFIX + ".AddFileCommand"%>' />
</portlet:actionURL>
<script type="text/javascript">
window.onload = function () {
	document.getElementById('btn_DocType').focus();	
	startTime();
}
</script>
<form action="<%=add %>" name="fm_tiepnhan" method="post" onSubmit="return validateDocReceipt()">
<div class="title_categ"><liferay-ui:message key="tiep-nhan-ho-so"/></div>
<div class="boxcontent" onclick="parent_disable();">
<fieldset class="filnoborder_div">
<ul>
	<li style="width: 49.6%; margin-right: 0.8%" >
	<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message	key="pccc-TN-thongtinhoso" /></label>			
						<table cellspacing="0" width="100%" class="bor_rgh">						
							<tr>
								<td width="33%" class="width-label"><label><liferay-ui:message key='pccc-TN-loaihoso' /> <font color="#FF0000" size="1">(*)</font>:</label></td>
								<td width="66%">										
								<table width="100%" cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td width="83%"><input type="text" id="fileTypeIdName"	readonly name="<portlet:namespace />fileTypeName" style="width: 95%"> 
											<input type="hidden" id="fileTypeId" name="<portlet:namespace />fileTypeId" style="width: 95%">
											</td>
											<td width="16%" align="right" style="padding-right: 2px;"><input id="btn_DocType" type="button" value="..." style="width: 95%"	onClick="mypopup()"></td>
										</tr>
									</table>
								</td>
							</tr>
							
							<tr>
								<td class="width-label">
								<label><liferay-ui:message	key='pccc-TN-sobiennhan' /><font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input type="text" id="numberReceipt" name="<portlet:namespace />numberReceipt" style="width: 97%" readonly value="[Auto]"></td>
							</tr>
							
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-tenhoso' /> <font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input id="fileName" name="<portlet:namespace />fileName" type="text" style="width: 97%"></td>
							</tr>
							<!-- End OK -->
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-nguoigiaohoso' /><font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input id="applicationName"	name="<portlet:namespace />applicantName" type="text" style="width: 97%"></td>
							</tr>
							
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-daidiendonvi' />:</label></td>
								<td><input id="applicantRepresentation"	name="<portlet:namespace />applicantRepresentation" type="text"	style="width: 97%"	value='<liferay-ui:message key='pccc-TN-daidienchudautu'/>'	maxlength="200"></td>
							</tr>
							
							<tr>
								<td class="width-label"><label><liferay-ui:message key='pccc-TN-diachi' />:</label></td>
								<td><input id="permanentAddress" name="<portlet:namespace />permanentAddress" type="text" style="width: 97%"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-dienthoai' />:</label></td>
								<td><input maxlength="15" id="applicantTelephone"	name="<portlet:namespace />applicantTelephone" type="text"	style="width: 97%" /></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-nguoinhanhoso' />:</label></td>
								<td><input id="receiverUnit" name="<portlet:namespace />receiverUnit" type="text" style="width: 97%" maxlength="50"></td>
							</tr>
							<tr style="display: none;">
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-daidiendonvi' />:</label></td>
								<td><input id="receiverRepresentation"	name="<portlet:namespace />receiverRepresentation" type="text"	style="width: 97%"	value='<liferay-ui:message key='pccc-TN-doihuongdan'/>'></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-dienthoai' />:</label></td>
								<td><input maxlength="15" id="receiverTelephone" name="<portlet:namespace />receiverTelephone" type="text"	style="width: 97%" /></td>
							</tr>
							
			</table>
			</fieldset>
			
			<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message key="pccc-TN-hosothietke" /></label>
						<table cellspacing="0" width="100%" class="bor_rgh">						
							<tr>
								<td width="33%" class="width-label"><label><liferay-ui:message	key='pccc-TN-congtrinh' />:</label></td>
								<td width="66%"><input id="projectName"	name="<portlet:namespace />projectName" type="text"	style="width: 97%" maxlength="100"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-hangmuc' />:</label></td>
								<td><input id="applicantCategory"
									name="<portlet:namespace />applicantCategory" type="text"
									style="width: 97%" maxlength="200"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-diadiemxaydung' />:</label></td>
								<td><input id="addressBuilder"
									name="<portlet:namespace />addressBuilder" type="text"
									style="width: 97%" maxlength="200"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-chudautu' /> <font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input id="investor"
									name="<portlet:namespace />investor" type="text"
									style="width: 97%" maxlength="100"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-donvithietke' />:</label></td>
								<td><input id="designCop"
									name="<portlet:namespace />designCop" type="text"
									style="width: 97%" maxlength="200"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-sobohoso' />:</label></td>
								<td><input id="txt_DocNum"
									name="<portlet:namespace />fileNumber" type="text"
									style="width: 97%" maxlength="30"></td>
							</tr>
						</table>
			</fieldset>
	</li>
	<li style="width: 49.6%;">
		<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message	key="pccc-TN-thongtinquanly" /></label>
						<table cellspacing="0" width="100%" class="bor_rgh">						
							<tr>
								<td width="37%" class="width-label"><label><liferay-ui:message	key='pccc-TN-thoigiannophoso' /> <font color="#FF0000" size="1">(*)</font>:</label></td>
								<td width="62%"><input id="applicantTime"
									name="<portlet:namespace />applicantTime" type="text"
									class="width-input-tn" value=""></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-ngaynophoso' /> <font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input id="applicationDate"
									name="<portlet:namespace />applicationDate" type="text"	onkeyup="getDateReturnWhenapplicationDateOnchange()"
									class="width-input-tn" value="<%= txt_DateStart %>"> 
									<input	id="applicationDateHidden" type="hidden" value="<%= txt_DateStart %>"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-ngayhentrakhach' /><font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input type="text" 	class="width-input-tn" id="expectedReturningDate" name="<portlet:namespace />expectedReturningDate"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message	key='pccc-TN-nguoitiepnhan' /> <font color="#FF0000">(*)</font>:</label></td>
								<td>
								<%
										User loginUser = PortalUtil.getUser(renderRequest);
										String userName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
									%> <input type="hidden" name="<portlet:namespace />receiver"
									value="<%=String.valueOf(loginUser.getUserId()) %>"> <input
									id="receiver" name="<portlet:namespace />receiver" type="text"
									class="width-input-tn" readonly value="<%=userName %>"></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-ngaynhaplieu' /><font color="#FF0000" size="1">(*)</font>:</label></td>
								<td><input id="inputDataDate" name="<portlet:namespace />inputDataDate" type="text"
									class="width-input-tn" value="<%= txt_DateStart %>"></td>
							</tr>
							<tr>
								<td valign="top" class="width-label"><label><liferay-ui:message
									key='pccc-TN-ghichu' />:</label></td>
								<td><textarea id="noteinformationManagement"
									name="<portlet:namespace />noteinformationManagement"
									class="width-input-tn" style="width: 95%"></textarea></td>
							</tr>
						</table>
			</fieldset>
						
			<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message	key="pccc-TN-thongtinthamkhao" /></label>
						<table cellspacing="0" width="100%" class="bor_rgh">						
							<tr>
								<td width="37%" class="width-label"><label ><liferay-ui:message key='pccc-TN-tongsogioxuly' />:</label></td>
								<td  width="62%"><input id="totalHour"
									name="<portlet:namespace />totalHour" type="text"
									style="width: 40%" readonly /> <span>&nbsp; <liferay-ui:message
									key='pccc-TN-gio-lam-viec' /> </span></td>
							</tr>
							<tr>
								<td class="width-label"><label><liferay-ui:message
									key='pccc-TN-tongsongayxuly' /></label>:</td>
								<td ><input id="totalDate"
									name="<portlet:namespace />totalDate" type="text"
									style="width: 40%" readonly /> <span>&nbsp; <liferay-ui:message
									key='pccc-TN-ngay-lam-viec' /> </span></td>
							</tr>
						</table>
			</fieldset>	
						
			<fieldset class="filborder">
						<label class="laborder"><liferay-ui:message	key="pccc-TN-ketluanvehosothamduyet" /></label>
						<table cellspacing="0" width="100%" class="bor_rgh">
							<tr>
								<td width="37%" valign="top" class="width-label"><LABEL><liferay-ui:message
									key='pccc-TN-ketluan' />:</LABEL></td>
								<td><textarea id="conclusion"	name="<portlet:namespace />conclusion" class="width-input-tn" style="width: 95%"></textarea></td>
							</tr>
						</table>
			</fieldset>

	</li>
</ul>

<ul>
	<li style="width: 100%">
	<fieldset class="filborder">
			<label class="laborder" style="float: left;">
			<span onclick="showhideAttachfile()" style="float: left;">
					<div id="up"><img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/up.png" /></div>
					<div id="down" style="display: none;"><img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/down.png" /></div>
			</span>
				<a class="style-top-title" onclick="showhideAttachfile()" style="float: left;padding: 2px 0 0 10px;cursor: pointer;"><liferay-ui:message key='pccc-TN-hosodinhkemtudongchon' /></a>
			</label>
			<div id="div-title">
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%" style="float: left;">	
					<tr class="portlet-section-header results-header" >
						<td width='4%' scope='row'>
								<div align='center'><liferay-ui:message
									key='sgs_onedoor_no.' /></div>
						</td>
						<td width='3%'>
								<div align='center'>##</div>
						</td>
								<td width='50%'>
								<div><liferay-ui:message
									key='sgs_onedoor_attached_file_name' /></div>
								</td>
								<td width='10%'>
								<div align='center'><liferay-ui:message
									key='sgs_onedoor_original' /></div>
								</td>
								<td width='10%'>
								<div align='center'><liferay-ui:message
									key='sgs_onedoor_copy' /></div>
								</td>
								<td>
								<div ><liferay-ui:message
									key='sgs_onedoor_note' /></div>
								</td>
							</tr>
				</table>
				</div>
				<div id="rowDocument" ></div>
		</fieldset>
	</li>
</ul>
<ul>
	<li style="width: 100%" id="DocDrawing">
							<!-- <table id="tbl_DocDrawing" align="center" cellpadding="0" cellspacing="1" width="100%" border="0" style="border:solid 1px #A3B2CC" > 
							<tr class="table-header" align="center">
								<td width="40px">&nbsp; <liferay-ui:message key='pccc-TN-stt'/> &nbsp;</td>
								<td width="63%"><liferay-ui:message key='pccc-TN-tentailieubanve'/></td>
								<td width="10%"><liferay-ui:message key='pccc-TN-soluong'/></td>
								<td><liferay-ui:message key='pccc-TN-ghichu'/></td>
								<td width="4%"><liferay-ui:message key='pccc-TN-xoa-'/></td>
							</tr>	
							<tr align="center">
							  <td colspan="5" width="100%" align="left">
								<input type="button" value='<liferay-ui:message key="pccc-TN-themdulieu"/>' onclick="addRow()"></td>									
							</tr>
						</table>
						-->
			<fieldset class="filborder">
			<label class="laborder" style="float: left;">
				<span onclick="showHideDrawFile()" style="float: left;">
					<div id="up-bv"><img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/up.png" /></div>
					<div id="down-bv" style="display: none;">
						<img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/down.png" />
					</div>
				</span>
				<a class="style-top-title"	onclick="showHideDrawFile()" style="float: left;padding: 2px 0 0 10px;cursor: pointer;">
					<liferay-ui:message key="pccc-TN-tailieubanve" />
				</a>
			</label>
				<div id="div-draw">
					<table id="adddraw" class="taglib-search-iterator table-pml" cellspacing="0" width="100%" style="float: left;border-right: 1px solid #60BFFC;">	
					<tr class="portlet-section-header results-header" >
									<td width='4%'><liferay-ui:message key='pccc-TN-stt' /></td>
									<td width="60%"><liferay-ui:message	key='pccc-TN-tentailieubanve' /></td>
									<td width="10%"><liferay-ui:message key='pccc-TN-soluong' /></td>
									<td colspan="2" width="40%"><liferay-ui:message key='pccc-TN-ghichu' /></td>
									
					</tr>
					<tr>
									<td colspan="5" width="100%" align="right">
									<input	type="button" value='<liferay-ui:message key="pccc-TN-themdulieu"/>' onclick="uploadReceiptfile()"></td>
					</tr>
					</table>
				</div>
				<div id="docDrawingDiv"></div>
			</fieldset>
			<input type="hidden" name="<portlet:namespace/>listNameRow"
								id="listNameRow" value="" /> <input type="hidden"
								name="<portlet:namespace/>drawName" id="valueNameFile" value="" />
			<input type="hidden" name="<portlet:namespace/>quantity"
								id="soluong" value="" /> <input type="hidden"
								name="<portlet:namespace/>note" id="notedraw" value="" />
       </li>
</ul>
<ul>
	<li style="width: 100%">
	<fieldset class="filborder">
			<label class="laborder" style="float: left;">
			<span onclick="showHideSortFile()" style="float: left;">
					<div id="up-st"><img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/up.png" /></div>
					<div id="down-st" style="display: none;">
						<img style="cursor: pointer;" src="/html/themes/sgs-portal-skin/images/imgbasic/down.png" />
					</div>
				</span>
				<a class="style-top-title"	onclick="showHideSortFile()" style="float: left;padding: 2px 0 0 10px;cursor: pointer;">
					<liferay-ui:message	key='pccc-TN-trinhtuxuly' />
				</a>
			</label>
			<div id="div-sort">
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%" style="float: left;border-right: 1px solid #60BFFC;">	
					<tr class="portlet-section-header results-header" >
								<td nowrap width='4%'>
								<div align='center' ><liferay-ui:message
									key='pccc-TN-stt' /></div>
								</td>
								<td width='38%'>
								<div ><liferay-ui:message
									key='pccc-TN-tenbuoc' /></div>
								</td>
								<td nowrap width='20%'>
								<div align='center'><liferay-ui:message
									key='pccc-TN-thoigianxuly' /></div>
								</td>
								<td nowrap width='38%'>
								<div><liferay-ui:message
									key='pccc-TN-ghichu' /></div>
								</td>
							</tr>
							<!-- <tr>	
					<td id="ProcessList" colspan="4">
								
					</td>
				</tr> -->
			</table>
			</div>
			<div id="trinhtuxuly"></div>
	</fieldset>
	</li>
</ul>					
	
		<%
		PortletURL currentURL = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 91464, PortletRequest.RENDER_PHASE);
		currentURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
		currentURL.setParameter("isProcess", "1");
		currentURL.setPortletMode(PortletMode.VIEW);
		currentURL.setWindowState(WindowState.NORMAL);		
		%> 
		<input id="redirect" name="<portlet:namespace/>redirect" type="hidden">

<div id="table-button" style="float: right;">
				<input type="hidden" id="listnamepaint" name="<portlet:namespace />listnamepaint" value="onedoorpcccprocess" /> 
				<input type="hidden" id="listAttachFileId" name="<portlet:namespace />listAttachFileId" value="onedoorpcccprocess" />			 
				<input type="button" class="button" value='<liferay-ui:message key='pccc-TN-xulyhoso'/>' name="xuly" onclick="return processButton('<%=currentURL.toString() %>')">
				<input type="submit" class="button" value='<liferay-ui:message key='pccc-TN-luuhoso'/>' name="luu">
				<input onclick="resetData()" type="button" class="button" value='<liferay-ui:message key='pccc-TN-xoahoso'/>' name="luu">
</div>
</div>
</form>
<%	
	if ("success".equals(message)) {
%>
<script type="text/javascript">
	alert("<liferay-ui:message key='pccc-TN-thanh-cong'/>");
</script>
<%
	}
%>