package com.sgs.portlet.agency.service;


/**
 * <a href="AgencyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.agency.service.AgencyLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.agency.service.AgencyLocalService
 *
 */
public class AgencyLocalServiceUtil {
    private static AgencyLocalService _service;

    public static com.sgs.portlet.agency.model.Agency addAgency(
        com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException {
        return getService().addAgency(agency);
    }

    public static com.sgs.portlet.agency.model.Agency createAgency(
        java.lang.String agencyId) {
        return getService().createAgency(agencyId);
    }

    public static void deleteAgency(java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteAgency(agencyId);
    }

    public static void deleteAgency(com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException {
        getService().deleteAgency(agency);
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

    public static com.sgs.portlet.agency.model.Agency getAgency(
        java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAgency(agencyId);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> getAgencies(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getAgencies(start, end);
    }

    public static int getAgenciesCount()
        throws com.liferay.portal.SystemException {
        return getService().getAgenciesCount();
    }

    public static com.sgs.portlet.agency.model.Agency updateAgency(
        com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException {
        return getService().updateAgency(agency);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> search(
        java.lang.String leaderLastNames, java.lang.String leaderFirstNames,
        java.lang.String agencyCode, java.lang.String agencyName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(leaderLastNames, leaderFirstNames, agencyCode,
            agencyName, andOperator, start, end, obc);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String leaderLastNames,
        java.lang.String leaderFirstNames, java.lang.String agencyCode,
        java.lang.String agencyName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(leaderLastNames, leaderFirstNames, agencyCode,
            agencyName, andOperator);
    }

    public static void removeAgency(java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeAgency(agencyId);
    }

    public static com.sgs.portlet.agency.model.Agency addAgency(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addAgency(agencyCode, agencyName, description, active);
    }

    public static com.sgs.portlet.agency.model.Agency updateAgency(
        java.lang.String agencyId, java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateAgency(agencyId, agencyCode, agencyName, description,
            active);
    }

    public static AgencyLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("AgencyLocalService is not set");
        }

        return _service;
    }

    public void setService(AgencyLocalService service) {
        _service = service;
    }
}
