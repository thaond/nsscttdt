package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="SoPhongVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService
 *
 */
public class SoPhongVanBanNoiBoLocalServiceUtil {
    private static SoPhongVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo addSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addSoPhongVanBanNoiBo(soPhongVanBanNoiBo);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo createSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK) {
        return getService().createSoPhongVanBanNoiBo(soPhongVanBanNoiBoPK);
    }

    public static void deleteSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSoPhongVanBanNoiBo(soPhongVanBanNoiBoPK);
    }

    public static void deleteSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteSoPhongVanBanNoiBo(soPhongVanBanNoiBo);
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

    public static com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo getSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSoPhongVanBanNoiBo(soPhongVanBanNoiBoPK);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo> getSoPhongVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSoPhongVanBanNoiBos(start, end);
    }

    public static int getSoPhongVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getSoPhongVanBanNoiBosCount();
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo updateSoPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateSoPhongVanBanNoiBo(soPhongVanBanNoiBo);
    }

    public static SoPhongVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "SoPhongVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(SoPhongVanBanNoiBoLocalService service) {
        _service = service;
    }
}
