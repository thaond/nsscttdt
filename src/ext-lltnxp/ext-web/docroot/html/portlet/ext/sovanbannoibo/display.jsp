<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalServiceUtil"%>
<%@page import="com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.SoVanBanNoiBoSearchTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.SoVanBanNoiBoDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.SoVanBanNoiBoSearch"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
%>

<div class="title_categ"><liferay-ui:message key="so-van-ban-noi-bo"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<%
    	SoVanBanNoiBoSearch soVanBanNoiBoSearch = new SoVanBanNoiBoSearch(renderRequest, portletURL);
    	SoVanBanNoiBoDisplayTerms displayTerms = (SoVanBanNoiBoDisplayTerms)soVanBanNoiBoSearch.getDisplayTerms();
    	SoVanBanNoiBoSearchTerms searchTerms = (SoVanBanNoiBoSearchTerms) soVanBanNoiBoSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", SoVanBanNoiBoDisplayTerms.MASOVANBANNOIBO);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = soVanBanNoiBoSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/sovanbannoibo/sovanbannoibo_search_form.jsp" searchContainer="<%= soVanBanNoiBoSearch %>" />
			<%
				PortletURL addURL = renderResponse.createActionURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
				addURL.setParameter("tab", "add_sovanbannoibo");
				addURL.setParameter("redirect", portletURLString);
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-so-van-ban-noi-bo"/>' /></span></a>
				<%
				int count = 0;
				List<SoVanBanNoiBo> listsoVanBanNoiBo = new ArrayList<SoVanBanNoiBo>();
				if (!displayTerms.isAdvancedSearch()) {
					count = SoVanBanNoiBoLocalServiceUtil.countByKeyword(searchTerms.getKeywords());
					listsoVanBanNoiBo = SoVanBanNoiBoLocalServiceUtil.findByKeyword(searchTerms.getKeywords(), soVanBanNoiBoSearch.getStart(), soVanBanNoiBoSearch.getEnd(), soVanBanNoiBoSearch.getOrderByComparator());
				}else{
					count = SoVanBanNoiBoLocalServiceUtil.countSoVanBanNoiBo(searchTerms.getMaSoVanBanNoiBo(), searchTerms.getTenSoVanBanNoiBo(), searchTerms.isAndOperator());
					listsoVanBanNoiBo = SoVanBanNoiBoLocalServiceUtil.findSoVanBanNoiBo(searchTerms.getMaSoVanBanNoiBo(), searchTerms.getTenSoVanBanNoiBo(),
							  soVanBanNoiBoSearch.getStart(), soVanBanNoiBoSearch.getEnd(), searchTerms.isAndOperator(), soVanBanNoiBoSearch.getOrderByComparator());
				}
				
				soVanBanNoiBoSearch.setTotal(count);
				soVanBanNoiBoSearch.setResults(listsoVanBanNoiBo);
				portletURL.setParameter(soVanBanNoiBoSearch.getCurParam(), String.valueOf(soVanBanNoiBoSearch.getCurValue()));
				List<ResultRow> resultRows = soVanBanNoiBoSearch.getResultRows();
					
					for(int i = 0; i < listsoVanBanNoiBo.size(); i++){
						SoVanBanNoiBo soVanBanNoiBo = listsoVanBanNoiBo.get(i);
						long soVanBanNoiBoId = soVanBanNoiBo.getSoVanBanNoiBoId();
						
						ResultRow row = new ResultRow(soVanBanNoiBo, soVanBanNoiBoId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//ma
						row.addText(soVanBanNoiBo.getMaSoVanBanNoiBo());
						
						//ten
						row.addText(soVanBanNoiBo.getTenSoVanBanNoiBo());
						
						//config loai van ban noi bo
						PortletURL rowURLConfigLoaiVanBanNoiBo = renderResponse.createActionURL();
						rowURLConfigLoaiVanBanNoiBo.setWindowState(WindowState.NORMAL);
						rowURLConfigLoaiVanBanNoiBo.setParameter("struts_action","/sgs/sovanbannoibo/view");
						rowURLConfigLoaiVanBanNoiBo.setParameter(Constants.CMD,"CONFIGLOAIVANBANNOIBO");
						rowURLConfigLoaiVanBanNoiBo.setParameter("tab", "config_loaivanbannoibo");
						rowURLConfigLoaiVanBanNoiBo.setParameter("soVanBanNoiBoId", String.valueOf(soVanBanNoiBoId));
						rowURLConfigLoaiVanBanNoiBo.setParameter("redirect", soVanBanNoiBoSearch.getIteratorURL().toString());
						
						String configLoaiVanBanNoiBoAction = "<a href='"+ rowURLConfigLoaiVanBanNoiBo.toString()+"'><img src='/html/images/configfile.png' />&nbsp;</a>";
						
						row.addText(configLoaiVanBanNoiBoAction);
						
						//config phong ban
						PortletURL rowURLConfigPhongBan = renderResponse.createActionURL();
						rowURLConfigPhongBan.setWindowState(WindowState.NORMAL);
						rowURLConfigPhongBan.setParameter("struts_action","/sgs/sovanbannoibo/view");
						rowURLConfigPhongBan.setParameter(Constants.CMD,"CONFIGPHONGBAN");
						rowURLConfigPhongBan.setParameter("tab", "config_phongban");
						rowURLConfigPhongBan.setParameter("soVanBanNoiBoId", String.valueOf(soVanBanNoiBoId));
						rowURLConfigPhongBan.setParameter("redirect", soVanBanNoiBoSearch.getIteratorURL().toString());
						
						String configPhongBanAction = "<a href='"+ rowURLConfigPhongBan.toString()+"'><img src='/html/images/configfile.png' />&nbsp;</a>";
						
						row.addText(configPhongBanAction);
						
						// edit
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter("struts_action","/sgs/sovanbannoibo/view");
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("tab", "edit_sovanbannoibo");
						rowURLEdit.setParameter("soVanBanNoiBoId", String.valueOf(soVanBanNoiBoId));
						rowURLEdit.setParameter("redirect", soVanBanNoiBoSearch.getIteratorURL().toString());
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/sovanbannoibo/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("soVanBanNoiBoId", String.valueOf(soVanBanNoiBoId));
						rowURLEdit.setParameter("redirect", soVanBanNoiBoSearch.getIteratorURL().toString());
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
			<liferay-ui:search-iterator searchContainer="<%= soVanBanNoiBoSearch %>" />
	</form>
</div>
<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script>
