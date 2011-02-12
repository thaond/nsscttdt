<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />thuThapCVDen(url)
{
	var documentReceiptIds = $jq("#<portlet:namespace />documentReceiptIds");
	documentReceiptIds.val(Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds"));
	
	if (documentReceiptIds.val() == "") {
		alert ('<%= UnicodeLanguageUtil.get(pageContext, "chon-cong-van-den-can-xu-ly") %>');
	} else {
		submitForm(document.<portlet:namespace />fm, url);
	}
}
</script>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	long idHoSoCongViec = ParamUtil.getLong(renderRequest, "idHoSoCongViec"); 

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvden");
	
	PmlEdmDocumentReceiptSearch searchContainer = new PmlEdmDocumentReceiptSearch(renderRequest, portletURL);
	PmlEdmDocumentReceiptSearchTerms searchTerms = (PmlEdmDocumentReceiptSearchTerms)searchContainer.getSearchTerms();
	
	searchContainer.setRowChecker(new RowChecker(renderResponse));
	
	PortletURL thuThapURL = renderResponse.createActionURL();
	thuThapURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvden");
	thuThapURL.setParameter("redirect", redirect);
	
%>

<form name="<portlet:namespace />fm" method="post" action="<%= portletURL.toString() %>">
<div class="title_categ" ><liferay-ui:message key="thu-thap-van-ban-den-cho-ho-so-cong-viec"/></div>
<div class="boxcontent">
<input type="hidden" name="<portlet:namespace />documentReceiptIds" id="<portlet:namespace />documentReceiptIds" />
<input type="hidden" name="<portlet:namespace />idHoSoCongViec" value="<%= idHoSoCongViec %>" />

<liferay-ui:search-form	page="/html/portlet/ext/pml_ho_so_cong_viec/cvden_search.jsp" searchContainer="<%= searchContainer %>" />

	<input type="button" value="<liferay-ui:message key="thu-thap"/>" onclick="<portlet:namespace />thuThapCVDen('<%= thuThapURL.toString() %>');"/>
	<input type="button" value="<liferay-ui:message key="back"/>" onClick="location.href = '<%= redirect %>';" />
<br><br>
<%
	int total = PmlEdmDocumentReceiptLocalServiceUtil.countBy_R_B_F_T(searchTerms.getDocumentReference(), searchTerms.getBriefContent(), searchTerms.getFromDate(), searchTerms.getToDate(), searchTerms.isAndOperator());

	List<PmlEdmDocumentReceipt> results = PmlEdmDocumentReceiptLocalServiceUtil.findBy_R_B_F_T(searchTerms.getDocumentReference(), searchTerms.getBriefContent(), searchTerms.getFromDate(), searchTerms.getToDate(), searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
	
	searchContainer.setTotal(total);
	searchContainer.setResults(results);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	
	List<ResultRow> resultRows = searchContainer.getResultRows();
	ResultRow row = null;
	
	PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null;
	
	for (int i = 0; i < results.size(); i++) {
		pmlEdmDocumentReceipt = results.get(i);
		
		long pmlEdmDocumentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId();
		
		row = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceiptId, i);
		
		row.addText(String.valueOf(i + 1));
		
		row.addText(pmlEdmDocumentReceipt.getDocumentReference());
		
		row.addText(dfTime.format(pmlEdmDocumentReceipt.getDateArrive()));
		
		row.addText(pmlEdmDocumentReceipt.getBriefContent());
		
		List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileLocalServiceUtil.findByObjectContentId_ObjectType(pmlEdmDocumentReceiptId, PmlEdmDocumentReceiptImpl.class.getName());
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
		} else if (size > 1){
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