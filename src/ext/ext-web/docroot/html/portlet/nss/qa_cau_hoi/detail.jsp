<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>

<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"%>

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

    <form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onsubmit="return checkFormAddCauHoi();">
		<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
			<table width="100%" border="0" >
				
				<tr>
					<td>
						<label><font color="blue" size="3"><%= cauHoiQA.getTieuDe() %></font></label>
					</td>
					<td>&nbsp;</td>
				</tr>
				  
				<tr>
					<td><%= cauHoiQA.getNoiDungHoi() %></td>
					<td>&nbsp;</td>
				</tr>
				 
				<tr align="right">
					<td><font size="2%"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></td>
					<td>&nbsp;</td>
				</tr>
 								
			</table>
			<table width="100%" border="0" >
				
				<tr>
					<td>
						<label><font color="blue" size="3"><liferay-ui:message key="cau-tra-loi" /></font></label>
					</td>
					<td>&nbsp;</td>
				</tr>
				
				<% if (cauTraLoiQAList.size() > 0) { %>
				<tr>
					<td><liferay-ui:message key="chao-ban-cam-on-ban-da-gui-cau-hoi-cho-chung-toi" /></td>
					<td>&nbsp;</td>
				</tr>
				<%
					for (int i = 0 ; i < cauTraLoiQAList.size(); i++) {
						CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				%>
					
					<tr>
						<td><%= cauTraLoiQA.getNoiDungTraLoi() %></td>
						<td>&nbsp;</td>
					</tr>
					
					<tr align="left">
						<td>(<%= sdf.format(cauTraLoiQA.getCreatedate()) %>)</td>
						<td>&nbsp;</td>
					</tr>
	 								
				<%		
					}
				}
				%>
 								
			</table>
			<table width="100%" border="0">
				
				<tr>
					<td>
						<label><liferay-ui:message key="tap-tin-dinh-kem" /></label>
					</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
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
			<table id="table-button">
				<tbody>
					<tr>
						<td>
							<a href="<%= addURL.toString() %>">
								<input type="button" value="<liferay-ui:message key="gui-cau-hoi" />" >
							</a>
			    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
					 	</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
