package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmAttachedFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmAttachedFileLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil
 *
 */
public interface PmlEdmAttachedFileLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile addPmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile createPmlEdmAttachedFile(
        long attachedFileId);

    public void deletePmlEdmAttachedFile(long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile getPmlEdmAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> getPmlEdmAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile updatePmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> getAttachedFileForLog(
        java.lang.Class clazz, long id);

    public int deletePmlEdmAttachedFileByOO(long objectContentId,
        java.lang.String objectType);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;
}
