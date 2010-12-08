package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlPaintDocumentLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.onedoor.service.impl.PmlPaintDocumentLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlPaintDocumentLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlPaintDocumentLocalService {
    public com.nss.portlet.onedoor.model.PmlPaintDocument addPmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlPaintDocument createPmlPaintDocument(
        long paintDocumentId);

    public void deletePmlPaintDocument(long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlPaintDocument getPmlPaintDocument(
        long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlPaintDocument> getPmlPaintDocuments(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlPaintDocumentsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlPaintDocument updatePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlPaintDocument updatePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException;

    public void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;
}
