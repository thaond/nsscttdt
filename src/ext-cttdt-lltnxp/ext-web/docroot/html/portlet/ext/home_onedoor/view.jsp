<%@ include file="/html/portlet/ext/home_onedoor/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>

<!-- Phan danh cho thong tin ho so -->
<%
	// Duong dan den danh sach ho so chua nhan
	PortletURL sofilechuanhan = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
	sofilechuanhan.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	sofilechuanhan.setParameter("processValue", "sofilechuanhan");
	sofilechuanhan.setPortletMode(PortletMode.VIEW);
	sofilechuanhan.setWindowState(WindowState.NORMAL);
	
	// Duong dan den danh sach ho so can xu ly						
	PortletURL sofilecanxuly = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
	sofilecanxuly.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	sofilecanxuly.setParameter("processValue", "sofilecanxuly");
	sofilecanxuly.setPortletMode(PortletMode.VIEW);
	sofilecanxuly.setWindowState(WindowState.NORMAL);
	
	// Duong dan den ho so qua han
	PortletURL sofiledaquahan = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
	sofiledaquahan.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	sofiledaquahan.setParameter("processValue", "sofiledaquahan");
	sofiledaquahan.setPortletMode(PortletMode.VIEW);
	sofiledaquahan.setWindowState(WindowState.NORMAL);

	// Duong dan den ho so can bo sung
	PortletURL sofilechobosung = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
	sofilechobosung.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	sofilechobosung.setParameter("processValue", "sofilechobosung");
	sofilechobosung.setPortletMode(PortletMode.VIEW);
	sofilechobosung.setWindowState(WindowState.NORMAL);

	// Duong dan den tong so file can xu ly
	PortletURL tongsofile = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
	tongsofile.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
	tongsofile.setPortletMode(PortletMode.VIEW);
	tongsofile.setWindowState(WindowState.NORMAL);
	
	List<String> typeList =  new ArrayList<String>();
	List<String> valueTypeList = new ArrayList<String>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String toDate = df.format(sdf.parse(sdf.format(date)));
	
	long userId = PortalUtil.getUserId(renderRequest);
	int quantityOfRecordNotReceiveYet = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null).size(); 
	int quantityOfRecordExpireISO = PmlOneDoorReceiveFileLocalServiceUtil.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, -1, -1, null).size();
	int quantityOfRecordSupplement = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null).size();
	int quantityOfRecordProcess = PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, -1, -1, null).size();
	int sumOfRecordProcess = PmlOneDoorReceiveFileLocalServiceUtil.getListFileNeedProcess(userId, typeList, valueTypeList, -1, -1, null).size();
%>

	<%-- nhac viec --%>
	<div class="title_categ">
		<liferay-ui:message key="nhac-viec"/>
	</div>

	<div class="boxcontent intleft">
		
		<label>
			<% if (sumOfRecordProcess > 0) { %>
					<a href="<%= tongsofile.toString() %>"><liferay-ui:message key="situation-process-record" /></a>
			<% } else { %>
					<liferay-ui:message key="situation-process-record" />
			<% } %>
		</label>
			
		<%
		if (quantityOfRecordNotReceiveYet == 0 && 
				quantityOfRecordExpireISO == 0 &&
				quantityOfRecordSupplement == 0 &&
				quantityOfRecordProcess == 0 &&
				sumOfRecordProcess == 0) {
		%>
			<ul class="ind_ul">
				<li>
					<liferay-ui:message key="now-you-have-not-any-record-need-process" />
				</li>
			</ul>
		<%
		} else {
		%>
			<!-- <b><liferay-ui:message key="now-you-have" /></b> -->
			
			<ul class="ind_ul">
				<c:if test="<%= quantityOfRecordNotReceiveYet > 0 %>">
					<li>
						<a href="<%= sofilechuanhan.toString() %>">
							<%= quantityOfRecordNotReceiveYet %>&nbsp;
							<liferay-ui:message key="record-not-receive" />
						</a> 
					</li>
				</c:if>
				
				<c:if test="<%= quantityOfRecordProcess > 0 %>">
					<li>
						<a href="<%= sofilecanxuly.toString() %>">
							<%= quantityOfRecordProcess %>&nbsp;
							<liferay-ui:message key="record-process-in-day" />
						</a>
					</li>
				</c:if>

				<c:if test="<%= quantityOfRecordExpireISO > 0 %>">
					<li>
						<a href="<%= sofiledaquahan.toString() %>">
							<%= quantityOfRecordExpireISO %>&nbsp;
							<liferay-ui:message key="late-record-process" />
						</a>
					</li>
				</c:if>
				
				<c:if test="<%= quantityOfRecordSupplement > 0 %>">
					<li>
						<a href="<%= sofilechobosung.toString() %>">
							<%= quantityOfRecordSupplement %>&nbsp;
							<liferay-ui:message key="doc-expect-complete" />
						</a>
					</li>
				</c:if>
				
				<c:if test="<%= sumOfRecordProcess > 0 %>">
					<li>
						<a href="<%= tongsofile.toString() %>">
							<%= sumOfRecordProcess %>&nbsp;
							<liferay-ui:message key="record-need-process" />
						</a>
					</li>
				</c:if>
			</ul>
		<%
		}
		%>
	</div>
