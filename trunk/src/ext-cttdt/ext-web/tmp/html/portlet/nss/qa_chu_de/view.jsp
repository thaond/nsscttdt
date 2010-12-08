<%@ include file="/html/portlet/nss/qa_chu_de/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.qa_chu_de.search.QAChuDeSearch"%>
<%@page import="com.nss.portlet.qa_chu_de.search.QAChuDeSearchTerms"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_chu_de.QAChuDeCauHoiCanNotDeleteException"%>
<%@page import="com.nss.portlet.qa_chu_de.QAChuDeCauHoiTenChuDeException"%>

<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/qa_chu_de/view");

	QAChuDeCauHoi chuDeCauHoi = (QAChuDeCauHoi)request.getAttribute("chuDeCauHoi");
	long maChuDeCauHoi = 0; 
	boolean isAddNew = true; // add new item
	String cmd = ParamUtil.getString(request, Constants.CMD);
	String QAChuDeCauHoiAUFlag = "";
	String tenChuDeCauHoi = "";
	
	if (chuDeCauHoi != null) {
		maChuDeCauHoi = chuDeCauHoi.getMaChuDeCauHoi();
		isAddNew = false;
		tenChuDeCauHoi = chuDeCauHoi.getTenChuDeCauHoi();
	}
	else {
		QAChuDeCauHoiAUFlag = request.getAttribute("QAChuDeCauHoiAUFlag") == null ? "" : String.valueOf(request.getAttribute("QAChuDeCauHoiAUFlag"));
		if (QAChuDeCauHoiAUFlag.equals("fail")) {
			maChuDeCauHoi = ParamUtil.getLong(request, "maChuDeCauHoi");
			isAddNew = false;
		}
		tenChuDeCauHoi = ParamUtil.getString(request, "tenChuDeCauHoi");
	}
	
%>

<script type="text/javascript">
	function deleteChuDeCauHoi(url){
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
	
	function <portlet:namespace />saveQAChuDeCauHoi(cmd) {
		if (cmd == null) {
			cmd = "<%= chuDeCauHoi != null || (chuDeCauHoi == null && maChuDeCauHoi > 0 && QAChuDeCauHoiAUFlag.equals("fail")) ? Constants.UPDATE : Constants.ADD %>";
		}

		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		submitForm(document.<portlet:namespace />fm);
	}
</script>	


<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm"  enctype="multipart/form-data" onSubmit="<portlet:namespace />saveQAChuDeCauHoi(); return false;">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input type="hidden" name="<portlet:namespace />maChuDeCauHoi" value="<%= maChuDeCauHoi %>" />
	<input name="<portlet:namespace />chuDeCauHoiURL" type="hidden" value='<%= portletURL.toString() %>' />

	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-chu-de-cau-hoi" /></div>
		<liferay-ui:error exception="<%= QAChuDeCauHoiTenChuDeException.class %>" message="ten-chu-de-cau-hoi-khong-hop-le" />
		<liferay-ui:error exception="<%= QAChuDeCauHoiCanNotDeleteException.class %>" message="khong-the-xoa-chu-de-cau-hoi" />
		
		<%
			QAChuDeSearch chuDeCauHoiSearch = new QAChuDeSearch(renderRequest, portletURL);
			QAChuDeSearchTerms searchTerms = (QAChuDeSearchTerms)chuDeCauHoiSearch.getSearchTerms();
			
			List<QAChuDeCauHoi> results = QAChuDeCauHoiLocalServiceUtil.findChuDeCauHoi(searchTerms.getTenChuDeCauHoi(), searchTerms.isAndOperator(), 
						chuDeCauHoiSearch.getStart(), chuDeCauHoiSearch.getEnd(), chuDeCauHoiSearch.getOrderByComparator());
			int total = QAChuDeCauHoiLocalServiceUtil.countChuDeCauHoi(searchTerms.getTenChuDeCauHoi(), searchTerms.isAndOperator());
			chuDeCauHoiSearch.setResults(results);
			chuDeCauHoiSearch.setTotal(total);
			
			portletURL.setParameter(chuDeCauHoiSearch.getCurParam(), String.valueOf(chuDeCauHoiSearch.getCurValue()));
		%>
		<div class="od-div-outer-box">
			<table class="common-table" width="100%">
				<tr>
					<td width="20%">
					<liferay-ui:message key="ten-chu-de-cau-hoi" />&nbsp;<span style="color:red;">(*)</span>:
					</td>
					<td width="50%">
						<input type="text" name="<portlet:namespace />tenChuDeCauHoi" value="<%= tenChuDeCauHoi %>" style="width:95%;" />
					</td>
					<td width="10%">
					<liferay-ui:message key="is-add-new" />:
					</td>
					<td >
						<input type="checkbox" name="<portlet:namespace />isAddNew" <%= isAddNew == true ? "checked" : "" %> disabled="disabled" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3">
					<input type="submit" value='<liferay-ui:message key="save" />' />
					<br><br>
					</td>
				</tr>
			</table>
		</div>
		<%	
			List resultRows = chuDeCauHoiSearch.getResultRows();
			ResultRow row = null;
			QAChuDeCauHoi qaChuDeCauHoi = null;
			String update = "";
			String deleteAction = "";
			String active = "";
			for (int i = 0; i < results.size(); i++) {
				qaChuDeCauHoi = results.get(i);
				long qaMaChuDeCauHoi = qaChuDeCauHoi.getMaChuDeCauHoi();
				qaChuDeCauHoi = qaChuDeCauHoi.toEscapedModel();
				row = new ResultRow(qaChuDeCauHoi, qaMaChuDeCauHoi, i);	
				
				// stt
				row.addText(String.valueOf(i + 1));
				
				// ten chu de		
				row.addText(qaChuDeCauHoi.getTenChuDeCauHoi());

				// Active image
				PortletURL rowURLActive = renderResponse.createActionURL();
				rowURLActive.setWindowState(WindowState.NORMAL);
				rowURLActive.setParameter("struts_action", "/nss/qa_chu_de/view");
				rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
				rowURLActive.setParameter("redirect", chuDeCauHoiSearch.getIteratorURL().toString());
				rowURLActive.setParameter("maChuDeCauHoi", String.valueOf(qaMaChuDeCauHoi));
			
				if (1 == qaChuDeCauHoi.getActive()) {
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
				} else if (0 == qaChuDeCauHoi.getActive()){
					active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
				}
				row.addText(active);
				
				// edit
				//URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
				rowURLEdit.setParameter("struts_action","/nss/qa_chu_de/view");
				rowURLEdit.setParameter("redirect", chuDeCauHoiSearch.getIteratorURL().toString());
				rowURLEdit.setParameter("maChuDeCauHoi", String.valueOf(qaMaChuDeCauHoi));
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				
				row.addText(update);

				// delete
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("struts_action","/nss/qa_chu_de/view");
				rowURLDelete.setParameter("redirect", chuDeCauHoiSearch.getIteratorURL().toString());
				rowURLDelete.setParameter("maChuDeCauHoi", String.valueOf(qaMaChuDeCauHoi));
				
				deleteAction = "<a  href='javascript: ;'  onclick=deleteChuDeCauHoi('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(deleteAction);
							
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%= chuDeCauHoiSearch %>" /> 
	</div>
</form>
