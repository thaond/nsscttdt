package com.nss.portlet.nss_don_vi_thu_tuc.service;


/**
 * <a href="DonViThuTucLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService
 *
 */
public class DonViThuTucLocalServiceUtil {
    private static DonViThuTucLocalService _service;

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc addDonViThuTuc(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException {
        return getService().addDonViThuTuc(donViThuTuc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc createDonViThuTuc(
        long maDonViThuTuc) {
        return getService().createDonViThuTuc(maDonViThuTuc);
    }

    public static void deleteDonViThuTuc(long maDonViThuTuc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDonViThuTuc(maDonViThuTuc);
    }

    public static void deleteDonViThuTuc(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException {
        getService().deleteDonViThuTuc(donViThuTuc);
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

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc getDonViThuTuc(
        long maDonViThuTuc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDonViThuTuc(maDonViThuTuc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> getDonViThuTucs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDonViThuTucs(start, end);
    }

    public static int getDonViThuTucsCount()
        throws com.liferay.portal.SystemException {
        return getService().getDonViThuTucsCount();
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc updateDonViThuTuc(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException {
        return getService().updateDonViThuTuc(donViThuTuc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc updateDonViThuTuc(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateDonViThuTuc(donViThuTuc, merge);
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

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi) {
        return getService().findByCapDonVi(capDonVi);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active) {
        return getService().findByCapDonVi_Active(capDonVi, active);
    }

    public static DonViThuTucLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("DonViThuTucLocalService is not set");
        }

        return _service;
    }

    public void setService(DonViThuTucLocalService service) {
        _service = service;
    }
}
