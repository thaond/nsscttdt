<%@ include file="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/init.jsp" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.onedoorreport_tinhhinhthulyhosocapso.searchfiledetail.PmlOneDoorReceiveFileSearch"%>

<liferay-util:include page="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/js/onedoorreport_tinhhinhthulyhosocapso-js.jsp"></liferay-util:include>

<script type="text/javascript" src="/html/js/validateAddAndEdit.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/css/ex.css" />

<script type="text/javascript">
function <portlet:namespace/>viewDetail(detailURL) 
{
	jQuery('#dropper').show();
	jQuery('#<portlet:namespace/>buttontask').show();
	jQuery('#<portlet:namespace/>divcontent2').load(detailURL);
	jQuery('#<portlet:namespace/>divcontent2').show();
}
</script>
<%
	String id = (String) renderRequest.getAttribute("id");
	String redirect = (String) renderRequest.getAttribute("redirect");
	String action = (String) renderRequest.getAttribute("action");
	
	String fileTypeId = (String) renderRequest.getAttribute("fileTypeId");
	String type = (String) renderRequest.getAttribute("type");
	String valueType = (String) renderRequest.getAttribute("valueType");
	String beginDateParam = (String) renderRequest.getAttribute("beginDateParam");
	String endDateParam = (String) renderRequest.getAttribute("endDateParam");
	String fileStateFilter = (String) renderRequest.getAttribute("fileStateFilter");
	List<PmlFilePcccDTO> pmlFilePcccList = (List<PmlFilePcccDTO>)renderRequest.getAttribute("pmlFilePcccList");

%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action"	value="/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" />
	<portlet:param name="action" value="<%= action %>" />
	<portlet:param name="id" value="<%= id %>" />
	<portlet:param name="fileTypeId" value="<%= fileTypeId %>" />
	<portlet:param name="redirect"	value="<%= redirect %>" />
