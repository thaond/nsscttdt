<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/onedoorpcccprocess/js/onedoorpcccprocess-js.jsp" %>

<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.model.PmlProcessDispose"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO"%>


<%@page import="com.sgs.portlet.onedoorpcccprocess.searchresult.PmlOneDoorReceiveFileSearchResult"%><link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccprocess/css/style.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccprocess/css/ex.css" />
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>

<style type="text/css">
	 td{
	 	border-right:1 solid #c0c0c0
	 }
	 div#tipDiv {
	    padding:4px;
	    color:#000; font-size:11px; line-height:1.2;
	    background-color:#E1E5F1; border:1px solid #667295; 
	    width:auto; 
	}
</style>

<script type="text/javascript">
	window.onload = function () {
		checkonchangBR33();
		if (document.getElementById('<portlet:namespace/>beginDate') != null) {
			callCalendar('<portlet:namespace/>beginDate','cal-button-beginDate');
		}
		
		if (document.getElementById('<portlet:namespace/>endDate') != null) {
			callCalendar('<portlet:namespace/>endDate','cal-button-endDate');
		}
	}
	function <portlet:namespace/>viewDetail(detailURL) 
	{
		jQuery('#dropper').show();
		jQuery('#<portlet:namespace/>buttontask').show();
		jQuery('#<portlet:namespace/>divcontent2').load(detailURL);
		jQuery('#<portlet:namespace/>divcontent2').show();
		jQuery('#div-empty').hide();
	}
</script>

<%
	String dataForSearch = (String)renderRequest.getAttribute("dataForSearch");
			
	String type = (String) renderRequest.getAttribute("type");
	String valueType = (String) renderRequest.getAttribute("valueType");
	String beginDateParam = (String) renderRequest.getAttribute("beginDateParam");
	String endDateParam = (String) renderRequest.getAttribute("endDateParam");
	
	String fileTypeFilter = renderRequest.getAttribute("fileTypeFilter") != null ? (String)renderRequest.getAttribute("fileTypeFilter") : "";
	List<PmlFilePcccDTO> receiveFilesDTO = (List<PmlFilePcccDTO>)renderRequest.getAttribute("receiveFilesDTO");
%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/searchresult" />
	<portlet:param name="dataForSearch" value="<%= dataForSearch%>" />
