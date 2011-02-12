package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="FileDinhKemVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService
 *
 */
public class FileDinhKemVanBanNoiBoLocalServiceUtil {
    private static FileDinhKemVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo addFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBo);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo createFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId) {
        return getService()
                   .createFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBoId);
    }

    public static void deleteFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBoId);
    }

    public static void deleteFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBo);
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

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo getFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemVanBanNoiBos(start, end);
    }

    public static int getFileDinhKemVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemVanBanNoiBosCount();
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo updateFileDinhKemVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateFileDinhKemVanBanNoiBo(fileDinhKemVanBanNoiBo);
    }

    public static FileDinhKemVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "FileDinhKemVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(FileDinhKemVanBanNoiBoLocalService service) {
        _service = service;
    }
}
