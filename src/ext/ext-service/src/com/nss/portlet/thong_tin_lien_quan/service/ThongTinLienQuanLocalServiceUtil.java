package com.nss.portlet.thong_tin_lien_quan.service;


/**
 * <a href="ThongTinLienQuanLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService
 *
 */
public class ThongTinLienQuanLocalServiceUtil {
    private static ThongTinLienQuanLocalService _service;

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan addThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException {
        return getService().addThongTinLienQuan(thongTinLienQuan);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan createThongTinLienQuan(
        long maThongTinLienQuan) {
        return getService().createThongTinLienQuan(maThongTinLienQuan);
    }

    public static void deleteThongTinLienQuan(long maThongTinLienQuan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThongTinLienQuan(maThongTinLienQuan);
    }

    public static void deleteThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException {
        getService().deleteThongTinLienQuan(thongTinLienQuan);
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

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan getThongTinLienQuan(
        long maThongTinLienQuan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getThongTinLienQuan(maThongTinLienQuan);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> getThongTinLienQuans(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getThongTinLienQuans(start, end);
    }

    public static int getThongTinLienQuansCount()
        throws com.liferay.portal.SystemException {
        return getService().getThongTinLienQuansCount();
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException {
        return getService().updateThongTinLienQuan(thongTinLienQuan);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateThongTinLienQuan(thongTinLienQuan, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static ThongTinLienQuanLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "ThongTinLienQuanLocalService is not set");
        }

        return _service;
    }

    public void setService(ThongTinLienQuanLocalService service) {
        _service = service;
    }
}
