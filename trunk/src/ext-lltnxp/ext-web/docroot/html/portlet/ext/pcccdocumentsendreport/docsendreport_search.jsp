<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentsendreport.search.DocSendReportDisplayTerms"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%><style>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>

<%
	DocSendReportDisplayTerms displayTerms = (DocSendReportDisplayTerms)searchContainer.getDisplayTerms();

	// Danh sach cac doi tuong nap vao combo box
	// phmphuc close 11/11/2010
	//List<PmlEdmDocumentType> docTypes = PmlEdmDocumentTypeUtil.findAll();
	List<PmlEdmDocumentType> docTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(2, 3);
	// end phmphuc update 11/11/2010
	List<Department> departments = DepartmentUtil.findAll();
	List<PmlUser> pmlUsers = PmlUserUtil.findAll();
	// Doc nguoi dung tu he thong va luu vao danh sach
	List<Long> userIds = new ArrayList<Long>();
	List<String> userNames = new ArrayList<String>();
	List<User> users = UserUtil.findAll();
	if (!users.isEmpty()) {
		for (int idx = 0; idx < users.size(); idx ++) {
			User userItem = (User) users.get(idx);
			// Them vao danh sach
			userIds.add(userItem.getUserId());
			userNames.add(userItem.getLastName() + " " + userItem.getMiddleName() + " " + userItem.getFirstName());
		}
	}
%>
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="tieu-thuc-tim-kiem"/></label>
<table cellspacing="0" width="100%">
	<tr>
		<td width="15%"><liferay-ui:message key="so-phat-hanh" />&nbsp;:</td>
		<td width="40%">
			<input style="width: 80%" name="<portlet:namespace /><%= displayTerms.SOPH %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSoPH()) %>" />
		</td>
		<td width="15%"><liferay-ui:message key="phat-hanh-trong" />&nbsp;:</td>
		<td>
			<liferay-ui:message key="thang" />
			<select name="<portlet:namespace /><%= displayTerms.NGAYPHMONTH %>" style="width: 50px">
				<option value="0">&nbsp;</option>
				<%
				for (int idx = 1; idx <= 12; idx++) {
				%>
					<option value="<%= idx %>" <%= displayTerms.getNgayPHMonth() == idx ? "selected" : "" %>>&nbsp;<%= idx %></option>
				<%
				}
				%>
			</select>
			<liferay-ui:message key="nam" />&nbsp;
			<input name="<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>" type="text" value="<%= displayTerms.getNgayPHYear() != 0 ? String.valueOf(displayTerms.getNgayPHYear()) : String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) %>" maxlength="4" style="width: 95px;" />
		</td>
	</tr>

	<tr>
		<td><liferay-ui:message key="loai-cong-van" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.LOAIVB %>" style="width: 82.5%;">
				<option value="0">&nbsp;</option>
				<%
				if (!docTypes.isEmpty()) {
					for (int idx = 0; idx < docTypes.size(); idx ++) {
						PmlEdmDocumentType dTItem = (PmlEdmDocumentType) docTypes.get(idx);
				%>
						<option value="<%= dTItem.getDocumentTypeId() %>" <%= dTItem.getDocumentTypeId() == displayTerms.getLoaiVB() ? "selected" : ""%>><%= dTItem.getDocumentTypeName() %></option>
				<%
					}
				}
				%>
			</select>
		</td>
		<td><liferay-ui:message key="noi-nhan" />&nbsp;:</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.NOINHAN %>" id="noinhan" type="text" value="<%= HtmlUtil.escape(displayTerms.getNoiNhan()) %>" style="width: 72.5%" />
			<input style="width: 10%" type="button" value="..." onclick="selRecPlace();" />
		</td>
	</tr>
	
	<tr>
		<td><liferay-ui:message key="phong-soan-thao" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.PHONGST %>" style="width: 82.5%;">
				<option value="">&nbsp;</option>
				<%
				if (!departments.isEmpty()) {
					for (int idx = 0; idx < departments.size(); idx ++) {
						Department depItem = (Department) departments.get(idx);
				%>
						<option value="<%= depItem.getDepartmentsId() %>" <%= depItem.getDepartmentsId().equals(displayTerms.getPhongST()) ? "selected" : ""%>><%= depItem.getDepartmentsName() %></option>
				<%
					}
				}
				%>
			</select>
		</td>
		<td><liferay-ui:message key="nguoi-tao" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.NGUOIST %>" style="width: 90%;">
				<option value="0">&nbsp;</option>
				<%
				if (!pmlUsers.isEmpty() && !userIds.isEmpty()) {
					Collections.sort(pmlUsers, new Comparator<PmlUser>() {
						public int compare(PmlUser obj1, PmlUser obj2) {
							return obj1.getDepartmentsId().compareToIgnoreCase(obj2.getDepartmentsId());
						}                                        
					});
					for (int idx = 0; idx < pmlUsers.size(); idx ++) {
						PmlUser pmlUserItem = (PmlUser) pmlUsers.get(idx);
						int indexOfCurPmlUser = userIds.indexOf(pmlUserItem.getUserId());
						if (indexOfCurPmlUser >= 0) {
				%>
							<option value="<%= (long) userIds.get(indexOfCurPmlUser) %>" <%= (long) userIds.get(indexOfCurPmlUser) == displayTerms.getNguoiST() ? "selected" : ""%>><%= userNames.get(indexOfCurPmlUser) %></option>
				<%
						}
					}
				}
				%>
			</select>
		</td>
	</tr>
	
	<tr>
		<td><liferay-ui:message key="nguoi-ky" />&nbsp;:</td>
		<td><input style="width: 80%" name="<portlet:namespace /><%= displayTerms.NGUOIKY %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getNguoiKy()) %>" /></td>
		<td><liferay-ui:message key="van-ban-phat-hanh" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.VANBANPH %>" style="width: 90%;">
				<option value="" ><liferay-ui:message key="pccc-cvdtn-tatca" /></option>
				<option value="daphathanh" <%="daphathanh".equals(displayTerms.getVanBanPH()) ? "selected" : "" %>><liferay-ui:message key="daphathanh" /></option>
				<option value="chuaphathanh" <%="chuaphathanh".equals(displayTerms.getVanBanPH()) ? "selected" : "" %>><liferay-ui:message key="chuaphathanh" /></option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td><liferay-ui:message key="trich-yeu" />&nbsp;:</td>
		<td colspan="3">
		<textarea name="<portlet:namespace /><%= displayTerms.TRICHYEU %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTrichYeu()) %>" style="width: 95%" rows="2"/></textarea>	
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td colspan="3">
			<input style="margin-left: 0" type="button" value='<liferay-ui:message key="search" />' onClick="<portlet:namespace />searchData();" />
			<input type="button" value='<liferay-ui:message key="pcccdocumentsendreport-inbaocao" />' onclick="<portlet:namespace />addActionFrom('word');<portlet:namespace />fm.submit();<portlet:namespace />setActionFrom();" />
			<input type="button" value='<liferay-ui:message key="pcccdocumentsendreport-xuatexcell" />' onclick="<portlet:namespace />addActionFrom('excel');<portlet:namespace />fm.submit();<portlet:namespace />setActionFrom();" />
		</td>
	</tr>
