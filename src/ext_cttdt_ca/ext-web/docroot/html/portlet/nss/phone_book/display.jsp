<%@page import="com.nss.portlet.phone_book.search.ContactBookSearchTerms"%>
<%@ include file="/html/portlet/nss/phone_book/init.jsp" %>

<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.phone_book.search.ContactBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.ContactBookSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.io.File"%>

	<%	
		String notDeleteContact = (String) request.getAttribute("NotDeleteContact") ;
		List<ContactBook> contactBooks = ContactBookLocalServiceUtil.getContactBooks(-1,-1);
		String contactBookCodesString = "";
		String contactBookNamesString = "";
		String contactBookDescriptionsString = "";
			for(ContactBook contactBook : contactBooks){
				contactBookCodesString += contactBook.getContactBookCode() +"/";
				contactBookNamesString += contactBook.getContactBookName() +"/";
				contactBookDescriptionsString += contactBook.getContactDescription() +"/";
			}
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("struts_action", "/nss/phone_book/view");
	%> 
	<% if(notDeleteContact != null){ %>
		<div style="color: red"><liferay-ui:message key="not-delete-contact" /></div>
	<%}%>   
	
<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%
			ContactBookSearch contactBookSearch = new ContactBookSearch(renderRequest, portletURL);
    		ContactBookDisplayTerms displayTerms = (ContactBookDisplayTerms)contactBookSearch.getDisplayTerms();
    		ContactBookSearchTerms searchTerms = (ContactBookSearchTerms) contactBookSearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", ContactBookDisplayTerms.NAME);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = contactBookSearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="titlecategr" style="margin-bottom: 15px;"><h4><p><liferay-ui:message key="nss-phone-book" /></p></h4></div>
		<liferay-ui:search-form	page="/html/portlet/nss/phone_book/search_form.jsp"	searchContainer="<%= contactBookSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/nss/phone_book/view");
				addURL.setParameter("tabs", "add");
				addURL.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
		<br><br>
		
				<%
				int count = 0;
				List<ContactBook> listContactBook = new ArrayList<ContactBook>();
				
					if (!displayTerms.isAdvancedSearch()) {
						count = ContactBookLocalServiceUtil.countByKeyword(searchTerms.getKeywords());
						listContactBook = ContactBookLocalServiceUtil.findByKeyword(searchTerms.getKeywords(),contactBookSearch.getStart(),
									contactBookSearch.getEnd(),searchTerms.isAndOperator(),contactBookSearch.getOrderByComparator());
					} else {
						count = ContactBookLocalServiceUtil.countContactBook(searchTerms.getContactBookCode(),searchTerms.getContactBookName(),searchTerms.getContactDescription(),searchTerms.isAndOperator());
						listContactBook = ContactBookLocalServiceUtil.findContactBook(searchTerms.getContactBookCode(),searchTerms.getContactBookName(),searchTerms.getContactDescription(),
									contactBookSearch.getStart(), contactBookSearch.getEnd(),searchTerms.isAndOperator(),contactBookSearch.getOrderByComparator());
					}
					
					ContactBook contactBook = null;
					long contactBookId = 0;
					
					contactBookSearch.setTotal(count);
					contactBookSearch.setResults(listContactBook);
					portletURL.setParameter(contactBookSearch.getCurParam(), String.valueOf(contactBookSearch.getCurValue()));
					
					List<ResultRow> resultRows = contactBookSearch.getResultRows();
					ResultRow row = null;
					
					String update = "";
					String deleteAction = "";
					String active = "";
					
					for(int i = 0; i < listContactBook.size(); i++){
						contactBook = listContactBook.get(i);
						contactBookId = contactBook.getContactBookId();
						row = new ResultRow(contactBook, contactBookId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						// code
						//URL detail
						PortletURL rowURLDetail= renderResponse.createActionURL();
						rowURLDetail.setWindowState(WindowState.NORMAL);
						rowURLDetail.setParameter("struts_action","/nss/phone_book/view");
						rowURLDetail.setParameter(Constants.CMD,"DETAIL");
						rowURLDetail.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLDetail.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						rowURLDetail.setParameter("tabs", "detail");
						
						row.addText(contactBook.getContactBookCode(), rowURLDetail.toString());
						
						// name
						row.addText(contactBook.getContactBookName(), rowURLDetail.toString());
						
						// mo ta 
						row.addText(contactBook.getContactDescription(), rowURLDetail.toString());
						
						//active 
						//URL active
						PortletURL rowURLActive= renderResponse.createActionURL();
						rowURLActive.setWindowState(WindowState.NORMAL);
						rowURLActive.setParameter("struts_action","/nss/phone_book/view");
						rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
						rowURLActive.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLActive.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						
						if (true == contactBook.getContactActive()) {
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
						} else if (false == contactBook.getContactActive()){
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
						}
						row.addText(active);
						
						// edit
						//URL update
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/nss/phone_book/view");
						rowURLEdit.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLEdit.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tabs", "edit");
						
						update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(update);
						
						// delete
						//URL delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/nss/phone_book/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLDelete.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						
						deleteAction = "<a  href='javascript: ;' onclick=deleteContactBook('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= contactBookSearch %>" />
	</div>
</form>

<script type="text/javascript">
	var myCode =  "<%= contactBookCodesString %>".split("/");
	var myName =  "<%= contactBookNamesString %>".split("/");
	var myDescription =  "<%= contactBookDescriptionsString %>".split("/");

	jQuery("#<portlet:namespace/>contactBookCodeAutoComplete").autocomplete({
		data : myCode
	});
	jQuery("#<portlet:namespace/>contactBookNameAutoComplete").autocomplete({
		data : myName
	});
	jQuery("#<portlet:namespace/>contactBookDescriptionAutoComplete").autocomplete({
		data : myDescription
	});
	
	function deleteContactBook(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
	
</script>    	
   