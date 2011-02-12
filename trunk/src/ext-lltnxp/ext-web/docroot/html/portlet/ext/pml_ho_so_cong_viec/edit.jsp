<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>
<style>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<%
	String portletResource = ParamUtil.getString(request, "portletResource");
	String redirect = ParamUtil.getString(request, "redirect");
	String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);
	
	if (originalRedirect.equals(StringPool.BLANK)) {
		originalRedirect = redirect;
	}
	else {
		redirect = originalRedirect;
	}
	
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	// Object processing
	PmlHoSoCongViec pmlHoSoCongViec = (PmlHoSoCongViec) request.getAttribute(WebKeysExt.PMLHOSOCONGVIEC);
	
	String PmlHoSoCongViecAUFlag = "";
	String PmlHoSoCongViecDelFlag = "";
	String cmd = ParamUtil.getString(request, Constants.CMD);
	
	// Object properties
	long userId = themeDisplay.getUserId();
	long idHoSoCongViec = 0;
	long idHSCVCha = 0;
	String soHieuHSCV = "";
	String tieuDe = "";
	Calendar ngayMoHSCV = CalendarFactoryUtil.getCalendar(timeZone, locale);
	Calendar hanXuLy = CalendarFactoryUtil.getCalendar(timeZone, locale);
	hanXuLy.add(Calendar.MONTH, 3);
	
	String idLinhVuc = "";
	String vanDeLienQuan = "";
	long idDoQuanTrong = 0;
	long idTinhChat = 0;
	long idTrangThaiHSCV = 0;
	String tomTatNoiDung = "";
	String hoatDong = "1";
	
	//List<PmlL>
	List<PmlTinhChat> pmlTinhChats = PmlTinhChatLocalServiceUtil.getAll();
	List<PmlDoQuanTrong> pmlDoQuanTrongs = PmlDoQuanTrongLocalServiceUtil.getAll();
	List<PmlTrangThaiHSCV> pmlTrangThaies = PmlTrangThaiHSCVLocalServiceUtil.getAll();
	List<PmlHoSoCongViec> pmlHoSoCongViecs = PmlHoSoCongViecLocalServiceUtil.getAll();
	List<com.liferay.portal.model.User> users = PmlHoSoCongViecLocalServiceUtil.getAllUsers();
	List<PmlField> fields = PmlFieldUtil.findAll();
	
	if (pmlHoSoCongViec != null) {
		idHoSoCongViec = pmlHoSoCongViec.getIdHoSoCongViec();
		userId = pmlHoSoCongViec.getUserId();
		idHSCVCha = pmlHoSoCongViec.getIdHSCVCha();
		soHieuHSCV = pmlHoSoCongViec.getSoHieuHSCV();
		tieuDe = pmlHoSoCongViec.getTieuDe();
		// Ngay mo
		if (pmlHoSoCongViec.getNgayMoHSCV() != null) {
			ngayMoHSCV.setTime(pmlHoSoCongViec.getNgayMoHSCV());
		}
		// Han xu ly
		if (pmlHoSoCongViec.getHanXuLy() != null) {
			hanXuLy.setTime(pmlHoSoCongViec.getHanXuLy());
		}
		
		idLinhVuc = pmlHoSoCongViec.getIdLinhVuc();
		vanDeLienQuan = pmlHoSoCongViec.getVanDeLienQuan();
		idDoQuanTrong = pmlHoSoCongViec.getIdDoQuanTrong();
		idTinhChat = pmlHoSoCongViec.getIdTinhChat();
		idTrangThaiHSCV = pmlHoSoCongViec.getIdTrangThaiHSCV();
		tomTatNoiDung = pmlHoSoCongViec.getTomTatNoiDung();
		hoatDong = pmlHoSoCongViec.getHoatDong();
	}
	else {
		PmlHoSoCongViecAUFlag = request.getAttribute("PmlHoSoCongViecAUFlag") == null ? "" : String.valueOf(request.getAttribute("PmlHoSoCongViecAUFlag"));
		if (PmlHoSoCongViecAUFlag.equals("fail")) { // Add or update fail
			if (cmd.equals(Constants.UPDATE)) {
				// Primary key
				idHoSoCongViec = ParamUtil.getLong(request, "idHoSoCongViec");
			}
			// Other fields
			userId = ParamUtil.getLong(request, "userId");
			idHSCVCha = ParamUtil.getLong(request, "idHSCVCha");
			soHieuHSCV = ParamUtil.getString(request, "soHieuHSCV", "");
			tieuDe = ParamUtil.getString(request, "tieuDe", "");
			// Ngay mo
			ngayMoHSCV.set(Calendar.MONTH, ParamUtil.getInteger(request, "ngayMoHSCVMonth"));
			ngayMoHSCV.set(Calendar.YEAR, ParamUtil.getInteger(request, "ngayMoHSCVYear"));
			ngayMoHSCV.set(Calendar.DAY_OF_MONTH, ParamUtil.getInteger(request, "ngayMoHSCVDay"));
			// Han xu ly
			hanXuLy.set(Calendar.MONTH, ParamUtil.getInteger(request, "hanXuLyMonth"));
			hanXuLy.set(Calendar.YEAR, ParamUtil.getInteger(request, "hanXuLyYear"));
			hanXuLy.set(Calendar.DAY_OF_MONTH, ParamUtil.getInteger(request, "hanXuLyDay"));

			idLinhVuc = ParamUtil.getString(request, "idLinhVuc", "");
			vanDeLienQuan = ParamUtil.getString(request, "vanDeLienQuan", "");
			idDoQuanTrong = ParamUtil.getLong(request, "idDoQuanTrong");
			idTinhChat = ParamUtil.getLong(request, "idTinhChat");
			idTrangThaiHSCV = ParamUtil.getLong(request, "idTrangThaiHSCV");
			tomTatNoiDung = ParamUtil.getString(request, "tomTatNoiDung", "");
			hoatDong = ParamUtil.getString(request, "hoatDong", "1");
		}
	}
