<%@ include file="/html/portlet/nss/onedoorreturn/init.jsp" %>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.onedoorreturn.search.PmlFileReturnSearch"%>

<liferay-util:include page="/html/portlet/nss/onedoorreturn/js/onedoorreturn-js.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/nss/onedoorreturn/css/ex.css" />
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>

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
	}
	 
</script>

<%
	long userId = PortalUtil.getUserId(renderRequest);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	PortletURL portletURLView = renderResponse.createRenderURL();
	portletURLView.setWindowState(WindowState.NORMAL);
	portletURLView.setParameter("struts_action","/nss/onedoorreturn/view");
	
	List<PmlFilePcccDTO> listFileDTO = (List<PmlFilePcccDTO>)renderRequest.getAttribute("listFileDTO");
	
	String sort = (String) renderRequest.getAttribute("sort");
	boolean loadData = (Boolean) renderRequest.getAttribute("loadData");
	String type = (String) renderRequest.getAttribute("type");
	String valueType = (String) renderRequest.getAttribute("valueType");
	String beginDateParam = (String) renderRequest.getAttribute("beginDateParam");
	String endDateParam = (String) renderRequest.getAttribute("endDateParam");	
	
	List<PmlFileType> fileTypeListFilter = renderRequest.getAttribute("fileTypeList") != null ? (List<PmlFileType>)renderRequest.getAttribute("fileTypeList") : new ArrayList<PmlFileType>();
	String fileTypeFilter = renderRequest.getAttribute("fileTypeFilter") != null ? (String)renderRequest.getAttribute("fileTypeFilter") : "";
%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action"	value="/nss/onedoorreturn/view" />
</portlet:actionURL>

