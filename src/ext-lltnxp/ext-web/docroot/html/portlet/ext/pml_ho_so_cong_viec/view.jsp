<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<%
	long userId = 0;

	if (Validator.isNotNull(user)) {
		userId = user.getUserId();
	}

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/view");
%>



<script type="text/javascript">
function deleteHSCV(delItemId)
{
	if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-item") %>')) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
		document.<portlet:namespace />fm.<portlet:namespace />deleteHSCVId.value = delItemId;
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
	}
}

function expireHSCV(itemId) 
{
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
	PmlHoSoCongViecSearch searchContainer = new PmlHoSoCongViecSearch(renderRequest, portletURL);
%>

<liferay-ui:search-form page="/html/portlet/ext/pml_ho_so_cong_viec/pml_ho_so_cong_viec_search.jsp" searchContainer="<%= searchContainer %>" />

<%
	PmlHoSoCongViecSearchTerms searchTerms = (PmlHoSoCongViecSearchTerms)searchContainer.getSearchTerms();
%>

<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/pml_ho_so_cong_viec_search_results.jspf" %>

<div class="separator"><!-- --></div>

<liferay-ui:error exception="<%= PmlHoSoCongViecReferenceException.class %>" message="khongthe_xoa_vi_rangbuoc_dulieu" />

<%
	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		PmlHoSoCongViec pmlHoSoCongViec = (PmlHoSoCongViec)results.get(i);

		pmlHoSoCongViec = pmlHoSoCongViec.toEscapedModel();
		
		long pmlHoSoCongViecId = pmlHoSoCongViec.getIdHoSoCongViec();

		ResultRow row = new ResultRow(pmlHoSoCongViec, pmlHoSoCongViecId, i);

		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setWindowState(WindowState.NORMAL);

		rowURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/viewdetail");
		rowURL.setParameter("redirect", currentURL );
		rowURL.setParameter("idHoSoCongViec", String.valueOf(pmlHoSoCongViecId));

		// Stt
		row.addText(String.valueOf(i + 1));

		// So hieu hscv
		row.addText(pmlHoSoCongViec.getSoHieuHSCV(), rowURL);

		// Tieu de
		row.addText(pmlHoSoCongViec.getTieuDe(), rowURL);

		// Ngay mo hscv
		String ngayMoHSCVStr = "";
		Date ngayMoHSCV = pmlHoSoCongViec.getNgayMoHSCV();
		if (Validator.isNotNull(ngayMoHSCV)) {
			ngayMoHSCVStr = df.format(ngayMoHSCV);
		}
		
		row.addText(ngayMoHSCVStr);

		// Linh vuc
		String fieldName = "";
		String fieldId = pmlHoSoCongViec.getIdLinhVuc();
		
		if (Validator.isNotNull(fieldId)) {
			PmlField pmlField = PmlFieldLocalServiceUtil.getPmlField(fieldId);
			
			if (Validator.isNotNull(pmlField)) {
				fieldName = pmlField.getFieldName();
			}
		}
		
		row.addText(fieldName);
		
		row.addText(pmlHoSoCongViec.getVanDeLienQuan());
		
		// Ho so cha
		String hoSoCongViecChaTieuDe = "";
		long hoSoCongViecChaId = pmlHoSoCongViec.getIdHSCVCha();
		
		if (hoSoCongViecChaId > 0) {
			PmlHoSoCongViec pmlHoSoCongViecCha = PmlHoSoCongViecLocalServiceUtil.getPmlHoSoCongViec(hoSoCongViecChaId);
			
			if (Validator.isNotNull(pmlHoSoCongViecCha)) {
				hoSoCongViecChaTieuDe = pmlHoSoCongViecCha.getTieuDe();
			}
		}
		
		row.addText(hoSoCongViecChaTieuDe);
		
		// Nguoi lap
		//xuancong close row.addText(pmlHSCV.getUserName());

		// So van ban
		long soVanBan = PmlChiTietHSCVLocalServiceUtil.countByIdHoSoCongViec(pmlHoSoCongViecId);
		row.addText(String.valueOf(soVanBan), rowURL);
		
		// Url dung cho hieu chinh, xoa, expire
		PortletURL editURL = renderResponse.createRenderURL();

		editURL.setWindowState(WindowState.NORMAL);
		editURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/edit");
		editURL.setParameter("redirect", currentURL );
		editURL.setParameter(Constants.CMD, Constants.EDIT);
		editURL.setParameter("idHoSoCongViec", String.valueOf(pmlHoSoCongViecId));
		row.addText("center", "middle", "<img src='/html/images/edit.png' border='0' title='Edit' />", editURL);
		
		// Ngung hoat dong
		StringBuilder sb = new StringBuilder();
	
		sb.append("<img title=\"Expire\"");
		sb.append(" border=\"0\" src=\"/html/images/error.png\" onClick=\"expireHSCV('");
		sb.append(String.valueOf(pmlHoSoCongViecId));
		sb.append("')\" >");
		row.addText("center", "middle", sb.toString());

		// Xoa
		sb = new StringBuilder();
	
		sb.append("<img title=\"Delete\"");
		sb.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deleteHSCV('");
		sb.append(String.valueOf(pmlHoSoCongViecId));
		sb.append("')\" >");
		row.addText("center", "middle", sb.toString());

		// Add result row
		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</div>
</form>
