<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pmluser/view");
%>
<%@page import="com.sgs.portlet.pmluser.search.PmlUserSearch"%>
<%@page import="com.sgs.portlet.pmluser.search.PmlUserDisplayTerms"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%><script type="text/javascript">
	function searchPmlUser(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	PmlUserSearch pmlUserSearch = (PmlUserSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PmlUserDisplayTerms displayTerms = (PmlUserDisplayTerms) pmlUserSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_pmluser" >
	<table class="pmluser-table" cellspacing="0" width="100%">
			<tr>
			<td width="7%" align="right"><liferay-ui:message key="ho" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=displayTerms.HO %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getHo()) %>" />
			</td>
			
			<td width="8%" align="right"><liferay-ui:message key="middle-name" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=displayTerms.LOT %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getLot()) %>" />
			</td>
			
			<td width="3%" align="right"><liferay-ui:message key="ten" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%= displayTerms.TEN %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
		</tr>
		<tr>
			<td align="right"><liferay-ui:message key="screen-name" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=displayTerms.TEN_GOI %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenGoi()) %>" />
			</td>
			
			<td align="right"><liferay-ui:message key="receipt.position" />:&nbsp;</td>
			<td colspan="3">
				<%-- xuancong close
				<input name="<portlet:namespace/><%=displayTerms.CHUC_VU %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getChucVu()) %>" />
				--%>
				<select name="<portlet:namespace/><%= displayTerms.CHUC_VU %>" style="width: 95%">
					<option value="">&nbsp;</option>
					<%
					List<Position> positions = PositionUtil.findAll();
					if (positions != null && !positions.isEmpty()) {
						for (int i = 0; i < positions.size(); i ++) {
							Position posItem = (Position) positions.get(i);
							String selected = (posItem.getPositionId().equalsIgnoreCase(displayTerms.getChucVu()) ? "selected" : "");
							out.print("<option value=\"" + posItem.getPositionId() + "\" " + selected + ">" + posItem.getPositionName() + "</option>");
						}
					}
					%>
				</select>
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" onclick="searchPmlUser('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
