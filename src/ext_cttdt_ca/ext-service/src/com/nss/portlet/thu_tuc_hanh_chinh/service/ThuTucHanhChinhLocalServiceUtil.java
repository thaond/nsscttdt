package com.nss.portlet.thu_tuc_hanh_chinh.service;


/**
 * <a href="ThuTucHanhChinhLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalService
 *
 */
public class ThuTucHanhChinhLocalServiceUtil {
    private static ThuTucHanhChinhLocalService _service;

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh addThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().addThuTucHanhChinh(thuTucHanhChinh);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh createThuTucHanhChinh(
        long maThuTucHanhChinh) {
        return getService().createThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static void deleteThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static void deleteThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getService().deleteThuTucHanhChinh(thuTucHanhChinh);
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

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh getThuTucHanhChinh(
        long maThuTucHanhChinh)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> getThuTucHanhChinhs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getThuTucHanhChinhs(start, end);
    }

    public static int getThuTucHanhChinhsCount()
        throws com.liferay.portal.SystemException {
        return getService().getThuTucHanhChinhsCount();
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().updateThuTucHanhChinh(thuTucHanhChinh);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateThuTucHanhChinh(thuTucHanhChinh, merge);
    }

    public static int searchCount(java.lang.String name, long linhVuc,
        long capDonVi, long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(name, linhVuc, capDonVi, donVi, andOperator);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> search(
        java.lang.String name, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(name, linhVuc, capDonVi, donVi, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTuc(
        long maLinhVucThuTuc) {
        return getService().findByMaLinhVucThuTuc(maLinhVucThuTuc);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTuc(
        long maDonViThuTuc) {
        return getService().findByMaDonViThuTuc(maDonViThuTuc);
    }

    public static ThuTucHanhChinhLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ThuTucHanhChinhLocalService is not set");
        }

        return _service;
    }

    public void setService(ThuTucHanhChinhLocalService service) {
        _service = service;
    }
}
