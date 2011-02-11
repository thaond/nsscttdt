package com.sgs.portlet.agency.service;


/**
 * <a href="AgencyLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.agency.service.impl.AgencyLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.agency.service.AgencyLocalServiceUtil
 *
 */
public interface AgencyLocalService {
    public com.sgs.portlet.agency.model.Agency addAgency(
        com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.agency.model.Agency createAgency(
        java.lang.String agencyId);

    public void deleteAgency(java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteAgency(com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.agency.model.Agency getAgency(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.agency.model.Agency> getAgencies(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getAgenciesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.agency.model.Agency updateAgency(
        com.sgs.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.agency.model.Agency> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.agency.model.Agency> search(
        java.lang.String leaderLastNames, java.lang.String leaderFirstNames,
        java.lang.String agencyCode, java.lang.String agencyName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String leaderLastNames,
        java.lang.String leaderFirstNames, java.lang.String agencyCode,
        java.lang.String agencyName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public void removeAgency(java.lang.String agencyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.agency.model.Agency addAgency(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.agency.model.Agency updateAgency(
        java.lang.String agencyId, java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
