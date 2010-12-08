<%@ include file="/html/portlet/nss/onedoorprocess/init.jsp"%>
<%@page import="com.nss.portlet.onedoorprocess.SearchIsDelegated.PmlOneDoorReceiveFileSearchIsDelegated"%>
<%@page import="com.nss.portlet.onedoorprocess.searchDelegated.PmlOneDoorReceiveFileSearchDelegated"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.nss.portlet.onedoorprocess.search.PmlOneDoorReceiveFileSearch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<!-- <script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>-->

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/nss/onedoorprocess/css/style.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/nss/onedoorprocess/css/ex.css" />

<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>

<script type="text/javascript">
function <portlet:namespace/>viewDetail(detailURL) 
{
	jQuery('#dropper').show();
	jQuery('#<portlet:namespace/>buttontask').show();
	jQuery('#<portlet:namespace/>divcontent2').load(detailURL);
	jQuery('#<portlet:namespace/>divcontent2').show();
	jQuery('#div-empty').hide();
}
 
function <portlet:namespace />processReport() 
{
	var form = document.getElementById("filter");
	form.action = "/nss/onedoorprocess/view?action=report"; 
}

</script>


<%

	List<PmlFilePcccDTO> ownerList = (List<PmlFilePcccDTO>)renderRequest.getAttribute("ownerList");
	List<PmlFilePcccDTO> isDelegatedList = (List<PmlFilePcccDTO>)renderRequest.getAttribute("isDelegatedList");
	List<PmlFilePcccDTO> delegatedList = (List<PmlFilePcccDTO>)renderRequest.getAttribute("delegatedList");
	
	//String numberReceipt = (String) renderRequest.getAttribute("numberReceipt");
 	//String isProcess = (String) renderRequest.getAttribute("isProcess");
 	//String processValue = ParamUtil.getString(renderRequest, "processValue");
 	//String showStatus = (String) renderRequest.getAttribute("showStatus");
	//String state = (String) renderRequest.getAttribute("state");
	String fileStateFilter = (String) renderRequest.getAttribute("fileStateFilter");
 	
	String sort = (String) renderRequest.getAttribute("sort");
	boolean loadData = (Boolean) renderRequest.getAttribute("loadData");
	String processValue = (String) renderRequest.getAttribute("processValue");
	String type = (String) renderRequest.getAttribute("type");
	String valueType = (String) renderRequest.getAttribute("valueType");
	String beginDateParam = (String) renderRequest.getAttribute("beginDateParam");
	String endDateParam = (String) renderRequest.getAttribute("endDateParam");
	String isDelegate = (String) renderRequest.getAttribute("isDelegate");
	List<PmlFileType> fileTypeListFilter = renderRequest.getAttribute("fileTypeList") != null ? (List<PmlFileType>)renderRequest.getAttribute("fileTypeList") : new ArrayList<PmlFileType>();
	String fileTypeFilter = renderRequest.getAttribute("fileTypeFilter") != null ? (String)renderRequest.getAttribute("fileTypeFilter") : "";
	
%>
<portlet:actionURL var="filter">
	<portlet:param name="struts_action"	value="/nss/onedoorprocess/view" />
	<portlet:param name="processValue"	value="<%= processValue %>" /> <!-- yenlt update 07052010 -->
</portlet:actionURL>

