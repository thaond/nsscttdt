<%@page import="com.sgs.portlet.pcccdocumentrecordto.search.DocumentRecordToSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentrecordto.search.DocumentRecordToDisplayTerms"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil"%>

<style>
	<%@ include file="/html/_css/qlcvmodule/module.css"%>
</style>
<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>

<%
	DocumentRecordToDisplayTerms displayTerms = (DocumentRecordToDisplayTerms)searchContainer.getDisplayTerms();

	// Danh sach cac doi tuong nap vao combo box
	List<PmlEdmLevelSend> levelSends = PmlEdmLevelSendUtil.findAll();
	List<PmlEdmPrivilegeLevel> privLevels = PmlEdmPrivilegeLevelUtil.findAll();
	// phmphuc close 11/11/2010
	// List<PmlEdmDocumentType> docTypes = PmlEdmDocumentTypeUtil.findAll(); 
	// List<PmlEdmDocumentType> docTypes = PmlEdmDocumentTypeLocalServiceUtil.getDocType(1, 3);
	// end phmphuc update 11/11/2010
	
	/* phmphuc update 16/02/2011 - nhung loai so vb duoc tao so vb cua co quan thi moi duoc hien thi */
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
	int currentYear = calendar.get(Calendar.YEAR);

	long userIdLogin = PortalUtil.getUserId(renderRequest);
	PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userIdLogin);		
	Department department = null;
	try {
		department = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId());
	} catch (Exception e) { }
	
	List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = new ArrayList<PmlEdmDocumentRecordType>();
	if (department != null) {
		pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.getDocumentRecordTypeUseForAgency("vbden", department.getAgencyId(), currentYear);
	}
	
	List<Department> departments = DepartmentUtil.findAll(); 
