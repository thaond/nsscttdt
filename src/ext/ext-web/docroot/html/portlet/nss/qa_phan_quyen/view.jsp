<%@ include file="/html/portlet/nss/qa_phan_quyen/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"%>
<%@page import="com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-util:include page="/html/portlet/nss/qa_phan_quyen/js/qaphanquyen_js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/qa_phan_quyen/view");
	portletURL.setParameter(Constants.CMD,Constants.ADD );

	long maChuDeCauHoi = (Long)renderRequest.getAttribute("maChuDeCauHoi") == null ? 0 : (Long)renderRequest.getAttribute("maChuDeCauHoi");
	List<QAChuDeCauHoi> qAChuDeCauHoiList = (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoiList") == null ? new ArrayList<QAChuDeCauHoi>()
				: (List<QAChuDeCauHoi>)renderRequest.getAttribute("qAChuDeCauHoiList");
	List<User> userList = (List<User>)renderRequest.getAttribute("userList") == null ? new ArrayList<User>()
			: (List<User>)renderRequest.getAttribute("userList");
	List<QAPhanQuyen> qAPhanQuyenList = (List<QAPhanQuyen>)renderRequest.getAttribute("qAPhanQuyenList") == null ? new ArrayList<QAPhanQuyen>()
			: (List<QAPhanQuyen>)renderRequest.getAttribute("qAPhanQuyenList");
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onsubmit="return checkMaChuDeCauHoiSelected();">
	<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="nss-qa-phan-quyen" /></div>
		<table class="common-table">
			<tr>
				<td>
					<%
						PortletURL chuDeURL = renderResponse.createActionURL();
						chuDeURL.setWindowState(WindowState.NORMAL);
						chuDeURL.setParameter("struts_action","/nss/qa_phan_quyen/view");
						chuDeURL.setParameter(Constants.CMD, Constants.VIEW);
					%>
					<select name="<portlet:namespace />maChuDeCauHoi" id="maChuDeCauHoi" onchange="reloadPhanQuyen('<%= chuDeURL.toString() %>')">
					<option value="0" <%=  maChuDeCauHoi == 0 ? "" : "selected=selected" %>><liferay-ui:message key="chon-chu-de" /></option>
					<%
						for (int i = 0 ; i < qAChuDeCauHoiList.size(); i++) {
							QAChuDeCauHoi chuDeCauHoi = qAChuDeCauHoiList.get(i);
					%>
						<option value="<%= chuDeCauHoi.getMaChuDeCauHoi() %>" <%=  maChuDeCauHoi == chuDeCauHoi.getMaChuDeCauHoi() ? "selected=selected" : ""%>> <%= chuDeCauHoi.getTenChuDeCauHoi() %></option>
					<%
						}
					%>
					</select>
				</td>
			</tr>
		</table>
		<table class="common-table">
			<tr>
				<td>
				</td>
				<td  align="center">
					<liferay-ui:message key="Xem" />
				</td>
				<td  align="center">
					<liferay-ui:message key="cap-nhat" />
				</td>
				<td  align="center">
					<liferay-ui:message key="tra-loi" />
				</td>
				<td  align="center">
					<liferay-ui:message key="duyet" />
				</td>
			</tr>
			
			<%
				for (int j = 0 ; j < userList.size(); j++) {
					User userAnswer = userList.get(j);
					long userId = userAnswer.getUserId();
					String fullName = userAnswer.getFullName();
					boolean quyenXem = false;
					boolean quyenCapNhat = false;
					boolean quyenTraLoi = false;
					boolean quyenDuyet = false;
					QAPhanQuyen phanQuyen = null;
					for (int k = 0 ; k < qAPhanQuyenList.size(); k++) {
						phanQuyen = qAPhanQuyenList.get(k);
						if (userId == phanQuyen.getMaNguoiTraLoi()) {
							quyenXem = phanQuyen.getQuyenXem();
							quyenCapNhat = phanQuyen.getQuyenCapNhat();
							quyenTraLoi = phanQuyen.getQuyenTraLoi();
							quyenDuyet = phanQuyen.getQuyenDuyet();
							break;
						}
					}
			%>
			<tr width="21%">
				<td width="21%" >
					<%= fullName %>
				</td>
				<td width="5%" align="center">
					<input type="checkbox" name="<portlet:namespace />xem" value="<%= String.valueOf(userId) %>" <%= quyenXem == true ? "checked=checked" : "" %>>
				</td>
				<td width="5%" align="center">
					<input type="checkbox" name="<portlet:namespace />capnhat" value="<%= String.valueOf(userId) %>" <%= quyenCapNhat == true ? "checked=checked" : "" %>>
				</td>
				<td width="5%" align="center">
					<input type="checkbox" name="<portlet:namespace />traloi" value="<%= String.valueOf(userId) %>" <%= quyenTraLoi == true ? "checked=checked" : "" %>>
				</td>
				<td width="5%" align="center">
					<input type="checkbox" name="<portlet:namespace />duyet" value="<%= String.valueOf(userId) %>" <%= quyenDuyet == true ? "checked=checked" : "" %>>
				</td>
			</tr>
			
			<%
				}
			%>
		</table>
		<input type="submit" value="<liferay-ui:message key="save" />" name="<portlet:namespace />save">
	</div>
</form>
