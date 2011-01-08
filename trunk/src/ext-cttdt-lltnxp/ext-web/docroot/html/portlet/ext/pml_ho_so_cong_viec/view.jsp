<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>
<%@page import="com.sgs.portlet.field.model.PmlField"%>
<%@page import="com.sgs.portlet.field.service.persistence.PmlFieldUtil"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	
	portletURL.setWindowState(WindowState.NORMAL);
	
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/view");

	// Parse ArrayList hscv 
	List<PmlHoSoCongViec> pmlHoSoCongViecs = PmlHoSoCongViecLocalServiceUtil.getAll();
	ArrayList<Long> pmlHSCVChaIds = new ArrayList<Long>();
	ArrayList<String> pmlHSCVChaNames = new ArrayList<String>();
	for (int idx = 0; idx < (pmlHoSoCongViecs == null ? 0 : pmlHoSoCongViecs.size()); idx++) {
		PmlHoSoCongViec hscvItem = (PmlHoSoCongViec) pmlHoSoCongViecs.get(idx);
		pmlHSCVChaIds.add(hscvItem.getIdHoSoCongViec());
		pmlHSCVChaNames.add(hscvItem.getTieuDe());
	}
	
	// Parse field ArrayList
	List<PmlField> fields = PmlFieldUtil.findAll();
	ArrayList<String> fieldIds = new ArrayList<String>();
	ArrayList<String> fieldNames = new ArrayList<String>();
	for (int idx = 0; idx < fields.size(); idx++) {
		PmlField fieldItem = (PmlField) fields.get(idx);
		fieldIds.add(fieldItem.getFieldId());
		fieldNames.add(fieldItem.getFieldName());
	}
%>



<script type="text/javascript">
	function deleteHSCV(delItemId) {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-item") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />deleteHSCVId.value = delItemId;
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}

	function expireHSCV(itemId) {
	
		if (itemId == null || itemId == "") {
			alert('<liferay-ui:message key="doituong_khong_tontai" />');
			return;
		}
		document.<portlet:namespace />fm.<portlet:namespace />expireHSCVId.value = itemId;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.EXPIRE %>";
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
	}

</script>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;" class="bgtran">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input name="<portlet:namespace />deleteHSCVId" type="hidden" />
	<input name="<portlet:namespace />expireHSCVId" type="hidden" />
<div class="title_categ"><liferay-ui:message key="ho-so-cong-viec" /></div>
<div class="boxcontent plmhscv">
<%
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	PmlHoSoCongViecSearch searchContainer = new PmlHoSoCongViecSearch(renderRequest, portletURL);

	List<String> headerNames = searchContainer.getHeaderNames();

	headerNames.add(StringPool.BLANK); // Sua
	headerNames.add(StringPool.BLANK); // Ngung hoat dong
	headerNames.add(StringPool.BLANK); // Xoa
%>

	<liferay-ui:search-form
		page="/html/portlet/ext/pml_ho_so_cong_viec/pml_ho_so_cong_viec_search.jsp"
		searchContainer="<%= searchContainer %>"
	/>

<%
	PmlHoSoCongViecSearchTerms searchTerms = (PmlHoSoCongViecSearchTerms)searchContainer.getSearchTerms();
%>

	<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/pml_ho_so_cong_viec_search_results.jspf" %>

	<div class="separator"><!-- --></div>
	<liferay-ui:error exception="<%= PmlHoSoCongViecReferenceException.class %>" message="khongthe_xoa_vi_rangbuoc_dulieu" />

	<%
	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		PmlHoSoCongViec pmlHSCV = (PmlHoSoCongViec)results.get(i);

		pmlHSCV = pmlHSCV.toEscapedModel();

		ResultRow row = new ResultRow(pmlHSCV, pmlHSCV.getIdHoSoCongViec(), i);

		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setWindowState(WindowState.NORMAL);

		rowURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/viewdetail");
		rowURL.setParameter("redirect", currentURL );
		rowURL.setParameter("idHoSoCongViec", String.valueOf(pmlHSCV.getIdHoSoCongViec()));

		// Stt
		row.addText(String.valueOf(i + 1));

		// So hieu hscv
		row.addText(pmlHSCV.getSoHieuHSCV(), rowURL);

		// Tieu de
		row.addText(pmlHSCV.getTieuDe(), rowURL);

		// Ngay mo hscv
		if (pmlHSCV.getNgayMoHSCV() != null) {
			row.addText(String.valueOf(format.format(pmlHSCV.getNgayMoHSCV())));
		}
		else {
			row.addText("&nbsp;");
		}

		// Linh vuc
		String linhVucAdd = "&nbsp;";
		if (fieldIds.contains(pmlHSCV.getIdLinhVuc())) {
			linhVucAdd = String.valueOf(fieldNames.get(fieldIds.indexOf(pmlHSCV.getIdLinhVuc())));
		}
		row.addText(linhVucAdd);
		
		// Van de lien quan
		String vanDeLienQuan = "&nbsp;";
		if (!"".equals(pmlHSCV.getVanDeLienQuan())) {
			vanDeLienQuan = pmlHSCV.getVanDeLienQuan();
		}
		row.addText(vanDeLienQuan);
		
		// Ho so cha
		String hoSoChaAdd = "&nbsp;";
		if (pmlHSCVChaIds.contains(pmlHSCV.getIdHSCVCha())) {
			hoSoChaAdd = String.valueOf(pmlHSCVChaNames.get(pmlHSCVChaIds.indexOf(pmlHSCV.getIdHSCVCha())));
		}
		row.addText(hoSoChaAdd);
		
		// Nguoi lap
		//xuancong close row.addText(pmlHSCV.getUserName());

		// So van ban
		long soVanBan = PmlChiTietHSCVLocalServiceUtil.countByIdHoSoCongViec(pmlHSCV.getIdHoSoCongViec());
		row.addText(String.valueOf(soVanBan), rowURL);
		
		// Url dung cho hieu chinh, xoa, expire
		PortletURL rowURLGeneral = renderResponse.createRenderURL();

		rowURLGeneral.setWindowState(WindowState.NORMAL);

		rowURLGeneral.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/edit");
		rowURLGeneral.setParameter("redirect", currentURL );

		// Sua
		PortletURL editURL = rowURLGeneral; 
		editURL.setParameter(Constants.CMD, Constants.EDIT);
		editURL.setParameter("idHoSoCongViec", String.valueOf(pmlHSCV.getIdHoSoCongViec()));
		row.addText("center", "middle", "<img src='/html/images/edit.png' border='0' title='Edit' />", editURL);
		
		// Ngung hoat dong
		StringBuilder sm = new StringBuilder();
	
		sm.append("<img title=\"Expire\"");
		sm.append(" border=\"0\" src=\"/html/images/error.png\" onClick=\"expireHSCV('");
		sm.append(String.valueOf(pmlHSCV.getIdHoSoCongViec()));
		sm.append("')\" >");
		row.addText("center", "middle", sm.toString());

		// Xoa
		sm = new StringBuilder();
	
		sm.append("<img title=\"Delete\"");
		sm.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deleteHSCV('");
		sm.append(String.valueOf(pmlHSCV.getIdHoSoCongViec()));
		sm.append("')\" >");
		row.addText("center", "middle", sm.toString());

		// Add result row
		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</div>
</form>
