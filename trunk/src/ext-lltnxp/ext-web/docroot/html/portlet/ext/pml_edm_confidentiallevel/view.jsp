<%@ include file="/html/portlet/ext/pml_edm_confidentiallevel/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pml_edm_confidentiallevel/js/confidentiallevel.jsp">
</liferay-util:include>

<%@page import="com.sgs.portlet.document.receipt.ConfidentialLevelNameNotSameException"%>
<%@page import="com.sgs.portlet.document.receipt.ConfidentialLevelSymbolNotSameException"%>
<%@page import="com.sgs.portlet.document.receipt.ConfidentialLevelReferenceException"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.pml_edm_confidentiallevel.search.PmlEDMConfidentialLevelSearch"%>
<%@page import="com.sgs.portlet.pml_edm_confidentiallevel.search.PmlEDMConfidentialLevelSearchTerms"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>
<script type="text/javascript">
	function addPmlEDMConfidentialLevel(url) {	
		submitForm(document.<portlet:namespace />fm, url);
	}

	function <portlet:namespace />addConfLevel() {
		// Ham de them moi do mat
		// Kiem tra du lieu nhap
		if (<portlet:namespace />validateInput() == false) return;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.ACTION %>.value = "<%= Constants.ADD %>";
		document.<portlet:namespace />fm.submit();
	}

	function <portlet:namespace />updateConfLevel() {
		// Cap nhat thong tin do mat
		// Kiem tra ma so do mat
		if (trim(document.<portlet:namespace />fm.<portlet:namespace />confidentialLevelId.value) == "") {
			alert("<liferay-ui:message key='cannot-determine-object-processing-please-recheck' />");
			return;
		}
		
		// Kiem tra du lieu nhap
		if (<portlet:namespace />validateInput() == false) return;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.ACTION %>.value = "<%= Constants.UPDATE %>";
		document.<portlet:namespace />fm.submit();
	}
	
	function deleteConfLevel(delId) {
		// Xoa do mat
		// Kiem tra ma so ton tai
		if (trim(delId) == "") { // Khong xac dinh duoc ma so cua muc can xoa
			alert("<liferay-ui:message key='cannot-determine-object-processing-please-recheck' />");
			return;
		}
		// Xac nhan truoc khi xoa va xoa khi dong y
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-item") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace />confidentialLevelId.value = delId;
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.ACTION %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.submit();
		}
		return;
	}
	
	function <portlet:namespace />validateInput() {
		// Ham kiem tra gia tri nhap vao truoc khi luu moi hoac luu hieu chinh
		var objItem = document.<portlet:namespace />fm.<portlet:namespace />confidentialLevelName;
		if (trim(objItem.value) == "") { // Khong nhap lieu hoac nhap khoang trang
			alert("<liferay-ui:message key='please-input-confidential-name' />");
			if (objItem.disabled == false) {
				objItem.focus();
			}
			objItem.select();
			return false;
		}

		// kiem tra muc do cua do mat
		var objItemSymbol = document.<portlet:namespace />fm.<portlet:namespace />confidentialLevelSymbol;
		if (trim(objItemSymbol.value) == "") { // Khong nhap lieu hoac nhap khoang trang
			alert("<liferay-ui:message key='vui-long-nhap-muc-do-do-mat' />");
			objItemSymbol.focus();
			return false;
		} 
		if (isNaN(objItemSymbol.value) == true || objItemSymbol.value == 0) {
			alert("<liferay-ui:message key='vui-long-nhap-so-va-lon-hon-0' />");
			objItemSymbol.focus();
			return false;
		}
		
		return true;
	}
</script>

