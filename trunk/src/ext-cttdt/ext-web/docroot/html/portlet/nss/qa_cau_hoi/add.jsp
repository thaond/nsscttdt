<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>

<liferay-util:include page="/html/portlet/nss/qa_cau_hoi/js/qacauhoi-js.jsp"></liferay-util:include>

<%
	String redirect = renderRequest.getParameter("redirect");
	List<QAChuDeCauHoi> qAChuDeCauHoilList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList") == null ? new ArrayList<QAChuDeCauHoi>() 
			: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoilList");
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/qa_cau_hoi/view");
	portletURL.setParameter("redirect", redirect);
%>

    <form action="<%= portletURL.toString() %>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onsubmit="return checkFormAddCauHoi();">
		<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="gui-cau-hoi" /></div>
		<table width="100%" border="0" class="common-table">
		
			<tr>
				<td><label><liferay-ui:message key="tieu-de-cau-hoi" /></label>
				<span style="color: rgb(255, 0, 0);"> *</span>
				</td>
				<td><input type="text" name="<portlet:namespace />tieuDeCauHoi" class="form-input-box" id="tieuDeCauHoi" /></td>
				<td>&nbsp;</td>
			</tr>
			
			
		    <tr>
		    	<td ><label><liferay-ui:message key="nguoi-hoi" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>
		    	</td>
				<td><input type="text" name="<portlet:namespace />tenNguoiHoi" class="form-input-box" id="tenNguoiHoi" /></td>
				<td>&nbsp;</td>
		    </tr>
		    
			
		    <tr>
		    	<td ><label><liferay-ui:message key="Email" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>
		    	</td>
				<td><input type="text" name="<portlet:namespace />email" class="form-input-box" id="email" onblur="validateEmail(this)"/></td>
				<td>&nbsp;</td>
		    </tr>
		    
		    
		    <tr>
		    	<td ><label><liferay-ui:message key="chu-de-cau-hoi" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>
		    	</td>
			    <td align="left">
			   		 <select name="<portlet:namespace />maChuDeCauHoi" id="maChuDeCauHoi" style="width: 24%;">
			    		<option value="0"><liferay-ui:message key="chon-chu-de" /></option>
						<%
							for (int i = 0; i < qAChuDeCauHoilList.size(); i ++) {
								QAChuDeCauHoi chuDeCauHoi = (QAChuDeCauHoi) qAChuDeCauHoilList.get(i);
						%>
						<option value="<%= chuDeCauHoi.getMaChuDeCauHoi() %>" ><%= chuDeCauHoi.getTenChuDeCauHoi() %></option>
						<%
							}
						%>
			    	</select>
			    </td>
		    </tr>
		    
		    
			<tr>
				<td>
					<label><liferay-ui:message key="noi-dung" /></label>
					<span style="color: rgb(255, 0, 0);"> *</span>
				</td>
				<td><textarea name="<portlet:namespace />noiDung" class="form-input-box" id="noiDung" cols="45" rows="5" ></textarea></td>
				<td>&nbsp;</td>
			</tr>
			
		    
			<tr>
				<td>
					<label><liferay-ui:message key="tap-tin-dinh-kem" /></label>
				</td>
				<td>
					<input type="file" name="<portlet:namespace />file" class="form-input-box" id="file" onchange="getFileName(this.value)" /></td>
					<input type="hidden" name="<portlet:namespace />fileName" id="fileName"> 
				<td>&nbsp;</td>
			</tr>
			
		    
			<tr>
				<td>
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<br/>
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
		</div>
	</form>
