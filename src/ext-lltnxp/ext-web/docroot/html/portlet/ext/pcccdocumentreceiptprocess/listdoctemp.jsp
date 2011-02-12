<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>

<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/init_search.jsp" %>

<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.util.DataReportUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>

<%@page import="com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>

<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp.PcccDocumentReceiptTempSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp.PcccDocumentReceiptTempSearchTerms"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>

<div style="display: inherit;"> 
<%
// yenlt update 20101022
	String soVanBanDen = ParamUtil.getString(renderRequest, "sovanbanden", "");
	String soHieuGoc = ParamUtil.getString(renderRequest, "sohieugoc", "");
	int loaiSoVB = ParamUtil.getInteger(renderRequest, "loaisocongvan", 0);
	String issuingplaceId = ParamUtil.getString(renderRequest, "issuingplaceId", "");
	String noiphathanh = ParamUtil.getString(renderRequest, "noiphathanh", "");
	String trichyeu = ParamUtil.getString(renderRequest, "trichyeu", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tungay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denngay", "");
	
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	// end yenlt update 20101022
	String  tabChung = ParamUtil.getString(renderRequest, "tabChung", "rad-letter-network");
	
	String hienTrang = renderRequest.getAttribute("hienTrang") == null ? "vbquamang" : (String) renderRequest.getAttribute("hienTrang");
	List<PmlEdmDocumentReceiptTemp> results = renderRequest.getAttribute("results") == null ? new ArrayList<PmlEdmDocumentReceiptTemp>()
			: (List<PmlEdmDocumentReceiptTemp>)renderRequest.getAttribute("results");
	int total1 = (Integer)renderRequest.getAttribute("total1") == null ? 0 : (Integer)renderRequest.getAttribute("total1");

	List<Long> userIdList = new ArrayList<Long>();
	 
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/listdoctemp");
	
	if (renderRequest.getAttribute("userIdList") != null) {
		userIdList = (List<Long>) renderRequest.getAttribute("userIdList");
		for(int i = 0; i < userIdList.size() ; i++) {			
			portletURL.setParameter(String.valueOf(userIdList.get(i)),  String.valueOf(userIdList.get(i)));
		}	
	}
	portletURL.setParameter("hienTrang", hienTrang);
	portletURL.setParameter("tabChung", tabChung);
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	PcccDocumentReceiptTempSearch searchContainer = new PcccDocumentReceiptTempSearch(renderRequest, portletURL);
	searchContainer = renderRequest.getAttribute("searchContainerList") != null ? (PcccDocumentReceiptTempSearch)renderRequest.getAttribute("searchContainerList")
				:  new PcccDocumentReceiptTempSearch(renderRequest, portletURL);
	
	PcccDocumentReceiptTempSearchTerms searchTerms = (PcccDocumentReceiptTempSearchTerms)searchContainer.getSearchTerms();
	searchContainer.setTotal(total1);
	searchContainer.setResults(results);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	
%>
	<input type="hidden" name="hienTrang" value="<%= hienTrang %>" id="<portlet:namespace/>hienTrang">
	<input type="hidden" name="timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>">
<%	
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(WindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/detaildoctemp");
	portletURLRedirect.setParameter("hienTrang", hienTrang);
	portletURLRedirect.setParameter("tabChung", tabChung);
	portletURLRedirect.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
	portletURLRedirect.setParameter("sovanbanden", soVanBanDen);
	portletURLRedirect.setParameter("sohieugoc", soHieuGoc);
	portletURLRedirect.setParameter("loaisocongvan", String.valueOf(loaiSoVB));
	portletURLRedirect.setParameter("issuingplaceId", issuingplaceId);
	portletURLRedirect.setParameter("noiphathanh", noiphathanh);
	portletURLRedirect.setParameter("trichyeu", trichyeu);
	portletURLRedirect.setParameter("tungay", tuNgay);
	portletURLRedirect.setParameter("denngay", denNgay);
	
	List resultRows1 = searchContainer.getResultRows();
	// xuancong: lay ma so trang thai, cap gui, loai van ban, noi phat hanh ra list
	List<Long> stateProcIdsFromSC = new ArrayList<Long>(); // List ma so trang thai tu search container
	List<Long> stateProcIdsMap = new ArrayList<Long>(); // List ma so trang thai mapping
	List<Integer> levelSendIdsFromSC = new ArrayList<Integer>(); // List ma so don vi gui tu search container
	List<Integer> levelSendIdsMap = new ArrayList<Integer>(); // List ma so don vi gui mapping
	List<Long> docTypeIdsFromSC = new ArrayList<Long>(); // List ma so loai van ban tu search container
	List<Long> docTypeIdsMap = new ArrayList<Long>(); // List ma so loai van ban mapping
	List<String> issuingPlaceIdsFromSC = new ArrayList<String>(); // List ma so don vi phat hanh tu search container
	List<String> issuingPlaceIdsMap = new ArrayList<String>(); // List ma so don vi phat hanh mapping
	
	for (int idx = 0; idx < results.size(); idx++) {
		PmlEdmDocumentReceiptTemp docRecItem = (PmlEdmDocumentReceiptTemp) results.get(idx);
		if (stateProcIdsFromSC.indexOf(docRecItem.getStatusId()) < 0) {
			stateProcIdsFromSC.add(docRecItem.getStatusId()); // Ma so trang thai
		}
		if (levelSendIdsFromSC.indexOf(docRecItem.getLevelSendId()) < 0) {
			levelSendIdsFromSC.add(docRecItem.getLevelSendId());
		}
		if (docTypeIdsFromSC.indexOf(docRecItem.getDocumentTypeId()) < 0) {
			docTypeIdsFromSC.add(docRecItem.getDocumentTypeId());
		}
		if (docRecItem.getIssuingPlaceId().trim().length() > 0 
				&& issuingPlaceIdsFromSC.indexOf(docRecItem.getIssuingPlaceId()) < 0) {
			issuingPlaceIdsFromSC.add(docRecItem.getIssuingPlaceId());
		} // end if
	}

	// Doc cac doi tuong ra list va luu ma so cua chung vao list tuong ung
	// Trang thai
	List<PmlStateProcess> stateProcessFromSC = PmlStateProcessLocalServiceUtil.findByStateProcessIds(stateProcIdsFromSC);
	if (stateProcessFromSC != null && !stateProcessFromSC.isEmpty()) {
		// Doc ma so trang thai ra list mapping
		for (int idxTmp = 0; idxTmp < stateProcessFromSC.size(); idxTmp++) {
			PmlStateProcess tmpObj = (PmlStateProcess) stateProcessFromSC.get(idxTmp);
			stateProcIdsMap.add(tmpObj.getStateProcessId());
		}
	}
	
	// Don vi gui
	List<PmlEdmLevelSend> levelSendFromSC = PmlEdmLevelSendLocalServiceUtil.findByLevelSendIds(levelSendIdsFromSC);
	if (levelSendFromSC != null && !levelSendFromSC.isEmpty()) {
		// Doc ma so don vi gui ra list mapping
		for (int idxTmp = 0; idxTmp < levelSendFromSC.size(); idxTmp++) {
			PmlEdmLevelSend tmpObj = (PmlEdmLevelSend) levelSendFromSC.get(idxTmp);
			levelSendIdsMap.add(tmpObj.getLevelSendId());
		}
	}

	// Loai van ban
	List<PmlEdmDocumentType> docTypeFromSC = PmlEdmDocumentTypeLocalServiceUtil.findByDocumentTypeIds(docTypeIdsFromSC);
	if (docTypeFromSC != null && !docTypeFromSC.isEmpty()) {
		// Doc ma so loai van ban ra list mapping
		for (int idxTmp = 0; idxTmp < docTypeFromSC.size(); idxTmp++) {
			PmlEdmDocumentType tmpObj = (PmlEdmDocumentType) docTypeFromSC.get(idxTmp);
			docTypeIdsMap.add(tmpObj.getDocumentTypeId());
		}
	}

	// Don vi phat hanh
	List<PmlEdmIssuingPlace> issuingPlaceFromSC = PmlEdmIssuingPlaceLocalServiceUtil.findByIssuingPlaceIds(issuingPlaceIdsFromSC);
	if (issuingPlaceFromSC != null && !issuingPlaceFromSC.isEmpty()) {
		// Doc ma so don vi phat hanh ra list mapping
		for (int idxTmp = 0; idxTmp < issuingPlaceFromSC.size(); idxTmp++) {
			PmlEdmIssuingPlace tmpObj = (PmlEdmIssuingPlace) issuingPlaceFromSC.get(idxTmp);
			issuingPlaceIdsMap.add(tmpObj.getIssuingPlaceId());
		}
	}
	
	for (int i = 0; i < results.size(); i ++) {
		PmlEdmDocumentReceiptTemp pmlEdmDocumentReceipt = (PmlEdmDocumentReceiptTemp) results.get(i);
		ResultRow row1 = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceipt.getDocumentReceiptId(), i);
		
		PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.ACTION_PHASE);
		rowURL.setWindowState(WindowState.NORMAL);
		rowURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/listdoctemp");
		rowURL.setParameter("documentReceiptIdTemp", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "true");
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME, DocumentReceiptPortletAction.COMMAND_PREFIX + ".AddDocumentReceiptCommand");
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION, "true" );
		rowURL.setParameter("redirect", portletURLRedirect.toString());
		rowURL.setParameter("DOC_CMD", "ADD_TO_DOCTEMP");
		//rowURL.setParameter("tabChung", tabChung);	
		//rowURL.setParameter("hienTrang", hienTrang);

		row1.addText (String.valueOf(i+1));
		
		// Cap gui
		int levelSendId = pmlEdmDocumentReceipt.getLevelSendId();
		PmlEdmLevelSend pmlEdmLevelSend = null;
		
		try {
			// Doc tu List thay cho doc database
			if (levelSendIdsMap.indexOf(levelSendId) >= 0) {
				pmlEdmLevelSend = (PmlEdmLevelSend) levelSendFromSC.get(levelSendIdsMap.indexOf(levelSendId));
			} // end if
		} catch (Exception e) {
			pmlEdmLevelSend = null;
		}
		
		if (pmlEdmLevelSend != null) {					
			row1.addText(pmlEdmLevelSend.getLevelSendName());
		} else {
			row1.addText("");
		}
		
		// Loai cong van 
		long documentTypeId = pmlEdmDocumentReceipt.getDocumentTypeId();
		PmlEdmDocumentType pmlEdmDocumentType = null;
		try {
			// Doc tu List thay cho doc database
			if (docTypeIdsMap.indexOf(documentTypeId) >= 0) {
				pmlEdmDocumentType = (PmlEdmDocumentType) docTypeFromSC.get(docTypeIdsMap.indexOf(documentTypeId));
			} // end if
		} catch (Exception e) {
			pmlEdmDocumentType = null;
		}
		
		if (pmlEdmDocumentType != null) {
			row1.addText(pmlEdmDocumentType.getDocumentTypeName());
				} else {
			row1.addText("");
		}
		
		// So cong van den
		row1.addText(pmlEdmDocumentReceipt.getNumberDocumentReceipt(), rowURL);
		
		// So hieu
		row1.addText(pmlEdmDocumentReceipt.getDocumentReference(), rowURL);
		
		// Ngay den	
		row1.addText(pmlEdmDocumentReceipt.getDateArrive() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive()) : "");
		
		// Noi phat hanh
		String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
		
		PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
		try {
			// Doc tu list thay cho doc database
			if (issuingPlaceIdsMap.indexOf(issuingPlaceId) >= 0) {
				pmlEdmIssuingPlace = issuingPlaceFromSC.get(issuingPlaceIdsMap.indexOf(issuingPlaceId));
			}
		} catch (Exception e) {
			pmlEdmIssuingPlace = null;
		}
		
		if (pmlEdmIssuingPlace != null) {
			row1.addText(pmlEdmIssuingPlace.getIssuingPlaceName());
				} else {
			row1.addText(pmlEdmDocumentReceipt.getIssuingPlaceOtherName());					
		}
		
		// Trich yeu
		row1.addText(pmlEdmDocumentReceipt.getBriefContent());
		
		String procTypeDesc = ""; // Dien giai cach thuc xu ly
		if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("1")) { // VB luu tham khao
			procTypeDesc = " (VB l\u01B0u tham kh\u1EA3o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("2")) { // VB bao cao
			procTypeDesc = " (VB b\u00E1o c\u00E1o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("3")) { // VB can soan vb tra loi
			procTypeDesc = " (VB ph\u1EA3i so\u1EA1n VB tr\u1EA3 l\u1EDDi)";
		}
		
		resultRows1.add(row1);
	}
	
	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	
	if (end > total) {
		end = total;
	}
	
	if (rowChecker != null) {
		if (headerNames != null) {
			headerNames.add(0, rowChecker.getAllRowsCheckBox());
		}
	}
	
	if (resultRows.isEmpty() && (headerNames == null)) {
		headerNames = new ArrayList<String>();
		headerNames.add(StringPool.BLANK);
	}
