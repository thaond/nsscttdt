
<%@ include file="/html/portlet/nss/phone_book/init.jsp" %>

<%@page import="com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil"%>
<%@page import="com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil"%>
<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="com.nss.portlet.phone_book.model.DetailBook"%>
<%@page import="com.nss.portlet.phone_book.search.DetailBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.DetailBookSearch"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
	long contactBookId =0;
	String contactBookCode = "";
	String contactBookName = "";
	String contactBookDescription = "";
	try{
		ContactBook contactBook = (ContactBook) request.getAttribute("contactBook");
		contactBookId = contactBook.getContactBookId();
		contactBookCode = contactBook.getContactBookCode();
		contactBookName = contactBook.getContactBookName();
		contactBookDescription = contactBook.getContactDescription();
	}catch(Exception e){
		contactBookId = ParamUtil.getLong(renderRequest, "contactBookId");
	}
		
		String redirect = ParamUtil.getString(renderRequest, "redirect", "/nss/phone_book/view");
		List<DetailBook> detailBooks = ContactBookLocalServiceUtil.getDetailBooks(contactBookId);
		String detailBookCodes = "";
		String detailBookNames = "";
		String detailBookDescriptions = "";
		String detailBookZips = "";
		String detailBookInternals = "";
		String detailBookHomes = "";
		String detailBookMobiles = "";
		for(DetailBook detailBook : detailBooks){
			detailBookCodes += detailBook.getDetailBookCode() + "/";
			detailBookNames += detailBook.getDetailBookName() + "/";
			detailBookDescriptions += detailBook.getDetailDescription() + "/";
			detailBookZips += detailBook.getZip() + "/";
			detailBookInternals += detailBook.getInternal() + "/";  
			detailBookHomes += detailBook.getHome() + "/";
			detailBookMobiles += detailBook.getMobile() + "/";
		}
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("struts_action", "/nss/phone_book/view");
		portletURL.setParameter(Constants.CMD,"DETAIL");
		portletURL.setParameter("tabs", "detail");
		portletURL.setParameter("contactBookId", String.valueOf(contactBookId));
	%> 

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%	
    		DetailBookSearch detailBookSearch = new DetailBookSearch(renderRequest,portletURL);
    		DetailBookDisplayTerms displayTerms = (DetailBookDisplayTerms)detailBookSearch.getDisplayTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DetailBookDisplayTerms.NAME);
    		
    		int sortType = Sort.STRING_TYPE;

    		String orderByType = detailBookSearch.getOrderByType().toLowerCase();
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-phone-book" /></div>
		<liferay-ui:search-form
			page="/html/portlet/nss/phone_book/search_form_detail.jsp" searchContainer="<%= detailBookSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/nss/phone_book/view_detail");
				addURL.setParameter("tabs", "add");
				addURL.setParameter("contactBookId", String.valueOf(contactBookId));
				addURL.setParameter("redirect", detailBookSearch.getIteratorURL().toString());
				
				PortletURL backURL = renderResponse.createRenderURL();
				backURL.setWindowState(WindowState.NORMAL);
				backURL.setParameter("struts_action", "/nss/phone_book/view");
			
			%>
			<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
			<a href="<%= backURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' /></span></a>
			<br><br>
			<%
					Hits hits = null;
					if (!displayTerms.isAdvancedSearch()) {
						hits = DetailBookLocalServiceUtil.search(user.getCompanyId(),contactBookId,displayTerms.getKeywords(),
								orderByCol, sortType, reverse,detailBookSearch.getStart(),detailBookSearch.getEnd());
					} else {
						hits = DetailBookLocalServiceUtil.search(user.getCompanyId(),contactBookId,
								displayTerms.getDetailBookCode().trim().length() == 0 ? "" : (displayTerms.getDetailBookCode() + "*"),
								displayTerms.getDetailBookName().trim().length() == 0 ? "" : (displayTerms.getDetailBookName() + "*"),
								displayTerms.getDetailDescription().trim().length() == 0 ? "" : (displayTerms.getDetailDescription() + "*"),				
								displayTerms.getZip().trim().length() == 0 ? "" : (displayTerms.getZip() + "*"),
								displayTerms.getInternal().trim().length() == 0 ? "" : (displayTerms.getInternal() + "*"),
								displayTerms.getHome().trim().length() == 0 ? "" : (displayTerms.getHome() + "*"),
								displayTerms.getMobile().trim().length() == 0 ? "" : (displayTerms.getMobile() + "*"),
								orderByCol, sortType, reverse,detailBookSearch.getStart(),detailBookSearch.getEnd());
					}
					
					int total = hits.getLength();
					List resultRows = detailBookSearch.getResultRows();
					ResultRow row = null;
					DetailBook detailBook = null;
					int detailBookId = 0;
					String update = "";
					String deleteAction = "";
					String active = "";
					int j = 0;
					
					for (int i = 0; i < hits.getDocs().length; i ++) {
						int stt = j+1;
						detailBookId = GetterUtil.getInteger(hits.doc(i).get(Field.ENTRY_CLASS_PK));
						try{
							detailBook  = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
							if(detailBook.getContactBookId() == contactBookId){
								j++;
							}else{
								total --;
							}
						}catch(Exception e){
							total --;
						}
						if(detailBook != null && detailBook.getContactBookId() == contactBookId){
							row = new ResultRow(detailBook, detailBook.getDetailBookId(), i);
							
							// STT
							row.addText(String.valueOf(stt));
							
							//URL detail
							PortletURL rowURLDetail= renderResponse.createActionURL();
							rowURLDetail.setWindowState(WindowState.NORMAL);
							rowURLDetail.setParameter("struts_action","/nss/phone_book/view_detail");
							rowURLDetail.setParameter(Constants.CMD,"DETAIL");
							rowURLDetail.setParameter("detailBookId", String.valueOf(detailBookId));
							rowURLDetail.setParameter("redirect", detailBookSearch.getIteratorURL().toString());
							rowURLDetail.setParameter("tabs", "detail");
							
							row.addText(detailBook.getDetailBookCode(), rowURLDetail.toString());
							
							// name
							row.addText(detailBook.getDetailBookName(), rowURLDetail.toString());
							
							// mo ta 
							row.addText(detailBook.getDetailDescription(), rowURLDetail.toString());
							
							//zip
							row.addText(detailBook.getZip(), rowURLDetail.toString());
							
							//internal
							row.addText(detailBook.getInternal(), rowURLDetail.toString());
							
							//home
							row.addText(detailBook.getHome(), rowURLDetail.toString());
							
							//mobile
							row.addText(detailBook.getMobile(), rowURLDetail.toString());
							
							//active 
							//URL active
							PortletURL rowURLActive= renderResponse.createActionURL();
							rowURLActive.setWindowState(WindowState.NORMAL);
							rowURLActive.setParameter("struts_action","/nss/phone_book/view_detail");
							rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
							rowURLActive.setParameter("detailBookId", String.valueOf(detailBookId));
							rowURLActive.setParameter("redirect", detailBookSearch.getIteratorURL().toString());
							
							if (true == detailBook.getDetailActive()) {
								active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
							} else if (false == detailBook.getDetailActive()){
								active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
							}
							row.addText(active);
							
							// edit
							//URL update
							PortletURL rowURLEdit = renderResponse.createActionURL();
							rowURLEdit.setWindowState(WindowState.NORMAL);
							rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
							rowURLEdit.setParameter("struts_action","/nss/phone_book/view_detail");
							rowURLEdit.setParameter("detailBookId", String.valueOf(detailBookId));
							rowURLEdit.setParameter("redirect", detailBookSearch.getIteratorURL().toString());
							rowURLEdit.setParameter("tabs", "edit");
							
							update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
							
							row.addText(update);
							
							// delete
							//URL delete
							PortletURL rowURLDelete = renderResponse.createActionURL();
							rowURLDelete.setWindowState(WindowState.NORMAL);
							rowURLDelete.setParameter("struts_action","/nss/phone_book/view_detail");
							rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
							rowURLDelete.setParameter("detailBookId", String.valueOf(detailBookId));
							rowURLDelete.setParameter("redirect", detailBookSearch.getIteratorURL().toString());
							
							deleteAction = "<a  href='javascript: ;' onclick=deleteDetailBook('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
							
							row.addText(deleteAction);
							
							resultRows.add(row);
						}
					}	
				detailBookSearch.setTotal(total);
				portletURL.setParameter(detailBookSearch.getCurParam(), String.valueOf(detailBookSearch.getCurValue()));
				
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= detailBookSearch %>" />
	</div>
