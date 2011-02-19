package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="VanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService
 *
 */
public class VanBanNoiBoLocalServiceUtil {
    private static VanBanNoiBoLocalService _service;

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo addVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addVanBanNoiBo(vanBanNoiBo);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo createVanBanNoiBo(
        long vanBanNoiBoId) {
        return getService().createVanBanNoiBo(vanBanNoiBoId);
    }

    public static void deleteVanBanNoiBo(long vanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteVanBanNoiBo(vanBanNoiBoId);
    }

    public static void deleteVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteVanBanNoiBo(vanBanNoiBo);
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

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo getVanBanNoiBo(
        long vanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getVanBanNoiBo(vanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> getVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getVanBanNoiBos(start, end);
    }

    public static int getVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getVanBanNoiBosCount();
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateVanBanNoiBo(vanBanNoiBo);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> getVanBanNoiBoByYear(
        int year) throws com.liferay.portal.SystemException {
        return getService().getVanBanNoiBoByYear(year);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long idVanBanNoiBo) throws com.liferay.portal.SystemException {
        return getService().getFileDinhKemVanBanNoiBos(idVanBanNoiBo);
    }

    public static void reIndex(long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(companyId, vanBanNoiBo);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo addVanBanNoiBo(
        long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().addVanBanNoiBo(companyId, vanBanNoiBo);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateVanBanNoiBo(
        long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().updateVanBanNoiBo(companyId, vanBanNoiBo);
    }

    public static void deleteVanBanNoiBo(long companyId,
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().deleteVanBanNoiBo(companyId, vanBanNoiBo);
    }

    public static void deleteVanBanNoiBo(long companyId, long vanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteVanBanNoiBo(companyId, vanBanNoiBoId);
    }

    public static void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(ids);
    }

    public static VanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("VanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(VanBanNoiBoLocalService service) {
        _service = service;
    }
}