%>

<script type="text/javascript">

	function <portlet:namespace />savePmlHoSoCongViec(cmd) {
		if (!<portlet:namespace />validate()) return;
		if (cmd == null) {
			cmd = "<%= pmlHoSoCongViec != null || pmlHoSoCongViec == null && PmlHoSoCongViecAUFlag.equals("fail") && idHoSoCongViec > 0 ? Constants.UPDATE : Constants.ADD %>";
		}

		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;
		submitForm(document.<portlet:namespace />fm);
	}
	
	function <portlet:namespace />validate() {
		// Kiem tra tieu de
		if (document.<portlet:namespace />fm.<portlet:namespace />tieuDe.value == "") {
			alert('<liferay-ui:message key="pml_inputvalue" />');
			Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />tieuDe);
			return false;
		}
		// Kiem tra ngay
		var ngayMo = new Date(document.<portlet:namespace />fm.<portlet:namespace />ngayMoHSCVYear.value, document.<portlet:namespace />fm.<portlet:namespace />ngayMoHSCVMonth.value, document.<portlet:namespace />fm.<portlet:namespace />ngayMoHSCVDay.value);
		var hanXuLy = new Date(document.<portlet:namespace />fm.<portlet:namespace />hanXuLyYear.value, document.<portlet:namespace />fm.<portlet:namespace />hanXuLyMonth.value, document.<portlet:namespace />fm.<portlet:namespace />hanXuLyDay.value);
		if (ngayMo == null || hanXuLy == null || ngayMo >= hanXuLy) {
			alert('<liferay-ui:message key="pml_kiemtra_ngaymo_hanxuly" />');
			return false;
		}
		return true;
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_ho_so_cong_viec/edit" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" class="bgtran">
	<input name="<portlet:namespace />portletResource" type="hidden" value="<%= HtmlUtil.escape(portletResource) %>" />
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
	<input name="<portlet:namespace />originalRedirect" type="hidden" value="<%= HtmlUtil.escape(originalRedirect) %>" />
	<input name="<portlet:namespace />referringPortletResource" type="hidden" value="<%= HtmlUtil.escape(referringPortletResource) %>" />
	<input name="<portlet:namespace />idHoSoCongViec" type="hidden" value="<%= idHoSoCongViec %>" />
	<input name="<portlet:namespace />hoatDong" type="hidden" value="<%= hoatDong %>" />
<% if (null == pmlHoSoCongViec) { %>	
<div class="title_categ"><liferay-ui:message key="them-ho-so-cong-viec" /></div>
<% } else { %>
<div class="title_categ"><liferay-ui:message key="cap-nhat-ho-so-cong-viec" /></div>
<% } %>
<div class="boxcontent">
<table cellspacing="0" width="100%">
<tr>
	<td width="17%">
		<liferay-ui:error exception="<%= PmlHoSoCongViecSoHieuHSCVException.class %>" message="sohieu_phaico_khongtrung" />
		<liferay-ui:message key="pml_sohieuhscv" />
		<span style="color:red;">(*)</span>&nbsp;:
	</td>
	<td width="35%"><input style="width: 90%" type="text" name="<portlet:namespace />soHieuHSCV" value="<%= soHieuHSCV %>" /></td>
	<td width="15%">
		<liferay-ui:error exception="<%= PmlHoSoCongViecTieuDeException.class %>" message="tieude_khong_detrong" />
			<liferay-ui:message key="pml_tieude" />
		<span style="color:red;">(*)&nbsp;:</span>
	</td>
	<td ><input style="width: 92%" type="text" name="<portlet:namespace />tieuDe" value="<%= tieuDe %>" /></td>
