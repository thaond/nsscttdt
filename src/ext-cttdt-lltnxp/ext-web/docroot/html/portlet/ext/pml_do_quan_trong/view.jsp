<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/html/portlet/ext/pml_do_quan_trong/init.jsp" %>
<style>
	<%@ include file="/html/_css/modulework/module.css"%>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>	
</style>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_do_quan_trong/view");
	PmlDoQuanTrong pmlDoQuanTrong = (PmlDoQuanTrong)request.getAttribute(WebKeysExt.PMLDOQUANTRONG);
	long idDoQuanTrong = 0; // idDoQuanTrong
	boolean isAddNew = true; // add new item
	String tenDoQuanTrong = "";
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String PmlDoQuanTrongAUFlag = "";
	if (pmlDoQuanTrong != null) {
		idDoQuanTrong = pmlDoQuanTrong.getIdDoQuanTrong();
		isAddNew = false;
		tenDoQuanTrong = pmlDoQuanTrong.getTenDoQuanTrong();
	}
	else {
		PmlDoQuanTrongAUFlag = request.getAttribute("PmlDoQuanTrongAUFlag") == null ? "" : String.valueOf(request.getAttribute("PmlDoQuanTrongAUFlag"));
		if (PmlDoQuanTrongAUFlag.equals("fail")) {
			idDoQuanTrong = ParamUtil.getLong(request, "idDoQuanTrong");
			isAddNew = false;
		}
		tenDoQuanTrong = ParamUtil.getString(request, "tenDoQuanTrong");
	}
	
%>
<script type="text/javascript">
	function <portlet:namespace />deletePmlDoQuanTrongs() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-do-quan-trong") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />deletePmlDoQuanTrongIdDoQuanTrongs.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_do_quan_trong/view" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
	
	function deletePmlDoQuanTrong(idDoQuanTrong) {
		if (trim(idDoQuanTrong) != null ){
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-do-quan-trong") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deletePmlDoQuanTrongIdDoQuanTrong.value = idDoQuanTrong;
				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_do_quan_trong/view" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
			}
		}
	}

	function <portlet:namespace />savePmlDoQuanTrong(cmd) {
		if (cmd == null) {
			cmd = "<%= pmlDoQuanTrong != null || (pmlDoQuanTrong == null && idDoQuanTrong > 0 && PmlDoQuanTrongAUFlag.equals("fail")) ? Constants.UPDATE : Constants.ADD %>";
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

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_do_quan_trong/view" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePmlDoQuanTrong(); return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />deletePmlDoQuanTrongIdDoQuanTrongs" />
	<input type="hidden" name="<portlet:namespace />deletePmlDoQuanTrongIdDoQuanTrong" />
	<input type="hidden" name="<portlet:namespace />idDoQuanTrong" value="<%= idDoQuanTrong %>" />
	<input name="<portlet:namespace />pmlDoQuanTrongURL" type="hidden" value='<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_do_quan_trong/view" /></portlet:renderURL>' />
<div class="title_categ"><liferay-ui:message key="do-quan-trong-hscv" /></div>
    <div class="boxcontent">
<%
	PmlDoQuanTrongSearch searchContainer = new PmlDoQuanTrongSearch(renderRequest, portletURL);
	List headerNames = searchContainer.getHeaderNames();

	headerNames.add(StringPool.BLANK); // Edit 
	headerNames.add(StringPool.BLANK); // Delete
	// Dat row dang checkbox
	searchContainer.setRowChecker(new RowChecker(renderResponse));
%>

<%
PmlDoQuanTrongSearchTerms searchTerms = (PmlDoQuanTrongSearchTerms)searchContainer.getSearchTerms();
%>
<%@ include file="/html/portlet/ext/pml_do_quan_trong/pml_do_quan_trong_search_results.jspf" %>
<liferay-ui:error exception="<%= PmlDoQuanTrongTenDoQuanTrongException.class %>" message="please-enter-a-valid-ten-do-quan-trong" />
<liferay-ui:error exception="<%= PmlDoQuanTrongCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
<table cellspacing="0" width="100%">
		<tr>
			<td width="18%">
				<liferay-ui:message key="ten-do-quan-trong" />&nbsp;<span style="color:red;">(*)</span>&nbsp;:
			</td>
			<td width="53%"><input type="text" name="<portlet:namespace />tenDoQuanTrong" value="<%= tenDoQuanTrong %>" style="width:90%;" /></td>
			<td width="9%" style="vertical-align: middle;">
				<liferay-ui:message key="is-add-new" />&nbsp;:
			</td>
			<td width="3%" style="vertical-align: middle;"><input type="checkbox" name="<portlet:namespace />isAddNew" <%= isAddNew == true ? "checked" : "" %> disabled="disabled" /></td>
			<td>
				<input type="submit" value='<liferay-ui:message key="save" />' />
				<input type="button" value='<liferay-ui:message key="delete" />' onclick="<portlet:namespace />deletePmlDoQuanTrongs()" />
			</td>
		</tr>
	</table>
<% 
	List resultRows = searchContainer.getResultRows();
	for (int ir = 0; ir < results.size(); ir++) {	
			PmlDoQuanTrong pmlDoQuanTrongList = (PmlDoQuanTrong)results.get(ir);

			pmlDoQuanTrongList = pmlDoQuanTrongList.toEscapedModel();
			ResultRow row = new ResultRow(pmlDoQuanTrongList, pmlDoQuanTrongList.getIdDoQuanTrong(), ir);	

			PortletURL rowURL = renderResponse.createRenderURL();

			rowURL.setWindowState(WindowState.NORMAL);

			rowURL.setParameter("struts_action", "/sgs/pml_do_quan_trong/view");
			rowURL.setParameter("redirect", currentURL);
			rowURL.setParameter(Constants.CMD, Constants.EDIT);
			rowURL.setParameter("idDoQuanTrong", String.valueOf(pmlDoQuanTrongList.getIdDoQuanTrong()));

			// Order no
			row.addText(String.valueOf(ir + 1));
			
			// tenDoQuanTrong			
			row.addText(pmlDoQuanTrongList.getTenDoQuanTrong() + "");

			// Edit image
			StringBuilder sm = new StringBuilder();
		
			sm.append("<img title=\"Edit\"");
			sm.append(" border=\"0\" src=\"/html/images/edit.png\" >");
			
			row.addText("center", "middle", sm.toString(), rowURL);

			// Delete image
			
			sm = new StringBuilder();
		
			sm.append("<img title=\"Delete\"");
			sm.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deletePmlDoQuanTrong('");
			sm.append(String.valueOf(pmlDoQuanTrongList.getIdDoQuanTrong()));
			sm.append("')\" >");

			row.addText("center", "middle", sm.toString());
						
			resultRows.add(row);
	}
	%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" /> 
</div>
</form>