<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/html/portlet/ext/pml_tinh_chat/init.jsp" %>
<style>
	<%@ include file="/html/_css/modulework/module.css"%>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<%

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("struts_action", "/sgs/pml_tinh_chat/view");

	PmlTinhChat pmlTinhChat = (PmlTinhChat)request.getAttribute(WebKeysExt.PMLTINHCHAT);
	long idTinhChat = 0; // idTinhChat
	boolean isAddNew = true; // add new TinhChat
	String tenTinhChat = "";
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String PmlTinhChatAUFlag = "";
	
	if (pmlTinhChat != null) {
		idTinhChat = pmlTinhChat.getIdTinhChat();
		isAddNew = false;
		tenTinhChat = pmlTinhChat.getTenTinhChat();
	}
	else {
		PmlTinhChatAUFlag = request.getAttribute("PmlTinhChatAUFlag") == null ? "" : String.valueOf(request.getAttribute("PmlTinhChatAUFlag"));
		if (PmlTinhChatAUFlag.equals("fail")) {
			idTinhChat = ParamUtil.getLong(request, "idTinhChat");
			isAddNew = false;
		}
		tenTinhChat = ParamUtil.getString(request, "tenTinhChat");		
	}
%>
<script type="text/javascript">
	function <portlet:namespace />deletePmlTinhChats() {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-tinh-chat") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />deletePmlTinhChatIdTinhChats.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_tinh_chat/view" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
	
	function deletePmlTinhChat(idTinhChat){	
		if(trim(idTinhChat) != null){
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-pml-tinh-chat") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deletePmlTinhChatIdTinhChat.value = idTinhChat;
				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_tinh_chat/view" /><portlet:param name="redirect" value="<%= currentURL  %>" /></portlet:actionURL>");
			}		
		}
	}
	
	function <portlet:namespace />savePmlTinhChat(cmd) {
		if (cmd == null) {
			cmd = "<%= pmlTinhChat != null || (pmlTinhChat == null && idTinhChat > 0 && PmlTinhChatAUFlag.equals("fail")) ? Constants.UPDATE : Constants.ADD %>";
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

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_tinh_chat/view" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePmlTinhChat(); return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />deletePmlTinhChatIdTinhChats" />
	<input type="hidden" name="<portlet:namespace />deletePmlTinhChatIdTinhChat" />
	<input type="hidden" name="<portlet:namespace />idTinhChat" value="<%= idTinhChat %>" />
	<input name="<portlet:namespace />pmlTinhChatURL" type="hidden" value="<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_tinh_chat/view" /></portlet:renderURL>" />
<div class="title_categ"><liferay-ui:message key="tinh-chat-hscv" /></div>
<div class="boxcontent">
<%
	PmlTinhChatSearch searchContainer = new PmlTinhChatSearch(renderRequest, portletURL);

	List headerNames = searchContainer.getHeaderNames();

	headerNames.add(StringPool.BLANK); // Edit 
	headerNames.add(StringPool.BLANK); // Delete

	// Dat row dang checkbox
	searchContainer.setRowChecker(new RowChecker(renderResponse));
%>

<%
PmlTinhChatSearchTerms searchTerms = (PmlTinhChatSearchTerms)searchContainer.getSearchTerms();
%>
<%@ include file="/html/portlet/ext/pml_tinh_chat/pml_tinh_chat_search_results.jspf" %>
<liferay-ui:error exception="<%= PmlTinhChatTenTinhChatException.class %>" message="please-enter-a-valid-ten-tinh-chat" />
<liferay-ui:error exception="<%= PmlTinhChatCanNotDeleteException.class %>" message="can-not-delete-pml-tinh-chat" />
<div class="od-div-outer-box">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="13%">
				<liferay-ui:message key="ten-tinh-chat" />&nbsp;<span style="color:red;">(*)</span>&nbsp;:
				
			</td>
			<td width="55%"><input type="text" name="<portlet:namespace />tenTinhChat" value="<%= tenTinhChat %>" style="width:90%;" /></td>
			<td width="9%" style="vertical-align: middle;">
				<liferay-ui:message key="is-add-new" />&nbsp;:
			</td>
			<td width="3%" style="vertical-align: middle;"><input type="checkbox" name="<portlet:namespace />isAddNew" <%= isAddNew == true ? "checked" : "" %> disabled="disabled" /></td>
			<td >
				<input type="submit" value="<liferay-ui:message key="save" />" />
				<input type="button" value='<liferay-ui:message key="delete" />' onClick="<portlet:namespace />deletePmlTinhChats()" />
			</td>
		</tr>
	</table>
</div>

<br>
<% 
	List resultRows = searchContainer.getResultRows();
	for (int ir = 0; ir < results.size(); ir++) {	
			PmlTinhChat pmlTinhChatList = (PmlTinhChat)results.get(ir);

			pmlTinhChatList = pmlTinhChatList.toEscapedModel();
			ResultRow row = new ResultRow(pmlTinhChatList, pmlTinhChatList.getIdTinhChat(), ir);	

			PortletURL rowURL = renderResponse.createRenderURL();

			rowURL.setWindowState(WindowState.NORMAL);

			rowURL.setParameter("struts_action", "/sgs/pml_tinh_chat/view");
			rowURL.setParameter("redirect", currentURL  );
			rowURL.setParameter(Constants.CMD, Constants.EDIT);
			rowURL.setParameter("idTinhChat", String.valueOf(pmlTinhChatList.getIdTinhChat()));

			// Order no
			row.addText(String.valueOf(ir + 1));
			
			// tenTinhChat			
			row.addText(pmlTinhChatList.getTenTinhChat() + "");

			// Edit image
			StringBuilder sm = new StringBuilder();
		
			sm.append("<img title=\"Edit\"");
			sm.append(" border=\"0\" src=\"/html/images/edit.png\" >");
	
			row.addText("center", "middle", sm.toString(), rowURL);

			// Delete image
			
			sm = new StringBuilder();
		
			sm.append("<img title=\"Delete\"");
			sm.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deletePmlTinhChat('");
			sm.append(String.valueOf(pmlTinhChatList.getIdTinhChat()));
			sm.append("')\" >");

			row.addText("center", "middle", sm.toString());
			resultRows.add(row);
	}
	%>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" /> 
	</div>
</form>