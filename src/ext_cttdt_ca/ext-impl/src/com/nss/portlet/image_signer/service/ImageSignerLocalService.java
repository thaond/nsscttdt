package com.nss.portlet.image_signer.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="ImageSignerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.image_signer.service.impl.ImageSignerLocalServiceImpl</code>.
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
 * @see com.nss.portlet.image_signer.service.ImageSignerLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ImageSignerLocalService {
    public com.nss.portlet.image_signer.model.ImageSigner addImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner createImageSigner(
        long imageSignerId);

    public void deleteImageSigner(long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.image_signer.model.ImageSigner getImageSigner(
        long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.image_signer.model.ImageSigner> getImageSigners(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getImageSignersCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner updateImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner updateImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException;

    public int countByName(java.lang.String name)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int count_User_Image(java.lang.String firstnames,
        java.lang.String middlenames, java.lang.String lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> find_User_Image(
        java.lang.String firstnames, java.lang.String middlenames,
        java.lang.String lastnames, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.image_signer.model.ImageSigner getImageSignerByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;
}
