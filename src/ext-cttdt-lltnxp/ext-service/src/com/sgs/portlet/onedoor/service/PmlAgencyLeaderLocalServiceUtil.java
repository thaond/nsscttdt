package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlAgencyLeaderLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalService
 *
 */
public class PmlAgencyLeaderLocalServiceUtil {
    private static PmlAgencyLeaderLocalService _service;

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader addPmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        return getService().addPmlAgencyLeader(pmlAgencyLeader);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader createPmlAgencyLeader(
        java.lang.String agencyId) {
        return getService().createPmlAgencyLeader(agencyId);
    }

    public static void deletePmlAgencyLeader(java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlAgencyLeader(agencyId);
    }

    public static void deletePmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        getService().deletePmlAgencyLeader(pmlAgencyLeader);
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

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader getPmlAgencyLeader(
        java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlAgencyLeader(agencyId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> getPmlAgencyLeaders(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlAgencyLeaders(start, end);
    }

    public static int getPmlAgencyLeadersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlAgencyLeadersCount();
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader updatePmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlAgencyLeader(pmlAgencyLeader);
    }

    public static PmlAgencyLeaderLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlAgencyLeaderLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlAgencyLeaderLocalService service) {
        _service = service;
    }
}