%>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="tieu-thuc-tim-kiem"/></legend>
<table cellspacing="0" width="100%">
	<tr>
		<td width="13%"><liferay-ui:message key="pccc-cvdtn-soCVden" />&nbsp;:</td>
		<td width="37%"><input style="width: 94%" name="<portlet:namespace /><%= displayTerms.SONOIBO %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSoNoiBo()) %>" /></td>
		<td width="12%"><liferay-ui:message key="pccc-cvdtn-sohieu" />&nbsp;:</td>
		<td><input style="width: 94%" name="<portlet:namespace /><%= displayTerms.SOHIEUGOC %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSoHieuGoc()) %>" /></td>
	</tr>
	<tr>
		<td ><liferay-ui:message key="pccc-cvdtn-capgoi" />&nbsp;:</td>
		<td >
			<select name="<portlet:namespace /><%= displayTerms.CAPGUI %>" style="width: 96%;">
				<option value="0">&nbsp;</option>
				<%
				if (!levelSends.isEmpty()) {
					for (int idx = 0; idx < levelSends.size(); idx ++) {
						PmlEdmLevelSend lvSdItem = (PmlEdmLevelSend) levelSends.get(idx);
				%>
						<option value="<%= lvSdItem.getLevelSendId() %>" <%= (long) lvSdItem.getLevelSendId() == displayTerms.getCapGui() ? "selected" : ""%>><%= lvSdItem.getLevelSendName() %></option>
				<%
					}
				}
				%>
			</select>
		</td>
		<!-- <td><liferay-ui:message key="receipt.uutien" />&nbsp;:</td> -->
		 <td><liferay-ui:message key="pccc-cvdtn-dokhan"/>&nbsp;:</td>
		
		<td>
		<select name="<portlet:namespace /><%= displayTerms.UUTIEN %>" style="width: 96%;">
				<option value="">&nbsp;</option>
				<%
				if (!privLevels.isEmpty()) {
					for (int idx = 0; idx < privLevels.size(); idx ++) {
						PmlEdmPrivilegeLevel prLvItem = (PmlEdmPrivilegeLevel) privLevels.get(idx);
				%>
						<option value="<%= prLvItem.getPrivilegeLevelId() %>" <%= prLvItem.getPrivilegeLevelId().equals(displayTerms.getUuTien()) ? "selected" : ""%>><%= prLvItem.getPrivilegeLevelName() %></option>
				<%
					}
				}
				%>
			</select>
		</td>
	</tr>
	
	<tr>
		<td><liferay-ui:message key="department" />&nbsp;:</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.PHONGBAN %>" style="width: 96%;">
				<option value="">&nbsp;</option>
				<%
				if (!departments.isEmpty()) {
					for (int idx = 0; idx < departments.size(); idx ++) {
						Department depItem = (Department) departments.get(idx);
				%>
						<option value="<%= depItem.getDepartmentsId() %>" <%= depItem.getDepartmentsId().equals(displayTerms.getPhongBan()) ? "selected" : ""%>><%= depItem.getDepartmentsName() %></option>
				<%
					}
				}
				%>
			</select>			
		</td>
		<td><liferay-ui:message key="pccc-cvdtn-socongvan" />&nbsp;:</td>
		<td >
			<select name="<portlet:namespace /><%= displayTerms.LOAIVB %>" style="width: 96%;">
				<option value="0">&nbsp;</option>
				<%
				if (!pmlEdmDocumentRecordTypeList.isEmpty()) {
					for (int idx = 0; idx < pmlEdmDocumentRecordTypeList.size(); idx ++) {
						PmlEdmDocumentRecordType dTItem = (PmlEdmDocumentRecordType) pmlEdmDocumentRecordTypeList.get(idx);
				%>
						<option value="<%= dTItem.getDocumentRecordTypeId() %>" <%= dTItem.getDocumentRecordTypeId() == displayTerms.getLoaiVB() ? "selected" : ""%>><%= dTItem.getDocumentRecordTypeName() %></option>
				<%
					}
				}
				%>
			</select>
		</td>
	</tr>
	
	<tr>
		<td><liferay-ui:message key="ngay-phat-hanh" />&nbsp;:</td>
		<td>
			<div>
			<input name="<portlet:namespace /><%= displayTerms.NGAYPHDAY %>" type="text" value="<%= displayTerms.getNgayPHDay() != 0 ? String.valueOf(displayTerms.getNgayPHDay()) : "" %>" style="width: 15%" />
			<select name="<portlet:namespace /><%= displayTerms.NGAYPHMONTH %>" style="width: 15%;" >
				<option value="0">&nbsp;</option>
				<%
				for (int idx = 1; idx <= 12; idx ++) {
				%>
					<option value=<%= idx %> <%= displayTerms.getNgayPHMonth() == idx ? "selected" : "" %>>&nbsp;<%= idx %></option>
				<%
				}
				%>
			</select>
			<input name="<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>" type="text" value="<%= displayTerms.getNgayPHYear() != 0 ? String.valueOf(displayTerms.getNgayPHYear()) : "" %>" style="width: 30%;" />
			</div>
		</td>
		<td ><liferay-ui:message key="noi-phat-hanh" />&nbsp;:</td>
		<td><input name="<portlet:namespace /><%= displayTerms.NOIPHATHANH %>" id="noiphathanh" type="text" value="<%= HtmlUtil.escape(displayTerms.getNoiPhatHanh()) %>" style="width: 82%" />
			<input type="button" value="..." onclick="selPubPlace();" style="width: 10%"/></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="ngay-den" />&nbsp;:</td>
		<td>
			<div>
			<input name="<portlet:namespace /><%= displayTerms.NGAYDENDAY %>" type="text" value="<%= displayTerms.getNgayDenDay() != 0 ? String.valueOf(displayTerms.getNgayDenDay()) : "" %>" style="width: 15%;" />
			<select name="<portlet:namespace /><%= displayTerms.NGAYDENMONTH %>" style="width: 15%;">
				<option value="0">&nbsp;</option>
				<%
				for (int idx = 1; idx <= 12; idx ++) {
				%>
					<option value=<%= idx %> <%= displayTerms.getNgayDenMonth() == idx ? "selected" : "" %>>&nbsp;<%= idx %></option>
				<%
				}
				%>
			</select>
			<input name="<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>" type="text" value="<%= displayTerms.getNgayDenYear() != 0 ? String.valueOf(displayTerms.getNgayDenYear()) : String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) %>" style="width: 30%" />
			</div>
		</td>
		<td><liferay-ui:message key="trich-yeu" />&nbsp;:</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.TRICHYEU %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTrichYeu()) %>" style="width: 94%" />
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input style="margin-left: 0;" type="button" value='<liferay-ui:message key="search" />' onClick="<portlet:namespace />searchData();" />
			<input type="button" value='<liferay-ui:message key="pcccdocumentrecordto-inbaocao" />' onclick="<portlet:namespace />addActionFrom('word');<portlet:namespace />fm.submit();<portlet:namespace />setActionFrom();" />
			<input type="button" value='<liferay-ui:message key="pcccdocumentrecordto-xuatexcell" />' onclick="<portlet:namespace />addActionFrom('excel');<portlet:namespace />fm.submit();<portlet:namespace />setActionFrom();" />
		</td>
	</tr>
