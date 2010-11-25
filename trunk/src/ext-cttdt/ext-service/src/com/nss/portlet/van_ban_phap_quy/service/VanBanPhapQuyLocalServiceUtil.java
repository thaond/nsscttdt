package com.nss.portlet.van_ban_phap_quy.service;


/**
 * <a href="VanBanPhapQuyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService
 *
 */
public class VanBanPhapQuyLocalServiceUtil {
    private static VanBanPhapQuyLocalService _service;

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getService().addVanBanPhapQuy(vanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy createVanBanPhapQuy(
        long maVanBanPhapQuy) {
        return getService().createVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static void deleteVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static void deleteVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        getService().deleteVanBanPhapQuy(vanBanPhapQuy);
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

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy getVanBanPhapQuy(
        long maVanBanPhapQuy)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanBanPhapQuies(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getVanBanPhapQuies(start, end);
    }

    public static int getVanBanPhapQuiesCount()
        throws com.liferay.portal.SystemException {
        return getService().getVanBanPhapQuiesCount();
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getService().updateVanBanPhapQuy(vanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateVanBanPhapQuy(vanBanPhapQuy, merge);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String kyHieuVanBan,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(kyHieuVanBan, andOperator);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> search(
        java.lang.String kyHieuVanBan, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(kyHieuVanBan, andOperator, start, end, obc);
    }

    public static void reIndex(long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(companyId, vanBanPhapQuy);
    }

    public static void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException {
        getService().reIndex(ids);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String kyHieuVanBan, java.lang.String tomTat,
        java.lang.String nguoiKy, long maLoaiVanBan, long maLinhVucVanBan,
        long maCoQuanBanHanh, java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, kyHieuVanBan, tomTat, nguoiKy,
            maLoaiVanBan, maLinhVucVanBan, maCoQuanBanHanh, tuNgay, denNgay,
            sortField, sortType, reverse, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits searchDisplay(
        long companyId, long maLoaiVanBan, long maLinhVucVanBan,
        long maCoQuanBanHanh, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchDisplay(companyId, maLoaiVanBan, maLinhVucVanBan,
            maCoQuanBanHanh, sortField, sortType, reverse, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String keywords, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, keywords, sortField, sortType, reverse,
            start, end);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        long companyId, java.lang.String kyHieuVanBan, long maLoaiVanBan,
        long maLinhVucVanBan, long maCoQuanBanHanh, java.lang.String tomTat,
        java.lang.String nguoiKy, java.util.Date ngayBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .addVanBanPhapQuy(companyId, kyHieuVanBan, maLoaiVanBan,
            maLinhVucVanBan, maCoQuanBanHanh, tomTat, nguoiKy, ngayBanHanh);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().addVanBanPhapQuy(companyId, vanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        long companyId, long maVanBanPhapQuy, java.lang.String kyHieuVanBan,
        long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
        java.lang.String tomTat, java.lang.String nguoiKy,
        java.util.Date ngayBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getService()
                   .updateVanBanPhapQuy(companyId, maVanBanPhapQuy,
            kyHieuVanBan, maLoaiVanBan, maLinhVucVanBan, maCoQuanBanHanh,
            tomTat, nguoiKy, ngayBanHanh);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().updateVanBanPhapQuy(companyId, vanBanPhapQuy);
    }

    public static void deleteVanBanPhapQuy(long companyId, long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        getService().deleteVanBanPhapQuy(companyId, maVanBanPhapQuy);
    }

    public static void deleteVanBanPhapQuy(long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().deleteVanBanPhapQuy(companyId, vanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaLinhVucVanBan(
        long maLinhVucVanBan) {
        return getService().getVanbanPhapQuyFromMaLinhVucVanBan(maLinhVucVanBan);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaLoaiVanBan(
        long maLoaiVanBan) {
        return getService().getVanbanPhapQuyFromMaLoaiVanBan(maLoaiVanBan);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaCoQuanBanHanh(
        long maCoQuanBanHanh) {
        return getService().getVanbanPhapQuyFromMaCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static VanBanPhapQuyLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("VanBanPhapQuyLocalService is not set");
        }

        return _service;
    }

    public void setService(VanBanPhapQuyLocalService service) {
        _service = service;
    }
}
