<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="javax.portlet.PortletContext"%>
<%@ page import="javax.portlet.PortletException"%>
<%@ page import="javax.portlet.PortletRequestDispatcher"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>

<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV" %>
<%@ page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt" %>
<%@ page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend" %>
<%@ page import="com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl" %>
<%@ page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl" %>
<%@ page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" %>
<%@ page import="com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend" %>
<%@ page import="com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl" %>

<%@page import="com.liferay.portal.kernel.xml.Document" %>
<%@page import="com.liferay.portal.kernel.xml.Element" %>
<%@page import="com.liferay.portal.kernel.xml.Node" %>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@page import="com.liferay.portal.kernel.xml.XPath" %>
<%@page import="com.liferay.portal.util.LayoutLister" %>
<%@page import="com.liferay.portal.util.LayoutView" %>
<%@page import="com.liferay.portal.webdav.WebDAVUtil" %>
<%@page import="com.ext.portal.util.PortletKeysExt" %>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecSearch"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecSearchTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.ext.portal.util.WebKeysExt"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat"%>
<%@page import="com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong"%>
<%@page import="com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.search.PmlHoSoCongViecDisplayTerms"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecSoHieuHSCVException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecTieuDeException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecNgayMoHSCVException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecHanXuLyException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecUserIdException"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.PmlHoSoCongViecReferenceException"%>
<%@page import="com.sgs.portlet.field.service.PmlFieldLocalServiceUtil" %>

<portlet:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
%>