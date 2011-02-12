<%@ include file="/html/portlet/init.jsp" %>

<%@page import="com.ext.portal.util.WebKeysExt"%>
<%@page import="com.ext.portal.util.PortletKeysExt"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.field.model.PmlField"%>
<%@page import="com.sgs.portlet.field.service.persistence.PmlFieldUtil"%>
<%@page import="com.sgs.portlet.field.service.PmlFieldLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong"%>
<%@page import="com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecHanXuLyException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecNgayMoHSCVException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecSoHieuHSCVException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecReferenceException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecTieuDeException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecUserIdException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentSendDisplayTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentSendSearch"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentSendSearchTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentReceiptSearch"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentReceiptSearchTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlEdmDocumentReceiptDisplayTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecDisplayTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecSearch"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecSearchTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat"%>
<%@page import="com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil"%>

<%@page import="java.util.List"%>


<portlet:defineObjects />

<%
	PortletPreferences preferences = renderRequest.getPreferences();
	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat dfTime = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
%>