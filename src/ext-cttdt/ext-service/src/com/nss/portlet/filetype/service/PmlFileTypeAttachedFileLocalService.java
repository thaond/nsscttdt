package com.nss.portlet.filetype.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlFileTypeAttachedFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.filetype.service.impl.PmlFileTypeAttachedFileLocalServiceImpl</code>.
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
 * @see com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlFileTypeAttachedFileLocalService {
    public com.nss.portlet.filetype.model.PmlFileTypeAttachedFile addPmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.filetype.model.PmlFileTypeAttachedFile createPmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId);

    public void deletePmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.filetype.model.PmlFileTypeAttachedFile getPmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> getPmlFileTypeAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlFileTypeAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.filetype.model.PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.filetype.model.PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;
}
