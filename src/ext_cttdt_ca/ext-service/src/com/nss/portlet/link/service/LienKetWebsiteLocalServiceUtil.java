package com.nss.portlet.link.service;


/**
 * <a href="LienKetWebsiteLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.link.service.LienKetWebsiteLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.LienKetWebsiteLocalService
 *
 */
public class LienKetWebsiteLocalServiceUtil {
    private static LienKetWebsiteLocalService _service;

    public static com.nss.portlet.link.model.LienKetWebsite addLienKetWebsite(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException {
        return getService().addLienKetWebsite(lienKetWebsite);
    }

    public static com.nss.portlet.link.model.LienKetWebsite createLienKetWebsite(
        long maWebsite) {
        return getService().createLienKetWebsite(maWebsite);
    }

    public static void deleteLienKetWebsite(long maWebsite)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLienKetWebsite(maWebsite);
    }

    public static void deleteLienKetWebsite(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException {
        getService().deleteLienKetWebsite(lienKetWebsite);
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

    public static com.nss.portlet.link.model.LienKetWebsite getLienKetWebsite(
        long maWebsite)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLienKetWebsite(maWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> getLienKetWebsites(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLienKetWebsites(start, end);
    }

    public static int getLienKetWebsitesCount()
        throws com.liferay.portal.SystemException {
        return getService().getLienKetWebsitesCount();
    }

    public static com.nss.portlet.link.model.LienKetWebsite updateLienKetWebsite(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException {
        return getService().updateLienKetWebsite(lienKetWebsite);
    }

    public static com.nss.portlet.link.model.LienKetWebsite updateLienKetWebsite(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateLienKetWebsite(lienKetWebsite, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MOTA(java.lang.String name,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByTEN_MOTA(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> getListLienKetWebsiteByLoaiWebsiteId(
        long maLoaiWebsite) {
        return getService().getListLienKetWebsiteByLoaiWebsiteId(maLoaiWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByMaLoaiWebsite_Active(
        long maLoaiWebsite, int active) {
        return getService().findByMaLoaiWebsite_Active(maLoaiWebsite, active);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static LienKetWebsiteLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LienKetWebsiteLocalService is not set");
        }

        return _service;
    }

    public void setService(LienKetWebsiteLocalService service) {
        _service = service;
    }
}
