<%@ include file="/html/portlet/nss/van_ban_phap_quy/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.io.File"%>

<%@page import="com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuySearch"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuySearchTerms"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalServiceUtil"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuyDisplayTerms"%>

<liferay-util:include page="/html/portlet/nss/van_ban_phap_quy/js/vanbanphapquy-js.jsp"></liferay-util:include>

	<%
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("struts_action", "/nss/van_ban_phap_quy/view");
	%>    
    <form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%
			VanBanPhapQuySearch vanBanPhapQuySearch = new VanBanPhapQuySearch(renderRequest, portletURL);
    		VanBanPhapQuyDisplayTerms displayTerms = (VanBanPhapQuyDisplayTerms)vanBanPhapQuySearch.getDisplayTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN);
    		
    		int sortType = Sort.STRING_TYPE;

    		String orderByType = vanBanPhapQuySearch.getOrderByType().toLowerCase();
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-van-ban-phap-quy" /></div>
		<div class="titlecateg">
	    <ul>
	    	<li class="leftact"><a class="rightact" href="#" onclick="<portlet:namespace/>reIndexVanBanPhapQuy('<liferay-ui:message key="loading"/>');"><liferay-ui:message key="reindex-van-ban-phap-quy" /></a></li>
	    </ul>
	    </div>
		<liferay-ui:search-form
			page="/html/portlet/nss/van_ban_phap_quy/search_form.jsp"
			searchContainer="<%= vanBanPhapQuySearch %>" />
			
		<div id="separator"></div>
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/nss/van_ban_phap_quy/view");
				addURL.setParameter("tabs", "add");
				addURL.setParameter("redirect", vanBanPhapQuySearch.getIteratorURL().toString());
			
			%>
			<br/>
			<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
			<br/>
			<br/>
				
			<%
				DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
				String tuNgay = "";
				String denNgay = "";
				Date fromDate = new Date();
				if (!"".equals(displayTerms.getTuNgay())) {
					fromDate = df1.parse(displayTerms.getTuNgay());
					tuNgay = df2.format(fromDate);
					
				}
				
				Date toDate = new Date();
				if (!"".equals(displayTerms.getDenNgay())) {
					toDate = df1.parse(displayTerms.getDenNgay());
					denNgay = df2.format(toDate);
				}
				
				try {
					Hits hits = null;
					if (!displayTerms.isAdvancedSearch()) {
						hits = VanBanPhapQuyLocalServiceUtil.search(user.getCompanyId(), displayTerms.getKeywords(),
									orderByCol, sortType, reverse, vanBanPhapQuySearch.getStart(), vanBanPhapQuySearch.getEnd());
					} else {
						hits = VanBanPhapQuyLocalServiceUtil.search(user.getCompanyId(), 
										displayTerms.getKyHieuVanBan().trim().length() == 0 ? "" : (displayTerms.getKyHieuVanBan() + "*"),
										displayTerms.getTomTat().trim().length() == 0 ? "" : (displayTerms.getTomTat() + "*"),
										displayTerms.getNguoiKy().trim().length() == 0 ? "" : (displayTerms.getNguoiKy() + "*"),
										displayTerms.getMaLoaiVanBan(), 
										displayTerms.getMaLinhVucVanBan(), 
										displayTerms.getMaCoQuanBanHanh(),
										fromDate, toDate, orderByCol, sortType, reverse, vanBanPhapQuySearch.getStart(), vanBanPhapQuySearch.getEnd());
					}
					
					int total = 0;
					total = hits.getLength();
					vanBanPhapQuySearch.setTotal(total);
					portletURL.setParameter(vanBanPhapQuySearch.getCurParam(), String.valueOf(vanBanPhapQuySearch.getCurValue()));
				
					List resultRows = vanBanPhapQuySearch.getResultRows();
				
					ResultRow row = null;	
					VanBanPhapQuy vanBanPhapQuy = null;
					
					int maVanBanPhapQuy = 0;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String ngayBanhanh = "";
					List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
					FileDinhKem fileDinhKem = null;
					String update = "";
					String deleteAction = "";
					String active = "";
					
					for (int i = 0; i < hits.getDocs().length; i ++) {
						maVanBanPhapQuy = GetterUtil.getInteger(hits.doc(i).get(Field.ENTRY_CLASS_PK));
						vanBanPhapQuy  = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
						vanBanPhapQuy = vanBanPhapQuy.toEscapedModel();
							
						row = new ResultRow(vanBanPhapQuy, vanBanPhapQuy.getMaVanBanPhapQuy(), i);
						
						// STT
						row.addText(String.valueOf(i + 1));
						
						// ky hieu van ban
						//URL detail
						PortletURL rowURLDetail= renderResponse.createActionURL();
						rowURLDetail.setWindowState(WindowState.NORMAL);
						rowURLDetail.setParameter("struts_action","/nss/van_ban_phap_quy/view");
						rowURLDetail.setParameter(Constants.CMD,"DETAIL");
						rowURLDetail.setParameter("maVanBanPhapQuy", String.valueOf(maVanBanPhapQuy));
						rowURLDetail.setParameter("redirect", vanBanPhapQuySearch.getIteratorURL().toString());
						rowURLDetail.setParameter("tabs", "detail");
						
						row.addText(vanBanPhapQuy.getKyHieuVanBan(), rowURLDetail.toString());
						
						// ngay ban hanh
						Date date = vanBanPhapQuy.getNgayBanHanh();
						if (date != null) {
							ngayBanhanh = simpleDateFormat.format(date);
						}
						row.addText(ngayBanhanh);
						
						// mo ta 
						row.addText(vanBanPhapQuy.getTomTat(), rowURLDetail.toString());
						
						// download	
						fileDinhKemList = FileDinhKemLocalServiceUtil.getListFileDinhKemByMaVanBanPhapQuy(vanBanPhapQuy.getMaVanBanPhapQuy());
						String download = "";
						String fileDinhKemPath = ""; 
						if (fileDinhKemList.size() > 0) {
							if (fileDinhKemList.size() == 1) {
								fileDinhKem = fileDinhKemList.get(0);
								fileDinhKemPath = fileDinhKem.getDuongDan();
								String patthFile = getServletContext().getRealPath("")+ fileDinhKemPath;
								File file = new File(patthFile);
								if (file.exists()) {
									download = "<a href='" + fileDinhKemPath+ "'>" + "<img src='/html/images/icon_download.png' title='" + fileDinhKem.getTenFile() + "'></a>";
								} else {
									download = "";
								}
							} else {
								download = "<img src='/html/images/fulldownload.png' title='" + fileDinhKem.getTenFile() + "'>";
							}
						} else {
							download = "";
						}
						row.addText(download);	
						 
						//active 
						//URL active
						PortletURL rowURLActive= renderResponse.createActionURL();
						rowURLActive.setWindowState(WindowState.NORMAL);
						rowURLActive.setParameter("struts_action","/nss/van_ban_phap_quy/view");
						rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
						rowURLActive.setParameter("maVanBanPhapQuy", String.valueOf(maVanBanPhapQuy));
						rowURLActive.setParameter("redirect", vanBanPhapQuySearch.getIteratorURL().toString());
						
						if (1 == vanBanPhapQuy.getActive()) {
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
						} else if (0 == vanBanPhapQuy.getActive()){
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
						}
						row.addText(active);
						
						// edit
						//URL update
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/nss/van_ban_phap_quy/view");
						rowURLEdit.setParameter("maVanBanPhapQuy", String.valueOf(maVanBanPhapQuy));
						rowURLEdit.setParameter("redirect", vanBanPhapQuySearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tabs", "edit");
						
						update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(update);
						
						// delete
						//URL delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/nss/van_ban_phap_quy/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("maVanBanPhapQuy", String.valueOf(maVanBanPhapQuy));
						rowURLDelete.setParameter("redirect", vanBanPhapQuySearch.getIteratorURL().toString());
						
						deleteAction = "<a  href='javascript: ;' onclick=deleteVanBanPhapQuy('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}	
				} catch (Exception e) {}
				
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= vanBanPhapQuySearch %>" />
	</div>
    </form>
    	
   