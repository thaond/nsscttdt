<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/page_iterator/init_search.jsp" %>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearch"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchTerms"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchDisplayTerms"%>


<%@page import="com.sgs.portlet.document.model.PmlDocumentSendLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>
<%@page import="com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<div style="display: inherit;"> 

<%
	//yenlt update 20101028
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	long loaiVB = ParamUtil.getLong(renderRequest, "loaiVB", 0);
	String donViSoanThao = ParamUtil.getString(renderRequest, "donViSoanThao", "");
	String nguoiKy = ParamUtil.getString(renderRequest, "nguoiKy", "");
	String trichYeu = ParamUtil.getString(renderRequest, "trichYeu", "");
	String coQuanNhan = ParamUtil.getString(renderRequest, "coQuanNhan", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tuNgay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denNgay", "");
	
	List<PmlEdmDocumentSend> results = renderRequest.getAttribute("results") == null ? new ArrayList<PmlEdmDocumentSend>()
			: (List<PmlEdmDocumentSend>)renderRequest.getAttribute("results");
	int total1 = (Integer)renderRequest.getAttribute("total1") == null ? 0 : (Integer)renderRequest.getAttribute("total1");
	
	// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
	List<PmlDocumentSendLog> resultsLog = renderRequest.getAttribute("resultLogs") == null ? new ArrayList<PmlDocumentSendLog>()
			: (List<PmlDocumentSendLog>)renderRequest.getAttribute("resultLogs");
	// end phmphuc update 12/11/2010

	// end yenlt update 20101028
	long userIdXLT = renderRequest.getAttribute("userIdXLT") == null ? 0 : (Long) renderRequest.getAttribute("userIdXLT");
	long statusId = renderRequest.getAttribute("statusId") == null ? 0 : (Long) renderRequest.getAttribute("statusId");
	boolean vtxulythayldb = renderRequest.getAttribute("vtxulythayldb") == null ? false : (Boolean) renderRequest.getAttribute("vtxulythayldb");
	boolean vtxulythayldvp = renderRequest.getAttribute("vtxulythayldvp") == null ? false : (Boolean) renderRequest.getAttribute("vtxulythayldvp");
	
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(WindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/viewxlt");
	portletURLRedirect.setParameter("vtxulythayldb", String.valueOf(vtxulythayldb));
	portletURLRedirect.setParameter("vtxulythayldvp", String.valueOf(vtxulythayldvp));
	portletURLRedirect.setParameter("statusId", String.valueOf(statusId));
	portletURLRedirect.setParameter("userIdXLT", String.valueOf(userIdXLT));
	// yenlt update 20101023
	portletURLRedirect.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
	portletURLRedirect.setParameter("loaiVB", String.valueOf(loaiVB));
	portletURLRedirect.setParameter("donViSoanThao", donViSoanThao);
	portletURLRedirect.setParameter("nguoiKy", nguoiKy);
	portletURLRedirect.setParameter("trichYeu", trichYeu);
	portletURLRedirect.setParameter("coQuanNhan", coQuanNhan);
	portletURLRedirect.setParameter("tuNgay", tuNgay);
	portletURLRedirect.setParameter("denNgay", denNgay);
	// end yenlt update 20101023
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/xulythayld");
	portletURL.setParameter("statusId", String.valueOf(statusId));
	portletURL.setParameter("userIdXLT", String.valueOf(userIdXLT));
	if (vtxulythayldb) {
		portletURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
	}
	
	if (vtxulythayldvp) {
		portletURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
	}
	
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	// yenlt update 20101028
	PcccDocumentSendProcessSearch searchContainer = new PcccDocumentSendProcessSearch(renderRequest, portletURL);
	searchContainer = renderRequest.getAttribute("searchContainerList") != null ? (PcccDocumentSendProcessSearch)renderRequest.getAttribute("searchContainerList")
				:  new PcccDocumentSendProcessSearch(renderRequest, portletURL);
	
	PcccDocumentSendProcessSearchTerms searchTerms = (PcccDocumentSendProcessSearchTerms)searchContainer.getSearchTerms();
	searchContainer.setTotal(total1);
	searchContainer.setResults(results);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	// end yenlt update 20101028
%>

<div id="divparent">
	
<%
	/* yenlt close 20101028

		List<String> headerNames1 = searchContainerList.getHeaderNames();
		PcccDocumentSendProcessSearchTerms searchTerms = (PcccDocumentSendProcessSearchTerms) searchContainerList.getSearchTerms();
		List<Long> listXLT = new ArrayList<Long>();
		listXLT.add(userIdXLT);
		
		int total1 = 0;
		List<PmlEdmDocumentSend> results = null;
	
		total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users(listXLT,  String.valueOf(searchTerms.getLoaiSoCongVan())); 
		
		results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users(listXLT, String.valueOf(searchTerms.getLoaiSoCongVan()),
					searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());

		searchContainerList.setTotal(total1);
		portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
	yenlt close end 20101028 */
%>	

<%		
		List resultRows1 = searchContainer.getResultRows();
	
			for (int i = 0; i < results.size(); i ++) {
				PmlEdmDocumentSend pmlEdmDocumentSend = (PmlEdmDocumentSend) results.get(i);
				
				ResultRow row1 = new ResultRow(pmlEdmDocumentSend, pmlEdmDocumentSend.getDocumentSendId(), i);
				
				PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
				rowURL.setWindowState(WindowState.NORMAL);
				rowURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/detail");
				rowURL.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
				rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "true");
				if (vtxulythayldb) {
					rowURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
				}
				
				if (vtxulythayldvp) {
					rowURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
				}
				
				rowURL.setParameter("redirect", portletURLRedirect.toString());
				// minh update 20100323
				PmlDocumentSendLog pmlDocumentSendLog = null;
				try {
					pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
							pmlEdmDocumentSend.getDocumentSendId(), userIdXLT , null , 0).get(0);
				} catch (Exception e) {
					try {
					pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_StateProcessIdAfter(
							pmlEdmDocumentSend.getDocumentSendId(), userIdXLT , 0).get(0);
					} catch (Exception ex) {
						pmlDocumentSendLog = new PmlDocumentSendLogImpl();
					}
				}
				rowURL.setParameter("statusId", String.valueOf(statusId));	
				rowURL.setParameter("userIdXLT", String.valueOf(userIdXLT)); // yenlt update 21082010	
				if (pmlDocumentSendLog != null) {
					rowURL.setParameter("stateProcessId", String.valueOf(pmlDocumentSendLog.getStateProcessIdBefore()));
				}  
				// end minh update 20100323		
				
				// STT
				row1.addText (String.valueOf(i + 1));
				
				// loai cong van 
				long documentTypeId = pmlEdmDocumentSend.getDocumentTypeId();
				
				PmlEdmDocumentType pmlEdmDocumentType = null;
				try {
					pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId) ;
				} catch (Exception e) {
					pmlEdmDocumentType = null;
				}
				
				if (pmlEdmDocumentType != null) {
					row1.addText(pmlEdmDocumentType.getDocumentTypeName());
				}
				
				else {
					row1.addText("");
				}
				
				
				// chi tiet
				row1.addText("Chi ti\u1ebft", rowURL);
				
				// nguoi tao
				long editorId = 0;
				editorId = pmlEdmDocumentSend.getEditorId();
				User userEditor = null;
				
				try {
					userEditor = UserUtil.findByPrimaryKey(editorId);
				} catch (Exception e) {
					userEditor = null;
				}
				
				if (userEditor != null) {
					row1.addText(userEditor.getLastName() + " " + userEditor.getMiddleName() + " " + userEditor.getFirstName());
				}
				else {
					row1.addText("");
					
				}
				
				// nguoi ky			
				row1.addText(pmlEdmDocumentSend.getSignerName());
				
				// Noi nhan
				row1.addText(pmlEdmDocumentSend.getReceivingPlace());
				
				// Trich yeu
				row1.addText(pmlEdmDocumentSend.getBriefContent());
				
				// phmphuc them 12/11/2010 - yeu cau xu ly
				String processInfomation = "";
				try {
					processInfomation = resultsLog.get(i).getProcessInfomation();
				} catch (Exception e) { }
				row1.addText(processInfomation);
				// end phmphuc add 12/11/2010
				
				// trang thai
				// minh update 20100323
				//String stateProcess = new DocumentSendLiferayWorkflowService().getCurrentStateOfDocumentSend(pmlEdmDocumentSend.getDocumentSendId());
				
				//PmlStateProcess pmlStateProcess = null; 
				//try {
				//	pmlStateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcess).get(0);
				//} catch (Exception e) {
				//	pmlStateProcess = null; 
				//}
			
				//PmlFileStatusStateProcess fileStatusStateProcess = null;
				//if (pmlStateProcess != null) {
				//try {
				//	fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, pmlStateProcess.getStateProcessId()).get(0);
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				if (pmlDocumentSendLog != null) {
					try {
						fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, pmlDocumentSendLog.getStateProcessIdBefore()).get(0);
				// end minh update 20100323		
					} catch (Exception e) {
						fileStatusStateProcess = null;
					}
				}
				
				
				if (fileStatusStateProcess != null) {
				
					row1.addText(fileStatusStateProcess.getDescription());
				}
				
				else {
					row1.addText("");
				}
		
				resultRows1.add(row1);
			}
			
		%>
	
	<%
	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer"); // yenlt close 20101028
	
//	boolean paginate = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:search-iterator:paginate"));
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
				<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/page_iterator/page.jsp" %>
			</div>
			
		</c:if>
	
		<div class="results-grid">
			<table class="taglib-search-iterator">
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
					}
				}
	
				if (orderCurrentHeader) {
					if (orderByType.equals("asc")) {
						orderByType = "desc";
					}
					else {
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
						<a onclick='viewListDocumentSendXLT("<%= portletURLString + "&" + PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaiSoCongVan() %>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
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
							<c:if test="<%= i== 1 %>">
								<br/>
								<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/list_filter.jsp" />
							</c:if>
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
					onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'
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
	
						<%
						entry.print(pageContext);
						
						%>
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
				<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/page_iterator/page.jsp" %>
			</div>
		</c:if>
	
		<c:if test="<%= (rowChecker != null) && (resultRows.size() > 0) && Validator.isNotNull(rowChecker.getAllRowsId()) && allRowsIsChecked %>">
			<script type="text/javascript">
				document.<%= rowChecker.getFormName() %>.<%= rowChecker.getAllRowsId() %>.checked = true;
			</script>
		</c:if>
	</c:if>	
	</div>


	