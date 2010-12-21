<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.nss.portlet.thong_ke_tin.util.SortUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="java.util.Date"%>
<%@page import="com.nss.portlet.thong_ke_tin.dto.JournalArticleUserReportDTO"%>
<%@page import="com.nss.portlet.thong_ke_tin.util.ReportUtil"%>
<%@page import="com.nss.portlet.thong_ke_tin.dto.JournalArticleCategoryReoportDTO"%>
<%@page import="com.liferay.portlet.tags.service.TagsVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.tags.model.TagsVocabulary"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.util.portlet.PortletRequestUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle"%>
<%@page import="com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.SetUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/nss/thong_ke_tin/init.jsp" %>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript">
	
window.onload = function () {
	
		if (document.getElementById('<portlet:namespace />cal_create_date_f') != null) {
			callCalendar('<portlet:namespace/>cal_create_date_f','<portlet:namespace/>cal_create_bdate_f');
		}
		
		if (document.getElementById('<portlet:namespace />cal_create_date_t') != null) {
			callCalendar('<portlet:namespace/>cal_create_date_t','<portlet:namespace/>cal_create_bdate_t');
		}
		if (document.getElementById('<portlet:namespace />cal_approved_date_f') != null) {
			callCalendar('<portlet:namespace/>cal_approved_date_f','<portlet:namespace/>cal_approved_bdate_f');
		}
		
		if (document.getElementById('<portlet:namespace />cal_approved_date_t') != null) {
			callCalendar('<portlet:namespace/>cal_approved_date_t','<portlet:namespace/>cal_approved_bdate_t');
		}
		if (document.getElementById('<portlet:namespace />cal_expiration_date_f') != null) {
			callCalendar('<portlet:namespace/>cal_expiration_date_f','<portlet:namespace/>cal_expiration_bdate_f');
		}
		
		if (document.getElementById('<portlet:namespace />cal_expiration_date_t') != null) {
			callCalendar('<portlet:namespace/>cal_expiration_date_t','<portlet:namespace/>cal_expiration_bdate_t');
		}
		if (document.getElementById('<portlet:namespace />cal_display_date_t') != null) {
			callCalendar('<portlet:namespace/>cal_display_date_t','<portlet:namespace/>cal_display_bdate_t');
		}
		
		if (document.getElementById('<portlet:namespace />cal_display_date_f') != null) {
			callCalendar('<portlet:namespace/>cal_display_date_f','<portlet:namespace/>cal_display_bdate_f');
		}
		
	}
	
</script>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "tk-user");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("struts_action", "/nss/thong_ke_tin/tab");

PortletURL portletURL1 = renderResponse.createRenderURL();

portletURL1.setWindowState(WindowState.NORMAL);

portletURL1.setParameter("struts_action", "/nss/thong_ke_tin/tab");
portletURL1.setParameter("tabs1", tabs1);


String select_user = ParamUtil.getString(request,"select_user");
String select_category = ParamUtil.getString(request,"select_category");

portletURL1.setParameter("select_user",select_user);
portletURL1.setParameter("select_category",select_category);

String currentURL = PortletURLUtil.getCurrent(renderRequest,renderResponse).toString();

String userIds = ParamUtil.getString(request,"userIds");
String categoryNames = ParamUtil.getString(request,"categoryNames");

boolean has_userIds = false;
boolean hasCategoryNames = false;

if(!"".equals(userIds) && "custom".equals(select_user)){
	has_userIds = true;
}
if(!"".equals(categoryNames) && "custom".equals(select_category)){
	hasCategoryNames = true;
}

if(!"".equals(userIds)){
	portletURL1.setParameter("userIds",userIds);
}
if(!"".equals(categoryNames)){
	portletURL1.setParameter("categoryNames",categoryNames);
}

String date_create_f = ParamUtil.getString(request,"cal_create_date_f","");
String date_create_t = ParamUtil.getString(request,"cal_create_date_t","");

String date_display_f = ParamUtil.getString(request,"cal_display_date_f","");
String date_display_t = ParamUtil.getString(request,"cal_display_date_t","");

String date_approved_f = ParamUtil.getString(request,"cal_approved_date_f","");
String date_approved_t = ParamUtil.getString(request,"cal_approved_date_t","");

