<%@page import="com.nss.portlet.image_signer.model.ImageSigner"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
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
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/image_signer/view");
%>

<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
<div class="parent-title"><liferay-ui:message key="Quan-ly-anh-ky"/></div>	
	<liferay-ui:error
	exception="<%=com.liferay.portal.RequiredRoleException.class %>"
	message="you-can-not-delete-a-system-role">
</liferay-ui:error> <%
 	UserSearch searchContainer = new UserSearch(renderRequest,
 			portletURL);
 	List<String> headerNames = searchContainer.getHeaderNames();
 %> 
 <liferay-ui:search-form page="/html/portlet/nss/image_signer/user_search.jsp" searchContainer="<%=searchContainer %>" /> 
 <br>
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
 		total = ImageSignerLocalServiceUtil.countByName(searchTerms
 				.getKeywords());

 		result = ImageSignerLocalServiceUtil.findByName(
 				searchTerms.getKeywords(), searchContainer.getStart(),
 				searchContainer.getEnd(),
 				searchContainer.getOrderByComparator());
 	}

 	portletURL.setParameter(searchContainer.getCurParam(),
 			String.valueOf(searchContainer.getCur()));

 	//set danh sach tra ve va so luong
 	searchContainer.setResults(result);
 	searchContainer.setTotal(total);
 	List<ResultRow> resultRows = searchContainer.getResultRows();

 	for (int i = 0; i < result.size(); i++) {
 		User user_image = (User) result.get(i);
 		user_image.toEscapedModel();
 		long userId = user_image.getUserId();
 		int countImageSigner = ImageSignerLocalServiceUtil
 				.getImageSigners(-1, -1).size();
 		ImageSigner imageSigner = ImageSignerLocalServiceUtil
 				.getImageSignerByUserId(userId, 0, countImageSigner);
 		ResultRow row = new ResultRow(user_image,
 				user_image.getUserId(), i);
 		row.addText(user_image.getFirstName());
 		row.addText(user_image.getMiddleName());
 		row.addText(user_image.getLastName());
 		if (imageSigner == null) {
 			row.addText("No Image Sign");
 			row.addText("No Image UnSign");
 		}else if(imageSigner.getImageIdSign()==0&&imageSigner.getImageIdUnSign()==0){
 			row.addText("No Image Sign");
 			row.addText("No Image UnSign");
 		}else{
 			row.addText("<img width='30px' height='20px' src='"+  themeDisplay.getPathImage()+ "/image_signer?img_id="+ imageSigner.getImageIdSign() +"' />");
 			row.addText("<img width='30px' height='20px' src='"+  themeDisplay.getPathImage()+ "/image_signer?img_id="+ imageSigner.getImageIdUnSign() +"' />");
 		}
 		row.addJSP("left", SearchEntry.DEFAULT_VALIGN,
 				"/html/portlet/nss/image_signer/action_image_signer.jsp");
 		resultRows.add(row);
 	}
 %> <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</form>

