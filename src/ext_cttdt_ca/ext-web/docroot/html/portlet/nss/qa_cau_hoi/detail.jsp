<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%
	String redirect = renderRequest.getParameter("redirect");
	long maChuDeCauHoi = ParamUtil.getLong(renderRequest,"maChuDeCauHoi");
	redirect += "&maChuDeCauHoi=" + maChuDeCauHoi;
	CauHoiQA cauHoiQA = (CauHoiQA)renderRequest.getAttribute("cauHoiQA");
	SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
	List<CauTraLoiQA> cauTraLoiQAList = (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList") == null ? new ArrayList<CauTraLoiQA>() 
			: (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList");
	
	List<FileDinhKemQA> fileDinhKemQAList = (List<FileDinhKemQA>)renderRequest.getAttribute("fileDinhKemQAList") == null ? new ArrayList<FileDinhKemQA>() 
			: (List<FileDinhKemQA>)renderRequest.getAttribute("fileDinhKemQAList");
	
	String ngayHoi = "";
	if (cauHoiQA.getCreatedate() != null) {
		ngayHoi = sdf.format(cauHoiQA.getCreatedate());
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
	portletURL.setParameter("redirect", redirect);
	
	PortletURL addURL = renderResponse.createRenderURL();
	addURL.setWindowState(WindowState.NORMAL);
	addURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
	addURL.setParameter("tabs", "add");
	addURL.setParameter("redirect", redirect);
%>
<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	PortletURL portletURL_ = renderResponse.createRenderURL();
	portletURL_.setWindowState(WindowState.NORMAL);
	portletURL_.setParameter("struts_action", "/nss/qa_cau_hoi/view");
	String portletURLDisplayString = portletURL_.toString();
%>
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
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + CauHoiQADisplayTerms.MA_CHU_DE_CAU_HOI + "=" + chuDeCauHoi.getMaChuDeCauHoi() %>"><%= chuDeCauHoi.getTenChuDeCauHoi() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
    </div>
    </div>  
    <form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onsubmit="return checkFormAddCauHoi();">
		<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
			<table width="100%" cellspacing="0">
				<tr>
					<td style="text-transform: capitalize;color: #ff8a00; font-size: 14px;">
						<label><liferay-ui:message key="cau-hoi" />&nbsp;:&nbsp;<%= cauHoiQA.getTieuDe() %></label>
					</td>
				</tr>
				<tr>
					<td>
						<div class="borqa">
							<p style="color: #222;padding-bottom: 8px;font-weight: bold;"><%= cauHoiQA.getNoiDungHoi() %>?</p>
							<p style="color: #555;"><font style="font-size: 11px;"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></p>
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" cellspacing="0">
				<tr>
					<td>
						<p style="text-transform: capitalize;color: #ff8a00; font-size: 14px;"><liferay-ui:message key="cau-tra-loi" /></p>
					</td>
				</tr>
				<tr>
					<td>
					<div class="borqa">
						<% if (cauTraLoiQAList.size() > 0) { %>
							<p ><liferay-ui:message key="chao-ban-cam-on-ban-da-gui-cau-hoi-cho-chung-toi" />!</p>
						<%
							for (int i = 0 ; i < cauTraLoiQAList.size(); i++) {
								CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
						%>
								<p style="padding-top: 8px;"><%= cauTraLoiQA.getNoiDungTraLoi() %></p>
								<p style="color: #555;padding: 8px 0;">(<%= sdf.format(cauTraLoiQA.getCreatedate()) %>)</p>
						<%		
							}
						}
						%>
					</div>
					</td>
 				</tr>			
			</table>
			<div class="results-grid">	
			<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message key="tap-tin-dinh-kem"/></label>
			<table cellspacing="0" width="100%" class="taglib-search-iterator">
			<tr class="portlet-section-header results-header">
					<td>
						<label><liferay-ui:message key="ten-tap-tin" /></label>
					</td>
					<td>
						<label><liferay-ui:message key="kich-thuoc" /></label>
					</td>
					<td>&nbsp;</td>
				</tr>
				<%
					for (int j = 0; j < fileDinhKemQAList.size(); j++ )  {
						FileDinhKemQA fileDinhKemQA = fileDinhKemQAList.get(j);
						
						String download = "";
						String fileDinhKemPath = ""; 
						fileDinhKemPath = fileDinhKemQA.getDuongDan();
						String patthFile = getServletContext().getRealPath("")+ fileDinhKemPath;
						File filedownload = new File(patthFile);
						if (filedownload.exists()) {
							download = "<a href='" + fileDinhKemPath+ "'>" + "<img src='/html/images/icon_download.png' title='" + fileDinhKemQA.getTenFile() + "'></a>";
						} else {
							download = "";
						}
				%>
					
					<tr>
						<td><%= fileDinhKemQA.getTenFile() %></td>
						<td><%= fileDinhKemQA.getKichThuoc()+ "kb" %></td>
						<td><%= download %></td>
					</tr>
				<%
					}
				%>
 								
			</table>
			</fieldset>
			</div>
			<br>
			<div align="right" id="table-button">
							<a href="<%= addURL.toString() %>">
								<input type="button" value="<liferay-ui:message key="gui-cau-hoi" />" >
							</a>
			    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			</div>
			<br><br>
			</div>
	</form>
</div>