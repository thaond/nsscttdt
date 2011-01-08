package com.sgs.portlet.onedoorpccc.service;


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
 * <code>com.sgs.portlet.onedoorpccc.service.impl.PmlFilePCCCAttachedFileLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalServiceUtil
 *
 */
public interface PmlFilePCCCAttachedFileLocalService {
    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile addPmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile createPmlFilePCCCAttachedFile(
        long attachedFileId);

    public void deletePmlFilePCCCAttachedFile(long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile getPmlFilePCCCAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> getPmlFilePCCCAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFilePCCCAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> getAttachedFilePCCCForUpload(
        java.lang.Class clazz, java.lang.String id);
}
