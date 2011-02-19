package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentRecordTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentRecordTypeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil
 *
 */
public interface PmlEdmDocumentRecordTypeLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType addPmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType createPmlEdmDocumentRecordType(
        int documentRecordTypeId);

    public void deletePmlEdmDocumentRecordType(int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType getPmlEdmDocumentRecordType(
        int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getPmlEdmDocumentRecordTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentRecordTypesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType updatePmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> search(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removePmlEdmDocumentType(int documentRecordTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForAgency(
        java.lang.String flag, java.lang.String agencyId, int currentYear)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForDeparment(
        java.lang.String departmentId, int currentYear)
        throws java.lang.Exception;
}
