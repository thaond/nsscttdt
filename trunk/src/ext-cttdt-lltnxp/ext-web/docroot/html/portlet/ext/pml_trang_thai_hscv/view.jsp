<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/html/portlet/ext/pml_trang_thai_hscv/init.jsp" %>
<style>
	<%@ include file="/html/_css/modulework/module.css"%>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("struts_action", "/sgs/pml_trang_thai_hscv/view");

	PmlTrangThaiHSCV pmlTrangThaiHSCV = (PmlTrangThaiHSCV)request.getAttribute(WebKeysExt.PMLTRANGTHAIHSCV);
	long idTrangThaiHSCV = 0; // idTrangThaiHSCV
	boolean isAddNew = true; // add new item
	String tenTrangThaiHSCV = "";
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String PmlTrangThaiHSCVAUFlag = "";
	
	if (pmlTrangThaiHSCV != null) {
		idTrangThaiHSCV = pmlTrangThaiHSCV.getIdTrangThaiHSCV();
		isAddNew = false;
		tenTrangThaiHSCV = pmlTrangThaiHSCV.getTenTrangThaiHSCV();
	}
	else {
		PmlTrangThaiHSCVAUFlag = request.getAttribute("PmlTrangThaiHSCVAUFlag") == null ? "" : String.valueOf(request.getAttribute("PmlTrangThaiHSCVAUFlag"));
		if (PmlTrangThaiHSCVAUFlag.equals("fail")) {
			idTrangThaiHSCV = ParamUtil.getLong(request, "idTrangThaiHSCV");
			isAddNew = false;
		}
		tenTrangThaiHSCV = ParamUtil.getString(request, "tenTrangThaiHSCV");
	}
	
%>
<script type="text/javascript">
	function <portlet:namespace />deletePmlTrangThaiHSCVs() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-trang-thai-hscv") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />deletePmlTrangThaiHSCVIdTrangThaiHSCVs.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_trang_thai_hscv/view" /><portlet:param name="redirect" value="<%= currentURL  %>" /></portlet:actionURL>");
		}
	}

	function deletePmlTrangThaiHSCV(idTrangThaiHSCV){	
		if(trim(idTrangThaiHSCV) != null){
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-trang-thai-hscv") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deletePmlTrangThaiHSCVIdTrangThaiHSCV.value = idTrangThaiHSCV;
				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_trang_thai_hscv/view" /><portlet:param name="redirect" value="<%= currentURL  %>" /></portlet:actionURL>");
			}		
		}
	}
	function <portlet:namespace />savePmlTrangThaiHSCV(cmd) {
		if (cmd == null) {
			cmd = "<%= pmlTrangThaiHSCV != null || (pmlTrangThaiHSCV == null && idTrangThaiHSCV > 0 && PmlTrangThaiHSCVAUFlag.equals("fail")) ? Constants.UPDATE : Constants.ADD %>";
		}

		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		submitForm(document.<portlet:namespace />fm);
	}
	
	function trim(str) {
		if (!str || !str.length) return '';
		var c = str.charCodeAt(0);
		while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
			str = str.substring(1);
			if (str.length > 0) c = str.charCodeAt(0);
		}
		if (str.length>0) {
			c = str.charCodeAt(str.length - 1);
			while(str.length > 0 && (c == 32 || c == 9 || c == 13)) {
				str = str.substring(0, str.length - 1);
				if (str.length > 0) c = str.charCodeAt(str.length - 1, 1);
			}
		}
		return str;
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_trang_thai_hscv/view" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePmlTrangThaiHSCV(); return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />deletePmlTrangThaiHSCVIdTrangThaiHSCVs" />
	<input type="hidden" name="<portlet:namespace />idTrangThaiHSCV" value="<%= idTrangThaiHSCV %>" />
	<input type="hidden" name="<portlet:namespace />deletePmlTrangThaiHSCVIdTrangThaiHSCV" />
	<input name="<portlet:namespace />pmlTrangThaiHSCVURL" type="hidden" value='<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_trang_tha_hscv/view" /></portlet:renderURL>' />
