package com.sgs.portlet.sovanbannoibo.service;


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
 * <code>com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService
 *
 */
public class SoVanBanNoiBoLocalServiceUtil {
    private static SoVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo addSoVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addSoVanBanNoiBo(soVanBanNoiBo);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo createSoVanBanNoiBo(
        long soVanBanNoiBoId) {
        return getService().createSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void deleteSoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void deleteSoVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
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

    public static com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo getSoVanBanNoiBo(
        long soVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> getSoVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBos(start, end);
    }

    public static int getSoVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getSoVanBanNoiBosCount();
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo updateSoVanBanNoiBo(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateSoVanBanNoiBo(soVanBanNoiBo);
    }

    public static int countByKeyword(java.lang.String keyword)
        throws com.liferay.portal.SystemException {
        return getService().countByKeyword(keyword);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findByKeyword(
        java.lang.String keyword, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeyword(keyword, start, end, obc);
    }

    public static int countSoVanBanNoiBo(java.lang.String maSoVanBanNoiBos,
        java.lang.String tenSoVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countSoVanBanNoiBo(maSoVanBanNoiBos, tenSoVanBanNoiBos,
            andOperator);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findSoVanBanNoiBo(
        java.lang.String maSoVanBanNoiBos, java.lang.String tenSoVanBanNoiBos,
        int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findSoVanBanNoiBo(maSoVanBanNoiBos, tenSoVanBanNoiBos,
            start, end, andOperator, obc);
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
