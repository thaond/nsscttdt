package com.nss.portlet.thu_tuc_hanh_chinh.service;


/**
 * <a href="FileDinhKemTTHCLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalService
 *
 */
public class FileDinhKemTTHCLocalServiceUtil {
    private static FileDinhKemTTHCLocalService _service;

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC addFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException {
        return getService().addFileDinhKemTTHC(fileDinhKemTTHC);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC createFileDinhKemTTHC(
        long maFileDinhKemTTHC) {
        return getService().createFileDinhKemTTHC(maFileDinhKemTTHC);
    }

    public static void deleteFileDinhKemTTHC(long maFileDinhKemTTHC)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFileDinhKemTTHC(maFileDinhKemTTHC);
    }

    public static void deleteFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException {
        getService().deleteFileDinhKemTTHC(fileDinhKemTTHC);
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

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC getFileDinhKemTTHC(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFileDinhKemTTHC(maFileDinhKemTTHC);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> getFileDinhKemTTHCs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemTTHCs(start, end);
    }

    public static int getFileDinhKemTTHCsCount()
        throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemTTHCsCount();
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKemTTHC(fileDinhKemTTHC);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKemTTHC(fileDinhKemTTHC, merge);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh) {
        return getService().findByMaThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static int searchCount(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(maThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> search(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().search(maThuTucHanhChinh, start, end);
    }

    public static FileDinhKemTTHCLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("FileDinhKemTTHCLocalService is not set");
        }

        return _service;
    }

    public void setService(FileDinhKemTTHCLocalService service) {
        _service = service;
    }
}
