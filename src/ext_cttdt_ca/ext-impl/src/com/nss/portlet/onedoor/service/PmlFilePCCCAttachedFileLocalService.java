package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlFilePCCCAttachedFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlFilePCCCAttachedFileLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlFilePCCCAttachedFileLocalService {
    public com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile addPmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile createPmlFilePCCCAttachedFile(
        long attachedFileId);

    public void deletePmlFilePCCCAttachedFile(long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile getPmlFilePCCCAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile> getPmlFilePCCCAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlFilePCCCAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;
}