String date_expiration_f = ParamUtil.getString(request,"cal_expiration_date_f","");
String date_expiration_t = ParamUtil.getString(request,"cal_expiration_date_t","");

String date_from = "";
String date_to = "";

String date_create = ParamUtil.getString(request,"date_create_type","");
String date_display = ParamUtil.getString(request,"date_display_type","");
String date_approved = ParamUtil.getString(request,"date_approved_type","");
String date_expired = ParamUtil.getString(request,"date_expiration_type","");

if("".equals(date_create_f) && "".equals(date_create_t) 
				&& "".equals(date_approved_f) && "".equals(date_approved_t)
				&& "".equals(date_display_f) && "".equals(date_display_t)
				&& "".equals(date_expiration_f) && "".equals(date_expiration_t)){
	Date now = new Date();
	date_create_t = now.getDate() + "/" + (now.getMonth() + 1 ) + "/" + (now.getYear() + 1900);
	int year = now.getYear() + 1900;
	int month = now.getMonth() + 1;
	if(month - 1 <0){
		month = 12;
		year -= 1;
	}else{
		month -= 1;
	}
	date_create_f = now.getDate() + "/" + month + "/" + year;
	date_create = "on";
}

Date create_f = null;
Date create_t = null;

Date display_f = null;
Date display_t = null;

Date approved_f = null;
Date approved_t = null;

Date expiration_f = null;
Date expiration_t = null;

boolean has_create = false;
boolean has_display = false;
boolean has_approved = false;
boolean has_expired = false;

if(!"".equals(date_expired)){
	has_expired = true;
	expiration_f = createDate(date_expiration_f);
	expiration_t = createDate(date_expiration_t);
	portletURL1.setParameter("date_expiration_type",date_expired);
	portletURL1.setParameter("cal_expiration_date_f",date_expiration_f);
	portletURL1.setParameter("cal_expiration_date_t",date_expiration_t);
	date_from = date_expiration_f;
	date_to = date_expiration_t;
}
if(!"".equals(date_approved)){
	has_approved = true;
	approved_f = createDate(date_approved_f);
	approved_t = createDate(date_approved_t);
	portletURL1.setParameter("date_approved_type",date_approved);
	portletURL1.setParameter("cal_approved_date_f",date_approved_f);
	portletURL1.setParameter("cal_approved_date_t",date_approved_t);
	date_from = date_approved_f;
	date_to = date_approved_t;
}
if(!"".equals(date_create)){
	has_create = true;
	create_f = createDate(date_create_f);
	create_t = createDate(date_create_t);
	portletURL1.setParameter("date_create_type",date_create);
	portletURL1.setParameter("cal_create_date_f",date_create_f);
	portletURL1.setParameter("cal_create_date_t",date_create_t);
	date_from = date_create_f;
	date_to = date_create_t;
}
if(!"".equals(date_display)){
	has_display = true;
	display_f = createDate(date_display_f);
	display_t = createDate(date_display_t);
	portletURL1.setParameter("date_display_type",date_display);
	portletURL1.setParameter("cal_display_date_f",date_display_f);
	portletURL1.setParameter("cal_display_date_t",date_display_t);
	date_from = date_display_f;
	date_to = date_display_t;
}


