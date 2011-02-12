<%@ include file="/html/portlet/ext/onedoorsearch/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.onedoorsearch.searchresult.PmlOneDoorReceiveFileSearchResult"%>
<%@page import="com.sgs.portlet.onedoorsearch.searchresult.PmlOneDoorReceiveFileSearchResultTerms"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCC"%>
<%@page import="com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalServiceUtil"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.model.PmlProcessDispose"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/onedoorsearch/view");
%>


<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="title_categ"><liferay-ui:message key="tieu-thuc-tim-kiem"/></div>
	<%
		PmlOneDoorReceiveFileSearchResult searchContainer = new PmlOneDoorReceiveFileSearchResult(renderRequest, portletURL);
		PmlOneDoorReceiveFileSearchResultTerms searchTerms = (PmlOneDoorReceiveFileSearchResultTerms)searchContainer.getSearchTerms();
	%> 
	<div class="boxcontent">
		<liferay-ui:search-form
				page="/html/portlet/ext/onedoorsearch/search_form.jsp"
				searchContainer="<%= searchContainer %>" />
	<%
		List<PmlOneDoorReceiveFile> results = null;
		int total = 0;
		results = PmlOneDoorReceiveFileLocalServiceUtil.onedoorSearch(searchTerms.getFileId(), searchTerms.getFileName(), searchTerms.getApplicantName(),
					searchTerms.getAddress(), searchTerms.getTelephone(), searchTerms.getFileTypeId(), searchTerms.getReceiveFromDate(), searchTerms.getReceiveToDate(),
					searchTerms.getExpectReturningFromDate(), searchTerms.getExpectReturningToDate(), searchTerms.getCompleteFromDate(), searchTerms.getCompleteToDate(),
					searchTerms.getExactReturningFromDate(), searchTerms.getExactReturningToDate(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		total = PmlOneDoorReceiveFileLocalServiceUtil.onedoorSearchCount(searchTerms.getFileId(), searchTerms.getFileName(), searchTerms.getApplicantName(),
				searchTerms.getAddress(), searchTerms.getTelephone(), searchTerms.getFileTypeId(), searchTerms.getReceiveFromDate(), searchTerms.getReceiveToDate(),
				searchTerms.getExpectReturningFromDate(), searchTerms.getExpectReturningToDate(), searchTerms.getCompleteFromDate(), searchTerms.getCompleteToDate(),
				searchTerms.getExactReturningFromDate(), searchTerms.getExactReturningToDate());
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < results.size(); i ++) {
			PmlOneDoorReceiveFile onedoorFile = results.get(i);
			String fileId = onedoorFile.getFileId();
			row = new ResultRow(onedoorFile, fileId, i);
			
			// STT
			row.addText(String.valueOf(i+1));
			
			// ma ho so
			PortletURL detailURL = renderResponse.createRenderURL();
			detailURL.setWindowState(WindowState.NORMAL);
			detailURL.setParameter("struts_action", "/sgs/onedoorsearch/detail");
			detailURL.setParameter("fileId", fileId);
			detailURL.setParameter("redirect",  searchContainer.getIteratorURL().toString());
			row.addText(onedoorFile.getNumberReceipt(), detailURL);
			
			// ten ho so
			PmlFilePCCC filePCCC = null;
			String fileName = "";
			try {
				 filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
			} catch (Exception e) {
				 filePCCC = null;
				 fileName = "";
			}
			if (null != filePCCC) {
				fileName = filePCCC.getFileName();
			}
			row.addText("left", "", fileName+"");
			//row.addText(fileName);
			
			// loai ho so
			String fileTypeName = "";
			try {
				PmlFileType fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(onedoorFile.getFileTypeId());
				fileTypeName = fileType.getFileTypeName();
			} catch (Exception e) {
				 fileName = "";
			}
			
			row.addText(fileTypeName);
			
			// trang thai
			String trangThai = "";
			PmlProcessDispose log = null;
			try {
				log = com.sgs.portlet.onedoorsearch.action.ViewAction.getProcessDipose(fileId);
			} catch (Exception e) {
			}

			if (log != null) {
				PmlStateProcess status = null;
				if (0 != log.getStateProcessIdAfter()) {
					status = PmlStateProcessUtil.findByPrimaryKey(log.getStateProcessIdAfter());
				} else {
					status = PmlStateProcessUtil.findByPrimaryKey(log.getStateProcessIdBefore());
				}
				try {
					PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil
							.findByStateProcessId(status.getStateProcessId())
							.get(0);
					trangThai = fileStatusStateProcess.getDescription();
				} catch (Exception e) {
					trangThai = "";
				}
			}

			row.addText(trangThai);
			
			// ngay nhan
			String ngayNhan = "";
			if (onedoorFile.getApplicationDate() != null) {
				ngayNhan = sdf.format(onedoorFile.getApplicationDate());
			}
			row.addText(ngayNhan);
			
			// ngay hen tra
			String ngayHenTra = "";
			if (onedoorFile.getExpectedReturningDate() != null) {
				ngayHenTra = sdf.format(onedoorFile.getExpectedReturningDate());
			}
			row.addText(ngayHenTra);
		
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</div>
</form>