<div class="title_categ"><liferay-ui:message key="tieu-thuc-loc-ho-so" /></div>
<div class="boxcontent">
	<div id="listdivpccc">
			<div id="listdiv">
			<ul>
			<form id="filter" action="<%=filter %>" onsubmit="return checkBeginEndDate()" method="post">
				<li style="width: 15%">
					<select onchange="checkonchangBR33('<%=filter %>'); " name="<portlet:namespace/>type" id="select" style="width: 95%">
							<option  onclick="javascript:submitForm(document.hrefFm,'<%= filter %>');"  value=""><liferay-ui:message key="all" /></option>
							<option <%=("mahoso".equals(type) ? "selected" : "" )%>	value="mahoso"><liferay-ui:message key="pccc-DSHS-mahoso" /></option>
							<option <%=("tenhoso".equals(type) ? "selected" : "" )%> value="tenhoso"><liferay-ui:message key="pccc-TN-tenhoso" /></option>
							<option <%=("loaihoso".equals(type) ? "selected" : "" )%> value="loaihoso"><liferay-ui:message key="pccc-TN-loaihoso" /></option>
							<!-- option <!%=("trangthaihoso".equals(type) ? "selected" : "" )%> value="trangthaihoso"><liferay-ui:message key="pccc-TN-trangthaihoso" /></option-->
							<!-- option <!%=("ngaygui".equals(type) ? "selected" : "" )%> value="ngaygui"><liferay-ui:message key="pccc-XL-ngaygui" /></option-->
							<!-- option <!%=("ngaynhan".equals(type) ? "selected" : "" )%> value="ngaynhan"><liferay-ui:message key="pccc-TN-ngaynhan" /></option-->
							<!-- option <!%=("ngayhethan".equals(type) ? "selected" : "" )%> value="ngayhethan"><liferay-ui:message key="pccc-DSHS-ngayhethan" /></option-->
							<option <%=("ngayhentrakhach".equals(type) ? "selected" : "" )%> value="ngayhentrakhach"><liferay-ui:message key="pccc-TN-ngayhentrakhach" /></option>
											
					</select>
				</li>
				<li style="width: 55%">
					<div id="<portlet:namespace/>comman"  >
							<input onkeypress="enableButton();" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" style="width: 97%" value="<%=valueType %>" />
					</div>	
					<div id="<portlet:namespace/>fileTypeFilterDiv"  style="display: none" >
							<select style="width: 97%" onchange="enableButton()" name="<portlet:namespace/>fileTypeFilter" id="fileTypeFilter" >
									<option value="">[chon]</option>
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
							<input type="text"  name="<portlet:namespace/>beginDate" id="<portlet:namespace/>beginDate" value="<%= beginDateParam %>" style="width:20%">
							<span class="btdate_hs"><img align="top" id="cal-button-beginDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>beginDate','cal-button-beginDate')"/></span>
						<label><liferay-ui:message key="pccc-DSHS-ngayketthuc" /></label>
						    <input type="text" name="<portlet:namespace/>endDate" id="<portlet:namespace/>endDate" value="<%= endDateParam %>" style="width:20%" >
						    <span class="btdate_hs"><img align="top" id="cal-button-endDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>endDate','cal-button-endDate')"/></span>
					</div>
				</li>
				<li style="width: 8%">
					<input style="width: 90%" type="submit" id="<portlet:namespace/>loc" value='<liferay-ui:message key="pccc-DSHS-loc"/>'/>
				</li>
			</form>
				<li style="width: 22%">
					<div class="btpre_hs" align="left"><liferay-util:include page="/html/portlet/nss/onedoorprocess/button.jsp"></liferay-util:include></div>
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
							portletURL.setParameter("struts_action", "/nss/onedoorprocess/view");
							PmlOneDoorReceiveFileSearch searchContainer = new PmlOneDoorReceiveFileSearch(renderRequest, portletURL);
							searchContainer = renderRequest.getAttribute("pmlOneDoorReceiveFileSearch") != null ? (PmlOneDoorReceiveFileSearch)renderRequest.getAttribute("pmlOneDoorReceiveFileSearch") : searchContainer;
							
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
				
								<td class="tr_xl-<%= i + 1 %>">
									<c:if test="<%= orderKey != null %>">
										<a href="<%= searchContainer.getIteratorURL().toString() %>
												&<%= renderResponse.getNamespace() %>processValue=<%= processValue %> 
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
						if (ownerList == null || ownerList.size() == 0) {
					%>
					<tr>
						<td colspan="9" rowspan="4" valign="middle" class="nodata_hs">
							<liferay-ui:message	key="pccc-TN-khongtontaidulieu-hs" />
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

										//jQuery('div#last_msg_loader').html('<img src="/html/portlet/ext/onedoorpcccprocess/images/bigLoader.gif">');
										
										var html = jQuery.ajax({
											  url: "<%= portletURL.toString() %>&last_msg_id=" + ID + "&loadData=true&processValue=<%= processValue %>",
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
					  		for (int i = 1; i <= ownerList.size(); i++) {
						  		PmlFilePcccDTO file = ownerList.get(i-1);
						  		String stype = "";	
								if (i % 2 == 0){
									stype = "tr_two results-row";
								}
								else {
									stype = "results-row";
								}
					%>
					
					<tr  id="<%= String.valueOf(i) %>" class="<%= stype %> ">
						<td nowrap="nowrap">
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
						<portlet:param name="struts_action"	value="/nss/onedoorprocess/detail" />
						<portlet:param name="fileId" value="<%=file.getFileId() %>" />
						<portlet:param name="processValue" value='<%= processValue %>' /> <!-- yenlt 07052010 -->
						<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
						<portlet:param name="processValue"	value="<%= processValue %>" />
						<portlet:param name="type"	value="<%= type %>" />
						<portlet:param name="valueType"	value="<%= valueType %>" />
						<portlet:param name="beginDateParam"	value="<%= beginDateParam %>" />
						<portlet:param name="endDateParam"	value="<%= endDateParam %>" />
						<portlet:param name="fileTypeFilter"	value="<%= fileTypeFilter %>" />
						<portlet:param name="sort"	value="<%= sort %>" />
						<portlet:param name="loadData"	value="<%= String.valueOf(loadData) %>" />
						<portlet:param name="isDelegate" value="false" /> <!-- yenlt 18052010 -->
					</portlet:renderURL>
					
						<td><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail%>');"><%=file.getNumberReceipt() %></a></td>
						<td><%=file.getFileName() %></td>
						<td><%=file.getFiletype() %></td>
						<td align="center"><%=file.getStatus() %></td>
						<td align="center"><%=(file.getSendDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getSendDate()) : ""%></td>
						<td align="center"><%=(file.getReceiveDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getReceiveDate()) : "" %></td>
						<td align="center" style="display: none;"><%= (file.getInputDataDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getInputDataDate()) : "" %></td>
						<td align="center"><%= file.getExpireDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpireDate()) : "" %></td>
						<td align="center"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
						<td align="center" style="display: none;"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
					</tr>
						<%} %>
						
						
							
					<%	} else {%>
					<div id="loaddata1">
					
					<%		for (int i = 1 + lastMsgId; i <= ownerList.size()+lastMsgId; i++) {
					  		PmlFilePcccDTO file = ownerList.get(i-1-lastMsgId);
					  		String stype = "";	
							if (i % 2 == 0){
								stype = "tr_two results-row";
							}
							else {
								stype = "results-row";
							}
				%>
				
						<tr id="<%= String.valueOf(i) %>" class="<%= stype %>">
							<td nowrap="nowrap">
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
							<portlet:param name="struts_action"	value="/nss/onedoorprocess/detail" />
							<portlet:param name="fileId" value="<%=file.getFileId() %>" />
							<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
							<portlet:param name="processValue"	value="<%= processValue %>" />
							<portlet:param name="type"	value="<%= type %>" />
							<portlet:param name="valueType"	value="<%= valueType %>" />
							<portlet:param name="beginDateParam"	value="<%= beginDateParam %>" />
							<portlet:param name="endDateParam"	value="<%= endDateParam %>" />
							<portlet:param name="fileTypeFilter"	value="<%= fileTypeFilter %>" />
							<portlet:param name="sort"	value="<%= sort %>" />
							<portlet:param name="loadData"	value="<%= String.valueOf(loadData) %>" />
							<portlet:param name="isDelegate" value="false" /> <!-- yenlt 18052010 -->
						</portlet:renderURL>
						
							<td><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail1%>');"><%=file.getNumberReceipt() %></a></td>
							<td><%=file.getFileName() %></td>
							<td><%=file.getFiletype() %></td>
							<td align="center"><%=file.getStatus() %></td>
							<td align="center"><%=(file.getSendDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getSendDate()) : ""%></td>
							<td align="center"><%=(file.getReceiveDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getReceiveDate()) : "" %></td>
							<td align="center" style="display: none;"><%= (file.getInputDataDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(file.getInputDataDate()) : "" %></td>
							<td align="center"><%= file.getExpireDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpireDate()) : "" %></td>
							<td align="center"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
							<td align="center" style="display: none;"><%= file.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExpectedReturingDate()) : "" %></td>
						</tr>
						
				<%	} %>
				<div id="last_msg_loader"></div>
				</div><div id="loaddata2"></div>
				<%
						}}%>
					</table>
			
	
				
				<c:if test="<%=!delegatedList.isEmpty() %>">
				<%
					if (delegatedList != null && delegatedList.size() != 0) {
				%>
					<fieldset>					
						<table width="100%" cellspacing="0">
							<tr >
								<td class="left-top-title-head"><img src="/html/images/tnog_lefttop.gif"></td>			
								<td class="bottom-title-head" nowrap="nowrap">
									<span ><liferay-ui:message	key="delegate-file-list" /></span>
								</td>
								
							</tr>
						</table>
						
					<table class="taglib-search-iterator table-pml">
					
					<tr class="portlet-section-header results-header" >
					
						<%			
							PortletURL portletURLDelegated = renderResponse.createRenderURL();
							portletURLDelegated.setWindowState(WindowState.NORMAL);
							portletURLDelegated.setParameter("struts_action", "/nss/onedoorprocess/view");
							PmlOneDoorReceiveFileSearchDelegated searchContainerDelegated = new PmlOneDoorReceiveFileSearchDelegated(renderRequest, portletURLDelegated);
							searchContainerDelegated = renderRequest.getAttribute("pmlOneDoorReceiveFileSearchDelegated") != null ? (PmlOneDoorReceiveFileSearchDelegated)renderRequest.getAttribute("pmlOneDoorReceiveFileSearchDelegated") : searchContainerDelegated;
							
							List<String> headerNamesDelegated = searchContainerDelegated.getHeaderNames();
							Map orderableHeadersDelegated = searchContainerDelegated.getOrderableHeaders();
							
							for (int i = 0; (headerNamesDelegated != null) && (i < headerNamesDelegated.size()); i++) {
								String headerName = headerNamesDelegated.get(i);
				
								String orderKey = null;
								String orderByType = null;
								boolean orderCurrentHeader = false;
				
								if (orderableHeaders != null) {
									orderKey = (String)orderableHeadersDelegated.get(headerName);
				
									if (orderKey != null) {
										orderByType = searchContainerDelegated.getOrderByType();
				
										if (orderKey.equals(searchContainerDelegated.getOrderByCol())) {
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
				
								<td class="col-<%= i + 1 %>">
									<c:if test="<%= orderKey != null %>">
										<a href="<%= searchContainerDelegated.getIteratorURL().toString() %>&<%= renderResponse.getNamespace() %>orderByCol=<%= orderKey %>&<%= renderResponse.getNamespace() %>orderByType=<%= orderByType %>&<%= renderResponse.getNamespace() %>sort=sort">
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
						for (int i = 1; i <= delegatedList.size(); i++) {
							PmlFilePcccDTO delegatedFile = delegatedList.get(i-1);
					%>
					<tr class="${((i % 2)==0)? 'tr_two results-row':'results-row'}">
						<td nowrap="nowrap">
							<div align="center"><%=i%>. 
							<%
							    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						    	Date date = new Date ();
						    	String cdate = dateFormat.format(date); 
						    	Date d1 = dateFormat.parse(cdate);
						    	Date d2 = delegatedFile.getExpectedReturingDate();
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
						    %>
					
					<portlet:renderURL var="detailView"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="struts_action"	value="/nss/onedoorprocess/detail" />
						<portlet:param name="fileId" value="<%=delegatedFile.getFileId() %>" />
						<portlet:param name="processValue" value="<%= processValue %>" />
						<portlet:param name="isDelegate" value="true" /> <!-- yenlt 18052010 -->
						<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
					</portlet:renderURL>
					
						<td>
							<a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detailView%>');"><%=delegatedFile.getNumberReceipt() %></a>
						</td>
						<td><%=delegatedFile.getFileName() %></td>
						<td><%=delegatedFile.getFiletype() %></td>
						<td><%= delegatedFile.getInputDataDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(delegatedFile.getInputDataDate()) : "" %></td>
						<td><%= delegatedFile.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(delegatedFile.getExpectedReturingDate()) : "" %></td>
					</tr>
					<%
						}
					%>
					</table>
				
					</fieldset>
				<%
				}
				%>
				</c:if> 
				
				
				<c:if test="<%=!isDelegatedList.isEmpty() %>">
					<%
						if(isDelegatedList != null && isDelegatedList.size() != 0) {
					%>
					<fieldset>
					
						<table cellspacing="0" width="100%">
							<tr>
								<td class="left-top-title-head"><img src="/html/images/tnog_lefttop.gif"></td>
								
								<td class="bottom-title-head" nowrap="nowrap">
									<span ><liferay-ui:message	key="isdelegate-file-list" /></span>
								</td>
								
							</tr>
						</table>
					
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					
					<tr class="portlet-section-header results-header" >
						<%			
							PortletURL portletURLIsDelegated = renderResponse.createRenderURL();
							portletURLIsDelegated.setWindowState(WindowState.NORMAL);
							portletURLIsDelegated.setParameter("struts_action", "/nss/onedoorprocess/view");
							PmlOneDoorReceiveFileSearchIsDelegated searchContainerIsDelegated = new PmlOneDoorReceiveFileSearchIsDelegated(renderRequest, portletURLIsDelegated);
							searchContainerIsDelegated = renderRequest.getAttribute("pmlOneDoorReceiveFileSearchIsDelegated") != null ? (PmlOneDoorReceiveFileSearchIsDelegated)renderRequest.getAttribute("pmlOneDoorReceiveFileSearchIsDelegated") : searchContainerIsDelegated;
							
							List<String> headerNamesIsDelegated = searchContainerIsDelegated.getHeaderNames();
							Map orderableHeadersIsDelegated = searchContainerIsDelegated.getOrderableHeaders();
							
							for (int i = 0; (headerNamesIsDelegated != null) && (i < headerNamesIsDelegated.size()); i++) {
								String headerName = headerNamesIsDelegated.get(i);
				
								String orderKey = null;
								String orderByType = null;
								boolean orderCurrentHeader = false;
				
								if (orderableHeaders != null) {
									orderKey = (String)orderableHeadersIsDelegated.get(headerName);
				
									if (orderKey != null) {
										orderByType = searchContainerIsDelegated.getOrderByType();
				
										if (orderKey.equals(searchContainerIsDelegated.getOrderByCol())) {
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
										<a href="<%= searchContainerIsDelegated.getIteratorURL().toString() %>&<%= renderResponse.getNamespace() %>orderByCol=<%= orderKey %>&<%= renderResponse.getNamespace() %>orderByType=<%= orderByType %>&<%= renderResponse.getNamespace() %>sort=sort">
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
						for (int i = 1; i <= isDelegatedList.size(); i++) {
						  PmlFilePcccDTO isDelegatedFile = isDelegatedList.get(i-1);
					%>
					<tr class="${((i % 2)==0)? 'tr_two results-row':'results-row'}">
						<td nowrap="nowrap">
							<div align="center"><%=i%>.
							<%
							    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							    Date date = new Date ();
							    String cdate = dateFormat.format(date); 
							    Date d1 = dateFormat.parse(cdate);
							    Date d2 = isDelegatedFile.getExpectedReturingDate();
							    if (d1.equals(d2)){
							       %> <img src="/html/images/pink.gif"></div>
									</td>
									<%
								}
							    if(d1.after(d2)){
							    	 %>
									<img src="/html/images/red.gif">
									</div>
									</td>
									<%
							    }
							    if(d1.before(d2)){
							    	 %>
									<img src="/html/images/blue.gif">
									</div>
									</td>
									<%
							    }
						    
						    %>
						    
					<portlet:renderURL var="viewdetail"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="struts_action"	value="/nss/onedoorprocess/detail" />
						<portlet:param name="fileId" value="<%=isDelegatedFile.getFileId() %>" />
						<portlet:param name="processValue" value="<%= processValue %>" />
						<portlet:param name="isDelegate" value="true" /> <!-- yenlt 18052010 -->
						<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
					</portlet:renderURL>
					
						<td>
							<a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=viewdetail%>');"><%=isDelegatedFile.getNumberReceipt() %></a></td>
						<td><%=isDelegatedFile.getFileName() %></td>
						<td><%=isDelegatedFile.getFiletype() %></td>
						<td><%= isDelegatedFile.getInputDataDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(isDelegatedFile.getInputDataDate()) : "" %></td>
						<td><%= isDelegatedFile.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(isDelegatedFile.getExpectedReturingDate()) : "" %></td>
					</tr>
					<%
					}
					%>
					</table>
					</fieldset>
				
					<%
						}
					%>
				</c:if>	
			</div>
		
		</div>
	
		<div id="dropper" style="display: none; margin: 5px auto;width: 50px;">
			<!-- img onClick="showAndHidden()" style="cursor: pointer;"	src="/html/images/showfull.gif"-->
			<img onClick="displayAndHidden()" style="cursor: pointer;"	src="/html/images/showfull.gif">
		</div>
	
	<!-- detail information document -->
		<div id="<portlet:namespace/>divcontent2" class="outer-2" style="display: none;"></div>
		<div id="<portlet:namespace/>buttontask" style="display: none"></div>
	
		<input type="hidden" id="hid" value="none">
</div>

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
</script>

<%

	String transitionBack = (String) renderRequest.getAttribute("transitionBack");
	String transition = (String) renderRequest.getPortletSession().getAttribute("transition",PortletSession.APPLICATION_SCOPE);
	if (transitionBack != null && transitionBack.trim().length() > 0 ) {
		transition = null;
	}
	
	if ("transition".equalsIgnoreCase(transition)) {
%>
		<script type="text/javascript">	
			alert("<liferay-ui:message key='pcccdocumentreceipt-chuyen-thanh-cong'/>");
		</script>
<%	} if ("update".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript">	
			alert("<liferay-ui:message key='pccconedoor-sua-thanh-cong'/>");
		</script>
<%	} if ("delete".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript">	
			alert("<liferay-ui:message key='pccconedoor-xoa-thanh-cong'/>");
		</script>
<%	} if ("return".equalsIgnoreCase(transition)) { %>
		<script type="text/javascript">	
			alert("<liferay-ui:message key='pccconedoor-tra-thanh-cong'/>");
		</script>
<%	}

	renderRequest.getPortletSession(true).setAttribute("transition",null,PortletSession.APPLICATION_SCOPE);
	String fileId = ParamUtil.getString(renderRequest, com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId");
	if (!"".equals(fileId)) {
%>


	<portlet:renderURL var="viewdetailBack"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action"	value="/nss/onedoorprocess/detail" />
		<portlet:param name="fileId" value="<%= fileId %>" />
		<portlet:param name="isDelegate" value="<%= isDelegate %>" />
		<portlet:param name="processValue" value="<%= processValue %>" />
		<portlet:param name="<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"	value="true" />
	</portlet:renderURL>
	
	<script type="text/javascript">	
		jQuery('#dropper').show();
		jQuery('#<portlet:namespace/>buttontask').show();
		jQuery('#<portlet:namespace/>divcontent2').load('<%= viewdetailBack %>');
		jQuery('#<portlet:namespace/>divcontent2').show();
		jQuery('#div-empty').hide();
	</script>
<% } %>