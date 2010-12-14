<%@ include file="/html/portlet/nss/linh_vuc_thu_tuc/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>
<%@page import="com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh"%>
<%@page import="com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalServiceUtil"%><liferay-util:include page="/html/portlet/nss/linh_vuc_thu_tuc/js/linhvucthutuc-js.jsp"></liferay-util:include>
<%
	List<LoaiThuTucHanhChinh> loaiThuTucHanhChinhList = LoaiThuTucHanhChinhLocalServiceUtil.findByActive(1);
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromLinhVucThuTucHanhChinh();"
	name="<portlet:namespace />fm" class="table-border-pml">
 	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
			<label><liferay-ui:message key="ten-linh-vuc-thu-tuc-hanh-chinh" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td><input type="text"  name="<portlet:namespace />tenLinhVucThuTucHanhChinh" style="width: 90%;" id="<portlet:namespace/>tenLinhVucThuTucHanhChinh" /></td>
		</tr>
		
		<tr>
			<td><label><liferay-ui:message key="ten-loai-thu-tuc" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>:
			</td>
			<td >
				<select name="<portlet:namespace />loaiLinhVucId" id="loaiLinhVucId" style="width: 92%;">
				<%
					for (int idx = 0; idx < (loaiThuTucHanhChinhList == null ? 0 : loaiThuTucHanhChinhList.size()); idx ++) {
						LoaiThuTucHanhChinh loaiThuTucHanhChinh = (LoaiThuTucHanhChinh) loaiThuTucHanhChinhList.get(idx);
					%>
						<option value="<%= loaiThuTucHanhChinh.getPrimaryKey() %>"> <%= loaiThuTucHanhChinh.getTenLoaiThuTucHanhChinh() %></option>
					<%
					}
				%>
						
				</select>
			</td>
		</tr>
		
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>:
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" style="width: 90%;" rows="3"></textarea></td>
		</tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>:
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked"/></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
					<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
					<input type="reset" class="button" value='<liferay-ui:message key="cancel" />' />
	    			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 	</td>
			</tr>
	</table>
 	</div>
 </form>
 