package com.sgs.portlet.loaivanbannoibo.service;


/**
 * <a href="LoaiPhongVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService
 *
 */
public class LoaiPhongVanBanNoiBoLocalServiceUtil {
    private static LoaiPhongVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo addLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBo);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo createLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK) {
        return getService().createLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBoPK);
    }

    public static void deleteLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBoPK);
    }

    public static void deleteLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBo);
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

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo getLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBoPK);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo> getLoaiPhongVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiPhongVanBanNoiBos(start, end);
    }

    public static int getLoaiPhongVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiPhongVanBanNoiBosCount();
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo updateLoaiPhongVanBanNoiBo(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiPhongVanBanNoiBo(loaiPhongVanBanNoiBo);
    }

    public static LoaiPhongVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "LoaiPhongVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiPhongVanBanNoiBoLocalService service) {
        _service = service;
    }
}
