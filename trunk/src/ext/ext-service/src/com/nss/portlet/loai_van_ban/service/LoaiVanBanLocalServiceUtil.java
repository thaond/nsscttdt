package com.nss.portlet.loai_van_ban.service;


/**
 * <a href="LoaiVanBanLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService
 *
 */
public class LoaiVanBanLocalServiceUtil {
    private static LoaiVanBanLocalService _service;

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan addLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiVanBan(loaiVanBan);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan createLoaiVanBan(
        long maLoaiVanBan) {
        return getService().createLoaiVanBan(maLoaiVanBan);
    }

    public static void deleteLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiVanBan(maLoaiVanBan);
    }

    public static void deleteLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiVanBan(loaiVanBan);
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

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan getLoaiVanBan(
        long maLoaiVanBan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiVanBan(maLoaiVanBan);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> getLoaiVanBans(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBans(start, end);
    }

    public static int getLoaiVanBansCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBansCount();
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan updateLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiVanBan(loaiVanBan);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan updateLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiVanBan(loaiVanBan, merge);
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

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static LoaiVanBanLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LoaiVanBanLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiVanBanLocalService service) {
        _service = service;
    }
}