%>

<c:if test="<%= (resultRows.size() > 0) || ((resultRows.size() == 0) && (emptyResultsMessage != null)) %>">
		<c:if test="<%= paginate %>">
		
			<div  class="taglib-search-iterator-page-iterator-top">	
				<div style="display: none;">		
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</div>	
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/pagedoctemp.jsp" %>
			</div>
			
		</c:if>
	
		<div class="results-grid">
			<table class="taglib-search-iterator" cellspacing="0" width="100%">
			<tr class="portlet-section-header results-header">
	
			<%
			for (int i = 0; (headerNames != null) && (i < headerNames.size()); i++) {
				String headerName = headerNames.get(i);
	
				String orderKey = null;
				String orderByType = null;
				boolean orderCurrentHeader = false;
	
				if (orderableHeaders != null) {
					orderKey = (String)orderableHeaders.get(headerName);
	
					if (orderKey != null) {
						orderByType = searchContainer.getOrderByType();
	
						if (orderKey.equals(searchContainer.getOrderByCol())) {
							orderCurrentHeader = true;
						}
					} // end if
				}
	
				if (orderCurrentHeader) {
					if (orderByType.equals("asc")) {
						orderByType = "desc";
					} else {
						orderByType = "asc";
					}
				}
			%>
	
				<th class="col-<%= i + 1 %>"	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					
					<c:if test="<%= orderKey != null %>">
					
						<a onclick='viewListDocument("<%= 
							searchContainer.getIteratorURL().toString() %>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
					</c:if>
	
					<c:if test="<%= orderCurrentHeader %>">
						<i>
					</c:if>
	
					<%
					String headerNameValue = LanguageUtil.get(pageContext, headerName);
					%>
	
					<c:choose>
						<c:when test="<%= headerNameValue.equals(StringPool.BLANK) %>">
							<%= StringPool.NBSP %>
						</c:when>
						<c:otherwise>													
							<%= headerNameValue %> 	
						</c:otherwise>
					</c:choose>
					
					<c:if test="<%= orderCurrentHeader %>">
						</i>
					</c:if>
	
					<c:if test="<%= orderKey != null %>">
						</a>
					</c:if>
				</th>
	
			<%
			}
			%>
	
			</tr>
	
			<c:if test="<%= (resultRows.size() == 0) && (emptyResultsMessage != null) %>">
				<tr class="portlet-section-body results-row">
					<td align="center" colspan="<%= headerNames.size() %>">
						<%= LanguageUtil.get(pageContext, emptyResultsMessage) %>
					</td>
				</tr>
			</c:if>
	
			<%
			boolean allRowsIsChecked = true;
	
			for (int i = 0; i < resultRows.size(); i++) {
				ResultRow row = (ResultRow)resultRows.get(i);
	
				String className = "portlet-section-alternate results-row alt";
				String classHoverName = "portlet-section-alternate-hover results-row alt hover";
	
				if (MathUtil.isEven(i)) {
					className = "portlet-section-body results-row";
					classHoverName = "portlet-section-body-hover results-row hover";
				}
	
				if (Validator.isNotNull(row.getClassName())) {
					className += " " + row.getClassName();
				}
	
				if (Validator.isNotNull(row.getClassHoverName())) {
					classHoverName += " " + row.getClassHoverName();
				}
	
				if (row.isRestricted()) {
					className += " restricted";
					classHoverName += " restricted";
				}
	
				row.setClassName(className);
				row.setClassHoverName(classHoverName);
	
				request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW, row);
	
				List entries = row.getEntries();
	
				if (rowChecker != null) {
					boolean rowIsChecked = rowChecker.isChecked(row.getObject());
	
					if (!rowIsChecked) {
						allRowsIsChecked = false;
					}
	
					row.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(rowIsChecked, row.getPrimaryKey()));
				}
			%>
	
				<tr class="<%= className %>"
					<c:if test="<%= searchContainer.isHover() %>">
						onmouseover="this.className = '<%= classHoverName %>';" onmouseout="this.className = '<%= className %>';"
					</c:if>
				>
	
				<%
				for (int j = 0; j < entries.size(); j++) {
					SearchEntry entry = (SearchEntry)entries.get(j);
	
					entry.setIndex(j);
	
					request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW_ENTRY, entry);
				%>
	
					<td align="<%= entry.getAlign() %>" class="col-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
						<% entry.print(pageContext);%>
					</td>
				<%
				}
				%>
				</tr>
	
			<%
			}
			%>
	
			</table>
		</div>
	
		<c:if test="<%= (resultRows.size() > 10) && paginate %>">
			<div class="taglib-search-iterator-page-iterator-bottom">
				<div style="display: none;">			
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</div>	
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/pagedoctemp.jsp" %>
			</div>
		</c:if>
	
		<c:if test="<%= (rowChecker != null) && (resultRows.size() > 0) && Validator.isNotNull(rowChecker.getAllRowsId()) && allRowsIsChecked %>">
			<script type="text/javascript">
				document.<%= rowChecker.getFormName() %>.<%= rowChecker.getAllRowsId() %>.checked = true;
			</script>
		</c:if>
	</c:if>
</div>
<div align="right" id="table-button">
	<input type="button" value='<liferay-ui:message key="print"/>' onclick="<portlet:namespace />addReportActionFrom('word');"/>
</div>