<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_edm_confidentiallevel/view");
	
	String cmd = ParamUtil.getString(request, Constants.ACTION, "");
	String confidentialLevelId = ParamUtil.getString(request, "confidentialLevelId", "");
	
	// Lay du lieu neu hieu chinh mau tin
	String confidentialLevelName = "";
	int confidentialLevelSymbol = 0;
	String limitViewDetailChecked = "";
	String haveProcessChecked = "";
	if (cmd.equals(Constants.EDIT) && confidentialLevelId.length() > 0) {
		try {
			PmlEdmConfidentialLevel editCLItem = PmlEdmConfidentialLevelUtil.findByPrimaryKey(confidentialLevelId);
			confidentialLevelName = editCLItem.getConfidentialLevelName();
			confidentialLevelSymbol = editCLItem.getConfidentialLevelSymbol();
			if (editCLItem.getLimitViewDetail() == true) {
				limitViewDetailChecked = "checked";
			}
			if (editCLItem.getHaveProcess() == true) {
				haveProcessChecked = "checked";
			}
		}
		catch (Exception ex) {
			// Do nothing
		}
	}
	
	// giu gia tri khi them moi hoac hieu chinh ko thanh cong
	String flag = request.getAttribute("flag") == null ? "" : String.valueOf(request.getAttribute("flag"));
	if (flag.equals("fail")) { // Them that bai
		confidentialLevelName = ParamUtil.getString(request, "confidentialLevelName");
		confidentialLevelSymbol = ParamUtil.getInteger(request, "confidentialLevelSymbol");
		limitViewDetailChecked = ParamUtil.getString(request, "limitViewDetail");
		haveProcessChecked = ParamUtil.getString(request, "haveProcess");
	}
