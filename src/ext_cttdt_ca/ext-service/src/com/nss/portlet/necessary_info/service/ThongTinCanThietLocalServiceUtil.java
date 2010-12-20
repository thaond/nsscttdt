package com.nss.portlet.necessary_info.service;


/**
 * <a href="ThongTinCanThietLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService
 *
 */
public class ThongTinCanThietLocalServiceUtil {
    private static ThongTinCanThietLocalService _service;

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet addThongTinCanThiet(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException {
        return getService().addThongTinCanThiet(thongTinCanThiet);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet createThongTinCanThiet(
        long maThongTinCanThiet) {
        return getService().createThongTinCanThiet(maThongTinCanThiet);
    }

    public static void deleteThongTinCanThiet(long maThongTinCanThiet)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThongTinCanThiet(maThongTinCanThiet);
    }

    public static void deleteThongTinCanThiet(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException {
        getService().deleteThongTinCanThiet(thongTinCanThiet);
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

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet getThongTinCanThiet(
        long maThongTinCanThiet)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getThongTinCanThiet(maThongTinCanThiet);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> getThongTinCanThiets(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getThongTinCanThiets(start, end);
    }

    public static int getThongTinCanThietsCount()
        throws com.liferay.portal.SystemException {
        return getService().getThongTinCanThietsCount();
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet updateThongTinCanThiet(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException {
        return getService().updateThongTinCanThiet(thongTinCanThiet);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet updateThongTinCanThiet(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateThongTinCanThiet(thongTinCanThiet, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static ThongTinCanThietLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "ThongTinCanThietLocalService is not set");
        }

        return _service;
    }

    public void setService(ThongTinCanThietLocalService service) {
        _service = service;
    }
}
