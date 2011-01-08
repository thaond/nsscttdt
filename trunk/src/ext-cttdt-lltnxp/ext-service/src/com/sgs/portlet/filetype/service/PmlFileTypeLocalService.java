package com.sgs.portlet.filetype.service;


/**
 * <a href="PmlFileTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.filetype.service.impl.PmlFileTypeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil
 *
 */
public interface PmlFileTypeLocalService {
    public com.sgs.portlet.filetype.model.PmlFileType addPmlFileType(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType createPmlFileType(
        java.lang.String fileTypeId);

    public void deletePmlFileType(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileType(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType getPmlFileType(
        java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getPmlFileTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFileTypesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType updatePmlFileType(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String fileTypeCode,
        java.lang.String fileTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> search(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByFieldId(
        java.lang.String fieldId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByUserId(
        long userId);

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> search(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCount() throws com.liferay.portal.SystemException;

    public void removePmlFileType(java.lang.String fileTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType addFileType(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        java.lang.String fieldId, java.lang.String processTime,
        java.lang.String description, java.lang.String active,
        java.lang.String currentReceiptNumber,
        java.lang.String receiptTemplate, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType updateFileType(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        java.lang.String fileTypeName, java.lang.String fieldId,
        java.lang.String processTime, java.lang.String description,
        java.lang.String active, java.lang.String currentReceiptNumber,
        java.lang.String receiptTemplate, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
