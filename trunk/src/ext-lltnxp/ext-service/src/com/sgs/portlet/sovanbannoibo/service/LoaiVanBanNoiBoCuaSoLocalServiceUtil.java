package com.sgs.portlet.sovanbannoibo.service;


/**
 * <a href="LoaiVanBanNoiBoCuaSoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService
 *
 */
public class LoaiVanBanNoiBoCuaSoLocalServiceUtil {
    private static LoaiVanBanNoiBoCuaSoLocalService _service;

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo addLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoCuaSo);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo createLoaiVanBanNoiBoCuaSo(
        long loaiVanBanNoiBoId) {
        return getService().createLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoId);
    }

    public static void deleteLoaiVanBanNoiBoCuaSo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoId);
    }

    public static void deleteLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoCuaSo);
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

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo getLoaiVanBanNoiBoCuaSo(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> getLoaiVanBanNoiBoCuaSos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBoCuaSos(start, end);
    }

    public static int getLoaiVanBanNoiBoCuaSosCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBoCuaSosCount();
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo updateLoaiVanBanNoiBoCuaSo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiVanBanNoiBoCuaSo(loaiVanBanNoiBoCuaSo);
    }

    public static int countByKeyword(java.lang.String keyword)
        throws com.liferay.portal.SystemException {
        return getService().countByKeyword(keyword);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findByKeyword(
        java.lang.String keyword, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeyword(keyword, start, end, obc);
    }

    public static int countLoaiVanBanNoiBo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countLoaiVanBanNoiBo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, andOperator);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findLoaiVanBanNoiBo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findLoaiVanBanNoiBo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, start, end, andOperator, obc);
    }

    public static LoaiVanBanNoiBoCuaSoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "LoaiVanBanNoiBoCuaSoLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiVanBanNoiBoCuaSoLocalService service) {
        _service = service;
    }
}