%>
<%!
public Date createDate(String date){
	String[] data = date.split("/");
	try{
		int day = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int year = Integer.parseInt(data[2]);
		return new Date(year-1900,month-1,day);
	}catch(Exception e){
		
	}
	return null;
}
%>
<%
String orderByCol = "";
String orderByType = "";
try{
	String NSS_THONG_KE_TIN = "thong_ke_tin";

	String portletResource = ParamUtil.getString(request, "portletResource");
	PortletPreferences preferences =
		PortletPreferencesFactoryUtil.getPortletSetup(
			renderRequest, portletResource);
	
	orderByCol = ParamUtil.getString(request, "orderByCol", "nss-tk-bai-viet");
	orderByType = ParamUtil.getString(request, "orderByType", "desc");
	
	preferences.setValue(
		 "tk-tin-order-by-col", orderByCol);
	preferences.setValue(
		 "tk-tin-order-by-type", orderByType);
		
	orderByCol = preferences.getValue("tk-tin-order-by-col", "nss-tk-bai-viet");
	orderByType = preferences.getValue("tk-tin-order-by-type", "desc");
		
	preferences.store();
	
}catch (Exception e) {
	
}
%>
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />date_create_f" type="hidden" value="<%= date_create_f %>" />
<input name="<portlet:namespace />date_create_t" type="hidden" value="<%= date_create_t %>" />
<input name="<portlet:namespace />date_display_f" type="hidden" value="<%= date_display_f %>" />
<input name="<portlet:namespace />date_display_t" type="hidden" value="<%= date_display_t %>" />
<input name="<portlet:namespace />date_approved_f" type="hidden" value="<%= date_approved_f %>" />
<input name="<portlet:namespace />date_approved_t" type="hidden" value="<%= date_approved_t %>" />
<input name="<portlet:namespace />date_expiration_f" type="hidden" value="<%= date_expiration_f %>" />
<input name="<portlet:namespace />date_expiration_t" type="hidden" value="<%= date_expiration_t %>" />
<input name="<portlet:namespace />date_from" type="hidden" value="<%= date_from %>" />
<input name="<portlet:namespace />date_to" type="hidden" value="<%= date_to %>" />
<liferay-ui:tabs names="tk-user,tk-tin" url="<%= portletURL.toString() %>" />
<% int stt = 1; 
		int totalArticle = 0;
		int totalArticleApproved = 0;
		int totalArticleNotApproved = 0;
		int totalArticleCountImg = 0;
		String totalArticleIds = "";
		String totalArticleApprovedIds = "";
		String totalArticleNotApprovedIds = "";
