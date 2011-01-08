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
	PortletURL URL = renderResponse.createRenderURL();

	URL.setWindowState(WindowState.NORMAL);
	URL.setParameter("struts_action", "/sgs/signer/view");
	URL.setParameter("search","false");
	URL.setParameter("beforeCheckFlag","true");
	String URLString = URL.toString();
	
	String tabsBefore = ParamUtil.getString(renderRequest, "tabs","chua-chon");
%>


<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%><script type="text/javascript">
	function <portlet:namespace/>updateSigner(signerRedirect) {
		document.<portlet:namespace/>fm.<portlet:namespace/>addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		document.<portlet:namespace/>fm.<portlet:namespace/>removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		submitForm(document.<portlet:namespace/>fm);
	}
</script>

<form name="<portlet:namespace/>fm"  action="<%=URLString%>" method="post">
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= HtmlUtil.escape(tabsBefore) %>" />
	<input name="<portlet:namespace/>addUserIds"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeUserIds"  type="hidden" value=""/>
<%
	
	UserSearch searchContainerBefore = new UserSearch(renderRequest,URL);
	List<String> headernamesBefore = searchContainerBefore.getHeaderNames();
	RowChecker rowCheckerBefore = new SignerChecker(renderResponse);	
	searchContainerBefore.setRowChecker(rowCheckerBefore);
	
%>
<liferay-ui:search-form
	page="/html/portlet/ext/signer/signer_searchBefore.jsp"
	searchContainer="<%= searchContainerBefore %>" />
	
	
		<input type="button" name="<portlet:namespace/>Update" value="<liferay-ui:message key="cap-nhat"/>" onclick="<portlet:namespace/>updateSigner('<%=URLString%>');"/>

	<br/>
	<%
		UserSearchTerms searchTermsBefore = (UserSearchTerms) searchContainerBefore.getSearchTerms();
		int totalBefore = 0;
		if(searchTermsBefore.isAdvancedSearch()){
			totalBefore = SignerLocalServiceUtil.searchCount(searchTermsBefore.getLastName(),searchTermsBefore.getFirstName(),
					searchTermsBefore.isAndOperator());
		}
		else{
			totalBefore = SignerLocalServiceUtil.searchCount(searchTermsBefore.getKeywords());
		}
		
		searchContainerBefore.setTotal(totalBefore);
		
		List resultsBefore = null;
		if(searchTermsBefore.isAdvancedSearch()){
			resultsBefore = SignerLocalServiceUtil.search(searchTermsBefore.getLastName(),searchTermsBefore.getFirstName(),searchTermsBefore.isAndOperator(),
					searchContainerBefore.getStart(),searchContainerBefore.getEnd(),searchContainerBefore.getOrderByComparator());
		}
		else{
			resultsBefore = SignerLocalServiceUtil.search(searchTermsBefore.getKeywords(),searchContainerBefore.getStart(),
					searchContainerBefore.getEnd(),searchContainerBefore.getOrderByComparator());
		}
		
		searchContainerBefore.setResults(resultsBefore);
		
		URL.setParameter(searchContainerBefore.getCurParam(), String.valueOf(searchContainerBefore.getCurValue()));
	%>
	
	<div class="separator"></div>
	
	<%
		Contact ctBefore = null;
		User usBefore = null;
		PmlUser pmlUser = null;
		Position position = null;
		String positionId = "";
		List resultRowsBefore = searchContainerBefore.getResultRows();
		ResultRow rowBefore = null;
		String lastName = "";
		String firstName = "";
		String middleName = "";
		String positionName = "";	
		
		for(int i=0; i<resultsBefore.size();i++){
			usBefore = (User)resultsBefore.get(i);
			usBefore.toEscapedModel();
			rowBefore = new ResultRow(usBefore ,usBefore.getUserId(),i);
			
			try{
				ctBefore = ContactUtil.findByPrimaryKey(usBefore.getContactId());
			}catch(NoSuchContactException e){
				ctBefore = null;
				lastName = firstName = middleName = positionName = "";
			}catch(SystemException e){
				ctBefore = null;
				lastName = firstName = middleName = positionName = "";
			}
			
			if(ctBefore != null){
				lastName = ctBefore.getLastName();
				firstName = ctBefore.getFirstName();
				middleName = ctBefore.getMiddleName();
			}
			
			try{
				pmlUser = PmlUserUtil.findByPrimaryKey(usBefore.getUserId());
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
				
			rowBefore.addText(lastName);
			rowBefore.addText(middleName);
			rowBefore.addText(firstName);
			rowBefore.addText(positionName);
			resultRowsBefore.add(rowBefore);
	
		}
	
	%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainerBefore %>" />
</form>