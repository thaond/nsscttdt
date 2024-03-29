<%@ include file="/html/portlet/nss/phone_book/init.jsp" %>

<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.phone_book.search.ContactBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.ContactBookSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
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
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", ContactBookDisplayTerms.NAME);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = contactBookSearch.getOrderByType().toLowerCase();
    		boolean reverse = false;
    		
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-phone-book" /></div>
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
				
					Hits hits = null;
					if (!displayTerms.isAdvancedSearch()) {
						hits = ContactBookLocalServiceUtil.search(user.getCompanyId(),displayTerms.getKeywords(),
								orderByCol, sortType, reverse,contactBookSearch.getStart(),contactBookSearch.getEnd());
					} else {
						hits = ContactBookLocalServiceUtil.search(user.getCompanyId(),
								displayTerms.getContactBookCode().trim().length() == 0 ? "" : (displayTerms.getContactBookCode() + "*"),
								displayTerms.getContactBookName().trim().length() == 0 ? "" : (displayTerms.getContactBookName() + "*"),
								displayTerms.getContactDescription().trim().length() == 0 ? "" : (displayTerms.getContactDescription() + "*"),				
								orderByCol, sortType, reverse,contactBookSearch.getStart(),contactBookSearch.getEnd());		
					}
					
					int total = hits.getLength();
					List resultRows = contactBookSearch.getResultRows();
					ResultRow row = null;
					ContactBook contactBook = null;
					long contactBookId = 0;
					String update = "";
					String deleteAction = "";
					String active = "";
					int j = 0;
					
					for (int i = 0; i < hits.getDocs().length; i ++) {
						int stt = j+1;
						contactBookId = GetterUtil.getInteger(hits.doc(i).get(Field.ENTRY_CLASS_PK));
						try{
							contactBook  = ContactBookLocalServiceUtil.getContactBook(contactBookId);
							j++;
						}catch(Exception e){
							total --;
						}
						if(contactBook != null){
							row = new ResultRow(contactBook, contactBook.getContactBookId(), i);
							// STT
							row.addText(String.valueOf(stt));
							
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
					}
				contactBookSearch.setTotal(total);
				portletURL.setParameter(contactBookSearch.getCurParam(), String.valueOf(contactBookSearch.getCurValue()));
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= contactBookSearch %>" />
	</div>
</form>

<script>
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
   