</portlet:actionURL>
<div class="title_categ"><liferay-ui:message key="danh-sach-ket-qua-tim-kiem"/></div>
<div class="boxcontent">
	<div class="HS-height">
		<div id="listdivpccc">
			<div id="listdiv" >
				<table cellpadding="0" cellspacing="0">
				<tr>
					<td width="85%">
					<form id="filter" action="<%= filter %>" method="post">
						<table width="100%" cellpadding="0" cellspacing="0" style="background: #fff; ">
								<tr>
									<td width="15%" style="padding: 5px; margin-right: 5px;">
										<select onchange="checkonchangBR33(); " name="<portlet:namespace/>type" id="select" style="width: 100%">
											<option  onclick="javascript:submitForm(document.hrefFm,'<%= filter %>');"  value=""><liferay-ui:message key="all" /></option>
											<option <%=("mahoso".equals(type) ? "selected" : "" )%>	value="mahoso"><liferay-ui:message key="pccc-DSHS-mahoso" /></option>
											<option <%=("tenhoso".equals(type) ? "selected" : "" )%> value="tenhoso"><liferay-ui:message key="pccc-TN-tenhoso" /></option>
											<option <%=("loaihoso".equals(type) ? "selected" : "" )%> value="loaihoso"><liferay-ui:message key="pccc-TN-loaihoso" /></option>
											<option <%=("ngayhentrakhach".equals(type) ? "selected" : "" )%> value="ngayhentrakhach"><liferay-ui:message key="pccc-TN-ngayhentrakhach" /></option>
										</select>
									</td>
									<td>
									
										<div id="<portlet:namespace/>comman"  >
											<input onkeypress="enableButton();" height="24" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" style="width: 98%" value="<%=valueType %>" />
										</div>	
										
										<div id="<portlet:namespace/>fileTypeFilterDiv"  style="display: none">
											<select onchange="enableButton()" name="<portlet:namespace/>fileTypeFilter" id="fileTypeFilter" >
												<option value="">[chon]</option>
												<%
													List<PmlFileType> fileTypeListFilter = renderRequest.getAttribute("fileTypeList") != null ? (List<PmlFileType>)renderRequest.getAttribute("fileTypeList") : new ArrayList<PmlFileType>();
													for (int i = 0; i < fileTypeListFilter.size(); i++) {
												%>
													<option <%=(fileTypeFilter.equals(String.valueOf(fileTypeListFilter.get(i).getFileTypeId())) ? "selected" : "" )%>	value="<%= fileTypeListFilter.get(i).getFileTypeId()%>"><%= fileTypeListFilter.get(i).getFileTypeName()%></option>
												<%		
													}
												%>
											</select>
										</div>
								
										<div id="<portlet:namespace/>status" style="display: none">				
											
										</div>	
									
										<div id="<portlet:namespace/>day" style="display: none">
											<label><liferay-ui:message key="pccc-DSHS-ngaybatdau" /></label>	
											<input type="text"  name="<portlet:namespace/>beginDate" id="<portlet:namespace/>beginDate" value="<%= beginDateParam %>" style="width:35" maxlength="10">
						    				<span style="cursor: pointer"><img  id="cal-button-beginDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>beginDate','cal-button-beginDate')"/></span>
						    					
						    				<label><liferay-ui:message key="pccc-DSHS-ngayketthuc" /></label>
						    				<input type="text" name="<portlet:namespace/>endDate" id="<portlet:namespace/>endDate" value="<%= endDateParam %>" style="width:35" maxlength="10">
						    				<span style="cursor: pointer"><img id="cal-button-endDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>endDate','cal-button-endDate')"/></span>
						    			</div>	
									
										
									</td>
									<td width="7%" align="left">
										<input width="100%" height="24"	type="submit" id="<portlet:namespace/>loc" value='<liferay-ui:message key="pccc-DSHS-loc"/>'/>
									</td>
								</tr>
								</table>
					</form>
					</td>
					<td><div align="center"><%@ include file="/html/portlet/ext/onedoorpcccprocess/button.jsp" %></div></td>
				</tr>
			</table>
		</div>	
				<div id="outer-1" class="outer-1">
					<div >
						<table class="taglib-search-iterator table-pml">
						
						<tr class="portlet-section-header results-header" >
							
							<%
								int lastMsgId = renderRequest.getAttribute("lastMsgId") != null ? (Integer)renderRequest.getAttribute("lastMsgId") : 0;
								PortletURL portletURL = renderResponse.createRenderURL();
								portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
								portletURL.setParameter("struts_action", "/sgs/onedoorpcccprocess/searchresult");
								PmlOneDoorReceiveFileSearchResult searchContainer = new PmlOneDoorReceiveFileSearchResult(renderRequest, portletURL);
								searchContainer = renderRequest.getAttribute("pmlOneDoorReceiveFileSearch") != null ? (PmlOneDoorReceiveFileSearchResult)renderRequest.getAttribute("pmlOneDoorReceiveFileSearch") : searchContainer;
								
								List<String> headerNames = searchContainer.getHeaderNames();
								Map orderableHeaders = searchContainer.getOrderableHeaders();
								
								for (int i = 0; (headerNames != null) && (i < headerNames.size()); i++) {
									String headerName = headerNames.get(i);
					
									String orderKey = null;
									String orderByType = null;
									boolean orderCurrentHeader = false;
					
									if (orderableHeaders != null) {
										orderKey = (String)orderableHeaders.get(headerName);
					
										if (orderKey != null) {
											orderByType = searchContainer.getOrderByType();
					
											if (orderKey.equals(searchContainer.getOrderByCol())) {
												orderCurrentHeader = true;
											}
										}
									}
					
									if (orderCurrentHeader) {
										if (orderByType.equals("asc")) {
											orderByType = "desc";
										}
										else {
											orderByType = "asc";
										}
									}
								%>
					
									<th class="col-<%= i + 1 %>">
										<c:if test="<%= orderKey != null %>">
											<a href="<%= searchContainer.getIteratorURL().toString() %>
													&<%= renderResponse.getNamespace() %>orderByCol=<%= orderKey %>
													&<%= renderResponse.getNamespace() %>orderByType=<%= orderByType %>
													&<%= renderResponse.getNamespace() %>sort=sort">

										</c:if>
					
										<c:if test="<%= orderCurrentHeader %>">
											<i>
										</c:if>
					
										<%
										String headerNameValue = LanguageUtil.get(pageContext, headerName);
										%>
					
										<c:choose>
											<c:when test="<%= headerNameValue.equals(StringPool.BLANK) %>">
												<%= StringPool.NBSP %>
											</c:when>
											<c:otherwise>
												<%= headerNameValue %>
											</c:otherwise>
										</c:choose>
					
										<c:if test="<%= orderCurrentHeader %>">
											</i>
										</c:if>
					
										<c:if test="<%= orderKey != null %>">
											</a>
										</c:if>
									</th>
					
								<%
								}
								%>
						</tr>
						
						<%	
							if (receiveFilesDTO == null || receiveFilesDTO.size() == 0) {
						%>
						<tr>
							<td colspan="9" rowspan="4" valign="middle">
								<div style="padding-top: 50px; padding-bottom: 40px" align="center"><liferay-ui:message	key="pccc-TN-khongtontaidulieu" /></div>
							</td>
						</tr>
						<%
							}else {
								if (lastMsgId == 0) {
									
						%>
								<script type="text/javascript">
									function last_msg_funtion()
										{
											var ID=jQuery(".message_box:last").attr("id");
	
											//jQuery('div#last_msg_loader').html('<img src="/html/portlet/ext/onedoorpcccprocess/images/bigLoader.gif">');
											var html = jQuery.ajax({
												  url: "<%= searchContainer.getIteratorURL().toString() %>&last_msg_id=" + ID + "&loadData=true" ,
												  async: false
											}).responseText; 
	
											if (html.indexOf("loaddata1") > 0) {										
												var data=html.substring(html.indexOf("loaddata1") +11, html.indexOf("loaddata2")-13);
												if (data != "") {
													jQuery(".message_box:last").after(data);
												}
											}
											//jQuery('div#last_msg_loader').empty();
										};	
													
									jQuery(document.getElementById('outer-1')).scroll(function(){	
										if (jQuery('div#outer-1').scrollTop() == document.getElementById('outer-1').scrollHeight - jQuery('div#outer-1').height()){
											last_msg_funtion();
										}
									});
															
								</script>	
							
						<%		
						  		for (int i = 1; i <= receiveFilesDTO.size(); i++) {
							  		PmlFilePcccDTO file = receiveFilesDTO.get(i-1);
							  		String stype = "";	
									if (i % 2 == 0){
										stype = "row4";
									}
									else {
										stype = "row3";
									}
						%>
						
						<tr  id="<%= String.valueOf(i) %>" onMouseOut="nofocusColor(this)" onMouseOver="focusColor2(this)"	class="<%= stype %> message_box">
							<td style="color: #131313; background-color: #dbeafc" nowrap="nowrap" class="td-stt-pml">
								<div align="center"><%=i%>.&nbsp; 
								<%
									DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							    	Date date = new Date ();
							    	String cdate = dateFormat.format(date);
							    	Date d1 = dateFormat.parse(cdate);
							    	Date d2 = null;
							    	try {
							    		d2 = dateFormat.parse(dateFormat.format(file.getExpireDate()));
							    	} catch (Exception e) {}
							    	
							    	if (null != d2) {
								    	if (d1.equals(d2)){
									%> 
									<img src="/html/images/pink.gif"></div>
								</td>
									<%
										}
										if(d1.after(d2)){
									%>
									<img src="/html/images/red.gif"></div>
								</td>
									<%
								    	}
										if(d1.before(d2)){
									%>
									<img src="/html/images/blue.gif"></div>
								</td>
									<%
										}
									}
							    %>
						
						<portlet:renderURL var="detail"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="struts_action"	value="/sgs/onedoorpcccprocess/detail" />
							<portlet:param name="fileId" value="<%=file.getFileId() %>" />
						</portlet:renderURL>
						
							<td class="td-stt-pml"><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail%>');"><%=file.getNumberReceipt() %></a></td>
							<td class="td-stt-pml"><%=file.getFileName() %></td>
							<td class="td-stt-pml"><%=file.getFiletype() %></td>
							<td class="td-stt-pml"><%=file.getStatus() %></td>
							<td class="td-stt-pml"><%=(file.getApplicationDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getApplicationDate()) : "" %></td>
							<td class="td-stt-pml"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
						</tr>
							
							<%} %>
								
						<%	} else {%>
						<div id="loaddata1">
						
						<%		for (int i = 1 + lastMsgId; i <= receiveFilesDTO.size()+lastMsgId; i++) {
						  		PmlFilePcccDTO file = receiveFilesDTO.get(i-1-lastMsgId);
						  		String stype = "";	
								if (i % 2 == 0){
									stype = "row4";
								}
								else {
									stype = "row3";
								}
					%>
					
							<tr id="<%= String.valueOf(i) %>" onMouseOut="nofocusColor(this)" onMouseOver="focusColor2(this)"	class="<%= stype %> message_box">
								<td style="color: #131313; background-color: #dbeafc" nowrap="nowrap" class="td-stt-pml">
									<div align="center"><%=i%>.&nbsp; 
									<%
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								    	Date date = new Date ();
								    	String cdate = dateFormat.format(date);
								    	Date d1 = dateFormat.parse(cdate);
								    	Date d2 = null;
								    	try {
								    		d2 = dateFormat.parse(dateFormat.format(file.getExpireDate()));
								    	} catch (Exception e) {}
								    	
								    	if (null != d2) {
									    	if (d1.equals(d2)){
										%> 
										<img src="/html/images/pink.gif"></div>
									</td>
										<%
											}
											if(d1.after(d2)){
										%>
										<img src="/html/images/red.gif"></div>
									</td>
										<%
									    	}
											if(d1.before(d2)){
										%>
										<img src="/html/images/blue.gif"></div>
									</td>
										<%
											}
										}
								    %>
							
							<portlet:renderURL var="detail1"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="struts_action"	value="/sgs/onedoorpcccprocess/detail" />
								<portlet:param name="fileId" value="<%=file.getFileId() %>" />							
							</portlet:renderURL>
							
								<td class="td-stt-pml"><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail1%>');"><%=file.getNumberReceipt() %></a></td>
								<td class="td-stt-pml"><%=file.getFileName() %></td>
								<td class="td-stt-pml"><%=file.getFiletype() %></td>
								<td class="td-stt-pml"><%=file.getStatus() %></td>
								<td class="td-stt-pml"><%=(file.getApplicationDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getApplicationDate()) : "" %></td>
								<td class="td-stt-pml"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
							</tr>
							
					<%	} %>
					<div id="last_msg_loader"></div>
					</div><div id="loaddata2"></div>
					<%}}%>
						</table>
					</div>
				</div>
			</div>
			
			<div id="dropper" style="display: none;">
				<table width="100%" bgcolor="#dbeafc" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="7" align="center" style="height: 4px">
							<div>
								<img onClick="displayAndHidden()" style="cursor: pointer;"	src="/html/images/showfull.gif">
							</div>
						</td>
					</tr>
				</table>
				
				<div id="div-empty">
					<table  border="1" >
						<tr>
							<td id="empty-border"  class="empty-table"></td>
						</tr>
					</table>
				</div>
			</div>
	
	<!-- detail information document -->
		<div id="<portlet:namespace/>divcontent2" class="outer-2" style="display: none;"></div>
		<div id="<portlet:namespace/>buttontask" style="display: none"></div>
	</div>	
</div>	
