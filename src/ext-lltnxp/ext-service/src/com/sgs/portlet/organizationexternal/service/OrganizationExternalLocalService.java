package com.sgs.portlet.organizationexternal.service;


/**
 * <a href="OrganizationExternalLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.organizationexternal.service.impl.OrganizationExternalLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil
 *
 */
public interface OrganizationExternalLocalService {
    public com.sgs.portlet.organizationexternal.model.OrganizationExternal addOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal createOrganizationExternal(
        long orgExternalId);

    public void deleteOrganizationExternal(long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal getOrganizationExternal(
        long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> getOrganizationExternals(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getOrganizationExternalsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal updateOrganizationExternal(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_DONVILIENTHONG(java.lang.String code,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findTEN_MA_DONVILIENTHONG(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal addOrganizationExternal(
        java.lang.String orgExternalCode, java.lang.String orgExternalName,
        boolean isOwnerOrg)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal updateOrganizationExternal(
        long orgExternalId, java.lang.String orgExternalCode,
        java.lang.String orgExternalName, boolean isOwnerOrg)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
