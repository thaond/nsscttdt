<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"%>

<liferay-util:include page="/html/portlet/nss/qa_cau_tra_loi/js/qacautraloi-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	CauHoiQA cauHoiQA = (CauHoiQA)renderRequest.getAttribute("cauHoiQA");
	/*
	List<CauTraLoiQA> cauTraLoiQAList = (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList") == null ? new ArrayList<CauTraLoiQA>() 
			: (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList");
	
	List<FileDinhKemQA> fileDinhKemQAList = (List<FileDinhKemQA>)renderRequest.getAttribute("fileDinhKemQAList") == null ? new ArrayList<FileDinhKemQA>() 
			: (List<CauTraLoiQA>)renderRequest.getAttribute("fileDinhKemQAList");
	*/
	SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
	String ngayHoi = "";
	if (null != cauHoiQA.getCreatedate()) {
		ngayHoi = sdf.format(cauHoiQA.getCreatedate());
	}
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	portletURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("tabs", "detail");
	
%>

<div id="divparent">
    <form action="<%= portletURL.toString() %>" method="post" enctype="multipart/form-data"  name="<portlet:namespace />fm" onsubmit="return checkFormAddCauTraLoi();">
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
		
		<table width="100%" border="0" class="table-border-pml">
			<tr height="10"></tr>
			<tr>
				<td>
					<label><liferay-ui:message key="cau-hoi" /></label>
				</td>
				<td>
					<label><%= cauHoiQA.getTieuDe() %></label>
				</td>
				<td>&nbsp;</td>
			</tr>
			 <tr height="10"></tr>
			<tr>
				<td><%= cauHoiQA.getNoiDungHoi() %></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr height="10"></tr>
			<tr align="right">
				<td><font size="2%"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr height="10"></tr>				
		</table>
		<table width="100%" border="0" class="table-border-pml">
			<tr height="10"></tr>
			<tr>
				<td><label><liferay-ui:message key="noi-dung" /><font color="red">*</font></label></td>
				<td><textarea name="<portlet:namespace />noiDungTraLoi" class="input-pml" id="noiDungTraLoi" cols="45" rows="5" ></textarea></td>
				<td>&nbsp;</td>
			</tr>
			<tr height="10"></tr>
			<tr height="10"></tr>
			<tr>
				<td>
					<label><liferay-ui:message key="tap-tin-dinh-kem" /></label>
				</td>
				<td>
					<input type="file" name="<portlet:namespace />file" class="input-pml" id="file" onchange="getFileName(this.value)" /></td>
					<input type="hidden" name="<portlet:namespace />fileName" id="fileName"> 
				<td>&nbsp;</td>
			</tr>
		    <tr height="10"></tr>
		</table>
		<br/>
		<table id="table-button">
			<tbody>
				<tr>
					<td>
						<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
						<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
						<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
		    			<span onclick="window.history.back()" ><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
				 	</td>
				</tr>
			</tbody>
		</table>
		</fieldset>
	</form>
</div>