package com.nss.portlet.image_signer.service;


/**
 * <a href="ImageSignerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.image_signer.service.ImageSignerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.image_signer.service.ImageSignerLocalService
 *
 */
public class ImageSignerLocalServiceUtil {
    private static ImageSignerLocalService _service;

    public static com.nss.portlet.image_signer.model.ImageSigner addImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException {
        return getService().addImageSigner(imageSigner);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner createImageSigner(
        long imageSignerId) {
        return getService().createImageSigner(imageSignerId);
    }

    public static void deleteImageSigner(long imageSignerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteImageSigner(imageSignerId);
    }

    public static void deleteImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException {
        getService().deleteImageSigner(imageSigner);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner getImageSigner(
        long imageSignerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getImageSigner(imageSignerId);
    }

    public static java.util.List<com.nss.portlet.image_signer.model.ImageSigner> getImageSigners(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getImageSigners(start, end);
    }

    public static int getImageSignersCount()
        throws com.liferay.portal.SystemException {
        return getService().getImageSignersCount();
    }

    public static com.nss.portlet.image_signer.model.ImageSigner updateImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException {
        return getService().updateImageSigner(imageSigner);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner updateImageSigner(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateImageSigner(imageSigner, merge);
    }

    public static int countByName(java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getService().countByName(name);
    }

    public static java.util.List<com.liferay.portal.model.User> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByName(name, start, end, obc);
    }

    public static int count_User_Image(java.lang.String firstnames,
        java.lang.String middlenames, java.lang.String lastnames,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .count_User_Image(firstnames, middlenames, lastnames,
            andOperator);
    }

    public static java.util.List<com.liferay.portal.model.User> find_User_Image(
        java.lang.String firstnames, java.lang.String middlenames,
        java.lang.String lastnames, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .find_User_Image(firstnames, middlenames, lastnames, start,
            end, andOperator, obc);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner getImageSignerByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getImageSignerByUserId(userId, start, end);
    }

    public static ImageSignerLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ImageSignerLocalService is not set");
        }

        return _service;
    }

    public void setService(ImageSignerLocalService service) {
        _service = service;
    }
}
