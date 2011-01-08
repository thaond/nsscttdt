<%@ include file="/html/portlet/ext/signer/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.signer.service.SignerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.signer.model.Signer"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.service.ContactLocalServiceUtil"%>
<%@page import="com.sgs.portlet.signer.search.SignerChecker"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.ContactUtil"%>
<%@page import="com.liferay.portal.model.impl.ContactImpl"%>
<%@page import="com.sgs.portlet.signer.search.UserSearch"%>
<%@page import="com.sgs.portlet.signer.search.UserSearchTerms"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%>
<%@page import="com.sgs.portlet.pmluser.NoSuchPmlUserException"%>
<%@page import="com.liferay.portal.NoSuchContactException"%>
<%@page import="com.sgs.portlet.position.NoSuchPositionException"%>
<%@page import="javax.portlet.ValidatorException"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/signer/view");
	portletURL.setParameter("search","true");
	portletURL.setParameter("afterCheckFlag","true");
	
	String tabsAfter = ParamUtil.getString(renderRequest, "tabs","da-chon");
	
	String portletURLString = portletURL.toString();
%>


<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%><script type="text/javascript">
	function <portlet:namespace/>updateSigner(signerRedirect) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		document.<portlet:namespace/>fm.<portlet:namespace/>removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		submitForm(document.<portlet:namespace/>fm);
	}
</script>

<form name="<portlet:namespace/>fm"  action="<%=portletURLString%>" method="post">
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= HtmlUtil.escape(tabsAfter) %>" />
	<input name="<portlet:namespace/>addUserIds"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeUserIds"  type="hidden" value=""/>
<%
	
	UserSearch searchContainerAfter = new UserSearch(renderRequest,portletURL);
	List<String> headernamesAfter = searchContainerAfter.getHeaderNames();
	RowChecker rowChecker = new SignerChecker(renderResponse);	
	searchContainerAfter.setRowChecker(rowChecker);
	
%>
<liferay-ui:search-form
	page="/html/portlet/ext/signer/signer_search.jsp"
	searchContainer="<%= searchContainerAfter %>" />
	
		<input type="button" name="<portlet:namespace/>Update" value="<liferay-ui:message key="cap-nhat"/>" onclick="<portlet:namespace/>updateSigner('<%=portletURLString%>');"/>
	<br/>
	<%
		UserSearchTerms searchTerms = (UserSearchTerms) searchContainerAfter.getSearchTerms();
		int total = 0;
		if(searchTerms.isAdvancedSearch()){
			total = SignerLocalServiceUtil.searchCountAfterChecked(searchTerms.getLastName(), searchTerms.getFirstName(), 
					searchTerms.isAndOperator());
		}
		else{
			total = SignerLocalServiceUtil.searchCountAfterChecked(searchTerms.getKeywords());
		}
		
		searchContainerAfter.setTotal(total);
		
		List results = null;
		if(searchTerms.isAdvancedSearch()){
			results = SignerLocalServiceUtil.searchAfterChecked(searchTerms.getLastName(),searchTerms.getFirstName(),
					searchTerms.isAndOperator(),searchContainerAfter.getStart(),
					searchContainerAfter.getEnd(),searchContainerAfter.getOrderByComparator());
		}
		else{
			results = SignerLocalServiceUtil.searchAfterChecked(searchTerms.getKeywords(),searchContainerAfter.getStart(),
					searchContainerAfter.getEnd(),searchContainerAfter.getOrderByComparator());
		}
		
		searchContainerAfter.setResults(results);
		
		portletURL.setParameter(searchContainerAfter.getCurParam(), String.valueOf(searchContainerAfter.getCurValue()));										
	%>
	<div class="separator"></div>
	
	<%
		Contact ctAfter = null;
		User usAfter = null;
		PmlUser pmlUser = null;
		Position position = null;
		String positionId = "";
		List resultRows = searchContainerAfter.getResultRows();
		ResultRow row = null;
		String lastName = "";
		String firstName = "";
		String middleName = "";
		String positionName = "";	
		
		for(int i=0; i<results.size();i++){
			usAfter = (User)results.get(i);
			usAfter.toEscapedModel();
			row = new ResultRow(usAfter ,usAfter.getUserId(),i);
			
			try{
				ctAfter = ContactUtil.findByPrimaryKey(usAfter.getContactId());
			}catch(NoSuchContactException e){
				ctAfter = null;
				lastName = firstName = middleName = positionName = "";
			}catch(SystemException e){
				ctAfter = null;
				lastName = firstName = middleName = positionName = "";
			}
			
			if(ctAfter != null){
				lastName = ctAfter.getLastName();
				firstName = ctAfter.getFirstName();
				middleName = ctAfter.getMiddleName();
			}
			
			try{
				pmlUser = PmlUserUtil.findByPrimaryKey(usAfter.getUserId());
			}catch(NoSuchPmlUserException e){
				pmlUser = null;
				position = null;
				positionName = "";
			}catch(SystemException e){
				pmlUser = null;
				position = null;
				positionName = "";
			}
			
			if(pmlUser != null){
				positionId = pmlUser.getPositionId();
				try{
					position = PositionUtil.findByPrimaryKey(positionId);
				}catch(NoSuchPositionException e){
					position = null;
				}catch(SystemException e){
					position = null;
				}
				
				if(position != null){
					positionName = position.getPositionName();
				}
			}
				
			row.addText(lastName);
			row.addText(middleName);
			row.addText(firstName);
			row.addText(positionName);
			resultRows.add(row);
	
		}
	
	%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainerAfter %>" />
</form>