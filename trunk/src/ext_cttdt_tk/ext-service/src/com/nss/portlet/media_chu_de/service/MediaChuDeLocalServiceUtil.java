package com.nss.portlet.media_chu_de.service;


/**
 * <a href="MediaChuDeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.media_chu_de.service.MediaChuDeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_chu_de.service.MediaChuDeLocalService
 *
 */
public class MediaChuDeLocalServiceUtil {
    private static MediaChuDeLocalService _service;

    public static com.nss.portlet.media_chu_de.model.MediaChuDe addMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException {
        return getService().addMediaChuDe(mediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe createMediaChuDe(
        long maMediaChuDe) {
        return getService().createMediaChuDe(maMediaChuDe);
    }

    public static void deleteMediaChuDe(long maMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        getService().deleteMediaChuDe(maMediaChuDe);
    }

    public static void deleteMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException {
        getService().deleteMediaChuDe(mediaChuDe);
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

    public static com.nss.portlet.media_chu_de.model.MediaChuDe getMediaChuDe(
        long maMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMediaChuDe(maMediaChuDe);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> getMediaChuDes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMediaChuDes(start, end);
    }

    public static int getMediaChuDesCount()
        throws com.liferay.portal.SystemException {
        return getService().getMediaChuDesCount();
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException {
        return getService().updateMediaChuDe(mediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateMediaChuDe(mediaChuDe, merge);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findMediaChuDe(tenMediaChuDe, andOperator, start, end, obc);
    }

    public static int countMediaChuDe(java.lang.String tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().countMediaChuDe(tenMediaChuDe, andOperator);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe addMediaChuDe(
        java.lang.String tenMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addMediaChuDe(tenMediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        long maMediaChuDe, java.lang.String tenMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateMediaChuDe(maMediaChuDe, tenMediaChuDe);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active) {
        return getService().findByActive(active);
    }

    public static MediaChuDeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MediaChuDeLocalService is not set");
        }

        return _service;
    }

    public void setService(MediaChuDeLocalService service) {
        _service = service;
    }
}
