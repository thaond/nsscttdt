<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />thuThapCVDi(url)
{
	var documentSendIds = $jq("#<portlet:namespace />documentSendIds");
	documentSendIds.val(Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds"));
	
	if (documentSendIds.val() == "") {
		alert ('<%= UnicodeLanguageUtil.get(pageContext, "chon-cong-van-di-can-xu-ly") %>');
	} else {
		submitForm(document.<portlet:namespace />fm, url);
	}
}
</script>

<%
	long idHoSoCongViec = ParamUtil.getLong(renderRequest, "idHoSoCongViec"); 

	PortletURL redirect = renderResponse.createRenderURL();
	redirect.setWindowState(WindowState.NORMAL);
	redirect.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/viewdetail");
	redirect.setParameter("tabs", "cvdi");
	redirect.setParameter("idHoSoCongViec", String.valueOf(idHoSoCongViec));
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvdi");
	portletURL.setParameter("idHoSoCongViec", String.valueOf(idHoSoCongViec));
	portletURL.setParameter("redirect", redirect.toString());
	
	PmlEdmDocumentSendSearch searchContainer = new PmlEdmDocumentSendSearch (renderRequest, portletURL);
	PmlEdmDocumentSendSearchTerms searchTerms = (PmlEdmDocumentSendSearchTerms) searchContainer.getSearchTerms();
	
	searchContainer.setRowChecker(new RowChecker(renderResponse));
	
	PortletURL thuThapCVDiURL = renderResponse.createActionURL();
	thuThapCVDiURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvdi");
	thuThapCVDiURL.setParameter("redirect", redirect.toString());
	
%>

<form name="<portlet:namespace />fm" method="post" action="<%= portletURL.toString() %>">
<input type="hidden" name="<portlet:namespace />documentSendIds" id="<portlet:namespace />documentSendIds" />
<input type="hidden" name="<portlet:namespace />idHoSoCongViec" value="<%= String.valueOf(idHoSoCongViec) %>" />
<div class="title_categ" ><liferay-ui:message key="thu-thap-van-ban-di-cho-ho-so-cong-viec"/></div>
<div class="boxcontent">	
	<liferay-ui:search-form	page="/html/portlet/ext/pml_ho_so_cong_viec/cvdi_search.jsp" searchContainer="<%= searchContainer %>" />
	
	<input type="button" value="<liferay-ui:message key="thu-thap"/>" onclick="<portlet:namespace />thuThapCVDi('<%= thuThapCVDiURL.toString() %>');" />
	<input type="button" value="<liferay-ui:message key="back"/>" onClick="location.href = '<%= redirect %>';" />
<br><br>	
	<%
		int total = PmlEdmDocumentSendLocalServiceUtil.countBy_R_B_F_T(searchTerms.getDocumentSendReference(), searchTerms.getDocumentSendBriefContent(), searchTerms.getDocumentSendFromDate(), searchTerms.getDocumentSendToDate(), searchTerms.isAndOperator());
	
		List<PmlEdmDocumentSend> results = PmlEdmDocumentSendLocalServiceUtil.findBy_R_B_F_T(searchTerms.getDocumentSendReference(), searchTerms.getDocumentSendBriefContent(), searchTerms.getDocumentSendFromDate(), searchTerms.getDocumentSendToDate(), searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		
		searchContainer.setTotal(total);
		searchContainer.setResults(results);
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		
		List<ResultRow> resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		
		PmlEdmDocumentSend pmlEdmDocumentSend = null;
		
		for (int i = 0; i < results.size(); i++) {
			pmlEdmDocumentSend = results.get(i);
			
			long pmlEdmDocumentSendId = pmlEdmDocumentSend.getDocumentSendId();
			
			row = new ResultRow(pmlEdmDocumentSend, pmlEdmDocumentSendId, i);
			
			row.addText(String.valueOf(i + 1));
			
			row.addText(pmlEdmDocumentSend.getDocumentReference());
			
			String dateCreateStr = "";
			
			Date dateCreate = pmlEdmDocumentSend.getDateCreated();
			
			if (Validator.isNotNull(dateCreate)) {
				dateCreateStr = df.format(dateCreate);
			}
			
			row.addText(dateCreateStr);
			
			row.addText(pmlEdmDocumentSend.getBriefContent());
			
			List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileLocalServiceUtil.findByObjectContentId_ObjectType(pmlEdmDocumentSendId, PmlEdmDocumentSendImpl.class.getName());
			int size = attachedFiles.size();
			
			StringBuilder attFilePathSB = new StringBuilder();
			
			if (size == 1) {
				PmlEdmAttachedFile attachedFile = attachedFiles.get(0);
				
				String fileName = attachedFile.getAttachedFileName();
				fileName = fileName.substring(14);
				
				attFilePathSB.append("<a class=\"dwld\" style=\"cursor:pointer;\" href=\"" + attachedFile.getPath() + "\" >");
				attFilePathSB.append("<img title=\"" + LanguageUtil.get(pageContext, "download") + StringPool.SPACE + fileName + "\" style=\"cursor:pointer;padding-left:10px\" ");
				attFilePathSB.append("border=\"0\" src=\"/html/_img/download.png\"");
				attFilePathSB.append("height=\"14px\" width=\"14px\"");
				attFilePathSB.append("> </a>");
			} else if (size > 1) {
				for (int j = 0; j < size; j++) {
					PmlEdmAttachedFile attachedFile = attachedFiles.get(j);
					
					String fileName = attachedFile.getAttachedFileName();
					fileName = fileName.substring(14);
					
					attFilePathSB.append("<a class=\"dwld\" style=\"cursor:pointer;\" href=\"" + 
							attachedFile.getPath() + "\" > ");
					attFilePathSB.append("<img title=\"" + LanguageUtil.get(pageContext, "download") + StringPool.SPACE + fileName + "\"  style=\"cursor:pointer;padding-left:10px\" ");
					attFilePathSB.append("border=\"0\" src=\"/html/_img/download.png\"");
					attFilePathSB.append("height=\"14px\" width=\"14px\"");
					attFilePathSB.append("> </a> <br/>");
				}
			}
			
			row.addText(attFilePathSB.toString());
			
			resultRows.add(row);
		}
	%>
	
	<liferay-ui:search-iterator page="/html/portlet/ext/pml_ho_so_cong_viec/search_iterator/page.jsp" searchContainer="<%=searchContainer %>"/>
</div>
</form>