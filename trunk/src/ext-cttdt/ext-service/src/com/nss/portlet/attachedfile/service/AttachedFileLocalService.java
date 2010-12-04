package com.nss.portlet.attachedfile.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="AttachedFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.attachedfile.service.impl.AttachedFileLocalServiceImpl</code>.
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
 * @see com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface AttachedFileLocalService {
    public com.nss.portlet.attachedfile.model.AttachedFile addAttachedFile(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile createAttachedFile(
        java.lang.String attachedFileId);

    public void deleteAttachedFile(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteAttachedFile(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.attachedfile.model.AttachedFile getAttachedFile(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> getAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile updateAttachedFile(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile updateAttachedFile(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> search(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String code, java.lang.String name,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public void removeAttachedFile(java.lang.String attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile addAttachedFile(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile updateAttachedFile(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
