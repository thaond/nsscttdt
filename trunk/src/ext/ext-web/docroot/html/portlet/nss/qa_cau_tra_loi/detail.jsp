<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"%>
<%@page import="com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"%>
<%@page import="com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/qa_cau_tra_loi/js/qacautraloi-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	long maChuDeCauHoi = ParamUtil.getLong(renderRequest,"maChuDeCauHoi");
	
	redirect += "&maChuDeCauHoi=" + maChuDeCauHoi;
	CauHoiQA cauHoiQA = (CauHoiQA)renderRequest.getAttribute("cauHoiQA");
	List<CauTraLoiQA> cauTraLoiQAList = (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList") == null ? new ArrayList<CauTraLoiQA>() 
			: (List<CauTraLoiQA>)renderRequest.getAttribute("cauTraLoiQAList");
	
	List<FileDinhKemQA> fileDinhKemQAList = (List<FileDinhKemQA>)renderRequest.getAttribute("fileDinhKemQAList") == null ? new ArrayList<FileDinhKemQA>() 
			: (List<FileDinhKemQA>)renderRequest.getAttribute("fileDinhKemQAList");
	long userId = PortalUtil.getUserId(renderRequest);
	QAPhanQuyen phanQuyen = null;
	SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
	String ngayHoi = "";
	if (null != cauHoiQA) {
		phanQuyen = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi_MaNguoiTraLoi(cauHoiQA.getMaChuDeCauHoi(), userId);
		ngayHoi = sdf.format(cauHoiQA.getCreatedate());
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	portletURL.setParameter("redirect", redirect);
	
	PortletURL addURL = renderResponse.createActionURL();
	addURL.setWindowState(WindowState.NORMAL);
	addURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	addURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
	addURL.setParameter(Constants.CMD, "ANSWER");
	addURL.setParameter("tabs", "answer");
	addURL.setParameter("redirect", redirect);
	
%>

<div id="divparent">
    <form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
			<table width="100%" border="0" class="table-border-pml">
				<tr height="10"></tr>
				<tr>
					<td>
						<label><%= cauHoiQA.getTieuDe() %></label>
					</td>
					<td>&nbsp;</td>
				</tr>
				  <tr height="10"></tr>
				<tr>
					<td><%= cauHoiQA.getNoiDungHoi() %></td>
					<td>&nbsp;</td>
				</tr>
				 <tr height="10"></tr>
				<tr align="right">
					<td><font size="2%"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></td>
					<td>&nbsp;</td>
				</tr>
 				<tr height="10"></tr>
 				<%
 					if (phanQuyen.getQuyenCapNhat()) {
 						PortletURL editQuestionURL = renderResponse.createRenderURL();
 						editQuestionURL.setWindowState(WindowState.NORMAL);
 						editQuestionURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
 						editQuestionURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
 						editQuestionURL.setParameter("tabs", "edit_question");
 						editQuestionURL.setParameter("redirect", redirect);
 						
 						PortletURL deleteQuestionURL = renderResponse.createActionURL();
 						deleteQuestionURL.setWindowState(WindowState.NORMAL);
 						deleteQuestionURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
 						deleteQuestionURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
 						deleteQuestionURL.setParameter(Constants.CMD, "DELETE_CAUHOI");
 						deleteQuestionURL.setParameter("redirect", redirect);
 						
 				%>
					<tr align="right">
						<td>
							<span onclick="javascript:submitForm(document.hrefFm,'<%= editQuestionURL.toString() %>');">
								<img src='/html/themes/nss_cttdt/images/cttdt/forum/newest_thread.gif'/>
							</span>
							<span onclick="deleteCauHoi('<%= deleteQuestionURL.toString() %>'); ">
								<img src='/html/images/xoa.gif'/>
							</span>
						</td>
						
						<td>&nbsp;</td>
					</tr>
 				<%		
 					}
 				%>
 								
			</table>
			<table width="100%" border="0" class="table-border-pml">
				<tr height="10"></tr>
				<tr>
					<td>
						<label><liferay-ui:message key="cau-tra-loi" /></label>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr height="10"></tr>
				<% if (cauTraLoiQAList.size() > 0) { %>
				<tr>
					<td><liferay-ui:message key="chao-ban-cam-on-ban-da-gui-cau-hoi-cho-chung-toi" /></td>
					<td>&nbsp;</td>
				</tr>
				<tr height="10"></tr>
				<%
					for (int i = 0 ; i < cauTraLoiQAList.size(); i++) {
						CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				%>
	 				<tr height="10"></tr>				
	 				<tr height="10"></tr>
					<tr>
						<td><%= cauTraLoiQA.getNoiDungTraLoi() %></td>
						<td>&nbsp;</td>
					</tr>
					<tr height="10"></tr>
					<tr align="left">
							<td>(<%= sdf.format(cauTraLoiQA.getCreatedate()) %>)</td>
						<td>&nbsp;</td>
					</tr>
	 				<tr height="10"></tr>				
	 				<tr height="10"></tr>
	 								
				<%	
						if (cauTraLoiQA.getMaNguoiTraLoi() == userId) {
							//PUBLISH URL
							PortletURL publishURL = renderResponse.createActionURL();
							publishURL.setWindowState(WindowState.NORMAL);
							publishURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
							publishURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
							publishURL.setParameter("maCauTraLoi", String.valueOf(cauTraLoiQA.getMaCauTraLoiQA()));
							publishURL.setParameter(Constants.CMD, "PUBLISH");
							publishURL.setParameter("tabs", "detail");
							publishURL.setParameter("redirect", redirect);	
							
							//edit URL
							PortletURL editAnswerURL = renderResponse.createActionURL();
							editAnswerURL.setWindowState(WindowState.NORMAL);
							editAnswerURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
							editAnswerURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
							editAnswerURL.setParameter("maCauTraLoi", String.valueOf(cauTraLoiQA.getMaCauTraLoiQA()));
							editAnswerURL.setParameter(Constants.CMD, Constants.EDIT);
							editAnswerURL.setParameter("tabs", "edit_answer");
							editAnswerURL.setParameter("redirect", redirect);	
							
							//delete URL
							PortletURL deleteAnswerURL = renderResponse.createActionURL();
							deleteAnswerURL.setWindowState(WindowState.NORMAL);
							deleteAnswerURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
							deleteAnswerURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
							deleteAnswerURL.setParameter("maCauTraLoi", String.valueOf(cauTraLoiQA.getMaCauTraLoiQA()));
							deleteAnswerURL.setParameter(Constants.CMD, Constants.DELETE);
							deleteAnswerURL.setParameter("tabs", "detail");
							deleteAnswerURL.setParameter("redirect", redirect);	
							
				%>
						<tr height="10">
							<td> 
				<%
							if (phanQuyen.getQuyenCapNhat()) {
								
				%>
								<span onclick="javascript:submitForm(document.hrefFm,'<%= editAnswerURL.toString() %>');">
									<img src='/html/themes/nss_cttdt/images/cttdt/forum/newest_thread.gif'/>
								</span>
								<span onclick="deleteCauHoi('<%= deleteAnswerURL.toString() %>');">
									<img src='/html/images/xoa.gif'/>
								</span>
				<%
							} if (phanQuyen.getQuyenDuyet()) {
				%>
								<span onclick="javascript:submitForm(document.hrefFm,'<%= publishURL.toString() %>');">
									<img src='/html/themes/nss_cttdt/images/cttdt/forum/publish.gif'/>
								</span>
				<%
							}
				%>
							</td>
						</tr>
				<%
						}
					}
				}
				%>
 				<tr height="10"></tr>				
			</table>
			<table width="100%" border="0" class="table-border-pml">
				<tr height="10"></tr>
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
					<tr height="10"></tr>
					<tr>
						<td><%= fileDinhKemQA.getTenFile() %></td>
						<td><%= fileDinhKemQA.getKichThuoc()+ "kb" %></td>
						<td><%= download %></td>
					</tr>
				<%
					}
				%>
 				<tr height="10"></tr>				
			</table>
			<table id="table-button">
				<tbody>
					<tr>
						<td>
						<%
							if (phanQuyen.getQuyenTraLoi()) {
						%>
							<span onclick="javascript:submitForm(document.hrefFm,'<%= addURL.toString() %>');">
								<input type="button" value="<liferay-ui:message key="tra-loi" />" >
							</span>
						<%
							} 
						%>
			    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
					 	</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>