%>
<div class="borderendTab">
	<c:choose>
		<c:when test='<%= tabs1.endsWith("tk-user") %>'>
		<input type="hidden" name="<portlet:namespace />tabs1" value="tk-user"/>
			<table width="100%">
			<tr>
				<td width="50%">
				<liferay-ui:message key="User" /> :
				<select name="<portlet:namespace />select_user">
					<option value="all" onclick="<portlet:namespace />hide_custom_user(); return false;"><liferay-ui:message key="tk-tat-ca" /></option>
					<option <%= has_userIds ? "selected" : "" %> value="custom" onclick="<portlet:namespace />show_custom_user();return false;"><liferay-ui:message key="tk-custom" /></option>
				</select>
				<br>
				<br>
				<script type="text/javascript">
					function <portlet:namespace />show_custom_user(){
						jQuery('#<portlet:namespace />custom_tk_user').show('slow');
					}
					function <portlet:namespace />hide_custom_user(){
						jQuery('#<portlet:namespace />custom_tk_user').hide('slow');
					}
				</script>
				<div id="<portlet:namespace />custom_tk_user" <%= has_userIds ? "" : "style='display: none;'" %> >
				<input name="<portlet:namespace />userIds" type="hidden" value="" />

		<%
		List<Long> listUserId = new ArrayList<Long>();
		List<User> users =  UserLocalServiceUtil.getUsers(-1,-1);
		String allMetadataFields = "";
		for(int i = 0;i<users.size(); i++){
			allMetadataFields += users.get(i).getScreenName() + ",";
			if("".equals(userIds) || "all".equals(select_user)){
				listUserId.add(users.get(i).getUserId());
			}else{
				if(userIds.contains(users.get(i).getScreenName())){
					listUserId.add(users.get(i).getUserId());
				}
			}
			
		}
		Set availableMetadataFields = SetUtil.fromArray(StringUtil.split(allMetadataFields));

		// Left list
		String[] metadataFields = userIds.split(",");
		List leftList = new ArrayList();

		for (int i = 0; i < metadataFields.length; i++) {
			String folderColumn = metadataFields[i];

			leftList.add(new KeyValuePair(folderColumn, LanguageUtil.get(pageContext, folderColumn)));
		}
		
		// Right list

		List rightList = new ArrayList();

		Arrays.sort(metadataFields);

		Iterator itr = availableMetadataFields.iterator();

		while (itr.hasNext()) {
			String folderColumn = (String)itr.next();

			if (Arrays.binarySearch(metadataFields, folderColumn) < 0) {
				rightList.add(new KeyValuePair(folderColumn, LanguageUtil.get(pageContext, folderColumn)));
			}
		}

		rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
		%>

		<liferay-ui:input-move-boxes
			formName="fm"
			leftTitle="current"
			rightTitle="available"
			leftBoxName="currentMetadataFields"
			rightBoxName="availableMetadataFields"
			leftReorder="true"
			leftList="<%= leftList %>"
			rightList="<%= rightList %>"
		/>
		</div>
			</tr>
		</table>
		<br>
		<%
		String typeDateId = portletDisplay.getNamespace() + "typeDateId";
		String title = LanguageUtil.get(pageContext, "Loai-Ngay-Thong-Ke");
		%>
		<liferay-ui:panel id="<%= typeDateId %>" title="<%= title %>" defaultState="opened" persistState="<%= true %>" extended="<%= true %>">
			<table width="100%">
			<tr>
				<td><input <%= has_create ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_create_type"  value="date_create" /> <liferay-ui:message key="create-date"/></td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_create_date_f" id="<portlet:namespace />cal_create_date_f" size="12" type="text" value="<%= date_create_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_create_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_create_date_f','<portlet:namespace/>cal_create_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_create_date_t" id="<portlet:namespace />cal_create_date_t" size="12" type="text" value="<%= date_create_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_create_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_create_date_t,'<portlet:namespace/>cal_create_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_approved ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_approved_type"  value="date_approved"/> <liferay-ui:message key="approved-date"/> </td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_approved_date_f" id="<portlet:namespace />cal_approved_date_f" size="12" type="text" value="<%= date_approved_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_approved_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_approved_date_f','<portlet:namespace/>cal_approved_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_approved_date_t" id="<portlet:namespace />cal_to_date" size="12" type="text" value="<%= date_approved_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_approved_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','<portlet:namespace/>cal_approved_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_display ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_display_type"  value="date_display"/> <liferay-ui:message key="display-date"/> </td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_display_date_f" id="<portlet:namespace />cal_display_date_f" size="12" type="text" value="<%= date_display_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_display_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_display_date_f','<portlet:namespace/>cal_display_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_display_date_t" id="<portlet:namespace />cal_display_date_t" size="12" type="text" value="<%= date_display_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_display_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_display_date_t','<portlet:namespace/>cal_display_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_expired ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_expiration_type"  value="date_expired"/> <liferay-ui:message key="expiration-date"/> </td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_expiration_date_f" id="<portlet:namespace />cal_expiration_date_f" size="12" type="text" value="<%= date_expiration_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_expiration_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_expiration_date_f','<portlet:namespace/>cal_expiration_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_expiration_date_t" id="<portlet:namespace />cal_expiration_date_t" size="12" type="text" value="<%= date_expiration_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_expiration_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_expiration_date_t','<portlet:namespace/>cal_expiration_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
		</table>
		</liferay-ui:panel>
		<br>
		<br/>
		<input type="submit" value='<liferay-ui:message key="tk-xem-ket-qua"/>' onclick="<portlet:namespace />submitTab1()"/>
		<input type="submit" value='<liferay-ui:message key="tk-xuat-report"/>' onclick="<portlet:namespace />submitReportTab1()"/>
		<div class="separator"></div>
		<% 
		List<JournalArticleUserReportDTO> list =  ReportUtil.getReportInfo(listUserId,create_f,create_t,approved_f,approved_t,display_f,display_t,expiration_f,expiration_t); 
		list =  SortUtil.sortListUserReportDTO(orderByCol,orderByType,list);
		%>
		
		<liferay-ui:search-container iteratorURL="<%= portletURL1%>" delta="20"	emptyResultsMessage="khong-co-thong-ke-nao"  orderByCol='<%= orderByCol %>' orderByType='<%= orderByType %>'>
	
		<liferay-ui:search-container-results
		results="<%= com.liferay.portal.kernel.util.ListUtil.subList(list,searchContainer.getStart(),searchContainer.getEnd()) %>"
		total="<%= list.size() %>" />
		<liferay-ui:search-container-row
		className="com.nss.portlet.thong_ke_tin.dto.JournalArticleUserReportDTO" modelVar="workflow">
		<liferay-ui:search-container-column-text name="STT"
			value="<%= String.valueOf(stt++) %>" />
		
		<liferay-ui:search-container-column-text name="name"
			value='<%= workflow.getUserName() %>' orderable="<%= true %>" />
		<c:choose>
			<c:when test='<%= workflow.getCountArticle() == 0 %>'>
			<liferay-ui:search-container-column-text name="nss-tk-bai-viet" property="countArticle" orderable="<%= true %>"/>
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticle" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIds() %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
			<% 
				totalArticle += workflow.getCountArticle(); 
				totalArticleIds += workflow.getArticleIds();
			%>
		<liferay-ui:search-container-column-text name="nss-tk-bai-viet" property="countArticle" href="<%= allArticle %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test='<%= "".equals(workflow.getArticleIdApproveds()) %>'>
			<liferay-ui:search-container-column-text name="nss-tk-bai-da-duyet" property="countArticleApproved" orderable="<%= true %>"/>
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticleApproved" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIdApproveds() %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
			<%
			totalArticleApproved += workflow.getCountArticleApproved();
			totalArticleApprovedIds += workflow.getArticleIdApproveds();
			%>
		<liferay-ui:search-container-column-text name="nss-tk-bai-da-duyet" property="countArticleApproved" href="<%= allArticleApproved %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>			
		<c:choose>
			<c:when test='<%= "".equals(workflow.getArticleIdNotApproveds()) %>'>
				<liferay-ui:search-container-column-text name="nss-tk-bai-chua-duyet" property="countArticleNotApproved" orderable="<%= true %>"/>
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticleNotApproved" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIdNotApproveds() %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
			<% 
			totalArticleNotApproved += workflow.getCountArticleNotApproved();
			totalArticleNotApprovedIds += workflow.getArticleIdNotApproveds();
			%>
		<liferay-ui:search-container-column-text name="nss-tk-bai-chua-duyet" property="countArticleNotApproved" href="<%= allArticleNotApproved %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>
		<% totalArticleCountImg += workflow.getCountArticleImage(); %>	
		<liferay-ui:search-container-column-text name="nss-tk-so-anh" property="countArticleImage" orderable="<%= true %>"/>
		
	</liferay-ui:search-container-row>
		<%
			JournalArticleUserReportDTO ja = new JournalArticleUserReportDTO();
			String text = LanguageUtil.get(request.getLocale(),"tong");
			ResultRow row2 = new ResultRow(ja,"tong",7);
			row2.addText("<b>"+text+"</b>");
			row2.addText("");
			PortletURL url = renderResponse.createRenderURL();
			url.setParameter("struts_action","/nss/thong_ke_tin/view");
			url.setParameter(com.liferay.portal.kernel.util.Constants.CMD,"detailArticle");
			url.setParameter("backURL",currentURL);
			url.setParameter("date_from",date_from);
			url.setParameter("date_to",date_to);
			if(totalArticle > 0){
				url.setParameter("articleIds",totalArticleIds);
				row2.addText("<b>"+totalArticle+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticle+"</b>");
			}
			
			if(totalArticleApproved > 0){
				url.setParameter("articleIds",totalArticleApprovedIds);
				row2.addText("<b>"+totalArticleApproved+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticleApproved+"</b>");
			}
			if(totalArticleNotApproved > 0){
				url.setParameter("articleIds",totalArticleNotApprovedIds);
				row2.addText("<b>"+totalArticleNotApproved+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticleNotApproved+"</b>");
			}
			row2.addText("<b>"+totalArticleCountImg+"</b>");
			searchContainer.getResultRows().add(row2); 
			
		%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	