</tr>
<tr>	
	<td ><liferay-ui:message key="pml_linhvuc" />&nbsp;:</td>
	<td>
		<select name="<portlet:namespace />idLinhVuc" style="width: 93%">
							<option value=""></option>
							<%
							for (int idx = 0; idx < fields.size(); idx++) {
							PmlField field = (PmlField) fields.get(idx);
							%>
								<option <%= field.getFieldId().equals(idLinhVuc) ? "selected" : "" %> value="<%= field.getFieldId() %>"><%= field.getFieldName() %></option>
							<%
							}
							%>
		</select>
	</td>
	<td>
		<liferay-ui:error exception="<%= PmlHoSoCongViecUserIdException.class %>" message="nguoilap_khong_detrong" />
		<liferay-ui:message key="pml_nguoilap" />&nbsp;:
	</td>
	<td>
		<select name="<portlet:namespace />userId" style="width: 95%">
							<option value="0"></option>
							<%
							for (int idx = 0; idx < users.size(); idx++) {
								com.liferay.portal.model.User userItem = (com.liferay.portal.model.User) users.get(idx);
							if (userItem.getFullName().trim().length() > 0) { // Chi lay nguoi dung thuc te
						%>
								<option <%= userItem.getUserId() == userId ? "selected" : "" %> value="<%= userItem.getUserId() %>"><%= userItem.getLastName().concat(" ") + userItem.getMiddleName().concat(" ") + userItem.getFirstName() %></option>
						<%
							}
							}
							%>
		</select>
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:error exception="<%= PmlHoSoCongViecNgayMoHSCVException.class %>" message="ngaymo_khong_detrong" />
		<liferay-ui:message key="pml_ngaymo" />&nbsp;:
	</td>
	<td>
		<%
						if (ngayMoHSCV == null) ngayMoHSCV = CalendarFactoryUtil.getCalendar(timeZone, locale);
						%>
						<liferay-ui:input-date
			 				formName="fm"
							monthParam='ngayMoHSCVMonth'
							monthValue="<%= ngayMoHSCV.get(Calendar.MONTH) %>"
							monthNullable="false"
							dayParam='ngayMoHSCVDay'
							dayValue="<%= ngayMoHSCV.get(Calendar.DAY_OF_MONTH) %>"
							dayNullable="false"
							yearParam='ngayMoHSCVYear'
							yearValue="<%= ngayMoHSCV.get(Calendar.YEAR) %>"
							yearNullable="false"
							yearRangeStart="<%= ngayMoHSCV.get(Calendar.YEAR) - 4 %>"
							yearRangeEnd="<%= ngayMoHSCV.get(Calendar.YEAR) + 4 %>"
							firstDayOfWeek="<%= ngayMoHSCV.getFirstDayOfWeek() %>"
							imageInputId='ngayMoHSCVImageInputId'
			 				disabled="false"
						/>
	</td>
	<td>
		<liferay-ui:error exception="<%= PmlHoSoCongViecHanXuLyException.class %>" message="hanxuly_lonhon_ngaymo" />
		<liferay-ui:message key="pml_hanxuly" />&nbsp;:
	</td>
	<td>
		<liferay-ui:input-date
			 				formName="fm"
							monthParam='hanXuLyMonth'
							monthValue="<%= hanXuLy.get(Calendar.MONTH) %>"
							monthNullable="false"
							dayParam='hanXuLyDay'
							dayValue="<%= hanXuLy.get(Calendar.DAY_OF_MONTH) %>"
							dayNullable="false"
							yearParam='hanXuLyYear'
							yearValue="<%= hanXuLy.get(Calendar.YEAR) %>"
							yearNullable="false"
							yearRangeStart="<%= hanXuLy.get(Calendar.YEAR) - 4 %>"
							yearRangeEnd="<%= hanXuLy.get(Calendar.YEAR) + 4 %>"
							firstDayOfWeek="<%= hanXuLy.getFirstDayOfWeek() %>"
							imageInputId='hanXuLyImageInputId'
			 				disabled="false"
						/>
	</td>	
