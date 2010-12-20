package com.nss.portlet.media_library.service;


/**
 * <a href="MediaLibraryLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.media_library.service.MediaLibraryLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_library.service.MediaLibraryLocalService
 *
 */
public class MediaLibraryLocalServiceUtil {
    private static MediaLibraryLocalService _service;

    public static com.nss.portlet.media_library.model.MediaLibrary addMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException {
        return getService().addMediaLibrary(mediaLibrary);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary createMediaLibrary(
        long maMediaLibrary) {
        return getService().createMediaLibrary(maMediaLibrary);
    }

    public static void deleteMediaLibrary(long maMediaLibrary)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMediaLibrary(maMediaLibrary);
    }

    public static void deleteMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException {
        getService().deleteMediaLibrary(mediaLibrary);
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

    public static com.nss.portlet.media_library.model.MediaLibrary getMediaLibrary(
        long maMediaLibrary)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMediaLibrary(maMediaLibrary);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> getMediaLibraries(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMediaLibraries(start, end);
    }

    public static int getMediaLibrariesCount()
        throws com.liferay.portal.SystemException {
        return getService().getMediaLibrariesCount();
    }

    public static com.nss.portlet.media_library.model.MediaLibrary updateMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException {
        return getService().updateMediaLibrary(mediaLibrary);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary updateMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMediaLibrary(mediaLibrary, merge);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String tieuDeMediaLibrary, java.lang.String tenMediaLibrary,
        long maMediaChuDe, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static int countMediaLibrary(java.lang.String tieuDeMediaLibrary,
        java.lang.String tenMediaLibrary, long maMediaChuDe, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active) {
        return getService().findByMaMediaChuDe_Active(maMediaChuDe, active);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active) {
        return getService().findByActive(active);
    }

    public static MediaLibraryLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MediaLibraryLocalService is not set");
        }

        return _service;
    }

    public void setService(MediaLibraryLocalService service) {
        _service = service;
    }
}