<div class="title_categ"><liferay-ui:message key="trang-thai-hscv" /></div>
<div class="boxcontent">
<%
	PmlTrangThaiHSCVSearch searchContainer = new PmlTrangThaiHSCVSearch(renderRequest, portletURL);
	List headerNames = searchContainer.getHeaderNames();
	headerNames.add(StringPool.BLANK); // Edit 
	headerNames.add(StringPool.BLANK); // Delete
	// Dat row dang checkbox
	searchContainer.setRowChecker(new RowChecker(renderResponse));
%>
<%
PmlTrangThaiHSCVSearchTerms searchTerms = (PmlTrangThaiHSCVSearchTerms)searchContainer.getSearchTerms();
%>
<%@ include file="/html/portlet/ext/pml_trang_thai_hscv/pml_trang_thai_hscv_search_results.jspf" %>
<liferay-ui:error exception="<%= PmlTrangThaiHSCVTenTrangThaiHSCVException.class %>" message="please-enter-a-valid-ten-trang-thai-hscv" />
<liferay-ui:error exception="<%= PmlTrangThaiHSCVCanNotDeleteException.class %>" message="can-not-delete-pml-trang-tha-hscv" />
<table cellspacing="0" width="100%">
		<tr>
			<td width="25%">
				<liferay-ui:message key="ten-trang-thai-hscv" />&nbsp;<span class="od-required-field">(*)</span>&nbsp;:
			</td>
			<td width="45%"><input type="text" name="<portlet:namespace />tenTrangThaiHSCV" value="<%= tenTrangThaiHSCV %>" style="width:90%;" /></td>
			<td width="9%" style="vertical-align: middle;">
				<liferay-ui:message key="is-add-new" />&nbsp;:
			</td>
			<td width="3%" style="vertical-align: middle;"><input type="checkbox" name="<portlet:namespace />isAddNew" <%= isAddNew == true ? "checked" : "" %> disabled="disabled" /></td>
			<td>
				<input type="submit" value='<liferay-ui:message key="save" />' />
				<input type="button" value='<liferay-ui:message key="delete" />' onClick="<portlet:namespace />deletePmlTrangThaiHSCVs()" />
			</td>
		</tr>
	</table>
<% 
	List resultRows = searchContainer.getResultRows();
	for (int ir = 0; ir < results.size(); ir++) {	
			PmlTrangThaiHSCV pmlTrangThaiHSCVList = (PmlTrangThaiHSCV)results.get(ir);

			pmlTrangThaiHSCVList = pmlTrangThaiHSCVList.toEscapedModel();
			ResultRow row = new ResultRow(pmlTrangThaiHSCVList, pmlTrangThaiHSCVList.getIdTrangThaiHSCV(), ir);	

			PortletURL rowURL = renderResponse.createRenderURL();

			rowURL.setWindowState(WindowState.NORMAL);

			rowURL.setParameter("struts_action", "/sgs/pml_trang_thai_hscv/view");
			rowURL.setParameter("redirect", currentURL );
			rowURL.setParameter(Constants.CMD, Constants.EDIT);
			rowURL.setParameter("idTrangThaiHSCV", String.valueOf(pmlTrangThaiHSCVList.getIdTrangThaiHSCV()));

			// Order no
			row.addText(String.valueOf(ir + 1));
			
			// tenTrangThaiHSCV			
			row.addText(pmlTrangThaiHSCVList.getTenTrangThaiHSCV() + "");

			// Edit image
			StringBuilder sm = new StringBuilder();
		
			sm.append("<img title=\"Edit\"");
			sm.append(" border=\"0\" src=\"/html/images/edit.png\" >");
	
			row.addText("center", "middle", sm.toString(), rowURL);

			// Delete image
			
			sm = new StringBuilder();
		
			sm.append("<img title=\"Delete\"");
			sm.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deletePmlTrangThaiHSCV('");
			sm.append(String.valueOf(pmlTrangThaiHSCVList.getIdTrangThaiHSCV()));
			sm.append("')\" >");

			row.addText("center", "middle", sm.toString());
						
			resultRows.add(row);
	}
	%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" /> 
	</div>
</form>
