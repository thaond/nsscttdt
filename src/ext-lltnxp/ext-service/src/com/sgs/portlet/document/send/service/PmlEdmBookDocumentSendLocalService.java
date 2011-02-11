package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmBookDocumentSendLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.send.service.impl.PmlEdmBookDocumentSendLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil
 *
 */
public interface PmlEdmBookDocumentSendLocalService {
    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend addPmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend createPmlEdmBookDocumentSend(
        long bookDocumentSendId);

    public void deletePmlEdmBookDocumentSend(long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getPmlEdmBookDocumentSend(
        long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> getPmlEdmBookDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmBookDocumentSendsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend updatePmlEdmBookDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSend(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId);

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSend(
        java.lang.String departmentsId, int documentRecordTypeId,
        java.lang.String agencyId);

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId);

    public int getDocumentRecordTypeIdByDocumentType(long documentTypeId);

    public int searchCountSoCongVanDiSo(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDiSo(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiSo(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiSo(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDiPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDiPB(java.lang.String loaiSoCVs,
        java.lang.String phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> searchSoCongVanDiPB(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlEdmPrivilegeLevel(long bookDocumentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
