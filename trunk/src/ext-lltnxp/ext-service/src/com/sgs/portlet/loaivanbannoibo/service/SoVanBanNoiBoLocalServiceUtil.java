package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="SoVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoLocalService
 *
 */
public class SoVanBanNoiBoLocalServiceUtil {
    private static SoVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo addSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addSoVanBanNoiBo(soVanBanNoiBo);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo createSoVanBanNoiBo(
        long soVanBanNoiBoId) {
        return getService().createSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void deleteSoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void deleteSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteSoVanBanNoiBo(soVanBanNoiBo);
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

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo getSoVanBanNoiBo(
        long soVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> getSoVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBos(start, end);
    }

    public static int getSoVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBosCount();
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo updateSoVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateSoVanBanNoiBo(soVanBanNoiBo);
    }

    public static SoVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("SoVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(SoVanBanNoiBoLocalService service) {
        _service = service;
    }
}
