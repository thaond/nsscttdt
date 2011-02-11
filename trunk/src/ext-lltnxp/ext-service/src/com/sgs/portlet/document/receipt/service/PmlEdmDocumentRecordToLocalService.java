package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentRecordToLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentRecordToLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil
 *
 */
public interface PmlEdmDocumentRecordToLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo addPmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo createPmlEdmDocumentRecordTo(
        long documentRecordToId);

    public void deletePmlEdmDocumentRecordTo(long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getPmlEdmDocumentRecordTo(
        long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> getPmlEdmDocumentRecordTos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentRecordTosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo updatePmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordTo(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(
        java.lang.String yearInUse, java.lang.String agencyId,
        int documentRecordTypeId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordTo(
        java.lang.String departmentsId, int documentRecordTypeId,
        java.lang.String agencyId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToByDocumentReceipt(
        long documentReceiptId);

    public int getDocumentRecordTypeIdByDocumentReceipt(long documentReceiptId);

    public java.lang.String getDepartmentIdByUserId(long userId);

    public boolean addBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo bookDocumentRecordTo);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToBy_DocumentType_AgencyId(
        long documentTypeId, java.lang.String agencyId);

    public java.lang.String getAgencyIdByDepartment(
        com.sgs.portlet.department.model.Department department);

    public int searchCountSoCongVanDenSo(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDenSo(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenSo(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenSo(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDenPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCountSoCongVanDenPB(java.lang.String loaiSoCVs,
        java.lang.String phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenPB(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlEdmPrivilegeLevel(long documentRecordToId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
