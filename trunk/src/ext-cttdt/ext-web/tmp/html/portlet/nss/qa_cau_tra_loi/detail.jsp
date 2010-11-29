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
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiDisplayTerms"%>
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
	
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	portletURL.setParameter("redirect", redirect);
	String portletURLDisplayString = portletURL.toString();
	
	PortletURL addURL = renderResponse.createActionURL();
	addURL.setWindowState(WindowState.NORMAL);
	addURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	addURL.setParameter("maCauHoi", String.valueOf(cauHoiQA.getMaCauHoiQA()));
	addURL.setParameter(Constants.CMD, "ANSWER");
	addURL.setParameter("tabs", "answer");
	addURL.setParameter("redirect", redirect);
	
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
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + QACauHoiDisplayTerms.MA_CHU_DE_CAU_HOI + "=" + chuDeCauHoi.getMaChuDeCauHoi() %>"><%= chuDeCauHoi.getTenChuDeCauHoi() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
    </div>
    </div>  
    <form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
			<table width="100%" border="0" class="table-border-pml">
				
				<tr>
					<td style="text-transform: capitalize;color: #ff8a00; font-size: 14px;">
						<liferay-ui:message key="Cau-hoi" />&nbsp;:&nbsp;<label><%= cauHoiQA.getTieuDe() %></label>
					</td>
				</tr>
				  
				<tr>
					<td>
					<div class="borqa">
							<p style="color: #222;padding-bottom: 8px;font-weight: bold;"><%= cauHoiQA.getNoiDungHoi() %>?</p>
							<p style="color: #555;"><font style="font-size: 11px;"><liferay-ui:message key="gui-boi" />&nbsp;<%= cauHoiQA.getTenNguoiHoi() %> ( <%= ngayHoi %> )</font></p>
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
			 				<p>
									<span onclick="javascript:submitForm(document.hrefFm,'<%= editQuestionURL.toString() %>');">
										<img style="width: 16px;height: auto;" src='/html/themes/nss_cttdt/images/cttdt/forum/newest_thread.gif'/>
									</span>
									<span onclick="deleteCauHoi('<%= deleteQuestionURL.toString() %>'); ">
										<img style="width: 16px;height: auto;" src='/html/images/xoa.gif'/>
									</span>
							</p>
						</div>
						</td>	
					</tr>
 				<%		
 					}
 				%>
 								
			</table>
			
			<table width="100%" cellspacing="0">
				<tr>
					<td>
						<p style="text-transform: capitalize;color: #ff8a00; font-size: 14px;"><liferay-ui:message key="cau-tra-loi" /></td>
				</tr>
				
				<% if (cauTraLoiQAList.size() > 0) { %>
				<tr>
					<td>
					<div class="borqa">
						<p><liferay-ui:message key="chao-ban-cam-on-ban-da-gui-cau-hoi-cho-chung-toi" /></p>
				
				<%
					for (int i = 0 ; i < cauTraLoiQAList.size(); i++) {
						CauTraLoiQA cauTraLoiQA = cauTraLoiQAList.get(i);
				%>
						<p style="padding-top: 8px;"><%= cauTraLoiQA.getNoiDungTraLoi() %></p>
						<p style="color: #555;padding: 8px 0;">(<%= sdf.format(cauTraLoiQA.getCreatedate()) %>)</p>
						<p style="border-bottom: 1px dotted #a4e4f5;height: 1px;"></p>
	 								
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
							<p> 
				<%
							if (phanQuyen.getQuyenCapNhat()) {
								
				%>
								<span onclick="javascript:submitForm(document.hrefFm,'<%= editAnswerURL.toString() %>');">
									<img style="width: 16px;height: auto;" src='/html/themes/nss_cttdt/images/cttdt/forum/newest_thread.gif'/>
								</span>
								<span onclick="deleteCauHoi('<%= deleteAnswerURL.toString() %>');">
									<img style="width: 16px;height: auto;" src='/html/images/xoa.gif'/>
								</span>
				<%
							} if (phanQuyen.getQuyenDuyet()) {
				%>
								<span onclick="javascript:submitForm(document.hrefFm,'<%= publishURL.toString() %>');">
									<img style="width: 16px;height: auto;" src='/html/themes/nss_cttdt/images/cttdt/forum/publish.gif'/>
								</span>
				<%
							}
				%>
							</p>
							</div>
							</td>
						</tr>
				<%
						}
					}
				}
				%>
 								
			</table>
			<div class="results-grid">	
			<fieldset class="filborder">
			<label class="laborder"><liferay-ui:message key="tap-tin-dinh-kem"/></label>
			<table cellspacing="0" width="100%" class="taglib-search-iterator">
			<tr class="portlet-section-header results-header">
					<td width="50%">
						<label><liferay-ui:message key="ten-tap-tin" /></label>
					</td>
					<td >
						<label><liferay-ui:message key="kich-thuoc" /></label>
					</td>
					<td width="10%" ></td>
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
						<td align="center"><%= download %></td>
					</tr>
				<%
					}
				%>
 								
			</table>
			</fieldset>
			</div>
			<br>
			<div align="right" id="table-button">
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
			</div>
			<br><br>
		</fieldset>
	</form>
</div>
