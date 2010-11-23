<%@ include file="/html/portlet/nss/loai_thu_tuc/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>



<%@page import="com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh"%><liferay-util:include page="/html/portlet/nss/loai_thu_tuc/js/loaithutuchanhchinh-js.jsp"></liferay-util:include>

<%
	LoaiThuTucHanhChinh loaiThuTucHanhChinh = (LoaiThuTucHanhChinh)renderRequest.getAttribute("loaiThuTucHanhChinh");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/loai_thu_tuc/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromLoaiThuTucHanhChinh();" name="<portlet:namespace />fm" class="table-border-pml">
 	<input type="hidden" name="<portlet:namespace />maLoaiThuTucHanhChinh" value="<%=  loaiThuTucHanhChinh.getMaLoaiThuTucHanhChinh()%>">
 	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
	
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-loai-thu-tuc" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenLoaiThuTucHanhChinh" class="form-input-box" id="<portlet:namespace/>tenLoaiThuTucHanhChinh" value="<%= loaiThuTucHanhChinh.getTenLoaiThuTucHanhChinh()%>" /></td>
			<td>&nbsp;</td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" cols="45" rows="4"><%= loaiThuTucHanhChinh.getDescription() %></textarea></td>
			<td>&nbsp;</td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= loaiThuTucHanhChinh.getActive() == 1 ? "checked=checked" : ""%> /></td>
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
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
    				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 		</td>
			</tr>
		</tbody>
	</table>
	</div>
 </form>