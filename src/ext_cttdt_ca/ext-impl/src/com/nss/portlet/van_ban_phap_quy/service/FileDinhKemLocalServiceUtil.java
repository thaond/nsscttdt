package com.nss.portlet.van_ban_phap_quy.service;


/**
 * <a href="FileDinhKemLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService
 *
 */
public class FileDinhKemLocalServiceUtil {
    private static FileDinhKemLocalService _service;

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem addFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException {
        return getService().addFileDinhKem(fileDinhKem);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem createFileDinhKem(
        long maFileDinhKem) {
        return getService().createFileDinhKem(maFileDinhKem);
    }

    public static void deleteFileDinhKem(long maFileDinhKem)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFileDinhKem(maFileDinhKem);
    }

    public static void deleteFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException {
        getService().deleteFileDinhKem(fileDinhKem);
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

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem getFileDinhKem(
        long maFileDinhKem)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFileDinhKem(maFileDinhKem);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> getFileDinhKems(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getFileDinhKems(start, end);
    }

    public static int getFileDinhKemsCount()
        throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemsCount();
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKem(fileDinhKem);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKem(fileDinhKem, merge);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem getVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuyId) {
        return getService().getVanBanPhapQuy_PhienBan(maVanBanPhapQuyId);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> getListFileDinhKemByMaVanBanPhapQuy(
        long maVanBanPhapQuyId) {
        return getService()
                   .getListFileDinhKemByMaVanBanPhapQuy(maVanBanPhapQuyId);
    }

    public static int countFileDinhKem(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getService().countFileDinhKem(maVanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findFileDinhKem(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().findFileDinhKem(maVanBanPhapQuy, start, end);
    }

    public static FileDinhKemLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("FileDinhKemLocalService is not set");
        }

        return _service;
    }

    public void setService(FileDinhKemLocalService service) {
        _service = service;
    }
}
