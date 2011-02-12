<%@page import="javax.portlet.WindowState"%>
<%@ include file="/html/portlet/ext/pml_template/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pml_template/js/pmltemplate-js.jsp"></liferay-util:include>
<%@page import="java.io.File"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.pml_template.model.FileTemplate"%>
<%@page import="com.sgs.portlet.pml_template.service.persistence.FileTemplateUtil"%>
<%@page import="com.sgs.portlet.pml_template.search.PmlTemplateSearch"%>
<%@page import="com.sgs.portlet.pml_template.service.PmlTemplateLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_template.model.PmlTemplate"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
	<portlet:actionURL var="filter">
	<portlet:param name="struts_action"	value="/sgs/pml_template/view" />
</portlet:actionURL>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_template/view");
	
	String locTheo = (String) renderRequest.getAttribute("locTheo");
	String valueType = (String) renderRequest.getAttribute("valueType");
	String ngayBanHanhParam = (String) renderRequest.getAttribute("ngayBanHanhParam");
	String departmentIdFilter = renderRequest.getAttribute("departmentIdFilter") != null ? (String)renderRequest.getAttribute("departmentIdFilter") : "";
	
	int total = renderRequest.getAttribute("total")== null? 0 : (Integer)renderRequest.getAttribute("total");
	List<PmlTemplate> pmlTemplateList = renderRequest.getAttribute("pmlTemplateList") == null ? new ArrayList<PmlTemplate>()
				: (List<PmlTemplate>)renderRequest.getAttribute("pmlTemplateList");
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onsubmit="return checkNgayBanHanh()">
<div class="title_categ"><liferay-ui:message key="bieu-mau"/></div>
<div class="boxcontent">
		<%
			PmlTemplateSearch templateSearch = new PmlTemplateSearch(renderRequest, portletURL);
			templateSearch = renderRequest.getAttribute("templateSearchContainer") != null ? (PmlTemplateSearch)renderRequest.getAttribute("templateSearchContainer") : templateSearch;
		%>
		
		<table cellspacing="0" width="100%">
			<tr>
				<td width="10%"><label><liferay-ui:message key="loc-theo" />:&nbsp;</label></td>
				<td width="25%">
					<select style="width: 90%" id="select" name="<portlet:namespace/>locTheo" onchange="checkonchangBR33('<%= filter %>');">						
						<option onclick="javascript:submitForm(document.hrefFm,'<%= filter %>');"  value=""><liferay-ui:message key="all" /></option>											
						<option value="mabieumau" <%= locTheo.equals("mabieumau")? "selected" : "" %>><%= LanguageUtil.get(pageContext,"ma-bieu-mau")%></option>											
						<option value="tenbieumau" <%= locTheo.equals("tenbieumau") ? "selected" : "" %>><%= LanguageUtil.get(pageContext,"ten-bieu-mau")%></option>											
						<option value="ngaybanhanh" <%= locTheo.equals("ngaybanhanh") ? "selected" : "" %>><%= LanguageUtil.get(pageContext,"ngay-ban-hanh")%></option>											
						<option value="phongbanhanh" <%= locTheo.equals("phongbanhanh")? "selected" : "" %>><%= LanguageUtil.get(pageContext,"phong-ban-hanh")%></option>											
					</select>
				</td>
				<td width="5%"></td>
				<td width="10%"><label><liferay-ui:message key="tu-khoa" />:&nbsp;</label></td>
				<td >
					<div id="<portlet:namespace/>comman"  >
						<input style="width: 90%" onkeypress="enableButton();" height="24" name="<portlet:namespace/>valueType" id="<portlet:namespace/>keyword" type="text" value="<%= valueType %>" />
					</div>	
					<div id="<portlet:namespace/>loctheophongban" style="display: none;" >
						<select onchange="enableButton()" style="width: 93%" id="departmentIdFilter" name="<portlet:namespace/>departmentIdFilter">
							<option value="0">[<liferay-ui:message key='chonphongban'/>]</option>
							<logic:iterate id="department" name="departmentList" indexId="i" type="com.sgs.portlet.department.model.Department" scope="request" >
								<option value="<%=department.getDepartmentsId() %>" <%= departmentIdFilter.equals(department.getDepartmentsId()) ? "selected" : "" %>><%=department.getDepartmentsName() %></option>
							</logic:iterate>
						</select>
					</div>
					<div id="<portlet:namespace/>day" style="display: none">
						<input style="width: 80%" type="text"  name="<portlet:namespace/>ngayBanHanhSearch" id="<portlet:namespace/>ngayBanHanh" value="<%= ngayBanHanhParam %>" maxlength="10">
		   				<span><img align="top" id="cal-button-ngayBanHanh" src="/html/images/cal.gif" onclick="callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-ngayBanHanh')"/></span>
		   			</div>	
				</td>
			</tr>
			
		</table>	
		<br/>
		<input type="submit" id="<portlet:namespace/>loc" name="<portlet:namespace/>search" value="<liferay-ui:message key="pccc-DSHS-loc"/>"/>
		
		
		<%
			PortletURL redirect =  templateSearch.getIteratorURL();
			redirect.setWindowState(WindowState.NORMAL);
			
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/sgs/pml_template/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect",redirect.toString());
		%>
		<span onclick="javascript:submitForm(document.hrefFm, '<%= addURL.toString()%>')">
			<input type="button" value="<liferay-ui:message key="add_new" />" >
		</span>
		<br/><br/>
		<%
			templateSearch.setResults(pmlTemplateList);
			templateSearch.setTotal(total);
			portletURL.setParameter(templateSearch.getCurParam(), String.valueOf(templateSearch.getCurValue()));
			
			List resultRows = templateSearch.getResultRows();
			PmlTemplate pmlTemplate = null;
			ResultRow row = null;	
			long templateId  = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String editURL = "";
			String deleteURL = "";
			for (int i = 0; i < pmlTemplateList.size(); i ++) {
				pmlTemplate = pmlTemplateList.get(i);
				templateId = pmlTemplate.getTemplateId();
				pmlTemplate = pmlTemplate.toEscapedModel();
				row = new ResultRow(pmlTemplate, templateId, i);
				
				// stt
				row.addText(String.valueOf(i+1));
				// ma bieu mau
				List<FileTemplate> fileTemplateList = new ArrayList<FileTemplate>();
				FileTemplate fileTemplate = null;
				try {
					fileTemplateList = FileTemplateUtil.findByTemplateId(templateId);
				} catch (SystemException e) {
					fileTemplateList = new ArrayList<FileTemplate>();
				}
				String fileDownLoad = pmlTemplate.getTemplateCode();
				if (fileTemplateList.size() > 0) {
					fileTemplate = fileTemplateList.get(0);
					String patthFile = getServletContext().getRealPath("")+ fileTemplate.getDuongDan();
					File file = new File(patthFile);
					if (file.exists()) {
						fileDownLoad = "<a href='" + fileTemplate.getDuongDan()+ "'>"+ pmlTemplate.getTemplateCode() + "</a>";
					} 
				}
				row.addText(fileDownLoad);
				// ten bieu mau
				row.addText(pmlTemplate.getTemplateName());
				// so van ban
				row.addText(String.valueOf(pmlTemplate.getNumberOfDocument()));
				// ngay ban hanh
				if (pmlTemplate.getPublishDate() != null){
					row.addText(sdf.format(pmlTemplate.getPublishDate()));
				} else {
					row.addText("");
				}
				// phong ban hanh
				String tenPhongBan = "";
				Department department = null;
				try {
					department = DepartmentLocalServiceUtil.getDepartment(pmlTemplate.getDepartmentId());
					tenPhongBan = department.getDepartmentsName();
				} catch (Exception e) {
					tenPhongBan = "";
				}
				row.addText(tenPhongBan);
				
				// edit
				PortletURL rowURLEdit = renderResponse.createActionURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter("struts_action", "/sgs/pml_template/view");
				rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
				rowURLEdit.setParameter("tabs", "edit");
				rowURLEdit.setParameter("templateId", String.valueOf(templateId));
				rowURLEdit.setParameter("redirect",  templateSearch.getIteratorURL().toString());
				editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
				
				row.addText(editURL);
				
				// xoa		
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action", "/sgs/pml_template/view");
				rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
				rowURLDelete.setParameter("templateId", String.valueOf(templateId));
				rowURLDelete.setParameter("redirect",  templateSearch.getIteratorURL().toString());
				
				deleteURL = "<a  href='javascript: ;'  onclick=deleteTemplate('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(deleteURL);
				
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%= templateSearch %>" />
</div>
</form>
<script type="text/javascript">
window.onload = function () {
	checkonchangBR33();
	if (document.getElementById('<portlet:namespace/>ngayBanHanh') != null) {
		callCalendar('<portlet:namespace/>ngayBanHanh','cal-button-ngayBanHanh');
	}
}
</script>