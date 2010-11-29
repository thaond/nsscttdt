<%@ include file="/html/portlet/nss/linh_vuc_thu_tuc/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.linh_vuc_thu_tuc.search.LinhVucThuTucHanhChinhSearch"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.search.LinhVucThuTucHanhChinhDisplayTerms"%>

<%
	LinhVucThuTucHanhChinhSearch searchContainer = (LinhVucThuTucHanhChinhSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LinhVucThuTucHanhChinhDisplayTerms displayTerms = (LinhVucThuTucHanhChinhDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_linhvucthutuc" >

<table cellspacing="0" width="100%">
		<tr>
			<td width="25%">
				<liferay-ui:message key="ten-linh-vuc-thu-tuc-hanh-chinh"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%=LinhVucThuTucHanhChinhDisplayTerms.TEN_LINH_VUC_THU_TUC %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenLinhVucThuTuc()) %>" />
			</td>
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=LinhVucThuTucHanhChinhDisplayTerms.MO_TA %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
