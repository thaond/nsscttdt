package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlAgencyLeaderLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlAgencyLeaderLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil
 *
 */
public interface PmlAgencyLeaderLocalService {
    public com.sgs.portlet.onedoor.model.PmlAgencyLeader addPmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader createPmlAgencyLeader(
        java.lang.String agencyId);

    public void deletePmlAgencyLeader(java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader getPmlAgencyLeader(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> getPmlAgencyLeaders(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlAgencyLeadersCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader updatePmlAgencyLeader(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException;
}
