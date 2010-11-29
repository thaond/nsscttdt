<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQASearch"%>
<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
	CauHoiQASearch cauHoiQASearch = (CauHoiQASearch)renderRequest.getAttribute("liferay-ui:search:searchContainer");
	CauHoiQADisplayTerms displayTerms = (CauHoiQADisplayTerms)cauHoiQASearch.getDisplayTerms();
%>

<table class="vanbanphapquy-table" width="100%" cellspacing="0">
		<tr>
			<td width="20%"><liferay-ui:message key="chu-de-cau-hoi" />:&nbsp;</td>
			<td>
				<select name="<portlet:namespace /><%= CauHoiQADisplayTerms.MA_CHU_DE_CAU_HOI%>" id="select2" style="width: 30%;">
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
		<tr>
			<td><liferay-ui:message key="tieu-de-cau-hoi" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%= CauHoiQADisplayTerms.TIEU_DE_CAU_HOI %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTieuDeCauHoi()) %>" />
			</td>
		</tr>
</table>	
<br>
<input style="margin-left: 15.5%" type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