</table>
</fieldset>
<br>

<script type="text/javascript">
	function selRecPlace() { 
		// Chon don vi gui van ban den. Tra ve ten don vi
		var posX = screen.width / 7;
		var posY = screen.height / 5;
		var widthPopup = 3 * posX;
		var heightPopup = 3 * posY;
	  	var host = location.host;
	  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentsendreport/selreceiveplace.jsp";
	  	var mywindow = window.open (path, "mywindow", "status=1,scrollbars=1,width=" + widthPopup + "px, height=" + heightPopup + "px");
	  
	  	mywindow.moveTo(posX , posY);
	}

	function retRecPlace (retVal) { 
		// Ham de popup tra ve gia tri duoc chon
		var obj = document.getElementById("noinhan");
		if (obj != null) {
			obj.value = retVal;
		} // end if
	}

	function <portlet:namespace />searchData() {
		// Kiem tra ngay phat hanh
		if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>.value != "") {
			if (isIntegerPositiveNumeric(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>.value)) {
				// Do nothing
			}
			else {
				alert("<liferay-ui:message key='vui-long-kiem-tra-ngay-nhap'/>");
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>);
				return;
			} 
		} // end if
		else {
			// Bat buoc phai nhap nam cua ngay den
			alert("<liferay-ui:message key='nam-cua-ngay-phat-hanh-bat-buoc-phai-nhap'/>");
			Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>);
			return;
		}

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.SOPH %>);
	</c:if>
</script>