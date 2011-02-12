<%@ include file="/html/portlet/ext/holiday_calendar_index/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.holiday_calendar_index.search.HolidayCalendarIndexSearchTerms"%>
<%@page import="com.sgs.portlet.holiday_calendar_index.search.HolidayCalendarIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.holiday_calendar_index.search.HolidayCalendarIndexSearch"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.AttactFileHoliday"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.HolidayCalendar"%>
<%@page import="com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/holiday_calendar_index/view");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
%>

<div class="title_categ"><liferay-ui:message key="holiday-calendar"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<%
    	HolidayCalendarIndexSearch holidayCalendarIndexSearch = new HolidayCalendarIndexSearch(renderRequest, portletURL);
    	HolidayCalendarIndexDisplayTerms displayTerms = (HolidayCalendarIndexDisplayTerms)holidayCalendarIndexSearch.getDisplayTerms();
    	HolidayCalendarIndexSearchTerms searchTerms = (HolidayCalendarIndexSearchTerms) holidayCalendarIndexSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", HolidayCalendarIndexDisplayTerms.HOLIDAYCALENDARCODE);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = holidayCalendarIndexSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/holiday_calendar_index/holiday_calendar_search_form.jsp" searchContainer="<%= holidayCalendarIndexSearch %>" />
				<%
				int count = HolidayCalendarLocalServiceUtil.countHolidayCalendarTest(searchTerms.getHolidayCalendarCode(), searchTerms.getHolidayCalendarTitle(), searchTerms.getDateFrom(), searchTerms.getDateTo(), searchTerms.isAndOperator());
				List<HolidayCalendar> listHolidayCalendar = HolidayCalendarLocalServiceUtil.findHolidayCalendarTest(searchTerms.getHolidayCalendarCode(), searchTerms.getHolidayCalendarTitle(),
						 searchTerms.getDateFrom(), searchTerms.getDateTo(), holidayCalendarIndexSearch.getStart(), holidayCalendarIndexSearch.getEnd(), searchTerms.isAndOperator(), holidayCalendarIndexSearch.getOrderByComparator());
				
				holidayCalendarIndexSearch.setTotal(count);
				holidayCalendarIndexSearch.setResults(listHolidayCalendar);
				portletURL.setParameter(holidayCalendarIndexSearch.getCurParam(), String.valueOf(holidayCalendarIndexSearch.getCurValue()));
				List<ResultRow> resultRows = holidayCalendarIndexSearch.getResultRows();
					
					for(int i = 0; i < listHolidayCalendar.size(); i++){
						HolidayCalendar holidayCalendar = listHolidayCalendar.get(i);
						long holidayCalendarId = holidayCalendar.getHolidayCalendarId();
						List<AttactFileHoliday> attactFileHolidays = HolidayCalendarLocalServiceUtil.getAttactFileHolidays(holidayCalendarId);
						
						ResultRow row = new ResultRow(holidayCalendar, holidayCalendarId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//code
						row.addText(holidayCalendar.getHolidayCalendarCode());
						
						//date create
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						if(holidayCalendar.getHolidayCalendarDateCreate() != null){
							String dateNow = simpleDateFormat.format(holidayCalendar.getHolidayCalendarDateCreate());
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// view
						String linkHolidayFile = "";
						for(AttactFileHoliday attactFileHoliday : attactFileHolidays){
							String title = attactFileHoliday.getAttactFileHolidayTitle();
							if(!attactFileHoliday.getAttactFileHolidayTitle().equals("")){
								try{
									title = (String) title.subSequence(0,title.lastIndexOf("_"));
									title = (String) title.subSequence(0,title.lastIndexOf("_"));
									linkHolidayFile += title + "<br>";
								}catch(Exception e){
								}
							}
						}
						row.addText(linkHolidayFile);
						
						// download
						String linkHolidayDownload = "";
						for(AttactFileHoliday attactFileHoliday : attactFileHolidays){
							String title = attactFileHoliday.getAttactFileHolidayPath();
							String path = attactFileHoliday.getAttactFileHolidayPath();
							if(!attactFileHoliday.getAttactFileHolidayTitle().equals("")){
								try{
									linkHolidayDownload += "<a href =" + path + ">" + path.substring(path.lastIndexOf("/")+15) + "</a>" + "<br>";
								}catch(Exception e){
								}
							}
						}
						row.addText(linkHolidayDownload);
						
						resultRows.add(row);
					}
			%>
		
			<liferay-ui:search-iterator searchContainer="<%= holidayCalendarIndexSearch %>" />
	</form>
</div>
