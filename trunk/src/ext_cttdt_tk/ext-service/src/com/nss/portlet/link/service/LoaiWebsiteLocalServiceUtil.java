package com.nss.portlet.link.service;


/**
 * <a href="LoaiWebsiteLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.link.service.LoaiWebsiteLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.LoaiWebsiteLocalService
 *
 */
public class LoaiWebsiteLocalServiceUtil {
    private static LoaiWebsiteLocalService _service;

    public static com.nss.portlet.link.model.LoaiWebsite addLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiWebsite(loaiWebsite);
    }

    public static com.nss.portlet.link.model.LoaiWebsite createLoaiWebsite(
        long maLoaiWebsite) {
        return getService().createLoaiWebsite(maLoaiWebsite);
    }

    public static void deleteLoaiWebsite(long maLoaiWebsite)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiWebsite(maLoaiWebsite);
    }

    public static void deleteLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiWebsite(loaiWebsite);
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

    public static com.nss.portlet.link.model.LoaiWebsite getLoaiWebsite(
        long maLoaiWebsite)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiWebsite(maLoaiWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> getLoaiWebsites(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiWebsites(start, end);
    }

    public static int getLoaiWebsitesCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiWebsitesCount();
    }

    public static com.nss.portlet.link.model.LoaiWebsite updateLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiWebsite(loaiWebsite);
    }

    public static com.nss.portlet.link.model.LoaiWebsite updateLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiWebsite(loaiWebsite, merge);
    }

    public static int countLoaiWebsiteByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countLoaiWebsiteByKeywords(keywords);
    }

    public static int countLoaiWebsite(java.lang.String name,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countLoaiWebsite(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findLoaiWebsiteByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findLoaiWebsiteByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findLoaiWebsite(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findLoaiWebsite(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static LoaiWebsiteLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LoaiWebsiteLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiWebsiteLocalService service) {
        _service = service;
    }
}
