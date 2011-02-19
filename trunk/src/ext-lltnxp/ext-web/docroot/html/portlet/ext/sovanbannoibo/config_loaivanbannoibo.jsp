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
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>

<%@page import="com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"%>
<%@page import="com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoUtil"%>
<%@page import="com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.LoaiVanBanNoiBoSearchTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.LoaiVanBanNoiBoDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.LoaiVanBanNoiBoSearch"%>
<%@page import="com.sgs.portlet.sovanbannoibo.util.LoaiVanBanNoiBoRowChecker"%>

<%	
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	portletURL.setParameter("tab", "config_loaivanbannoibo");
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	String backURLString = backURL.toString();
	
	long soVanBanNoiBoId = 0;
	try{
		soVanBanNoiBoId = (Long) request.getAttribute("soVanBanNoiBoId");
	}catch(Exception e){
	}
	List<LoaiVanBanNoiBo> results = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBos(-1,-1);
%>

<div class="title_categ"><liferay-ui:message key="loai-van-ban-noi-bo"/></div>
<div class="boxcontent">
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace/>addLoaiVanBanNoiBo"  type="hidden" value=""/>
<!--	<input name="<portlet:namespace/>loaiVanBanNoiBoIds" type="hidden" value="">-->
	<input name="<portlet:namespace/>soVanBanNoiBoId" type="hidden" value="<%=(soVanBanNoiBoId != 0) ? soVanBanNoiBoId : "" %>">
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
    	
    	int countLoaiVanBanNoiBo = 0;
		String loaiVanBanNoiBoIsCheck = "";
		StringBuilder rowNameChecked=null;
		
    	List<String> header = loaivanbannoiboSearch.getHeaderNames();
    	String formName = renderResponse.getNamespace() + "fm";
    	String rowNameLoaiVBNB = renderResponse.getNamespace() + "loaiVanBanNoiBo";
		String rowAllNameLoaiVBNB = renderResponse.getNamespace() +"allLoaiVanBanNoiBo";
		
		StringBuilder rowAllLoaiVanBanNoiBoChecked = new StringBuilder();
		rowAllLoaiVanBanNoiBoChecked.append("<input name=\"");
		rowAllLoaiVanBanNoiBoChecked.append(rowAllNameLoaiVBNB);
		rowAllLoaiVanBanNoiBoChecked.append("\" type=\"checkbox\" ");
		rowAllLoaiVanBanNoiBoChecked.append("onClick=\"Liferay.Util.checkAll(");
		rowAllLoaiVanBanNoiBoChecked.append(formName);
		rowAllLoaiVanBanNoiBoChecked.append(", '");
		rowAllLoaiVanBanNoiBoChecked.append(rowNameLoaiVBNB);
		rowAllLoaiVanBanNoiBoChecked.append("', this");
		rowAllLoaiVanBanNoiBoChecked.append(");\"> ");
		header.add(0,rowAllLoaiVanBanNoiBoChecked.toString());
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/sovanbannoibo/loaivanbannoibo_search_form.jsp" searchContainer="<%= loaivanbannoiboSearch %>" />
		<input type="button" name="<portlet:namespace/>config" value='<liferay-ui:message key="update-loai-van-ban-noi-bo"/>' onclick="<portlet:namespace/>updateConfig();" />
		<a href="<%=backURLString %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
		
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
				
				loaivanbannoiboSearch.setResults(listloaivanbannoibo);
				loaivanbannoiboSearch.setTotal(count);
				portletURL.setParameter(loaivanbannoiboSearch.getCurParam(), String.valueOf(loaivanbannoiboSearch.getCurValue()));
				List<ResultRow> resultRows = loaivanbannoiboSearch.getResultRows();
					
					for(int i = 0; i < listloaivanbannoibo.size(); i++){
						LoaiVanBanNoiBo loaivanbannoibo = listloaivanbannoibo.get(i);
						long loaivanbannoiboId = loaivanbannoibo.getLoaiVanBanNoiBoId();
						
						ResultRow row = new ResultRow(loaivanbannoibo, loaivanbannoiboId, i);
						
						//check
						List<SoLoaiVanBanNoiBo> list = SoLoaiVanBanNoiBoUtil.findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,loaivanbannoiboId);
						if(list.size() > 0){
							loaiVanBanNoiBoIsCheck = "1";
							countLoaiVanBanNoiBo += 1;
						}

						// checked
						rowNameChecked = new StringBuilder();
						rowNameChecked.append("<input ");
						rowNameChecked.append(("1".equals(loaiVanBanNoiBoIsCheck) ? "checked " : " "));
						rowNameChecked.append("name=\"");
						rowNameChecked.append(rowNameLoaiVBNB);
						rowNameChecked.append("\" type=\"checkbox\" value=\"");
						rowNameChecked.append(String.valueOf(loaivanbannoiboId));
						rowNameChecked.append("\" ");
						rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
						rowNameChecked.append(formName);
						rowNameChecked.append(", '");
						rowNameChecked.append(rowNameLoaiVBNB);
						rowNameChecked.append("', ");
						rowNameChecked.append(rowAllNameLoaiVBNB);
						rowNameChecked.append(");\"");
						rowNameChecked.append(">");
						
						loaiVanBanNoiBoIsCheck = "";
						row.addText(rowNameChecked.toString());
						// STT
						row.addText(String.valueOf(i + 1));
						
						//ky hieu
						row.addText(loaivanbannoibo.getKyHieuLoaiVanBanNoiBo());
						
						//ten
						row.addText(loaivanbannoibo.getTenLoaiVanBanNoiBo());
						
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

<script type="text/javascript">
	function <portlet:namespace/>updateConfig(){
		var loaiVanBanNoiBoCheckboxs = document.getElementsByName("<portlet:namespace/>loaiVanBanNoiBo");
		var listLoaiVanBanNoiBoCheck = "";
		for (var i = 0; i < loaiVanBanNoiBoCheckboxs.length; i++) {
			if (loaiVanBanNoiBoCheckboxs[i].checked) {
				listLoaiVanBanNoiBoCheck += loaiVanBanNoiBoCheckboxs[i].value + ",";
			}
		}
		document.<portlet:namespace/>fm.<portlet:namespace/>addLoaiVanBanNoiBo.value = listLoaiVanBanNoiBoCheck;
		if (confirm("<liferay-ui:message key='ban-co-muon-tiep-tuc-khong'/>")){
			submitForm(document.<portlet:namespace/>fm,
					"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
					<portlet:param name="struts_action" value="/sgs/sovanbannoibo/view" />
					<portlet:param name="tab" value="config_loaivanbannoibo" />
					<portlet:param name="<%=Constants.CMD%>" value="CONFIGUPDATELOAIVANBANNOIBO" />
					</portlet:actionURL>");
		}
	}
</script>

<c:if test="<%= (countLoaiVanBanNoiBo == results.size()) %>">
	<script type="text/javascript">
			document.<portlet:namespace />fm.<portlet:namespace />allLoaiVanBanNoiBo.checked = true;
	</script>
</c:if>