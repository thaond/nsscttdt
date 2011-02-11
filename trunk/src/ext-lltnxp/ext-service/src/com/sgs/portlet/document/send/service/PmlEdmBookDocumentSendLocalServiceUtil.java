package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmBookDocumentSendLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService
 *
 */
public class PmlEdmBookDocumentSendLocalServiceUtil {
    private static PmlEdmBookDocumentSendLocalService _service;

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend addPmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmBookDocumentSend(pmlEdmBookDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend createPmlEdmBookDocumentSend(
        long bookDocumentSendId) {
        return getService().createPmlEdmBookDocumentSend(bookDocumentSendId);
    }

    public static void deletePmlEdmBookDocumentSend(long bookDocumentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmBookDocumentSend(bookDocumentSendId);
    }

    public static void deletePmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmBookDocumentSend(pmlEdmBookDocumentSend);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getPmlEdmBookDocumentSend(
        long bookDocumentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmBookDocumentSend(bookDocumentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> getPmlEdmBookDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmBookDocumentSends(start, end);
    }

    public static int getPmlEdmBookDocumentSendsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmBookDocumentSendsCount();
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend updatePmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmBookDocumentSend(pmlEdmBookDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSend(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) {
        return getService()
                   .getBookDocumentSend(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSend(
        java.lang.String departmentsId, int documentRecordTypeId,
        java.lang.String agencyId) {
        return getService()
                   .getBookDocumentSend(departmentsId, documentRecordTypeId,
            agencyId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) {
        return getService()
                   .getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId);
    }

    public static int getDocumentRecordTypeIdByDocumentType(long documentTypeId) {
        return getService().getDocumentRecordTypeIdByDocumentType(documentTypeId);
    }

    public static int searchCountSoCongVanDiSo(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDiSo(keywords);
    }

    public static int searchCountSoCongVanDiSo(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDiSo(loaiSoCVs, so, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiSo(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchSoCongVanDiSo(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiSo(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchSoCongVanDiSo(loaiSoCVs, so, andOperator, start, end,
            obc);
    }

    public static int searchCountSoCongVanDiPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDiPB(keywords);
    }

    public static int searchCountSoCongVanDiPB(java.lang.String loaiSoCVs,
        java.lang.String phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCountSoCongVanDiPB(loaiSoCVs, phongBan, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchSoCongVanDiPB(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiPB(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchSoCongVanDiPB(loaiSoCVs, phongBan, andOperator,
            start, end, obc);
    }

    public static void removePmlEdmPrivilegeLevel(long bookDocumentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmPrivilegeLevel(bookDocumentSendId);
    }

    public static PmlEdmBookDocumentSendLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmBookDocumentSendLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmBookDocumentSendLocalService service) {
        _service = service;
    }
}
