<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQASearchTerms"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQASearch"%>
<%@page import="com.nss.portlet.qa_cau_hoi.model.CauHoiQA"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/qa_cau_hoi/js/qacauhoi-js.jsp"></liferay-util:include>

<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
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
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + CauHoiQADisplayTerms.MA_CHU_DE_CAU_HOI + "=" + chuDeCauHoi.getMaChuDeCauHoi() %>"><%= chuDeCauHoi.getTenChuDeCauHoi() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
    </div>
    </div>  
    
    <form action="<%= portletURLDisplayString %>"  method="post" name="<portlet:namespace />fm" >
		<fieldset>
		<div class="parent-title"><liferay-ui:message key="hoi-dap-truc-tuyen" /></div>
    	<%
	    	CauHoiQASearch cauHoiQASearch =  new CauHoiQASearch(renderRequest, portletURL);
	    	CauHoiQASearchTerms searchTerms = (CauHoiQASearchTerms)cauHoiQASearch.getSearchTerms();
    		
		%>
			<liferay-ui:search-form
				page="/html/portlet/nss/qa_cau_hoi/search_form.jsp"
				searchContainer="<%= cauHoiQASearch %>" />
			
			<div id="separator"></div>
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", cauHoiQASearch.getIteratorURL().toString());
		%>
		<a href="<%= addURL.toString() %>">
			<input type="button" value="<liferay-ui:message key="gui-cau-hoi" />" >
		</a>
		<br/><br/>
		<%
			
			List<CauHoiQA> results = CauHoiQALocalServiceUtil.findTieuDe_ChuDe(searchTerms.getMaChuDeCauHoi(), searchTerms.getTieuDeCauHoi(), searchTerms.isAndOperator(), cauHoiQASearch.getStart(),
					cauHoiQASearch.getEnd(), cauHoiQASearch.getOrderByComparator());
			int total = CauHoiQALocalServiceUtil.countByTieuDe_ChuDe(searchTerms.getMaChuDeCauHoi(), searchTerms.getTieuDeCauHoi(), searchTerms.isAndOperator());
			cauHoiQASearch.setResults(results);
			cauHoiQASearch.setTotal(total);
			
			portletURL.setParameter(cauHoiQASearch.getCurParam(), String.valueOf(cauHoiQASearch.getCurValue()));
			
			List resultRows = cauHoiQASearch.getResultRows();
			ResultRow row = null;
			SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
			CauHoiQA cauHoiQA = null;
			for (int i = 0; i < results.size(); i++) {
				cauHoiQA = results.get(i);
				long maCauHoi = cauHoiQA.getMaCauHoiQA();
				cauHoiQA = cauHoiQA.toEscapedModel();
				row = new ResultRow(cauHoiQA, maCauHoi, i);	
				
				// stt
				row.addText(String.valueOf(i + 1));
				
				PortletURL detailURL = renderResponse.createActionURL();
				detailURL.setWindowState(WindowState.NORMAL);
				detailURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
				detailURL.setParameter("maCauHoi", String.valueOf(maCauHoi));
				detailURL.setParameter(Constants.CMD, Constants.VIEW);
				detailURL.setParameter("tabs", "detail");
				detailURL.setParameter("maChuDeCauHoi", String.valueOf(searchTerms.getMaChuDeCauHoi()));
				detailURL.setParameter("redirect", cauHoiQASearch.getIteratorURL().toString());
				
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
					cauTraLoiQAList = CauTraLoiQALocalServiceUtil.findByMaCauHoi_Publish(maCauHoi);
				} catch (Exception e ) {
					cauTraLoiQAList = new ArrayList<CauTraLoiQA>();
				}
				String soCauTraLoi = "";
				if (cauTraLoiQAList.size() > 0) {
					soCauTraLoi = LanguageUtil.get(pageContext,"co") + "&nbsp;" + String.valueOf(cauTraLoiQAList.size())  + "&nbsp;" + LanguageUtil.get(pageContext,"cau-tra-loi");
					row.addText(soCauTraLoi, detailURL.toString());
				} else {
					soCauTraLoi = LanguageUtil.get(pageContext,"chua-co-cau-tra-loi");     
					row.addText(soCauTraLoi);
				}
				
				
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
