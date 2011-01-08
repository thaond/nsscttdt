package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlFileAttachedFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlFileAttachedFileLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalServiceUtil
 *
 */
public interface PmlFileAttachedFileLocalService {
    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile addPmlFileAttachedFile(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile createPmlFileAttachedFile(
        java.lang.String fileAttachedFileId);

    public void deletePmlFileAttachedFile(java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlFileAttachedFile(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile getPmlFileAttachedFile(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> getPmlFileAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlFileAttachedFilesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile updatePmlFileAttachedFile(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException;
}
