<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQASearch"%>

<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
												: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	CauHoiQASearch cauHoiQASearch = (CauHoiQASearch)renderRequest.getAttribute("liferay-ui:search:searchContainer");
	CauHoiQADisplayTerms displayTerms = (CauHoiQADisplayTerms)cauHoiQASearch.getDisplayTerms();
%>

<table class="vanbanphapquy-table">
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="chu-de-cau-hoi" />:&nbsp;</td>
			<td align="left">
				<select name="<portlet:namespace /><%= displayTerms.MA_CHU_DE_CAU_HOI%>" id="select2" style="width: 89%;">
		    		<option <%=(displayTerms.getMaChuDeCauHoi() == 0  ? "selected" : "" )%> value="0"><liferay-ui:message key="chon-chu-de" /></option>
					<%
						if (!qAChuDeCauHoilList.isEmpty()) { 
							for (int i = 0; i < qAChuDeCauHoilList.size(); i ++) {
								QAChuDeCauHoi chuDeCauHoi = (QAChuDeCauHoi) qAChuDeCauHoilList.get(i);
								String select = (displayTerms.getMaChuDeCauHoi() == chuDeCauHoi.getMaChuDeCauHoi() ? "selected" : "" );
					%>
								<option <%= select %>  value="<%= chuDeCauHoi.getMaChuDeCauHoi() %>" > <%= chuDeCauHoi.getTenChuDeCauHoi() %> </option>
					<%
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		
		<tr height="10"></tr>
		<tr>
			<td align="right"><liferay-ui:message key="tieu-de-cau-hoi" />:&nbsp;</td>
			<td align="left">
				<input name="<portlet:namespace/><%= displayTerms.TIEU_DE_CAU_HOI %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTieuDeCauHoi()) %>" />
			</td>
		</tr>
	</table>	
<br/>
<div style="padding-top: 5px;padding-bottom: 10px;">
	<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
</div>