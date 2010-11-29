<%@ include file="/html/portlet/nss/qa_cau_tra_loi/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiSearch"%>
<%@page import="com.nss.portlet.qa_cau_tra_loi.searchCauHoi.QACauHoiDisplayTerms"%>

<%
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
												: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	QACauHoiSearch cauHoiSearch = (QACauHoiSearch)renderRequest.getAttribute("liferay-ui:search:searchContainer");
	QACauHoiDisplayTerms displayTerms = (QACauHoiDisplayTerms)cauHoiSearch.getDisplayTerms();
%>

<table class="vanbanphapquy-table" width="100%" cellspacing="0">
		<tr>
			<td width="15%"><liferay-ui:message key="chu-de-cau-hoi" />:&nbsp;</td>
			<td >
				<select name="<portlet:namespace /><%= QACauHoiDisplayTerms.MA_CHU_DE_CAU_HOI%>" id="select2" style="width: 50%;">
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
				<input name="<portlet:namespace/><%= QACauHoiDisplayTerms.TIEU_DE_CAU_HOI %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTieuDeCauHoi()) %>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/></td>
		</tr>
	</table>	
	<br><br>
	
