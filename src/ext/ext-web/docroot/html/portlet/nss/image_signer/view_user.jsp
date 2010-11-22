<%@page
	import="com.nss.portlet.image_signer.service.ImageSignerLocalServiceUtil"%>
<%@page import="com.nss.portlet.image_signer.search.UserSearchTerms"%>
<%@page import="com.nss.portlet.image_signer.search.UserSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.RequiredRoleException"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>
<%
	PortletURL portletURL = (PortletURL) request
			.getAttribute("portletURL");
%>

<liferay-ui:error
	exception="<%=com.liferay.portal.RequiredRoleException.class %>"
	message="you-can-not-delete-a-system-role"></liferay-ui:error>

<%
	UserSearch searchContainer = new UserSearch(renderRequest,
			portletURL);
	List<String> headerNames = searchContainer.getHeaderNames();
%>
<liferay-ui:search-form
	page="/html/portlet/nss/image_signer/user_search.jsp"
	searchContainer="<%=searchContainer %>" />
<%
	UserSearchTerms searchTerms = (UserSearchTerms) searchContainer
			.getSearchTerms();
	int total = 0;
	List<User> result = null;
	if (searchTerms.isAdvancedSearch()) {
		total = ImageSignerLocalServiceUtil.count_User_Image(
				searchTerms.getFirstName(),
				searchTerms.getMiddleName(), searchTerms.getLastName(),
				searchTerms.isAndOperator());
		result = ImageSignerLocalServiceUtil.find_User_Image(
				searchTerms.getFirstName(),
				searchTerms.getMiddleName(), searchTerms.getLastName(),
				searchContainer.getStart(), searchContainer.getEnd(),
				searchTerms.isAndOperator(),
				searchContainer.getOrderByComparator());
	} else {
		total = ImageSignerLocalServiceUtil.countByName("%"
				+ searchTerms.getKeywords() + "%");
		result = ImageSignerLocalServiceUtil.findByName("%"
				+ searchTerms.getKeywords() + "%",
				searchContainer.getStart(), searchContainer.getEnd(),
				searchContainer.getOrderByComparator());
	}

	portletURL.setParameter(searchContainer.getCurParam(),
			String.valueOf(searchContainer.getCur()));

	//set danh sach tra ve va so luong
	searchContainer.setResults(result);
	searchContainer.setTotal(total);
	List<ResultRow> resultRows = searchContainer.getResultRows();
	PortletURL editURL = null;
	PortletURL deleteURL = null;
	for (int i = 0; i < result.size(); i++) {
		User user_image = (User) result.get(i);
		user_image.toEscapedModel();
		ResultRow row = new ResultRow(user_image,
				user_image.getUserId(), i);
		//add cot name
		row.addText(user_image.getFirstName());
		//add cot ID
		row.addText(user_image.getMiddleName());
		//add cot price
		row.addText(user_image.getLastName());
		//add cot action
		//row.addJSP("left", SearchEntry.DEFAULT_VALIGN,
		//		"/html/portlet/nss/image_signer/action_user.jsp");
		resultRows.add(row);
	}
%>
total
<%=total%>
result
<%=result.size()%>
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