</portlet:actionURL>
<div class="title_categ"><liferay-ui:message key="danh-sach-ho-so-bao-cao" /></div>
<div class="boxcontent">
	
		<div id="listdivpccc">
			<div id="listdiv" >
				<input name="redirect" type="hidden" value="<%= filter %>"> 
				<ul>
							<form id="filter" action="<%=filter %>" method="post">
							<li style="width: 15%">
										<select	onchange="checkonchangBR33();" name="<portlet:namespace/>type" id="select" style="width: 95%">
											<option  onclick="javascript:submitForm(document.hrefFm,'<%= filter %>');"  value=""><liferay-ui:message key="all" /></option>
											<option <%=("mahoso".equals(type) ? "selected" : "" )%>	value="mahoso"><liferay-ui:message key="pccc-DSHS-mahoso" /></option>
											<option <%=("tenhoso".equals(type) ? "selected" : "" )%> value="tenhoso"><liferay-ui:message key="pccc-TN-tenhoso" /></option>
											<option <%=("loaihoso".equals(type) ? "selected" : "" )%> value="loaihoso"><liferay-ui:message key="pccc-TN-loaihoso" /></option>
											<option <%=("ngayhentrakhach".equals(type) ? "selected" : "" )%> value="ngayhentrakhach"><liferay-ui:message key="pccc-TN-ngayhentrakhach" /></option>
										</select>
									</li>
									<li style="width: 55%">
										<div id="<portlet:namespace/>comman"  >
											<input onkeypress="enableButton();" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" style="width: 97%" value="<%=valueType %>" />
										</div>	
										
										<div id="<portlet:namespace/>fileTypeFilterDiv"  style="display: none">
											<select style="width: 97%" onchange="enableButton()" name="<portlet:namespace/>fileTypeFilter" id="fileTypeFilter" >
												<option value="">[chon]</option>
												<%
													List<PmlFileType> fileTypeListFilter = renderRequest.getAttribute("fileTypeList") != null ? (List<PmlFileType>)renderRequest.getAttribute("fileTypeList") : new ArrayList<PmlFileType>();
													String fileTypeFilter = renderRequest.getAttribute("fileTypeFilter") != null ? (String)renderRequest.getAttribute("fileTypeFilter") : "";
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
											<input type="text"  name="<portlet:namespace/>beginDate" id="<portlet:namespace/>beginDate" value="<%= beginDateParam %>" style="width:20%;">
						    				<span style="cursor: pointer"><img  id="cal-button-beginDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>beginDate','cal-button-beginDate')"/></span>
						    					
						    				<label><liferay-ui:message key="pccc-DSHS-ngayketthuc" /></label>
						    				<input type="text" name="<portlet:namespace/>endDate" id="<portlet:namespace/>endDate" value="<%= endDateParam %>" style="width:20%;" maxlength="10">
						    				<span style="cursor: pointer"><img id="cal-button-endDate" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>endDate','cal-button-endDate')"/></span>
						    			</div>
										</li>
										<li style="width: 8%">
										<input style="width: 90%" type="submit" id="<portlet:namespace/>loc" value='<liferay-ui:message key="pccc-DSHS-loc"/>'/>
									</li>
							</form>
						<li style="width: 22%">
							<div class="btpre_hs" align="left"><liferay-util:include page="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/button.jsp"></liferay-util:include></div>
						</li>
				</ul>
			
			</div>
			
			
			<div id="outer-1" class="outer-1">
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%" align="center">	
						<tr class="portlet-section-header results-header" >
						
						<%
							int lastMsgId = renderRequest.getAttribute("lastMsgId") != null ? (Integer)renderRequest.getAttribute("lastMsgId") : 0;
							PortletURL portletURL = renderResponse.createRenderURL();
							portletURL.setWindowState(WindowState.NORMAL);
							portletURL.setParameter("struts_action", "/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails");
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
				
								<td class="col-<%= i + 1 %>">
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
								</td>
				
							<%
							}
							%>
					</tr>
					
					<%	
						if (pmlFilePcccList == null || pmlFilePcccList.size() == 0) {
					%>
					<tr>
						<td colspan="9" rowspan="4" valign="middle" class="nodata_hs">
							<liferay-ui:message	key="pccc-TN-khongtontaidulieu" />
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
									
										var html = jQuery.ajax({
											  url: "<%= searchContainer.getIteratorURL().toString() %>&last_msg_id=" + ID + "&loadData=true",
											  async: false
										}).responseText;
										
										if (html.indexOf("loaddata1") > 0) {										
											var data=html.substring(html.indexOf("loaddata1") +11, html.indexOf("loaddata2")-15);
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
						  		for (int i = 1; i <= pmlFilePcccList.size(); i++) {
							  		PmlFilePcccDTO pmlFilePcccDTO = pmlFilePcccList.get(i-1);
							  		String style = "";	
									if (i % 2 == 0){
										style = "tr_two results-row";
									}
									else {
										style = "results-row";
									}
						  		
							%>
							<tr id="<%= String.valueOf(i) %>" class="<%= style %>">
								<td width="35px">
									<div align="center"><%= i%>.
									<%
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								    	Date date = new Date ();
								    	String cdate = dateFormat.format(date);
								    	Date d1 = dateFormat.parse(cdate);
								    	Date d2 = dateFormat.parse(cdate);
								    	if ( null != pmlFilePcccDTO.getExpireDate()) {
								    		d2 = dateFormat.parse(dateFormat.format(pmlFilePcccDTO.getExpireDate()));
								    	}
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
							<portlet:renderURL var="detail"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="struts_action"	value="/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails_detail" />
								<portlet:param name="fileId" value="<%=pmlFilePcccDTO.getFileId() %>" />							
							</portlet:renderURL>
							
								<!-- input name="redirect" type="hidden" value="<!%= detail %>"-->
								 
								<td><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail%>');"><%=pmlFilePcccDTO.getNumberReceipt() %></a></td>
								<td><%= pmlFilePcccDTO.getFileName() %></td>
								<td><%= pmlFilePcccDTO.getFiletype() %></td>
								<td><%= pmlFilePcccDTO.getStatus() %></td>
								<td>
									<%= (pmlFilePcccDTO.getReceiveDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getReceiveDate())) : "" %>
								</td>
								<td>
									<%= (pmlFilePcccDTO.getExpectedReturingDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getExpectedReturingDate())) : ""%>
								</td>
							</tr>
						
						<%}} else { %>
							<div id="loaddata1">
							
							<%	
								int size = pmlFilePcccList.size() + lastMsgId;
						  		for (int i = 1 + lastMsgId; i <= size; i++) {
							  		PmlFilePcccDTO pmlFilePcccDTO = pmlFilePcccList.get(i-1-lastMsgId);
							  		String style = "";	
									if (i % 2 == 0){
										style = "tr_two results-row";
									}
									else {
										style = "results-row";
									}
						  		
							%>
							<tr id="<%= String.valueOf(i) %>" onMouseOut="nofocusColor(this)" onMouseOver="focusColor2(this)"	class="<%= style %> message_box">
								<td width="35px">
									<div align="center"><%=i%>.
									<%
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								    	Date date = new Date ();
								    	String cdate = dateFormat.format(date);
								    	Date d1 = dateFormat.parse(cdate);
								    	Date d2 = dateFormat.parse(cdate);
								    	if ( null != pmlFilePcccDTO.getExpireDate()) {
								    		d2 = dateFormat.parse(dateFormat.format(pmlFilePcccDTO.getExpireDate()));
								    	}
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
							<portlet:renderURL var="detail1"	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="struts_action"	value="/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails_detail" />
								<portlet:param name="fileId" value="<%=pmlFilePcccDTO.getFileId() %>" />							
							</portlet:renderURL>
							
								<td><a class="showTip L1" href="javascript: ;" onclick="<portlet:namespace/>viewDetail('<%=detail1%>');"><%=pmlFilePcccDTO.getNumberReceipt() %></a></td>
								<td><%= pmlFilePcccDTO.getFileName() %></td>
								<td><%= pmlFilePcccDTO.getFiletype() %></td>
								<td><%= pmlFilePcccDTO.getStatus() %></td>
								<td>
									<%= (pmlFilePcccDTO.getReceiveDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getReceiveDate())) : "" %>
								</td>
								<td>
									<%= (pmlFilePcccDTO.getExpectedReturingDate() != null) ? ((new SimpleDateFormat("dd/MM/yyyy")).format(pmlFilePcccDTO.getExpectedReturingDate())) : ""%>
								</td>
							</tr>
							<%	} %>
							<div id="last_msg_loader"></div>
							</div><div id="loaddata2"></div>
						<%
						}
					}%>
					</table>
				</div>
			</div>
		
	
	
	<div id="dropper" style="display: none;margin: 5px auto;width: 50px;">
		<img onClick="displayAndHiddenReport()" style="cursor: pointer;" src="/html/images/showfull.gif">
	</div>
	
		
	
	<!-- detail information document -->
	<div id="<portlet:namespace/>divcontent2" class="outer-2" style="display: none;"></div>
	<div id="<portlet:namespace/>buttontask" style="display: none"></div>
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