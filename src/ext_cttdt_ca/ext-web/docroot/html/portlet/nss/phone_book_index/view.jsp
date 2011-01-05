<%@ include file="/html/portlet/nss/phone_book_index/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.phone_book_index.search.DetailBookIndexDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book_index.search.DetailBookIndexSearch"%>
<%@page import="com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil"%>
<%@page import="com.nss.portlet.phone_book.service.ContactBookLocalServiceUtil"%>
<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="com.nss.portlet.phone_book.model.DetailBook"%>
<%@page import="javax.portlet.WindowState"%>
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
	long contactBookId =0;
	long idSelectDetail = 0; 
	
	String redirect = ParamUtil.getString(renderRequest, "redirect", "/nss/phone_book_index/view");
	List<DetailBook> detailBooks = DetailBookLocalServiceUtil.getDetailBooks(-1,-1);
	List<ContactBook> contactBooks = ContactBookLocalServiceUtil.getContactBooks(-1,-1);
	List<ContactBook> tempCB = new ArrayList<ContactBook>();
	
	for(ContactBook cb : contactBooks){
		if(cb.getContactActive() == true){
			tempCB.add(cb);
		}
	}
	contactBooks = tempCB;
		
	String selectContactBook = (String) request.getAttribute("selectContactBook");
	String selectDetailBook = (String) request.getAttribute("selectDetailBook");
	String donViCaNhan = (String) request.getAttribute("donViCaNhan");
		
	if(selectContactBook != null){
		detailBooks = (List<DetailBook>) request.getAttribute("detailBooks");	 
	}else{
		detailBooks = new ArrayList<DetailBook>();	
	}
		
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book_index/view");
	portletURL.setParameter(Constants.CMD,"DETAIL");
	portletURL.setParameter("tabs", "detail");
	portletURL.setParameter("contactBookId", String.valueOf(contactBookId));
	%> 

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%	
    		DetailBookIndexSearch detailBookSearch = new DetailBookIndexSearch(renderRequest,portletURL);
    		DetailBookIndexDisplayTerms displayTerms = (DetailBookIndexDisplayTerms)detailBookSearch.getDisplayTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DetailBookIndexDisplayTerms.NAME);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = detailBookSearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="titlecategr" style="margin-bottom: 15px;"><h4><p><liferay-ui:message key="nss-phone-book-index" /></p></h4></div>
		
		<select name="<portlet:namespace/>selectContactBook">
				<option onclick="sendSelect()"><liferay-ui:message key="chon-khoi" /></option>
			<% for(int i=0;i<contactBooks.size();i++){ 
				long contactIdSelect = contactBooks.get(i).getContactBookId();
			%>
			<% if(selectContactBook != null){
				long idSelectContact = Long.parseLong(selectContactBook);
			%>
				<option onclick="sendSelect()" <%= idSelectContact == contactIdSelect ? "selected" : ""%> value="<%=String.valueOf(contactIdSelect) %>"><%=contactBooks.get(i).getContactBookName() %></option>
			<%}else{ %>
				<option onclick="sendSelect()" value="<%=String.valueOf(contactIdSelect) %>"><%=contactBooks.get(i).getContactBookName() %></option>
			<%} %>
			<%} %>
		</select>
		
		<select name="<portlet:namespace/>selectDetailBook">
				<option onclick="sendSelect()"><liferay-ui:message key="chon-don-vi-ca-nhan-su-dung" /></option>
			<% if(detailBooks != null){ %>
			<% for(int j=0;j<detailBooks.size();j++){
				long detailIdSelect = detailBooks.get(j).getDetailBookId();
			%>
			<% if(selectDetailBook != null){ 
				idSelectDetail = Long.parseLong(selectDetailBook);
			%>
				<option onclick="sendSelect()" <%= idSelectDetail == detailIdSelect ? "selected" : ""%> value="<%=String.valueOf(detailIdSelect) %>"><%=detailBooks.get(j).getDetailBookName() %></option>
			<%}else{ %>
				<option onclick="sendSelect()" value="<%=String.valueOf(detailIdSelect) %>"><%=detailBooks.get(j).getDetailBookName() %></option>
			<%} %>
			<%} %>
			<%} %>
		</select>
		
		<liferay-ui:message key='don-vi-ca-nhan-su-dung'/> 
		<% if(donViCaNhan != null){ %>
			<input type="text" name="<portlet:namespace/>donViCaNhan" value="<%=donViCaNhan %>">
		<%}else{ %>
			<input type="text" name="<portlet:namespace/>donViCaNhan" value="">
		<%} %>
		<input onclick="search()" type="button" value="<liferay-ui:message key='search'/>">
		
		<br><br>
		
			<br><br>
			
				<%
					List<DetailBook> results = new ArrayList<DetailBook>();
					results = DetailBookLocalServiceUtil.getDetailBooks(-1,-1);
					
					DetailBook detailBook = null;
					long detailBookId = 0;
					List<DetailBook> listDetailBook = new ArrayList<DetailBook>();
					
					if(selectContactBook != null){
						contactBookId = Long.parseLong(selectContactBook);
					}
					
					  for(int i=0;i< results.size();i++){
						detailBookId = results.get(i).getDetailBookId();
						try{
							detailBook  = DetailBookLocalServiceUtil.getDetailBook(detailBookId);
							if(contactBookId == 0 && idSelectDetail == 0){
								listDetailBook.add(detailBook);
							}
							if(contactBookId != 0 && idSelectDetail == 0){
								if(contactBookId == detailBook.getContactBookId()){
									listDetailBook.add(detailBook);
								}
							}
							if(contactBookId != 0 && idSelectDetail != 0){
								boolean check = false;
								List<DetailBook> detailBookIds = ContactBookLocalServiceUtil.getDetailBooks(contactBookId);
								for(DetailBook dBook : detailBookIds){
									if(dBook.getDetailBookId() == idSelectDetail){
										check = true;
									}
								}
								if(check){
									if(idSelectDetail == detailBookId && contactBookId == detailBook.getContactBookId()){
										listDetailBook.add(detailBook);
									}
								}else if(contactBookId == detailBook.getContactBookId()){
									listDetailBook.add(detailBook);
								}
							}
							if(donViCaNhan != null){
								List<DetailBook> temp = new ArrayList<DetailBook>();
								for(DetailBook dB : listDetailBook){
									if(dB.getDetailBookName().toLowerCase().contains(donViCaNhan)){
										temp.add(dB);
									}
								}
								listDetailBook = temp;
							}
							List<DetailBook> temp1 = new ArrayList<DetailBook>();
							for(ContactBook cb1 : contactBooks){
								long idCb = cb1.getContactBookId();
								for(DetailBook db1 : listDetailBook){
									if(db1.getContactBookId() == idCb){
										temp1.add(db1);
									}
								}
							}
							listDetailBook = temp1;
						}catch(Exception e){
						}
					}
					
					int total = listDetailBook.size();
					detailBookSearch.setTotal(total);
					detailBookSearch.setResults(listDetailBook);
					String emptyResultsMessage = detailBookSearch.getEmptyResultsMessage();
					portletURL.setParameter(detailBookSearch.getCurParam(), String.valueOf(detailBookSearch.getCurValue()));
					
					List<ResultRow> resultRows = detailBookSearch.getResultRows();
					ResultRow row = null;	
					
					int start = detailBookSearch.getStart();
					int end = detailBookSearch.getEnd();
					
					if (end > total) {
						end = total;
					}
					%>
								
			<table border="1">
				<tr>
					<td rowspan="2">STT</td>
					<td rowspan="2"><liferay-ui:message key='don-vi-ca-nhan-su-dung'/></td>
					<td colspan="4"><div style="margin-left: 80px"><liferay-ui:message key='so-may-dien-thoai'/></div></td>
				</tr>
				<tr>
					<td><liferay-ui:message key='so-buu-dien'/></td>
					<td><liferay-ui:message key='so-noi-bo'/></td>
					<td><liferay-ui:message key='so-nha-rieng'/></td>
					<td><liferay-ui:message key='so-di-dong'/></td>
				</tr>
				<% if(total > 0){ 
					listDetailBook = listDetailBook.subList(start,end);
					for(int i =0;i<listDetailBook.size();i++){ %>
					<tr>
						<td><%=i+1 %></td>
						<td><%=listDetailBook.get(i).getDetailBookName() %></td>
						<td><%=listDetailBook.get(i).getZip() %></td>
						<td><%=listDetailBook.get(i).getInternal() %></td>
						<td><%=listDetailBook.get(i).getHome() %></td>
						<td><%=listDetailBook.get(i).getMobile() %></td>
					</tr>
					<%} %>
				<%}else{ %>
					<tr>
						<td colspan="6"><liferay-ui:message key='<%=emptyResultsMessage %>'/></td>
					</tr>
				<%} %>
			</table>
			
			<% if(total > 0){ %>
				<liferay-ui:search-paginator searchContainer="<%= detailBookSearch %>" />
			<%} %>
	</div>
</form>
    
<script type="text/javascript">
	function sendSelect(){
		submitForm(document.<portlet:namespace/>fm,
				"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
				<portlet:param name="struts_action" value="/nss/phone_book_index/view" />
				<portlet:param name="<%=Constants.CMD%>" value="SELECT" />
				</portlet:actionURL>");
	}
	
	function search(){
		submitForm(document.<portlet:namespace/>fm,
				"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
				<portlet:param name="struts_action" value="/nss/phone_book_index/view" />
				<portlet:param name="<%=Constants.CMD%>" value="SEARCH" />
				</portlet:actionURL>");
	}
</script>   	
   