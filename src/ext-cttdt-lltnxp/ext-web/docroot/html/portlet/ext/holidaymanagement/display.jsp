<%@ include file="/html/portlet/ext/holidaymanagement/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.holidaymanagement.search.HolidaySearch"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.holiday.model.PmlHoliday"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil"%><portlet:renderURL var="add">
	<portlet:param name="struts_action" value="/sgs/holidaymanagement/view" />
	<portlet:param name="tab" value="add" />
</portlet:renderURL>

<script type="text/javascript">
function getSelectRadio(elementRow)
{		
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('holidayId'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

function clickRadio(event)
{
	
	if (event) // firefox
	{
		event.stopPropagation();	
	}
	else // windows
		window.event.cancelBubble = true;
	return true; // co the false, bo
}

function validate() {
	
	var arrRadioElements = document.getElementsByName("holidayId");
	
	var res = false;
	for ( var i = 0; i < arrRadioElements.length; i++) {
		if (arrRadioElements[i].checked) {
			res = true;
			break;
		}		
	}

	if(!res) {
		return false;
	}

	else {
		return true;
	}
		
}

function deleteHoliday(url) {		
	if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}
</script>

<%
	PortletURL displayURL = renderResponse.createRenderURL();
	displayURL.setWindowState(WindowState.NORMAL);
	displayURL.setParameter("struts_action", "/sgs/holidaymanagement/view");
%>

<form method="post" name="<portlet:namespace />fm" action="<%=add %>">
<input name="<portlet:namespace />holidayURL" type="hidden" value="<%= displayURL.toString() %>" />
<div class="title_categ"><liferay-ui:message key="javax.portlet.title.SGS_HOLIDAYMANAGEMENT"/></div>
<div class="boxcontent">
	<%
		HolidaySearch holidaySearch = new HolidaySearch(renderRequest, displayURL);
		// URL add
		PortletURL addURL = renderResponse.createRenderURL();
		addURL.setWindowState(WindowState.NORMAL);
		addURL.setParameter("struts_action", "/sgs/holidaymanagement/view");
		addURL.setParameter("tab", "add");
		addURL.setParameter("redirect", holidaySearch.getIteratorURL().toString());
	%>
	
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addURL.toString() %>');">
	<input  type="button"  value="<liferay-ui:message key="add_new"/>"/>
	</span>
	<%
		
	
		List<PmlHoliday> listHoliday = PmlHolidayLocalServiceUtil.findListPmlHoliday(holidaySearch.getStart(), holidaySearch.getEnd());
		int total = PmlHolidayLocalServiceUtil.countListPmlHoliday();
		holidaySearch.setTotal(total);
		holidaySearch.setResults(listHoliday);
		displayURL.setParameter(holidaySearch.getCurParam(), String.valueOf(holidaySearch.getCurValue()));
		
		List resultRows = holidaySearch.getResultRows();
		ResultRow row = null;
		PmlHoliday holiday = null;
		
		String update= "";
		String delete = "";
		
		for (int i = 0; i <listHoliday.size(); i++) {
			String holidayValue = "";
			String holidayType = "";
			
			holiday = listHoliday.get(i);
			row = new ResultRow(holiday, holiday.getHolidayId(), i);
			
			String type = LanguageUtil.get(pageContext, "holiday-ngay-nghi-le");
			holidayType = holiday.getHoliday_type();
			if ("1".equals(holidayType)) {
				type = LanguageUtil.get(pageContext, "holiday-nghi-buoi-sang");
			}
			if ("2".equals(holidayType)) {
				type = LanguageUtil.get(pageContext, "holiday-nghi-buoi-chieu");
			}
			if ("3".equals(holidayType)) {
				type = LanguageUtil.get(pageContext, "holiday-nghi-ca-ngay");
			}
			
			holidayValue = holiday.getHoliday_value();
			if ("MON".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.monday");
			}
			if ("TUES".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.tuesday");
			}
			if ("WEDNES".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.wednesday");
			}
			if ("THURS".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.thursday");
			}
			if ("FRI".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.friday");
			}
			if ("SATUR".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.saturday");
			}
			if ("SUN".equals(holidayValue)) {
				holidayValue = LanguageUtil.get(pageContext, "calendar.add_personalevent.sunday");
			}
			
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("struts_action", "/sgs/holidaymanagement/view");
			rowURLEdit.setParameter("holidayId", String.valueOf(holiday.getHolidayId()));
			rowURLEdit.setParameter("tab", "edit");
			rowURLEdit.setParameter("redirect", holidaySearch.getIteratorURL().toString());
			
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/holidaymanagement/view");
			rowURLDelete.setParameter("holidayId", String.valueOf(holiday.getHolidayId()));
			rowURLDelete.setParameter(Constants.ACTION, Constants.DELETE);
			rowURLDelete.setParameter("redirect", holidaySearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			delete = "<a  href='javascript: ;' onclick=deleteHoliday('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(String.valueOf(i+1));
			row.addText(type);
			row.addText(holidayValue);
			row.addText(update);
			row.addText(delete);
			
			resultRows.add(row);
		}
	%>
	
	<liferay-ui:search-iterator searchContainer="<%=holidaySearch %>" />
</div>
 </form>

<% 
Boolean flag = (Boolean) renderRequest.getAttribute("flag") == null ? true : (Boolean) renderRequest.getAttribute("flag");
if (flag != null && !flag) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-rang-buoc'/>");
	</script>
<%	
}
%>
