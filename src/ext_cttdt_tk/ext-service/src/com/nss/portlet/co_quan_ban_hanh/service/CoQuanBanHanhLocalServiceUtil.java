package com.nss.portlet.co_quan_ban_hanh.service;


/**
 * <a href="CoQuanBanHanhLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService
 *
 */
public class CoQuanBanHanhLocalServiceUtil {
    private static CoQuanBanHanhLocalService _service;

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh addCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException {
        return getService().addCoQuanBanHanh(coQuanBanHanh);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh createCoQuanBanHanh(
        long maCoQuanBanHanh) {
        return getService().createCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static void deleteCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static void deleteCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException {
        getService().deleteCoQuanBanHanh(coQuanBanHanh);
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

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh getCoQuanBanHanh(
        long maCoQuanBanHanh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> getCoQuanBanHanhs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCoQuanBanHanhs(start, end);
    }

    public static int getCoQuanBanHanhsCount()
        throws com.liferay.portal.SystemException {
        return getService().getCoQuanBanHanhsCount();
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException {
        return getService().updateCoQuanBanHanh(coQuanBanHanh);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateCoQuanBanHanh(coQuanBanHanh, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static CoQuanBanHanhLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CoQuanBanHanhLocalService is not set");
        }

        return _service;
    }

    public void setService(CoQuanBanHanhLocalService service) {
        _service = service;
    }
}
