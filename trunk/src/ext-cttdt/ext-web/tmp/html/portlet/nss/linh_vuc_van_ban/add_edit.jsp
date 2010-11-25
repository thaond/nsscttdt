<%@ include file="/html/portlet/nss/linh_vuc_van_ban/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>

<liferay-util:include page="/html/portlet/nss/linh_vuc_van_ban/js/linhvucvanban-js.jsp"></liferay-util:include>
<%
	LinhVucVanBan linhVucVanBan = (LinhVucVanBan) renderRequest.getAttribute("linhVucVanBan");
	List<LinhVucVanBan> linhVucVanBanListParent = (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVanBanListParent") == null ? 
											new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>) renderRequest.getAttribute("linhVucVanBanListParent");
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/linh_vuc_van_ban/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkFromLinhVucVanBan();"
	name="<portlet:namespace />fm" >
 	<div class="commom-form">
	<input type="hidden" name="checkParentId" id="checkParentId">
	 <%
 		if (Validator.isNull(linhVucVanBan)) {
 	%>
 	<input type="hidden" name="tabs" id="tabs" value="add">
	<div class="parent-title"><liferay-ui:message key="them-moi"/></div>
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-linh-vuc-van-ban" /></label>
			<span style="color: rgb(255, 0, 0);"> *</span>
			</td>
			<td><input type="text" name="<portlet:namespace />tenLinhVucVanBan" class="input-pml" id="<portlet:namespace/>tenLinhVucVanBan" /></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
	    	<td ><label><liferay-ui:message key="linh-vuc-van-ban" /></label>
	    	<span style="color: rgb(255, 0, 0);"> *</span>
	    	</td>
		    <td align="left">
				<select name="<portlet:namespace />parentId" id="<portlet:namespace/>parentId" style="width: 71%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < linhVucVanBanListParent.size(); i ++) {
							LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVanBanListParent.get(i);
							out.println("<option value=\"" + String.valueOf(linhVucVB.getMaLinhVucVanBan()) + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" class="input-pml" id="description" cols="45" rows="5"></textarea></td>
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
 	<input type="hidden" name="tabs" id="tabs" value="edit">
 	<input type="hidden" name="<portlet:namespace />maLinhVucVanBan" id="<portlet:namespace />maLinhVucVanBan" value="<%=  linhVucVanBan.getMaLinhVucVanBan()%>">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
 	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ten-linh-vuc-van-ban" /></label>
			</td>
			<td><input type="text" name="<portlet:namespace />tenLinhVucVanBan" class="input-pml" id="<portlet:namespace/>tenLinhVucVanBan" value="<%= linhVucVanBan.getTenLinhVucVanBan()%>" /></td>
			<td>&nbsp;</td>
		</tr>
	    
	    <tr>
	    	<td ><label><liferay-ui:message key="linh-vuc-van-ban" /></label></td>
		    <td align="left">
				<select name="<portlet:namespace />parentId" id="<portlet:namespace/>parentId" style="width: 71%;">
		    		<option value="0"><liferay-ui:message key="khong-chon" /></option>
					<%
						for (int i = 0; i < linhVucVanBanListParent.size(); i ++) {
							LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVanBanListParent.get(i);
							String selDesc = ( linhVucVanBan.getParentid() == linhVucVB.getMaLinhVucVanBan() ? "selected" : "" );
							out.println("<option " + selDesc + " value=\"" + String.valueOf(linhVucVB.getMaLinhVucVanBan()) + "\">" + linhVucVB.getTenLinhVucVanBan() + "</option>");
						}
					%>
		    	</select>
		    </td>
	    </tr>
	    
		<tr>
			<td>
			<label><liferay-ui:message key="description" /></label>
			</td>
			<td><textarea name="<portlet:namespace />description" id="description" ><%= linhVucVanBan.getDescription() %></textarea></td>
			<td>&nbsp;</td>
		</tr>
	      
		<tr>
			<td>
			<label><liferay-ui:message key="active" /></label>
			</td>
			<td><input name="<portlet:namespace />active" type="checkbox" id="active" 
				<%= linhVucVanBan.getActive() == 1 ? "checked=checked" : ""%> /></td>
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
 