</form>
    
<script>
	var myCodes = "<%= detailBookCodes %>".split("/");
	var myNames = "<%= detailBookNames %>".split("/");
	var myDescription = "<%= detailBookDescriptions %>".split("/");
	var myZips = "<%= detailBookZips %>".split("/");
	var myInternals = "<%= detailBookInternals %>".split("/");
	var myHomes = "<%= detailBookHomes %>".split("/");
	var myMobiles = "<%= detailBookMobiles %>".split("/");
	
	jQuery("#<portlet:namespace/>detailBookCodeAutoComplete").autocomplete({
		data : myCodes
	});
	jQuery("#<portlet:namespace/>detailBookNameAutoComplete").autocomplete({
		data : myNames
	});
	jQuery("#<portlet:namespace/>detailBookDescriptionAutoComplete").autocomplete({
		data : myDescription
	});
	jQuery("#<portlet:namespace/>detailBookZipAutoComplete").autocomplete({
		data : myZips
	});
	jQuery("#<portlet:namespace/>detailBookInternalAutoComplete").autocomplete({
		data : myInternals
	});
	jQuery("#<portlet:namespace/>detailBookHomeAutoComplete").autocomplete({
		data : myHomes
	});
	jQuery("#<portlet:namespace/>detailBookMobileAutoComplete").autocomplete({
		data : myMobiles
	});
	
	function deleteDetailBook(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script>   	
   