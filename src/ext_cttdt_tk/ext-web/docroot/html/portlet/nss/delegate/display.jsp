<%@ include file="/html/portlet/nss/delegate/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.delegate.model.PmlDelegate"%>
<%@page import="com.nss.portlet.delegate.search.PmlDelegateSearch"%>
<%@page import="com.nss.portlet.delegate.search.PmlDelegateSearchTerms"%>
<%@page import="com.nss.portlet.delegate.service.PmlDelegateLocalServiceUtil"%>
<%@page import="com.nss.portlet.delegate.model.PmlFileTypeDelegate"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.nss.portlet.delegate.service.PmlFileTypeDelegateLocalServiceUtil"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/delegate/view");
%>

<%
	List<PmlDelegate> delegateList = (List<PmlDelegate>)renderRequest.getAttribute("delegates");
%>
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace/>fm">
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="delegate"/></div>
	<%
		PmlDelegateSearch delegateSearch = new PmlDelegateSearch(renderRequest, portletURL);
		PmlDelegateSearchTerms delegateSearchTerms = (PmlDelegateSearchTerms)delegateSearch.getSearchTerms();
	%>
	<%
		// URL add
		PortletURL addURL = renderResponse.createRenderURL();
		addURL.setWindowState(WindowState.NORMAL);
		addURL.setParameter("struts_action", "/nss/delegate/view");
		addURL.setParameter(Constants.CMD,Constants.ADD);
		addURL.setParameter("tab", "add");
		addURL.setParameter("redirect", delegateSearch.getIteratorURL().toString());
	%>
	<%
		List<PmlDelegate> results = null;
		int total =0;
		
		results = PmlDelegateLocalServiceUtil.getPmlDelegates(delegateSearch.getStart(), delegateSearch.getEnd());
		delegateSearch.setResults(results);
		
		total = PmlDelegateLocalServiceUtil.getPmlDelegatesCount();
		delegateSearch.setTotal(total);
		
		portletURL.setParameter(delegateSearch.getCurParam(), String.valueOf(delegateSearch.getCurValue()));
	%>
	<%
		List resultRows = delegateSearch.getResultRows();
		ResultRow row = null;
		PmlDelegate pmlDelegate = null;
		User userDelegated = null;
		User userAssigner = null;
		List<PmlFileTypeDelegate> fileTypeDelegates = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String active = "";
		for (int i=0; i< results.size(); i++) {
			pmlDelegate = results.get(i);
			pmlDelegate = pmlDelegate.toEscapedModel();
			
			row = new ResultRow( pmlDelegate, pmlDelegate.getDelegateId(), i);
			
			//STT
			row.addText(String.valueOf(i+1));
			
			//nguoi uy quyen
			try {
				userAssigner = UserLocalServiceUtil.getUser(pmlDelegate.getAssigner());
				row.addText(userAssigner.getLastName()+" "+ userAssigner.getMiddleName()+" "+ userAssigner.getFirstName());
			} catch( Exception e) {
				row.addText("");
			}
			
			//nguoi duoc uy quyen
			try {
				userDelegated = UserLocalServiceUtil.getUser(pmlDelegate.getReceiver());
			} catch( Exception e) {
				
			}
			
			if ( null!= userDelegated) {
				row.addText(userDelegated.getLastName()+" "+ userDelegated.getMiddleName()+" "+ userDelegated.getFirstName());
				
			} else {
				row.addText("");
				
			}
			
			// loai ho so
			try {
				fileTypeDelegates = PmlFileTypeDelegateLocalServiceUtil.findByDelegateId(pmlDelegate.getDelegateId());
			} catch( Exception e) {
				fileTypeDelegates = new ArrayList<PmlFileTypeDelegate>();
			}
			
			PmlFileTypeDelegate fileTypeDelegate = null;
			PmlFileType fileType = null;
			String loaiHoSo = " ";
			for (int j = 0; j < fileTypeDelegates.size(); j++) {
				
				String fileTypeName = " ";
				String fileTypeId = "";
				
				fileTypeDelegate = fileTypeDelegates.get(j);
				fileTypeId = fileTypeDelegate.getFileTypeId();
				
				try {
					fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
				} catch (Exception e){
					
				}
				
				if ( null!= fileType){
					fileTypeName += "-&nbsp;" + fileType.getFileTypeName() +". ";
				} else {
					fileTypeName = " ";
				}
				
				if (loaiHoSo.trim().length() > 0) {
					loaiHoSo += "<br/>";
				}
				loaiHoSo += fileTypeName;
			}
			
			row.addText(loaiHoSo);
			
			// ngay bat dau uy quyen
			if ( pmlDelegate.getStartDate() != null) {
				row.addText(dateFormat.format(pmlDelegate.getStartDate()));
			} else {
				row.addText("");
			}
			
			// ngay ket thuc uy quyen
			if ( pmlDelegate.getEndDate() != null) {
				row.addText(dateFormat.format(pmlDelegate.getEndDate()));
			} else {
				row.addText("");
			}
			
			// ngay huy uy quyen
			if ( pmlDelegate.getCancelDate() != null) {
				row.addText(dateFormat.format(pmlDelegate.getCancelDate()));
			} else {
				row.addText("");
			}
			
			// huy uy quyen
			PortletURL activeURL = renderResponse.createActionURL();
			activeURL.setParameter("struts_action","/nss/delegate/view");
			activeURL.setParameter(Constants.ACTION,Constants.DEACTIVATE);
			activeURL.setParameter("delegateId",String.valueOf(pmlDelegate.getDelegateId()));
			
			if (pmlDelegate.getCancelDelegate().equals("0")) {
				active = "<a  href='"+activeURL.toString()+"'><img src='/html/images/blue.gif' border='0' title=\"<liferay-ui:message key='delete-huyuyquyen'/>\" /></a>";
			
			} else { 
				active = "<img src='/html/images/red.gif' border='0' />";
			} 
			
			row.addText(active);
			
			resultRows.add(row);
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%=delegateSearch %>" />
	<br>
	<div align="right" id="table-button">
			<span onclick="javascript:submitForm(document.hrefFm,'<%= addURL.toString() %>');" >
				<input class="button" type="button" value='<liferay-ui:message key="add_new" />' />
			</span>
	</div>
</div>
</form>
