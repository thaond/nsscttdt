<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/page_iterator/init_search.jsp" %>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearch"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchTerms"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PcccDocumentSendProcessSearchDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlDocumentSendLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>
<%@page import="com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl"%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>

<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<div style="display: inherit;"> 
<%
	//yenlt update 20101023
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	String soKyHieu = ParamUtil.getString(renderRequest, "soKyHieu" , "");
	long loaiVB = ParamUtil.getLong(renderRequest, "loaisocongvan", 0);
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

	// end yenlt update 20101023
	
	String  tabChung = ParamUtil.getString(renderRequest,"tabChung");
	long statusId = renderRequest.getAttribute("statusId") == null ? 0 : (Long) renderRequest.getAttribute("statusId");
	String hienTrang = renderRequest.getAttribute("hienTrang") == null ? "dangXuLy" : (String) renderRequest.getAttribute("hienTrang");
	boolean isExpired = renderRequest.getAttribute("isExpired") == null ? false : (Boolean) renderRequest.getAttribute("isExpired");
	//yenlt update 09/04/2010
	int year = renderRequest.getAttribute("year") == null ? new Date().getYear() + 1900 : (Integer) renderRequest.getAttribute("year");
	String nguoiXuLy = renderRequest.getAttribute( "nguoiXuLy") == null ? "xuLyChung" : (String) renderRequest.getAttribute( "nguoiXuLy") ;
	long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(renderRequest)); 
	//end
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/list");
	
	List<Long> userIdList = new ArrayList<Long>();
	 
	if (renderRequest.getAttribute("listUser_LDVP_Long") != null) {
		userIdList = (List<Long>) renderRequest.getAttribute("listUser_LDVP_Long");
		for(int i = 0; i < userIdList.size() ; i++) {			
			portletURL.setParameter(String.valueOf(userIdList.get(i)),  String.valueOf(userIdList.get(i)));
		}	
	}
	portletURL.setParameter("statusId", String.valueOf(statusId));
	portletURL.setParameter("hienTrang", hienTrang);
	portletURL.setParameter("isExpired", String.valueOf(isExpired));
	portletURL.setParameter("nguoiXuLy", nguoiXuLy);
	portletURL.setParameter("year", String.valueOf(year));
	portletURL.setParameter("tabChung", tabChung);
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);

	// yenlt update 20101023
	PcccDocumentSendProcessSearch searchContainer = new PcccDocumentSendProcessSearch(renderRequest, portletURL);
	searchContainer = renderRequest.getAttribute("searchContainerList") != null ? (PcccDocumentSendProcessSearch)renderRequest.getAttribute("searchContainerList")
				:  new PcccDocumentSendProcessSearch(renderRequest, portletURL);
	
	PcccDocumentSendProcessSearchTerms searchTerms = (PcccDocumentSendProcessSearchTerms)searchContainer.getSearchTerms();
	searchContainer.setTotal(total1);
	searchContainer.setResults(results);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	// end yenlt update 20101023
	
	/* yenlt close 20101023
	//List<String> headerNames1 = searchContainerList.getHeaderNames();
	///int total1 = 0;
	//List<PmlEdmDocumentSend> results = null; 
	if (hienTrang.equals("dangXuLy")) { 
			if (!isExpired) {
				total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy(userIdList, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca"); 
		
				results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy(userIdList, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()),"tatca",
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
			} else {
				total1 = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy_TreHan(userIdList, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca"); 
		
				results = PmlEdmDocumentSendLocalServiceUtil.findByDocumentSend_Users_Status_DangXuLy_TreHan(userIdList, statusId, String.valueOf(searchTerms.getLoaiSoCongVan()), "tatca",
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
			}
	
	}
	else if (hienTrang.equals("daXuLy")) {
		
		if (!isExpired){
			if ("xuLyChung".equals(nguoiXuLy)) {
				results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				
				total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung(userId, String.valueOf(year),  String.valueOf(searchTerms.getLoaiSoCongVan()));
			}
			else  if ("tuXuLy".equals(nguoiXuLy)) {
				results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
							searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
				
				total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()));
              
			}
		} else {
			if ("xuLyChung".equals(nguoiXuLy)) {
				results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyChung_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
			
				total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyChung_treHan(userId, String.valueOf(year),  String.valueOf(searchTerms.getLoaiSoCongVan()));
			
			}
			else  if ("tuXuLy".equals(nguoiXuLy)) {
				results = PmlEdmDocumentSendLocalServiceUtil.getListCVDiDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()),
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
			
				total1 = PmlEdmDocumentSendLocalServiceUtil.countListCVDiDaXuLyTuXuLy_treHan(userId, String.valueOf(year), String.valueOf(searchTerms.getLoaiSoCongVan()));
			}
		}
	}
	searchContainerList.setTotal(total1);
	searchContainerList.setResults(results);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
	 yenlt close 20101023 */
	//end
			
