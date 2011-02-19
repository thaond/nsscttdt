package com.sgs.portlet.sovanbannoibo.service;


/**
 * <a href="LoaiVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService
 *
 */
public class LoaiVanBanNoiBoLocalServiceUtil {
    private static LoaiVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo addLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addLoaiVanBanNoiBo(loaiVanBanNoiBo);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo createLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId) {
        return getService().createLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static void deleteLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static void deleteLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteLoaiVanBanNoiBo(loaiVanBanNoiBo);
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

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo getLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> getLoaiVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBos(start, end);
    }

    public static int getLoaiVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getLoaiVanBanNoiBosCount();
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo updateLoaiVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateLoaiVanBanNoiBo(loaiVanBanNoiBo);
    }

    public static int countByKeyword(java.lang.String keyword)
        throws com.liferay.portal.SystemException {
        return getService().countByKeyword(keyword);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> findByKeyword(
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

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> findLoaiVanBanNoiBo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findLoaiVanBanNoiBo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, start, end, andOperator, obc);
    }

    public static LoaiVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LoaiVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(LoaiVanBanNoiBoLocalService service) {
        _service = service;
    }
}
