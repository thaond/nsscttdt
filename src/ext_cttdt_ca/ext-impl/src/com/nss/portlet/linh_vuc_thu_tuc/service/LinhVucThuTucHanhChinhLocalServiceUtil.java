package com.nss.portlet.linh_vuc_thu_tuc.service;


/**
 * <a href="LinhVucThuTucHanhChinhLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService
 *
 */
public class LinhVucThuTucHanhChinhLocalServiceUtil {
    private static LinhVucThuTucHanhChinhLocalService _service;

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh addLinhVucThuTucHanhChinh(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().addLinhVucThuTucHanhChinh(linhVucThuTucHanhChinh);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh createLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh) {
        return getService()
                   .createLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static void deleteLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static void deleteLinhVucThuTucHanhChinh(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getService().deleteLinhVucThuTucHanhChinh(linhVucThuTucHanhChinh);
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

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh getLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> getLinhVucThuTucHanhChinhs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLinhVucThuTucHanhChinhs(start, end);
    }

    public static int getLinhVucThuTucHanhChinhsCount()
        throws com.liferay.portal.SystemException {
        return getService().getLinhVucThuTucHanhChinhsCount();
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh updateLinhVucThuTucHanhChinh(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().updateLinhVucThuTucHanhChinh(linhVucThuTucHanhChinh);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh updateLinhVucThuTucHanhChinh(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateLinhVucThuTucHanhChinh(linhVucThuTucHanhChinh, merge);
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

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) {
        return getService().findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static LinhVucThuTucHanhChinhLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "LinhVucThuTucHanhChinhLocalService is not set");
        }

        return _service;
    }

    public void setService(LinhVucThuTucHanhChinhLocalService service) {
        _service = service;
    }
}