%>
	
	<!-- phmphuc them 22/04/2010 -->
	<input type="hidden" name="statusId" value="<%= statusId %>" id="statusId">
	<input type="hidden" name="isExpired" value="<%= isExpired %>" id="isExpired">
	<input type="hidden" name="hienTrang" value="<%= hienTrang %>" id="hienTrang">
	<input type="hidden" name="nguoiXuLy" value="<%= nguoiXuLy %>" id="nguoiXuLy">
	<input type="hidden" name="year" value="<%= String.valueOf(year) %>" id="year"><!-- ltyen 23/04/2010 -->
<%	
	// minh update 20100203
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
//	portletURLRedirect.setWindowState(LiferayWindowState.MAXIMIZED);
	portletURLRedirect.setWindowState(WindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/view");
	portletURLRedirect.setParameter("hienTrang", hienTrang);//yenlt update 14/04/2010
	// end
	//yenlt update 22/04/2010
	portletURLRedirect.setParameter("nguoiXuLy", nguoiXuLy);
	portletURLRedirect.setParameter("isExpired", String.valueOf(isExpired));
	portletURLRedirect.setParameter("year", String.valueOf(year));
	portletURLRedirect.setParameter("statusId", String.valueOf(statusId)); // yenlt update 10082010
	//end
	// yenlt update 20101023
	portletURLRedirect.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
	portletURLRedirect.setParameter("soKyHieu", soKyHieu);
	portletURLRedirect.setParameter("loaisocongvan", String.valueOf(loaiVB));
	portletURLRedirect.setParameter("donViSoanThao", donViSoanThao);
	portletURLRedirect.setParameter("nguoiKy", nguoiKy);
	portletURLRedirect.setParameter("trichYeu", trichYeu);
	portletURLRedirect.setParameter("coQuanNhan", coQuanNhan);
	portletURLRedirect.setParameter("tuNgay", tuNgay);
	portletURLRedirect.setParameter("denNgay", denNgay);
	List resultRows1 = searchContainer.getResultRows();
	// end yenlt update 20101023
	//List resultRows1 = searchContainerList.getResultRows();
		
	for (int i = 0; i < results.size(); i ++) {
		PmlEdmDocumentSend pmlEdmDocumentSend = (PmlEdmDocumentSend) results.get(i);
		
		ResultRow row1 = new ResultRow(pmlEdmDocumentSend, pmlEdmDocumentSend.getDocumentSendId(), i);
		
		//PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 33011, PortletRequest.RENDER_PHASE);
		PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
		rowURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/detail");
		rowURL.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "true");
		rowURL.setParameter("hienTrang", hienTrang);
		rowURL.setParameter("redirect", portletURLRedirect.toString() + "&"+ searchContainer.getCurParam() +"="+ searchContainer.getCurValue());
		rowURL.setParameter("tabChung", tabChung);	
		// minh update 20100323
		PmlDocumentSendLog pmlDocumentSendLog = null;
		try {
			pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
					pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0) , null , 0).get(0);
		} catch (Exception e) {
			try {
				pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor_StateProcessIdAfter(
						pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0) , 0).get(0);
			} catch (Exception ex) {
				try {					
					pmlDocumentSendLog =  PmlDocumentSendLogUtil.findByDocumentSendId_Processor(
							pmlEdmDocumentSend.getDocumentSendId(), userIdList.get(0)).get(0);	
				} catch (Exception e2) {
					pmlDocumentSendLog = new PmlDocumentSendLogImpl();
				}
			}
		}
		rowURL.setParameter("statusId", String.valueOf(statusId));	
		if (pmlDocumentSendLog != null) {
			rowURL.setParameter("stateProcessId", String.valueOf(pmlDocumentSendLog.getStateProcessIdBefore()));
		}  
		// end minh update 20100323	
		// yenlt update 20101102 - rut lai vb
		boolean rutLai = false;
		List<PmlDocumentSendLog> logReturnList = new ArrayList<PmlDocumentSendLog>();
		logReturnList = PmlDocumentSendLogUtil.findByDocumentSendId_Processor(pmlEdmDocumentSend.getDocumentSendId(), userId);
		long receiverIdBack = -1;
		if (logReturnList.size() == 1) {
			PmlDocumentSendLog logBack = logReturnList.get(0);
			if (logBack.getDateProcess() != null) { // TH da gui VB
				if (logBack.getReceiveDate() != null) {// nguoi duoc gui da nhan
					rutLai = false;
				} else {// nguoi duoc gui chua nhan VB
					rutLai = true;
					receiverIdBack = logBack.getReceiver();
				}
			} else {// TH chua gui VB
				rutLai = false;
			}
		} else if (logReturnList.size() > 1) {
			List<PmlDocumentSendLog> logList = new ArrayList<PmlDocumentSendLog>();
			Collections.sort(logReturnList, new Comparator<PmlDocumentSendLog>() {
				public int compare(PmlDocumentSendLog o1, PmlDocumentSendLog o2) {
					int sort = o2.getTransition_()- o1.getTransition_();
					return sort;
				}
			});
			Date dateProcess = null;
			if (logReturnList.get(0).getDateProcessTime() != null) {
				dateProcess = logReturnList.get(0).getDateProcessTime();
			}
			
			for (PmlDocumentSendLog logReturnTemp : logReturnList) {
				if (logReturnTemp.getDateProcessTime()!= null && logReturnTemp.getDateProcessTime().equals(dateProcess)) {
					if (logReturnTemp.getReceiveDate() == null) {
						rutLai = true;
						logList.add(logReturnTemp);
					} else {
						rutLai = false;
						break;
					}
				}
				continue;
			}
			if (rutLai) {
				PmlDocumentSendLog logTransition = logList.get(logList.size() -1);
				PmlDocumentSendLog logReceiverBack = PmlDocumentSendLogUtil.
						findByDocumentSendId_Transition(pmlEdmDocumentSend.getDocumentSendId(), logTransition.getTransition_()).get(0);
				receiverIdBack = logReceiverBack.getReceiver();
			}
		}
		rowURL.setParameter("rutLai", String.valueOf(rutLai));
		rowURL.setParameter("receiverId", String.valueOf(userId));
		rowURL.setParameter("receiverIdBack", String.valueOf(receiverIdBack));
		// end yenlt 20101102
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
			row1.addText("&nbsp;");
		}
		//so phat hanh
		
		if ("rad-letter-do-finish".equals(tabChung)) {
			row1.addText(pmlEdmDocumentSend.getDocumentReference(), rowURL);
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
			row1.addText("&nbsp;");
		}
		
		// nguoi ky			
		row1.addText(pmlEdmDocumentSend.getSignerName());
		
		// Noi nhan
		row1.addText(pmlEdmDocumentSend.getReceivingPlace());
		
		// Trich yeu
		if (!"".equals(pmlEdmDocumentSend.getBriefContent())) {
			row1.addText(pmlEdmDocumentSend.getBriefContent());
		} else {
			row1.addText("&nbsp;");
		}
		
		// phmphuc them 12/11/2010 - yeu cau xu ly
		String processInfomation = "";
		try {
			processInfomation = resultsLog.get(i).getProcessInfomation();
		} catch (Exception e) { }
		row1.addText(processInfomation);
		// end phmphuc add 12/11/2010
		
		// trang thai
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		long stateProcessId = pmlDocumentSendLog.getStateProcessIdBefore();
		if ("daXuLy".equals(hienTrang)) {
			stateProcessId = pmlDocumentSendLog.getStateProcessIdAfter();
		}
		if (pmlDocumentSendLog != null) {
			try {
				fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, stateProcessId).get(0);
		// end minh update 20100323		
			} catch (Exception e) {
				fileStatusStateProcess = null;
			}
		}
		
		if (fileStatusStateProcess != null) {
			row1.addText(fileStatusStateProcess.getDescription());
		} else {
			row1.addText("&nbsp;");
		}
	
		resultRows1.add(row1);
		
	} 
	
	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");// yenlt close 20101023
	
	//boolean paginate = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:search-iterator:paginate"));
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
	
	if ("rad-letter-do-finish".equals(tabChung)) {
		headerNames.add(2,LanguageUtil.get(pageContext, "so-phat-hanh"));
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
	
				<td class="col-<%= i + 1 %>"
	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					<c:if test="<%= orderKey != null %>">
						<a onclick='viewListDocumentSend("<%=
							//portletURLString  //ltyen update 24/04/2010
							//+ "&" + PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaiSoCongVan()
							//searchContainerList.getIteratorURL().toString() //end
							searchContainer.getIteratorURL().toString() //yenlt update 20101023
							%>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
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
				</td>
	
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
					onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);"
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
<%
	int loaiSoCongVan = ((PcccDocumentSendProcessSearchDisplayTerms) searchContainer.getDisplayTerms()).getLoaiSoCongVan();
	String paramLoaiSoCongVan = "word&".
		concat(renderResponse.getNamespace()).
		concat(PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN).
		concat("=").
		concat(String.valueOf(loaiSoCongVan));
%>

<div align="right" id="table-button">
			<input type="button" value='<liferay-ui:message key="print"/>' onclick="<portlet:namespace />addReportActionFrom('<%= paramLoaiSoCongVan %>');" />
</div>