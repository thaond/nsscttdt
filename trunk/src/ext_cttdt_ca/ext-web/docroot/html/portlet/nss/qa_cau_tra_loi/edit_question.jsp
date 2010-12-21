<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<%@page import="com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiDisplayTerms"%>
<liferay-util:include page="/html/portlet/nss/qa_cau_tra_loi/js/qacautraloi-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	long maCauHoi = ParamUtil.getLong(renderRequest, "maCauHoi");
	
	CauHoiQA cauHoiQA = null;
	FileDinhKemQA fileDinhKemQA = null;
	try {
		cauHoiQA = CauHoiQALocalServiceUtil.getCauHoiQA(maCauHoi);
	} catch (Exception e) {}
	if (null != cauHoiQA) {
		try {
			fileDinhKemQA = FileDinhKemQALocalServiceUtil.findByMaCauHoi(maCauHoi);
		} catch (Exception e) {}
	}
	SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
	String ngayHoi = "";
	if (null != cauHoiQA) {
		ngayHoi = sdf.format(cauHoiQA.getCreatedate());
	}
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	portletURL.setParameter("tabs", "detail");
	portletURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter(Constants.CMD, "UPDATE_CAUHOI");
	
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
			
	PortletURL portletURL_ = renderResponse.createRenderURL();
	portletURL_.setWindowState(WindowState.NORMAL);
	portletURL_.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	portletURL_.setParameter("redirect", redirect);
	String portletURLDisplayString = portletURL_.toString();
%>
<div id="boxcontainer-vbpq">
	<div id="bttomcontainer-vbpq">
		<div id="container-vbpq">
  
	<div id="main">
    <div id="leftmenu">
    <div id="topmnl">
    <div id="vbpq">
	    <ul>
	    	<h2><liferay-ui:message key="chuyen-muc" /></h2>
	    	<%
	    		for (int i = 0; i < qAChuDeCauHoilList.size(); i ++) {
	    			QAChuDeCauHoi chuDeCauHoi = (QAChuDeCauHoi) qAChuDeCauHoilList.get(i);
	    	%>
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + QACauHoiDisplayTerms.MA_CHU_DE_CAU_HOI + "=" + chuDeCauHoi.getMaChuDeCauHoi() %>"><%= chuDeCauHoi.getTenChuDeCauHoi() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
    </div>
    </div>  
<div id="divparent">
    <form action="<%= portletURL.toString() %>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm" onsubmit="return checkFormAddCauHoi();">
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
			<table width="100%" border="0" class="table-border-pml">
				<tr height="10"></tr>
				<tr>
					<td><label><liferay-ui:message key="tieu-de-cau-hoi" /><font color="red">*</font></label></td>
					<td><input type="text" name="<portlet:namespace />tieuDe" id="tieuDeCauHoi" value="<%= cauHoiQA.getTieuDe() %>"></td>
					<td>&nbsp;</td>
				</tr>
				<tr height="10"></tr>
				<tr>
					<td><label><liferay-ui:message key="noi-dung" /><font color="red">*</font></label></td>
					<td><textarea name="<portlet:namespace />noiDungHoi" class="input-pml" id="noiDungHoi" cols="45" rows="5" ><%= cauHoiQA.getNoiDungHoi()  %></textarea></td>
					<td>&nbsp;</td>
				</tr>
				<tr height="10"></tr>
				<tr align="right">
					<td><font size="2%"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></td>
					<td>&nbsp;</td>
				</tr>
 				<tr height="10"></tr>
			</table>
			<br/>
			<table id="table-button">
				<tbody>
					<tr>
						<td>
							<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
							<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
			    			<span onclick="window.history.back()" ><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' /></span>
					 	</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>