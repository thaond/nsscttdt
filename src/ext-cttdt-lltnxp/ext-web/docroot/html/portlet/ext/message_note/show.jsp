<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/ext/message_note/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.sgs.portlet.message_note.model.PmlMessage"%>
<%@page import="com.sgs.portlet.message_note.service.persistence.PmlMessageUtil"%>
<%@page import="com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>

<%
	// user dang nhap (receiver)
	long userIdLogin = ParamUtil.getLong(request, "userId", 0);
	List<Long> fromUserList = new ArrayList<Long>();
	List<PmlMessage> messageList = null;
	PmlUser pmlUser = null;
	try {
		messageList = PmlMessageUtil.findByToUserId(userIdLogin);
		
		for (PmlMessage message: messageList) {
			long fromUserId = message.getFromUserId();
			if (!fromUserList.contains(fromUserId)) {
				fromUserList.add(fromUserId);
			}
		}
	} catch (Exception e) {
		messageList = new ArrayList<PmlMessage>();
	}
	
	int total = PmlMessageLocalServiceUtil.getTotalDocumentByUser(fromUserList, userIdLogin);
	
	if (total > 0) {
%>

	<div id="showmessage" class="show-note">
		<embed height="1" quality="high" src="/html/portlet/ext/message_note/alert.swf" type="application/x-shockwave-flash" width="1"/>
	
	<label>
		<liferay-ui:message key="ban-nhan-duoc" />:
	</label>
	
	<%		
		for (int i = 0; i < fromUserList.size(); i ++) {
			long fromuserid = fromUserList.get(i);
			String fromUsername = "";
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(fromuserid);
				fromUsername = pmlUser.getLastName() + " " + pmlUser.getMiddleName() + " " + pmlUser.getFirstName();
			} catch (Exception e) { }
			
			// van ban den
			List<PmlMessage> listVBDen = PmlMessageLocalServiceUtil.getDocumentListByUser(fromuserid, userIdLogin, PmlEdmDocumentReceiptImpl.class);
		%>
			
			<c:if test="<%= listVBDen.size() > 0 %>">
			<ul>
				<li>
				<label>	<%= listVBDen.size() %>&nbsp;<liferay-ui:message key="van-ban-den-tu" />&nbsp;<%= fromUsername %></label>
				</li>
			</ul>
			</c:if>
		
		<%
			PmlMessageLocalServiceUtil.deletePmlMessageList(listVBDen);
			// ket thuc van ban den
			
			// van ban di
			List<PmlMessage> listVBDi = PmlMessageLocalServiceUtil.getDocumentListByUser(fromuserid, userIdLogin, PmlEdmDocumentSendImpl.class);
		%>
			
			<c:if test="<%= listVBDi.size() > 0 %>">
			<ul>
				<li>
					<font style="padding-left: 5px"><%= listVBDi.size() %>&nbsp;<liferay-ui:message key="van-ban-di-tu" />&nbsp;<%= fromUsername %></font>
				</li>
			</ul>
			</c:if>
		
		<%	
			PmlMessageLocalServiceUtil.deletePmlMessageList(listVBDi);
			// ket thuc van ban den
		}
	%>
	</div>
	
	<%
	}
%>