<div class="title_categ"><liferay-ui:message key="ho-so-da-tra"/></div>
<div class="boxcontent">
		<div id="listdivpccc">
			<div id="listdiv">
				<ul>
							<form id="filter" name="<portlet:namespace/>fm" action="<%=filter %>" onsubmit="return checkBeginEndDate()" method="post" style="background:#ffffff;">
								<li style="width: 15%" >
										<select onchange="checkonchangBR33(); " name="<portlet:namespace/>type" id="select" style="width: 95%">
											<option  onclick="javascript:submitForm(document.hrefFm,'<%= filter %>');"  value=""><liferay-ui:message key="all" /></option>
											<option <%=("mahoso".equals(type) ? "selected" : "" )%>	value="mahoso"><liferay-ui:message key="pccc-DSHS-mahoso" /></option>
											<option <%=("tenhoso".equals(type) ? "selected" : "" )%> value="tenhoso"><liferay-ui:message key="pccc-TN-tenhoso" /></option>
											<option <%=("loaihoso".equals(type) ? "selected" : "" )%> value="loaihoso"><liferay-ui:message key="pccc-TN-loaihoso" /></option>
											<option <%=("ngayhentrakhach".equals(type) ? "selected" : "" )%> value="ngayhentrakhach"><liferay-ui:message key="pccc-TN-ngayhentrakhach" /></option>
										</select>
								</li>
									<li style="width: 55%;">
										<div id="<portlet:namespace/>comman"  >
											<input onkeypress="enableButton();" height="24" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" style="width: 97%;" value="<%=valueType %>" />
										</div>	
										
										<div id="<portlet:namespace/>fileTypeFilterDiv"  style="display: none">
											<select onchange="enableButton()" style="width: 97%;" name="<portlet:namespace/>fileTypeFilter" id="fileTypeFilter" >
												<option value=""><liferay-ui:message key ='choice'/></option>
												<%
													for (int i = 0; i < fileTypeListFilter.size(); i++) {
												%>
													<option <%=(fileTypeFilter.equals(String.valueOf(fileTypeListFilter.get(i).getFileTypeId())) ? "selected" : "" )%>	value="<%= fileTypeListFilter.get(i).getFileTypeId()%>"><%= fileTypeListFilter.get(i).getFileTypeName()%></option>
												<%		
													}
												%>
											</select>
										</div>
								
										<div id="<portlet:namespace/>day" style="display: none">
											<label><liferay-ui:message key="pccc-DSHS-ngaybatdau" /></label>	
											<input type="text"  name="<portlet:namespace/>beginDate" id="<portlet:namespace/>beginDate" value="<%= beginDateParam %>" style="width:35" maxlength="10">
						    				<span style="cursor: pointer"><img  id="cal-button-beginDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>beginDate','cal-button-beginDate')"/></span>
						    					
						    				<label><liferay-ui:message key="pccc-DSHS-ngayketthuc" /></label>
						    				<input type="text" name="<portlet:namespace/>endDate" id="<portlet:namespace/>endDate" value="<%= endDateParam %>" style="width:35" maxlength="10">
						    				<span style="cursor: pointer"><img id="cal-button-endDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>endDate','cal-button-endDate')"/></span>
						    			</div>	
										
									</li>
									<li style="width: 8%;" >
										<input style="width: 90%"	type="submit" id="<portlet:namespace/>loc" value='<liferay-ui:message key="pccc-DSHS-loc"/>'/>
									</li>
								
							</form>
						<li style="width: 22%;">
							<div class="btpre_hs" align="left"><liferay-util:include page="/html/portlet/nss/onedoorreturn/button.jsp"></liferay-util:include></div>
						</li>
				
				</ul>
			</div>
		<!-- HET PHAN LOC -->

			<div id="outer-1" class="outer-1">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
						<tr class="portlet-section-header results-header" >
							
							<%
								int lastMsgId = renderRequest.getAttribute("lastMsgId") != null ? (Integer)renderRequest.getAttribute("lastMsgId") : 0;
								PortletURL portletURL = renderResponse.createRenderURL();
								portletURL.setWindowState(WindowState.NORMAL);
								portletURL.setParameter("struts_action", "/nss/onedoorreturn/view");
								PmlFileReturnSearch searchContainer = new PmlFileReturnSearch(renderRequest, portletURL);
								searchContainer = renderRequest.getAttribute("pmlOneDoorFileSearch") != null ? (PmlFileReturnSearch)renderRequest.getAttribute("pmlOneDoorFileSearch") : searchContainer;
								
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
					
									<td class="tr_dt-<%= i + 1 %>">
										<c:if test="<%= orderKey != null %>">
											<a href="<%= searchContainer.getIteratorURL().toString() %>
													&<%= renderResponse.getNamespace() %>orderByCol=<%= orderKey %>&<%= renderResponse.getNamespace() %>orderByType=<%= orderByType %>&<%= renderResponse.getNamespace() %>sort=sort">
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
									</td>
					
								<%
								}
								%>
						</tr>
						
						<%	
						if (listFileDTO == null || listFileDTO.size() == 0) {
						%>
						<tr>
							<td colspan="9" rowspan="4" valign="middle" class="nodata_hs">
								<liferay-ui:message	key="pccc-TN-khongtontaidulieu" />
							</td>
						</tr>
						<%
							}else {
								if (lastMsgId == 0) {
									portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
						%>
								<script type="text/javascript">
									function last_msg_funtion()
										{
											var ID=jQuery(".message_box:last").attr("id");

											var html = jQuery.ajax({
												  url: "<%= portletURL.toString() %>&last_msg_id=" + ID + "&loadData=true",
												  async: false
											}).responseText; 

											if (html.indexOf("loaddata1") > 0) {										
												var data=html.substring(html.indexOf("loaddata1") +11, html.indexOf("loaddata2")-13);
												if (data != "") {
													jQuery(".message_box:last").after(data);
												}
											}
										};	
													
									jQuery(document.getElementById('outer-1')).scroll(function(){	
										if (jQuery('div#outer-1').scrollTop() == document.getElementById('outer-1').scrollHeight - jQuery('div#outer-1').height()){
											last_msg_funtion();
										}
									});
															
								</script>	
							
						<%		
						  		for (int i = 1; i <= listFileDTO.size(); i++) {
							  		PmlFilePcccDTO file = listFileDTO.get(i-1);
							  		String stype = "";	
									if (i % 2 == 0){
										stype = "tr_two results-row";
									}
									else {
										stype = "results-row";
									}
						%>
						
						<tr  id="<%= String.valueOf(i) %>" class="<%= stype %>">
							<td width="45px">
								<div align="center"><%=i%>.
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
							<portlet:param name="struts_action"	value="/nss/onedoorreturn/detail" />
							<portlet:param name="fileId" value="<%=file.getFileId() %>" />
							<portlet:param name="type"	value="<%= type %>" />
							<portlet:param name="valueType"	value="<%= valueType %>" />
							<portlet:param name="beginDateParam"	value="<%= beginDateParam %>" />
							<portlet:param name="endDateParam"	value="<%= endDateParam %>" />
							<portlet:param name="fileTypeFilter"	value="<%= fileTypeFilter %>" />
							<portlet:param name="sort"	value="<%= sort %>" />
							<portlet:param name="loadData"	value="<%= String.valueOf(loadData) %>" />
						</portlet:renderURL>
						
							<td ><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail%>');"><%=file.getNumberReceipt() %></a></td>
							<td width="20%"><%=file.getFileName() %></td>
							<td width="35%"><%=file.getFiletype() %></td>
							<td align="center"><%=file.getStatus() %></td>
							<td align="center"><%=(file.getApplicationDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getApplicationDate()) : "" %></td>
							<td align="center"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
						</tr>
							<%} %>
								
						<%	} else {%>
						<div id="loaddata1">
						
						<%		for (int i = 1 + lastMsgId; i <= listFileDTO.size()+lastMsgId; i++) {
						  		PmlFilePcccDTO file = listFileDTO.get(i-1-lastMsgId);
						  		String stype = "";	
								if (i % 2 == 0){
									stype = "tr_two results-row";
								}
								else {
									stype = "results-row";
								}
					%>
					
							<tr id="<%= String.valueOf(i) %>" class="<%= stype %>">
								<td width="45px">
									<div align="center"><%=i%>.
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
							
							<portlet:renderURL var="detail1" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="struts_action"	value="/nss/onedoorreturn/detail" />
								<portlet:param name="fileId" value="<%=file.getFileId() %>" />
								<portlet:param name="type"	value="<%= type %>" />
								<portlet:param name="valueType"	value="<%= valueType %>" />
								<portlet:param name="beginDateParam"	value="<%= beginDateParam %>" />
								<portlet:param name="endDateParam"	value="<%= endDateParam %>" />
								<portlet:param name="fileTypeFilter"	value="<%= fileTypeFilter %>" />
								<portlet:param name="sort"	value="<%= sort %>" />
								<portlet:param name="loadData"	value="<%= String.valueOf(loadData) %>" />
							</portlet:renderURL>
							
								<td><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail1%>');"><%=file.getNumberReceipt() %></a></td>
								<td><%=file.getFileName() %></td>
								<td><%=file.getFiletype() %></td>
								<td align="center"><%=file.getStatus() %></td>
								<td align="center"><%=(file.getApplicationDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getApplicationDate()) : "" %></td>
								<td align="center"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
							</tr>
							
					<%	} %>
						<div id="last_msg_loader"></div>
						</div><div id="loaddata2"></div>
					<%
						}}%>
					</table>
			</div>
	</div>		
		<div id="dropper" style="display: none; margin: 5px auto;width: 50px;">
			<img onClick="displayAndHidden()" style="cursor: pointer;"	src="/html/images/showfull.gif">
		</div>
	
	<!-- detail information document -->
		<div id="<portlet:namespace/>divcontent2" class="outer-2" style="display: none;"></div>
		<div id="<portlet:namespace/>buttontask" style="display: none"></div>
		<input type="hidden" id="hid" value="none">
</div>

