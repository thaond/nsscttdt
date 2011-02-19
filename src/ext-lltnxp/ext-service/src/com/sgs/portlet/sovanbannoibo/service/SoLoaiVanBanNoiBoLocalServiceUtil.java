package com.sgs.portlet.sovanbannoibo.service;


/**
 * <a href="SoLoaiVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService
 *
 */
public class SoLoaiVanBanNoiBoLocalServiceUtil {
    private static SoLoaiVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo addSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addSoLoaiVanBanNoiBo(soLoaiVanBanNoiBo);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo createSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK) {
        return getService().createSoLoaiVanBanNoiBo(soLoaiVanBanNoiBoPK);
    }

    public static void deleteSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSoLoaiVanBanNoiBo(soLoaiVanBanNoiBoPK);
    }

    public static void deleteSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteSoLoaiVanBanNoiBo(soLoaiVanBanNoiBo);
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

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo getSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSoLoaiVanBanNoiBo(soLoaiVanBanNoiBoPK);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> getSoLoaiVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSoLoaiVanBanNoiBos(start, end);
    }

    public static int getSoLoaiVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getSoLoaiVanBanNoiBosCount();
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo updateSoLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateSoLoaiVanBanNoiBo(soLoaiVanBanNoiBo);
    }

    public static SoLoaiVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "SoLoaiVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(SoLoaiVanBanNoiBoLocalService service) {
        _service = service;
    }
}
