<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/thu_tuc_hanh_chinh/js/thutuchanhchinh-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh)renderRequest.getAttribute("thuTucHanhChinh");
	List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList") == null ? new ArrayList<LinhVucThuTucHanhChinh>() : (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList"); 
	List<FileDinhKemTTHC> fileDinhKemList = (List<FileDinhKemTTHC>)renderRequest.getAttribute("fileDinhKemList") == null ? new ArrayList<FileDinhKemTTHC>() : (List<FileDinhKemTTHC>)renderRequest.getAttribute("fileDinhKemList");

	DonViThuTuc donVi = null;
	if (null != thuTucHanhChinh) {
		donVi = DonViThuTucLocalServiceUtil.getDonViThuTuc(thuTucHanhChinh.getMaDonViThuTucHanhChinh());
	}
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh/view" );
	portletURL.setParameter("redirect", redirect);

%>


<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="return <portlet:namespace />validateFormThuTucHanhChinh()">
	<input type="hidden" name="<portlet:namespace/>maThuTucHanhChinh" id="maThuTucHanhChinh" value="<%= thuTucHanhChinh.getMaThuTucHanhChinh() %>" />
	<input type="hidden" name="<portlet:namespace/>str_filethutuchanhchinhtodelete" id="str_filethutuchanhchinhtodelete" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>radioCapDV" id="<portlet:namespace/>radioCapDV" value="" />
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
	<table width="100%" cellspacing="0">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ten-thu-tuc-hanh-chinh" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text" name="<portlet:namespace />tenThuTucHanhChinh" style="width: 90%" id="tenThuTucHanhChinh" value="<%= thuTucHanhChinh.getTenThuTucHanhChinh() %>"/></td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="dia-chi-lien-he" /></label>:
			</td>
			<td><input type="text" name="<portlet:namespace />diaChiLienHe" style="width: 90%" id="diaChiLienHe" value="<%= thuTucHanhChinh.getDiaChiLienHe() %>"/></td>
		</tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="linh-vuc" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>:
	    	</td>
		    <td align="left">
				<select name="<portlet:namespace />maLinhVucThuTuc" id="maLinhVucThuTuc" style="width: 92%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < linhVucThuTucHanhChinhList.size(); i ++) {
							LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) linhVucThuTucHanhChinhList.get(i);
							String selected = thuTucHanhChinh.getMaLinhVucThuTucHanhChinh() == linhVucThuTucHanhChinh.getMaLinhVucThuTucHanhChinh() ? "selected" : "";
					%>
						<option <%= selected %>  value="<%= linhVucThuTucHanhChinh.getMaLinhVucThuTucHanhChinh() %>" > <%= linhVucThuTucHanhChinh.getTenLinhVucThuTucHanhChinh() %> </option>
					<%
						}
					%>
		    	</select>
		    </td>
	    </tr>
		<tr >
			<td></td>
			<td colspan="6">
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= donVi.getCapDonVi() == 1 ? "checked" : "" %> value="1"/><liferay-ui:message key="cap-thanh-pho" />&nbsp;
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= donVi.getCapDonVi() == 2 ? "checked" : "" %> value="2"/><liferay-ui:message key="cap-quan-huyen" />&nbsp;
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= donVi.getCapDonVi() == 3 ? "checked" : "" %> value="3"/><liferay-ui:message key="cap-phuong-xa" />&nbsp;
			</td>
		</tr>
	    <tr>
	    	<td ><label><liferay-ui:message key="co-quan-thuc-hien" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>:
	    	</td>
		    <td >
	    		<div id="donViOnChange">
			    	<select name="<portlet:namespace />maDonViThuTuc" id='maDonViThuTuc' style="width: 92%;">
						<%
							if (1 == donVi.getCapDonVi()) {
								List<DonViThuTuc> capThanhPhoList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(1, 1);
								for (int i = 0; i < capThanhPhoList.size(); i ++) {
									DonViThuTuc donViThuTuc = (DonViThuTuc) capThanhPhoList.get(i);
									String selected = thuTucHanhChinh.getMaDonViThuTucHanhChinh() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "";
						%>
							<option <%= selected %> value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							else if (2 == donVi.getCapDonVi()) {
								List<DonViThuTuc> capQuanHuyenList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(2, 1);
								for (int i = 0; i < capQuanHuyenList.size(); i ++) {
								DonViThuTuc donViThuTuc = (DonViThuTuc) capQuanHuyenList.get(i);
								String selected = thuTucHanhChinh.getMaDonViThuTucHanhChinh() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "";
						%>
							<option value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							else {
								List<DonViThuTuc> capPhuongXaList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(3, 1);
								for (int i = 0; i < capPhuongXaList.size(); i ++) {
								DonViThuTuc donViThuTuc = (DonViThuTuc) capPhuongXaList.get(i);
								String selected = thuTucHanhChinh.getMaDonViThuTucHanhChinh() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "";
						%>
							<option <%= selected %> value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
						%>
			    	</select>
		    	</div>
		    </td>
	    </tr>
		<tr >
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active"  <%= thuTucHanhChinh.getActive() == 1 ? "checked=checked" : ""%>/></td>
			<td></td>
		</tr>
	</table>
	<%
		if (!fileDinhKemList.isEmpty()) {
	%>
<br>

<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="tap-tin-dinh-kem"/></label>
<div class="results-grid">
	<table id="recentFile" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
			<td width="35px"><div align="center"><liferay-ui:message key="stt"/></div></td>
			<td width="30%"><div style="padding-left: 10px"><liferay-ui:message key="tieu-de-tap-tin" /></div></td>
			<td width="40%"><div style="padding-left: 10px"><liferay-ui:message key="ten-tap-tin" /></div></td>
			<td ><div align="center"></div></td>
		</tr>
		<logic:iterate id="fileDinhKem" name="fileDinhKemList" indexId="i" type="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC" scope="request">
			<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>">
				<td align="center"><div><%= ++i %></div></td>
			 	<td><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getTenFile() %></a></div></td>
			  	<td><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getDuongDan().substring(38) %></a></div></td>
			  	<td align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteRowFileUpload(this, '<%= fileDinhKem.getMaFileDinhKemTTHC() %>');" ></td>
			</tr>
		</logic:iterate>
	</table>
</div>	
</fieldset>
	
	<%
		} 
	%>
		
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="toan-van"/></label>
<div class="results-grid">
	<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
				  	<td width="35%" ><liferay-ui:message key="tieu-de-tap-tin" /></td>
				    <td width="50%" ><liferay-ui:message key="ten-tap-tin" /></td>
					<td align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="upload-file" />' onclick="uploadThuTucHanhChinhFile()"></td>
		</tr>
	</table>
</div>
</fieldset>
<br/>

<div id ="table-button" align="right">
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
</div>
</div>
</form>
	