package com.nss.portlet.linh_vuc_van_ban.service;


/**
 * <a href="LinhVucVanBanLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService
 *
 */
public class LinhVucVanBanLocalServiceUtil {
    private static LinhVucVanBanLocalService _service;

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan addLinhVucVanBan(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException {
        return getService().addLinhVucVanBan(linhVucVanBan);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan createLinhVucVanBan(
        long maLinhVucVanBan) {
        return getService().createLinhVucVanBan(maLinhVucVanBan);
    }

    public static void deleteLinhVucVanBan(long maLinhVucVanBan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLinhVucVanBan(maLinhVucVanBan);
    }

    public static void deleteLinhVucVanBan(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException {
        getService().deleteLinhVucVanBan(linhVucVanBan);
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

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan getLinhVucVanBan(
        long maLinhVucVanBan)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLinhVucVanBan(maLinhVucVanBan);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> getLinhVucVanBans(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLinhVucVanBans(start, end);
    }

    public static int getLinhVucVanBansCount()
        throws com.liferay.portal.SystemException {
        return getService().getLinhVucVanBansCount();
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan updateLinhVucVanBan(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException {
        return getService().updateLinhVucVanBan(linhVucVanBan);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan updateLinhVucVanBan(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateLinhVucVanBan(linhVucVanBan, merge);
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

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> getListLinhVucVanBanByParenId(
        long parentId) {
        return getService().getListLinhVucVanBanByParenId(parentId);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active) {
        return getService().findByActive(active);
    }

    public static LinhVucVanBanLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LinhVucVanBanLocalService is not set");
        }

        return _service;
    }

    public void setService(LinhVucVanBanLocalService service) {
        _service = service;
    }
}
