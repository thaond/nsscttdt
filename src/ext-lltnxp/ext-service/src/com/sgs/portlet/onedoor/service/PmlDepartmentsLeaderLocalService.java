package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlDepartmentsLeaderLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlDepartmentsLeaderLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalServiceUtil
 *
 */
public interface PmlDepartmentsLeaderLocalService {
    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader addPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader createPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK);

    public void deletePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader getPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> getPmlDepartmentsLeaders(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDepartmentsLeadersCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public boolean checkUserIsLeader(java.lang.String userIdString);
}