%>
<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input name="<portlet:namespace /><%= Constants.ACTION %>" type="hidden" />
	<input name="<portlet:namespace />confidentialLevelId" type="hidden" value="<%= (cmd.equals(Constants.EDIT) && confidentialLevelId.length() > 0) ? confidentialLevelId : "" %>" />
	<div class="title_categ"><liferay-ui:message key="confidentiallevel"/></div>
	<div class="boxcontent">
	
	<liferay-ui:error exception="<%= ConfidentialLevelReferenceException.class %>" message="khong-the-xoa-dong-nay-vi-co-ren-buoc" />
	<liferay-ui:error exception="<%= ConfidentialLevelNameNotSameException.class %>" message="ten-do-mat-khong-duoc-trung" />
	<liferay-ui:error exception="<%= ConfidentialLevelSymbolNotSameException.class %>" message="muc-do-do-mat-khong-duoc-trung" />
	
	<%
		PmlEDMConfidentialLevelSearch pEDMConfidentialLevelSearch   = new PmlEDMConfidentialLevelSearch(renderRequest, portletURL);
		PmlEDMConfidentialLevelSearchTerms searchTerms = (PmlEDMConfidentialLevelSearchTerms) pEDMConfidentialLevelSearch.getSearchTerms();

	%>
	<table width="100%" height="100%" border="0" cellspacing="5px" cellpadding="0" align="left">
		<tr>
			<td width="25%">
				<label><liferay-ui:message key="pml_edm_confidential_level_name"/>&nbsp;<font color="red">(*)</font>:</label>
			</td>
			<td>
				<%--
	<input name="<%= renderResponse.getNamespace() %><%= PmlEDMConfidentialLevelSearchTerms.PMLEDMCONFIDENTIALLEVEL_NAME %>" size="90" type="text" value="<%= HtmlUtil.escape(searchTerms.getPmlEDMConfidentialLevelName()) %>" />
				--%>
				<input name="<portlet:namespace />confidentialLevelName" size="90" type="text" value="<%= confidentialLevelName %>" id="confidentialLevelName"/>
			</td>
		</tr>
		<!-- muc do do mat / symbol -->
		<tr>
			<td>
				<label><liferay-ui:message key="muc-do-do-mat"/>&nbsp;<font color="red">(*)</font>:</label>
			</td>
			<td >
				<input name="<portlet:namespace />confidentialLevelSymbol" size="90" type="text" value="<%= confidentialLevelSymbol == 0 ? "" : confidentialLevelSymbol %>" maxlength="2" id="confidentialLevelSymbol"/>
			</td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="limit-view-detail"/>:</label>
			</td>
			<td style="vertical-align: middle;">
				<input type="checkbox" id="limitViewDetail" name="<portlet:namespace />limitViewDetail" <%= limitViewDetailChecked %> />&nbsp;(<liferay-ui:message key="if-not-select-all-user-can-view-detail-document" />)
			</td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="need-participate-process-to-view-detail"/>:</label>
			</td>
			<td style="vertical-align: middle;">
				<input type="checkbox" id="haveProcess" name="<portlet:namespace />haveProcess" <%= haveProcessChecked %> />&nbsp;(<liferay-ui:message key="if-not-select-all-user-in-department-can-view-detail-document" />)
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input style="margin-left: 0" type="button" value='<liferay-ui:message key="add_new" />' onclick="<portlet:namespace />addConfLevel()" />
				<input  type="button" value='<liferay-ui:message key="save-edit" />' onclick="<portlet:namespace />updateConfLevel()" />
			</td>
		</tr>
	</table>

	<%-- xuancong close
	<input type="submit" class="button-width"  name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
	<portlet:actionURL var="add">
		<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
		<portlet:param name="struts_action" value="/sgs/pml_edm_confidentiallevel/view" />
		<portlet:param name="redirect" value="<%= pEDMConfidentialLevelSearch.getIteratorURL().toString() %>" />
	</portlet:actionURL>
	
	<input class="button-width" onclick="addPmlEDMConfidentialLevel('<%= add %>')" id="addButton" type="button" value='<liferay-ui:message key="add"/>' />	
	--%>
	
	<%
	
		int total = PmlEdmConfidentialLevelLocalServiceUtil.searchCount(searchTerms.getPmlEDMConfidentialLevelName());
		List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelLocalServiceUtil.
			search(searchTerms.getPmlEDMConfidentialLevelName(), pEDMConfidentialLevelSearch.getStart(), 
					pEDMConfidentialLevelSearch.getEnd(), pEDMConfidentialLevelSearch.getOrderByComparator() );
	
	
		List<PmlEdmConfidentialLevel> results = confidentialLevels;
		
		pEDMConfidentialLevelSearch.setTotal(total);
		
		pEDMConfidentialLevelSearch.setResults(results);
		
		portletURL.setParameter(pEDMConfidentialLevelSearch.getCurParam(), String.valueOf(pEDMConfidentialLevelSearch.getCurValue()));
	
		List resultRows = pEDMConfidentialLevelSearch.getResultRows();
	
		PmlEdmConfidentialLevel pmlEdmConfidentialLevel  = null;
		
		ResultRow row = null;	
		
		String PmlEdmConfidentialLevelId  = "";
		
		
		for (int i = 0; i < results.size(); i ++) {
			pmlEdmConfidentialLevel = results.get(i);
			PmlEdmConfidentialLevelId = pmlEdmConfidentialLevel.getConfidentialLevelId();
			
			row = new ResultRow(pmlEdmConfidentialLevel, PmlEdmConfidentialLevelId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			// ma do mat 
			row.addText(PmlEdmConfidentialLevelId);
			
			// ten do mat
			StringBuilder pmlEdmConfidentialLevelName = new StringBuilder();
			
			//pmlEdmConfidentialLevelName.append("<div id=\"");
			//pmlEdmConfidentialLevelName.append("name".concat(PmlEdmConfidentialLevelId));
			//pmlEdmConfidentialLevelName.append("\">");
			//pmlEdmConfidentialLevelName.append(pmlEdmConfidentialLevel.getConfidentialLevelName());
			//pmlEdmConfidentialLevelName.append("</div>");		
			//pmlEdmConfidentialLevelName.append("<div id=\"");
			//pmlEdmConfidentialLevelName.append("editName".concat(PmlEdmConfidentialLevelId));
			//pmlEdmConfidentialLevelName.append("\" style=\"display: none;\" >");
			//pmlEdmConfidentialLevelName.append("<input name=\"");
			//pmlEdmConfidentialLevelName.append("confidentialLevelName_".concat(PmlEdmConfidentialLevelId));
			//pmlEdmConfidentialLevelName.append("\" style=\"width: 99%\"");
			//pmlEdmConfidentialLevelName.append(" id=\"");
			//pmlEdmConfidentialLevelName.append("hidden".concat(PmlEdmConfidentialLevelId));
			//pmlEdmConfidentialLevelName.append("\" type=\"text\"");
			//pmlEdmConfidentialLevelName.append(" value=\"");
			pmlEdmConfidentialLevelName.append(pmlEdmConfidentialLevel.getConfidentialLevelName());
			//pmlEdmConfidentialLevelName.append("\" /> </div>");
						
			row.addText(pmlEdmConfidentialLevelName.toString());
			
			// muc do do mat
			row.addText(String.valueOf(pmlEdmConfidentialLevel.getConfidentialLevelSymbol()));
			
			// Gioi han xem chi tiet
			if (pmlEdmConfidentialLevel.getLimitViewDetail() == true) {
				row.addText("center", "middle", "<img class=\"image-edit\" src=\"/html/images/checked.gif\"");
			}
			else {
				row.addText("");
			}
				
			// Can tham gia xu ly de xem
			if (pmlEdmConfidentialLevel.getHaveProcess() == true) {
				row.addText("center", "middle", "<img class=\"image-edit\" src=\"/html/images/checked.gif\"");
			}
			else {
				row.addText("");
			}
			
			// sua  hoac xoa
			//PortletURL deleteURL = renderResponse.createActionURL();
			//deleteURL.setParameter(Constants.ACTION, Constants.DELETE);
			//deleteURL.setParameter("confidentialLevelId", PmlEdmConfidentialLevelId);
			//deleteURL.setParameter("struts_action", "/sgs/pml_edm_confidentiallevel/view");
			//deleteURL.setParameter("redirect",  pEDMConfidentialLevelSearch.getIteratorURL().toString());
			
			//PortletURL updateURL = renderResponse.createActionURL();
			PortletURL updateURL = renderResponse.createRenderURL();
			//updateURL.setParameter(Constants.ACTION, Constants.UPDATE);
			updateURL.setParameter(Constants.ACTION, Constants.EDIT);
			updateURL.setParameter("confidentialLevelId", PmlEdmConfidentialLevelId);
			updateURL.setParameter("struts_action", "/sgs/pml_edm_confidentiallevel/view");
			updateURL.setParameter("redirect",  pEDMConfidentialLevelSearch.getIteratorURL().toString());
			
			//StringBuilder editOrDelete = new StringBuilder();
			
			//editOrDelete.append("<div id=\"");
			//editOrDelete.append("current".concat(PmlEdmConfidentialLevelId));
			//editOrDelete.append("\">");
			//editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.gif\"");
			//editOrDelete.append(" value='");
			//editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			//editOrDelete.append("' onclick=\"editConfidentialLevel('");
			//editOrDelete.append(PmlEdmConfidentialLevelId);
			//editOrDelete.append("'); \"/>");
			
			//editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/xoa.gif\"");
			//editOrDelete.append(" value='");
			//editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			//editOrDelete.append("' onclick=\"deletteConfidentialLevel('");
			//editOrDelete.append(PmlEdmConfidentialLevelId);
			//editOrDelete.append("', '");
			//editOrDelete.append(deleteURL.toString());			
			//editOrDelete.append("');\"/>");			
			//editOrDelete.append("</div>");
			
			
			//editOrDelete.append("<div id=\"");
			//editOrDelete.append("edit".concat(PmlEdmConfidentialLevelId));
			//editOrDelete.append("\" style=\"display: none;\" >");
			//editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			//editOrDelete.append(" value='");
			//editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			//editOrDelete.append("' onclick=\"updateConfidentialLevel('");
			//editOrDelete.append(PmlEdmConfidentialLevelId);
			//editOrDelete.append("', '");
			//editOrDelete.append(updateURL.toString());	
			//editOrDelete.append("');\"/>");
			
			//editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			//editOrDelete.append(" value='");
			//editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			//editOrDelete.append("' onclick=\"cancel('");
			//editOrDelete.append(PmlEdmConfidentialLevelId);
			//editOrDelete.append("');\"/>");			
			//editOrDelete.append("</div>");
			  
			//row.addText(editOrDelete.toString());	
			
			// Sua
			row.addText("center", "middle", "<img class=\"image-edit\" src=\"/html/images/edit.png\">", updateURL);
			
			// Xoa
			StringBuilder delStr = new StringBuilder();
			
			delStr.append("<img title=\"Delete\"");
			delStr.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deleteConfLevel('");
			delStr.append(pmlEdmConfidentialLevel.getConfidentialLevelId());
			delStr.append("')\" >");
			
			row.addText("center", "middle", delStr.toString());
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pEDMConfidentialLevelSearch %>" />
		
</div>
	</form>

<%-- xuancong close
<% 
boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
if (!delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>
--%>