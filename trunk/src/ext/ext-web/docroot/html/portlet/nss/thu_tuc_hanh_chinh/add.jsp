<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/thu_tuc_hanh_chinh/js/thutuchanhchinh-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	int radioCapDonVi = ParamUtil.getInteger(renderRequest,"radioCapDonVi", 1);
	List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList") == null ? new ArrayList<LinhVucThuTucHanhChinh>() : (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList"); 

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="return <portlet:namespace />validateFormThuTucHanhChinh()">
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>radioCapDV" id="<portlet:namespace/>radioCapDV" value="" />
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
		
	<table width="100%" border="0" class="common-table">
		<tr>
			<td>
			<label><liferay-ui:message key="ten-thu-tuc-hanh-chinh" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenThuTucHanhChinh" class="form-input-box" id="tenThuTucHanhChinh" value=""/></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="dia-chi-lien-he" /></label>
			</td>
			<td><input type="text" name="<portlet:namespace />diaChiLienHe" class="form-input-box" id="diaChiLienHe" value=""/></td>
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
					%>
						<option value="<%= linhVucThuTucHanhChinh.getMaLinhVucThuTucHanhChinh() %>" > <%= linhVucThuTucHanhChinh.getTenLinhVucThuTucHanhChinh() %> </option>
					<%
						}
					%>
		    	</select>
		    </td>
	    </tr>
		<tr >
			<td></td>
			<td colspan="3">
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= radioCapDonVi == 1 ? "checked" : "" %> value="1"/><liferay-ui:message key="cap-thanh-pho" />&nbsp;
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= radioCapDonVi == 2 ? "checked" : "" %> value="2"/><liferay-ui:message key="cap-quan-huyen" />&nbsp;
				<input onclick="selectRadioCapDonVi(this.value)" name="<portlet:namespace />capDonVi" type="radio" id="capDonVi" <%= radioCapDonVi == 3 ? "checked" : "" %> value="3"/><liferay-ui:message key="cap-phuong-xa" />&nbsp;
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
						<option value="0"><liferay-ui:message key="khong-chon" /></option>
						<%
							if (1 == radioCapDonVi) {
								List<DonViThuTuc> capThanhPhoList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(1, 1);
								for (int i = 0; i < capThanhPhoList.size(); i ++) {
									DonViThuTuc donViThuTuc = (DonViThuTuc) capThanhPhoList.get(i);
						%>
							<option value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							
						%>
			    	</select>
		    	</div>
			    	
		    </td>
	    </tr>
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
			<td></td>
		</tr>
	   
	</table>
	<table style="width:100%">
	  <tr>
	    <td valign="top"><div align="right"></div></td>
	    <td colspan="3" align="center">
	    <fieldset>
			<legend class="legend-noborder"><liferay-ui:message key="toan-van"/></legend>
			<table id="addfileupload" style="width: 98%" align="center" cellpadding="0" cellspacing="0">
			  <tr class="bgtitlecvddetails" align="center">
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
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
		</tbody>
	</table>
	</div>
</form>
	