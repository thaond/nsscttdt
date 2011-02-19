<%@ include file="/html/portlet/ext/loaivanbannoibo/init.jsp" %>

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
<%@page import="com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.search.LoaiVanBanNoiBoSearchTerms"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.search.LoaiVanBanNoiBoDisplayTerms"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.search.LoaiVanBanNoiBoSearch"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/loaivanbannoibo/view");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
%>

<div class="title_categ"><liferay-ui:message key="loai-van-ban-noi-bo"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<%
    	LoaiVanBanNoiBoSearch loaivanbannoiboSearch = new LoaiVanBanNoiBoSearch(renderRequest, portletURL);
    	LoaiVanBanNoiBoDisplayTerms displayTerms = (LoaiVanBanNoiBoDisplayTerms)loaivanbannoiboSearch.getDisplayTerms();
    	LoaiVanBanNoiBoSearchTerms searchTerms = (LoaiVanBanNoiBoSearchTerms) loaivanbannoiboSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", LoaiVanBanNoiBoDisplayTerms.KYHIEULOAIVANBANNOIBO);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = loaivanbannoiboSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/loaivanbannoibo/loaivanbannoibo_search_form.jsp" searchContainer="<%= loaivanbannoiboSearch %>" />
			<%
				PortletURL addURL = renderResponse.createActionURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/loaivanbannoibo/view");
				addURL.setParameter("tab", "add_loaivanbannoibo");
				addURL.setParameter("redirect", portletURLString);
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-loai-van-ban-noi-bo"/>' /></span></a>
				<%
				int count = 0;
				List<LoaiVanBanNoiBo> listloaivanbannoibo = new ArrayList<LoaiVanBanNoiBo>();
				if (!displayTerms.isAdvancedSearch()) {
					count = LoaiVanBanNoiBoLocalServiceUtil.countByKeyword(searchTerms.getKeywords());
					listloaivanbannoibo = LoaiVanBanNoiBoLocalServiceUtil.findByKeyword(searchTerms.getKeywords(), loaivanbannoiboSearch.getStart(), loaivanbannoiboSearch.getEnd(), loaivanbannoiboSearch.getOrderByComparator());
				}else{
					count = LoaiVanBanNoiBoLocalServiceUtil.countLoaiVanBanNoiBo(searchTerms.getKyHieuLoaiVanBanNoiBo(), searchTerms.getTenLoaiVanBanNoiBo(), searchTerms.isAndOperator());
					listloaivanbannoibo = LoaiVanBanNoiBoLocalServiceUtil.findLoaiVanBanNoiBo(searchTerms.getKyHieuLoaiVanBanNoiBo(), searchTerms.getTenLoaiVanBanNoiBo(),
							  loaivanbannoiboSearch.getStart(), loaivanbannoiboSearch.getEnd(), searchTerms.isAndOperator(), loaivanbannoiboSearch.getOrderByComparator());
				}
				
				loaivanbannoiboSearch.setTotal(count);
				loaivanbannoiboSearch.setResults(listloaivanbannoibo);
				portletURL.setParameter(loaivanbannoiboSearch.getCurParam(), String.valueOf(loaivanbannoiboSearch.getCurValue()));
				List<ResultRow> resultRows = loaivanbannoiboSearch.getResultRows();
					
					for(int i = 0; i < listloaivanbannoibo.size(); i++){
						LoaiVanBanNoiBo loaivanbannoibo = listloaivanbannoibo.get(i);
						long loaivanbannoiboId = loaivanbannoibo.getLoaiVanBanNoiBoId();
						
						ResultRow row = new ResultRow(loaivanbannoibo, loaivanbannoiboId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//ky hieu
						row.addText(loaivanbannoibo.getKyHieuLoaiVanBanNoiBo());
						
						//ten
						row.addText(loaivanbannoibo.getTenLoaiVanBanNoiBo());
						
						// edit
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter("struts_action","/sgs/loaivanbannoibo/view");
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("tab", "edit_loaivanbannoibo");
						rowURLEdit.setParameter("loaiVanBanNoiBoId", String.valueOf(loaivanbannoiboId));
						rowURLEdit.setParameter("redirect", loaivanbannoiboSearch.getIteratorURL().toString());
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/loaivanbannoibo/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("loaiVanBanNoiBoId", String.valueOf(loaivanbannoiboId));
						rowURLEdit.setParameter("redirect", loaivanbannoiboSearch.getIteratorURL().toString());
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
			<liferay-ui:search-iterator searchContainer="<%= loaivanbannoiboSearch %>" />
	</form>
</div>
<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script>
