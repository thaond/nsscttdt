package com.sgs.portlet.organizationexternal.service;


/**
 * <a href="OrganizationExternalLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService
 *
 */
public class OrganizationExternalLocalServiceUtil {
    private static OrganizationExternalLocalService _service;

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal addOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException {
        return getService().addOrganizationExternal(organizationExternal);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal createOrganizationExternal(
        long orgExternalId) {
        return getService().createOrganizationExternal(orgExternalId);
    }

    public static void deleteOrganizationExternal(long orgExternalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteOrganizationExternal(orgExternalId);
    }

    public static void deleteOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException {
        getService().deleteOrganizationExternal(organizationExternal);
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

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal getOrganizationExternal(
        long orgExternalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getOrganizationExternal(orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> getOrganizationExternals(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getOrganizationExternals(start, end);
    }

    public static int getOrganizationExternalsCount()
        throws com.liferay.portal.SystemException {
        return getService().getOrganizationExternalsCount();
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal updateOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException {
        return getService().updateOrganizationExternal(organizationExternal);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByTEN_MA_DONVILIENTHONG(java.lang.String code,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByTEN_MA_DONVILIENTHONG(code, name, andOperator);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findTEN_MA_DONVILIENTHONG(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findTEN_MA_DONVILIENTHONG(code, name, andOperator, start,
            end, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal addOrganizationExternal(
        java.lang.String orgExternalCode, java.lang.String orgExternalName,
        boolean isOwnerOrg)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addOrganizationExternal(orgExternalCode, orgExternalName,
            isOwnerOrg);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal updateOrganizationExternal(
        long orgExternalId, java.lang.String orgExternalCode,
        java.lang.String orgExternalName, boolean isOwnerOrg)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateOrganizationExternal(orgExternalId, orgExternalCode,
            orgExternalName, isOwnerOrg);
    }

    public static OrganizationExternalLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "OrganizationExternalLocalService is not set");
        }

        return _service;
    }

    public void setService(OrganizationExternalLocalService service) {
        _service = service;
    }
}
