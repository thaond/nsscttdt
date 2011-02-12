<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<link type="text/css" rel="stylesheet"	href="/html/_css/modulework/chitiethscv.css" />

<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>

<script type="text/javascript">
function setValueCVDen(idCongVanDen) 
{
	if (trim(idCongVanDen) != null){
		document.<portlet:namespace />fm.<portlet:namespace />hidCVDen.value = idCongVanDen ;
	}
}
	
function <portlet:namespace />deleteCVDen() 
{
	if (document.<portlet:namespace />fm.<portlet:namespace />hidCVDen.value == "" || document.<portlet:namespace />fm.<portlet:namespace />hidCVDen.value == null ){
		alert('<%= UnicodeLanguageUtil.get(pageContext, "chon-cong-van-den-can-xu-ly") %>');
	}
	else {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-cong-van-den") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/viewdetail" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
}
function setValueCVDi(idCongVanDi) 
{	
	if (trim(idCongVanDi) != null){
		document.<portlet:namespace />fm.<portlet:namespace />hidCVDi.value = idCongVanDi ;
	}
}
	
function <portlet:namespace />deleteCVDi() 
{
	if (document.<portlet:namespace />fm.<portlet:namespace />hidCVDi.value == "" || document.<portlet:namespace />fm.<portlet:namespace />hidCVDi.value == null ){
		alert('<%= UnicodeLanguageUtil.get(pageContext, "chon-cong-van-di-can-xu-ly") %>');
	}
	else {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-cong-van-di") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/viewdetail" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
}
	
function <portlet:namespace />backURL() 
{
	submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/view" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
}
</script>

<%
	String tabs = ParamUtil.getString(request, "tabs", "cvden");
	String redirect = ParamUtil.getString(request, "redirect");
	String cur = ParamUtil.getString(request, "cur");
	
	long idHoSoCongViec = ParamUtil.getLong(request, "idHoSoCongViec");

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/viewdetail");
	portletURL.setParameter("tabs", tabs);
	portletURL.setParameter("idHoSoCongViec", String.valueOf(idHoSoCongViec));
	
	PmlHoSoCongViec pmlHoSoCongViec = null;
	String soHieuHSCV = "";
	String tieuDe = "";
	String linhVuc = "";
	String userName = "";
	String ngayMo = "";
	String hanXuLy = "";
	String mucDoQuanTrong = "";
	String tinhChat = "";
	String vanDeLienQuan = "";
	String tinhTrangXuLy = "";
	String hoSoCha = "";

	pmlHoSoCongViec = PmlHoSoCongViecLocalServiceUtil.getPmlHoSoCongViec(idHoSoCongViec);
	
	if (Validator.isNotNull(pmlHoSoCongViec)){
		soHieuHSCV = pmlHoSoCongViec.getSoHieuHSCV();
		tieuDe = pmlHoSoCongViec.getTieuDe();
		
		String fieldId = pmlHoSoCongViec.getIdLinhVuc();
		if (Validator.isNotNull(fieldId)) {
			PmlField field = PmlFieldLocalServiceUtil.getPmlField(fieldId);
			
			if (Validator.isNotNull(field)) {
				linhVuc = field.getFieldName();
			}
		}
		
		userName = pmlHoSoCongViec.getUserName();
		ngayMo = df.format(pmlHoSoCongViec.getNgayMoHSCV());
		hanXuLy = df.format(pmlHoSoCongViec.getHanXuLy());
	
		long doQuanTrongId = pmlHoSoCongViec.getIdDoQuanTrong();
		if (doQuanTrongId > 0) {
			PmlDoQuanTrong pmlDoQuanTrong = PmlDoQuanTrongLocalServiceUtil.getPmlDoQuanTrong(doQuanTrongId);
			if (Validator.isNotNull(pmlDoQuanTrong)) {
				mucDoQuanTrong = pmlDoQuanTrong.getTenDoQuanTrong();
			}
		}
		
		long trangThaiHSCVId = pmlHoSoCongViec.getIdTrangThaiHSCV();
		if (trangThaiHSCVId > 0) {
			PmlTrangThaiHSCV pmlTrangThaiHSCV = PmlTrangThaiHSCVLocalServiceUtil.getPmlTrangThaiHSCV(trangThaiHSCVId);
			if (Validator.isNotNull(pmlTrangThaiHSCV)) {
				tinhTrangXuLy = pmlTrangThaiHSCV.getTenTrangThaiHSCV();
			}
		}
		
		long tinhChatId = pmlHoSoCongViec.getIdTinhChat();
		if (tinhChatId > 0) {
			PmlTinhChat pmlTinhChat = PmlTinhChatLocalServiceUtil.getPmlTinhChat(tinhChatId);
			tinhChat = pmlTinhChat.getTenTinhChat();
		}
		
		vanDeLienQuan = pmlHoSoCongViec.getVanDeLienQuan();
	
		long idHSCVCha = pmlHoSoCongViec.getIdHSCVCha();
	
		if (idHSCVCha > 0){
			PmlHoSoCongViec pmlHoSoCongViecCha = PmlHoSoCongViecLocalServiceUtil.getPmlHoSoCongViec(idHSCVCha);
			if (Validator.isNotNull(pmlHoSoCongViecCha)) {
				hoSoCha = pmlHoSoCongViecCha.getTieuDe();
			}
		}
	}
%>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/viewdetail" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePmlDoQuanTrong(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
<input name="<portlet:namespace />tabs" type="hidden" value="<%= HtmlUtil.escape(tabs) %>" />
<input name="<portlet:namespace />redirect" type="hidden" value="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/viewdetail" /><portlet:param name="tabs" value="<%= tabs %>" />portlet:param name="cur" value="<%= cur %>" /></portlet:renderURL>" />
<input name="<portlet:namespace />pmlChiTietHSCVURL" type="hidden" value="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/viewdetail" /></portlet:renderURL>" />
<input name="<portlet:namespace />hidCVDen" type="hidden"/>
<input name="<portlet:namespace />hidCVDi" type="hidden"/>
<input name="<portlet:namespace />idHoSoCongViec" type="hidden" value="<%=idHoSoCongViec %>" />

<div class="title_categ"><liferay-ui:message key="thong-tin-ho-so-cong-viec"/></div>

<div class="boxcontent">
	<fieldset class="filborder filborderIE">
		<legend class="laborder"><liferay-ui:message key="pccc-Chitiethoso"/></legend>
		<table cellspacing="0" width="100%" class="bab">
			<tr>
				<td width="18%" class="td-left"><liferay-ui:message key="so-hieu-hscv" />&nbsp;:</td>
				<td width="32%" class="td-right"><%= soHieuHSCV %></td>
				<td width="18%" class="td-left"><liferay-ui:message key="tieu-de" />&nbsp;:</td>
				<td class="td-right"><%= tieuDe %></td>
			</tr>
			
			<tr>	
				<td class="td-left"><liferay-ui:message key="linh-vuc" />&nbsp;:</td>
				<td class="td-right"><%= linhVuc %></td>
				<td class="td-left"><liferay-ui:message key="nguoi-tao" />&nbsp;:</td>
				<td class="td-right"><%= userName %></td>
			</tr>
			
			<tr>	
				<td class="td-left"><liferay-ui:message key="ngay-mo" />&nbsp;:</td>
				<td class="td-right"><%= ngayMo %></td>
				<td class="td-left"><liferay-ui:message key="han-xu-ly" />&nbsp;:</td>
				<td class="td-right"><%= hanXuLy %></td>
			</tr>
			
			<tr>
				<td class="td-left"><liferay-ui:message key="muc-do-quan-trong" />&nbsp;:</td>
				<td class="td-right"><%= mucDoQuanTrong %></td>
				<td class="td-left"><liferay-ui:message key="tinh-trang-xu-ly" />&nbsp;:</td>
				<td class="td-right"><%= tinhTrangXuLy %></td>
			</tr>
			
			<tr>
				<td class="td-left"><liferay-ui:message key="tinh-chat" />&nbsp;:</td>
				<td class="td-right"><%= tinhChat %></td>
				<td class="td-left"><liferay-ui:message key="van-de-lien-quan" />&nbsp;:</td>
				<td class="td-right"><%= vanDeLienQuan %></td>
			</tr>
			
			<tr>
				<td class="td-left"><liferay-ui:message key="ho-so-cha" />&nbsp;:</td>
				<td class="td-right" colspan="3"><%= hoSoCha %></td>
			</tr>
			
			<tr>
				<td></td>
				<td colspan="5" align="right">
					<input type="button" value='<liferay-ui:message key="back"/>'onClick="location.href = '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/view" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';" />			
				</td>
			</tr>	
		</table>
	</fieldset>
	
	<div class="separator"><!-- --></div>

	<liferay-ui:tabs names="cvden,cvdi"	param="tabs" url="<%= portletURL.toString() %>"	value="<%= tabs %>"/>
	<div class="boxcontent_Tab pmlhscv">
		<c:choose>
			<c:when test='<%= tabs.equals("cvden") %>'>
				<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/pml_chi_tiet_hscv_cvden.jspf" %>						
			</c:when>
			<c:when test='<%= tabs.equals("cvdi") %>'>
				<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/pml_chi_tiet_hscv_cvdi.jspf" %>
			</c:when>
		</c:choose>
	</div>
</div>
</form>
