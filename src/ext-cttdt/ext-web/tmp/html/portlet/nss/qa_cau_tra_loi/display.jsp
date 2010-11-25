<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalServiceUtil"%>

<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiDisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiSearch"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiSearchTerms"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"%>
<%@page import="com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil"%>

<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
	String portletURLDisplayString = portletURL.toString();
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
    <form action="<%= portletURLDisplayString %>"  method="post" name="<portlet:namespace />fm" >
    <input type="hidden" name="cauTraLoiURL" value="<%= portletURLDisplayString %>">
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
    	<%
	    	QACauHoiSearch cauHoiQASearch =  new QACauHoiSearch(renderRequest, portletURL);
	    	QACauHoiSearchTerms searchTerms = (QACauHoiSearchTerms)cauHoiQASearch.getSearchTerms();
    		
		%>
			<liferay-ui:search-form
				page="/html/portlet/nss/qa_cau_tra_loi/search_form.jsp"
				searchContainer="<%= cauHoiQASearch %>" />
			
			<div id="separator"></div>
		<%
			long userId = PortalUtil.getUserId(renderRequest);
			List<CauHoiQA> results = CauHoiQALocalServiceUtil.findTieuDe_ChuDe_PhanQuyen(userId, searchTerms.getMaChuDeCauHoi(), searchTerms.getTieuDeCauHoi(), searchTerms.isAndOperator(), cauHoiQASearch.getStart(),
					cauHoiQASearch.getEnd(), cauHoiQASearch.getOrderByComparator());
			int total = CauHoiQALocalServiceUtil.countByTieuDe_ChuDe_PhanQuyen(userId, searchTerms.getMaChuDeCauHoi(), searchTerms.getTieuDeCauHoi(), searchTerms.isAndOperator());
			cauHoiQASearch.setResults(results);
			cauHoiQASearch.setTotal(total);
			
			portletURL.setParameter(cauHoiQASearch.getCurParam(), String.valueOf(cauHoiQASearch.getCurValue()));
			List resultRows = cauHoiQASearch.getResultRows();
			ResultRow row = null;
			SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
			CauHoiQA cauHoiQA = null;
			String delete = "";
			String answer = "";
			String update = "";
			String publish = "";
			QAPhanQuyen phanQuyen = null;
			for (int i = 0; i < results.size(); i++) {
				cauHoiQA = results.get(i);
				long maCauHoi = cauHoiQA.getMaCauHoiQA();
				cauHoiQA = cauHoiQA.toEscapedModel();
				row = new ResultRow(cauHoiQA, maCauHoi, i);	
				phanQuyen = QAPhanQuyenLocalServiceUtil.findByMaChuDeCauHoi_MaNguoiTraLoi(cauHoiQA.getMaChuDeCauHoi(), userId);
				// stt
				row.addText(String.valueOf(i + 1));
				
				PortletURL detailURL = renderResponse.createActionURL();
				detailURL.setWindowState(WindowState.NORMAL);
				detailURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
				detailURL.setParameter("maCauHoi", String.valueOf(maCauHoi));
				detailURL.setParameter("maChuDeCauHoi", String.valueOf(searchTerms.getMaChuDeCauHoi()));
				detailURL.setParameter(Constants.CMD, Constants.VIEW);
				detailURL.setParameter("tabs", "detail");
				detailURL.setParameter("redirect", cauHoiQASearch.getIteratorURL().toString());
				
				PortletURL answerURL = renderResponse.createActionURL();
				answerURL.setWindowState(WindowState.NORMAL);
				answerURL.setParameter("struts_action", "/nss/qa_cau_tra_loi/view");
				answerURL.setParameter("maCauHoi", String.valueOf(maCauHoi));
				answerURL.setParameter("maChuDeCauHoi", String.valueOf(searchTerms.getMaChuDeCauHoi()));
				answerURL.setParameter(Constants.CMD, "ANSWER");
				answerURL.setParameter("tabs", "answer");
				answerURL.setParameter("redirect", cauHoiQASearch.getIteratorURL().toString());
				
				// tieu de
				row.addText(cauHoiQA.getTieuDe(), detailURL.toString());
				
				// nguoi hoi
				row.addText(cauHoiQA.getTenNguoiHoi());
				
				// ngay hoi
				String ngayHoi = "";
				if (cauHoiQA.getCreatedate() != null) {
					ngayHoi = sdf.format(cauHoiQA.getCreatedate());
				}
				row.addText(ngayHoi);
				
				// trang thai
				List<CauTraLoiQA> cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
				try {
					cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi(maCauHoi);
				} catch (Exception e ) {
					cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
				}
				String soCauTraLoi = "";
				if (cauTraLoiQAList.size() > 0) {
					soCauTraLoi = LanguageUtil.get(pageContext,"co") + "&nbsp;" + String.valueOf(cauTraLoiQAList.size()) + "&nbsp;" + LanguageUtil.get(pageContext,"cau-tra-loi");
					row.addText(soCauTraLoi, detailURL.toString());
				} else {
					soCauTraLoi = LanguageUtil.get(pageContext,"chua-co-cau-tra-loi");     
					row.addText(soCauTraLoi);
				}

				// answer 
				if (null != phanQuyen && phanQuyen.getQuyenXem() == true) {
					answer = "<a  href='"+ answerURL.toString() +"')><u>"+ "<img src='/html/themes/nss_cttdt/images/cttdt/forum/answer.gif'/>" +"</u></a>";
				} else {
					answer = "";
				}
				row.addText(answer);
				
				resultRows.add(row);
			}
		%>
		<liferay-ui:search-iterator searchContainer="<%= cauHoiQASearch %>" /> 
		</fieldset>
	</form>
</div>

</div>
</div>
</div>  
</div>