</tr>
<tr>
	<td><liferay-ui:message key="pml_mucdoquantrong" />&nbsp;:</td>
	<td>
		<select name="<portlet:namespace />idDoQuanTrong" style="width: 93%">
							<%
							for (int idx = 0; idx < pmlDoQuanTrongs.size(); idx++) {
								PmlDoQuanTrong pmlDoQuanTrongCboItem = (PmlDoQuanTrong) pmlDoQuanTrongs.get(idx);
							%>
								<option <%= pmlDoQuanTrongCboItem.getPrimaryKey() == idDoQuanTrong ? "selected" : "" %> value="<%= pmlDoQuanTrongCboItem.getPrimaryKey() %>"><%= pmlDoQuanTrongCboItem.getTenDoQuanTrong() %></option>
							<%
							}
							%>
						</select>
	</td>
	<td><liferay-ui:message key="pml_trangthai" />&nbsp;:</td>
	<td>
		<select name="<portlet:namespace />idTrangThaiHSCV" style="width: 95%">
							<%
							for (int idx = 0; idx < pmlTrangThaies.size(); idx++) {
								PmlTrangThaiHSCV pmlTrangThaiHSCVCboItem = (PmlTrangThaiHSCV) pmlTrangThaies.get(idx);
							%>
								<option <%= pmlTrangThaiHSCVCboItem.getPrimaryKey() == idTrangThaiHSCV ? "selected" : "" %> value="<%= pmlTrangThaiHSCVCboItem.getPrimaryKey() %>"><%= pmlTrangThaiHSCVCboItem.getTenTrangThaiHSCV() %></option>
							<%
							}
							%>
						</select>
	</td>
</tr>
<tr>
	<td><liferay-ui:message key="pml_tinhchat" />&nbsp;:</td>
	<td>
		<select name="<portlet:namespace />idTinhChat" style="width: 93%">
							<%
							for (int idx = 0; idx < pmlTinhChats.size(); idx++) {
								PmlTinhChat pmlTinhChatCboItem = (PmlTinhChat) pmlTinhChats.get(idx);
							%>
								<option <%= pmlTinhChatCboItem.getPrimaryKey() == idTinhChat ? "selected" : "" %> value="<%= pmlTinhChatCboItem.getPrimaryKey() %>"><%= pmlTinhChatCboItem.getTenTinhChat() %></option>
							<%
							}
							%>
						</select>
	</td>	
	<td><liferay-ui:message key="pml_hosocha" />&nbsp;:</td>
	<td>
		<select name="<portlet:namespace />idHSCVCha" style="width: 95%">
							<option value="0"></option>
							<%
							for (int idx = 0; idx < pmlHoSoCongViecs.size(); idx++) {
								PmlHoSoCongViec pmlHoSoCongViecCboItem = (PmlHoSoCongViec) pmlHoSoCongViecs.get(idx);
								if (idHoSoCongViec > 0 && pmlHoSoCongViecCboItem.getIdHoSoCongViec() == idHoSoCongViec) {
									continue;
								}
							%>
								<option <%= pmlHoSoCongViecCboItem.getPrimaryKey() == idHSCVCha ? "selected" : "" %> value="<%= pmlHoSoCongViecCboItem.getPrimaryKey() %>"><%= pmlHoSoCongViecCboItem.getTieuDe() %></option>
							<%
							}
							%>
						</select>
	</td>
</tr>
<tr>
	<td><liferay-ui:message key="pml_vandelienquan" />&nbsp;:</td>
	<td colspan="3"><textarea style="width: 97%" name="<portlet:namespace />vanDeLienQuan" rows="2"><%= vanDeLienQuan %></textarea></td>

</tr>
<tr>
	<td><liferay-ui:message key="pml_tomtatnoidung" />&nbsp;:</td>
	<td colspan="3"><textarea style="width: 97%"  name="<portlet:namespace />tomTatNoiDung" wrap="soft" rows="2"><%= tomTatNoiDung %></textarea></td>

</tr>	
<tr>
	<td></td>
	<td colspan="3">
	<% if (null == pmlHoSoCongViec) { %>	
		<input style="margin-left: 0;" type="button" value='<liferay-ui:message key="save" />'  onClick="<portlet:namespace />savePmlHoSoCongViec()" />
	<% } else { %>
		<input style="margin-left: 0;" type="button" value='<liferay-ui:message key="update" />'  onClick="<portlet:namespace />savePmlHoSoCongViec()" />
	<% } %>
		<input type="button" value='<liferay-ui:message key="back" />' onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
	</td>

</tr>
</table>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />soHieuHSCV);
	</script>
</c:if>