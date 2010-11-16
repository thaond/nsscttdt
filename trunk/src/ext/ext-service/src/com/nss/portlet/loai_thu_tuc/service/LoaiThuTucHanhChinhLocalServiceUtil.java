package com.nss.portlet.loai_thu_tuc.service;


/**
 * <a href="LoaiThuTucHanhChinhLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService
 *
 */
public class LoaiThuTucHanhChinhLocalServiceUtil {
    private static LoaiThuTucHanhChinhLocalService _service;

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh addLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh createLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) {
        return getService().createLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static void deleteLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static void deleteLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
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

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh getLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> getLoaiThuTucHanhChinhs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiThuTucHanhChinhs(start, end);
    }

    public static int getLoaiThuTucHanhChinhsCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiThuTucHanhChinhsCount();
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiThuTucHanhChinh(loaiThuTucHanhChinh);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateLoaiThuTucHanhChinh(loaiThuTucHanhChinh, merge);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(name, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static LoaiThuTucHanhChinhLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "LoaiThuTucHanhChinhLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiThuTucHanhChinhLocalService service) {
        _service = service;
    }
}