</table>
</fieldset>
<br>
<script type="text/javascript">
	function selPubPlace() { 
		// Chon don vi gui van ban den. Tra ve ten don vi
		var posX = screen.width / 7;
		var posY = screen.height / 5;
		var widthPopup = 3 * posX;
		var heightPopup = 3 * posY;
	  	var host = location.host;
	  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentrecordto/selpublicplace.jsp";
	  	var mywindow = window.open (path, "mywindow", "status=1,scrollbars=1,width=" + widthPopup + "px, height=" + heightPopup + "px");
	  
	  	mywindow.moveTo(posX , posY);
	}

	function retPubPlace (retVal) { 
		// Ham de popup tra ve gia tri duoc chon
		var obj = document.getElementById("noiphathanh");
		if (obj != null) {
			obj.value = retVal;
		} // end if
	}

	function <portlet:namespace />searchData() {
		// Kiem tra ngay phat hanh
		if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>.value != "") {
			if (isIntegerPositiveNumeric(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>.value)) {
				// Kiem tra thang
				if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHMONTH %>.selectedIndex == 0) {
					// Xoa ngay phat hanh
					document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHDAY %>.value = "";
				}
				else {
					// Kiem tra neu thanh phan ngay khong hop thi bao loi
					if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHDAY %>.value != "") {
						dPH = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHDAY %>.value;
						dPH = dPH.length == 1 ? "0" + dPH : dPH;
						mPH = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHMONTH %>.value;
						mPH = mPH.length == 1 ? "0" + mPH : mPH;
						if (!isDate(dPH + "/" + mPH + "/" + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>.value)) {
							alert("<liferay-ui:message key='vui-long-kiem-tra-ngay-nhap'/>");
							Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHDAY %>);
							return;
						}
					}
				}
			}
			else {
				alert("<liferay-ui:message key='vui-long-kiem-tra-ngay-nhap'/>");
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHYEAR %>);
				return;
			} 
		} // end if
		else {
			// Khi khong nhap nam thi bo gia tri cua ngay, thang
			document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHMONTH %>.selectedIndex = 0;
			document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYPHDAY %>.value = "";
		} 

		// Kiem tra ngay den
		if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>.value != "") {
			if (isIntegerPositiveNumeric(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>.value)) {
				// Kiem tra thang
				if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENMONTH %>.selectedIndex == 0) {
					// Xoa ngay phat hanh
					document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENDAY %>.value = "";
				}
				else {
					// Kiem tra neu thanh phan ngay khong hop thi bao loi
					if (document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENDAY %>.value != "") {
						dDN = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENDAY %>.value;
						dDN = dDN.length == 1 ? "0" + dDN : dDN;
						mDN = document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENMONTH %>.value;
						mDN = mDN.length == 1 ? "0" + mDN : mDN;
						if (!isDate(dDN + "/" + mDN + "/" + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>.value)) {
							alert("<liferay-ui:message key='vui-long-kiem-tra-ngay-nhap'/>");
							Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENDAY %>);
							return;
						}
					}
				}
			}
			else {
				alert("<liferay-ui:message key='vui-long-kiem-tra-ngay-nhap'/>");
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>);
				return;
			} 
		} // end if
		else {
			// Bat buoc phai nhap nam cua ngay den
			alert("<liferay-ui:message key='nam-cua-ngay-van-ban-den-bat-buoc-phai-nhap'/>");
			Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NGAYDENYEAR %>);
			return;
		}

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.SONOIBO %>);
	</c:if>
</script>