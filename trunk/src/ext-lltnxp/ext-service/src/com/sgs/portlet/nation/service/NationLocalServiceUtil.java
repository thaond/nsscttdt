package com.sgs.portlet.nation.service;


/**
 * <a href="NationLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.nation.service.NationLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.service.NationLocalService
 *
 */
public class NationLocalServiceUtil {
    private static NationLocalService _service;

    public static com.sgs.portlet.nation.model.Nation addNation(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException {
        return getService().addNation(nation);
    }

    public static com.sgs.portlet.nation.model.Nation createNation(
        java.lang.String nationId) {
        return getService().createNation(nationId);
    }

    public static void deleteNation(java.lang.String nationId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteNation(nationId);
    }

    public static void deleteNation(com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException {
        getService().deleteNation(nation);
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

    public static com.sgs.portlet.nation.model.Nation getNation(
        java.lang.String nationId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getNation(nationId);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> getNations(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getNations(start, end);
    }

    public static int getNationsCount()
        throws com.liferay.portal.SystemException {
        return getService().getNationsCount();
    }

    public static com.sgs.portlet.nation.model.Nation updateNation(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException {
        return getService().updateNation(nation);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_QUOCGIA(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator,
            start, end, obc);
    }

    public static NationLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("NationLocalService is not set");
        }

        return _service;
    }

    public void setService(NationLocalService service) {
        _service = service;
    }
}
