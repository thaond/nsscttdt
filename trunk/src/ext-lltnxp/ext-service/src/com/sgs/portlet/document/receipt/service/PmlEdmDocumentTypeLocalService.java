package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentTypeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil
 *
 */
public interface PmlEdmDocumentTypeLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType addPmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType createPmlEdmDocumentType(
        long documentTypeId);

    public void deletePmlEdmDocumentType(long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType getPmlEdmDocumentType(
        long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentTypesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType updatePmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> search(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeIds(
        java.util.List<Long> documentTypeIds) throws java.lang.Exception;

    public void removePmlEdmDocumentType(long documentTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getDocType(
        int get1, int get2) throws com.liferay.portal.SystemException;
}
