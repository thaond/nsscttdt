<%@ include file="/html/portlet/nss/loai_thu_tuc/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.loai_thu_tuc.search.LoaiThuTucHanhChinhSearch"%>
<%@page import="com.nss.portlet.loai_thu_tuc.search.LoaiThuTucHanhChinhDisplayTerms"%>

<%
	LoaiThuTucHanhChinhSearch searchContainer = (LoaiThuTucHanhChinhSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LoaiThuTucHanhChinhDisplayTerms displayTerms = (LoaiThuTucHanhChinhDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_loaivanban" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-loai-thu-tuc"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%=LoaiThuTucHanhChinhDisplayTerms.TEN_LOAI_THU_TUC %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenLoaiThuTucHanhChinh()) %>" />
			</td>
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=LoaiThuTucHanhChinhDisplayTerms.MO_TA %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit"  name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
