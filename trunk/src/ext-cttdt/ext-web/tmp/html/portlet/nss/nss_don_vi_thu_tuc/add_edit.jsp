<%@ include file="/html/portlet/nss/nss_don_vi_thu_tuc/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>

<liferay-util:include page="/html/portlet/nss/nss_don_vi_thu_tuc/js/donvithutuc-js.jsp"></liferay-util:include>

<%
	DonViThuTuc donViThuTuc = (DonViThuTuc) renderRequest.getAttribute("donViThuTuc");
	String capDonVi = "";
	if (null != donViThuTuc) {
		if (donViThuTuc.getCapDonVi() == 1){
			capDonVi = "C\u1ea5p Th\u00e0nh Ph\u1ed1";
		}
		else if (donViThuTuc.getCapDonVi() == 2){
			capDonVi = "C\u1ea5p Qu\u1eadn/ Huy\u1ec7n/ Th\u1ecb x\u00e3";
		}
		else {
			capDonVi = "C\u1ea5p X\u00e3/ Ph\u01b0\u1eddng/ Th\u1ecb tr\u1ea5n";
		}
	}
	
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromDonViThuTuc();"
	name="<portlet:namespace />fm" class="table-border-pml">
	<div class="commom-form">
	<%
 		if (Validator.isNull(donViThuTuc)) {
 	%>
 	
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-don-vi-thu-tuc" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" size="40px" name="<portlet:namespace />tenDonViThuTuc" class="form-input-box" id="<portlet:namespace/>tenDonViThuTuc" /></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
			<td>
			<label><liferay-ui:message key="cap-don-vi-thu-tuc" /></label>
			</td>
			<td>
				<select name="<portlet:namespace />capDonVi" id="capDonVi" style="width: 29%;">
					<option value="1" ><liferay-ui:message key="cap-thanh-pho" /></option>
					<option value="2" ><liferay-ui:message key="cap-quan-huyen" /></option>
					<option value="3" ><liferay-ui:message key="cap-phuong-xa" /></option>
		    	</select>
			</td>			
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" class="form-input-box" id="description" cols="45" rows="4"></textarea></td>
			<td>&nbsp;</td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
			<td></td>
		</tr>
	     
		<tr>
			<td>
			</td>
			<td></td>
			<td></td>
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
 	<%
 		} else {
 	%>
 	<input type="hidden" name="<portlet:namespace />maDonViThuTuc" value="<%= donViThuTuc.getMaDonViThuTuc()%>">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-don-vi-thu-tuc" /></label>
			</td>
			<td><input type="text" name="<portlet:namespace />tenDonViThuTuc" class="form-input-box" id="<portlet:namespace/>tenDonViThuTuc" value="<%= donViThuTuc.getTenDonViThuTuc()%>" /></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="cap-don-vi-thu-tuc" /></label>
			</td>
			<td>
				<select name="<portlet:namespace />capDonVi" id="capDonVi" style="width: 29%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<option value="1" <%= donViThuTuc.getCapDonVi() == 1 ? "selected" : "" %>><liferay-ui:message key="cap-thanh-pho" /></option>
					<option value="2" <%= donViThuTuc.getCapDonVi() == 2 ? "selected" : "" %>><liferay-ui:message key="cap-quan-huyen" /></option>
					<option value="3" <%= donViThuTuc.getCapDonVi() == 3 ? "selected" : "" %>><liferay-ui:message key="cap-phuong-xa" /></option>
		    	</select>
			</td>			
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" cols="45" rows="4"><%= donViThuTuc.getDescription() %></textarea></td>
			<td>&nbsp;</td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= donViThuTuc.getActive() == 1 ? "checked=checked" : ""%> /></td>
			<td></td>
		</tr>
	     
		<tr>
			<td>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<table id="table-button">
		<tbody>
			<tr>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
					<input type="submit" class="button"	name="button" id="button" value='<liferay-ui:message key="update" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' /></a>
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 		</td>
			</tr>
		</tbody>
	</table>
 	<%
 		}
 	%>
 	</div>
 </form>
 