</liferay-ui:search-container>
		</c:when>
		<c:when test='<%= tabs1.equals("tk-tin") %>'>
		<input type="hidden" name="<portlet:namespace />tabs1" value="tk-tin"/>
			<table width="100%">
			<tr>
				<td width="50%">
				<liferay-ui:message key="Loai-Tin" /> :
				<select name="<portlet:namespace />select_category">
					<option value="all" onclick="<portlet:namespace />hide_custom_category();return false;"><liferay-ui:message key="tk-tat-ca" /></option>
					<option <%= hasCategoryNames ? "selected" : "" %> value="custom" onclick="<portlet:namespace />show_custom_category();return false;"><liferay-ui:message key="tk-custom" /></option>
				</select>
				<br>
				<br>
				<script type="text/javascript">
					function <portlet:namespace />show_custom_category(){
						jQuery('#<portlet:namespace />custom_tk_tin').show('slow');
					}
					function <portlet:namespace />hide_custom_category(){
						jQuery('#<portlet:namespace />custom_tk_tin').hide('slow');
					}
				</script>
				<div id="<portlet:namespace />custom_tk_tin" <%= hasCategoryNames ? "" : "style='display: none;'" %>>
				<input name="<portlet:namespace />categoryNames" type="hidden" value="" />

		<%
		
		String allMetadataFields = "";
		List<TagsVocabulary> vocabularies = TagsVocabularyLocalServiceUtil.getTagsVocabularies(-1,-1);
		List<Long> allVocabulary = new ArrayList<Long>();
		
		for(int i = 0;i< vocabularies.size();i++){
			if(!vocabularies.get(i).getFolksonomy()){
				allMetadataFields += vocabularies.get(i).getName() + ",";
				if("".equals(categoryNames) || "all".equals(select_category)){
					allVocabulary.add(vocabularies.get(i).getVocabularyId());
				}else{
					if(categoryNames.contains(vocabularies.get(i).getName())){
						allVocabulary.add(vocabularies.get(i).getVocabularyId());
					}
				}
				
			}
		}
		Set availableMetadataFields = SetUtil.fromArray(StringUtil.split(allMetadataFields));

		// Left list
		String[] metadataFields = categoryNames.split(",");
		List leftList = new ArrayList();

		for (int i = 0; i < metadataFields.length; i++) {
			String folderColumn = metadataFields[i];

			leftList.add(new KeyValuePair(folderColumn, LanguageUtil.get(pageContext, folderColumn)));
		}

		// Right list

		List rightList = new ArrayList();

		Arrays.sort(metadataFields);

		Iterator itr = availableMetadataFields.iterator();

		while (itr.hasNext()) {
			String folderColumn = (String)itr.next();

			if (Arrays.binarySearch(metadataFields, folderColumn) < 0) {
				rightList.add(new KeyValuePair(folderColumn, LanguageUtil.get(pageContext, folderColumn)));
			}
		}

		rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
		%>

		<liferay-ui:input-move-boxes
			formName="fm"
			leftTitle="current"
			rightTitle="available"
			leftBoxName="currentMetadataFields"
			rightBoxName="availableMetadataFields"
			leftReorder="true"
			leftList="<%= leftList %>"
			rightList="<%= rightList %>"
		/>
		</div>
			</tr>
		</table>
		<br>
		<%
		String typeDateId = portletDisplay.getNamespace() + "typeDateId";
		String title = LanguageUtil.get(pageContext, "Loai-Ngay-Thong-Ke");
		%>
		<liferay-ui:panel id="<%= typeDateId %>" title="<%= title %>" defaultState="opened" persistState="<%= true %>" extended="<%= true %>">
			<table width="100%">
			<tr>
				<td><input <%= has_create ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_create_type"  value="date_create" /><liferay-ui:message key="create-date"/></td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_create_date_f" id="<portlet:namespace />cal_create_date_f" size="12" type="text" value="<%= date_create_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_create_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_create_date_f','<portlet:namespace/>cal_create_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_create_date_t" id="<portlet:namespace />cal_create_date_t" size="12" type="text" value="<%= date_create_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_create_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_create_date_t,'<portlet:namespace/>cal_create_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_approved ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_approved_type"  value="date_approved"/><liferay-ui:message key="approved-date"/></td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_approved_date_f" id="<portlet:namespace />cal_approved_date_f" size="12" type="text" value="<%= date_approved_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_approved_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_approved_date_f','<portlet:namespace/>cal_approved_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_approved_date_t" id="<portlet:namespace />cal_to_date" size="12" type="text" value="<%= date_approved_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_approved_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','<portlet:namespace/>cal_approved_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_display ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_display_type"  value="display-date"/> <liferay-ui:message key="date-display"/> </td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_display_date_f" id="<portlet:namespace />cal_display_date_f" size="12" type="text" value="<%= date_display_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_display_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_display_date_f','<portlet:namespace/>cal_display_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_display_date_t" id="<portlet:namespace />cal_display_date_t" size="12" type="text" value="<%= date_display_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_display_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_display_date_t','<portlet:namespace/>cal_display_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
			<tr>
				<td><input <%= has_expired ? "checked" : " " %> type="checkbox" name="<portlet:namespace/>date_expiration_type"  value="date_expired"/> <liferay-ui:message key="expiration-date"/> </td>
				<td><liferay-ui:message key="tk-tu-ngay"/>: <input name="<portlet:namespace />cal_expiration_date_f" id="<portlet:namespace />cal_expiration_date_f" size="12" type="text" value="<%= date_expiration_f %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" style="cursor: pointer;" id="<portlet:namespace/>cal_expiration_bdate_f" onClick="callCalendar('<portlet:namespace/>cal_expiration_date_f','<portlet:namespace/>cal_expiration_bdate_f')" />
						<br>
						(dd/mm/yyyy)
						</td></td>
				<td><liferay-ui:message key="tk-den-ngay"/>: <input name="<portlet:namespace />cal_expiration_date_t" id="<portlet:namespace />cal_expiration_date_t" size="12" type="text" value="<%= date_expiration_t %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
						<img src="/html/images/cal.gif" id="<portlet:namespace/>cal_expiration_bdate_t" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_expiration_date_t','<portlet:namespace/>cal_expiration_bdate_t')" />
						<br>
						(dd/mm/yyyy)</td>
			</tr>
		</table>
		</liferay-ui:panel>
		<br>
		<br/>
		<input type="submit" value='<liferay-ui:message key="tk-xem-ket-qua"/>' onclick="<portlet:namespace />submitTab2()"/>
		<input type="submit" value='<liferay-ui:message key="tk-xuat-report"/>' onclick="<portlet:namespace />submitReportTab2()"/>
		<div class="separator"></div>
		<% 
		List<JournalArticleCategoryReoportDTO> list =  ReportUtil.getReportInfoByVocabulary(allVocabulary,create_f,create_t,approved_f,approved_t,display_f,display_t,expiration_f,expiration_t); 
		list = SortUtil.sortListCategoryReportDTO(orderByCol,orderByType,list);
		%>
		
		<liferay-ui:search-container delta="20" iteratorURL="<%= portletURL1%>" emptyResultsMessage="khong-co-thong-ke-nao"  orderByCol='<%= orderByCol %>' orderByType='<%= orderByType %>'>
		<liferay-ui:search-container-results
		results="<%= com.liferay.portal.kernel.util.ListUtil.subList(list,searchContainer.getStart(),searchContainer.getEnd()) %>"
		total="<%= list.size() %>" />
		<liferay-ui:search-container-row
		className="com.nss.portlet.thong_ke_tin.dto.JournalArticleCategoryReoportDTO" modelVar="workflow">
		
		<liferay-ui:search-container-column-text name="stt"
			value="<%= String.valueOf(stt++) %>"/>
		
		<liferay-ui:search-container-column-text name="nss-tk-loai-tin"
			value='<%= workflow.getName() %>' orderable="<%= true %>" />
		<c:choose>
			<c:when test='<%= workflow.getCountArticle() == 0 %>'>
				<liferay-ui:search-container-column-text name="nss-tk-bai-viet" property="countArticle" orderable="<%= true %>"/>
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticle" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIds() %>" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
				<% 
				totalArticle += workflow.getCountArticle(); 
				totalArticleIds += workflow.getArticleIds();
				%>
				<liferay-ui:search-container-column-text name="nss-tk-bai-viet" property="countArticle" href="<%= allArticle %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%= "".equals(workflow.getArticleIdApproveds()) %>'>
			<liferay-ui:search-container-column-text name="nss-tk-bai-da-duyet" property="countArticleApproved" orderable="<%= true %>" />
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticleApproved" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIdApproveds() %>" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
				<%
			totalArticleApproved += workflow.getCountArticleApproved();
			totalArticleApprovedIds += workflow.getArticleIdApproveds();
			%>
		<liferay-ui:search-container-column-text name="nss-tk-bai-da-duyet" property="countArticleApproved" href="<%= allArticleApproved %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>	
		<c:choose>
			<c:when test='<%= "".equals(workflow.getArticleIdNotApproveds()) %>'>
				<liferay-ui:search-container-column-text name="nss-tk-bai-chua-duyet" property="countArticleNotApproved" orderable="<%= true %>"/>
			</c:when>
			<c:otherwise>
				<portlet:renderURL var="allArticleNotApproved" windowState="<%= WindowState.NORMAL.toString() %>">
					<portlet:param name="struts_action" value="/nss/thong_ke_tin/view" />
					<portlet:param name="articleIds" value="<%= workflow.getArticleIdNotApproveds() %>" />
					<portlet:param name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" value="detailArticle" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="date_from" value="<%= date_from %>" />
					<portlet:param name="date_to" value="<%= date_to %>" />
				</portlet:renderURL>
			<% 
			totalArticleNotApproved += workflow.getCountArticleNotApproved();
			totalArticleNotApprovedIds += workflow.getArticleIdNotApproveds();
			%>
		<liferay-ui:search-container-column-text name="nss-tk-bai-chua-duyet" property="countArticleNotApproved" href="<%= allArticleNotApproved %>" orderable="<%= true %>"/>
			</c:otherwise>
		</c:choose>				
		
		<% totalArticleCountImg += workflow.getCountArticleImage(); %>
		<liferay-ui:search-container-column-text name="nss-tk-so-anh" property="countArticleImage" orderable="<%= true %>"/>
	</liferay-ui:search-container-row>
		<%
			JournalArticleCategoryReoportDTO ja = new JournalArticleCategoryReoportDTO();
			String text = LanguageUtil.get(request.getLocale(),"tong");
			ResultRow row2 = new ResultRow(ja,"tong",7);
			row2.addText("<b>"+text+"</b>");
			row2.addText("");
			PortletURL url = renderResponse.createRenderURL();
			url.setParameter("struts_action","/nss/thong_ke_tin/view");
			url.setParameter(com.liferay.portal.kernel.util.Constants.CMD,"detailArticle");
			url.setParameter("backURL",currentURL);
			url.setParameter("date_from",date_from);
			url.setParameter("date_to",date_to);
			if(totalArticle > 0){
				url.setParameter("articleIds",totalArticleIds);
				row2.addText("<b>"+totalArticle+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticle+"</b>");
			}
			
			if(totalArticleApproved > 0){
				url.setParameter("articleIds",totalArticleApprovedIds);
				row2.addText("<b>"+totalArticleApproved+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticleApproved+"</b>");
			}
			if(totalArticleNotApproved > 0){
				url.setParameter("articleIds",totalArticleNotApprovedIds);
				row2.addText("<b>"+totalArticleNotApproved+"</b>",url);
			}else{
				row2.addText("<b>"+totalArticleNotApproved+"</b>");
			}
			row2.addText("<b>"+totalArticleCountImg+"</b>");
			searchContainer.getResultRows().add(row2); 
			
		%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>
		</c:when>
	</c:choose>
</div>
</form>
<script type="text/javascript">

function <portlet:namespace />submitTab1() {
	document.<portlet:namespace />fm.<portlet:namespace />userIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentMetadataFields);
}
function <portlet:namespace />submitReportTab1() {
	document.<portlet:namespace />fm.<portlet:namespace />userIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentMetadataFields);
	submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/nss/thong_ke_tin/view" /><portlet:param name="report" value="reportUser" /></portlet:actionURL>");
}
function <portlet:namespace />submitTab2() {
	document.<portlet:namespace />fm.<portlet:namespace />categoryNames.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentMetadataFields);
}
function <portlet:namespace />submitReportTab2() {
	document.<portlet:namespace />fm.<portlet:namespace />categoryNames.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentMetadataFields);
	submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/nss/thong_ke_tin/view" /><portlet:param name="report" value="reportCategory" /></portlet:actionURL>");
}
</script>