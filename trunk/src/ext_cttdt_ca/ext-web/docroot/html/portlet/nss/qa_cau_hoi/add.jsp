<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_cau_hoi.search.CauHoiQADisplayTerms"%>
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
<div class="leftmain_admin">
<div id="menuleft">	
<div class="nav-menu-style-1">	
<ul class="navlevel-1">
	    	<h2><liferay-ui:message key="chuyen-muc" /></h2>
	    	<%
	    		for (int i = 0; i < qAChuDeCauHoilList.size(); i ++) {
	    			QAChuDeCauHoi chuDeCauHoi = (QAChuDeCauHoi) qAChuDeCauHoilList.get(i);
	    	%>
		        <li><a href="<%= portletURL.toString() + "&" + renderResponse.getNamespace() + CauHoiQADisplayTerms.MA_CHU_DE_CAU_HOI + "=" + chuDeCauHoi.getMaChuDeCauHoi() %>"><%= chuDeCauHoi.getTenChuDeCauHoi() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
</div>
</div>  
<div class="centermain_admin" >  
<form action="<%= portletURL.toString() %>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onsubmit="return checkFormAddCauHoi();">
		<fieldset>
		<div class="titlecategr" style="margin-bottom: 15px;"><h4><p><liferay-ui:message key="gui-cau-hoi" /></p></h4></div>
		<table width="100%" cellspacing="0">
		
			<tr>
				<td width="20%"><label><liferay-ui:message key="tieu-de-cau-hoi" /></label>
				<span style="color: rgb(255, 0, 0);"> *</span>:
				</td>
				<td><input type="text" name="<portlet:namespace />tieuDeCauHoi" style="width: 90%" id="tieuDeCauHoi" /></td>
			</tr>
			
			
		    <tr>
		    	<td ><label><liferay-ui:message key="nguoi-hoi" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>:
		    	</td>
				<td><input type="text" name="<portlet:namespace />tenNguoiHoi" style="width: 90%" id="tenNguoiHoi" /></td>
		    </tr>
		    
			
		    <tr>
		    	<td ><label><liferay-ui:message key="Email" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>:
		    	</td>
				<td><input type="text" name="<portlet:namespace />email" style="width: 90%" id="email" onblur="validateEmail(this)"/></td>
		    </tr>
		    
		    
		    <tr>
		    	<td ><label><liferay-ui:message key="chu-de-cau-hoi" /></label>
		    	<span style="color: rgb(255, 0, 0);"> *</span>:
		    	</td>
			    <td align="left">
			   		 <select name="<portlet:namespace />maChuDeCauHoi" id="maChuDeCauHoi" style="width: 92%;">
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
					<span style="color: rgb(255, 0, 0);"> *</span>:
				</td>
				<td><textarea name="<portlet:namespace />noiDung" style="width: 90%" id="noiDung" rows="3" ></textarea></td>
			</tr>
			
		    
			<tr>
				<td>
					<label><liferay-ui:message key="tap-tin-dinh-kem" /></label>:
				</td>
				<td>
					<input type="file" name="<portlet:namespace />file" style="width: 90%" id="file" onchange="getFileName(this.value)" /></td>
					<input type="hidden" name="<portlet:namespace />fileName" id="fileName"> 
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
		</fieldset>
	</form>
</div>