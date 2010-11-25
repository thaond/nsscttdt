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
	
	<table width="100%" border="0" class="common-table">
		<tr>
			<td>
			<label><liferay-ui:message key="ten-thu-tuc-hanh-chinh" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenThuTucHanhChinh" class="form-input-box" id="tenThuTucHanhChinh" value="<%= thuTucHanhChinh.getTenThuTucHanhChinh() %>"/></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="dia-chi-lien-he" /></label>
			</td>
			<td><input type="text" name="<portlet:namespace />diaChiLienHe" class="form-input-box" id="diaChiLienHe" value="<%= thuTucHanhChinh.getDiaChiLienHe() %>"/></td>
			<td>&nbsp;</td>
		</tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="linh-vuc" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
				<select name="<portlet:namespace />maLinhVucThuTuc" id="maLinhVucThuTuc" style="width: 18%;">
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
			<td></td>
		</tr>
	    <tr>
	    	<td class="minlabel"><label><liferay-ui:message key="co-quan-thuc-hien" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
	    		<div id="donViOnChange">
			    	<select name="<portlet:namespace />maDonViThuTuc" id='maDonViThuTuc' style="width: 18%;">
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
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active"  <%= thuTucHanhChinh.getActive() == 1 ? "checked=checked" : ""%>/></td>
			<td></td>
		</tr>
		<tr>
			<td>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<%
		if (!fileDinhKemList.isEmpty()) {
	%>
	
	<fieldset>
	<table id="recentFile" class="tab-doc-process-list-base">
		<tr style="height: 28px;" class="title-tran-header">
			<td width="5%" class="td-stt-pml"><div align="center"><liferay-ui:message key="stt"/></div></td>
			<td width="30%" class="td-stt-pml"><div style="padding-left: 10px"><liferay-ui:message key="tieu-de-tap-tin" /></div></td>
			<td width="40%" class="td-stt-pml"><div style="padding-left: 10px"><liferay-ui:message key="ten-tap-tin" /></div></td>
			<td width="10%" class="td-stt-pml"><div align="center"></div></td>
		</tr>
		<logic:iterate id="fileDinhKem" name="fileDinhKemList" indexId="i" type="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC" scope="request">
			<tr class="<%=(i % 2) == 0 ? "rowOne" : "rowTwo" %>">
				<td class="td-stt-pml"><div><%= ++i %></div></td>
			 	<td class="td-stt-pml-left"><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getTenFile() %></a></div></td>
			  	<td class="td-stt-pml-left"><div><a href="#" onclick="getHostName(this,'<%= fileDinhKem.getDuongDan() %>' )"><%= fileDinhKem.getDuongDan().substring(38) %></a></div></td>
			  	<td class="td-stt-pml"><input type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteRowFileUpload(this, '<%= fileDinhKem.getMaFileDinhKemTTHC() %>');" ></td>
			</tr>
		</logic:iterate>
	</table>
	</fieldset>
	<%
		} 
	%>
		
	<table>
	  <tr>
	    <td valign="top"><div align="right"></div></td>
	    <td colspan="3" align="center">
	    <fieldset>
			<legend class="legend-noborder"><liferay-ui:message key="toan-van"/></legend>
			<table id="addfileupload" style="width: 98%" align="center" cellpadding="0" cellspacing="0">
			  	<tr class="header-upload" align="center">
				  	<td width="30%" ><liferay-ui:message key="tieu-de-tap-tin" /></td>
				    <td width="50%" ><liferay-ui:message key="ten-tap-tin" /></td>
					<td width="20%" ><input type="button" value='<liferay-ui:message key="upload-file" />' onclick="uploadThuTucHanhChinhFile()"></td>
				</tr>
			</table>
		</fieldset>
	    </td>
	  </tr>
	</table>
	<table id="table-button">
		<tbody>
			<tr>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
		</tbody>
	</table>
	</div>
</form>
	