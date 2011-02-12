<%@ include file="/html/portlet/ext/holiday_calendar/init.jsp" %>


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
<%@page import="com.sgs.portlet.holiday_calendar.search.HolidayCalendarSearchTerms"%>
<%@page import="com.sgs.portlet.holiday_calendar.search.HolidayCalendarDisplayTerms"%>
<%@page import="com.sgs.portlet.holiday_calendar.search.HolidayCalendarSearch"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.AttactFileHoliday"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.HolidayCalendar"%>
<%@page import="com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/holiday_calendar/view");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
%>

<div class="title_categ"><liferay-ui:message key="holiday-calendar"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<%
    	HolidayCalendarSearch holidayCalendarSearch = new HolidayCalendarSearch(renderRequest, portletURL);
    	HolidayCalendarDisplayTerms displayTerms = (HolidayCalendarDisplayTerms)holidayCalendarSearch.getDisplayTerms();
    	HolidayCalendarSearchTerms searchTerms = (HolidayCalendarSearchTerms) holidayCalendarSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", HolidayCalendarDisplayTerms.HOLIDAYCALENDARCODE);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = holidayCalendarSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/holiday_calendar/holiday_calendar_search_form.jsp" searchContainer="<%= holidayCalendarSearch %>" />
			<%
				PortletURL addURL = renderResponse.createActionURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/holiday_calendar/view");
				addURL.setParameter("tab", "add_holiday_calendar");
				addURL.setParameter(Constants.CMD,"DELETEATTACT");
				addURL.setParameter("redirect", portletURLString);
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-holiday-calendar"/>' /></span></a>
				<%
				int count = HolidayCalendarLocalServiceUtil.countHolidayCalendarTest(searchTerms.getHolidayCalendarCode(), searchTerms.getHolidayCalendarTitle(), searchTerms.getDateFrom(), searchTerms.getDateTo(), searchTerms.isAndOperator());
				List<HolidayCalendar> listHolidayCalendar = HolidayCalendarLocalServiceUtil.findHolidayCalendarTest(searchTerms.getHolidayCalendarCode(), searchTerms.getHolidayCalendarTitle(),
						 searchTerms.getDateFrom(), searchTerms.getDateTo(), holidayCalendarSearch.getStart(), holidayCalendarSearch.getEnd(), searchTerms.isAndOperator(), holidayCalendarSearch.getOrderByComparator());
				
				holidayCalendarSearch.setTotal(count);
				holidayCalendarSearch.setResults(listHolidayCalendar);
				portletURL.setParameter(holidayCalendarSearch.getCurParam(), String.valueOf(holidayCalendarSearch.getCurValue()));
				List<ResultRow> resultRows = holidayCalendarSearch.getResultRows();
					
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
						
						// edit
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter("struts_action","/sgs/holiday_calendar/view");
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("tab", "edit_holiday_calendar");
						rowURLEdit.setParameter("holidayCalendarId", String.valueOf(holidayCalendarId));
						rowURLEdit.setParameter("redirect", holidayCalendarSearch.getIteratorURL().toString());
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/holiday_calendar/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("holidayCalendarId", String.valueOf(holidayCalendarId));
						rowURLEdit.setParameter("redirect", holidayCalendarSearch.getIteratorURL().toString());
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
			<liferay-ui:search-iterator searchContainer="<%= holidayCalendarSearch %>" />
	</form>
</div>
