package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBStatsUserLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBStatsUserLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBStatsUserLocalService {
    public com.liferay.portlet.messageboards.model.MBStatsUser addMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser createMBStatsUser(
        long statsUserId);

    public void deleteMBStatsUser(long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBStatsUser getMBStatsUser(
        long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> getMBStatsUsers(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBStatsUsersCount() throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser updateMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser updateMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser addStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException;

    public void deleteStatsUserByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void deleteStatsUserByUserId(long userId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBStatsUser getStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> getStatsUsers(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStatsUsersCount(long groupId)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser updateStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser updateStatsUser(
        long groupId, long userId, java.util.Date lastPostDate)
        throws com.liferay.portal.SystemException;
}
